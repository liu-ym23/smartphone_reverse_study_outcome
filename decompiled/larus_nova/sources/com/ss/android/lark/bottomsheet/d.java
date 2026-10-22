package com.ss.android.lark.bottomsheet;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetContainerActivity f410701a;

    public d(BottomSheetContainerActivity r100) {
        this.f410701a = r100;
        super(500);
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        this.f410701a.onBackPressed();
    }
}
