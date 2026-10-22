package jc4;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f498090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f498091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f498092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f498094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f498095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f498096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f498097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f498098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f498099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f498100k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f498101l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f498102m;

    public abstract void a(StringBuilder r100);

    public boolean b() {
        return true;
    }

    public abstract int c();

    public abstract String e();

    public abstract String g();

    public abstract int getType();

    public final String f() {
        int r100 = tb4.b.f545252a;
        String r101 = this.f498102m;
        String r102 = e();
        Activity r103 = getActivity();
        Intrinsics.checkNotNullParameter(r102, NsdHelper.serviceTypeKey);
        if (r101 != null) goto L5;
    L7:
        com.bytedance.bdturing.setting.e r104 = com.bytedance.bdturing.setting.e.f202077a;
        Intrinsics.checkNotNullParameter(r102, "service");
        r101 = com.bytedance.bdturing.setting.e.c(r102, "url");
    L8:
        com.bytedance.bdturing.setting.e r105 = com.bytedance.bdturing.setting.e.f202077a;
        String r106 = com.bytedance.bdturing.setting.e.d(r102);
        if (Intrinsics.areEqual(r102, "twice_verify") == false) goto L18;
        fc4.a r107 = com.bytedance.bdturing.twiceverify.a.a().f202111a;
        if (r107 == null) goto L13;
        r106 = r107.S();
    L14:
        fc4.a r108 = com.bytedance.bdturing.twiceverify.a.a().f202111a;
        if (r108 == null) goto L17;
        r108.url();
        r101 = "https://rmc.bytedance.com/verifycenter/authentication";
        goto L18
    L17:
        r101 = null;
        goto L18
    L13:
        r106 = null;
    L18:
        int r109 = qb4.n.f532367a;
        StringBuilder r110 = new StringBuilder(r101 + '?');
        hc4.f.a(r110, r106);
        tb4.b.a(r103, r110);
        a(r110);
        return r110.toString();
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L7;
        goto L7
    }

    public final Activity getActivity() {
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTopActivity();
    }

    public a() {
        this.f498091b = true;
        this.f498092c = true;
        this.f498093d = "";
        this.f498095f = "";
        this.f498097h = -1;
        this.f498098i = "";
        this.f498099j = "";
        this.f498101l = "";
    }

    public boolean d() {
        return this.f498090a;
    }
}
