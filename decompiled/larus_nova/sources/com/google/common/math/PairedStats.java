package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.base.j;
import com.google.common.base.m;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class PairedStats implements Serializable {
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas)});
    }

    public long count() {
        return this.xStats.count();
    }

    public byte[] toByteArray() {
        ByteBuffer r100 = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(r100);
        this.yStats.writeTo(r100);
        r100.putDouble(this.sumOfProductsOfDeltas);
        return r100.array();
    }

    public d leastSquaresFit() {
        boolean r100 = false;
        if (count() <= 1) goto L5;
        boolean r101 = true;
    L6:
        m.o(r101);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == true) goto L9;
        double r102 = this.xStats.sumOfSquaresOfDeltas();
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L27;
        if (this.yStats.sumOfSquaresOfDeltas() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L24;
        double r103 = this.xStats.mean();
        double r104 = this.yStats.mean();
        if (b.a(r103) == true) goto L17;
    L19:
        m.b(r100);
        double r105 = this.sumOfProductsOfDeltas / r102;
        m.b(!Double.isNaN(r105));
        if (b.a(r105) == false) goto L23;
        return new d.b(r105, r104 - (r103 * r105));
    L23:
        return new d.c(r103);
    L17:
        if (b.a(r104) == false) goto L19;
        r100 = true;
        goto L19
    L24:
        double r106 = this.yStats.mean();
        m.b(b.a(r106));
        return new d.b(AudioStats.AUDIO_AMPLITUDE_NONE, r106);
    L27:
        if (this.yStats.sumOfSquaresOfDeltas() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
        r100 = true;
    L29:
        m.o(r100);
        double r107 = this.xStats.mean();
        m.b(b.a(r107));
        return new d.c(r107);
    L9:
        return d.a.f275627a;
    L5:
        r101 = false;
        goto L6
    }

    public double pearsonsCorrelationCoefficient() {
        boolean r100 = true;
        if (count() <= 1) goto L5;
        boolean r101 = true;
    L6:
        m.o(r101);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == false) goto L10;
        return Double.NaN;
    L10:
        double r102 = xStats().sumOfSquaresOfDeltas();
        double r103 = yStats().sumOfSquaresOfDeltas();
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        boolean r104 = true;
    L14:
        m.o(r104);
        if (r103 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
        r100 = false;
    L18:
        m.o(r100);
        double r105 = r102 * r103;
        if (r105 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
        r105 = Double.MIN_VALUE;
    L22:
        double r106 = this.sumOfProductsOfDeltas / Math.sqrt(r105);
        double r107 = 1.0d;
        if (r106 >= 1.0d) goto L28;
        r107 = -1.0d;
        if (r106 <= (-1.0d)) goto L28;
        return r106;
    L28:
        return r107;
    L13:
        r104 = false;
        goto L14
    L5:
        r101 = false;
        goto L6
    }

    public double populationCovariance() {
        if (count() == 0) goto L5;
        boolean r100 = true;
    L6:
        m.o(r100);
        return this.sumOfProductsOfDeltas / count();
    L5:
        r100 = false;
        goto L6
    }

    public double sampleCovariance() {
        if (count() <= 1) goto L5;
        boolean r100 = true;
    L6:
        m.o(r100);
        return this.sumOfProductsOfDeltas / (count() - 1);
    L5:
        r100 = false;
        goto L6
    }

    public String toString() {
        if (count() <= 0) goto L6;
        j.a r100 = j.b(this);
        r100.b("xStats", this.xStats);
        r100.b("yStats", this.yStats);
        r100.c("populationCovariance", String.valueOf(populationCovariance()));
        return r100.toString();
    L6:
        j.a r101 = j.b(this);
        r101.b("xStats", this.xStats);
        r101.b("yStats", this.yStats);
        return r101.toString();
    }

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }

    public static PairedStats fromByteArray(byte[] r100) {
        r100.getClass();
        if (r100.length != 88) goto L5;
        boolean r101 = true;
    L6:
        m.e(r101, "Expected PairedStats.BYTES = %s, got %s", 88, r100.length);
        ByteBuffer r102 = ByteBuffer.wrap(r100).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(r102), Stats.readFrom(r102), r102.getDouble());
    L5:
        r101 = false;
        goto L6
    }

    public boolean equals(@CheckForNull Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (PairedStats.class == r100.getClass()) goto L8;
        return false;
    L8:
        PairedStats r101 = (PairedStats) r100;
        if (this.xStats.equals(r101.xStats) == true) goto L11;
        return false;
    L11:
        if (this.yStats.equals(r101.yStats) == true) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfProductsOfDeltas) != Double.doubleToLongBits(r101.sumOfProductsOfDeltas)) goto L18;
        return true;
    L18:
        return false;
    }

    public PairedStats(Stats r100, Stats r101, double r102) {
        this.xStats = r100;
        this.yStats = r101;
        this.sumOfProductsOfDeltas = r102;
    }
}
