package com.bytedance.android.shopping.gallery2.newgallery;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.shopping.anchorv4.data.h;
import com.bytedance.android.shopping.anchorv4.dto.ImageOCRResponseDTO;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.gallery2.ECVideoViewContainerVH;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.shopping.gallery2.PhotoWithBtnVH;
import com.bytedance.android.shopping.gallery2.VideoVH;
import com.bytedance.android.shopping.utils.f;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/newgallery/NewGalleryAdapter;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NewGalleryAdapter extends TransitionPagerAdapter<TransitionViewHolder> {
    public final int a;
    public List<? extends l> b;
    public final LinkedList<VideoVH> c;
    public final LinkedList<ECVideoViewContainerVH> d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ NewGalleryAdapter a;
        public final /* synthetic */ TransitionViewHolder b;
        public final /* synthetic */ int c;

        public b(NewGalleryAdapter r1, TransitionViewHolder r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            ImageOCRResponseDTO r6 = (ImageOCRResponseDTO) r5;
            TransitionPhotoDraweeView r0 = ((PhotoVH) this.b).a;
            NewGalleryAdapter r1 = this.a;
            int r2 = r1.a;
            if (r2 != 1) goto L5;
            String r7 = j.e(2131913860, Integer.valueOf(r1.y2(this.c)), r6.getOcrTexts());
        L9:
            r0.setContentDescription(r7);
            return;
        L5:
            if (r2 == 2) goto L7;
            r7 = "";
            goto L9
        L7:
            r7 = j.e(2131913857, Integer.valueOf(r1.y2(this.c)), r6.getOcrTexts());
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
            ((PhotoVH) this.a).a.setContentDescription(j.c(2131913861));
        }
    }

    static {
    }

    public final int getItemCount() {
        List<? extends l> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public NewGalleryAdapter() {
        this.a = -1;
        this.c = new LinkedList();
        this.d = new LinkedList();
    }

    public void onDestroy() {
        super.onDestroy();
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((VideoVH) r0.next()).b.l();
        goto L4
    L6:
        Iterator<T> r1 = this.d.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((ECVideoViewContainerVH) r1.next()).J();
        goto L8
    }

    public void B2(TransitionViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        com.bytedance.android.ec.sdk.helper.c.a.a("NewGalleryAdapter", "onPageSelected " + r4.getLayoutPosition());
        if ((r4 instanceof VideoVH) == false) goto L11;
        VideoVH r0 = (VideoVH) r4;
        k r1 = r0.c;
        if (r1 == null) goto L9;
        String r2 = r1.b;
        if (r2 == null) goto L9;
        r0.b.p(r2);
    L9:
        r0.b.k();
    L11:
        if ((r4 instanceof ECVideoViewContainerVH) == false) goto L16;
        ECVideoPlayer r5 = ((ECVideoViewContainerVH) r4).c;
        if (r5 == null) goto L17;
        r5.k();
        return;
    L17:
        return;
    }

    public void C2(TransitionViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        com.bytedance.android.ec.sdk.helper.c.a.a("NewGalleryAdapter", "onPageUnSelected " + r4.getLayoutPosition());
        if ((r4 instanceof VideoVH) == false) goto L6;
        ((VideoVH) r4).b.j();
    L6:
        if ((r4 instanceof ECVideoViewContainerVH) == false) goto L11;
        ECVideoPlayer r5 = ((ECVideoViewContainerVH) r4).c;
        if (r5 == null) goto L12;
        r5.j();
        return;
    L12:
        return;
    }

    public int getItemViewType(int r4) {
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
        if (r6.intValue() != 6) goto L38;
        return 6;
    L38:
        return 1;
    L27:
        if (r6.intValue() != 4) goto L29;
        return 5;
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

    public final void onViewAttachedToWindow(TransitionViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewAttachedToWindow(r4);
        com.bytedance.android.ec.sdk.helper.c.a.a("NewGalleryAdapter", "onViewAttachedToWindow " + r4.getLayoutPosition());
    }

    public final void onViewDetachedFromWindow(TransitionViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewDetachedFromWindow(r4);
        com.bytedance.android.ec.sdk.helper.c.a.a("NewGalleryAdapter", "onViewDetachedFromWindow " + r4.getLayoutPosition());
    }

    public final int y2(int r7) {
        List<? extends l> r0 = this.b;
        if (r0 == null) goto L7;
        l r1 = (l) ListProtector.get(r0, r7);
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.getType());
    L8:
        List<? extends l> r3 = this.b;
        if (r3 == null) goto L25;
        Iterator<T> r4 = r3.iterator();
        int r5 = 0;
    L12:
        if (r4.hasNext() == false) goto L25;
        Object r6 = r4.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        int r9 = ((l) r6).getType();
        if (r2 == null) goto L23;
        if (r9 != r2.intValue()) goto L23;
        return (r7 - r5) + 1;
    L23:
        r5 = r8;
    L25:
        return r7 + 1;
    L7:
        r2 = null;
        goto L8
    }

    public final /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        onViewAttachedToWindow((TransitionViewHolder) r1);
    }

    public final /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        onViewDetachedFromWindow((TransitionViewHolder) r1);
    }

    public TransitionViewHolder A2(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L7;
        VideoVH r6 = new VideoVH(LayoutInflater.from(r4.getContext()).inflate(2131560596, r4, false));
        this.c.add(r6);
        return r6;
    L7:
        if (r5 != 3) goto L9;
        ECVideoViewContainerVH r7 = new ECVideoViewContainerVH(LayoutInflater.from(r4.getContext()).inflate(2131560590, r4, false));
        this.d.add(r7);
        return r7;
    L9:
        return new PhotoVH(LayoutInflater.from(r4.getContext()).inflate(2131560593, r4, false));
    L15:
        return new PhotoVH(LayoutInflater.from(r4.getContext()).inflate(2131560593, r4, false));
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        z2((TransitionViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return A2(r1, r2);
    }

    public void z2(TransitionViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        List<? extends l> r0 = this.b;
        if (r0 == null) goto L49;
        ee3.b r1 = (l) ListProtector.get(r0, r9);
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r8 instanceof PhotoVH) == false) goto L43;
        if (f.b == false) goto L19;
        PipelineDraweeControllerBuilder r2 = Fresco.newDraweeControllerBuilder();
        String r3 = null;
        if ((r1 instanceof k) == true) goto L14;
        ee3.b r4 = null;
    L15:
        ee3.b r5 = r4;
        if (r5 == null) goto L18;
        r3 = ((k) r5).c;
    L18:
        AbstractDraweeController r6 = r2.setLowResImageRequest(ImageRequest.fromUri(r3)).setUri(((k) r1).b).setOldController(((PhotoVH) r8).a.getController()).build();
    L20:
        PhotoVH r7 = (PhotoVH) r8;
        ee3.b r10 = r1;
        r7.c = ((k) r10).b;
        if ((r8 instanceof PhotoWithBtnVH) == false) goto L23;
        ((PhotoWithBtnVH) r8).U3(((k) r10).k);
    L23:
        r7.a.setController(r6);
        if (((k) r10).i == null) goto L27;
        r7.a.getHierarchy().setImage(((k) r10).i, 1.0f, true);
        r7.a.requestLayout();
    L27:
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L50;
        r7.a.setImportantForAccessibility(1);
        TransitionPhotoDraweeView r11 = r7.a;
        int r12 = this.a;
        if (r12 != 1) goto L31;
        String r13 = j.d(2131913862, Integer.valueOf(y2(r9)));
    L35:
        r11.setContentDescription(r13);
        if (r1.getType() != 1) goto L41;
        int r14 = h.a;
        ArrayList r15 = new ArrayList();
        String r16 = ((k) r10).b;
        if (r16 == null) goto L40;
        r15.add(r16);
    L40:
        Unit r17 = Unit.INSTANCE;
        h.a(r15).subscribe(new b(this, r8, r9), new c(r8));
        return;
    L41:
        r7.a.setContentDescription(((k) r10).l);
        return;
    L31:
        if (r12 == 2) goto L33;
        r13 = "";
        goto L35
    L33:
        r13 = j.d(2131913858, Integer.valueOf(y2(r9)));
        goto L35
    L50:
        return;
    L14:
        r4 = r1;
        goto L15
    L19:
        r6 = Fresco.newDraweeControllerBuilder().setUri(((k) r1).b).build();
        goto L20
    L43:
        if ((r8 instanceof VideoVH) == false) goto L46;
        ((VideoVH) r8).T3(r1);
        return;
    L46:
        if ((r8 instanceof ECVideoViewContainerVH) == false) goto L54;
        ((ECVideoViewContainerVH) r8).W(r1);
        return;
    L54:
        return;
    }
}
