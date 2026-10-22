package com.larus.dora.impl.serviceimpl;

import com.larus.dora.api.LightEffectStatus;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f338014a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f338015a = null;

        static {
            int[] r100 = new int[LightEffectStatus.values().length];
            r100[LightEffectStatus.TURN_ON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[LightEffectStatus.SLOWLY_FLASHING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[LightEffectStatus.RAPID_FLASHING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[LightEffectStatus.TURN_OFF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f338015a = r100;
        }
    }

    static {
    }
}
