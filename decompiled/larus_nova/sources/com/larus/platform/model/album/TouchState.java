package com.larus.platform.model.album;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/album/TouchState;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ACTION_DOWN", "ACTION_MOVE_CONSUMED", "ACTION_UP", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TouchState extends Enum<TouchState> {
    public static final TouchState ACTION_DOWN = null;
    public static final TouchState ACTION_MOVE_CONSUMED = null;
    public static final TouchState ACTION_UP = null;
    public static final TouchState DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TouchState[] f365549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365550b = null;

    public static EnumEntries<TouchState> getEntries() {
        return f365550b;
    }

    static {
        TouchState r100 = new TouchState("DEFAULT", 0);
        DEFAULT = r100;
        TouchState r101 = new TouchState("ACTION_DOWN", 1);
        ACTION_DOWN = r101;
        TouchState r102 = new TouchState("ACTION_MOVE_CONSUMED", 2);
        ACTION_MOVE_CONSUMED = r102;
        TouchState r103 = new TouchState("ACTION_UP", 3);
        ACTION_UP = r103;
        TouchState[] r104 = {r100, r101, r102, r103};
        f365549a = r104;
        f365550b = EnumEntriesKt.enumEntries(r104);
    }

    public static TouchState[] values() {
        return (TouchState[]) f365549a.clone();
    }

    public static TouchState valueOf(String r100) {
        return (TouchState) a.a(TouchState.class, r100);
    }

    public TouchState(String r100, int r101) {
        super(r100, r101);
    }
}
