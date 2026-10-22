package com.bytedance.android.tools.superkv;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements com.bytedance.android.tools.superkv.f {
    public static int q = 32768;
    public static int r = 8192;
    public volatile int a;
    public volatile int b;
    public volatile MappedByteBuffer c;
    public final Map<String, c> d;
    public final FileChannel e;
    public final RandomAccessFile f;
    public final boolean g;
    public final e h;
    public final e i;
    public final com.bytedance.android.tools.superkv.f.a j;
    public final bm3.c k;
    public final bm3.a l;
    public final bm3.b m;
    public final com.bytedance.android.tools.superkv.c n;
    public final a o;
    public final b p;

    public class a extends ThreadLocal<byte[]> {
        @Override // java.lang.ThreadLocal
        public final byte[] initialValue() {
            return new byte[g.r];
        }

        public a() {
        }
    }

    public class b implements d {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.tools.superkv.g.d
        public final void a(String r2) {
            this.a.d.remove(r2);
            ((com.bytedance.android.tools.superkv.d) this.a.j).c.remove(r2);
        }

        @Override // com.bytedance.android.tools.superkv.g.d
        public final void b(String r2, c r3) {
            this.a.d.put(r2, r3);
            ((com.bytedance.android.tools.superkv.d) this.a.j).c.remove(r2);
        }
    }

    public static final class c {
        public volatile int a;
        public volatile int b;

        public c() {
        }

        public c(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface d {
        void a(String r1);

        void b(String r1, c r2);
    }

    public interface e {
        void lock();

        void unlock();
    }

    public static final class f implements e {
        public final ReentrantReadWriteLock a;

        @Override // com.bytedance.android.tools.superkv.g.e
        public final void lock() {
            this.a.readLock().lock();
        }

        @Override // com.bytedance.android.tools.superkv.g.e
        public final void unlock() {
            this.a.readLock().unlock();
        }

        public f(ReentrantReadWriteLock r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.tools.superkv.g$g, reason: collision with other inner class name */
    public static final class C0026g implements e {
        public final ReentrantReadWriteLock a;

        @Override // com.bytedance.android.tools.superkv.g.e
        public final void lock() {
            this.a.writeLock().lock();
        }

        @Override // com.bytedance.android.tools.superkv.g.e
        public final void unlock() {
            this.a.writeLock().unlock();
        }

        public C0026g(ReentrantReadWriteLock r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final void a() {
        d(false);
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final void release() {
        m.a(this.c);
        this.e.close();     // Catch: Exception -> L5
    L13:
        this.f.close();     // Catch: Exception -> L9
        return;
    L9:
        com.bytedance.android.tools.superkv.b.a("Failed to close dataRandomAccessFile");
        return;
    L5:
        e = move-exception;
        com.bytedance.android.tools.superkv.b.b("Failed to close dataFileChannel", e);
        goto L13
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final int b(List r4) {
        this.i.lock();
        this.m.c();     // Catch: Throwable -> L6
        bm3.b r1 = this.m;     // Catch: Throwable -> L6
        r1.b = "__prefetch_cache_key_array";     // Catch: Throwable -> L6
        r1.c = 10;     // Catch: Throwable -> L6
        r1.k = r4;     // Catch: Throwable -> L6
        int r5 = f("__prefetch_cache_key_array", (byte) 1);     // Catch: Throwable -> L6
        this.i.unlock();
        return r5;
    L6:
        th = move-exception;
        this.i.unlock();
        throw th;
    }

    public final void d(boolean r11) {
        byte[] r0 = this.o.get();
        boolean r2 = false;
        this.c.position(0);
        this.c.get(r0, 0, 16);
        int r4 = 1;
        int r1 = ((((r0[0] & 255) << 24) | ((r0[1] & 255) << 16)) | ((r0[2] & 255) << 8)) | (r0[3] & 255);
        int r5 = (((r0[4] & 255) << 24) | ((r0[5] & 255) << 16)) | ((r0[6] & 255) << 8);
        int r3 = (r0[7] & 255) | r5;
        if (r1 <= 0) goto L27;
        if (r3 <= 0) goto L27;
        if (this.b >= r1) goto L24;
        ((LinkedHashMap) this.d).clear();
        int[] r6 = new int[1];
        if (e(16, r3, new h(this, r6)) == false) goto L12;
        r6[0] = -1;
    L12:
        if (r6[0] == this.d.size()) goto L15;
        if (r11 == false) goto L15;
    L16:
        ByteBuffer r12 = ByteBuffer.allocate(this.c.capacity() - 16);
        this.c.position(16);
        byte[] r7 = r12.array();
        Iterator r8 = ((LinkedHashMap) this.d).values().iterator();
        int r9 = 0;
    L18:
        if (r8.hasNext() == false) goto L20;
        c r10 = (c) r8.next();
        this.c.position(r10.a - 16);
        this.c.get(r7, r9, r10.b + 16);
        r10.a = (r9 + 16) + 16;
        r9 = r9 + (r10.b + 16);
        goto L18
    L20:
        this.c.position(16);
        this.c.put(r7, 0, r12.capacity());
        this.a = r9 + 16;
        ((com.bytedance.android.tools.superkv.d) this.j).c.evictAll();
        r2 = true;
    L21:
        if (r2 == false) goto L26;
        r4 = r1 + 1;
        g(r4, this.a);
    L28:
        this.b = r4;
        return;
    L26:
        r4 = r1;
    L15:
        if (r6[0] != (-1)) goto L21;
    L24:
        if (this.a >= r3) goto L26;
        e(this.a, r3, this.p);
    L27:
        g(1, 16);
        goto L28
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final bm3.b get(String r7) {
        this.h.lock();
    L9:
        th = move-exception;
        this.h.unlock();
        throw th;
    L11:
        e = move-exception;
        com.bytedance.android.tools.superkv.b.d("Failed to read local data!", e);     // Catch: Throwable -> L9
    L17:
        this.h.unlock();
        return null;
    L4:
        if (this.g == false) goto L6;
        d(false);     // Catch: Throwable -> L9 Exception -> L11
    L6:
        c r1 = (c) ((LinkedHashMap) this.d).get(r7);     // Catch: Throwable -> L9 Exception -> L11
        if (r1 != null) goto L13;
        com.bytedance.android.tools.superkv.b.b.onLog(2, com.bytedance.android.tools.superkv.b.c("Item does not exist, key: " + r7));     // Catch: Throwable -> L9 Exception -> L11
        goto L17
    L13:
        bm3.c r8 = this.k;     // Catch: Throwable -> L9 Exception -> L11
        com.bytedance.android.tools.superkv.c r0 = this.n;     // Catch: Throwable -> L9 Exception -> L11
        MappedByteBuffer r4 = this.c;     // Catch: Throwable -> L9 Exception -> L11
        int r5 = r1.a;     // Catch: Throwable -> L9 Exception -> L11
        int r2 = r1.b;     // Catch: Throwable -> L9 Exception -> L11
        r0.a = r4;     // Catch: Throwable -> L9 Exception -> L11
        r0.b = r2 + r5;     // Catch: Throwable -> L9 Exception -> L11
        r4.position(r5);     // Catch: Throwable -> L9 Exception -> L11
        r8.a = r0;     // Catch: Throwable -> L9 Exception -> L11
        r8.b = 0;     // Catch: Throwable -> L9 Exception -> L11
        r8.c = Long.MAX_VALUE;     // Catch: Throwable -> L9 Exception -> L11
        r8.d = 0;     // Catch: Throwable -> L9 Exception -> L11
        r8.e = 2;     // Catch: Throwable -> L9 Exception -> L11
        r8.f = -1;     // Catch: Throwable -> L9 Exception -> L11
        r8.g = -1;     // Catch: Throwable -> L9 Exception -> L11
        bm3.b r3 = this.m;     // Catch: Throwable -> L9 Exception -> L11
        bm3.b.a.a(r8, r3);     // Catch: Throwable -> L9 Exception -> L11
        this.h.unlock();
        return r3;
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final void remove(String r4) {
        this.i.lock();
    L13:
        th = move-exception;
        this.i.unlock();
        throw th;
    L4:
        if (this.g == false) goto L7;
        d(false);     // Catch: Throwable -> L13
    L7:
        if (this.d.remove(r4) != null) goto L11;
        com.bytedance.android.tools.superkv.b.b.onLog(2, com.bytedance.android.tools.superkv.b.c("Tried to remove item doesn't exist, key: " + r4));     // Catch: Throwable -> L13
    L9:
        this.i.unlock();
        return;
    L11:
        this.m.c();     // Catch: Throwable -> L13
        bm3.b r0 = this.m;     // Catch: Throwable -> L13
        r0.b = r4;     // Catch: Throwable -> L13
        r0.c = 0;     // Catch: Throwable -> L13
        f(r4, (byte) 0);     // Catch: Throwable -> L13
        goto L9
    }

    public g(String r8, com.bytedance.android.tools.superkv.f.a r9) throws IOException {
        this.a = 16;
        this.b = -1;
        this.d = new LinkedHashMap();
        this.k = new bm3.c();
        this.l = new bm3.a();
        this.m = new bm3.b();
        this.n = new com.bytedance.android.tools.superkv.c();
        this.o = new a();
        this.p = new b(this);
        this.g = false;
        this.j = r9;
        PolarisFileWrapper r10 = new PolarisFileWrapper(r8 + ".mapped.data");
        if (r10.exists() == true) goto L5;
        r10.createNewFile();
    L5:
        RandomAccessFile r11 = new RandomAccessFile(r10, "rw");
        this.f = r11;
        FileChannel r1 = r11.getChannel();
        this.e = r1;
        if (r1.size() <= 0) goto L8;
        int r12 = (int) r1.size();
    L9:
        this.c = r1.map(FileChannel.MapMode.READ_WRITE, 0, r12);
        ReentrantReadWriteLock r13 = new ReentrantReadWriteLock();
        f r14 = new f(r13);
        this.h = r14;
        this.i = new C0026g(r13);
        r14.lock();
        d(true);
        r14.unlock();
        return;
    L8:
        r12 = q;
        goto L9
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final int c(String r3, String r4) {
        this.i.lock();
        this.m.c();     // Catch: Throwable -> L6
        bm3.b r0 = this.m;     // Catch: Throwable -> L6
        r0.b = r3;     // Catch: Throwable -> L6
        r0.c = 8;     // Catch: Throwable -> L6
        r0.i = r4;     // Catch: Throwable -> L6
        int r5 = f(r3, (byte) 1);     // Catch: Throwable -> L6
        this.i.unlock();
        return r5;
    L6:
        th = move-exception;
        this.i.unlock();
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int f(String r35, byte r36) {
        byte[] r0 = this.o.get();
        if (this.g == false) goto L5;
        d(false);
    L5:
        c r3 = new c();
        int r5 = this.a;
        bm3.b r6 = this.m;
        int r7 = cm3.a.a(2, r6.c) + cm3.b.b(1, r6.b);
        int r9 = r6.c;
        if (r9 == 0) goto L54;
        switch(r9) {
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        Iterator<String> r8 = r6.k.iterator();
        int r10 = 0;
    L13:
        if (r8.hasNext() == false) goto L15;
        r10 = r10 + cm3.b.b(10, r8.next());
        goto L13
    L15:
        r7 = r7 + r10;
        goto L54
    L16:
        int r11 = r6.j.length;
        int r12 = r11 + bm3.a.b(r11);
        int r13 = bm3.a.b(72);
    L49:
        int r14 = r12 + r13;
    L53:
        r7 = r7 + r14;
        goto L54
    L17:
        r14 = cm3.b.b(8, r6.i);
        goto L53
    L18:
        r14 = bm3.a.b(56) + 8;
        goto L53
    L19:
        r14 = bm3.a.b(48) + 4;
        goto L53
    L20:
        long r15 = r6.f;
        if ((r15 & (-128)) != 0) goto L24;
        r12 = 1;
    L48:
        r13 = bm3.a.b(40);
        goto L49
    L24:
        if ((r15 & (-16384)) != 0) goto L27;
        r12 = 2;
        goto L48
    L27:
        if ((r15 & (-2097152)) != 0) goto L30;
        r12 = 3;
        goto L48
    L30:
        if ((r15 & (-268435456)) != 0) goto L33;
        r12 = 4;
        goto L48
    L33:
        if ((r15 & (-34359738368L)) != 0) goto L36;
        r12 = 5;
        goto L48
    L36:
        if ((r15 & (-4398046511104L)) != 0) goto L39;
        r12 = 6;
        goto L48
    L39:
        if ((r15 & (-562949953421312L)) != 0) goto L42;
        r12 = 7;
        goto L48
    L42:
        if ((r15 & (-72057594037927936L)) != 0) goto L45;
        r12 = 8;
        goto L48
    L45:
        if ((r15 & Long.MIN_VALUE) != 0) goto L47;
        r12 = 9;
        goto L48
    L47:
        r12 = 10;
        goto L48
    L50:
        r14 = cm3.a.a(4, r6.e);
        goto L53
    L51:
        r14 = bm3.a.b(24) + 1;
        goto L53
    L52:
        r14 = cm3.a.a(2, r9);
        goto L53
    L10:
        throw new IllegalArgumentException("Unknown type!");
    L54:
        r3.b = r7;
        r3.a = r5 + 16;
        int r16 = r7 + 16;
        if (r16 <= r0.length) goto L57;
        r0 = new byte[r16];
    L57:
        byte[] r17 = r0;
        bm3.a r1 = this.l;
        r1.a = r17;
        r1.b = 16;
        bm3.b r18 = this.m;
        cm3.b.a(r1, 1, r18.b);
        int r19 = r18.c;
        if (r19 == 0) goto L74;
        r1.c(16);
        if (r19 < 0) goto L63;
        r1.c(r19);
    L65:
        switch(r18.c) {
            case 3: goto L82;
            case 4: goto L78;
            case 5: goto L77;
            case 6: goto L76;
            case 7: goto L75;
            case 8: goto L73;
            case 9: goto L72;
            case 10: goto L68;
            default: goto L67;
        };
    L68:
        Iterator<String> r4 = r18.k.iterator();
    L70:
        if (r4.hasNext() == false) goto L74;
        cm3.b.a(r1, 10, r4.next());
        goto L70
    L72:
        byte[] r20 = r18.j;
        r1.c(74);
        r1.c(r20.length);
        System.arraycopy(r20, 0, r1.a, r1.b, r20.length);
        r1.b += r20.length;
        goto L74
    L73:
        cm3.b.a(r1, 8, r18.i);
        goto L74
    L75:
        double r21 = r18.h;
        r1.c(57);
        long r22 = Double.doubleToLongBits(r21);
        byte[] r23 = r1.a;
        int r110 = r1.b;
        int r111 = r110 + 1;
        r23[r110] = (byte) ((r22 >>> 56) & 255);
        int r112 = r111 + 1;
        r23[r111] = (byte) ((r22 >>> 48) & 255);
        int r113 = r112 + 1;
        r23[r112] = (byte) ((r22 >>> 40) & 255);
        int r114 = r113 + 1;
        r23[r113] = (byte) ((r22 >>> 32) & 255);
        int r115 = r114 + 1;
        r23[r114] = (byte) ((r22 >>> 24) & 255);
        int r116 = r115 + 1;
        int r117 = r5;
        int r33 = r16;
        r23[r115] = (byte) ((r22 >>> 16) & 255);
        int r24 = r116 + 1;
        r23[r116] = (byte) ((r22 >>> 8) & 255);
        r1.b = r24 + 1;
        r23[r24] = (byte) (r22 & 255);
    L83:
        long r25 = com.bytedance.android.tools.superkv.a.a(r17, 16, r7);
        r17[0] = (byte) (r7 >>> 24);
        r17[1] = (byte) (r7 >>> 16);
        r17[2] = (byte) (r7 >>> 8);
        r17[3] = (byte) r7;
        r17[4] = r36;
        r17[7] = -1;
        r17[6] = -1;
        r17[5] = -1;
        r17[8] = (byte) (r25 >>> 56);
        r17[9] = (byte) (r25 >>> 48);
        r17[10] = (byte) (r25 >>> 40);
        r17[11] = (byte) (r25 >>> 32);
        r17[12] = (byte) (r25 >>> 24);
        r17[13] = (byte) (r25 >>> 16);
        r17[14] = (byte) (r25 >>> 8);
        r17[15] = (byte) r25;
        if (this.c.capacity() >= (r3.a + r7)) goto L92;
        int r2 = r3.a + r7;
        int r26 = this.c.capacity();
    L86:
        if (r26 >= r2) goto L97;
        r26 = (int) (r26 * 1.5f);
        goto L86
    L97:
        m.a(this.c);     // Catch: Exception -> L90
        this.c = this.e.map(FileChannel.MapMode.READ_WRITE, 0, r26);     // Catch: Exception -> L90
    L90:
        e = move-exception;
        com.bytedance.android.tools.superkv.b.b("Failed to resize mapped buffer", e);
    L92:
        int r27 = r117;
        this.c.position(r27);
        int r28 = r33;
        this.c.put(r17, 0, r28);
        this.a = r27 + r28;
        g(this.b, this.a);
        if (r36 != 1) goto L96;
        this.d.put(r35, r3);
    L96:
        return r3.b;
    L76:
        r117 = r5;
        r33 = r16;
        float r29 = r18.g;
        r1.c(53);
        int r30 = Float.floatToIntBits(r29);
        byte[] r31 = r1.a;
        int r32 = r1.b;
        int r34 = r32 + 1;
        r31[r32] = (byte) ((r30 >>> 24) & 255);
        int r37 = r34 + 1;
        r31[r34] = (byte) ((r30 >>> 16) & 255);
        int r38 = r37 + 1;
        r31[r37] = (byte) ((r30 >>> 8) & 255);
        r1.b = r38 + 1;
        r31[r38] = (byte) (r30 & 255);
        goto L83
    L77:
        r117 = r5;
        r33 = r16;
        long r39 = r18.f;
        r1.c(40);
        r1.d(r39);
        goto L83
    L78:
        r117 = r5;
        r33 = r16;
        int r40 = r18.e;
        r1.c(32);
        if (r40 < 0) goto L81;
        r1.c(r40);
        goto L83
    L81:
        r1.d(r40);
        goto L83
    L82:
        r117 = r5;
        r33 = r16;
        boolean r41 = r18.d;
        r1.c(24);
        r1.c(r41 ? 1 : 0);
        goto L83
    L67:
        throw new IllegalArgumentException("Unknown type!");
    L63:
        r1.d(r19);
    L74:
        r117 = r5;
        r33 = r16;
        goto L83
    }

    public final void g(int r5, int r6) {
        byte[] r0 = this.o.get();
        r0[0] = (byte) (r5 >>> 24);
        r0[1] = (byte) (r5 >>> 16);
        r0[2] = (byte) (r5 >>> 8);
        r0[3] = (byte) r5;
        r0[4] = (byte) (r6 >>> 24);
        r0[5] = (byte) (r6 >>> 16);
        r0[6] = (byte) (r6 >>> 8);
        r0[7] = (byte) r6;
        this.c.position(0);
        this.c.put(r0, 0, 16);
    }

    public final boolean e(int r18, int r19, d r20) {
        byte[] r3 = ByteBuffer.allocateDirect(r19 - r18).array();
        int r4 = r18;
        int r5 = 0;
        boolean r6 = false;
    L3:
        if (r4 >= r19) goto L36;
        this.c.position(r4);
        this.c.get(r3, r5, 16);
        int r7 = r5 + 1;
        int r10 = r7 + 1;
        int r8 = ((r3[r5] & 255) << 24) | ((r3[r7] & 255) << 16);
        int r9 = r10 + 1;
        int r11 = r8 | ((r3[r10] & 255) << 8);
        int r12 = r9 + 1;
        int r13 = r11 | (r3[r9] & 255);
        int r14 = r12 + 1;
        byte r15 = r3[r12];
        int r16 = r14 + 1;
        if (r3[r14] != (-1)) goto L35;
        int r17 = r16 + 1;
        if (r3[r16] != (-1)) goto L35;
        int r110 = r17 + 1;
        if (r3[r17] != (-1)) goto L35;
        int r21 = r110 + 1;
        int r111 = r21 + 1;
        int r22 = r111 + 1;
        long r23 = (((((long) r3[r21]) & 255) << 48) | ((((long) r3[r110]) & 255) << 56)) | ((((long) r3[r111]) & 255) << 40);
        int r112 = r22 + 1;
        long r24 = r23 | ((((long) r3[r22]) & 255) << 32);
        int r25 = r112 + 1;
        long r26 = r24 | ((((long) r3[r112]) & 255) << 24);
        int r113 = r25 + 1;
        long r27 = r26 | ((((long) r3[r25]) & 255) << 16);
        int r28 = r113 + 1;
        int r114 = r28 + 1;
        long r29 = (r27 | ((((long) r3[r113]) & 255) << 8)) | (((long) r3[r28]) & 255);
        if (r13 <= 0) goto L13;
        this.c.get(r3, r114, r13);
        if (com.bytedance.android.tools.superkv.a.a(r3, r114, r13) != r29) goto L16;
        com.bytedance.android.tools.superkv.c r30 = this.n;     // Catch: Exception -> L32
        MappedByteBuffer r31 = this.c;     // Catch: Exception -> L32
        int r32 = r4 + 16;     // Catch: Exception -> L32
        r30.a = r31;     // Catch: Exception -> L32
        int r115 = r13 + r32;     // Catch: Exception -> L32
        r30.b = r115;     // Catch: Exception -> L32
        r31.position(r32);     // Catch: Exception -> L32
        bm3.c r33 = new bm3.c(r30);     // Catch: Exception -> L32
        r33.c();     // Catch: Exception -> L32
    L18:
        int r34 = r33.e();     // Catch: Exception -> L32
        if (r34 == (-1)) goto L31;
        if (r34 != 1) goto L18;
        String r35 = r33.h();     // Catch: Exception -> L38
        if ((r15 & 1) == 0) goto L27;
        r20.b(r35, new c(r32, r13));
    L28:
        r5 = r13 + r114;
        r4 = r115;
        goto L3
    L27:
        r20.a(r35);
        goto L28
    L31:
        throw new IllegalArgumentException("No key found in proto");     // Catch: Exception -> L38
    L33:
        com.bytedance.android.tools.superkv.b.a("Failed to decode data at: " + r4);
    L34:
        r4 = r4 + (r13 + 16);
        r5 = r114;
        r6 = true;
        goto L3
    L16:
        com.bytedance.android.tools.superkv.b.a("Checksum failed at position: " + r4 + ", expected: " + r29 + ", found: " + com.bytedance.android.tools.superkv.a.a(r3, r114, r13) + ", skipping...");
        goto L34
    L13:
        com.bytedance.android.tools.superkv.b.a("Unexpected EOF at " + r114 + "!");
    L35:
        com.bytedance.android.tools.superkv.b.a("Broken entry info at " + r4 + "! Skipping all the rest...");
        r6 = true;
    L36:
        this.a = r4;
        return r6;
    }
}
