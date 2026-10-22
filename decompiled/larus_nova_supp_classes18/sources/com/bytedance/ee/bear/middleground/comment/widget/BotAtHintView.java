package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0015J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020/H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0015H\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007H\u0002J\u000e\u00106\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u000209J\u0014\u0010:\u001a\u00020\u001c2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002090<J\u0006\u0010=\u001a\u00020\u001cJ\u000e\u0010>\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0007J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020AH\u0014J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u0007H\u0002J\b\u0010D\u001a\u00020\u0015H\u0002J \u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0002J\b\u0010K\u001a\u00020\u001cH\u0002J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010M\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintAdapter;", "defaultMaxHeightPx", "compactMaxHeightPx", "middleMaxHeightPx", "minReservedTopSpacePx", "estimatedItemHeightPx", "availableTopSpacePx", "shouldUseMiddleHeightByTopSpace", "", "onActionClick", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintInfo;", "Lkotlin/ParameterName;", "name", "hintInfo", "", "getOnActionClick", "()Lkotlin/jvm/functions/Function1;", "setOnActionClick", "(Lkotlin/jvm/functions/Function1;)V", "value", "Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "commentAnalytic", "getCommentAnalytic", "()Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "setCommentAnalytic", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;)V", "setRecyclerNestedScrollingEnabled", "enabled", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleContainerTouch", "event", "canRecyclerScrollVertically", "updateParentInterceptDisallowState", "disallow", "shouldUseCompactHeight", "upsertHint", "removeBot", "botId", "", "syncBots", "retainedBotIds", "", "clear", "updateAvailableTopSpace", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateHintVisibility", "displayCount", "shouldHideInPhoneLandscape", "reevaluateHeightMode", "previousDisplayCount", "nextDisplayCount", "reason", "", "estimateDisplayHeight", "requestContainerRelayout", "scheduleScrollToHint", "pendingScrollHintInfo", "scrollVersion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAtHintView extends FrameLayout {
    public final RecyclerView a;
    public final com.bytedance.ee.bear.middleground.comment.widget.a b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public int h;
    public boolean i;
    public Function1<? super b, Unit> j;
    public com.bytedance.ee.bear.middleground.comment.uitls.h k;
    public b l;
    public int m;

    public static final class a implements Runnable {
        public final /* synthetic */ BotAtHintView a;

        public a(BotAtHintView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.requestLayout();     // Catch: Throwable -> L9
            this.a.requestLayout();     // Catch: Throwable -> L9
            Object r0 = this.a.getParent();     // Catch: Throwable -> L9
            if ((r0 instanceof View) == false) goto L5;
            View r1 = (View) r0;     // Catch: Throwable -> L9
        L6:
            if (r1 == null) goto L12;
            r1.requestLayout();     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L5:
            r1 = null;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public BotAtHintView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BotAtHintView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b() {
        com.bytedance.ee.bear.middleground.comment.widget.a r0 = this.b;
        ((ArrayList) r0.a).clear();
        r0.b.clear();
        r0.notifyDataSetChanged();
        this.i = false;
        setVisibility(8);
        e();
    }

    public final void e() {
        this.a.requestLayout();
        requestLayout();
        Object r0 = getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 == null) goto L8;
        r1.requestLayout();
    L8:
        post(new a(this));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final com.bytedance.ee.bear.middleground.comment.uitls.h getCommentAnalytic() {
        return this.k;
    }

    public final Function1<b, Unit> getOnActionClick() {
        return this.j;
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public final void d(long r9) {
        int r0 = this.b.z2();
        com.bytedance.ee.bear.middleground.comment.widget.a r1 = this.b;
        Iterator r2 = ((ArrayList) r1.a).iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L12;
        if (((b) r2.next()).a != r9) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L13;
        r4 = r4 + 1;
    L13:
        if (r4 < 0) goto L16;
        ListProtector.remove(r1.a, r4);
        r1.A2();
        r1.notifyDataSetChanged();
    L16:
        int r10 = this.b.z2();
        c(r0, r10, "removeBot");
        g(r10);
        return;
    L8:
        r5 = false;
        goto L9
    L12:
        r4 = -1;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        int r0 = r6.getActionMasked();
        boolean r2 = false;
        if (r0 == 0) goto L22;
        if (r0 != 1) goto L6;
    L18:
        ViewParent r1 = getParent();
        if (r1 == null) goto L30;
        r1.requestDisallowInterceptTouchEvent(false);
    L30:
        return super.dispatchTouchEvent(r6);
    L6:
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L18;
    L11:
        if (this.a.canScrollVertically(-1) == false) goto L13;
    L14:
        r2 = true;
    L15:
        ViewParent r3 = getParent();
        if (r3 == null) goto L30;
        r3.requestDisallowInterceptTouchEvent(r2);
        goto L30
    L13:
        if (this.a.canScrollVertically(1) == false) goto L15;
    L22:
        if (this.a.canScrollVertically(-1) == false) goto L24;
    L25:
        r2 = true;
    L26:
        ViewParent r4 = getParent();
        if (r4 == null) goto L30;
        r4.requestDisallowInterceptTouchEvent(r2);
        goto L30
    L24:
        if (this.a.canScrollVertically(1) == false) goto L26;
        goto L25
    }

    public final void f(final Set<Long> r6) {
        Intrinsics.checkNotNullParameter(r6, "retainedBotIds");
        int r1 = this.b.z2();
        com.bytedance.ee.bear.middleground.comment.widget.a r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "retainedBotIds");
        if (((ArrayList) r2.a).isEmpty() == false) goto L6;
    L11:
        int r7 = this.b.z2();
        c(r1, r7, "syncBots");
        g(r7);
        return;
    L6:
        if (r6.isEmpty() == false) goto L8;
        ((ArrayList) r2.a).clear();
        r2.b.clear();
        r2.notifyDataSetChanged();
        goto L11
    L8:
        int r0 = ((ArrayList) r2.a).size();
        CollectionsKt.removeAll(r2.a, new BotAtHintAdapter$syncBots$1(r6));
        if (((ArrayList) r2.a).size() == r0) goto L11;
        r2.A2();
        r2.notifyDataSetChanged();
        goto L11
    }

    public final void g(int r1) {
        if (r1 <= 0) goto L6;
        Lazy r2 = CommentUtils.a;
        if (CommentUtils.b(getContext()) == true) goto L6;
        int r3 = 0;
    L7:
        setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        g(this.b.z2());
    }

    public final void setCommentAnalytic(com.bytedance.ee.bear.middleground.comment.uitls.h r2) {
        this.k = r2;
        this.b.d = r2;
    }

    public final void setOnActionClick(Function1<? super b, Unit> r1) {
        this.j = r1;
    }

    public final void setRecyclerNestedScrollingEnabled(boolean r2) {
        this.a.setNestedScrollingEnabled(r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        int r7 = View.MeasureSpec.getSize(r6);
        boolean r1 = false;
        if (this.b.getItemCount() <= 1) goto L15;
        float r0 = View.MeasureSpec.getSize(r5) / a(getResources()).density;
        if (com.bytedance.ee.util.ui.n.C(getContext()) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L15;
        if (r0 < 800.0f) goto L15;
        r1 = true;
        goto L15
    L8:
        if (r0 < 600.0f) goto L10;
        r3 = true;
    L15:
        if (r1 == false) goto L18;
        int r2 = this.d;
    L21:
        if (r7 <= 0) goto L23;
        r2 = Math.min(r7, r2);
    L23:
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE));
        return;
    L18:
        if (this.i == false) goto L20;
        r2 = this.e;
        goto L21
    L20:
        r2 = this.c;
        goto L21
    }

    public BotAtHintView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        com.bytedance.ee.bear.middleground.comment.widget.a r7 = new com.bytedance.ee.bear.middleground.comment.widget.a();
        this.b = r7;
        this.c = MathKt.roundToInt(a(getResources()).density * 132.0f);
        this.d = MathKt.roundToInt(a(getResources()).density * 50.0f);
        this.e = MathKt.roundToInt(a(getResources()).density * 90.0f);
        this.f = MathKt.roundToInt(a(getResources()).density * 145.0f);
        this.g = MathKt.roundToInt(a(getResources()).density * 44.0f);
        this.h = -1;
        LayoutInflater.from(r4).inflate(2131559850, this, true);
        RecyclerView r8 = findViewById(2131364351);
        this.a = r8;
        r8.setLayoutManager(new LinearLayoutManager(r4, 1, false));
        r8.setAdapter(r7);
        r7.c = new AnonymousClass1(this);
        setVisibility(8);
    }

    public final void c(int r4, int r5, String r6) {
        tt5.a.h("BotAtHintView", "reevaluateHeightMode: " + r6 + ", previousDisplayCount=" + r4 + ", nextDisplayCount=" + r5);
        boolean r0 = false;
        if (this.h <= 0) goto L26;
        if (r5 <= 1) goto L26;
        Integer r1 = Integer.valueOf(getMeasuredHeight());
        if (r1.intValue() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r1 = null;
    L14:
        if (r1 == null) goto L16;
        int r7 = r1.intValue();
    L19:
        if (r5 > 0) goto L21;
        int r8 = 0;
    L23:
        if (((this.h + r7) - r8) >= this.f) goto L26;
        r0 = true;
        goto L26
    L21:
        r8 = RangesKt.coerceAtMost(r5 * this.g, this.c);
        goto L23
    L16:
        if (r4 > 0) goto L18;
        r7 = 0;
        goto L19
    L18:
        r7 = RangesKt.coerceAtMost(r4 * this.g, this.c);
        goto L19
    L10:
        r2 = false;
    L26:
        if (this.i != r0) goto L28;
        return;
    L28:
        this.i = r0;
        e();
    }

    public /* synthetic */ BotAtHintView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
