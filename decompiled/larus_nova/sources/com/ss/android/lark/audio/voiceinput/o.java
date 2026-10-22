package com.ss.android.lark.audio.voiceinput;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f409281a = 0;

    static {
    }

    public static boolean a(String r100) {
        boolean r101 = idb.f.a().isCurrentEnable(r100);
        Log.i("VoiceInputFeatureConfig", "isFgEnable: " + r100 + ':' + r101);
        return r101;
    }
}
