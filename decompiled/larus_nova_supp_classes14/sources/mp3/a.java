package mp3;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Fade;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(ViewGroup r4, List r5) {
        int r0 = r4.getChildCount();
        ArrayList r1 = new ArrayList();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1.add(r4.getChildAt(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator r6 = r1.iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        View r3 = (View) r6.next();
        if (r3.getId() == (-1)) goto L12;
        ArrayList r7 = (ArrayList) r5;
        r7.add(Integer.valueOf(r3.getId()));
    L12:
        if ((r3 instanceof ViewGroup) == false) goto L7;
        a((ViewGroup) r3, r5);
        goto L7
    }

    public static Transition b(Fade r1, Set r2) {
        if (r2.isEmpty() == false) goto L6;
        return null;
    L6:
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r1.addTarget(((Number) r3.next()).intValue());
        goto L8
    L10:
        return r1;
    }
}
