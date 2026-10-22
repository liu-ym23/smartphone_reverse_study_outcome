package com.bytedance.speech.speechengine.log_tracker;

import com.bytedance.speech.speechengine.SpeechEngineLoader;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public class SpeechLogTracker {

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f270332a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f270333b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f270334c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f270335d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f270336e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ b[] f270337f = null;

        static {
            b r100 = new b("TRACKER_LOG_LEVEL_TRACE", 0);
            f270332a = r100;
            b r101 = new b("TRACKER_LOG_LEVEL_DEBUG", 1);
            f270333b = r101;
            b r102 = new b("TRACKER_LOG_LEVEL_INFO", 2);
            f270334c = r102;
            b r103 = new b("TRACKER_LOG_LEVEL_WARN", 3);
            f270335d = r103;
            b r104 = new b("TRACKER_LOG_LEVEL_ERROR", 4);
            f270336e = r104;
            f270337f = new b[]{r100, r101, r102, r103, r104};
        }

        public static b[] values() {
            return (b[]) f270337f.clone();
        }

        public static b valueOf(String r100) {
            return (b) a.a(b.class, r100);
        }

        public b(String r100, int r101) {
            super(r100, r101);
        }
    }

    private native long getInstanceToNative(String r100, String r101, String r102, String r103);

    private native void writeLogToNative(long r100, long r101, String r102, String r103);

    static {
        new SpeechLogTracker();
        SpeechEngineLoader.getInstance().load();
    }

    public SpeechLogTracker() {
    }
}
