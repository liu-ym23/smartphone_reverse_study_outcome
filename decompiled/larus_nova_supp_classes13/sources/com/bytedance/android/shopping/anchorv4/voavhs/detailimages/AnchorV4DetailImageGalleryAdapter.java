package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.dto.ImageOCRResponseDTO;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.shopping.gallery2.VideoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageGalleryAdapter;", "Lcom/bytedance/android/shopping/gallery2/GalleryAdapter;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageGalleryAdapter extends GalleryAdapter {
    public n f;
    public l g;
    public final Context h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorV4DetailImageGalleryAdapter a;
        public final /* synthetic */ TransitionViewHolder b;
        public final /* synthetic */ int c;

        public b(AnchorV4DetailImageGalleryAdapter r1, TransitionViewHolder r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            ImageOCRResponseDTO r6 = (ImageOCRResponseDTO) r5;
            TransitionPhotoDraweeView r0 = ((PhotoVH) this.b).a;
            AnchorV4DetailImageGalleryAdapter r1 = this.a;
            int r2 = r1.a;
            if (r2 != 1) goto L5;
            String r7 = com.bytedance.android.shopping.extensions.j.e(2131913860, Integer.valueOf(r1.y2(this.c)), r6.getOcrTexts());
        L9:
            r0.setContentDescription(r7);
            return;
        L5:
            if (r2 == 2) goto L7;
            r7 = "";
            goto L9
        L7:
            r7 = com.bytedance.android.shopping.extensions.j.e(2131913857, Integer.valueOf(r1.y2(this.c)), r6.getOcrTexts());
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TransitionViewHolder a;

        public c(TransitionViewHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ((PhotoVH) this.a).a.setContentDescription(com.bytedance.android.shopping.extensions.j.c(2131913861));
        }
    }

    public static final class d implements n {
        public final /* synthetic */ AnchorV4DetailImageGalleryAdapter a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.n
        public final void a() {
            n r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.n
        public final void b() {
            n r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.n
        public final void c() {
            n r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        public d(AnchorV4DetailImageGalleryAdapter r1) {
            this.a = r1;
        }
    }

    static {
    }

    public AnchorV4DetailImageGalleryAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.h = r2;
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final int getItemViewType(int r4) {
        List<? extends com.bytedance.android.ec.model.l> r0 = this.b;
        if (r0 == null) goto L7;
        com.bytedance.android.ec.model.l r5 = (com.bytedance.android.ec.model.l) ListProtector.get(r0, r4);
        if (r5 == null) goto L7;
        Integer r6 = Integer.valueOf(r5.getType());
    L9:
        if (r6 != null) goto L12;
    L14:
        if (r6 != null) goto L17;
    L19:
        if (r6 != null) goto L22;
    L24:
        if (r6 != null) goto L27;
        return 1;
    L27:
        if (r6.intValue() != 10) goto L32;
        return 7;
    L32:
        return 1;
    L22:
        if (r6.intValue() != 3) goto L24;
        return 3;
    L17:
        if (r6.intValue() != 2) goto L19;
        return 2;
    L12:
        if (r6.intValue() != 1) goto L14;
        return 1;
    L7:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final TransitionViewHolder A2(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 == 7) goto L7;
        return new PhotoVH(LayoutInflater.from(r5.getContext()).inflate(2131560593, r5, false));
    L7:
        return new AnchorV4DetailLargeImageVH(LayoutInflater.from(r5.getContext()).inflate(th.a.f(r5.getContext()).getLayout(2131564713), r5, false));
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        z2((TransitionViewHolder) r1, r2);
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return A2(r1, r2);
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void z2(TransitionViewHolder r20, int r21) {
        Intrinsics.checkNotNullParameter(r20, "holder");
        List<? extends com.bytedance.android.ec.model.l> r3 = this.b;
        if (r3 == null) goto L72;
        com.bytedance.android.ec.model.k r4 = (com.bytedance.android.ec.model.l) ListProtector.get(r3, r21);
        if (r4 == null) goto L79;
        String r6 = "";
        if ((r20 instanceof PhotoVH) == false) goto L43;
        if (com.bytedance.android.shopping.utils.f.b == false) goto L19;
        PipelineDraweeControllerBuilder r5 = Fresco.newDraweeControllerBuilder();
        String r8 = null;
        if ((r4 instanceof com.bytedance.android.ec.model.k) == true) goto L14;
        com.bytedance.android.ec.model.k r7 = null;
    L15:
        com.bytedance.android.ec.model.k r9 = r7;
        if (r9 == null) goto L18;
        r8 = r9.c;
    L18:
        AbstractDraweeController r10 = r5.setLowResImageRequest(ImageRequest.fromUri(r8)).setUri(r4.b).setOldController(((PhotoVH) r20).a.getController()).build();
    L20:
        PhotoVH r11 = (PhotoVH) r20;
        com.bytedance.android.ec.model.k r12 = r4;
        r11.c = r12.b;
        r11.a.setController(r10);
        if (r12.i == null) goto L24;
        r11.a.getHierarchy().setImage(r12.i, 1.0f, true);
        r11.a.requestLayout();
    L24:
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L39;
        r11.a.setImportantForAccessibility(1);
        TransitionPhotoDraweeView r13 = r11.a;
        int r14 = this.a;
        if (r14 != 1) goto L28;
        r6 = com.bytedance.android.shopping.extensions.j.d(2131913862, Integer.valueOf(y2(r21)));
    L32:
        r13.setContentDescription(r6);
        if (r4.getType() != 1) goto L38;
        int r15 = com.bytedance.android.shopping.anchorv4.data.h.a;
        ArrayList r16 = new ArrayList();
        String r17 = r12.b;
        if (r17 == null) goto L37;
        r16.add(r17);
    L37:
        Unit r18 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.data.h.a(r16).subscribe(new b(this, r20, r21), new c(r20));
        goto L39
    L38:
        r11.a.setContentDescription(r12.l);
        goto L39
    L28:
        if (r14 != 2) goto L32;
        r6 = com.bytedance.android.shopping.extensions.j.d(2131913858, Integer.valueOf(y2(r21)));
    L39:
        l r1 = this.g;
        if (r1 == null) goto L73;
        r1.setVisible(true);
        return;
    L73:
        return;
    L14:
        r7 = r4;
        goto L15
    L19:
        r10 = Fresco.newDraweeControllerBuilder().setUri(r4.b).setAutoPlayAnimations(true).build();
        goto L20
    L43:
        if ((r20 instanceof VideoVH) == false) goto L48;
        ((VideoVH) r20).T3(r4);
        l r2 = this.g;
        if (r2 == null) goto L75;
        r2.setVisible(true);
        return;
    L75:
        return;
    L48:
        if ((r20 instanceof AnchorV4DetailLargeImageVH) == false) goto L77;
        AnchorV4DetailLargeImageVH r19 = (AnchorV4DetailLargeImageVH) r20;
        Context r22 = this.h;
        com.bytedance.android.ec.model.k r23 = r4;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "galleryMediaModel");
        File r24 = r22.getExternalCacheDir();
        if (r24 != null) goto L52;
    L54:
        String r25 = r22.getCacheDir().getAbsolutePath();
    L55:
        String r26 = r25 + "/shopping/anchor/largeimage/";
        StringBuilder r27 = new StringBuilder();
        int r28 = com.bytedance.android.shopping.utils.n.a;
        String r29 = r23.b;
        if (r29 == null) goto L64;
        int r110 = StringsKt.lastIndexOf$default(r29, "/", 0, false, 6, null);
        int r30 = StringsKt.lastIndexOf$default(r29, ".", 0, false, 6, null);
        if (r110 == (-1)) goto L64;
        if (r30 == (-1)) goto L64;
        if (r30 <= r110) goto L63;
        r6 = r29.substring(r110 + 1, r30);
        goto L64
    L63:
        r6 = r29.substring(r110 + 1);
    L64:
        r27.append(r6);
        r27.append("_");
        r27.append(System.currentTimeMillis());
        String r31 = r27.toString();
        String r32 = r26 + r31;
        PolarisFileWrapper r33 = new PolarisFileWrapper(r32);
        if (r33.exists() == false) goto L67;
        r19.b.setInputStream(new PolarisFileInputStreamWrapper(r33));
    L68:
        r19.b.setLargeImageMoveListener(new i(r19));
        r19.b.setOnTouchListener(new j(r19));
        d r34 = new d(this);
        Intrinsics.checkNotNullParameter(r34, "largeImageTouchListener");
        r19.a = r34;
        l r35 = this.g;
        if (r35 == null) goto L78;
        r35.setVisible(false);
        return;
    L78:
        return;
    L67:
        String r36 = r23.b;
        Downloader.with(r22).url(r36).name(r31).savePath(r26).mainThreadListener(new h(r19, r32)).download();
        goto L68
    L52:
        if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) == false) goto L54;
        r25 = r24.getAbsolutePath();
        goto L55
    L77:
        return;
    L79:
        return;
    }
}
