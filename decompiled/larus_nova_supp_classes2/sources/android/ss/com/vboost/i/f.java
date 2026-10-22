package android.ss.com.vboost.i;

import android.content.Context;
import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.CoreCluster;
import android.ss.com.vboost.CustomScene;
import android.ss.com.vboost.FrequencyLevel;
import android.ss.com.vboost.Status;
import android.ss.com.vboost.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class f extends android.ss.com.vboost.i.a implements h {
    private static final String e = "f";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.ss.com.vboost.g.a f127c;
    private boolean d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f128a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f129b = null;

        static {
            int[] r0 = new int[CustomScene.values().length];
            f129b = r0;
            r0[CustomScene.COMMON_APP_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L73
        L155:
            f129b[CustomScene.COMMON_WINDOW_SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L74
        L173:
            f129b[CustomScene.COMMON_TAB_SWITCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L75
        L181:
            f129b[CustomScene.COMMON_CAMERA_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L76
        L185:
            f129b[CustomScene.DY_GO_DUET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L77
        L207:
            f129b[CustomScene.DY_GO_REACTION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L78
        L211:
            f129b[CustomScene.DY_TAB_LIVING_LOAD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L79
        L229:
            f129b[CustomScene.DY_TAB_NEARBY_LOAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L80
        L235:
            f129b[CustomScene.DY_TAB_FOLLOW_LOAD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L81
        L251:
            f129b[CustomScene.DY_TAB_SEARCH_LOAD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L82
        L255:
            f129b[CustomScene.DY_TAB_HOME_LOAD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L83
        L147:
            f129b[CustomScene.DY_TAB_FAMILIAR_LOAD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L84
        L153:
            f129b[CustomScene.DY_TAB_PUBLISH_LOAD.ordinal()] = 13;     // Catch: NoSuchFieldError -> L85
        L171:
            f129b[CustomScene.DY_TAB_NOTIFICATION_LOAD.ordinal()] = 14;     // Catch: NoSuchFieldError -> L86
        L177:
            f129b[CustomScene.DY_TAB_USER_LOAD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L87
        L195:
            f129b[CustomScene.DY_CONCURRENT_UPLOAD_COMPILE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L88
        L201:
            f129b[CustomScene.DY_FEED_SCROLL.ordinal()] = 17;     // Catch: NoSuchFieldError -> L89
        L221:
            f129b[CustomScene.DY_COMMENT_LOAD.ordinal()] = 18;     // Catch: NoSuchFieldError -> L90
        L225:
            f129b[CustomScene.DY_TAB_MUSIC.ordinal()] = 19;     // Catch: NoSuchFieldError -> L91
        L243:
            f129b[CustomScene.DY_15S_CAPTURE_START.ordinal()] = 20;     // Catch: NoSuchFieldError -> L92
        L247:
            f129b[CustomScene.DY_LIVING_SCROLL.ordinal()] = 21;     // Catch: NoSuchFieldError -> L93
        L139:
            f129b[CustomScene.DY_LIVING_ENTER_GIFT_PANEL.ordinal()] = 22;     // Catch: NoSuchFieldError -> L94
        L143:
            f129b[CustomScene.DY_LIVING_ENTER_GOODS_LIST.ordinal()] = 23;     // Catch: NoSuchFieldError -> L95
        L163:
            f129b[CustomScene.TO_FIRST_FRAME_DRAW.ordinal()] = 24;     // Catch: NoSuchFieldError -> L96
        L165:
            f129b[CustomScene.TO_TAB_SWITCH.ordinal()] = 25;     // Catch: NoSuchFieldError -> L97
        L187:
            f129b[CustomScene.TO_CLICK_NEWS.ordinal()] = 26;     // Catch: NoSuchFieldError -> L98
        L191:
            f129b[CustomScene.TO_SCROLL_NEWS.ordinal()] = 27;     // Catch: NoSuchFieldError -> L99
        L215:
            f129b[CustomScene.TO_VIDEO_FIRST_FRAME.ordinal()] = 28;     // Catch: NoSuchFieldError -> L100
        L217:
            f129b[CustomScene.TL_FIRST_FRAME_DRAW.ordinal()] = 29;     // Catch: NoSuchFieldError -> L101
        L237:
            f129b[CustomScene.TL_TAB_SWITCH.ordinal()] = 30;     // Catch: NoSuchFieldError -> L102
        L239:
            f129b[CustomScene.TL_CLICK_NEWS.ordinal()] = 31;     // Catch: NoSuchFieldError -> L103
        L257:
            f129b[CustomScene.TL_SCROLL_NEWS.ordinal()] = 32;     // Catch: NoSuchFieldError -> L104
        L135:
            f129b[CustomScene.DC_SCROLL_HOME.ordinal()] = 33;     // Catch: NoSuchFieldError -> L105
        L157:
            f129b[CustomScene.DC_TAB_SWITCH.ordinal()] = 34;     // Catch: NoSuchFieldError -> L106
        L159:
            f129b[CustomScene.DC_SCROLL_MOMENTS.ordinal()] = 35;     // Catch: NoSuchFieldError -> L107
        L179:
            f129b[CustomScene.DC_VIDEO_FIRST_DRAW.ordinal()] = 36;     // Catch: NoSuchFieldError -> L108
        L183:
            f129b[CustomScene.TT_GO_DUET.ordinal()] = 37;     // Catch: NoSuchFieldError -> L109
        L205:
            f129b[CustomScene.TT_GO_REACTION.ordinal()] = 38;     // Catch: NoSuchFieldError -> L110
        L209:
            f129b[CustomScene.TT_TAB_LIVING_LOAD.ordinal()] = 39;     // Catch: NoSuchFieldError -> L111
        L227:
            f129b[CustomScene.TT_TAB_NEARBY_LOAD.ordinal()] = 40;     // Catch: NoSuchFieldError -> L112
        L233:
            f129b[CustomScene.TT_TAB_FOLLOW_LOAD.ordinal()] = 41;     // Catch: NoSuchFieldError -> L113
        L249:
            f129b[CustomScene.TT_TAB_SEARCH_LOAD.ordinal()] = 42;     // Catch: NoSuchFieldError -> L114
        L253:
            f129b[CustomScene.TT_TAB_HOME_LOAD.ordinal()] = 43;     // Catch: NoSuchFieldError -> L115
        L145:
            f129b[CustomScene.TT_TAB_FAMILIAR_LOAD.ordinal()] = 44;     // Catch: NoSuchFieldError -> L116
        L151:
            f129b[CustomScene.TT_TAB_PUBLISH_LOAD.ordinal()] = 45;     // Catch: NoSuchFieldError -> L117
        L169:
            f129b[CustomScene.TT_TAB_NOTIFICATION_LOAD.ordinal()] = 46;     // Catch: NoSuchFieldError -> L118
        L175:
            f129b[CustomScene.TT_TAB_USER_LOAD.ordinal()] = 47;     // Catch: NoSuchFieldError -> L119
        L193:
            f129b[CustomScene.TT_CONCURRENT_UPLOAD_COMPILE.ordinal()] = 48;     // Catch: NoSuchFieldError -> L120
        L199:
            f129b[CustomScene.TT_FEED_SCROLL.ordinal()] = 49;     // Catch: NoSuchFieldError -> L121
        L219:
            f129b[CustomScene.TT_COMMENT_LOAD.ordinal()] = 50;     // Catch: NoSuchFieldError -> L122
        L223:
            f129b[CustomScene.TT_TAB_MUSIC.ordinal()] = 51;     // Catch: NoSuchFieldError -> L123
        L241:
            f129b[CustomScene.TT_15S_CAPTURE_START.ordinal()] = 52;     // Catch: NoSuchFieldError -> L124
        L245:
            f129b[CustomScene.TT_LIVING_SCROLL.ordinal()] = 53;     // Catch: NoSuchFieldError -> L125
        L137:
            f129b[CustomScene.TT_LIVING_ENTER_GIFT_PANEL.ordinal()] = 54;     // Catch: NoSuchFieldError -> L126
        L141:
            f129b[CustomScene.TT_LIVING_ENTER_GOODS_LIST.ordinal()] = 55;     // Catch: NoSuchFieldError -> L127
        L64:
            int[] r7 = new int[CapabilityType.values().length];
            f128a = r7;
            r7[CapabilityType.CPU_FREQ_MIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L128
        L167:
            f128a[CapabilityType.GPU_FREQ_MIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L129
        L189:
            f128a[CapabilityType.UFS_FREQ_MIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L130
        L197:
            f128a[CapabilityType.TASK_PRIORITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L131
        L203:
            f128a[CapabilityType.CPU_AFFINITY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L132
        L213:
            f128a[CapabilityType.VIBRATE_ENHANCE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L133
        L231:
            f128a[CapabilityType.PRESET_SCENE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L134
            return;
        }
    }

    public f(Context r2) {
        this.d = false;
        if (android.ss.com.vboost.h.d.a(r2) == false) goto L6;
        this.d = android.ss.com.vboost.h.j.a(r2);
        b();
        c();
        LogUtil.info(e, "registered.");
        return;
    }

    private void b() {
        HashSet r0 = new HashSet();
        if (d() == false) goto L6;
        r0.add(CapabilityType.CPU_FREQ_MIN);
        r0.add(CapabilityType.GPU_FREQ_MIN);
    L6:
        if (e() == false) goto L9;
        r0.add(CapabilityType.UFS_FREQ_MIN);
    L9:
        if (f() == false) goto L11;
        r0.add(CapabilityType.VIBRATE_ENHANCE);
    L11:
        r0.add(CapabilityType.PRESET_SCENE);
        r0.add(CapabilityType.TASK_PRIORITY);
        r0.add(CapabilityType.CPU_AFFINITY);
        a(r0);
        android.ss.com.vboost.g.a r1 = android.ss.com.vboost.g.a.b();
        this.f127c = r1;
        r1.a(r0);
        Iterator r2 = r0.iterator();
    L13:
        if (r2.hasNext() == false) goto L20;
        CapabilityType r3 = (CapabilityType) r2.next();
        switch(a.f128a[r3.ordinal()]) {
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L13;
            case 7: goto L13;
            default: goto L16;
        };
    L16:
        LogUtil.error(e, "PlatformProvider not support this capability " + r3);
        goto L13
    L17:
        this.f127c.a(android.ss.com.vboost.g.b.f57b);
        goto L13
    L18:
        this.f127c.a(new android.ss.com.vboost.g.d(-20, 19, 1));
        goto L13
    L19:
        android.ss.com.vboost.g.c r4 = new android.ss.com.vboost.g.c(false, 0, 0, true, Integer.MAX_VALUE, false, 0);
        ArrayList r5 = new ArrayList();
        r5.add(r4);
        this.f127c.a(r3, r5);
        goto L13
    }

    private void c() {
        HashMap r0 = new HashMap();
        FrequencyLevel r1 = FrequencyLevel.LEVEL_9;
        g r3 = g.f131b;
        r0.put(r1, new d(0, Integer.MAX_VALUE, r3, r1));
        FrequencyLevel r2 = FrequencyLevel.LEVEL_8;
        r0.put(r2, new d(0, Integer.MAX_VALUE, r3, r2));
        FrequencyLevel r6 = FrequencyLevel.LEVEL_7;
        r0.put(r6, new d(0, Integer.MAX_VALUE, r3, r6));
        FrequencyLevel r7 = FrequencyLevel.LEVEL_6;
        r0.put(r7, new d(0, Integer.MAX_VALUE, r3, r7));
        FrequencyLevel r8 = FrequencyLevel.LEVEL_5;
        r0.put(r8, new d(0, Integer.MAX_VALUE, r3, r8));
        FrequencyLevel r9 = FrequencyLevel.LEVEL_4;
        r0.put(r9, new d(0, Integer.MAX_VALUE, r3, r9));
        FrequencyLevel r10 = FrequencyLevel.LEVEL_3;
        r0.put(r10, new d(0, Integer.MAX_VALUE, r3, r10));
        FrequencyLevel r11 = FrequencyLevel.LEVEL_2;
        r0.put(r11, new d(0, Integer.MAX_VALUE, r3, r11));
        FrequencyLevel r12 = FrequencyLevel.LEVEL_1;
        r0.put(r12, new d(0, Integer.MAX_VALUE, r3, r12));
        FrequencyLevel r13 = FrequencyLevel.LEVEL_0;
        r0.put(r13, new d(0, Integer.MAX_VALUE, r3, r13));
        k.a().a(r3, CapabilityType.CPU_FREQ_MIN, r0);
        HashMap r4 = new HashMap();
        r4.put(r1, new d(0, Integer.MAX_VALUE, r3, r1));
        r4.put(r2, new d(0, Integer.MAX_VALUE, r3, r2));
        r4.put(r6, new d(0, Integer.MAX_VALUE, r3, r6));
        r4.put(r7, new d(0, Integer.MAX_VALUE, r3, r7));
        r4.put(r8, new d(0, Integer.MAX_VALUE, r3, r8));
        r4.put(r9, new d(0, Integer.MAX_VALUE, r3, r9));
        r4.put(r10, new d(0, Integer.MAX_VALUE, r3, r10));
        r4.put(r11, new d(0, Integer.MAX_VALUE, r3, r11));
        r4.put(r12, new d(0, Integer.MAX_VALUE, r3, r12));
        r4.put(r13, new d(0, Integer.MAX_VALUE, r3, r13));
        k.a().a(r3, CapabilityType.GPU_FREQ_MIN, r4);
        HashMap r5 = new HashMap();
        r5.put(r1, new d(0, Integer.MAX_VALUE, r3, r1));
        r5.put(r2, new d(0, Integer.MAX_VALUE, r3, r2));
        r5.put(r6, new d(0, Integer.MAX_VALUE, r3, r6));
        r5.put(r7, new d(0, Integer.MAX_VALUE, r3, r7));
        r5.put(r8, new d(0, Integer.MAX_VALUE, r3, r8));
        r5.put(r9, new d(0, Integer.MAX_VALUE, r3, r9));
        r5.put(r10, new d(0, Integer.MAX_VALUE, r3, r10));
        r5.put(r11, new d(0, Integer.MAX_VALUE, r3, r11));
        r5.put(r12, new d(0, Integer.MAX_VALUE, r3, r12));
        r5.put(r13, new d(0, Integer.MAX_VALUE, r3, r13));
        k.a().a(r3, CapabilityType.UFS_FREQ_MIN, r5);
        HashMap r14 = new HashMap();
        r14.put(r1, new d(-20, Integer.MAX_VALUE, r3, r1));
        r14.put(r2, new d(-16, Integer.MAX_VALUE, r3, r2));
        r14.put(r6, new d(-12, Integer.MAX_VALUE, r3, r6));
        r14.put(r7, new d(-8, Integer.MAX_VALUE, r3, r7));
        r14.put(r8, new d(-4, Integer.MAX_VALUE, r3, r8));
        r14.put(r9, new d(0, Integer.MAX_VALUE, r3, r9));
        r14.put(r10, new d(4, Integer.MAX_VALUE, r3, r10));
        r14.put(r11, new d(8, Integer.MAX_VALUE, r3, r11));
        r14.put(r12, new d(12, Integer.MAX_VALUE, r3, r12));
        r14.put(r13, new d(19, Integer.MAX_VALUE, r3, r13));
        k.a().a(r3, CapabilityType.TASK_PRIORITY, r14);
    }

    private void d(i r3) {
        android.ss.com.vboost.d r4 = r3.e;
        int r0 = r4.f51a;
        if (r0 == (-1)) goto L16;
        if (r0 != 0) goto L6;
        android.ss.com.vboost.h.j.d();
        return;
    L6:
        if (r0 != 1) goto L8;
        android.ss.com.vboost.h.j.a(r4.f52b, r4.f53c);
        return;
    L8:
        if (r0 != 2) goto L10;
        android.ss.com.vboost.h.j.a(r4.f52b, r4.f53c, r4.d);
        return;
    L10:
        if (r0 == 3) goto L12;
        LogUtil.error(e, "unsupport vibrator scene !");
        return;
    L12:
        android.ss.com.vboost.h.j.a(r4.e);
        return;
    L16:
        android.ss.com.vboost.h.j.c();
    }

    private boolean d() {
        android.ss.com.vboost.h.e.a r0 = android.ss.com.vboost.h.e.b();
        if (r0 != android.ss.com.vboost.h.e.a.f79b) goto L5;
    L10:
        return true;
    L5:
        if (r0 == android.ss.com.vboost.h.e.a.f80c) goto L10;
        if (r0 == android.ss.com.vboost.h.e.a.d) goto L10;
        return false;
    }

    private boolean e() {
        if (android.ss.com.vboost.h.e.b() != android.ss.com.vboost.h.e.a.f79b) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean f() {
        return this.d;
    }

    @Override // android.ss.com.vboost.i.h
    public Object a(i r4) {
        switch(a.f128a[r4.f133a.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        LogUtil.warn(e, "Not implement this capability type by Platform provider!!!");
    L12:
        return 1;
    L5:
        android.ss.com.vboost.h.d.c();
        LogUtil.info(e, "release boost for " + r4.d.f139a.getDesc());
        goto L12
    L6:
        android.ss.com.vboost.h.j.d();
        goto L12
    L7:
        String r0 = e;
        StringBuilder r2 = new StringBuilder("reset tid:");
        r2.append(r4.f138h);
        String r5 = " core bind";
    L9:
        r2.append(r5);
        LogUtil.debug(r0, r2.toString());
        goto L12
    L8:
        r0 = e;
        r2 = new StringBuilder("reset tid:");
        r2.append(r4.f138h);
        r5 = " priority";
        goto L9
    L10:
        android.ss.com.vboost.h.d.c();
        goto L12
    }

    @Override // android.ss.com.vboost.i.h
    public boolean a(CapabilityType r2) {
        android.ss.com.vboost.g.a r0 = this.f127c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a().contains(r2) == false) goto L7;
        return true;
    }

    @Override // android.ss.com.vboost.i.h
    public Object b(i r4) {
        switch(a.f128a[r4.f133a.ordinal()]) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L18;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        LogUtil.warn(e, "Not implement this capability type by Platform provider!!!");
    L28:
        return 1;
    L5:
        c(r4);
        goto L28
    L6:
        d(r4);
        goto L28
    L7:
        CoreCluster r0 = r4.f137g;
        if (r0 != CoreCluster.GOLD) goto L10;
    L15:
        String r1 = e;
        StringBuilder r2 = new StringBuilder("bind tid:");
        r2.append(r4.f138h);
        String r5 = " to big core";
    L16:
        r2.append(r5);
    L17:
        LogUtil.debug(r1, r2.toString());
        goto L28
    L10:
        if (r0 == CoreCluster.SUPER) goto L15;
        if (r0 != CoreCluster.SILVER) goto L28;
        r1 = e;
        r2 = new StringBuilder("bind tid:");
        r2.append(r4.f138h);
        r5 = " to little core";
        goto L16
    L18:
        int r3 = r4.f135c;
        if (r3 <= 19) goto L21;
    L22:
        LogUtil.warn(e, "your request level is out of range:[-19,20]");
    L23:
        r1 = e;
        r2 = new StringBuilder("set tid:");
        r2.append(r4.f138h);
        r2.append(" to priority ");
        r2.append(r4.f135c);
        goto L17
    L21:
        if (r3 >= (-20)) goto L23;
    L24:
        android.ss.com.vboost.h.d.c(r4.f136f);
        goto L28
    L25:
        android.ss.com.vboost.h.d.b(r4.f136f);
        goto L28
    L26:
        android.ss.com.vboost.h.d.a(r4.f136f);
        goto L28
    }

    public int c(i r4) {
        j r5 = r4.d;
        String r0 = e;
        LogUtil.info(r0, "Platform provider process scene " + r5.f139a.getDesc());
        switch(a.f129b[r5.f139a.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L7;
            case 19: goto L7;
            case 20: goto L7;
            case 21: goto L7;
            case 22: goto L7;
            case 23: goto L7;
            case 24: goto L7;
            case 25: goto L7;
            case 26: goto L7;
            case 27: goto L7;
            case 28: goto L7;
            case 29: goto L7;
            case 30: goto L7;
            case 31: goto L7;
            case 32: goto L7;
            case 33: goto L7;
            case 34: goto L7;
            case 35: goto L7;
            case 36: goto L7;
            case 37: goto L7;
            case 38: goto L7;
            case 39: goto L7;
            case 40: goto L7;
            case 41: goto L7;
            case 42: goto L7;
            case 43: goto L7;
            case 44: goto L7;
            case 45: goto L7;
            case 46: goto L7;
            case 47: goto L7;
            case 48: goto L7;
            case 49: goto L7;
            case 50: goto L7;
            case 51: goto L7;
            case 52: goto L7;
            case 53: goto L7;
            case 54: goto L7;
            case 55: goto L7;
            default: goto L4;
        };
    L4:
        LogUtil.warn(r0, "this scene is not support!!!");
        return 0;
    L7:
        if (r5.f140b != Status.BEGIN) goto L9;
        LogUtil.debug(r0, "begin boost for " + r5.f139a.getDesc());
        android.ss.com.vboost.h.d.d();
        return 1;
    L9:
        LogUtil.debug(r0, "end boost for " + r5.f139a.getDesc());
        android.ss.com.vboost.h.d.c();
        return 1;
    }
}
