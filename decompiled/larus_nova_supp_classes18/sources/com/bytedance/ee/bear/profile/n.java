package com.bytedance.ee.bear.profile;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.lark.dependency.c0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements HalfProfileLauncher.EmptyFragment.a {
    public final /* synthetic */ c0.a a;
    public final /* synthetic */ FragmentManager b;

    public n(c0.a r1, FragmentManager r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.profile.HalfProfileLauncher.EmptyFragment.a
    public final void a(Fragment r2, int r3, int r4, Intent r5) {
        Intrinsics.checkNotNullParameter(r2, "fragmentToRemove");
        if (11011 == r3) goto L5;
        return;
    L5:
        if (r4 != (-1)) goto L13;
        boolean r6 = false;
        if (r5 != null) goto L9;
    L11:
        if (r6 == false) goto L13;
        this.a.onConfirm();
    L14:
        this.b.beginTransaction().remove(r2).commitNowAllowingStateLoss();
        return;
    L9:
        if (r5.getBooleanExtra("is_confirm", false) != true) goto L11;
        r6 = true;
    L13:
        this.a.onCancel();
        goto L14
    }
}
