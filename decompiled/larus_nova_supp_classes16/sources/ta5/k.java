package ta5;

import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class k extends sa5.e implements sa5.b {
    public final sa5.c a;

    public static final class a {
    }

    static {
    }

    public k() {
        this(0);
    }

    @Override // sa5.b
    public final void d(sa5.d r2) {
        Intrinsics.checkNotNullParameter(r2, "backListener");
        this.a.d(r2);
    }

    @Override // sa5.b
    public final void e(sa5.d r2) {
        Intrinsics.checkNotNullParameter(r2, "backListener");
        this.a.e(r2);
    }

    public List<Fragment> k() {
        throw null;
    }

    @Override // sa5.e
    public boolean j() {
        sa5.c r0 = this.a;
        int r1 = ((ArrayList) r0.a).size() - 1;
        if (r1 < 0) goto L10;
    L4:
        int r4 = r1 - 1;
        sa5.d r2 = (sa5.d) ListProtector.get(r0.a, r1);
        if (r2.onBackPressed() == true) goto L6;
        if (r4 < 0) goto L10;
        r1 = r4;
        goto L4
    L6:
        tt5.a.h("BaseBackPressDispatcher", "onBackPressed intercept by " + r2.getClass());
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return true;
    L13:
        List<Fragment> r5 = k();
        if (r5 == null) goto L26;
        int r6 = r5.size() - 1;
        if (r6 < 0) goto L26;
    L18:
        int r7 = r6 - 1;
        sa5.d r8 = (Fragment) ListProtector.get(r5, r6);
        if ((r8 instanceof sa5.d) == true) goto L21;
    L23:
        if (r7 < 0) goto L26;
        r6 = r7;
        goto L18
    L21:
        if (r8.onBackPressed() == false) goto L23;
        tt5.a.h("FragmentBackPressDispatcher", "Back press consumed by :" + r8);
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        return true;
    L29:
        return false;
    L26:
        r9 = false;
    L10:
        r3 = false;
        goto L11
    }

    public k(int r2) {
        sa5.c r3 = new sa5.c();
        Intrinsics.checkNotNullParameter(r3, "backPressDelegate");
        this.a = r3;
    }
}
