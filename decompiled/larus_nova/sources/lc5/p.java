package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f508507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f508508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f508509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f508510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f508511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f508512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f508513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f508514n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f508515o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f508516p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f508517q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f508518r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f508519s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f508520t;

    public final int getType() {
        return this.f508508h;
    }

    public p(String r110, String r111, String r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r111, "subModule");
        Intrinsics.checkNotNullParameter(r112, "click");
        Intrinsics.checkNotNullParameter(r113, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r114, "currentSubView");
        this(r110, r111, r112, r113, r114, r115, null, null);
    }

    public p(String r210, String r211, String r212, int r213, String r214, Boolean r215, String r216) {
        Intrinsics.checkNotNullParameter("recent", "currentSubView");
        this("ccm_space_home_page_click", "home", "recent", r210, r211, "recent", r212, r213, r214, "", false, false, false, 0, r215, r216, null, null, null, "list");
    }

    public p(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217) {
        Intrinsics.checkNotNullParameter(r214, "currentSubView");
        int r100 = sbb.e.f541294e.f541317b;
        Intrinsics.checkNotNullParameter(r214, "currentSubView");
        if (r215 != null) goto L5;
        String r101 = "ccm_space_home_page_click";
    L6:
        this(r101, r210, r211, r212, r213, r214, "", r100, "", "", false, false, false, 0, null, "", null, r216, r217, null);
        return;
    L5:
        r101 = r215;
        goto L6
    }

    public p(String r210, String r211, String r212, String r213, String r214, String r215, int r216, String r310, Boolean r311, String r312, String r313) {
        Intrinsics.checkNotNullParameter(r214, "currentSubView");
        if (r313 != null) goto L5;
        String r100 = "ccm_space_home_page_click";
    L6:
        this(r100, r210, r211, r212, r213, r214, r215, r216, r310, "", false, false, false, 0, r311, r312, null, null, null, null);
        return;
    L5:
        r100 = r313;
        goto L6
    }

    public p(String r210, String r211, String r212, String r213, String r214, String r215, int r216, String r310, String r311, boolean r312, boolean r313, boolean r314, int r315, Boolean r316, String r317, String r318) {
        Intrinsics.checkNotNullParameter(r214, PickerReporterConstants.KEY.TARGET);
        this(r210, r211, r212, r213, r214, "", r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, null, null, null);
    }

    public p(String r100, String r101, String r102, String r103, String r104, String r105, String r106, int r110, String r111, String r112, boolean r113, boolean r114, boolean r115, int r116, Boolean r117, String r118, String r119, String r210, String r211, String r212) {
        this.f508501a = r100;
        this.f508502b = r101;
        this.f508503c = r102;
        this.f508504d = r103;
        this.f508505e = r104;
        this.f508506f = r105;
        this.f508507g = r106;
        this.f508508h = r110;
        this.f508509i = r111;
        this.f508510j = r112;
        this.f508511k = r113;
        this.f508512l = r114;
        this.f508513m = r115;
        this.f508514n = r116;
        this.f508515o = r117;
        this.f508516p = r118;
        this.f508517q = r119;
        this.f508518r = r210;
        this.f508519s = r211;
        this.f508520t = r212;
    }
}
