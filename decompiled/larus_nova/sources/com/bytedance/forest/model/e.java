package com.bytedance.forest.model;

import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f244334c;

    @Override // com.bytedance.forest.model.a
    public final byte[] e() {
        monitor-enter(this);
        ByteBuffer r100 = this.f244334c;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        byte[] r101 = new byte[this.f244328b];     // Catch: Throwable -> L10
        r100.position(0);     // Catch: Throwable -> L10
        r100.get(r101);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.forest.model.a
    public final void b() {
        ByteBuffer r100 = this.f244334c;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f244334c = null;
    }

    @Override // com.bytedance.forest.model.a
    public final void c() {
        ByteBuffer r100 = this.f244334c;
        if (r100 == null) goto L5;
        ByteBuffer r101 = r100.asReadOnlyBuffer();
    L6:
        this.f244334c = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.forest.model.a
    public final boolean d() {
        if (this.f244334c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("DirectBufferMeta(buffer_size=");
        ByteBuffer r101 = this.f244334c;
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.capacity());
    L6:
        r100.append(r103);
        r100.append(", buffer_pos=");
        ByteBuffer r104 = this.f244334c;
        if (r104 == null) goto L9;
        r102 = Integer.valueOf(r104.position());
    L9:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    public e(int r100, com.bytedance.forest.utils.e r101) {
        super(r100, r101);
        this.f244334c = ByteBuffer.allocateDirect(r100);
    }

    @Override // com.bytedance.forest.model.a
    public final void a(int r100, byte[] r110, int r111, int r112) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f244334c != null) goto L6;
        this.f244334c = ByteBuffer.allocateDirect(this.f244328b);     // Catch: Throwable -> L22
    L6:
        ByteBuffer r101 = this.f244334c;     // Catch: Throwable -> L22
        if (r101 != null) goto L10;
        Intrinsics.throwNpe();     // Catch: Throwable -> L22
    L10:
        if (r101.isReadOnly() == true) goto L20;
        ByteBuffer r102 = this.f244334c;     // Catch: Throwable -> L22
        if (r102 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L22
    L14:
        r102.position(r100);     // Catch: Throwable -> L22
        ByteBuffer r103 = this.f244334c;     // Catch: Throwable -> L22
        if (r103 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L22
    L17:
        r103.put(r110, r111, r112);     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L20:
        com.bytedance.forest.utils.c.a(getContext().f244543g, 6, "ForestDirectBuffer", "write bytes after finish", true, null, null, 48);     // Catch: Throwable -> L22
        throw new IOException("write bytes after finish");     // Catch: Throwable -> L22
    }

    @Override // com.bytedance.forest.model.a
    public final void f(int r100, byte[] r101, int r102, int r103) {
        monitor-enter(this);
        ByteBuffer r104 = this.f244334c;     // Catch: Throwable -> L8
        if (r104 == null) goto L6;
        r104.position(r100);     // Catch: Throwable -> L8
        r104.get(r101, r102, r103);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
