package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kza.l;
import kza.m;
import kza.o;
import kza.p;
import kza.q;
import kza.r;
import kza.t;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f422584a = null;

    static {
        f422584a = new f();
    }

    public f() {
    }

    public static final Pair b(PhotoItem r100) {
        Pair r101 = null;
        String r102 = null;
        if (r100 == null) goto L47;
        PhotoItem.PicInfo r103 = r100.getMiddlePicInfo();
        if (r103 == null) goto L8;
        String r104 = r103.key;
    L9:
        PhotoItem.PicInfo r105 = r100.getMiddlePicInfo();
        boolean r106 = false;
        if (r105 == null) goto L12;
        int r107 = r105.width;
    L13:
        PhotoItem.PicInfo r108 = r100.getMiddlePicInfo();
        if (r108 == null) goto L16;
        int r109 = r108.height;
    L18:
        if (r104 != null) goto L20;
    L23:
        boolean r110 = true;
    L24:
        if (r110 == false) goto L37;
        PhotoItem.PicInfo r111 = r100.getOriginPicInfo();
        if (r111 == null) goto L28;
        r102 = r111.key;
    L28:
        PhotoItem.PicInfo r112 = r100.getOriginPicInfo();
        if (r112 == null) goto L31;
        r107 = r112.width;
    L32:
        PhotoItem.PicInfo r113 = r100.getOriginPicInfo();
        if (r113 == null) goto L35;
        r109 = r113.height;
    L36:
        r104 = r102;
        goto L37
    L35:
        r109 = 0;
        goto L36
    L31:
        r107 = 0;
    L37:
        if (r104 != null) goto L39;
    L40:
        r106 = true;
    L41:
        if (r106 == false) goto L44;
        r104 = r100.getImageKey();
        r107 = r100.getWidth();
        r109 = r100.getHeight();
    L44:
        if (r104 != null) goto L46;
        r104 = "";
    L46:
        r101 = new Pair(r104, new Pair(Integer.valueOf(r107), Integer.valueOf(r109)));
        goto L47
    L39:
        if (r104.length() != 0) goto L41;
    L20:
        if (r104.length() == 0) goto L23;
        r110 = false;
        goto L24
    L16:
        r109 = 0;
        goto L18
    L12:
        r107 = 0;
        goto L13
    L8:
        r104 = null;
    L47:
        return r101;
    }

    public static File d(com.ss.android.lark.image.entity.b r100) {
        Intrinsics.checkNotNullParameter(r100, "imageKey");
        ArrayList<com.ss.android.lark.image.entity.b> r101 = new ArrayList(1);
        r101.add(r100);
        IIMApi r102 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r102 == null) goto L5;
        com.ss.android.lark.image.entity.c r103 = r102.findImageCache("look_large_image", r101, null);
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.f426348b;
    L5:
        r103 = null;
        goto L6
    }

    public static o c(PhotoItem r110, GalleryType r111) {
        ValidateIMFileResult r100 = r110.getValidateIMFileResult();
        String r101 = null;
        if (r100 == null) goto L5;
        IMFileResult r102 = r100.getResultType();
    L6:
        int r103 = MessagePermissionUtil.h(r102).getValue();
        boolean r104 = false;
        if (r110.isHasPreviewPermission() == false) goto L11;
        MessagePermissionUtil.ReceiveAuthorizationState.Companion.getClass();
        if (MessagePermissionUtil.g(MessagePermissionUtil.ReceiveAuthorizationState.a.a(r103)) == true) goto L11;
        boolean r105 = true;
    L12:
        MessageIdentity r106 = r110.getMessageIdentity();
        if (r106 == null) goto L15;
        String r107 = r106.getChatId();
    L16:
        MessageIdentity r108 = r110.getMessageIdentity();
        if (r108 == null) goto L20;
        String r109 = r108.getMessageId();
        if (r109 == null) goto L20;
    L21:
        String r112 = r109;
        if (r111 != GalleryType.Video) goto L33;
        MediaExtra r113 = r110.getMediaExtra();
        if (r113 == null) goto L26;
        r101 = r113.getKey();
    L26:
        if (r101 != null) goto L29;
        r101 = "";
    L29:
        if (r101.length() != 0) goto L31;
        r104 = true;
    L31:
        if (r104 == false) goto L35;
        r101 = r110.getImageKey();
    L35:
        return new o(r103, r105, r110.resourceIsCleaned, new t(new r(r111, r112, r107, r101, 112), new q(r101, true, 13)), 56);
    L33:
        r101 = r110.getImageKey();
    L20:
        r109 = r110.getMessageId();
        goto L21
    L15:
        r107 = null;
    L11:
        r105 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static m e(Context r210, PhotoItem r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "photoItem");
        String r100 = null;
        if (r211.isVideo() == false) goto L24;
        String r101 = "video_" + System.currentTimeMillis();
        MediaExtra r102 = r211.getMediaExtra();
        if (r102 == null) goto L7;
        String r103 = r102.getUrl();
    L8:
        c r104 = new c(r210, r211);
        MediaExtra r105 = r211.getMediaExtra();
        if (r105 == null) goto L11;
        long r106 = r105.getDuration();
    L12:
        double r107 = r106 / 1000.0d;
        PhotoItem.PicInfo r108 = r211.getOriginPicInfo();
        if (r108 == null) goto L15;
        Integer r109 = Integer.valueOf(r108.height);
    L16:
        PhotoItem.PicInfo r110 = r211.getOriginPicInfo();
        if (r110 == null) goto L19;
        Integer r111 = Integer.valueOf(r110.width);
    L20:
        d r112 = new d(r210, r211);
        MediaExtra r113 = r211.getMediaExtra();
        if (r113 == null) goto L23;
        r100 = r113.getFilePath();
    L23:
        String r114 = r103;
        p r115 = new p(r101, r114, r104, Double.valueOf(r107), r109, r111, r112, r100, new e(r210, r211), r211, null, 2048);
        GalleryType r116 = GalleryType.Video;
        return new m(r116, null, r115, r211.getMessageId(), null, 0, c(r211, r116), 48);
    L19:
        r111 = null;
        goto L20
    L15:
        r109 = null;
        goto L16
    L11:
        r106 = 0;
        goto L12
    L7:
        r103 = null;
        goto L8
    L24:
        File r117 = r211.getPhotoState().getOriginFile();
        if (r117 != null) goto L27;
        r117 = r211.getPhotoState().getMiddleFile();
    L27:
        if (r117 != null) goto L29;
    L31:
        String r118 = null;
    L32:
        File r119 = r211.getPhotoState().getThumbnailFile();
        if (r119 != null) goto L35;
    L37:
        l r120 = new l(r118, r100, r211, new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1(r210, r211), r211.isOriginSource(), null, 131);
        GalleryType r121 = GalleryType.Image;
        return new m(r121, r120, null, r211.getMessageId(), null, 0, c(r211, r121), 48);
    L35:
        if (r119.exists() == false) goto L37;
        r100 = Uri.fromFile(r119).toString();
        goto L37
    L29:
        if (r117.exists() == false) goto L31;
        r118 = Uri.fromFile(r117).toString();
        goto L32
    }

    public static final Object a(f r100, Context r101, GalleryImageType r102, PhotoItem r103, boolean r104, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof FlowImageLoaderUtils$downloadImageFile$1) == false) goto L7;
        FlowImageLoaderUtils$downloadImageFile$1 r105 = (FlowImageLoaderUtils$downloadImageFile$1) r110;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L16;
        if (r108 == 1) goto L15;
        if (r108 != 2) goto L14;
        ResultKt.throwOnFailure(r107);
    L26:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r104 = r105.Z$0;
        r103 = (PhotoItem) r105.L$2;
        r102 = (GalleryImageType) r105.L$1;
        r101 = (Context) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L19:
        r107 = (File) r107;
        if (r104 == true) goto L26;
        if (r107 != null) goto L26;
        r105.L$0 = null;
        r105.L$1 = null;
        r105.L$2 = null;
        r105.label = 2;
        r107 = BuildersKt.withContext(Dispatchers.getIO(), new FlowImageLoaderUtils$downloadImageFile$3(r102, r101, r103, null), r105);
        if (r107 != r111) goto L26;
        return r111;
    L16:
        ResultKt.throwOnFailure(r107);
        r105.L$0 = r101;
        r105.L$1 = r102;
        r105.L$2 = r103;
        r105.Z$0 = r104;
        r105.label = 1;
        r107 = BuildersKt.withContext(Dispatchers.getIO(), new FlowImageLoaderUtils$getImageCacheFile$2(r101, r102, r103, null), r105);
        if (r107 != r111) goto L19;
        return r111;
    L7:
        r105 = new FlowImageLoaderUtils$downloadImageFile$1(r100, r110);
        goto L8
    }
}
