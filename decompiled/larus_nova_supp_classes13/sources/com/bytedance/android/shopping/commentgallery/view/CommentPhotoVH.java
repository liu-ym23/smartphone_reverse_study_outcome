package com.bytedance.android.shopping.commentgallery.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cc3.b;
import cc3.h;
import cc3.k;
import cc3.l;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/CommentPhotoVH;", "Lcom/bytedance/android/shopping/gallery2/PhotoVH;", "Lcc3/l;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentPhotoVH extends PhotoVH implements l {
    public final View d;
    public final View e;
    public float f;
    public float g;
    public h h;
    public b i;
    public final View j;

    @Override // cc3.l
    public final void onPageSelected(int r4) {
        b r0 = this.i;
        if (r0 == null) goto L11;
        k r1 = r0.o;
        if (r1 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r1.e, "pic") == false) goto L9;
        r1.h = r4;
    L9:
        t53.b r5 = t53.b.a;
        Context r2 = this.j.getContext();
        r5.getClass();
        t53.b.d(r2, r1);
        return;
    }

    public CommentPhotoVH(View r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super(r5);
        this.j = r4;
        this.d = r5.findViewById(2131370805);
        View r6 = r5.findViewById(2131370804);
        this.e = r6;
        this.f = 1.0f;
        this.g = 1.0f;
        this.a.setDoubleClickScaleEnabled(true);
        this.a.setTranslationEnabled(true);
        this.a.setSingleTagDismissEnabled(true);
        this.a.setScaleEnabled(true);
        this.a.setMaxScaleFactor(2.0f);
        TransitionPhotoDraweeView r0 = this.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L8;
        r2.bottomMargin = (int) UIUtils.dip2Px(r5.getContext(), 66.0f);
        r0.setLayoutParams(r2);
    L8:
        TransitionPhotoDraweeView r7 = this.a;
        h r3 = this.h;
        if (r3 != null) goto L12;
        r3 = new h(this);
        this.h = r3;
    L12:
        r7.addTransitionListener(r3);
        r6.setVisibility(0);
    }
}
