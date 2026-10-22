package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import android.util.SparseArray;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreAudioFormat;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "PCM", "WAV", "AAC", "OPUS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreAudioFormat extends Enum<LiveWrappedSAMICoreAudioFormat> {
    public static final LiveWrappedSAMICoreAudioFormat AAC = null;
    public static final a Companion = null;
    public static final LiveWrappedSAMICoreAudioFormat OPUS = null;
    public static final LiveWrappedSAMICoreAudioFormat PCM = null;
    public static final LiveWrappedSAMICoreAudioFormat WAV = null;
    public static final /* synthetic */ LiveWrappedSAMICoreAudioFormat[] a = null;
    public static final SparseArray<LiveWrappedSAMICoreAudioFormat> b = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreAudioFormat$a] */
    static {
        int r3 = 0;
        LiveWrappedSAMICoreAudioFormat r1 = new LiveWrappedSAMICoreAudioFormat("PCM", 0, 0);
        PCM = r1;
        LiveWrappedSAMICoreAudioFormat r2 = new LiveWrappedSAMICoreAudioFormat("WAV", 1, 1);
        WAV = r2;
        LiveWrappedSAMICoreAudioFormat r4 = new LiveWrappedSAMICoreAudioFormat("AAC", 2, 2);
        AAC = r4;
        LiveWrappedSAMICoreAudioFormat r5 = new LiveWrappedSAMICoreAudioFormat("OPUS", 3, 3);
        OPUS = r5;
        a = new LiveWrappedSAMICoreAudioFormat[]{r1, r2, r4, r5};
        Companion = new a();
        b = new SparseArray();
        LiveWrappedSAMICoreAudioFormat[] r0 = values();
        int r6 = r0.length;
    L3:
        if (r3 >= r6) goto L5;
        LiveWrappedSAMICoreAudioFormat r7 = r0[r3];
        b.put(r7.value, r7);
        r3 = r3 + 1;
        goto L3
    }

    public static LiveWrappedSAMICoreAudioFormat valueOf(String r1) {
        return (LiveWrappedSAMICoreAudioFormat) r27.a.a(LiveWrappedSAMICoreAudioFormat.class, r1);
    }

    public static LiveWrappedSAMICoreAudioFormat[] values() {
        return (LiveWrappedSAMICoreAudioFormat[]) a.clone();
    }

    public static final /* synthetic */ SparseArray access$getIntToEnumMap$cp() {
        return b;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreAudioFormat(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
