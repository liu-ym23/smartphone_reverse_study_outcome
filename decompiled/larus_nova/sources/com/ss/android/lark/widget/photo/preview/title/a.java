package com.ss.android.lark.widget.photo.preview.title;

import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f447119a;

    public a(b r100) {
        this.f447119a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        PhotoPagerViewModel r101 = this.f447119a.f447124e;
        PhotoPagerViewModel r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r101 = null;
    L5:
        PhotoPagerViewModel r103 = this.f447119a.f447124e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r103 = null;
    L8:
        r101.removeItem(r103.getCurrentIndex());
        PhotoPagerViewModel r104 = this.f447119a.f447124e;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L13:
        if (r102.isEmpty() == false) goto L16;
        ((FrameLayout) this.f447119a.f447125f.getValue()).setVisibility(8);
        return;
    L16:
        return;
    L11:
        r102 = r104;
        goto L13
    }
}
