package com.larus.settings.tutor;

import androidx.camera.video.AudioStats;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<VoiceConfig> f368559a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<VoiceConfig> f368560b = null;

    static {
        f368559a = CollectionsKt.listOf(new VoiceConfig[]{a(-3.0d, false), a(-2.5d, false), a(-2.0d, false), a(-1.5d, false), a(-1.0d, false), a(-0.5d, false), a(AudioStats.AUDIO_AMPLITUDE_NONE, true), a(0.5d, false), a(1.0d, false), a(1.5d, false), a(2.0d, false), a(2.5d, false), a(3.0d, false)});
        f368560b = CollectionsKt.listOf(new VoiceConfig[]{a(0.7d, false), a(0.75d, false), a(0.8d, false), a(0.85d, false), a(0.9d, false), a(0.95d, false), a(1.0d, true), a(1.05d, false), a(1.1d, false), a(1.15d, false), a(1.2d, false), a(1.25d, false), a(1.3d, false), a(1.35d, false), a(1.4d, false), a(1.45d, false), a(1.5d, false)});
    }

    public static final VoiceConfig a(double r100, boolean r101) {
        return new VoiceConfig(Double.valueOf(r100), Boolean.valueOf(r101));
    }
}
