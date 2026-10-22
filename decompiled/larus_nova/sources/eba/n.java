package eba;

import com.obric.assistant.activation.presentation.runtime.manager.ActivationSource;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f471970a = null;

    static {
        int[] r100 = new int[ActivationSource.values().length];
        r100[ActivationSource.AI_KEY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r100[ActivationSource.VOICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r100[ActivationSource.BREATH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r100[ActivationSource.POWER_KEY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r100[ActivationSource.POWER_KEY_TERMINAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        f471970a = r100;
    }
}
