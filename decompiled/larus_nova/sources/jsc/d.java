package jsc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static final void a(ByteBuffer r100, ByteBuffer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$copyTo");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        int r103 = r101.remaining();
        if (r100.hasArray() == true) goto L5;
    L12:
        ByteBuffer r104 = r100.duplicate();
        r104.limit(r103 + r102);
        r104.position(r102);
        r101.put(r104);
        return;
    L5:
        if (r100.isReadOnly() == true) goto L12;
        if (r101.hasArray() == false) goto L12;
        if (r101.isReadOnly() == true) goto L12;
        int r105 = r101.position();
        System.arraycopy(r100.array(), r100.arrayOffset() + r102, r101.array(), r101.arrayOffset() + r105, r103);
        r101.position(r105 + r103);
    }

    public static final void b(ByteBuffer r100, ByteBuffer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$copyTo");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r100.hasArray() == true) goto L5;
    L8:
        c(r101, r102, r100.remaining()).put(r100);
        return;
    L5:
        if (r100.isReadOnly() == true) goto L8;
        byte[] r103 = r100.array();
        int r104 = r100.arrayOffset() + r100.position();
        int r105 = r100.remaining();
        ByteBuffer r106 = ByteBuffer.wrap(r103, r104, r105).slice().order(ByteOrder.BIG_ENDIAN);
        ByteBuffer r107 = c.f500279b;
        Intrinsics.checkNotNullParameter(r106, "buffer");
        c.a(r106, r101, 0, r105, r102);
        r100.position(r100.limit());
    }

    public static final ByteBuffer c(ByteBuffer r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ByteBuffer r103 = r100.duplicate();
        r103.position(r101);
        r103.limit(r101 + r102);
        return r103.slice();
    }
}
