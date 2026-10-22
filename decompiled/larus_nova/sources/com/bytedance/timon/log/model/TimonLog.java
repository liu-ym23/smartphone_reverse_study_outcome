package com.bytedance.timon.log.model;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final class TimonLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f270625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LogType f270626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f270627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f270628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f270629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f270630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f270631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f270632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Action f270633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f270634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f270635k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f270636l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/timon/log/model/TimonLog$Action;", "", "Unknown", "EnterForeground", "EnterBackground", "timon-monitor-api_release"}, k = 1, mv = {1, 4, 0})
    public static final enum Action extends Enum<Action> {
        public static final Action EnterBackground = null;
        public static final Action EnterForeground = null;
        public static final Action Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f270637a = null;

        static {
            Action r100 = new Action("Unknown", 0);
            Unknown = r100;
            Action r101 = new Action("EnterForeground", 1);
            EnterForeground = r101;
            Action r102 = new Action("EnterBackground", 2);
            EnterBackground = r102;
            f270637a = new Action[]{r100, r101, r102};
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) f270637a.clone();
        }

        public Action(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/timon/log/model/TimonLog$LogType;", "", "Unknown", "ApiCall", "AppLaunch", "PageSwitch", "AppSwitch", "RequestPermissionResult", "Group", "ShieldFilter", "timon-monitor-api_release"}, k = 1, mv = {1, 4, 0})
    public static final enum LogType extends Enum<LogType> {
        public static final LogType ApiCall = null;
        public static final LogType AppLaunch = null;
        public static final LogType AppSwitch = null;
        public static final LogType Group = null;
        public static final LogType PageSwitch = null;
        public static final LogType RequestPermissionResult = null;
        public static final LogType ShieldFilter = null;
        public static final LogType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogType[] f270638a = null;

        static {
            LogType r100 = new LogType("Unknown", 0);
            Unknown = r100;
            LogType r101 = new LogType("ApiCall", 1);
            ApiCall = r101;
            LogType r102 = new LogType("AppLaunch", 2);
            AppLaunch = r102;
            LogType r103 = new LogType("PageSwitch", 3);
            PageSwitch = r103;
            LogType r104 = new LogType("AppSwitch", 4);
            AppSwitch = r104;
            LogType r105 = new LogType("RequestPermissionResult", 5);
            RequestPermissionResult = r105;
            LogType r106 = new LogType("Group", 6);
            Group = r106;
            LogType r107 = new LogType("ShieldFilter", 7);
            ShieldFilter = r107;
            f270638a = new LogType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static LogType valueOf(String r100) {
            return (LogType) a.a(LogType.class, r100);
        }

        public static LogType[] values() {
            return (LogType[]) f270638a.clone();
        }

        public LogType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TimonLog) == false) goto L28;
        TimonLog r101 = (TimonLog) r100;
        if (Intrinsics.areEqual(this.f270626b, r101.f270626b) == true) goto L8;
        return false;
    L8:
        if (this.f270627c == r101.f270627c) goto L10;
        return false;
    L10:
        if (this.f270628d == r101.f270628d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f270629e, r101.f270629e) == true) goto L14;
        return false;
    L14:
        if (this.f270630f == r101.f270630f) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f270631g, r101.f270631g) == true) goto L18;
        return false;
    L18:
        if (this.f270632h == r101.f270632h) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f270633i, r101.f270633i) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f270634j, r101.f270634j) == true) goto L24;
        return false;
    L24:
        if (this.f270635k == r101.f270635k) goto L26;
        return false;
    L26:
        if (this.f270636l == r101.f270636l) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        LogType r100 = this.f270626b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f270627c;
        int r104 = ((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f270628d) * 31;
        String r105 = this.f270629e;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f270630f;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.f270631g;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (((r110 + r112) * 31) + this.f270632h) * 31;
        Action r114 = this.f270633i;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f270634j;
        if (r117 == null) goto L25;
        r101 = r117.hashCode();
    L25:
        return ((((r116 + r101) * 31) + this.f270635k) * 31) + this.f270636l;
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TimonLog(type=" + this.f270626b + ", timestamp=" + this.f270627c + ", apiId=" + this.f270628d + ", bpeaToken=" + this.f270629e + ", isDowngrade=" + this.f270630f + ", params=" + this.f270631g + ", count=" + this.f270632h + ", action=" + this.f270633i + ", topPage=" + this.f270634j + ", appMode=" + this.f270635k + ", hashToken=" + this.f270636l + ")";
    }

    public TimonLog() {
        LogType r100 = LogType.Unknown;
        Map<String, String> r101 = MapsKt.emptyMap();
        Action r102 = Action.Unknown;
        this.f270626b = r100;
        this.f270627c = 0;
        this.f270628d = 0;
        this.f270629e = null;
        this.f270630f = false;
        this.f270631g = r101;
        this.f270632h = 0;
        this.f270633i = r102;
        this.f270634j = null;
        this.f270635k = 0;
        this.f270636l = -1;
        this.f270625a = LazyKt.lazy(new TimonLog$timestamps$2(this));
    }

    public final LogType getType() {
        return this.f270626b;
    }
}
