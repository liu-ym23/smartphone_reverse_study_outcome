package com.larus.kmp.voice_setting.platform;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class v implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f351733a;

    public v(Context r100) {
        this.f351733a = r100;
    }

    @Override // com.larus.kmp.voice_setting.platform.u0
    public final String a(VoiceStringKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return x.a(this.f351733a, r100, new Object[0]);
    }
}
