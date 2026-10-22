package sa5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface o {

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final a f541176q2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f541177a = null;

        static {
            f541177a = new a();
        }

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [androidx.fragment.app.FragmentActivity] */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v3, types: [android.view.ViewParent] */
        @JvmStatic
        public static Object a(Class r100, FragmentActivity r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            if ((r101 instanceof o) == false) goto L5;
            o r103 = (o) r101;
        L6:
            if (r103 != null) goto L21;
            if (r102 == 0) goto L17;
        L10:
            if (r102 == 0) goto L17;
            if ((r102 instanceof View) == false) goto L17;
            View r104 = (View) r102;
            Object r105 = r104.getTag(R.id.extension_host);
            if ((r105 instanceof o) == true) goto L15;
            r102 = r104.getParent();
            goto L10
        L15:
            r103 = (o) r105;
        L18:
            if (r103 != null) goto L21;
            r103 = null;
        L17:
            r103 = null;
        L21:
            if (r103 != null) goto L23;
            return null;
        L23:
            return r103.vb(r100);
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        f541176q2 = a.f541177a;
    }

    void Xi(e r100);

    e vb(Class r100);
}
