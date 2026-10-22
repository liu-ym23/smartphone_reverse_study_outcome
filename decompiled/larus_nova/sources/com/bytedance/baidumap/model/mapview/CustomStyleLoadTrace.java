package com.bytedance.baidumap.model.mapview;

import android.os.SystemClock;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes7.dex */
public final class CustomStyleLoadTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f199503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f199505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f199506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f199507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public StyleSource f199508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f199509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f199510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f199511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f199512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f199513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f199514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f199515m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f199516n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f199517o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f199518p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f199519q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f199520r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f199521s;

    public static final enum StyleSource extends Enum<StyleSource> {
        public static final StyleSource LOCAL = null;
        public static final StyleSource MIXED = null;
        public static final StyleSource ONLINE = null;
        public static final StyleSource UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StyleSource[] f199522a = null;
        private final String value;

        static {
            StyleSource r100 = new StyleSource("ONLINE", 0, "online");
            ONLINE = r100;
            StyleSource r101 = new StyleSource(AccountType.LOCAL, 1, "local");
            LOCAL = r101;
            StyleSource r102 = new StyleSource("MIXED", 2, LiveVrEffectInfo.STREAM_FORMAT_LITE_MODE_6DOF_OFF_MIXED);
            MIXED = r102;
            StyleSource r103 = new StyleSource("UNKNOWN", 3, "unknown");
            UNKNOWN = r103;
            f199522a = new StyleSource[]{r100, r101, r102, r103};
        }

        public static StyleSource[] values() {
            return (StyleSource[]) f199522a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static StyleSource valueOf(String r100) {
            return (StyleSource) r27.a.a(StyleSource.class, r100);
        }

        public StyleSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public final void c() {
        if (this.f199510h.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        int r100 = this.f199503a;
        String r101 = this.f199507e;
        String r102 = this.f199504b;
        String r103 = this.f199505c;
        StyleSource r104 = this.f199508f;
        if (r104 != null) goto L8;
        String r105 = "";
    L9:
        String r106 = r105;
        String r107 = this.f199511i;
        String r108 = this.f199512j;
        boolean r109 = this.f199506d;
        boolean r110 = this.f199513k;
        String r111 = this.f199514l;
        Integer r112 = this.f199515m;
        String r113 = this.f199516n;
        if (EventConstant.Value.RETRY.equals(r107) == false) goto L12;
        Integer r114 = this.f199519q;
    L14:
        if (EventConstant.Value.RETRY.equals(this.f199511i) == false) goto L16;
        String r115 = this.f199520r;
    L17:
        String r116 = r115;
        if (EventConstant.Value.RETRY.equals(this.f199511i) == false) goto L20;
        long r117 = this.f199521s;
    L21:
        Integer r118 = r114;
        MapMonitor.customMapStyleTrace(r100, r101, r102, r103, r106, r107, r108, r109, r110, r111, r112, r113, r118, r116, r117, this.f199517o, SystemClock.elapsedRealtime() - this.f199509g, this.f199518p);
        return;
    L20:
        r117 = -1;
        goto L21
    L16:
        r115 = null;
        goto L17
    L12:
        r114 = null;
        goto L14
    L8:
        r105 = r104.getValue();
        goto L9
    }

    public CustomStyleLoadTrace(int r100, String r101, String r102, boolean r103) {
        this.f199510h = new AtomicBoolean(false);
        this.f199521s = -1;
        this.f199503a = r100;
        this.f199504b = r101;
        this.f199505c = r102;
        this.f199506d = r103;
        this.f199509g = SystemClock.elapsedRealtime();
    }

    public final void a(String r100, String r101, boolean r102, long r103, String r104) {
        this.f199511i = r100;
        this.f199512j = r101;
        this.f199513k = r102;
        this.f199514l = null;
        this.f199515m = null;
        this.f199516n = null;
        this.f199517o = r103;
        this.f199518p = r104;
    }

    public final void b(boolean r100, String r101, Integer r110, String r111, long r112, String r113) {
        a(SoloKtvContext.SOLO_PAGE_FIRST, MapMonitorConst.FIRST_FAIL, r100, r112, r113);
        this.f199514l = r101;
        this.f199515m = r110;
        this.f199516n = r111;
    }
}
