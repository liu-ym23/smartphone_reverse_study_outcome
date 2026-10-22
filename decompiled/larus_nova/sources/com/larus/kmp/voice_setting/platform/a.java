package com.larus.kmp.voice_setting.platform;

import com.larus.platform.api.j2;
import com.larus.platform.service.DoraAudioService;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements y {
    public a() {
    }

    @Override // com.larus.kmp.voice_setting.platform.y
    public final void b() {
        j2 r100 = DoraAudioService.c();
        if (r100 == null) goto L6;
        r100.m();
        return;
    }

    @Override // com.larus.kmp.voice_setting.platform.y
    public final boolean c() {
        j2 r100 = DoraAudioService.c();
        if (r100 == null) goto L10;
        Integer r101 = r100.h();
        if (r101 == null) goto L10;
        if (r101.intValue() != 2) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.larus.kmp.voice_setting.platform.y
    public final void a() {
        DoraAudioService.a();
    }

    @Override // com.larus.kmp.voice_setting.platform.y
    public final void d() {
        DoraAudioService.b();
    }
}
