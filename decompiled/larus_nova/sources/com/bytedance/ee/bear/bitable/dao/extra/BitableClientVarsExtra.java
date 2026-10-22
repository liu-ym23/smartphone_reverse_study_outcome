package com.bytedance.ee.bear.bitable.dao.extra;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/dao/extra/BitableClientVarsExtra;", "Lcom/bytedance/ee/bear/bitable/dao/extra/BitableResourceDataExtra;", "<init>", "()V", "baseRev", "", "getBaseRev", "()Ljava/lang/Integer;", "setBaseRev", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tableRev", "getTableRev", "setTableRev", "viewId", "", "getViewId", "()Ljava/lang/String;", "setViewId", "(Ljava/lang/String;)V", "schemaVersion", "getSchemaVersion", "setSchemaVersion", "clientVarsMD5", "getClientVarsMD5", "setClientVarsMD5", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableClientVarsExtra extends BitableResourceDataExtra {
    private Integer baseRev;
    private String clientVarsMD5;
    private Integer schemaVersion;
    private Integer tableRev;
    private String viewId;

    public BitableClientVarsExtra() {
    }

    public final Integer getBaseRev() {
        return this.baseRev;
    }

    public final String getClientVarsMD5() {
        return this.clientVarsMD5;
    }

    public final Integer getSchemaVersion() {
        return this.schemaVersion;
    }

    public final Integer getTableRev() {
        return this.tableRev;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setBaseRev(Integer r100) {
        this.baseRev = r100;
    }

    public final void setClientVarsMD5(String r100) {
        this.clientVarsMD5 = r100;
    }

    public final void setSchemaVersion(Integer r100) {
        this.schemaVersion = r100;
    }

    public final void setTableRev(Integer r100) {
        this.tableRev = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }
}
