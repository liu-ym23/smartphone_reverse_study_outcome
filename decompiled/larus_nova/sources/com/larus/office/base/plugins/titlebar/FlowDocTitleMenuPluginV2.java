package com.larus.office.base.plugins.titlebar;

import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.larus.office.base.service.BizMenuData;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginId;
import com.ss.android.lark.chameleon.util.JsonUtils;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004/012B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u00132\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\"H\u0016J\u0012\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u00063"}, d2 = {"Lcom/larus/office/base/plugins/titlebar/FlowDocTitleMenuPluginV2;", "Lcom/larus/office/base/plugins/titlebar/NestScrollTitlePlugin;", "Lcom/larus/office/base/service/ITitleStateChangeListener;", "Lcom/larus/office/base/page/INavigationListener;", "isSupportNestedScroll", "", "<init>", "(Z)V", "titleData", "Lcom/larus/office/base/plugins/titlebar/TitleData;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getPluginId", "", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onLoadingEnd", "isPartialEdit", "onTitleClicked", "onLoadingStart", "onAiThinkingStateChanged", "state", "", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onBackPressed", "docContainerFragment", "Landroidx/fragment/app/Fragment;", "onCustomHeaderPaddingChanged", "paddingLeft", "paddingRight", "changeNavigationNestedScrollState", "setTitleBarVisible", "isVisible", "disablePaddingTop", "shouldEnableNestScroll", "Companion", "TitleMenuHandler", "SetTitleHandler", "OpenFloatChatHandler", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDocTitleMenuPluginV2 extends NestScrollTitlePlugin implements com.larus.office.base.service.c, vm9.d {
    private static final String BIZ_NAVIGATION_OPEN_CHAT = "biz.navigation.openFloatChat";
    private static final String BIZ_NAVIGATION_SET_MENU = "flow_biz.navigation.setMenu";
    private static final String BIZ_NAVIGATION_SET_TITLE = "flow_biz.navigation.setTitle";
    public static final a Companion = null;
    private static final String FUNC_MORE_OPERATION = "javascript:window.flow.biz.navigation.moreOperation";
    private static final String JSB_TAG = "OfficeJSB";
    private static final String JS_MSG_LOADING_END = "javascript:window.flow.biz.util.messageLoadingEnd";
    private static final String JS_MSG_LOADING_START = "javascript:window.flow.biz.util.messageLoadingStart";
    private static final String JS_NOTIFY_AI_EDIT_STATE_CHANGE = "javascript:window.flow.biz.util.notifyAIEditStateChange";
    private static final String JS_NOTIFY_AI_MESSAGE_END = "javascript:window.flow.biz.util.notifyAiMessageEnd";
    private static final String JS_TITLE_CLICKED = "javascript:window.flow.biz.navigation.titleClickHandler";
    private static final String TAG = "TitleMenuPlugin";
    private final Lazy gson$delegate;
    private boolean isSupportNestedScroll;
    private TitleData titleData;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowDocTitleMenuPluginV2 f360773a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(FlowDocTitleMenuPluginV2 r100) {
            this.f360773a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            FLogger r103 = FLogger.f375446a;
            r103.i(FlowDocTitleMenuPluginV2.TAG, "Got open float chat event");
            StringBuilder r104 = new StringBuilder("FE->Native biz.navigation.openFloatChat source=FlowDocTitleMenuPluginV2 hasCallback=");
            if (r101 == null) goto L5;
            boolean r105 = true;
        L6:
            r104.append(r105);
            r103.i(FlowDocTitleMenuPluginV2.JSB_TAG, r104.toString());
            ChameleonPluginHost r106 = this.f360773a.getHost();
            if (r106 == null) goto L10;
            String r107 = x.a(r106);
            if (r107 == null) goto L10;
        L11:
            Lazy r108 = com.larus.office.base.service.m.f361113a;
            com.larus.office.base.service.m.c(r107).f();
            return;
        L10:
            r107 = "";
            goto L11
        L5:
            r105 = false;
            goto L6
        }
    }

    public final class c implements i<TitleData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowDocTitleMenuPluginV2 f360774a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(FlowDocTitleMenuPluginV2 r100) {
            this.f360774a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            TitleData r102 = (TitleData) r100;
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("handleSetTitle: ");
            String r105 = null;
            if (r102 == null) goto L5;
            Integer r106 = r102.getDisplayTitleType();
        L6:
            r104.append(r106);
            r103.i(FlowDocTitleMenuPluginV2.TAG, r104.toString());
            ChameleonPluginHost r107 = this.f360774a.getHost();
            if (r107 == null) goto L10;
            String r108 = x.a(r107);
            if (r108 == null) goto L10;
        L11:
            FlowDocTitleMenuPluginV2.access$setTitleData$p(this.f360774a, r102);
            Lazy r109 = com.larus.office.base.service.m.f361113a;
            com.larus.office.base.service.b r110 = com.larus.office.base.service.m.c(r108);
            if (r102 == null) goto L14;
            Integer r111 = r102.getDisplayTitleType();
        L15:
            if (r102 == null) goto L17;
            String r112 = r102.getTitle();
        L18:
            if (r102 == null) goto L20;
            String r113 = r102.getSubTitle();
        L21:
            if (r102 == null) goto L23;
            r105 = r102.getName();
        L23:
            r110.a(r111, r112, r113, r105);
            return;
        L20:
            r113 = null;
            goto L21
        L17:
            r112 = null;
            goto L18
        L14:
            r111 = null;
        L10:
            r108 = "";
            goto L11
        L5:
            r106 = null;
            goto L6
        }
    }

    public final class d implements i<MenuData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowDocTitleMenuPluginV2 f360775a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public d(FlowDocTitleMenuPluginV2 r100) {
            this.f360775a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.office.base.plugins.titlebar.c] */
        /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.office.base.plugins.titlebar.d] */
        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            MenuData r102 = (MenuData) r100;
            if (r102 == null) goto L16;
            final FlowDocTitleMenuPluginV2 r103 = this.f360775a;     // Catch: Exception -> L11
            ChameleonPluginHost r104 = r103.getHost();     // Catch: Exception -> L11
            if (r104 == null) goto L8;
            String r105 = x.a(r104);     // Catch: Exception -> L11
            if (r105 == null) goto L8;
        L9:
            String r106 = JsonUtils.INSTANCE.toJsonString(r102);     // Catch: Exception -> L11
            Lazy r107 = com.larus.office.base.service.m.f361113a;     // Catch: Exception -> L11
            com.larus.office.base.service.m.c(r105).e((BizMenuData) FlowDocTitleMenuPluginV2.access$getGson(r103).fromJson(r106, BizMenuData.class), new com.larus.office.base.plugins.titlebar.c(r103), new com.larus.office.base.plugins.titlebar.d(r103));     // Catch: Exception -> L11
            return;
        L8:
            r105 = "";
        L11:
            e = move-exception;
            FLogger.f375446a.e(FlowDocTitleMenuPluginV2.TAG, "handleMenuData failed: " + e.getMessage());
            return;
        }
    }

    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f360776a;

        public e(com.larus.office.base.plugins.titlebar.a r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f360776a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f360776a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f360776a.invoke(r100);
        }
    }

    static {
        Companion = new a();
    }

    public FlowDocTitleMenuPluginV2() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ Gson e() {
        return gson_delegate$lambda$0();
    }

    public static /* synthetic */ Unit f(Boolean r100) {
        return onAttachToUIContainer$lambda$1(r100);
    }

    @Override // com.larus.office.base.plugins.titlebar.NestScrollTitlePlugin, com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    private static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public String getPluginId() {
        return ChameleonPluginId.TitleBarPlugin.getValue();
    }

    @Override // com.larus.office.base.service.c
    public void onLoadingStart() {
        FLogger r100 = FLogger.f375446a;
        r100.i(TAG, "On message loading start");
        r100.i(JSB_TAG, "Native->FE biz.util.messageLoadingStart source=FlowDocTitleMenuPluginV2");
        SafeJSExecutor.execJS(getHost().getWeb().getWebView(), JS_MSG_LOADING_START, new JsonObject());
        updateNestScroll();
    }

    @Override // com.larus.office.base.service.c
    public void onTitleClicked() {
        FLogger.f375446a.i(TAG, "On title clicked");
        if (this.titleData != null) goto L5;
        JsonObject r100 = new JsonObject();
    L6:
        SafeJSExecutor.execJS(getHost().getWeb().getWebView(), JS_TITLE_CLICKED, r100);
        return;
    L5:
        String r101 = GsonProtectorUtils.toJson(getGson(), this.titleData);
        r100 = (JsonObject) GsonProtectorUtils.fromJson(getGson(), r101, JsonObject.class);
        goto L6
    }

    @Override // com.larus.office.base.plugins.titlebar.NestScrollTitlePlugin
    public boolean shouldEnableNestScroll() {
        return this.isSupportNestedScroll;
    }

    public FlowDocTitleMenuPluginV2(boolean r100) {
        this.isSupportNestedScroll = r100;
        this.gson$delegate = LazyKt.lazy(new com.larus.office.base.plugins.titlebar.b());
    }

    public static final /* synthetic */ Gson access$getGson(FlowDocTitleMenuPluginV2 r100) {
        return r100.getGson();
    }

    private static final Unit onAttachToUIContainer$lambda$1(Boolean r100) {
        com.larus.office.base.service.b r101 = com.larus.office.base.service.m.d();
        Intrinsics.checkNotNull(r100);
        r101.c(r100.booleanValue());
        return Unit.INSTANCE;
    }

    @Override // vm9.d
    public void changeNavigationNestedScrollState(boolean r100) {
        this.isSupportNestedScroll = r100;
        updateNestScroll();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_NAVIGATION_SET_MENU, new d(this));
        r100.put(BIZ_NAVIGATION_SET_TITLE, new c(this));
        r100.put(BIZ_NAVIGATION_OPEN_CHAT, new b(this));
    }

    @Override // com.larus.office.base.service.c
    public void onAiThinkingStateChanged(int r100) {
        FLogger.f375446a.i(JSB_TAG, "Native->FE biz.util.notifyAIEditStateChange source=FlowDocTitleMenuPluginV2 state=" + r100);
        WebView r101 = getHost().getWeb().getWebView();
        JsonObject r102 = new JsonObject();
        r102.addProperty("state", Integer.valueOf(r100));
        Unit r103 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r101, JS_NOTIFY_AI_EDIT_STATE_CHANGE, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vm9.d
    public boolean onBackPressed(Fragment r100) {
        if ((r100 instanceof sa5.d) == true) goto L5;
        return false;
    L5:
        if (((sa5.d) r100).onBackPressed() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.larus.office.base.service.c
    public void onLoadingEnd(boolean r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i(TAG, "On message loading end, is_partial_edit = " + r100);
        r101.i(JSB_TAG, "Native->FE biz.util.messageLoadingEnd source=FlowDocTitleMenuPluginV2 isPartialEdit=" + r100);
        WebView r102 = getHost().getWeb().getWebView();
        JsonObject r103 = new JsonObject();
        r103.addProperty("is_partial_edit", Boolean.valueOf(r100));
        Unit r104 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r102, JS_MSG_LOADING_END, r103);
        r101.i(JSB_TAG, "Native->FE biz.util.notifyAiMessageEnd source=FlowDocTitleMenuPluginV2 reason=legacy_loading_end");
        SafeJSExecutor.execJS(getHost().getWeb().getWebView(), JS_NOTIFY_AI_MESSAGE_END, new JsonObject());
        updateNestScroll();
    }

    public static final /* synthetic */ void access$setTitleData$p(FlowDocTitleMenuPluginV2 r100, TitleData r101) {
        r100.titleData = r101;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.office.base.plugins.titlebar.a] */
    @Override // com.larus.office.base.plugins.titlebar.NestScrollTitlePlugin
    public void onAttachToUIContainer(ChameleonPluginHost r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiContainer");
        super.onAttachToUIContainer(r100, r101);
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        String r102 = x.a(r100);
        Lazy r103 = com.larus.office.base.service.m.f361113a;
        com.larus.office.base.service.m.g(this, r102);
        com.larus.office.base.service.m.f(this, r102);
        ((vz4.e) r100.getHostAbility(vz4.e.class)).getCustomHeaderState().observe(r100.getFragment().getViewLifecycleOwner(), new e(new com.larus.office.base.plugins.titlebar.a()));
    }

    @Override // vm9.d
    public void onCustomHeaderPaddingChanged(int r100, int r101) {
        ((vz4.e) getHost().getHostAbility(vz4.e.class)).setPadding(r100, r101);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        if (r101 == null) goto L7;
        View r102 = r101.getContentView();
        if (r102 == null) goto L7;
        FrameLayout r103 = (FrameLayout) r102.findViewById(R.id.cml_title_layout);
    L8:
        if (r103 == null) goto L10;
        r103.removeAllViews();
    L10:
        if (r100 == null) goto L12;
        String r104 = x.a(r100);
    L13:
        Lazy r105 = com.larus.office.base.service.m.f361113a;
        if (r104 != null) goto L16;
        String r106 = "";
    L17:
        com.larus.office.base.service.m.g(null, r106);
        if (r104 != null) goto L20;
        r104 = "";
    L20:
        com.larus.office.base.service.m.f(null, r104);
        return;
    L16:
        r106 = r104;
        goto L17
    L12:
        r104 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // vm9.d
    public void setTitleBarVisible(boolean r100, boolean r101) {
        updateTitleBarVisibility(r100, r101);
    }

    @Override // com.larus.office.base.plugins.titlebar.NestScrollTitlePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }

    public /* synthetic */ FlowDocTitleMenuPluginV2(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
