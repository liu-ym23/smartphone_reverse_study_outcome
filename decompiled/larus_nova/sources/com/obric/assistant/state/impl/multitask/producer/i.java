package com.obric.assistant.state.impl.multitask.producer;

import com.obric.assistant.state.api.multitask.state.ObricInteractionType;

/* JADX INFO: loaded from: classes33.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f393171a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f393172a = null;

        static {
            int[] r100 = new int[ObricInteractionType.values().length];
            r100[ObricInteractionType.TextMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[ObricInteractionType.ManualHalfDuplex.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[ObricInteractionType.AutoHalfDuplex.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[ObricInteractionType.NullMode.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ObricInteractionType.DefaultMode.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[ObricInteractionType.RealtimeCallMode.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f393172a = r100;
        }
    }

    static {
    }
}
