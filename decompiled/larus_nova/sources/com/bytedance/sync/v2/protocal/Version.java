package com.bytedance.sync.v2.protocal;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum Version extends Enum<Version> implements WireEnum {
    private static final /* synthetic */ Version[] $VALUES = null;
    public static final ProtoAdapter<Version> ADAPTER = null;
    public static final Version Unknown = null;
    public static final Version V1 = null;
    public static final Version V2 = null;
    private final int value;

    static {
        Version r100 = new Version("Unknown", 0, 0);
        Unknown = r100;
        Version r101 = new Version(OuterPayLoginWrapper.LOGIN_STYLE_V1, 1, 1);
        V1 = r101;
        Version r102 = new Version("V2", 2, 2);
        V2 = r102;
        $VALUES = new Version[]{r100, r101, r102};
        ADAPTER = new ProtoAdapter_Version();
    }

    public static Version[] values() {
        return (Version[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static Version fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return V2;
    L12:
        return V1;
    L14:
        return Unknown;
    }

    public static Version valueOf(String r100) {
        return (Version) r27.a.a(Version.class, r100);
    }

    private Version(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
