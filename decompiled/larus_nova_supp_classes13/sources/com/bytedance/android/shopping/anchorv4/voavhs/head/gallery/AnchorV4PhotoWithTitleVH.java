package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0;
import com.bytedance.android.shopping.gallery2.PhotoWithBtnVH;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4PhotoWithTitleVH;", "Lcom/bytedance/android/shopping/gallery2/PhotoWithBtnVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/j0;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4PhotoWithTitleVH extends PhotoWithBtnVH implements j0 {
    public static final int k = 0;
    public static final int l = 0;
    public final View h;
    public final TextView i;
    public final Lazy j;

    public static final class a {
    }

    @Override // com.bytedance.android.shopping.gallery2.PhotoWithBtnVH
    public final int T3() {
        return 2;
    }

    static {
        int r0 = com.bytedance.android.shopping.extensions.b.a(20);
        k = r0;
        l = com.bytedance.android.shopping.extensions.b.a(15) + r0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d S3() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d) this.j.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0
    public final void o0() {
        this.h.setAlpha(1.0f);
        if (this.i.getText().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.h.setVisibility(0);
        return;
    L8:
        this.h.setVisibility(8);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void V3(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        this.h.setVisibility(8);
        return;
    L11:
        this.i.setText(r3);
        this.h.setVisibility(0);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public AnchorV4PhotoWithTitleVH(View r3, j r4) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3, r4);
        View r5 = r3.findViewById(2131382243);
        this.h = r5;
        TextView r6 = (TextView) r3.findViewById(2131382242);
        this.i = r6;
        this.j = LazyKt.lazy(new AnchorV4PhotoWithTitleVH$galleryLayerItem$2(this));
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L12;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if ((r7 instanceof FrameLayout.LayoutParams) == true) goto L7;
        r7 = null;
    L7:
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r7;
        if (r8 == null) goto L10;
        r8.gravity = 49;
        r8.bottomMargin = 0;
        r8.height = -2;
    L10:
        r6.setTextColor((int) 3439329279L);
        r6.setTextSize(1, 13.0f);
        r6.setVisibility(4);
        this.a.addBoundsChangeListener(new AnonymousClass2(this));
        return;
    }
}
