package com.ss.android.lark.pb.compliance;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum SourceTerminal extends Enum<SourceTerminal> implements WireEnum {
    private static final /* synthetic */ SourceTerminal[] $VALUES = null;
    public static final ProtoAdapter<SourceTerminal> ADAPTER = null;
    public static final SourceTerminal Browser = null;
    public static final SourceTerminal Mobile = null;
    public static final SourceTerminal PC = null;
    public static final SourceTerminal UNKNOWN = null;
    private final int value;

    static {
        SourceTerminal r100 = new SourceTerminal("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        SourceTerminal r101 = new SourceTerminal("Browser", 1, 1);
        Browser = r101;
        SourceTerminal r102 = new SourceTerminal("PC", 2, 2);
        PC = r102;
        SourceTerminal r103 = new SourceTerminal("Mobile", 3, 3);
        Mobile = r103;
        $VALUES = new SourceTerminal[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(SourceTerminal.class);
    }

    public static SourceTerminal[] values() {
        return (SourceTerminal[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SourceTerminal fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return Mobile;
    L14:
        return PC;
    L16:
        return Browser;
    L18:
        return UNKNOWN;
    }

    public static SourceTerminal valueOf(String r100) {
        return (SourceTerminal) a.a(SourceTerminal.class, r100);
    }

    private SourceTerminal(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
