package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001d\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fB%\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/desc/ScrollMentionTextView;", "Lcom/bytedance/awemeopen/apps/framework/feed/desc/MentionTextView;", "Landroid/view/View$OnClickListener;", "l", "", "setOnClickListener", "", "o", "Lkotlin/Lazy;", "getScaledTouchSlop", "()I", "scaledTouchSlop", "", "p", "Z", "getLastLineFadeEnable", "()Z", "setLastLineFadeEnable", "(Z)V", "lastLineFadeEnable", "", "r", "getLastLineFadeColors", "()[I", "lastLineFadeColors", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class ScrollMentionTextView extends MentionTextView {
    public static final /* synthetic */ int s = 0;
    public boolean m;
    public float n;
    public final Lazy o;
    public boolean p;
    public float q;
    public final Lazy r;

    private final int[] getLastLineFadeColors() {
        return (int[]) this.r.getValue();
    }

    private final int getScaledTouchSlop() {
        return ((Number) this.o.getValue()).intValue();
    }

    public final boolean getLastLineFadeEnable() {
        return this.p;
    }

    public ScrollMentionTextView(Context r2) {
        new LinkedHashMap();
        super(r2);
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.o = LazyKt.lazy(r3, new ScrollMentionTextView$scaledTouchSlop$2(this));
        this.r = LazyKt.lazy(r3, new ScrollMentionTextView$lastLineFadeColors$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView
    public final void onDraw(Canvas r13) {
        if (this.p == true) goto L5;
    L13:
        getPaint().setShader(null);
    L14:
        super.onDraw(r13);
        return;
    L5:
        if (canScrollVertically(getScrollY()) == false) goto L13;
        float r0 = getMeasuredHeight();
        if (this.q != r0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        this.q = r0;
    L12:
        this.q += getScrollY();
        float r2 = getLineHeight();
        float r6 = this.q;
        getPaint().setShader(new LinearGradient(0.0f, r6, 0.0f, 0.0f, getLastLineFadeColors(), new float[]{0.0f, r2 / r6, 1.0f}, Shader.TileMode.CLAMP));
        goto L14
    L9:
        r1 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.comment.view.widget.ClickSpanWorkaroundTextView
    public final boolean onTouchEvent(MotionEvent r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
        return false;
    L5:
        boolean r1 = super.onTouchEvent(r5);
        if (this.g == false) goto L34;
        int r2 = r5.getAction();
        if (r2 == 0) goto L30;
        if (r2 != 1) goto L11;
        ViewParent r6 = getParent();
        if (r6 == null) goto L33;
        r6.requestDisallowInterceptTouchEvent(false);
    L33:
        return true;
    L11:
        if (r2 == 2) goto L19;
        if (r2 != 3) goto L33;
        ViewParent r7 = getParent();
        if (r7 == null) goto L33;
        r7.requestDisallowInterceptTouchEvent(false);
        goto L33
    L19:
        if (this.m == false) goto L21;
    L24:
        ViewParent r8 = getParent();
        if (r8 == null) goto L33;
        r8.requestDisallowInterceptTouchEvent(true);
        goto L33
    L21:
        if (Math.abs(r5.getY() - this.n) < getScaledTouchSlop()) goto L23;
        r0 = true;
    L23:
        this.m = r0;
        goto L24
    L30:
        this.n = r5.getY();
        this.m = false;
        ViewParent r9 = getParent();
        if (r9 == null) goto L33;
        r9.requestDisallowInterceptTouchEvent(true);
        goto L33
    L34:
        this.m = false;
        return r1;
    }

    public final void setLastLineFadeEnable(boolean r1) {
        this.p = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(final View.OnClickListener r2) {
        if (r2 != null) goto L5;
        super/*android.widget.TextView*/.setOnClickListener(r2);
        return;
    L5:
        super/*android.widget.TextView*/.setOnClickListener(new h(this, r2));
    }

    public ScrollMentionTextView(Context r2, AttributeSet r3) {
        new LinkedHashMap();
        super(r2, r3);
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.NONE;
        this.o = LazyKt.lazy(r4, new ScrollMentionTextView$scaledTouchSlop$2(this));
        this.r = LazyKt.lazy(r4, new ScrollMentionTextView$lastLineFadeColors$2(this));
    }

    public ScrollMentionTextView(Context r2, AttributeSet r3, int r4) {
        new LinkedHashMap();
        super(r2, r3, r4);
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.o = LazyKt.lazy(r5, new ScrollMentionTextView$scaledTouchSlop$2(this));
        this.r = LazyKt.lazy(r5, new ScrollMentionTextView$lastLineFadeColors$2(this));
    }
}
