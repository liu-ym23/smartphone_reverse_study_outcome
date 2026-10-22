package com.larus.larkfeed.impl.voice.service.asr;

import com.ss.android.lark.voiceinput.api.data.model.asr.VoiceAsrState;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f355662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f355663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f355664c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355665a = null;

        static {
            int[] r100 = new int[VoiceAsrState.values().length];
            r100[VoiceAsrState.Finished.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[VoiceAsrState.Failed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[VoiceAsrState.TimedOut.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[VoiceAsrState.Canceled.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f355665a = r100;
        }
    }

    public i() {
        this.f355662a = new AtomicBoolean(false);
        this.f355663b = new AtomicBoolean(false);
        this.f355664c = new AtomicBoolean(false);
    }
}
