package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CreateScene extends Enum<CreateScene> implements WireEnum {
    private static final /* synthetic */ CreateScene[] $VALUES = null;
    public static final ProtoAdapter<CreateScene> ADAPTER = null;
    public static final CreateScene COMMON_SHARE = null;
    public static final CreateScene NORMAL = null;
    public static final CreateScene SHARE_CALENDAR_EVENT = null;
    public static final CreateScene SHARE_DOC = null;
    public static final CreateScene SHARE_GROUP_CHAT = null;
    public static final CreateScene SHARE_MINUTES = null;
    public static final CreateScene SHARE_QR_CODE = null;
    public static final CreateScene SHARE_STICKER = null;
    public static final CreateScene SHARE_SUBSCRIPTION = null;
    public static final CreateScene SHARE_TODO = null;
    private final int value;

    static {
        CreateScene r100 = new CreateScene(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        CreateScene r101 = new CreateScene("SHARE_GROUP_CHAT", 1, 1);
        SHARE_GROUP_CHAT = r101;
        CreateScene r102 = new CreateScene("SHARE_CALENDAR_EVENT", 2, 2);
        SHARE_CALENDAR_EVENT = r102;
        CreateScene r103 = new CreateScene("SHARE_DOC", 3, 3);
        SHARE_DOC = r103;
        CreateScene r104 = new CreateScene("SHARE_TODO", 4, 4);
        SHARE_TODO = r104;
        CreateScene r105 = new CreateScene("SHARE_MINUTES", 5, 5);
        SHARE_MINUTES = r105;
        CreateScene r110 = new CreateScene("SHARE_QR_CODE", 6, 6);
        SHARE_QR_CODE = r110;
        CreateScene r111 = new CreateScene("SHARE_SUBSCRIPTION", 7, 7);
        SHARE_SUBSCRIPTION = r111;
        CreateScene r112 = new CreateScene("SHARE_STICKER", 8, 8);
        SHARE_STICKER = r112;
        CreateScene r113 = new CreateScene("COMMON_SHARE", 9, 9);
        COMMON_SHARE = r113;
        $VALUES = new CreateScene[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(CreateScene.class);
    }

    public static CreateScene[] values() {
        return (CreateScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CreateScene fromValue(int r100) {
        switch(r100) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return COMMON_SHARE;
    L8:
        return SHARE_STICKER;
    L10:
        return SHARE_SUBSCRIPTION;
    L12:
        return SHARE_QR_CODE;
    L14:
        return SHARE_MINUTES;
    L16:
        return SHARE_TODO;
    L18:
        return SHARE_DOC;
    L20:
        return SHARE_CALENDAR_EVENT;
    L22:
        return SHARE_GROUP_CHAT;
    L24:
        return NORMAL;
    }

    public static CreateScene valueOf(String r100) {
        return (CreateScene) a.a(CreateScene.class, r100);
    }

    private CreateScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
