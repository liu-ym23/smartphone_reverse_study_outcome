package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedStreamIndex;", "", "", "value", "", "toString", "I", "Companion", "a", "STREAM_INDEX_MAIN", "STREAM_INDEX_SCREEN", "STREAM_INDEX_3RD", "STREAM_INDEX_4TH", "STREAM_INDEX_5TH", "STREAM_INDEX_6TH", "STREAM_INDEX_7TH", "STREAM_INDEX_MAX", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedStreamIndex extends Enum<LiveWrappedStreamIndex> {
    public static final a Companion = null;
    public static final LiveWrappedStreamIndex STREAM_INDEX_3RD = null;
    public static final LiveWrappedStreamIndex STREAM_INDEX_4TH = null;
    public static final LiveWrappedStreamIndex STREAM_INDEX_5TH = null;
    public static final LiveWrappedStreamIndex STREAM_INDEX_6TH = null;
    public static final LiveWrappedStreamIndex STREAM_INDEX_7TH = null;
    public static final LiveWrappedStreamIndex STREAM_INDEX_MAIN = null;
    public static final LiveWrappedStreamIndex STREAM_INDEX_MAX = null;
    public static final LiveWrappedStreamIndex STREAM_INDEX_SCREEN = null;
    public static final /* synthetic */ LiveWrappedStreamIndex[] a = null;
    private int value;

    public static LiveWrappedStreamIndex valueOf(String r1) {
        return (LiveWrappedStreamIndex) r27.a.a(LiveWrappedStreamIndex.class, r1);
    }

    public static LiveWrappedStreamIndex[] values() {
        return (LiveWrappedStreamIndex[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex$a] */
    static {
        LiveWrappedStreamIndex r1 = new LiveWrappedStreamIndex("STREAM_INDEX_MAIN", 0, 0);
        STREAM_INDEX_MAIN = r1;
        LiveWrappedStreamIndex r2 = new LiveWrappedStreamIndex("STREAM_INDEX_SCREEN", 1, 1);
        STREAM_INDEX_SCREEN = r2;
        LiveWrappedStreamIndex r3 = new LiveWrappedStreamIndex("STREAM_INDEX_3RD", 2, 2);
        STREAM_INDEX_3RD = r3;
        LiveWrappedStreamIndex r4 = new LiveWrappedStreamIndex("STREAM_INDEX_4TH", 3, 3);
        STREAM_INDEX_4TH = r4;
        LiveWrappedStreamIndex r5 = new LiveWrappedStreamIndex("STREAM_INDEX_5TH", 4, 4);
        STREAM_INDEX_5TH = r5;
        LiveWrappedStreamIndex r6 = new LiveWrappedStreamIndex("STREAM_INDEX_6TH", 5, 5);
        STREAM_INDEX_6TH = r6;
        LiveWrappedStreamIndex r7 = new LiveWrappedStreamIndex("STREAM_INDEX_7TH", 6, 6);
        STREAM_INDEX_7TH = r7;
        LiveWrappedStreamIndex r8 = new LiveWrappedStreamIndex("STREAM_INDEX_MAX", 7, 7);
        STREAM_INDEX_MAX = r8;
        a = new LiveWrappedStreamIndex[]{r1, r2, r3, r4, r5, r6, r7, r8};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(n0.a[ordinal()]) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return "valid";
    L6:
        return "kStreamIndex7th";
    L8:
        return "kStreamIndex6th";
    L10:
        return "kStreamIndex5th";
    L12:
        return "kStreamIndex4th";
    L14:
        return "kStreamIndex3rd";
    L16:
        return "kStreamIndexScreen";
    L18:
        return "kStreamIndexMain";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedStreamIndex(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
