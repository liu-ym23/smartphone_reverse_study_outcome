package com.larus.office.base.component.permission;

import com.larus.office.permission.DocPermissionFullData;

/* JADX INFO: loaded from: classes29.dex */
public interface a extends m1a.a, fo9.b {

    /* JADX INFO: renamed from: com.larus.office.base.component.permission.a$a, reason: collision with other inner class name */
    public interface InterfaceC4430a {
        void a(DocPermissionFullData r100);
    }

    DocPermissionFullData C4();

    void LR(InterfaceC4430a r100);

    void R20(InterfaceC4430a r100);

    boolean canCopy();

    boolean canEdit();

    boolean canRead();

    boolean canShare();

    boolean isOwner();

    boolean k9();

    void mW(c r100);

    boolean p6();

    boolean s8();

    boolean y4();
}
