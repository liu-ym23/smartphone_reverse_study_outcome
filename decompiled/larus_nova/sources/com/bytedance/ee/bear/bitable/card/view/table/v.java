package com.bytedance.ee.bear.bitable.card.view.table;

import android.widget.ImageView;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes15.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f208917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecordPageCoverAdapter f208918b;

    public v(ImageView r100, RecordPageCoverAdapter r101) {
        this.f208917a = r100;
        this.f208918b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f208917a.setVisibility(0);     // Catch: Throwable -> L4
        UDLoadingDrawable r100 = new UDLoadingDrawable(this.f208918b.getContext());     // Catch: Throwable -> L4
        r100.setColorSchemeColors(new int[]{UIHelper.getColor(R.color.ud_N400)});     // Catch: Throwable -> L4
        this.f208917a.setImageDrawable(r100);     // Catch: Throwable -> L4
        r100.start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
