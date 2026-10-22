package com.ss.android.lark.chat.cot;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/cot/CotBlockStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "RUNNING", "DONE", "ERROR", "VIOLATED", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotBlockStatus extends Enum<CotBlockStatus> {
    public static final CotBlockStatus DONE = null;
    public static final CotBlockStatus ERROR = null;
    public static final CotBlockStatus PENDING = null;
    public static final CotBlockStatus RUNNING = null;
    public static final CotBlockStatus VIOLATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CotBlockStatus[] f414782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f414783b = null;

    public static EnumEntries<CotBlockStatus> getEntries() {
        return f414783b;
    }

    static {
        CotBlockStatus r100 = new CotBlockStatus("PENDING", 0);
        PENDING = r100;
        CotBlockStatus r101 = new CotBlockStatus("RUNNING", 1);
        RUNNING = r101;
        CotBlockStatus r102 = new CotBlockStatus("DONE", 2);
        DONE = r102;
        CotBlockStatus r103 = new CotBlockStatus("ERROR", 3);
        ERROR = r103;
        CotBlockStatus r104 = new CotBlockStatus("VIOLATED", 4);
        VIOLATED = r104;
        CotBlockStatus[] r105 = {r100, r101, r102, r103, r104};
        f414782a = r105;
        f414783b = EnumEntriesKt.enumEntries(r105);
    }

    public static CotBlockStatus[] values() {
        return (CotBlockStatus[]) f414782a.clone();
    }

    public static CotBlockStatus valueOf(String r100) {
        return (CotBlockStatus) r27.a.a(CotBlockStatus.class, r100);
    }

    public CotBlockStatus(String r100, int r101) {
        super(r100, r101);
    }
}
