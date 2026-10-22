package com.ss.android.socialbase.appdownloader.util.parser.zip;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes38.dex */
class Simple8BitZipEncoding implements ZipEncoding {
    private final char[] highChars;
    private final List<Simple8BitChar> reverseMapping;

    public static final class Simple8BitChar implements Comparable<Simple8BitChar> {
        public final byte code;
        public final char unicode;

        public String toString() {
            return "0x" + Integer.toHexString(65535 & this.unicode) + "->0x" + Integer.toHexString(this.code & UByte.MAX_VALUE);
        }

        public int hashCode() {
            return this.unicode;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Simple8BitChar r100) {
            return compareTo2(r100);
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Simple8BitChar) == false) goto L10;
            Simple8BitChar r101 = (Simple8BitChar) r100;
            if (this.unicode == r101.unicode) goto L7;
            return false;
        L7:
            if (this.code != r101.code) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Simple8BitChar r100) {
            return this.unicode - r100.unicode;
        }

        public Simple8BitChar(byte r100, char r101) {
            this.code = r100;
            this.unicode = r101;
        }
    }

    public Simple8BitZipEncoding(char[] r100) {
        char[] r101 = (char[]) r100.clone();
        this.highChars = r101;
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        byte r104 = ByteCompanionObject.MAX_VALUE;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r104 = (byte) (r104 + 1);
        r102.add(new Simple8BitChar(r104, r101[r105]));
        r105 = r105 + 1;
        goto L3
    L5:
        Collections.sort(r102);
        this.reverseMapping = Collections.unmodifiableList(r102);
    }

    private Simple8BitChar encodeHighChar(char r100) {
        int r101 = this.reverseMapping.size();
        int r102 = 0;
    L3:
        if (r101 <= r102) goto L11;
        int r103 = ((r101 - r102) / 2) + r102;
        Simple8BitChar r104 = (Simple8BitChar) ListProtector.get(this.reverseMapping, r103);
        char r105 = r104.unicode;
        if (r105 == r100) goto L6;
        if (r105 < r100) goto L8;
        r101 = r103;
        goto L3
    L8:
        r102 = r103 + 1;
        goto L3
    L6:
        return r104;
    L11:
        if (r102 < this.reverseMapping.size()) goto L13;
        return null;
    L13:
        Simple8BitChar r106 = (Simple8BitChar) ListProtector.get(this.reverseMapping, r102);
        if (r106.unicode == r100) goto L16;
        return null;
    L16:
        return r106;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public boolean canEncode(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L9;
        if (canEncodeChar(r100.charAt(r101)) == false) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public boolean canEncodeChar(char r100) {
        if (r100 < 0) goto L8;
        if (r100 >= 128) goto L8;
        return true;
    L8:
        if (encodeHighChar(r100) != null) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public String decode(byte[] r100) throws IOException {
        char[] r101 = new char[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = decodeByte(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L7:
        return new String(r101);
    }

    public char decodeByte(byte r100) {
        if (r100 < 0) goto L6;
        return (char) r100;
    L6:
        return this.highChars[r100 + ByteCompanionObject.MIN_VALUE];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEncoding
    public ByteBuffer encode(String r100) {
        ByteBuffer r101 = ByteBuffer.allocate((r100.length() + 6) + ((r100.length() + 1) / 2));
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L12;
        char r103 = r100.charAt(r102);
        if (r101.remaining() >= 6) goto L9;
        r101 = ZipEncodingHelper.growBuffer(r101, r101.position() + 6);
    L9:
        if (pushEncodedChar(r101, r103) == true) goto L11;
        ZipEncodingHelper.appendSurrogate(r101, r103);
    L11:
        r102 = r102 + 1;
        goto L4
    L12:
        ZipEncodingHelper.prepareBufferForRead(r101);
        return r101;
    }

    public boolean pushEncodedChar(ByteBuffer r100, char r101) {
        if (r101 >= 0) goto L5;
    L8:
        Simple8BitChar r102 = encodeHighChar(r101);
        if (r102 != null) goto L12;
        return false;
    L12:
        r100.put(r102.code);
        return true;
    L5:
        if (r101 >= 128) goto L8;
        r100.put((byte) r101);
        return true;
    }
}
