package com.bytedance.ee.bear.doc.screenshot.plugin;

import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.doc.screenshot.DocShotModel;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.h;
import com.ss.android.lark.vfs.VFSPath;
import java.util.HashMap;
import java.util.Map;
import jz4.k;
import jz4.l;
import kotlin.Unit;
import lz4.n;
import lz4.o;
import lz4.p;
import lz4.w;
import rcb.c;
import sa5.d;
import sbb.e;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeSnapshotPlugin extends DocumentPluginV3 implements d, wz4.b {
    private static final String TAG = "SnapshotPlugin";
    private OfficeDocShotPresenter docShotPresenter;

    public class a implements i<String> {
        public final /* synthetic */ OfficeSnapshotPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeSnapshotPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            tt5.a.h(OfficeSnapshotPlugin.TAG, "onScreenShotExit");
            if (OfficeSnapshotPlugin.access$300(this.a) == null) goto L12;
            OfficeDocShotPresenter r4 = OfficeSnapshotPlugin.access$300(this.a);
            jz4.a r5 = r4.n;
            if (r5 == null) goto L10;
            j.e(r5);
            wz4.a r6 = r4.r;
            if (r6 == null) goto L9;
            r6.onHideShotView();
        L9:
            r4.n = null;
        L10:
            r4.c();
            return;
        }
    }

    public class b implements i<DocShotModel> {
        public final /* synthetic */ OfficeSnapshotPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeSnapshotPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r11, m r12) {
            DocShotModel r13 = (DocShotModel) r11;
            tt5.a.h(OfficeSnapshotPlugin.TAG, "onScreenShotReady:" + r13.success);
            c.c(OfficeSnapshotPlugin.access$200(this.a));
            if (OfficeSnapshotPlugin.access$300(this.a) == null) goto L35;
            OfficeDocShotPresenter r14 = OfficeSnapshotPlugin.access$300(this.a);
            r14.getClass();
            tt5.a.b("OfficeDocShotPresenter", "docShotReady()...success = " + r13.success + ", backPressed = " + r14.g);
            if (r14.g == false) goto L8;
            tt5.a.h("OfficeDocShotPresenter", "docShotReady()... has backpressed");
            return;
        L8:
            if (r13.success == false) goto L33;
            wz4.a r16 = r14.r;
            if (r16 == null) goto L12;
            r16.setSnapState(true);
        L12:
            WebView r17 = r14.e;
            if (r17 == null) goto L32;
            r17.measure(0, 0);
            int r18 = r14.e.getMeasuredWidth();
            int r2 = r14.e.getMeasuredHeight();
            if (r18 <= 0) goto L31;
            if (r2 <= 0) goto L31;
            int r0 = r14.e.getHeight();
            tt5.a.h("OfficeDocShotPresenter", "captureWebViewIfNeed()... count = " + (r2 / r0) + ", contentHeight =" + r2 + ", contentWidth =" + r18 + ",height = " + r0);
            if (r14.a == false) goto L21;
            VFSPath r1 = cm5.a.a(r14.h.f);
        L22:
            n r3 = new n(r14.d, r14.e, r1, r14.i, new jz4.i(r14, r18, r2, r0), r14.s);
            r3.g = r18;
            r3.h = r2;
            r3.i = r14.e.getHeight();
            boolean r19 = r14.a;
            boolean r4 = r14.b;
            kz4.b r5 = new kz4.b();
            r14.l = r5;
            if (r4 == false) goto L27;
            if (r19 == false) goto L26;
            r5.a = new p(r3);
        L30:
            r14.l.start();
            return;
        L26:
            r5.a = new o(r3);
            goto L30
        L27:
            if (r19 == false) goto L29;
            r5.a = new w(r3);
            goto L30
        L29:
            r5.a = new lz4.m(r3);
            goto L30
        L21:
            r1 = cm5.a.b().getVfsPath();
        L31:
            tt5.a.d("OfficeDocShotPresenter", "webView size is  0, width: " + r18 + ", height: " + r2);
            r14.d("web view  size error", null);
            return;
        L32:
            tt5.a.d("OfficeDocShotPresenter", "captureWebViewIfNeed while getWebView null");
            r14.d("web view == null", null);
            return;
        L33:
            r14.d("docShotReady(), is success = false", r13);
            return;
        }
    }

    public static /* synthetic */ Unit a(OfficeSnapshotPlugin r0) {
        return r0.lambda$startSnapShot$1();
    }

    public static /* synthetic */ void c(OfficeSnapshotPlugin r0, wz4.a r1) {
        r0.lambda$startSnapShot$2(r1);
    }

    public static /* synthetic */ Unit d(OfficeSnapshotPlugin r0) {
        return r0.lambda$startSnapShot$0();
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private /* synthetic */ Unit lambda$startSnapShot$1() {
        OfficeDocShotPresenter r0 = this.docShotPresenter;
        if (r0 == null) goto L6;
        r0.f();
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ Unit lambda$startSnapShot$0() {
        BaseTitlePlugin r0 = (BaseTitlePlugin) getHost().findPlugin(BaseTitlePlugin.class);
        if (r0 == null) goto L5;
        r0.setAppBarLayoutVisible();
    L5:
        OfficeDocShotPresenter r1 = this.docShotPresenter;
        if (r1 == null) goto L9;
        r1.f();
    L9:
        return Unit.INSTANCE;
    }

    public OfficeSnapshotPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FragmentActivity access$200(OfficeSnapshotPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ OfficeDocShotPresenter access$300(OfficeSnapshotPlugin r0) {
        return r0.docShotPresenter;
    }

    private /* synthetic */ void lambda$startSnapShot$2(wz4.a r1) {
        r1.dismiss();
        this.docShotPresenter = null;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.doc.screenshotReady", new b(this));
        r3.put("biz.doc.screenshotExit", new a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        r1.registerHostAbility(this);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public void onSaveDocBitmap(final Context r4, wz4.b.a r5) {
        final OfficeDocShotPresenter r6 = this.docShotPresenter;
        if (r6 == null) goto L6;
        h.g(r6.d, new jz4.b(r6, r4), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-ccm_docs_export_image"), new String[0]);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startSnapShot(String r17, wz4.c r18, wz4.a r19) {
        if (getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L6;
        tt5.a.k(TAG, "onRequestSnapshot, activity is not RESUMED");
        return;
    L6:
        if (r19 != null) goto L9;
        tt5.a.k(TAG, "shotUIDelegate After ui detach");
        return;
    L9:
        y3 r3 = getDocumentMetadata();
        boolean r13 = "mindnote".equals(r3.getDocumentType());
        WebView r14 = getHost().getWeb().getWebView();
        BearUrl r16 = r3.getBearUrl();
        boolean r8 = r3.isType(e.n);
        String r4 = (String) r3.getDocName().getValue();
        fz4.c r12 = new fz4.c(r13, r14, r16, r8, r17, r4, null);
        r19.setDismissListener(new jz4.j(this));
        r19.setOnBackPressListener(new k(this));
        BaseTitlePlugin r5 = (BaseTitlePlugin) getHost().findPlugin(BaseTitlePlugin.class);
        if (r5 == null) goto L12;
        r5.setAppBarLayoutInvisible();
    L12:
        OfficeDocShotPresenter r6 = new OfficeDocShotPresenter(getActivity(), r13, getHost().getUserComponent());
        this.docShotPresenter = r6;
        r6.p = new l(this, r19);
        r6.q = r18;
        r6.j = System.currentTimeMillis();
        r6.r = r19;
        r6.i.setValue(Boolean.TRUE);
        r6.g = false;
        r6.h = r12;
        if (r14 == null) goto L19;
        if (r16 == null) goto L19;
        r18.onStartShot(new wz4.c.a(r4));
        r6.e(0, r14);
        if (r6.a == false) goto L18;
        r6.f = r14.getScrollY();
        r14.scrollTo(0, 0);
    L18:
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap<String, Object> r2 = r1.m("docCommonParams");
        r1.n("ccm_space_docs_topbar_view", r2);
        tt5.a.b("OfficeDocShotPresenter", "reportTopBarViewEvent, params = " + r2);
        return;
    L19:
        tt5.a.h("OfficeDocShotPresenter", "startShot()...webView or bearUrl is null");
    }

    @Override // wz4.b
    public void requestSnapshot(String r3, wz4.c r4, wz4.a r5) {
        tt5.a.h(TAG, "onRequestSnapshot()...1");
        startSnapShot(r3, r4, r5);
    }
}
