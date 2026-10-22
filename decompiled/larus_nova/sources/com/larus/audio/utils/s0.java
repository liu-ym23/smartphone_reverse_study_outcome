package com.larus.audio.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f290136a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f290137a = null;

        static {
            int[] r100 = new int[AudioLogLevel.values().length];
            r100[AudioLogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AudioLogLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AudioLogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AudioLogLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f290137a = r100;
        }
    }

    public s0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f290136a = r100;
    }
}
