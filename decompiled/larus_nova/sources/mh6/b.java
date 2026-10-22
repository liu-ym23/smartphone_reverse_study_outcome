package mh6;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import java.util.List;
import vm2.i;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final boolean c() {
        if (((Boolean) vm2.e.f556054k.getValue(null, vm2.e.f556037a[9])).booleanValue() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static final String d() {
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

    public static final boolean a(Integer r100) {
        return !((List) i.D.getValue(null, i.f556291a[28])).contains(String.valueOf(r100));
    }

    public static final boolean b(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L11:
        return false;
    L9:
        if (r100.intValue() != 63) goto L11;
    L12:
        return true;
    L5:
        if (r100.intValue() == 62) goto L12;
        goto L6
    }
}
