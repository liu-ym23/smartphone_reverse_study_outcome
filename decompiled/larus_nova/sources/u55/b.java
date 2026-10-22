package u55;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import jg5.e;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DocPermission f548841b;

    public final boolean a() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.f499003a.g() == false) goto L7;
        s55.a r100 = s55.a.f540731a;
        return s55.a.m(this.f548840a, "COMMENT", this.f548841b).getAllow();
    L7:
        return this.f548841b.f234419a.canComment();
    }

    public final boolean b() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.f499003a.g() == false) goto L7;
        s55.a r100 = s55.a.f540731a;
        return s55.a.m(this.f548840a, "CONTENT_COPY", this.f548841b).getAllow();
    L7:
        return this.f548841b.f234419a.canCopy();
    }

    public final boolean c() {
        return this.f548841b.f234419a.canEdit();
    }

    public final boolean d() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.f499003a.g() == false) goto L7;
        s55.a r100 = s55.a.f540731a;
        return s55.a.m(this.f548840a, "EXPORT", this.f548841b).getAllow();
    L7:
        return this.f548841b.f234419a.canExport();
    }

    public final boolean e() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.f499003a.g() == false) goto L7;
        s55.a r100 = s55.a.f540731a;
        return s55.a.m(this.f548840a, "VIEW", this.f548841b).getAllow();
    L7:
        return this.f548841b.f234419a.canRead();
    }

    public final int f() {
        return this.f548841b.f234419a.getPermissionStatusCode();
    }

    public final int g() {
        return this.f548841b.f234419a.getControlPointMap().get("view").intValue();
    }

    public final boolean i() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.f499003a.d() == true) goto L5;
        return false;
    L5:
        if (g() != 2004) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean j() {
        if (this.f548841b.f234419a.getErrorCode() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean k() {
        return this.f548841b.f234420b.isOwner();
    }

    public b() {
        this.f548840a = "";
        this.f548841b = new DocPermission();
    }

    public final boolean h() {
        if (e() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f548841b.f234419a.canPerceive() == false) goto L7;
        return true;
    }

    public b(String r100, DocPermission r101) {
        this.f548840a = r100;
        this.f548841b = r101;
    }
}
