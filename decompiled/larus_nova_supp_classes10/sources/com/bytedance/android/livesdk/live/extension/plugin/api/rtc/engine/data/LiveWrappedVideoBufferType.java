package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoBufferType;", "", "", "value", "", "toString", "I", "Companion", "a", "RAW_MEMORY", "GL_TEXTURE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoBufferType extends Enum<LiveWrappedVideoBufferType> {
    public static final a Companion = null;
    public static final LiveWrappedVideoBufferType GL_TEXTURE = null;
    public static final LiveWrappedVideoBufferType RAW_MEMORY = null;
    public static final /* synthetic */ LiveWrappedVideoBufferType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoBufferType$a] */
    static {
        LiveWrappedVideoBufferType r2 = new LiveWrappedVideoBufferType("RAW_MEMORY", 0, 0);
        RAW_MEMORY = r2;
        LiveWrappedVideoBufferType r3 = new LiveWrappedVideoBufferType("GL_TEXTURE", 1, 2);
        GL_TEXTURE = r3;
        a = new LiveWrappedVideoBufferType[]{r2, r3};
        Companion = new a();
    }

    public static LiveWrappedVideoBufferType valueOf(String r1) {
        return (LiveWrappedVideoBufferType) r27.a.a(LiveWrappedVideoBufferType.class, r1);
    }

    public static LiveWrappedVideoBufferType[] values() {
        return (LiveWrappedVideoBufferType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != RAW_MEMORY) goto L5;
        return "kVideoBufferTypeRawMemory";
    L5:
        return "kVideoBufferTypeGLTexture";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoBufferType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
