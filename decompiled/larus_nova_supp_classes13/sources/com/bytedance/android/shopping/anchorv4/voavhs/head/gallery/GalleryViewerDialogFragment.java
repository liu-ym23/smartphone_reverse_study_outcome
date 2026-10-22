package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.gallery2.IndexIndicator;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryPlayerBlockCompatAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/GalleryViewerDialogFragment;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/PhotoViewDialogFragment;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GalleryViewerDialogFragment extends PhotoViewDialogFragment implements TransitionListener {
    public static final /* synthetic */ int q = 0;
    public IndexIndicator n;
    public boolean o;
    public final GalleryAdapter p;

    public final void onTransitionBegin(int r1) {
    }

    public final void onTransitionChanged(int r1, float r2) {
    }

    public void onTransitionEnd(int r1) {
    }

    public GalleryViewerDialogFragment() {
        this(new GalleryAdapter());
    }

    public final IndexIndicator aa0() {
        IndexIndicator r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indexIndicator");
    L5:
        return r0;
    }

    public GalleryViewerDialogFragment(GalleryAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryAdapter");
        super(r2);
        this.p = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public void X90(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.X90(r5);
        this.p.addTransitionListener(this);
        GalleryAdapter r1 = null;
        boolean r3 = false;
        View r0 = new IndexIndicator(r5, null, 6, 0);
        this.n = r0;
        Intrinsics.checkNotNullParameter(r0, "indicatorView");
        this.j.add(r0);
        FrameLayout r6 = this.e;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L5:
        r6.addView(r0);
        r0.onAttach(this.h, this.m);
        GalleryAdapter r7 = this.p;
        List<? extends l> r2 = r7.b;
        if (r2 != null) goto L9;
        return;
    L9:
        if ((r7 instanceof GalleryPlayerBlockCompatAdapter) == false) goto L12;
        r1 = r7;
    L12:
        GalleryPlayerBlockCompatAdapter r4 = (GalleryPlayerBlockCompatAdapter) r1;
        if (r4 == null) goto L18;
        if (r4.B2() != true) goto L18;
        r3 = true;
    L18:
        if (this.o == false) goto L24;
        if (r3 == false) goto L24;
        IndexIndicator r8 = this.n;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("indexIndicator");
    L23:
        r8.setCount(r2.size() + 1);
        return;
    L24:
        IndexIndicator r9 = this.n;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("indexIndicator");
    L27:
        r9.setCount(r2.size());
    }
}
