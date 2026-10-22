package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum KeyData$KeyMaterialType extends Enum<KeyData$KeyMaterialType> implements e.a {
    public static final KeyData$KeyMaterialType ASYMMETRIC_PRIVATE = null;
    public static final int ASYMMETRIC_PRIVATE_VALUE = 2;
    public static final KeyData$KeyMaterialType ASYMMETRIC_PUBLIC = null;
    public static final int ASYMMETRIC_PUBLIC_VALUE = 3;
    public static final KeyData$KeyMaterialType REMOTE = null;
    public static final int REMOTE_VALUE = 4;
    public static final KeyData$KeyMaterialType SYMMETRIC = null;
    public static final int SYMMETRIC_VALUE = 1;
    public static final KeyData$KeyMaterialType UNKNOWN_KEYMATERIAL = null;
    public static final int UNKNOWN_KEYMATERIAL_VALUE = 0;
    public static final KeyData$KeyMaterialType UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275790a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KeyData$KeyMaterialType[] f275791b = null;
    private final int value;

    public class a implements e.b<KeyData$KeyMaterialType> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275792a = null;

        public b() {
        }

        static {
            f275792a = new b();
        }
    }

    static {
        KeyData$KeyMaterialType r100 = new KeyData$KeyMaterialType("UNKNOWN_KEYMATERIAL", 0, 0);
        UNKNOWN_KEYMATERIAL = r100;
        KeyData$KeyMaterialType r101 = new KeyData$KeyMaterialType("SYMMETRIC", 1, 1);
        SYMMETRIC = r101;
        KeyData$KeyMaterialType r102 = new KeyData$KeyMaterialType("ASYMMETRIC_PRIVATE", 2, 2);
        ASYMMETRIC_PRIVATE = r102;
        KeyData$KeyMaterialType r103 = new KeyData$KeyMaterialType("ASYMMETRIC_PUBLIC", 3, 3);
        ASYMMETRIC_PUBLIC = r103;
        KeyData$KeyMaterialType r104 = new KeyData$KeyMaterialType("REMOTE", 4, 4);
        REMOTE = r104;
        KeyData$KeyMaterialType r105 = new KeyData$KeyMaterialType("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r105;
        f275791b = new KeyData$KeyMaterialType[]{r100, r101, r102, r103, r104, r105};
        f275790a = new a();
    }

    public static KeyData$KeyMaterialType[] values() {
        return (KeyData$KeyMaterialType[]) f275791b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<KeyData$KeyMaterialType> internalGetValueMap() {
        return f275790a;
    }

    public static e.c internalGetVerifier() {
        return b.f275792a;
    }

    public static KeyData$KeyMaterialType forNumber(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return REMOTE;
    L16:
        return ASYMMETRIC_PUBLIC;
    L18:
        return ASYMMETRIC_PRIVATE;
    L20:
        return SYMMETRIC;
    L22:
        return UNKNOWN_KEYMATERIAL;
    }

    public static KeyData$KeyMaterialType valueOf(String r100) {
        return (KeyData$KeyMaterialType) r27.a.a(KeyData$KeyMaterialType.class, r100);
    }

    public static KeyData$KeyMaterialType valueOf(int r100) {
        return forNumber(r100);
    }

    public KeyData$KeyMaterialType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
