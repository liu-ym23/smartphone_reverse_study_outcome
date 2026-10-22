package iz;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    public static final String a(IBaseUser r100) {
        if (r100 == null) goto L13;
        String r101 = r100.getIdString();
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return null;
    L11:
        if ((!Intrinsics.areEqual(r101, "0")) == false) goto L17;
        return r101;
    L17:
        return null;
    L8:
        r102 = false;
        goto L9
    L13:
        return null;
    }
}
