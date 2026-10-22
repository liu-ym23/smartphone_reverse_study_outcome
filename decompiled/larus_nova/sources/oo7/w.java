package oo7;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes22.dex */
public final class w implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f524645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f524646b;

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean r100) {
        k.e("WindowFocusUtils", "onWindowFocusChanged hasFocus = " + r100);
        if (r100 == false) goto L9;
        x r101 = this.f524645a;
        if (r101 == null) goto L7;
        ((com.bytedance.ug.sdk.share.impl.manager.j.b) r101).a();
    L7:
        this.f524646b.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
        return;
    }

    public w(x r100, View r101) {
        this.f524645a = r100;
        this.f524646b = r101;
    }
}
