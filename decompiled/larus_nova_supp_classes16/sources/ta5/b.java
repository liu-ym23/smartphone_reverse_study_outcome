package ta5;

import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import sa5.p;
import sa5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends sa5.e implements p {
    public final List<q> a;
    public final AppCompatActivity b;

    public b(AppCompatActivity r2) {
        this.a = new ArrayList();
        this.b = r2;
    }

    @Override // sa5.p
    public final void a(q r2) {
        if (((ArrayList) this.a).contains(r2) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.a).add(r2);
    }

    @Override // sa5.p
    public final void f(q r2) {
        ((ArrayList) this.a).remove(r2);
    }

    @Override // sa5.e
    public final boolean g(KeyEvent r8) {
        List r0 = this.b.getSupportFragmentManager().getFragments();
        if (r0 == null) goto L12;
        int r4 = r0.size() - 1;
    L5:
        if (r4 < 0) goto L12;
        Fragment r5 = (Fragment) ListProtector.get(r0, r4);
        if ((r5 instanceof q) == false) goto L11;
        if (k(r5, r8) == false) goto L11;
        tt5.a.h("ActivityKeyEventDispatcher", "Key Event consumed by :" + r5);
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        return true;
    L15:
        int r2 = ((ArrayList) this.a).size() - 1;
    L16:
        if (r2 < 0) goto L22;
        if (((q) ListProtector.get(this.a, r2)).dispatchKeyEvent(r8) == true) goto L19;
        r2 = r2 - 1;
        goto L16
    L19:
        tt5.a.h("ActivityKeyEventDispatcher", "KeyEvent intercept.");
        return true;
    L22:
        return false;
    L11:
        r4 = r4 - 1;
    L12:
        r1 = false;
        goto L13
    }

    public static boolean k(Fragment r5, KeyEvent r6) {
        if (r5.isAdded() == true) goto L6;
        return false;
    L6:
        List r0 = r5.getChildFragmentManager().getFragments();
        int r1 = r0.size() - 1;
    L7:
        if (r1 < 0) goto L16;
        Fragment r3 = (Fragment) ListProtector.get(r0, r1);
        if ((r3 instanceof q) == false) goto L14;
        if (k(r3, r6) == false) goto L14;
        tt5.a.h("ActivityKeyEventDispatcher", "Key Event consumed by :" + r3);
        return true;
    L14:
        r1 = r1 - 1;
        goto L7
    L16:
        return ((q) r5).dispatchKeyEvent(r6);
    }
}
