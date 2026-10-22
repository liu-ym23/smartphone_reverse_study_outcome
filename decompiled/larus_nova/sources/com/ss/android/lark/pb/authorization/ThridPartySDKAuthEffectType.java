package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ThridPartySDKAuthEffectType extends Enum<ThridPartySDKAuthEffectType> implements WireEnum {
    private static final /* synthetic */ ThridPartySDKAuthEffectType[] $VALUES = null;
    public static final ProtoAdapter<ThridPartySDKAuthEffectType> ADAPTER = null;
    public static final ThridPartySDKAuthEffectType AMapSDK = null;
    public static final ThridPartySDKAuthEffectType FeelGood = null;
    public static final ThridPartySDKAuthEffectType PaySDK = null;
    public static final ThridPartySDKAuthEffectType QQSDK = null;
    public static final ThridPartySDKAuthEffectType Unknown = null;
    public static final ThridPartySDKAuthEffectType WeChatSDK = null;
    public static final ThridPartySDKAuthEffectType WeiBoSDK = null;
    private final int value;

    static {
        ThridPartySDKAuthEffectType r100 = new ThridPartySDKAuthEffectType("Unknown", 0, -1);
        Unknown = r100;
        ThridPartySDKAuthEffectType r101 = new ThridPartySDKAuthEffectType("WeChatSDK", 1, 1);
        WeChatSDK = r101;
        ThridPartySDKAuthEffectType r102 = new ThridPartySDKAuthEffectType("QQSDK", 2, 2);
        QQSDK = r102;
        ThridPartySDKAuthEffectType r103 = new ThridPartySDKAuthEffectType("WeiBoSDK", 3, 3);
        WeiBoSDK = r103;
        ThridPartySDKAuthEffectType r104 = new ThridPartySDKAuthEffectType("PaySDK", 4, 4);
        PaySDK = r104;
        ThridPartySDKAuthEffectType r105 = new ThridPartySDKAuthEffectType("FeelGood", 5, 5);
        FeelGood = r105;
        ThridPartySDKAuthEffectType r110 = new ThridPartySDKAuthEffectType("AMapSDK", 6, 6);
        AMapSDK = r110;
        $VALUES = new ThridPartySDKAuthEffectType[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(ThridPartySDKAuthEffectType.class);
    }

    public static ThridPartySDKAuthEffectType[] values() {
        return (ThridPartySDKAuthEffectType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ThridPartySDKAuthEffectType fromValue(int r100) {
        switch(r100) {
            case -1: goto L18;
            case 0: goto L3;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return AMapSDK;
    L8:
        return FeelGood;
    L10:
        return PaySDK;
    L12:
        return WeiBoSDK;
    L14:
        return QQSDK;
    L16:
        return WeChatSDK;
    L18:
        return Unknown;
    }

    public static ThridPartySDKAuthEffectType valueOf(String r100) {
        return (ThridPartySDKAuthEffectType) a.a(ThridPartySDKAuthEffectType.class, r100);
    }

    private ThridPartySDKAuthEffectType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
