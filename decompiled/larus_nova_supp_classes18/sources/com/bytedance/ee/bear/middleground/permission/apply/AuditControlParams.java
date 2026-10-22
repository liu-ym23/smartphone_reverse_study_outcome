package com.bytedance.ee.bear.middleground.permission.apply;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/AuditControlParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", ResourceData.KEY_TYPE, "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", ResourceData.KEY_TOKEN, "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "action", "getAction", "setAction", "remark", "getRemark", "setRemark", "approvalType", "getApprovalType", "setApprovalType", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuditControlParams implements NonProguard {
    private String action;

    @JSONField(name = "approval_type")
    private Integer approvalType;

    @JSONField(name = "remark")
    private String remark;

    @JSONField(name = ResourceData.KEY_TOKEN)
    private String token;

    @JSONField(name = "obj_type")
    private Integer type;

    public AuditControlParams() {
        this.remark = "";
    }

    public final String getAction() {
        return this.action;
    }

    public final Integer getApprovalType() {
        return this.approvalType;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setAction(String r1) {
        this.action = r1;
    }

    public final void setApprovalType(Integer r1) {
        this.approvalType = r1;
    }

    public final void setRemark(String r1) {
        this.remark = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }
}
