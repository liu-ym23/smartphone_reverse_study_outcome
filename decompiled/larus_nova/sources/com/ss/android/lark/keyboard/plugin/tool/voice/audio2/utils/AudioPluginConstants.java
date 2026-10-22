package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
public final class AudioPluginConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f429985a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f429986b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f429987c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f429988d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f429989e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f429990f = null;

    static {
        AudioPluginFeature r100 = AudioPluginFeature.RECORD;
        f429985a = r100.getIndex();
        f429986b = AudioPluginFeature.WITH_TEXT.getIndex();
        f429987c = r100.getIndex();
        f429988d = AudioPluginFeature.RECOGNIZE.getIndex();
        f429989e = LazyKt.lazy(AudioPluginConstants$ASR_WAITING_TIPS_IN_MILLIS$2.INSTANCE);
        f429990f = LazyKt.lazy(AudioPluginConstants$ASR_TIMEOUT_IN_MILLIS$2.INSTANCE);
    }

    public static long a() {
        return ((Number) f429990f.getValue()).longValue();
    }
}
