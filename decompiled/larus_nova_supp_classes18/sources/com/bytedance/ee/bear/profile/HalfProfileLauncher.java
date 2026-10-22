package com.bytedance.ee.bear.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.lark.dependency.c0;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class HalfProfileLauncher {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/profile/HalfProfileLauncher$EmptyFragment;", "Landroidx/fragment/app/Fragment;", "callback", "Lcom/bytedance/ee/bear/profile/HalfProfileLauncher$EmptyFragment$ActivityResultCallBack;", "<init>", "(Lcom/bytedance/ee/bear/profile/HalfProfileLauncher$EmptyFragment$ActivityResultCallBack;)V", "onActivityResult", "", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "ActivityResultCallBack", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EmptyFragment extends Fragment {
        public final a d;

        public interface a {
            void a(Fragment r1, int r2, int r3, Intent r4);
        }

        public EmptyFragment(n r1) {
            this.d = r1;
        }

        public final void onActivityResult(int r2, int r3, Intent r4) {
            a r0 = this.d;
            if (r0 == null) goto L5;
            r0.a(this, r2, r3, r4);
        L5:
            super.onActivityResult(r2, r3, r4);
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(Fragment r3, UserSession r4, String r5, String r6, String r7, String r8, c0.a r9) {
        Intrinsics.checkNotNullParameter(r3, "sourceFragment");
        Intrinsics.checkNotNullParameter(r4, "session");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Context r1 = r3.getContext();
        if (r1 != null) goto L6;
        tt5.a.d("HalfProfileLauncher", "launchInForseti, context is null!");
        return;
    L6:
        Bundle r2 = new Bundle();
        r2.putString("userId", r5);
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        r2.putString("title", r6);
        r2.putString("content", r7);
        r2.putString("confirmText", r8);
        PassportcConvention.h(r2, r4);
        Fragment r10 = Fragment.instantiate(r1, HalfProfileFragment.class.getName(), r2);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ee.bear.profile.HalfProfileFragment");
        HalfProfileFragment r11 = (HalfProfileFragment) r10;
        r11.k = r9;
        com.suite.lark.component.navroute.forseti.g r12 = com.suite.lark.component.navroute.forseti.f.b(r3);
        if (r12 == null) goto L13;
        r12.h(new com.suite.lark.component.navroute.fragment.c(r11), HalfProfileLauncher$launchInForseti$1.INSTANCE);
        return;
    }

    @JvmStatic
    public static final void a(FragmentActivity r4, FragmentManager r5, UserSession r6, String r7, String r8, String r9, String r10, c0.a r11) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        Intrinsics.checkNotNullParameter(r6, "session");
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (r5.findFragmentByTag("HalfProfileLauncher") == null) goto L7;
        tt5.a.k("HalfProfileLauncher", "is showding now!");
        return;
    L7:
        if (com.bytedance.ee.util.ui.b.a(r4) == true) goto L10;
        tt5.a.k("HalfProfileLauncher", "activity is not active");
        return;
    L10:
        Intent r2 = new Intent(r4, HalfProfileActivity.class);
        r2.putExtra("userId", r7);
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        r2.putExtra("title", r8);
        r2.putExtra("content", r9);
        r2.putExtra("confirmText", r10);
        PassportcConvention.g(r2, r6);
        EmptyFragment r12 = new EmptyFragment(new n(r11, r5));
        FragmentTransaction r13 = r5.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "HalfProfileLauncher", 0) == true) goto L17;
        r13 = r13.add(r12, "HalfProfileLauncher");
    L17:
        r13.commitNowAllowingStateLoss();
        r12.startActivityForResult(r2, 11011);
    }
}
