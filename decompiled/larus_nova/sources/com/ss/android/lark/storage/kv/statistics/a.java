package com.ss.android.lark.storage.kv.statistics;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements m6c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f441083a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.storage.kv.statistics.a$a, reason: collision with other inner class name */
    public static final class C5310a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441084c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f441085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Object> f441086b;

        /* JADX INFO: renamed from: com.ss.android.lark.storage.kv.statistics.a$a$a, reason: collision with other inner class name */
        public static final class C5311a {
        }

        static {
        }

        public C5310a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            int r103 = b.f441087a;
            this.f441085a = "infra_unistore_event_kv";
            HashMap<String, Object> r104 = new HashMap();
            this.f441086b = r104;
            r104.put("type", r100);
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r104.put("repo_name", r101);
            if (r102 != null) goto L8;
            r102 = "";
        L8:
            r104.put("key", r102);
        }
    }

    public a() {
    }

    static {
        f441083a = new a();
        new HashSet();
    }

    public static String c(KVRepo r100) {
    L3:
        if ((r100 instanceof com.ss.android.lark.storage.kv.repo.c) == false) goto L6;
        r100 = ((com.ss.android.lark.storage.kv.repo.c) r100).c();
        goto L3
    L6:
        if ((r100 instanceof com.ss.android.lark.storage.kv.repo.d) == true) goto L8;
        String r101 = r100.getClass().getName();
        Intrinsics.checkNotNull(r101);
        return r101;
    L8:
        return ((com.ss.android.lark.storage.kv.repo.d) r100).c();
    }

    public static String d(String r110) {
        List r100 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        if ((!r100.isEmpty()) == false) goto L31;
        Iterator r101 = r100.iterator();
        int r102 = 0;
        String r103 = r110;
    L6:
        if (r101.hasNext() == false) goto L24;
        Object r104 = r101.next();
        int r105 = r102 + 1;
        if (r102 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r106 = (String) r104;
        if (r106.length() <= 10) goto L22;
        int r107 = 0;
    L14:
        if (r107 >= r106.length()) goto L19;
        if (Character.isDigit(r106.charAt(r107)) == false) goto L17;
        r107 = r107 + 1;
        goto L14
    L17:
        boolean r108 = false;
    L20:
        if (r108 == false) goto L22;
        r103 = StringsKt.replace$default(r110, r106, "user", false, 4, null);
        goto L22
    L19:
        r108 = true;
    L22:
        r102 = r105;
        goto L6
    L24:
        return r103;
    L31:
        return r110;
    }

    public static void g(C5310a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.ss.android.lark.storage.monitor.b.f441102a.getClass();
        com.ss.android.lark.storage.monitor.a r101 = com.ss.android.lark.storage.monitor.b.f441103b;
        if (r101 == null) goto L6;
        r101.sendEvent(r100.f441085a, r100.f441086b);
        return;
    }

    public static void e(KVRepo r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "srcRepo");
        Intrinsics.checkNotNullParameter(r101, "key");
        String r102 = d(c(r100));
        int r103 = C5310a.f441084c;
        Intrinsics.checkNotNullParameter(r102, "repoName");
        Intrinsics.checkNotNullParameter(r101, "key");
        g(new C5310a("migrate_triggered", r102, r101));
    }

    public static void f(KVRepo r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "kvRepo");
        Intrinsics.checkNotNullParameter(r101, "key");
        String r102 = d(c(r100));
        int r103 = C5310a.f441084c;
        Intrinsics.checkNotNullParameter(r102, "repoName");
        Intrinsics.checkNotNullParameter(r101, "key");
        g(new C5310a("serailize_error", r102, r101));
    }

    @Override // m6c.a
    public final void a(KVRepo r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "block");
        r102.invoke();
    }

    @Override // m6c.a
    public final String b(KVRepo r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "block");
        return (String) r102.invoke();
    }
}
