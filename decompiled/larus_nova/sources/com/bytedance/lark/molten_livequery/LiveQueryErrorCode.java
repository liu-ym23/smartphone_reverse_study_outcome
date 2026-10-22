package com.bytedance.lark.molten_livequery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/molten_livequery/LiveQueryErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "UnknownError", "SnapshotError", "DiffsError", "BuilderError", "CallbackError", "Companion", "molten_livequery_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LiveQueryErrorCode extends Enum<LiveQueryErrorCode> {
    public static final LiveQueryErrorCode BuilderError = null;
    public static final LiveQueryErrorCode CallbackError = null;
    public static final a Companion = null;
    public static final LiveQueryErrorCode DiffsError = null;
    public static final LiveQueryErrorCode SnapshotError = null;
    public static final LiveQueryErrorCode UnknownError = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveQueryErrorCode[] f253318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253319b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<LiveQueryErrorCode> getEntries() {
        return f253319b;
    }

    static {
        LiveQueryErrorCode r100 = new LiveQueryErrorCode("UnknownError", 0);
        UnknownError = r100;
        LiveQueryErrorCode r101 = new LiveQueryErrorCode("SnapshotError", 1);
        SnapshotError = r101;
        LiveQueryErrorCode r102 = new LiveQueryErrorCode("DiffsError", 2);
        DiffsError = r102;
        LiveQueryErrorCode r103 = new LiveQueryErrorCode("BuilderError", 3);
        BuilderError = r103;
        LiveQueryErrorCode r104 = new LiveQueryErrorCode("CallbackError", 4);
        CallbackError = r104;
        LiveQueryErrorCode[] r105 = {r100, r101, r102, r103, r104};
        f253318a = r105;
        f253319b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static LiveQueryErrorCode[] values() {
        return (LiveQueryErrorCode[]) f253318a.clone();
    }

    public static LiveQueryErrorCode valueOf(String r100) {
        return (LiveQueryErrorCode) r27.a.a(LiveQueryErrorCode.class, r100);
    }

    public LiveQueryErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
