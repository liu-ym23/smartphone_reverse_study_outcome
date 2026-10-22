package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.google.common.base.j;
import com.google.common.base.m;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)});
    }

    public double max() {
        if (this.count == 0) goto L5;
        boolean r100 = true;
    L6:
        m.o(r100);
        return this.max;
    L5:
        r100 = false;
        goto L6
    }

    public double mean() {
        if (this.count == 0) goto L5;
        boolean r100 = true;
    L6:
        m.o(r100);
        return this.mean;
    L5:
        r100 = false;
        goto L6
    }

    public double min() {
        if (this.count == 0) goto L5;
        boolean r100 = true;
    L6:
        m.o(r100);
        return this.min;
    L5:
        r100 = false;
        goto L6
    }

    public double populationVariance() {
        if (this.count <= 0) goto L5;
        boolean r100 = true;
    L6:
        m.o(r100);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        if (this.count != 1) goto L13;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L13:
        double r101 = this.sumOfSquaresOfDeltas;
        m.b(!Double.isNaN(r101));
        return Math.max(r101, AudioStats.AUDIO_AMPLITUDE_NONE) / count();
    L5:
        r100 = false;
        goto L6
    }

    public double sampleVariance() {
        if (this.count <= 1) goto L5;
        boolean r100 = true;
    L6:
        m.o(r100);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L10;
        return Double.NaN;
    L10:
        double r101 = this.sumOfSquaresOfDeltas;
        m.b(true ^ Double.isNaN(r101));
        return Math.max(r101, AudioStats.AUDIO_AMPLITUDE_NONE) / (this.count - 1);
    L5:
        r100 = false;
        goto L6
    }

    public double sum() {
        return this.mean * this.count;
    }

    public byte[] toByteArray() {
        ByteBuffer r100 = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(r100);
        return r100.array();
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public String toString() {
        if (count() <= 0) goto L6;
        j.a r100 = j.b(this);
        r100.a("count", this.count);
        r100.c("mean", String.valueOf(this.mean));
        r100.c("populationStandardDeviation", String.valueOf(populationStandardDeviation()));
        r100.c(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, String.valueOf(this.min));
        r100.c(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, String.valueOf(this.max));
        return r100.toString();
    L6:
        j.a r101 = j.b(this);
        r101.a("count", this.count);
        return r101.toString();
    }

    public long count() {
        return this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public static Stats fromByteArray(byte[] r100) {
        r100.getClass();
        if (r100.length != 40) goto L5;
        boolean r101 = true;
    L6:
        m.e(r101, "Expected Stats.BYTES = %s remaining , got %s", 40, r100.length);
        return readFrom(ByteBuffer.wrap(r100).order(ByteOrder.LITTLE_ENDIAN));
    L5:
        r101 = false;
        goto L6
    }

    public static double meanOf(Iterator<? extends Number> r110) {
        m.b(r110.hasNext());
        double r100 = r110.next().doubleValue();
        long r101 = 1;
    L4:
        if (r110.hasNext() == false) goto L11;
        double r102 = r110.next().doubleValue();
        r101 = r101 + 1;
        if (Doubles.a(r102) == false) goto L10;
        if (Doubles.a(r100) == false) goto L10;
        r100 = r100 + ((r102 - r100) / r101);
    L10:
        r100 = f.a(r100, r102);
        goto L4
    L11:
        return r100;
    }

    public static Stats of(Iterable<? extends Number> r210) {
        Iterator<? extends Number> r100 = r210.iterator();
        long r101 = 0;
        long r102 = 0;
        double r110 = 0.0d;
        double r111 = 0.0d;
        double r103 = Double.NaN;
        double r112 = Double.NaN;
    L4:
        if (r100.hasNext() == false) goto L20;
        double r104 = r100.next().doubleValue();
        if (r102 == r101) goto L8;
        r102 = r102 + 1;
        if (Doubles.a(r104) == true) goto L14;
    L16:
        r110 = f.a(r110, r104);
        r111 = Double.NaN;
    L17:
        double r105 = Math.min(r112, r104);
        r103 = Math.max(r103, r104);
        r112 = r105;
    L18:
        r101 = 0;
        goto L4
    L14:
        if (Doubles.a(r110) == false) goto L16;
        double r113 = r104 - r110;
        r110 = r110 + (r113 / r102);
        r111 = r111 + (r113 * (r104 - r110));
        goto L17
    L8:
        if (Doubles.a(r104) == true) goto L10;
        r103 = r104;
        r110 = r103;
        r112 = r110;
        r102 = 1;
        r111 = Double.NaN;
        goto L18
    L10:
        r103 = r104;
        r110 = r103;
        r112 = r110;
        r102 = 1;
        goto L18
    L20:
        return new Stats(r102, r110, r111, r112, r103);
    }

    public static Stats readFrom(ByteBuffer r110) {
        r110.getClass();
        if (r110.remaining() < 40) goto L5;
        boolean r100 = true;
    L6:
        m.e(r100, "Expected at least Stats.BYTES = %s remaining , got %s", 40, r110.remaining());
        return new Stats(r110.getLong(), r110.getDouble(), r110.getDouble(), r110.getDouble(), r110.getDouble());
    L5:
        r100 = false;
        goto L6
    }

    public boolean equals(@CheckForNull Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Stats.class == r100.getClass()) goto L8;
        return false;
    L8:
        Stats r101 = (Stats) r100;
        if (this.count == r101.count) goto L11;
        return false;
    L11:
        if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(r101.mean)) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(r101.sumOfSquaresOfDeltas)) goto L15;
        return false;
    L15:
        if (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(r101.min)) goto L17;
        return false;
    L17:
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(r101.max)) goto L24;
        return true;
    L24:
        return false;
    }

    public void writeTo(ByteBuffer r100) {
        r100.getClass();
        if (r100.remaining() < 40) goto L5;
        boolean r101 = true;
    L6:
        m.e(r101, "Expected at least Stats.BYTES = %s remaining , got %s", 40, r100.remaining());
        r100.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static double meanOf(int... r100) {
        int r101 = 1;
        if (r100.length <= 0) goto L5;
        boolean r102 = true;
    L6:
        m.b(r102);
        double r103 = r100[0];
    L8:
        if (r101 >= r100.length) goto L16;
        double r104 = r100[r101];
        if (Doubles.a(r104) == true) goto L12;
    L14:
        r103 = f.a(r103, r104);
    L15:
        r101 = r101 + 1;
        goto L8
    L12:
        if (Doubles.a(r103) == false) goto L14;
        r103 = r103 + ((r104 - r103) / ((double) (r101 + 1)));
        goto L15
    L16:
        return r103;
    L5:
        r102 = false;
        goto L6
    }

    public static Stats of(int... r210) {
        int[] r100 = r210;
        int r101 = r100.length;
        int r102 = 0;
        double r110 = 0.0d;
        double r111 = 0.0d;
        double r103 = Double.NaN;
        double r104 = Double.NaN;
        long r112 = 0;
    L3:
        if (r102 >= r101) goto L19;
        double r105 = r100[r102];
        if (r112 != 0) goto L10;
        r101 = r101;
        if (Doubles.a(r105) == true) goto L9;
        r103 = r105;
        r104 = r103;
        r110 = r104;
        r112 = 1;
        r111 = Double.NaN;
    L17:
        r102 = r102 + 1;
        r100 = r210;
        r101 = r101;
        goto L3
    L9:
        r103 = r105;
        r104 = r103;
        r110 = r104;
        r112 = 1;
        goto L17
    L10:
        r112 = r112 + 1;
        if (Doubles.a(r105) == true) goto L13;
    L15:
        r110 = f.a(r110, r105);
        r111 = Double.NaN;
    L16:
        double r106 = Math.min(r104, r105);
        r103 = Math.max(r103, r105);
        r104 = r106;
        goto L17
    L13:
        if (Doubles.a(r110) == false) goto L15;
        double r211 = r105 - r110;
        r110 = r110 + (r211 / r112);
        r111 = r111 + (r211 * (r105 - r110));
        goto L16
    L19:
        return new Stats(r112, r110, r111, r104, r103);
    }

    public static double meanOf(long... r100) {
        int r101 = 1;
        if (r100.length <= 0) goto L5;
        boolean r102 = true;
    L6:
        m.b(r102);
        double r103 = r100[0];
    L8:
        if (r101 >= r100.length) goto L16;
        double r104 = r100[r101];
        if (Doubles.a(r104) == true) goto L12;
    L14:
        r103 = f.a(r103, r104);
    L15:
        r101 = r101 + 1;
        goto L8
    L12:
        if (Doubles.a(r103) == false) goto L14;
        r103 = r103 + ((r104 - r103) / ((double) (r101 + 1)));
        goto L15
    L16:
        return r103;
    L5:
        r102 = false;
        goto L6
    }

    public static Stats of(long... r210) {
        long[] r100 = r210;
        int r101 = r100.length;
        int r102 = 0;
        double r110 = 0.0d;
        double r111 = 0.0d;
        double r103 = Double.NaN;
        double r104 = Double.NaN;
        long r112 = 0;
    L3:
        if (r102 >= r101) goto L19;
        double r105 = r100[r102];
        if (r112 != 0) goto L10;
        r101 = r101;
        if (Doubles.a(r105) == true) goto L9;
        r103 = r105;
        r104 = r103;
        r110 = r104;
        r112 = 1;
        r111 = Double.NaN;
    L17:
        r102 = r102 + 1;
        r100 = r210;
        r101 = r101;
        goto L3
    L9:
        r103 = r105;
        r104 = r103;
        r110 = r104;
        r112 = 1;
        goto L17
    L10:
        r112 = r112 + 1;
        if (Doubles.a(r105) == true) goto L13;
    L15:
        r110 = f.a(r110, r105);
        r111 = Double.NaN;
    L16:
        double r106 = Math.min(r104, r105);
        r103 = Math.max(r103, r105);
        r104 = r106;
        goto L17
    L13:
        if (Doubles.a(r110) == false) goto L15;
        double r211 = r105 - r110;
        r110 = r110 + (r211 / r112);
        r111 = r111 + (r211 * (r105 - r110));
        goto L16
    L19:
        return new Stats(r112, r110, r111, r104, r103);
    }

    public static double meanOf(double... r100) {
        int r101 = 1;
        if (r100.length <= 0) goto L5;
        boolean r102 = true;
    L6:
        m.b(r102);
        double r103 = r100[0];
    L8:
        if (r101 >= r100.length) goto L16;
        double r104 = r100[r101];
        if (Doubles.a(r104) == true) goto L12;
    L14:
        r103 = f.a(r103, r104);
    L15:
        r101 = r101 + 1;
        goto L8
    L12:
        if (Doubles.a(r103) == false) goto L14;
        r103 = r103 + ((r104 - r103) / ((double) (r101 + 1)));
        goto L15
    L16:
        return r103;
    L5:
        r102 = false;
        goto L6
    }

    public static Stats of(double... r210) {
        double[] r100 = r210;
        int r101 = r100.length;
        int r102 = 0;
        double r110 = 0.0d;
        double r111 = 0.0d;
        double r103 = Double.NaN;
        double r104 = Double.NaN;
        long r112 = 0;
    L3:
        if (r102 >= r101) goto L19;
        double r105 = r100[r102];
        if (r112 != 0) goto L10;
        r101 = r101;
        if (Doubles.a(r105) == true) goto L9;
        r103 = r105;
        r104 = r103;
        r110 = r104;
        r112 = 1;
        r111 = Double.NaN;
    L17:
        r102 = r102 + 1;
        r100 = r210;
        r101 = r101;
        goto L3
    L9:
        r103 = r105;
        r104 = r103;
        r110 = r104;
        r112 = 1;
        goto L17
    L10:
        r112 = r112 + 1;
        if (Doubles.a(r105) == true) goto L13;
    L15:
        r110 = f.a(r110, r105);
        r111 = Double.NaN;
    L16:
        double r106 = Math.min(r104, r105);
        r103 = Math.max(r103, r105);
        r104 = r106;
        goto L17
    L13:
        if (Doubles.a(r110) == false) goto L15;
        double r211 = r105 - r110;
        r110 = r110 + (r211 / r112);
        r111 = r111 + (r211 * (r105 - r110));
        goto L16
    L19:
        return new Stats(r112, r110, r111, r104, r103);
    }

    public static double meanOf(Iterable<? extends Number> r100) {
        return meanOf(r100.iterator());
    }

    public static Stats of(Iterator<? extends Number> r110) {
        long r100 = 0;
        long r101 = 0;
        double r102 = 0.0d;
        double r111 = 0.0d;
        double r103 = Double.NaN;
        double r112 = Double.NaN;
    L4:
        if (r110.hasNext() == false) goto L20;
        double r104 = r110.next().doubleValue();
        if (r101 == r100) goto L8;
        r101 = r101 + 1;
        if (Doubles.a(r104) == true) goto L14;
    L16:
        r102 = f.a(r102, r104);
        r111 = Double.NaN;
    L17:
        double r105 = Math.min(r112, r104);
        r103 = Math.max(r103, r104);
        r112 = r105;
    L18:
        r100 = 0;
        goto L4
    L14:
        if (Doubles.a(r102) == false) goto L16;
        double r113 = r104 - r102;
        r102 = r102 + (r113 / r101);
        r111 = r111 + (r113 * (r104 - r102));
        goto L17
    L8:
        if (Doubles.a(r104) == true) goto L10;
        r103 = r104;
        r102 = r103;
        r112 = r102;
        r101 = 1;
        r111 = Double.NaN;
        goto L18
    L10:
        r103 = r104;
        r102 = r103;
        r112 = r102;
        r101 = 1;
        goto L18
    L20:
        return new Stats(r101, r102, r111, r112, r103);
    }

    public Stats(long r100, double r101, double r102, double r103, double r104) {
        this.count = r100;
        this.mean = r101;
        this.sumOfSquaresOfDeltas = r102;
        this.min = r103;
        this.max = r104;
    }
}
