package ov5;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<pv5.a> f526904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<C7115a> f526905b = null;

    /* JADX INFO: renamed from: ov5.a$a, reason: collision with other inner class name */
    public static class C7115a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f526906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f526907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f526908c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f526909d;

        public C7115a(boolean r100, String r101, String r102, long r103) {
            this.f526906a = r100;
            this.f526907b = r101;
            this.f526908c = r102;
            this.f526909d = r103;
        }
    }

    static {
        f526905b = new ArrayList();
    }

    public static void a(String r100, String r101, long r110) {
        if (b.f526910a == true) goto L5;
        return;
    L5:
        List<C7115a> r102 = f526905b;
        monitor-enter(r102);
        C7115a r103 = new C7115a(false, r100, r101, r110);     // Catch: Throwable -> L10
        ((ArrayList) r102).add(r103);     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
