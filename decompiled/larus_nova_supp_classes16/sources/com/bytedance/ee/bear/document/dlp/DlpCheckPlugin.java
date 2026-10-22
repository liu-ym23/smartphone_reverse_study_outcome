package com.bytedance.ee.bear.document.dlp;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfoPlugin;
import com.bytedance.ee.bear.middleground_permission_export.model.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/dlp/DlpCheckPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "hasFetch", "", "isDlpMigrate", "dlpContext", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CCMOpenFileSceneContext;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "handleGetData", "notifyPermChange", "cacheDocument", "Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "timer", "Ljava/lang/Runnable;", "getTimer", "()Ljava/lang/Runnable;", "setTimer", "(Ljava/lang/Runnable;)V", "getDlpData", "documentInfo", "onDetachFromHost", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DlpCheckPlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final String TAG = "DlpCheckPlugin";
    private DocumentInfo cacheDocument;
    private com.ss.android.lark.security.compliance.api.model.filepolicy.c dlpContext;
    private Handler handler;
    private boolean hasFetch;
    private boolean isDlpMigrate;
    private Runnable timer;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DlpCheckPlugin a;

        public b(DlpCheckPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((DocumentInfo) r2, "t");
            DlpCheckPlugin.access$handleGetData(this.a);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DlpCheckPlugin a;

        public final void a() {
            DlpCheckPlugin.access$setHasFetch$p(this.a, true);
            if (DlpCheckPlugin.access$getCacheDocument$p(this.a) == null) goto L13;
            DocumentInfo r1 = null;
            d r0 = (d) org.koin.java.a.c(d.class, null, null, 6);
            DocumentInfo r2 = DlpCheckPlugin.access$getCacheDocument$p(this.a);
            if (r2 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("cacheDocument");
            r2 = null;
        L7:
            long r4 = r0.g(r2.getObjToken());
            this.a.getHandler().removeCallbacksAndMessages(null);
            DlpCheckPlugin r3 = this.a;
            DocumentInfo r5 = DlpCheckPlugin.access$getCacheDocument$p(r3);
            if (r5 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("cacheDocument");
        L11:
            DlpCheckPlugin.access$getDlpData(r3, r1);
            this.a.getHandler().postDelayed(this, r4);
            return;
        L10:
            r1 = r5;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(DlpCheckPlugin r1) {
            this.a = r1;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DlpCheckPlugin() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        this.isDlpMigrate = e.a.a.g();
        Looper r1 = Looper.myLooper();
        Intrinsics.checkNotNull(r1);
        this.handler = new Handler(r1);
        this.timer = new c(this);
    }

    private final void handleGetData() {
        this.cacheDocument = getDocViewModel().getDocumentInfoData();
        if (this.isDlpMigrate == false) goto L19;
        if (getDocViewModel() != null) goto L7;
    L16:
        tt5.a.d(TAG, "handleGetData empty model");
        return;
    L7:
        if (getDocViewModel().getDocumentInfoData() == null) goto L16;
        if (this.hasFetch == false) goto L12;
        return;
    L12:
        String r0 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).c(getDocViewModel().getDocumentInfoData().getType());
        this.dlpContext = new com.ss.android.lark.security.compliance.api.model.filepolicy.c(getDocViewModel().getDocumentInfoData().getObjToken(), r0, getDocViewModel().getDocumentInfoData().getType(), new AnonymousClass1(this));
        long r4 = yu5.c.g(getDocViewModel().getCreatorTenantId(), 0);
        long r2 = yu5.c.g(getDocViewModel().getOwnerUserId(), 0);
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r1 = this.dlpContext;
        if (r1 == null) goto L15;
        r1.a(FileBizDomain.FileBizDomainCCM, Long.valueOf(r2), Long.valueOf(r4));
    L15:
        this.hasFetch = true;
        return;
    L19:
        if (this.hasFetch == true) goto L23;
        this.hasFetch = true;
        this.handler.post(this.timer);
        return;
    }

    private final void notifyPermChange() {
        getDocViewModel().setPermissionUpdate(Boolean.TRUE);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final Runnable getTimer() {
        return this.timer;
    }

    public static final /* synthetic */ DocumentInfo access$getCacheDocument$p(DlpCheckPlugin r0) {
        return r0.cacheDocument;
    }

    public static final /* synthetic */ void access$handleGetData(DlpCheckPlugin r0) {
        r0.handleGetData();
    }

    public static final /* synthetic */ void access$notifyPermChange(DlpCheckPlugin r0) {
        r0.notifyPermChange();
    }

    private final void getDlpData(DocumentInfo r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ((d) org.koin.java.a.c(d.class, null, null, 6)).c(r4.getObjToken(), r4.getType());
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        this.hasFetch = false;
        if (getDocViewModel().getDocumentInfoData() != null) goto L8;
        DocumentInfoPlugin r4 = (DocumentInfoPlugin) findPlugin(DocumentInfoPlugin.class);
        if (r4 == null) goto L7;
        r4.requestDocumentInfo();
    L7:
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new b(this));
        return;
    L8:
        handleGetData();
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        this.hasFetch = true;
        if (this.isDlpMigrate == false) goto L7;
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r3 = this.dlpContext;
        if (r3 == null) goto L9;
        r3.c();
        return;
    L9:
        return;
    L7:
        this.handler.removeCallbacksAndMessages(null);
    }

    public final void setHandler(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.handler = r2;
    }

    public final void setTimer(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timer = r2;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$getDlpData(DlpCheckPlugin r0, DocumentInfo r1) {
        r0.getDlpData(r1);
    }

    public static final /* synthetic */ void access$setHasFetch$p(DlpCheckPlugin r0, boolean r1) {
        r0.hasFetch = r1;
    }
}
