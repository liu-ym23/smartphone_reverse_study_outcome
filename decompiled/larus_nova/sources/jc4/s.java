package jc4;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class s extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498136n;

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
        return "mobile_voice_sms_verify";
    }

    @Override // jc4.a
    public int getType() {
        return 13;
    }

    public s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "verifyTicket");
        this.f498136n = r100;
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        hc4.f.c(r100, "decision_config", "mobile_voice_sms_verify");
        if (TextUtils.isEmpty(this.f498136n) == true) goto L5;
        hc4.f.c(r100, "verify_ticket", this.f498136n);
    L5:
        hc4.f.b(r100, "use_turing_bridge", 1);
    }
}
