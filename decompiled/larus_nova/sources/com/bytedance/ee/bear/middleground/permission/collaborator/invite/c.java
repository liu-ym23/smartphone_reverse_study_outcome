package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground_permission_export.model.ShareFolderUtils;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static HashMap<String, Object> a() {
        AccountService$Account r100 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r100 != null) goto L6;
        tt5.a.d("CollaboratorUtils", "getDefaultFolderOwner account is null!");
        return null;
    L6:
        HashMap<String, Object> r101 = new HashMap();
        r101.put("uid", r100.uid);
        r101.put("avatarUrl", r100.avatarUrl);
        r101.put("tenantId", r100.tenantId);
        r101.put("tenantName", r100.tenantName);
        r101.put("cnName", r100.cnName);
        r101.put("enName", r100.enName);
        r101.put("userName", r100.userName);
        r101.put("isOwner", Boolean.TRUE);
        r101.put("ownerType", 0);
        r101.put("label", r100.organization);
        r101.put(ComplianceResult.JsonKey.PERMISSIONS, Integer.valueOf(ShareFolderUtils.a()));
        return r101;
    }
}
