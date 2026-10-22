package u55;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import jg5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final String a;
    public final DocPermission b;

    public final boolean a() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L7;
        s55.a r0 = s55.a.a;
        return s55.a.m(this.a, "COMMENT", this.b).getAllow();
    L7:
        return this.b.a.canComment();
    }

    public final boolean b() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L7;
        s55.a r0 = s55.a.a;
        return s55.a.m(this.a, "CONTENT_COPY", this.b).getAllow();
    L7:
        return this.b.a.canCopy();
    }

    public final boolean c() {
        return this.b.a.canEdit();
    }

    public final boolean d() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L7;
        s55.a r0 = s55.a.a;
        return s55.a.m(this.a, "EXPORT", this.b).getAllow();
    L7:
        return this.b.a.canExport();
    }

    public final boolean e() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L7;
        s55.a r0 = s55.a.a;
        return s55.a.m(this.a, "VIEW", this.b).getAllow();
    L7:
        return this.b.a.canRead();
    }

    public final int f() {
        return this.b.a.getPermissionStatusCode();
    }

    public final int g() {
        return ((Integer) this.b.a.getControlPointMap().get("view")).intValue();
    }

    public final boolean i() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.d() == true) goto L5;
        return false;
    L5:
        if (g() != 2004) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean j() {
        if (this.b.a.getErrorCode() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean k() {
        return this.b.b.isOwner();
    }

    public b() {
        this.a = "";
        this.b = new DocPermission();
    }

    public final boolean h() {
        if (e() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.b.a.canPerceive() == false) goto L7;
        return true;
    }

    public b(String r1, DocPermission r2) {
        this.a = r1;
        this.b = r2;
    }
}
