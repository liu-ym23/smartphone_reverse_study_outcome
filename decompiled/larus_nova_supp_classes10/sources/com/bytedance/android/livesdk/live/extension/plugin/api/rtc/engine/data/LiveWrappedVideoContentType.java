package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoContentType;", "", "", "value", "", "toString", "I", "Companion", "a", "NORMAL_FRAME", "BLACK_FRAME", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoContentType extends Enum<LiveWrappedVideoContentType> {
    public static final LiveWrappedVideoContentType BLACK_FRAME = null;
    public static final a Companion = null;
    public static final LiveWrappedVideoContentType NORMAL_FRAME = null;
    public static final /* synthetic */ LiveWrappedVideoContentType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoContentType$a] */
    static {
        LiveWrappedVideoContentType r1 = new LiveWrappedVideoContentType("NORMAL_FRAME", 0, 0);
        NORMAL_FRAME = r1;
        LiveWrappedVideoContentType r2 = new LiveWrappedVideoContentType("BLACK_FRAME", 1, 1);
        BLACK_FRAME = r2;
        a = new LiveWrappedVideoContentType[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedVideoContentType valueOf(String r1) {
        return (LiveWrappedVideoContentType) r27.a.a(LiveWrappedVideoContentType.class, r1);
    }

    public static LiveWrappedVideoContentType[] values() {
        return (LiveWrappedVideoContentType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != NORMAL_FRAME) goto L5;
        return "kVideoContentTypeNormalFrame";
    L5:
        return "kVideoContentTypeBlackFrame";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoContentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
