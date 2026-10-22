package com.larus.dora.impl.file;

import com.larus.dora.impl.DoraBuryPointManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f335732a = null;

    static {
        f335732a = new a();
    }

    public a() {
    }

    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        g49.d.a("DoraDefaultEventReporter", "report event=" + r100 + ", params=" + r101);
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, r100, r101, false, 12);
    }
}
