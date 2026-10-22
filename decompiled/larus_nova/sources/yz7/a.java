package yz7;

import android.os.Build;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f569549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f569550b = false;

    static {
        f569549a = true;
        boolean r100 = false;
        boolean r101 = RomUtils.f285919b[0].equals(RomUtils.e().f285940a);
        if (r101 == false) goto L5;
        Log.i("GlobalFontFgUtil", "vivo font hook close");
    L5:
        if (r101 == false) goto L12;
        StringBuilder r102 = new StringBuilder("sdk version is ");
        int r103 = Build.VERSION.SDK_INT;
        r102.append(r103);
        Log.i("GlobalFontFgUtil", r102.toString());
        if (r103 >= 34) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        r100 = true;
        goto L12
    L9:
        r104 = false;
    L12:
        Log.i("GlobalFontFgUtil", "global font Android 14 close " + r100);
        f569550b = true ^ r100;
    }
}
