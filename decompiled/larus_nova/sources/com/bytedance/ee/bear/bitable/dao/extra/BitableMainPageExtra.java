package com.bytedance.ee.bear.bitable.dao.extra;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/dao/extra/BitableMainPageExtra;", "Lcom/bytedance/ee/bear/bitable/dao/extra/BitableResourceDataExtra;", "<init>", "()V", "language", "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "schemaVersion", "", "getSchemaVersion", "()Ljava/lang/Integer;", "setSchemaVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMainPageExtra extends BitableResourceDataExtra {
    private String language;
    private Integer schemaVersion;

    public BitableMainPageExtra() {
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Integer getSchemaVersion() {
        return this.schemaVersion;
    }

    public final void setLanguage(String r100) {
        this.language = r100;
    }

    public final void setSchemaVersion(Integer r100) {
        this.schemaVersion = r100;
    }
}
