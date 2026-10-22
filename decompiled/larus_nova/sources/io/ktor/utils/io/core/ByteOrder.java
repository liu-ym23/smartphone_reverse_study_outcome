package io.ktor.utils.io.core;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/core/ByteOrder;", "", "Ljava/nio/ByteOrder;", "nioOrder", "Ljava/nio/ByteOrder;", "getNioOrder", "()Ljava/nio/ByteOrder;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "BIG_ENDIAN", "LITTLE_ENDIAN", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final enum ByteOrder extends Enum<ByteOrder> {
    public static final ByteOrder BIG_ENDIAN = null;
    public static final a Companion = null;
    public static final ByteOrder LITTLE_ENDIAN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteOrder f492016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ByteOrder[] f492017b = null;
    private final java.nio.ByteOrder nioOrder;

    public static ByteOrder valueOf(String r100) {
        return (ByteOrder) r27.a.a(ByteOrder.class, r100);
    }

    public static ByteOrder[] values() {
        return (ByteOrder[]) f492017b.clone();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [io.ktor.utils.io.core.ByteOrder$a] */
    static {
        java.nio.ByteOrder r100 = java.nio.ByteOrder.BIG_ENDIAN;
        ByteOrder r101 = new ByteOrder("BIG_ENDIAN", 0, r100);
        BIG_ENDIAN = r101;
        ByteOrder r102 = new ByteOrder("LITTLE_ENDIAN", 1, java.nio.ByteOrder.LITTLE_ENDIAN);
        LITTLE_ENDIAN = r102;
        f492017b = new ByteOrder[]{r101, r102};
        Companion = new a();
        if (java.nio.ByteOrder.nativeOrder() == r100) goto L6;
        r101 = r102;
    L6:
        f492016a = r101;
    }

    public static final /* synthetic */ ByteOrder access$getNative$cp() {
        return f492016a;
    }

    public final java.nio.ByteOrder getNioOrder() {
        return this.nioOrder;
    }

    public ByteOrder(String r100, int r101, java.nio.ByteOrder r102) {
        super(r100, r101);
        this.nioOrder = r102;
    }
}
