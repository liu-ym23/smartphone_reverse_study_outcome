package com.bytedance.ee.bear.imageviewer;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r3 extends a implements sw4.c {
    @Override // sw4.c
    public final com.bytedance.ee.bear.browser.plugin.s g() {
        return (com.bytedance.ee.bear.browser.plugin.s) ((HashMap) this.a).get("Comment#ImageViewerWrapper");
    }

    public r3() {
    }

    @Override // sw4.c
    public final void c(FragmentManager r2, String r3) {
        Fragment r4 = r2.findFragmentByTag(r3);
        if (r4 != null) goto L8;
        WeakReference r5 = (WeakReference) ((HashMap) this.b).remove(r3);
        if (r5 == null) goto L8;
        r4 = (Fragment) r5.get();
    L8:
        if ((r4 instanceof ImageViewerDialogFragment) == true) goto L10;
        return;
    L10:
        if (r4.isAdded() == true) goto L19;
        return;
    L19:
        ((ImageViewerDialogFragment) r4).dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L23;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // sw4.c
    public final void f(FragmentManager r1, String r2) {
        i(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sw4.c
    public final ImageViewerDialogFragment b(Context r3, FragmentManager r4, ImageData r5, String r6, String r7, int r8, String r9) {
        Bundle r0 = new Bundle();
        r0.putSerializable("extra_image", r5);
        r0.putString("extra_token", r7);
        r0.putInt("extra_type", r8);
        r0.putString("extra_from", r9);
        if (com.ss.android.lark.utils.y0.a(r9, "input_comment") == false) goto L5;
        r0.putBoolean("extra_flag_back_press", true);
    L5:
        Fragment r10 = (ImageViewerDialogFragment) Fragment.instantiate(r3, ImageViewerDialogFragment.class.getName(), r0);
        Map<String, WeakReference<Fragment>> r11 = this.b;
        HashMap r12 = (HashMap) r11;
        r12.put(r6, new WeakReference(r10));
        if ((r10 instanceof Fragment) == false) goto L8;
        Fragment r13 = r10;
    L9:
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, r6, r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r13, r14) == false) goto L16;
    L14:
        return r10;
    L16:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        r10.show(r4, r6);
        goto L14
    L8:
        r13 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sw4.c
    public final ImageViewerFragment d(Context r3, FragmentManager r4, com.bytedance.ee.bear.browser.plugin.s r5, ViewGroup r6, ImageData r7, String r8, String r9, int r10, String r11) {
        Bundle r0 = new Bundle();
        if (r7 != 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        FragmentTransaction r12 = j(r4, r5, r1, r8);
        if (r12 == null) goto L18;
        if (r1 == false) goto L12;
        r0.putString("extra_enter_anim_uuid", r7.getImage().getUuid());
        r0.putParcelable("extra_enter_anim_pos", r7.getImage().getPosition());
    L12:
        r0.putSerializable("extra_image", r7);
        r0.putString("extra_token", r9);
        r0.putInt("extra_type", r10);
        r0.putString("extra_from", r11);
        ImageViewerFragment r13 = (ImageViewerFragment) Fragment.instantiate(r3, ImageViewerFragment.class.getName(), r0);
        Map<String, WeakReference<Fragment>> r14 = this.b;
        HashMap r16 = (HashMap) r14;
        r16.put(r8, new WeakReference(r13));
        int r17 = r6.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r8, r17) == true) goto L16;
        r12.add(r17, r13, r8);
    L16:
        r12.commitAllowingStateLoss();
        return r13;
    L18:
        return null;
    L5:
        if (r7.hasValidEnterAnimator() == false) goto L7;
        r1 = true;
        goto L8
    }
}
