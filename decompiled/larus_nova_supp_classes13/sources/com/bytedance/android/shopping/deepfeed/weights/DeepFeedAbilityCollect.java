package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import he3.i1;
import he3.j1;
import he3.p0;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAbilityCollect;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getUnCollectIconRes", "", "getCollectIconRes", "icon", "", "desc", "", "update", "(Ljava/lang/Integer;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedAbilityCollect extends ConstraintLayout {
    public final ImageView a;
    public final ProductTextView b;
    public final LottieAnimationView c;
    public long d;
    public final List<Integer> e;
    public final List<Integer> f;

    public DeepFeedAbilityCollect(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedAbilityCollect(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final List<Integer> getCollectIconRes() {
        Integer r0 = tc3.f.c();
        if (r0 == null) goto L9;
        if (r0.intValue() != 1) goto L9;
        return this.f;
    L9:
        return this.e;
    }

    private final int getUnCollectIconRes() {
        Integer r0 = tc3.f.c();
        if (r0 != null) goto L6;
    L8:
        return 2131248104;
    L6:
        if (r0.intValue() != 1) goto L8;
        return 2131248105;
    }

    public final void T5() {
        if (tc3.f.b() == false) goto L5;
        U5(0, "收藏", false);
        return;
    L5:
        update(Integer.valueOf(getUnCollectIconRes()), "收藏");
    }

    public final void S5(boolean r6) {
        if (r6 == false) goto L5;
        this.d++;
        int r7 = 1;
    L7:
        if (tc3.f.b() == false) goto L9;
        StringBuilder r1 = new StringBuilder();
        ConcurrentHashMap<String, com.bytedance.android.shopping.deepfeed.utlis.j.a> r3 = com.bytedance.android.shopping.deepfeed.utlis.j.a;
        r1.append(com.bytedance.android.shopping.deepfeed.utlis.j.a(this.d));
        r1.append("收藏");
        U5(r7, r1.toString(), false);
        return;
    L9:
        Integer r8 = (Integer) CollectionsKt.getOrNull(getCollectIconRes(), r7);
        StringBuilder r0 = new StringBuilder();
        ConcurrentHashMap<String, com.bytedance.android.shopping.deepfeed.utlis.j.a> r2 = com.bytedance.android.shopping.deepfeed.utlis.j.a;
        r0.append(com.bytedance.android.shopping.deepfeed.utlis.j.a(this.d));
        r0.append("收藏");
        update(r8, r0.toString());
        return;
    L5:
        this.d--;
        r7 = 0;
        goto L7
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(p0 r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "product");
        i1 r0 = r11.e();
        if (r0 == null) goto L5;
        Boolean r1 = r0.b();
    L6:
        boolean r2 = Intrinsics.areEqual(r1, Boolean.TRUE);
        i1 r3 = r11.e();
        if (r3 == null) goto L11;
        Long r4 = r3.a();
        if (r4 == null) goto L11;
        long r5 = r4.longValue();
    L12:
        this.d = r5;
        j1 r13 = r11.f();
        if (r13 == null) goto L17;
        Long r14 = r13.b();
        if (r14 == null) goto L17;
        long r6 = r14.longValue();
    L18:
        long r7 = this.d;
        if (tc3.f.e() == true) goto L28;
        if (r12 == true) goto L28;
        long r8 = 10000;
        if (r7 >= r8) goto L24;
    L26:
        this.b.setTextSize(1, 10.0f);
        goto L28
    L24:
        if (r6 < r8) goto L26;
        this.b.setTextSize(1, 9.0f);
    L28:
        if (tc3.f.a() == false) goto L31;
        ViewGroup.LayoutParams r15 = this.a.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r9 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r15.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 24);
        r15.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 24);
        this.a.setLayoutParams(r15);
    L31:
        String r16 = "收藏";
        if (r12 == false) goto L42;
        long r10 = this.d;
        if (r10 <= 0) goto L38;
        r16 = com.bytedance.android.shopping.deepfeed.utlis.j.a(r10);
    L38:
        if (tc3.f.b() == false) goto L40;
        U5(r2 ? 1 : 0, r16, true);
        return;
    L40:
        update(Integer.valueOf(getUnCollectIconRes()), r16);
        return;
    L42:
        if (tc3.f.b() == false) goto L44;
        StringBuilder r17 = new StringBuilder();
        ConcurrentHashMap<String, com.bytedance.android.shopping.deepfeed.utlis.j.a> r18 = com.bytedance.android.shopping.deepfeed.utlis.j.a;
        r17.append(com.bytedance.android.shopping.deepfeed.utlis.j.a(this.d));
        r17.append("收藏");
        U5(r2 ? 1 : 0, r17.toString(), true);
        return;
    L44:
        Integer r19 = (Integer) CollectionsKt.getOrNull(getCollectIconRes(), r2 ? 1 : 0);
        StringBuilder r20 = new StringBuilder();
        ConcurrentHashMap<String, com.bytedance.android.shopping.deepfeed.utlis.j.a> r21 = com.bytedance.android.shopping.deepfeed.utlis.j.a;
        r20.append(com.bytedance.android.shopping.deepfeed.utlis.j.a(this.d));
        r20.append("收藏");
        update(r19, r20.toString());
        return;
    L17:
        r6 = 0;
    L11:
        r5 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedAbilityCollect(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ViewGroup.inflate(r3, 2131564623, this);
        ImageView r6 = (ImageView) findViewById(2131376297);
        this.a = r6;
        this.b = (ProductTextView) findViewById(2131390479);
        LottieAnimationView r7 = findViewById(2131367130);
        this.c = r7;
        if (tc3.f.b() == false) goto L5;
        r7.setAnimationFromUrl("https://lf3-static.bytednsdoc.com/obj/eden-cn/ljylttvjl_lmp/ljhwZthlaukjlkulzlp/ec_mall_douyin/shopping_deep_feed_collect_lottie.json");
        r7.setRepeatCount(0);
        r7.setProgress(0.0f);
        b0.n(r7);
        r6.setVisibility(4);
        d2.d(r6, 0, com.bytedance.android.shopping.extensions.b.b(12), 0, 0);
    L5:
        this.e = CollectionsKt.listOf(new Integer[]{2131248104, 2131248102});
        this.f = CollectionsKt.listOf(new Integer[]{2131248105, 2131248100});
    }

    public final void U5(int r3, String r4, boolean r5) {
        if (r3 != 1) goto L7;
        if (r5 == true) goto L6;
        this.a.setVisibility(4);
        b0.n(this.c);
        this.c.removeAllAnimatorListeners();
        this.c.setProgress(0.0f);
        this.c.playAnimation();
    L8:
        if (r4 == null) goto L11;
        this.b.setText(r4);
        return;
    L11:
        return;
    L6:
        this.c.removeAllAnimatorListeners();
        this.c.cancelAnimation();
        this.c.setProgress(1.0f);
        this.c.pauseAnimation();
        goto L8
    L7:
        this.c.removeAllAnimatorListeners();
        this.c.cancelAnimation();
        this.c.setProgress(0.0f);
        this.c.pauseAnimation();
        goto L8
    }

    public /* synthetic */ DeepFeedAbilityCollect(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
