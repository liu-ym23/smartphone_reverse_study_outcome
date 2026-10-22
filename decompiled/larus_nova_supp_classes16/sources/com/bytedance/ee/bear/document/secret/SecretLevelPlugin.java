package com.bytedance.ee.bear.document.secret;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocShareUserInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfoPlugin;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jg5.j;
import jg5.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0016J\u001c\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0002J$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010!\u001a\u00020\bH\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/document/secret/SecretLevelPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/secret/SecretLevelChangeListener;", "<init>", "()V", "secretUpdatePush", "Lcom/bytedance/ee/space/push/PushObserver;", "retryToken", "", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "requestSecretLevelSetting", "onRequestSecretLevelSetting", "docVM", "Lcom/bytedance/ee/bear/document/DocViewModel;", "documentInfo", "Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "shareUserInfo", "Lcom/bytedance/ee/bear/document/DocShareUserInfo;", "showSecretFragment", "onAttachToHost", "updateSecretLevelToList", "meta", "Lcom/bytedance/ee/bear/DocMetaInfo;", "onDetachFromHost", "getRetryToken", "onSecretLevelChange", "name", "level", "", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretLevelPlugin extends DocumentPlugin implements fj5.b {
    public static final a Companion = null;
    private static final String TAG = "SecretPlugin";
    private String retryToken;
    private bu5.a secretUpdatePush;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements i {
        public final /* synthetic */ SecretLevelPlugin a;

        public b(SecretLevelPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            Void r5 = (Void) r3;
            if (SecretLevelPlugin.access$getDocViewModel(this.a).getDocumentInfoData() != null) goto L5;
        L8:
            DocumentInfoPlugin r6 = (DocumentInfoPlugin) SecretLevelPlugin.access$findPlugin(this.a, DocumentInfoPlugin.class);
            if (r6 == null) goto L11;
            r6.requestDocumentInfo();
        L11:
            MutableLiveData<DocumentInfo> r7 = SecretLevelPlugin.access$getDocViewModel(this.a).liveDocumentInfoData();
            LifecycleOwner r8 = SecretLevelPlugin.access$getLifecycleOwner(this.a);
            final SecretLevelPlugin r1 = this.a;
            r7.observe(r8, new SecretLevelPlugin$getBridgeHandlers$1$1(r1));
            final MutableLiveData<Throwable> r9 = ((w05.b) this.a.getHostAbility(w05.b.class)).getDocumentInfoProvider().b();
            LifecycleOwner r10 = SecretLevelPlugin.access$getLifecycleOwner(this.a);
            final SecretLevelPlugin r2 = this.a;
            r9.observe(r10, new SecretLevelPlugin$getBridgeHandlers$1$2(r9, r2));
            return;
        L5:
            if (SecretLevelPlugin.access$getDocViewModel(this.a).getDocumentInfoData().getDocMetaInfo().isGetSecDetailFail() == true) goto L8;
            SecretLevelPlugin r11 = this.a;
            SecretLevelPlugin.access$showSecretFragment(r11, SecretLevelPlugin.access$getDocViewModel(r11).getDocumentInfoData());
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ SecretLevelPlugin a;

        public c(SecretLevelPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DocumentInfo r3 = (DocumentInfo) r2;
            Intrinsics.checkNotNullParameter(r3, "t");
            SecretLevelPlugin.access$updateSecretLevelToList(this.a, r3.getDocMetaInfo());
        }
    }

    public static final class d implements bu5.a {
        public final /* synthetic */ SecretLevelPlugin a;

        public static final class a implements Runnable {
            public final /* synthetic */ SecretLevelPlugin a;

            public a(SecretLevelPlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L17;
                throw th;
            L17:
                return;
            L3:
                if (SecretLevelPlugin.access$isUIContainerDetached(this.a) == true) goto L12;
                DocumentInfoPlugin r0 = (DocumentInfoPlugin) SecretLevelPlugin.access$findPlugin(this.a, DocumentInfoPlugin.class);     // Catch: Throwable -> L9
                if (r0 == null) goto L16;
                r0.requestDocumentInfo();     // Catch: Throwable -> L9
                return;
            L16:
                return;
            }
        }

        public d(SecretLevelPlugin r1) {
            this.a = r1;
        }

        public final void didReceivePush(String r2) {
            tt5.a.h(SecretLevelPlugin.TAG, "receive secret update push");
            com.bytedance.ee.util.ui.m.a(new a(this.a));
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ SecretLevelPlugin a;

        public e(SecretLevelPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            String r6 = (String) r5;
            Intrinsics.checkNotNull(r6);
            if (r6.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            return;
        L8:
            if (((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(SecretLevelPlugin.access$getRetryToken$p(this.a)) == true) goto L10;
            return;
        L10:
            if (Intrinsics.areEqual(SecretLevelPlugin.access$getRetryToken$p(this.a), r6) == true) goto L19;
            j r1 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
            String r2 = SecretLevelPlugin.access$getRetryToken$p(this.a);
            r1.getClass();
            HashMap r3 = (HashMap) j.d;
            ArrayList r4 = (ArrayList) r3.get(r2);
            if (r4 != null) goto L14;
            return;
        L14:
            if (r4.size() <= 0) goto L21;
            r3.remove(r2);
            r3.put(r6, r4);
            return;
        L21:
            return;
        L19:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ SecretLevelPlugin a;
        public final /* synthetic */ DocViewModel b;

        public f(SecretLevelPlugin r1, DocViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            DocShareUserInfo r5 = (DocShareUserInfo) r4;
            SecretLevelPlugin r0 = this.a;
            DocViewModel r1 = this.b;
            MutableLiveData<DocumentInfo> r2 = r1.liveDocumentInfoData();
            if (r2 == null) goto L5;
            DocumentInfo r3 = (DocumentInfo) r2.getValue();
        L6:
            SecretLevelPlugin.access$onRequestSecretLevelSetting(r0, r1, r3, r5);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ SecretLevelPlugin a;
        public final /* synthetic */ DocViewModel b;

        public g(SecretLevelPlugin r1, DocViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            DocumentInfo r5 = (DocumentInfo) r4;
            SecretLevelPlugin r0 = this.a;
            DocViewModel r1 = this.b;
            MutableLiveData<DocShareUserInfo> r2 = r1.getmDocShareInfo();
            if (r2 == null) goto L5;
            DocShareUserInfo r3 = (DocShareUserInfo) r2.getValue();
        L6:
            SecretLevelPlugin.access$onRequestSecretLevelSetting(r0, r1, r5, r3);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SecretLevelPlugin() {
        this.retryToken = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void requestSecretLevelSetting() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L6;
        tt5.a.h(TAG, "requestSecretLevelSetting, docVM is null");
        return;
    L6:
        BearUrl r2 = r0.getBearUrl();
        if (r2 == null) goto L29;
        Map<String, String> r3 = r2.d;
        if (r3 == null) goto L29;
        String r4 = r3.get("open_secret_setting_page");
        if (r4 == null) goto L29;
        if (Intrinsics.areEqual(r4, DiagramData$RESULT.SUCCESS) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L29;
        if (r0.hasAutoShownSecretSetting() == false) goto L22;
        tt5.a.h(TAG, "requestSecretLevelSetting, hasAutoShownSecretSetting is true");
        return;
    L22:
        MutableLiveData<DocShareUserInfo> r1 = r0.getmDocShareInfo();
        if (r1 == null) goto L25;
        r1.observe(((DocumentPluginHost) getHost()).getLifecycleOwner(), new f(this, r0));
    L25:
        MutableLiveData<DocumentInfo> r5 = r0.liveDocumentInfoData();
        if (r5 == null) goto L31;
        r5.observe(((DocumentPluginHost) getHost()).getLifecycleOwner(), new g(this, r0));
        return;
    L31:
        return;
    L29:
        tt5.a.h(TAG, "requestSecretLevelSetting, open_secret_setting_page is not 1");
    }

    public String getRetryToken() {
        return this.retryToken;
    }

    public static final /* synthetic */ Context access$getContext(SecretLevelPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(SecretLevelPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(SecretLevelPlugin r0) {
        return r0.getLifecycleOwner();
    }

    public static final /* synthetic */ String access$getRetryToken$p(SecretLevelPlugin r0) {
        return r0.retryToken;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(SecretLevelPlugin r0) {
        return r0.isUIContainerDetached();
    }

    private final void showSecretFragment(DocumentInfo r11) {
        if (r11.getDocPermission().a.canModifySecretLevel() == true) goto L5;
    L24:
        tt5.a.k(TAG, "no modify secret permission or is not single container");
        return;
    L5:
        if (r11.getVersion().isDocV2() == false) goto L24;
        if (r11.getDocMetaInfo().isGetSecDetailFail() == false) goto L11;
        tt5.a.h(TAG, "isGetSecDetailFail");
        Toast.showFailureText(getContext(), 2131887384);
        return;
    L11:
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L17;
        WikiInfo r1 = r0.getWikiInfo();
        if (r1 == null) goto L17;
        String r2 = r1.getWikiToken();
        if (r2 == null) goto L17;
    L18:
        String r6 = r2;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).r3(getActivity(), getDocViewModel().getToken(), getDocViewModel().getDocumentTypeValue(), r11.getDocMetaInfo(), r6, "from_left_upper");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        k r12 = k.a.a;
        String r13 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r14 = new JSONObject();
        String r3 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r4 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L21;
        String r5 = "vc";
    L22:
        com.bytedance.ee.bear.middleground.permission.c.a(r14, r3, r4, r5, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r14.put("click", "security_setting");
        r14.put("target", "ccm_permission_security_setting_view");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_space_docs_topbar_click", r14);
        return;
    L21:
        r5 = "none";
    L17:
        r2 = "";
        goto L18
    }

    private final void updateSecretLevelToList(DocMetaInfo r4) {
        if (r4.isGetSecSuccess() == false) goto L6;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).Q(getDocViewModel().getToken(), r4.getSecretLevel().getName(), r4.getSecretLevel().getLevel());
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.secret", new b(this));
    }

    public void onAttachToHost(DocumentPluginHost r6) {
        super.onAttachToHost(r6);
        if (getDocViewModel().getDocumentInfoData() != null) goto L8;
        DocumentInfoPlugin r7 = (DocumentInfoPlugin) findPlugin(DocumentInfoPlugin.class);
        if (r7 == null) goto L7;
        r7.requestDocumentInfo();
    L7:
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new c(this));
    L8:
        d r8 = new d(this);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).d7(getDocViewModel().getToken(), getDocViewModel().getDocumentTypeValue(), r8);
        this.secretUpdatePush = r8;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().o(getDocViewModel().getToken(), this);
        this.retryToken = getDocViewModel().getToken();
        getDocViewModel().liveDocObjToken().observe(getLifecycleOwner(), new e(this));
    }

    public void onDetachFromHost(DocumentPluginHost r4) {
        super.onDetachFromHost(r4);
        bu5.a r5 = this.secretUpdatePush;
        if (r5 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r5);
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().q(getDocViewModel().getToken(), this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(SecretLevelPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$showSecretFragment(SecretLevelPlugin r0, DocumentInfo r1) {
        r0.showSecretFragment(r1);
    }

    public static final /* synthetic */ void access$updateSecretLevelToList(SecretLevelPlugin r0, DocMetaInfo r1) {
        r0.updateSecretLevelToList(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        requestSecretLevelSetting();
    }

    public void onSecretLevelChange(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        DocumentInfoPlugin r0 = (DocumentInfoPlugin) findPlugin(DocumentInfoPlugin.class);
        if (r0 == null) goto L5;
        r0.requestDocumentInfo();
    L5:
        DocViewModel r1 = getDocViewModel();
        if (r1 == null) goto L11;
        WikiInfo r2 = r1.getWikiInfo();
        if (r2 == null) goto L11;
        String r3 = r2.getWikiToken();
        if (r3 == null) goto L11;
    L13:
        if (r3.length() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).Q(r3, r5, r6);
        return;
    L19:
        return;
    L15:
        r4 = false;
    L11:
        r3 = "";
        goto L13
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onRequestSecretLevelSetting(DocViewModel r8, DocumentInfo r9, DocShareUserInfo r10) {
        tt5.a.h(TAG, "onRequestSecretLevelSetting, documentInfo: " + r9 + ", shareUserInfo: " + r10);
        if (r9 == null) goto L32;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isHasPullSuc() == true) goto L9;
        return;
    L9:
        if (r8.hasAutoShownSecretSetting() == false) goto L12;
        tt5.a.h(TAG, "onRequestSecretLevelSetting, hasAutoShownSecretSetting is true");
        return;
    L12:
        DocMetaInfo r11 = r9.getDocMetaInfo();
        if (r9.getType() != sbb.e.n.b) goto L15;
        boolean r0 = fj5.a.b(r11.getRealType());
    L16:
        boolean r12 = r11.isVisibleSecList();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L19;
        boolean r2 = r8.getPermissionResponseWithUserPermission(BizDomain.FileBizDomainCCM, "SECRET_MODIFY").getAllow();
    L20:
        tt5.a.h(TAG, "onRequestSecretLevelSetting, isDocTypeSecretEnabled: " + r0 + ", isSecretVisible: " + r12 + ", canModifySecret: " + r2);
        if (r0 == false) goto L34;
        if (r12 == false) goto L35;
        if (r2 == false) goto L37;
        r8.onAutoShownSecretSetting();
        cj5.c r1 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        FragmentActivity r3 = ((DocumentPluginHost) getHost()).getActivity();
        String r4 = r8.getToken();
        int r5 = r8.getDocumentTypeValue();
        DocMetaInfo r6 = r9.getDocMetaInfo();
        WikiInfo r13 = r8.getWikiInfo();
        if (r13 == null) goto L29;
        String r14 = r13.getWikiToken();
        if (r14 == null) goto L29;
    L30:
        r1.r3(r3, r4, r5, r6, r14, "from_docs_more_menu");
        return;
    L29:
        r14 = "";
        goto L30
    L37:
        return;
    L35:
        return;
    L34:
        return;
    L19:
        r2 = r9.getDocPermission().a.canModifySecretLevel();
        goto L20
    L15:
        r0 = fj5.a.c(r9.getType(), r9.getVersion().isDocV2());
        goto L16
    }

    public static final /* synthetic */ void access$onRequestSecretLevelSetting(SecretLevelPlugin r0, DocViewModel r1, DocumentInfo r2, DocShareUserInfo r3) {
        r0.onRequestSecretLevelSetting(r1, r2, r3);
    }
}
