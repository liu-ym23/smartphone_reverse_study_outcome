package com.larus.avlink.plugins;

import com.larus.audio.call.play.abs.TtsPlayEndType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p1 extends com.larus.audio.call.play.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1 f294043a;

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void c() {
        this.f294043a.c();
    }

    public p1(o1 r100) {
        this.f294043a = r100;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void b(Map<String, String> r100) {
        if (this.f294043a.f294019k == false) goto L6;
        this.f294043a.f294019k = false;
        com.larus.audio.call.tracer.b.b(this.f294043a.f294009a.i(), "tts_delay", null, 6);
        com.larus.audio.call.tracer.b.b(this.f294043a.f294009a.i(), "realcall_message", null, 6);
        o1 r101 = this.f294043a;
        r101.f294022n = System.currentTimeMillis();
        this.f294043a.f294024p = false;
        o1.e(this.f294043a, 0, -2, null, null, 12);
        o1 r102 = this.f294043a;
        r102.getClass();
        com.larus.utils.l0.b(new n1(r102, 0));
        o1 r103 = this.f294043a;
        r103.getClass();
        s1 r104 = new s1(r103);
        r103.f294029u = r104;
        r104.d();
        return;
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void f(TtsPlayEndType r100) {
        Intrinsics.checkNotNullParameter(r100, "endType");
        this.f294043a.d();
    }
}
