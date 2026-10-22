package qd9;

import buc.b;
import buc.c;
import buc.d;
import com.larus.im.internal.audio.trace.smartnetwork.MultipathCause;
import com.larus.im.internal.delegate.d1;
import java.util.LinkedHashMap;
import java.util.Map;
import kf9.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f532581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final buc.a f532582b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final buc.a f532583c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f532584d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f532585e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final buc.a f532586f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final buc.a f532587g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final buc.a f532588h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final buc.a f532589i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final buc.a f532590j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final buc.a f532591k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f532592l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final buc.a f532593m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f532594n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f532595o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c f532596p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f532597q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c f532598r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c f532599s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c f532600t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f532601u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c f532602v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c f532603w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static MultipathCause f532604x;

    public a() {
    }

    static {
        f532581a = new a();
        f532582b = b.a(false);
        f532583c = b.a(false);
        f532584d = b.b();
        f532585e = b.b();
        f532586f = b.a(false);
        f532587g = b.a(false);
        f532588h = b.a(false);
        f532589i = b.a(false);
        f532590j = b.a(false);
        f532591k = b.a(false);
        f532592l = b.b();
        f532593m = b.a(false);
        f532594n = b.b();
        f532595o = b.b();
        f532596p = b.b();
        f532597q = b.c(0);
        f532598r = b.b();
        f532599s = b.b();
        f532600t = b.b();
        f532601u = b.c(0);
        f532602v = b.b();
        f532603w = b.b();
        f532604x = MultipathCause.NONE;
    }

    public static void d() {
        f532582b.d(false);
        f532583c.d(false);
        e(0);
        f532585e.d(0);
        f532586f.d(false);
        f532587g.d(false);
        f532588h.d(false);
        f532589i.d(false);
        f532590j.d(false);
        f532604x = MultipathCause.NONE;
        f532591k.d(false);
        f532592l.d(0);
        f532593m.d(false);
        f532594n.d(0);
        f532595o.d(0);
        f532596p.d(0);
        f532597q.e(0);
        f532598r.d(0);
        f532599s.d(0);
        f532600t.d(0);
        f532601u.e(0);
        f532602v.d(0);
        f532603w.d(0);
    }

    public final String toString() {
        return "SmartNetworkReport = {mIsWifiNetworkValid = " + f532582b.c() + ", mIsCellNetworkValid = " + f532583c.c() + ", mL2NetworkQuality = " + f532584d.b() + ", mL4NetworkQuality = " + f532585e.b() + ", mIsSmartNetworkEnable = " + f532586f.c() + ", mIsL2AndAccelerateEnable = " + f532587g.c() + ", mIsRtcMultipathEnable = " + f532588h.c() + ", mIsRedundantSendEnable = " + f532589i.c() + ", mIsRtcMultipathWork = " + f532590j.c() + ", mMultipathCause = " + f532604x + ", mIs2Dot4GReport = " + f532591k.c() + ", mChloadScoreReport = " + f532592l.b() + ", mIsHavePosition = " + f532593m.c() + ", mBandWidthReport = " + f532594n.b() + ", mEncryptionTypeReport = " + f532595o.b() + ", mSameChannelApNumReport = " + f532596p.b() + ", mWifiScanningTimeReport = " + f532597q.c() + ", mStaNumOfApReport = " + f532598r.b() + ", mWifiStandardReport = " + f532599s.b() + ", mApHistoryScoreReport = " + f532600t.b() + ", mTotalCellularBytesReport = " + f532601u.c() + ", mTxCellularKBitrate = " + f532602v.b() + ", mTxWifiKBitRate = " + f532603w.b() + '}';
    }

    public static void e(int r100) {
        f532584d.d(r100);
    }

    public static void f(MultipathCause r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        f532604x = r100;
    }

    public final void a(Map<String, Object> r100) {
        if (r100 != null) goto L6;
        fe9.a.f476620a.e("SmartNetwork", "params is null");
        return;
    L6:
        g.a(r100, "smart_network_is_wifi_valid", Boolean.valueOf(f532582b.c()));
        g.a(r100, "smart_network_is_cell_valid", Boolean.valueOf(f532583c.c()));
        g.a(r100, "smart_network_l2_network_quality", Integer.valueOf(f532584d.b()));
        g.a(r100, "smart_network_l4_network_quality", Integer.valueOf(f532585e.b()));
        g.a(r100, "smart_network_is_enable", Boolean.valueOf(f532586f.c()));
        g.a(r100, "smart_network_accelerate_is_enable", Boolean.valueOf(f532587g.c()));
        g.a(r100, "smart_network_is_rtc_multipath_enable", Boolean.valueOf(f532588h.c()));
        g.a(r100, "smart_network_is_redundant_send_enable", Boolean.valueOf(f532589i.c()));
        g.a(r100, "smart_network_is_rtc_multipath_work", Boolean.valueOf(f532590j.c()));
        g.a(r100, "smart_network_multipath_cause", f532604x);
        g.a(r100, "smart_network_is_2dot4g", Boolean.valueOf(f532591k.c()));
        g.a(r100, "smart_network_chload_score", Integer.valueOf(f532592l.b()));
        g.a(r100, "smart_network_is_have_position", Boolean.valueOf(f532593m.c()));
        g.a(r100, "smart_network_bandwidth", Integer.valueOf(f532594n.b()));
        g.a(r100, "smart_network_encryption_type", Integer.valueOf(f532595o.b()));
        g.a(r100, "smart_network_same_channel_ap_num", Integer.valueOf(f532596p.b()));
        g.a(r100, "smart_network_wifi_scanning_time", Long.valueOf(f532597q.c()));
        g.a(r100, "smart_network_sta_num_of_ap", Integer.valueOf(f532598r.b()));
        g.a(r100, "smart_network_wifi_standard", Integer.valueOf(f532599s.b()));
        g.a(r100, "smart_network_ap_history_score", Integer.valueOf(f532600t.b()));
        fe9.a.f476620a.e("SmartNetwork", toString());
    }

    public final void c(int r100, int r101, int r102, int r103, int r104, int r105) {
        LinkedHashMap r106 = new LinkedHashMap();
        a(r106);
        g.a(r106, "smart_network_single_wifi_rtt_avg", Integer.valueOf(r100));
        g.a(r106, "smart_network_single_wifi_rtt_p95", Integer.valueOf(r101));
        g.a(r106, "smart_network_mp_wifi_rtt_avg", Integer.valueOf(r102));
        g.a(r106, "smart_network_mp_wifi_rtt_p95", Integer.valueOf(r103));
        g.a(r106, "smart_network_mp_cell_rtt_avg", Integer.valueOf(r104));
        g.a(r106, "smart_network_mp_cell_rtt_p95", Integer.valueOf(r105));
        g.a(r106, "smart_network_mp_cell_total_bytes", Long.valueOf(f532601u.c()));
        d1.f348206b.a("flow_av_smart_network_stop", g.b(r106));
    }

    public final void b(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        LinkedHashMap r107 = new LinkedHashMap();
        a(r107);
        g.a(r107, "smart_network_mp_report_times", Integer.valueOf(r106));
        g.a(r107, "smart_network_mp_wifi_min_rtt", Integer.valueOf(r100));
        g.a(r107, "smart_network_mp_wifi_max_rtt", Integer.valueOf(r101));
        g.a(r107, "smart_network_mp_wifi_avg_rtt", Integer.valueOf(r102));
        g.a(r107, "smart_network_mp_cell_min_rtt", Integer.valueOf(r103));
        g.a(r107, "smart_network_mp_cell_max_rtt", Integer.valueOf(r104));
        g.a(r107, "smart_network_mp_cell_avg_rtt", Integer.valueOf(r105));
        g.a(r107, "smart_network_mp_wifi_tx_rate", Integer.valueOf(f532603w.b()));
        g.a(r107, "smart_network_mp_cell_tx_rate", Integer.valueOf(f532602v.b()));
        d1.f348206b.a("flow_av_smart_network_mp_start", g.b(r107));
    }
}
