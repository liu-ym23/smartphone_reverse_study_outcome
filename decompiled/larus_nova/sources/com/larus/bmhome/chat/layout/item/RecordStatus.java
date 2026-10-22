package com.larus.bmhome.chat.layout.item;

import com.byted.cast.common.bean.State;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/RecordStatus;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "AVAILABLE", State.RECORDING, "RECORD_FINISHED", "RecordInterruptedFinish", "OFFLINE_ASR_ING", "SUMMARY_READY", "RECORD_ERROR", "SUMMARY_GENERATE_ERROR", "UNAUTHORIZED_ERROR", "SecurityRiskControlError", "EarlyEndError", "OfflineASRError", "Connecting", "SUMMARY_GENERATING", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordStatus extends Enum<RecordStatus> {

    @Deprecated(message = "available 已废弃，默认的初始状态为 connecting")
    public static final RecordStatus AVAILABLE = null;
    public static final a Companion = null;
    public static final RecordStatus Connecting = null;
    public static final RecordStatus EarlyEndError = null;
    public static final RecordStatus OFFLINE_ASR_ING = null;
    public static final RecordStatus OfflineASRError = null;
    public static final RecordStatus RECORDING = null;
    public static final RecordStatus RECORD_ERROR = null;
    public static final RecordStatus RECORD_FINISHED = null;
    public static final RecordStatus RecordInterruptedFinish = null;
    public static final RecordStatus SUMMARY_GENERATE_ERROR = null;
    public static final RecordStatus SUMMARY_GENERATING = null;
    public static final RecordStatus SUMMARY_READY = null;
    public static final RecordStatus SecurityRiskControlError = null;
    public static final RecordStatus UNAUTHORIZED_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordStatus[] f304205a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f304206b = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static RecordStatus a(Integer r100) {
            RecordStatus[] r101 = RecordStatus.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            RecordStatus r104 = r101[r103];
            int r105 = r104.getType();
            if (r100 != null) goto L8;
        L10:
            boolean r106 = false;
        L11:
            if (r106 == true) goto L18;
            r103 = r103 + 1;
            goto L3
        L18:
            return r104;
        L8:
            if (r105 != r100.intValue()) goto L10;
            r106 = true;
            goto L11
        L14:
            return null;
        }
    }

    public static EnumEntries<RecordStatus> getEntries() {
        return f304206b;
    }

    static {
        RecordStatus r100 = new RecordStatus("AVAILABLE", 0, 1);
        AVAILABLE = r100;
        RecordStatus r101 = new RecordStatus(State.RECORDING, 1, 2);
        RECORDING = r101;
        RecordStatus r102 = new RecordStatus("RECORD_FINISHED", 2, 3);
        RECORD_FINISHED = r102;
        RecordStatus r103 = new RecordStatus("RecordInterruptedFinish", 3, 31);
        RecordInterruptedFinish = r103;
        RecordStatus r104 = new RecordStatus("OFFLINE_ASR_ING", 4, 4);
        OFFLINE_ASR_ING = r104;
        RecordStatus r105 = new RecordStatus("SUMMARY_READY", 5, 5);
        SUMMARY_READY = r105;
        RecordStatus r110 = new RecordStatus("RECORD_ERROR", 6, 100);
        RECORD_ERROR = r110;
        RecordStatus r111 = new RecordStatus("SUMMARY_GENERATE_ERROR", 7, 101);
        SUMMARY_GENERATE_ERROR = r111;
        RecordStatus r112 = new RecordStatus("UNAUTHORIZED_ERROR", 8, 102);
        UNAUTHORIZED_ERROR = r112;
        RecordStatus r113 = new RecordStatus("SecurityRiskControlError", 9, 103);
        SecurityRiskControlError = r113;
        RecordStatus r106 = new RecordStatus("EarlyEndError", 10, 104);
        EarlyEndError = r106;
        RecordStatus r107 = new RecordStatus("OfflineASRError", 11, 105);
        OfflineASRError = r107;
        RecordStatus r108 = new RecordStatus("Connecting", 12, 11);
        Connecting = r108;
        RecordStatus r114 = new RecordStatus("SUMMARY_GENERATING", 13, 41);
        SUMMARY_GENERATING = r114;
        RecordStatus[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r114};
        f304205a = r109;
        f304206b = EnumEntriesKt.enumEntries(r109);
        Companion = new a();
    }

    public static RecordStatus[] values() {
        return (RecordStatus[]) f304205a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static RecordStatus valueOf(String r100) {
        return (RecordStatus) r27.a.a(RecordStatus.class, r100);
    }

    public RecordStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
