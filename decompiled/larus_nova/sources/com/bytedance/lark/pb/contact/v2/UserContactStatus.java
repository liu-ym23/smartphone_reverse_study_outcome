package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum UserContactStatus extends Enum<UserContactStatus> implements WireEnum {
    private static final /* synthetic */ UserContactStatus[] $VALUES = null;
    public static final ProtoAdapter<UserContactStatus> ADAPTER = null;
    public static final UserContactStatus CONTACT_POINT_FRIEND = null;
    public static final UserContactStatus CONTACT_STATUS_NOT_FRIEND = null;
    public static final UserContactStatus CONTACT_STATUS_RECEIVE = null;
    public static final UserContactStatus CONTACT_STATUS_REQUEST = null;
    public static final UserContactStatus CONTACT_STATUS_REQUEST_EXPIRED = null;
    private final int value;

    static {
        UserContactStatus r100 = new UserContactStatus("CONTACT_STATUS_NOT_FRIEND", 0, 0);
        CONTACT_STATUS_NOT_FRIEND = r100;
        UserContactStatus r101 = new UserContactStatus("CONTACT_POINT_FRIEND", 1, 1);
        CONTACT_POINT_FRIEND = r101;
        UserContactStatus r102 = new UserContactStatus("CONTACT_STATUS_REQUEST", 2, 2);
        CONTACT_STATUS_REQUEST = r102;
        UserContactStatus r103 = new UserContactStatus("CONTACT_STATUS_REQUEST_EXPIRED", 3, 3);
        CONTACT_STATUS_REQUEST_EXPIRED = r103;
        UserContactStatus r104 = new UserContactStatus("CONTACT_STATUS_RECEIVE", 4, 4);
        CONTACT_STATUS_RECEIVE = r104;
        $VALUES = new UserContactStatus[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserContactStatus.class);
    }

    public static UserContactStatus[] values() {
        return (UserContactStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserContactStatus fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return CONTACT_STATUS_RECEIVE;
    L16:
        return CONTACT_STATUS_REQUEST_EXPIRED;
    L18:
        return CONTACT_STATUS_REQUEST;
    L20:
        return CONTACT_POINT_FRIEND;
    L22:
        return CONTACT_STATUS_NOT_FRIEND;
    }

    public static UserContactStatus valueOf(String r100) {
        return (UserContactStatus) a.a(UserContactStatus.class, r100);
    }

    private UserContactStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
