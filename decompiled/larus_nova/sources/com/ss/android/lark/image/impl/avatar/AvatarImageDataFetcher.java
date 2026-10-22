package com.ss.android.lark.image.impl.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.FileUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.ImageFormat;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.a;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import qkb.b;
import qpc.e;

/* JADX INFO: loaded from: classes36.dex */
public class AvatarImageDataFetcher extends ResourceImageDataFetcher<AvatarImage> {

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.avatar.AvatarImageDataFetcher$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType = null;

        static {
            int[] r100 = new int[ImageUtils.ImageType.values().length];
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType = r100;
            r100[ImageUtils.ImageType.TYPE_WEBP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.ImageType.TYPE_JPG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.ImageType.TYPE_PNG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.ImageType.TYPE_HEIF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.ImageType.TYPE_HEIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "AvatarImageDataFetcher";
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher, rkb.a
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public AvatarImageDataFetcher(AvatarImage r100) {
        super(r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_image_impl_avatar_AvatarImageDataFetcher_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private float getDeviceDensity(Context r100) {
        return INVOKEVIRTUAL_com_ss_android_lark_image_impl_avatar_AvatarImageDataFetcher_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(UIHelper.getResources()).density;
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(AvatarImage r110) throws FileNotFoundException {
        long r100 = r110.getCreateTime();
        if (r100 == 0) goto L5;
        r110.setWaitTime(System.currentTimeMillis() - r100);
    L5:
        String r101 = r110.getKey();
        if (r101.startsWith("lark.avatar/") == false) goto L8;
        r101 = r101.substring(12);
    L8:
        int r102 = b.f533689a;
        boolean r103 = false;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L11;
        Log.d("HeifAvatarExperimentConfig", "debug mode no support heif avatar");
    L29:
        if (r103 == false) goto L36;
        int r104 = r110.getWidth();
        int r105 = b.f533689a;
        if (r104 < r105) goto L36;
        if (r110.getHeight() < r105) goto L36;
        r110.setImageFormat(ImageFormat.HEIC);
    L36:
        if (r110.isOnlyLocal() == false) goto L43;
        String r106 = ImageModule.f426214a.getAvatarDir() + File.separator + AvatarImageNameManager.inst().generateFileName(LarkContext.getApplication(), r110);
        boolean r107 = new PolarisFileWrapper(r106).exists();
        Log.i("AvatarImageDataFetcher", "try to load local file, path is:" + r106 + ", isExist:" + r107);
        if (r107 == false) goto L41;
        Log.i("AvatarImageDataFetcher", "file path " + r106 + " exists, avatarKey is " + r110.getKey() + ", entityId is " + r110.getEntityId());
        return new PolarisFileInputStreamWrapper(r106);
    L41:
        Log.i("AvatarImageDataFetcher", "file path " + r106 + " does not exist, avatarKey is " + r110.getKey() + ", entityId is " + r110.getEntityId());
        return null;
    L43:
        String r108 = a.a();
        Resource r109 = getAvatarImageResource(r110, r108);
        r110.setDecodeStartTime(System.currentTimeMillis());
        if (r109 == null) goto L59;
        r110.setErrorResult(r109.f461380e);
        String r111 = r109.f461377b;
        if (r111 != null) goto L52;
        ErrorResult r112 = r109.f461380e;
        if (r112 != null) goto L50;
    L51:
        r110.setErrorResult(new ErrorResult(701002));
        goto L52
    L50:
        if (r112.getCode() == 0) goto L51;
    L52:
        Log.i("AvatarImageDataFetcher", "load avatar image, key is: " + r101 + ", path is:" + r111 + ", contextId:" + r108);
        if (r111 != null) goto L55;
    L58:
        return null;
    L55:
        if (new PolarisFileWrapper(r111).exists() == false) goto L58;
        setImageFormat(r110, r111);
        r110.setResourceSize(new PolarisFileWrapper(r111).length());
        return new PolarisFileInputStreamWrapper(r111);
    L59:
        Log.e("AvatarImageDataFetcher", "load avatar image failed resource is empty, key is: " + r101);
        r110.setErrorResult(new ErrorResult(GlideException.ERROR_CODE_DECODE_JOB_CANCELLED));
        return null;
    L11:
        Boolean r113 = b.f533690b;
        if (r113 != null) goto L27;
        boolean r114 = FeatureGatingModule.getFeatureGatingService().isEnable("messenger.avatar.download.heic");
        Boolean r115 = (Boolean) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(qkb.a.class, true);
        if (r115 == null) goto L16;
        boolean r116 = r115.booleanValue();
    L18:
        if (Build.VERSION.SDK_INT < 27) goto L20;
        boolean r117 = true;
    L21:
        Log.i("HeifAvatarExperimentConfig", "isEnableSupportHeif:fg:" + r114 + " experiment:" + r116 + " hasO1:" + r117);
        if (r114 == false) goto L26;
        if (r116 == false) goto L26;
        if (r117 == false) goto L26;
        r103 = true;
    L26:
        Boolean r118 = Boolean.valueOf(r103);
        b.f533690b = r118;
        boolean r119 = Intrinsics.areEqual(r118, Boolean.TRUE);
    L28:
        r103 = r119;
        goto L29
    L20:
        r117 = false;
        goto L21
    L16:
        r116 = false;
        goto L18
    L27:
        r119 = Intrinsics.areEqual(r113, Boolean.TRUE);
        goto L28
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(AvatarImage r100) throws FileNotFoundException {
        return getResourceStream2(r100);
    }

    private Resource getAvatarImageResource(AvatarImage r110, String r111) {
        e r100 = (e) ApiUtils.getApi(e.class);
        return r100.getImageService().getAvatarImageResource(r110.getEntityId(), r110.getKey(), UIHelper.px2dp(Math.max(r110.getWidth(), r110.getHeight())), getDeviceDensity(LarkContext.getApplication()), r110.getImageType(), r111);
    }

    private void setImageFormat(AvatarImage r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (FileUtils.r(r101) == false) goto L24;
        int r102 = AnonymousClass1.$SwitchMap$com$ss$android$lark$utils$ImageUtils$ImageType[ImageUtils.c(VFSFiles.f444819b.i(r101)).ordinal()];
        if (r102 != 1) goto L9;
        ImageFormat r103 = ImageFormat.WEBP;
    L21:
        Log.i("AvatarImageDataFetcher", "setImageFormat, path:" + r101 + ", format:" + r103);
        r100.setImageFormat(r103);
        return;
    L9:
        if (r102 != 2) goto L11;
        r103 = ImageFormat.JPEG;
        goto L21
    L11:
        if (r102 != 3) goto L13;
        r103 = ImageFormat.PNG;
        goto L21
    L13:
        if (r102 != 4) goto L15;
    L17:
        r103 = ImageFormat.HEIC;
        goto L21
    L15:
        if (r102 == 5) goto L17;
        r103 = null;
        goto L21
    }
}
