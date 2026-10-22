package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ExifOutputStream extends FilterOutputStream {
    private static final short BYTE_ALIGN_II = 18761;
    private static final short BYTE_ALIGN_MM = 19789;
    private static final boolean DEBUG = false;
    private static final byte[] IDENTIFIER_EXIF_APP1 = null;
    private static final int IFD_OFFSET = 8;
    private static final byte START_CODE = 42;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final String TAG = "ExifOutputStream";
    private final ByteBuffer mBuffer;
    private int mByteToCopy;
    private int mByteToSkip;
    private final ExifData mExifData;
    private final byte[] mSingleByteArray;
    private int mState;

    public static final class JpegHeader {
        public static final short APP1 = -31;
        public static final short DAC = -52;
        public static final short DHT = -60;
        public static final short EOI = -39;
        public static final short JPG = -56;
        public static final short SOF0 = -64;
        public static final short SOF15 = -49;
        public static final short SOI = -40;

        private JpegHeader() {
        }

        public static boolean isSofMarker(short r1) {
            if (r1 >= (-64)) goto L5;
        L13:
            return false;
        L5:
            if (r1 > (-49)) goto L13;
            if (r1 == (-60)) goto L13;
            if (r1 == (-56)) goto L13;
            if (r1 == (-52)) goto L13;
            return true;
        }
    }

    static {
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(ExifAttribute.ASCII);
    }

    private void writeExifSegment(ByteOrderedDataOutputStream r15) throws IOException {
        ExifTag[][] r0 = ExifData.EXIF_TAGS;
        int[] r1 = new int[r0.length];
        int[] r2 = new int[r0.length];
        ExifTag[] r3 = ExifData.EXIF_POINTER_TAGS;
        int r4 = r3.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L10;
        ExifTag r6 = r3[r5];
        int r7 = 0;
    L6:
        if (r7 >= ExifData.EXIF_TAGS.length) goto L8;
        this.mExifData.getAttributes(r7).remove(r6.name);
        r7 = r7 + 1;
        goto L6
    L8:
        r5 = r5 + 1;
        goto L3
    L10:
        if (this.mExifData.getAttributes(1).isEmpty() == true) goto L13;
        this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
    L13:
        if (this.mExifData.getAttributes(2).isEmpty() == true) goto L16;
        this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
    L16:
        if (this.mExifData.getAttributes(3).isEmpty() == true) goto L18;
        this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
    L18:
        int r8 = 0;
    L20:
        if (r8 >= ExifData.EXIF_TAGS.length) goto L28;
        Iterator<Map.Entry<String, ExifAttribute>> r9 = this.mExifData.getAttributes(r8).entrySet().iterator();
        int r11 = 0;
    L23:
        if (r9.hasNext() == false) goto L27;
        int r12 = r9.next().getValue().size();
        if (r12 <= 4) goto L23;
        r11 = r11 + r12;
        goto L23
    L27:
        r2[r8] = r2[r8] + r11;
        r8 = r8 + 1;
        goto L20
    L28:
        int r10 = 0;
        int r13 = 8;
    L30:
        if (r10 >= ExifData.EXIF_TAGS.length) goto L35;
        if (this.mExifData.getAttributes(r10).isEmpty() == true) goto L34;
        r1[r10] = r13;
        r13 = r13 + ((((this.mExifData.getAttributes(r10).size() * 12) + 2) + 4) + r2[r10]);
    L34:
        r10 = r10 + 1;
        goto L30
    L35:
        int r14 = r13 + 8;
        if (this.mExifData.getAttributes(1).isEmpty() == true) goto L39;
        this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(r1[1], this.mExifData.getByteOrder()));
    L39:
        if (this.mExifData.getAttributes(2).isEmpty() == true) goto L42;
        this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(r1[2], this.mExifData.getByteOrder()));
    L42:
        if (this.mExifData.getAttributes(3).isEmpty() == true) goto L44;
        this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(r1[3], this.mExifData.getByteOrder()));
    L44:
        r15.writeUnsignedShort(r14);
        r15.write(IDENTIFIER_EXIF_APP1);
        if (this.mExifData.getByteOrder() != ByteOrder.BIG_ENDIAN) goto L47;
        short r16 = BYTE_ALIGN_MM;
    L48:
        r15.writeShort(r16);
        r15.setByteOrder(this.mExifData.getByteOrder());
        r15.writeUnsignedShort(42);
        r15.writeUnsignedInt(8);
        int r17 = 0;
    L50:
        if (r17 >= ExifData.EXIF_TAGS.length) goto L70;
        if (this.mExifData.getAttributes(r17).isEmpty() == true) goto L69;
        r15.writeUnsignedShort(this.mExifData.getAttributes(r17).size());
        int r18 = ((r1[r17] + 2) + (this.mExifData.getAttributes(r17).size() * 12)) + 4;
        Iterator<Map.Entry<String, ExifAttribute>> r19 = this.mExifData.getAttributes(r17).entrySet().iterator();
    L55:
        if (r19.hasNext() == false) goto L63;
        Map.Entry<String, ExifAttribute> r20 = r19.next();
        int r21 = ((ExifTag) Preconditions.checkNotNull((ExifTag) ((HashMap) ListProtector.get(ExifData.Builder.sExifTagMapsForWriting, r17)).get(r20.getKey()), "Tag not supported: " + r20.getKey() + ". Tag needs to be ported from ExifInterface to ExifData.")).number;
        ExifAttribute r22 = r20.getValue();
        int r110 = r22.size();
        r15.writeUnsignedShort(r21);
        r15.writeUnsignedShort(r22.format);
        r15.writeInt(r22.numberOfComponents);
        if (r110 > 4) goto L58;
        r15.write(r22.bytes);
        if (r110 >= 4) goto L55;
    L61:
        if (r110 >= 4) goto L55;
        r15.writeByte(0);
        r110 = r110 + 1;
        goto L61
    L58:
        r15.writeUnsignedInt(r18);
        r18 = r18 + r110;
        goto L55
    L63:
        r15.writeUnsignedInt(0);
        Iterator<Map.Entry<String, ExifAttribute>> r23 = this.mExifData.getAttributes(r17).entrySet().iterator();
    L65:
        if (r23.hasNext() == false) goto L69;
        byte[] r24 = r23.next().getValue().bytes;
        if (r24.length <= 4) goto L65;
        r15.write(r24, 0, r24.length);
    L69:
        r17 = r17 + 1;
        goto L50
    L70:
        r15.setByteOrder(ByteOrder.BIG_ENDIAN);
        return;
    L47:
        r16 = BYTE_ALIGN_II;
        goto L48
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r3) throws IOException {
        byte[] r0 = this.mSingleByteArray;
        r0[0] = (byte) (r3 & 255);
        write(r0);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r3) throws IOException {
        write(r3, 0, r3.length);
    }

    public ExifOutputStream(OutputStream r3, ExifData r4) {
        super(new BufferedOutputStream(r3, STREAMBUFFER_SIZE));
        this.mSingleByteArray = new byte[1];
        this.mBuffer = ByteBuffer.allocate(4);
        this.mState = 0;
        this.mExifData = r4;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r7, int r8, int r9) throws IOException {
    L2:
        int r0 = this.mByteToSkip;
        if (r0 <= 0) goto L5;
    L8:
        if (r9 <= 0) goto L44;
        if (r0 <= 0) goto L11;
        int r1 = Math.min(r9, r0);
        r9 = r9 - r1;
        this.mByteToSkip -= r1;
        r8 = r8 + r1;
    L11:
        int r2 = this.mByteToCopy;
        if (r2 <= 0) goto L14;
        int r3 = Math.min(r9, r2);
        ((FilterOutputStream) this).out.write(r7, r8, r3);
        r9 = r9 - r3;
        this.mByteToCopy -= r3;
        r8 = r8 + r3;
    L14:
        if (r9 == 0) goto L15;
        int r4 = this.mState;
        if (r4 != 0) goto L18;
        int r5 = requestByteToBuffer(2, r7, r8, r9);
        r8 = r8 + r5;
        r9 = r9 - r5;
        if (this.mBuffer.position() < 2) goto L38;
        this.mBuffer.rewind();
        if (this.mBuffer.getShort() != (-40)) goto L43;
        ((FilterOutputStream) this).out.write(this.mBuffer.array(), 0, 2);
        this.mState = 1;
        this.mBuffer.rewind();
        ByteOrderedDataOutputStream r6 = new ByteOrderedDataOutputStream(((FilterOutputStream) this).out, ByteOrder.BIG_ENDIAN);
        r6.writeShort(-31);
        writeExifSegment(r6);
        goto L2
    L43:
        throw new IOException("Not a valid jpeg image, cannot write exif");
    L38:
        return;
    L18:
        if (r4 != 1) goto L2;
        int r10 = requestByteToBuffer(4, r7, r8, r9);
        r8 = r8 + r10;
        r9 = r9 - r10;
        if (this.mBuffer.position() != 2) goto L26;
        if (this.mBuffer.getShort() != (-39)) goto L26;
        ((FilterOutputStream) this).out.write(this.mBuffer.array(), 0, 2);
        this.mBuffer.rewind();
    L26:
        if (this.mBuffer.position() < 4) goto L27;
        this.mBuffer.rewind();
        short r11 = this.mBuffer.getShort();
        if (r11 != (-31)) goto L32;
        this.mByteToSkip = (this.mBuffer.getShort() & 65535) - 2;
        this.mState = 2;
    L35:
        this.mBuffer.rewind();
        goto L2
    L32:
        if (JpegHeader.isSofMarker(r11) == true) goto L34;
        ((FilterOutputStream) this).out.write(this.mBuffer.array(), 0, 4);
        this.mByteToCopy = (this.mBuffer.getShort() & 65535) - 2;
        goto L35
    L34:
        ((FilterOutputStream) this).out.write(this.mBuffer.array(), 0, 4);
        this.mState = 2;
        goto L35
    L27:
        return;
    L15:
        return;
    L44:
        if (r9 <= 0) goto L60;
        ((FilterOutputStream) this).out.write(r7, r8, r9);
        return;
    L60:
        return;
    L5:
        if (this.mByteToCopy > 0) goto L8;
        if (this.mState == 2) goto L44;
        goto L8
    }

    private int requestByteToBuffer(int r2, byte[] r3, int r4, int r5) {
        int r6 = Math.min(r5, r2 - this.mBuffer.position());
        this.mBuffer.put(r3, r4, r6);
        return r6;
    }
}
