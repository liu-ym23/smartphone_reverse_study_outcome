package rk0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import yz0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final String a() {
        g r100 = (g) f.d(j.C0.a(), g.class);
        if (r100 == null) goto L8;
        IBaseUser r101 = r100.getUser();
        if (r101 == null) goto L8;
        String r102 = r101.getIdString();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }
}
