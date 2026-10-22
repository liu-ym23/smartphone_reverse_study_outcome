package com.bytedance.android.shopping.utils.gallery;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.gallery2.GalleryViewer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/HybridViewerDialog;", "Lcom/bytedance/android/shopping/gallery2/GalleryViewer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridViewerDialog extends GalleryViewer {
    public final ee3.f d;
    public final e e;
    public List<String> f;
    public final HybridGalleryAdapter g;

    /* JADX WARN: Multi-variable type inference failed */
    public HybridViewerDialog(ECGalleryActivity r3) {
        HybridGalleryAdapter r0 = new HybridGalleryAdapter();
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r0, "hybridAdapter");
        super(r3, new HybridGalleryAdapter());
        this.g = r0;
        ee3.f r1 = new ee3.f();
        this.d = r1;
        this.e = new e(r3);
        this.f = CollectionsKt.emptyList();
        r1.d = new l(this);
        r1.e = new m(this);
        getPager().addOnScrollListener(new AnonymousClass3(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPageSelected(int r2) {
        super/*com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog*/.onPageSelected(r2);
        if (this.g.B2() == false) goto L8;
        if (r2 != 0) goto L6;
        this.d.d();
        return;
    L6:
        this.d.c();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTransitionEnd(int r8) {
        if (r8 == 0) goto L5;
        return;
    L5:
        if (this.g.B2() == false) goto L7;
        this.d.a(getRootContainer());
    L7:
        e r9 = this.e;
        FrameLayout r0 = getRootContainer();
        List<String> r1 = this.f;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "root");
        Intrinsics.checkNotNullParameter(r1, "titles");
        RecyclerView.Adapter r5 = null;
        View r2 = th.a.d(r0.getContext(), 2131560518, null, 6);
        r9.a = r2;
        if (r2 == null) goto L10;
        RecyclerView r3 = (RecyclerView) r2.findViewById(2131375243);
    L11:
        r9.b = r3;
        if (r3 == null) goto L14;
        r3.setVisibility(4);
        LinearLayoutManager r4 = new LinearLayoutManager(r0.getContext());
        r4.setOrientation(0);
        Unit r6 = Unit.INSTANCE;
        r3.setLayoutManager(r4);
        r3.setAdapter(new BannerAdapter(r0.getContext(), r1, r9.f));
        r3.addItemDecoration(new BannerListDecoration(r9.g));
    L14:
        View r7 = r9.a;
        if (r7 == null) goto L17;
        View r10 = r7.findViewById(2131375245);
    L18:
        r9.c = r10;
        View r11 = r9.a;
        if (r11 == null) goto L21;
        r11.post(new c(r9));
    L21:
        View r12 = r9.a;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, -2);
        r13.gravity = 1;
        Unit r14 = Unit.INSTANCE;
        r0.addView(r12, r13);
        RecyclerView r15 = r9.b;
        if (r15 == null) goto L24;
        RecyclerView.Adapter r16 = r15.getAdapter();
    L26:
        if ((r16 instanceof BannerAdapter) == false) goto L29;
        r5 = r16;
    L29:
        BannerAdapter r17 = (BannerAdapter) r5;
        if (r17 == null) goto L39;
        List<String> r18 = r17.d;
        if (r18 != null) goto L34;
        return;
    L34:
        if (r18.size() <= 0) goto L41;
        View r19 = r9.a;
        if (r19 == null) goto L42;
        r19.postDelayed(new d(r9), 200);
        return;
    L42:
        return;
    L41:
        return;
    L39:
        return;
    L24:
        r16 = null;
        goto L26
    L17:
        r10 = null;
        goto L18
    L10:
        r3 = null;
        goto L11
    }
}
