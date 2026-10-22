package com.bytedance.applet.aibridge.navi.picker;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.applet.aibridge.navi.NavigationPageFrom;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.navigation.api.c;
import com.larus.utils.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import rv3.i;
import rv3.j;
import rv3.k;
import rv3.l;
import sv3.d;
import sv3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class NavigationMapAppLauncher {
    public static final NavigationMapAppLauncher a = null;
    public static final Map<String, String> b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$AppType;", "", "key", "", "packageName", "displayName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getPackageName", "getDisplayName", "DOUBAO", "AMAP", "BAIDU", "APPLE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AppType extends Enum<AppType> {
        public static final AppType AMAP = null;
        public static final AppType APPLE = null;
        public static final AppType BAIDU = null;
        public static final a Companion = null;
        public static final AppType DOUBAO = null;
        public static final /* synthetic */ AppType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String displayName;
        private final String key;
        private final String packageName;

        public static final class a {
            public a() {
            }

            public static AppType a(String r5) {
                if (r5 == null) goto L9;
                AppType[] r0 = AppType.values();
                int r1 = r0.length;
                int r2 = 0;
            L4:
                if (r2 >= r1) goto L9;
                AppType r3 = r0[r2];
                if (Intrinsics.areEqual(r3.getKey(), r5) == true) goto L13;
                r2 = r2 + 1;
                goto L4
            L13:
                return r3;
            L9:
                return null;
            }
        }

        public static EnumEntries<AppType> getEntries() {
            return b;
        }

        static {
            AppType r6 = new AppType("DOUBAO", 0, "doubao", null, null);
            DOUBAO = r6;
            AppType r0 = new AppType("AMAP", 1, "amap", "com.autonavi.minimap", "高德地图");
            AMAP = r0;
            AppType r1 = new AppType("BAIDU", 2, "baidu", "com.baidu.BaiduMap", "百度地图");
            BAIDU = r1;
            AppType r2 = new AppType("APPLE", 3, "apple", null, null);
            APPLE = r2;
            AppType[] r3 = {r6, r0, r1, r2};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static AppType[] values() {
            return (AppType[]) a.clone();
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public static AppType valueOf(String r1) {
            return (AppType) r27.a.a(AppType.class, r1);
        }

        public AppType(String r1, int r2, String r3, String r4, String r5) {
            super(r1, r2);
            this.key = r3;
            this.packageName = r4;
            this.displayName = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$BaiduDrivingPreference;", "", "schemeValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSchemeValue", "()Ljava/lang/String;", "DEFAULT", "BLK", "TIME", "DIS", "FEE", "HIGHWAY", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BaiduDrivingPreference extends Enum<BaiduDrivingPreference> {
        public static final BaiduDrivingPreference BLK = null;
        public static final a Companion = null;
        public static final BaiduDrivingPreference DEFAULT = null;
        public static final BaiduDrivingPreference DIS = null;
        public static final BaiduDrivingPreference FEE = null;
        public static final BaiduDrivingPreference HIGHWAY = null;
        public static final BaiduDrivingPreference TIME = null;
        public static final /* synthetic */ BaiduDrivingPreference[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String schemeValue;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<BaiduDrivingPreference> getEntries() {
            return b;
        }

        static {
            BaiduDrivingPreference r0 = new BaiduDrivingPreference("DEFAULT", 0, "DEFAULT");
            DEFAULT = r0;
            BaiduDrivingPreference r1 = new BaiduDrivingPreference("BLK", 1, "BLK");
            BLK = r1;
            BaiduDrivingPreference r3 = new BaiduDrivingPreference("TIME", 2, "TIME");
            TIME = r3;
            BaiduDrivingPreference r5 = new BaiduDrivingPreference("DIS", 3, "DIS");
            DIS = r5;
            BaiduDrivingPreference r7 = new BaiduDrivingPreference("FEE", 4, "FEE");
            FEE = r7;
            BaiduDrivingPreference r9 = new BaiduDrivingPreference("HIGHWAY", 5, "HIGHWAY");
            HIGHWAY = r9;
            BaiduDrivingPreference[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
        }

        public static BaiduDrivingPreference[] values() {
            return (BaiduDrivingPreference[]) a.clone();
        }

        public final String getSchemeValue() {
            return this.schemeValue;
        }

        public static BaiduDrivingPreference valueOf(String r1) {
            return (BaiduDrivingPreference) r27.a.a(BaiduDrivingPreference.class, r1);
        }

        public BaiduDrivingPreference(String r1, int r2, String r3) {
            super(r1, r2);
            this.schemeValue = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$BaiduTransitStrategy;", "", "protocolValue", "", "androidSy", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getProtocolValue", "()I", "getAndroidSy", "()Ljava/lang/String;", "RECOMMEND", "LESS_TRANSFER", "LESS_WALK", "NO_SUBWAY", "LEAST_TIME", "SUBWAY_FIRST", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BaiduTransitStrategy extends Enum<BaiduTransitStrategy> {
        public static final a Companion = null;
        public static final BaiduTransitStrategy LEAST_TIME = null;
        public static final BaiduTransitStrategy LESS_TRANSFER = null;
        public static final BaiduTransitStrategy LESS_WALK = null;
        public static final BaiduTransitStrategy NO_SUBWAY = null;
        public static final BaiduTransitStrategy RECOMMEND = null;
        public static final BaiduTransitStrategy SUBWAY_FIRST = null;
        public static final /* synthetic */ BaiduTransitStrategy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String androidSy;
        private final int protocolValue;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<BaiduTransitStrategy> getEntries() {
            return b;
        }

        static {
            BaiduTransitStrategy r0 = new BaiduTransitStrategy("RECOMMEND", 0, 0, "0");
            RECOMMEND = r0;
            BaiduTransitStrategy r1 = new BaiduTransitStrategy("LESS_TRANSFER", 1, 1, "2");
            LESS_TRANSFER = r1;
            BaiduTransitStrategy r3 = new BaiduTransitStrategy("LESS_WALK", 2, 2, "3");
            LESS_WALK = r3;
            BaiduTransitStrategy r5 = new BaiduTransitStrategy("NO_SUBWAY", 3, 3, "4");
            NO_SUBWAY = r5;
            BaiduTransitStrategy r7 = new BaiduTransitStrategy("LEAST_TIME", 4, 4, "5");
            LEAST_TIME = r7;
            BaiduTransitStrategy r9 = new BaiduTransitStrategy("SUBWAY_FIRST", 5, 5, "6");
            SUBWAY_FIRST = r9;
            BaiduTransitStrategy[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
        }

        public static BaiduTransitStrategy[] values() {
            return (BaiduTransitStrategy[]) a.clone();
        }

        public final String getAndroidSy() {
            return this.androidSy;
        }

        public final int getProtocolValue() {
            return this.protocolValue;
        }

        public static BaiduTransitStrategy valueOf(String r1) {
            return (BaiduTransitStrategy) r27.a.a(BaiduTransitStrategy.class, r1);
        }

        public BaiduTransitStrategy(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.protocolValue = r3;
            this.androidSy = r4;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$InstallState;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALLED", "NEED_INSTALL", "IN_APP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InstallState extends Enum<InstallState> {
        public static final InstallState INSTALLED = null;
        public static final InstallState IN_APP = null;
        public static final InstallState NEED_INSTALL = null;
        public static final /* synthetic */ InstallState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<InstallState> getEntries() {
            return b;
        }

        static {
            InstallState r0 = new InstallState("INSTALLED", 0);
            INSTALLED = r0;
            InstallState r1 = new InstallState("NEED_INSTALL", 1);
            NEED_INSTALL = r1;
            InstallState r3 = new InstallState("IN_APP", 2);
            IN_APP = r3;
            InstallState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static InstallState[] values() {
            return (InstallState[]) a.clone();
        }

        public static InstallState valueOf(String r1) {
            return (InstallState) r27.a.a(InstallState.class, r1);
        }

        public InstallState(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$RouteMode;", "", "key", "", "amapT", "", "baiduMode", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getAmapT", "()I", "getBaiduMode", "WALKING", "CYCLING", "E_CYCLING", "DRIVING", "TRANSIT", "supportsLightNav", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RouteMode extends Enum<RouteMode> {
        public static final RouteMode CYCLING = null;
        public static final a Companion = null;
        public static final RouteMode DRIVING = null;
        public static final RouteMode E_CYCLING = null;
        public static final RouteMode TRANSIT = null;
        public static final RouteMode WALKING = null;
        public static final /* synthetic */ RouteMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int amapT;
        private final String baiduMode;
        private final String key;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RouteMode> getEntries() {
            return b;
        }

        static {
            RouteMode r6 = new RouteMode("WALKING", 0, "walking", 2, "walking");
            WALKING = r6;
            RouteMode r0 = new RouteMode("CYCLING", 1, "cycling", 3, "riding");
            CYCLING = r0;
            RouteMode r1 = new RouteMode("E_CYCLING", 2, "e_cycling", 4, "riding");
            E_CYCLING = r1;
            RouteMode r2 = new RouteMode("DRIVING", 3, "driving", 0, "driving");
            DRIVING = r2;
            RouteMode r3 = new RouteMode("TRANSIT", 4, "transit", 1, "transit");
            TRANSIT = r3;
            RouteMode[] r4 = {r6, r0, r1, r2, r3};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new a();
        }

        public static RouteMode[] values() {
            return (RouteMode[]) a.clone();
        }

        public final boolean supportsLightNav() {
            if (this != WALKING) goto L5;
        L10:
            return true;
        L5:
            if (this == CYCLING) goto L10;
            if (this == E_CYCLING) goto L10;
            return false;
        }

        public final int getAmapT() {
            return this.amapT;
        }

        public final String getBaiduMode() {
            return this.baiduMode;
        }

        public final String getKey() {
            return this.key;
        }

        public static RouteMode valueOf(String r1) {
            return (RouteMode) r27.a.a(RouteMode.class, r1);
        }

        public RouteMode(String r1, int r2, String r3, int r4, String r5) {
            super(r1, r2);
            this.key = r3;
            this.amapT = r4;
            this.baiduMode = r5;
        }
    }

    public static final class a {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "LaunchResult(success=" + this.a + ", isBackground=" + this.b + ')';
        }

        public a(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[AppType.values().length];
            r0[AppType.DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L33:
            r0[AppType.APPLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L43:
            r0[AppType.BAIDU.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[AppType.AMAP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L10:
            a = r0;
            int[] r1 = new int[RouteMode.values().length];
            r1[RouteMode.DRIVING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L39:
            r1[RouteMode.WALKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L27:
            r1[RouteMode.CYCLING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L37:
            r1[RouteMode.E_CYCLING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L31:
            r1[RouteMode.TRANSIT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L16:
            b = r1;
        }
    }

    public NavigationMapAppLauncher() {
    }

    static {
        a = new NavigationMapAppLauncher();
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("xiaomi", "mimarket://details/detailmini?overlayStyle=normal&id={pkg}"), TuplesKt.to("redmi", "mimarket://details/detailmini?overlayStyle=normal&id={pkg}"), TuplesKt.to("huawei", "appmarket://details?id={pkg}"), TuplesKt.to("honor", "appmarket://details?id={pkg}"), TuplesKt.to("vivo", "vivomarket://details?id={pkg}"), TuplesKt.to("oppo", "oppomarket://details?packagename={pkg}"), TuplesKt.to("oneplus", "oppomarket://details?packagename={pkg}"), TuplesKt.to("realme", "oppomarket://details?packagename={pkg}"), TuplesKt.to("meizu", "mstore://details?package_name={pkg}"), TuplesKt.to("samsung", "samsungapps://ProductDetail/{pkg}")});
    }

    public static String d(List r8) {
        JSONArray r0 = new JSONArray();
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L30;
        m r1 = (m) r9.next();
        JSONObject r2 = new JSONObject().put("lat", r1.a()).put("lng", r1.b());
        String r3 = r1.c();
        boolean r4 = false;
        String r6 = null;
        if (r3 != null) goto L8;
    L16:
        a.getClass();
        if (Intrinsics.areEqual(r1.e(), "baidu") == false) goto L26;
        String r5 = r1.d();
        if (r5 == null) goto L26;
        if (r5.length() <= 0) goto L24;
        r4 = true;
    L24:
        if (r4 == false) goto L26;
        r6 = r5;
    L26:
        if (r6 == null) goto L28;
        r2.put("uid", r6);
    L28:
        r0.put(r2);
        goto L4
    L8:
        if (r3.length() <= 0) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L16;
        r2.put("name", r3);
        goto L16
    L10:
        r7 = false;
        goto L11
    L30:
        return new JSONObject().put("viaPoints", r0).toString();
    }

    public static String f(sv3.a r5) {
        String r0 = r5.c;
        if (r0 != null) goto L5;
    L10:
        r0 = null;
    L12:
        if (r0 != null) goto L16;
        StringBuilder r1 = new StringBuilder();
        r1.append(r5.a);
        r1.append(',');
        r1.append(r5.b);
        return r1.toString();
    L16:
        return "name:" + r0 + "|latlng:" + r5.a + ',' + r5.b;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
    L7:
        r2 = false;
        goto L8
    }

    public static InstallState g(AppType r1) {
        Intrinsics.checkNotNullParameter(r1, "app");
        if (r1 != AppType.DOUBAO) goto L6;
        return InstallState.IN_APP;
    L6:
        if (h(r1) == false) goto L9;
        return InstallState.INSTALLED;
    L9:
        return InstallState.NEED_INSTALL;
    }

    public static boolean h(AppType r4) {
        Intrinsics.checkNotNullParameter(r4, "app");
        int r0 = b.a[r4.ordinal()];
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L17;
        String r1 = r4.getPackageName();
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L17;
        if (z0.a(r4.getPackageName()) == false) goto L17;
        return true;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
    L17:
        return false;
    }

    public static boolean i(String r17) {
        Intrinsics.checkNotNullParameter(r17, "packageName");
        Application r11 = AppHost.a.getApplication();
        if (r11 != null) goto L37;
        return false;
    L37:
        String r1 = Build.MANUFACTURER;     // Catch: RuntimeException -> L31
        if (r1 == null) goto L8;
        String r2 = r1.toLowerCase(Locale.ROOT);     // Catch: RuntimeException -> L31
    L9:
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        String r13 = r2;
        String r3 = b.get(r13);     // Catch: RuntimeException -> L31
        if (r3 == null) goto L20;
        String r12 = "android.intent.action.VIEW";
        Uri r4 = UriProtector.parse(StringsKt.replace$default(r3, "{pkg}", r17, false, 4, null));     // Catch: RuntimeException -> L31
        Intent r5 = new Intent(r12, r4);     // Catch: RuntimeException -> L31
        r5.addFlags(268435456);     // Catch: RuntimeException -> L31
        if (r5.resolveActivity(r11.getPackageManager()) == null) goto L19;
        r11.startActivity(r5);     // Catch: RuntimeException -> L31
        int r0 = c.a;     // Catch: RuntimeException -> L31
        c.d("nav_map_launcher", "launchAppStore: vendor=" + r13 + " uri=" + r4);     // Catch: RuntimeException -> L31
        return true;
    L19:
        int r6 = c.a;     // Catch: RuntimeException -> L31
        c.d("nav_map_launcher", "launchAppStore: vendor=" + r13 + " schema unresolvable, falling back to market://details");     // Catch: RuntimeException -> L31
    L21:
        Intent r7 = new Intent(r12, UriProtector.parse("market://details?id=".concat(r17)));     // Catch: RuntimeException -> L31
        r7.addFlags(268435456);     // Catch: RuntimeException -> L31
        ComponentName r8 = r7.resolveActivity(r11.getPackageManager());     // Catch: RuntimeException -> L31
        if (r8 != null) goto L35;
        int r9 = c.a;     // Catch: RuntimeException -> L31
        c.b("nav_map_launcher", "launchAppStore: no app store on device for pkg=".concat(r17));     // Catch: RuntimeException -> L31
        return false;
    L35:
        r11.startActivity(r7);     // Catch: RuntimeException -> L29
        int r10 = c.a;     // Catch: RuntimeException -> L29
        c.d("nav_map_launcher", "launchAppStore: market://details pkg=" + r17 + " via " + r8.getPackageName());     // Catch: RuntimeException -> L29
        return true;
    L29:
        e = e;
    L33:
        int r14 = c.a;
        c.c("nav_map_launcher", "launchAppStore failed [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        return false;
    L20:
        r12 = "android.intent.action.VIEW";
        goto L21
    L8:
        r2 = null;
    L31:
        e = e;
        goto L33
    }

    public static boolean j(AppType r1, RouteMode r2) {
        Intrinsics.checkNotNullParameter(r1, "app");
        Intrinsics.checkNotNullParameter(r2, "mode");
        int r3 = b.a[r1.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L7;
        return false;
    L7:
        if (r3 != 3) goto L9;
        return true;
    L9:
        if (r3 != 4) goto L12;
        return true;
    L12:
        throw new NoWhenBranchMatchedException();
    L15:
        return r2.supportsLightNav();
    }

    public static Uri a(RouteMode r23, sv3.a r24, sv3.a r25, List r26) {
        Uri.Builder r2 = new Uri.Builder().scheme("amapuri").authority("route").path("plan/").appendQueryParameter("sourceApplication", "doubao").appendQueryParameter("dlat", String.valueOf(r25.a)).appendQueryParameter("dlon", String.valueOf(r25.b));
        if (r23 != RouteMode.E_CYCLING) goto L5;
        RouteMode r3 = RouteMode.CYCLING;
    L6:
        Uri.Builder r4 = r2.appendQueryParameter("t", String.valueOf(r3.getAmapT())).appendQueryParameter("dev", "0");
        int r5 = b.b[r23.ordinal()];
        if (r5 != 3) goto L9;
        r4.appendQueryParameter("rideType", "bike");
    L13:
        String r1 = r25.c;
        boolean r6 = false;
        String r7 = null;
        if (r1 != null) goto L16;
    L24:
        if (r24 == null) goto L34;
        r4.appendQueryParameter("slat", String.valueOf(r24.a));
        r4.appendQueryParameter("slon", String.valueOf(r24.b));
        String r0 = r24.c;
        if (r0 == null) goto L34;
        if (r0.length() <= 0) goto L30;
        r6 = true;
    L30:
        if (r6 == false) goto L32;
        r7 = r0;
    L32:
        if (r7 == null) goto L34;
        r4.appendQueryParameter("sname", r7);
    L34:
        Intrinsics.checkNotNull(r4);
        if (r26.isEmpty() == true) goto L39;
        r4.appendQueryParameter("vian", String.valueOf(r26.size()));
        List r8 = r26;
        r4.appendQueryParameter("vialons", CollectionsKt.joinToString$default(r8, "|", null, null, 0, null, new sv3.b(), 30, null));
        r4.appendQueryParameter("vialats", CollectionsKt.joinToString$default(r8, "|", null, null, 0, null, new sv3.c(), 30, null));
        r4.appendQueryParameter("vianames", CollectionsKt.joinToString$default(r8, "|", null, null, 0, null, new d(), 30, null));
    L39:
        return r4.build();
    L16:
        if (r1.length() <= 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == true) goto L22;
        r1 = null;
    L22:
        if (r1 == null) goto L24;
        r4.appendQueryParameter("dname", r1);
        goto L24
    L18:
        r9 = false;
        goto L19
    L9:
        if (r5 == 4) goto L11;
        Unit r10 = Unit.INSTANCE;
        goto L13
    L11:
        r4.appendQueryParameter("rideType", "elebike");
        goto L13
    L5:
        r3 = r23;
        goto L6
    }

    public static Uri b(RouteMode r9, sv3.a r10, sv3.a r11, boolean r12, List r13) {
        if ((!r13.isEmpty()) == true) goto L5;
        if (r12 == false) goto L29;
        if (r9 == RouteMode.TRANSIT) goto L29;
        int r14 = b.b[r9.ordinal()];
        if (r14 == 1) goto L27;
        if (r14 == 2) goto L32;
        if (r14 == 3) goto L31;
        if (r14 == 4) goto L30;
        if (r14 == 5) goto L22;
        throw new NoWhenBranchMatchedException();
    L22:
        throw new IllegalStateException("TRANSIT has no direct-navi schema; caller must route through buildAmapRoutePlanUri".toString());
    L30:
        return new Uri.Builder().scheme("amapuri").authority("openFeature").appendQueryParameter("sourceApplication", "doubao").appendQueryParameter("lat", String.valueOf(r11.a)).appendQueryParameter("lon", String.valueOf(r11.b)).appendQueryParameter("dev", "0").appendQueryParameter("featureName", "OnRideNavi").appendQueryParameter("rideType", "elebike").build();
    L31:
        return new Uri.Builder().scheme("amapuri").authority("openFeature").appendQueryParameter("sourceApplication", "doubao").appendQueryParameter("lat", String.valueOf(r11.a)).appendQueryParameter("lon", String.valueOf(r11.b)).appendQueryParameter("dev", "0").appendQueryParameter("featureName", "OnRideNavi").appendQueryParameter("rideType", "ride").build();
    L32:
        return new Uri.Builder().scheme("amapuri").authority("openFeature").appendQueryParameter("sourceApplication", "doubao").appendQueryParameter("lat", String.valueOf(r11.a)).appendQueryParameter("lon", String.valueOf(r11.b)).appendQueryParameter("dev", "0").appendQueryParameter("featureName", "OnFootNavi").build();
    L27:
        return new Uri.Builder().scheme("androidamap").authority("navi").appendQueryParameter("sourceApplication", "doubao").appendQueryParameter("lat", String.valueOf(r11.a)).appendQueryParameter("lon", String.valueOf(r11.b)).appendQueryParameter("dev", "0").appendQueryParameter("style", "2").build();
    L29:
        return a(r9, r10, r11, r13);
    L5:
        return a(r9, r10, r11, r13);
    }

    public static Uri c(RouteMode r22, sv3.a r23, sv3.a r24, List r25, boolean r26, BaiduDrivingPreference r27, BaiduTransitStrategy r28) {
        if (r26 == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        String r8 = "destination";
        String r15 = "gcj02";
        String r7 = ") routePreference=";
        String r17 = null;
        if (r6 == false) goto L62;
        int r9 = c.a;
        StringBuilder r10 = new StringBuilder("[buildBaiduUri] directLaunch=true → direct navi (mode=");
        r10.append(r22);
        r10.append(", directLaunch=");
        r10.append(r26);
        r10.append(", waypoints=");
        r10.append(r25.size());
        r10.append(") routePreference=");
        if (r27 == null) goto L13;
        String r4 = r27.getSchemeValue();
    L14:
        r10.append(r4);
        c.d("nav_map_launcher", r10.toString());
        int r5 = b.b[r22.ordinal()];
        if (r5 != 1) goto L17;
        String r14 = "viaPoints";
        String r11 = "coord_type";
        Uri.Builder r12 = new Uri.Builder().scheme("baidumap").authority("map").path("navi").appendQueryParameter("src", "doubao").appendQueryParameter(r11, "gcj02");
        StringBuilder r13 = new StringBuilder();
        r13.append(r24.a);
        r13.append(',');
        r13.append(r24.b);
        Uri.Builder r16 = r12.appendQueryParameter("location", r13.toString());
        String r18 = r24.c;
        if (r18 != null) goto L45;
    L53:
        if (r27 == null) goto L56;
        r16.appendQueryParameter("type", r27.getSchemeValue());
    L56:
        if ((!r25.isEmpty()) == false) goto L58;
        r16.appendQueryParameter(r14, d(r25));
    L58:
        Uri r19 = r16.build();
    L59:
        if (r19 == null) goto L61;
        return r19;
    L61:
        String r20 = "nav_map_launcher";
        c.d(r20, "[buildBaiduUri] direct navi unsupported for mode=" + r22 + ", fallback to direction");
    L63:
        int r21 = c.a;
        StringBuilder r29 = new StringBuilder("[buildBaiduUri] → map/direction (route plan, directLaunch=");
        r29.append(r26);
        r29.append(" waypoints=");
        r29.append(r25.size());
        r29.append(r7);
        if (r27 == null) goto L66;
        String r3 = r27.getSchemeValue();
    L67:
        r29.append(r3);
        r29.append(" transitSy=");
        if (r28 == null) goto L70;
        r17 = r28.getAndroidSy();
    L70:
        r29.append(r17);
        c.d(r20, r29.toString());
        String r30 = r22.getBaiduMode();
        if (r30 != null) goto L73;
        r30 = "driving";
    L73:
        Uri.Builder r31 = new Uri.Builder().scheme("baidumap").authority("map").path("direction").appendQueryParameter(r11, r15).appendQueryParameter("src", "doubao").appendQueryParameter("mode", r30);
        r31.appendQueryParameter(r8, f(r24));
        if (r23 == null) goto L76;
        a.getClass();
        r31.appendQueryParameter("origin", f(r23));
    L76:
        int r0 = b.b[r22.ordinal()];
        if (r0 != 1) goto L79;
        if (r27 == null) goto L86;
        r31.appendQueryParameter("car_type", r27.getSchemeValue());
    L86:
        if ((!r25.isEmpty()) == false) goto L89;
        r31.appendQueryParameter(r14, d(r25));
    L89:
        return r31.build();
    L79:
        if (r0 != 5) goto L86;
        if (r28 == null) goto L86;
        r31.appendQueryParameter("sy", r28.getAndroidSy());
        goto L86
    L66:
        r3 = null;
        goto L67
    L45:
        if (r18.length() <= 0) goto L47;
        boolean r110 = true;
    L48:
        if (r110 == true) goto L51;
        r18 = null;
    L51:
        if (r18 == null) goto L53;
        r16.appendQueryParameter("query", r18);
        goto L53
    L47:
        r110 = false;
        goto L48
    L17:
        if (r5 != 2) goto L19;
        r14 = "viaPoints";
        Uri.Builder r32 = new Uri.Builder().scheme("baidumap").authority("map").path("walknavi").appendQueryParameter("src", "doubao").appendQueryParameter("coord_type", "gcj02");
        StringBuilder r33 = new StringBuilder();
        r33.append(r24.a);
        r33.append(',');
        r33.append(r24.b);
        Uri.Builder r34 = r32.appendQueryParameter("destination", r33.toString());
        if (r23 == null) goto L39;
        StringBuilder r35 = new StringBuilder();
        r35.append(r23.a);
        r35.append(',');
        r35.append(r23.b);
        r34.appendQueryParameter("origin", r35.toString());
    L39:
        if ((!r25.isEmpty()) == false) goto L41;
        r34.appendQueryParameter(r14, d(r25));
    L41:
        r19 = r34.build();
        r11 = "coord_type";
        goto L59
    L19:
        if (r5 != 3) goto L21;
    L27:
        Uri.Builder r36 = new Uri.Builder().scheme("baidumap").authority("map").path("bikenavi").appendQueryParameter("src", "doubao").appendQueryParameter("coord_type", "gcj02");
        StringBuilder r37 = new StringBuilder();
        r37.append(r24.a);
        r37.append(',');
        r37.append(r24.b);
        Uri.Builder r38 = r36.appendQueryParameter("destination", r37.toString());
        if (r23 == null) goto L31;
        StringBuilder r39 = new StringBuilder();
        r39.append(r23.a);
        r39.append(',');
        r39.append(r23.b);
        r38.appendQueryParameter("origin", r39.toString());
    L31:
        if ((!r25.isEmpty()) == false) goto L33;
        r14 = "viaPoints";
        r38.appendQueryParameter(r14, d(r25));
    L34:
        r19 = r38.build();
        r15 = "gcj02";
        r11 = "coord_type";
        goto L59
    L33:
        r14 = "viaPoints";
        goto L34
    L21:
        if (r5 == 4) goto L27;
        if (r5 != 5) goto L26;
        r11 = "coord_type";
        r19 = null;
        r14 = "viaPoints";
        goto L59
    L26:
        throw new NoWhenBranchMatchedException();
    L13:
        r4 = null;
        goto L14
    L62:
        r20 = "nav_map_launcher";
        r7 = ") routePreference=";
        r8 = "destination";
        r11 = "coord_type";
        r14 = "viaPoints";
        goto L63
    L5:
        if (r22 == RouteMode.TRANSIT) goto L7;
        r6 = true;
        goto L8
    }

    public static Uri e(RouteMode r26, sv3.a r27, sv3.a r28, String r29, String r30, String r31, String r32, String r33, String r34, List r35) {
        String r2 = r29;
        if (r2 != null) goto L5;
    L15:
        r2 = "relaunch";
    L16:
        String r12 = r2;
        String r3 = r26.getKey();
        if (r27 == null) goto L19;
        j r4 = new j(r27.a, r27.b, r27.c);
    L20:
        j r11 = new j(r28.a, r28.b, r28.c);
        NavigationPageFrom r6 = NavigationPageFrom.POPUP;
        if ((!r35.isEmpty()) == false) goto L23;
        List r5 = r35;
    L24:
        if (r5 == null) goto L33;
        List r7 = r5;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L27:
        if (r9.hasNext() == false) goto L32;
        m r10 = (m) r9.next();
        double r19 = r10.a();
        double r21 = r10.b();
        String r13 = r10.c();
        if (r13 != null) goto L31;
        r13 = "";
    L31:
        r8.add(new l(r19, r21, r13, r10.d(), r10.e()));
        goto L27
    L32:
        ArrayList r14 = r8;
    L34:
        i r15 = new i(r3, r4, r11, r6, r12, r14, r30, r31, r32, 262112);
        String r16 = k.a(r15, r12, r33, r34);
        Object r17 = com.bytedance.applet.aibridge.navigation.l.a;
        Intrinsics.checkNotNullParameter(r15, "pageData");
        final String r18 = r15.f();
        if (r18 != null) goto L37;
    L50:
        int r20 = c.a;
        c.a("nav_map_launcher", "[buildLightNavUri/v2] page JSON raw=" + GsonProtectorUtils.toJson(new Gson(), r15));
        StringBuilder r22 = new StringBuilder("[buildLightNavUri/v2] appId=db_1GFLTGc startText=");
        if (r27 == null) goto L53;
        String r23 = r27.c;
    L54:
        r22.append(r23);
        r22.append(" endText=");
        r22.append(r28.c);
        r22.append(" dPoiId=");
        r22.append(r30);
        r22.append(" dPoiIdType=");
        r22.append(r31);
        r22.append(" autoLinkId=");
        r22.append(r32);
        r22.append(" waypoints=");
        r22.append(r35.size());
        r22.append(" uri=");
        r22.append(r16);
        c.a("nav_map_launcher", r22.toString());
        StringBuilder r24 = new StringBuilder("[H5_OUT/sslocal] mode=");
        r24.append(r26.getKey());
        r24.append(" | startPoint=(lat=");
        if (r27 == null) goto L57;
        Double r25 = Double.valueOf(r27.a);
    L58:
        r24.append(r25);
        r24.append(",lng=");
        if (r27 == null) goto L61;
        Double r36 = Double.valueOf(r27.b);
    L62:
        r24.append(r36);
        r24.append(",text='");
        if (r27 == null) goto L65;
        String r0 = r27.c;
    L66:
        r24.append(r0);
        r24.append("') | endPoint=(lat=");
        r24.append(r28.a);
        r24.append(",lng=");
        r24.append(r28.b);
        r24.append(",text='");
        r24.append(r28.c);
        r24.append("') | dPoiId=");
        r24.append(r30);
        r24.append(" dPoiIdType=");
        r24.append(r31);
        r24.append(" autoLinkId=");
        r24.append(r32);
        r24.append(" | waypoints=");
        r24.append(r35.size());
        r24.append(" | from=");
        r24.append(NavigationPageFrom.POPUP);
        r24.append(" | pageData_json=");
        r24.append(GsonProtectorUtils.toJson(new Gson(), r15));
        r24.append(" | uri=");
        r24.append(r16);
        c.a("nav_protocol_trace", r24.toString());
        return UriProtector.parse(r16);
    L65:
        r0 = null;
        goto L66
    L61:
        r36 = null;
        goto L62
    L57:
        r25 = null;
        goto L58
    L53:
        r23 = null;
        goto L54
    L37:
        if ((!StringsKt.isBlank(r18)) == true) goto L40;
        r18 = null;
    L40:
        if (r18 == null) goto L50;
        final long r37 = SystemClock.elapsedRealtime() + 60000;
        Object r38 = com.bytedance.applet.aibridge.navigation.l.a;
        monitor-enter(r38);
        com.bytedance.applet.aibridge.navigation.l.d = new com.bytedance.applet.aibridge.navigation.l.b(r15, r37);     // Catch: Throwable -> L47
        Unit r39 = Unit.INSTANCE;     // Catch: Throwable -> L47
        monitor-exit(r38);
        com.bytedance.applet.aibridge.navigation.l.b.postDelayed(new com.bytedance.applet.aibridge.navigation.j(r18, r37), 60000);
    L47:
        th = move-exception;
        throw th;
    L33:
        r14 = null;
        goto L34
    L23:
        r5 = null;
        goto L24
    L19:
        r4 = null;
        goto L20
    L5:
        if (Intrinsics.areEqual(r2, "navigate") == false) goto L7;
    L10:
        boolean r40 = true;
    L11:
        if (r40 == true) goto L14;
        r2 = null;
    L14:
        if (r2 != null) goto L16;
    L7:
        if (Intrinsics.areEqual(r2, "relaunch") == true) goto L10;
        r40 = false;
        goto L11
    }
}
