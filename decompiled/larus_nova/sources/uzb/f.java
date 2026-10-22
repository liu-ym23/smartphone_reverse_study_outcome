package uzb;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: classes37.dex */
public final class f {
    public static void a(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r101 = r100.findViewById(R.id.content);
        if (r101 == null) goto L10;
        InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");
        if (r102.isActive() == false) goto L11;
        r102.hideSoftInputFromWindow(r101.getWindowToken(), 0);
        return;
    L11:
        return;
    }

    public static void b(Context r100) {
        Activity r101 = ViewUtils.getActivityByContext(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        a(Contexts.requireActivity(r101));
    }

    public static boolean c(Context r100) {
        Activity r101 = ViewUtils.getActivityByContext(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        return d.f552245b.b(r101);
    L11:
        return e.f552246a.b(r101);
    }
}
