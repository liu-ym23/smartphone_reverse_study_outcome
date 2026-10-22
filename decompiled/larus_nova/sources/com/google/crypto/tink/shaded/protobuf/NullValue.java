package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final enum NullValue extends Enum<NullValue> implements e.a {
    public static final NullValue NULL_VALUE = null;
    public static final int NULL_VALUE_VALUE = 0;
    public static final NullValue UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ NullValue[] f275831b = null;
    private final int value;

    public class a implements e.b<NullValue> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275832a = null;

        public b() {
        }

        static {
            f275832a = new b();
        }
    }

    static {
        NullValue r100 = new NullValue("NULL_VALUE", 0, 0);
        NULL_VALUE = r100;
        NullValue r101 = new NullValue("UNRECOGNIZED", 1, -1);
        UNRECOGNIZED = r101;
        f275831b = new NullValue[]{r100, r101};
        f275830a = new a();
    }

    public static NullValue[] values() {
        return (NullValue[]) f275831b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<NullValue> internalGetValueMap() {
        return f275830a;
    }

    public static e.c internalGetVerifier() {
        return b.f275832a;
    }

    public static NullValue forNumber(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return NULL_VALUE;
    }

    public static NullValue valueOf(String r100) {
        return (NullValue) r27.a.a(NullValue.class, r100);
    }

    public static NullValue valueOf(int r100) {
        return forNumber(r100);
    }

    public NullValue(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
