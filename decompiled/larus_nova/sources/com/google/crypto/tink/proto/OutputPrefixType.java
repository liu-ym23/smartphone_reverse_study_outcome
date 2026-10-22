package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum OutputPrefixType extends Enum<OutputPrefixType> implements e.a {
    public static final OutputPrefixType CRUNCHY = null;
    public static final int CRUNCHY_VALUE = 4;
    public static final OutputPrefixType LEGACY = null;
    public static final int LEGACY_VALUE = 2;
    public static final OutputPrefixType RAW = null;
    public static final int RAW_VALUE = 3;
    public static final OutputPrefixType TINK = null;
    public static final int TINK_VALUE = 1;
    public static final OutputPrefixType UNKNOWN_PREFIX = null;
    public static final int UNKNOWN_PREFIX_VALUE = 0;
    public static final OutputPrefixType UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275796a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ OutputPrefixType[] f275797b = null;
    private final int value;

    public class a implements e.b<OutputPrefixType> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275798a = null;

        public b() {
        }

        static {
            f275798a = new b();
        }
    }

    static {
        OutputPrefixType r100 = new OutputPrefixType("UNKNOWN_PREFIX", 0, 0);
        UNKNOWN_PREFIX = r100;
        OutputPrefixType r101 = new OutputPrefixType("TINK", 1, 1);
        TINK = r101;
        OutputPrefixType r102 = new OutputPrefixType("LEGACY", 2, 2);
        LEGACY = r102;
        OutputPrefixType r103 = new OutputPrefixType("RAW", 3, 3);
        RAW = r103;
        OutputPrefixType r104 = new OutputPrefixType("CRUNCHY", 4, 4);
        CRUNCHY = r104;
        OutputPrefixType r105 = new OutputPrefixType("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r105;
        f275797b = new OutputPrefixType[]{r100, r101, r102, r103, r104, r105};
        f275796a = new a();
    }

    public static OutputPrefixType[] values() {
        return (OutputPrefixType[]) f275797b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<OutputPrefixType> internalGetValueMap() {
        return f275796a;
    }

    public static e.c internalGetVerifier() {
        return b.f275798a;
    }

    public static OutputPrefixType forNumber(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return CRUNCHY;
    L16:
        return RAW;
    L18:
        return LEGACY;
    L20:
        return TINK;
    L22:
        return UNKNOWN_PREFIX;
    }

    public static OutputPrefixType valueOf(String r100) {
        return (OutputPrefixType) r27.a.a(OutputPrefixType.class, r100);
    }

    public static OutputPrefixType valueOf(int r100) {
        return forNumber(r100);
    }

    public OutputPrefixType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
