package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 implements kza.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f422551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoItem f422552b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f422553a = null;

        static {
            int[] r100 = new int[GalleryImageType.values().length];
            r100[GalleryImageType.Middle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GalleryImageType.Origin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f422553a = r100;
        }
    }

    @Override // kza.e
    public final void c() {
    }

    public FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1(Context r100, PhotoItem r101) {
        this.f422551a = r100;
        this.f422552b = r101;
    }

    @Override // kza.e
    public final Object a(Context r110, GalleryImageType r111, Continuation r112) {
        if ((r112 instanceof FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1) == false) goto L7;
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1 r100 = (FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        File r114 = (File) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L30:
        File r115 = (File) r113;
    L35:
        if (r114 != null) goto L37;
        return null;
    L37:
        if (r114.exists() == true) goto L39;
        return null;
    L39:
        return r114.getAbsolutePath();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r114 = (File) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L34:
        File r116 = (File) r113;
        goto L35
    L17:
        r111 = (GalleryImageType) r100.L$1;
        r110 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L21:
        Context r104 = r110;
        r114 = (File) r113;
        if (r114 != null) goto L35;
        int r117 = a.f422553a[r111.ordinal()];
        if (r117 == 1) goto L31;
        if (r117 != 2) goto L35;
        f r105 = f.f422584a;
        GalleryImageType r106 = GalleryImageType.Middle;
        PhotoItem r107 = this.f422552b;
        r100.L$0 = r114;
        r100.L$1 = null;
        r100.label = 3;
        r113 = f.a(r105, r104, r106, r107, false, r100);
        if (r113 != r102) goto L30;
        return r102;
    L31:
        f r108 = f.f422584a;
        GalleryImageType r109 = GalleryImageType.Origin;
        PhotoItem r118 = this.f422552b;
        r100.L$0 = r114;
        r100.L$1 = null;
        r100.label = 2;
        r113 = f.a(r108, r104, r109, r118, false, r100);
        if (r113 != r102) goto L34;
        return r102;
    L18:
        ResultKt.throwOnFailure(r113);
        f r119 = f.f422584a;
        PhotoItem r120 = this.f422552b;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 1;
        r113 = f.a(r119, r110, r111, r120, false, r100);
        if (r113 != r102) goto L21;
        return r102;
    L7:
        r100 = new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1(this, r112);
        goto L8
    }

    @Override // kza.e
    public final Object b(GalleryImageType r100, boolean r101, Continuation<? super String> r110) {
        if ((r110 instanceof FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1) == false) goto L7;
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1 r102 = (FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1 r104 = r102;
        Object r111 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        File r112 = (File) r111;
        if (r112 != null) goto L20;
    L22:
        return null;
    L20:
        if (r112.exists() == false) goto L22;
        return Uri.fromFile(r112).toString();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        f r107 = f.f422584a;
        Context r113 = this.f422551a;
        PhotoItem r108 = this.f422552b;
        r104.label = 1;
        r111 = f.a(r107, r113, r100, r108, r101, r104);
        if (r111 != r105) goto L17;
        return r105;
    L7:
        r102 = new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1(this, r110);
        goto L8
    }
}
