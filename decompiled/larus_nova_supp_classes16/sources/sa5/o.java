package sa5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface o {
    public static final a q2 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v3, types: [android.view.ViewParent] */
        @JvmStatic
        public static Object a(Class r2, FragmentActivity r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "type");
            if ((r3 instanceof o) == false) goto L5;
            o r5 = (o) r3;
        L6:
            if (r5 != null) goto L21;
            if (r4 == 0) goto L17;
        L10:
            if (r4 == 0) goto L17;
            if ((r4 instanceof View) == false) goto L17;
            View r6 = (View) r4;
            Object r7 = r6.getTag(2131371995);
            if ((r7 instanceof o) == true) goto L15;
            r4 = r6.getParent();
            goto L10
        L15:
            r5 = (o) r7;
        L18:
            if (r5 != null) goto L21;
            r5 = null;
        L17:
            r5 = null;
        L21:
            if (r5 != null) goto L23;
            return null;
        L23:
            return r5.vb(r2);
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
        q2 = a.a;
    }

    void Xi(e r1);

    e vb(Class r1);
}
