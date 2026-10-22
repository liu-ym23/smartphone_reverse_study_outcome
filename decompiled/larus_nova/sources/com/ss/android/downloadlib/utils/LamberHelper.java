package com.ss.android.downloadlib.utils;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes34.dex */
public class LamberHelper {
    static double GSL_DBL_EPSILON = 2.220446049250313E-16d;
    static double M_E = 2.718281828459045d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final double[] f408342c = null;

    public static final enum GSL_RETURN extends Enum<GSL_RETURN> {
        private static final /* synthetic */ GSL_RETURN[] $VALUES = null;
        public static final GSL_RETURN GSL_EDOM = null;
        public static final GSL_RETURN GSL_EMAXITER = null;
        public static final GSL_RETURN GSL_SUCCESS = null;

        static {
            GSL_RETURN r100 = new GSL_RETURN("GSL_SUCCESS", 0);
            GSL_SUCCESS = r100;
            GSL_RETURN r101 = new GSL_RETURN("GSL_EMAXITER", 1);
            GSL_EMAXITER = r101;
            GSL_RETURN r102 = new GSL_RETURN("GSL_EDOM", 2);
            GSL_EDOM = r102;
            $VALUES = new GSL_RETURN[]{r100, r101, r102};
        }

        public static GSL_RETURN[] values() {
            return (GSL_RETURN[]) $VALUES.clone();
        }

        public static GSL_RETURN valueOf(String r100) {
            return (GSL_RETURN) r27.a.a(GSL_RETURN.class, r100);
        }

        private GSL_RETURN(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class gsl_sf_result {
        public double err;
        public double val;

        public gsl_sf_result() {
            this.err = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.val = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public LamberHelper() {
    }

    static {
        f408342c = new double[]{-1.0d, 2.331643981597124d, -1.8121878856393634d, 1.9366311144923598d, -2.3535512018816145d, 3.0668589010506317d, -4.175335600258177d, 5.858023729874774d, -8.401032217523978d, 12.25075350131446d, -18.10069701247244d, 27.029044799010563d};
    }

    public static double branch0(double r100) {
        gsl_sf_result r101 = new gsl_sf_result();
        if (gsl_sf_lambert_W0_e(r100, r101) == GSL_RETURN.GSL_EMAXITER) goto L7;
        return r101.val;
    L7:
        throw new RuntimeException("Too many iterations");
    }

    public static double branchNeg1(double r100) {
        gsl_sf_result r101 = new gsl_sf_result();
        if (gsl_sf_lambert_Wm1_e(r100, r101) == GSL_RETURN.GSL_EMAXITER) goto L7;
        return r101.val;
    L7:
        throw new RuntimeException("Too many iterations");
    }

    public static double series_eval(double r110) {
        double[] r100 = f408342c;
        double r101 = r100[8] + ((r100[9] + ((r100[10] + (r100[11] * r110)) * r110)) * r110);
        double r102 = r100[5] + ((r100[6] + ((r100[7] + (r101 * r110)) * r110)) * r110);
        double r103 = r100[1] + ((r100[2] + ((r100[3] + ((r100[4] + (r102 * r110)) * r110)) * r110)) * r110);
        return r100[0] + (r110 * r103);
    }

    public static GSL_RETURN gsl_sf_lambert_W0_e(double r110, gsl_sf_result r111) {
        double r100 = M_E;
        double r101 = (1.0d / r100) + r110;
        if (r110 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        r111.val = AudioStats.AUDIO_AMPLITUDE_NONE;
        r111.err = AudioStats.AUDIO_AMPLITUDE_NONE;
        return GSL_RETURN.GSL_SUCCESS;
    L7:
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        r111.val = -1.0d;
        r111.err = Math.sqrt(-r101);
        return GSL_RETURN.GSL_EDOM;
    L11:
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r111.val = -1.0d;
        r111.err = GSL_DBL_EPSILON;
        return GSL_RETURN.GSL_SUCCESS;
    L15:
        if (r101 >= 0.001d) goto L19;
        double r112 = series_eval(Math.sqrt(r101));
        r111.val = r112;
        r111.err = (GSL_DBL_EPSILON * 2.0d) * Math.abs(r112);
        return GSL_RETURN.GSL_SUCCESS;
    L19:
        if (r110 >= 1.0d) goto L21;
        double r102 = Math.sqrt((r100 * 2.0d) * r101);
        double r103 = (r102 * (((((11.0d * r102) / 72.0d) - 0.3333333333333333d) * r102) + 1.0d)) - 1.0d;
    L25:
        return halley_iteration(r110, r103, 10, r111);
    L21:
        r103 = Math.log(r110);
        if (r110 <= 3.0d) goto L25;
        r103 = r103 - Math.log(r103);
        goto L25
    }

    public static GSL_RETURN gsl_sf_lambert_Wm1_e(double r100, gsl_sf_result r110) {
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        r110.val = AudioStats.AUDIO_AMPLITUDE_NONE;
        r110.err = AudioStats.AUDIO_AMPLITUDE_NONE;
        return GSL_RETURN.GSL_SUCCESS;
    L9:
        double r101 = (1.0d / M_E) + r100;
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        r110.val = -1.0d;
        r110.err = Math.sqrt(-r101);
        return GSL_RETURN.GSL_EDOM;
    L14:
        if (r100 >= (-1.0E-6d)) goto L19;
        double r102 = series_eval(-Math.sqrt(r101));
        if (r101 >= 0.003d) goto L21;
        r110.val = r102;
        r110.err = (GSL_DBL_EPSILON * 5.0d) * Math.abs(r102);
        return GSL_RETURN.GSL_SUCCESS;
    L21:
        return halley_iteration(r100, r102, 32, r110);
    L19:
        double r103 = Math.log(-r100);
        double r104 = Math.log(-r103);
        r102 = (r103 - r104) + (r104 / r103);
        goto L21
    L5:
        return gsl_sf_lambert_W0_e(r100, r110);
    }

    public static GSL_RETURN halley_iteration(double r110, double r210, int r211, gsl_sf_result r212) {
        double r100 = r210;
        int r101 = 0;
    L3:
        if (r101 >= r211) goto L13;
        double r102 = Math.exp(r100);
        double r103 = r100 + 1.0d;
        double r111 = (r100 * r102) - r110;
        if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        double r112 = (r111 / r103) / r102;
    L8:
        r100 = r100 - r112;
        double r113 = (GSL_DBL_EPSILON * 10.0d) * Math.max(Math.abs(r100), 1.0d / (Math.abs(r103) * r102));
        if (Math.abs(r112) < r113) goto L10;
        r101 = r101 + 1;
        goto L3
    L10:
        r212.val = r100;
        r212.err = 2.0d * r113;
        return GSL_RETURN.GSL_SUCCESS;
    L7:
        r112 = r111 / ((r102 * r103) - ((((r103 + 1.0d) * 0.5d) * r111) / r103));
        goto L8
    L13:
        r212.val = r100;
        r212.err = Math.abs(r100);
        return GSL_RETURN.GSL_EMAXITER;
    }
}
