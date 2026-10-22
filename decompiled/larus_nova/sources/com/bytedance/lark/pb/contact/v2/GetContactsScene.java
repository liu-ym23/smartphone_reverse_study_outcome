package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum GetContactsScene extends Enum<GetContactsScene> implements WireEnum {
    private static final /* synthetic */ GetContactsScene[] $VALUES = null;
    public static final ProtoAdapter<GetContactsScene> ADAPTER = null;
    public static final GetContactsScene GET_CONTACTS_SCENE_FULL_COLD = null;
    public static final GetContactsScene GET_CONTACTS_SCENE_FULL_LONG = null;
    public static final GetContactsScene GET_CONTACTS_SCENE_INCR_PUSH = null;
    public static final GetContactsScene GET_CONTACTS_SCENE_INCR_SHORT = null;
    public static final GetContactsScene GET_CONTACTS_SCENE_UNKNOWN = null;
    private final int value;

    static {
        GetContactsScene r100 = new GetContactsScene("GET_CONTACTS_SCENE_UNKNOWN", 0, 0);
        GET_CONTACTS_SCENE_UNKNOWN = r100;
        GetContactsScene r101 = new GetContactsScene("GET_CONTACTS_SCENE_INCR_PUSH", 1, 1);
        GET_CONTACTS_SCENE_INCR_PUSH = r101;
        GetContactsScene r102 = new GetContactsScene("GET_CONTACTS_SCENE_INCR_SHORT", 2, 2);
        GET_CONTACTS_SCENE_INCR_SHORT = r102;
        GetContactsScene r103 = new GetContactsScene("GET_CONTACTS_SCENE_FULL_LONG", 3, 3);
        GET_CONTACTS_SCENE_FULL_LONG = r103;
        GetContactsScene r104 = new GetContactsScene("GET_CONTACTS_SCENE_FULL_COLD", 4, 4);
        GET_CONTACTS_SCENE_FULL_COLD = r104;
        $VALUES = new GetContactsScene[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(GetContactsScene.class);
    }

    public static GetContactsScene[] values() {
        return (GetContactsScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static GetContactsScene fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return GET_CONTACTS_SCENE_FULL_COLD;
    L16:
        return GET_CONTACTS_SCENE_FULL_LONG;
    L18:
        return GET_CONTACTS_SCENE_INCR_SHORT;
    L20:
        return GET_CONTACTS_SCENE_INCR_PUSH;
    L22:
        return GET_CONTACTS_SCENE_UNKNOWN;
    }

    public static GetContactsScene valueOf(String r100) {
        return (GetContactsScene) a.a(GetContactsScene.class, r100);
    }

    private GetContactsScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
