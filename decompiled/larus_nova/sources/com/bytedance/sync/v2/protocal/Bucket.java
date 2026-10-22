package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum Bucket extends Enum<Bucket> implements WireEnum {
    private static final /* synthetic */ Bucket[] $VALUES = null;
    public static final ProtoAdapter<Bucket> ADAPTER = null;
    public static final Bucket Device = null;
    public static final Bucket User = null;
    private final int value;

    static {
        Bucket r100 = new Bucket("Device", 0, 0);
        Device = r100;
        Bucket r101 = new Bucket("User", 1, 1);
        User = r101;
        $VALUES = new Bucket[]{r100, r101};
        ADAPTER = new ProtoAdapter_Bucket();
    }

    public static Bucket[] values() {
        return (Bucket[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static Bucket fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return User;
    L10:
        return Device;
    }

    public static Bucket valueOf(String r100) {
        return (Bucket) r27.a.a(Bucket.class, r100);
    }

    private Bucket(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
