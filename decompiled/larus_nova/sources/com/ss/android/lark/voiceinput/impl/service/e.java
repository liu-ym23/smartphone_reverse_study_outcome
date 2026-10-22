package com.ss.android.lark.voiceinput.impl.service;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f445119a = null;

    static {
        f445119a = new e();
    }

    public e() {
    }

    @Override // com.ss.android.lark.voiceinput.impl.service.h
    public final void a(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Log.e("DefaultVoiceService", "【VoiceApp】" + r100, r101);
    }
}
