package tla;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f546669b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f546670c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f546671a;

    public static class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f546672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f546673e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final double f546674f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final double f546675g;

        public a(String r100) {
            this.f546671a = r100;
            int r101 = r100.indexOf(40);
            int r102 = r100.indexOf(44, r101);
            this.f546672d = CastDoubleProtector.parseDouble(r100.substring(r101 + 1, r102).trim());
            int r103 = r102 + 1;
            int r104 = r100.indexOf(44, r103);
            this.f546673e = CastDoubleProtector.parseDouble(r100.substring(r103, r104).trim());
            int r105 = r104 + 1;
            int r106 = r100.indexOf(44, r105);
            this.f546674f = CastDoubleProtector.parseDouble(r100.substring(r105, r106).trim());
            int r107 = r106 + 1;
            this.f546675g = CastDoubleProtector.parseDouble(r100.substring(r107, r100.indexOf(41, r107)).trim());
        }

        @Override // tla.c
        public final double a(double r110) {
            if (r110 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L6:
            if (r110 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double r100 = 0.5d;
            double r101 = 0.5d;
        L10:
            if (r100 <= 0.01d) goto L15;
            r100 = r100 * 0.5d;
            if (d(r101) < r110) goto L13;
            r101 = r101 - r100;
            goto L10
        L13:
            r101 = r101 + r100;
            goto L10
        L15:
            double r102 = r101 - r100;
            double r103 = d(r102);
            double r104 = r101 + r100;
            double r105 = d(r104);
            double r106 = e(r102);
            return (((e(r104) - r106) * (r110 - r103)) / (r105 - r103)) + r106;
        }

        @Override // tla.c
        public final double b(double r110) {
            double r100 = 0.5d;
            double r101 = 0.5d;
        L4:
            if (r100 <= 1.0E-4d) goto L9;
            r100 = r100 * 0.5d;
            if (d(r101) < r110) goto L7;
            r101 = r101 - r100;
            goto L4
        L7:
            r101 = r101 + r100;
            goto L4
        L9:
            double r111 = r101 - r100;
            double r102 = d(r111);
            double r103 = r101 + r100;
            double r104 = d(r103);
            return (e(r103) - e(r111)) / (r104 - r102);
        }

        public final double d(double r100) {
            double r101 = 1.0d - r100;
            double r102 = 3.0d * r101;
            double r103 = (r101 * r102) * r100;
            double r104 = (r102 * r100) * r100;
            double r105 = (r100 * r100) * r100;
            return ((this.f546672d * r103) + (this.f546674f * r104)) + r105;
        }

        public final double e(double r100) {
            double r101 = 1.0d - r100;
            double r102 = 3.0d * r101;
            double r103 = (r101 * r102) * r100;
            double r104 = (r102 * r100) * r100;
            double r105 = (r100 * r100) * r100;
            return ((this.f546673e * r103) + (this.f546675g * r104)) + r105;
        }
    }

    public double a(double r100) {
        return r100;
    }

    public double b(double r100) {
        return 1.0d;
    }

    static {
        f546669b = new c();
        f546670c = new String[]{"standard", "accelerate", "decelerate", "linear"};
    }

    public c() {
        this.f546671a = DownloadHelper.IDENTITY;
    }

    public final String toString() {
        return this.f546671a;
    }

    public static c c(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.startsWith("cubic") == false) goto L10;
        return new a(r100);
    L10:
        if (r100.startsWith("spline") == false) goto L14;
        return new m(r100);
    L14:
        if (r100.startsWith("Schlick") == true) goto L16;
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1354466595: goto L41;
            case -1263948740: goto L37;
            case -1197605014: goto L33;
            case -1102672091: goto L29;
            case -749065269: goto L25;
            case 1312628413: goto L21;
            default: goto L44;
        };
    L44:
        switch(r101) {
            case 0: goto L58;
            case 1: goto L56;
            case 2: goto L54;
            case 3: goto L52;
            case 4: goto L50;
            case 5: goto L48;
            default: goto L45;
        };
    L45:
        System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f546670c));
        return f546669b;
    L48:
        return new a("cubic(0.4, 0.0, 0.2, 1)");
    L50:
        return new a("cubic(0.34, 1.56, 0.64, 1)");
    L52:
        return new a("cubic(1, 1, 0, 0)");
    L54:
        return new a("cubic(0.36, 0, 0.66, -0.56)");
    L56:
        return new a("cubic(0.0, 0.0, 0.2, 0.95)");
    L58:
        return new a("cubic(0.4, 0.05, 0.8, 0.7)");
    L21:
        if (r100.equals("standard") == false) goto L44;
        r101 = 5;
        goto L44
    L25:
        if (r100.equals("overshoot") == false) goto L44;
        r101 = 4;
        goto L44
    L29:
        if (r100.equals("linear") == false) goto L44;
        r101 = 3;
        goto L44
    L33:
        if (r100.equals("anticipate") == false) goto L44;
        r101 = 2;
        goto L44
    L37:
        if (r100.equals("decelerate") == false) goto L44;
        r101 = 1;
        goto L44
    L41:
        if (r100.equals("accelerate") == false) goto L44;
        r101 = 0;
        goto L44
    L16:
        return new j(r100);
    }
}
