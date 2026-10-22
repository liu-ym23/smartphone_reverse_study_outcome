package im2;

import androidx.camera.video.AudioStats;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f490514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f490515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f490516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f490517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f490518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f490519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f490520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f490521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f490522i;

    public final p c() {
        String r100 = this.f490522i;
        int r101 = this.f490514a;
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 <= 0) goto L5;
        double r103 = ((double) this.f490517d) / ((double) r101);
    L6:
        if (r101 <= 0) goto L8;
        double r104 = ((double) this.f490518e) / ((double) r101);
    L9:
        if (r101 <= 0) goto L11;
        r102 = ((double) this.f490519f) / ((double) r101);
    L11:
        double r110 = r102;
        if (r101 <= 0) goto L14;
        int r105 = (int) (this.f490515b / ((long) r101));
    L16:
        return new p(r100, r101, r103, r104, r110, r105);
    L14:
        r105 = 0;
        goto L16
    L8:
        r104 = 0.0d;
        goto L9
    L5:
        r103 = 0.0d;
        goto L6
    }

    public o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f490522i = r100;
        this.f490520g = 64;
        this.f490521h = 1073741824;
    }

    public final int a(int r100) {
        int r101 = this.f490521h;
        if (r100 >= r101) goto L10;
        int r102 = this.f490520g;
        if (r100 <= r102) goto L11;
        int r103 = r100 - 1;
        int r104 = r103 | (r103 >> 1);
        int r105 = r104 | (r104 >> 2);
        int r106 = r105 | (r105 >> 4);
        int r107 = r106 | (r106 >> 8);
        return (r107 | (r107 >> 16)) + 1;
    L11:
        return r102;
    L10:
        return r101;
    }

    public final byte[] b(InputStream r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "input");
        int r101 = this.f490514a;
        if (r101 <= 0) goto L5;
        int r102 = a(MathKt.roundToInt(((double) r110) * (this.f490516c / ((double) r101))));
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(r102);
    L6:
        byte[] r104 = new byte[4096];
    L7:
        int r105 = r100.read(r104);
        if (r105 == (-1)) goto L9;
        r103.write(r104, 0, r105);
        goto L7
    L9:
        int r106 = RangesKt.coerceAtLeast(a(r103.size()), 4096);
        byte[] r107 = r103.toByteArray();
        int r108 = this.f490514a;
        if (r108 <= 0) goto L18;
        long r109 = this.f490515b;
        if (r102 != r106) goto L14;
        this.f490517d++;
        r102 = r106;
    L17:
        this.f490515b = r109 + ((long) r102);
        goto L18
    L14:
        if (r102 <= r106) goto L16;
        this.f490518e++;
        r102 = (r106 * 2) - r102;
        goto L17
    L16:
        this.f490519f++;
    L18:
        this.f490514a = r108 + 1;
        if (r110 <= 0) goto L21;
        double r111 = ((double) r107.length) / ((double) r110);
    L22:
        this.f490516c += r111;
        r100.close();     // Catch: Throwable -> L25
    L27:
        return r107;
    L25:
        th = move-exception;
        th.printStackTrace();
        th.toString();
        goto L27
    L21:
        r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L22
    L5:
        r103 = new ByteArrayOutputStream();
        r102 = r110;
        goto L6
    }
}
