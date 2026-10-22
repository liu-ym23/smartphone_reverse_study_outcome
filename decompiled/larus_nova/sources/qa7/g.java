package qa7;

import android.R;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes19.dex */
public final class g {
    public static Drawable b(Context r100) {
        if ((r100 instanceof Activity) == true) goto L13;
        TypedValue r101 = new TypedValue();
        r100.getTheme().resolveAttribute(R.attr.windowBackground, r101, true);
        int r102 = r101.type;
        if (r102 < 28) goto L11;
        if (r102 > 31) goto L11;
        return new ColorDrawable(r101.data);
    L11:
        return r100.getResources().getDrawable(r101.resourceId);
    L13:
        throw new IllegalArgumentException("Use Scene Context instead");
    }

    public static boolean c(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isFinishing() == false) goto L9;
        return false;
    L9:
        if (r100.isDestroyed() == false) goto L11;
        return false;
    L11:
        return true;
    }

    public static void d(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r101);
    }

    public static void a(FragmentManager r100, FragmentTransaction r101, boolean r102) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        if (r102 == false) goto L6;
        r101.commitNowAllowingStateLoss();
        return;
    L6:
        r101.commitAllowingStateLoss();
        return;
    L7:
        r101.commitAllowingStateLoss();
        if (r102 == false) goto L13;
        r100.executePendingTransactions();
        return;
    }
}
