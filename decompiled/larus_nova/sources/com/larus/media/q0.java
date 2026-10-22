package com.larus.media;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class q0 {
    public static final void a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.larus.platform.service.o.f365780a.b("audio_session_action", com.larus.utils.f.c(new Pair[]{TuplesKt.to("action_type", "deactivate"), TuplesKt.to("scene", r100), TuplesKt.to("session_type", Integer.valueOf(r101)), TuplesKt.to("success", Boolean.TRUE), TuplesKt.to("time_elapsed", 0), TuplesKt.to("enable_mixing", Boolean.valueOf(o.a()))}));
    }

    public static final void c(String r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.larus.platform.service.o.f365780a.b("audio_session_action", com.larus.utils.f.c(new Pair[]{TuplesKt.to("action_type", "activate"), TuplesKt.to("scene", r100), TuplesKt.to("session_type", Integer.valueOf(r101)), TuplesKt.to("success", Boolean.TRUE), TuplesKt.to("time_elapsed", Long.valueOf(System.currentTimeMillis() - r102)), TuplesKt.to("enable_mixing", Boolean.valueOf(o.a()))}));
    }

    public static final void b(String r100, int r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r103, "reason");
        com.larus.platform.service.o.f365780a.b("audio_session_action", com.larus.utils.f.c(new Pair[]{TuplesKt.to("action_type", "activate"), TuplesKt.to("scene", r100), TuplesKt.to("session_type", Integer.valueOf(r101)), TuplesKt.to("success", Boolean.FALSE), TuplesKt.to("error", r103), TuplesKt.to("time_elapsed", Long.valueOf(System.currentTimeMillis() - r102)), TuplesKt.to("enable_mixing", Boolean.valueOf(o.a()))}));
    }
}
