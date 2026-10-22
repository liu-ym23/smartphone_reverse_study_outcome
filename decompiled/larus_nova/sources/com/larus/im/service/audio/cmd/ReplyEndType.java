package com.larus.im.service.audio.cmd;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/service/audio/cmd/ReplyEndType;", "", "<init>", "(Ljava/lang/String;I)V", "Generated", "Pushed", "NoReply", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyEndType extends Enum<ReplyEndType> {
    public static final ReplyEndType Generated = null;
    public static final ReplyEndType NoReply = null;
    public static final ReplyEndType Pushed = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyEndType[] f350719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350720b = null;

    public static EnumEntries<ReplyEndType> getEntries() {
        return f350720b;
    }

    static {
        ReplyEndType r100 = new ReplyEndType("Generated", 0);
        Generated = r100;
        ReplyEndType r101 = new ReplyEndType("Pushed", 1);
        Pushed = r101;
        ReplyEndType r102 = new ReplyEndType("NoReply", 2);
        NoReply = r102;
        ReplyEndType[] r103 = {r100, r101, r102};
        f350719a = r103;
        f350720b = EnumEntriesKt.enumEntries(r103);
    }

    public static ReplyEndType[] values() {
        return (ReplyEndType[]) f350719a.clone();
    }

    public static ReplyEndType valueOf(String r100) {
        return (ReplyEndType) a.a(ReplyEndType.class, r100);
    }

    public ReplyEndType(String r100, int r101) {
        super(r100, r101);
    }
}
