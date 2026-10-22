package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import he3.p0;
import he3.w1;
import he3.x1;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedSearchBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedSearchBarView extends ConstraintLayout {
    public final ConstraintLayout a;
    public final ProductTextView b;

    public DeepFeedSearchBarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedSearchBarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(InFeedProductV2 r4, com.bytedance.android.shopping.deepfeed.action.i r5) {
        Intrinsics.checkNotNullParameter(r4, "inFeedProductInfo");
        Intrinsics.checkNotNullParameter(r5, "parentAbility");
        if (com.bytedance.android.shopping.deepfeed.utlis.g.d(r4) == false) goto L5;
    L31:
        this.a.setVisibility(8);
        setVisibility(8);
        return;
    L5:
        if (tc3.f.f() == false) goto L31;
        if (com.bytedance.android.shopping.deepfeed.utlis.g.c(r4) == true) goto L31;
        setBackgroundResource(2131247983);
        InFeedProductPackData r6 = r4.getPackData();
        if (r6 == null) goto L24;
        InFeedProductPackDataElements r7 = r6.getElements();
        if (r7 == null) goto L24;
        List<p0> r8 = r7.getProducts();
        if (r8 == null) goto L24;
        p0 r9 = (p0) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L24;
        w1 r10 = r9.o();
        if (r10 == null) goto L24;
        List<x1> r11 = r10.a();
        if (r11 == null) goto L24;
        x1 r12 = (x1) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L24;
        String r13 = r12.a();
    L26:
        if (com.bytedance.android.shopping.extensions.k.c(r13) == false) goto L28;
        this.b.setText("相关搜索·" + r13);
        this.a.setVisibility(0);
        setVisibility(0);
    L29:
        setOnClickListener(new u(r5));
        return;
    L28:
        this.a.setVisibility(8);
        setVisibility(8);
    L24:
        r13 = null;
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    public DeepFeedSearchBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ViewGroup.inflate(r2, 2131564634, this);
        this.a = findViewById(2131385355);
        ?? r5 = (ProductTextView) findViewById(2131385358);
        this.b = r5;
        r5.setTextColor(ColorProtector.parseColor("#B2FFFFFF"));
    }

    public /* synthetic */ DeepFeedSearchBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
