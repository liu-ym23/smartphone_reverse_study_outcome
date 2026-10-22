package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum TranslateSource extends Enum<TranslateSource> implements WireEnum {
    private static final /* synthetic */ TranslateSource[] $VALUES = null;
    public static final ProtoAdapter<TranslateSource> ADAPTER = null;
    public static final TranslateSource AUTO_TRANSLATE = null;
    public static final TranslateSource MANUAL_TRANSLATE = null;
    public static final TranslateSource UNKNOWN_TRANSLATE_SOURCE = null;
    private final int value;

    static {
        TranslateSource r100 = new TranslateSource("UNKNOWN_TRANSLATE_SOURCE", 0, 0);
        UNKNOWN_TRANSLATE_SOURCE = r100;
        TranslateSource r101 = new TranslateSource("MANUAL_TRANSLATE", 1, 1);
        MANUAL_TRANSLATE = r101;
        TranslateSource r102 = new TranslateSource("AUTO_TRANSLATE", 2, 2);
        AUTO_TRANSLATE = r102;
        $VALUES = new TranslateSource[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(TranslateSource.class);
    }

    public static TranslateSource[] values() {
        return (TranslateSource[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TranslateSource fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return AUTO_TRANSLATE;
    L12:
        return MANUAL_TRANSLATE;
    L14:
        return UNKNOWN_TRANSLATE_SOURCE;
    }

    public static TranslateSource valueOf(String r100) {
        return (TranslateSource) a.a(TranslateSource.class, r100);
    }

    private TranslateSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
