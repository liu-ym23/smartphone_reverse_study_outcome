package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum KeyStatusType extends Enum<KeyStatusType> implements e.a {
    public static final KeyStatusType DESTROYED = null;
    public static final int DESTROYED_VALUE = 3;
    public static final KeyStatusType DISABLED = null;
    public static final int DISABLED_VALUE = 2;
    public static final KeyStatusType ENABLED = null;
    public static final int ENABLED_VALUE = 1;
    public static final KeyStatusType UNKNOWN_STATUS = null;
    public static final int UNKNOWN_STATUS_VALUE = 0;
    public static final KeyStatusType UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KeyStatusType[] f275794b = null;
    private final int value;

    public class a implements e.b<KeyStatusType> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275795a = null;

        public b() {
        }

        static {
            f275795a = new b();
        }
    }

    static {
        KeyStatusType r100 = new KeyStatusType("UNKNOWN_STATUS", 0, 0);
        UNKNOWN_STATUS = r100;
        KeyStatusType r101 = new KeyStatusType("ENABLED", 1, 1);
        ENABLED = r101;
        KeyStatusType r102 = new KeyStatusType("DISABLED", 2, 2);
        DISABLED = r102;
        KeyStatusType r103 = new KeyStatusType("DESTROYED", 3, 3);
        DESTROYED = r103;
        KeyStatusType r104 = new KeyStatusType("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275794b = new KeyStatusType[]{r100, r101, r102, r103, r104};
        f275793a = new a();
    }

    public static KeyStatusType[] values() {
        return (KeyStatusType[]) f275794b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<KeyStatusType> internalGetValueMap() {
        return f275793a;
    }

    public static e.c internalGetVerifier() {
        return b.f275795a;
    }

    public static KeyStatusType forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return DESTROYED;
    L14:
        return DISABLED;
    L16:
        return ENABLED;
    L18:
        return UNKNOWN_STATUS;
    }

    public static KeyStatusType valueOf(String r100) {
        return (KeyStatusType) r27.a.a(KeyStatusType.class, r100);
    }

    public static KeyStatusType valueOf(int r100) {
        return forNumber(r100);
    }

    public KeyStatusType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
