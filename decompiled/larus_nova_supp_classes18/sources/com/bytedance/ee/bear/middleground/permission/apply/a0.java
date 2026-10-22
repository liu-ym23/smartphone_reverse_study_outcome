package com.bytedance.ee.bear.middleground.permission.apply;

import android.R;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestLinkPasswordDialog;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestLinkPasswordFragment;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 implements c0 {
    public a0() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final j1 c() {
        return new j1(0);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a b(NoPermission r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        int r1 = AuditControlApplyFragment.p;
        Intrinsics.checkNotNullParameter(r4, "params");
        AuditControlApplyFragment r0 = new AuditControlApplyFragment();
        Bundle r2 = new Bundle();
        r2.putSerializable("Params", r4);
        r0.setArguments(r2);
        return r0;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a d(NoPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return f(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a f(NoPermission r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        int r1 = PermApplyFragment.q;
        Intrinsics.checkNotNullParameter(r4, "params");
        PermApplyFragment r0 = new PermApplyFragment();
        Bundle r2 = new Bundle();
        r2.putSerializable("Params", r4);
        r0.setArguments(r2);
        return r0;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final DialogFragment a(FragmentActivity r4, int r5, String r6, boolean r7, Runnable r8) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        int r0 = RequestLinkPasswordDialog.n;
        DialogFragment r1 = r4.getSupportFragmentManager().findFragmentByTag(RequestLinkPasswordDialog.class.getName());
        if (r1 != null) goto L5;
    L7:
        Bundle r2 = new Bundle();
        r2.putInt(ResourceData.KEY_TYPE, r5);
        r2.putString(ResourceData.KEY_OBJ_TOKEN, r6);
        r2.putBoolean("is_share_folder_v2", r7);
        RequestLinkPasswordDialog r3 = Fragment.instantiate(r4, RequestLinkPasswordDialog.class.getName(), r2);
        r3.j = r8;
        if (com.bytedance.ee.util.ui.b.a(r4) == false) goto L14;
        FragmentManager r9 = r4.getSupportFragmentManager();
        String r10 = RequestLinkPasswordDialog.class.getName();
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, r10, r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r3, r11) == true) goto L21;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        r3.show(r9, r10);
        return r3;
    L21:
        return r3;
    L14:
        tt5.a.e("RequestLinkPasswordDialog", "show when activity not active", new IllegalStateException(), false);
        return r3;
    L5:
        if (r1.isVisible() == false) goto L7;
        tt5.a.d("RequestLinkPasswordDialog", "show fragment when fragment is visible");
        return r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final BaseFragment e(FragmentManager r3, String r4, int r5, int r6, boolean r7, Runnable r8) {
        Intrinsics.checkNotNullParameter(r3, "fm");
        int r0 = RequestLinkPasswordFragment.k;
        BaseFragment r1 = r3.findFragmentByTag(RequestLinkPasswordFragment.class.getName());
        if (r1 != null) goto L5;
    L7:
        Bundle r2 = new Bundle();
        r2.putInt(ResourceData.KEY_TYPE, r5);
        r2.putString(ResourceData.KEY_OBJ_TOKEN, r4);
        r2.putBoolean("extraShowBack", r7);
        RequestLinkPasswordFragment r9 = Fragment.instantiate(eu5.b.a, RequestLinkPasswordFragment.class.getName(), r2);
        r9.h = r8;
        if (r6 != (-1)) goto L11;
        r6 = R.id.content;
    L11:
        FragmentTransaction r10 = r3.beginTransaction();
        String r11 = RequestLinkPasswordFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r11, r6) == true) goto L15;
        r10 = r10.add(r6, r9, r11);
    L15:
        r10.commitAllowingStateLoss();
        return r9;
    L5:
        if (r1.isVisible() == false) goto L7;
        tt5.a.d("RequestLinkPasswordFragment", "add fragment when fragment is visible");
        return r1;
    }
}
