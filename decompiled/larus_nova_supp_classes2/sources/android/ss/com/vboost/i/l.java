package android.ss.com.vboost.i;

import android.content.Context;
import android.os.Build;
import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.CoreCluster;
import android.ss.com.vboost.CustomScene;
import android.ss.com.vboost.FrequencyLevel;
import android.ss.com.vboost.utils.LogUtil;
import com.samsung.sdk.sperf.CustomParams;
import com.samsung.sdk.sperf.PerformanceManager;
import com.samsung.sdk.sperf.SPerf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class l extends android.ss.com.vboost.i.a implements h {
    private static final String e = "l";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f144f = 6000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PerformanceManager f145c;
    private android.ss.com.vboost.g.a d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f147b = null;

        static {
            int[] r0 = new int[CustomScene.values().length];
            f147b = r0;
            r0[CustomScene.COMMON_APP_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L83
        L174:
            f147b[CustomScene.COMMON_WINDOW_SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L84
        L192:
            f147b[CustomScene.COMMON_TAB_SWITCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L85
        L200:
            f147b[CustomScene.COMMON_CAMERA_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L86
        L204:
            f147b[CustomScene.DY_GO_DUET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L87
        L226:
            f147b[CustomScene.DY_GO_REACTION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L88
        L230:
            f147b[CustomScene.DY_TAB_LIVING_LOAD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L89
        L248:
            f147b[CustomScene.DY_TAB_NEARBY_LOAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L90
        L254:
            f147b[CustomScene.DY_TAB_FOLLOW_LOAD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L91
        L276:
            f147b[CustomScene.DY_TAB_SEARCH_LOAD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L92
        L280:
            f147b[CustomScene.DY_TAB_HOME_LOAD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L93
        L164:
            f147b[CustomScene.DY_TAB_FAMILIAR_LOAD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L94
        L172:
            f147b[CustomScene.DY_TAB_PUBLISH_LOAD.ordinal()] = 13;     // Catch: NoSuchFieldError -> L95
        L190:
            f147b[CustomScene.DY_TAB_NOTIFICATION_LOAD.ordinal()] = 14;     // Catch: NoSuchFieldError -> L96
        L196:
            f147b[CustomScene.DY_TAB_USER_LOAD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L97
        L214:
            f147b[CustomScene.DY_CONCURRENT_UPLOAD_COMPILE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L98
        L220:
            f147b[CustomScene.DY_FEED_SCROLL.ordinal()] = 17;     // Catch: NoSuchFieldError -> L99
        L240:
            f147b[CustomScene.DY_COMMENT_LOAD.ordinal()] = 18;     // Catch: NoSuchFieldError -> L100
        L244:
            f147b[CustomScene.DY_TAB_MUSIC.ordinal()] = 19;     // Catch: NoSuchFieldError -> L101
        L266:
            f147b[CustomScene.DY_15S_CAPTURE_START.ordinal()] = 20;     // Catch: NoSuchFieldError -> L102
        L270:
            f147b[CustomScene.DY_LIVING_SCROLL.ordinal()] = 21;     // Catch: NoSuchFieldError -> L103
        L154:
            f147b[CustomScene.DY_LIVING_ENTER_GIFT_PANEL.ordinal()] = 22;     // Catch: NoSuchFieldError -> L104
        L160:
            f147b[CustomScene.DY_LIVING_ENTER_GOODS_LIST.ordinal()] = 23;     // Catch: NoSuchFieldError -> L105
        L182:
            f147b[CustomScene.TO_FIRST_FRAME_DRAW.ordinal()] = 24;     // Catch: NoSuchFieldError -> L106
        L184:
            f147b[CustomScene.TO_TAB_SWITCH.ordinal()] = 25;     // Catch: NoSuchFieldError -> L107
        L206:
            f147b[CustomScene.TO_CLICK_NEWS.ordinal()] = 26;     // Catch: NoSuchFieldError -> L108
        L210:
            f147b[CustomScene.TO_SCROLL_NEWS.ordinal()] = 27;     // Catch: NoSuchFieldError -> L109
        L234:
            f147b[CustomScene.TO_VIDEO_FIRST_FRAME.ordinal()] = 28;     // Catch: NoSuchFieldError -> L110
        L236:
            f147b[CustomScene.TL_FIRST_FRAME_DRAW.ordinal()] = 29;     // Catch: NoSuchFieldError -> L111
        L256:
            f147b[CustomScene.TL_TAB_SWITCH.ordinal()] = 30;     // Catch: NoSuchFieldError -> L112
        L260:
            f147b[CustomScene.TL_CLICK_NEWS.ordinal()] = 31;     // Catch: NoSuchFieldError -> L113
        L282:
            f147b[CustomScene.TL_SCROLL_NEWS.ordinal()] = 32;     // Catch: NoSuchFieldError -> L114
        L150:
            f147b[CustomScene.DC_SCROLL_HOME.ordinal()] = 33;     // Catch: NoSuchFieldError -> L115
        L176:
            f147b[CustomScene.DC_TAB_SWITCH.ordinal()] = 34;     // Catch: NoSuchFieldError -> L116
        L178:
            f147b[CustomScene.DC_SCROLL_MOMENTS.ordinal()] = 35;     // Catch: NoSuchFieldError -> L117
        L198:
            f147b[CustomScene.DC_VIDEO_FIRST_DRAW.ordinal()] = 36;     // Catch: NoSuchFieldError -> L118
        L202:
            f147b[CustomScene.TT_GO_DUET.ordinal()] = 37;     // Catch: NoSuchFieldError -> L119
        L224:
            f147b[CustomScene.TT_GO_REACTION.ordinal()] = 38;     // Catch: NoSuchFieldError -> L120
        L228:
            f147b[CustomScene.TT_TAB_LIVING_LOAD.ordinal()] = 39;     // Catch: NoSuchFieldError -> L121
        L246:
            f147b[CustomScene.TT_TAB_NEARBY_LOAD.ordinal()] = 40;     // Catch: NoSuchFieldError -> L122
        L252:
            f147b[CustomScene.TT_TAB_FOLLOW_LOAD.ordinal()] = 41;     // Catch: NoSuchFieldError -> L123
        L274:
            f147b[CustomScene.TT_TAB_SEARCH_LOAD.ordinal()] = 42;     // Catch: NoSuchFieldError -> L124
        L278:
            f147b[CustomScene.TT_TAB_HOME_LOAD.ordinal()] = 43;     // Catch: NoSuchFieldError -> L125
        L162:
            f147b[CustomScene.TT_TAB_FAMILIAR_LOAD.ordinal()] = 44;     // Catch: NoSuchFieldError -> L126
        L170:
            f147b[CustomScene.TT_TAB_PUBLISH_LOAD.ordinal()] = 45;     // Catch: NoSuchFieldError -> L127
        L188:
            f147b[CustomScene.TT_TAB_NOTIFICATION_LOAD.ordinal()] = 46;     // Catch: NoSuchFieldError -> L128
        L194:
            f147b[CustomScene.TT_TAB_USER_LOAD.ordinal()] = 47;     // Catch: NoSuchFieldError -> L129
        L212:
            f147b[CustomScene.TT_CONCURRENT_UPLOAD_COMPILE.ordinal()] = 48;     // Catch: NoSuchFieldError -> L130
        L218:
            f147b[CustomScene.TT_FEED_SCROLL.ordinal()] = 49;     // Catch: NoSuchFieldError -> L131
        L238:
            f147b[CustomScene.TT_COMMENT_LOAD.ordinal()] = 50;     // Catch: NoSuchFieldError -> L132
        L242:
            f147b[CustomScene.TT_TAB_MUSIC.ordinal()] = 51;     // Catch: NoSuchFieldError -> L133
        L264:
            f147b[CustomScene.TT_15S_CAPTURE_START.ordinal()] = 52;     // Catch: NoSuchFieldError -> L134
        L268:
            f147b[CustomScene.TT_LIVING_SCROLL.ordinal()] = 53;     // Catch: NoSuchFieldError -> L135
        L152:
            f147b[CustomScene.TT_LIVING_ENTER_GIFT_PANEL.ordinal()] = 54;     // Catch: NoSuchFieldError -> L136
        L158:
            f147b[CustomScene.TT_LIVING_ENTER_GOODS_LIST.ordinal()] = 55;     // Catch: NoSuchFieldError -> L137
        L69:
            int[] r12 = new int[CapabilityType.values().length];
            f146a = r12;
            r12[CapabilityType.CPU_FREQ_MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L138
        L186:
            f146a[CapabilityType.GPU_FREQ_MAX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L139
        L208:
            f146a[CapabilityType.BUS_FREQ_MAX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L140
        L216:
            f146a[CapabilityType.CPU_FREQ_MIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L141
        L222:
            f146a[CapabilityType.GPU_FREQ_MIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L142
        L232:
            f146a[CapabilityType.BUS_FREQ_MIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L143
        L250:
            f146a[CapabilityType.CPU_CORE_MAX.ordinal()] = 7;     // Catch: NoSuchFieldError -> L144
        L258:
            f146a[CapabilityType.CPU_CORE_MIN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L145
        L262:
            f146a[CapabilityType.TASK_PRIORITY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L146
        L272:
            f146a[CapabilityType.CPU_AFFINITY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L147
        L156:
            f146a[CapabilityType.PRESET_SCENE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L148
        L168:
            f146a[CapabilityType.IDLE_STATE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L149
            return;
        }
    }

    private l(Context r3) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return;
    L5:
        if (SPerf.initialize(r3) == false) goto L11;
        PerformanceManager r4 = PerformanceManager.getInstance();
        this.f145c = r4;
        if (r4 == null) goto L12;
        b();
        c();
        android.ss.com.vboost.i.a.f114b = true;
        LogUtil.info(e, "registered.");
        return;
    L12:
        return;
    }

    private int a(int r5, int r6) {
        if (r5 >= 0) goto L5;
    L20:
        LogUtil.error(e, "request capability type err!!!");
        return -1;
    L5:
        if (r5 > 2) goto L20;
        PerformanceManager r2 = this.f145c;
        if (r2 != null) goto L10;
        return -1;
    L10:
        int r0 = 64;
        if (r5 == 0) goto L19;
        if (r5 == 1) goto L17;
        if (r5 != 2) goto L19;
        r0 = 256;
        goto L19
    L17:
        r0 = 128;
    L19:
        return r2.start(r0, r6);
    }

    public static l a(Context r1) {
        l r0 = new l(r1);
        if (android.ss.com.vboost.i.a.f114b == true) goto L6;
        return null;
    L6:
        return r0;
    }

    private void b() {
        HashSet r0 = new HashSet();
        r0.add(CapabilityType.PRESET_SCENE);
        r0.add(CapabilityType.CPU_FREQ_MIN);
        r0.add(CapabilityType.CPU_FREQ_MAX);
        r0.add(CapabilityType.CPU_CORE_MIN);
        r0.add(CapabilityType.CPU_CORE_MAX);
        r0.add(CapabilityType.GPU_FREQ_MIN);
        r0.add(CapabilityType.GPU_FREQ_MAX);
        r0.add(CapabilityType.BUS_FREQ_MIN);
        r0.add(CapabilityType.BUS_FREQ_MAX);
        r0.add(CapabilityType.TASK_PRIORITY);
        r0.add(CapabilityType.CPU_AFFINITY);
        r0.add(CapabilityType.IDLE_STATE);
        a(r0);
        android.ss.com.vboost.g.a r1 = android.ss.com.vboost.g.a.b();
        this.d = r1;
        r1.a(r0);
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        CapabilityType r3 = (CapabilityType) r2.next();
        switch(a.f146a[r3.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L4;
            case 12: goto L4;
            default: goto L7;
        };
    L7:
        LogUtil.error(e, "SsCapabilityProvider not support this capability " + r3);
        goto L4
    L8:
        this.d.a(android.ss.com.vboost.g.b.f57b);
        goto L4
    L9:
        this.d.a(new android.ss.com.vboost.g.d(0, 5, 1));
        goto L4
    L10:
        android.ss.com.vboost.g.c r4 = new android.ss.com.vboost.g.c(true, 0, 5, true, 1000, false, 0);
        ArrayList r5 = new ArrayList();
        r5.add(r4);
        this.d.a(r3, r5);
        goto L4
    }

    private void c() {
        HashMap r0 = new HashMap();
        FrequencyLevel r1 = FrequencyLevel.LEVEL_9;
        g r3 = g.f131b;
        r0.put(r1, new d(0, Integer.MAX_VALUE, r3, r1));
        FrequencyLevel r2 = FrequencyLevel.LEVEL_8;
        r0.put(r2, new d(0, Integer.MAX_VALUE, r3, r2));
        FrequencyLevel r6 = FrequencyLevel.LEVEL_7;
        g r8 = g.f130a;
        r0.put(r6, new d(3, 1000, r8, r2));
        FrequencyLevel r7 = FrequencyLevel.LEVEL_6;
        r0.put(r7, new d(3, 1000, r8, r2));
        FrequencyLevel r11 = FrequencyLevel.LEVEL_5;
        r0.put(r11, new d(2, 1000, r8, r11));
        FrequencyLevel r12 = FrequencyLevel.LEVEL_4;
        r0.put(r12, new d(2, 1000, r8, r12));
        FrequencyLevel r14 = FrequencyLevel.LEVEL_3;
        r0.put(r14, new d(1, 1000, r8, r14));
        FrequencyLevel r15 = FrequencyLevel.LEVEL_2;
        r0.put(r15, new d(1, 1000, r8, r15));
        FrequencyLevel r9 = FrequencyLevel.LEVEL_1;
        r0.put(r9, new d(0, 1000, r8, r9));
        FrequencyLevel r13 = FrequencyLevel.LEVEL_0;
        r0.put(r13, new d(0, 1000, r8, r13));
        k.a().a(r8, CapabilityType.CPU_FREQ_MIN, r0);
        k.a().a(r8, CapabilityType.CPU_FREQ_MAX, r0);
        HashMap r4 = new HashMap();
        r4.put(r1, new d(0, Integer.MAX_VALUE, r3, r1));
        r4.put(r2, new d(0, Integer.MAX_VALUE, r3, r2));
        r4.put(r6, new d(3, 1000, r8, r2));
        r4.put(r7, new d(3, 1000, r8, r2));
        r4.put(r11, new d(2, 1000, r8, r11));
        r4.put(r12, new d(2, 1000, r8, r12));
        r4.put(r14, new d(1, 1000, r8, r14));
        r4.put(r15, new d(1, 1000, r8, r15));
        r4.put(r9, new d(0, 1000, r8, r9));
        r4.put(r13, new d(0, 1000, r8, r13));
        k.a().a(r8, CapabilityType.GPU_FREQ_MIN, r4);
        k.a().a(r8, CapabilityType.GPU_FREQ_MAX, r4);
        HashMap r5 = new HashMap();
        r5.put(r1, new d(3, 1000, r8, r1));
        r5.put(r2, new d(3, 1000, r8, r2));
        r5.put(r6, new d(2, 1000, r8, r6));
        r5.put(r7, new d(2, 1000, r8, r7));
        r5.put(r11, new d(2, 1000, r8, r11));
        r5.put(r12, new d(1, 1000, r8, r12));
        r5.put(r14, new d(1, 1000, r8, r14));
        r5.put(r15, new d(1, 1000, r8, r15));
        r5.put(r9, new d(0, 1000, r8, r9));
        r5.put(r13, new d(0, 1000, r8, r13));
        k.a().a(r8, CapabilityType.BUS_FREQ_MIN, r5);
        k.a().a(r8, CapabilityType.BUS_FREQ_MAX, r5);
        HashMap r10 = new HashMap();
        r10.put(r1, new d(4, 99999999, r8, r1));
        r10.put(r2, new d(4, 99999999, r8, r2));
        r10.put(r6, new d(3, 99999999, r8, r6));
        r10.put(r7, new d(3, 99999999, r8, r7));
        r10.put(r11, new d(2, 99999999, r8, r11));
        r10.put(r12, new d(2, 99999999, r8, r12));
        r10.put(r14, new d(1, 99999999, r8, r14));
        r10.put(r15, new d(1, 99999999, r8, r15));
        r10.put(r9, new d(0, 99999999, r8, r9));
        r10.put(r13, new d(0, 99999999, r8, r13));
        k.a().a(r8, CapabilityType.TASK_PRIORITY, r10);
    }

    @Override // android.ss.com.vboost.i.h
    public Object a(i r5) {
        String r0 = e;
        LogUtil.debug(r0, "restore ability " + r5.f133a.toString());
        if (this.f145c != null) goto L6;
        return null;
    L6:
        int r1 = a.f146a[r5.f133a.ordinal()];
        if (r1 == 10) goto L14;
        switch(r1) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            default: goto L10;
        };
    L11:
        int r6 = this.f145c.stop();
    L13:
        return Integer.valueOf(r6);
    L10:
        return 0;
    L14:
        LogUtil.debug(r0, "reset tid:" + r5.f138h + " core bind");
        CustomParams r7 = new CustomParams();
        r7.add(8, 0, 99999999);
        r6 = this.f145c.start(r7);
        goto L13
    }

    @Override // android.ss.com.vboost.i.h
    public boolean a(CapabilityType r2) {
        android.ss.com.vboost.g.a r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a().contains(r2) == false) goto L7;
        return true;
    }

    @Override // android.ss.com.vboost.i.h
    public Object b(i r8) {
        if (this.f145c != null) goto L7;
        return null;
    L7:
        switch(a.f146a[r8.f133a.ordinal()]) {
            case 1: goto L45;
            case 2: goto L43;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L35;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L24;
            case 10: goto L14;
            case 11: goto L12;
            case 12: goto L10;
            default: goto L8;
        };
    L8:
        LogUtil.warn(e, "not implement by ss provider!");
        return 0;
    L10:
        CustomParams r0 = new CustomParams();
        r0.add(10, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r0));
    L12:
        c(r8);
        return 1;
    L14:
        CoreCluster r1 = r8.f137g;
        if (r1 != CoreCluster.GOLD) goto L17;
    L21:
        LogUtil.debug(e, "bind tid:" + r8.f138h + " to big core");
        CustomParams r9 = new CustomParams();
        r9.add(8, 1, 99999999);
        return Integer.valueOf(this.f145c.start(r9));
    L17:
        if (r1 == CoreCluster.SUPER) goto L21;
        LogUtil.debug(e, "bind tid:" + r8.f138h + " to little core");
        CustomParams r10 = new CustomParams();
        r10.add(8, 2, 99999999);
        return Integer.valueOf(this.f145c.start(r10));
    L31:
        CustomParams r2 = new CustomParams();
        r2.add(6, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r2));
    L33:
        CustomParams r3 = new CustomParams();
        r3.add(7, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r3));
    L35:
        CustomParams r4 = new CustomParams();
        r4.add(4, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r4));
    L37:
        CustomParams r5 = new CustomParams();
        r5.add(2, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r5));
    L39:
        CustomParams r6 = new CustomParams();
        r6.add(0, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r6));
    L41:
        CustomParams r7 = new CustomParams();
        r7.add(5, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r7));
    L43:
        CustomParams r11 = new CustomParams();
        r11.add(3, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r11));
    L45:
        CustomParams r12 = new CustomParams();
        r12.add(1, r8.f135c, (int) r8.f136f);
        return Integer.valueOf(this.f145c.start(r12));
    L24:
        if (r8.f135c <= 5) goto L27;
        r8.f135c = 5;
    L27:
        if (r8.f135c >= 0) goto L29;
        r8.f135c = 0;
    L29:
        CustomParams r13 = new CustomParams();
        r13.add(9, r8.f135c, 99999999);
        return Integer.valueOf(this.f145c.start(r13));
    }

    public int c(i r4) {
        j r5 = r4.d;
        String r0 = e;
        LogUtil.info(r0, "SamSung provider process scene " + r5.f139a.getDesc());
        switch(a.f147b[r5.f139a.ordinal()]) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L6;
            case 24: goto L6;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L6;
            case 28: goto L6;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L6;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L6;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L6;
            case 38: goto L6;
            case 39: goto L6;
            case 40: goto L6;
            case 41: goto L6;
            case 42: goto L6;
            case 43: goto L6;
            case 44: goto L6;
            case 45: goto L6;
            case 46: goto L6;
            case 47: goto L6;
            case 48: goto L6;
            case 49: goto L6;
            case 50: goto L6;
            case 51: goto L6;
            case 52: goto L6;
            case 53: goto L6;
            case 54: goto L6;
            case 55: goto L6;
            default: goto L4;
        };
    L4:
        LogUtil.warn(r0, "this scene is not support!!!");
        return 0;
    L6:
        a(0, f144f);
        a(1, f144f);
        return a(2, f144f);
    }
}
