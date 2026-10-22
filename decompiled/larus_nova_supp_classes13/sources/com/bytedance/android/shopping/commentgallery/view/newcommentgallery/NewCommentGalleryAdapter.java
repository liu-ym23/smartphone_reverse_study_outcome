package com.bytedance.android.shopping.commentgallery.view.newcommentgallery;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import cc3.m;
import cc3.n;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.v0;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.shopping.commentgallery.view.CommentGalleryVideoVHNew;
import com.bytedance.android.shopping.commentgallery.view.CommentPhotoVH;
import com.bytedance.android.shopping.gallery2.ECVideoViewContainerVH;
import com.bytedance.android.shopping.gallery2.VideoVH;
import com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/newcommentgallery/NewCommentGalleryAdapter;", "Lcom/bytedance/android/shopping/gallery2/newgallery/NewGalleryAdapter;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewCommentGalleryAdapter extends NewGalleryAdapter {
    public final SparseArray<TransitionViewHolder> e;
    public int f;
    public n g;
    public int h;

    public static final class a {
    }

    public static final class b implements n {
        public final /* synthetic */ NewCommentGalleryAdapter a;

        @Override // cc3.n
        public final void a() {
            n r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        @Override // cc3.n
        public final void b() {
            n r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        public b(NewCommentGalleryAdapter r1) {
            this.a = r1;
        }
    }

    public static final class c implements ControllerListener<ImageInfo> {
        public final /* synthetic */ TransitionViewHolder a;

        public final void onFailure(String r1, Throwable r2) {
        }

        public final void onIntermediateImageFailed(String r1, Throwable r2) {
        }

        public final void onRelease(String r1) {
        }

        public final void onSubmit(String r1, Object r2) {
        }

        public c(TransitionViewHolder r1) {
            this.a = r1;
        }

        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r2) {
            ImageInfo r3 = (ImageInfo) r2;
        }

        public final void onFinalImageSet(String r8, Object r9, Animatable r10) {
            ImageInfo r11 = (ImageInfo) r9;
            if (r11 == null) goto L86;
            CommentPhotoVH r12 = (CommentPhotoVH) this.a;
            int r13 = r11.getWidth();
            int r14 = r11.getHeight();
            r12.getClass();
            int r0 = v0.a;
            Context r1 = ((RecyclerView.ViewHolder) r12).itemView.getContext();
            Intrinsics.checkNotNullParameter(r1, "context");
            if (k1.m(r1) <= k1.j(r1)) goto L68;
            Intrinsics.checkNotNullParameter(r1, "context");
            String r2 = Build.MANUFACTURER;
            boolean r3 = true;
            if (StringsKt.equals("HUAWEI", r2, true) == true) goto L9;
        L11:
            dm.a.a("HwFoldableDeviceUtils").i("isHwFoldable = false");
            boolean r4 = false;
        L12:
            if (r4 == false) goto L14;
        L65:
            boolean r5 = true;
        L66:
            if (r5 == false) goto L68;
        L69:
            if (r3 == false) goto L87;
            ViewGroup.LayoutParams r6 = r12.a.getLayoutParams();
            if ((r6 instanceof FrameLayout.LayoutParams) == true) goto L73;
            r6 = null;
        L73:
            FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
            int r15 = k1.j(((RecyclerView.ViewHolder) r12).itemView.getContext());
            int r16 = k1.m(((RecyclerView.ViewHolder) r12).itemView.getContext());
            if (r14 == 0) goto L88;
            if (r13 == 0) goto L89;
            int r17 = (r13 * r15) / r14;
            if (r17 > r16) goto L81;
            if (r7 == null) goto L84;
            r7.gravity = 17;
            r7.width = r17;
            r7.height = r15;
            r7.bottomMargin = 0;
        L84:
            r12.a.setLayoutParams(r7);
            return;
        L81:
            int r18 = (r14 * r16) / r13;
            if (r7 == null) goto L84;
            r7.gravity = 17;
            r7.width = r16;
            r7.height = r18;
            r7.bottomMargin = 0;
            goto L84
        L89:
            return;
        L88:
            return;
        L87:
            return;
        L14:
            if (StringsKt.equals("HUAWEI", r2, true) == false) goto L24;
            String r19 = Build.DEVICE;
            if (StringsKt.equals("HWTAH ", r19, true) == false) goto L18;
        L23:
            dm.a.a("HwFoldableDeviceUtils").i("isMateX = true");
            boolean r20 = true;
        L25:
            if (r20 == true) goto L65;
            if (StringsKt.equals("HUAWEI", r2, true) == false) goto L45;
            String r21 = Build.MODEL;
            if (StringsKt.equals("TAH-AN00", r21, true) == false) goto L31;
        L44:
            dm.a.a("HwFoldableDeviceUtils").i("isMateXS = true");
            boolean r22 = true;
        L46:
            if (r22 == true) goto L65;
            if (StringsKt.equals("OPPO", r2, true) == false) goto L54;
            String r23 = Build.DEVICE;
            if (StringsKt.equals("OP4E75L1", r23, true) == false) goto L52;
        L53:
            boolean r24 = true;
        L55:
            if (r24 == true) goto L65;
            if (StringsKt.equals("Xiaomi", r2, true) == true) goto L59;
        L61:
            boolean r25 = false;
        L62:
            if (r25 == true) goto L65;
            r5 = false;
            goto L66
        L59:
            if (StringsKt.equals("M2011J18C", Build.MODEL, true) == false) goto L61;
            r25 = true;
            goto L62
        L52:
            if (StringsKt.equals("OP55F1L1", r23, true) == true) goto L53;
        L54:
            r24 = false;
            goto L55
        L31:
            if (StringsKt.equals("TAH-N29", r21, true) == true) goto L44;
            if (StringsKt.equals("TAH-AN00m", r21, true) == true) goto L44;
            if (StringsKt.equals("TAH-N29m", r21, true) == true) goto L44;
            if (StringsKt.equals("RLI-AN00", r21, true) == true) goto L44;
            if (StringsKt.equals("RLI-N29", r21, true) == true) goto L44;
            if (StringsKt.equals("RHA-AN00m", r21, true) == true) goto L44;
            if (StringsKt.equals("RHA-N29m", r21, true) == true) goto L44;
        L45:
            dm.a.a("HwFoldableDeviceUtils").i("isMateXS = false");
            r22 = false;
            goto L46
        L18:
            if (StringsKt.equals("HWTAH-C", r19, true) == true) goto L23;
            if (StringsKt.equals("unknownRLI", r19, true) == true) goto L23;
            if (StringsKt.equals("unknownRHA", r19, true) == true) goto L23;
        L24:
            dm.a.a("HwFoldableDeviceUtils").i("isMateX = false");
            r20 = false;
            goto L25
        L9:
            if (r1.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L11;
            dm.a.a("HwFoldableDeviceUtils").i("isHwFoldable = true");
            r4 = true;
        L68:
            r3 = false;
            goto L69
        }
    }

    static {
    }

    public NewCommentGalleryAdapter() {
        this.e = new SparseArray();
        this.f = -1;
        this.h = -1;
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter
    public final void onDestroy() {
        super.onDestroy();
        dm.a.a("NewCommentGalleryAdapter").i("onDestroy");
        int r0 = this.e.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        TransitionViewHolder r2 = this.e.valueAt(r1);
        if ((r2 instanceof m) == true) goto L7;
        r2 = null;
    L7:
        m r3 = (m) r2;
        if (r3 == null) goto L10;
        r3.J();
    L10:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter
    public final void B2(TransitionViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.B2(r2);
        if ((r2 instanceof m) == false) goto L6;
        ((m) r2).z3();
        return;
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter
    public final void C2(TransitionViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.C2(r2);
        if ((r2 instanceof m) == false) goto L6;
        ((m) r2).u0();
        return;
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter
    public final int getItemViewType(int r4) {
        List<? extends l> r0 = this.b;
        if (r0 == null) goto L7;
        l r5 = (l) ListProtector.get(r0, r4);
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
    L29:
        if (r6 != null) goto L32;
        return 1;
    L32:
        if (r6.intValue() != 8) goto L38;
        return 8;
    L38:
        return 1;
    L27:
        if (r6.intValue() != 7) goto L29;
        return 7;
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

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter
    public final TransitionViewHolder A2(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == 7) goto L11;
        if (r5 == 8) goto L9;
        return new CommentPhotoVH(r4, LayoutInflater.from(r4.getContext()).inflate(2131560533, r4, false));
    L9:
        return new CommentGalleryVideoVHNew(th.a.c(r4.getContext(), 2131560536, r4, false));
    L11:
        return new CommentPhotoVH(r4, LayoutInflater.from(r4.getContext()).inflate(2131560533, r4, false));
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        z2((TransitionViewHolder) r1, r2);
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return A2(r1, r2);
    }

    @Override // com.bytedance.android.shopping.gallery2.newgallery.NewGalleryAdapter
    public final void z2(TransitionViewHolder r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        List<? extends l> r0 = this.b;
        if (r0 == null) goto L55;
        l r1 = (l) ListProtector.get(r0, r10);
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r9 instanceof CommentPhotoVH) == false) goto L31;
        ee3.b r2 = (k) r1;
        String r3 = ((k) r2).b;
        if (r3 != null) goto L12;
    L20:
        ImageRequest r4 = null;
    L21:
        AbstractDraweeController r5 = Fresco.newDraweeControllerBuilder().setImageRequest(r4).setCallerContext(new r("ec_comment", "previewCell")).setControllerListener(new c(r9)).build();
        CommentPhotoVH r6 = (CommentPhotoVH) r9;
        r6.a.setHierarchy(new GenericDraweeHierarchyBuilder(r6.a.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        r6.c = ((k) r2).b;
        r6.a.setController(r5);
        if (((k) r2).i == null) goto L25;
        r6.a.getHierarchy().setImage(((k) r2).i, 1.0f, true);
        r6.a.requestLayout();
    L25:
        if ((r1 instanceof cc3.b) == true) goto L27;
        r1 = null;
    L27:
        ee3.b r7 = (cc3.b) r1;
        if (r7 == null) goto L45;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "model");
        r6.i = r7;
    L45:
        this.e.put(r10, r9);
        if (this.f == r10) goto L48;
        return;
    L48:
        if ((r9 instanceof cc3.l) == true) goto L50;
        r9 = null;
    L50:
        cc3.l r11 = (cc3.l) r9;
        if (r11 == null) goto L53;
        r11.onPageSelected(r10);
    L53:
        this.f = -1;
        return;
    L12:
        if (r3.length() <= 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L20;
        r4 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3)).setRotationOptions(RotationOptions.autoRotateAtRenderTime()).setResizeOptions(dc3.a.a).build();
        goto L21
    L14:
        r8 = false;
        goto L15
    L31:
        if ((r9 instanceof VideoVH) == false) goto L34;
        ((VideoVH) r9).T3((k) r1);
        goto L45
    L34:
        if ((r9 instanceof ECVideoViewContainerVH) == false) goto L37;
        ((ECVideoViewContainerVH) r9).W((ee3.b) r1);
        goto L45
    L37:
        if ((r9 instanceof m) == false) goto L45;
        if ((r1 instanceof cc3.b) == true) goto L41;
        r1 = null;
    L41:
        cc3.b r12 = (cc3.b) r1;
        if (r12 == null) goto L44;
        ((m) r9).B2(r12);
    L44:
        ((m) r9).V2(new b(this));
        goto L45
    }
}
