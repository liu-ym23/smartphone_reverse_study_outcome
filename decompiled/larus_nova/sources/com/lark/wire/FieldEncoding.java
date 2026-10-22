package com.lark.wire;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/lark/wire/FieldEncoding;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue$wire_runtime", "()I", "VARINT", "FIXED64", "LENGTH_DELIMITED", "FIXED32", "rawProtoAdapter", "Lcom/lark/wire/ProtoAdapter;", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum FieldEncoding extends Enum<FieldEncoding> {
    public static final a Companion = null;
    public static final FieldEncoding FIXED32 = null;
    public static final FieldEncoding FIXED64 = null;
    public static final FieldEncoding LENGTH_DELIMITED = null;
    public static final FieldEncoding VARINT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FieldEncoding[] f282709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282710b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f282711a = null;

        static {
            int[] r100 = new int[FieldEncoding.values().length];
            r100[FieldEncoding.VARINT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[FieldEncoding.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[FieldEncoding.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f282711a = r100;
        }
    }

    public static EnumEntries<FieldEncoding> getEntries() {
        return f282710b;
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
        FieldEncoding[] r104 = {r100, r101, r102, r103};
        f282709a = r104;
        f282710b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static FieldEncoding[] values() {
        return (FieldEncoding[]) f282709a.clone();
    }

    public final ProtoAdapter<?> rawProtoAdapter() {
        int r100 = b.f282711a[ordinal()];
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 != 4) goto L12;
        return ProtoAdapter.f282727p;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return ProtoAdapter.f282724m;
    L19:
        return ProtoAdapter.f282721j;
    L16:
        return ProtoAdapter.f282723l;
    }

    public final int getValue$wire_runtime() {
        return this.value;
    }

    @JvmStatic
    public static final FieldEncoding get$wire_runtime(int r100) throws IOException {
        Companion.getClass();
        if (r100 == 0) goto L16;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 != 5) goto L12;
        return FIXED32;
    L12:
        throw new ProtocolException("Unexpected FieldEncoding: " + r100);
    L18:
        return LENGTH_DELIMITED;
    L19:
        return FIXED64;
    L16:
        return VARINT;
    }

    public static FieldEncoding valueOf(String r100) {
        return (FieldEncoding) r27.a.a(FieldEncoding.class, r100);
    }

    public FieldEncoding(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
