package com.larus.extension.chat_extension.impl.ltm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/InsertBotRespStatus;", "", "status", "", "<init>", "(Ljava/lang/String;II)V", "getStatus", "()I", "StartInsert", "Success", "OutOfSizeLimit", "OutOfCntLimit", "ReviewNotPass", "RepeatedMemory", "FailInsert", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InsertBotRespStatus extends Enum<InsertBotRespStatus> {
    public static final a Companion = null;
    public static final InsertBotRespStatus FailInsert = null;
    public static final InsertBotRespStatus OutOfCntLimit = null;
    public static final InsertBotRespStatus OutOfSizeLimit = null;
    public static final InsertBotRespStatus RepeatedMemory = null;
    public static final InsertBotRespStatus ReviewNotPass = null;
    public static final InsertBotRespStatus StartInsert = null;
    public static final InsertBotRespStatus Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InsertBotRespStatus[] f342846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f342847b = null;
    private final int status;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<InsertBotRespStatus> getEntries() {
        return f342847b;
    }

    static {
        InsertBotRespStatus r100 = new InsertBotRespStatus("StartInsert", 0, 0);
        StartInsert = r100;
        InsertBotRespStatus r101 = new InsertBotRespStatus("Success", 1, 1);
        Success = r101;
        InsertBotRespStatus r102 = new InsertBotRespStatus("OutOfSizeLimit", 2, 2);
        OutOfSizeLimit = r102;
        InsertBotRespStatus r103 = new InsertBotRespStatus("OutOfCntLimit", 3, 3);
        OutOfCntLimit = r103;
        InsertBotRespStatus r104 = new InsertBotRespStatus("ReviewNotPass", 4, 4);
        ReviewNotPass = r104;
        InsertBotRespStatus r105 = new InsertBotRespStatus("RepeatedMemory", 5, 6);
        RepeatedMemory = r105;
        InsertBotRespStatus r110 = new InsertBotRespStatus("FailInsert", 6, -1);
        FailInsert = r110;
        InsertBotRespStatus[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f342846a = r111;
        f342847b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static InsertBotRespStatus[] values() {
        return (InsertBotRespStatus[]) f342846a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public static InsertBotRespStatus valueOf(String r100) {
        return (InsertBotRespStatus) r27.a.a(InsertBotRespStatus.class, r100);
    }

    public InsertBotRespStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
