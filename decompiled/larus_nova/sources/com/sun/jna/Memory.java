package com.sun.jna;

import com.larus.apm.impl.protector.RunnableProtector;
import com.sun.jna.internal.Cleaner;
import java.io.Closeable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class Memory extends Pointer implements Closeable {
    private static final Map<Long, Reference<Memory>> allocatedMemory = null;
    private static final WeakMemoryHolder buffers = null;
    private final Cleaner.Cleanable cleanable;
    protected long size;

    public static final class MemoryDisposer implements Runnable {
        private long peer;

        public synchronized void com_sun_jna_Memory$MemoryDisposer__run$___twin___() {
            monitor-enter(this);
            Memory.free(this.peer);     // Catch: Throwable -> L8
            Memory.access$000().remove(Long.valueOf(this.peer));     // Catch: Throwable -> L11
            this.peer = 0;     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            Memory.access$000().remove(Long.valueOf(this.peer));     // Catch: Throwable -> L11
            this.peer = 0;     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            monitor-enter(this);
            com_sun_jna_Memory$MemoryDisposer_com_larus_apm_impl_protector_RunnableLancet_run(this);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public MemoryDisposer(long r100) {
            this.peer = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_sun_jna_Memory$MemoryDisposer_com_larus_apm_impl_protector_RunnableLancet_run(MemoryDisposer r100) {
            r100.com_sun_jna_Memory$MemoryDisposer__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class SharedMemory extends Memory {
        final /* synthetic */ Memory this$0;

        @Override // com.sun.jna.Memory
        public synchronized void dispose() {
            monitor-enter(this);
            this.peer = 0;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return super.toString() + " (shared from " + this.this$0.toString() + ")";
        }

        @Override // com.sun.jna.Memory
        public void boundsCheck(long r100, long r101) {
            Memory r102 = this.this$0;
            r102.boundsCheck((this.peer - r102.peer) + r100, r101);
        }

        public SharedMemory(Memory r100, long r101, long r102) {
            this.this$0 = r100;
            this.size = r102;
            this.peer = r100.peer + r101;
        }
    }

    static {
        allocatedMemory = new ConcurrentHashMap();
        buffers = new WeakMemoryHolder();
    }

    public static void disposeAll() {
        Iterator r100 = new ArrayList(allocatedMemory.values()).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Memory r101 = (Memory) ((Reference) r100.next()).get();
        if (r101 == null) goto L4;
        r101.close();
        goto L4
    }

    public static void purge() {
        buffers.clean();
    }

    public void clear() {
        clear(this.size);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.peer = 0;
        Cleaner.Cleanable r100 = this.cleanable;
        if (r100 == null) goto L6;
        r100.clean();
        return;
    }

    @Override // com.sun.jna.Pointer
    public String toString() {
        return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
    }

    public boolean valid() {
        if (this.peer == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Memory() {
        this.cleanable = null;
    }

    public String dump() {
        return dump(0, (int) size());
    }

    public static /* synthetic */ Map access$000() {
        return allocatedMemory;
    }

    public void dispose() {
        close();
    }

    public long size() {
        return this.size;
    }

    public Memory(long r100) {
        this.size = r100;
        if (r100 <= 0) goto L11;
        long r101 = malloc(r100);
        this.peer = r101;
        if (r101 == 0) goto L9;
        allocatedMemory.put(Long.valueOf(r101), new WeakReference(this));
        this.cleanable = Cleaner.getCleaner().register(this, new MemoryDisposer(this.peer));
        return;
    L9:
        throw new OutOfMemoryError("Cannot allocate " + r100 + " bytes");
    L11:
        throw new IllegalArgumentException("Allocation size must be greater than zero");
    }

    public static void free(long r100) {
        if (r100 == 0) goto L6;
        Native.free(r100);
        return;
    }

    public static long malloc(long r100) {
        return Native.malloc(r100);
    }

    private Pointer shareReferenceIfInBounds(Pointer r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        long r101 = r100.peer - this.peer;
        if (r101 >= 0) goto L8;
        return r100;
    L8:
        if (r101 < this.size) goto L10;
        return r100;
    L10:
        return share(r101);
    }

    public Memory align(int r110) {
        if (r110 <= 0) goto L21;
        int r100 = 0;
    L5:
        if (r100 >= 32) goto L19;
        if (r110 == (1 << r100)) goto L8;
        r100 = r100 + 1;
        goto L5
    L8:
        long r101 = r110;
        long r102 = ~(r101 - 1);
        long r103 = this.peer;
        if ((r103 & r102) == r103) goto L16;
        long r104 = ((r101 + r103) - 1) & r102;
        long r105 = (this.size + r103) - r104;
        if (r105 <= 0) goto L15;
        return (Memory) share(r104 - r103, r105);
    L15:
        throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
    L16:
        return this;
    L19:
        throw new IllegalArgumentException("Byte boundary must be a power of two");
    L21:
        throw new IllegalArgumentException("Byte boundary must be positive: " + r110);
    }

    @Override // com.sun.jna.Pointer
    public byte getByte(long r100) {
        boundsCheck(r100, 1);
        return super.getByte(r100);
    }

    @Override // com.sun.jna.Pointer
    public char getChar(long r100) {
        boundsCheck(r100, Native.WCHAR_SIZE);
        return super.getChar(r100);
    }

    @Override // com.sun.jna.Pointer
    public double getDouble(long r100) {
        boundsCheck(r100, 8);
        return super.getDouble(r100);
    }

    @Override // com.sun.jna.Pointer
    public float getFloat(long r100) {
        boundsCheck(r100, 4);
        return super.getFloat(r100);
    }

    @Override // com.sun.jna.Pointer
    public int getInt(long r100) {
        boundsCheck(r100, 4);
        return super.getInt(r100);
    }

    @Override // com.sun.jna.Pointer
    public long getLong(long r100) {
        boundsCheck(r100, 8);
        return super.getLong(r100);
    }

    @Override // com.sun.jna.Pointer
    public Pointer getPointer(long r100) {
        boundsCheck(r100, Native.POINTER_SIZE);
        return shareReferenceIfInBounds(super.getPointer(r100));
    }

    @Override // com.sun.jna.Pointer
    public short getShort(long r100) {
        boundsCheck(r100, 2);
        return super.getShort(r100);
    }

    @Override // com.sun.jna.Pointer
    public String getWideString(long r100) {
        boundsCheck(r100, 0);
        return super.getWideString(r100);
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long r100) {
        return share(r100, size() - r100);
    }

    public void boundsCheck(long r100, long r101) {
        if (r100 < 0) goto L10;
        long r102 = r100 + r101;
        if (r102 > this.size) goto L8;
        return;
    L8:
        throw new IndexOutOfBoundsException("Bounds exceeds available space : size=" + this.size + ", offset=" + r102);
    L10:
        throw new IndexOutOfBoundsException("Invalid offset: " + r100);
    }

    @Override // com.sun.jna.Pointer
    public ByteBuffer getByteBuffer(long r100, long r101) {
        boundsCheck(r100, r101);
        ByteBuffer r102 = super.getByteBuffer(r100, r101);
        buffers.put(r102, this);
        return r102;
    }

    @Override // com.sun.jna.Pointer
    public String getString(long r100, String r101) {
        boundsCheck(r100, 0);
        return super.getString(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setByte(long r100, byte r101) {
        boundsCheck(r100, 1);
        super.setByte(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setChar(long r100, char r101) {
        boundsCheck(r100, Native.WCHAR_SIZE);
        super.setChar(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setDouble(long r100, double r101) {
        boundsCheck(r100, 8);
        super.setDouble(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setFloat(long r100, float r101) {
        boundsCheck(r100, 4);
        super.setFloat(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setInt(long r100, int r101) {
        boundsCheck(r100, 4);
        super.setInt(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setLong(long r100, long r101) {
        boundsCheck(r100, 8);
        super.setLong(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setPointer(long r100, Pointer r101) {
        boundsCheck(r100, Native.POINTER_SIZE);
        super.setPointer(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setShort(long r100, short r101) {
        boundsCheck(r100, 2);
        super.setShort(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public void setWideString(long r100, String r101) {
        boundsCheck(r100, (((long) r101.length()) + 1) * ((long) Native.WCHAR_SIZE));
        super.setWideString(r100, r101);
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long r100, long r110) {
        boundsCheck(r100, r110);
        return new SharedMemory(this, r100, r110);
    }

    @Override // com.sun.jna.Pointer
    public void setString(long r100, String r101, String r102) {
        boundsCheck(r100, ((long) Native.getBytes(r101, r102).length) + 1);
        super.setString(r100, r101, r102);
    }

    @Override // com.sun.jna.Pointer
    public void read(long r100, byte[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 1);
        super.read(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void write(long r100, byte[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 1);
        super.write(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void read(long r100, char[] r101, int r102, int r103) {
        boundsCheck(r100, Native.WCHAR_SIZE * r103);
        super.read(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void write(long r100, char[] r101, int r102, int r103) {
        boundsCheck(r100, Native.WCHAR_SIZE * r103);
        super.write(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void read(long r100, double[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 8);
        super.read(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void write(long r100, double[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 8);
        super.write(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void read(long r100, float[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 4);
        super.read(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void write(long r100, float[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 4);
        super.write(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void read(long r100, int[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 4);
        super.read(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void write(long r100, int[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 4);
        super.write(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void read(long r100, long[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 8);
        super.read(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void write(long r100, long[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 8);
        super.write(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void read(long r100, Pointer[] r101, int r102, int r103) {
        boundsCheck(r100, Native.POINTER_SIZE * r103);
        super.read(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void write(long r100, Pointer[] r101, int r102, int r103) {
        boundsCheck(r100, Native.POINTER_SIZE * r103);
        super.write(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void read(long r100, short[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 2);
        super.read(r100, r101, r102, r103);
    }

    @Override // com.sun.jna.Pointer
    public void write(long r100, short[] r101, int r102, int r103) {
        boundsCheck(r100, ((long) r103) * 2);
        super.write(r100, r101, r102, r103);
    }
}
