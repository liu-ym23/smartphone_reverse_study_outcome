package x8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562882a;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f562882a = r100;
    }

    public static void c(b r100, Throwable r101) {
        Intrinsics.checkNotNullParameter("AnnieFragment", "tag");
        a.c("AnnieFragment", r101, false);
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r102 = a.f562881a;
        a.b(r100, d(null, r101), false);
    }

    public final String d(String r100, String r101) {
        if (r100 == null) goto L7;
        String r102 = "{\"session_id\": \"" + this.f562882a + "\", \"name\": \"" + r100 + "\", \"msg\": \"" + r101 + "\"}";
        if (r102 == null) goto L7;
        return r102;
    L7:
        return "{\"session_id\": \"" + this.f562882a + "\", \"msg\": \"" + r101 + "\"}";
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r102 = a.f562881a;
        a.d(r100, d(null, r101), false);
    }

    public final void f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "msg");
        int r103 = a.f562881a;
        a.d(r100, d(r101, r102), false);
    }

    public static void b(b r100, String r101, String r102, String r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "stage");
        Intrinsics.checkNotNullParameter(r103, "msg");
        int r104 = a.f562881a;
        a.b(r101, r100.d(r102, r103), false);
    }
}
