package ou7;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
public final class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileChannel f526792a;

    public final List<String> a() throws IOException {
        this.f526792a.position(0);
        ArrayList r100 = new ArrayList();
        this.f526792a.position(0);
        ByteBuffer r101 = ByteBuffer.allocate(8);
        ByteOrder r102 = ByteOrder.LITTLE_ENDIAN;
        r101.order(r102);
        if (d(r101, 0) != 1179403647) goto L68;
        b(r101, 4, 1);
        short r103 = (short) (r101.get() & UByte.MAX_VALUE);
        b(r101, 5, 1);
        if (((short) (r101.get() & UByte.MAX_VALUE)) != 2) goto L7;
        boolean r104 = true;
    L8:
        if (r103 != 1) goto L10;
        d r105 = new g(r104, this);
    L12:
        ByteBuffer r106 = ByteBuffer.allocate(8);
        if (r105.f526779a == false) goto L15;
        r102 = ByteOrder.BIG_ENDIAN;
    L15:
        r106.order(r102);
        long r107 = r105.f526783e;
        if (r107 != 65535) goto L18;
        r107 = r105.c().f526789a;
    L18:
        long r110 = 0;
    L19:
        long r111 = 1;
        if (r110 >= r107) goto L25;
        e r108 = r105.b(r110);
        if (r108.f526785a == 2) goto L23;
        r110 = r110 + 1;
        goto L19
    L23:
        long r109 = r108.f526786b;
    L27:
        if (r109 == 0) goto L29;
        ArrayList r112 = new ArrayList();
        long r113 = 0;
        int r114 = 0;
    L31:
        c r115 = r105.a(r109, r114);
        long r210 = r109;
        long r116 = r115.f526777a;
        if (r116 != 1) goto L35;
        r112.add(Long.valueOf(r115.f526778b));
    L37:
        r114 = r114 + 1;
        if (r115.f526777a == 0) goto L40;
        r107 = r107;
        r109 = r210;
        goto L31
    L40:
        if (r113 == 0) goto L63;
        long r117 = 0;
    L43:
        if (r117 >= r107) goto L61;
        e r118 = r105.b(r117);
        long r119 = r107;
        if (r118.f526785a != r111) goto L59;
        long r120 = r118.f526787c;
        if (r120 > r113) goto L59;
        if (r113 > (r118.f526788d + r120)) goto L59;
        long r121 = (r113 - r120) + r118.f526786b;
        Iterator r122 = r112.iterator();
    L52:
        if (r122.hasNext() == false) goto L58;
        long r123 = ((Long) r122.next()).longValue() + r121;
        StringBuilder r124 = new StringBuilder();
    L54:
        long r125 = r123 + 1;
        b(r106, r123, 1);
        short r126 = (short) (r106.get() & UByte.MAX_VALUE);
        if (r126 == 0) goto L57;
        r124.append((char) r126);
        r123 = r125;
        goto L54
    L57:
        r100.add(r124.toString());
        goto L52
    L58:
        return r100;
    L59:
        r117 = r117 + 1;
        r111 = 1;
        r107 = r119;
        goto L43
    L61:
        throw new IllegalStateException("Could not map vma to file offset!");
    L63:
        throw new IllegalStateException("String table offset not found!");
    L35:
        if (r116 != 5) goto L37;
        r113 = r115.f526778b;
        goto L37
    L29:
        return Collections.unmodifiableList(r100);
    L25:
        r109 = 0;
        goto L27
    L10:
        if (r103 != 2) goto L66;
        r105 = new h(r104, this);
        goto L12
    L66:
        throw new IllegalStateException("Invalid class type!");
    L7:
        r104 = false;
        goto L8
    L68:
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f526792a.close();
    }

    public i(PolarisFileWrapper r100) throws FileNotFoundException {
        if (r100.exists() == false) goto L7;
        this.f526792a = new PolarisFileInputStreamWrapper(r100).getChannel();
        return;
    L7:
        throw new IllegalArgumentException("File is null or does not exist");
    }

    public final int c(ByteBuffer r100, long r101) throws IOException {
        b(r100, r101, 2);
        return r100.getShort() & 65535;
    }

    public final long d(ByteBuffer r100, long r101) throws IOException {
        b(r100, r101, 4);
        return ((long) r100.getInt()) & BodyPartID.bodyIdMax;
    }

    public final void b(ByteBuffer r100, long r101, int r110) throws IOException {
        r100.position(0);
        r100.limit(r110);
        long r102 = 0;
    L4:
        if (r102 >= r110) goto L10;
        int r103 = this.f526792a.read(r100, r101 + r102);
        if (r103 == (-1)) goto L9;
        r102 = r102 + ((long) r103);
        goto L4
    L9:
        throw new EOFException();
    L10:
        r100.position(0);
    }
}
