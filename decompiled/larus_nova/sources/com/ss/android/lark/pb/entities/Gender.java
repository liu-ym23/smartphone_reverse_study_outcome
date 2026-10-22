package com.ss.android.lark.pb.entities;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum Gender extends Enum<Gender> implements WireEnum {
    private static final /* synthetic */ Gender[] $VALUES = null;
    public static final ProtoAdapter<Gender> ADAPTER = null;
    public static final Gender DEFAULT = null;
    public static final Gender MAN = null;
    public static final Gender WOMAN = null;
    private final int value;

    static {
        Gender r100 = new Gender("DEFAULT", 0, 0);
        DEFAULT = r100;
        Gender r101 = new Gender(HTTP.MAN, 1, 1);
        MAN = r101;
        Gender r102 = new Gender("WOMAN", 2, 2);
        WOMAN = r102;
        $VALUES = new Gender[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(Gender.class);
    }

    public static Gender[] values() {
        return (Gender[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Gender fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return WOMAN;
    L12:
        return MAN;
    L14:
        return DEFAULT;
    }

    public static Gender valueOf(String r100) {
        return (Gender) a.a(Gender.class, r100);
    }

    private Gender(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
