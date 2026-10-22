package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.customview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.anim.EaseInOutInterpolator;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.utils.ViewExtKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B)\b\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/OverScrollLayout;", "Landroid/widget/LinearLayout;", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/OverScrollLayout$OverScrollListener;", "listener", "", "setOverScrollListener", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/OverScrollLayout$LayoutListener;", "setLayoutListener", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/OverScrollLayout$OverScrollThresholdListener;", "setThresholdListener", "", "position", "setPosition", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "LayoutListener", "OverScrollListener", "OverScrollThresholdListener", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OverScrollLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f450209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f450210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f450211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f450212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OverScrollListener f450213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LayoutListener f450214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OverScrollThresholdListener f450215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f450216h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/OverScrollLayout$Companion;", "", "()V", "ANIM_TIME", "", "DAMPING_COEFFICIENT", "", "DEBUG_TAG", "", "OVERSCROLL_THRESHOLD", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/OverScrollLayout$LayoutListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface LayoutListener {
        void a(int r100);

        void b(int r100);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/OverScrollLayout$OverScrollListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OverScrollListener {
        void a(int r100);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/OverScrollLayout$OverScrollThresholdListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OverScrollThresholdListener {
        void a(boolean r100);
    }

    static {
        new Companion(0);
    }

    public OverScrollLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OverScrollLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() >= 0) goto L5;
        return;
    L5:
        if ((getChildAt(0) instanceof RecyclerView) == false) goto L12;
        View r100 = getChildAt(0);
        if (r100 == null) goto L10;
        this.f450209a = (RecyclerView) r100;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r100 = r110.getAction();
        if (r100 != 0) goto L5;
        Logger.a("OverScrollLayout", "onInterceptTouchEvent ACTION_DOWN，disable parent touch event");
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f450212d = r110.getX();
        this.f450211c = false;
        return super.onInterceptTouchEvent(r110);
    L5:
        if (r100 == 2) goto L8;
        Logger.a("OverScrollLayout", "onInterceptTouchEvent action others: " + r110.getAction());
        return super.onInterceptTouchEvent(r110);
    L8:
        int r101 = (int) (r110.getX() - this.f450212d);
        if (r101 <= 0) goto L28;
        RecyclerView r102 = this.f450209a;
        if (r102 != null) goto L13;
    L23:
        boolean r103 = false;
    L26:
        if (r103 == false) goto L28;
        boolean r104 = true;
    L29:
        Logger.a("OverScrollLayout", "onInterceptTouchEvent scrollXPox = " + r101 + ", canSlideRight = " + r104);
        if (r101 >= 0) goto L54;
        RecyclerView r105 = this.f450209a;
        if (r105 == null) goto L49;
        RecyclerView.Adapter r106 = r105.getAdapter();
        if (r106 == null) goto L36;
        int r107 = r106.getItemCount();
    L37:
        int r108 = r107 - 1;
        if ((r105.getLayoutManager() instanceof LinearLayoutManager) == false) goto L49;
        if (r108 < 0) goto L49;
        RecyclerView.LayoutManager r109 = r105.getLayoutManager();
        if (r109 == null) goto L51;
        if (((LinearLayoutManager) r109).findLastVisibleItemPosition() < r108) goto L49;
        if (r105.getChildCount() <= 0) goto L49;
        int[] r111 = ViewExtKt.c(r105);
        View r112 = r105.getChildAt(r105.getChildCount() - 1);
        int r113 = ArraysKt.first(ViewExtKt.c(r112)) + r112.getWidth();
        int r114 = ArraysKt.first(r111) + r105.getWidth();
        Logger.a("OverScrollLayout", "canSlideLeft lastChildRightPos = " + r113 + ", rcyViewRightPos = " + r114);
        if (r113 > r114) goto L49;
        boolean r115 = true;
    L52:
        if (r115 == false) goto L54;
        boolean r116 = true;
    L55:
        Logger.a("OverScrollLayout", "onInterceptTouchEvent scrollXPox = " + r101 + ", canSlideLeft = " + r116);
        if (r104 == true) goto L63;
        if (r116 == true) goto L63;
        if (this.f450211c == true) goto L63;
        Logger.a("OverScrollLayout", "onInterceptTouchEvent ACTION_MOVE: isMoving = false");
        this.f450212d = r110.getX();
        this.f450211c = false;
        return super.onInterceptTouchEvent(r110);
    L63:
        Logger.a("OverScrollLayout", "onInterceptTouchEvent ACTION_MOVE: isMoving = true");
        this.f450211c = true;
        return true;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L36:
        r107 = 0;
    L49:
        r115 = false;
    L54:
        r116 = false;
        goto L55
    L13:
        if ((r102.getLayoutManager() instanceof LinearLayoutManager) == false) goto L23;
        RecyclerView.LayoutManager r117 = r102.getLayoutManager();
        if (r117 == null) goto L25;
        if (((LinearLayoutManager) r117).findFirstVisibleItemPosition() != 0) goto L23;
        if (r102.getChildCount() <= 0) goto L23;
        int[] r118 = ViewExtKt.c(r102);
        int[] r119 = ViewExtKt.c(r102.getChildAt(0));
        Logger.a("OverScrollLayout", "canSlideRight firstChildLeftPos = " + ArraysKt.first(r119) + ", rcyViewLeftPos = " + ArraysKt.first(r118));
        if (ArraysKt.first(r119) < ArraysKt.first(r118)) goto L23;
        r103 = true;
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L28:
        r104 = false;
        goto L29
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r100 = r110.getAction();
        if (r100 == 0) goto L36;
        final int r101 = 2;
        if (r100 != 2) goto L7;
        int r111 = (int) (((int) (r110.getX() - this.f450212d)) * 0.3f);
        Logger.a("OverScrollLayout", "onTouchEvent: ACTION_MOVE: isMoving = " + this.f450211c + ", offset = " + r111);
        RecyclerView r102 = this.f450209a;
        if (r102 == null) goto L27;
        Rect r103 = this.f450210b;
        r102.layout(r103.left + r111, r103.top, r103.right + r111, r103.bottom);
    L27:
        if (r111 >= 100) goto L33;
        if (r111 <= (-100)) goto L33;
        OverScrollThresholdListener r112 = this.f450215g;
        if (r112 == null) goto L37;
        r112.a(false);
    L37:
        return true;
    L33:
        OverScrollThresholdListener r113 = this.f450215g;
        if (r113 == null) goto L37;
        r113.a(true);
        goto L37
    L7:
        if (r110.getAction() != 1) goto L13;
        Logger.a("OverScrollLayout", "onTouchEvent touch event up, recoverLayout isMoved = " + this.f450211c);
        int r114 = (int) (((float) ((int) (r110.getX() - this.f450212d))) * 0.3f);
        if (r114 < 100) goto L11;
        boolean r115 = true;
        r101 = 1;
    L16:
        if (this.f450211c == false) goto L37;
        Logger.a("OverScrollLayout", "recover OverScrollLayout");
        RecyclerView r104 = this.f450209a;
        if (r104 == null) goto L23;
        TranslateAnimation r105 = new TranslateAnimation(r104.getLeft() - this.f450210b.left, 0.0f, 0.0f, 0.0f);
        r105.setInterpolator(new EaseInOutInterpolator());
        r105.setDuration(200);
        if (r115 == false) goto L22;
        r105.setAnimationListener(new OverScrollLayout$recoverLayout$$inlined$let$lambda$1(this, r101));
    L22:
        r104.startAnimation(r105);
        Rect r116 = this.f450210b;
        r104.layout(r116.left, r116.top, r116.right, r116.bottom);
    L23:
        this.f450211c = false;
        goto L37
    L11:
        if (r114 > (-100)) goto L14;
        r115 = true;
    L14:
        r115 = false;
        r101 = 0;
        goto L16
    L13:
        Logger.a("OverScrollLayout", "onTouchEvent touch event else branch, event action = " + r110.getAction() + ", isMoved = " + this.f450211c);
        goto L14
    L36:
        Logger.a("OverScrollLayout", "onTouchEvent ACTION_DOWN");
        goto L37
    }

    public final void setLayoutListener(LayoutListener r100) {
        this.f450214f = r100;
    }

    public final void setOverScrollListener(OverScrollListener r100) {
        this.f450213e = r100;
    }

    public final void setPosition(int r100) {
        this.f450216h = r100;
    }

    public final void setThresholdListener(OverScrollThresholdListener r100) {
        this.f450215g = r100;
    }

    public OverScrollLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f450210b = new Rect();
    }

    public /* synthetic */ OverScrollLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        LayoutListener r105 = this.f450214f;
        if (r105 == null) goto L5;
        r105.b(this.f450216h);
    L5:
        super.onLayout(r100, r101, r102, r103, r104);
        RecyclerView r106 = this.f450209a;
        if (r106 == null) goto L8;
        this.f450210b.set(r106.getLeft(), r106.getTop(), r106.getRight(), r106.getBottom());
        Logger.a("OverScrollLayout", "originalPos left = " + r106.getLeft() + ", top = " + r106.getTop() + ", right = " + r106.getRight() + ", bottom = " + r106.getBottom());
    L8:
        LayoutListener r107 = this.f450214f;
        if (r107 == null) goto L12;
        r107.a(this.f450216h);
        return;
    }
}
