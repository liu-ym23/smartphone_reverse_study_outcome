package com.bytedance.ee.bear.document.restore;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.document.z5;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.ui.l;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "<init>", "()V", "commonAbility", "Lcom/bytedance/ee/bear/document/FileCommonAbility;", "docDeletedView", "Lcom/bytedance/ee/bear/IDocDeletedView;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "showDeleted", "getDesc", "", "context", "Landroid/content/Context;", "getResId", "", "reloadFile", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDeletedPlugin extends BasePluginV2 {
    public static final a Companion = null;
    private static final String TAG = "DocDeletedPlugin";
    private r4 commonAbility;
    private com.bytedance.ee.bear.b docDeletedView;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DocDeletedPlugin a;
        public final /* synthetic */ t b;

        public b(DocDeletedPlugin r1, t r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            r4.a r7 = (r4.a) r6;
            if ((r7 instanceof r4.a.C0096a) == true) goto L5;
            return;
        L5:
            if (((r4.a.C0096a) r7).a == (-55)) goto L7;
            return;
        L7:
            if (DocDeletedPlugin.access$isUIContainerAttached(this.a) == false) goto L16;
            tt5.a.h(DocDeletedPlugin.TAG, "DocDeletedPlugin.showDeleted");
            DocDeletedPlugin.access$showDeleted(this.a, this.b);
            r4 r8 = DocDeletedPlugin.access$getCommonAbility$p(this.a);
            if (r8 == null) goto L11;
            BearUrl r9 = r8.getOriginBearUrl();
        L12:
            String r10 = com.bytedance.ee.bear.route.c.f(r9);
            DocDeletedPlugin r1 = this.a;
            ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).d(CollectionsKt.listOf(r10));
            ((h) org.koin.java.a.c(h.class, null, null, 6)).N9(r10, DocDeletedPlugin.access$getContext(r1).getResources().getString(2131889867));
            return;
        L11:
            r9 = null;
            goto L12
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            tt5.a.h(DocDeletedPlugin.TAG, "reloadWebView ok: " + ((Boolean) r3));
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r4) {
            tt5.a.e(DocDeletedPlugin.TAG, "reloadWebView err ", (Throwable) r4, false);
        }
    }

    public static final class e implements com.bytedance.ee.bear.b.a {
        public final /* synthetic */ com.bytedance.ee.bear.b a;
        public final /* synthetic */ DocDeletedPlugin b;
        public final /* synthetic */ t c;

        public final void a() {
            tt5.a.h(DocDeletedPlugin.TAG, "DocDeletedPlugin.onRestoreSuccess, reloadFile");
            this.a.hide();
            bn4.a r0 = (bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6);
            if (r0.a(this.b.getHost()) == false) goto L5;
            r0.n(this.c);
        L5:
            DocDeletedPlugin.access$reloadFile(this.b);
        }

        public e(DocDeletedCtrlView r1, DocDeletedPlugin r2, t r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ String a;

        public f(String r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ((h) org.koin.java.a.c(h.class, null, null, 6)).D4(this.a);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ rz4.a a;
        public final /* synthetic */ DocDeletedPlugin b;

        public g(rz4.a r1, DocDeletedPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(DocDeletedPlugin.TAG, "deleteView Back click");
            if (this.a.processContentEvent(new sz4.a()) == true) goto L6;
            DocDeletedPlugin.access$getActivity(this.b).onBackPressed();
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final int getResId() {
        e4 r0 = (e4) getHostAbilityOrNull(e4.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        y3 r2 = r0.getDocumentMetadata();
        if (r2 == null) goto L9;
        if (r2.isSyncBlock() != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        return 2131232580;
    L11:
        return 2131232549;
    }

    private final void reloadFile() {
        r4 r0 = this.commonAbility;
        if (r0 == null) goto L36;
        String r1 = r0.getOriginUrl();
        if (r1 == null) goto L40;
        r4 r2 = this.commonAbility;
        if (r2 == null) goto L37;
        Fragment r3 = r2.getFragment();
        if (r3 != null) goto L13;
        return;
    L13:
        if ((r3 instanceof WebFragment) == false) goto L34;
        PluginHost r4 = getHost();
        if ((r4 instanceof WebPluginHost) == false) goto L19;
        k r5 = ((WebPluginHost) r4).getWeb();
        if (r5 == null) goto L19;
        WebView r6 = r5.getWebView();
    L21:
        if (r6 == null) goto L23;
        tt5.a.h(TAG, "reloadWebView, instance: " + r6.hashCode());
        ((m) org.koin.java.a.c(m.class, null, null, 6)).j(r6, false).subscribe(c.a, d.a);
    L23:
        boolean r7 = r6 instanceof ChameleonWebView;
        if (r7 == false) goto L30;
        if (r7 == false) goto L27;
        ChameleonWebView r8 = (ChameleonWebView) r6;
    L28:
        if (r8 == null) goto L30;
        r8.destroyWebview();
        goto L30
    L27:
        r8 = null;
    L30:
        z5 r9 = (z5) getHost().getHostAbilityOrNull(z5.class);
        if (r9 == null) goto L33;
        r9.reloadDocumentFragment(r1, null);
        return;
    L33:
        tt5.a.h(TAG, "reloadAbility is null");
        return;
    L19:
        r6 = null;
        goto L21
    L34:
        RouteBean r10 = new RouteBean();
        Bundle r11 = new Bundle();
        r11.putBoolean("addToBackStack", false);
        r11.putBoolean("force_load_same", true);
        r11.putBoolean("force_single_top", true);
        r10.n = r11;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).m9(r1, r10);
        return;
    L37:
        return;
    L40:
        return;
    }

    public DocDeletedPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DocDeletedPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ r4 access$getCommonAbility$p(DocDeletedPlugin r0) {
        return r0.commonAbility;
    }

    public static final /* synthetic */ Context access$getContext(DocDeletedPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(DocDeletedPlugin r0) {
        return r0.isUIContainerAttached();
    }

    public static final /* synthetic */ void access$reloadFile(DocDeletedPlugin r0) {
        r0.reloadFile();
    }

    private final String getDesc(Context r4) {
        e4 r0 = (e4) getHostAbilityOrNull(e4.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        y3 r2 = r0.getDocumentMetadata();
        if (r2 == null) goto L9;
        if (r2.isSyncBlock() != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        String r5 = r4.getResources().getString(2131889296);
        Intrinsics.checkNotNull(r5);
        return r5;
    L11:
        String r6 = r4.getResources().getString(2131889867);
        Intrinsics.checkNotNull(r6);
        return r6;
    }

    private final void showDeleted(t r8) {
        boolean r1 = false;
        DocsOpenSource r2 = null;
        if (this.docDeletedView != null) goto L42;
        Context r0 = getContext();
        if (r0 != null) goto L7;
        return;
    L7:
        r4 r3 = this.commonAbility;
        if (r3 == null) goto L41;
        String r4 = r3.getOriginUrl();
        if (r4 == null) goto L58;
        DocDeletedCtrlView r5 = new DocDeletedCtrlView(r0, null);
        r5.b(getHost(), getLifecycleOwner(), r4);
        r5.setDelegate(new e(r5, this, r8));
        r4 r6 = this.commonAbility;
        if (r6 == null) goto L15;
        HashMap<String, Object> r7 = r6.getReportCommonParams();
    L16:
        r5.setReportCommonParams(r7);
        r4 r9 = this.commonAbility;
        if (r9 == null) goto L21;
        BearUrl r10 = r9.getBearUrl();
        if (r10 == null) goto L21;
        String r11 = r10.a;
    L23:
        if (Intrinsics.areEqual(r11, sbb.e.l.getType()) == false) goto L25;
    L26:
        r5.setTitleBarVisible(false);
    L27:
        bn4.a r12 = (bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6);
        if (r12.a(getHost()) == false) goto L30;
        r5.setTitleBarVisible(false);
        r12.g(r8, r5);
    L31:
        this.docDeletedView = r5;
        r4 r13 = this.commonAbility;
        if (r13 == null) goto L34;
        BearUrl r14 = r13.getOriginBearUrl();
    L35:
        String r16 = com.bytedance.ee.bear.route.c.f(r14);
        if (((h) org.koin.java.a.c(h.class, null, null, 6)).Xb(r16) == false) goto L38;
        r5.setBackListener(new f(r16));
    L38:
        rz4.a r17 = (rz4.a) getHost().getHostAbilityOrNull(rz4.a.class);
        if (r17 == null) goto L42;
        r5.setBackIcon(l.a(r0, r17.getLeftImageResource(), 2131101926));
        r5.setBackListener(new g(r17, this));
        goto L42
    L34:
        r14 = null;
        goto L35
    L30:
        r5.a(r8.c(this), null);
        goto L31
    L25:
        if (StringsKt.contains$default(r4, "base_instruction_docx", false, 2, null) == false) goto L27;
    L21:
        r11 = null;
        goto L23
    L15:
        r7 = null;
        goto L16
    L58:
        return;
    L41:
        return;
    L42:
        com.bytedance.ee.bear.b r18 = this.docDeletedView;
        if (r18 == null) goto L54;
        DocsOpenSource r19 = DocsOpenSource.vc;
        e4 r20 = (e4) getHostAbilityOrNull(e4.class);
        if (r20 == null) goto L49;
        y3 r21 = r20.getDocumentMetadata();
        if (r21 == null) goto L49;
        r2 = r21.getOpenSource();
    L49:
        if (r19 != r2) goto L51;
    L53:
        r18.setBackIconVisible(r1);
        goto L54
    L51:
        if (r8.getTitleBar().isLeftIconVisible() == false) goto L53;
        r1 = true;
    L54:
        com.bytedance.ee.bear.b r22 = this.docDeletedView;
        if (r22 == null) goto L59;
        r22.show(getDesc(getContext()), getResId());
        return;
    }

    public static final /* synthetic */ void access$showDeleted(DocDeletedPlugin r0, t r1) {
        r0.showDeleted(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r3, t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        super.onAttachToUIContainer(r3, r4);
        r4 r0 = (r4) getHostAbilityOrNull(r4.class);
        if (r0 != null) goto L5;
        return;
    L5:
        this.commonAbility = r0;
        LiveData<r4.a> r1 = r0.getLoadState();
        if (r1 != null) goto L8;
        return;
    L8:
        r1.observe(r3.getLifecycleOwner(), new b(this, r4));
    }
}
