package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandResultCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "FAIL", "UNKNOWN", "NO_ACTION", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FieldCommandResultCode extends Enum<FieldCommandResultCode> {
    public static final a Companion = null;
    public static final FieldCommandResultCode FAIL = null;
    public static final FieldCommandResultCode NO_ACTION = null;
    public static final FieldCommandResultCode SUCCESS = null;
    public static final FieldCommandResultCode UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FieldCommandResultCode[] f207108a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207109b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static FieldCommandResultCode a(int r100) {
            FieldCommandResultCode r101 = FieldCommandResultCode.SUCCESS;
            if (r100 == r101.getValue()) goto L13;
            FieldCommandResultCode r102 = FieldCommandResultCode.FAIL;
            if (r100 == r102.getValue()) goto L14;
            FieldCommandResultCode r103 = FieldCommandResultCode.NO_ACTION;
            if (r100 != r103.getValue()) goto L12;
            return r103;
        L12:
            return FieldCommandResultCode.UNKNOWN;
        L14:
            return r102;
        L13:
            return r101;
        }
    }

    @JvmStatic
    public static final FieldCommandResultCode from(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<FieldCommandResultCode> getEntries() {
        return f207109b;
    }

    static {
        FieldCommandResultCode r100 = new FieldCommandResultCode("SUCCESS", 0, 2);
        SUCCESS = r100;
        FieldCommandResultCode r101 = new FieldCommandResultCode("FAIL", 1, 1);
        FAIL = r101;
        FieldCommandResultCode r102 = new FieldCommandResultCode("UNKNOWN", 2, 0);
        UNKNOWN = r102;
        FieldCommandResultCode r103 = new FieldCommandResultCode("NO_ACTION", 3, -1);
        NO_ACTION = r103;
        FieldCommandResultCode[] r104 = {r100, r101, r102, r103};
        f207108a = r104;
        f207109b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static FieldCommandResultCode[] values() {
        return (FieldCommandResultCode[]) f207108a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FieldCommandResultCode valueOf(String r100) {
        return (FieldCommandResultCode) r27.a.a(FieldCommandResultCode.class, r100);
    }

    public FieldCommandResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
