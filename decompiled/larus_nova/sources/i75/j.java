package i75;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.fragment.DrivePreviewFragment;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f488468a = 0;

    public static final class a {
        @JvmStatic
        public static View a(int r100, Fragment r101) {
            View r102 = null;
            if ((r101 instanceof DrivePreviewFragment) == false) goto L9;
            Fragment r103 = ((DrivePreviewFragment) r101).getParentFragment();
            if (r103 == null) goto L9;
            View r104 = r103.getView();
            if (r104 == null) goto L9;
            View r105 = r104.findViewById(r100);
        L10:
            if (r105 != null) goto L20;
            if (r101 == null) goto L13;
            FragmentActivity r106 = r101.getActivity();
        L14:
            if (r106 == null) goto L21;
            FragmentActivity r107 = r101.getActivity();
            if (r107 == null) goto L19;
            r102 = r107.findViewById(r100);
        L19:
            return r102;
        L21:
            return r105;
        L13:
            r106 = null;
            goto L14
        L20:
            return r105;
        L9:
            r105 = null;
            goto L10
        }
    }

    static {
    }
}
