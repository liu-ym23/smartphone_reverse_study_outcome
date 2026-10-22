package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum Platform extends Enum<Platform> implements WireEnum {
    private static final /* synthetic */ Platform[] $VALUES = null;
    public static final ProtoAdapter<Platform> ADAPTER = null;
    public static final Platform Platform_Android = null;
    public static final Platform Platform_Harmony = null;
    public static final Platform Platform_IOS = null;
    public static final Platform Platform_Linux = null;
    public static final Platform Platform_Mac = null;
    public static final Platform Platform_Windows = null;
    private final int value;

    static {
        Platform r100 = new Platform("Platform_Android", 0, 1);
        Platform_Android = r100;
        Platform r101 = new Platform("Platform_IOS", 1, 2);
        Platform_IOS = r101;
        Platform r102 = new Platform("Platform_Windows", 2, 3);
        Platform_Windows = r102;
        Platform r103 = new Platform("Platform_Mac", 3, 4);
        Platform_Mac = r103;
        Platform r104 = new Platform("Platform_Linux", 4, 5);
        Platform_Linux = r104;
        Platform r110 = new Platform("Platform_Harmony", 5, 10);
        Platform_Harmony = r110;
        $VALUES = new Platform[]{r100, r101, r102, r103, r104, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(Platform.class);
    }

    public static Platform[] values() {
        return (Platform[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Platform fromValue(int r100) {
        if (r100 == 1) goto L27;
        if (r100 == 2) goto L25;
        if (r100 == 3) goto L23;
        if (r100 == 4) goto L21;
        if (r100 == 5) goto L19;
        if (r100 == 10) goto L17;
        return null;
    L17:
        return Platform_Harmony;
    L19:
        return Platform_Linux;
    L21:
        return Platform_Mac;
    L23:
        return Platform_Windows;
    L25:
        return Platform_IOS;
    L27:
        return Platform_Android;
    }

    public static Platform valueOf(String r100) {
        return (Platform) a.a(Platform.class, r100);
    }

    private Platform(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
