package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import dg2.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedAudioVADType;", "", "", "value", "", "toString", "I", "Companion", "a", "NO_SPEECH", "SPEECH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioVADType extends Enum<LiveWrappedAudioVADType> {
    public static final a Companion = null;
    public static final LiveWrappedAudioVADType NO_SPEECH = null;
    public static final LiveWrappedAudioVADType SPEECH = null;
    public static final /* synthetic */ LiveWrappedAudioVADType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioVADType$a] */
    static {
        LiveWrappedAudioVADType r1 = new LiveWrappedAudioVADType("NO_SPEECH", 0, 0);
        NO_SPEECH = r1;
        LiveWrappedAudioVADType r2 = new LiveWrappedAudioVADType("SPEECH", 1, 1);
        SPEECH = r2;
        a = new LiveWrappedAudioVADType[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedAudioVADType valueOf(String r1) {
        return (LiveWrappedAudioVADType) r27.a.a(LiveWrappedAudioVADType.class, r1);
    }

    public static LiveWrappedAudioVADType[] values() {
        return (LiveWrappedAudioVADType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = b.a[ordinal()];
        if (r0 != 1) goto L5;
        return "kAudioVADTypeNoSpeech";
    L5:
        if (r0 == 2) goto L8;
        return "valid";
    L8:
        return "kAudioVADTypeSpeech";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAudioVADType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
