package kotlin;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\u0087\b¨\u0006\u000b"}, d2 = {"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    public NumbersKt__NumbersKt() {
    }

    public static final byte rotateLeft(byte r100, int r101) {
        int r102 = r101 & 7;
        int r103 = r100 << r102;
        return (byte) (((r100 & 255) >>> (8 - r102)) | r103);
    }

    public static final short rotateLeft(short r100, int r101) {
        int r102 = r101 & 15;
        int r103 = r100 << r102;
        return (short) (((r100 & 65535) >>> (16 - r102)) | r103);
    }

    public static final byte rotateRight(byte r100, int r101) {
        int r102 = r101 & 7;
        int r103 = r100 << (8 - r102);
        return (byte) (((r100 & 255) >>> r102) | r103);
    }

    public static final short rotateRight(short r100, int r101) {
        int r102 = r101 & 15;
        int r103 = r100 << (16 - r102);
        return (short) (((r100 & 65535) >>> r102) | r103);
    }

    private static final int countLeadingZeroBits(short r100) {
        return Integer.numberOfLeadingZeros(r100 & 65535) - 16;
    }

    private static final int countOneBits(short r100) {
        return Integer.bitCount(r100 & 65535);
    }

    private static final int countTrailingZeroBits(short r100) {
        return Integer.numberOfTrailingZeros(r100 | 65536);
    }

    private static final short takeHighestOneBit(short r100) {
        return (short) Integer.highestOneBit(r100 & 65535);
    }

    private static final byte takeLowestOneBit(byte r100) {
        return (byte) Integer.lowestOneBit(r100);
    }

    private static final int countLeadingZeroBits(byte r100) {
        return Integer.numberOfLeadingZeros(r100 & UByte.MAX_VALUE) - 24;
    }

    private static final int countOneBits(byte r100) {
        return Integer.bitCount(r100 & UByte.MAX_VALUE);
    }

    private static final int countTrailingZeroBits(byte r100) {
        return Integer.numberOfTrailingZeros(r100 | 256);
    }

    private static final byte takeHighestOneBit(byte r100) {
        return (byte) Integer.highestOneBit(r100 & UByte.MAX_VALUE);
    }

    private static final short takeLowestOneBit(short r100) {
        return (short) Integer.lowestOneBit(r100);
    }
}
