package com.bytedance.ee.bear.bitable.msgcenter.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitableMsgCenterContainerBinding;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.p;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyView;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001bj\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/msgcenter/view/BitableMsgCenterContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/msgcenter/view/BitableMsgCenterContainerModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableMsgCenterContainerBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableMsgCenterContainerBinding;", "onTabSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnTabSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function1;)V", "mDataMap", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/bitable/msgcenter/view/BitableMsgCardModel;", "Lkotlin/collections/HashMap;", "mFooterModel", "Lcom/bytedance/ee/bear/bitable/msgcenter/view/FooterModel;", "mOldMentionModel", "Lcom/bytedance/ee/bear/bitable/msgcenter/view/OldMentionModel;", "mOnFooterRetry", "Lkotlin/Function0;", "mOnOpenHistory", "delayShowListFlag", "", "setData", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMsgCenterContainer extends FrameLayout implements gv4.b<BitableMsgCenterContainerModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableMsgCenterContainerBinding f214699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Integer, Unit> f214700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, BitableMsgCardModel> f214701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FooterModel f214702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f214703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f214704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f214705g;

    public static final class a extends com.bytedance.ee.bear.bitable.common.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMsgCenterContainer f214706a;

        public a(BitableMsgCenterContainer r100) {
            this.f214706a = r100;
        }

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void b(com.larksuite.component.universe_design.tab.b r100) {
            Intrinsics.checkNotNullParameter(r100, "tab");
            Function1<Integer, Unit> r101 = this.f214706a.getOnTabSelected();
            if (r101 == null) goto L6;
            r101.invoke(Integer.valueOf(r100.f285297f));
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMsgCenterContainer f214707a;

        public b(BitableMsgCenterContainer r100) {
            this.f214707a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BitableMsgCenterContainer r100 = this.f214707a;     // Catch: Throwable -> L4
            r100.f214705g = false;     // Catch: Throwable -> L4
            r100.getBinding().f210955c.getMAdapter().notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements gqa.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMsgCenterContainerModel f214708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ gv4.a f214709b;

        public c(BitableMsgCenterContainerModel r100, gv4.a r101) {
            this.f214708a = r100;
            this.f214709b = r101;
        }

        @Override // gqa.b
        public final void O0(cqa.h r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            FooterModel r101 = this.f214708a.getFooter();
            if (r101 == null) goto L10;
            ActionPayload r102 = r101.getLoadMoreAction();
            if (r102 == null) goto L11;
            gv4.a r103 = this.f214709b;
            if (r103 == null) goto L12;
            r103.a(r102);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public BitableMsgCenterContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableMsgCenterContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final BitableMsgCenterContainerBinding getBinding() {
        return this.f214699a;
    }

    public final Function1<Integer, Unit> getOnTabSelected() {
        return this.f214700b;
    }

    public final void setOnTabSelected(Function1<? super Integer, Unit> r100) {
        this.f214700b = r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(final BitableMsgCenterContainerModel r110, final gv4.a r111) {
        if (r110 == null) goto L80;
        Integer r100 = r110.getCurrentTabIndex();
        int r101 = this.f214699a.f210957e.getSelectPosition();
        if (r100 != null) goto L8;
    L9:
        tt5.a.h("BitableMsgCenterFragment", "update Index. current:" + this.f214699a.f210957e.getSelectPosition() + ". fe:" + r110.getCurrentTabIndex());
        UDTabLayout r102 = this.f214699a.f210957e;
        Integer r103 = r110.getCurrentTabIndex();
        if (r103 == null) goto L12;
        int r104 = r103.intValue();
    L13:
        r102.selectTabAt(r104);
    L14:
        SimpleItemModel r105 = (SimpleItemModel) m.j(r110.getTabs(), 1, null);
        if (r105 == null) goto L21;
        String r106 = r105.getText();
        if (r106 == null) goto L21;
        if (TextUtils.equals(r106, this.f214699a.f210957e.getTabAt(1).f285294c) == true) goto L21;
        this.f214699a.f210957e.getTabAt(1).b(r106);
    L21:
        this.f214700b = new BitableMsgCenterContainer$setData$1$2(r110, this, r111);
        final SmartRefreshLayout r107 = this.f214699a.f210956d;
        if (r107.getState() != RefreshState.Loading) goto L30;
        FooterModel r108 = r110.getFooter();
        if (r108 != null) goto L26;
    L28:
        boolean r109 = false;
    L29:
        if (r109 == false) goto L30;
    L37:
        r107.b(0, false);
    L38:
        FooterModel r112 = r110.getFooter();
        if (r112 != null) goto L41;
    L43:
        boolean r113 = false;
    L44:
        if (r113 == false) goto L53;
        FooterModel r114 = r110.getFooter();
        if (r114 != null) goto L48;
    L50:
        boolean r115 = false;
    L51:
        if (r115 == true) goto L53;
        boolean r116 = true;
    L54:
        r107.g(r116);
        if (r116 == false) goto L57;
        r107.i(new c(r110, r111));
    L57:
        this.f214703e = new BitableMsgCenterContainer$setData$1$3$2(r107, r110, r111);
        this.f214702d = r110.getFooter();
        r110.getOldMentionData();
        OldMentionModel r117 = r110.getOldMentionData();
        if (r117 == null) goto L62;
        final ActionPayload r118 = r117.getOpenOldMention();
        if (r118 == null) goto L62;
        Function0<Unit> r119 = new BitableMsgCenterContainer$setData$1$4$1(r111, r118);
    L63:
        this.f214704f = r119;
        this.f214701c.putAll(r110.getMessageDataMap());
        if (r110.getHasError() == false) goto L66;
        m.z(this.f214699a.f210955c, false);
        m.z(this.f214699a.f210954b, true);
        EmptyView r120 = this.f214699a.f210954b;
        Context r121 = getContext();
        Function1<View, Unit> r122 = new BitableMsgCenterContainer$setData$1$5(r110, r111);
        Lazy r123 = BitableMsgCenterContainerKt.f214710a;
        Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r122, "click");
        EmptyData r124 = new EmptyData();
        Icon r125 = new Icon();
        r125.setImgRes(Integer.valueOf(R.drawable.ccm_empty_negative_load_failed));
        r124.setIcon(r125);
        SpannableStringBuilder r126 = new SpannableStringBuilder();
        String r127 = r121.getString(R.string.Bitable_FeedCenter_Retry_Button);
        String r128 = xo5.a.c(r121, R.string.Bitable_FeedCenter_LoadFailedRetry_Desc, EventConstant.Value.RETRY, r127);
        Intrinsics.checkNotNull(r128);
        int r129 = StringsKt.indexOf$default(r128, r127, 0, false, 6, null);
        int r130 = r127.length() + r129;
        r126.append(r128);
        r126.setSpan(new com.bytedance.ee.bear.bitable.f(r121), 0, r129, 33);
        r126.setSpan(new p(r121, r122), r129, r130, 33);
        r124.setTextEx(r126);
        r124.setGuidelinePercent(Float.valueOf(0.3f));
        r120.a(r124, null);
        return;
    L66:
        List<String> r131 = r110.getRenderList();
        if (r131 != null) goto L69;
    L72:
        boolean r132 = true;
    L73:
        if (r132 == false) goto L75;
        m.z(this.f214699a.f210955c, false);
        m.z(this.f214699a.f210954b, true);
        EmptyView r133 = this.f214699a.f210954b;
        Context r134 = getContext();
        int r135 = this.f214699a.f210957e.getSelectPosition();
        Lazy r136 = BitableMsgCenterContainerKt.f214710a;
        Intrinsics.checkNotNullParameter(r134, PerfLog.PARAM_KEY_CONTEXT_ID);
        EmptyData r137 = new EmptyData();
        Icon r138 = new Icon();
        r138.setImgRes(Integer.valueOf(R.drawable.ccm_empty_positive_im_default));
        r137.setIcon(r138);
        Lazy r139 = BitableMsgCenterContainerKt.f214710a;
        r137.setTitle(r134.getString(((Number) ((Pair) ListProtector.get((List) r139.getValue(), RangesKt.coerceAtMost(r135, 2))).getFirst()).intValue()));
        r137.setText(r134.getString(((Number) ((Pair) ListProtector.get((List) r139.getValue(), RangesKt.coerceAtMost(r135, 2))).getSecond()).intValue()));
        r137.setGuidelinePercent(Float.valueOf(0.3f));
        r133.a(r137, null);
        return;
    L75:
        m.z(this.f214699a.f210955c, true);
        m.z(this.f214699a.f210954b, false);
        BitableMsgCenterList r140 = this.f214699a.f210955c;
        List<String> r141 = r110.getRenderList();
        r140.f214712b = r111;
        BitableMsgCenterList.MsgCenterAdapter r142 = r140.f214711a;
        if (r141 != null) goto L78;
        r141 = new ArrayList();
    L78:
        r142.getClass();
        Intrinsics.checkNotNullParameter(r141, "<set-?>");
        r142.f214719a = r141;
        r140.f214711a.notifyDataSetChanged();
        return;
    L69:
        if (r131.isEmpty() == true) goto L72;
        r132 = false;
    L62:
        r119 = null;
        goto L63
    L48:
        if (r114.isError() != true) goto L50;
        r115 = true;
    L53:
        r116 = false;
        goto L54
    L41:
        if (r112.getHasMore() != true) goto L43;
        r113 = true;
        goto L44
    L26:
        if (r108.isSuccess() != true) goto L28;
        r109 = true;
    L30:
        FooterModel r143 = r110.getFooter();
        if (r143 != null) goto L33;
    L35:
        boolean r144 = false;
    L36:
        if (r144 == false) goto L38;
    L33:
        if (r143.isError() != true) goto L35;
        r144 = true;
        goto L36
    L12:
        r104 = 0;
        goto L13
    L8:
        if (r100.intValue() == r101) goto L14;
    }

    public BitableMsgCenterContainer(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f214701c = new HashMap();
        this.f214705g = true;
        View r113 = LayoutInflater.from(r110).inflate(R.layout.bitable_msg_center_container, this, false);
        addView(r113);
        int r100 = R.id.empty_view;
        EmptyView r101 = (EmptyView) ViewBindings.findChildViewById(r113, R.id.empty_view);
        if (r101 == null) goto L13;
        r100 = R.id.msg_center_list;
        BitableMsgCenterList r102 = (BitableMsgCenterList) ViewBindings.findChildViewById(r113, R.id.msg_center_list);
        if (r102 == null) goto L13;
        r100 = R.id.refresh_layout;
        SmartRefreshLayout r103 = (SmartRefreshLayout) ViewBindings.findChildViewById(r113, R.id.refresh_layout);
        if (r103 == null) goto L13;
        r100 = R.id.ud_tab;
        UDTabLayout r114 = (UDTabLayout) ViewBindings.findChildViewById(r113, R.id.ud_tab);
        if (r114 == null) goto L13;
        this.f214699a = new BitableMsgCenterContainerBinding((LinearLayout) r113, r101, r102, r103, r114);
        r114.getTabAt(1).b(r110.getString(R.string.Bitable_FeedCenter_InBase_UnreadMsg_Tab));
        r114.addOnTabSelectedListener(new a(this));
        LoadMoreFooter r115 = new LoadMoreFooter(r110);
        BearLottieView r116 = r115.getBearLottieView();
        RelativeLayout.LayoutParams r104 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        r104.setMargins(0, n.d(16), 0, 0);
        r104.addRule(14);
        r116.setLayoutParams(r104);
        r116.setAnimation("lottie_loading.json");
        r103.F(r115, n.d(80));
        r103.A = false;
        r103.g(true);
        r102.setGetData(new AnonymousClass3(this));
        r102.setGetFooter(new AnonymousClass4(this));
        postDelayed(new b(this), 300);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r100)));
    }

    public /* synthetic */ BitableMsgCenterContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
