package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum IncompatibleLevel extends Enum<IncompatibleLevel> implements WireEnum {
    private static final /* synthetic */ IncompatibleLevel[] $VALUES = null;
    public static final ProtoAdapter<IncompatibleLevel> ADAPTER = null;
    public static final IncompatibleLevel DISABLE_EDIT = null;
    public static final IncompatibleLevel DISABLE_READ = null;
    public static final IncompatibleLevel SHOW_HINT = null;
    private final int value;

    static {
        IncompatibleLevel r100 = new IncompatibleLevel("SHOW_HINT", 0, 1);
        SHOW_HINT = r100;
        IncompatibleLevel r101 = new IncompatibleLevel("DISABLE_EDIT", 1, 2);
        DISABLE_EDIT = r101;
        IncompatibleLevel r102 = new IncompatibleLevel("DISABLE_READ", 2, 3);
        DISABLE_READ = r102;
        $VALUES = new IncompatibleLevel[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(IncompatibleLevel.class);
    }

    public static IncompatibleLevel[] values() {
        return (IncompatibleLevel[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static IncompatibleLevel fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return DISABLE_READ;
    L13:
        return DISABLE_EDIT;
    L15:
        return SHOW_HINT;
    }

    public static IncompatibleLevel valueOf(String r100) {
        return (IncompatibleLevel) a.a(IncompatibleLevel.class, r100);
    }

    private IncompatibleLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
