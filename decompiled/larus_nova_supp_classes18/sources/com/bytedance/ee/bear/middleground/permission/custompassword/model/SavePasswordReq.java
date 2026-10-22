package com.bytedance.ee.bear.middleground.permission.custompassword.model;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/SavePasswordReq;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", ResourceData.KEY_TOKEN, "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", ResourceData.KEY_TYPE, "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "password", "getPassword", "setPassword", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SavePasswordReq implements NonProguard {
    private String password;
    private String token;
    private Integer type;

    public SavePasswordReq() {
        this.token = "";
        this.type = -1;
        this.password = "";
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setPassword(String r1) {
        this.password = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }
}
