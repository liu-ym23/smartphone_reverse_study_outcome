package jc4;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class d extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498105n;

    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String e() {
        return "twice_verify";
    }

    @Override // jc4.a
    public final String g() {
        return "email_verify";
    }

    @Override // jc4.a
    public int getType() {
        return 11;
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "verifyTicket");
        this.f498105n = r100;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        hc4.f.c(r100, "decision_config", "email_verify");
        if (TextUtils.isEmpty(this.f498105n) == true) goto L5;
        hc4.f.c(r100, "verify_ticket", this.f498105n);
    L5:
        hc4.f.b(r100, "is_turing", 1);
        hc4.f.b(r100, "use_turing_bridge", 1);
        BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;
        if (r101 == null) goto L8;
        int r102 = r101.getEmailDigits();
    L9:
        hc4.f.b(r100, "use_email_mode", r102);
        return;
    L8:
        r102 = 0;
        goto L9
    }
}
