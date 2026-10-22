package com.bytedance.ee.bear.bitable.homepage.chart.widget.chart;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.homepage.chart.ChartType;
import com.bytedance.ee.bear.bitable.homepage.chart.container.JSContextTag;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.BaseChartEntity;
import com.bytedance.ee.bear.bitable.homepage.chart.n;
import com.bytedance.ee.bear.bitable.homepage.chart.s;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ks4.j;
import ks4.k;

/* JADX INFO: loaded from: classes15.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u00013\b\u0007\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u0002:\b\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010U\u001a\u00020MH\u0002J\u0010\u0010V\u001a\u0002082\u0006\u0010=\u001a\u00020>H\u0002J\u001c\u0010W\u001a\u00020M2\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Z\u0018\u00010JJ\u000e\u0010[\u001a\u00020M2\u0006\u0010\\\u001a\u00020]J\u000e\u0010^\u001a\u00020M2\u0006\u00100\u001a\u000201J\u0006\u0010e\u001a\u00020fJ\u000e\u0010g\u001a\u00020M2\u0006\u0010h\u001a\u00020/J\u0006\u0010i\u001a\u00020MJ\u0006\u0010j\u001a\u00020MJ \u0010k\u001a\u00020M2\u0006\u0010l\u001a\u00020m2\b\u0010n\u001a\u0004\u0018\u00010o2\u0006\u0010T\u001a\u00020<J\u000e\u0010p\u001a\u00020M2\u0006\u0010+\u001a\u00020*J\b\u0010q\u001a\u00020MH\u0002J\u0018\u0010r\u001a\u00020M2\u0006\u0010s\u001a\u00020\b2\u0006\u0010t\u001a\u00020\bH\u0014J\b\u0010u\u001a\u00020MH\u0002J\b\u0010v\u001a\u00020MH\u0002J\b\u0010w\u001a\u00020MH\u0002J\b\u0010x\u001a\u00020MH\u0002J\b\u0010y\u001a\u00020MH\u0002J&\u0010z\u001a\u00020M2\u000e\u0010{\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0|2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020M0~H\u0002J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J\u0018\u0010\u0081\u0001\u001a\u00020M2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020M0~H\u0002J\t\u0010\u0083\u0001\u001a\u00020MH\u0002R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001e\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b(\u0010)R\u001e\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020*@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR7\u0010I\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b('\u0012\u0004\u0012\u00020M\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d¨\u0006\u0088\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hpChartErrorContainerFromXml", "getHpChartErrorContainerFromXml", "()Landroid/widget/FrameLayout;", "setHpChartErrorContainerFromXml", "(Landroid/widget/FrameLayout;)V", "hpChartLynxContainerFromXml", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/LynxUIContainer;", "getHpChartLynxContainerFromXml", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/LynxUIContainer;", "setHpChartLynxContainerFromXml", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/LynxUIContainer;)V", "hpChartLoadingContainerFromXml", "Landroid/widget/LinearLayout;", "getHpChartLoadingContainerFromXml", "()Landroid/widget/LinearLayout;", "setHpChartLoadingContainerFromXml", "(Landroid/widget/LinearLayout;)V", "hpChartLoadingIconFromXml", "Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;", "getHpChartLoadingIconFromXml", "()Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;", "setHpChartLoadingIconFromXml", "(Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;)V", "hpChartErrorIconFromXml", "getHpChartErrorIconFromXml", "setHpChartErrorIconFromXml", "value", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView$State;", "state", "setState", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView$State;)V", "Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartType;", "chartType", "setChartType", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartType;)V", "measureHeightStrategy", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView$MeasureHeightStrategy;", "chartStyle", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView$ChartStyle;", "destroyEventObserver", "com/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView$destroyEventObserver$1", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView$destroyEventObserver$1;", "retryButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "lynxContainer", "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/ChartLynxContainer;", "renderStrategyDecider", "Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/RenderStrategyDecider;", "renderingChartToken", "", "lynxContainerProvider", "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/IChartLynxContainerProvider;", "getLynxContainerProvider", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/container/IChartLynxContainerProvider;", "setLynxContainerProvider", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/container/IChartLynxContainerProvider;)V", "tagForJsContext", "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/JSContextTag;", "getTagForJsContext", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/container/JSContextTag;", "setTagForJsContext", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/container/JSContextTag;)V", "onStateChangeListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnStateChangeListener", "()Lkotlin/jvm/functions/Function1;", "setOnStateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "loadStartTimestamp", "", "scene", "initView", "generateChartLynxContainer", "bindOnRetryClickListener", "listener", "Landroid/view/View;", "", "bindLifecycleOwner", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "bindChartStyle", "forceUseTemplateData", "", "getForceUseTemplateData", "()[B", "setForceUseTemplateData", "([B)V", "getBizDataContainer", "Lcom/bytedance/ee/bear/bitable/homepage/chart/container/IChartLynxBizDataContainer;", "updateMeasureHeightStrategy", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "preventTouchEventDispatchToLynxView", "allowTouchEventDispatchToLynxView", ChameleonOpenTracker.Stage.RENDER, "chart", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/BaseChartEntity;", "chartData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageChartData;", "updateChartType", "onChartTypeChanged", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onStateChanged", "hideAllContainers", DyPayConstant.KEY_SHOW_LOADING, "showError", "showLoaded", "requireState", "expectClass", "Ljava/lang/Class;", "match", "Lkotlin/Function0;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "runOnUIThread", "action", LiveCommonConstants.REASON_ON_DEDTROY, "MeasureHeightStrategy", "ChartStyle", "State", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartItemView extends com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.d implements d0c.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Set<Integer> f212650v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f212651w = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f212652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LynxUIContainer f212653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f212654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UDEmptyState f212655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDEmptyState f212656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f212657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ChartType f212658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MeasureHeightStrategy f212659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ChartStyle f212660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ChartItemView$destroyEventObserver$1 f212661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public UDButton f212662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ks4.b f212663m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RenderStrategyDecider f212664n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f212665o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Inject
    public k f212666p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public JSContextTag f212667q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super c, Unit> f212668r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f212669s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f212670t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte[] f212671u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView$ChartStyle;", "", "<init>", "(Ljava/lang/String;I)V", "CARD", "PAGE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChartStyle extends Enum<ChartStyle> {
        public static final ChartStyle CARD = null;
        public static final ChartStyle PAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChartStyle[] f212672a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f212673b = null;

        public static EnumEntries<ChartStyle> getEntries() {
            return f212673b;
        }

        static {
            ChartStyle r100 = new ChartStyle("CARD", 0);
            CARD = r100;
            ChartStyle r101 = new ChartStyle("PAGE", 1);
            PAGE = r101;
            ChartStyle[] r102 = {r100, r101};
            f212672a = r102;
            f212673b = EnumEntriesKt.enumEntries(r102);
        }

        public static ChartStyle[] values() {
            return (ChartStyle[]) f212672a.clone();
        }

        public static ChartStyle valueOf(String r100) {
            return (ChartStyle) r27.a.a(ChartStyle.class, r100);
        }

        public ChartStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/widget/chart/ChartItemView$MeasureHeightStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "BY_CHART_TYPE", "BY_SYSTEM", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MeasureHeightStrategy extends Enum<MeasureHeightStrategy> {
        public static final MeasureHeightStrategy BY_CHART_TYPE = null;
        public static final MeasureHeightStrategy BY_SYSTEM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MeasureHeightStrategy[] f212674a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f212675b = null;

        public static EnumEntries<MeasureHeightStrategy> getEntries() {
            return f212675b;
        }

        static {
            MeasureHeightStrategy r100 = new MeasureHeightStrategy("BY_CHART_TYPE", 0);
            BY_CHART_TYPE = r100;
            MeasureHeightStrategy r101 = new MeasureHeightStrategy("BY_SYSTEM", 1);
            BY_SYSTEM = r101;
            MeasureHeightStrategy[] r102 = {r100, r101};
            f212674a = r102;
            f212675b = EnumEntriesKt.enumEntries(r102);
        }

        public static MeasureHeightStrategy[] values() {
            return (MeasureHeightStrategy[]) f212674a.clone();
        }

        public static MeasureHeightStrategy valueOf(String r100) {
            return (MeasureHeightStrategy) r27.a.a(MeasureHeightStrategy.class, r100);
        }

        public MeasureHeightStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            LarkAppContext.a r101 = LarkAppContext.Companion;
            r101.getClass();
            if (DevEnvUtil.isDebugMode(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L9;
            r101.getClass();
            if (DevEnvUtil.isDevelopPackage(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L9;
            tt5.a.e("ChartItemView", "ChartItemView must bind an lifecycle owner", new RuntimeException("ChartItemView must bind an lifecycle owner"), false);
            return;
        L9:
            throw new RuntimeException("ChartItemView must bind an lifecycle owner");
        }
    }

    public static final class b {
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f212676a;

        public static final class a extends c {
            public a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                super(r100);
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f212677b = null;

            static {
                f212677b = new b();
            }

            public b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView$c$c, reason: collision with other inner class name */
        public static final class C3049c extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C3049c f212678b = null;

            static {
                f212678b = new C3049c();
            }

            public C3049c() {
                super(null);
            }
        }

        public /* synthetic */ c() {
            this(null);
        }

        public c(String r100) {
            this.f212676a = r100;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f212679a = null;

        static {
            int[] r100 = new int[ChartStyle.values().length];
            r100[ChartStyle.CARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ChartStyle.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f212679a = r100;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f212681a;

        public e(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f212681a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f212681a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ChartItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChartItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public /* bridge */ /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    static {
        f212650v = SetsKt.setOf(new Integer[]{102, 601, 102, 104, 106, 1201, 12002});
        f212651w = new a();
    }

    public final void g() {
        c r100 = this.f212657g;
        if ((r100 instanceof c.C3049c) == false) goto L6;
        i(c.C3049c.class, new ChartItemView$showLoading$1(this));
    L11:
        Function1<? super c, Unit> r101 = this.f212668r;
        if (r101 == null) goto L17;
        r101.invoke(this.f212657g);
        return;
    L17:
        return;
    L6:
        if ((r100 instanceof c.b) == false) goto L9;
        i(c.b.class, new ChartItemView$showLoaded$1(this));
        goto L11
    L9:
        if ((r100 instanceof c.a) == false) goto L16;
        i(c.a.class, new ChartItemView$showError$1(this));
        goto L11
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final FrameLayout getHpChartErrorContainerFromXml() {
        KeyEvent.Callback r100 = this.f212652b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.hp_chart_error_container);
        this.f212652b = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final UDEmptyState getHpChartErrorIconFromXml() {
        KeyEvent.Callback r100 = this.f212656f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.hp_chart_error_icon);
        this.f212656f = (UDEmptyState) r100;
    L6:
        return (UDEmptyState) r100;
    }

    public final LinearLayout getHpChartLoadingContainerFromXml() {
        KeyEvent.Callback r100 = this.f212654d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.hp_chart_loading_container);
        this.f212654d = (LinearLayout) r100;
    L6:
        return (LinearLayout) r100;
    }

    public final UDEmptyState getHpChartLoadingIconFromXml() {
        KeyEvent.Callback r100 = this.f212655e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.hp_chart_loading_icon);
        this.f212655e = (UDEmptyState) r100;
    L6:
        return (UDEmptyState) r100;
    }

    public final LynxUIContainer getHpChartLynxContainerFromXml() {
        KeyEvent.Callback r100 = this.f212653c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.hp_chart_lynx_container);
        this.f212653c = (LynxUIContainer) r100;
    L6:
        return (LynxUIContainer) r100;
    }

    public final k getLynxContainerProvider() {
        k r100 = this.f212666p;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("lynxContainerProvider");
        return null;
    }

    @Override // d0c.c
    public final UserSession e9() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.a().z4();
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public final j getBizDataContainer() {
        return this.f212663m;
    }

    public final byte[] getForceUseTemplateData() {
        return this.f212671u;
    }

    public final Function1<c, Unit> getOnStateChangeListener() {
        return this.f212668r;
    }

    public final JSContextTag getTagForJsContext() {
        return this.f212667q;
    }

    public static final void b(ChartItemView r100) {
        r100.getHpChartLoadingContainerFromXml().setVisibility(8);
        r100.getHpChartErrorContainerFromXml().setVisibility(8);
        r100.getHpChartLynxContainerFromXml().setVisibility(4);
    }

    private final void setChartType(ChartType r100) {
        if (this.f212658h != r100) goto L5;
        return;
    L5:
        this.f212658h = r100;
        getHpChartLoadingIconFromXml().setImageRes(Integer.valueOf(this.f212658h.getLoadingRes()));
    }

    private final void setState(c r100) {
        if (Intrinsics.areEqual(this.f212657g, r100) == false) goto L5;
        return;
    L5:
        this.f212657g = r100;
        g();
    }

    public final void e(ChartStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "chartStyle");
        ChartStyle r101 = this.f212660j;
        if (r101 == null) goto L8;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("chartStyle");
        r101 = null;
    L6:
        if (r101 != r100) goto L8;
        return;
    L8:
        this.f212660j = r100;
        int r102 = d.f212679a[r100.ordinal()];
        if (r102 != 1) goto L11;
        int r103 = (int) new UDDimension.Dp(8).toPixels(getContext());
        int r104 = (int) new UDDimension.Dp(4).toPixels(getContext());
        int r105 = (int) new UDDimension.Dp(20).toPixels(getContext());
        float r106 = 60.0f;
    L16:
        UDButton r107 = this.f212662l;
        if (r107 == null) goto L19;
        r107.setPadding(r103, r104, r103, r104);
    L19:
        LinearLayout r108 = getHpChartLoadingContainerFromXml();
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L28;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        r110.bottomMargin = r105;
        r108.setLayoutParams(r110);
        FrameLayout r111 = getHpChartErrorContainerFromXml();
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L26;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        r113.bottomMargin = r105;
        r111.setLayoutParams(r113);
        getHpChartLoadingIconFromXml().setImageSize(Float.valueOf(r106));
        getHpChartErrorIconFromXml().setImageSize(Float.valueOf(r106));
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        if (r102 != 2) goto L14;
        r103 = (int) new UDDimension.Dp(16).toPixels(getContext());
        r104 = (int) new UDDimension.Dp(8).toPixels(getContext());
        r105 = 0;
        r106 = 100.0f;
        goto L16
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void f(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        r100.getLifecycle().removeObserver(this.f212661k);
        r100.getLifecycle().addObserver(this.f212661k);
        removeOnAttachStateChangeListener(f212651w);
    }

    public final void j(ChartType r100) {
        Intrinsics.checkNotNullParameter(r100, "chartType");
        if (this.f212659i == MeasureHeightStrategy.BY_CHART_TYPE) goto L5;
    L7:
        setChartType(r100);
        return;
    L5:
        if (this.f212658h.calculateHeightPx() == r100.calculateHeightPx()) goto L7;
        requestLayout();
        goto L7
    }

    public final void setForceUseTemplateData(byte[] r100) {
        this.f212671u = r100;
    }

    public final void setHpChartErrorContainerFromXml(FrameLayout r100) {
        this.f212652b = r100;
    }

    public final void setHpChartErrorIconFromXml(UDEmptyState r100) {
        this.f212656f = r100;
    }

    public final void setHpChartLoadingContainerFromXml(LinearLayout r100) {
        this.f212654d = r100;
    }

    public final void setHpChartLoadingIconFromXml(UDEmptyState r100) {
        this.f212655e = r100;
    }

    public final void setHpChartLynxContainerFromXml(LynxUIContainer r100) {
        this.f212653c = r100;
    }

    public final void setLynxContainerProvider(k r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f212666p = r100;
    }

    public final void setOnStateChangeListener(Function1<? super c, Unit> r100) {
        this.f212668r = r100;
    }

    public final void setTagForJsContext(JSContextTag r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f212667q = r100;
    }

    public static final void c(ChartItemView r100, Function0 r101) {
        r100.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r101.invoke();
        return;
    L5:
        CoreThreadPool.getDefault().getUIExecutor().execute(new e(r101));
    }

    public static final /* synthetic */ void d(ChartItemView r100, c r101) {
        r100.setState(r101);
    }

    public final void i(Class<? extends c> r100, Function0<Unit> r101) {
        if (r100.isAssignableFrom(this.f212657g.getClass()) == true) goto L11;
        String r102 = "Expected state " + r100 + ", but actual state is " + this.f212657g;
        LarkAppContext.Companion.getClass();
        if (DevEnvUtil.isDebugMode(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L10;
        if (DevEnvUtil.isDevelopPackage(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L10;
        tt5.a.e("ChartItemView", r102, new IllegalStateException(r102), false);
        return;
    L10:
        throw new IllegalStateException(r102);
    L11:
        r101.invoke();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f212659i != MeasureHeightStrategy.BY_CHART_TYPE) goto L5;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.f212658h.calculateHeightPx(), 1073741824));
        return;
    L5:
        super.onMeasure(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView$generateChartLynxContainer$lynxContainer$1] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView$generateChartLynxContainer$lynxContainer$2] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.ChartItemView$destroyEventObserver$1] */
    public ChartItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f212657g = c.C3049c.f212678b;
        this.f212658h = ChartType.UNKNOWN;
        this.f212659i = MeasureHeightStrategy.BY_CHART_TYPE;
        this.f212661k = new ChartItemView$destroyEventObserver$1(this);
        this.f212667q = JSContextTag.TAG_FOR_JS_CONTEXT_HOME;
        View.inflate(r100, R.layout.bitable_homepage_chart_item, this);
        setBackgroundResource(R.drawable.bitable_homepage_add_chart_item_bg);
        k r103 = getLynxContainerProvider();
        ChartItemView$generateChartLynxContainer$hideLoadingHandler$1 r104 = new ChartItemView$generateChartLynxContainer$hideLoadingHandler$1(this);
        ks4.b r105 = r103.a(getContext(), new ChartItemView$generateChartLynxContainer$lynxContainer$1(this), MapsKt.mapOf(TuplesKt.to(r104.f212682b.getName(), r104)), this.f212667q, new ChartItemView$generateChartLynxContainer$lynxContainer$2(this));
        getHpChartLynxContainerFromXml().addView(r105.getLynxView(), new ViewGroup.LayoutParams(-1, -1));
        this.f212663m = r105;
        this.f212664n = new RenderStrategyDecider(r105);
        addOnAttachStateChangeListener(f212651w);
        UDButton r106 = (UDButton) getHpChartErrorContainerFromXml().findViewById(R.id.btnSecondary);
        this.f212662l = r106;
        if (r106 == null) goto L9;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L8;
        r107.height = -2;
        r106.setLayoutParams(r107);
        r106.setTextColor(getContext().getResources().getColor(R.color.text_title));
        Drawable r108 = UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_refresh_outlined, new UDDimension.Dp(16));
        r108.setTint(getContext().getResources().getColor(R.color.ud_N900));
        com.larksuite.component.universe_design.button.e.e(r106, r108, ChartItemView$initView$1$2.INSTANCE);
        r106.setCornerRadius((int) new UDDimension.Dp(8).toPixels(getContext()));
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L9:
        addOnLayoutChangeListener(new com.bytedance.ee.bear.bitable.homepage.chart.widget.chart.b(this));
        e(ChartStyle.CARD);
        g();
        getHpChartLoadingIconFromXml().setImageRes(Integer.valueOf(this.f212658h.getLoadingRes()));
    }

    public final void h(BaseChartEntity r100, rs4.d r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "chart");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f212665o = r100.getChartToken();
        boolean r103 = true;
        if (r101 != null) goto L5;
    L10:
        this.f212670t = r102;
        RenderStrategyDecider r104 = this.f212664n;
        byte[] r105 = this.f212671u;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "chart");
        Intrinsics.checkNotNullParameter(r102, "scene");
        RenderStrategyDecider.a r106 = new RenderStrategyDecider.a(r100, r101, r102, r105);
        if (r106.f212695d == null) goto L13;
        RenderStrategyDecider.RenderStrategy r107 = RenderStrategyDecider.RenderStrategy.PLAYGROUND_RENDER;
    L47:
        r107.render(r104.f212687a, r106);
        r104.f212688b = r106;
        tt5.a.h("RenderStrategyDecider", "chart token: " + du5.b.i(r100.getChartToken()) + ", render strategy: " + r107);
        if (r107.isFullUpdate() == false) goto L54;
        setState(c.C3049c.f212678b);
        if (this.f212669s <= 0) goto L52;
        int r108 = n.f212600a;
        n.d(this.f212670t, "cancel", System.currentTimeMillis() - this.f212669s);
        this.f212669s = 0;
    L52:
        this.f212669s = System.currentTimeMillis();
        int r109 = n.f212600a;
        CoreThreadPool.getBackgroundHandler().post(new s(this.f212670t));
        return;
    L54:
        return;
    L13:
        rs4.d r110 = r106.f212693b;
        if (r110 != null) goto L16;
    L21:
        RenderStrategyDecider.a r111 = r104.f212688b;
        String r112 = null;
        if (r110 != null) goto L24;
        if (r111 == null) goto L36;
        rs4.d r113 = r111.f212693b;
    L37:
        if (r113 == null) goto L40;
        r107 = RenderStrategyDecider.RenderStrategy.WAIT_NEXT;
    L40:
        if (r104.f212689c.get() == false) goto L46;
        if (r111 == null) goto L44;
        r112 = r111.f212694c;
    L44:
        if (Intrinsics.areEqual(r112, r106.f212694c) == true) goto L46;
        r107 = RenderStrategyDecider.RenderStrategy.UPDATE_DATA;
    L46:
        r107 = RenderStrategyDecider.RenderStrategy.SKIP;
        goto L47
    L36:
        r113 = null;
        goto L37
    L24:
        if (r104.f212689c.get() == true) goto L26;
        r107 = RenderStrategyDecider.RenderStrategy.RENDER;
        goto L47
    L26:
        if (r111 == null) goto L28;
        rs4.d r114 = r111.f212693b;
    L29:
        if (r114 != null) goto L32;
        r107 = RenderStrategyDecider.RenderStrategy.RELOAD;
        goto L47
    L32:
        if (Intrinsics.areEqual(r111.f212692a.getChartToken(), r106.f212692a.getChartToken()) == true) goto L40;
        r107 = RenderStrategyDecider.RenderStrategy.RELOAD;
        goto L47
    L28:
        r114 = null;
        goto L29
    L16:
        if (r110.f539106a != null) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L21;
        r107 = RenderStrategyDecider.RenderStrategy.SKIP;
        goto L47
    L5:
        if (r101.f539106a == null) goto L7;
        boolean r115 = true;
    L8:
        if (r115 == true) goto L10;
        setState(new c.a("chart data error"));
        goto L10
    L7:
        r115 = false;
        goto L8
    }

    public /* synthetic */ ChartItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
