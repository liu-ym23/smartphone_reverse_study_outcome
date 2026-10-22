package tla;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public final class m extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f546725d;

    public m(String r210) {
        this.f546671a = r210;
        double[] r100 = new double[r210.length() / 2];
        int r101 = r210.indexOf(40) + 1;
        int r102 = r210.indexOf(44, r101);
        int r103 = 0;
    L4:
        if (r102 == (-1)) goto L6;
        r100[r103] = CastDoubleProtector.parseDouble(r210.substring(r101, r102).trim());
        r101 = r102 + 1;
        r102 = r210.indexOf(44, r101);
        r103 = r103 + 1;
        goto L4
    L6:
        r100[r103] = CastDoubleProtector.parseDouble(r210.substring(r101, r210.indexOf(41, r101)).trim());
        double[] r104 = Arrays.copyOf(r100, r103 + 1);
        int r105 = (r104.length * 3) - 2;
        int r106 = r104.length - 1;
        double r107 = 1.0d / ((double) r106);
        double[][] r108 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r105, 1});
        double[] r109 = new double[r105];
        int r110 = 0;
    L8:
        if (r110 >= r104.length) goto L13;
        double r111 = r104[r110];
        int r112 = r110 + r106;
        r108[r112][0] = r111;
        double r113 = ((double) r110) * r107;
        r109[r112] = r113;
        if (r110 <= 0) goto L12;
        int r114 = (r106 * 2) + r110;
        r108[r114][0] = r111 + 1.0d;
        r109[r114] = r113 + 1.0d;
        int r115 = r110 - 1;
        r108[r115][0] = (r111 - 1.0d) - r107;
        r109[r115] = (r113 - 1.0d) - r107;
    L12:
        r110 = r110 + 1;
        goto L8
    L13:
        h r116 = new h(r109, r108);
        System.out.println(" 0 " + r116.b(AudioStats.AUDIO_AMPLITUDE_NONE));
        System.out.println(" 1 " + r116.b(1.0d));
        this.f546725d = r116;
    }

    @Override // tla.c
    public final double a(double r100) {
        return this.f546725d.b(r100);
    }

    @Override // tla.c
    public final double b(double r100) {
        return this.f546725d.e(r100);
    }
}
