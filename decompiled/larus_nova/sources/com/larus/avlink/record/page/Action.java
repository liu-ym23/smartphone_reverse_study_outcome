package com.larus.avlink.record.page;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/record/page/Action;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_PULL", "RETRY_PULL", "REFRESH_PULL", "START_PULL", "END_PULL", "DELETE", "UPLOAD_PROGRESS", "SYNC_COMPLETED", "ERROR", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Action extends Enum<Action> {
    public static final Action DELETE = null;
    public static final Action END_PULL = null;
    public static final Action ERROR = null;
    public static final Action INITIAL_PULL = null;
    public static final Action REFRESH_PULL = null;
    public static final Action RETRY_PULL = null;
    public static final Action START_PULL = null;
    public static final Action SYNC_COMPLETED = null;
    public static final Action UNKNOWN = null;
    public static final Action UPLOAD_PROGRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Action[] f294142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294143b = null;

    public static EnumEntries<Action> getEntries() {
        return f294143b;
    }

    static {
        Action r100 = new Action("INITIAL_PULL", 0);
        INITIAL_PULL = r100;
        Action r101 = new Action("RETRY_PULL", 1);
        RETRY_PULL = r101;
        Action r102 = new Action("REFRESH_PULL", 2);
        REFRESH_PULL = r102;
        Action r103 = new Action("START_PULL", 3);
        START_PULL = r103;
        Action r104 = new Action("END_PULL", 4);
        END_PULL = r104;
        Action r105 = new Action("DELETE", 5);
        DELETE = r105;
        Action r110 = new Action("UPLOAD_PROGRESS", 6);
        UPLOAD_PROGRESS = r110;
        Action r111 = new Action("SYNC_COMPLETED", 7);
        SYNC_COMPLETED = r111;
        Action r112 = new Action("ERROR", 8);
        ERROR = r112;
        Action r113 = new Action("UNKNOWN", 9);
        UNKNOWN = r113;
        Action[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f294142a = r114;
        f294143b = EnumEntriesKt.enumEntries(r114);
    }

    public static Action[] values() {
        return (Action[]) f294142a.clone();
    }

    public static Action valueOf(String r100) {
        return (Action) r27.a.a(Action.class, r100);
    }

    public Action(String r100, int r101) {
        super(r100, r101);
    }
}
