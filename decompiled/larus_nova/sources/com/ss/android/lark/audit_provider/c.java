package com.ss.android.lark.audit_provider;

import android.content.Context;
import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.log.Log;
import gwa.g;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDataIPCService f409554a;

    public c(Context r100) {
        jrc.b.a.f500175a.getClass();     // Catch: Throwable -> L5
        this.f409554a = (IDataIPCService) jrc.b.a(r100, IDataIPCService.class);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("DataIPCServiceImpl", "init DataHandlerImpl failed", th);
    }

    @Override // gwa.g.a
    public final void deleteAuditData(String r100, List<AuditDBData> r101) {
        IDataIPCService r102 = this.f409554a;
        if (r102 != null) goto L6;
        Log.e("DataIPCServiceImpl", "deleteAuditData failed for null mDataIPCService");
        return;
    L6:
        r102.deleteAuditData(r100, r101);
    }

    @Override // gwa.g.a
    public final List<AuditDBData> queryAuditData(String r100, int r101) {
        IDataIPCService r102 = this.f409554a;
        if (r102 != null) goto L7;
        Log.e("DataIPCServiceImpl", "queryAuditData failed for null mDataIPCService");
        return null;
    L7:
        return r102.queryAuditData(r100, r101);
    }

    @Override // gwa.g.a
    public final void recordAuditData(String r100, String r101) {
        IDataIPCService r102 = this.f409554a;
        if (r102 != null) goto L6;
        Log.e("DataIPCServiceImpl", "recordAuditData failed for null mDataIPCService");
        return;
    L6:
        r102.recordAuditData(r100, r101);
    }
}
