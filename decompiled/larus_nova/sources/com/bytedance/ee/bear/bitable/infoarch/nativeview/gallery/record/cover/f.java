package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.widget.ImageView;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f213499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GalleryCoverAdapter f213500b;

    public f(ImageView r100, GalleryCoverAdapter r101) {
        this.f213499a = r100;
        this.f213500b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f213499a.setVisibility(0);     // Catch: Throwable -> L4
        UDLoadingDrawable r100 = new UDLoadingDrawable(this.f213500b.getContext());     // Catch: Throwable -> L4
        r100.setColorSchemeColors(new int[]{UIHelper.getColor(R.color.ud_N400)});     // Catch: Throwable -> L4
        this.f213499a.setImageDrawable(r100);     // Catch: Throwable -> L4
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
