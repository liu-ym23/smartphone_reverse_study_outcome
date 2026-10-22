package com.huawei.hms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel r100) {
        return a(r100, 20293);
    }

    private static int a(Parcel r100, int r101) {
        r100.writeInt(r101 | (-65536));
        r100.writeInt(0);
        return r100.dataPosition();
    }

    private static void b(Parcel r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = r100.dataPosition();
        r100.setDataPosition(r101 - 4);
        r100.writeInt(r102 - r101);
        r100.setDataPosition(r102);
    }

    public static void finishObjectHeader(Parcel r100, int r101) {
        b(r100, r101);
    }

    private static <P extends Parcelable> void a(Parcel r100, P r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r103 = r100.dataPosition();
        r100.writeInt(1);
        int r104 = r100.dataPosition();
        r101.writeToParcel(r100, r102);
        int r105 = r100.dataPosition();
        r100.setDataPosition(r103);
        r100.writeInt(r105 - r104);
        r100.setDataPosition(r105);
    }

    public static void writeBoolean(Parcel r100, int r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r100, r101, 4);
        if (r102 == false) goto L7;
        r100.writeInt(1);
        return;
    L7:
        r100.writeInt(0);
    }

    public static void writeByte(Parcel r100, int r101, byte r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r100, r101, 4);
        r100.writeInt(r102);
    }

    public static void writeChar(Parcel r100, int r101, char r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r100, r101, 4);
        r100.writeInt(r102);
    }

    public static void writeDouble(Parcel r100, int r101, double r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r100, r101, 8);
        r100.writeDouble(r102);
    }

    public static void writeFloat(Parcel r100, int r101, float r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r100, r101, 4);
        r100.writeFloat(r102);
    }

    public static void writeInt(Parcel r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r100, r101, 4);
        r100.writeInt(r102);
    }

    public static void writeLong(Parcel r100, int r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r100, r101, 8);
        r100.writeLong(r102);
    }

    public static void writeShort(Parcel r100, int r101, short r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r100, r101, 4);
        r100.writeInt(r102);
    }

    private static void a(Parcel r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 < 65535) goto L8;
        r100.writeInt(r101 | (-65536));
        r100.writeInt(r102);
        return;
    L8:
        r100.writeInt(r101 | (r102 << 16));
    }

    public static void writeBigDecimal(Parcel r100, int r101, BigDecimal r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeByteArray(r102.unscaledValue().toByteArray());
        r100.writeInt(r102.scale());
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeBigDecimalArray(Parcel r100, int r101, BigDecimal[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.length;
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeByteArray(r102[r104].unscaledValue().toByteArray());
        r100.writeInt(r102[r104].scale());
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeBigInteger(Parcel r100, int r101, BigInteger r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeByteArray(r102.toByteArray());
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeBigIntegerArray(Parcel r100, int r101, BigInteger[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.length;
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeByteArray(r102[r104].toByteArray());
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeBooleanArray(Parcel r100, int r101, boolean[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeBooleanArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeBooleanList(Parcel r100, int r101, List<Boolean> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(((Boolean) ListProtector.get(r102, r104)).booleanValue() ? 1 : 0);
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeBooleanObject(Parcel r100, int r101, Boolean r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        a(r100, r101, 4);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeBundle(Parcel r100, int r101, Bundle r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeBundle(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeByteArray(Parcel r100, int r101, byte[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeByteArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeByteArrayArray(Parcel r100, int r101, byte[][] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.length;
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeByteArray(r102[r104]);
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeByteArraySparseArray(Parcel r100, int r101, SparseArray<byte[]> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(r102.keyAt(r104));
        r100.writeByteArray(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeCharArray(Parcel r100, int r101, char[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeCharArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeDoubleArray(Parcel r100, int r101, double[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeDoubleArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeDoubleList(Parcel r100, int r101, List<Double> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeDouble(((Double) ListProtector.get(r102, r104)).doubleValue());
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeDoubleObject(Parcel r100, int r101, Double r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        a(r100, r101, 8);
        r100.writeDouble(r102.doubleValue());
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeDoubleSparseArray(Parcel r100, int r101, SparseArray<Double> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(r102.keyAt(r104));
        r100.writeDouble(r102.valueAt(r104).doubleValue());
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeFloatArray(Parcel r100, int r101, float[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeFloatArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeFloatList(Parcel r100, int r101, List<Float> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeFloat(((Float) ListProtector.get(r102, r104)).floatValue());
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeFloatObject(Parcel r100, int r101, Float r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        a(r100, r101, 4);
        r100.writeFloat(r102.floatValue());
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeFloatSparseArray(Parcel r100, int r101, SparseArray<Float> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(r102.keyAt(r104));
        r100.writeFloat(r102.valueAt(r104).floatValue());
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeIBinder(Parcel r100, int r101, IBinder r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeStrongBinder(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeIBinderArray(Parcel r100, int r101, IBinder[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeBinderArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeIBinderList(Parcel r100, int r101, List<IBinder> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeBinderList(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeIBinderSparseArray(Parcel r100, int r101, SparseArray<IBinder> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(r102.keyAt(r104));
        r100.writeStrongBinder(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeIntArray(Parcel r100, int r101, int[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeIntArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeIntegerList(Parcel r100, int r101, List<Integer> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(((Integer) ListProtector.get(r102, r104)).intValue());
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeIntegerObject(Parcel r100, int r101, Integer r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        a(r100, r101, 4);
        r100.writeInt(r102.intValue());
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeList(Parcel r100, int r101, List r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeList(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeLongArray(Parcel r100, int r101, long[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeLongArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeLongList(Parcel r100, int r101, List<Long> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeLong(((Long) ListProtector.get(r102, r104)).longValue());
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeLongObject(Parcel r100, int r101, Long r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        a(r100, r101, 8);
        r100.writeLong(r102.longValue());
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeParcel(Parcel r100, int r101, Parcel r102, boolean r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L7;
        int r104 = a(r100, r101);
        r100.appendFrom(r102, 0, r102.dataSize());
        b(r100, r104);
        return;
    L7:
        if (r103 == false) goto L11;
        a(r100, r101, 0);
        return;
    }

    public static void writeParcelArray(Parcel r100, int r101, Parcel[] r102, boolean r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L14;
        int r104 = a(r100, r101);
        int r105 = r102.length;
        r100.writeInt(r105);
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L13;
        Parcel r107 = r102[r106];
        if (r107 != null) goto L11;
        r100.writeInt(0);
    L12:
        r106 = r106 + 1;
        goto L7
    L11:
        r100.writeInt(r107.dataSize());
        Parcel r108 = r102[r106];
        r100.appendFrom(r108, 0, r108.dataSize());
        goto L12
    L13:
        b(r100, r104);
        return;
    L14:
        if (r103 == false) goto L21;
        a(r100, r101, 0);
        return;
    }

    public static void writeParcelList(Parcel r100, int r101, List<Parcel> r102, boolean r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L14;
        int r104 = a(r100, r101);
        int r105 = r102.size();
        r100.writeInt(r105);
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L13;
        Parcel r107 = (Parcel) ListProtector.get(r102, r106);
        if (r107 != null) goto L11;
        r100.writeInt(0);
    L12:
        r106 = r106 + 1;
        goto L7
    L11:
        r100.writeInt(r107.dataSize());
        r100.appendFrom(r107, 0, r107.dataSize());
        goto L12
    L13:
        b(r100, r104);
        return;
    L14:
        if (r103 == false) goto L21;
        a(r100, r101, 0);
        return;
    }

    public static void writeParcelSparseArray(Parcel r100, int r101, SparseArray<Parcel> r102, boolean r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L14;
        int r104 = a(r100, r101);
        int r105 = r102.size();
        r100.writeInt(r105);
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L13;
        r100.writeInt(r102.keyAt(r106));
        Parcel r107 = r102.valueAt(r106);
        if (r107 != null) goto L11;
        r100.writeInt(0);
    L12:
        r106 = r106 + 1;
        goto L7
    L11:
        r100.writeInt(r107.dataSize());
        r100.appendFrom(r107, 0, r107.dataSize());
        goto L12
    L13:
        b(r100, r104);
        return;
    L14:
        if (r103 == false) goto L21;
        a(r100, r101, 0);
        return;
    }

    public static void writeSparseBooleanArray(Parcel r100, int r101, SparseBooleanArray r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeSparseBooleanArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeSparseIntArray(Parcel r100, int r101, SparseIntArray r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(r102.keyAt(r104));
        r100.writeInt(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeSparseLongArray(Parcel r100, int r101, SparseLongArray r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(r102.keyAt(r104));
        r100.writeLong(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static void writeString(Parcel r100, int r101, String r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeString(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeStringArray(Parcel r100, int r101, String[] r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeStringArray(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeStringList(Parcel r100, int r101, List<String> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r104 = a(r100, r101);
        r100.writeStringList(r102);
        b(r100, r104);
        return;
    L6:
        if (r103 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static void writeStringSparseArray(Parcel r100, int r101, SparseArray<String> r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r104 = 0;
        if (r102 == null) goto L10;
        int r105 = a(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L7:
        if (r104 >= r106) goto L9;
        r100.writeInt(r102.keyAt(r104));
        r100.writeString(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L7
    L9:
        b(r100, r105);
        return;
    L10:
        if (r103 == false) goto L15;
        a(r100, r101, 0);
        return;
    }

    public static <T extends Parcelable> void writeTypedList(Parcel r100, int r101, List<T> r102, boolean r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L14;
        int r104 = a(r100, r101);
        int r105 = r102.size();
        r100.writeInt(r105);
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L13;
        Parcelable r107 = (Parcelable) ListProtector.get(r102, r106);
        if (r107 == null) goto L11;
        a(r100, r107, 0);
    L12:
        r106 = r106 + 1;
        goto L7
    L11:
        r100.writeInt(0);
        goto L12
    L13:
        b(r100, r104);
        return;
    L14:
        if (r103 == false) goto L21;
        a(r100, r101, 0);
        return;
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel r100, int r101, SparseArray<T> r102, boolean r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L14;
        int r104 = a(r100, r101);
        int r105 = r102.size();
        r100.writeInt(r105);
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L13;
        r100.writeInt(r102.keyAt(r106));
        T r107 = r102.valueAt(r106);
        if (r107 == null) goto L11;
        a(r100, r107, 0);
    L12:
        r106 = r106 + 1;
        goto L7
    L11:
        r100.writeInt(0);
        goto L12
    L13:
        b(r100, r104);
        return;
    L14:
        if (r103 == false) goto L21;
        a(r100, r101, 0);
        return;
    }

    public static void writeParcelable(Parcel r100, int r101, Parcelable r102, int r103, boolean r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L6;
        int r105 = a(r100, r101);
        r102.writeToParcel(r100, r103);
        b(r100, r105);
        return;
    L6:
        if (r104 == false) goto L10;
        a(r100, r101, 0);
        return;
    }

    public static <P extends Parcelable> void writeTypedArray(Parcel r100, int r101, P[] r102, int r103, boolean r104) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L14;
        int r105 = a(r100, r101);
        r100.writeInt(r105);
        int r106 = r102.length;
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L13;
        P r108 = r102[r107];
        if (r108 == null) goto L11;
        a(r100, r108, r103);
    L12:
        r107 = r107 + 1;
        goto L7
    L11:
        r100.writeInt(0);
        goto L12
    L13:
        b(r100, r105);
        return;
    L14:
        if (r104 == false) goto L21;
        a(r100, r101, 0);
        return;
    }
}
