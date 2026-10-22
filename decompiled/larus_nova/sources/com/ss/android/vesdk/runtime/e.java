package com.ss.android.vesdk.runtime;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.clipparam.VEClipParam;
import com.ss.android.vesdk.filterparam.VEBaseFilterParam;
import com.ss.android.vesdk.filterparam.VERepeatFilterParam;
import com.ss.android.vesdk.filterparam.VESlowMotionFilterParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f455899a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f455900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f455901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f455902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f455903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f455904e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f455905f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f455906g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f455907h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final double f455908i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f455909j;

        public final String toString() {
            return "Clip: clipType" + this.f455901b + " path=" + this.f455902c + " seqin=" + this.f455904e + " seqout=" + this.f455905f + " trimIn=" + this.f455906g + " trimOut=" + this.f455907h + " speed=" + this.f455908i + " clipRotate=" + this.f455909j;
        }

        public a(int r100, int r101, String r102, int r103, int r104, int r105, int r106, int r107, double r108, int r110) {
            this.f455900a = r100;
            this.f455901b = r101;
            this.f455903d = r103;
            this.f455904e = r104;
            this.f455905f = r105;
            this.f455906g = r106;
            this.f455907h = r107;
            this.f455908i = r108;
            this.f455902c = r102;
            this.f455909j = r110;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<a> f455910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<a> f455911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<a> f455912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<a> f455913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f455914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public VEBaseFilterParam f455915f;

        public b() {
        }
    }

    public final int f() {
        VEBaseFilterParam r100 = this.f455899a.f455915f;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if ((r100 instanceof VERepeatFilterParam) == false) goto L10;
        return 1;
    L10:
        if ((r100 instanceof VESlowMotionFilterParam) == false) goto L13;
        return 2;
    L13:
        return 0;
    }

    public final void g() {
        ((ArrayList) this.f455899a.f455910a).clear();
        ((ArrayList) this.f455899a.f455911b).clear();
        ((ArrayList) this.f455899a.f455912c).clear();
        ((ArrayList) this.f455899a.f455913d).clear();
        b r100 = this.f455899a;
        r100.f455915f = null;
        r100.getClass();
        this.f455899a.f455914e = -1;
    }

    public e() {
        b r100 = new b();
        this.f455899a = r100;
        r100.f455910a = new ArrayList();
        r100.f455911b = new ArrayList();
        r100.f455912c = new ArrayList();
        r100.f455913d = new ArrayList();
        r100.f455915f = null;
        r100.f455914e = -1;
    }

    public static List e(VEBaseFilterParam r310, List r311) {
        ArrayList r100 = new ArrayList();
        if ((r310 instanceof VERepeatFilterParam) == false) goto L52;
        VERepeatFilterParam r101 = (VERepeatFilterParam) r310;
        int r102 = r101.seqIn;
        int r103 = r101.repeatDuration + r102;
        float r104 = r101.repeatTime;
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((ArrayList) r311).iterator();
        int r110 = 0;
    L6:
        if (r106.hasNext() == false) goto L38;
        a r111 = (a) r106.next();
        int r112 = r111.f455904e;
        if (r112 >= r103) goto L36;
        int r113 = r111.f455905f;
        if (r113 <= r102) goto L36;
        if (r112 < r102) goto L16;
        if (r113 > r103) goto L16;
        r105.add(new a(1, r111.f455901b, r111.f455902c, r110, r112, r113, r111.f455906g, r111.f455907h, r111.f455908i, r111.f455909j));
        r103 = r103;
    L15:
        ArrayList r210 = r100;
        Iterator r312 = r106;
    L37:
        r110 = r110 + 1;
        r106 = r312;
        r100 = r210;
    L16:
        r103 = r103;
        if (r112 >= r102) goto L20;
        if (r113 <= r103) goto L20;
        int r114 = r111.f455906g;
        double r115 = r111.f455908i;
        int r107 = ((int) (((double) (r102 - r112)) * r115)) + r114;
        int r211 = r114 + ((int) (((double) (r103 - r112)) * r115));
        r105.add(new a(0, r111.f455901b, r111.f455902c, r110, r112, r113, r114, r107, r115, r111.f455909j));
        r105.add(new a(1, r111.f455901b, r111.f455902c, r110, r111.f455904e, r111.f455905f, r107, r211, r111.f455908i, r111.f455909j));
        r105.add(new a(0, r111.f455901b, r111.f455902c, r110, r111.f455904e, r111.f455905f, r211, r111.f455907h, r111.f455908i, r111.f455909j));
    L20:
        if (r112 != r102) goto L23;
        if (r113 <= r103) goto L23;
        int r116 = r111.f455906g;
        double r117 = r111.f455908i;
        int r108 = ((int) (((double) (r103 - r112)) * r117)) + r116;
        r312 = r106;
        r105.add(new a(1, r111.f455901b, r111.f455902c, r110, r112, r113, r116, r108, r117, r111.f455909j));
        r105.add(new a(0, r111.f455901b, r111.f455902c, r110, r111.f455904e, r111.f455905f, r108, r111.f455907h, r111.f455908i, r111.f455909j));
        r210 = r100;
    L23:
        r312 = r106;
        if (r112 >= r102) goto L27;
        if (r113 != r103) goto L27;
        int r118 = r111.f455906g;
        double r119 = r111.f455908i;
        int r109 = ((int) (((double) (r102 - r112)) * r119)) + r118;
        r210 = r100;
        r105.add(new a(0, r111.f455901b, r111.f455902c, r110, r112, r113, r118, r109, r119, r111.f455909j));
        r105.add(new a(1, r111.f455901b, r111.f455902c, r110, r111.f455904e, r111.f455905f, r109, r111.f455907h, r111.f455908i, r111.f455909j));
    L27:
        r210 = r100;
        if (r112 >= r102) goto L32;
        if (r113 <= r102) goto L32;
        if (r113 >= r103) goto L32;
        int r120 = r111.f455906g;
        double r121 = r111.f455908i;
        int r122 = ((int) (((double) (r102 - r112)) * r121)) + r120;
        r105.add(new a(0, r111.f455901b, r111.f455902c, r110, r112, r113, r120, r122, r121, r111.f455909j));
        r105.add(new a(1, r111.f455901b, r111.f455902c, r110, r111.f455904e, r111.f455905f, r122, r111.f455907h, r111.f455908i, r111.f455909j));
    L32:
        if (r112 >= r103) goto L37;
        if (r113 <= r103) goto L37;
        if (r112 <= r102) goto L37;
        int r123 = r111.f455906g;
        double r124 = r111.f455908i;
        int r125 = ((int) (((double) (r103 - r112)) * r124)) + r123;
        r105.add(new a(1, r111.f455901b, r111.f455902c, r110, r112, r113, r123, r125, r124, r111.f455909j));
        r105.add(new a(0, r111.f455901b, r111.f455902c, r110, r111.f455904e, r111.f455905f, r125, r111.f455907h, r111.f455908i, r111.f455909j));
    L36:
        r210 = r100;
        r312 = r106;
        r105.add(new a(0, r111.f455901b, r111.f455902c, r110, r112, r111.f455905f, r111.f455906g, r111.f455907h, r111.f455908i, r111.f455909j));
        goto L37
    L38:
        ArrayList r212 = r100;
        ArrayList r126 = new ArrayList();
        int r127 = 0;
        boolean r128 = false;
        int r129 = 0;
    L40:
        if (r127 >= r105.size()) goto L47;
        if (((a) ListProtector.get(r105, r127)).f455900a != 1) goto L46;
        r126.add((a) ListProtector.get(r105, r127));
        if (r128 == true) goto L46;
        r129 = r127;
        r128 = true;
    L46:
        r127 = r127 + 1;
        goto L40
    L47:
        int r130 = 0;
    L49:
        if (r130 >= (r104 - 1.0f)) goto L51;
        r105.addAll(r129, r126);
        r130 = r130 + 1;
        goto L49
    L51:
        ArrayList r131 = r212;
        r131.addAll(r105);
    L98:
        return r131;
    L52:
        r131 = r100;
        if ((r310 instanceof VESlowMotionFilterParam) == false) goto L98;
        VESlowMotionFilterParam r132 = (VESlowMotionFilterParam) r310;
        int r133 = r132.seqIn;
        int r134 = r132.slowMotionDuration + r133;
        float r135 = r132.slowMotionSpeed;
        ArrayList r136 = new ArrayList();
        Iterator r137 = ((ArrayList) r311).iterator();
        int r213 = 0;
    L56:
        if (r137.hasNext() == false) goto L96;
        a r138 = (a) r137.next();
        int r139 = r138.f455904e;
        if (r139 >= r134) goto L94;
        int r140 = r138.f455905f;
        if (r140 <= r133) goto L94;
        if (r139 < r133) goto L65;
        if (r140 > r134) goto L65;
        ArrayList r214 = r131;
        int r141 = r213;
        r136.add(new a(2, r138.f455901b, r138.f455902c, r141, r139, r140, r138.f455906g, r138.f455907h, r135 * r138.f455908i, r138.f455909j));
        int r142 = r134;
    L69:
        r133 = r133;
        int r143 = r142;
        ArrayList r144 = r136;
    L95:
        r213 = r213 + 1;
        r137 = r137;
        r136 = r144;
        r133 = r133;
        r134 = r143;
        r131 = r214;
    L65:
        r214 = r131;
        r142 = r134;
        if (r139 >= r133) goto L70;
        if (r140 <= r142) goto L70;
        int r145 = r138.f455906g;
        double r146 = r138.f455908i;
        int r147 = ((int) (((double) (r133 - r139)) * r146)) + r145;
        int r148 = r145 + ((int) (((double) (r142 - r139)) * r146));
        int r149 = r213;
        r136.add(new a(0, r138.f455901b, r138.f455902c, r149, r139, r140, r145, r147, r146, r138.f455909j));
        r136.add(new a(2, r138.f455901b, r138.f455902c, r149, r138.f455904e, r138.f455905f, r147, r148, r138.f455908i * ((double) r135), r138.f455909j));
        r136.add(new a(0, r138.f455901b, r138.f455902c, r213, r138.f455904e, r138.f455905f, r148, r138.f455907h, r138.f455908i, r138.f455909j));
    L70:
        r137 = r137;
        if (r139 != r133) goto L74;
        if (r140 <= r142) goto L74;
        int r150 = r138.f455906g;
        double r151 = r138.f455908i;
        int r152 = ((int) (((double) (r142 - r139)) * r151)) + r150;
        r143 = r142;
        r144 = r136;
        r144.add(new a(2, r138.f455901b, r138.f455902c, r213, r139, r140, r150, r152, ((double) r135) * r151, r138.f455909j));
        r144.add(new a(0, r138.f455901b, r138.f455902c, r213, r138.f455904e, r138.f455905f, r152, r138.f455907h, r138.f455908i, r138.f455909j));
        r133 = r133;
    L74:
        int r153 = r142;
        r144 = r136;
        if (r139 < r133) goto L77;
    L80:
        if (r139 >= r133) goto L86;
        if (r140 <= r133) goto L86;
        int r154 = r153;
        if (r140 >= r154) goto L85;
        int r155 = r138.f455906g;
        double r156 = r138.f455908i;
        int r157 = ((int) (((double) (r133 - r139)) * r156)) + r155;
        int r158 = r213;
        r144.add(new a(0, r138.f455901b, r138.f455902c, r158, r139, r140, r155, r157, r156, r138.f455909j));
        r133 = r133;
        r143 = r154;
        r144.add(new a(2, r138.f455901b, r138.f455902c, r158, r138.f455904e, r138.f455905f, r157, r138.f455907h, r135 * r138.f455908i, r138.f455909j));
        goto L95
    L85:
        int r159 = r154;
    L87:
        if (r139 >= r159) goto L93;
        if (r140 <= r159) goto L93;
        int r160 = r133;
        if (r139 <= r160) goto L92;
        int r161 = r138.f455906g;
        double r162 = r138.f455908i;
        int r163 = ((int) (((double) (r159 - r139)) * r162)) + r161;
        r143 = r159;
        r133 = r160;
        int r164 = r213;
        r144.add(new a(2, r138.f455901b, r138.f455902c, r164, r139, r140, r161, r163, ((double) r135) * r162, r138.f455909j));
        r144.add(new a(0, r138.f455901b, r138.f455902c, r164, r138.f455904e, r138.f455905f, r163, r138.f455907h, r138.f455908i, r138.f455909j));
        goto L95
    L92:
        r143 = r159;
        r133 = r160;
    L93:
        r143 = r159;
    L86:
        r159 = r153;
        goto L87
    L77:
        if (r140 != r153) goto L79;
        int r165 = r138.f455906g;
        double r166 = r138.f455908i;
        int r167 = ((int) (((double) (r133 - r139)) * r166)) + r165;
        int r168 = r213;
        r144.add(new a(0, r138.f455901b, r138.f455902c, r168, r139, r140, r165, r167, r166, r138.f455909j));
        r133 = r133;
        r143 = r153;
        r144.add(new a(2, r138.f455901b, r138.f455902c, r168, r138.f455904e, r138.f455905f, r167, r138.f455907h, r135 * r138.f455908i, r138.f455909j));
        goto L95
    L79:
        r153 = r153;
    L94:
        r133 = r133;
        r214 = r131;
        r143 = r134;
        r144 = r136;
        r137 = r137;
        r144.add(new a(0, r138.f455901b, r138.f455902c, r213, r139, r138.f455905f, r138.f455906g, r138.f455907h, r138.f455908i, r138.f455909j));
        goto L95
    L96:
        ArrayList r169 = r131;
        r169.addAll(r136);
        return r169;
    }

    public static void b(List r100, List r101, List r102, List r103) {
        ArrayList r104 = (ArrayList) r100;
        if (r104.size() <= 0) goto L15;
        ArrayList r105 = (ArrayList) r101;
        if (r105.size() <= 0) goto L19;
        boolean[] r106 = new boolean[r104.size()];
        int r107 = 0;
    L9:
        if (r107 >= r105.size()) goto L20;
        a r108 = (a) ListProtector.get(r105, r107);
        int r109 = r108.f455903d;
        if (r106[r109] == true) goto L13;
        r106[r109] = true;
    L14:
        VEClipParam r110 = new VEClipParam();
        r110.clipType = r108.f455901b;
        r110.path = r108.f455902c;
        r110.trimIn = r108.f455906g;
        r110.trimOut = r108.f455907h;
        r110.speed = r108.f455908i;
        r110.clipRotate = r108.f455909j;
        r110.clipIndex = r107;
        ((ArrayList) r103).add(r110);
        r107 = r107 + 1;
        goto L9
    L13:
        VEClipParam r111 = new VEClipParam();
        r111.clipType = r108.f455901b;
        r111.path = r108.f455902c;
        r111.trimIn = r108.f455906g;
        r111.trimOut = r108.f455907h;
        r111.speed = r108.f455908i;
        r111.clipRotate = r108.f455909j;
        r111.clipIndex = r107;
        ((ArrayList) r102).add(r111);
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static void c(List r100, List r101, List r110, List r111) {
        ArrayList r102 = (ArrayList) r100;
        boolean[] r103 = new boolean[r102.size()];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        ArrayList r107 = (ArrayList) r101;
        if (r105 >= r107.size()) goto L11;
        a r108 = (a) ListProtector.get(r107, r105);
        int r109 = r108.f455903d;
        if (r103[r109] == true) goto L8;
        r103[r109] = true;
    L9:
        r105 = r105 + 1;
        goto L3
    L8:
        VEClipParam r112 = new VEClipParam();
        r112.path = r108.f455902c;
        r112.trimIn = r108.f455906g;
        r112.trimOut = r108.f455907h;
        r112.speed = r108.f455908i;
        r112.clipRotate = r108.f455909j;
        r112.clipIndex = r105 - r106;
        r106 = r106 + 1;
        ((ArrayList) r110).add(r112);
    L11:
        if (r104 >= r102.size()) goto L13;
        VEClipParam r113 = new VEClipParam();
        r113.path = ((a) ListProtector.get(r102, r104)).f455902c;
        r113.trimIn = ((a) ListProtector.get(r102, r104)).f455906g;
        r113.trimOut = ((a) ListProtector.get(r102, r104)).f455907h;
        r113.speed = ((a) ListProtector.get(r102, r104)).f455908i;
        r113.clipRotate = ((a) ListProtector.get(r102, r104)).f455909j;
        r113.clipIndex = r104;
        ((ArrayList) r111).add(r113);
        r104 = r104 + 1;
        goto L11
    }

    public final void d(List<VEClipParam> r100, List<VEClipParam> r101, List<VEClipParam> r102, List<VEClipParam> r103) {
        VELogUtil.e("VETimeEffectManager", "deleteTimeEffect  mTrack.videoClips=" + ((ArrayList) this.f455899a.f455910a).size() + "mTrack.videoTimeEffectClips=" + ((ArrayList) this.f455899a.f455912c).size() + "mTrack.audioClips=" + ((ArrayList) this.f455899a.f455911b).size() + "mTrack.audioTimeEffectClips=" + ((ArrayList) this.f455899a.f455913d).size());
        if (((ArrayList) this.f455899a.f455910a).size() <= 0) goto L6;
        b r104 = this.f455899a;
        c(r104.f455910a, r104.f455912c, r100, r101);
    L6:
        if (((ArrayList) this.f455899a.f455911b).size() <= 0) goto L8;
        b r105 = this.f455899a;
        c(r105.f455911b, r105.f455913d, r102, r103);
    L8:
        g();
    }

    public final void a(int r210, List r310, List r311, VEBaseFilterParam r312, List r313, List r314, List r315, List r316) {
        g();
        if (r310 != null) goto L5;
    L19:
        VELogUtil.e("VETimeEffectManager", "addTimeEffect init param error");
        return;
    L5:
        if (r310.size() == 0) goto L19;
        this.f455899a.getClass();
        this.f455899a.f455914e = r210;
        int r110 = 0;
    L9:
        if (r110 >= r310.size()) goto L11;
        VEClipParam r100 = (VEClipParam) ListProtector.get(r310, r110);
        ((ArrayList) this.f455899a.f455910a).add(new a(0, r100.clipType, r100.path, r110, r100.seqIn, r100.seqOut, r100.trimIn, r100.trimOut, r100.speed, r100.clipRotate));
        r110 = r110 + 1;
        goto L9
    L11:
        int r101 = 0;
    L13:
        if (r101 >= ((ArrayList) r311).size()) goto L15;
        VEClipParam r102 = (VEClipParam) ListProtector.get(r311, r101);
        ((ArrayList) this.f455899a.f455911b).add(new a(0, r102.clipType, r102.path, r101, r102.seqIn, r102.seqOut, r102.trimIn, r102.trimOut, r102.speed, r102.clipRotate));
        r101 = r101 + 1;
        goto L13
    L15:
        b r103 = this.f455899a;
        r103.f455915f = r312;
        ((ArrayList) r103.f455912c).clear();
        b r104 = this.f455899a;
        ((ArrayList) r104.f455912c).addAll(e(r312, r104.f455910a));
        VELogUtil.e("VETimeEffectManager", "addTimeEffect  mTrack.videoClips=" + ((ArrayList) this.f455899a.f455910a).size() + " mTrack.timeEffectClips=" + ((ArrayList) this.f455899a.f455912c).size());
        b r105 = this.f455899a;
        b(r105.f455910a, r105.f455912c, r313, r314);
        ((ArrayList) this.f455899a.f455913d).clear();
        if (((ArrayList) this.f455899a.f455911b).size() <= 0) goto L23;
        b r106 = this.f455899a;
        ((ArrayList) r106.f455913d).addAll(e(r312, r106.f455911b));
        VELogUtil.e("VETimeEffectManager", "addTimeEffect  mTrack.audioClips=" + ((ArrayList) this.f455899a.f455911b).size() + " mTrack.audioTimeEffectClips=" + ((ArrayList) this.f455899a.f455913d).size());
        b r107 = this.f455899a;
        b(r107.f455911b, r107.f455913d, r315, r316);
        return;
    }
}
