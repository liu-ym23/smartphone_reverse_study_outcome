package com.bytedance.kmp.network.util;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class NLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Level f252570a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/kmp/network/util/NLog$Level;", "", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", UserProfileEvent.POSITION_NONE, "network_service_release"}, k = 1, mv = {1, 7, 0})
    public static final enum Level extends Enum<Level> {
        public static final Level DEBUG = null;
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final Level NONE = null;
        public static final Level VERBOSE = null;
        public static final Level WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f252571a = null;

        public static Level valueOf(String r100) {
            return (Level) a.a(Level.class, r100);
        }

        public static Level[] values() {
            return (Level[]) f252571a.clone();
        }

        static {
            Level r100 = new Level("VERBOSE", 0);
            VERBOSE = r100;
            Level r101 = new Level("DEBUG", 1);
            DEBUG = r101;
            Level r102 = new Level("INFO", 2);
            INFO = r102;
            Level r103 = new Level("WARN", 3);
            WARN = r103;
            Level r104 = new Level("ERROR", 4);
            ERROR = r104;
            Level r105 = new Level(UserProfileEvent.POSITION_NONE, 5);
            NONE = r105;
            f252571a = new Level[]{r100, r101, r102, r103, r104, r105};
        }

        public Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f252570a = Level.INFO;
    }
}
