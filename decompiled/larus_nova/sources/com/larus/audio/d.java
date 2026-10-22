package com.larus.audio;

import com.larus.audio.tts.AudioDowngradeManager;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f289662a = null;

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            FLogger.f375446a.i("AudioAppBackgroundManager", "onAppBackground");
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            FLogger.f375446a.i("AudioAppBackgroundManager", "onAppForeground");
            AudioDowngradeManager r100 = AudioDowngradeManager.f289820a;
            AudioDowngradeManager.c();
        }
    }

    static {
        f289662a = new a();
    }
}
