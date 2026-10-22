package com.larus.uaigc.music.template;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes31.dex */
public final class o implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f373805a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    public o(ConstraintLayout r100) {
        this.f373805a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f373805a.removeOnAttachStateChangeListener(this);
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(r100);
        if (r101 == null) goto L7;
        Insets r102 = r101.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r102 == null) goto L7;
        int r103 = r102.bottom;
    L8:
        int r104 = r100.getPaddingStart();
        int r105 = r100.getPaddingTop();
        int r106 = r100.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r100.getClass().getSimpleName() + ",source:resetPadding,start:" + r104 + ",top:" + r105 + ",end:" + r106 + ",bottom:" + r103);
        r100.setPaddingRelative(r104, r105, r106, r103);
        return;
    L7:
        r103 = 0;
        goto L8
    }
}
