package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4CustomViewCompatVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CustomViewCompatVH extends TransitionViewHolder {
    public final View a;
    public final ViewGroup b;
    public final List<View> c;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4CustomViewCompatVH(View r2, List<? extends View> r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "viewProvider");
        super(r2);
        this.c = r3;
        this.a = r2.findViewById(2131368461);
        this.b = (ViewGroup) r2.findViewById(2131368480);
    }
}
