package st;

import android.os.SystemClock;
import android.view.Window;
import com.bytedance.android.gamecp.base.cache.c;
import com.bytedance.android.gamecp.business.monitor.GameDetailFmpConfig;
import com.bytedance.android.gamecp.common.monitor_v1.FMPMonitorTracker;
import com.bytedance.android.gamecp.common.monitor_v1.h;
import com.bytedance.android.gamecp.host_api.service.FmpCalculator;
import com.bytedance.ies.sve_core.Store;
import com.bytedance.ies.sve_core.w;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f543529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Window f543530e;

    /* JADX INFO: renamed from: st.a$a, reason: collision with other inner class name */
    public static final class C7652a implements FmpCalculator.FmpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.sve_core.a f543531a;

        public C7652a(com.bytedance.ies.sve_core.a r100) {
            this.f543531a = r100;
        }
    }

    public static final class b implements FmpCalculator.FmpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.sve_core.a f543532a;

        public b(com.bytedance.ies.sve_core.a r100) {
            this.f543532a = r100;
        }
    }

    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        if ((r110 instanceof tt.a.C7770a) == false) goto L51;
        tt.a.C7770a r100 = (tt.a.C7770a) r110;
        String r101 = r100.f547495a;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return;
    L13:
        if (r100.f547496b != null) goto L15;
        return;
    L15:
        if (this.f543530e == null) goto L55;
        List<String> r104 = GameDetailFmpConfig.f56152a;
        String r105 = r100.f547495a;
        if (GameDetailFmpConfig.a() == false) goto L29;
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L29;
        if (GameDetailFmpConfig.f56154c.contains(r105) == true) goto L29;
        boolean r107 = true;
    L30:
        if (r107 == false) goto L32;
        c<String, FMPMonitorTracker.b> r108 = FMPMonitorTracker.f56549a;
        FMPMonitorTracker.n(this.f543529d, r100.f547495a, SystemClock.elapsedRealtime());
        int r109 = eu.a.f473969a;
        eu.a.a(new FmpCalculator(this.f543529d, "game_detail", r100.f547496b, this.f543530e, new C7652a(r110), 0, false, false, null, 14304));
    L32:
        String r111 = r100.f547495a;
        if (GameDetailFmpConfig.a() == false) goto L44;
        if (r111 != null) goto L36;
    L39:
        boolean r112 = true;
    L40:
        if (r112 == true) goto L44;
        if (GameDetailFmpConfig.f56155d.contains(r111) == false) goto L44;
        r102 = true;
        goto L44
    L36:
        if (r111.length() == 0) goto L39;
        r112 = false;
    L44:
        if (r102 == false) goto L54;
        c<String, FMPMonitorTracker.b> r113 = FMPMonitorTracker.f56549a;
        String r114 = this.f543529d;
        String r115 = r100.f547495a;
        long r116 = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(r114, "trackId");
        if (FMPMonitorTracker.d() == false) goto L49;
        FMPMonitorTracker.e().post(new h(r114, r115, r116));
    L49:
        int r117 = eu.a.f473969a;
        eu.a.a(new FmpCalculator(this.f543529d, "game_detail", r100.f547496b, this.f543530e, new b(r110), 0, true, false, null, 14304));
        return;
    L54:
        return;
    L21:
        if (r105.length() == 0) goto L24;
        r106 = false;
    L29:
        r107 = false;
        goto L30
    L55:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r103 = false;
        goto L11
    }

    public a(Store r100, String r101, Window r102) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "fmpTrackId");
        super(r100);
        this.f543529d = r101;
        this.f543530e = r102;
    }
}
