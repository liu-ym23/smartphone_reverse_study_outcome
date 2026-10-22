package i75;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.fragment.DrivePreviewFragment;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static View a(int r3, Fragment r4) {
            View r1 = null;
            if ((r4 instanceof DrivePreviewFragment) == false) goto L9;
            Fragment r0 = ((DrivePreviewFragment) r4).getParentFragment();
            if (r0 == null) goto L9;
            View r2 = r0.getView();
            if (r2 == null) goto L9;
            View r5 = r2.findViewById(r3);
        L10:
            if (r5 != null) goto L20;
            if (r4 == null) goto L13;
            FragmentActivity r6 = r4.getActivity();
        L14:
            if (r6 == null) goto L21;
            FragmentActivity r7 = r4.getActivity();
            if (r7 == null) goto L19;
            r1 = r7.findViewById(r3);
        L19:
            return r1;
        L21:
            return r5;
        L13:
            r6 = null;
            goto L14
        L20:
            return r5;
        L9:
            r5 = null;
            goto L10
        }
    }

    static {
    }
}
