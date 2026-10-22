package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNRemoteAudioStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", "a", "Internal", "NetworkCongestion", "NetworkRecovery", "LocalUnmute", "LocalMute", "RemoteStart", "RemoteStop", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNRemoteAudioStateChangeReason extends Enum<LiveWrappedWTNRemoteAudioStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason Internal = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason LocalMute = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason LocalUnmute = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason NetworkCongestion = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason NetworkRecovery = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason RemoteStart = null;
    public static final LiveWrappedWTNRemoteAudioStateChangeReason RemoteStop = null;
    public static final /* synthetic */ LiveWrappedWTNRemoteAudioStateChangeReason[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteAudioStateChangeReason$a] */
    static {
        LiveWrappedWTNRemoteAudioStateChangeReason r1 = new LiveWrappedWTNRemoteAudioStateChangeReason("Internal", 0, 0);
        Internal = r1;
        LiveWrappedWTNRemoteAudioStateChangeReason r2 = new LiveWrappedWTNRemoteAudioStateChangeReason("NetworkCongestion", 1, 1);
        NetworkCongestion = r2;
        LiveWrappedWTNRemoteAudioStateChangeReason r3 = new LiveWrappedWTNRemoteAudioStateChangeReason("NetworkRecovery", 2, 2);
        NetworkRecovery = r3;
        LiveWrappedWTNRemoteAudioStateChangeReason r4 = new LiveWrappedWTNRemoteAudioStateChangeReason("LocalUnmute", 3, 3);
        LocalUnmute = r4;
        LiveWrappedWTNRemoteAudioStateChangeReason r5 = new LiveWrappedWTNRemoteAudioStateChangeReason("LocalMute", 4, 4);
        LocalMute = r5;
        LiveWrappedWTNRemoteAudioStateChangeReason r6 = new LiveWrappedWTNRemoteAudioStateChangeReason("RemoteStart", 5, 5);
        RemoteStart = r6;
        LiveWrappedWTNRemoteAudioStateChangeReason r7 = new LiveWrappedWTNRemoteAudioStateChangeReason("RemoteStop", 6, 6);
        RemoteStop = r7;
        a = new LiveWrappedWTNRemoteAudioStateChangeReason[]{r1, r2, r3, r4, r5, r6, r7};
        Companion = new a();
    }

    public static LiveWrappedWTNRemoteAudioStateChangeReason valueOf(String r1) {
        return (LiveWrappedWTNRemoteAudioStateChangeReason) r27.a.a(LiveWrappedWTNRemoteAudioStateChangeReason.class, r1);
    }

    public static LiveWrappedWTNRemoteAudioStateChangeReason[] values() {
        return (LiveWrappedWTNRemoteAudioStateChangeReason[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(a1.a[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "RemoteStop";
    L6:
        return "RemoteStart";
    L7:
        return "LocalMute";
    L8:
        return "LocalUnmute";
    L9:
        return "NetworkRecovery";
    L10:
        return "NetworkCongestion";
    L11:
        return "Internal";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNRemoteAudioStateChangeReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
