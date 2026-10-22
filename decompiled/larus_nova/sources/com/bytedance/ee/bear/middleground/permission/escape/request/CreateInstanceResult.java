package com.bytedance.ee.bear.middleground.permission.escape.request;

import com.bytedance.ee.bear.contract.Result;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/request/CreateInstanceResult;", "Lcom/bytedance/ee/bear/contract/Result;", "", "<init>", "()V", "isNeedApprove", "", "()Z", "setNeedApprove", "(Z)V", "onlyCarbonCopy", "getOnlyCarbonCopy", "setOnlyCarbonCopy", "instanceCode", "getInstanceCode", "()Ljava/lang/String;", "setInstanceCode", "(Ljava/lang/String;)V", "permResponse", "getPermResponse", "setPermResponse", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateInstanceResult extends Result<String> {

    @SerializedName("instance_conde")
    private String instanceCode;

    @SerializedName("is_need_approve")
    private boolean isNeedApprove;

    @SerializedName("only_carbon_copy")
    private boolean onlyCarbonCopy;

    @SerializedName("perm_response")
    private String permResponse;

    public CreateInstanceResult() {
    }

    public final String getInstanceCode() {
        return this.instanceCode;
    }

    public final boolean getOnlyCarbonCopy() {
        return this.onlyCarbonCopy;
    }

    public final String getPermResponse() {
        return this.permResponse;
    }

    public final boolean isNeedApprove() {
        return this.isNeedApprove;
    }

    public final void setInstanceCode(String r100) {
        this.instanceCode = r100;
    }

    public final void setNeedApprove(boolean r100) {
        this.isNeedApprove = r100;
    }

    public final void setOnlyCarbonCopy(boolean r100) {
        this.onlyCarbonCopy = r100;
    }

    public final void setPermResponse(String r100) {
        this.permResponse = r100;
    }
}
