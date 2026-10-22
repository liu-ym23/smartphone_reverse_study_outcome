package com.larus.kmp.voice_setting.platform;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.audio.quality.AudioCheckerResult;

/* JADX INFO: loaded from: classes30.dex */
public final class o0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351710a = null;

        static {
            int[] r100 = new int[AudioCheckerResult.values().length];
            r100[AudioCheckerResult.PASSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[AudioCheckerResult.AUDIO_RECORD_SILENCED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[AudioCheckerResult.INTERNAL_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[AudioCheckerResult.NETWORK_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[AudioCheckerResult.SNR_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[AudioCheckerResult.WER_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[AudioCheckerResult.INIT_CONFIG_ERROR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[AudioCheckerResult.INIT_METRIC_ERROR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f351710a = r100;
        }
    }

    public static final n0 a(Object r110) {
        boolean r100 = r110 instanceof Fragment;
        FragmentActivity r101 = null;
        if (r100 == false) goto L5;
        Fragment r102 = (Fragment) r110;
    L6:
        if (r100 == false) goto L9;
        Context r103 = ((Fragment) r110).getContext();
    L12:
        if (r102 == null) goto L18;
        FragmentActivity r104 = r102.getActivity();
        if (r104 == null) goto L18;
        r101 = r104;
    L20:
        v r105 = new v(r103);
        return new n0(new s(r102, r101), new l(), new AndroidVoiceFileGateway(r103), new u(), r105, new w(r103, r105), new com.larus.kmp.voice_setting.platform.a(), new q(r103, r102), new e(), new f(), new d(), new g(), new c(), new b());
    L18:
        if ((r103 instanceof FragmentActivity) == false) goto L20;
        r101 = (FragmentActivity) r103;
        goto L20
    L9:
        if ((r110 instanceof Context) == false) goto L11;
        r103 = (Context) r110;
        goto L12
    L11:
        r103 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
