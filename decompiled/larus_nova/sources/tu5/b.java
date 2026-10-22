package tu5;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static int a(String r100, String r101) {
    L36:
        return -2;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return -2;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return -1;
    L10:
        if (TextUtils.equals(r100, r101) == false) goto L12;
        return 0;
    L12:
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L36
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L36
        int r104 = Math.min(r102.length, r103.length);     // Catch: Exception -> L36
        int r105 = 0;
        int r106 = 0;
    L13:
        if (r105 >= r104) goto L18;
        r106 = CastIntegerProtector.parseInt(r102[r105]) - CastIntegerProtector.parseInt(r103[r105]);     // Catch: Exception -> L36
        if (r106 != 0) goto L18;
        r105 = r105 + 1;     // Catch: Exception -> L36
    L18:
        if (r106 != 0) goto L33;
        int r107 = r105;
    L21:
        if (r107 >= r102.length) goto L26;
        if (CastIntegerProtector.parseInt(r102[r107]) > 0) goto L24;
        r107 = r107 + 1;     // Catch: Exception -> L36
        goto L21
    L24:
        return 1;
    L26:
        if (r105 >= r103.length) goto L32;
        if (CastIntegerProtector.parseInt(r103[r105]) > 0) goto L30;
        r105 = r105 + 1;
        goto L26
    L30:
        return -1;
    L32:
        return 0;
    L33:
        if (r106 <= 0) goto L45;
        return 1;
    L45:
        return -1;
    }
}
