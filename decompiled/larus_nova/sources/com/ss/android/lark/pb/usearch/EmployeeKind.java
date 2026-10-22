package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum EmployeeKind extends Enum<EmployeeKind> implements WireEnum {
    private static final /* synthetic */ EmployeeKind[] $VALUES = null;
    public static final ProtoAdapter<EmployeeKind> ADAPTER = null;
    public static final EmployeeKind AGENT = null;
    public static final EmployeeKind HUMAN = null;
    private final int value;

    static {
        EmployeeKind r100 = new EmployeeKind("HUMAN", 0, 0);
        HUMAN = r100;
        EmployeeKind r101 = new EmployeeKind("AGENT", 1, 1);
        AGENT = r101;
        $VALUES = new EmployeeKind[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(EmployeeKind.class);
    }

    public static EmployeeKind[] values() {
        return (EmployeeKind[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EmployeeKind fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return AGENT;
    L10:
        return HUMAN;
    }

    public static EmployeeKind valueOf(String r100) {
        return (EmployeeKind) a.a(EmployeeKind.class, r100);
    }

    private EmployeeKind(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
