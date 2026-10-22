package com.bytedance.awemeopen.apps.framework.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static boolean a(Fragment r6) {
            List r0 = r6.getChildFragmentManager().getFragments();
            n44.a r2 = null;
            if (r0.size() <= 0) goto L22;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L29;
            Fragment r3 = (Fragment) r1.next();
            if (r3 == null) goto L6;
            int r5 = d.a;
            if (a(r3) == true) goto L11;
            if ((r6 instanceof AosBaseFragment) == false) goto L15;
            AosBaseFragment r4 = (AosBaseFragment) r6;
        L16:
            if (r4 == null) goto L18;
            boolean r7 = Intrinsics.areEqual(r4.onBackPressed(), Boolean.TRUE);
        L19:
            if (r7 == false) goto L6;
            return true;
        L18:
            r7 = false;
            goto L19
        L15:
            r4 = null;
            goto L16
        L11:
            return true;
        L29:
            return false;
        L22:
            if ((r6 instanceof n44.a) == false) goto L24;
            r2 = (n44.a) r6;
        L24:
            if (r2 == null) goto L26;
            boolean r8 = Intrinsics.areEqual(r2.onBackPressed(), Boolean.TRUE);
        L27:
            if (r8 == false) goto L29;
            return true;
        L26:
            r8 = false;
            goto L27
        }

        public static boolean b(FragmentActivity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            Iterator r5 = r4.getSupportFragmentManager().getFragments().iterator();
        L3:
            boolean r1 = false;
            if (r5.hasNext() == false) goto L18;
            Fragment r0 = (Fragment) r5.next();
            if (r0 == null) goto L3;
            int r2 = d.a;
            if (a(r0) == true) goto L9;
            if ((r0 instanceof AosBaseFragment) == false) goto L13;
            AosBaseFragment r3 = (AosBaseFragment) r0;
        L14:
            if (r3 == null) goto L16;
            r1 = Intrinsics.areEqual(r3.onBackPressed(), Boolean.TRUE);
        L16:
            if (r1 == false) goto L3;
            return true;
        L13:
            r3 = null;
            goto L14
        L9:
            return true;
        L18:
            return false;
        }

        public static void c(FragmentManager r1, int r2, Fragment r3, String r4) {
            Intrinsics.checkNotNullParameter(r1, "fragmentManager");
            Intrinsics.checkNotNullParameter(r3, "fragment");
            Intrinsics.checkNotNullParameter(r4, "tag");
            FragmentTransaction r5 = r1.beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == true) goto L6;
            r5 = r5.replace(r2, r3, r4);
        L6:
            r5.commitAllowingStateLoss();
        }
    }

    static {
    }
}
