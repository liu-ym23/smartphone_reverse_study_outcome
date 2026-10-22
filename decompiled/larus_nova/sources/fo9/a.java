package fo9;

import com.larus.office.permission.DocPermissionFullData;

/* JADX INFO: loaded from: classes29.dex */
public interface a extends m1a.a, b {

    /* JADX INFO: renamed from: fo9.a$a, reason: collision with other inner class name */
    public interface InterfaceC5936a {
        void a(DocPermissionFullData r100);
    }

    DocPermissionFullData C4();

    void D70(InterfaceC5936a r100);

    void Io(d r100);

    void Wk(DocPermissionFullData r100);

    boolean canCopy();

    boolean canEdit();

    boolean canRead();

    boolean canShare();

    Integer getType();

    boolean isOwner();

    boolean k9();

    void mw(Integer r100);

    boolean p6();

    boolean s8();

    void vP(InterfaceC5936a r100);

    boolean y4();
}
