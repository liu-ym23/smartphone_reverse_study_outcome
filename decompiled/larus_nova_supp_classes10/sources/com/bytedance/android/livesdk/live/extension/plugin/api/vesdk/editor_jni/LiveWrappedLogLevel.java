package com.bytedance.android.livesdk.live.extension.plugin.api.vesdk.editor_jni;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/vesdk/editor_jni/LiveWrappedLogLevel;", "", "", "swigValue", "I", "a", "LEVEL_VERBOSE", "LEVEL_DEBUG", "LEVEL_INFO", "LEVEL_WARNING", "LEVEL_ERROR", "LEVEL_ASSERT", "LEVEL_OFF", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedLogLevel extends Enum<LiveWrappedLogLevel> {
    public static final LiveWrappedLogLevel LEVEL_ASSERT = null;
    public static final LiveWrappedLogLevel LEVEL_DEBUG = null;
    public static final LiveWrappedLogLevel LEVEL_ERROR = null;
    public static final LiveWrappedLogLevel LEVEL_INFO = null;
    public static final LiveWrappedLogLevel LEVEL_OFF = null;
    public static final LiveWrappedLogLevel LEVEL_VERBOSE = null;
    public static final LiveWrappedLogLevel LEVEL_WARNING = null;
    public static final /* synthetic */ LiveWrappedLogLevel[] a = null;
    private final int swigValue;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    static {
        LiveWrappedLogLevel r1 = new LiveWrappedLogLevel("LEVEL_VERBOSE", 0, 0);
        LEVEL_VERBOSE = r1;
        LiveWrappedLogLevel r2 = new LiveWrappedLogLevel("LEVEL_DEBUG", 1, 1);
        LEVEL_DEBUG = r2;
        LiveWrappedLogLevel r3 = new LiveWrappedLogLevel("LEVEL_INFO", 2, 2);
        LEVEL_INFO = r3;
        LiveWrappedLogLevel r4 = new LiveWrappedLogLevel("LEVEL_WARNING", 3, 3);
        LEVEL_WARNING = r4;
        LiveWrappedLogLevel r5 = new LiveWrappedLogLevel("LEVEL_ERROR", 4, 4);
        LEVEL_ERROR = r5;
        LiveWrappedLogLevel r6 = new LiveWrappedLogLevel("LEVEL_ASSERT", 5, 5);
        LEVEL_ASSERT = r6;
        LiveWrappedLogLevel r7 = new LiveWrappedLogLevel("LEVEL_OFF", 6, 6);
        LEVEL_OFF = r7;
        a = new LiveWrappedLogLevel[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static LiveWrappedLogLevel valueOf(String r1) {
        return (LiveWrappedLogLevel) r27.a.a(LiveWrappedLogLevel.class, r1);
    }

    public static LiveWrappedLogLevel[] values() {
        return (LiveWrappedLogLevel[]) a.clone();
    }

    public LiveWrappedLogLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.swigValue = r3;
        int r4 = a.a;
    }
}
