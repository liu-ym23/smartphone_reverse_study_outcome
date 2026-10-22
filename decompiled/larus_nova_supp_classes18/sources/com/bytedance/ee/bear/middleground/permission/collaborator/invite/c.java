package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground_permission_export.model.ShareFolderUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static HashMap<String, Object> a() {
        AccountService.Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r0 != null) goto L6;
        tt5.a.d("CollaboratorUtils", "getDefaultFolderOwner account is null!");
        return null;
    L6:
        HashMap<String, Object> r1 = new HashMap();
        r1.put("uid", r0.uid);
        r1.put("avatarUrl", r0.avatarUrl);
        r1.put("tenantId", r0.tenantId);
        r1.put("tenantName", r0.tenantName);
        r1.put("cnName", r0.cnName);
        r1.put("enName", r0.enName);
        r1.put("userName", r0.userName);
        r1.put("isOwner", Boolean.TRUE);
        r1.put("ownerType", 0);
        r1.put("label", r0.organization);
        r1.put("permissions", Integer.valueOf(ShareFolderUtils.a()));
        return r1;
    }
}
