package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;

/* JADX INFO: loaded from: classes15.dex */
public final class f {
    public static final boolean a(String r100) {
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity(r100, sbb.e.f541301l, BizDomain.FileBizDomainCCM, ""), "VIEW"), null).getAllow();
    }
}
