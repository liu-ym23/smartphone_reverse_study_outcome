package com.bytedance.ee.bear.document.documentinfo;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.WikiNavInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.n;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.contract.route.parcelable.k;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.doccomponent.DocComponentVM;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.forseti.ForsetiVM;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.mainnav.MainNavPlugin;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/WikiNavPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "mObserver", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "handleDocumentInfo", "handleContainerInfo", "containerInfo", "Lcom/bytedance/ee/bear/DocContainerInfo;", "handleMoveToWiki", "wikiToken", "", "logid", "lastToken", "addRouteEntry", "logId", "removeObserveDocumentInfo", "routeToWiki", "checkFinish", "sendMoveToWikiToVC", "generateWikiUrl", "onDetachFromHost", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiNavPlugin extends DocumentPlugin {
    public static final a Companion = null;
    private static final String FROM_MOV_WIKI = "move_to_wiki";
    private static final String TAG = "WikiNavPlugin";
    private static final String VIEW_DOC_HISTORY = "view_doc_history";
    private final CompositeDisposable disposable;
    private final Observer<DocumentInfo> mObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ WikiNavPlugin a;

        public b(WikiNavPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((DocumentInfo) r2, "it");
            WikiNavPlugin.access$handleDocumentInfo(this.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WikiNavPlugin a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ DocumentPluginHost c;

        public c(WikiNavPlugin r1, boolean r2, DocumentPluginHost r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            DocContainerInfo r4 = (DocContainerInfo) r3;
            tt5.a.h(WikiNavPlugin.TAG, "resp doc containerinfo is " + r4);
            WikiNavPlugin r0 = this.a;
            Intrinsics.checkNotNull(r4);
            WikiNavPlugin.access$handleContainerInfo(r0, r4);
            if (this.b == true) goto L12;
            int r5 = r4.getBiz_type();
            int r1 = com.bytedance.ee.bear.a.a;
            if (r5 != 3) goto L13;
            tt5.a.h(WikiNavPlugin.TAG, "do not support phoenix, jump default");
            ((h) org.koin.java.a.c(h.class, null, null, 6)).K8();
            DocumentPluginHost r6 = this.c;
            if (r6 == null) goto L14;
            FragmentActivity r7 = r6.getActivity();
            if (r7 == null) goto L15;
            r7.finish();
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            tt5.a.d(WikiNavPlugin.TAG, "request doc containerinfo error " + ((Throwable) r3).getMessage());
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiNavPlugin() {
        this.mObserver = new b(this);
        this.disposable = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkFinish() {
        if (getDocViewModel().getOpenSource() != DocsOpenSource.vc) goto L5;
        return;
    L5:
        if (getDocViewModel().getOpenSource() != DocsOpenSource.doc_component) goto L7;
        return;
    L7:
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).c()) == false) goto L9;
        return;
    L9:
        if (AppInfoUtils.f().booleanValue() == true) goto L15;
        ((DocumentPluginHost) getHost()).getActivity().getIntent().putExtra("release_webview", false);
        ((DocumentPluginHost) getHost()).getActivity().finish();
        ((DocumentPluginHost) getHost()).getActivity().overridePendingTransition(0, 0);
        return;
    }

    private final void handleDocumentInfo() {
        DocumentInfo r0 = getDocViewModel().getDocumentInfoData();
        if (r0 == null) goto L5;
        DocObjInfo r1 = r0.getDocObjInfo();
    L6:
        if (r1 == null) goto L10;
        WikiNavInfo r2 = r1.getWikiInfo();
        if (r2 == null) goto L10;
        boolean r3 = r2.isWiki();
    L11:
        if (r3 == true) goto L13;
        return;
    L13:
        if (r1 == null) goto L20;
        WikiNavInfo r4 = r1.getWikiInfo();
        if (r4 == null) goto L20;
        String r5 = r4.getWikiToken();
        if (r5 == null) goto L20;
        String r6 = r5;
    L21:
        if (r1 == null) goto L26;
        String r7 = r1.getLogId();
        if (r7 == null) goto L26;
        String r8 = r7;
    L27:
        handleMoveToWiki$default(this, r6, r8, null, 4, null);
        return;
    L26:
        r8 = "";
    L20:
        r6 = "";
    L10:
        r3 = false;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removeObserveDocumentInfo() {
        DocumentPluginHost r0 = (DocumentPluginHost) getHost();
        if (r0 == null) goto L10;
        DocViewModel r1 = r0.a();
        if (r1 == null) goto L11;
        MutableLiveData<DocumentInfo> r2 = r1.liveDocumentInfoData();
        if (r2 == null) goto L12;
        r2.removeObserver(this.mObserver);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void sendMoveToWikiToVC() {
        if (getDocViewModel().getOpenSource() != DocsOpenSource.vc) goto L6;
        ((DocumentPluginHost) getHost()).findPluginToDo(FollowPlugin.class, e.a);
        return;
    }

    public static final /* synthetic */ void access$handleDocumentInfo(WikiNavPlugin r0) {
        r0.handleDocumentInfo();
    }

    private final String generateWikiUrl(String r5) {
        if (ce5.b.a("ccm.mobile.domain_geo_replace_ecm") == false) goto L11;
        BearUrl r0 = getDocViewModel().getOriginBearUrl();
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.d;
    L9:
        return z75.d.b(r5, r1, getDocViewModel().getOriginUrl());
    L7:
        r1 = null;
        goto L9
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L14;
        return "";
    L14:
        BearUrl r2 = getDocViewModel().getOriginBearUrl();
        if (r2 == null) goto L18;
        Map<String, String> r3 = r2.d;
        if (r3 == null) goto L18;
    L20:
        if (r3.containsKey(DocRedirectToDocxPlugin.FROM) == true) goto L23;
        r3.put(DocRedirectToDocxPlugin.FROM, "move_to_wiki");
    L23:
        return p.a().Fd(getDocViewModel().getOriginUrl(), sbb.e.n.getType(), r5, r3);
    L18:
        r3 = new HashMap();
        goto L20
    }

    private final void handleContainerInfo(DocContainerInfo r3) {
        getDocViewModel().setContainerType(r3.getBiz_type());
        if (getDocViewModel().isType(sbb.e.n) == false) goto L5;
        return;
    L5:
        int r0 = r3.getBiz_type();
        int r1 = com.bytedance.ee.bear.a.a;
        if (r0 != 2) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        handleMoveToWiki(r3.getNode_token(), r3.getLogId(), getDocViewModel().getOriginBearUrl().b);
        return;
    L12:
        return;
    L8:
        r2 = false;
        goto L9
    }

    private final void routeToWiki(String r11) {
        String r0 = generateWikiUrl(r11);
        if (TextUtils.isEmpty(r0) == true) goto L6;
        sendMoveToWikiToVC();
        h r1 = (h) org.koin.java.a.c(h.class, null, null, 6);
        tt5.a.h(TAG, "This doc has been moved to wiki. wikiToken: " + du5.b.i(r11));
        WikiRouteBean r2 = new WikiRouteBean(getDocViewModel().getToken(), getDocViewModel().getDocumentTypeValue(), r11, "", "");
        Bundle r12 = new Bundle();
        r12.putBoolean("popLastDocument", true);
        r12.putString("redirect", "move_to_wiki");
        r12.putString("chat_id", getDocViewModel().getChatId());
        ((RouteBean) r2).n = r12;
        ((RouteBean) r2).a = 0;
        int r13 = lw4.a.g;
        ((RouteBean) r2).o = com.bytedance.ee.util.ui.a.a(getActivity());
        r1.m9(r0, r2);
        checkFinish();
        return;
    }

    public void onAttachToHost(DocumentPluginHost r6) {
        tt5.a.b(TAG, "onAttachToHost !");
        super.onAttachToHost(r6);
        if (getDocViewModel().isType(sbb.e.n) == false) goto L5;
        return;
    L5:
        String r0 = getDocViewModel().getToken();
        Parcelable.Creator r1 = Document.CREATOR;
        if (lbb.a.a(r0) == false) goto L9;
        return;
    L9:
        if (getDocViewModel().isSyncBlock() == false) goto L11;
        return;
    L11:
        if (r6 == null) goto L19;
        y3 r2 = r6.getDocumentMetadata();
        if (r2 == null) goto L19;
        BearUrl r3 = r2.getBearUrl();
        if (r3 == null) goto L19;
        Map<String, String> r4 = r3.d;
        if (r4 == null) goto L19;
        String r5 = r4.get(VIEW_DOC_HISTORY);
    L21:
        if (TextUtils.equals(r5, DiagramData$RESULT.SUCCESS) == false) goto L23;
        return;
    L23:
        String r7 = getDocViewModel().getToken();
        int r8 = getDocViewModel().getDocumentTypeValue();
        boolean r9 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.workspace.phoenix", false);
        Disposable r10 = w05.a.a(r7, r8).subscribe(new c(this, r9, r6), d.a);
        this.disposable.add(r10);
        return;
    L19:
        r5 = null;
        goto L21
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        removeObserveDocumentInfo();
        this.disposable.clear();
        super.onDetachFromHost(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$handleContainerInfo(WikiNavPlugin r0, DocContainerInfo r1) {
        r0.handleContainerInfo(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addRouteEntry(String r9, String r10) {
        String r3 = getDocViewModel().getToken();
        int r4 = getDocViewModel().getDocumentTypeValue();
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (r4 == (-1)) goto L23;
        DocumentPluginHost r0 = (DocumentPluginHost) getHost();
        if (r0 == null) goto L15;
        s4 r1 = (s4) r0.getHostAbility(s4.class);
        if (r1 == null) goto L15;
        Fragment r2 = r1.getFragment();
        if (r2 == null) goto L15;
        Bundle r5 = r2.getArguments();
    L16:
        if (r5 == null) goto L18;
        String r6 = r5.getString("redirect");
    L19:
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).n(new k(r9, r3, r4, !TextUtils.isEmpty(r6), r10));
        return;
    L18:
        r6 = null;
    L15:
        r5 = null;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleMoveToWiki(String r4, String r5, String r6) {
        MainNavPlugin r0 = (MainNavPlugin) findPlugin(MainNavPlugin.class);
        boolean r1 = false;
        if (r0 == null) goto L6;
        r0.setNeedAddVisitRecord(false);
    L6:
        if (getDocViewModel().getOpenSource() != DocsOpenSource.template_preview) goto L9;
        r1 = true;
    L9:
        if (getDocViewModel().getOpenSource() != DocsOpenSource.doc_component) goto L13;
        String r7 = generateWikiUrl(r4);
        Fragment r8 = ((DocumentPluginHost) getHost()).c().getParentFragment();
        if (r8 == null) goto L33;
        ((DocComponentVM) new ViewModelProvider(r8).get(DocComponentVM.class)).getLiveMoveToWiki().postValue(r7);
        return;
    L33:
        return;
    L13:
        if (r1 == false) goto L15;
    L28:
        if (r1 == true) goto L37;
        routeToWiki(r4);
        removeObserveDocumentInfo();
        addRouteEntry(r4, r5);
        return;
    L37:
        return;
    L15:
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).c()) == false) goto L28;
        String r9 = generateWikiUrl(r4);
        ViewModelStoreOwner r10 = ((DocumentPluginHost) getHost()).c();
    L17:
        if (r10 == null) goto L22;
        if ((r10 instanceof n) == true) goto L23;
        r10 = r10.getParentFragment();
    L23:
        if (r10 == null) goto L35;
        MutableLiveData<Bundle> r11 = ((ForsetiVM) new ViewModelProvider(r10).get(ForsetiVM.class)).getLiveArgs();
        Bundle r2 = new Bundle();
        r2.putString("url", r9);
        if (r6 != null) goto L27;
        r6 = "";
    L27:
        r2.putString("last_token", r6);
        r11.postValue(r2);
        return;
    L35:
        return;
    L22:
        r10 = null;
        goto L23
    }

    public static /* synthetic */ void handleMoveToWiki$default(WikiNavPlugin r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.handleMoveToWiki(r1, r2, r3);
    }
}
