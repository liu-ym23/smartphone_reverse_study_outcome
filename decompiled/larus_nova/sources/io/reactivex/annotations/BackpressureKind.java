package io.reactivex.annotations;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum BackpressureKind extends Enum<BackpressureKind> {
    private static final /* synthetic */ BackpressureKind[] $VALUES = null;
    public static final BackpressureKind ERROR = null;
    public static final BackpressureKind FULL = null;
    public static final BackpressureKind NONE = null;
    public static final BackpressureKind PASS_THROUGH = null;
    public static final BackpressureKind SPECIAL = null;
    public static final BackpressureKind UNBOUNDED_IN = null;

    static {
        BackpressureKind r100 = new BackpressureKind("PASS_THROUGH", 0);
        PASS_THROUGH = r100;
        BackpressureKind r101 = new BackpressureKind("FULL", 1);
        FULL = r101;
        BackpressureKind r102 = new BackpressureKind("SPECIAL", 2);
        SPECIAL = r102;
        BackpressureKind r103 = new BackpressureKind("UNBOUNDED_IN", 3);
        UNBOUNDED_IN = r103;
        BackpressureKind r104 = new BackpressureKind("ERROR", 4);
        ERROR = r104;
        BackpressureKind r105 = new BackpressureKind(UserProfileEvent.POSITION_NONE, 5);
        NONE = r105;
        $VALUES = new BackpressureKind[]{r100, r101, r102, r103, r104, r105};
    }

    public static BackpressureKind[] values() {
        return (BackpressureKind[]) $VALUES.clone();
    }

    public static BackpressureKind valueOf(String r100) {
        return (BackpressureKind) a.a(BackpressureKind.class, r100);
    }

    private BackpressureKind(String r100, int r101) {
        super(r100, r101);
    }
}
