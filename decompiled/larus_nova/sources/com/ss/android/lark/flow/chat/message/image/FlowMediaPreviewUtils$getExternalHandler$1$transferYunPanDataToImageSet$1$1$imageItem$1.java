package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.ext.UrlPreviewEntityExt;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1 implements kza.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f422555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocImageProperty f422556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map.Entry<String, PreviewHangPoint> f422557c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f422558a = null;

        static {
            int[] r100 = new int[GalleryImageType.values().length];
            r100[GalleryImageType.Thumbnail.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[GalleryImageType.Middle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[GalleryImageType.Origin.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f422558a = r100;
        }
    }

    @Override // kza.e
    public final void c() {
    }

    public FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1(Context r100, DocImageProperty r101, Map.Entry<String, PreviewHangPoint> r102) {
        this.f422555a = r100;
        this.f422556b = r101;
        this.f422557c = r102;
    }

    @Override // kza.e
    public final Object a(Context r110, GalleryImageType r111, Continuation r112) {
        if ((r112 instanceof FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$downloadImage$1) == false) goto L7;
        FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$downloadImage$1 r113 = (FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$downloadImage$1) r112;
        int r100 = r113.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L7;
        r113.label = r100 - Integer.MIN_VALUE;
    L8:
        Object r114 = r113.result;
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r113.label;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L56:
        File r115 = (File) r114;
        if (r115 != null) goto L59;
    L63:
        Log.e("FlowMediaPreviewUtils", "yunpan downloadImage, file is null or not exists");
        return null;
    L59:
        if (r115.exists() == false) goto L63;
        return r115.getAbsolutePath();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        UrlCardPreviewEntity r116 = this.f422557c.getValue().getUrlCardPreviewEntity();
        String r103 = "";
        if (r116 == null) goto L24;
        UrlInlinePreviewEntity r117 = r116.getInlineEntity();
        if (r117 == null) goto L24;
        UrlPreviewEntityExt r118 = r117.getExt();
        if (r118 == null) goto L24;
        UrlPreviewEntityExt.DocInfo r119 = r118.getDocInfo();
        if (r119 == null) goto L24;
        String r120 = r119.getFileName();
        if (r120 == null) goto L24;
    L25:
        FlowYunPanFileUtils r104 = FlowYunPanFileUtils.f422568a;
        String r105 = this.f422556b.getToken();
        if (r105 != null) goto L28;
        r105 = "";
    L28:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "fileToken");
        Intrinsics.checkNotNullParameter(r120, "fileName");
        boolean r106 = false;
        if (r120.length() != 0) goto L31;
        boolean r121 = true;
    L32:
        if (r121 == false) goto L34;
        StringBuilder r122 = new StringBuilder();
        r122.append(Math.abs(r105.hashCode()));
        r122.append(System.currentTimeMillis());
        String r123 = r122.toString();
    L35:
        VFSPath r124 = LarkFileStorage.b().b(com.ss.android.lark.storage.f.f440958e, new com.ss.android.lark.storage.d(new String[]{"im", "flow_download_media_cache"}));
        if (com.suite.lark.component.storage.ext.b.b(r124) == false) goto L38;
    L40:
        VFSFile r125 = VFSFiles.f444819b.v(r124.getAbsolutePath(), r123);
        Log.i("FlowYunPanFileUtils", "getDownloadVideoWorkSpace, version:" + Build.VERSION.SDK_INT + ",workSpace:" + r125.getAbsolutePath());
        String r126 = r125.getAbsolutePath();
        if (r126 != null) goto L44;
    L42:
        r126 = "";
    L44:
        if (r126.length() != 0) goto L46;
        r106 = true;
    L46:
        if (r106 == false) goto L49;
        Log.e("FlowMediaPreviewUtils", "yunpan downloadImage, savePath is null or empty");
        return null;
    L49:
        String r127 = this.f422556b.getToken();
        if (r127 == null) goto L53;
        r103 = r127;
    L53:
        r113.label = 1;
        r114 = r104.f(r103, r126, r113);
        if (r114 != r101) goto L56;
        return r101;
    L38:
        if (com.suite.lark.component.storage.ext.b.d(r124) == true) goto L40;
        Log.e("FlowYunPanFileUtils", "getDownloadImageWorkSpace, mkdirs error");
        goto L42
    L34:
        r123 = System.currentTimeMillis() + '_' + r120;
        goto L35
    L31:
        r121 = false;
    L24:
        r120 = "";
    L7:
        r113 = new FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$downloadImage$1(this, r112);
        goto L8
    }

    @Override // kza.e
    public final Object b(GalleryImageType r100, boolean r101, Continuation<? super String> r110) {
        if ((r110 instanceof FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1) == false) goto L7;
        FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1 r102 = (FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1 r104 = r102;
        Object r111 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r111);
    L29:
        File r112 = (File) r111;
    L47:
        if (r112 != null) goto L51;
        return null;
    L51:
        return Uri.fromFile(r112).toString();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r111);
    L38:
        r112 = (File) r111;
        goto L47
    L17:
        ResultKt.throwOnFailure(r111);
    L46:
        r112 = (File) r111;
        goto L47
    L18:
        ResultKt.throwOnFailure(r111);
        int r107 = a.f422558a[r100.ordinal()];
        String r113 = "";
        if (r107 == 1) goto L39;
        if (r107 == 2) goto L32;
        if (r107 != 3) goto L31;
        FlowYunPanFileUtils r108 = FlowYunPanFileUtils.f422568a;
        Context r109 = this.f422555a;
        String r114 = this.f422556b.getToken();
        if (r114 == null) goto L26;
        r113 = r114;
    L26:
        r104.label = 3;
        r111 = r108.e(r109, r113, r101, r104);
        if (r111 != r105) goto L29;
        return r105;
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        FlowYunPanFileUtils r115 = FlowYunPanFileUtils.f422568a;
        Context r116 = this.f422555a;
        String r117 = this.f422556b.getToken();
        if (r117 != null) goto L35;
        r117 = "";
    L35:
        FlowYunPanCoverType r118 = FlowYunPanCoverType.Middle;
        r104.label = 2;
        r111 = r115.d(r116, r117, r118, r101, r104);
        if (r111 != r105) goto L38;
        return r105;
    L39:
        FlowYunPanFileUtils r119 = FlowYunPanFileUtils.f422568a;
        Context r120 = this.f422555a;
        String r121 = this.f422556b.getToken();
        if (r121 != null) goto L42;
        String r122 = "";
    L43:
        FlowYunPanCoverType r123 = FlowYunPanCoverType.Thumbnail;
        r104.label = 1;
        r111 = r119.d(r120, r122, r123, r101, r104);
        if (r111 != r105) goto L46;
        return r105;
    L42:
        r122 = r121;
    L7:
        r102 = new FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1(this, r110);
        goto L8
    }
}
