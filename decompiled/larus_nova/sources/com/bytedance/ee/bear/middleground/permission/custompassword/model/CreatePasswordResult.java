package com.bytedance.ee.bear.middleground.permission.custompassword.model;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/CreatePasswordResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "password", "", "getPassword", "()Ljava/lang/String;", "setPassword", "(Ljava/lang/String;)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreatePasswordResult extends Result<Serializable> implements NonProguard {
    private String password;

    public CreatePasswordResult() {
        this.password = "";
    }

    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(String r100) {
        this.password = r100;
    }
}
