package kx0;

import android.view.View;
import com.bytedance.android.live.recharge.view.FastPayView;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FastPayView f506529a;

    public b(FastPayView r100) {
        this.f506529a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FastPayView.a(this.f506529a);
    }
}
