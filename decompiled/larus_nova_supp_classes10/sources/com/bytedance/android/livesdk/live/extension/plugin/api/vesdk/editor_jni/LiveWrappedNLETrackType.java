package com.bytedance.android.livesdk.live.extension.plugin.api.vesdk.editor_jni;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/vesdk/editor_jni/LiveWrappedNLETrackType;", "", "", "swigValue", "I", "a", "NONE", "AUDIO", "VIDEO", "STICKER", "EFFECT", "FILTER", "IMAGE", "MV", "EFFECT_STICKER", "IMAGE_TEMPLATE_EFFECT", "VIRTUAL", "LAYER_STICKER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedNLETrackType extends Enum<LiveWrappedNLETrackType> {
    public static final LiveWrappedNLETrackType AUDIO = null;
    public static final LiveWrappedNLETrackType EFFECT = null;
    public static final LiveWrappedNLETrackType EFFECT_STICKER = null;
    public static final LiveWrappedNLETrackType FILTER = null;
    public static final LiveWrappedNLETrackType IMAGE = null;
    public static final LiveWrappedNLETrackType IMAGE_TEMPLATE_EFFECT = null;
    public static final LiveWrappedNLETrackType LAYER_STICKER = null;
    public static final LiveWrappedNLETrackType MV = null;
    public static final LiveWrappedNLETrackType NONE = null;
    public static final LiveWrappedNLETrackType STICKER = null;
    public static final LiveWrappedNLETrackType VIDEO = null;
    public static final LiveWrappedNLETrackType VIRTUAL = null;
    public static final /* synthetic */ LiveWrappedNLETrackType[] a = null;
    private final int swigValue;

    public static final class a {
        public static int a;

        static {
        }
    }

    public static LiveWrappedNLETrackType valueOf(String r1) {
        return (LiveWrappedNLETrackType) r27.a.a(LiveWrappedNLETrackType.class, r1);
    }

    public static LiveWrappedNLETrackType[] values() {
        return (LiveWrappedNLETrackType[]) a.clone();
    }

    static {
        LiveWrappedNLETrackType r1 = new LiveWrappedNLETrackType("NONE", 0, 0);
        NONE = r1;
        LiveWrappedNLETrackType r2 = new LiveWrappedNLETrackType("AUDIO", 1, 1);
        AUDIO = r2;
        LiveWrappedNLETrackType r3 = new LiveWrappedNLETrackType("VIDEO", 2, 2);
        VIDEO = r3;
        LiveWrappedNLETrackType r4 = new LiveWrappedNLETrackType("STICKER", 3, 3);
        STICKER = r4;
        LiveWrappedNLETrackType r5 = new LiveWrappedNLETrackType("EFFECT", 4, 4);
        EFFECT = r5;
        LiveWrappedNLETrackType r6 = new LiveWrappedNLETrackType("FILTER", 5, 5);
        FILTER = r6;
        LiveWrappedNLETrackType r7 = new LiveWrappedNLETrackType("IMAGE", 6, 6);
        IMAGE = r7;
        LiveWrappedNLETrackType r8 = new LiveWrappedNLETrackType("MV", 7, 7);
        MV = r8;
        LiveWrappedNLETrackType r9 = new LiveWrappedNLETrackType("EFFECT_STICKER", 8, 8);
        EFFECT_STICKER = r9;
        LiveWrappedNLETrackType r10 = new LiveWrappedNLETrackType("IMAGE_TEMPLATE_EFFECT", 9, 9);
        IMAGE_TEMPLATE_EFFECT = r10;
        LiveWrappedNLETrackType r11 = new LiveWrappedNLETrackType("VIRTUAL", 10, 10);
        VIRTUAL = r11;
        LiveWrappedNLETrackType r12 = new LiveWrappedNLETrackType();
        LAYER_STICKER = r12;
        a = new LiveWrappedNLETrackType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12};
    }

    public LiveWrappedNLETrackType() {
        super("LAYER_STICKER", 11);
        int r0 = a.a;
        a.a = r0 + 1;
        this.swigValue = r0;
    }

    public LiveWrappedNLETrackType(String r1, int r2, int r3) {
        super(r1, r2);
        this.swigValue = r3;
        a.a = r3 + 1;
    }
}
