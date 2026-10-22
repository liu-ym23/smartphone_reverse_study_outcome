package o47;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static final boolean a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Number r101 = r100.f521972c.a();
        String r102 = r100.f521972c.e();
        String r103 = r100.f521971b;
        if (r101 != null) goto L5;
    L16:
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L16;
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return false;
    L11:
        if (r101.longValue() > System.currentTimeMillis()) goto L14;
        com.bytedance.pia.core.utils.d.l("[Cache] cache is invalid, reason: expire by maxAge", null, 14);
        return false;
    L14:
        return true;
    }
}
