package com.larus.dora.impl.onboarding.lite;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 22\u00020\u0001:\u00012B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\f\u0010%\u001a\u00020&*\u00020'H\u0002J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\f\u0010*\u001a\u00020&*\u00020'H\u0002J\u001c\u0010+\u001a\u00020&*\u00020'2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\nH\u0002J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020&H\u0014J\b\u00101\u001a\u00020&H\u0014R&\u0010\f\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u000f0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingTopicView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "offlineTopicList", "", "", "Lkotlin/jvm/internal/EnhancedNullability;", "getOfflineTopicList", "()Ljava/util/List;", "offlineTopicList$delegate", "Lkotlin/Lazy;", "data", "itemScale", "", "itemSpace", "itemMinHeight", "paddingHorizontal", "topChildIndex", "isScrolling", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "loopJob", "Lkotlinx/coroutines/Job;", "backgroundView", "Landroid/view/View;", "contentView", "getTopicList", "addAllChildView", "", "Landroid/view/ViewGroup;", "startScroll", "stopScroll", "scrollToNext", "endAction", "topChildView", "nextChildViewIndex", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingTopicView extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f336896m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f336897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f336898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f336899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f336900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f336901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f336902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f336903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f336904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineScope f336905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f336906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f336907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final FrameLayout f336908l;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingTopicView f336909a;

        public b(DoraLiteOnboardingTopicView r100) {
            this.f336909a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            View r109 = this.f336909a.f336908l.getChildAt(0);
            if (r109 == null) goto L10;
            View r110 = this.f336909a.f336907k;
            ViewGroup.LayoutParams r111 = r110.getLayoutParams();
            if (r111 == null) goto L7;
            r111.height = (int) (r109.getHeight() * this.f336909a.f336899c);
            r111.width = (int) (r109.getWidth() * this.f336909a.f336899c);
        L8:
            r110.setLayoutParams(r111);
            return;
        L7:
            r111 = null;
            goto L8
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingTopicView f336910a;

        public c(DoraLiteOnboardingTopicView r100) {
            this.f336910a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            View r109 = this.f336910a.f336908l.getChildAt(0);
            if (r109 == null) goto L10;
            View r110 = this.f336910a.f336907k;
            ViewGroup.LayoutParams r111 = r110.getLayoutParams();
            if (r111 == null) goto L7;
            r111.height = (int) (r109.getHeight() * this.f336910a.f336899c);
            r111.width = (int) (r109.getWidth() * this.f336910a.f336899c);
        L8:
            r110.setLayoutParams(r111);
            return;
        L7:
            r111 = null;
            goto L8
        }
    }

    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraLiteOnboardingTopicView f336911a;

        public d(DoraLiteOnboardingTopicView r100) {
            this.f336911a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            View r109 = this.f336911a.f336908l.getChildAt(0);
            if (r109 == null) goto L10;
            View r110 = this.f336911a.f336907k;
            ViewGroup.LayoutParams r111 = r110.getLayoutParams();
            if (r111 == null) goto L7;
            r111.height = (int) (r109.getHeight() * this.f336911a.f336899c);
            r111.width = (int) (r109.getWidth() * this.f336911a.f336899c);
        L8:
            r110.setLayoutParams(r111);
            return;
        L7:
            r111 = null;
            goto L8
        }
    }

    static {
    }

    private final List<String> getOfflineTopicList() {
        return (List) this.f336897a.getValue();
    }

    private final List<String> getTopicList() {
        DoraSetting.f338023a.getClass();
        List<String> r100 = DoraSetting.d();
        if (r100 != null) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if (r100.size() > 6) goto L8;
        r100 = CollectionsKt.plus(r100, getOfflineTopicList());
    L8:
        Iterator<String> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        g49.d.d("DoraOnboardingTopicView", "DoraOnboardingTopicView: queryTopic=" + r101.next());
        goto L10
    L12:
        return r100;
    }

    public final void c() {
        Job r100 = this.f336906j;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        g49.d.d("DoraOnboardingTopicView", "startScroll: loopJob is active");
        return;
    L10:
        this.f336906j = BuildersKt.launch$default(this.f336905i, null, null, new DoraLiteOnboardingTopicView$startScroll$1(this, null), 3, null);
        return;
    L5:
        if (r100.isActive() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L6;
        c();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r100 = this.f336906j;
        if (r100 == null) goto L6;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
        return;
    }

    public DoraLiteOnboardingTopicView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f336897a = LazyKt.lazy(new t(this));
        this.f336898b = getTopicList();
        this.f336899c = 1.2f;
        this.f336900d = i5.h();
        this.f336901e = i5.X();
        int r101 = (int) ((com.larus.utils.i.d(getContext()) * 0.33600003f) / 2);
        this.f336902f = r101;
        this.f336905i = CoroutineScopeKt.MainScope();
        setClipChildren(true);
        setClipToPadding(false);
        setPadding(r101, 0, r101, 0);
        View r102 = new View(getContext());
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 1;
        r102.setLayoutParams(r103);
        r102.setBackground(ContextCompat.getDrawable(r102.getContext(), R.drawable.larus_dora_onboarding_query_topic_highlight_bg));
        this.f336907k = r102;
        addView(r102);
        FrameLayout r104 = new FrameLayout(getContext());
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r104.setClipChildren(false);
        r104.setClipToPadding(false);
        b(r104);
        this.f336908l = r104;
        addView(r104);
        addOnLayoutChangeListener(new b(this));
    }

    public static List a(DoraLiteOnboardingTopicView r100) {
        return CollectionsKt.listOf(new String[]{r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic1_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic2_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic3_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic4_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic5_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic6_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic7_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic8_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic9_cn), r100.getContext().getResources().getString(R.string.larus_dora_onboarding_query_topic10_cn)});
    }

    public final void b(ViewGroup r110) {
        r110.removeAllViews();
        int r100 = ((com.larus.utils.i.c(r110.getContext()) - ((Number) i5.O1.getValue()).intValue()) / (this.f336901e + this.f336900d)) + 2;
        g49.d.d("DoraOnboardingTopicView", "#####maxChildCount=" + r100);
        int r101 = com.larus.utils.i.d(r110.getContext()) - (this.f336902f * 2);
        float r102 = 0.0f;
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L9;
        TextView r104 = new TextView(r110.getContext());
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 1;
        r104.setLayoutParams(r105);
        r104.setMaxLines(2);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        r104.setTextSize(16.0f);
        r104.setMinHeight(this.f336901e);
        r104.setGravity(17);
        List<String> r106 = this.f336898b;
        r104.setText((CharSequence) ListProtector.get(r106, r103 % r106.size()));
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), R.color.larus_neutral_100));
        r104.setTag(Integer.valueOf(r103 % this.f336898b.size()));
        r104.setPaddingRelative(i5.q(), i5.h(), i5.q(), i5.h());
        r104.measure(View.MeasureSpec.makeMeasureSpec(r101, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r107 = r104.getMeasuredHeight();
        if (r103 != 0) goto L7;
        r104.setScaleX(this.f336899c);
        r104.setScaleY(this.f336899c);
        float r108 = r107;
        r104.setTranslationY(((this.f336899c * r108) - r108) / 2.0f);
        float r109 = (r108 * this.f336899c) + this.f336900d;
    L8:
        r102 = r102 + r109;
        r110.addView(r104);
        r103 = r103 + 1;
        goto L3
    L7:
        r104.setTranslationY(r102);
        r109 = r107 + this.f336900d;
        goto L8
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        c();
        return;
    L5:
        Job r101 = this.f336906j;
        if (r101 == null) goto L10;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        return;
    }

    public DoraLiteOnboardingTopicView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f336897a = LazyKt.lazy(new t(this));
        this.f336898b = getTopicList();
        this.f336899c = 1.2f;
        this.f336900d = i5.h();
        this.f336901e = i5.X();
        int r102 = (int) ((com.larus.utils.i.d(getContext()) * 0.33600003f) / 2);
        this.f336902f = r102;
        this.f336905i = CoroutineScopeKt.MainScope();
        setClipChildren(true);
        setClipToPadding(false);
        setPadding(r102, 0, r102, 0);
        View r103 = new View(getContext());
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 1;
        r103.setLayoutParams(r104);
        r103.setBackground(ContextCompat.getDrawable(r103.getContext(), R.drawable.larus_dora_onboarding_query_topic_highlight_bg));
        this.f336907k = r103;
        addView(r103);
        FrameLayout r105 = new FrameLayout(getContext());
        r105.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r105.setClipChildren(false);
        r105.setClipToPadding(false);
        b(r105);
        this.f336908l = r105;
        addView(r105);
        addOnLayoutChangeListener(new c(this));
    }

    public DoraLiteOnboardingTopicView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f336897a = LazyKt.lazy(new t(this));
        this.f336898b = getTopicList();
        this.f336899c = 1.2f;
        this.f336900d = i5.h();
        this.f336901e = i5.X();
        int r103 = (int) ((com.larus.utils.i.d(getContext()) * 0.33600003f) / 2);
        this.f336902f = r103;
        this.f336905i = CoroutineScopeKt.MainScope();
        setClipChildren(true);
        setClipToPadding(false);
        setPadding(r103, 0, r103, 0);
        View r104 = new View(getContext());
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 1;
        r104.setLayoutParams(r105);
        r104.setBackground(ContextCompat.getDrawable(r104.getContext(), R.drawable.larus_dora_onboarding_query_topic_highlight_bg));
        this.f336907k = r104;
        addView(r104);
        FrameLayout r106 = new FrameLayout(getContext());
        r106.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r106.setClipChildren(false);
        r106.setClipToPadding(false);
        b(r106);
        this.f336908l = r106;
        addView(r106);
        addOnLayoutChangeListener(new d(this));
    }
}
