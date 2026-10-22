package com.larus.kmp.voice_setting.voice.mix;

/* JADX INFO: loaded from: classes30.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f353760a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f353761a = null;

        static {
            int[] r100 = new int[VoiceMixPlayVisualState.values().length];
            r100[VoiceMixPlayVisualState.Playing.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VoiceMixPlayVisualState.Loading.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VoiceMixPlayVisualState.Idle.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f353761a = r100;
        }
    }

    static {
    }
}
