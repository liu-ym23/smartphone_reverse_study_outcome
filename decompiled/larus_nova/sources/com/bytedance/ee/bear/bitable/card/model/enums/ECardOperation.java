package com.bytedance.ee.bear.bitable.card.model.enums;

import cu5.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum ECardOperation extends Enum<ECardOperation> {
    public static final ECardOperation ADD_LINKED_RECORD = null;
    public static final ECardOperation BACKWARD_LINK_TABLE = null;
    public static final ECardOperation CANCEL = null;
    public static final ECardOperation CLICK_TIP = null;
    public static final ECardOperation CONFIRM = null;
    public static final ECardOperation CONFIRM_FORM = null;
    public static final ECardOperation CONTINUE_SUBMIT = null;
    public static final ECardOperation CREATE_FORM_GRID_RECORD = null;
    public static final ECardOperation CREATE_GROUP = null;
    public static final ECardOperation DELETE_FORM_GRID_RECORD = null;
    public static final ECardOperation DELETE_RECORD = null;
    public static final ECardOperation EDIT_FORM_GRID_RECORD = null;
    public static final ECardOperation EDIT_RECORD = null;
    public static final ECardOperation EXIT = null;
    public static final ECardOperation EXIT_FORM_GRID_RECORD_EDIT = null;
    public static final ECardOperation FORWARD_LINK_TABLE = null;
    public static final ECardOperation OPEN = null;
    public static final ECardOperation OPEN_AI_POLISH = null;
    public static final ECardOperation OPEN_VOICE_INPUT = null;
    public static final ECardOperation SAVE_FORM_GRID_RECORD = null;
    public static final ECardOperation SUBMIT_RESULT = null;
    public static final ECardOperation SWITCH = null;
    public static final ECardOperation TOGGLE_HIDDEN_FIELDS_DISCLOSURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECardOperation[] f207085a = null;

    static {
        ECardOperation r100 = new ECardOperation("EDIT_RECORD", 0);
        EDIT_RECORD = r100;
        ECardOperation r101 = new ECardOperation("EDIT_FORM_GRID_RECORD", 1);
        EDIT_FORM_GRID_RECORD = r101;
        ECardOperation r102 = new ECardOperation("CREATE_FORM_GRID_RECORD", 2);
        CREATE_FORM_GRID_RECORD = r102;
        ECardOperation r103 = new ECardOperation("DELETE_FORM_GRID_RECORD", 3);
        DELETE_FORM_GRID_RECORD = r103;
        ECardOperation r104 = new ECardOperation("SAVE_FORM_GRID_RECORD", 4);
        SAVE_FORM_GRID_RECORD = r104;
        ECardOperation r105 = new ECardOperation("EXIT_FORM_GRID_RECORD_EDIT", 5);
        EXIT_FORM_GRID_RECORD_EDIT = r105;
        ECardOperation r110 = new ECardOperation("DELETE_RECORD", 6);
        DELETE_RECORD = r110;
        ECardOperation r111 = new ECardOperation("CREATE_GROUP", 7);
        CREATE_GROUP = r111;
        ECardOperation r112 = new ECardOperation("EXIT", 8);
        EXIT = r112;
        ECardOperation r113 = new ECardOperation("SWITCH", 9);
        SWITCH = r113;
        ECardOperation r114 = new ECardOperation("CONFIRM", 10);
        CONFIRM = r114;
        ECardOperation r115 = new ECardOperation("CONTINUE_SUBMIT", 11);
        CONTINUE_SUBMIT = r115;
        ECardOperation r106 = new ECardOperation("CANCEL", 12);
        CANCEL = r106;
        ECardOperation r107 = new ECardOperation("FORWARD_LINK_TABLE", 13);
        FORWARD_LINK_TABLE = r107;
        ECardOperation r108 = new ECardOperation("BACKWARD_LINK_TABLE", 14);
        BACKWARD_LINK_TABLE = r108;
        ECardOperation r109 = new ECardOperation("ADD_LINKED_RECORD", 15);
        ADD_LINKED_RECORD = r109;
        ECardOperation r116 = new ECardOperation("CONFIRM_FORM", 16);
        CONFIRM_FORM = r116;
        ECardOperation r117 = new ECardOperation("OPEN", 17);
        OPEN = r117;
        ECardOperation r118 = new ECardOperation("TOGGLE_HIDDEN_FIELDS_DISCLOSURE", 18);
        TOGGLE_HIDDEN_FIELDS_DISCLOSURE = r118;
        ECardOperation r119 = new ECardOperation("SUBMIT_RESULT", 19);
        SUBMIT_RESULT = r119;
        ECardOperation r120 = new ECardOperation("CLICK_TIP", 20);
        CLICK_TIP = r120;
        ECardOperation r121 = new ECardOperation("OPEN_AI_POLISH", 21);
        OPEN_AI_POLISH = r121;
        ECardOperation r122 = new ECardOperation("OPEN_VOICE_INPUT", 22);
        OPEN_VOICE_INPUT = r122;
        f207085a = new ECardOperation[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122};
    }

    public static ECardOperation[] values() {
        return (ECardOperation[]) f207085a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return a.a(name().toLowerCase());
    }

    public static ECardOperation valueOf(String r100) {
        return (ECardOperation) r27.a.a(ECardOperation.class, r100);
    }

    public ECardOperation(String r100, int r101) {
        super(r100, r101);
    }
}
