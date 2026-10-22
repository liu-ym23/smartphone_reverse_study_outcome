package com.larus.dora.impl.core.wifi;

import android.net.wifi.WifiManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dora.wlan.DoraWifiLinkStrategy;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.util.b0;
import com.larus.settings.value.e10;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import kotlinx.coroutines.sync.MutexImpl;
import nu9.f;
import nu9.q;
import vk4.e;
import vk4.h;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraWifiLinkWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraWifiLinkWrapper f332292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutexImpl f332293b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, h> f332294c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Function0<Unit>> f332295d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f332296e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f332297f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f332298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static DoraWifiScene f332299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f332300i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f332301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f332302b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f332301a == r101.f332301a) goto L12;
            return false;
        L12:
            if (this.f332302b == r101.f332302b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f332301a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f332302b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "P2PRTCRuntimeState(hasP2PLinkPermissions=" + this.f332301a + ", hasP2PRTCAbility=" + this.f332302b + ')';
        }

        public final boolean a() {
            if (this.f332301a == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f332302b == false) goto L7;
            return true;
        }

        public a(boolean r100, boolean r101) {
            this.f332301a = r100;
            this.f332302b = r101;
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f332303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f332304b;

        public b(e r100, String r101) {
            this.f332303a = r100;
            this.f332304b = r101;
        }

        @Override // vk4.h
        public final void a(int r100, int r101, String r102) {
            if (r101 == 0) goto L4;
            return;
        L4:
            Object r103 = DoraWifiLinkWrapper.f332297f;
            String r104 = this.f332304b;
            monitor-enter(r103);
            Function0<Unit> r105 = null;
            if (DoraWifiLinkWrapper.f332294c.remove(r104, this) == true) goto L10;
        L13:
            monitor-exit(r103);
            this.f332303a.j(this);
            if (r105 == null) goto L23;
            r105.invoke();
            return;
        L23:
            return;
        L10:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332298g, r104) == false) goto L12;
            DoraWifiLinkWrapper.f332298g = null;     // Catch: Throwable -> L18
            DoraWifiLinkWrapper.f332299h = null;     // Catch: Throwable -> L18
        L12:
            DoraWifiLinkWrapper.f332296e.remove(r104);     // Catch: Throwable -> L18
            r105 = DoraWifiLinkWrapper.f332295d.remove(r104);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraWifiScene f332305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f332306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f332307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f332308d;

        public c(DoraWifiScene r100, e r101, d r102, String r103) {
            this.f332305a = r100;
            this.f332306b = r101;
            this.f332307c = r102;
            this.f332308d = r103;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            g49.d.d("DoraWifiLinkWrapper", "connect: invokeOnCancellation, scene=" + this.f332305a);
            this.f332306b.j(this.f332307c);
            Object r101 = DoraWifiLinkWrapper.f332297f;
            String r102 = this.f332308d;
            d r103 = this.f332307c;
            monitor-enter(r101);
            if (r102 != null) goto L32;
        L11:
            boolean r104 = true;
        L12:
            if (r104 == true) goto L14;
        L16:
            if (r102 == null) goto L19;
            if (r104 == false) goto L19;
            DoraWifiLinkWrapper.f332296e.remove(r102);     // Catch: Throwable -> L9
        L19:
            if (r102 == null) goto L27;
            if (r104 == false) goto L27;
            if (DoraWifiLinkWrapper.f332294c.remove(r102, r103) == false) goto L27;
            DoraWifiLinkWrapper.f332295d.remove(r102);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        L27:
            monitor-exit(r101);
            if (r104 == false) goto L31;
            this.f332306b.b(this.f332305a);
        L31:
            return Unit.INSTANCE;
        L14:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332300i, r102) == false) goto L16;
            DoraWifiLinkWrapper.f332300i = null;     // Catch: Throwable -> L9
            goto L16
        L32:
            if (DoraWifiLinkWrapper.f332294c.get(r102) == r103) goto L11;
            r104 = false;
            goto L12
        }
    }

    public static final class d implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraWifiScene f332310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f332311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f332312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f332313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ i<x39.b> f332314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f332315f;

        @Override // vk4.h
        public final void a(int r100, int r101, String r102) {
            g49.d.d("DoraWifiLinkWrapper", "connect: wifiLinkStateChanged: " + r100 + " -> " + r101 + ", reason=" + r102 + ", scene=" + this.f332310a);
            Function0<Unit> r103 = null;
            if (r101 != 0) goto L5;
            Object r104 = DoraWifiLinkWrapper.f332297f;
            String r105 = this.f332311b;
            monitor-enter(r104);
            if (r105 != null) goto L130;
        L86:
            boolean r106 = true;
        L87:
            if (r105 == null) goto L92;
            if (r106 == false) goto L92;
            if (DoraWifiLinkWrapper.f332296e.contains(r105) == false) goto L92;
            boolean r107 = true;
        L93:
            if (r106 == true) goto L95;
        L97:
            if (r106 == true) goto L99;
        L101:
            if (r105 == null) goto L104;
            if (r106 == false) goto L104;
            DoraWifiLinkWrapper.f332296e.remove(r105);     // Catch: Throwable -> L84
        L104:
            if (r105 == null) goto L112;
            if (r106 == false) goto L112;
            if (DoraWifiLinkWrapper.f332294c.remove(r105, this) == false) goto L112;
            r103 = DoraWifiLinkWrapper.f332295d.remove(r105);     // Catch: Throwable -> L84
        L84:
            th = move-exception;
            throw th;
        L112:
            monitor-exit(r104);
            if (r107 == false) goto L115;
            Object r108 = new x39.b.a("disconnected_after_cancel");
        L122:
            if (this.f332313d.compareAndSet(false, true) == false) goto L124;
            this.f332314e.resumeWith(Result.m9449constructorimpl(r108));
        L124:
            this.f332312c.j(this);
            if (r103 == null) goto L141;
            r103.invoke();
            return;
        L141:
            return;
        L115:
            DoraWifiLinkWrapper.f332292a.getClass();
            r108 = DoraWifiLinkWrapper.m(r102);
            if (r108 != null) goto L122;
            if (r102 != null) goto L120;
            r102 = "";
        L120:
            r108 = new x39.b.a(r102);
            goto L122
        L99:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332300i, r105) == false) goto L101;
            DoraWifiLinkWrapper.f332300i = null;     // Catch: Throwable -> L84
            goto L101
        L95:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332298g, r105) == false) goto L97;
            DoraWifiLinkWrapper.f332298g = null;     // Catch: Throwable -> L84
            DoraWifiLinkWrapper.f332299h = null;     // Catch: Throwable -> L84
        L92:
            r107 = false;
            goto L93
        L130:
            if (DoraWifiLinkWrapper.f332294c.get(r105) == this) goto L86;
            r106 = false;
            goto L87
        L5:
            if (r101 != 2) goto L142;
            String r109 = this.f332311b;
            if (r109 == null) goto L28;
            Object r110 = DoraWifiLinkWrapper.f332297f;
            DoraWifiScene r111 = this.f332310a;
            monitor-enter(r110);
        L25:
            th = move-exception;
            throw th;
        L12:
            if (DoraWifiLinkWrapper.f332294c.get(r109) == this) goto L14;
        L20:
            boolean r112 = false;
        L21:
            monitor-exit(r110);
            if (r112 == true) goto L28;
            boolean r113 = false;
        L29:
            if (r113 == true) goto L58;
            String r114 = this.f332311b;
            if (r114 == null) goto L50;
            Object r115 = DoraWifiLinkWrapper.f332297f;
            monitor-enter(r115);
            ConcurrentHashMap<String, h> r116 = DoraWifiLinkWrapper.f332294c;     // Catch: Throwable -> L47
            if (r116.get(r114) != this) goto L43;
            Set<String> r117 = DoraWifiLinkWrapper.f332296e;     // Catch: Throwable -> L47
            if (r117.contains(r114) == false) goto L43;
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332300i, r114) == false) goto L41;
            DoraWifiLinkWrapper.f332300i = null;     // Catch: Throwable -> L47
        L41:
            r116.remove(r114, this);     // Catch: Throwable -> L47
            r117.remove(r114);     // Catch: Throwable -> L47
            DoraWifiLinkWrapper.f332295d.remove(r114);     // Catch: Throwable -> L47
            boolean r118 = true;
        L44:
            monitor-exit(r115);
            if (r118 == false) goto L50;
            boolean r119 = true;
        L51:
            g49.d.e("DoraWifiLinkWrapper", "connect: ignore stale/cancelled owner callback scene=" + this.f332310a + " cancelled=" + r119);
            this.f332312c.j(this);
            if (r119 == false) goto L136;
            this.f332312c.b(this.f332310a);
            if (this.f332313d.compareAndSet(false, true) == false) goto L137;
            i<x39.b> r120 = this.f332314e;
            Result.Companion r121 = Result.Companion;
            r120.resumeWith(Result.m9449constructorimpl(new x39.b.a("connected_after_cancel")));
            return;
        L137:
            return;
        L136:
            return;
        L43:
            r118 = false;
        L47:
            th = move-exception;
            throw th;
        L50:
            r119 = false;
            goto L51
        L58:
            if (this.f332311b != null) goto L68;
            Object r122 = DoraWifiLinkWrapper.f332297f;
            monitor-enter(r122);
            DoraWifiLinkWrapper.f332300i = null;     // Catch: Throwable -> L64
            DoraWifiLinkWrapper.f332298g = null;     // Catch: Throwable -> L64
            DoraWifiLinkWrapper.f332299h = null;     // Catch: Throwable -> L64
            Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L64
            monitor-exit(r122);
        L64:
            th = move-exception;
            throw th;
        L68:
            if (this.f332313d.compareAndSet(false, true) == false) goto L138;
            i<x39.b> r124 = this.f332314e;
            Result.Companion r125 = Result.Companion;
            String r126 = this.f332312c.c();
            if (r126 != null) goto L72;
            r126 = "";
        L72:
            r124.resumeWith(Result.m9449constructorimpl(new x39.b.f(r126)));
            if (this.f332311b != null) goto L75;
        L76:
            this.f332312c.j(this);
            return;
        L75:
            if (this.f332315f == null) goto L76;
            return;
        L138:
            return;
        L14:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332300i, r109) == false) goto L20;
            if (DoraWifiLinkWrapper.f332296e.contains(r109) == true) goto L20;
            DoraWifiLinkWrapper.f332300i = null;     // Catch: Throwable -> L25
            DoraWifiLinkWrapper.f332298g = r109;     // Catch: Throwable -> L25
            DoraWifiLinkWrapper.f332299h = r111;     // Catch: Throwable -> L25
            r112 = true;
        L28:
            r113 = true;
            goto L29
        }

        public d(DoraWifiScene r100, String r101, e r102, AtomicBoolean r103, j r104, Function0 r105) {
            this.f332310a = r100;
            this.f332311b = r101;
            this.f332312c = r102;
            this.f332313d = r103;
            this.f332314e = r104;
            this.f332315f = r105;
        }
    }

    public DoraWifiLinkWrapper() {
    }

    static {
        f332292a = new DoraWifiLinkWrapper();
        f332293b = kotlinx.coroutines.sync.b.a();
        f332294c = new ConcurrentHashMap();
        f332295d = new ConcurrentHashMap();
        f332296e = new LinkedHashSet();
        f332297f = new Object();
    }

    public static boolean f() {
        if (o0.d("p2p_rtc") == false) goto L7;
        sk4.e r100 = o0.f332223a;
        if (o0.d(FlowProtocolAbility.FEATURE_P2P_BT_RTC) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static boolean k() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L20
        Object r101 = AppHost.f326268a.getApplication().getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L20
        Integer r102 = null;
        if ((r101 instanceof WifiManager) == false) goto L5;
        WifiManager r103 = (WifiManager) r101;     // Catch: Throwable -> L20
    L6:
        if (r103 == null) goto L8;
        r102 = Integer.valueOf(r103.getWifiState());     // Catch: Throwable -> L20
    L8:
        boolean r104 = true;
        if (r102 != null) goto L12;
    L13:
        if (r102 != null) goto L16;
    L18:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L20
    L22:
        Boolean r106 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r105) == false) goto L26;
        r105 = r106;
    L26:
        return ((Boolean) r105).booleanValue();
    L16:
        if (r102.intValue() != 0) goto L18;
    L17:
        r104 = false;
        goto L18
    L12:
        if (r102.intValue() == 1) goto L17;
    L5:
        r103 = null;
    L20:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public static x39.a o() {
        DoraWifiScene r100 = DoraWifiScene.OTHER;
        e r101 = e.d.f555490a;
        r101.getClass();
        String r102 = r101.i(q(r100, DoraWifiLinkStrategy.fromValue(pk4.i.a.f529628a.f529627a.getInt("wifi_link_strategy", -1))));
        if (r102 == null) goto L24;
        switch(r102.hashCode()) {
            case -1743217746: goto L20;
            case -1374293515: goto L16;
            case -196981436: goto L12;
            case 1377196703: goto L8;
            default: goto L24;
        };
    L8:
        if (r102.equals(FlowDoraConnectReason.P2P_CHECK_HOTSPOT_OPEN) == false) goto L24;
        return x39.a.b.f562391a;
    L12:
        if (r102.equals(FlowDoraConnectReason.P2P_CHECK_VPN_OPEN) == false) goto L24;
        return x39.a.d.f562393a;
    L16:
        if (r102.equals(FlowDoraConnectReason.P2P_CHECK_LOCATION_NOT_PASS) == false) goto L24;
        return x39.a.C8191a.f562390a;
    L20:
        if (r102.equals(FlowDoraConnectReason.P2P_CHECK_WIFI_NOT_OPEN) == false) goto L24;
        return x39.a.e.f562394a;
    L24:
        return x39.a.c.f562392a;
    }

    public static List p() {
        int r100 = Build.VERSION.SDK_INT;
        boolean r101 = ObricFeatureServiceDelegate.f387839b.b();
        if (r100 < 33) goto L8;
        if (r101 == false) goto L10;
        return CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION");
    L10:
        return CollectionsKt.listOf(new String[]{"android.permission.NEARBY_WIFI_DEVICES", "android.permission.ACCESS_FINE_LOCATION"});
    L8:
        return CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION");
    }

    public static boolean g() {
        List r100 = p();
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L23;
        String r102 = (String) r101.next();
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), r102) != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L9;
        return false;
    L13:
        r103 = false;
        goto L14
    L23:
        return true;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return true;
    }

    public static boolean h() {
        boolean r100 = false;
        if (f() == true) goto L6;
        g49.d.d("DoraWifiLinkWrapper", "dataSaving decision: enabled=false, reason=no_bt_p2p_rtc_ability");
        return false;
    L6:
        Integer r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        e10 r103 = e10.f368561a;     // Catch: Throwable -> L15
        nu9.a r104 = e10.Q().a();     // Catch: Throwable -> L15
        if (r104 == null) goto L12;
        q r105 = r104.b();     // Catch: Throwable -> L15
        if (r105 == null) goto L12;
        f r106 = r105.a();     // Catch: Throwable -> L15
    L13:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r107) == false) goto L20;
        Object r108 = null;
    L21:
        f r109 = (f) r108;
        if (r109 == null) goto L24;
        Integer r110 = r109.b();
    L25:
        if (r109 == null) goto L27;
        r101 = r109.a();
    L27:
        if (r101 == null) goto L29;
        int r111 = r101.intValue();
    L31:
        if (r111 != 1) goto L33;
        boolean r112 = true;
    L34:
        if (r110 == null) goto L36;
        int r113 = r110.intValue();
    L37:
        if (r113 != 1) goto L39;
        boolean r114 = true;
    L40:
        String r115 = ILoginService.f286097a.getAccountInfo().f531530c;
        if (r115 != null) goto L44;
        r115 = "";
    L44:
        if (r114 == false) goto L48;
        b0.f338123a.getClass();
        Intrinsics.checkNotNullParameter(r115, "uid");
        if (b0.j().contains("dora_enable_data_saving_".concat(r115)) == false) goto L48;
        boolean r116 = true;
    L49:
        if (r114 == false) goto L53;
        if (r116 == false) goto L53;
        b0.f338123a.getClass();
        Intrinsics.checkNotNullParameter(r115, "uid");
        boolean r117 = b0.j().getBoolean("dora_enable_data_saving_".concat(r115), r112);
    L54:
        StringBuilder r118 = new StringBuilder("dataSaving decision: enabled=");
        r118.append(r117);
        r118.append(", settingsFetched=");
        r118.append(Result.m9456isSuccessimpl(r107));
        r118.append(", settingsNull=");
        if (r109 != null) goto L57;
        r100 = true;
    L57:
        r118.append(r100);
        r118.append(", rawShowEntrance=");
        r118.append(r110);
        r118.append(", rawDefValue=");
        r118.append(r101);
        r118.append(", showEntrance=");
        r118.append(r114);
        r118.append(", defValue=");
        r118.append(r112);
        r118.append(", hasUserChoice=");
        r118.append(r116);
        g49.d.d("DoraWifiLinkWrapper", r118.toString());
        return r117;
    L53:
        r117 = r112;
    L48:
        r116 = false;
        goto L49
    L39:
        r114 = false;
        goto L40
    L36:
        r113 = 0;
        goto L37
    L33:
        r112 = false;
        goto L34
    L29:
        r111 = 0;
        goto L31
    L24:
        r110 = null;
        goto L25
    L20:
        r108 = r107;
    L12:
        r106 = null;
    L15:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public static boolean i() {
        boolean r100 = f();
        Integer r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        e10 r103 = e10.f368561a;     // Catch: Throwable -> L11
        nu9.a r104 = e10.Q().a();     // Catch: Throwable -> L11
        if (r104 == null) goto L8;
        q r105 = r104.b();     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        f r106 = r105.a();     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r107) == false) goto L16;
        Object r108 = null;
    L17:
        f r109 = (f) r108;
        if (r109 == null) goto L20;
        Integer r110 = r109.b();
    L21:
        boolean r111 = true;
        if (r100 == false) goto L28;
        if (r110 == null) goto L25;
        int r112 = r110.intValue();
    L26:
        if (r112 != 1) goto L28;
        boolean r113 = true;
    L29:
        StringBuilder r114 = new StringBuilder("dataSaving entrance: visible=");
        r114.append(r113);
        r114.append(", hasAbility=");
        r114.append(r100);
        r114.append(", settingsFetched=");
        r114.append(Result.m9456isSuccessimpl(r107));
        r114.append(", settingsNull=");
        if (r109 == null) goto L33;
        r111 = false;
    L33:
        r114.append(r111);
        r114.append(", rawShowEntrance=");
        r114.append(r110);
        r114.append(", rawDefValue=");
        if (r109 == null) goto L36;
        r101 = r109.a();
    L36:
        r114.append(r101);
        g49.d.d("DoraWifiLinkWrapper", r114.toString());
        return r113;
    L25:
        r112 = 0;
    L28:
        r113 = false;
        goto L29
    L20:
        r110 = null;
        goto L21
    L16:
        r108 = r107;
    L8:
        r106 = null;
    L11:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static boolean j() {
        if (f() == true) goto L5;
    L8:
        return true;
    L5:
        if (l() == true) goto L8;
        return false;
    }

    public static boolean l() {
        boolean r100 = f();
        boolean r101 = k();
        if (r100 == true) goto L6;
        g49.d.d("DoraWifiLinkWrapper", "videoCallWifiEffective=" + r101 + ", reason=legacy_no_bt_p2p_rtc, systemWifi=" + r101);
        return r101;
    L6:
        boolean r102 = h();
        boolean r103 = true;
        if (r102 == true) goto L21;
        boolean r104 = true;
    L17:
        if (r102 == false) goto L19;
        r103 = r104;
    L19:
        g49.d.d("DoraWifiLinkWrapper", "videoCallWifiEffective=" + r103 + ", hasAbility=true, dataSaving=" + r102 + ", phoneWifiConnected=" + r104 + ", systemWifi=" + r101);
        return r103;
    L21:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L10
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(NetworkUtils.isWifi(AppHost.f326268a.getApplication())));     // Catch: Throwable -> L10
    L12:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L15;
        r106 = r107;
    L15:
        r104 = ((Boolean) r106).booleanValue();
    L10:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static a n() {
        return new a(g(), o0.d("p2p_rtc"));
    }

    public static Object e(Continuation r100) {
        List r101 = p();
        List r102 = r101;
        boolean r103 = true;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L17;
        String r105 = (String) r104.next();
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), r105) != 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L9;
        r103 = false;
        goto L17
    L13:
        r106 = false;
    L17:
        if (r103 == false) goto L20;
        return null;
    L20:
        return BuildersKt.withContext(Dispatchers.getMain(), new DoraWifiLinkWrapper$checkAndRequestPermissions$2(r101, null), r100);
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }

    public static x39.b m(String r100) {
        if (r100 != null) goto L4;
    L22:
        return null;
    L4:
        switch(r100.hashCode()) {
            case -1743217746: goto L19;
            case -1374293515: goto L15;
            case -196981436: goto L11;
            case 1377196703: goto L7;
            default: goto L22;
        };
    L7:
        if (r100.equals(FlowDoraConnectReason.P2P_CHECK_HOTSPOT_OPEN) == false) goto L22;
        return x39.b.c.f562398b;
    L11:
        if (r100.equals(FlowDoraConnectReason.P2P_CHECK_VPN_OPEN) == false) goto L22;
        return x39.b.g.f562402b;
    L15:
        if (r100.equals(FlowDoraConnectReason.P2P_CHECK_LOCATION_NOT_PASS) == false) goto L22;
        return x39.b.C8192b.f562397b;
    L19:
        if (r100.equals(FlowDoraConnectReason.P2P_CHECK_WIFI_NOT_OPEN) == false) goto L22;
        return x39.b.h.f562403b;
    }

    public static void d(DoraWifiScene r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        e r102 = e.d.f555490a;
        Object r103 = f332297f;
        monitor-enter(r103);
        boolean r104 = true;
        boolean r105 = false;
        if (r101 != null) goto L48;
    L13:
        if (r101 == null) goto L15;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == false) goto L24;
        r104 = false;
    L40:
        monitor-exit(r103);
        if (r104 == true) goto L44;
        g49.d.e("DoraWifiLinkWrapper", "disconnect: reject mismatched owner scene=" + r100);
        return;
    L44:
        g49.d.d("DoraWifiLinkWrapper", "disconnect: scene=" + r100);
        return;
    L24:
        if (r101 != null) goto L27;
        r102.b(r100);     // Catch: Throwable -> L11
        goto L40
    L27:
        if (Intrinsics.areEqual(f332298g, r101) == true) goto L29;
    L31:
        boolean r107 = Intrinsics.areEqual(f332300i, r101);     // Catch: Throwable -> L11
        h r108 = null;
        if (r105 == false) goto L34;
        f332298g = null;     // Catch: Throwable -> L11
        f332299h = null;     // Catch: Throwable -> L11
        f332296e.remove(r101);     // Catch: Throwable -> L11
        f332300i = null;     // Catch: Throwable -> L11
        f332295d.remove(r101);     // Catch: Throwable -> L11
        r108 = f332294c.remove(r101);     // Catch: Throwable -> L11
    L36:
        if (r108 == null) goto L38;
        r102.j(r108);     // Catch: Throwable -> L11
    L38:
        if (r107 == true) goto L40;
        r102.b(r100);     // Catch: Throwable -> L11
        goto L40
    L34:
        if (r107 == false) goto L36;
        f332296e.add(r101);     // Catch: Throwable -> L11
        f332295d.remove(r101);     // Catch: Throwable -> L11
        goto L36
    L29:
        if (f332299h != r100) goto L31;
        r105 = true;
        goto L31
    L15:
        if (f332298g == null) goto L19;
        if (f332299h != r100) goto L19;
    L20:
        r106 = true;
    L19:
        if (f332300i == null) goto L21;
    L48:
    L11:
        th = move-exception;
        throw th;
    L7:
        if (Intrinsics.areEqual(f332298g, r101) == true) goto L13;
        if (Intrinsics.areEqual(f332300i, r101) == false) goto L20;
        goto L20
    }

    public static DoraWifiLinkStrategy q(DoraWifiScene r100, DoraWifiLinkStrategy r101) {
        if (r100 != DoraWifiScene.ALBUM_SILENT) goto L7;
        return DoraWifiLinkStrategy.P2P_ONLY;
    L7:
        if (ObricFeatureServiceDelegate.f387839b.b() == true) goto L9;
    L12:
        return r101;
    L9:
        if (r101 != DoraWifiLinkStrategy.P2P_NEXT_SOFT_AP) goto L12;
        g49.d.d("DoraWifiLinkWrapper", "resolveWifiStrategy: override P2P_NEXT_SOFT_AP to P2P_ONLY for Obric OS, scene=" + r100);
        return DoraWifiLinkStrategy.P2P_ONLY;
    }

    public static boolean a(e r100, DoraWifiScene r101, String r102, Function0 r103) {
        b r104 = new b(r100, r102);
        Object r105 = f332297f;
        monitor-enter(r105);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(f332298g, r102) == false) goto L9;
        if (r103 == null) goto L19;
        f332295d.put(r102, r103);     // Catch: Throwable -> L29
    L19:
        boolean r106 = true;
    L21:
        monitor-exit(r105);
        if (r106 == true) goto L24;
        return false;
    L24:
        r100.a(r101);
        if (r100.f555486e != 2) goto L27;
        return true;
    L27:
        r100.b(r101);
        r104.a(2, 0, "connected_link_lost");
        return false;
    L9:
        if (f332298g == null) goto L11;
    L20:
        r106 = false;
        goto L21
    L11:
        if (f332300i != null) goto L20;
        if (r100.f555486e != 2) goto L20;
        f332298g = r102;     // Catch: Throwable -> L29
        f332299h = r101;     // Catch: Throwable -> L29
        f332294c.put(r102, r104);     // Catch: Throwable -> L29
        if (r103 == null) goto L18;
        f332295d.put(r102, r103);     // Catch: Throwable -> L29
    L18:
        ((CopyOnWriteArraySet) r100.f555484c).add(r104);     // Catch: Throwable -> L29
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedance.dora.wlan.model.DoraWifiScene, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.dora.wlan.model.DoraWifiScene] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object b(DoraWifiScene r110, DoraWifiLinkStrategy r111, boolean r112, String r113, Function0<Unit> r114, Continuation<? super x39.b> r115) {
        if ((r115 instanceof DoraWifiLinkWrapper$connect$2) == false) goto L7;
        DoraWifiLinkWrapper$connect$2 r100 = (DoraWifiLinkWrapper$connect$2) r115;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraWifiLinkWrapper$connect$2 r102 = r100;
        Object r116 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L16;
        kotlinx.coroutines.sync.a r117 = (kotlinx.coroutines.sync.a) r102.L$0;
        ResultKt.throwOnFailure(r116);     // Catch: Throwable -> L32
        r110 = r117;
    L29:
        x39.b r118 = (x39.b) r116;     // Catch: Throwable -> L32
        r110.unlock(null);
        return r118;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r112 = r102.Z$0;
        kotlinx.coroutines.sync.a r119 = (kotlinx.coroutines.sync.a) r102.L$4;
        Function0<Unit> r120 = (Function0) r102.L$3;
        String r121 = (String) r102.L$2;
        DoraWifiLinkStrategy r122 = (DoraWifiLinkStrategy) r102.L$1;
        DoraWifiScene r105 = (DoraWifiScene) r102.L$0;
        ResultKt.throwOnFailure(r116);
        String r106 = r121;
        Function0<Unit> r107 = r120;
        DoraWifiLinkStrategy r123 = r122;
        ?? r124 = r105;
        kotlinx.coroutines.sync.a r125 = r119;
    L22:
        ?? r108 = f332292a;     // Catch: Throwable -> L32
        if (r112 == false) goto L25;
        boolean r109 = true;
    L26:
        r102.L$0 = r125;     // Catch: Throwable -> L32
        r102.L$1 = null;     // Catch: Throwable -> L32
        r102.L$2 = null;     // Catch: Throwable -> L32
        r102.L$3 = null;     // Catch: Throwable -> L32
        r102.L$4 = null;     // Catch: Throwable -> L32
        r102.label = 2;     // Catch: Throwable -> L32
        r116 = r108.c(r124, r123, r109, r106, r107, r102);     // Catch: Throwable -> L32
        r110 = r125;
        if (r116 != r103) goto L29;
        return r103;
    L25:
        r109 = false;
        goto L26
    L18:
        ResultKt.throwOnFailure(r116);
        MutexImpl r126 = f332293b;
        r102.L$0 = r110;
        r102.L$1 = r111;
        r102.L$2 = r113;
        r102.L$3 = r114;
        r102.L$4 = r126;
        r102.Z$0 = r112;
        r102.label = 1;
        if (r126.a(null, r102) != r103) goto L21;
        return r103;
    L21:
        r106 = r113;
        r107 = r114;
        r123 = r111;
        r124 = r110;
        r125 = r126;
    L32:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L7:
        r100 = new DoraWifiLinkWrapper$connect$2(this, r115);
        goto L8
    }

    public final Object c(DoraWifiScene r110, DoraWifiLinkStrategy r210, boolean r211, String r212, Function0<Unit> r213, Continuation<? super x39.b> r214) {
        if ((r214 instanceof DoraWifiLinkWrapper$connectLocked$1) == false) goto L7;
        DoraWifiLinkWrapper$connectLocked$1 r100 = (DoraWifiLinkWrapper$connectLocked$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        DoraWifiLinkStrategy r106 = (DoraWifiLinkStrategy) r100.L$4;
        e r107 = (e) r100.L$3;
        Function0 r108 = (Function0) r100.L$2;
        String r109 = (String) r100.L$1;
        DoraWifiScene r111 = (DoraWifiScene) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L108:
        return r102;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function0<Unit> r112 = (Function0) r100.L$3;
        String r113 = (String) r100.L$2;
        DoraWifiLinkStrategy r114 = (DoraWifiLinkStrategy) r100.L$1;
        DoraWifiScene r115 = (DoraWifiScene) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Function0<Unit> r116 = r112;
        DoraWifiLinkStrategy r117 = r114;
    L22:
        x39.b r118 = (x39.b) r102;
    L40:
        if (r118 == null) goto L43;
        g49.d.b("DoraWifiLinkWrapper", "connect: permission denied " + r118);
        return r118;
    L43:
        g49.d.d("DoraWifiLinkWrapper", "connect: start method, scene=" + r115 + ", strategy=" + r117);
        e r119 = e.d.f555490a;
        if (r117 != null) goto L46;
        r119.getClass();
        r117 = DoraWifiLinkStrategy.fromValue(pk4.i.a.f529628a.f529627a.getInt("wifi_link_strategy", -1));
    L46:
        DoraWifiLinkStrategy r120 = q(r115, r117);
        if (r119.f555486e != 2) goto L49;
        boolean r121 = true;
    L50:
        if (r121 == false) goto L85;
        Object r122 = f332297f;
        monitor-enter(r122);
        String r123 = f332298g;     // Catch: Throwable -> L81
        monitor-exit(r122);
        if (r113 == null) goto L70;
        if (r123 != null) goto L58;
    L60:
        if (r123 == null) goto L62;
    L66:
        Intrinsics.checkNotNull(r119);
        boolean r124 = a(r119, r115, r113, r116);
    L67:
        if (r124 == true) goto L70;
        r105 = false;
        goto L70
    L62:
        if (r120 != DoraWifiLinkStrategy.P2P_ONLY) goto L66;
        if (r119.e() == false) goto L66;
    L65:
        r124 = false;
        goto L67
    L58:
        if (Intrinsics.areEqual(r123, r113) == true) goto L60;
    L70:
        if (r105 == true) goto L73;
        g49.d.e("DoraWifiLinkWrapper", "connect: reject unknown/mismatched owner scene=" + r115);
        return new x39.b.a("connected_owner_mismatch");
    L73:
        g49.d.d("DoraWifiLinkWrapper", "connect: already connected, scene=" + r115);
        if (r113 != null) goto L76;
        r119.a(r115);
    L76:
        String r125 = r119.c();
        if (r125 != null) goto L80;
        r125 = "";
    L80:
        return new x39.b.f(r125);
    L81:
        th = move-exception;
        throw th;
    L85:
        String r126 = r119.i(r120);
        x39.b r127 = m(r126);
        if (r127 == null) goto L89;
        g49.d.e("DoraWifiLinkWrapper", "connect: precheck failed, reason=" + r126 + ", scene=" + r115);
        return r127;
    L89:
        r100.L$0 = r115;
        r100.L$1 = r113;
        r100.L$2 = r116;
        r100.L$3 = r119;
        r100.L$4 = r120;
        r100.label = 2;
        j r128 = new j(IntrinsicsKt.intercepted(r100), 1);
        r128.C();
        d r129 = new d(r115, r113, r119, new AtomicBoolean(false), r128, r116);
        r128.i(new c(r115, r119, r129, r113));
        if (r113 == null) goto L103;
        Object r130 = f332297f;
        monitor-enter(r130);
        f332296e.remove(r113);     // Catch: Throwable -> L100
        f332300i = r113;     // Catch: Throwable -> L100
        if (r116 == null) goto L96;
        f332295d.put(r113, r116);     // Catch: Throwable -> L100
    L96:
        h r131 = f332294c.put(r113, r129);     // Catch: Throwable -> L100
        monitor-exit(r130);
        if (r131 == null) goto L103;
        r119.j(r131);
    L100:
        th = move-exception;
        throw th;
    L103:
        ((CopyOnWriteArraySet) r119.f555484c).add(r129);
        g49.d.d("DoraWifiLinkWrapper", "connect: do connect action, scene=" + r115 + ", finalStrategy=" + r120);
        dl4.a.a(new vk4.b(r119, r115, r120));
        r102 = r128.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L106:
        if (r102 != r103) goto L108;
        return r103;
    L49:
        r121 = false;
        goto L50
    L16:
        ResultKt.throwOnFailure(r102);
        if (r211 == false) goto L23;
        r100.L$0 = r110;
        r117 = r210;
        r100.L$1 = r117;
        r113 = r212;
        r100.L$2 = r113;
        r116 = r213;
        r100.L$3 = r116;
        r100.label = 1;
        Object r132 = e(r100);
        if (r132 != r103) goto L21;
        return r103;
    L21:
        r115 = r110;
        r102 = r132;
        goto L22
    L23:
        r117 = r210;
        r113 = r212;
        r116 = r213;
        int r133 = Build.VERSION.SDK_INT;
        boolean r134 = ObricFeatureServiceDelegate.f387839b.b();
        if (r133 < 33) goto L27;
        if (r134 == false) goto L27;
        String r135 = null;
    L30:
        if (r135 != null) goto L33;
    L34:
        x39.b r136 = null;
    L39:
        x39.b r137 = r136;
        r115 = r110;
        r118 = r137;
        goto L40
    L33:
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), r135) == 0) goto L34;
        if (Intrinsics.areEqual(r135, "android.permission.NEARBY_WIFI_DEVICES") == false) goto L38;
        r136 = x39.b.e.f562400b;
        goto L39
    L38:
        r136 = x39.b.d.f562399b;
    L27:
        if (r133 < 33) goto L29;
        r135 = "android.permission.NEARBY_WIFI_DEVICES";
        goto L30
    L29:
        r135 = "android.permission.ACCESS_FINE_LOCATION";
    L7:
        r100 = new DoraWifiLinkWrapper$connectLocked$1(this, r214);
        goto L8
    }
}
