package com.ss.android.lark.voiceinput.impl.service.asr;

import com.ss.android.lark.voiceinput.api.data.model.asr.VoiceAsrState;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes38.dex */
public final class VoiceAsrStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jbc.a<VoiceAsrState> f445108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f445109b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f445110a = null;

        static {
            int[] r100 = new int[VoiceAsrState.values().length];
            r100[VoiceAsrState.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[VoiceAsrState.Preparing.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[VoiceAsrState.Prepared.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[VoiceAsrState.Streaming.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[VoiceAsrState.Finishing.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[VoiceAsrState.SwitchLanguage.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[VoiceAsrState.Canceled.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[VoiceAsrState.TimedOut.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[VoiceAsrState.Failed.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[VoiceAsrState.Finished.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[VoiceAsrState.Destroy.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f445110a = r100;
        }
    }

    public VoiceAsrStateMachine() {
        jbc.a<VoiceAsrState> r100 = new jbc.a(VoiceAsrState.Idle, new VoiceAsrStateMachine$stateMachine$1(this));
        this.f445108a = r100;
        this.f445109b = r100.f498066c;
    }

    public static boolean a(VoiceAsrState r100, VoiceAsrState... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        if (r101[r103] != r100) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L9;
        r103 = r103 + 1;
        goto L3
    L9:
        return true;
    L7:
        r104 = false;
        goto L8
    L14:
        return false;
    }
}
