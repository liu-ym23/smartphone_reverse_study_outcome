package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001d\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fB%\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/desc/ScrollMentionTextView;", "Lcom/bytedance/awemeopen/apps/framework/feed/desc/MentionTextView;", "Landroid/view/View$OnClickListener;", "l", "", "setOnClickListener", "", "o", "Lkotlin/Lazy;", "getScaledTouchSlop", "()I", "scaledTouchSlop", "", "p", "Z", "getLastLineFadeEnable", "()Z", "setLastLineFadeEnable", "(Z)V", "lastLineFadeEnable", "", "r", "getLastLineFadeColors", "()[I", "lastLineFadeColors", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class ScrollMentionTextView extends MentionTextView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f194648s = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f194649m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f194650n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f194651o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f194652p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f194653q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f194654r;

    private final int[] getLastLineFadeColors() {
        return (int[]) this.f194654r.getValue();
    }

    private final int getScaledTouchSlop() {
        return ((Number) this.f194651o.getValue()).intValue();
    }

    public final boolean getLastLineFadeEnable() {
        return this.f194652p;
    }

    public ScrollMentionTextView(Context r100) {
        new LinkedHashMap();
        super(r100);
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f194651o = LazyKt.lazy(r101, new ScrollMentionTextView$scaledTouchSlop$2(this));
        this.f194654r = LazyKt.lazy(r101, new ScrollMentionTextView$lastLineFadeColors$2(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        if (this.f194652p == true) goto L5;
    L13:
        getPaint().setShader(null);
    L14:
        super.onDraw(r110);
        return;
    L5:
        if (canScrollVertically(getScrollY()) == false) goto L13;
        float r100 = getMeasuredHeight();
        if (this.f194653q != r100) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
        this.f194653q = r100;
    L12:
        this.f194653q += getScrollY();
        float r102 = getLineHeight();
        float r103 = this.f194653q;
        getPaint().setShader(new LinearGradient(0.0f, r103, 0.0f, 0.0f, getLastLineFadeColors(), new float[]{0.0f, r102 / r103, 1.0f}, Shader.TileMode.CLAMP));
        goto L14
    L9:
        r101 = false;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.widget.ClickSpanWorkaroundTextView, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r102 = super.onTouchEvent(r100);
        if (this.f194631g == false) goto L34;
        int r103 = r100.getAction();
        if (r103 == 0) goto L30;
        if (r103 != 1) goto L11;
        ViewParent r104 = getParent();
        if (r104 == null) goto L33;
        r104.requestDisallowInterceptTouchEvent(false);
    L33:
        return true;
    L11:
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L33;
        ViewParent r105 = getParent();
        if (r105 == null) goto L33;
        r105.requestDisallowInterceptTouchEvent(false);
        goto L33
    L19:
        if (this.f194649m == false) goto L21;
    L24:
        ViewParent r106 = getParent();
        if (r106 == null) goto L33;
        r106.requestDisallowInterceptTouchEvent(true);
        goto L33
    L21:
        if (Math.abs(r100.getY() - this.f194650n) < getScaledTouchSlop()) goto L23;
        r101 = true;
    L23:
        this.f194649m = r101;
        goto L24
    L30:
        this.f194650n = r100.getY();
        this.f194649m = false;
        ViewParent r107 = getParent();
        if (r107 == null) goto L33;
        r107.requestDisallowInterceptTouchEvent(true);
        goto L33
    L34:
        this.f194649m = false;
        return r102;
    }

    public final void setLastLineFadeEnable(boolean r100) {
        this.f194652p = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener r100) {
        if (r100 != null) goto L5;
        super.setOnClickListener(r100);
        return;
    L5:
        super.setOnClickListener(new h(this, r100));
    }

    public ScrollMentionTextView(Context r100, AttributeSet r101) {
        new LinkedHashMap();
        super(r100, r101);
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.NONE;
        this.f194651o = LazyKt.lazy(r102, new ScrollMentionTextView$scaledTouchSlop$2(this));
        this.f194654r = LazyKt.lazy(r102, new ScrollMentionTextView$lastLineFadeColors$2(this));
    }

    public ScrollMentionTextView(Context r100, AttributeSet r101, int r102) {
        new LinkedHashMap();
        super(r100, r101, r102);
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f194651o = LazyKt.lazy(r103, new ScrollMentionTextView$scaledTouchSlop$2(this));
        this.f194654r = LazyKt.lazy(r103, new ScrollMentionTextView$lastLineFadeColors$2(this));
    }
}
