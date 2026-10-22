package up5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public static final boolean a(String r3) {
        String r1 = null;
        AccountService.Account r0 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r0 == null) goto L6;
        r1 = r0.tenantId;
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return false;
    L11:
        return TextUtils.equals(r1, r3);
    }
}
