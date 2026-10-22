package com.ss.android.lark.inline.ai.ui.selector;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f427665a;

    public a(FragmentActivity r100) {
        this.f427665a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f427665a.setResult(0);
        this.f427665a.finish();
    }
}
