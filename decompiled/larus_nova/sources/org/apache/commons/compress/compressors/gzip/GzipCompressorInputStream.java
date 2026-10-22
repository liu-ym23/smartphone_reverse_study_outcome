package org.apache.commons.compress.compressors.gzip;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.UByte;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes42.dex */
public class GzipCompressorInputStream extends CompressorInputStream {
    private final byte[] buf;
    private int bufUsed;
    private final CountingInputStream countingStream;

    /* JADX INFO: renamed from: crc, reason: collision with root package name */
    private final CRC32 f525009crc;
    private final boolean decompressConcatenated;
    private boolean endReached;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f525010in;
    private Inflater inf;
    private final byte[] oneByte;
    private final GzipParameters parameters;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Inflater r100 = this.inf;
        if (r100 == null) goto L5;
        r100.end();
        this.inf = null;
    L5:
        InputStream r101 = this.f525010in;
        if (r101 == System.in) goto L9;
        r101.close();
        return;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.oneByte[0] & UByte.MAX_VALUE;
    }

    static {
    }

    public GzipCompressorInputStream(InputStream r100) throws IOException {
        this(r100, false);
    }

    private boolean init(boolean r100) throws IOException {
        int r101 = this.f525010in.read();
        int r102 = this.f525010in.read();
        if (r101 != (-1)) goto L8;
        if (r100 == true) goto L8;
        return false;
    L8:
        if (r101 != 31) goto L44;
        if (r102 != 139) goto L44;
        DataInputStream r103 = new DataInputStream(this.f525010in);
        int r104 = r103.readUnsignedByte();
        if (r104 != 8) goto L42;
        int r105 = r103.readUnsignedByte();
        if ((r105 & 224) != 0) goto L40;
        this.parameters.setModificationTime(ByteUtils.fromLittleEndian(r103, 4) * 1000);
        int r106 = r103.readUnsignedByte();
        if (r106 == 2) goto L21;
        if (r106 != 4) goto L22;
        this.parameters.setCompressionLevel(1);
    L22:
        this.parameters.setOperatingSystem(r103.readUnsignedByte());
        if ((r105 & 4) == 0) goto L29;
        int r107 = (r103.readUnsignedByte() << 8) | r103.readUnsignedByte();
    L25:
        int r108 = r107 - 1;
        if (r107 <= 0) goto L29;
        r103.readUnsignedByte();
        r107 = r108;
    L29:
        if ((r105 & 8) == 0) goto L32;
        this.parameters.setFilename(new String(readToNull(r103), "ISO-8859-1"));
    L32:
        if ((r105 & 16) == 0) goto L35;
        this.parameters.setComment(new String(readToNull(r103), "ISO-8859-1"));
    L35:
        if ((r105 & 2) == 0) goto L37;
        r103.readShort();
    L37:
        this.inf.reset();
        this.f525009crc.reset();
        return true;
    L21:
        this.parameters.setCompressionLevel(9);
        goto L22
    L40:
        throw new IOException("Reserved flags are set in the .gz header");
    L42:
        throw new IOException("Unsupported compression method " + r104 + " in the .gz header");
    L44:
        if (r100 == false) goto L46;
        String r109 = "Input is not in the .gz format";
    L48:
        throw new IOException(r109);
    L46:
        r109 = "Garbage after a valid .gz stream";
        goto L48
    }

    private static byte[] readToNull(DataInput r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
    L3:
        int r102 = r100.readUnsignedByte();
        if (r102 == 0) goto L7;
        r101.write(r102);
        goto L3
    L7:
        return r101.toByteArray();
    }

    public GzipCompressorInputStream(InputStream r100, boolean r101) throws IOException {
        this.buf = new byte[8192];
        this.inf = new Inflater(true);
        this.f525009crc = new CRC32();
        this.endReached = false;
        this.oneByte = new byte[1];
        this.parameters = new GzipParameters();
        CountingInputStream r102 = new CountingInputStream(r100);
        this.countingStream = r102;
        if (r102.markSupported() == false) goto L5;
        this.f525010in = r102;
    L6:
        this.decompressConcatenated = r101;
        init(true);
        return;
    L5:
        this.f525010in = new BufferedInputStream(r102);
        goto L6
    }

    @Override // java.io.InputStream
    public int read(byte[] r110, int r111, int r112) throws IOException {
        if (this.endReached == false) goto L5;
        return -1;
    L5:
        int r100 = 0;
    L6:
        if (r112 <= 0) goto L40;
        if (this.inf.needsInput() == false) goto L41;
        this.f525010in.mark(this.buf.length);
        int r101 = this.f525010in.read(this.buf);
        this.bufUsed = r101;
        if (r101 == (-1)) goto L13;
        this.inf.setInput(this.buf, 0, r101);
        goto L41
    L13:
        throw new EOFException();
    L41:
        int r102 = this.inf.inflate(r110, r111, r112);     // Catch: DataFormatException -> L38
        this.f525009crc.update(r110, r111, r102);
        r111 = r111 + r102;
        r112 = r112 - r102;
        r100 = r100 + r102;
        count(r102);
        if (this.inf.finished() == false) goto L6;
        this.f525010in.reset();
        long r103 = this.bufUsed - this.inf.getRemaining();
        if (IOUtils.skip(this.f525010in, r103) != r103) goto L37;
        this.bufUsed = 0;
        DataInputStream r104 = new DataInputStream(this.f525010in);
        if (ByteUtils.fromLittleEndian(r104, 4) != this.f525009crc.getValue()) goto L35;
        if (ByteUtils.fromLittleEndian(r104, 4) != (this.inf.getBytesWritten() & BodyPartID.bodyIdMax)) goto L33;
        if (this.decompressConcatenated == false) goto L27;
        if (init(false) == true) goto L6;
    L27:
        this.inf.end();
        this.inf = null;
        this.endReached = true;
        if (r100 != 0) goto L31;
        return -1;
    L31:
        return r100;
    L33:
        throw new IOException("Gzip-compressed data is corrupt(uncompressed size mismatch)");
    L35:
        throw new IOException("Gzip-compressed data is corrupt (CRC32 error)");
    L37:
        throw new IOException();
    L39:
        throw new IOException("Gzip-compressed data is corrupt");
    L40:
        return r100;
    }
}
