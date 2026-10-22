package zg9;

import com.larus.kmp.voice_setting.voice.utils.h;
import kotlin.jvm.internal.Intrinsics;
import mh9.v;
import ouc.d0;
import p2a.d;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements p2a.c {
    public c() {
    }

    @Override // p2a.h
    public final d a3() {
        return com.larus.kmp.voice_setting.voice.base.d.f351783a;
    }

    @Override // p2a.h
    public final v2a.b f7() {
        return com.larus.kmp.voice_setting.voice.mix.a.f353751a;
    }

    @Override // p2a.h
    public final p2a.a l2() {
        return h.f355098a;
    }

    @Override // p2a.h
    public final void G(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = v.f514022a;
        Intrinsics.checkNotNullParameter(r100, "params");
        v.a("voice_settings_scheme_jump_start", r100);
    }

    @Override // p2a.h
    public final void T0(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = v.f514022a;
        Intrinsics.checkNotNullParameter(r100, "params");
        v.a("voice_settings_change_end", r100);
    }

    @Override // p2a.h
    public final void X2(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = v.f514022a;
        Intrinsics.checkNotNullParameter(r100, "params");
        v.a("voice_settings_scheme_jump_end", r100);
    }
}
