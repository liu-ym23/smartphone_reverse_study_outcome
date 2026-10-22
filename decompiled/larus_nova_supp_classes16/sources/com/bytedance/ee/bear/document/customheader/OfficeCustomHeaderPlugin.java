package com.bytedance.ee.bear.document.customheader;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.document.x4;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
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
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00046789B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010\u001b\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u001c\u0010\u001f\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\"\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\u0011H\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\nH\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\n01H\u0016J\u0018\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/document/ability/CustomHeaderAbility;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderViewModel;", "callBackFunction", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "isFromVc", "", "isFromBase", "hideCustomHeaderInLandscape", "fullScreenMode", "titleBarVisibleInDocFollow", "Ljava/lang/Boolean;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "handleBusinessLogic", "extraId", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getPluginId", "onDetachFromUIContainer", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "onFullScreenModeChanged", "enter", "updateHeaderVisible", "decorateHeader", "customHeaderConfig", "Lcom/bytedance/ee/bear/document/customheader/CustomHeaderConfig;", "customHeaderFragment", "Lcom/bytedance/ee/bear/document/customheader/OfficeCustomHeaderFragment;", "handleTitleBarStateInVc", "customHeaderVisible", "handleOrientationEvent", "setCustomHeaderVisibility", "isVisible", "getCustomHeaderState", "Landroidx/lifecycle/LiveData;", "setPadding", "paddingLeft", "", "paddingRight", "BaseSetHeaderHandler", "SetHeaderHandler", "ExitDocumentHandler", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OfficeCustomHeaderPlugin extends DocumentPluginV3 implements vz4.e {
    private static final String BIZ_EXIT_DOCUMENT = "biz.util.exitDocument";
    public static final String BIZ_SET_CUSTOM_HEADER = "biz.navigation.setCustomHeader";
    public static final b Companion = null;
    public static final String KEY_TRANSLATE = "TRANSLATE_CUSTOM_HEADER_KEY";
    private static final String TAG = "CustomHeaderPlugin";
    private m callBackFunction;
    private boolean fullScreenMode;
    private boolean hideCustomHeaderInLandscape;
    private boolean isFromBase;
    private boolean isFromVc;
    private Boolean titleBarVisibleInDocFollow;
    private OfficeCustomHeaderViewModel viewModel;

    public class a<T extends CustomHeaderConfig> implements i<T> {
        public final ArrayList<Pair<CustomHeaderConfig, m>> a;
        public final /* synthetic */ OfficeCustomHeaderPlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeCustomHeaderPlugin r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r9, m r10) {
            CustomHeaderConfig r11 = (CustomHeaderConfig) r9;
            tt5.a.h(OfficeCustomHeaderPlugin.TAG, "setCustomHeader: " + r11);
            boolean r0 = true;
            Pair<CustomHeaderConfig, m> r2 = null;
            if (r11 != null) goto L5;
        L32:
            StringBuilder r12 = new StringBuilder("hide with key: ");
            if (r11 == null) goto L35;
            String r3 = r11.getKey();
        L36:
            r12.append(r3);
            tt5.a.h(OfficeCustomHeaderPlugin.TAG, r12.toString());
            ArrayList<Pair<CustomHeaderConfig, m>> r13 = this.a;
            Iterator<Pair<CustomHeaderConfig, m>> r4 = r13.iterator();
        L38:
            if (r4.hasNext() == false) goto L46;
            Pair<CustomHeaderConfig, m> r5 = r4.next();
            String r6 = ((CustomHeaderConfig) r5.getFirst()).getKey();
            if (r11 == null) goto L42;
            String r7 = r11.getKey();
        L44:
            if (TextUtils.equals(r6, r7) == false) goto L38;
        L47:
            TypeIntrinsics.asMutableCollection(r13).remove(r5);
            OfficeCustomHeaderViewModel r14 = OfficeCustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r14 == null) goto L54;
            MutableLiveData<CustomHeaderConfig> r16 = r14.getHeaderData();
            if (r16 == null) goto L54;
            CustomHeaderConfig r17 = (CustomHeaderConfig) r16.getValue();
            if (r17 == null) goto L54;
            String r18 = r17.getKey();
        L55:
            if (r11 == null) goto L57;
            String r19 = r11.getKey();
        L59:
            if (TextUtils.equals(r18, r19) == false) goto L70;
            Pair r20 = (Pair) CollectionsKt.lastOrNull(this.a);
            if (r20 == null) goto L63;
            m r110 = (m) r20.getSecond();
        L64:
            if (r20 == null) goto L66;
            r2 = (CustomHeaderConfig) r20.getFirst();
        L66:
            if (r20 != null) goto L69;
            r0 = false;
        L69:
            a(r110, r2, r0);
            return;
        L63:
            r110 = null;
            goto L64
        L70:
            tt5.a.h(OfficeCustomHeaderPlugin.TAG, "this data is not show in display, do nothing");
            return;
        L57:
            r19 = null;
        L54:
            r18 = null;
            goto L55
        L42:
            r7 = null;
            goto L44
        L46:
            r5 = null;
            goto L47
        L35:
            r3 = null;
            goto L36
        L5:
            if (r11.isEmpty() == true) goto L32;
            String r8 = r11.getKey();
            OfficeCustomHeaderViewModel r21 = OfficeCustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r21 == null) goto L13;
            MutableLiveData<CustomHeaderConfig> r22 = r21.getHeaderData();
            if (r22 == null) goto L13;
            CustomHeaderConfig r23 = (CustomHeaderConfig) r22.getValue();
            if (r23 == null) goto L13;
            String r24 = r23.getKey();
        L15:
            if (TextUtils.equals(r8, r24) == false) goto L23;
            ArrayList<Pair<CustomHeaderConfig, m>> r26 = this.a;
            Iterator<Pair<CustomHeaderConfig, m>> r27 = r26.iterator();
        L18:
            if (r27.hasNext() == false) goto L22;
            Pair<CustomHeaderConfig, m> r28 = r27.next();
            if (TextUtils.equals(((CustomHeaderConfig) r28.getFirst()).getKey(), r11.getKey()) == false) goto L18;
            r2 = r28;
        L22:
            TypeIntrinsics.asMutableCollection(r26).remove(r2);
        L31:
            tt5.a.h(OfficeCustomHeaderPlugin.TAG, "show with key: " + r11.getKey());
            this.a.add(new Pair(r11, r10));
            a(r10, r11, true);
            return;
        L23:
            Iterator<Pair<CustomHeaderConfig, m>> r29 = this.a.iterator();
        L25:
            if (r29.hasNext() == false) goto L29;
            Pair<CustomHeaderConfig, m> r30 = r29.next();
            if (TextUtils.equals(r11.getKey(), ((CustomHeaderConfig) r30.getFirst()).getKey()) == false) goto L25;
            r2 = r30;
        L29:
            if (r2 == null) goto L31;
            tt5.a.k(OfficeCustomHeaderPlugin.TAG, "updateHeader... containsKey is true. key = " + r11 + ".key");
            return;
        L13:
            r24 = null;
            goto L15
        }

        public final <T extends CustomHeaderConfig> void a(m r9, T r10, boolean r11) {
            OfficeCustomHeaderPlugin.access$setCallBackFunction$p(this.b, r9);
            int r0 = 0;
            boolean r1 = false;
            r0 = 0;
            r0 = 0;
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ui_state_fix_enable") == false) goto L46;
            tt5.a.h(OfficeCustomHeaderPlugin.TAG, "ui state fix enable is on");
            TitleBar r2 = OfficeCustomHeaderPlugin.access$getTitleBar(this.b);
            Integer r3 = null;
            if (r2 == null) goto L7;
            BaseTitleBar r4 = r2.getTitleBarLayout();
        L8:
            if (r4 == null) goto L10;
            int r5 = r4.getHeight();
        L11:
            if (r4 == null) goto L15;
            ViewGroup.LayoutParams r6 = r4.getLayoutParams();
            if (r6 == null) goto L15;
            int r7 = r6.height;
        L16:
            if (r5 <= 0) goto L18;
            r7 = r5;
        L21:
            OfficeCustomHeaderViewModel r8 = OfficeCustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r8 == null) goto L30;
            Integer r12 = Integer.valueOf(r7);
            if (r12.intValue() <= 0) goto L26;
            boolean r13 = true;
        L27:
            if (r13 == false) goto L29;
            r3 = r12;
        L29:
            r8.setHeaderHeight(r3);
            goto L30
        L26:
            r13 = false;
        L30:
            if (r7 <= 0) goto L35;
            StringBuilder r14 = new StringBuilder("resolve custom header height, active=");
            r14.append(r11);
            r14.append(", useMeasured=");
            if (r5 <= 0) goto L34;
            r1 = true;
        L34:
            r14.append(r1);
            r14.append(", height=");
            r14.append(r7);
            tt5.a.h(OfficeCustomHeaderPlugin.TAG, r14.toString());
        L36:
            OfficeCustomHeaderViewModel r16 = OfficeCustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r16 == null) goto L41;
            MutableLiveData<CustomHeaderConfig> r17 = r16.getHeaderData();
            if (r17 == null) goto L41;
            r17.setValue(r10);
        L41:
            OfficeCustomHeaderViewModel r18 = OfficeCustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r18 == null) goto L68;
            MutableLiveData<Boolean> r19 = r18.getActive();
            if (r19 == null) goto L69;
            r19.setValue(Boolean.valueOf(r11));
            return;
        L69:
            return;
        L68:
            return;
        L35:
            tt5.a.k(OfficeCustomHeaderPlugin.TAG, "custom header height unavailable, use layout default, active=" + r11);
            goto L36
        L18:
            if (r7 > 0) goto L21;
            r7 = 0;
        L15:
            r7 = 0;
            goto L16
        L10:
            r5 = 0;
            goto L11
        L7:
            r4 = null;
            goto L8
        L46:
            OfficeCustomHeaderViewModel r20 = OfficeCustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r20 == null) goto L51;
            MutableLiveData<CustomHeaderConfig> r21 = r20.getHeaderData();
            if (r21 == null) goto L51;
            r21.setValue(r10);
        L51:
            OfficeCustomHeaderViewModel r22 = OfficeCustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r22 == null) goto L56;
            MutableLiveData<Boolean> r23 = r22.getActive();
            if (r23 == null) goto L56;
            r23.setValue(Boolean.valueOf(r11));
        L56:
            ChameleonPluginHost r24 = this.b.getHost();
            if (r24 == null) goto L63;
            ViewGroup r26 = r24.getContainer(ContainerType.Root.getValue());
            if (r26 == null) goto L63;
            View r27 = r26.findViewById(2131369266);
            if (r27 == null) goto L63;
            r0 = r27.getHeight();
        L63:
            if (r0 <= 0) goto L71;
            OfficeCustomHeaderViewModel r28 = OfficeCustomHeaderPlugin.access$getViewModel$p(this.b);
            if (r28 == null) goto L72;
            r28.setHeaderHeight(Integer.valueOf(r0));
            return;
        L72:
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public final class c implements i<Void> {
        public final /* synthetic */ OfficeCustomHeaderPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficeCustomHeaderPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.document.customheader.OfficeCustomHeaderPlugin] */
        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            Void r4 = (Void) r2;
            ChameleonPluginHost r5 = this.a.getHost();
            if (r5 == null) goto L16;
            ?? r6 = this.a;
            if (KeyboardUtils.isSoftShowing(OfficeCustomHeaderPlugin.access$getActivity(r6)) == false) goto L8;
            KeyboardUtils.hideKeyboard(OfficeCustomHeaderPlugin.access$getActivity(r6));
        L8:
            if (ForsetiHelper.s(r5.getFragment()) == false) goto L12;
            g r7 = f.b(r5.getFragment());
            if (r7 == null) goto L17;
            r7.g(null);
            return;
        L17:
            return;
        L12:
            com.bytedance.ee.bear.document.container.a r8 = (com.bytedance.ee.bear.document.container.a) r6.getHost().getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
            if (r8 == null) goto L19;
            r8.onBackPressed();
            return;
        L19:
            return;
        }
    }

    public final class d extends a<CustomHeaderConfig> {
        public d(OfficeCustomHeaderPlugin r1) {
            super(r1);
        }
    }

    public static final class e implements OfficeCustomHeaderViewModel.a {
        public final /* synthetic */ OfficeCustomHeaderPlugin a;

        public e(OfficeCustomHeaderPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.customheader.OfficeCustomHeaderViewModel.a
        public final void a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "id");
            JSONObject r1 = new JSONObject();
            r1.put("id", r3);
            m r5 = OfficeCustomHeaderPlugin.access$getCallBackFunction$p(this.a);
            if (r5 == null) goto L5;
            r5.b(r1);
        L5:
            tt5.a.h(OfficeCustomHeaderPlugin.TAG, "callback: " + r1);
            OfficeCustomHeaderPlugin.access$handleBusinessLogic(this.a, r4);
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleOrientationEvent() {
        OfficeCustomHeaderViewModel r0 = this.viewModel;
        boolean r1 = false;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r2 = r0.getActive();
        if (r2 == null) goto L7;
        boolean r3 = Intrinsics.areEqual(r2.getValue(), Boolean.TRUE);
    L8:
        if (r3 == false) goto L32;
        Context r4 = getContext();
        if (r4 == null) goto L18;
        Resources r5 = r4.getResources();
        if (r5 == null) goto L18;
        Configuration r6 = r5.getConfiguration();
        if (r6 == null) goto L18;
        if (2 != r6.orientation) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L30;
        OfficeCustomHeaderViewModel r7 = this.viewModel;
        if (r7 == null) goto L28;
        MutableLiveData<CustomHeaderConfig> r8 = r7.getHeaderData();
        if (r8 == null) goto L28;
        CustomHeaderConfig r9 = (CustomHeaderConfig) r8.getValue();
        if (r9 == null) goto L28;
        Boolean r10 = r9.getHideCustomHeaderInLandscape();
        if (r10 == null) goto L28;
        boolean r11 = r10.booleanValue();
    L29:
        setCustomHeaderVisibility(!r11);
        return;
    L28:
        r11 = this.hideCustomHeaderInLandscape;
        goto L29
    L30:
        setCustomHeaderVisibility(true);
        return;
    L32:
        return;
    L7:
        r3 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateHeaderVisible() {
        StringBuilder r0 = new StringBuilder("updateHeaderVisible fullScreenMode=");
        r0.append(this.fullScreenMode);
        r0.append(", titleBarVisibleByFollow = ");
        r0.append(this.titleBarVisibleInDocFollow);
        r0.append(", keepShowingInVcFollow = ");
        OfficeCustomHeaderViewModel r1 = this.viewModel;
        if (r1 == null) goto L9;
        MutableLiveData<CustomHeaderConfig> r2 = r1.getHeaderData();
        if (r2 == null) goto L9;
        CustomHeaderConfig r3 = (CustomHeaderConfig) r2.getValue();
        if (r3 == null) goto L9;
        Boolean r4 = Boolean.valueOf(r3.getKeepShowingInVcFollow());
    L10:
        r0.append(r4);
        tt5.a.h(TAG, r0.toString());
        OfficeCustomHeaderViewModel r5 = this.viewModel;
        boolean r6 = true;
        if (r5 == null) goto L19;
        MutableLiveData<CustomHeaderConfig> r7 = r5.getHeaderData();
        if (r7 == null) goto L19;
        CustomHeaderConfig r8 = (CustomHeaderConfig) r7.getValue();
        if (r8 == null) goto L19;
        if (r8.getKeepShowingInVcFollow() != true) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == true) goto L28;
        if (this.fullScreenMode == true) goto L24;
    L26:
        r6 = false;
        goto L28
    L24:
        if (Intrinsics.areEqual(this.titleBarVisibleInDocFollow, Boolean.FALSE) == true) goto L26;
    L28:
        if (this.isFromVc == false) goto L30;
        handleTitleBarStateInVc(r6);
    L30:
        if (r6 == false) goto L32;
        OfficeCustomHeaderFragment r10 = (OfficeCustomHeaderFragment) instantiateFragment(OfficeCustomHeaderFragment.class);
        getUIContainer().i(this, r10);
        handleOrientationEvent();
        return;
    L32:
        boolean r11 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.is_use_docx_in_sheet");
        if (r11 == false) goto L38;
        if (getTitleBar() == null) goto L38;
        getTitleBar().setTransparent(false);
    L38:
        if (getActivity() == null) goto L43;
        if (r11 == false) goto L43;
        BaseTitlePlugin r12 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r12 == null) goto L43;
        r12.handleOrientation(getActivity().getResources().getConfiguration());
    L43:
        removeFragment();
        return;
    L19:
        r9 = false;
    L9:
        r4 = null;
        goto L10
    }

    @Override // vz4.e
    public LiveData<Boolean> getCustomHeaderState() {
        OfficeCustomHeaderViewModel r0 = this.viewModel;
        if (r0 == null) goto L8;
        MutableLiveData<Boolean> r1 = r0.getActive();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return new MutableLiveData();
    }

    public String getPluginId() {
        String r0 = y5.a;
        return y5.e;
    }

    public OfficeCustomHeaderPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentActivity access$getActivity(OfficeCustomHeaderPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ m access$getCallBackFunction$p(OfficeCustomHeaderPlugin r0) {
        return r0.callBackFunction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TitleBar access$getTitleBar(OfficeCustomHeaderPlugin r0) {
        return r0.getTitleBar();
    }

    public static final /* synthetic */ OfficeCustomHeaderViewModel access$getViewModel$p(OfficeCustomHeaderPlugin r0) {
        return r0.viewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleBusinessLogic(String r2) {
        int r0 = com.bytedance.ee.bear.document.customheader.b.a;
        if (Intrinsics.areEqual("docx_embedded_history_exit", r2) == false) goto L10;
        x4 r3 = (x4) getHostAbilityOrNull(x4.class);
        if (r3 == null) goto L11;
        MutableLiveData<Boolean> r4 = r3.isShowingHistory();
        if (r4 == null) goto L12;
        r4.setValue(Boolean.FALSE);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleTitleBarStateInVc(boolean r2) {
        if (r2 == false) goto L5;
        getTitleBar().getTitleBarLayout().setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onFullScreenModeChanged(boolean r3) {
        tt5.a.h(TAG, "onFullScreenModeChanged: enter = " + r3);
        this.fullScreenMode = r3;
        BaseTitlePlugin r0 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r0 == null) goto L5;
        r0.updateEnableNestScroll(!r3);
    L5:
        getTitleBar().enableTitleBarAlwaysShowing(r3);
        OfficeCustomHeaderViewModel r4 = this.viewModel;
        if (r4 == null) goto L12;
        MutableLiveData<CustomHeaderConfig> r5 = r4.getHeaderData();
        if (r5 == null) goto L12;
        CustomHeaderConfig r6 = (CustomHeaderConfig) r5.getValue();
        if (r6 == null) goto L12;
        String r7 = r6.getKey();
    L13:
        TextUtils.equals("TRANSLATE_CUSTOM_HEADER_KEY", r7);
        updateHeaderVisible();
        return;
    L12:
        r7 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setCustomHeaderVisibility(boolean r3) {
        OfficeCustomHeaderViewModel r0 = this.viewModel;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.isCustomHeaderVisible();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.valueOf(r3));
    L7:
        getTitleBar().enableTitleBarAlwaysShowing(r3);
        if (r3 == false) goto L10;
        getTitleBar().show(false);
    L12:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.is_use_docx_in_sheet") == false) goto L15;
        getTitleBar().setTransparent(r3);
        return;
    L15:
        return;
    L10:
        getTitleBar().hide(false);
        goto L12
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.navigation.setCustomHeader", new d(this));
        r3.put(BIZ_EXIT_DOCUMENT, new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        if (r4 == null) goto L5;
        r4.registerHostAbility(this);
    L5:
        OfficeCustomHeaderViewModel r5 = (OfficeCustomHeaderViewModel) viewModel(OfficeCustomHeaderViewModel.class);
        this.viewModel = r5;
        if (r5 == null) goto L10;
        MutableLiveData<Boolean> r6 = r5.getActive();
        if (r6 == null) goto L10;
        r6.observe(getLifecycleOwner(), new AnonymousClass1(this));
    L10:
        OfficeCustomHeaderViewModel r7 = this.viewModel;
        if (r7 == null) goto L13;
        r7.setDelegate(new e(this));
    L13:
        y3 r8 = getDocumentMetadata();
        boolean r0 = true;
        if (r8 != null) goto L16;
    L18:
        boolean r9 = false;
    L19:
        if (r9 == true) goto L21;
    L23:
        r0 = false;
    L24:
        this.hideCustomHeaderInLandscape = r0;
        return;
    L21:
        if (ku5.c.k(getContext()) == true) goto L23;
    L16:
        if (r8.isDocumentType(sbb.e.h) != true) goto L18;
        r9 = true;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r1);
        handleOrientationEvent();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$handleBusinessLogic(OfficeCustomHeaderPlugin r0, String r1) {
        r0.handleBusinessLogic(r1);
    }

    public static final /* synthetic */ void access$onFullScreenModeChanged(OfficeCustomHeaderPlugin r0, boolean r1) {
        r0.onFullScreenModeChanged(r1);
    }

    public static final /* synthetic */ void access$setCallBackFunction$p(OfficeCustomHeaderPlugin r0, m r1) {
        r0.callBackFunction = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r5, t r6) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r5, r6);
        y3 r7 = getDocumentMetadata();
        DocsOpenSource r8 = null;
        if (r7 == null) goto L5;
        DocsOpenSource r0 = r7.getOpenSource();
    L6:
        boolean r2 = true;
        if (r0 != DocsOpenSource.vc) goto L9;
        boolean r1 = true;
    L10:
        this.isFromVc = r1;
        if (r7 == null) goto L14;
        r8 = r7.getOpenSource();
    L14:
        if (r8 == DocsOpenSource.base_instruction_docx) goto L17;
        r2 = false;
    L17:
        this.isFromBase = r2;
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vz4.e
    public void setPadding(int r4, int r5) {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L11;
        t r1 = r0.getUIContainer();
        if (r1 == null) goto L12;
        ViewGroup r2 = r1.c(this);
        if (r2 == null) goto L13;
        r2.setPadding(r4, r2.getPaddingTop(), r5, r2.getPaddingBottom());
        return;
    L13:
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
    }

    public void decorateHeader(CustomHeaderConfig r2, OfficeCustomHeaderFragment r3, OfficeCustomHeaderViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "customHeaderFragment");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        ImageView r5 = r3.o;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewIcon");
        r5 = null;
    L5:
        r5.setVisibility(8);
        ImageView r6 = r3.p;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
        r6 = null;
    L8:
        r6.setVisibility(8);
        LinearLayout r7 = r3.g;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r7 = null;
    L11:
        r7.setOnClickListener(null);
    }
}
