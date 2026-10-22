package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.live.core.setting.o2;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends a<am2.i> {
    public static Boolean e;
    public String c;
    public String d;

    public l() {
        this.c = "";
        this.d = "";
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r7) {
        super.a(r7);
        am2.j.a().getClass();
        String r1 = "1";
        if (am2.j.d == false) goto L5;
        String r0 = "1";
    L6:
        r7.put("is_first_start", r0);
        am2.j.c r2 = am2.j.a().b;
        int r3 = -1;
        if (r2 != null) goto L9;
        int r4 = -1;
    L10:
        r7.put("net_quality", String.valueOf(r4));
        am2.j.b r5 = am2.j.a().c;
        if (r5 != null) goto L13;
        int r6 = -1;
    L14:
        r7.put("downstream_throughput_kbps", String.valueOf(r6));
        am2.j.a r8 = am2.j.a().a;
        if (r8 != null) goto L17;
        String r9 = "";
    L18:
        r7.put("definition", r9);
        r7.put("fold_state", FoldScreenUtils.a() + "");
        boolean r10 = FoldScreenUtils.f();
        if (r10 == false) goto L21;
        String r11 = "1";
    L22:
        r7.put("is_fold", r11);
        if (e != null) goto L26;
        e = (Boolean) o2.a.getValue();
    L26:
        if (e == Boolean.TRUE) goto L28;
        return;
    L28:
        if (TextUtils.isEmpty(this.c) == false) goto L32;
        ce1.d r12 = ce1.e.a;
        if (r12 == null) goto L32;
        this.c = r12.a();
    L32:
        r7.put("is_pad", this.c);
        if (r10 == true) goto L36;
        r1 = BDLocationException.ERROR_TIMEOUT;
    L36:
        r7.put("is_fold_screen", r1);
        if (TextUtils.isEmpty(this.d) == true) goto L41;
        if (TextUtils.equals(this.d, "-1") == true) goto L41;
    L47:
        r7.put("fold_type", this.d);
        return;
    L41:
        if (FoldScreenUtils.a != null) goto L43;
        FoldScreenUtils.a = jc1.k.f(IMiddleWareHostContext.class);
    L43:
        IMiddleWareHostContext r13 = FoldScreenUtils.a;
        if (r13 == null) goto L46;
        r3 = r13.getFoldType();
    L46:
        this.d = String.valueOf(r3);
        goto L47
    L21:
        r11 = BDLocationException.ERROR_TIMEOUT;
        goto L22
    L17:
        r9 = r8.getDefinition();
        goto L18
    L13:
        r6 = r5.a();
        goto L14
    L9:
        r4 = r2.getNetQuality();
        goto L10
    L5:
        r0 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }
}
