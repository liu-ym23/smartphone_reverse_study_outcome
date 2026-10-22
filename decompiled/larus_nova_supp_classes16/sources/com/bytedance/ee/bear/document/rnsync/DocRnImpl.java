package com.bytedance.ee.bear.document.rnsync;

import a35.e0;
import a35.y;
import android.app.Application;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.offline.create.GetCreatedDocHandler;
import com.bytedance.ee.bear.document.offline.file.upload.UploadFileHandler;
import com.bytedance.ee.bear.rn.j;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import f25.k;
import f25.n;
import f25.s;
import g25.c;
import g25.i;
import h25.d;
import h25.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@ClaymoreImpl(dx4.a.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/rnsync/DocRnImpl;", "Lcom/bytedance/ee/bear/contract/rn/IRn;", "<init>", "()V", "mOfflineSyncDocHandler", "Lcom/bytedance/ee/bear/document/offline/create/OfflineSyncDocHandler;", "mModifyOfflineDocInfoHandler", "Lcom/bytedance/ee/bear/document/offline/create/ModifyOfflineDocInfoHandler;", "mApplication", "Landroid/app/Application;", "mRnManager", "Lcom/bytedance/ee/bear/rn/RnManager;", "getMRnManager", "()Lcom/bytedance/ee/bear/rn/RnManager;", "mRnManager$delegate", "Lkotlin/Lazy;", "init", "", "application", "setOfflineSyncListener", "listener", "Lcom/bytedance/ee/bear/document/offline/create/OfflineSyncInterface;", "removeOfflineSyncListener", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocRnImpl implements dx4.a {
    public static final a Companion = null;
    private static final String TAG = "DocRnImpl";
    private Application mApplication;
    private d mModifyOfflineDocInfoHandler;
    private m mOfflineSyncDocHandler;
    private final Lazy mRnManager$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final j getMRnManager() {
        return (j) this.mRnManager$delegate.getValue();
    }

    public DocRnImpl() {
        this.mRnManager$delegate = LazyKt.lazy(DocRnImpl$mRnManager$2.INSTANCE);
    }

    @Override // dx4.a
    public void init(Application r11) {
        Intrinsics.checkNotNullParameter(r11, "application");
        this.mApplication = r11;
        com.bytedance.ee.bear.contract.d r12 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        this.mOfflineSyncDocHandler = new m("Rn");
        this.mModifyOfflineDocInfoHandler = new d("Rn");
        getMRnManager().c("biz.util.setData", new s(true, null));
        getMRnManager().c("biz.util.getData", new n(true));
        getMRnManager().c("biz.util.setDataV2", new i(true));
        getMRnManager().c("biz.util.getDataV2", new c(true));
        getMRnManager().c("biz.util.getOfflineCreatedDoc", new GetCreatedDocHandler());
        getMRnManager().c("biz.notify.syncDocInfo", this.mOfflineSyncDocHandler);
        getMRnManager().c("biz.util.modifyOfflineDocInfo", this.mModifyOfflineDocInfoHandler);
        j r8 = getMRnManager();
        Application r2 = this.mApplication;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
        r2 = null;
    L5:
        r8.c("biz.util.uploadFile", new UploadFileHandler(r2.getApplicationContext(), r12, (NetService) org.koin.java.a.c(NetService.class, null, null, 6), com.bytedance.ee.bear.contract.j.a.a, UploadFileHandler.From.RN));
        getMRnManager().c("biz.util.showFullQuoteDialog", new com.bytedance.ee.bear.document.alert.a("rn", -1, null, null));
        getMRnManager().c("biz.util.logger", new q15.a("RN"));
        getMRnManager().c("biz.util.batchLogger", new com.bytedance.ee.bear.document.frontendlog.a("RN"));
        getMRnManager().c("biz.statistics.reportEvent", new x35.c(r12));
        getMRnManager().c("biz.util.notifySyncStatus", new e0(y.e()));
        ((yr4.a) org.koin.java.a.c(yr4.a.class, null, null, 6)).d();
        if (AppInfoUtils.f().booleanValue() == false) goto L9;
        tt5.a.h(TAG, "init, register GetAuthHeaderHandler");
        getMRnManager().c("biz.util.getAuthHeader", new k());
        return;
    }

    public final void removeOfflineSyncListener(h25.n r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        m r0 = this.mOfflineSyncDocHandler;
        if (r0 != null) goto L5;
    L7:
        d r1 = this.mModifyOfflineDocInfoHandler;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.b != r4) goto L14;
        r1.b = null;
        return;
    L14:
        return;
    L5:
        if (r0.b != r4) goto L7;
        r0.b = null;
        goto L7
    }

    public final void setOfflineSyncListener(h25.n r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        m r0 = this.mOfflineSyncDocHandler;
        if (r0 == null) goto L5;
        r0.b = r2;
    L5:
        d r1 = this.mModifyOfflineDocInfoHandler;
        if (r1 == null) goto L9;
        r1.b = r2;
        return;
    }
}
