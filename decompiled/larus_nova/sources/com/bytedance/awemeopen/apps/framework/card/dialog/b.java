package com.bytedance.awemeopen.apps.framework.card.dialog;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.utils.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f193825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AosHostCardBottomPanelDialog f193826b;

    public b(View r100, AosHostCardBottomPanelDialog r101) {
        this.f193825a = r100;
        this.f193826b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (y.a(this.f193825a) == false) goto L5;
        return;
    L5:
        AosHostCardBottomPanelDialog r101 = this.f193826b;
        int r102 = AosHostCardBottomPanelDialog.f193818j;
        r101.getClass();
        this.f193826b.f193823i.b();
        this.f193826b.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        throw null;
    }
}
