package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.view.ViewGroupKt;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000 \u007f2\u00020\u0001:\u0001\u007fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;J\u0016\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\u0006\u0010\u001d\u001a\u00020\nJ\u0014\u00109\u001a\u00020\u000e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0=J\u000e\u0010>\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;J\u0006\u0010?\u001a\u00020\u000eJ\u000e\u0010@\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;J\u0006\u0010A\u001a\u00020\u000eJ\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010C\u001a\u00020\u000eJ\u0006\u0010D\u001a\u00020\u000eJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u00020\nJ\u0006\u0010I\u001a\u00020\u000eJ\u0006\u0010J\u001a\u00020\u000eJ\u0018\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\nH\u0014J0\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0014J\b\u0010V\u001a\u00020\u000eH\u0014J\b\u0010W\u001a\u00020\u000eH\u0016J\b\u0010]\u001a\u00020\u000eH\u0002J\u0010\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u000203H\u0002J\b\u0010`\u001a\u00020\u000eH\u0002J\b\u0010a\u001a\u00020\u000eH\u0002J\u0018\u0010b\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010:\u001a\u00020;H\u0002J\u0006\u0010c\u001a\u00020\u000eJ\b\u0010d\u001a\u00020\u000eH\u0003J\b\u0010e\u001a\u00020\u000eH\u0002J\b\u0010f\u001a\u00020\u000eH\u0002J\b\u0010g\u001a\u00020\u000eH\u0002R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R7\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010h\u001a\u00020i8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bj\u0010kR\u001b\u0010n\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010m\u001a\u0004\bp\u0010qR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010m\u001a\u0004\bt\u0010qR\u001b\u0010v\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010m\u001a\u0004\bw\u0010qR\u001b\u0010y\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010m\u001a\u0004\bz\u0010qR\u001b\u0010|\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u0010m\u001a\u0004\b}\u0010q¨\u0006\u0080\u0001"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/CardListFrame;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onClearClick", "Lkotlin/Function0;", "", "getOnClearClick", "()Lkotlin/jvm/functions/Function0;", "setOnClearClick", "(Lkotlin/jvm/functions/Function0;)V", "onExpand", "getOnExpand", "setOnExpand", "onEllipsize", "getOnEllipsize", "setOnEllipsize", "onCardClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "getOnCardClick", "()Lkotlin/jvm/functions/Function1;", "setOnCardClick", "(Lkotlin/jvm/functions/Function1;)V", "onTopCardClick", "getOnTopCardClick", "setOnTopCardClick", "onTopCardMovedOut", "getOnTopCardMovedOut", "setOnTopCardMovedOut", "onCardViewRemoved", "getOnCardViewRemoved", "setOnCardViewRemoved", "actionLayout", "Landroid/widget/LinearLayout;", "actionLayoutBottom", "cardList", "Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/CardListLayout;", "cardScrollView", "Landroid/widget/ScrollView;", "clearButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "clearButtonBottom", "ellipsizeButton", "ellipsizeButtonBottom", "topCardContainer", "Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/TopCardContainer;", "addCardView", "view", "Landroid/view/View;", "views", "", "addTopCardView", "clearTopCardView", "replaceTopCardView", "removeFirstCardView", "removeCardViewAt", "removeAllCardViews", "removeTopCardViewNoAnim", "hasCardView", "", "cardCount", "bannerCount", BitableAnalytic.LinkSceneClickType.EXPAND, "ellipsize", "maxWidth", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "firstLayoutAfterAttachToWindow", "onDetachedFromWindow", "requestLayout", "clearState", "bottomClearState", "reInitClearButtonCallback", "Ljava/lang/Runnable;", "reInitBottomClearButtonCallback", "initViews", "initClearButton", "button", "initEllipsizeButton", "initButtonColors", "onCardViewClicked", "release", "settleTopView", "removeTopCardViews", "ensureActionLayoutState", "onRemoveCardAnimEnd", "addTransition", "Landroidx/transition/Transition;", "getAddTransition", "()Landroidx/transition/Transition;", "addTransition$delegate", "Lkotlin/Lazy;", "transition", "Landroidx/transition/TransitionSet;", "getTransition", "()Landroidx/transition/TransitionSet;", "transition$delegate", "removeCardTransition", "getRemoveCardTransition", "removeCardTransition$delegate", "addTopCardTransition", "getAddTopCardTransition", "addTopCardTransition$delegate", "fadeOutTopCardTransition", "getFadeOutTopCardTransition", "fadeOutTopCardTransition$delegate", "removeTopCardTransition", "getRemoveTopCardTransition", "removeTopCardTransition$delegate", "Companion", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardListFrame extends FrameLayout {
    public final Lazy A;
    public final Lazy B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f460824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f460825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f460826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f460827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f460828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f460829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f460830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f460831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f460832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CardListLayout f460833j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ScrollView f460834k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public UDButton f460835l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public UDButton f460836m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UDButton f460837n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public UDButton f460838o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TopCardContainer f460839p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f460840q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f460841r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f460842s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f460843t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f460844u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f460845v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f460846w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f460847x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f460848y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f460849z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardListFrame f460852a;

        public b(CardListFrame r100) {
            this.f460852a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f460852a.d();
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardListFrame f460853a;

        public c(CardListFrame r100) {
            this.f460853a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f460853a.d();
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardListFrame f460854a;

        public d(CardListFrame r100) {
            this.f460854a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CardListFrame r101 = this.f460854a;
            int r102 = r101.f460842s;
            if (r102 == 0) goto L10;
            if (r102 != 1) goto L26;
            Function0<Unit> r103 = r101.getOnClearClick();
            if (r103 == null) goto L9;
            r103.invoke();
        L9:
            this.f460854a.d();
            return;
        L26:
            return;
        L10:
            LinearLayout r104 = r101.f460831h;
            UDButton r105 = null;
            if (r104 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
            r104 = null;
        L13:
            TransitionManager.beginDelayedTransition(r104);
            UDButton r106 = this.f460854a.f460835l;
            if (r106 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            r106 = null;
        L16:
            r106.setText(R.string.Lark_Meetings_ClearAllCard_Button);
            UDButton r107 = this.f460854a.f460835l;
            if (r107 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            r107 = null;
        L19:
            r107.applyStyle(R.style.UDButton_Middle_Circle);
            UDButton r108 = this.f460854a.f460835l;
            if (r108 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        L23:
            r105.setTextColor(UDColorUtils.getColor(this.f460854a.getContext(), R.color.text_title));
            CardListFrame r109 = this.f460854a;
            r109.f460842s = 1;
            r109.postDelayed(r109.f460844u, 5000);
            return;
        L22:
            r105 = r108;
            goto L23
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardListFrame f460855a;

        public e(CardListFrame r100) {
            this.f460855a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CardListFrame r101 = this.f460855a;
            int r102 = r101.f460843t;
            if (r102 == 0) goto L10;
            if (r102 != 1) goto L26;
            Function0<Unit> r103 = r101.getOnClearClick();
            if (r103 == null) goto L9;
            r103.invoke();
        L9:
            this.f460855a.d();
            return;
        L26:
            return;
        L10:
            LinearLayout r104 = r101.f460832i;
            UDButton r105 = null;
            if (r104 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("actionLayoutBottom");
            r104 = null;
        L13:
            TransitionManager.beginDelayedTransition(r104);
            UDButton r106 = this.f460855a.f460836m;
            if (r106 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
            r106 = null;
        L16:
            r106.setText(R.string.Lark_Meetings_ClearAllCard_Button);
            UDButton r107 = this.f460855a.f460836m;
            if (r107 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
            r107 = null;
        L19:
            r107.applyStyle(R.style.UDButton_Middle_Circle);
            UDButton r108 = this.f460855a.f460836m;
            if (r108 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        L23:
            r105.setTextColor(UDColorUtils.getColor(this.f460855a.getContext(), R.color.text_title));
            CardListFrame r109 = this.f460855a;
            r109.f460843t = 1;
            r109.postDelayed(r109.f460845v, 5000);
            return;
        L22:
            r105 = r108;
            goto L23
        }
    }

    public static final class f implements TopCardContainer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardListFrame f460856a;

        @Override // com.suite.lark.platform.component.widget_biz_dinghelper.helper.view.TopCardContainer.a
        public final void a() {
            TopCardContainer r100 = this.f460856a.f460839p;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
            r100 = null;
        L5:
            int r101 = r100.getChildCount();
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L8;
            r100.getChildAt(r102).setVisibility(4);
            r102 = r102 + 1;
            goto L6
        L8:
            Function0<Unit> r103 = this.f460856a.getOnTopCardMovedOut();
            if (r103 == null) goto L13;
            r103.invoke();
            return;
        }

        public f(CardListFrame r100) {
            this.f460856a = r100;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardListFrame f460858a;

        public g(CardListFrame r100) {
            this.f460858a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CardListFrame r100 = this.f460858a;     // Catch: Throwable -> L11
            r100.f460843t = 0;     // Catch: Throwable -> L11
            LinearLayout r101 = r100.f460832i;     // Catch: Throwable -> L11
            UDButton r102 = null;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("actionLayoutBottom");     // Catch: Throwable -> L11
            r101 = null;
        L5:
            TransitionManager.beginDelayedTransition(r101);     // Catch: Throwable -> L11
            CardListFrame r103 = this.f460858a;     // Catch: Throwable -> L11
            UDButton r104 = r103.f460836m;     // Catch: Throwable -> L11
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");     // Catch: Throwable -> L11
        L9:
            r103.f(r102);     // Catch: Throwable -> L11
            return;
        L8:
            r102 = r104;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardListFrame f460859a;

        public h(CardListFrame r100) {
            this.f460859a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CardListFrame r100 = this.f460859a;     // Catch: Throwable -> L11
            r100.f460842s = 0;     // Catch: Throwable -> L11
            LinearLayout r101 = r100.f460831h;     // Catch: Throwable -> L11
            UDButton r102 = null;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("actionLayout");     // Catch: Throwable -> L11
            r101 = null;
        L5:
            TransitionManager.beginDelayedTransition(r101);     // Catch: Throwable -> L11
            CardListFrame r103 = this.f460859a;     // Catch: Throwable -> L11
            UDButton r104 = r103.f460835l;     // Catch: Throwable -> L11
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");     // Catch: Throwable -> L11
        L9:
            r103.f(r102);     // Catch: Throwable -> L11
            return;
        L8:
            r102 = r104;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    static {
    }

    private final TransitionSet getAddTopCardTransition() {
        return (TransitionSet) this.f460849z.getValue();
    }

    private final Transition getAddTransition() {
        return (Transition) this.f460846w.getValue();
    }

    private final TransitionSet getFadeOutTopCardTransition() {
        return (TransitionSet) this.A.getValue();
    }

    private final TransitionSet getRemoveCardTransition() {
        return (TransitionSet) this.f460848y.getValue();
    }

    private final TransitionSet getRemoveTopCardTransition() {
        return (TransitionSet) this.B.getValue();
    }

    private final TransitionSet getTransition() {
        return (TransitionSet) this.f460847x.getValue();
    }

    public final void d() {
        CardListLayout r100 = this.f460833j;
        UDButton r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r100 = null;
    L6:
        if (r100.f460863a == true) goto L8;
        return;
    L8:
        ScrollView r102 = this.f460834k;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r102 = null;
    L11:
        TransitionManager.beginDelayedTransition(r102, getTransition());
        CardListLayout r103 = this.f460833j;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r103 = null;
    L14:
        r103.f460863a = false;
        r103.T5();
        LinearLayout r104 = this.f460831h;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
        r104 = null;
    L17:
        r104.setVisibility(8);
        Function0<Unit> r105 = this.f460826c;
        if (r105 == null) goto L20;
        r105.invoke();
    L20:
        setOnClickListener(null);
        setClickable(false);
        UDButton r106 = this.f460835l;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r106 = null;
    L23:
        f(r106);
        this.f460842s = 0;
        UDButton r107 = this.f460835l;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r107 = null;
    L26:
        r107.removeCallbacks(this.f460844u);
        UDButton r108 = this.f460836m;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r108 = null;
    L29:
        f(r108);
        this.f460843t = 0;
        UDButton r109 = this.f460836m;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
    L33:
        r101.removeCallbacks(this.f460845v);
        return;
    L32:
        r101 = r109;
        goto L33
    }

    public final void e() {
        UDButton r100 = this.f460837n;
        UDButton r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r100 = null;
    L5:
        r100.setTextColor(UDColorUtils.getColor(getContext(), R.color.text_title));
        UDButton r102 = this.f460837n;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r102 = null;
    L8:
        r102.setBackgroundColor(UDColorUtils.getColorStateList(getContext(), R.color.bg_color_card_list_button));
        UDButton r103 = this.f460837n;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r103 = null;
    L11:
        r103.setStrokeColor(UDColorUtils.getColorStateList(getContext(), R.color.line_border_card));
        UDButton r104 = this.f460838o;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
        r104 = null;
    L14:
        r104.setTextColor(UDColorUtils.getColor(getContext(), R.color.text_title));
        UDButton r105 = this.f460838o;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
        r105 = null;
    L17:
        r105.setBackgroundColor(UDColorUtils.getColorStateList(getContext(), R.color.bg_color_card_list_button));
        UDButton r106 = this.f460838o;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
        r106 = null;
    L20:
        r106.setStrokeColor(UDColorUtils.getColorStateList(getContext(), R.color.line_border_card));
        UDButton r107 = this.f460835l;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r107 = null;
    L23:
        r107.setTextColor(UDColorUtils.getColor(getContext(), R.color.text_title));
        UDButton r108 = this.f460835l;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r108 = null;
    L26:
        r108.setBackgroundColor(UDColorUtils.getColorStateList(getContext(), R.color.bg_color_card_list_button));
        UDButton r109 = this.f460835l;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r109 = null;
    L29:
        r109.setStrokeColor(UDColorUtils.getColorStateList(getContext(), R.color.line_border_card));
        UDButton r110 = this.f460836m;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r110 = null;
    L32:
        r110.setTextColor(UDColorUtils.getColor(getContext(), R.color.text_title));
        UDButton r111 = this.f460836m;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r111 = null;
    L35:
        r111.setBackgroundColor(UDColorUtils.getColorStateList(getContext(), R.color.bg_color_card_list_button));
        UDButton r112 = this.f460836m;
        if (r112 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
    L39:
        r101.setStrokeColor(UDColorUtils.getColorStateList(getContext(), R.color.line_border_card));
        return;
    L38:
        r101 = r112;
        goto L39
    }

    public final void g() {
        this.f460831h = (LinearLayout) findViewById(R.id.action_layout);
        this.f460832i = (LinearLayout) findViewById(R.id.action_layout_bottom);
        this.f460833j = (CardListLayout) findViewById(R.id.card_list);
        this.f460834k = (ScrollView) findViewById(R.id.card_scroll_view);
        this.f460835l = (UDButton) findViewById(R.id.clear_button);
        this.f460836m = (UDButton) findViewById(R.id.clear_button_bottom);
        this.f460837n = (UDButton) findViewById(R.id.ellipsize_button);
        this.f460838o = (UDButton) findViewById(R.id.ellipsize_button_bottom);
        this.f460839p = (TopCardContainer) findViewById(R.id.single_top_container);
        CardListLayout r100 = this.f460833j;
        TopCardContainer r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r100 = null;
    L5:
        r100.setChildrenOnClickListener(new CardListFrame$initViews$1(this));
        UDButton r102 = this.f460837n;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r102 = null;
    L8:
        r102.setOnClickListener(new b(this));
        UDButton r103 = this.f460838o;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
        r103 = null;
    L11:
        r103.setOnClickListener(new c(this));
        UDButton r104 = this.f460835l;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r104 = null;
    L14:
        f(r104);
        UDButton r105 = this.f460836m;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r105 = null;
    L17:
        f(r105);
        e();
        UDButton r106 = this.f460835l;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r106 = null;
    L20:
        r106.setOnClickListener(new d(this));
        UDButton r107 = this.f460836m;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r107 = null;
    L23:
        r107.setOnClickListener(new e(this));
        TopCardContainer r108 = this.f460839p;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
    L27:
        r101.setOnTopCardMoveOutListener(new f(this));
        return;
    L26:
        r101 = r108;
        goto L27
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f460841r = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (this.f460841r == false) goto L9;
        this.f460841r = false;
        TopCardContainer r100 = this.f460839p;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r100 = null;
    L7:
        r100.requestLayout();
        return;
    }

    public final Function1<Integer, Unit> getOnCardClick() {
        return this.f460827d;
    }

    public final Function0<Unit> getOnCardViewRemoved() {
        return this.f460830g;
    }

    public final Function0<Unit> getOnClearClick() {
        return this.f460824a;
    }

    public final Function0<Unit> getOnEllipsize() {
        return this.f460826c;
    }

    public final Function0<Unit> getOnExpand() {
        return this.f460825b;
    }

    public final Function0<Unit> getOnTopCardClick() {
        return this.f460828e;
    }

    public final Function0<Unit> getOnTopCardMovedOut() {
        return this.f460829f;
    }

    public CardListFrame(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.card_list_frame, this, true);
        g();
        this.f460840q = (int) new UDDimension.Dp(360).toPixels(getContext());
        this.f460844u = new h(this);
        this.f460845v = new g(this);
        this.f460846w = LazyKt.lazy(new CardListFrame$addTransition$2(this));
        this.f460847x = LazyKt.lazy(new CardListFrame$transition$2(this));
        this.f460848y = LazyKt.lazy(new CardListFrame$removeCardTransition$2(this));
        this.f460849z = LazyKt.lazy(new CardListFrame$addTopCardTransition$2(this));
        this.A = LazyKt.lazy(new CardListFrame$fadeOutTopCardTransition$2(this));
        this.B = LazyKt.lazy(new CardListFrame$removeTopCardTransition$2(this));
    }

    public static final void b(CardListFrame r100) {
        ScrollView r101 = r100.f460834k;
        TopCardContainer r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r101 = null;
    L5:
        TransitionManager.beginDelayedTransition(r101, r100.getRemoveTopCardTransition());
        TopCardContainer r103 = r100.f460839p;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
    L9:
        r102.removeAllViews();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public static final void c(CardListFrame r100) {
        TopCardContainer r101 = r100.f460839p;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r101 = null;
    L6:
        if (r101.getChildCount() == 0) goto L24;
        TopCardContainer r102 = r100.f460839p;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r102 = null;
    L11:
        TopCardContainer r103 = r100.f460839p;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r103 = null;
    L14:
        final View r104 = r102.getChildAt(r103.getChildCount() - 1);
        TopCardContainer r105 = r100.f460839p;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r105 = null;
    L17:
        Iterator r106 = SequencesKt.filter(ViewGroupKt.getChildren(r105), new CardListFrame$settleTopView$1(r104)).iterator();
    L19:
        if (r106.hasNext() == false) goto L28;
        View r107 = (View) r106.next();
        TopCardContainer r108 = r100.f460839p;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r108 = null;
    L23:
        r108.removeView(r107);
        goto L19
    L28:
        return;
    }

    public final void f(UDButton r100) {
        com.larksuite.component.universe_design.button.e.e(r100, UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_close_outlined, UDColorUtils.getColor(getContext(), R.color.icon_n2), new UDDimension.Dp(18)), CardListFrame$initClearButton$1.INSTANCE);
        r100.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        int r102 = (int) new UDDimension.Dp(36).toPixels(getContext());
        r101.width = r102;
        r101.height = r102;
    }

    public final void setOnCardClick(Function1<? super Integer, Unit> r100) {
        this.f460827d = r100;
    }

    public final void setOnCardViewRemoved(Function0<Unit> r100) {
        this.f460830g = r100;
    }

    public final void setOnClearClick(Function0<Unit> r100) {
        this.f460824a = r100;
    }

    public final void setOnEllipsize(Function0<Unit> r100) {
        this.f460826c = r100;
    }

    public final void setOnExpand(Function0<Unit> r100) {
        this.f460825b = r100;
    }

    public final void setOnTopCardClick(Function0<Unit> r100) {
        this.f460828e = r100;
    }

    public final void setOnTopCardMovedOut(Function0<Unit> r100) {
        this.f460829f = r100;
    }

    public CardListFrame(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.card_list_frame, this, true);
        g();
        this.f460840q = (int) new UDDimension.Dp(360).toPixels(getContext());
        this.f460844u = new h(this);
        this.f460845v = new g(this);
        this.f460846w = LazyKt.lazy(new CardListFrame$addTransition$2(this));
        this.f460847x = LazyKt.lazy(new CardListFrame$transition$2(this));
        this.f460848y = LazyKt.lazy(new CardListFrame$removeCardTransition$2(this));
        this.f460849z = LazyKt.lazy(new CardListFrame$addTopCardTransition$2(this));
        this.A = LazyKt.lazy(new CardListFrame$fadeOutTopCardTransition$2(this));
        this.B = LazyKt.lazy(new CardListFrame$removeTopCardTransition$2(this));
    }

    public static final void a(CardListFrame r100, int r101) {
        CardListLayout r102 = r100.f460833j;
        UDButton r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r102 = null;
    L6:
        if (r102.getChildCount() <= 1) goto L38;
        CardListLayout r104 = r100.f460833j;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r104 = null;
    L11:
        if (r104.f460863a == true) goto L38;
        CardListLayout r105 = r100.f460833j;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r105 = null;
    L16:
        if (r105.f460863a == true) goto L44;
        ScrollView r106 = r100.f460834k;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r106 = null;
    L21:
        TransitionManager.beginDelayedTransition(r106, r100.getTransition());
        CardListLayout r107 = r100.f460833j;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r107 = null;
    L24:
        r107.f460863a = true;
        r107.R5();
        r107.T5();
        LinearLayout r108 = r100.f460831h;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
        r108 = null;
    L27:
        r108.setVisibility(0);
        r100.setOnClickListener(new com.suite.lark.platform.component.widget_biz_dinghelper.helper.view.b(r100));
        Function0<Unit> r109 = r100.f460825b;
        if (r109 == null) goto L30;
        r109.invoke();
    L30:
        UDButton r110 = r100.f460837n;
        if (r110 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r110 = null;
    L33:
        r110.setText(R.string.Lark_Meetings_ShowLessCard_Button);
        UDButton r111 = r100.f460838o;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
    L37:
        r103.setText(R.string.Lark_Meetings_ShowLessCard_Button);
        r100.e();
        return;
    L36:
        r103 = r111;
        goto L37
    L44:
        return;
    L38:
        Function1<? super Integer, Unit> r112 = r100.f460827d;
        if (r112 == null) goto L43;
        r112.invoke(Integer.valueOf(r101));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = j08.b.d(getContext(), r102);
        int r105 = j08.b.d(getContext(), r103);
        ScrollView r106 = this.f460834k;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r106 = null;
    L5:
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
        if (r105 >= 480) goto L9;
        r108.width = this.f460840q;
        r108.gravity = 1;
    L12:
        super.onMeasure(r100, r101);
        return;
    L9:
        if (r104 < 600) goto L11;
        r108.width = this.f460840q;
        r108.gravity = 5;
        goto L12
    L11:
        r108.width = -1;
        r108.gravity = 8388659;
        goto L12
    }

    public CardListFrame(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.card_list_frame, this, true);
        g();
        this.f460840q = (int) new UDDimension.Dp(360).toPixels(getContext());
        this.f460844u = new h(this);
        this.f460845v = new g(this);
        this.f460846w = LazyKt.lazy(new CardListFrame$addTransition$2(this));
        this.f460847x = LazyKt.lazy(new CardListFrame$transition$2(this));
        this.f460848y = LazyKt.lazy(new CardListFrame$removeCardTransition$2(this));
        this.f460849z = LazyKt.lazy(new CardListFrame$addTopCardTransition$2(this));
        this.A = LazyKt.lazy(new CardListFrame$fadeOutTopCardTransition$2(this));
        this.B = LazyKt.lazy(new CardListFrame$removeTopCardTransition$2(this));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        CardListLayout r105 = this.f460833j;
        LinearLayout r106 = null;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r105 = null;
    L5:
        int r107 = r105.getHeight();
        ScrollView r108 = this.f460834k;
        if (r108 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r108 = null;
    L9:
        if (r107 <= r108.getHeight()) goto L15;
        LinearLayout r109 = this.f460832i;
        if (r109 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("actionLayoutBottom");
    L14:
        r106.setVisibility(0);
        return;
    L13:
        r106 = r109;
        goto L14
    L15:
        LinearLayout r110 = this.f460832i;
        if (r110 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("actionLayoutBottom");
    L19:
        r106.setVisibility(8);
        return;
    L18:
        r106 = r110;
        goto L19
    }
}
