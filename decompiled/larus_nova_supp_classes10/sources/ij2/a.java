package ij2;

import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.ec.common.api.jump.model.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {

    /* JADX INFO: renamed from: ij2.a$a, reason: collision with other inner class name */
    public static final class C0143a {
        public static b a(a r2) {
            boolean r0 = r2 instanceof View;
            ViewParent r1 = null;
            Object r3 = r2;
            if (r0 == true) goto L5;
            r3 = null;
        L5:
            View r4 = (View) r3;
            if (r4 == null) goto L8;
            ViewParent r5 = r4.getParent();
        L10:
            if ((r5 instanceof b) == false) goto L14;
            r1 = r5;
        L14:
            return (b) r1;
        L8:
            r5 = null;
            goto L10
        }

        public static boolean b(a r2) {
            boolean r0 = r2 instanceof View;
            ViewParent r1 = null;
            Object r3 = r2;
            if (r0 == true) goto L5;
            r3 = null;
        L5:
            View r4 = (View) r3;
            if (r4 == null) goto L8;
            r1 = r4.getParent();
        L8:
            if (r1 == null) goto L10;
            return true;
        L10:
            return false;
        }
    }

    boolean a();

    void b(e r1);

    String getCurrentContentDescription();

    b getParentContainer();

    String getType();

    void release();
}
