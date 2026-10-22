package ij2;

import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.ec.common.api.jump.model.e;

/* JADX INFO: loaded from: classes10.dex */
public interface a {

    /* JADX INFO: renamed from: ij2.a$a, reason: collision with other inner class name */
    public static final class C6273a {
        public static b a(a r100) {
            boolean r101 = r100 instanceof View;
            ViewParent r102 = null;
            Object r103 = r100;
            if (r101 == true) goto L5;
            r103 = null;
        L5:
            View r104 = (View) r103;
            if (r104 == null) goto L8;
            ViewParent r105 = r104.getParent();
        L10:
            if ((r105 instanceof b) == false) goto L14;
            r102 = r105;
        L14:
            return (b) r102;
        L8:
            r105 = null;
            goto L10
        }

        public static boolean b(a r100) {
            boolean r101 = r100 instanceof View;
            ViewParent r102 = null;
            Object r103 = r100;
            if (r101 == true) goto L5;
            r103 = null;
        L5:
            View r104 = (View) r103;
            if (r104 == null) goto L8;
            r102 = r104.getParent();
        L8:
            if (r102 == null) goto L10;
            return true;
        L10:
            return false;
        }
    }

    boolean a();

    void b(e r100);

    String getCurrentContentDescription();

    b getParentContainer();

    String getType();

    void release();
}
