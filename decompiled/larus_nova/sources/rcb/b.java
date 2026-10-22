package rcb;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.i0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Configuration r101 = r100.getResources().getConfiguration();
        StringBuilder r102 = new StringBuilder(" hardKeyboardHidden=");
        Integer r103 = null;
        if (r101 == null) goto L8;
        Integer r104 = Integer.valueOf(r101.hardKeyboardHidden);
    L9:
        r102.append(r104);
        r102.append(" keyboard=");
        if (r101 == null) goto L12;
        r103 = Integer.valueOf(r101.keyboard);
    L12:
        r102.append(r103);
        Log.i("HardKeyboardUtils", r102.toString());
        if (r101 != null) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L25;
        int r106 = r101.keyboard;
        if (r106 != 2) goto L22;
    L23:
        return true;
    L22:
        if (r106 == 3) goto L23;
        return false;
    L25:
        return false;
    L15:
        if (r101.hardKeyboardHidden != 1) goto L17;
        r105 = true;
        goto L18
    L8:
        r104 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean b(FragmentActivity r100) {
        if (r100 == null) goto L28;
        int r101 = a.f537196a;
        int r102 = Build.VERSION.SDK_INT;
        boolean r103 = true;
        if (r102 < 30) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L10;
    L12:
        boolean r105 = false;
    L14:
        if (r100.getResources().getConfiguration().orientation != 2) goto L21;
        if (r105 == true) goto L17;
    L19:
        r105 = false;
        goto L21
    L17:
        if (com.ss.android.lark.base.embedded.b.b(r100) == false) goto L19;
        r105 = true;
    L21:
        if (r102 >= 24) goto L24;
        r103 = false;
    L24:
        if (r103 == false) goto L29;
        if (r105 == false) goto L27;
        return false;
    L27:
        return r100.isInMultiWindowMode();
    L29:
        return false;
    L10:
        if (i0.b() == false) goto L12;
        r105 = true;
        goto L14
    L7:
        r104 = false;
        goto L8
    L28:
        return false;
    }
}
