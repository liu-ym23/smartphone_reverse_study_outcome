package com.ss.android.lark.pb.department;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ContactDisplayModule extends Enum<ContactDisplayModule> implements WireEnum {
    private static final /* synthetic */ ContactDisplayModule[] $VALUES = null;
    public static final ProtoAdapter<ContactDisplayModule> ADAPTER = null;
    public static final ContactDisplayModule DISPLAY_MODULE_DEPARTMENT = null;
    public static final ContactDisplayModule DISPLAY_MODULE_DEPARTMENT_LEADER = null;
    public static final ContactDisplayModule DISPLAY_MODULE_USER = null;
    private final int value;

    static {
        ContactDisplayModule r100 = new ContactDisplayModule("DISPLAY_MODULE_DEPARTMENT_LEADER", 0, 1);
        DISPLAY_MODULE_DEPARTMENT_LEADER = r100;
        ContactDisplayModule r101 = new ContactDisplayModule("DISPLAY_MODULE_DEPARTMENT", 1, 2);
        DISPLAY_MODULE_DEPARTMENT = r101;
        ContactDisplayModule r102 = new ContactDisplayModule("DISPLAY_MODULE_USER", 2, 3);
        DISPLAY_MODULE_USER = r102;
        $VALUES = new ContactDisplayModule[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContactDisplayModule.class);
    }

    public static ContactDisplayModule[] values() {
        return (ContactDisplayModule[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ContactDisplayModule fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return DISPLAY_MODULE_USER;
    L13:
        return DISPLAY_MODULE_DEPARTMENT;
    L15:
        return DISPLAY_MODULE_DEPARTMENT_LEADER;
    }

    public static ContactDisplayModule valueOf(String r100) {
        return (ContactDisplayModule) a.a(ContactDisplayModule.class, r100);
    }

    private ContactDisplayModule(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
