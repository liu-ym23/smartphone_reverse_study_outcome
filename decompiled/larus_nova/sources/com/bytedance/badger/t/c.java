package com.bytedance.badger.t;

import com.bytedance.badger.NativeBridge;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f199195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f199196b;

    public c(int r100) {
        this.f199196b = r100;
        this.f199195a = new o();
    }

    public final void b(int r100) {
        this.f199195a.a(r100);
    }

    public final void c(String r100) {
        if (r100.getBytes(Charsets.UTF_8).length <= 65535) goto L6;
        this.f199195a.c("");
        com.bytedance.badger.e.e("NativeRequestBuilder", "String length exceeds 65535 characters");
        return;
    L6:
        this.f199195a.c(r100);
    }

    public final d a(Object r110) {
        int r100 = this.f199196b;
        byte[] r101 = this.f199195a.f199208a.toByteArray();
        ByteBuffer r102 = ByteBuffer.allocate(r101.length + 10);
        ByteOrder r103 = ByteOrder.BIG_ENDIAN;
        ByteBuffer r104 = r102.order(r103);
        r104.put((byte) 1);
        r104.put((byte) 0);
        r104.putInt(r100);
        r104.putInt(r101.length);
        r104.put(r101);
        byte[] r105 = r104.array();
        int r106 = a.f199193a;
        byte[] r111 = NativeBridge.f199025a.a(r105, r110);     // Catch: Throwable -> L14
        if (r111 != null) goto L22;
        com.bytedance.badger.e.e("NativeBridge", "native method returned null");
        return new d(0, CollectionsKt.listOf(new l[]{new g(-1), new k("Native returned null")}), new byte[0]);
    L22:
        ByteBuffer r107 = ByteBuffer.wrap(r111).order(r103);     // Catch: Throwable -> L12
        r107.get();     // Catch: Throwable -> L12
        r107.get();     // Catch: Throwable -> L12
        int r108 = r107.getInt();     // Catch: Throwable -> L12
        byte[] r109 = new byte[r107.getInt()];     // Catch: Throwable -> L12
        r107.get(r109);     // Catch: Throwable -> L12
        m r112 = new m(r109);     // Catch: Throwable -> L12
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L12
    L8:
        if (r112.f199207a.hasRemaining() == false) goto L10;
        r113.add(r112.b());     // Catch: Throwable -> L12
        goto L8
    L10:
        d r114 = new d(r108, r113, r111);     // Catch: Throwable -> L12
    L21:
        return r114;
    L12:
        th = move-exception;
        com.bytedance.badger.e.c("NativeBridge", "parse result payload error", th);
        return new d(0, CollectionsKt.listOf(new l[]{new g(-1), new k("Parse result error: " + th.getMessage())}), r111);
    L14:
        th = move-exception;
        com.bytedance.badger.e.c("NativeBridge", "call native method error", th);
        l[] r115 = new l[2];
        r115[0] = new g(-1);
        String r116 = th.getMessage();
        if (r116 != null) goto L19;
        r116 = "Unknown error";
    L19:
        r115[1] = new k(r116);
        r114 = new d(0, CollectionsKt.listOf(r115), new byte[0]);
        goto L21
    }

    public final void d(List r100) {
        this.f199195a.f199208a.write(32);
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L34;
        Object r102 = r101.next();
        if ((r102 instanceof Integer) == true) goto L7;
        if ((r102 instanceof Long) == true) goto L10;
        if ((r102 instanceof Boolean) == true) goto L13;
        if ((r102 instanceof String) == true) goto L16;
        if ((r102 instanceof byte[]) == true) goto L19;
        if ((r102 instanceof List) == true) goto L22;
        if ((r102 instanceof n) == false) goto L33;
        this.f199195a.f199208a.write(16);
        ((n) r102).a(this.f199195a);
        this.f199195a.f199208a.write(17);
        goto L4
    L33:
        throw new IllegalArgumentException("Unsupported type in list: ".concat(r102.getClass().getSimpleName()));
    L22:
        ArrayList r103 = new ArrayList();
        Iterator r104 = ((Iterable) r102).iterator();
    L24:
        if (r104.hasNext() == false) goto L28;
        Object r105 = r104.next();
        if ((r105 instanceof Object) == false) goto L24;
        r103.add(r105);
        goto L24
    L28:
        d(r103);
        goto L4
    L19:
        o r106 = this.f199195a;
        r106.d((byte[]) r102);
        goto L4
    L16:
        c((String) r102);
        goto L4
    L13:
        boolean r107 = ((Boolean) r102).booleanValue();
        o r108 = this.f199195a;
        r108.f199208a.write(5);
        r108.f199208a.write(r107 ? 1 : 0);
        goto L4
    L10:
        long r109 = ((Number) r102).longValue();
        this.f199195a.b(r109);
        goto L4
    L7:
        int r110 = ((Number) r102).intValue();
        this.f199195a.a(r110);
        goto L4
    L34:
        this.f199195a.f199208a.write(33);
    }
}
