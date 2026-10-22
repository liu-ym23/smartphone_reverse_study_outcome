package yu5;

import android.text.TextUtils;
import com.miui.easygo.constant.EasyGoConstant;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static int a(String r100, String r101) {
        int r102 = 0;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L18:
        tt5.a.d("VersionUtils", "version name illegal");
        return 0;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        String r103 = r100.split("-")[0];
        String r104 = r101.split("-")[0];
        String[] r105 = r103.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r106 = r104.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r107 = Math.min(r105.length, r106.length);
        int r108 = 0;
    L8:
        if (r102 >= r107) goto L15;
        r108 = r105[r102].length() - r106[r102].length();
        if (r108 != 0) goto L12;
        r108 = r105[r102].compareTo(r106[r102]);
    L12:
        if (r108 != 0) goto L15;
        r102 = r102 + 1;
    L15:
        if (r108 == 0) goto L17;
        return r108;
    L17:
        return r105.length - r106.length;
    }
}
