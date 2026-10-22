package rk3;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.container.TabKitActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface c {

    public static final class a {
        public static TabKitFragment a(c r3) {
            boolean r0 = r3 instanceof View;
            Fragment r1 = null;
            Object r4 = r3;
            if (r0 == true) goto L5;
            r4 = null;
        L5:
            View r5 = (View) r4;
            if (r5 == null) goto L8;
            FragmentActivity r6 = r5.getContext();
        L10:
            if ((r6 instanceof TabKitActivity) == false) goto L18;
            Fragment r7 = ((TabKitActivity) r6).getSupportFragmentManager().findFragmentByTag("tabkit_fragment");
            if ((r7 instanceof TabKitFragment) == false) goto L16;
            r1 = r7;
        L16:
            return (TabKitFragment) r1;
        L18:
            if ((r6 instanceof FragmentActivity) == true) goto L20;
            r6 = null;
        L20:
            FragmentActivity r8 = r6;
            if (r8 == null) goto L29;
            FragmentManager r9 = r8.getSupportFragmentManager();
            if (r9 == null) goto L29;
            Fragment r10 = r9.findFragmentByTag("tabkit_bottom_sheet_fragment");
            if (r10 == null) goto L29;
            FragmentManager r11 = r10.getChildFragmentManager();
            if (r11 == null) goto L29;
            Fragment r12 = r11.findFragmentByTag("tabkit_fragment");
        L31:
            if ((r12 instanceof TabKitFragment) == false) goto L35;
            r1 = r12;
        L35:
            return (TabKitFragment) r1;
        L29:
            r12 = null;
            goto L31
        L8:
            r6 = null;
            goto L10
        }
    }

    TabKitFragment getTabkitFragment();
}
