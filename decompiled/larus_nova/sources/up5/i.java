package up5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;

/* JADX INFO: loaded from: classes18.dex */
public final class i {
    public static final boolean a(String r100) {
        String r101 = null;
        AccountService$Account r102 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r102 == null) goto L6;
        r101 = r102.tenantId;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return false;
    L11:
        return TextUtils.equals(r101, r100);
    }
}
