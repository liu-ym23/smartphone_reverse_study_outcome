package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum Scene extends Enum<Scene> implements WireEnum {
    private static final /* synthetic */ Scene[] $VALUES = null;
    public static final ProtoAdapter<Scene> ADAPTER = null;
    public static final Scene NORMAL_SCENE = null;
    public static final Scene OBRICSDK = null;
    private final int value;

    static {
        Scene r100 = new Scene("NORMAL_SCENE", 0, 0);
        NORMAL_SCENE = r100;
        Scene r101 = new Scene("OBRICSDK", 1, 1);
        OBRICSDK = r101;
        $VALUES = new Scene[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
    }

    public static Scene[] values() {
        return (Scene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Scene fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return OBRICSDK;
    L10:
        return NORMAL_SCENE;
    }

    public static Scene valueOf(String r100) {
        return (Scene) a.a(Scene.class, r100);
    }

    private Scene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
