package jc4;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class r extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498133n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f498134o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f498135p;

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
        return "mobile_up_sms_verify";
    }

    @Override // jc4.a
    public int getType() {
        return 6;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        hc4.f.c(r100, "decision_config", "block-upsms");
        hc4.f.b(r100, "is_turing", 1);
        if (TextUtils.isEmpty(this.f498133n) == true) goto L5;
        hc4.f.c(r100, "verify_ticket", this.f498133n);
    L5:
        hc4.f.c(r100, "channel_mobile", this.f498134o);
        hc4.f.c(r100, "sms_content", this.f498135p);
        hc4.f.b(r100, "use_turing_bridge", 1);
        BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;
        if (r101 == null) goto L8;
        int r102 = r101.getSmsDigits();
    L9:
        hc4.f.b(r100, "use_sms_mode", r102);
        return;
    L8:
        r102 = 0;
        goto L9
    }

    public r(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "verifyTicket");
        Intrinsics.checkNotNullParameter(r101, "channelMobile");
        Intrinsics.checkNotNullParameter(r102, "smsContent");
        this.f498133n = r100;
        this.f498134o = r101;
        this.f498135p = r102;
    }
}
