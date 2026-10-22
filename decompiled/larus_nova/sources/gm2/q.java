package gm2;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: classes11.dex */
public final class q {
    public static String b(IBaseUser r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getNickName();
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L4:
        r101 = null;
        goto L5
    }

    public static String a(IBaseUser r100, boolean r101) {
        if (r100 == null) goto L12;
        gd0.n r102 = (gd0.n) jc1.k.f(gd0.n.class);
        if (r102 != null) goto L6;
    L11:
        String r103 = r100.getProperNickName(r101);
    L13:
        if (r103 != null) goto L16;
        return "";
    L16:
        return r103;
    L6:
        if (r102.isAudienceLinkEngineOn() == false) goto L11;
        r103 = r100.getSafeNicName();
        if (TextUtils.isEmpty(r103) == false) goto L13;
        r103 = r100.getProperNickName(r101);
        goto L13
    L12:
        r103 = null;
        goto L13
    }
}
