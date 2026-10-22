package yo5;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.i0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
    L15:
        return false;
    L13:
        if (r4.isInMultiWindowMode() == false) goto L15;
        return true;
    L8:
        if (i0.b() == false) goto L10;
        r1 = true;
        goto L11
    L5:
        r0 = false;
        goto L6
    }
}
