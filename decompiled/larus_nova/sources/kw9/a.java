package kw9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f506417f;

    /* JADX INFO: renamed from: kw9.a$a, reason: collision with other inner class name */
    public static final class C6621a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f506412a, r101.f506412a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506413b, r101.f506413b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506414c, r101.f506414c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506415d, r101.f506415d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506416e, r101.f506416e) == true) goto L24;
        return false;
    L24:
        if (this.f506417f == r101.f506417f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f506412a.hashCode() * 31) + this.f506413b.hashCode()) * 31) + this.f506414c.hashCode()) * 31) + this.f506415d.hashCode()) * 31) + this.f506416e.hashCode()) * 31) + this.f506417f;
    }

    public final String toString() {
        return "DoubaoForwardTarget(id=" + this.f506412a + ", name=" + this.f506413b + ", avatarKey=" + this.f506414c + ", threadId=" + this.f506415d + ", p2pChatId=" + this.f506416e + ", targetType=" + this.f506417f + ')';
    }

    public static a a(a r100) {
        String r101 = r100.f506412a;
        String r102 = r100.f506413b;
        String r103 = r100.f506414c;
        String r104 = r100.f506415d;
        String r105 = r100.f506416e;
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "avatarKey");
        Intrinsics.checkNotNullParameter(r104, "threadId");
        Intrinsics.checkNotNullParameter(r105, "p2pChatId");
        return new a(r101, r102, r103, r104, r105, 1);
    }

    public a(String r100, String r101, String r102, String r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        Intrinsics.checkNotNullParameter(r103, "threadId");
        Intrinsics.checkNotNullParameter(r104, "p2pChatId");
        this.f506412a = r100;
        this.f506413b = r101;
        this.f506414c = r102;
        this.f506415d = r103;
        this.f506416e = r104;
        this.f506417f = r105;
    }
}
