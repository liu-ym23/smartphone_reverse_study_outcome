package v15;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.util.ui.j;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a {
    public static void a(b r7, FragmentManager r8, Runnable r9) {
        Intrinsics.checkNotNullParameter(r8, "manager");
        Intrinsics.checkNotNullParameter(r9, "show");
        if (r7.D10() == true) goto L6;
        r9.run();
        return;
    L6:
        Iterator r0 = r8.getFragments().iterator();
    L8:
        if (r0.hasNext() == false) goto L17;
        b r1 = (Fragment) r0.next();
        if ((r1 instanceof b) == false) goto L8;
        if (Intrinsics.areEqual(r1, r7) == true) goto L8;
        b r2 = r1;
        long r4 = r2.q30();
        r2.dismissDialog();
        if (Intrinsics.areEqual(r7.getClass(), r1.getClass()) == true) goto L16;
        r1.Yf();
    L16:
        b.s2.getClass();
        tt5.a.h("IndependentDialog", "dismiss " + r1 + ", show " + r7 + ", delayShowTime = " + r4);
    L19:
        if (r4 <= 0) goto L21;
        j.d(new c(r8, r9), r4);
        return;
    L21:
        r9.run();
        return;
    L17:
        r4 = 0;
        goto L19
    }
}
