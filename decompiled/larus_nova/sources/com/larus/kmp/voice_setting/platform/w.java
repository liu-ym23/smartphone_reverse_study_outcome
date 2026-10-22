package com.larus.kmp.voice_setting.platform;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w implements v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f351734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f351735b;

    @Override // com.larus.kmp.voice_setting.platform.v0
    public final void a(VoiceStringKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        t19.s r101 = t19.s.f544207a;
        Context r102 = this.f351735b;
        String r103 = this.f351734a.a(r100);
        r101.getClass();
        t19.s.t(r102, r103);
    }

    @Override // com.larus.kmp.voice_setting.platform.v0
    public final void b(VoiceStringKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        t19.s r101 = t19.s.f544207a;
        Context r102 = this.f351735b;
        int r103 = x.c(r100);
        r101.getClass();
        t19.s.b(r102, r103, false);
    }

    @Override // com.larus.kmp.voice_setting.platform.v0
    public final void c(String r100) {
        t19.s r101 = t19.s.f544207a;
        Context r102 = this.f351735b;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        t19.s.j(r101, r102, r100, null, false, 28);
    }

    @Override // com.larus.kmp.voice_setting.platform.v0
    public final void d(String r100) {
        t19.s r101 = t19.s.f544207a;
        Context r102 = this.f351735b;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.getClass();
        t19.s.c(r102, r100);
    }

    @Override // com.larus.kmp.voice_setting.platform.v0
    public final void e(VoiceStringKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        t19.s.f544207a.g(this.f351735b, x.c(r100), false);
    }

    @Override // com.larus.kmp.voice_setting.platform.v0
    public final void f(VoiceStringKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        t19.s r101 = t19.s.f544207a;
        Context r102 = this.f351735b;
        int r103 = x.c(r100);
        r101.getClass();
        t19.s.o(r102, r103, false);
    }

    public w(Context r100, v r101) {
        Intrinsics.checkNotNullParameter(r101, "resources");
        this.f351734a = r101;
        if (r100 == null) goto L5;
        Context r102 = r100.getApplicationContext();
    L6:
        this.f351735b = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
