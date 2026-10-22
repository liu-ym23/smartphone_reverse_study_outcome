package jsc;

import androidx.collection.SieveCacheKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@JvmInline
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f500279b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f500280a;

    public static final class a {
    }

    static {
        ByteBuffer r100 = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullParameter(r100, "buffer");
        f500279b = r100;
    }

    public final int hashCode() {
        return this.f500280a.hashCode();
    }

    public final String toString() {
        return "Memory(buffer=" + this.f500280a + ')';
    }

    public /* synthetic */ c(ByteBuffer r100) {
        this.f500280a = r100;
    }

    public final boolean equals(Object r100) {
        ByteBuffer r101 = this.f500280a;
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r101, ((c) r100).f500280a) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static final void a(ByteBuffer r100, ByteBuffer r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r100.hasArray() == true) goto L5;
    L12:
        ByteBuffer r105 = r100.duplicate();
        r105.position(r102);
        r105.limit(r102 + r103);
        ByteBuffer r106 = r101.duplicate();
        r106.position(r104);
        r106.put(r105);
        return;
    L5:
        if (r101.hasArray() == false) goto L12;
        if (r100.isReadOnly() == true) goto L12;
        if (r101.isReadOnly() == true) goto L12;
        System.arraycopy(r100.array(), r100.arrayOffset() + r102, r101.array(), r101.arrayOffset() + r104, r103);
    }

    public static final void b(ByteBuffer r100, ByteBuffer r101, long r102, long r103, long r110) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r102 >= SieveCacheKt.NodeLinkMask) goto L14;
        int r104 = (int) r102;
        if (r103 >= SieveCacheKt.NodeLinkMask) goto L12;
        int r105 = (int) r103;
        if (r110 >= SieveCacheKt.NodeLinkMask) goto L10;
        a(r100, r101, r104, r105, (int) r110);
        return;
    L10:
        io.ktor.utils.io.core.internal.b.a(r110, "destinationOffset");
        throw null;
    L12:
        io.ktor.utils.io.core.internal.b.a(r103, "length");
        throw null;
    L14:
        io.ktor.utils.io.core.internal.b.a(r102, "offset");
        throw null;
    }
}
