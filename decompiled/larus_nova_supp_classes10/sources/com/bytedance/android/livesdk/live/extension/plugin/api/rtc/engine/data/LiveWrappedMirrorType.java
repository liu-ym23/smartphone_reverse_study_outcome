package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedMirrorType;", "", "", "value", "", "toString", "I", "Companion", "a", "MIRROR_TYPE_NONE", "MIRROR_TYPE_RENDER", "MIRROR_TYPE_RENDER_AND_ENCODER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMirrorType extends Enum<LiveWrappedMirrorType> {
    public static final a Companion = null;
    public static final LiveWrappedMirrorType MIRROR_TYPE_NONE = null;
    public static final LiveWrappedMirrorType MIRROR_TYPE_RENDER = null;
    public static final LiveWrappedMirrorType MIRROR_TYPE_RENDER_AND_ENCODER = null;
    public static final /* synthetic */ LiveWrappedMirrorType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedMirrorType$a] */
    static {
        LiveWrappedMirrorType r2 = new LiveWrappedMirrorType("MIRROR_TYPE_NONE", 0, 0);
        MIRROR_TYPE_NONE = r2;
        LiveWrappedMirrorType r3 = new LiveWrappedMirrorType("MIRROR_TYPE_RENDER", 1, 1);
        MIRROR_TYPE_RENDER = r3;
        LiveWrappedMirrorType r4 = new LiveWrappedMirrorType("MIRROR_TYPE_RENDER_AND_ENCODER", 2, 3);
        MIRROR_TYPE_RENDER_AND_ENCODER = r4;
        a = new LiveWrappedMirrorType[]{r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedMirrorType valueOf(String r1) {
        return (LiveWrappedMirrorType) r27.a.a(LiveWrappedMirrorType.class, r1);
    }

    public static LiveWrappedMirrorType[] values() {
        return (LiveWrappedMirrorType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != MIRROR_TYPE_NONE) goto L7;
        return "kMirrorTypeNone";
    L7:
        if (this != MIRROR_TYPE_RENDER) goto L11;
        return "kMirrorTypeRender";
    L11:
        if (this != MIRROR_TYPE_RENDER_AND_ENCODER) goto L14;
        return "kMirrorTypeRenderAndEncoder";
    L14:
        return "";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedMirrorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
