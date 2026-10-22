package com.bytedance.ee.space.sync;

import com.bytedance.crash.dumper.Scraps;
import com.obric.miniapp.alarm.AlarmSessionType;
import faceverify.q;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/space/sync/PushRoute$EType;", "", "data", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", q.KEY_TOKEN, "ID", "UNIT", AlarmSessionType.EVENT, "Companion", "contentmanager-space-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PushRoute$EType extends Enum<PushRoute$EType> {
    public static final a Companion = null;
    public static final PushRoute$EType EVENT = null;
    public static final PushRoute$EType ID = null;
    public static final String KEY_NAME = "route_type";
    public static final PushRoute$EType TOKEN = null;
    public static final PushRoute$EType UNIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PushRoute$EType[] f243072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243073b = null;
    private final String data;

    public static EnumEntries<PushRoute$EType> getEntries() {
        return f243073b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.space.sync.PushRoute$EType$a] */
    static {
        PushRoute$EType r100 = new PushRoute$EType(q.KEY_TOKEN, 0, "token");
        TOKEN = r100;
        PushRoute$EType r101 = new PushRoute$EType("ID", 1, "id");
        ID = r101;
        PushRoute$EType r102 = new PushRoute$EType("UNIT", 2, Scraps.INNER_UNIT);
        UNIT = r102;
        PushRoute$EType r103 = new PushRoute$EType(AlarmSessionType.EVENT, 3, "DRIVE_THIRD_EVENT");
        EVENT = r103;
        PushRoute$EType[] r104 = {r100, r101, r102, r103};
        f243072a = r104;
        f243073b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static PushRoute$EType[] values() {
        return (PushRoute$EType[]) f243072a.clone();
    }

    public final String getData() {
        return this.data;
    }

    public static PushRoute$EType valueOf(String r100) {
        return (PushRoute$EType) r27.a.a(PushRoute$EType.class, r100);
    }

    public PushRoute$EType(String r100, int r101, String r102) {
        super(r100, r101);
        this.data = r102;
    }
}
