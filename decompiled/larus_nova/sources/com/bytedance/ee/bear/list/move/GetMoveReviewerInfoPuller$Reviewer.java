package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class GetMoveReviewerInfoPuller$Reviewer implements NonProguard {
    public String avatar_url;
    public String cn_name;
    public DisplayName display_name;
    public String email;
    public String en_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f228838id;
    public String mobile;
    public String name;
    public String suid;
    public String tenant_id;
    public String tenant_name;
    public int user_type;

    public GetMoveReviewerInfoPuller$Reviewer() {
    }

    public String toString() {
        return "Reviewer{id='" + yu5.c.j(this.f228838id) + "', suid='" + yu5.c.j(this.suid) + "', name='" + this.name + "', cn_name='" + this.cn_name + "', en_name='" + this.en_name + "', email='" + yu5.c.j(this.email) + "', mobile='" + yu5.c.j(this.mobile) + "', avatar_url='" + yu5.c.j(this.avatar_url) + "', tenant_id='" + yu5.c.j(this.tenant_id) + "', tenant_name='" + this.tenant_name + "', user_type=" + this.user_type + "', display_name=" + this.display_name + '}';
    }
}
