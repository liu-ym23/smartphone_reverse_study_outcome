package ta5;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends sa5.e {
    public final AppCompatActivity a;

    public f(AppCompatActivity r1) {
        this.a = r1;
    }

    @Override // sa5.e
    public final void i(int r5, int r6, Intent r7) {
        List r0 = this.a.getSupportFragmentManager().getFragments();
        if (r0 == null) goto L20;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L32;
        Fragment r2 = (Fragment) r1.next();
        if ((r2 instanceof sa5.a) == false) goto L11;
        r2.onActivityResult(r5, r6, r7);
    L11:
        if ((r2 instanceof e) == true) goto L6;
        List r3 = r2.getChildFragmentManager().getFragments();
        if (r3 == null) goto L6;
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L6;
        Fragment r8 = (Fragment) r4.next();
        if ((r8 instanceof sa5.a) == false) goto L16;
        r8.onActivityResult(r5, r6, r7);
        goto L16
    L32:
        return;
    }
}
