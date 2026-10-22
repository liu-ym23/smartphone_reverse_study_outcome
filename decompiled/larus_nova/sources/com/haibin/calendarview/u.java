package com.haibin.calendarview;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes23.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f276225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double[] f276226b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final double[] f276227c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double[] f276228d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double[] f276229e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final double[] f276230f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final double[] f276231g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final double[] f276232h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final double[] f276233i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final double[] f276234j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final double[] f276235k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final double[] f276236l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final double[] f276237m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final double[] f276238n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final double[] f276239o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final double[] f276240p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final double[] f276241q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final double[] f276242r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static double f276243s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f276244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f276245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f276246c;

        public final String toString() {
            return u.b(this.f276244a) + u.b(this.f276245b) + u.b(this.f276246c);
        }

        public a() {
        }
    }

    public static double f(double r100) {
        double r101 = r100 % 6.283185307179586d;
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return r101;
    L5:
        return r101 + 6.283185307179586d;
    }

    static {
        f276226b = new double[]{-4000.0d, 108371.7d, -13036.8d, 392.0d, AudioStats.AUDIO_AMPLITUDE_NONE, -500.0d, 17201.0d, -627.82d, 16.17d, -0.3413d, -150.0d, 12200.6d, -346.41d, 5.403d, -0.1593d, 150.0d, 9113.8d, -328.13d, -1.647d, 0.0377d, 500.0d, 5707.5d, -391.41d, 0.915d, 0.3145d, 900.0d, 2203.4d, -283.45d, 13.034d, -0.1778d, 1300.0d, 490.1d, -57.35d, 2.085d, -0.0072d, 1600.0d, 120.0d, -9.81d, -1.532d, 0.1403d, 1700.0d, 10.2d, -0.91d, 0.51d, -0.037d, 1800.0d, 13.4d, -0.72d, 0.202d, -0.0193d, 1830.0d, 7.8d, -1.81d, 0.416d, -0.0247d, 1860.0d, 8.3d, -0.13d, -0.406d, 0.0292d, 1880.0d, -5.4d, 0.32d, -0.183d, 0.0173d, 1900.0d, -2.3d, 2.06d, 0.169d, -0.0135d, 1920.0d, 21.2d, 1.69d, -0.304d, 0.0167d, 1940.0d, 24.2d, 1.22d, -0.064d, 0.0031d, 1960.0d, 33.2d, 0.51d, 0.231d, -0.0109d, 1980.0d, 51.0d, 1.29d, -0.026d, 0.0032d, 2000.0d, 64.7d, -1.66d, 5.224d, -0.2905d, 2150.0d, 279.4d, 732.95d, 429.579d, 0.0158d, 6000.0d};
        f276227c = new double[]{0.016708634d, -4.2037E-5d, -1.267E-7d};
        f276228d = new double[]{1.796595680777785d, 0.030010238356341697d, 8.028514559173916E-6d};
        f276229e = new double[]{4.89506311081711d, 628.3319667475674d, 5.291887161265863E-6d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        f276230f = new double[]{2.1824391966d, -33.757045954d, 3.62262E-5d, 3.734E-8d, -2.8793E-10d, -171996.0d, -1742.0d, 92025.0d, 89.0d, 3.5069406862d, 1256.663930738d, 1.05845E-5d, 6.9813E-10d, -2.2815E-10d, -13187.0d, -16.0d, 5736.0d, -31.0d, 1.3375032491d, 16799.418221925d, -5.11866E-5d, 6.4626E-8d, -5.3543E-10d, -2274.0d, -2.0d, 977.0d, -5.0d, 4.3648783932d, -67.514091907d, 7.24525E-5d, 7.4681E-8d, -5.7586E-10d, 2062.0d, 2.0d, -895.0d, 5.0d, 0.0431251803d, -628.301955171d, 2.682E-6d, 6.5935E-10d, 5.5705E-11d, -1426.0d, 34.0d, 54.0d, -1.0d, 2.3555557435d, 8328.691425719d, 1.545547E-4d, 2.5033E-7d, -1.1863E-9d, 712.0d, 1.0d, -7.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 3.4638155059d, 1884.965885909d, 7.9025E-6d, 3.8785E-11d, -2.8386E-10d, -517.0d, 12.0d, 224.0d, -6.0d, 5.4382493597d, 16833.175267879d, -8.74129E-5d, 2.7285E-8d, -2.475E-10d, -386.0d, -4.0d, 200.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 3.6930589926d, 25128.109647645d, 1.033681E-4d, 3.1496E-7d, -1.7218E-9d, -301.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 129.0d, -1.0d, 3.5500658664d, 628.361975567d, 1.32664E-5d, 1.3575E-9d, -1.7245E-10d, 217.0d, -5.0d, -95.0d, 3.0d};
        f276231g = new double[]{1.75347045673d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0.03341656456d, 4.66925680417d, 6283.0758499914d, 3.4894275E-4d, 4.62610241759d, 12566.1516999828d, 3.417571E-5d, 2.82886579606d, 3.523118349d, 3.497056E-5d, 2.74411800971d, 5753.3848848968d, 3.135896E-5d, 3.62767041758d, 77713.7714681205d, 2.676218E-5d, 4.41808351397d, 7860.4193924392d, 2.342687E-5d, 6.13516237631d, 3930.2096962196d, 1.273166E-5d, 2.03709655772d, 529.6909650946d, 1.324292E-5d, 0.74246356352d, 11506.7697697936d, 9.01855E-6d, 2.04505443513d, 26.2983197998d, 1.199167E-5d, 1.10962944315d, 1577.3435424478d, 8.57223E-6d, 3.50849156957d, 398.1490034082d, 7.79786E-6d, 1.17882652114d, 5223.6939198022d, 9.9025E-6d, 5.23268129594d, 5884.9268465832d, 7.53141E-6d, 2.53339053818d, 5507.5532386674d, 5.05264E-6d, 4.58292563052d, 18849.2275499742d, 4.92379E-6d, 4.20506639861d, 775.522611324d, 3.56655E-6d, 2.91954116867d, 0.0673103028d, 2.84125E-6d, 1.89869034186d, 796.2980068164d, 2.4281E-6d, 0.34481140906d, 5486.777843175d, 3.17087E-6d, 5.84901952218d, 11790.6290886588d, 2.71039E-6d, 0.31488607649d, 10977.078804699d, 2.0616E-6d, 4.80646606059d, 2544.3144198834d, 2.05385E-6d, 1.86947813692d, 5573.1428014331d, 2.02261E-6d, 2.45767795458d, 6069.7767545534d, 1.26184E-6d, 1.0830263021d, 20.7753954924d, 1.55516E-6d, 0.83306073807d, 213.299095438d, 1.15132E-6d, 0.64544911683d, 0.9803210682d, 1.02851E-6d, 0.63599846727d, 4694.0029547076d, 1.01724E-6d, 4.26679821365d, 7.1135470008d, 9.9206E-7d, 6.20992940258d, 2146.1654164752d, 1.32212E-6d, 3.41118275555d, 2942.4634232916d, 9.7607E-7d, 0.6810127227d, 155.4203994342d, 8.5128E-7d, 1.29870743025d, 6275.9623029906d, 7.4651E-7d, 1.75508916159d, 5088.6288397668d, 1.01895E-6d, 0.97569221824d, 15720.8387848784d, 8.4711E-7d, 3.67080093025d, 71430.6956181291d, 7.3547E-7d, 4.67926565481d, 801.8209311238d, 7.3874E-7d, 3.50319443167d, 3154.6870848956d, 7.8756E-7d, 3.03698313141d, 12036.4607348882d, 7.9637E-7d, 1.807913307d, 17260.1546546904d, 8.5803E-7d, 5.98322631256d, 161000.6857376741d, 5.6963E-7d, 2.78430398043d, 6286.5989683404d, 6.1148E-7d, 1.81839811024d, 7084.8967811152d, 6.9627E-7d, 0.83297596966d, 9437.762934887d, 5.6116E-7d, 4.38694880779d, 14143.4952424306d, 6.2449E-7d, 3.97763880587d, 8827.3902698748d, 5.1145E-7d, 0.28306864501d, 5856.4776591154d, 5.5577E-7d, 3.47006009062d, 6279.5527316424d, 4.1036E-7d, 5.36817351402d, 8429.2412664666d, 5.1605E-7d, 1.33282746983d, 1748.016413067d, 5.1992E-7d, 0.18914945834d, 12139.5535091068d, 4.9E-7d, 0.48735065033d, 1194.4470102246d, 3.92E-7d, 6.16832995016d, 10447.3878396044d, 3.5566E-7d, 1.77597314691d, 6812.766815086d, 3.677E-7d, 6.04133859347d, 10213.285546211d, 3.6596E-7d, 2.56955238628d, 1059.3819301892d, 3.3291E-7d, 0.59309499459d, 17789.845619785d, 3.5954E-7d, 1.70876111898d, 2352.8661537718d};
        f276232h = new double[]{6283.31966747491d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0.00206058863d, 2.67823455584d, 6283.0758499914d, 4.30343E-5d, 2.63512650414d, 12566.1516999828d, 4.25264E-6d, 1.59046980729d, 3.523118349d, 1.08977E-6d, 2.96618001993d, 1577.3435424478d, 9.3478E-7d, 2.59212835365d, 18849.2275499742d, 1.19261E-6d, 5.79557487799d, 26.2983197998d, 7.2122E-7d, 1.13846158196d, 529.6909650946d, 6.7768E-7d, 1.87472304791d, 398.1490034082d, 6.7327E-7d, 4.40918235168d, 5507.5532386674d, 5.9027E-7d, 2.8879703846d, 5223.6939198022d, 5.5976E-7d, 2.17471680261d, 155.4203994342d, 4.5407E-7d, 0.39803079805d, 796.2980068164d, 3.6369E-7d, 0.46624739835d, 775.522611324d, 2.8958E-7d, 2.64707383882d, 7.1135470008d, 1.9097E-7d, 1.84628332577d, 5486.777843175d, 2.0844E-7d, 5.34138275149d, 0.9803210682d, 1.8508E-7d, 4.96855124577d, 213.299095438d, 1.6233E-7d, 0.03216483047d, 2544.3144198834d, 1.7293E-7d, 2.99116864949d, 6275.9623029906d};
        f276233i = new double[]{5.291887E-4d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 8.719837E-5d, 1.07209665242d, 6283.0758499914d, 3.09125E-6d, 0.86728818832d, 12566.1516999828d, 2.7339E-7d, 0.05297871691d, 3.523118349d, 1.6334E-7d, 5.18826691036d, 26.2983197998d, 1.5752E-7d, 3.6845788943d, 155.4203994342d, 9.541E-8d, 0.75742297675d, 18849.2275499742d, 8.937E-8d, 2.05705419118d, 77713.7714681205d, 6.952E-8d, 0.8267330541d, 775.522611324d, 5.064E-8d, 4.66284525271d, 1577.3435424478d};
        f276234j = new double[]{2.89226E-6d, 5.84384198723d, 6283.0758499914d, 3.4955E-7d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1.6819E-7d, 5.48766912348d, 12566.1516999828d};
        f276235k = new double[]{1.14084E-6d, 3.14159265359d, AudioStats.AUDIO_AMPLITUDE_NONE, 7.717E-8d, 4.13446589358d, 6283.0758499914d, 7.65E-9d, 3.83803776214d, 12566.1516999828d};
        f276236l = new double[]{8.78E-9d, 3.14159265359d, AudioStats.AUDIO_AMPLITUDE_NONE};
        f276237m = new double[]{2.7962E-6d, 3.19870156017d, 84334.6615813083d, 1.01643E-6d, 5.42248619256d, 5507.5532386674d, 8.0445E-7d, 3.88013204458d, 5223.6939198022d, 4.3806E-7d, 3.70444689758d, 2352.8661537718d, 3.1933E-7d, 4.00026369781d, 1577.3435424478d, 2.2724E-7d, 3.9847383156d, 1047.7473117547d, 1.6392E-7d, 3.56456119782d, 5856.4776591154d, 1.8141E-7d, 4.98367470263d, 6283.0758499914d, 1.4443E-7d, 3.70275614914d, 9437.762934887d, 1.4304E-7d, 3.41117857525d, 10213.285546211d};
        f276238n = new double[]{9.03E-8d, 3.8972906189d, 5507.5532386674d, 6.177E-8d, 1.73038850355d, 5223.6939198022d};
        f276239o = new double[]{1.00013988799d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0.01670699626d, 3.09846350771d, 6283.0758499914d, 1.3956023E-4d, 3.0552460962d, 12566.1516999828d, 3.08372E-5d, 5.19846674381d, 77713.7714681205d, 1.628461E-5d, 1.17387749012d, 5753.3848848968d, 1.575568E-5d, 2.84685245825d, 7860.4193924392d, 9.24799E-6d, 5.45292234084d, 11506.7697697936d, 5.42444E-6d, 4.56409149777d, 3930.2096962196d};
        f276240p = new double[]{0.00103018608d, 1.10748969588d, 6283.0758499914d, 1.721238E-5d, 1.06442301418d, 12566.1516999828d, 7.02215E-6d, 3.14159265359d, AudioStats.AUDIO_AMPLITUDE_NONE};
        f276241q = new double[]{4.359385E-5d, 5.78455133738d, 6283.0758499914d};
        f276242r = new double[]{1.44595E-6d, 4.27319435148d, 6283.0758499914d};
        f276243s = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static double a(double[] r110) {
        double r100 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r101 = 0;
    L4:
        if (r101 >= r110.length) goto L6;
        r100 = r100 + (r110[r101] * Math.cos(r110[r101 + 1] + (f276243s * r110[r101 + 2])));
        r101 = r101 + 3;
        goto L4
    L6:
        return r100;
    }

    public static String b(double r100) {
        int r101 = (int) r100;
        if (r100 >= 10.0d) goto L6;
        return "0" + r101;
    L6:
        return String.valueOf(r101);
    }

    public static double d(double r100) {
        double r101 = Math.floor(r100);
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return r101;
    L5:
        return r101 + 1.0d;
    }

    public static a g(double r110) {
        a r100 = new a();
        double r101 = ((r110 - 2451545.0d) / 365.2425d) + 2000.0d;
        int r102 = 0;
    L3:
        double[] r103 = f276226b;
        if (r102 >= 100) goto L11;
        int r104 = r102 + 5;
        if (r101 < r103[r104]) goto L11;
        if (r102 == 95) goto L11;
        r102 = r104;
    L11:
        double r105 = r103[r102];
        double r106 = ((r101 - r105) / (r103[r102 + 5] - r105)) * 10.0d;
        double r107 = r106 * r106;
        double r108 = r107 * r106;
        double r111 = (r110 - ((((r103[r102 + 1] + (r103[r102 + 2] * r106)) + (r103[r102 + 3] * r107)) + (r103[r102 + 4] * r108)) / 86400.0d)) + 0.5d;
        double r109 = d(r111);
        double r112 = r111 - r109;
        if (r109 <= 2299161.0d) goto L14;
        double r113 = d((r109 - 1867216.25d) / 36524.25d);
        r109 = r109 + ((r113 + 1.0d) - d(r113 / 4.0d));
    L14:
        double r114 = r109 + 1524.0d;
        double r115 = d((r114 - 122.1d) / 365.25d);
        r100.f276244a = r115;
        double r116 = r114 - d(r115 * 365.25d);
        double r117 = d(r116 / 30.6001d);
        r100.f276245b = r117;
        r100.f276246c = r116 - d(r117 * 30.6001d);
        double r118 = r100.f276244a - 4716.0d;
        r100.f276244a = r118;
        double r119 = r100.f276245b - 1.0d;
        r100.f276245b = r119;
        if (r119 <= 12.0d) goto L18;
        r100.f276245b = r119 - 12.0d;
    L18:
        if (r100.f276245b > 2.0d) goto L20;
        r100.f276244a = r118 + 1.0d;
    L20:
        double r120 = r112 * 24.0d;
        d((r120 - d(r120)) * 60.0d);
        return r100;
    }

    public static double c(double r210, double r211) {
        double r100 = r210 / 365250.0d;
        f276243s = r100;
        double r101 = r100 * r100;
        double r102 = r101 * r100;
        double r103 = r102 * r100;
        double[] r104 = {((((a(f276231g) + (a(f276232h) * r100)) + (a(f276233i) * r101)) + (a(f276234j) * r102)) + (a(f276235k) * r103)) + (a(f276236l) * (r103 * r100)), a(f276237m) + (a(f276238n) * r100), ((a(f276239o) + (a(f276240p) * r100)) + (a(f276241q) * r101)) + (a(f276242r) * r102)};
        double r105 = f(r104[0]);
        r104[0] = r105;
        double r106 = r105 + 3.141592653589793d;
        r104[0] = r106;
        r104[1] = -r104[1];
        double r107 = r210 / 36525.0d;
        double r108 = r107 * r107;
        double r110 = r108 * r107;
        double r111 = r110 * r107;
        double[] r109 = f276229e;
        double r112 = (((r109[0] + (r109[1] * r107)) + (r109[2] * r108)) + (r109[3] * r110)) + (r109[4] * r111);
        double[] r113 = f276228d;
        double r114 = (r113[0] + (r113[1] * r107)) + (r113[2] * r108);
        double[] r115 = f276227c;
        double r212 = (r115[0] + (r115[1] * r107)) + (r115[2] * r108);
        double r116 = r112 - r106;
        double r117 = r114 - r106;
        r104[0] = r106 - (((Math.cos(r116) - (Math.cos(r117) * r212)) * 9.936508497454117E-5d) / Math.cos(r104[1]));
        double r118 = r104[1];
        r104[1] = r118 - ((Math.sin(r118) * 9.936508497454117E-5d) * (Math.sin(r116) - (r212 * Math.sin(r117))));
        r104[0] = f(r104[0]);
        double r119 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r120 = 0;
    L4:
        if (r120 >= 90) goto L6;
        double[] r121 = f276230f;
        double r122 = (((r121[r120] + (r121[r120 + 1] * r107)) + (r121[r120 + 2] * r108)) + (r121[r120 + 3] * r110)) + (r121[r120 + 4] * r111);
        r119 = r119 + ((r121[r120 + 5] + ((r121[r120 + 6] * r107) / 10.0d)) * Math.sin(r122));
        double r123 = r121[r120 + 7];
        double r124 = r121[r120 + 8];
        Math.cos(r122);
        r120 = r120 + 9;
        goto L4
    L6:
        double r125 = r104[0] + (r119 / 2.0626480624709637E9d);
        r104[0] = r125;
        return f(r211 - r125);
    }

    public static double e(double r210, double r211) {
        double r100 = r210;
        double r101 = 360.0d + r100;
        double r102 = 0.017453292519943295d * r211;
        double r103 = c(r100, r102);
        double r104 = c(r101, r102);
        if (r103 >= r104) goto L5;
        r104 = r104 - 6.283185307179586d;
    L5:
        double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r111 = 1.0d;
        int r112 = 0;
    L7:
        if (r112 >= 10) goto L19;
        double r113 = (r104 - r103) / (r101 - r100);
        if (Math.abs(r113) <= 1.0E-15d) goto L11;
        r111 = r113;
    L11:
        r110 = r100 - (r103 / r111);
        double r105 = c(r110, r102);
        if (r105 <= 1.0d) goto L16;
        r105 = r105 - 6.283185307179586d;
    L16:
        if (Math.abs(r105) < 1.0E-8d) goto L19;
        r112 = r112 + 1;
        r103 = r104;
        r104 = r105;
        r100 = r101;
        r101 = r110;
    L19:
        return r110;
    }
}
