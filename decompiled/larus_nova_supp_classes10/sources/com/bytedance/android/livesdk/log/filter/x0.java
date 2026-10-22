package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x0 extends a<IBaseUser> {
    public String c;

    public x0() {
        this.c = "";
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r2) {
        super.a(r2);
        J(r2, null);
    }

    public final void J(Map<String, String> r2, IBaseUser r3) {
        super.u(r2, r3);
        if (r3 != null) goto L5;
    L7:
        r2.put("user_id", this.c);
        return;
    L5:
        if (TextUtils.isEmpty(r3.getIdString()) == true) goto L7;
        this.c = r3.getIdString();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final /* bridge */ /* synthetic */ void u(Map r1, Object r2) {
        J(r1, (IBaseUser) r2);
    }
}
