package com.bytedance.ee.bear.bitable.utils;

import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(DocumentInfo r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "documentInfo");
        Intrinsics.checkNotNullParameter(r2, "operation");
        return b(r1, r2).getAllow();
    }

    public static PermissionResponse b(DocumentInfo r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "documentInfo");
        Intrinsics.checkNotNullParameter(r14, "operation");
        UniBaseEntity r0 = new UniBaseEntity(r13.getObjToken(), sbb.e.d(r13.getType()), BizDomain.FileBizDomainCCM, r13.getCreatorTenantId(), r13.getOwnerUid(), null, null, null, null, 480, null);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r0, r14), new UserPermissionEntity(r13.getDocPermission().a, null));
    }
}
