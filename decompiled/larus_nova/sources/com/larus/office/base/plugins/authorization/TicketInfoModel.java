package com.larus.office.base.plugins.authorization;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/office/base/plugins/authorization/TicketInfoModel;", "Ljava/io/Serializable;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TicketInfoModel implements Serializable {

    @SerializedName("url")
    private String url;

    public String toString() {
        StringBuilder r100 = new StringBuilder("urlLength=");
        String r101 = this.url;
        if (r101 == null) goto L5;
        int r102 = r101.length();
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = 0;
        goto L6
    }

    public TicketInfoModel() {
        this.url = "";
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
