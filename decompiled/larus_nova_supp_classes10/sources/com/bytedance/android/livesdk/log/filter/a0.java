package com.bytedance.android.livesdk.log.filter;

import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0 extends com.bytedance.android.livesdk.log.filter.a<n> {
    public boolean c;

    public static final class a {
    }

    static {
    }

    public a0() {
        J(null);
    }

    public final void J(n r6) {
        this.b.clear();
        String r0 = "1";
        if (r6 == null) goto L11;
        this.b.put("channel_id", String.valueOf(r6.u()));
        this.b.put("channel_name", r6.i());
        this.b.put("member_number", String.valueOf(r6.B()));
        Map<String, String> r2 = this.b;
        if (r6.c() == false) goto L7;
        String r3 = "1";
    L8:
        r2.put("is_creator", r3);
        if (r6.c() == true) goto L11;
        this.b.put("creator_id", r6.q());
        this.b.put("sec_creator_id", r6.p());
        goto L11
    L7:
        r3 = BDLocationException.ERROR_TIMEOUT;
    L11:
        Map<String, String> r7 = this.b;
        if (this.c == true) goto L15;
        r0 = BDLocationException.ERROR_TIMEOUT;
    L15:
        r7.put("is_tab_mode", r0);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        super.a(r2);
        r2.putAll(this.b);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final /* bridge */ /* synthetic */ void setData(Object r1) {
        J((n) r1);
    }
}
