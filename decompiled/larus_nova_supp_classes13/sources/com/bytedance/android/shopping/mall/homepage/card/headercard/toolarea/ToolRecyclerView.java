package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/ToolRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolRecyclerView extends RecyclerView {
    public final boolean a;
    public float b;
    public float c;

    public ToolRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ToolRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        ViewParent r0 = getParent();
        if (this.a == false) goto L23;
        if (r7 == null) goto L23;
        if (r0 == null) goto L23;
        r0.requestDisallowInterceptTouchEvent(true);
        int r2 = r7.getAction();
        if (r2 != 0) goto L10;
        this.b = r7.getX();
        this.c = r7.getY();
        r0.requestDisallowInterceptTouchEvent(true);
        goto L23
    L10:
        if (r2 != 1) goto L12;
    L20:
        r0.requestDisallowInterceptTouchEvent(false);
        goto L23
    L12:
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L20;
    L17:
        if (Math.abs(r7.getX() - this.b) <= Math.abs(r7.getY() - this.c)) goto L19;
        r0.requestDisallowInterceptTouchEvent(true);
        goto L23
    L19:
        r0.requestDisallowInterceptTouchEvent(false);
    L23:
        return super.onInterceptTouchEvent(r7);
    }

    public ToolRecyclerView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        int r6 = s93.c.a;
        boolean r7 = true;
        Object r8 = 1;
        IHybridHostService r9 = com.bytedance.android.ec.hybrid.a.h();
        if (r9 == null) goto L10;
        yj.g r10 = r9.getHostAB();
        if (r10 == null) goto L10;
        Object r11 = r10.a("ec_mall_header_card_tool_slide_opt", r8);
        if (r11 == null) goto L10;
        r8 = r11;
    L10:
        Lazy r12 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_header_card_tool_slide_opt, Value: " + r8);
        if (((Number) r8).intValue() == 1) goto L14;
        r7 = false;
    L14:
        this.a = r7;
    }

    public /* synthetic */ ToolRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
