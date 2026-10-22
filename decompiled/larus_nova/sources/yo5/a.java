package yo5;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.i0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
    L15:
        return false;
    L13:
        if (r100.isInMultiWindowMode() == false) goto L15;
        return true;
    L8:
        if (i0.b() == false) goto L10;
        r102 = true;
        goto L11
    L5:
        r101 = false;
        goto L6
    }
}
