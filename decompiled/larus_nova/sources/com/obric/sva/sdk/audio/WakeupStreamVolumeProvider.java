package com.obric.sva.sdk.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Build;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/sva/sdk/audio/WakeupStreamVolumeProvider;", "", "<init>", "()V", "TAG", "", "getMaxActiveStreamVolumePercent", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "aecState", "", "isStreamActive", "", "streamType", "audioManager", "Landroid/media/AudioManager;", "getStreamTypes", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupStreamVolumeProvider {
    public static final WakeupStreamVolumeProvider INSTANCE = null;
    private static final String TAG = "WakeupStreamVolumeProvider";

    static {
        INSTANCE = new WakeupStreamVolumeProvider();
    }

    private WakeupStreamVolumeProvider() {
    }

    private final int[] getStreamTypes() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(AudioManager.class.getField("STREAM_ASSISTANT").getInt(null)));     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L10;
        LogUtils.w(TAG, "STREAM_ASSISTANT not available: " + r102.getMessage(), new Object[0]);
    L10:
        if (Result.m9455isFailureimpl(r101) == false) goto L12;
        r101 = -1;
    L12:
        int r103 = ((Number) r101).intValue();
        if (r103 == (-1)) goto L16;
        return new int[]{1, 2, 3, 4, 0, r103};
    L16:
        return new int[]{1, 2, 3, 4, 0};
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @JvmStatic
    public static final float getMaxActiveStreamVolumePercent(Context r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r100 = 0.0f;
        if (r111 != 0) goto L5;
        return 0.0f;
    L5:
        Object r112 = r110.getSystemService("audio");
        if ((r112 instanceof AudioManager) == false) goto L8;
        AudioManager r113 = (AudioManager) r112;
    L9:
        if (r113 != null) goto L11;
        return 0.0f;
    L11:
        int[] r114 = INSTANCE.getStreamTypes();
        int r101 = r114.length;
        int r102 = 3;
        int r103 = 0;
    L13:
        if (r103 >= r101) goto L29;
        int r104 = r114[r103];
        boolean r105 = INSTANCE.isStreamActive(r104, r113);
        LogUtils.i(TAG, "getStreamVolume, streamType: " + r104 + ", isStreamActive: " + r105, new Object[0]);
        if (r105 == false) goto L27;
        if (r104 == 2) goto L28;
        if (r104 == 4) goto L28;
        int r106 = r113.getStreamMaxVolume(r104);
        if (r106 <= 0) goto L27;
        double r107 = ((double) r113.getStreamVolume(r104)) / ((double) r106);
        if (r107 <= r100) goto L27;
        r100 = (float) r107;
        r102 = r104;
    L28:
        r100 = 1.0f;
        r102 = r104;
    L27:
        r103 = r103 + 1;
    L29:
        LogUtils.i(TAG, "maxVolumePercent: " + r100 + ", maxVolumeStream: " + r102, new Object[0]);
        return r100;
    L8:
        r113 = null;
        goto L9
    }

    private final boolean isStreamActive(int r110, AudioManager r111) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        List<AudioPlaybackConfiguration> r112 = r111.getActivePlaybackConfigurations();
        Intrinsics.checkNotNull(r112);
    L7:
        if (r112.isEmpty() == false) goto L9;
        return false;
    L9:
        Iterator<AudioPlaybackConfiguration> r113 = r112.iterator();
    L11:
        if (r113.hasNext() == false) goto L56;
        AudioPlaybackConfiguration r100 = r113.next();
        Integer r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        Object r103 = r100.getClass().getMethod("isPlaying", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L22
        if ((r103 instanceof Boolean) == false) goto L16;
        Boolean r104 = (Boolean) r103;     // Catch: Throwable -> L22
    L17:
        if (r104 == null) goto L19;
        boolean r105 = r104.booleanValue();     // Catch: Throwable -> L22
    L20:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L22
    L24:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L27;
        LogUtils.w(TAG, "isPlaying reflect failed for config=" + r100, new Object[]{r107});
    L27:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L31;
        r106 = r108;
    L31:
        if (((Boolean) r106).booleanValue() == false) goto L11;
        if (Build.VERSION.SDK_INT < 26) goto L36;
        AudioAttributes r109 = r100.getAudioAttributes();
    L37:
        if (r109 == null) goto L11;
        Object r114 = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[]{AudioAttributes.class}).invoke(null, new Object[]{r109});     // Catch: Throwable -> L48
        if ((r114 instanceof Integer) == false) goto L43;
        r101 = (Integer) r114;     // Catch: Throwable -> L48
    L43:
        if (r101 == null) goto L45;
        int r115 = r101.intValue();     // Catch: Throwable -> L48
    L46:
        Object r116 = Result.m9449constructorimpl(Integer.valueOf(r115));     // Catch: Throwable -> L48
    L51:
        if (Result.m9455isFailureimpl(r116) == false) goto L54;
        r116 = Integer.MIN_VALUE;
    L54:
        if (((Number) r116).intValue() != r110) goto L11;
        return true;
    L45:
        r115 = Integer.MIN_VALUE;
    L48:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    L36:
        r109 = null;
        goto L37
    L19:
        r105 = false;
        goto L20
    L16:
        r104 = null;
    L22:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L56:
        return false;
    L5:
        r112 = CollectionsKt.emptyList();
        goto L7
    }
}
