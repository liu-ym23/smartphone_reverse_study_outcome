package com.ss.android.lark.pb.office_ai;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum QuickActionType extends Enum<QuickActionType> implements WireEnum {
    private static final /* synthetic */ QuickActionType[] $VALUES = null;
    public static final ProtoAdapter<QuickActionType> ADAPTER = null;
    public static final QuickActionType API = null;
    public static final QuickActionType EXTERNAL_LINK = null;
    public static final QuickActionType PROMPT_TASK = null;
    public static final QuickActionType QUERY = null;
    private final int value;

    static {
        QuickActionType r100 = new QuickActionType("PROMPT_TASK", 0, 0);
        PROMPT_TASK = r100;
        QuickActionType r101 = new QuickActionType("API", 1, 1);
        API = r101;
        QuickActionType r102 = new QuickActionType(ConfirmNextAction.ACTION_TYPE_QUERY, 2, 2);
        QUERY = r102;
        QuickActionType r103 = new QuickActionType("EXTERNAL_LINK", 3, 3);
        EXTERNAL_LINK = r103;
        $VALUES = new QuickActionType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(QuickActionType.class);
    }

    public static QuickActionType[] values() {
        return (QuickActionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static QuickActionType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return EXTERNAL_LINK;
    L14:
        return QUERY;
    L16:
        return API;
    L18:
        return PROMPT_TASK;
    }

    public static QuickActionType valueOf(String r100) {
        return (QuickActionType) a.a(QuickActionType.class, r100);
    }

    private QuickActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
