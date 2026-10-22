package com.larus.kmp.voice_setting.voice.bridge;

import kotlin.collections.MapsKt;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class y {
    public static final boolean a() {
        d0 r100 = v.a().e("flow_speak_style_config", new d0(MapsKt.emptyMap()), false);
        v.b();
        return w.a(r100, "enable_new_style", true);
    }

    public static final boolean b() {
        return v.a().d("ugc_voice_public", false);
    }
}
