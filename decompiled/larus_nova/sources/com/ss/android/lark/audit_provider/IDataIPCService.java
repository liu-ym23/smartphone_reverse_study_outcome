package com.ss.android.lark.audit_provider;

import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;
import gwa.g;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
@RemoteService
public interface IDataIPCService extends IHookInterface, g.a {
    /* synthetic */ void deleteAuditData(String r100, List<AuditDBData> r101);

    /* synthetic */ List<AuditDBData> queryAuditData(String r100, int r101);

    /* synthetic */ void recordAuditData(String r100, String r101);
}
