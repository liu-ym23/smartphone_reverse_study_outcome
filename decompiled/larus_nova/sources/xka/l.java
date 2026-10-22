package xka;

import android.content.ContentValues;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l implements vka.b<Long> {
    public static final /* synthetic */ int I = 0;
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final String F;
    public final String G;
    public final String H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f564320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f564323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f564324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f564325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f564326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f564327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f564328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f564329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f564330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f564331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f564332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Long f564333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f564334o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f564335p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Long f564336q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Long f564337r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Long f564338s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Integer f564339t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f564340u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f564341v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f564342w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Long f564343x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f564344y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f564345z;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentValues r101 = new ContentValues();
        r101.put("name", this.f564321b);
        r101.put("account_type", this.f564324e);
        r101.put("account_name", this.f564323d);
        r101.put("calendar_location", this.f564322c);
        r101.put("calendar_color", this.f564325f);
        r101.put("calendar_color_index", this.f564326g);
        r101.put("_sync_id", this.f564327h);
        r101.put("dirty", this.f564328i);
        r101.put("mutators", this.f564329j);
        r101.put("deleted", this.f564330k);
        r101.put("calendar_displayName", this.f564331l);
        r101.put("calendar_access_level", this.f564332m);
        r101.put("visible", this.f564333n);
        r101.put("calendar_timezone", this.f564334o);
        r101.put("ownerAccount", this.f564335p);
        r101.put("sync_events", this.f564336q);
        r101.put("canOrganizerRespond", this.f564337r);
        r101.put("canModifyTimeZone", this.f564338s);
        r101.put("maxReminders", this.f564339t);
        r101.put("allowedReminders", this.f564340u);
        r101.put("allowedAvailability", this.f564341v);
        r101.put("allowedAttendeeTypes", this.f564342w);
        r101.put("isPrimary", this.f564343x);
        r101.put("cal_sync1", this.f564344y);
        r101.put("cal_sync2", this.f564345z);
        r101.put("cal_sync3", this.A);
        r101.put("cal_sync4", this.B);
        r101.put("cal_sync5", this.C);
        r101.put("cal_sync6", this.D);
        r101.put("cal_sync7", this.E);
        r101.put("cal_sync8", this.F);
        r101.put("cal_sync9", this.G);
        r101.put("cal_sync10", this.H);
        if (this.f564320a == null) goto L8;
        if (r100.update(new ala.a(this.f564320a, this.f564323d), r101, null, null) > 0) goto L10;
        return null;
    L10:
        return this.f564320a;
    L8:
        return r100.insert(new ala.a(null, this.f564323d), r101);
    }

    public l(Long r100, String r101, String r102, String r103, String r104, Integer r105, String r106, String r110, Long r111, String r112, Long r113, String r114, Integer r115, Long r116, String r117, String r118, Long r119, Long r210, Long r211, Integer r212, String r213, String r214, String r215, Long r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316) {
        this.f564320a = r100;
        this.f564321b = r101;
        this.f564322c = r102;
        this.f564323d = r103;
        this.f564324e = r104;
        this.f564325f = r105;
        this.f564326g = r106;
        this.f564327h = r110;
        this.f564328i = r111;
        this.f564329j = r112;
        this.f564330k = r113;
        this.f564331l = r114;
        this.f564332m = r115;
        this.f564333n = r116;
        this.f564334o = r117;
        this.f564335p = r118;
        this.f564336q = r119;
        this.f564337r = r210;
        this.f564338s = r211;
        this.f564339t = r212;
        this.f564340u = r213;
        this.f564341v = r214;
        this.f564342w = r215;
        this.f564343x = r216;
        this.f564344y = r217;
        this.f564345z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
        this.E = r313;
        this.F = r314;
        this.G = r315;
        this.H = r316;
    }
}
