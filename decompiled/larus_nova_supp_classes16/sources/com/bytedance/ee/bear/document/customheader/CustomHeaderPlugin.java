package com.bytedance.ee.bear.document.customheader;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl;
import com.bytedance.ee.bear.document.DocActivity;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larksuite.framework.utils.KeyboardUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u00049:;<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016J\u001c\u0010\"\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\"\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\nH\u0002J\b\u00100\u001a\u00020\u0015H\u0002J\u0010\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\nH\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\n04H\u0016J\u0018\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/CustomHeaderPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/ability/CustomHeaderAbility;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderViewModel;", "callBackFunction", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "isFromVc", "", "isFromBase", "vcFollowTitleBarStateInterceptor", "Lcom/bytedance/ee/bear/doc/follow/state/DocFollowStateController$ITitleBarStateInterceptor;", "hideCustomHeaderInLandscape", "fullScreenMode", "titleBarVisibleInDocFollow", "Ljava/lang/Boolean;", "docFollowStateObserver", "Lcom/bytedance/ee/bear/doc/follow/state/DocFollowStateObserver;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "handleBusinessLogic", "extraId", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "onFullScreenModeChanged", "enter", "updateHeaderVisible", "decorateHeader", "customHeaderConfig", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "customHeaderFragment", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderFragment;", "handleTitleBarStateInVc", "customHeaderVisible", "handleOrientationEvent", "setCustomHeaderVisibility", "isVisible", "getCustomHeaderState", "Landroidx/lifecycle/LiveData;", "setPadding", "paddingLeft", "", "paddingRight", "BaseSetHeaderHandler", "SetHeaderHandler", "ExitDocumentHandler", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomHeaderPlugin extends DocumentPlugin implements vz4.e {
    private static final String BIZ_EXIT_DOCUMENT = "biz.util.exitDocument";
    public static final String BIZ_SET_CUSTOM_HEADER = "biz.navigation.setCustomHeader";
    public static final b Companion = null;
    public static final String KEY_TRANSLATE = "TRANSLATE_CUSTOM_HEADER_KEY";
    private static final String TAG = "CustomHeaderPlugin";
    private m callBackFunction;
    private final sy4.d docFollowStateObserver;
    private boolean fullScreenMode;
    private boolean hideCustomHeaderInLandscape;
    private boolean isFromBase;
    private boolean isFromVc;
    private Boolean titleBarVisibleInDocFollow;
    private final sy4.c.b vcFollowTitleBarStateInterceptor;
    private CustomHeaderViewModel viewModel;

    public class a<T extends CustomHeaderConfig> implements i<T> {
        public final ArrayList<Pair<CustomHeaderConfig, m>> a;
        public final /* synthetic */ CustomHeaderPlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(CustomHeaderPlugin r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        public void a(T r9, m r10) {
            tt5.a.h(CustomHeaderPlugin.TAG, "setCustomHeader: " + r9);
            boolean r0 = true;
            Pair<CustomHeaderConfig, m> r3 = null;
            if (r9 != null) goto L5;
        L34:
            StringBuilder r11 = new StringBuilder("hide with key: ");
            if (r9 == null) goto L37;
            String r4 = r9.getKey();
        L38:
            r11.append(r4);
            tt5.a.h(CustomHeaderPlugin.TAG, r11.toString());
            ArrayList<Pair<CustomHeaderConfig, m>> r12 = this.a;
            Iterator<Pair<CustomHeaderConfig, m>> r5 = r12.iterator();
        L40:
            if (r5.hasNext() == false) goto L48;
            Pair<CustomHeaderConfig, m> r6 = r5.next();
            String r7 = ((CustomHeaderConfig) r6.getFirst()).getKey();
            if (r9 == null) goto L44;
            String r8 = r9.getKey();
        L46:
            if (TextUtils.equals(r7, r8) == false) goto L40;
        L49:
            TypeIntrinsics.asMutableCollection(r12).remove(r6);
            CustomHeaderViewModel r13 = CustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r13 != null) goto L52;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r13 = null;
        L52:
            CustomHeaderConfig r14 = (CustomHeaderConfig) r13.getHeaderData().getValue();
            if (r14 == null) goto L55;
            String r16 = r14.getKey();
        L56:
            if (r9 == null) goto L58;
            String r17 = r9.getKey();
        L60:
            if (TextUtils.equals(r16, r17) == false) goto L71;
            Pair r18 = (Pair) CollectionsKt.lastOrNull(this.a);
            if (r18 == null) goto L64;
            m r19 = (m) r18.getSecond();
        L65:
            if (r18 == null) goto L67;
            r3 = (CustomHeaderConfig) r18.getFirst();
        L67:
            if (r18 != null) goto L70;
            r0 = false;
        L70:
            c(r19, r3, r0);
            return;
        L64:
            r19 = null;
            goto L65
        L71:
            tt5.a.h(CustomHeaderPlugin.TAG, "this data is not show in display, do nothing");
            return;
        L58:
            r17 = null;
            goto L60
        L55:
            r16 = null;
            goto L56
        L44:
            r8 = null;
            goto L46
        L48:
            r6 = null;
            goto L49
        L37:
            r4 = null;
            goto L38
        L5:
            if (r9.isEmpty() == true) goto L34;
            String r20 = r9.getKey();
            CustomHeaderViewModel r21 = CustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r21 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r21 = null;
        L9:
            CustomHeaderConfig r2 = (CustomHeaderConfig) r21.getHeaderData().getValue();
            if (r2 == null) goto L12;
            String r22 = r2.getKey();
        L14:
            if (TextUtils.equals(r20, r22) == false) goto L22;
            ArrayList<Pair<CustomHeaderConfig, m>> r23 = this.a;
            Iterator<Pair<CustomHeaderConfig, m>> r24 = r23.iterator();
        L17:
            if (r24.hasNext() == false) goto L21;
            Pair<CustomHeaderConfig, m> r26 = r24.next();
            if (TextUtils.equals(((CustomHeaderConfig) r26.getFirst()).getKey(), r9.getKey()) == false) goto L17;
            r3 = r26;
        L21:
            TypeIntrinsics.asMutableCollection(r23).remove(r3);
        L31:
            if (r9.getKey() == null) goto L33;
            tt5.a.h(CustomHeaderPlugin.TAG, "show with key: " + r9.getKey());
            this.a.add(new Pair(r9, r10));
        L33:
            c(r10, r9, true);
            return;
        L22:
            Iterator<Pair<CustomHeaderConfig, m>> r27 = this.a.iterator();
        L24:
            if (r27.hasNext() == false) goto L28;
            Pair<CustomHeaderConfig, m> r28 = r27.next();
            if (TextUtils.equals(r9.getKey(), ((CustomHeaderConfig) r28.getFirst()).getKey()) == false) goto L24;
            r3 = r28;
        L28:
            if (r3 == null) goto L31;
            tt5.a.k(CustomHeaderPlugin.TAG, "updateHeader... containsKey is true. key = " + r9 + ".key");
            return;
        L12:
            r22 = null;
            goto L14
        }

        @Override // tb5.i, tb5.o
        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            a((CustomHeaderConfig) r1, r2);
        }

        public final <T extends CustomHeaderConfig> void c(m r3, T r4, boolean r5) {
            CustomHeaderPlugin.access$setCallBackFunction$p(this.b, r3);
            CustomHeaderViewModel r6 = CustomHeaderPlugin.access$getViewModel$p(this.b);
            CustomHeaderViewModel r0 = null;
            if (r6 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r6 = null;
        L5:
            r6.getHeaderData().setValue(r4);
            CustomHeaderViewModel r7 = CustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r7 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L9:
            r0.getActive().setValue(Boolean.valueOf(r5));
            return;
        L8:
            r0 = r7;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }
    }

    public final class c implements i<Void> {
        public final /* synthetic */ CustomHeaderPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(CustomHeaderPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            Void r5 = (Void) r3;
            DocumentPluginHost r6 = (DocumentPluginHost) this.a.getHost();
            if (r6 == null) goto L23;
            CustomHeaderPlugin r7 = this.a;
            if (KeyboardUtils.isSoftShowing(CustomHeaderPlugin.access$getActivity(r7)) == false) goto L7;
            KeyboardUtils.hideKeyboard(CustomHeaderPlugin.access$getActivity(r7));
        L7:
            BaseCommonActivity r1 = null;
            if (ForsetiHelper.s(r6.c()) == false) goto L12;
            com.suite.lark.component.navroute.forseti.g r8 = com.suite.lark.component.navroute.forseti.f.b(r6.c());
            if (r8 == null) goto L24;
            r8.g(null);
            return;
        L24:
            return;
        L12:
            FragmentActivity r9 = CustomHeaderPlugin.access$getActivity(r7);
            if ((r9 instanceof BaseCommonActivity) == false) goto L15;
            r1 = (BaseCommonActivity) r9;
        L15:
            if (r1 == null) goto L19;
            DocActivity.a r10 = (DocActivity.a) r1.vb(DocActivity.a.class);
            if (r10 == null) goto L19;
            boolean r11 = r10.j();
        L20:
            if (r11 == true) goto L26;
            CustomHeaderPlugin.access$getActivity(r7).finish();
            return;
        L26:
            return;
        L19:
            r11 = false;
            goto L20
        }
    }

    public final class d extends a<CustomHeaderConfig> {
        public d(CustomHeaderPlugin r1) {
            super(r1);
        }
    }

    public static final class e implements sy4.d {
        public final /* synthetic */ CustomHeaderPlugin a;

        public e(CustomHeaderPlugin r1) {
            this.a = r1;
        }

        @Override // sy4.d
        public final void a(sy4.b r3) {
            CustomHeaderViewModel r0 = CustomHeaderPlugin.access$getViewModel$p(this.a);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L5:
            CustomHeaderConfig r1 = (CustomHeaderConfig) r0.getHeaderData().getValue();
            if (r1 == null) goto L10;
            boolean r2 = true;
            if (r1.getKeepShowingInVcFollow() != true) goto L10;
        L12:
            if ((r3 instanceof sy4.f) == false) goto L16;
            if (r2 == true) goto L17;
            CustomHeaderPlugin.access$setTitleBarVisibleInDocFollow$p(this.a, Boolean.valueOf(((sy4.f) r3).a));
            tt5.a.h(CustomHeaderPlugin.TAG, "onStateChanged visible=" + CustomHeaderPlugin.access$getTitleBarVisibleInDocFollow$p(this.a));
            CustomHeaderPlugin.access$updateHeaderVisible(this.a);
            return;
        L17:
            return;
        L16:
            return;
        L10:
            r2 = false;
            goto L12
        }
    }

    public static final class f implements CustomHeaderViewModel.a {
        public final /* synthetic */ CustomHeaderPlugin a;

        public f(CustomHeaderPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.customheader.CustomHeaderViewModel.a
        public final void a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "id");
            JSONObject r1 = new JSONObject();
            r1.put("id", r3);
            m r5 = CustomHeaderPlugin.access$getCallBackFunction$p(this.a);
            if (r5 == null) goto L5;
            r5.b(r1);
        L5:
            tt5.a.h(CustomHeaderPlugin.TAG, "callback: " + r1);
            CustomHeaderPlugin.access$handleBusinessLogic(this.a, r4);
        }
    }

    public static final class g implements sy4.c.b {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // sy4.c.b
        public final boolean a(sy4.b r1) {
            return true;
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // vz4.e
    public void setPadding(int r1, int r2) {
    }

    private final void handleOrientationEvent() {
        CustomHeaderViewModel r0 = this.viewModel;
        CustomHeaderViewModel r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r0.getActive().getValue(), Boolean.TRUE) == false) goto L30;
        Context r2 = getContext();
        boolean r3 = false;
        if (r2 == null) goto L16;
        Resources r4 = r2.getResources();
        if (r4 == null) goto L16;
        Configuration r5 = r4.getConfiguration();
        if (r5 == null) goto L16;
        if (2 != r5.orientation) goto L16;
        r3 = true;
    L16:
        if (r3 == false) goto L28;
        CustomHeaderViewModel r6 = this.viewModel;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        CustomHeaderConfig r7 = (CustomHeaderConfig) r1.getHeaderData().getValue();
        if (r7 == null) goto L26;
        Boolean r8 = r7.getHideCustomHeaderInLandscape();
        if (r8 == null) goto L26;
        boolean r9 = r8.booleanValue();
    L27:
        setCustomHeaderVisibility(!r9);
        return;
    L26:
        r9 = this.hideCustomHeaderInLandscape;
        goto L27
    L20:
        r1 = r6;
        goto L21
    L28:
        setCustomHeaderVisibility(true);
        return;
    }

    private final void updateHeaderVisible() {
        StringBuilder r0 = new StringBuilder("updateHeaderVisible fullScreenMode=");
        r0.append(this.fullScreenMode);
        r0.append(", titleBarVisibleByFollow = ");
        r0.append(this.titleBarVisibleInDocFollow);
        r0.append(", keepShowingInVcFollow = ");
        CustomHeaderViewModel r1 = this.viewModel;
        CustomHeaderViewModel r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        CustomHeaderConfig r2 = (CustomHeaderConfig) r1.getHeaderData().getValue();
        if (r2 == null) goto L8;
        Boolean r4 = Boolean.valueOf(r2.getKeepShowingInVcFollow());
    L9:
        r0.append(r4);
        tt5.a.h(TAG, r0.toString());
        CustomHeaderViewModel r5 = this.viewModel;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        CustomHeaderConfig r6 = (CustomHeaderConfig) r3.getHeaderData().getValue();
        boolean r7 = false;
        if (r6 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L21;
    L26:
        boolean r9 = true;
    L28:
        if (this.isFromVc == false) goto L30;
        handleTitleBarStateInVc(r9);
    L30:
        if (r9 == false) goto L38;
        BaseTitlePlugin r10 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r10 == null) goto L34;
        r10.updateIsInCustomHeader(true);
    L34:
        CustomHeaderFragment r11 = (CustomHeaderFragment) instantiateFragment(CustomHeaderFragment.class);
        rz4.a r12 = (rz4.a) getHostAbilityOrNull(rz4.a.class);
        if (r12 == null) goto L37;
        r7 = r12.padModel();
    L37:
        r11.w = r7;
        getUIContainer().i(this, r11);
        handleOrientationEvent();
        return;
    L38:
        boolean r13 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.is_use_docx_in_sheet");
        if (r13 == false) goto L44;
        if (getTitleBar() == null) goto L44;
        getTitleBar().setTransparent(false);
    L44:
        if (getActivity() == null) goto L49;
        if (r13 == false) goto L49;
        BaseTitlePlugin r14 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r14 == null) goto L49;
        r14.handleOrientation(getActivity().getResources().getConfiguration());
    L49:
        removeFragment();
        BaseTitlePlugin r16 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r16 == null) goto L54;
        r16.updateIsInCustomHeader(false);
        return;
    L54:
        return;
    L21:
        if (this.fullScreenMode == true) goto L23;
    L25:
        r9 = false;
        goto L28
    L23:
        if (Intrinsics.areEqual(this.titleBarVisibleInDocFollow, Boolean.FALSE) == true) goto L25;
    L16:
        if (r6.getKeepShowingInVcFollow() != true) goto L18;
        r8 = true;
        goto L19
    L12:
        r3 = r5;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    @Override // vz4.e
    public LiveData<Boolean> getCustomHeaderState() {
        CustomHeaderViewModel r0 = this.viewModel;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.getActive();
    }

    public CustomHeaderPlugin() {
        this.vcFollowTitleBarStateInterceptor = g.a;
        this.docFollowStateObserver = new e(this);
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(CustomHeaderPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ m access$getCallBackFunction$p(CustomHeaderPlugin r0) {
        return r0.callBackFunction;
    }

    public static final /* synthetic */ Boolean access$getTitleBarVisibleInDocFollow$p(CustomHeaderPlugin r0) {
        return r0.titleBarVisibleInDocFollow;
    }

    public static final /* synthetic */ CustomHeaderViewModel access$getViewModel$p(CustomHeaderPlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$updateHeaderVisible(CustomHeaderPlugin r0) {
        r0.updateHeaderVisible();
    }

    private final void handleBusinessLogic(String r2) {
        int r0 = com.bytedance.ee.bear.document.customheader.b.a;
        if (Intrinsics.areEqual("docx_embedded_history_exit", r2) == false) goto L6;
        getDocViewModel().isShowingHistory().setValue(Boolean.FALSE);
        return;
    }

    private final void handleTitleBarStateInVc(boolean r3) {
        FollowPlugin r0 = (FollowPlugin) findPlugin(FollowPlugin.class);
        boolean r1 = false;
        if (r3 == false) goto L7;
        getTitleBar().getTitleBarLayout().setVisibility(0);
        if (r0 == null) goto L18;
        r0.addTitleBarStateInterceptor(this.vcFollowTitleBarStateInterceptor);
        return;
    L18:
        return;
    L7:
        if (r0 == null) goto L9;
        r0.removeTitleBarStateInterceptor(this.vcFollowTitleBarStateInterceptor);
    L9:
        if (r0 == null) goto L15;
        sy4.f r4 = r0.getCurTitleBarState();
        if (r4 == null) goto L15;
        if (r4.a == true) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L20;
        tt5.a.h(TAG, "hide original titleBar when exit fullScreen mode");
        getTitleBar().getTitleBarLayout().setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    private final void onFullScreenModeChanged(boolean r4) {
        tt5.a.h(TAG, "onFullScreenModeChanged: enter = " + r4);
        this.fullScreenMode = r4;
        BaseTitlePlugin r0 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r0 == null) goto L5;
        r0.updateIsInCustomHeaderNestScroll(!r4);
    L5:
        if (r0 == null) goto L7;
        r0.updateEnableNestScroll(!r4);
    L7:
        getTitleBar().enableTitleBarAlwaysShowing(r4);
        CustomHeaderViewModel r1 = this.viewModel;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L10:
        CustomHeaderConfig r2 = (CustomHeaderConfig) r1.getHeaderData().getValue();
        if (r2 == null) goto L13;
        String r3 = r2.getKey();
    L15:
        if (TextUtils.equals("TRANSLATE_CUSTOM_HEADER_KEY", r3) == true) goto L17;
        ((ny4.a) org.koin.java.a.c(ny4.a.class, null, null, 6)).d(getHost(), !r4);
    L17:
        updateHeaderVisible();
        return;
    L13:
        r3 = null;
        goto L15
    }

    private final void setCustomHeaderVisibility(boolean r3) {
        CustomHeaderViewModel r0 = this.viewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.isCustomHeaderVisible().setValue(Boolean.valueOf(r3));
        getTitleBar().enableTitleBarAlwaysShowing(r3);
        if (r3 == false) goto L8;
        getTitleBar().show(false);
    L10:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.is_use_docx_in_sheet") == false) goto L13;
        getTitleBar().setTransparent(r3);
        return;
    L13:
        return;
    L8:
        getTitleBar().hide(false);
        goto L10
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.navigation.setCustomHeader", new d(this));
        r3.put(BIZ_EXIT_DOCUMENT, new c(this));
    }

    public void onAttachToHost(DocumentPluginHost r5) {
        super.onAttachToHost(r5);
        if (r5 == null) goto L5;
        r5.registerHostAbility(this);
    L5:
        CustomHeaderViewModel r6 = (CustomHeaderViewModel) viewModel(CustomHeaderViewModel.class);
        this.viewModel = r6;
        CustomHeaderViewModel r0 = null;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L8:
        r6.getActive().observe(getLifecycleOwner(), new AnonymousClass1(this));
        CustomHeaderViewModel r7 = this.viewModel;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r0.setDelegate(new f(this));
        if (getDocViewModel().isDocumentType(sbb.e.h) == true) goto L15;
    L17:
        boolean r8 = false;
    L18:
        this.hideCustomHeaderInLandscape = r8;
        return;
    L15:
        if (ku5.c.k(getContext()) == true) goto L17;
        r8 = true;
        goto L18
    L11:
        r0 = r7;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        CustomHeaderViewModel r4 = this.viewModel;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L5:
        MutableLiveData<Boolean> r5 = r4.isStatusBarImmersive();
        if (this.isFromVc == false) goto L8;
    L16:
        boolean r0 = false;
    L17:
        r5.setValue(Boolean.valueOf(r0));
        handleOrientationEvent();
        return;
    L8:
        if (p05.d.a(getActivity()) == false) goto L16;
        if (getDocViewModel().getOpenSource() == DocsOpenSource.doc_component) goto L16;
        if (Intrinsics.areEqual(getDocViewModel().getBearUrl().a, "docx") == true) goto L16;
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).c()) == true) goto L16;
        r0 = true;
        goto L17
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$handleBusinessLogic(CustomHeaderPlugin r0, String r1) {
        r0.handleBusinessLogic(r1);
    }

    public static final /* synthetic */ void access$onFullScreenModeChanged(CustomHeaderPlugin r0, boolean r1) {
        r0.onFullScreenModeChanged(r1);
    }

    public static final /* synthetic */ void access$setCallBackFunction$p(CustomHeaderPlugin r0, m r1) {
        r0.callBackFunction = r1;
    }

    public static final /* synthetic */ void access$setTitleBarVisibleInDocFollow$p(CustomHeaderPlugin r0, Boolean r1) {
        r0.titleBarVisibleInDocFollow = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(DocumentPluginHost r7, t r8) {
        Intrinsics.checkNotNullParameter(r7, "host");
        Intrinsics.checkNotNullParameter(r8, "uiContainer");
        super.onAttachToUIContainer(r7, r8);
        tt5.a.h(TAG, "onAttachToUIContainer");
        boolean r1 = true;
        if (getDocViewModel().getOpenSource() != DocsOpenSource.vc) goto L5;
        boolean r9 = true;
    L6:
        this.isFromVc = r9;
        if (getDocViewModel().getOpenSource() != DocsOpenSource.base_instruction_docx) goto L9;
        boolean r10 = true;
    L10:
        this.isFromBase = r10;
        boolean r11 = Intrinsics.areEqual(getDocViewModel().getBearUrl().a, "docx");
        CustomHeaderViewModel r0 = this.viewModel;
        Boolean r3 = null;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L13:
        MutableLiveData<Boolean> r2 = r0.isStatusBarImmersive();
        if (this.isFromVc == false) goto L16;
    L25:
        r1 = false;
    L26:
        r2.setValue(Boolean.valueOf(r1));
        FollowPlugin r12 = (FollowPlugin) ((DocumentPluginHost) getHost()).findPlugin(FollowPlugin.class);
        if (r12 == null) goto L36;
        BaseFollowImpl r13 = r12.getDocumentFollow();
        if (r13 == null) goto L31;
        r13.registerDocFollowStateObserver(this.docFollowStateObserver);
    L31:
        sy4.f r14 = r12.getCurTitleBarState();
        if (r14 == null) goto L34;
        r3 = Boolean.valueOf(r14.a);
    L34:
        this.titleBarVisibleInDocFollow = r3;
        return;
    L36:
        return;
    L16:
        if (this.isFromBase == true) goto L25;
        if (p05.d.a(getActivity()) == false) goto L25;
        if (getDocViewModel().getOpenSource() == DocsOpenSource.doc_component) goto L25;
        if (r11 == true) goto L25;
        if (ForsetiHelper.s(r7.c()) == true) goto L25;
    L9:
        r10 = false;
        goto L10
    L5:
        r9 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        tt5.a.h(TAG, "onDetachFromUIContainer");
        FollowPlugin r3 = (FollowPlugin) ((DocumentPluginHost) getHost()).findPlugin(FollowPlugin.class);
        if (r3 == null) goto L9;
        BaseFollowImpl r4 = r3.getDocumentFollow();
        if (r4 == null) goto L7;
        r4.unregisterDocFollowStateObserver(this.docFollowStateObserver);
    L7:
        this.titleBarVisibleInDocFollow = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public void decorateHeader(CustomHeaderConfig r2, CustomHeaderFragment r3, CustomHeaderViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "customHeaderFragment");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        r3.W90(false, "", 0, null);
    }
}
