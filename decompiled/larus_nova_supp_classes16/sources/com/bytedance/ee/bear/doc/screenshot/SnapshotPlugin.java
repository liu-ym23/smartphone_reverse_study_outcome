package com.bytedance.ee.bear.doc.screenshot;

import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.EditModeSwitchPlugin;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.ability.ISnapshotPlugin;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.vfs.VFSPath;
import fz4.b0;
import fz4.c0;
import fz4.r;
import fz4.x;
import iz4.n;
import iz4.o;
import iz4.p;
import iz4.w;
import java.util.Map;
import sbb.e;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SnapshotPlugin extends DocumentPlugin implements ISnapshotPlugin<DocumentPluginHost>, sa5.d, m.c {
    private static final String TAG = "SnapshotPlugin";
    private DocShotFragment mFragment;
    private final MutableLiveData<Boolean> snapshottingLiveData;

    public class a implements i<String> {
        public final /* synthetic */ SnapshotPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(SnapshotPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            tt5.a.h(SnapshotPlugin.TAG, "onScreenShotExit");
            if (SnapshotPlugin.access$300(this.a) == null) goto L14;
            DocShotFragment r5 = SnapshotPlugin.access$300(this.a);
            r5.getClass();
            tt5.a.h("DocShotFragment", "onScreenShotExit");
            DocShotPresenter r6 = r5.j;
            if (r6 == null) goto L15;
            r r7 = r6.d;
            if (r7 == null) goto L12;
            j.e(r7);
            b0 r8 = r6.f;
            if (r8 == null) goto L11;
            ((DocShotView) r8).f();
        L11:
            r6.d = null;
        L12:
            r6.e();
            return;
        L15:
            return;
        }
    }

    public class b implements i<DocShotModel> {
        public final /* synthetic */ SnapshotPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SnapshotPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, tb5.m r11) {
            DocShotModel r12 = (DocShotModel) r10;
            tt5.a.h(SnapshotPlugin.TAG, "onScreenShotReady:" + r12.success);
            rcb.c.c(SnapshotPlugin.access$200(this.a));
            if (SnapshotPlugin.access$300(this.a) == null) goto L36;
            DocShotPresenter r13 = SnapshotPlugin.access$300(this.a).j;
            if (r13 == null) goto L37;
            boolean r0 = r12.success;
            r13.q = System.currentTimeMillis();
            tt5.a.b("DocShotPresenter", "docShotReady()...success = " + r0 + ", backPressed = " + r13.o);
            if (r13.o == false) goto L9;
            tt5.a.h("DocShotPresenter", "docShotReady()... has backpressed");
            return;
        L9:
            if (r0 == false) goto L34;
            b0 r14 = r13.f;
            if (r14 == null) goto L13;
            r14.setSnapState(true);
        L13:
            WebView r16 = r13.g;
            if (r16 == null) goto L33;
            r16.measure(0, 0);
            int r17 = r13.g.getMeasuredWidth();
            int r1 = r13.g.getMeasuredHeight();
            if (r17 <= 0) goto L32;
            if (r1 <= 0) goto L32;
            int r2 = r13.g.getHeight();
            tt5.a.h("DocShotPresenter", "captureWebViewIfNeed()... count = " + (r1 / r2) + ", contentHeight =" + r1 + ", contentWidth =" + r17 + ",height = " + r2);
            if (r13.s == false) goto L22;
            VFSPath r3 = cm5.a.a(r13.n);
        L23:
            n r4 = new n(r13.e, r13.g, r3, r13.b, new x(r13, r17, r1, r2));
            r4.f = r17;
            r4.g = r1;
            r4.h = r13.g.getHeight();
            boolean r18 = r13.s;
            boolean r5 = r13.t;
            hz4.b r6 = new hz4.b();
            r13.a = r6;
            if (r5 == false) goto L28;
            if (r18 == false) goto L27;
            r6.a = new p(r4);
        L31:
            r13.a.start();
            return;
        L27:
            r6.a = new o(r4);
            goto L31
        L28:
            if (r18 == false) goto L30;
            r6.a = new w(r4);
            goto L31
        L30:
            r6.a = new iz4.m(r4);
            goto L31
        L22:
            r3 = cm5.a.b().getVfsPath();
        L32:
            tt5.a.d("DocShotPresenter", "webView size is  0, width: " + r17 + ", height: " + r1);
            r13.i("web view  size error", null);
            return;
        L33:
            tt5.a.d("DocShotPresenter", "captureWebViewIfNeed while getWebView null");
            r13.i("web view == null", null);
            return;
        L34:
            r13.i("docShotReady(), is success = false", r12);
            return;
        L37:
            return;
        }
    }

    public static /* synthetic */ void c(SnapshotPlugin r0) {
        r0.lambda$startSnapShot$0();
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SnapshotPlugin() {
        this.snapshottingLiveData = new MutableLiveData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$startSnapShot$0() {
        BaseTitlePlugin r0 = (BaseTitlePlugin) ((DocumentPluginHost) getHost()).findPlugin(BaseTitlePlugin.class);
        if (r0 == null) goto L5;
        r0.setAppBarLayoutVisible();
    L5:
        EditModeSwitchPlugin r1 = (EditModeSwitchPlugin) ((DocumentPluginHost) getHost()).findPlugin(EditModeSwitchPlugin.class);
        if (r1 == null) goto L8;
        r1.showButton();
    L8:
        this.snapshottingLiveData.setValue(Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.document.ability.ISnapshotPlugin
    public /* bridge */ /* synthetic */ LiveData getSnapshottingLiveData() {
        return m146getSnapshottingLiveData();
    }

    /* JADX INFO: renamed from: getSnapshottingLiveData, reason: collision with other method in class */
    public MutableLiveData<Boolean> m146getSnapshottingLiveData() {
        return this.snapshottingLiveData;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_screenshot_SnapshotPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DocShotFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static /* synthetic */ FragmentActivity access$200(SnapshotPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ DocShotFragment access$300(SnapshotPlugin r0) {
        return r0.mFragment;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.doc.screenshotReady", new b(this));
        r3.put("biz.doc.screenshotExit", new a(this));
    }

    public void onRequestSnapshot(String r3) {
        tt5.a.h(TAG, "onRequestSnapshot()...1");
        startSnapShot(r3, null, null);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        ((m) org.koin.java.a.a(m.class)).k(this);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        ((m) org.koin.java.a.a(m.class)).n(this);
    }

    public void onRequestSnapshot(String r3, m.b r4) {
        tt5.a.h(TAG, "onRequestSnapshot()...2");
        startSnapShot(r3, null, r4);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.contract.m.c
    public void onRequestSnapshot(String r3, String r4) {
        tt5.a.h(TAG, "onRequestSnapshot()...1 exportType");
        startSnapShot(r3, r4, null);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_screenshot_SnapshotPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DocShotFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DocShotFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startSnapShot(String r7, String r8, m.b r9) {
        if (getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L7;
        tt5.a.k(TAG, "onRequestSnapshot, activity is not RESUMED");
        return;
    L7:
        if (getUIContainer() != null) goto L10;
        tt5.a.k(TAG, "onRequestSnapshot After ui detach");
        return;
    L10:
        DocShotFragment r0 = this.mFragment;
        if (r0 == null) goto L13;
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_screenshot_SnapshotPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
    L13:
        this.snapshottingLiveData.setValue(Boolean.TRUE);
        DocShotFragment r1 = Fragment.instantiate(getActivity(), DocShotFragment.class.getName(), null);
        this.mFragment = r1;
        r1.setStyle(0, 2131952049);
        boolean r2 = "mindnote".equals(getDocViewModel().getDocumentType());
        WebView r3 = getWeb().getWebView();
        BearUrl r4 = getDocViewModel().getBearUrl();
        getDocViewModel().isType(e.n);
        String r5 = (String) getDocViewModel().getDocName().getValue();
        DocShotFragment r6 = this.mFragment;
        getActivity();
        r6.getClass();
        r6.i = r2;
        r6.k = r3;
        r6.l = r4;
        r6.m = r7;
        r6.n = r8;
        r6.o = r9;
        r6.p = r5;
        DocShotFragment r10 = this.mFragment;
        r10.q = new c0(this);
        EditModeSwitchPlugin r11 = (EditModeSwitchPlugin) ((DocumentPluginHost) getHost()).findPlugin(EditModeSwitchPlugin.class);
        if (r11 == null) goto L16;
        r11.hideButton();
    L16:
        BaseTitlePlugin r12 = (BaseTitlePlugin) ((DocumentPluginHost) getHost()).findPlugin(BaseTitlePlugin.class);
        if (r12 == null) goto L19;
        r12.setAppBarLayoutInvisible();
    L19:
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_screenshot_SnapshotPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(this.mFragment, getActivity().getSupportFragmentManager(), TAG);
    }

    @Override // com.bytedance.ee.bear.contract.m.c
    public void onRequestSnapshot(String r3, String r4, m.b r5) {
        tt5.a.h(TAG, "onRequestSnapshot()...2 exportType");
        startSnapShot(r3, r4, r5);
    }
}
