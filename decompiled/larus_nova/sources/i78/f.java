package i78;

import com.bytedance.flow_audio.api.service.KmpTtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f488482a = null;

        static {
            int[] r100 = new int[KmpTtsLifeState.values().length];
            r100[KmpTtsLifeState.TTS_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[KmpTtsLifeState.TTS_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[KmpTtsLifeState.TTS_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[KmpTtsLifeState.TTS_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[KmpTtsLifeState.TTS_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[KmpTtsLifeState.TTS_START_PLAYING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[KmpTtsLifeState.TTS_FINISH_PLAYING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f488482a = r100;
        }
    }

    public static final TtsLifeState a(KmpTtsLifeState r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(a.f488482a[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return TtsLifeState.TTS_FINISH_PLAYING;
    L15:
        return TtsLifeState.TTS_START_PLAYING;
    L16:
        return TtsLifeState.TTS_RESUME;
    L17:
        return TtsLifeState.TTS_PAUSE;
    L18:
        return TtsLifeState.TTS_ERROR;
    L19:
        return TtsLifeState.TTS_STOP;
    L13:
        return TtsLifeState.TTS_START;
    }
}
