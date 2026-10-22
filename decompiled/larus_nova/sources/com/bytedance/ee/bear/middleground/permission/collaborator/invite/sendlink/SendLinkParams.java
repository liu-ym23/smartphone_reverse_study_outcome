package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\r\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0017\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rJ\u0018\u0010\u0019\u001a\u00020\u00112\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rJ\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ\u001c\u0010\u001c\u001a\u00020\u00112\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/SendLinkParams;", "Ljava/io/Serializable;", "<init>", "()V", "token", "", "type", "", "Ljava/lang/Integer;", "remark", "linkParams", "", "members", "", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/SendLinkParams$MembersBean;", "getToken", "setToken", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "getRemark", "setRemark", "getMembers", "setMembers", "owners", "getLinkParams", "setLinkParams", "MembersBean", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendLinkParams implements Serializable {

    @SerializedName("link_params")
    @JSONField(name = "link_params")
    private Map<String, ? extends Serializable> linkParams;
    private List<MembersBean> members;
    private String remark;
    private String token;
    private Integer type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/SendLinkParams$MembersBean;", "Ljava/io/Serializable;", "<init>", "()V", "owner_id", "", "getOwner_id", "()Ljava/lang/String;", "setOwner_id", "(Ljava/lang/String;)V", "owner_type", "", "getOwner_type", "()Ljava/lang/Integer;", "setOwner_type", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MembersBean implements Serializable {
        private String owner_id;
        private Integer owner_type;

        public MembersBean() {
        }

        public final String getOwner_id() {
            return this.owner_id;
        }

        public final Integer getOwner_type() {
            return this.owner_type;
        }

        public final void setOwner_id(String r100) {
            this.owner_id = r100;
        }

        public final void setOwner_type(Integer r100) {
            this.owner_type = r100;
        }
    }

    public SendLinkParams() {
    }

    public final Map<String, Serializable> getLinkParams() {
        return this.linkParams;
    }

    public final List<MembersBean> getMembers() {
        return this.members;
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

    public final void setLinkParams(Map<String, ? extends Serializable> r100) {
        this.linkParams = r100;
    }

    public final void setMembers(List<MembersBean> r100) {
        this.members = r100;
    }

    public final void setRemark(String r100) {
        this.remark = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
