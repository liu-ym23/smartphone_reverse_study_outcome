package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum FieldEncoding extends Enum<FieldEncoding> {
    private static final /* synthetic */ FieldEncoding[] $VALUES = null;
    public static final FieldEncoding FIXED32 = null;
    public static final FieldEncoding FIXED64 = null;
    public static final FieldEncoding LENGTH_DELIMITED = null;
    public static final FieldEncoding VARINT = null;
    final int value;

    /* JADX INFO: renamed from: com.squareup.wire.FieldEncoding$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes34.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$FieldEncoding = null;

        static {
            int[] r100 = new int[FieldEncoding.values().length];
            $SwitchMap$com$squareup$wire$FieldEncoding = r100;
            r100[FieldEncoding.VARINT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        FieldEncoding r100 = new FieldEncoding("VARINT", 0, 0);
        VARINT = r100;
        FieldEncoding r101 = new FieldEncoding("FIXED64", 1, 1);
        FIXED64 = r101;
        FieldEncoding r102 = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
        LENGTH_DELIMITED = r102;
        FieldEncoding r103 = new FieldEncoding("FIXED32", 3, 5);
        FIXED32 = r103;
        $VALUES = new FieldEncoding[]{r100, r101, r102, r103};
    }

    public static FieldEncoding[] values() {
        return (FieldEncoding[]) $VALUES.clone();
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int r100 = AnonymousClass1.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 != 4) goto L13;
        return ProtoAdapter.BYTES;
    L13:
        throw new AssertionError();
    L15:
        return ProtoAdapter.FIXED64;
    L17:
        return ProtoAdapter.FIXED32;
    L19:
        return ProtoAdapter.UINT64;
    }

    public static FieldEncoding get(int r100) throws IOException {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 != 5) goto L12;
        return FIXED32;
    L12:
        throw new ProtocolException("Unexpected FieldEncoding: " + r100);
    L14:
        return LENGTH_DELIMITED;
    L16:
        return FIXED64;
    L18:
        return VARINT;
    }

    public static FieldEncoding valueOf(String r100) {
        return (FieldEncoding) a.a(FieldEncoding.class, r100);
    }

    private FieldEncoding(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
