package mp3;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Fade;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514708a = 0;

    static {
    }

    public static void a(ViewGroup r100, List r101) {
        int r102 = r100.getChildCount();
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103.add(r100.getChildAt(r104));
        r104 = r104 + 1;
        goto L3
    L5:
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L14;
        View r106 = (View) r105.next();
        if (r106.getId() == (-1)) goto L12;
        ArrayList r107 = (ArrayList) r101;
        r107.add(Integer.valueOf(r106.getId()));
    L12:
        if ((r106 instanceof ViewGroup) == false) goto L7;
        a((ViewGroup) r106, r101);
        goto L7
    }

    public static Transition b(Fade r100, Set r101) {
        if (r101.isEmpty() == false) goto L6;
        return null;
    L6:
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r100.addTarget(((Number) r102.next()).intValue());
        goto L8
    L10:
        return r100;
    }
}
