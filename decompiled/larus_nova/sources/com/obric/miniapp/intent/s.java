package com.obric.miniapp.intent;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f397723d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f397724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, String> f397725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f397726c;

    public static final class a {
    }

    static {
        f397723d = new s();
    }

    public s() {
        this.f397724a = 128;
        this.f397725b = new LinkedHashMap();
        this.f397726c = new LinkedHashMap();
    }

    public final synchronized String a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "localMessageId");     // Catch: Throwable -> L6
        String r101 = (String) ((LinkedHashMap) this.f397726c).get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String b(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "cardId");     // Catch: Throwable -> L6
        String r101 = this.f397725b.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
