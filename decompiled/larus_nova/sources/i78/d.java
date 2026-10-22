package i78;

import com.bytedance.flow_audio.api.foundation.player.AudioPlayerStatus;
import com.bytedance.flow_audio.api.player.KmpAudioPlayerErrorEnum;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f488477a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f488478b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f488479c = null;

        static {
            int[] r100 = new int[AudioPlayerStatus.values().length];
            r100[AudioPlayerStatus.Initial.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            r100[AudioPlayerStatus.Playing.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L64:
            r100[AudioPlayerStatus.Paused.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L44:
            r100[AudioPlayerStatus.Stopped.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L10:
            f488477a = r100;
            int[] r101 = new int[PlayStateEnum.values().length];
            r101[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L58:
            r101[PlayStateEnum.PLAY_STATE_PLAYING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L38:
            r101[PlayStateEnum.PLAY_STATE_PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r101[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L15:
            f488478b = r101;
            int[] r102 = new int[KmpAudioPlayerErrorEnum.values().length];
            r102[KmpAudioPlayerErrorEnum.START_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L40:
            r102[KmpAudioPlayerErrorEnum.RELEASE_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L48:
            r102[KmpAudioPlayerErrorEnum.CONFIG_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L54:
            r102[KmpAudioPlayerErrorEnum.WRITE_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L62:
            r102[KmpAudioPlayerErrorEnum.INIT_ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L42:
            r102[KmpAudioPlayerErrorEnum.UNKNOWN_ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L22:
            f488479c = r102;
        }
    }

    public static final PlayStateEnum a(AudioPlayerStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f488477a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return PlayStateEnum.PLAY_STATE_FAIL;
    L17:
        return PlayStateEnum.PLAY_STATE_STOPPED;
    L18:
        return PlayStateEnum.PLAY_STATE_PAUSED;
    L19:
        return PlayStateEnum.PLAY_STATE_PLAYING;
    L15:
        return PlayStateEnum.PLAY_STATE_PREPARE;
    }
}
