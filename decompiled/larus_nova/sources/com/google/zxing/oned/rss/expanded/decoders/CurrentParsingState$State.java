package com.google.zxing.oned.rss.expanded.decoders;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
final enum CurrentParsingState$State extends Enum<CurrentParsingState$State> {
    public static final CurrentParsingState$State ALPHA = null;
    public static final CurrentParsingState$State ISO_IEC_646 = null;
    public static final CurrentParsingState$State NUMERIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CurrentParsingState$State[] f275957a = null;

    static {
        CurrentParsingState$State r100 = new CurrentParsingState$State("NUMERIC", 0);
        NUMERIC = r100;
        CurrentParsingState$State r101 = new CurrentParsingState$State("ALPHA", 1);
        ALPHA = r101;
        CurrentParsingState$State r102 = new CurrentParsingState$State("ISO_IEC_646", 2);
        ISO_IEC_646 = r102;
        f275957a = new CurrentParsingState$State[]{r100, r101, r102};
    }

    public static CurrentParsingState$State[] values() {
        return (CurrentParsingState$State[]) f275957a.clone();
    }

    public static CurrentParsingState$State valueOf(String r100) {
        return (CurrentParsingState$State) a.a(CurrentParsingState$State.class, r100);
    }

    public CurrentParsingState$State(String r100, int r101) {
        super(r100, r101);
    }
}
