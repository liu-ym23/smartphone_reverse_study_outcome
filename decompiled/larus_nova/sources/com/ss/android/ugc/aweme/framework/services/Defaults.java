package com.ss.android.ugc.aweme.framework.services;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes5.dex */
public final class Defaults {
    private static final Double DOUBLE_DEFAULT = null;
    private static final Float FLOAT_DEFAULT = null;

    private Defaults() {
    }

    static {
        DOUBLE_DEFAULT = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        FLOAT_DEFAULT = Float.valueOf(0.0f);
    }

    public static <T> T defaultValue(Class<T> r100) {
        requireNonNull(r100);
        if (r100 != Boolean.TYPE) goto L7;
        return (T) Boolean.FALSE;
    L7:
        if (r100 != Character.TYPE) goto L11;
        return (T) (char) 0;
    L11:
        if (r100 != Byte.TYPE) goto L15;
        return (T) (byte) 0;
    L15:
        if (r100 != Short.TYPE) goto L19;
        return (T) (short) 0;
    L19:
        if (r100 != Integer.TYPE) goto L23;
        return (T) 0;
    L23:
        if (r100 != Long.TYPE) goto L27;
        return (T) 0L;
    L27:
        if (r100 != Float.TYPE) goto L31;
        return (T) FLOAT_DEFAULT;
    L31:
        if (r100 == Double.TYPE) goto L33;
        return null;
    L33:
        return (T) DOUBLE_DEFAULT;
    }

    public static <T> T requireNonNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }
}
