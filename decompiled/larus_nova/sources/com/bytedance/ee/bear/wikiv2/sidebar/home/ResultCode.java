package com.bytedance.ee.bear.wikiv2.sidebar.home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/home/ResultCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DECO", "DEC1", "DEC2", "isDEC0", "", "isDEC1", "isDEC2", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultCode extends Enum<ResultCode> {
    public static final ResultCode DEC1 = null;
    public static final ResultCode DEC2 = null;
    public static final ResultCode DECO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultCode[] f241224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f241225b = null;
    private final int value;

    public static EnumEntries<ResultCode> getEntries() {
        return f241225b;
    }

    static {
        ResultCode r100 = new ResultCode("DECO", 0, 0);
        DECO = r100;
        ResultCode r101 = new ResultCode("DEC1", 1, 1);
        DEC1 = r101;
        ResultCode r102 = new ResultCode("DEC2", 2, 2);
        DEC2 = r102;
        ResultCode[] r103 = {r100, r101, r102};
        f241224a = r103;
        f241225b = EnumEntriesKt.enumEntries(r103);
    }

    public static ResultCode[] values() {
        return (ResultCode[]) f241224a.clone();
    }

    public final boolean isDEC0() {
        if (this.value != DECO.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDEC1() {
        if (this.value != DEC1.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDEC2() {
        if (this.value != DEC2.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public static ResultCode valueOf(String r100) {
        return (ResultCode) a.a(ResultCode.class, r100);
    }

    public ResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
