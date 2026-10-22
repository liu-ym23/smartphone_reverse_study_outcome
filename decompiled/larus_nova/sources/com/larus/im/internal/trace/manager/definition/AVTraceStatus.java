package com.larus.im.internal.trace.manager.definition;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/trace/manager/definition/AVTraceStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Success", CheckStatus.FAIL, "Interrupt", "Session_End", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AVTraceStatus extends Enum<AVTraceStatus> {
    public static final AVTraceStatus Fail = null;
    public static final AVTraceStatus Interrupt = null;
    public static final AVTraceStatus Session_End = null;
    public static final AVTraceStatus Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AVTraceStatus[] f350155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350156b = null;
    private final int value;

    public static EnumEntries<AVTraceStatus> getEntries() {
        return f350156b;
    }

    static {
        AVTraceStatus r100 = new AVTraceStatus("Success", 0, 0);
        Success = r100;
        AVTraceStatus r101 = new AVTraceStatus(CheckStatus.FAIL, 1, 1);
        Fail = r101;
        AVTraceStatus r102 = new AVTraceStatus("Interrupt", 2, 2);
        Interrupt = r102;
        AVTraceStatus r103 = new AVTraceStatus("Session_End", 3, 3);
        Session_End = r103;
        AVTraceStatus[] r104 = {r100, r101, r102, r103};
        f350155a = r104;
        f350156b = EnumEntriesKt.enumEntries(r104);
    }

    public static AVTraceStatus[] values() {
        return (AVTraceStatus[]) f350155a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AVTraceStatus valueOf(String r100) {
        return (AVTraceStatus) a.a(AVTraceStatus.class, r100);
    }

    public AVTraceStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
