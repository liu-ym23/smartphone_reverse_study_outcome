package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final enum Writer$FieldOrder extends Enum<Writer$FieldOrder> {
    public static final Writer$FieldOrder ASCENDING = null;
    public static final Writer$FieldOrder DESCENDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Writer$FieldOrder[] f275854a = null;

    static {
        Writer$FieldOrder r100 = new Writer$FieldOrder("ASCENDING", 0);
        ASCENDING = r100;
        Writer$FieldOrder r101 = new Writer$FieldOrder("DESCENDING", 1);
        DESCENDING = r101;
        f275854a = new Writer$FieldOrder[]{r100, r101};
    }

    public static Writer$FieldOrder[] values() {
        return (Writer$FieldOrder[]) f275854a.clone();
    }

    public static Writer$FieldOrder valueOf(String r100) {
        return (Writer$FieldOrder) r27.a.a(Writer$FieldOrder.class, r100);
    }

    public Writer$FieldOrder(String r100, int r101) {
        super(r100, r101);
    }
}
