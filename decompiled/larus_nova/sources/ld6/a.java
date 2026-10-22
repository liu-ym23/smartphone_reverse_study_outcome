package ld6;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f508696a = null;

    static {
        f508696a = new a();
    }

    public a() {
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r100, "msg");
        id6.b.f489337c.Q2("KPerf", r100, false);
    }

    public static void a(a r100, Function0 r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter("KPerf", "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        System.out.println("KPerf: " + ((String) r101.invoke()));
    }
}
