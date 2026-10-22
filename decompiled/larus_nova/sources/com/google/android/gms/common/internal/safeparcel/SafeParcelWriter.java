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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel r100) {
        return zza(r100, 20293);
    }

    public static void finishObjectHeader(Parcel r100, int r101) {
        zzb(r100, r101);
    }

    private static int zza(Parcel r100, int r101) {
        r100.writeInt(r101 | (-65536));
        r100.writeInt(0);
        return r100.dataPosition();
    }

    private static void zzb(Parcel r100, int r101) {
        int r102 = r100.dataPosition();
        r100.setDataPosition(r101 - 4);
        r100.writeInt(r102 - r101);
        r100.setDataPosition(r102);
    }

    public static void writeBoolean(Parcel r100, int r101, boolean r102) {
        zzc(r100, r101, 4);
        r100.writeInt(r102 ? 1 : 0);
    }

    public static void writeByte(Parcel r100, int r101, byte r102) {
        zzc(r100, r101, 4);
        r100.writeInt(r102);
    }

    public static void writeChar(Parcel r100, int r101, char r102) {
        zzc(r100, r101, 4);
        r100.writeInt(r102);
    }

    public static void writeDouble(Parcel r100, int r101, double r102) {
        zzc(r100, r101, 8);
        r100.writeDouble(r102);
    }

    public static void writeFloat(Parcel r100, int r101, float r102) {
        zzc(r100, r101, 4);
        r100.writeFloat(r102);
    }

    public static void writeInt(Parcel r100, int r101, int r102) {
        zzc(r100, r101, 4);
        r100.writeInt(r102);
    }

    public static void writeLong(Parcel r100, int r101, long r102) {
        zzc(r100, r101, 8);
        r100.writeLong(r102);
    }

    public static void writeShort(Parcel r100, int r101, short r102) {
        zzc(r100, r101, 4);
        r100.writeInt(r102);
    }

    private static void zzc(Parcel r100, int r101, int r102) {
        r100.writeInt(r101 | (r102 << 16));
    }

    private static void zzd(Parcel r100, Parcelable r101, int r102) {
        int r103 = r100.dataPosition();
        r100.writeInt(1);
        int r104 = r100.dataPosition();
        r101.writeToParcel(r100, r102);
        int r105 = r100.dataPosition();
        r100.setDataPosition(r103);
        r100.writeInt(r105 - r104);
        r100.setDataPosition(r105);
    }

    public static void writeBigDecimal(Parcel r100, int r101, BigDecimal r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeByteArray(r102.unscaledValue().toByteArray());
        r100.writeInt(r102.scale());
        zzb(r100, r104);
    }

    public static void writeBigDecimalArray(Parcel r100, int r101, BigDecimal[] r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.length;
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeByteArray(r102[r104].unscaledValue().toByteArray());
        r100.writeInt(r102[r104].scale());
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeBigInteger(Parcel r100, int r101, BigInteger r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeByteArray(r102.toByteArray());
        zzb(r100, r104);
    }

    public static void writeBigIntegerArray(Parcel r100, int r101, BigInteger[] r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.length;
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeByteArray(r102[r104].toByteArray());
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeBooleanArray(Parcel r100, int r101, boolean[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeBooleanArray(r102);
        zzb(r100, r104);
    }

    public static void writeBooleanList(Parcel r100, int r101, List<Boolean> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(((Boolean) ListProtector.get(r102, r104)).booleanValue() ? 1 : 0);
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeBooleanObject(Parcel r100, int r101, Boolean r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        zzc(r100, r101, 4);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
    }

    public static void writeBundle(Parcel r100, int r101, Bundle r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeBundle(r102);
        zzb(r100, r104);
    }

    public static void writeByteArray(Parcel r100, int r101, byte[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeByteArray(r102);
        zzb(r100, r104);
    }

    public static void writeByteArrayArray(Parcel r100, int r101, byte[][] r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.length;
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeByteArray(r102[r104]);
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeByteArraySparseArray(Parcel r100, int r101, SparseArray<byte[]> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(r102.keyAt(r104));
        r100.writeByteArray(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeCharArray(Parcel r100, int r101, char[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeCharArray(r102);
        zzb(r100, r104);
    }

    public static void writeDoubleArray(Parcel r100, int r101, double[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeDoubleArray(r102);
        zzb(r100, r104);
    }

    public static void writeDoubleList(Parcel r100, int r101, List<Double> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeDouble(((Double) ListProtector.get(r102, r104)).doubleValue());
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeDoubleObject(Parcel r100, int r101, Double r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        zzc(r100, r101, 8);
        r100.writeDouble(r102.doubleValue());
    }

    public static void writeDoubleSparseArray(Parcel r100, int r101, SparseArray<Double> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(r102.keyAt(r104));
        r100.writeDouble(r102.valueAt(r104).doubleValue());
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeFloatArray(Parcel r100, int r101, float[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeFloatArray(r102);
        zzb(r100, r104);
    }

    public static void writeFloatList(Parcel r100, int r101, List<Float> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeFloat(((Float) ListProtector.get(r102, r104)).floatValue());
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeFloatObject(Parcel r100, int r101, Float r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        zzc(r100, r101, 4);
        r100.writeFloat(r102.floatValue());
    }

    public static void writeFloatSparseArray(Parcel r100, int r101, SparseArray<Float> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(r102.keyAt(r104));
        r100.writeFloat(r102.valueAt(r104).floatValue());
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeIBinder(Parcel r100, int r101, IBinder r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeStrongBinder(r102);
        zzb(r100, r104);
    }

    public static void writeIBinderArray(Parcel r100, int r101, IBinder[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeBinderArray(r102);
        zzb(r100, r104);
    }

    public static void writeIBinderList(Parcel r100, int r101, List<IBinder> r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeBinderList(r102);
        zzb(r100, r104);
    }

    public static void writeIBinderSparseArray(Parcel r100, int r101, SparseArray<IBinder> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(r102.keyAt(r104));
        r100.writeStrongBinder(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeIntArray(Parcel r100, int r101, int[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeIntArray(r102);
        zzb(r100, r104);
    }

    public static void writeIntegerList(Parcel r100, int r101, List<Integer> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(((Integer) ListProtector.get(r102, r104)).intValue());
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeIntegerObject(Parcel r100, int r101, Integer r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        zzc(r100, r101, 4);
        r100.writeInt(r102.intValue());
    }

    public static void writeList(Parcel r100, int r101, List r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeList(r102);
        zzb(r100, r104);
    }

    public static void writeLongArray(Parcel r100, int r101, long[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeLongArray(r102);
        zzb(r100, r104);
    }

    public static void writeLongList(Parcel r100, int r101, List<Long> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeLong(((Long) ListProtector.get(r102, r104)).longValue());
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeLongObject(Parcel r100, int r101, Long r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        zzc(r100, r101, 8);
        r100.writeLong(r102.longValue());
    }

    public static void writeParcel(Parcel r100, int r101, Parcel r102, boolean r103) {
        if (r102 != null) goto L7;
        if (r103 == false) goto L9;
        zzc(r100, r101, 0);
        return;
    L9:
        return;
    L7:
        int r104 = zza(r100, r101);
        r100.appendFrom(r102, 0, r102.dataSize());
        zzb(r100, r104);
    }

    public static void writeParcelArray(Parcel r100, int r101, Parcel[] r102, boolean r103) {
        if (r102 != null) goto L7;
        if (r103 == false) goto L19;
        zzc(r100, r101, 0);
        return;
    L19:
        return;
    L7:
        int r104 = zza(r100, r101);
        int r105 = r102.length;
        r100.writeInt(r105);
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L14;
        Parcel r107 = r102[r106];
        if (r107 == null) goto L12;
        r100.writeInt(r107.dataSize());
        r100.appendFrom(r107, 0, r107.dataSize());
    L13:
        r106 = r106 + 1;
        goto L8
    L12:
        r100.writeInt(0);
        goto L13
    L14:
        zzb(r100, r104);
    }

    public static void writeParcelList(Parcel r100, int r101, List<Parcel> r102, boolean r103) {
        if (r102 != null) goto L7;
        if (r103 == false) goto L19;
        zzc(r100, r101, 0);
        return;
    L19:
        return;
    L7:
        int r104 = zza(r100, r101);
        int r105 = r102.size();
        r100.writeInt(r105);
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L14;
        Parcel r107 = (Parcel) ListProtector.get(r102, r106);
        if (r107 == null) goto L12;
        r100.writeInt(r107.dataSize());
        r100.appendFrom(r107, 0, r107.dataSize());
    L13:
        r106 = r106 + 1;
        goto L8
    L12:
        r100.writeInt(0);
        goto L13
    L14:
        zzb(r100, r104);
    }

    public static void writeParcelSparseArray(Parcel r100, int r101, SparseArray<Parcel> r102, boolean r103) {
        if (r102 != null) goto L7;
        if (r103 == false) goto L19;
        zzc(r100, r101, 0);
        return;
    L19:
        return;
    L7:
        int r104 = zza(r100, r101);
        int r105 = r102.size();
        r100.writeInt(r105);
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L14;
        r100.writeInt(r102.keyAt(r106));
        Parcel r107 = r102.valueAt(r106);
        if (r107 == null) goto L12;
        r100.writeInt(r107.dataSize());
        r100.appendFrom(r107, 0, r107.dataSize());
    L13:
        r106 = r106 + 1;
        goto L8
    L12:
        r100.writeInt(0);
        goto L13
    L14:
        zzb(r100, r104);
    }

    public static void writePendingIntent(Parcel r100, int r101, PendingIntent r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        PendingIntent.writePendingIntentOrNullToParcel(r102, r100);
        zzb(r100, r104);
    }

    public static void writeSparseBooleanArray(Parcel r100, int r101, SparseBooleanArray r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeSparseBooleanArray(r102);
        zzb(r100, r104);
    }

    public static void writeSparseIntArray(Parcel r100, int r101, SparseIntArray r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(r102.keyAt(r104));
        r100.writeInt(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeSparseLongArray(Parcel r100, int r101, SparseLongArray r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(r102.keyAt(r104));
        r100.writeLong(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static void writeString(Parcel r100, int r101, String r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeString(r102);
        zzb(r100, r104);
    }

    public static void writeStringArray(Parcel r100, int r101, String[] r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeStringArray(r102);
        zzb(r100, r104);
    }

    public static void writeStringList(Parcel r100, int r101, List<String> r102, boolean r103) {
        if (r102 != null) goto L6;
        if (r103 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r104 = zza(r100, r101);
        r100.writeStringList(r102);
        zzb(r100, r104);
    }

    public static void writeStringSparseArray(Parcel r100, int r101, SparseArray<String> r102, boolean r103) {
        int r104 = 0;
        if (r102 != null) goto L7;
        if (r103 == false) goto L13;
        zzc(r100, r101, 0);
        return;
    L13:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.size();
        r100.writeInt(r106);
    L8:
        if (r104 >= r106) goto L10;
        r100.writeInt(r102.keyAt(r104));
        r100.writeString(r102.valueAt(r104));
        r104 = r104 + 1;
        goto L8
    L10:
        zzb(r100, r105);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel r100, int r101, List<T> r102, boolean r103) {
        if (r102 != null) goto L7;
        if (r103 == false) goto L19;
        zzc(r100, r101, 0);
        return;
    L19:
        return;
    L7:
        int r104 = zza(r100, r101);
        int r105 = r102.size();
        r100.writeInt(r105);
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L14;
        Parcelable r107 = (Parcelable) ListProtector.get(r102, r106);
        if (r107 != null) goto L12;
        r100.writeInt(0);
    L13:
        r106 = r106 + 1;
        goto L8
    L12:
        zzd(r100, r107, 0);
        goto L13
    L14:
        zzb(r100, r104);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel r100, int r101, SparseArray<T> r102, boolean r103) {
        if (r102 != null) goto L7;
        if (r103 == false) goto L19;
        zzc(r100, r101, 0);
        return;
    L19:
        return;
    L7:
        int r104 = zza(r100, r101);
        int r105 = r102.size();
        r100.writeInt(r105);
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L14;
        r100.writeInt(r102.keyAt(r106));
        T r107 = r102.valueAt(r106);
        if (r107 != null) goto L12;
        r100.writeInt(0);
    L13:
        r106 = r106 + 1;
        goto L8
    L12:
        zzd(r100, r107, 0);
        goto L13
    L14:
        zzb(r100, r104);
    }

    public static void writeParcelable(Parcel r100, int r101, Parcelable r102, int r103, boolean r104) {
        if (r102 != null) goto L6;
        if (r104 == false) goto L8;
        zzc(r100, r101, 0);
        return;
    L8:
        return;
    L6:
        int r105 = zza(r100, r101);
        r102.writeToParcel(r100, r103);
        zzb(r100, r105);
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel r100, int r101, T[] r102, int r103, boolean r104) {
        if (r102 != null) goto L7;
        if (r104 == false) goto L19;
        zzc(r100, r101, 0);
        return;
    L19:
        return;
    L7:
        int r105 = zza(r100, r101);
        int r106 = r102.length;
        r100.writeInt(r106);
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L14;
        T r108 = r102[r107];
        if (r108 != null) goto L12;
        r100.writeInt(0);
    L13:
        r107 = r107 + 1;
        goto L8
    L12:
        zzd(r100, r108, r103);
        goto L13
    L14:
        zzb(r100, r105);
    }
}
