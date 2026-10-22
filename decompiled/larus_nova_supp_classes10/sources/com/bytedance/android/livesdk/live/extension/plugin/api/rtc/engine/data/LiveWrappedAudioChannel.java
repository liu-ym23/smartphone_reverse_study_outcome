package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import zf2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioChannel;", "", "", "value", "", "toString", "I", "Companion", "a", "AUDIO_CHANNEL_AUTO", "AUDIO_CHANNEL_MONO", "AUDIO_CHANNEL_STEREO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioChannel extends Enum<LiveWrappedAudioChannel> {
    public static final LiveWrappedAudioChannel AUDIO_CHANNEL_AUTO = null;
    public static final LiveWrappedAudioChannel AUDIO_CHANNEL_MONO = null;
    public static final LiveWrappedAudioChannel AUDIO_CHANNEL_STEREO = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedAudioChannel[] a = null;
    private int value;

    public static final class a {
        public a() {
        }
    }

    static {
        LiveWrappedAudioChannel r1 = new LiveWrappedAudioChannel("AUDIO_CHANNEL_AUTO", 0, -1);
        AUDIO_CHANNEL_AUTO = r1;
        LiveWrappedAudioChannel r2 = new LiveWrappedAudioChannel("AUDIO_CHANNEL_MONO", 1, 1);
        AUDIO_CHANNEL_MONO = r2;
        LiveWrappedAudioChannel r3 = new LiveWrappedAudioChannel("AUDIO_CHANNEL_STEREO", 2, 2);
        AUDIO_CHANNEL_STEREO = r3;
        a = new LiveWrappedAudioChannel[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedAudioChannel valueOf(String r1) {
        return (LiveWrappedAudioChannel) r27.a.a(LiveWrappedAudioChannel.class, r1);
    }

    public static LiveWrappedAudioChannel[] values() {
        return (LiveWrappedAudioChannel[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = c.a[ordinal()];
        if (r0 != 1) goto L5;
        return "kAudioChannelAuto";
    L5:
        if (r0 != 2) goto L7;
        return "kAudioChannelMono";
    L7:
        if (r0 == 3) goto L9;
        return "kAudioChannelUnknown";
    L9:
        return "kAudioChannelStereo";
    }

    public final int value() {
        return this.value;
    }

    @JvmStatic
    public static final LiveWrappedAudioChannel fromId(int r5) {
        Companion.getClass();
        LiveWrappedAudioChannel[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        LiveWrappedAudioChannel r3 = r0[r2];
        if (r3.value() == r5) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r3;
    L9:
        return AUDIO_CHANNEL_AUTO;
    }

    public LiveWrappedAudioChannel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
