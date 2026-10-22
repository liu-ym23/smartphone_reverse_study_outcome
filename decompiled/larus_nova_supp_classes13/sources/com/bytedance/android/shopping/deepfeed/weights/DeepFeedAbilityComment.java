package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import he3.i1;
import he3.j1;
import he3.p0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAbilityComment;", "Landroid/widget/LinearLayout;", "", "icon", "", "desc", "", "update", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCommentIconRes", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedAbilityComment extends LinearLayout {
    public final ImageView a;
    public final ProductTextView b;

    public DeepFeedAbilityComment(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedAbilityComment(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getCommentIconRes() {
        Integer r0 = tc3.f.c();
        if (r0 != null) goto L6;
    L8:
        return 2131248103;
    L6:
        if (r0.intValue() != 1) goto L8;
        return 2131247974;
    }

    public final void b() {
        update(2131248103, "评价");
    }

    private final void update(Integer r2, String r3) {
        if (r2 == null) goto L4;
        int r4 = r2.intValue();
        this.a.setImageResource(r4);
    L4:
        if (r3 == null) goto L7;
        this.b.setText(r3);
        return;
    }

    public final void a(p0 r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "product");
        j1 r0 = r10.f();
        if (r0 == null) goto L7;
        Long r1 = r0.b();
        if (r1 == null) goto L7;
        long r3 = r1.longValue();
    L8:
        i1 r12 = r10.e();
        if (r12 == null) goto L13;
        Long r13 = r12.a();
        if (r13 == null) goto L13;
        long r5 = r13.longValue();
    L15:
        if (tc3.f.e() == true) goto L24;
        if (r11 == true) goto L24;
        long r7 = 10000;
        if (r3 >= r7) goto L20;
    L22:
        this.b.setTextSize(1, 10.0f);
        goto L24
    L20:
        if (r5 < r7) goto L22;
        this.b.setTextSize(1, 9.0f);
    L24:
        if (tc3.f.a() == false) goto L27;
        ViewGroup.LayoutParams r14 = this.a.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r2 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r14.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 24);
        r14.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 24);
        this.a.setLayoutParams(r14);
    L27:
        String r15 = "评价";
        if (r11 == true) goto L30;
        update(Integer.valueOf(getCommentIconRes()), com.bytedance.android.shopping.deepfeed.utlis.j.a(r3) + "评价");
        return;
    L30:
        if (r3 <= 0) goto L33;
        r15 = com.bytedance.android.shopping.deepfeed.utlis.j.a(r3);
    L33:
        update(Integer.valueOf(getCommentIconRes()), r15);
        return;
    L13:
        r5 = 0;
    L7:
        r3 = 0;
        goto L8
    }

    public DeepFeedAbilityComment(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(1);
        setGravity(1);
        LinearLayout.inflate(r2, 2131564624, this);
        this.a = (ImageView) findViewById(2131376297);
        this.b = (ProductTextView) findViewById(2131390479);
    }

    public /* synthetic */ DeepFeedAbilityComment(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
