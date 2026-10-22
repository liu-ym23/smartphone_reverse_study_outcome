package com.bytedance.android.shopping.gallery2;

import android.content.Context;
import com.bytedance.android.ec.core.gallery2.IndexIndicator;
import com.bytedance.android.ec.core.gallery2.TitleIndicator;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryPlayerBlockCompatAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/GalleryViewer;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoViewerDialog;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GalleryViewer extends PhotoViewerDialog implements TransitionListener {
    public final IndexIndicator a;
    public final TitleIndicator b;
    public final GalleryAdapter c;

    public void onTransitionBegin(int r1) {
    }

    public void onTransitionChanged(int r1, float r2) {
    }

    public void onTransitionEnd(int r1) {
    }

    public GalleryViewer(Context r5, GalleryAdapter r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "galleyAdapter");
        super(r5, r6);
        this.c = r6;
        r6.addTransitionListener(this);
        IndexIndicator r7 = new IndexIndicator(r5, null, 6, 0);
        this.a = r7;
        TitleIndicator r3 = new TitleIndicator(r5, null, 6, 0);
        this.b = r3;
        addIndicatorView(r7);
        addIndicatorView(r3);
    }

    public void a(List<? extends l> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "medias");
        GalleryAdapter r0 = this.c;
        r0.b = r3;
        if ((r0 instanceof GalleryPlayerBlockCompatAdapter) == true) goto L5;
        r0 = null;
    L5:
        GalleryPlayerBlockCompatAdapter r1 = (GalleryPlayerBlockCompatAdapter) r0;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r4 == false) goto L14;
        if (r2 == false) goto L14;
        this.a.setCount(r3.size() + 1);
        return;
    L14:
        this.a.setCount(r3.size());
        return;
    L8:
        if (r1.B2() != true) goto L10;
        r2 = true;
        goto L11
    }
}
