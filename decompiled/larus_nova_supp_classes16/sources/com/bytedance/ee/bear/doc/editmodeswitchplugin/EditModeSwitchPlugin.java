package com.bytedance.ee.bear.doc.editmodeswitchplugin;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelPlugin;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.a5;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.doccomponent.DocComponentPlugin;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.OrientationViewModel;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.edit.component.toolbar2.DocToolbarV2Compat;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.templates.BaseAnnounceTemplateViewModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.button.CommonEditButton;
import com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditModeSwitchPlugin extends DocumentPluginV2 implements x2.b, TitleBar.a, p, oy4.a, IEditModeSwitchViewPlugin<PluginHost> {
    private static final int EDIT_BUTTON_WITH_ANNOUNCE_INVISIBLE_LOCATION_Y = 200;
    private static final int EDIT_BUTTON_WITH_ANNOUNCE_VISIBLE_LOCATION_Y = 350;
    private static final String JS_CLICK_COMPLETE_BUTTON = "window.lark.biz.completeButton.click";
    private static final String JS_CLICK_ENTER_EDIT_BUTTON = "window.lark.biz.editButton.clickEdit";
    private static final String TAG = "EditModeSwitchPlugin";
    private final View.OnLayoutChangeListener asideCommentLayoutChangeListener;
    private final MutableLiveData<Boolean> editModeLiveData;
    private boolean isEditButtonCanVisible;
    private boolean isEditButtonCanVisibleFromNative;
    private boolean isInEditStatus;
    private boolean isLoadDocSuccess;
    private View mAsideCommentAnchorContainer;
    private Rect mDefaultButtonMarginRect;
    private s1 mDocReport;
    private CommonEditButton mEditModeSwitchView;
    private OrientationViewModel mOrientationViewModel;
    private Rect mPendingPaddingRect;
    private Boolean originalLeftIconVisibility;

    public class EditStatus implements NonProguard {
        private int status;
        final /* synthetic */ EditModeSwitchPlugin this$0;

        public int getStatus() {
            return this.status;
        }

        private EditStatus(EditModeSwitchPlugin r1) {
            this.this$0 = r1;
        }

        public void setStatus(int r1) {
            this.status = r1;
        }
    }

    public class a implements Observer<Boolean> {
        public final /* synthetic */ EditModeSwitchPlugin a;

        public a(EditModeSwitchPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            Boolean r0 = Boolean.TRUE;
            if (r0.equals(r4) == false) goto L8;
            if (EditModeSwitchPlugin.access$400(this.a) == false) goto L8;
            EditModeSwitchPlugin.access$500(this.a, Boolean.FALSE);
            return;
        L8:
            if (Boolean.FALSE.equals(r4) == true) goto L10;
            return;
        L10:
            if (EditModeSwitchPlugin.access$400(this.a) == false) goto L15;
            EditModeSwitchPlugin.access$500(this.a, r0);
            return;
        }
    }

    public class b implements BaseTitlePlugin.a {
        public final /* synthetic */ EditModeSwitchPlugin a;

        public b(EditModeSwitchPlugin r1) {
            this.a = r1;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ EditModeSwitchPlugin a;

        @Override // java.lang.Runnable
        public final void run() {
            EditModeSwitchPlugin.access$700(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(EditModeSwitchPlugin r1) {
            this.a = r1;
        }
    }

    public class d implements i<String> {
        public final /* synthetic */ EditModeSwitchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(EditModeSwitchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            String r4 = (String) r2;
            tt5.a.k(EditModeSwitchPlugin.TAG, "CompleteButtonVisibleHandler.handle");
            if (EditModeSwitchPlugin.access$1100(this.a) == false) goto L5;
            tt5.a.k(EditModeSwitchPlugin.TAG, "CompleteButtonVisibleHandler receive h5 CompleteButtonVisibleHandler info, but isUIContainerDetached");
            return;
        L5:
            if (r4 != null) goto L16;
            tt5.a.k(EditModeSwitchPlugin.TAG, "set complete button status failed, data is null");
            return;
        L16:
            EditModeCompleteButtonVisibleInfo r5 = (EditModeCompleteButtonVisibleInfo) JSON.parseObject(r4).toJavaObject(EditModeCompleteButtonVisibleInfo.class);     // Catch: Exception -> L12
            if (r5 != null) goto L10;
            tt5.a.k(EditModeSwitchPlugin.TAG, "parse json failed");     // Catch: Exception -> L12
        L15:
            return;
        L10:
            EditModeSwitchPlugin.access$1200(this.a, r5.isVisible());     // Catch: Exception -> L12
        L12:
            e = move-exception;
            tt5.a.f(EditModeSwitchPlugin.TAG, e, false);
        }
    }

    public class e implements i<String> {
        public final /* synthetic */ EditModeSwitchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(EditModeSwitchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            com.bytedance.ee.bear.appsetting.c r7 = com.bytedance.ee.bear.appsetting.c.a.a;
            if (r7.h("ccm.docx.mobile.new_complete_btn_layout") == true) goto L5;
            EditModeSwitchPlugin.access$800(this.a);
        L5:
            EditModeSwitchButtonVisibleInfo r8 = (EditModeSwitchButtonVisibleInfo) JSON.parseObject(r6, EditModeSwitchButtonVisibleInfo.class);
            if (r8 == null) goto L15;
            tt5.a.h(EditModeSwitchPlugin.TAG, "json visible info is " + r8.isVisible() + " token " + du5.b.g(this.a.getDocumentMetadata().getToken()));
            EditModeSwitchPlugin.access$602(this.a, r8.isVisible());
            EditModeSwitchPlugin.access$900(this.a);
            if (r7.h("ccm.docx.mobile.new_complete_btn_layout") == true) goto L16;
            EditModeSwitchPlugin r9 = this.a;
            if (r8.isVisible() == false) goto L12;
            int r10 = 8;
        L13:
            EditModeSwitchPlugin.access$1000(r9, r10);
            return;
        L12:
            r10 = 0;
            goto L13
        L16:
            return;
        }
    }

    public class f implements i<String> {
        public final /* synthetic */ EditModeSwitchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(EditModeSwitchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docx.mobile.new_complete_btn_layout") == false) goto L16;
            EditModeSwitchPlugin.access$800(this.a);     // Catch: Exception -> L9
            tt5.a.h(EditModeSwitchPlugin.TAG, "onEditStateChange data: " + r6);     // Catch: Exception -> L9
            EditModeSwitchPlugin.access$402(this.a, JSONObjectProtectorUtils.getBoolean(new JSONObject(r6), JSEventListener.ACTION_EDIT));     // Catch: Exception -> L9
            if (EditModeSwitchPlugin.access$400(this.a) == false) goto L7;
            EditModeSwitchPlugin.access$1000(this.a, 0);     // Catch: Exception -> L9
        L12:
            return;
        L7:
            EditModeSwitchPlugin.access$1000(this.a, 8);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            tt5.a.l(EditModeSwitchPlugin.TAG, "Failed to updateEditStatus", e);
            return;
        }
    }

    public class g implements i<String> {
        public final /* synthetic */ EditModeSwitchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(EditModeSwitchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            tt5.a.h(EditModeSwitchPlugin.TAG, "updateEditStatus data: " + r6);     // Catch: Exception -> L11
            JSONObject r1 = new JSONObject(r6);     // Catch: Exception -> L11
            if (r1.has("status") == false) goto L16;
            EditModeSwitchPlugin r7 = this.a;     // Catch: Exception -> L11
            int r8 = JSONObjectProtectorUtils.getInt(r1, "status");     // Catch: Exception -> L11
            boolean r2 = true;
            if (r8 == 1) goto L9;
            r2 = false;
        L9:
            EditModeSwitchPlugin.access$402(r7, r2);     // Catch: Exception -> L11
            EditModeSwitchPlugin.access$1300(this.a);     // Catch: Exception -> L11
            EditModeSwitchPlugin.access$1400(this.a).postValue(Boolean.valueOf(EditModeSwitchPlugin.access$400(this.a)));     // Catch: Exception -> L11
            return;
        L16:
            return;
        L11:
            e = move-exception;
            tt5.a.l(EditModeSwitchPlugin.TAG, "Failed to updateEditStatus", e);
        }
    }

    public static /* synthetic */ void a(EditModeSwitchPlugin r0, BaseAnnounceTemplateViewModel r1, Boolean r2) {
        r0.lambda$observeEditSwitchHeight$1(r1, r2);
    }

    public static /* synthetic */ void c(EditModeSwitchPlugin r0, View r1) {
        r0.lambda$onAttachToUIContainer$2(r1);
    }

    public static /* synthetic */ void d(EditModeSwitchPlugin r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r0.lambda$new$0(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void e(EditModeSwitchPlugin r0, View r1) {
        r0.lambda$setCompleteButtonVisible$6(r1);
    }

    public static /* synthetic */ void f(EditModeSwitchPlugin r0, View r1) {
        r0.lambda$setCompleteButtonVisible$3(r1);
    }

    public static /* synthetic */ void g(EditModeSwitchPlugin r0, View r1) {
        r0.lambda$setCompleteButtonVisible$4(r1);
    }

    public static /* synthetic */ void h(EditModeSwitchPlugin r0, View r1) {
        r0.lambda$setCompleteButtonVisible$5(r1);
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar.a
    public void onTitleBarStateChanged(com.bytedance.ee.bear.browser.plugin.d r1) {
    }

    private void applyEditModeSwitchMargin() {
        CommonEditButton r0 = this.mEditModeSwitchView;
        if (r0 != null) goto L5;
        return;
    L5:
        Rect r1 = this.mPendingPaddingRect;
        if (r1 != null) goto L9;
        r1 = this.mDefaultButtonMarginRect;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        int r2 = r1.left;
        int r3 = r1.top;
        int r4 = r1.right + resolveAsideWidth(findAsideCommentAnchorContainer());
        int r5 = r1.bottom;
        FrameLayout r6 = r0.getEditButtonContainerFromXml();
        if (r6 == null) goto L31;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof FrameLayout.LayoutParams) == false) goto L17;
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r7;
    L18:
        if (r8 != null) goto L21;
        return;
    L21:
        if (r8.leftMargin == r2) goto L23;
    L29:
        r8.setMargins(r2, r3, r4, r5);
        r6.setLayoutParams(r8);
        return;
    L23:
        if (r8.topMargin != r3) goto L29;
        if (r8.rightMargin != r4) goto L29;
        if (r8.bottomMargin != r5) goto L29;
        return;
    L17:
        r8 = null;
        goto L18
    }

    private boolean canShowEditButton() {
        if (this.isEditButtonCanVisible == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isEditButtonCanVisibleFromNative == false) goto L7;
        return true;
    }

    private void captureDefaultButtonMarginIfNeed() {
        CommonEditButton r0 = this.mEditModeSwitchView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mDefaultButtonMarginRect != null) goto L16;
        FrameLayout r1 = r0.getEditButtonContainerFromXml();
        if (r1 != null) goto L10;
        return;
    L10:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        this.mDefaultButtonMarginRect = new Rect(r3.leftMargin, r3.topMargin, r3.getMarginEnd(), r3.bottomMargin);
        return;
    L15:
        return;
    }

    private void detachAsideCommentLayoutListener() {
        View r0 = this.mAsideCommentAnchorContainer;
        if (r0 == null) goto L6;
        r0.removeOnLayoutChangeListener(this.asideCommentLayoutChangeListener);
        this.mAsideCommentAnchorContainer = null;
        return;
    }

    private void initTitleBarBehaviorIfNeed() {
        BaseTitlePlugin r0 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getImmersiveDelegate() != null) goto L9;
        r0.setImmersiveDelegate(new b(this));
        return;
    }

    private void notifyEditStatusChange() {
        if (this.isInEditStatus == true) goto L14;
        notifyOrientationSupportPanelState(Boolean.FALSE);
        updateTitleBarinDOB(8);
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L7;
    L19:
        BlockEditPanelPlugin r0 = (BlockEditPanelPlugin) findPlugin(BlockEditPanelPlugin.class);
        if (r0 == null) goto L23;
        r0.setEditStatus(this.isInEditStatus);
        return;
    L23:
        return;
    L7:
        if (n.C(getContext()) == false) goto L12;
        if (ku5.c.k(getContext()) == true) goto L12;
        hideButton();
    L12:
        if (this.isEditButtonCanVisible == false) goto L19;
        showButton();
        goto L19
    L14:
        OrientationViewModel r1 = this.mOrientationViewModel;
        if (r1 == null) goto L19;
        if (r1.isLock() == true) goto L19;
        notifyOrientationSupportPanelState(Boolean.TRUE);
        goto L19
    }

    private void observeEditSwitchHeight() {
        final BaseAnnounceTemplateViewModel r0 = ((wn5.a) org.koin.java.a.a(wn5.a.class)).i(getHost());
        r0.getPanelActive().observe(getLifecycleOwner(), new com.bytedance.ee.bear.doc.editmodeswitchplugin.f(this, r0));
    }

    private void showButtonInternal() {
        CommonEditButton r0 = this.mEditModeSwitchView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 8) goto L11;
        tt5.a.h(TAG, "show button");
        this.mEditModeSwitchView.setVisibility(0);
        if (getDocumentMetadata().isAnnounceDoc() == false) goto L12;
        this.mEditModeSwitchView.postDelayed(new c(this), 100);
        return;
    L12:
        return;
    }

    public void hideButton() {
        CommonEditButton r0 = this.mEditModeSwitchView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L9;
        tt5.a.h(TAG, "hide button");
        this.mEditModeSwitchView.setVisibility(8);
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadSuccess() {
        tt5.a.h(TAG, "load success, token is " + du5.b.g(getDocumentMetadata().getToken()));
        this.isLoadDocSuccess = true;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        if (this.isInEditStatus == false) goto L7;
        return true;
    L7:
        return super.shouldDisableLandscape();
    }

    public EditModeSwitchPlugin() {
        this.isLoadDocSuccess = false;
        this.isEditButtonCanVisible = false;
        this.isEditButtonCanVisibleFromNative = true;
        this.isInEditStatus = false;
        this.editModeLiveData = new MutableLiveData();
        this.asideCommentLayoutChangeListener = new com.bytedance.ee.bear.doc.editmodeswitchplugin.e(this);
    }

    private void attachAsideCommentLayoutListener() {
        View r0 = findAsideCommentAnchorContainer();
        if (this.mAsideCommentAnchorContainer != r0) goto L5;
        return;
    L5:
        detachAsideCommentLayoutListener();
        this.mAsideCommentAnchorContainer = r0;
        if (r0 == null) goto L9;
        r0.addOnLayoutChangeListener(this.asideCommentLayoutChangeListener);
        return;
    }

    private View findAsideCommentAnchorContainer() {
        t r0 = getUIContainer();
        if (r0 == null) goto L5;
        View r1 = r0.findView(2131363249);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (getActivity() != null) goto L10;
        return r1;
    L10:
        if (getActivity().getWindow() != null) goto L12;
        return r1;
    L12:
        return INVOKEVIRTUAL_com_bytedance_ee_bear_doc_editmodeswitchplugin_EditModeSwitchPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getActivity().getWindow()).findViewById(2131363249);
    L5:
        r1 = null;
        goto L6
    }

    private void updateEditButtonVisibility() {
        if (canShowEditButton() == false) goto L5;
        showButtonInternal();
        return;
    L5:
        hideButton();
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadStart() {
        hideButton();
        this.isLoadDocSuccess = false;
    }

    public void showButton() {
        if (canShowEditButton() == true) goto L5;
        return;
    L5:
        showButtonInternal();
    }

    @Override // oy4.a
    public LiveData<Boolean> getEditModeLiveData() {
        return this.editModeLiveData;
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_bear_doc_editmodeswitchplugin_EditModeSwitchPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static /* synthetic */ boolean access$1100(EditModeSwitchPlugin r0) {
        return r0.isUIContainerDetached();
    }

    public static /* synthetic */ void access$1300(EditModeSwitchPlugin r0) {
        r0.notifyEditStatusChange();
    }

    public static /* synthetic */ MutableLiveData access$1400(EditModeSwitchPlugin r0) {
        return r0.editModeLiveData;
    }

    public static /* synthetic */ boolean access$400(EditModeSwitchPlugin r0) {
        return r0.isInEditStatus;
    }

    public static /* synthetic */ boolean access$600(EditModeSwitchPlugin r0) {
        return r0.isEditButtonCanVisible;
    }

    public static /* synthetic */ void access$700(EditModeSwitchPlugin r0) {
        r0.observeEditSwitchHeight();
    }

    public static /* synthetic */ void access$800(EditModeSwitchPlugin r0) {
        r0.initTitleBarBehaviorIfNeed();
    }

    public static /* synthetic */ void access$900(EditModeSwitchPlugin r0) {
        r0.updateEditButtonVisibility();
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$2(View r2) {
        tt5.a.h(TAG, "click button enter edit mode");
        dispatchBridgeMsg(JS_CLICK_ENTER_EDIT_BUTTON, new com.alibaba.fastjson.JSONObject());
    }

    private /* synthetic */ void lambda$setCompleteButtonVisible$3(View r2) {
        dispatchBridgeMsg(JS_CLICK_COMPLETE_BUTTON, new com.alibaba.fastjson.JSONObject());
        getTitleBar().d();
        DocToolbarV2Compat.of(getActivity()).forceClearToolbar();
    }

    private /* synthetic */ void lambda$setCompleteButtonVisible$4(View r2) {
        this.mDocReport.m("done");
    }

    private /* synthetic */ void lambda$setCompleteButtonVisible$5(View r3) {
        a5 r4 = (a5) getHostAbilityOrNull(a5.class);
        if (r4 == null) goto L11;
        Iterator<a5.a> r5 = r4.getBackPressedInterceptors().iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        a5.a r0 = r5.next();
        if (r0.onPressed() == false) goto L6;
        tt5.a.h(TAG, "titleBar back comsume by backPressedInterceptor=" + r0);
        return;
    L11:
        getActivity().onBackPressed();
    }

    private /* synthetic */ void lambda$setCompleteButtonVisible$6(View r2) {
        this.mDocReport.m("back");
    }

    private void notifyOrientationSupportPanelState(Boolean r3) {
        if (ku5.c.k(getContext()) == true) goto L5;
    L7:
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L12;
        tt5.a.k(TAG, "can not find BaseUnspecifiedOrientationPlugin");
        return;
    L12:
        if (Boolean.TRUE.equals(r3) == false) goto L14;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L14:
        r0.onOrientationSupportPanelDismiss(this);
        return;
    L5:
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L7;
    }

    private int resolveAsideWidth(View r3) {
        if (r3 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r3.getVisibility() != 0) goto L8;
        return Math.max(r3.getWidth(), 0);
    }

    private void setCompleteButtonVisible(boolean r4) {
        tt5.a.k(TAG, "CompleteButtonVisibleHandler.visible: " + r4);
        if (r4 == false) goto L9;
        Boolean r5 = Boolean.valueOf(getTitleBar().isLeftIconVisible());
        this.originalLeftIconVisibility = r5;
        if (r5.booleanValue() == true) goto L7;
        getTitleBar().setLeftIconVisibility(true);
    L7:
        np5.a.a(getTitleBar().getTitleBarLayout().q, 2131233837, 2131105548);
        getTitleBar().getTitleBarLayout().setLeftClickListener(new com.bytedance.ee.bear.doc.editmodeswitchplugin.a(this));
        getTitleBar().getTitleBarLayout().setLeftExtraClickListener(new com.bytedance.ee.bear.doc.editmodeswitchplugin.b(this));
        return;
    L9:
        if (this.originalLeftIconVisibility == null) goto L11;
        getTitleBar().setLeftIconVisibility(this.originalLeftIconVisibility.booleanValue());
    L11:
        DocComponentPlugin r6 = (DocComponentPlugin) findPlugin(DocComponentPlugin.class);
        TitleBar r0 = getTitleBar();
        if (r0 == null) goto L18;
        BaseTitleBar r1 = r0.getTitleBarLayout();
        if (r6 != null) goto L16;
        int r7 = 2131254998;
    L17:
        np5.a.a(r1.q, r7, 2131101926);
        r0.getTitleBarLayout().setLeftClickListener(new com.bytedance.ee.bear.doc.editmodeswitchplugin.c(this));
        goto L18
    L16:
        r7 = r6.getLeftImageResource();
    L18:
        getTitleBar().getTitleBarLayout().setLeftExtraClickListener(new com.bytedance.ee.bear.doc.editmodeswitchplugin.d(this));
    }

    private void updateTitleBarinDOB(int r3) {
        if (TextUtils.equals(getDocViewModel().getOpenSource().name(), DocsOpenSource.base_instruction_docx.name()) == true) goto L5;
        return;
    L5:
        if (getTitleBar() == null) goto L9;
        getTitleBar().getTitleBarLayout().setVisibility(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.editButton.setVisible", new e(this));
        r3.put("biz.completeButton.setVisible", new d(this));
        r3.put("biz.docx.updateEditStatus", new g(this));
        r3.put("biz.edit.onEditStateChange", new f(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r10) {
        super.onAttachToHost(r10);
        getEditorAbility().getDocumentLoader().S3(this);
        OrientationViewModel r0 = (OrientationViewModel) viewModel(OrientationViewModel.class);
        this.mOrientationViewModel = r0;
        r0.getLocked().observe(getLifecycleOwner(), new a(this));
        this.mDocReport = new s1(j.a.a, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (b0) org.koin.java.a.a(b0.class), (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), ((b0) org.koin.java.a.a(b0.class)).e());
        observeEditSwitchHeight();
        if (ForsetiHelper.s(r10.getHostFragment()) == false) goto L6;
        r10.registerHostAbility(this);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        notifyEditStatusChange();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        super.onDetachFromHost(r2);
        getEditorAbility().getDocumentLoader().S(this);
        if (ForsetiHelper.s(r2.getHostFragment()) == false) goto L6;
        r2.unregisterHostAbility(this);
        return;
    }

    @Override // com.bytedance.ee.bear.doc.editmodeswitchplugin.IEditModeSwitchViewPlugin
    public void setEditButtonVisibilityFromNative(boolean r3) {
        tt5.a.h(TAG, "setEditButtonVisibilityFromNative, show = " + r3 + ", canVisibleFromFrontend = " + this.isEditButtonCanVisible);
        this.isEditButtonCanVisibleFromNative = r3;
        updateEditButtonVisibility();
    }

    public static /* synthetic */ void access$1000(EditModeSwitchPlugin r0, int r1) {
        r0.updateTitleBarinDOB(r1);
    }

    public static /* synthetic */ void access$1200(EditModeSwitchPlugin r0, boolean r1) {
        r0.setCompleteButtonVisible(r1);
    }

    public static /* synthetic */ boolean access$402(EditModeSwitchPlugin r0, boolean r1) {
        r0.isInEditStatus = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(EditModeSwitchPlugin r0, Boolean r1) {
        r0.notifyOrientationSupportPanelState(r1);
    }

    public static /* synthetic */ boolean access$602(EditModeSwitchPlugin r0, boolean r1) {
        r0.isEditButtonCanVisible = r1;
        return r1;
    }

    private /* synthetic */ void lambda$observeEditSwitchHeight$1(BaseAnnounceTemplateViewModel r2, Boolean r3) {
        if (this.mEditModeSwitchView != null) goto L5;
        return;
    L5:
        if (r2.getPanelLocOnScreenS() == null) goto L14;
        int r4 = r2.getPanelLocOnScreenS()[1];
        if (r3.booleanValue() == false) goto L10;
        int r5 = r4 - 350;
    L11:
        this.mEditModeSwitchView.setY(r5);
        return;
    L10:
        r5 = r4 + EDIT_BUTTON_WITH_ANNOUNCE_INVISIBLE_LOCATION_Y;
        goto L11
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r6, t r7) {
        super.onAttachToUIContainer(r6, r7);
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.template_preview) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
    L13:
        attachAsideCommentLayoutListener();
        applyEditModeSwitchMargin();
        getTitleBar().g(this);
        return;
    L8:
        if (this.mEditModeSwitchView != null) goto L13;
        CommonEditButton r9 = new CommonEditButton(getContext());
        this.mEditModeSwitchView = r9;
        SpaceShadowLayout r0 = r9.getEditButtonShadowFromXml();
        r0.setShadowSize(UDShadowLayout.Size.S3);
        r0.setShadowDirection(UDShadowLayout.Direction.NONE);
        r0.setShadowRadius(new UDDimension.Dp(12));
        r0.setPadding(r0.getPaddingLeft(), r0.getPaddingTop(), UIUtils.dp2px(r9.getContext(), 4.0f), r0.getPaddingBottom());
        AppCompatImageView r10 = r9.getEditButtonFromXml();
        if (r10 == null) goto L12;
        r10.setImageResource(2131231965);
    L12:
        this.mEditModeSwitchView.setOnClickListener(new com.bytedance.ee.bear.doc.editmodeswitchplugin.g(this));
        captureDefaultButtonMarginIfNeed();
        applyEditModeSwitchMargin();
        r7.h(this, this.mEditModeSwitchView);
        goto L13
    L5:
        r8 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        getTitleBar().c(this);
        detachAsideCommentLayoutListener();
        CommonEditButton r3 = this.mEditModeSwitchView;
        if (r3 == null) goto L6;
        r2.m(this, r3);
        this.mEditModeSwitchView = null;
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadFail(int r3, Throwable r4) {
        tt5.a.i(TAG, "load fail, token is " + du5.b.g(getDocumentMetadata().getToken()) + " code is " + r3, r4);
        hideButton();
        this.isLoadDocSuccess = false;
        setCompleteButtonVisible(false);
    }

    @Override // com.bytedance.ee.bear.doc.editmodeswitchplugin.IEditModeSwitchViewPlugin
    public void setEditModeSwitchMargin(int r3, int r4, int r5, int r6) {
        tt5.a.h(TAG, "setEditModeSwitchPadding, bottom = " + r6);
        Rect r0 = this.mPendingPaddingRect;
        if (r0 != null) goto L5;
        this.mPendingPaddingRect = new Rect(r3, r4, r5, r6);
    L7:
        if (this.mEditModeSwitchView != null) goto L10;
        tt5.a.k(TAG, "setEditModeSwitchPadding delayed, mEditModeSwitchView is null");
        return;
    L10:
        applyEditModeSwitchMargin();
        this.mEditModeSwitchView.requestLayout();
        return;
    L5:
        r0.set(r3, r4, r5, r6);
        goto L7
    }

    private /* synthetic */ void lambda$new$0(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L7;
        if (r3 != r7) goto L7;
        if (r4 != r8) goto L7;
        if (r5 != r9) goto L7;
        return;
    L7:
        applyEditModeSwitchMargin();
    }
}
