package com.bytedance.express.command;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/express/command/Primitive;", "", "", "code", "I", "getCode", "()I", "NULL", "BOOL", "INT", "LONG", "FLOAT", "DOUBLE", "CHAR", "STRING", "COLLECTION", "UNSUPPORTED", "express_release"}, k = 1, mv = {1, 4, 0})
public final enum Primitive extends Enum<Primitive> {
    public static final Primitive BOOL = null;
    public static final Primitive CHAR = null;
    public static final Primitive COLLECTION = null;
    public static final Primitive DOUBLE = null;
    public static final Primitive FLOAT = null;
    public static final Primitive INT = null;
    public static final Primitive LONG = null;
    public static final Primitive NULL = null;
    public static final Primitive STRING = null;
    public static final Primitive UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Primitive[] f243197a = null;
    private final int code;

    public static Primitive valueOf(String r100) {
        return (Primitive) r27.a.a(Primitive.class, r100);
    }

    public static Primitive[] values() {
        return (Primitive[]) f243197a.clone();
    }

    static {
        Primitive r100 = new Primitive("NULL", 0, 0);
        NULL = r100;
        Primitive r101 = new Primitive("BOOL", 1, 1);
        BOOL = r101;
        Primitive r102 = new Primitive("INT", 2, 2);
        INT = r102;
        Primitive r103 = new Primitive("LONG", 3, 3);
        LONG = r103;
        Primitive r104 = new Primitive("FLOAT", 4, 4);
        FLOAT = r104;
        Primitive r105 = new Primitive("DOUBLE", 5, 5);
        DOUBLE = r105;
        Primitive r106 = new Primitive("CHAR", 6, 6);
        CHAR = r106;
        Primitive r107 = new Primitive("STRING", 7, 7);
        STRING = r107;
        Primitive r108 = new Primitive("COLLECTION", 8, 8);
        COLLECTION = r108;
        Primitive r109 = new Primitive("UNSUPPORTED", 9, Integer.MAX_VALUE);
        UNSUPPORTED = r109;
        f243197a = new Primitive[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final int getCode() {
        return this.code;
    }

    public Primitive(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
