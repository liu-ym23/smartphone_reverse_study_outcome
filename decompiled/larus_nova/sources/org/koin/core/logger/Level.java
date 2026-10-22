package org.koin.core.logger;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lorg/koin/core/logger/Level;", "", "DEBUG", "INFO", "ERROR", UserProfileEvent.POSITION_NONE, "koin-core"}, k = 1, mv = {1, 5, 1})
public final enum Level extends Enum<Level> {
    public static final Level DEBUG = null;
    public static final Level ERROR = null;
    public static final Level INFO = null;
    public static final Level NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Level[] f526143a = null;

    static {
        Level r100 = new Level("DEBUG", 0);
        DEBUG = r100;
        Level r101 = new Level("INFO", 1);
        INFO = r101;
        Level r102 = new Level("ERROR", 2);
        ERROR = r102;
        Level r103 = new Level(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        f526143a = new Level[]{r100, r101, r102, r103};
    }

    public static Level[] values() {
        return (Level[]) Arrays.copyOf(f526143a, 4);
    }

    public static Level valueOf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return (Level) a.a(Level.class, r100);
    }

    public Level(String r100, int r101) {
        super(r100, r101);
    }
}
