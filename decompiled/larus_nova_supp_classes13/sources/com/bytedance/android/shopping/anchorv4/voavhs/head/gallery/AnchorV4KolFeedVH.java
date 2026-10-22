package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4KolFeedVH;", "Lcom/bytedance/android/shopping/gallery2/PhotoVH;", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolFeedVH extends PhotoVH {
    public final ViewGroup d;
    public i e;
    public final boolean f;

    public AnchorV4KolFeedVH(final View r2, i r3, boolean r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.d = (ViewGroup) r2.findViewById(2131376858);
        r2.addOnAttachStateChangeListener(new AnonymousClass1(this, r2));
    }
}
