package com.bytedance.ee.bear.document.documentinfo;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.contract.n0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s45.p;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003\u001e\u001f B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001c\u001a\u00020\u0013J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfoPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/documentinfo/IDocumentInfoPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "()V", "mCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "mRenderSuccess", "", "isNotify", "referList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ee/bear/document/documentinfo/BlockInfo;", "getReferList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setReferList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "onAttachToHost", "", "host", "renderCallback", "Lcom/bytedance/ee/bear/contract/RenderCallback;", "requestDocumentInfo", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "callBackNotify", "registerDocumentInfoObserver", "Companion", "NotifySetFocusableReadyHandler", "SetBlockInfoHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentInfoPlugin extends DocumentPlugin implements IDocumentInfoPlugin<DocumentPluginHost> {
    private static final String BIZ_UTIL_NOTIFY_SET_FOCUSABLE_READY = "biz.util.notifySetFocusableReady";
    private static final String BIZ_UTIL_SET_BLOCK_INFO = "biz.util.setBlockInfo";
    public static final a Companion = null;
    private static final String TAG = "DocumentInfoPlugin";
    private boolean isNotify;
    private m mCallback;
    private boolean mRenderSuccess;
    private CopyOnWriteArrayList<BlockInfo> referList;
    private final m0 renderCallback;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<Object> {
        public final /* synthetic */ DocumentInfoPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(DocumentInfoPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            DocumentInfoPlugin.access$setMCallback$p(this.a, r2);
            if (r2 != null) goto L5;
            return;
        L5:
            if (DocumentInfoPlugin.access$getMRenderSuccess$p(this.a) == true) goto L7;
            return;
        L7:
            if (DocumentInfoPlugin.access$isNotify$p(this.a) == true) goto L12;
            this.a.callBackNotify();
            return;
        }
    }

    public final class c implements i<BlockInfo> {
        public final /* synthetic */ DocumentInfoPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(DocumentInfoPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            BlockInfo r5 = (BlockInfo) r3;
            if (r5 != null) goto L5;
            tt5.a.h(DocumentInfoPlugin.TAG, "SetBlockInfoHandler handle data empty");
            return;
        L5:
            tt5.a.h(DocumentInfoPlugin.TAG, "SetBlockInfoHandler data");
            this.a.getReferList().add(r5);
            w05.i r6 = ((w05.b) ((DocumentPluginHost) this.a.getHost()).getHostAbility(w05.b.class)).getDocumentInfoProvider();
            DocumentInfo r0 = (DocumentInfo) r6.g().getValue();
            if (r0 == null) goto L8;
            r0.updateBlockInfo(CollectionsKt.listOf(r5));
        L8:
            DocumentInfo r7 = (DocumentInfo) r6.h().getValue();
            if (r7 == null) goto L11;
            r7.updateBlockInfo(CollectionsKt.listOf(r5));
        L11:
            DocumentInfoPlugin.access$getDocViewModel(this.a).setPermissionUpdate(Boolean.TRUE);
            DocumentInfoPlugin.access$getDocViewModel(this.a).notifyBlockInfoUpdate();
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DocumentInfoPlugin a;

        public d(DocumentInfoPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DocumentInfo r3 = (DocumentInfo) r2;
            if (r3 == null) goto L6;
            r3.updateBlockInfo(this.a.getReferList());
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DocumentInfoPlugin a;

        public e(DocumentInfoPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DocumentInfo r3 = (DocumentInfo) r2;
            if (r3 == null) goto L5;
            r3.updateBlockInfo(this.a.getReferList());
        L5:
            DocumentInfoPlugin.access$getDocViewModel(this.a).notifyBlockInfoUpdate();
        }
    }

    public static final class f extends n0 {
        public final /* synthetic */ DocumentInfoPlugin a;

        public f(DocumentInfoPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.n0, com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r2) {
            this.a.requestDocumentInfo();
            DocumentInfoPlugin.access$setMRenderSuccess$p(this.a, true);
            if (DocumentInfoPlugin.access$getMCallback$p(this.a) == null) goto L6;
            this.a.callBackNotify();
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void registerDocumentInfoObserver() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r0 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L5;
        return;
    L5:
        if (getDocViewModel() != null) goto L7;
        return;
    L7:
        MutableLiveData<DocumentInfo> r1 = getDocViewModel().liveOfflineDocumentInfoData();
        if (r1 == null) goto L11;
        r1.observe(getLifecycleOwner(), new d(this));
    L11:
        if (getDocViewModel() != null) goto L13;
        return;
    L13:
        if (getDocViewModel().liveDocumentInfoData() == null) goto L19;
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new e(this));
        return;
    }

    public final void callBackNotify() {
        m r1 = this.mCallback;
        if (r1 == null) goto L11;
        tt5.a.h(TAG, "callBackNotify");     // Catch: Exception -> L6
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L6
        r2.put("enable", true);     // Catch: Exception -> L6
        r1.onCallBack(r2.toString());     // Catch: Exception -> L6
        this.isNotify = true;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        tt5.a.d(TAG, "callBackNotify : " + e.getMessage());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.documentinfo.IDocumentInfoPlugin
    public void requestDocumentInfo() {
        tt5.a.h(TAG, "requestDocumentInfo()...");
        String r0 = getDocViewModel().getUrl();
        if (TextUtils.isEmpty(r0) == true) goto L16;
        if (p.a().v6(r0) == false) goto L16;
        BearUrl r1 = p.a().Z(r0);
        if (TextUtils.isEmpty(r1.b) == true) goto L16;
        if (lbb.a.a(r1.b) == true) goto L16;
        DocViewModel r2 = getDocViewModel();
        if (r2.isSyncBlock() == false) goto L13;
        r2.setToken(r2.getBearUrl().b);
    L14:
        r2.requestDocumentInfo(r0, true);
        goto L16
    L13:
        r2.setToken(r1.b);
    L16:
        if (j.a.a.getNetworkState().a() == false) goto L19;
        ((w05.b) ((DocumentPluginHost) getHost()).getHostAbility(w05.b.class)).getDocumentInfoProvider();
        return;
    }

    public DocumentInfoPlugin() {
        this.referList = new CopyOnWriteArrayList();
        this.renderCallback = new f(this);
    }

    public final CopyOnWriteArrayList<BlockInfo> getReferList() {
        return this.referList;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(DocumentInfoPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ m access$getMCallback$p(DocumentInfoPlugin r0) {
        return r0.mCallback;
    }

    public static final /* synthetic */ boolean access$getMRenderSuccess$p(DocumentInfoPlugin r0) {
        return r0.mRenderSuccess;
    }

    public static final /* synthetic */ boolean access$isNotify$p(DocumentInfoPlugin r0) {
        return r0.isNotify;
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        bindBridgeHandler(BIZ_UTIL_NOTIFY_SET_FOCUSABLE_READY, new b(this));
        bindBridgeHandler(BIZ_UTIL_SET_BLOCK_INFO, new c(this));
        registerDocumentInfoObserver();
    }

    public final void setReferList(CopyOnWriteArrayList<BlockInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.referList = r2;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setMCallback$p(DocumentInfoPlugin r0, m r1) {
        r0.mCallback = r1;
    }

    public static final /* synthetic */ void access$setMRenderSuccess$p(DocumentInfoPlugin r0, boolean r1) {
        r0.mRenderSuccess = r1;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        tt5.a.h(TAG, "onAttachToUIContainer()...add render callback");
        k r3 = getWeb();
        if ((r3 instanceof z4) == false) goto L5;
        z4 r4 = (z4) r3;
    L6:
        if (r4 == null) goto L9;
        r4.x(this.renderCallback);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        tt5.a.h(TAG, "onDetachFromUIContainer()...remove render callback");
        k r3 = getWeb();
        if ((r3 instanceof z4) == false) goto L5;
        z4 r4 = (z4) r3;
    L6:
        if (r4 == null) goto L9;
        r4.m(this.renderCallback);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
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
}
