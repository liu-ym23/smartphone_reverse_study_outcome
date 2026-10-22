package m02;

import com.bytedance.android.live.core.resources.j;
import com.bytedance.android.live.core.resources.k;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static final int a(String r100, com.bytedance.android.live.core.resources.e r101) {
        if (r101 == null) goto L26;
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return -1;
    L10:
        if (r100.equals(r101.getMD5()) == false) goto L12;
        return 0;
    L12:
        j r103 = r101.getH265ResourceModel();
        String r104 = null;
        if (r103 == null) goto L15;
        String r105 = r103.getMd5();
    L17:
        if (r100.equals(r105) == false) goto L19;
        return 1;
    L19:
        k r106 = r101.getH265SuperResourceModel();
        if (r106 == null) goto L23;
        r104 = r106.getMd5();
    L23:
        if (r100.equals(r104) == false) goto L30;
        return 2;
    L30:
        return -1;
    L15:
        r105 = null;
        goto L17
    L7:
        r102 = false;
        goto L8
    L26:
        return -1;
    }
}
