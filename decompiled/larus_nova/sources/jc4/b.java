package jc4;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498103n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f498104o;

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
        return "mobile_sms_verify";
    }

    @Override // jc4.a
    public int getType() {
        return 7;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        hc4.f.c(r100, "decision_config", "block-sms");
        hc4.f.b(r100, "is_turing", 1);
        if (TextUtils.isEmpty(this.f498103n) == true) goto L6;
        hc4.f.c(r100, "verify_ticket", this.f498103n);
    L6:
        if (TextUtils.isEmpty(this.f498104o) == true) goto L8;
        hc4.f.c(r100, "show_mobile", this.f498104o);
    L8:
        hc4.f.b(r100, "use_turing_bridge", 1);
        BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;
        if (r101 == null) goto L11;
        int r102 = r101.getSmsDigits();
    L12:
        hc4.f.b(r100, "use_sms_mode", r102);
        return;
    L11:
        r102 = 0;
        goto L12
    }

    public b(String r100, String r101) {
        this.f498103n = r100;
        this.f498104o = r101;
    }
}
