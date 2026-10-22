package com.bytedance.ee.bear.list.applydelete;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import kotlin.Metadata;
import yu5.c;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00101\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/list/applydelete/DeleteReviewer;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "suid", "getSuid", "setSuid", "name", "getName", "setName", "cn_name", "getCn_name", "setCn_name", "en_name", "getEn_name", "setEn_name", "email", "getEmail", "setEmail", "mobile", "getMobile", "setMobile", "avatar_url", "getAvatar_url", "setAvatar_url", "tenant_id", "getTenant_id", "setTenant_id", "tenant_name", "getTenant_name", "setTenant_name", "user_type", "", "getUser_type", "()I", "setUser_type", "(I)V", IGoogleService.ResponseKey.DISPLAY_NAME, "Lcom/bytedance/ee/bear/common/DisplayName;", "getDisplay_name", "()Lcom/bytedance/ee/bear/common/DisplayName;", "setDisplay_name", "(Lcom/bytedance/ee/bear/common/DisplayName;)V", "toString", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeleteReviewer implements NonProguard {
    private String avatar_url;
    private String cn_name;
    private DisplayName display_name;
    private String email;
    private String en_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f227665id;
    private String mobile;
    private String name;
    private String suid;
    private String tenant_id;
    private String tenant_name;
    private int user_type;

    public DeleteReviewer() {
    }

    public String toString() {
        return "Reviewer{id='" + c.j(this.f227665id) + "', suid='" + c.j(this.suid) + "', name='" + this.name + "', cn_name='" + this.cn_name + "', en_name='" + this.en_name + "', email='" + c.j(this.email) + "', mobile='" + c.j(this.mobile) + "', avatar_url='" + c.j(this.avatar_url) + "', tenant_id='" + c.j(this.tenant_id) + "', tenant_name='" + this.tenant_name + "', user_type=" + this.user_type + "', display_name=" + this.display_name + '}';
    }

    public final String getAvatar_url() {
        return this.avatar_url;
    }

    public final String getCn_name() {
        return this.cn_name;
    }

    public final DisplayName getDisplay_name() {
        return this.display_name;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getEn_name() {
        return this.en_name;
    }

    public final String getId() {
        return this.f227665id;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSuid() {
        return this.suid;
    }

    public final String getTenant_id() {
        return this.tenant_id;
    }

    public final String getTenant_name() {
        return this.tenant_name;
    }

    public final int getUser_type() {
        return this.user_type;
    }

    public final void setAvatar_url(String r100) {
        this.avatar_url = r100;
    }

    public final void setCn_name(String r100) {
        this.cn_name = r100;
    }

    public final void setDisplay_name(DisplayName r100) {
        this.display_name = r100;
    }

    public final void setEmail(String r100) {
        this.email = r100;
    }

    public final void setEn_name(String r100) {
        this.en_name = r100;
    }

    public final void setId(String r100) {
        this.f227665id = r100;
    }

    public final void setMobile(String r100) {
        this.mobile = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSuid(String r100) {
        this.suid = r100;
    }

    public final void setTenant_id(String r100) {
        this.tenant_id = r100;
    }

    public final void setTenant_name(String r100) {
        this.tenant_name = r100;
    }

    public final void setUser_type(int r100) {
        this.user_type = r100;
    }
}
