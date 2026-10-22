package j59;

import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f497473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f497474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f497475c;

    public final a b() {
        return new a(this.f497473a.getLong(a("last_show_time")), this.f497473a.getInt(a("show_times")), this.f497473a.getInt(a("close_times")), this.f497473a.getInt(a("click_times")));
    }

    public final String a(String r100) {
        return this.f497474b + '_' + r100 + '_' + this.f497475c;
    }

    public b(c r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "keyPrefix");
        Intrinsics.checkNotNullParameter(r102, "sn");
        this.f497473a = r100;
        this.f497474b = r101;
        this.f497475c = r102;
    }
}
