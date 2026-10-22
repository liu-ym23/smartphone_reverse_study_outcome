package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final enum Syntax extends Enum<Syntax> implements e.a {
    public static final Syntax SYNTAX_EDITIONS = null;
    public static final int SYNTAX_EDITIONS_VALUE = 2;
    public static final Syntax SYNTAX_PROTO2 = null;
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final Syntax SYNTAX_PROTO3 = null;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    public static final Syntax UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Syntax[] f275847b = null;
    private final int value;

    public class a implements e.b<Syntax> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275848a = null;

        public b() {
        }

        static {
            f275848a = new b();
        }
    }

    static {
        Syntax r100 = new Syntax("SYNTAX_PROTO2", 0, 0);
        SYNTAX_PROTO2 = r100;
        Syntax r101 = new Syntax("SYNTAX_PROTO3", 1, 1);
        SYNTAX_PROTO3 = r101;
        Syntax r102 = new Syntax("SYNTAX_EDITIONS", 2, 2);
        SYNTAX_EDITIONS = r102;
        Syntax r103 = new Syntax("UNRECOGNIZED", 3, -1);
        UNRECOGNIZED = r103;
        f275847b = new Syntax[]{r100, r101, r102, r103};
        f275846a = new a();
    }

    public static Syntax[] values() {
        return (Syntax[]) f275847b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<Syntax> internalGetValueMap() {
        return f275846a;
    }

    public static e.c internalGetVerifier() {
        return b.f275848a;
    }

    public static Syntax forNumber(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return SYNTAX_EDITIONS;
    L12:
        return SYNTAX_PROTO3;
    L14:
        return SYNTAX_PROTO2;
    }

    public static Syntax valueOf(String r100) {
        return (Syntax) r27.a.a(Syntax.class, r100);
    }

    public static Syntax valueOf(int r100) {
        return forNumber(r100);
    }

    public Syntax(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
