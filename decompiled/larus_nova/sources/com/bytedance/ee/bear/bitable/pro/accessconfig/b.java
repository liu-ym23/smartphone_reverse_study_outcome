package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.os.Build;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableDefaultMemberAdapter f215119a;

    public b(BitableDefaultMemberAdapter r100) {
        this.f215119a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        BitableDefaultMemberAdapter r101 = this.f215119a;
        Intrinsics.checkNotNull(r100);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        int r102 = BitableDefaultMemberAdapter.f215110b;
        r101.getClass();
    L8:
        return true;
    L5:
        if (r101.f215111a != null) goto L8;
        r101.f215111a = r100.startActionMode(new a(r101), 1);
        goto L8
    }
}
