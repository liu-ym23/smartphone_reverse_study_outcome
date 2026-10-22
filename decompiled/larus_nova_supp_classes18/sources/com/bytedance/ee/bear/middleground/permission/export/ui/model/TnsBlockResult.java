package com.bytedance.ee.bear.middleground.permission.export.ui.model;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/ui/model/TnsBlockResult;", "", ResourceData.KEY_URL, "", "code", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/Long;", "setCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TnsBlockResult {
    private Long code;
    private String url;

    public final Long getCode() {
        return this.code;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCode(Long r1) {
        this.code = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public TnsBlockResult(String r1, Long r2) {
        this.url = r1;
        this.code = r2;
    }
}
