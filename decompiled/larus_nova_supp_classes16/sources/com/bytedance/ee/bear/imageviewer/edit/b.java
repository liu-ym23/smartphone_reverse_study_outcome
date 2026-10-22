package com.bytedance.ee.bear.imageviewer.edit;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.imageviewer.s3;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.vfs.VFSPath;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends com.bytedance.ee.bear.imageviewer.a implements sw4.b {
    public s3 c;

    public b() {
    }

    @Override // sw4.b
    public final void a(FragmentManager r2) {
        i(r2, "EditImagePlugin");
    }

    @Override // sw4.b
    public final EditImageFragment h(Context r3, FragmentManager r4, s r5, ViewGroup r6) {
        boolean r0 = true;
        FragmentTransaction r7 = j(r4, r5, true, "EditImagePlugin");
        if (r7 == null) goto L11;
        if (r6 == null) goto L11;
        Bundle r8 = new Bundle();
        EditImageFragment r9 = (EditImageFragment) Fragment.instantiate(r3, EditImageFragment.class.getName(), r8);
        Map<String, WeakReference<Fragment>> r10 = this.b;
        HashMap r11 = (HashMap) r10;
        r11.put("EditImagePlugin", new WeakReference(r9));
        int r12 = r6.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "EditImagePlugin", r12) == true) goto L9;
        r7.add(r12, r9, "EditImagePlugin");
    L9:
        r7.commitAllowingStateLoss();
        return r9;
    L11:
        StringBuilder r13 = new StringBuilder("showEditImageFragment transaction null: ");
        if (r7 != null) goto L14;
        boolean r14 = true;
    L15:
        r13.append(r14);
        r13.append("; rootView null: ");
        if (r6 == null) goto L19;
        r0 = false;
    L19:
        r13.append(r0);
        tt5.a.d("EditImageManager", r13.toString());
        return null;
    L14:
        r14 = false;
        goto L15
    }

    @Override // sw4.b
    public final String e(FragmentActivity r2, String r3, String r4, int r5, ImageData.Image r6) {
        if (this.c != null) goto L5;
        this.c = new s3();
    L5:
        this.c.getClass();
        VFSPath r7 = s3.a(Glide.with(r2), r3, r4, r5, r6);
        if (r7 != null) goto L10;
        return "";
    L10:
        return r7.getAbsolutePath();
    }
}
