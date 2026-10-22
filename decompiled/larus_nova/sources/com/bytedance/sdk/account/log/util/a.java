package com.bytedance.sdk.account.log.util;

import java.util.Arrays;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements IProfiler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile C3760a f269168a;

    /* JADX INFO: renamed from: com.bytedance.sdk.account.log.util.a$a, reason: collision with other inner class name */
    public static final class C3760a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f269169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.sdk.account.log.util.b f269170b;

        public C3760a(com.bytedance.sdk.account.log.util.b r100) {
            this.f269169a = "Init";
            this.f269170b = r100;
        }
    }

    public static final class b {
    }

    static {
    }

    public a() {
    }

    public final void b() {
        long r100 = System.currentTimeMillis();
        long r101 = System.nanoTime();
        monitor-enter(this);
        C3760a r102 = this.f269168a;     // Catch: Throwable -> L11
        this.f269168a = new C3760a(new com.bytedance.sdk.account.log.util.b(System.currentTimeMillis(), System.nanoTime()));     // Catch: Throwable -> L11
        monitor-exit(this);
        String r103 = "[Checkpoint] Init ";
        if (r102 == null) goto L9;
        com.bytedance.sdk.account.log.util.b r104 = r102.f269170b;
        r103 = "[Checkpoint] Init \n  >> last checkpoint: " + r102.f269169a + " Duration: " + new c(r100 - r104.f269171a, r101 - r104.f269172b);
    L9:
        c(0, r103);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void c(int r100, String r101) {
        if (r100 != 1) goto L5;
        tb7.a.f("Profiler/TTAccountInit", r101, null);
        return;
    L5:
        if (r100 == 2) goto L7;
        tb7.a.d("Profiler/TTAccountInit", r101);
        return;
    L7:
        tb7.a.c("Profiler/TTAccountInit", r101, null);
    }

    @Override // com.bytedance.sdk.account.log.util.IProfiler
    public final void a(String r110, int r111, Pair... r112) {
        Pair[] r113 = (Pair[]) Arrays.copyOf(r112, r112.length);
        C3760a r100 = this.f269168a;
        long r101 = System.currentTimeMillis();
        long r102 = System.nanoTime();
        StringBuilder r103 = new StringBuilder();
        if (r111 != 1) goto L5;
        r103.append("[WARN] " + r110);
    L10:
        if (r113.length != 0) goto L12;
        boolean r114 = true;
    L14:
        if ((!r114) == false) goto L16;
        r103.append("\n");
        r103.append(LogFormatter.a(r113));
    L16:
        if (r100 == null) goto L18;
        com.bytedance.sdk.account.log.util.b r115 = r100.f269170b;
        c r116 = new c(r101 - r115.f269171a, r102 - r115.f269172b);
        r103.append("\n  >> Time elapsed since ");
        r103.append(r100.f269169a);
        r103.append(": ");
        r103.append(r116);
    L18:
        c(r111, r103.toString());
        return;
    L12:
        r114 = false;
        goto L14
    L5:
        if (r111 == 2) goto L7;
        r103.append("[Record] " + r110);
        goto L10
    L7:
        r103.append("[ERROR] " + r110);
        goto L10
    }
}
