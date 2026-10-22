package com.ss.android.lark.audit_provider;

import android.content.Context;
import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
@RemoteServiceImpl(service = IDataIPCService.class)
public class DataIPCServiceImpl implements IDataIPCService {
    private static final String TAG = "DataIPCServiceImpl";

    public DataIPCServiceImpl(Context r100) {
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public void deleteAuditData(String r100, List<AuditDBData> r101) {
        Log.i(TAG, "deleteAuditData");
        iwa.b.a.f496246a.deleteAuditData(r100, r101);
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public List<AuditDBData> queryAuditData(String r100, int r101) {
        Log.i(TAG, "queryAuditData");
        return iwa.b.a.f496246a.queryAuditData(r100, r101);
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public void recordAuditData(String r100, String r101) {
        Log.i(TAG, "recordAuditData");
        iwa.b.a.f496246a.recordAuditData(r100, r101);
    }
}
