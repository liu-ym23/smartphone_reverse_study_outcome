package com.larus.search.impl.global;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes31.dex */
public final class s implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f367733a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    public s(View r100) {
        this.f367733a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f367733a.removeOnAttachStateChangeListener(this);
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(r100);
        int r102 = 0;
        if (r101 == null) goto L7;
        Insets r103 = r101.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r103 == null) goto L7;
        int r104 = r103.bottom;
    L8:
        WindowInsetsCompat r105 = ViewCompat.getRootWindowInsets(r100);
        if (r105 == null) goto L13;
        Insets r106 = r105.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r106 == null) goto L13;
        r102 = r106.top;
    L13:
        int r107 = r100.getPaddingStart();
        int r108 = r100.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r100.getClass().getSimpleName() + ",source:resetPadding,start:" + r107 + ",top:" + r102 + ",end:" + r108 + ",bottom:" + r104);
        r100.setPaddingRelative(r107, r102, r108, r104);
        return;
    L7:
        r104 = 0;
        goto L8
    }
}
