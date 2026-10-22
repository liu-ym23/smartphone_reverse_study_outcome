package er9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f473641e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f473642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f473643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f473644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f473645d;

    /* JADX INFO: renamed from: er9.a$a, reason: collision with other inner class name */
    public static final class C5808a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f473642a, r101.f473642a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f473643b, r101.f473643b) == true) goto L15;
        return false;
    L15:
        if (this.f473644c == r101.f473644c) goto L18;
        return false;
    L18:
        if (this.f473645d == r101.f473645d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        b r100 = this.f473642a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b r104 = this.f473643b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f473644c) * 31;
        if (this.f473645d == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProjectListDataSourceConfig(projectPagingConfig=" + this.f473642a + ", projectConversationPagingConfig=" + this.f473643b + ", projectListUpdateStrategy=" + this.f473644c + ", enableAddLocalFolder=" + this.f473645d + ')';
    }

    static {
        f473641e = new a(0);
    }

    public /* synthetic */ a(int r100) {
        this(new b(0), new b(0), 0, false);
    }

    public a(b r100, b r101, int r102, boolean r103) {
        this.f473642a = r100;
        this.f473643b = r101;
        this.f473644c = r102;
        this.f473645d = r103;
    }
}
