package ta5;

import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class k extends sa5.e implements sa5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sa5.c f545185a;

    public static final class a {
    }

    static {
    }

    public k() {
        this(0);
    }

    @Override // sa5.b
    public final void d(sa5.d r100) {
        Intrinsics.checkNotNullParameter(r100, "backListener");
        this.f545185a.d(r100);
    }

    @Override // sa5.b
    public final void e(sa5.d r100) {
        Intrinsics.checkNotNullParameter(r100, "backListener");
        this.f545185a.e(r100);
    }

    public List<Fragment> k() {
        throw null;
    }

    @Override // sa5.e
    public boolean j() {
        sa5.c r100 = this.f545185a;
        int r101 = ((ArrayList) r100.f541166a).size() - 1;
        if (r101 < 0) goto L10;
    L4:
        int r102 = r101 - 1;
        sa5.d r103 = (sa5.d) ListProtector.get(r100.f541166a, r101);
        if (r103.onBackPressed() == true) goto L6;
        if (r102 < 0) goto L10;
        r101 = r102;
        goto L4
    L6:
        tt5.a.h("BaseBackPressDispatcher", "onBackPressed intercept by " + r103.getClass());
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        return true;
    L13:
        List<Fragment> r105 = k();
        if (r105 == null) goto L26;
        int r106 = r105.size() - 1;
        if (r106 < 0) goto L26;
    L18:
        int r107 = r106 - 1;
        Object r108 = (Fragment) ListProtector.get(r105, r106);
        if ((r108 instanceof sa5.d) == true) goto L21;
    L23:
        if (r107 < 0) goto L26;
        r106 = r107;
        goto L18
    L21:
        if (((sa5.d) r108).onBackPressed() == false) goto L23;
        tt5.a.h("FragmentBackPressDispatcher", "Back press consumed by :" + r108);
        boolean r109 = true;
    L27:
        if (r109 == false) goto L29;
        return true;
    L29:
        return false;
    L26:
        r109 = false;
    L10:
        r104 = false;
        goto L11
    }

    public k(int r100) {
        sa5.c r101 = new sa5.c();
        Intrinsics.checkNotNullParameter(r101, "backPressDelegate");
        this.f545185a = r101;
    }
}
