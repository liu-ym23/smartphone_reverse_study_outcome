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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0015J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020/H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0015H\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007H\u0002J\u000e\u00106\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u000209J\u0014\u0010:\u001a\u00020\u001c2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002090<J\u0006\u0010=\u001a\u00020\u001cJ\u000e\u0010>\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0007J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020AH\u0014J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u0007H\u0002J\b\u0010D\u001a\u00020\u0015H\u0002J \u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0002J\b\u0010K\u001a\u00020\u001cH\u0002J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010M\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintAdapter;", "defaultMaxHeightPx", "compactMaxHeightPx", "middleMaxHeightPx", "minReservedTopSpacePx", "estimatedItemHeightPx", "availableTopSpacePx", "shouldUseMiddleHeightByTopSpace", "", "onActionClick", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintInfo;", "Lkotlin/ParameterName;", "name", "hintInfo", "", "getOnActionClick", "()Lkotlin/jvm/functions/Function1;", "setOnActionClick", "(Lkotlin/jvm/functions/Function1;)V", "value", "Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "commentAnalytic", "getCommentAnalytic", "()Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "setCommentAnalytic", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;)V", "setRecyclerNestedScrollingEnabled", "enabled", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleContainerTouch", "event", "canRecyclerScrollVertically", "updateParentInterceptDisallowState", "disallow", "shouldUseCompactHeight", "upsertHint", "removeBot", "botId", "", "syncBots", "retainedBotIds", "", "clear", "updateAvailableTopSpace", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateHintVisibility", "displayCount", "shouldHideInPhoneLandscape", "reevaluateHeightMode", "previousDisplayCount", "nextDisplayCount", "reason", "", "estimateDisplayHeight", "requestContainerRelayout", "scheduleScrollToHint", "pendingScrollHintInfo", "scrollVersion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAtHintView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f232259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.widget.a f232260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f232261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f232262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f232263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f232264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f232265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f232266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f232267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super b, Unit> f232268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.uitls.h f232269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f232270l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f232271m;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BotAtHintView f232272a;

        public a(BotAtHintView r100) {
            this.f232272a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f232272a.f232259a.requestLayout();     // Catch: Throwable -> L9
            this.f232272a.requestLayout();     // Catch: Throwable -> L9
            Object r100 = this.f232272a.getParent();     // Catch: Throwable -> L9
            if ((r100 instanceof View) == false) goto L5;
            View r101 = (View) r100;     // Catch: Throwable -> L9
        L6:
            if (r101 == null) goto L12;
            r101.requestLayout();     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L5:
            r101 = null;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public BotAtHintView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BotAtHintView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b() {
        com.bytedance.ee.bear.middleground.comment.widget.a r100 = this.f232260b;
        ((ArrayList) r100.f232313a).clear();
        r100.f232314b.clear();
        r100.notifyDataSetChanged();
        this.f232267i = false;
        setVisibility(8);
        e();
    }

    public final void e() {
        this.f232259a.requestLayout();
        requestLayout();
        Object r100 = getParent();
        if ((r100 instanceof View) == false) goto L5;
        View r101 = (View) r100;
    L6:
        if (r101 == null) goto L8;
        r101.requestLayout();
    L8:
        post(new a(this));
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final com.bytedance.ee.bear.middleground.comment.uitls.h getCommentAnalytic() {
        return this.f232269k;
    }

    public final Function1<b, Unit> getOnActionClick() {
        return this.f232268j;
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void d(long r100) {
        int r101 = this.f232260b.z2();
        com.bytedance.ee.bear.middleground.comment.widget.a r102 = this.f232260b;
        Iterator r103 = ((ArrayList) r102.f232313a).iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L12;
        if (((b) r103.next()).f232318a != r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L13;
        r104 = r104 + 1;
    L13:
        if (r104 < 0) goto L16;
        ListProtector.remove(r102.f232313a, r104);
        r102.A2();
        r102.notifyDataSetChanged();
    L16:
        int r106 = this.f232260b.z2();
        c(r101, r106, "removeBot");
        g(r106);
        return;
    L8:
        r105 = false;
        goto L9
    L12:
        r104 = -1;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        boolean r102 = false;
        if (r101 == 0) goto L22;
        if (r101 != 1) goto L6;
    L18:
        ViewParent r103 = getParent();
        if (r103 == null) goto L30;
        r103.requestDisallowInterceptTouchEvent(false);
    L30:
        return super.dispatchTouchEvent(r100);
    L6:
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L18;
    L11:
        if (this.f232259a.canScrollVertically(-1) == false) goto L13;
    L14:
        r102 = true;
    L15:
        ViewParent r104 = getParent();
        if (r104 == null) goto L30;
        r104.requestDisallowInterceptTouchEvent(r102);
        goto L30
    L13:
        if (this.f232259a.canScrollVertically(1) == false) goto L15;
    L22:
        if (this.f232259a.canScrollVertically(-1) == false) goto L24;
    L25:
        r102 = true;
    L26:
        ViewParent r105 = getParent();
        if (r105 == null) goto L30;
        r105.requestDisallowInterceptTouchEvent(r102);
        goto L30
    L24:
        if (this.f232259a.canScrollVertically(1) == false) goto L26;
        goto L25
    }

    public final void f(final Set<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "retainedBotIds");
        int r101 = this.f232260b.z2();
        com.bytedance.ee.bear.middleground.comment.widget.a r102 = this.f232260b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "retainedBotIds");
        if (((ArrayList) r102.f232313a).isEmpty() == false) goto L6;
    L11:
        int r103 = this.f232260b.z2();
        c(r101, r103, "syncBots");
        g(r103);
        return;
    L6:
        if (r100.isEmpty() == false) goto L8;
        ((ArrayList) r102.f232313a).clear();
        r102.f232314b.clear();
        r102.notifyDataSetChanged();
        goto L11
    L8:
        int r104 = ((ArrayList) r102.f232313a).size();
        CollectionsKt.removeAll(r102.f232313a, new BotAtHintAdapter$syncBots$1(r100));
        if (((ArrayList) r102.f232313a).size() == r104) goto L11;
        r102.A2();
        r102.notifyDataSetChanged();
        goto L11
    }

    public final void g(int r100) {
        if (r100 <= 0) goto L6;
        Lazy r101 = CommentUtils.f232185a;
        if (CommentUtils.b(getContext()) == true) goto L6;
        int r102 = 0;
    L7:
        setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        g(this.f232260b.z2());
    }

    public final void setCommentAnalytic(com.bytedance.ee.bear.middleground.comment.uitls.h r100) {
        this.f232269k = r100;
        this.f232260b.f232316d = r100;
    }

    public final void setOnActionClick(Function1<? super b, Unit> r100) {
        this.f232268j = r100;
    }

    public final void setRecyclerNestedScrollingEnabled(boolean r100) {
        this.f232259a.setNestedScrollingEnabled(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        boolean r103 = false;
        if (this.f232260b.getItemCount() <= 1) goto L15;
        float r104 = View.MeasureSpec.getSize(r100) / a(getResources()).density;
        if (com.bytedance.ee.util.ui.n.C(getContext()) == true) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L15;
        if (r104 < 800.0f) goto L15;
        r103 = true;
        goto L15
    L8:
        if (r104 < 600.0f) goto L10;
        r105 = true;
    L15:
        if (r103 == false) goto L18;
        int r106 = this.f232262d;
    L21:
        if (r102 <= 0) goto L23;
        r106 = Math.min(r102, r106);
    L23:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r106, Integer.MIN_VALUE));
        return;
    L18:
        if (this.f232267i == false) goto L20;
        r106 = this.f232263e;
        goto L21
    L20:
        r106 = this.f232261c;
        goto L21
    }

    public BotAtHintView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        com.bytedance.ee.bear.middleground.comment.widget.a r103 = new com.bytedance.ee.bear.middleground.comment.widget.a();
        this.f232260b = r103;
        this.f232261c = MathKt.roundToInt(a(getResources()).density * 132.0f);
        this.f232262d = MathKt.roundToInt(a(getResources()).density * 50.0f);
        this.f232263e = MathKt.roundToInt(a(getResources()).density * 90.0f);
        this.f232264f = MathKt.roundToInt(a(getResources()).density * 145.0f);
        this.f232265g = MathKt.roundToInt(a(getResources()).density * 44.0f);
        this.f232266h = -1;
        LayoutInflater.from(r100).inflate(R.layout.comment_bot_at_hint_view, this, true);
        RecyclerView r104 = (RecyclerView) findViewById(R.id.bot_at_hint_recycler);
        this.f232259a = r104;
        r104.setLayoutManager(new LinearLayoutManager(r100, 1, false));
        r104.setAdapter(r103);
        r103.f232315c = new AnonymousClass1(this);
        setVisibility(8);
    }

    public final void c(int r100, int r101, String r102) {
        tt5.a.h("BotAtHintView", "reevaluateHeightMode: " + r102 + ", previousDisplayCount=" + r100 + ", nextDisplayCount=" + r101);
        boolean r103 = false;
        if (this.f232266h <= 0) goto L26;
        if (r101 <= 1) goto L26;
        Integer r104 = Integer.valueOf(getMeasuredHeight());
        if (r104.intValue() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L16;
        int r106 = r104.intValue();
    L19:
        if (r101 > 0) goto L21;
        int r107 = 0;
    L23:
        if (((this.f232266h + r106) - r107) >= this.f232264f) goto L26;
        r103 = true;
        goto L26
    L21:
        r107 = RangesKt.coerceAtMost(r101 * this.f232265g, this.f232261c);
        goto L23
    L16:
        if (r100 > 0) goto L18;
        r106 = 0;
        goto L19
    L18:
        r106 = RangesKt.coerceAtMost(r100 * this.f232265g, this.f232261c);
        goto L19
    L10:
        r105 = false;
    L26:
        if (this.f232267i != r103) goto L28;
        return;
    L28:
        this.f232267i = r103;
        e();
    }

    public /* synthetic */ BotAtHintView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
