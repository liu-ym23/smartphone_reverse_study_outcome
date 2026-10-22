package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/SetExTypeBeanResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "FAIL", "UNKNOWN", "NO_ACTION", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SetExTypeBeanResult extends Enum<SetExTypeBeanResult> {
    public static final a Companion = null;
    public static final SetExTypeBeanResult FAIL = null;
    public static final SetExTypeBeanResult NO_ACTION = null;
    public static final SetExTypeBeanResult SUCCESS = null;
    public static final SetExTypeBeanResult UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SetExTypeBeanResult[] f207112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207113b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SetExTypeBeanResult> getEntries() {
        return f207113b;
    }

    static {
        SetExTypeBeanResult r100 = new SetExTypeBeanResult("SUCCESS", 0, 2);
        SUCCESS = r100;
        SetExTypeBeanResult r101 = new SetExTypeBeanResult("FAIL", 1, 1);
        FAIL = r101;
        SetExTypeBeanResult r102 = new SetExTypeBeanResult("UNKNOWN", 2, 0);
        UNKNOWN = r102;
        SetExTypeBeanResult r103 = new SetExTypeBeanResult("NO_ACTION", 3, -1);
        NO_ACTION = r103;
        SetExTypeBeanResult[] r104 = {r100, r101, r102, r103};
        f207112a = r104;
        f207113b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static SetExTypeBeanResult[] values() {
        return (SetExTypeBeanResult[]) f207112a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final SetExTypeBeanResult from(int r100) {
        Companion.getClass();
        SetExTypeBeanResult r101 = SUCCESS;
        if (r100 == r101.getValue()) goto L13;
        SetExTypeBeanResult r102 = FAIL;
        if (r100 == r102.getValue()) goto L14;
        SetExTypeBeanResult r103 = NO_ACTION;
        if (r100 != r103.getValue()) goto L12;
        return r103;
    L12:
        return UNKNOWN;
    L14:
        return r102;
    L13:
        return r101;
    }

    public static SetExTypeBeanResult valueOf(String r100) {
        return (SetExTypeBeanResult) r27.a.a(SetExTypeBeanResult.class, r100);
    }

    public SetExTypeBeanResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
