package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String r100, Parcel r101) {
            super(r100 + " Parcel: pos=" + r101.dataPosition() + " size=" + r101.dataSize());
        }
    }

    private SafeParcelReader() {
    }

    public static int getFieldId(int r100) {
        return (char) r100;
    }

    public static int readHeader(Parcel r100) {
        return r100.readInt();
    }

    public static int validateObjectHeader(Parcel r100) {
        int r101 = readHeader(r100);
        int r102 = readSize(r100, r101);
        int r103 = getFieldId(r101);
        int r104 = r100.dataPosition();
        if (r103 != 20293) goto L12;
        int r105 = r102 + r104;
        if (r105 < r104) goto L10;
        if (r105 > r100.dataSize()) goto L10;
        return r105;
    L10:
        throw new ParseException("Size read is invalid start=" + r104 + " end=" + r105, r100);
    L12:
        throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(r101))), r100);
    }

    public static BigDecimal createBigDecimal(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        byte[] r104 = r100.createByteArray();
        int r105 = r100.readInt();
        r100.setDataPosition(r103 + r102);
        return new BigDecimal(new BigInteger(r104), r105);
    }

    public static BigDecimal[] createBigDecimalArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        int r104 = r100.readInt();
        BigDecimal[] r105 = new BigDecimal[r104];
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L9;
        byte[] r107 = r100.createByteArray();
        int r108 = r100.readInt();
        r105[r106] = new BigDecimal(new BigInteger(r107), r108);
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r105;
    }

    public static BigInteger createBigInteger(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        byte[] r104 = r100.createByteArray();
        r100.setDataPosition(r103 + r102);
        return new BigInteger(r104);
    }

    public static BigInteger[] createBigIntegerArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        int r104 = r100.readInt();
        BigInteger[] r105 = new BigInteger[r104];
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L9;
        r105[r106] = new BigInteger(r100.createByteArray());
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r105;
    }

    public static boolean[] createBooleanArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        boolean[] r104 = r100.createBooleanArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static ArrayList<Boolean> createBooleanList(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        ArrayList<Boolean> r104 = new ArrayList();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L13;
        if (r100.readInt() == 0) goto L11;
        boolean r107 = true;
    L12:
        r104.add(Boolean.valueOf(r107));
        r106 = r106 + 1;
        goto L7
    L11:
        r107 = false;
        goto L12
    L13:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static Bundle createBundle(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        Bundle r104 = r100.readBundle();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static byte[] createByteArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        byte[] r104 = r100.createByteArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static byte[][] createByteArrayArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        int r104 = r100.readInt();
        byte[][] r105 = new byte[r104][];
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L9;
        r105[r106] = r100.createByteArray();
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r105;
    }

    public static SparseArray<byte[]> createByteArraySparseArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        int r104 = r100.readInt();
        SparseArray<byte[]> r105 = new SparseArray(r104);
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L9;
        r105.append(r100.readInt(), r100.createByteArray());
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r105;
    }

    public static char[] createCharArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        char[] r104 = r100.createCharArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static double[] createDoubleArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        double[] r104 = r100.createDoubleArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static ArrayList<Double> createDoubleList(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        ArrayList<Double> r104 = new ArrayList();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.add(Double.valueOf(r100.readDouble()));
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static SparseArray<Double> createDoubleSparseArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        SparseArray<Double> r104 = new SparseArray();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.append(r100.readInt(), Double.valueOf(r100.readDouble()));
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static float[] createFloatArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        float[] r104 = r100.createFloatArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static ArrayList<Float> createFloatList(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        ArrayList<Float> r104 = new ArrayList();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.add(Float.valueOf(r100.readFloat()));
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static SparseArray<Float> createFloatSparseArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        SparseArray<Float> r104 = new SparseArray();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.append(r100.readInt(), Float.valueOf(r100.readFloat()));
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static IBinder[] createIBinderArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        IBinder[] r104 = r100.createBinderArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static ArrayList<IBinder> createIBinderList(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        ArrayList<IBinder> r104 = r100.createBinderArrayList();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static SparseArray<IBinder> createIBinderSparseArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        int r104 = r100.readInt();
        SparseArray<IBinder> r105 = new SparseArray(r104);
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L9;
        r105.append(r100.readInt(), r100.readStrongBinder());
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r105;
    }

    public static int[] createIntArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        int[] r104 = r100.createIntArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static ArrayList<Integer> createIntegerList(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        ArrayList<Integer> r104 = new ArrayList();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.add(Integer.valueOf(r100.readInt()));
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static long[] createLongArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        long[] r104 = r100.createLongArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static ArrayList<Long> createLongList(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        ArrayList<Long> r104 = new ArrayList();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.add(Long.valueOf(r100.readLong()));
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static Parcel createParcel(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        Parcel r104 = Parcel.obtain();
        r104.appendFrom(r100, r103, r102);
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static Parcel[] createParcelArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L5;
        return null;
    L5:
        int r104 = r100.readInt();
        Parcel[] r105 = new Parcel[r104];
        int r106 = 0;
    L6:
        if (r106 >= r104) goto L12;
        int r107 = r100.readInt();
        if (r107 == 0) goto L10;
        int r108 = r100.dataPosition();
        Parcel r109 = Parcel.obtain();
        r109.appendFrom(r100, r108, r107);
        r105[r106] = r109;
        r100.setDataPosition(r108 + r107);
    L11:
        r106 = r106 + 1;
        goto L6
    L10:
        r105[r106] = null;
        goto L11
    L12:
        r100.setDataPosition(r103 + r102);
        return r105;
    }

    public static ArrayList<Parcel> createParcelList(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L5;
        return null;
    L5:
        int r104 = r100.readInt();
        ArrayList<Parcel> r105 = new ArrayList();
        int r106 = 0;
    L6:
        if (r106 >= r104) goto L12;
        int r107 = r100.readInt();
        if (r107 == 0) goto L10;
        int r108 = r100.dataPosition();
        Parcel r109 = Parcel.obtain();
        r109.appendFrom(r100, r108, r107);
        r105.add(r109);
        r100.setDataPosition(r108 + r107);
    L11:
        r106 = r106 + 1;
        goto L6
    L10:
        r105.add(null);
        goto L11
    L12:
        r100.setDataPosition(r103 + r102);
        return r105;
    }

    public static SparseArray<Parcel> createParcelSparseArray(Parcel r100, int r110) {
        int r111 = readSize(r100, r110);
        int r101 = r100.dataPosition();
        if (r111 != 0) goto L5;
        return null;
    L5:
        int r102 = r100.readInt();
        SparseArray<Parcel> r103 = new SparseArray();
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L12;
        int r105 = r100.readInt();
        int r106 = r100.readInt();
        if (r106 == 0) goto L10;
        int r107 = r100.dataPosition();
        Parcel r108 = Parcel.obtain();
        r108.appendFrom(r100, r107, r106);
        r103.append(r105, r108);
        r100.setDataPosition(r107 + r106);
    L11:
        r104 = r104 + 1;
        goto L6
    L10:
        r103.append(r105, null);
        goto L11
    L12:
        r100.setDataPosition(r101 + r111);
        return r103;
    }

    public static SparseBooleanArray createSparseBooleanArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        SparseBooleanArray r104 = r100.readSparseBooleanArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static SparseIntArray createSparseIntArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        SparseIntArray r104 = new SparseIntArray();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.append(r100.readInt(), r100.readInt());
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static SparseLongArray createSparseLongArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        SparseLongArray r104 = new SparseLongArray();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.append(r100.readInt(), r100.readLong());
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static String createString(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        String r104 = r100.readString();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static String[] createStringArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        String[] r104 = r100.createStringArray();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static ArrayList<String> createStringList(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        ArrayList<String> r104 = r100.createStringArrayList();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static SparseArray<String> createStringSparseArray(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        SparseArray<String> r104 = new SparseArray();
        int r105 = r100.readInt();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104.append(r100.readInt(), r100.readString());
        r106 = r106 + 1;
        goto L7
    L9:
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static void ensureAtEnd(Parcel r100, int r101) {
        if (r100.dataPosition() != r101) goto L6;
        return;
    L6:
        throw new ParseException("Overread allowed size end=" + r101, r100);
    }

    public static boolean readBoolean(Parcel r100, int r101) {
        zzb(r100, r101, 4);
        if (r100.readInt() == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static Boolean readBooleanObject(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        if (r102 != 0) goto L6;
        return null;
    L6:
        zza(r100, r101, r102, 4);
        if (r100.readInt() == 0) goto L9;
        boolean r103 = true;
    L11:
        return Boolean.valueOf(r103);
    L9:
        r103 = false;
        goto L11
    }

    public static byte readByte(Parcel r100, int r101) {
        zzb(r100, r101, 4);
        return (byte) r100.readInt();
    }

    public static char readChar(Parcel r100, int r101) {
        zzb(r100, r101, 4);
        return (char) r100.readInt();
    }

    public static double readDouble(Parcel r100, int r101) {
        zzb(r100, r101, 8);
        return r100.readDouble();
    }

    public static Double readDoubleObject(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        if (r102 != 0) goto L6;
        return null;
    L6:
        zza(r100, r101, r102, 8);
        return Double.valueOf(r100.readDouble());
    }

    public static float readFloat(Parcel r100, int r101) {
        zzb(r100, r101, 4);
        return r100.readFloat();
    }

    public static Float readFloatObject(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        if (r102 != 0) goto L6;
        return null;
    L6:
        zza(r100, r101, r102, 4);
        return Float.valueOf(r100.readFloat());
    }

    public static IBinder readIBinder(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        IBinder r104 = r100.readStrongBinder();
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static int readInt(Parcel r100, int r101) {
        zzb(r100, r101, 4);
        return r100.readInt();
    }

    public static Integer readIntegerObject(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        if (r102 != 0) goto L6;
        return null;
    L6:
        zza(r100, r101, r102, 4);
        return Integer.valueOf(r100.readInt());
    }

    public static long readLong(Parcel r100, int r101) {
        zzb(r100, r101, 8);
        return r100.readLong();
    }

    public static Long readLongObject(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        if (r102 != 0) goto L6;
        return null;
    L6:
        zza(r100, r101, r102, 8);
        return Long.valueOf(r100.readLong());
    }

    public static PendingIntent readPendingIntent(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        int r103 = r100.dataPosition();
        if (r102 != 0) goto L6;
        return null;
    L6:
        PendingIntent r104 = PendingIntent.readPendingIntentOrNullFromParcel(r100);
        r100.setDataPosition(r103 + r102);
        return r104;
    }

    public static short readShort(Parcel r100, int r101) {
        zzb(r100, r101, 4);
        return (short) r100.readInt();
    }

    public static int readSize(Parcel r100, int r101) {
        if ((r101 & (-65536)) == (-65536)) goto L7;
        return (char) (r101 >> 16);
    L7:
        return r100.readInt();
    }

    public static void skipUnknownField(Parcel r100, int r101) {
        int r102 = readSize(r100, r101);
        r100.setDataPosition(r100.dataPosition() + r102);
    }

    public static <T extends Parcelable> T createParcelable(Parcel r100, int r101, Parcelable.Creator<T> r102) {
        int r103 = readSize(r100, r101);
        int r104 = r100.dataPosition();
        if (r103 != 0) goto L6;
        return null;
    L6:
        T r105 = r102.createFromParcel(r100);
        r100.setDataPosition(r104 + r103);
        return r105;
    }

    public static <T> T[] createTypedArray(Parcel r100, int r101, Parcelable.Creator<T> r102) {
        int r103 = readSize(r100, r101);
        int r104 = r100.dataPosition();
        if (r103 != 0) goto L6;
        return null;
    L6:
        T[] r105 = (T[]) r100.createTypedArray(r102);
        r100.setDataPosition(r104 + r103);
        return r105;
    }

    public static <T> ArrayList<T> createTypedList(Parcel r100, int r101, Parcelable.Creator<T> r102) {
        int r103 = readSize(r100, r101);
        int r104 = r100.dataPosition();
        if (r103 != 0) goto L6;
        return null;
    L6:
        ArrayList<T> r105 = r100.createTypedArrayList(r102);
        r100.setDataPosition(r104 + r103);
        return r105;
    }

    public static <T> SparseArray<T> createTypedSparseArray(Parcel r100, int r101, Parcelable.Creator<T> r102) {
        int r103 = readSize(r100, r101);
        int r104 = r100.dataPosition();
        if (r103 != 0) goto L5;
        return null;
    L5:
        int r105 = r100.readInt();
        SparseArray<T> r106 = new SparseArray();
        int r107 = 0;
    L6:
        if (r107 >= r105) goto L12;
        int r108 = r100.readInt();
        if (r100.readInt() == 0) goto L10;
        T r109 = r102.createFromParcel(r100);
    L11:
        r106.append(r108, r109);
        r107 = r107 + 1;
        goto L6
    L10:
        r109 = null;
        goto L11
    L12:
        r100.setDataPosition(r104 + r103);
        return r106;
    }

    private static void zzb(Parcel r100, int r101, int r102) {
        int r103 = readSize(r100, r101);
        if (r103 != r102) goto L6;
        return;
    L6:
        throw new ParseException("Expected size " + r102 + " got " + r103 + " (0x" + Integer.toHexString(r103) + ")", r100);
    }

    public static void readList(Parcel r100, int r101, List r102, ClassLoader r103) {
        int r104 = readSize(r100, r101);
        int r105 = r100.dataPosition();
        if (r104 != 0) goto L5;
        return;
    L5:
        r100.readList(r102, r103);
        r100.setDataPosition(r105 + r104);
    }

    private static void zza(Parcel r100, int r101, int r102, int r103) {
        if (r102 != r103) goto L5;
        return;
    L5:
        throw new ParseException("Expected size " + r103 + " got " + r102 + " (0x" + Integer.toHexString(r102) + ")", r100);
    }
}
