package com.bytedance.ee.bear.document.minutes;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocActivity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/minutes/MinutesThreeInOneRedirectPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "latestDocumentInfo", "Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "latestRealSubType", "", "Ljava/lang/Integer;", "latestObjToken", "", "redirectStarted", "", "nativeContentHidden", "contentView", "Landroid/view/View;", "documentInfoObserver", "Landroidx/lifecycle/Observer;", "objTokenObserver", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "tryRedirect", "isVcOpenSource", "traceRouteTokensIfNeeded", "closeDocument", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinutesThreeInOneRedirectPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String TAG = "MinutesThreeInOneRedirectPlugin";
    private static final int TARGET_REAL_SUB_TYPE = 131;
    private View contentView;
    private final Observer<DocumentInfo> documentInfoObserver;
    private DocumentInfo latestDocumentInfo;
    private String latestObjToken;
    private Integer latestRealSubType;
    private boolean nativeContentHidden;
    private final Observer<String> objTokenObserver;
    private boolean redirectStarted;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ MinutesThreeInOneRedirectPlugin a;

        public b(MinutesThreeInOneRedirectPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DocumentInfo r3 = (DocumentInfo) r2;
            MinutesThreeInOneRedirectPlugin.access$setLatestDocumentInfo$p(this.a, r3);
            MinutesThreeInOneRedirectPlugin r0 = this.a;
            if (r3 == null) goto L7;
            DocMetaInfo r4 = r3.getDocMetaInfo();
            if (r4 == null) goto L7;
            Integer r5 = Integer.valueOf(r4.getRealSubType());
        L8:
            MinutesThreeInOneRedirectPlugin.access$setLatestRealSubType$p(r0, r5);
            MinutesThreeInOneRedirectPlugin.access$traceRouteTokensIfNeeded(this.a);
            MinutesThreeInOneRedirectPlugin.access$tryRedirect(this.a);
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ MinutesThreeInOneRedirectPlugin a;

        public c(MinutesThreeInOneRedirectPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            String r4 = (String) r3;
            MinutesThreeInOneRedirectPlugin r0 = this.a;
            if (r4 != null) goto L5;
        L7:
            r4 = null;
        L8:
            MinutesThreeInOneRedirectPlugin.access$setLatestObjToken$p(r0, r4);
            MinutesThreeInOneRedirectPlugin.access$traceRouteTokensIfNeeded(this.a);
            MinutesThreeInOneRedirectPlugin.access$tryRedirect(this.a);
            return;
        L5:
            if ((!StringsKt.isBlank(r4)) == false) goto L7;
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void traceRouteTokensIfNeeded() {
        DocumentInfo r0 = this.latestDocumentInfo;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getDocMetaInfo().getRealSubType() == TARGET_REAL_SUB_TYPE) goto L8;
        return;
    L8:
        String r1 = r0.getObjToken();
        String r3 = null;
        if ((!StringsKt.isBlank(r1)) == true) goto L12;
        r1 = null;
    L12:
        if (r1 != null) goto L25;
        r1 = this.latestObjToken;
        if (r1 != null) goto L25;
        DocViewModel r2 = getDocViewModel();
        if (r2 == null) goto L22;
        r1 = r2.getToken();
        if (r1 == null) goto L22;
        if ((!StringsKt.isBlank(r1)) == false) goto L22;
    L23:
        if (r1 != null) goto L25;
        return;
    L22:
        r1 = null;
    L25:
        String r4 = r0.getDocObjInfo().getWikiInfo().getWikiToken();
        if ((!StringsKt.isBlank(r4)) == true) goto L29;
        r4 = null;
    L29:
        if (r4 != null) goto L38;
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L39;
        WikiInfo r6 = r5.getWikiInfo();
        if (r6 == null) goto L39;
        r4 = r6.getWikiToken();
        if (r4 == null) goto L39;
        if ((!StringsKt.isBlank(r4)) == true) goto L38;
    L39:
        Set<String> r7 = a25.a.a;
        if (TextUtils.isEmpty(r1) == true) goto L43;
        a25.a.a.add(r1);
    L43:
        if (TextUtils.isEmpty(r3) == true) goto L45;
        a25.a.b.add(r3);
    L45:
        tt5.a.h("MinutesThreeInOneRedirector", "traceRouteTokens objToken=" + du5.b.g(r1) + ", wikiToken=" + du5.b.g(r3));
        return;
    L38:
        r3 = r4;
        goto L39
    }

    public MinutesThreeInOneRedirectPlugin() {
        this.documentInfoObserver = new b(this);
        this.objTokenObserver = new c(this);
    }

    private final void closeDocument() {
        PluginHost r0 = getHost();
        BaseCommonActivity r1 = null;
        if (r0 == null) goto L13;
        Fragment r2 = r0.getHostFragment();
        if (r2 == null) goto L13;
        if (ForsetiHelper.s(r2) == false) goto L13;
        g r3 = f.b(r2);
        if (r3 == null) goto L24;
        r3.g(null);
        return;
    L24:
        return;
    L13:
        FragmentActivity r4 = getActivity();
        if ((r4 instanceof BaseCommonActivity) == false) goto L16;
        r1 = (BaseCommonActivity) r4;
    L16:
        if (r1 == null) goto L20;
        DocActivity.a r5 = (DocActivity.a) r1.vb(DocActivity.a.class);
        if (r5 == null) goto L20;
        boolean r6 = r5.j();
    L21:
        if (r6 == true) goto L25;
        getActivity().finish();
        return;
    L25:
        return;
    L20:
        r6 = false;
        goto L21
    }

    private final boolean isVcOpenSource() {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L5;
        DocsOpenSource r1 = r0.getOpenSource();
    L7:
        if (r1 != DocsOpenSource.vc) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    private final void tryRedirect() {
        if (isVcOpenSource() == false) goto L5;
        return;
    L5:
        if (this.redirectStarted == true) goto L42;
        Integer r0 = this.latestRealSubType;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.intValue() != TARGET_REAL_SUB_TYPE) goto L44;
        String r1 = this.latestObjToken;
        if (r1 != null) goto L22;
        DocViewModel r2 = getDocViewModel();
        if (r2 == null) goto L21;
        r1 = r2.getToken();
        if (r1 == null) goto L21;
        if ((!StringsKt.isBlank(r1)) == true) goto L22;
    L21:
        r1 = null;
    L22:
        if (r1 != null) goto L24;
    L27:
        boolean r3 = true;
    L29:
        if (r3 == false) goto L32;
        tt5.a.h(TAG, "tryRedirect waiting objToken");
        return;
    L32:
        Context r4 = getActivity();
        if (r4 != null) goto L39;
        r4 = getContext();
        if (r4 != null) goto L39;
        this.redirectStarted = true;
        tt5.a.d(TAG, "tryRedirect context missing");
        return;
    L39:
        this.redirectStarted = true;
        a25.a.a(r4, r1, null);
        tt5.a.h(TAG, "tryRedirect, token=" + du5.b.g(r1));
        closeDocument();
        return;
    L24:
        if (StringsKt.isBlank(r1) == true) goto L27;
        r3 = false;
        goto L29
    L44:
        return;
    }

    public static final /* synthetic */ void access$traceRouteTokensIfNeeded(MinutesThreeInOneRedirectPlugin r0) {
        r0.traceRouteTokensIfNeeded();
    }

    public static final /* synthetic */ void access$tryRedirect(MinutesThreeInOneRedirectPlugin r0) {
        r0.tryRedirect();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        DocViewModel r4 = getDocViewModel();
        String r0 = null;
        if (r4 == null) goto L9;
        String r5 = r4.getToken();
        if (r5 == null) goto L9;
        if ((!StringsKt.isBlank(r5)) == false) goto L9;
        r0 = r5;
    L9:
        this.latestObjToken = r0;
        DocViewModel r6 = getDocViewModel();
        if (r6 == null) goto L14;
        MutableLiveData<DocumentInfo> r7 = r6.liveDocumentInfoData();
        if (r7 == null) goto L14;
        r7.observe(getLifecycleOwner(), this.documentInfoObserver);
    L14:
        DocViewModel r8 = getDocViewModel();
        if (r8 == null) goto L19;
        LiveData<String> r9 = r8.liveDocObjToken();
        if (r9 == null) goto L19;
        r9.observe(getLifecycleOwner(), this.objTokenObserver);
    L19:
        tryRedirect();
    }

    public static final /* synthetic */ void access$setLatestDocumentInfo$p(MinutesThreeInOneRedirectPlugin r0, DocumentInfo r1) {
        r0.latestDocumentInfo = r1;
    }

    public static final /* synthetic */ void access$setLatestObjToken$p(MinutesThreeInOneRedirectPlugin r0, String r1) {
        r0.latestObjToken = r1;
    }

    public static final /* synthetic */ void access$setLatestRealSubType$p(MinutesThreeInOneRedirectPlugin r0, Integer r1) {
        r0.latestRealSubType = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        if (r2 == null) goto L5;
        View r3 = r2.getContentView();
    L6:
        this.contentView = r3;
        tryRedirect();
        return;
    L5:
        r3 = null;
        goto L6
    }
}
