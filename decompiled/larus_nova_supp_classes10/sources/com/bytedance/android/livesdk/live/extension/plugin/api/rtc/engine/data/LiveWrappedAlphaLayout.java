package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAlphaLayout;", "", "", "value", "", "toString", "I", "Companion", "a", "TOP", "BOTTOM", "LEFT", "RIGHT", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAlphaLayout extends Enum<LiveWrappedAlphaLayout> {
    public static final LiveWrappedAlphaLayout BOTTOM = null;
    public static final a Companion = null;
    public static final LiveWrappedAlphaLayout LEFT = null;
    public static final LiveWrappedAlphaLayout RIGHT = null;
    public static final LiveWrappedAlphaLayout TOP = null;
    public static final /* synthetic */ LiveWrappedAlphaLayout[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAlphaLayout$a] */
    static {
        LiveWrappedAlphaLayout r1 = new LiveWrappedAlphaLayout("TOP", 0, 0);
        TOP = r1;
        LiveWrappedAlphaLayout r2 = new LiveWrappedAlphaLayout("BOTTOM", 1, 1);
        BOTTOM = r2;
        LiveWrappedAlphaLayout r3 = new LiveWrappedAlphaLayout("LEFT", 2, 2);
        LEFT = r3;
        LiveWrappedAlphaLayout r4 = new LiveWrappedAlphaLayout("RIGHT", 3, 3);
        RIGHT = r4;
        a = new LiveWrappedAlphaLayout[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedAlphaLayout valueOf(String r1) {
        return (LiveWrappedAlphaLayout) r27.a.a(LiveWrappedAlphaLayout.class, r1);
    }

    public static LiveWrappedAlphaLayout[] values() {
        return (LiveWrappedAlphaLayout[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = zf2.a.a[ordinal()];
        if (r0 != 1) goto L5;
        return "TOP";
    L5:
        if (r0 != 2) goto L7;
        return "BOTTOM";
    L7:
        if (r0 != 3) goto L9;
        return "LEFT";
    L9:
        if (r0 == 4) goto L11;
        return "";
    L11:
        return "RIGHT";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedAlphaLayout(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
