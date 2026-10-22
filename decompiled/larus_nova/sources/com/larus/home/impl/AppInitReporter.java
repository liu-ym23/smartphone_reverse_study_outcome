package com.larus.home.impl;

import android.app.Application;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.launch.DefaultLaunchMode;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class AppInitReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppInitReporter f344102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Long f344103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f344104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f344105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f344106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile long f344107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile long f344108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile long f344109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile long f344110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile Long f344111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f344112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f344113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f344114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile boolean f344115n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile boolean f344116o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f344117p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile boolean f344118q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile boolean f344119r;

    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/home/impl/AppInitReporter$ReportType;", "", "scene", "", "step", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getScene", "()Ljava/lang/String;", "getStep", "()I", "FIRST_FRAME", "FEED_SHOW", "PRIVACY_SHOW", "PRIVACY_CLICK_TO_LOGIN_SHOW", "FIRST_FRAME_CHAT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReportType extends Enum<ReportType> {
        public static final ReportType FEED_SHOW = null;
        public static final ReportType FIRST_FRAME = null;
        public static final ReportType FIRST_FRAME_CHAT = null;
        public static final ReportType PRIVACY_CLICK_TO_LOGIN_SHOW = null;
        public static final ReportType PRIVACY_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReportType[] f344120a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f344121b = null;
        private final String scene;
        private final int step;

        public static EnumEntries<ReportType> getEntries() {
            return f344121b;
        }

        static {
            ReportType r100 = new ReportType("FIRST_FRAME", 0, "FIRST_FRAME", 1);
            FIRST_FRAME = r100;
            ReportType r101 = new ReportType("FEED_SHOW", 1, "FEED_SHOW", 2);
            FEED_SHOW = r101;
            ReportType r102 = new ReportType("PRIVACY_SHOW", 2, "PRIVACY_SHOW", 3);
            PRIVACY_SHOW = r102;
            ReportType r103 = new ReportType("PRIVACY_CLICK_TO_LOGIN_SHOW", 3, "PRIVACY_CLICK_TO_LOGIN_SHOW", 4);
            PRIVACY_CLICK_TO_LOGIN_SHOW = r103;
            ReportType r104 = new ReportType("FIRST_FRAME_CHAT", 4, "FIRST_FRAME_CHAT", 5);
            FIRST_FRAME_CHAT = r104;
            ReportType[] r110 = {r100, r101, r102, r103, r104};
            f344120a = r110;
            f344121b = EnumEntriesKt.enumEntries(r110);
        }

        public static ReportType[] values() {
            return (ReportType[]) f344120a.clone();
        }

        public final String getScene() {
            return this.scene;
        }

        public final int getStep() {
            return this.step;
        }

        public static ReportType valueOf(String r100) {
            return (ReportType) r27.a.a(ReportType.class, r100);
        }

        public ReportType(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.scene = r102;
            this.step = r103;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f344122a = null;

        static {
            int[] r100 = new int[ReportType.values().length];
            r100[ReportType.FIRST_FRAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ReportType.FEED_SHOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ReportType.PRIVACY_SHOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ReportType.PRIVACY_CLICK_TO_LOGIN_SHOW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ReportType.FIRST_FRAME_CHAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f344122a = r100;
        }
    }

    public AppInitReporter() {
    }

    static {
        f344102a = new AppInitReporter();
        f344109h = -1;
        f344110i = -1;
    }

    public static boolean a(String r100) {
        Object r101 = ns3.d.a(r100).first;
        if (r101 != DefaultLaunchMode.CLOD_LAUNCH) goto L5;
    L8:
        return true;
    L5:
        if (r101 == DefaultLaunchMode.UNKNOWN_LAUNCH) goto L8;
        return false;
    }

    public static void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonParams");
        if (f344103b != null) goto L6;
        return;
    L6:
        if (f344116o == false) goto L8;
        return;
    L8:
        f344116o = true;
        Application r101 = AppHost.f326268a.getApplication();
        JSONObject r102 = new JSONObject();
        r102.put("real_app_init_time", f344103b);
        r102.put(ReportType.PRIVACY_SHOW.getScene(), System.currentTimeMillis());
        Unit r103 = Unit.INSTANCE;
        com.larus.home.impl.utils.e.a(r101, r102.toString());
    }

    public static void c(ReportType r100, JSONObject r110) {
        long r101 = System.currentTimeMillis();
        Long r102 = f344111j;
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        int r104 = a.f344122a[r100.ordinal()];
        if (r104 != 1) goto L9;
        long r105 = r101 - r103;
        r110.put("fst_frame_dur", r105);
        r110.put("duration", r105);
        if (f344109h >= 0) goto L30;
        f344109h = r105;
    L30:
        r110.put("real_launch_mode", ns3.d.a(HomeServiceV2.f344096a.a()).first);
        r110.put("stage", r100.getScene());
        FLogger.f375446a.i("AppInitReporter", "ReportType: " + r100 + ", duration=" + r110.optLong("duration", 0) + ", Current report param: " + r110);
        ApmAgent.addPerfTag(r100.getScene(), String.valueOf(r100.getStep()));
        com.larus.platform.service.o.f365780a.reportEvent("direct_first_frame", r110);
        return;
    L9:
        if (r104 != 2) goto L11;
        long r106 = r101 - r103;
        r110.put("fst_feed_dur", r106);
        r110.put("duration", r106);
        if (f344110i >= 0) goto L30;
        f344110i = r106;
        goto L30
    L11:
        if (r104 == 3) goto L30;
        if (r104 != 4) goto L15;
        Long r107 = f344103b;
        if (r107 == null) goto L22;
        long r108 = r107.longValue();
    L23:
        r110.put("duration", r101 - r108);
        goto L30
    L22:
        r108 = 0;
        goto L23
    L15:
        if (r104 != 5) goto L18;
        r110.put("duration", r101 - r103);
        goto L30
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        r103 = 0;
        goto L6
    }
}
