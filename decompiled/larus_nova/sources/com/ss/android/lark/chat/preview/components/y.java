package com.ss.android.lark.chat.preview.components;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class y implements View.OnAttachStateChangeListener {
    public y() {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        CircularProgressDrawable r101 = null;
        if ((r100 instanceof ImageView) == false) goto L5;
        ImageView r102 = (ImageView) r100;
    L6:
        if (r102 == null) goto L8;
        Drawable r103 = r102.getDrawable();
    L10:
        if ((r103 instanceof CircularProgressDrawable) == false) goto L12;
        r101 = (CircularProgressDrawable) r103;
    L12:
        if (r101 != null) goto L15;
        return;
    L15:
        if (r101.isRunning() == true) goto L18;
        r101.start();
        return;
    L18:
        return;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        CircularProgressDrawable r101 = null;
        if ((r100 instanceof ImageView) == false) goto L5;
        ImageView r102 = (ImageView) r100;
    L6:
        if (r102 == null) goto L8;
        Drawable r103 = r102.getDrawable();
    L10:
        if ((r103 instanceof CircularProgressDrawable) == false) goto L12;
        r101 = (CircularProgressDrawable) r103;
    L12:
        if (r101 == null) goto L15;
        r101.stop();
        return;
    L15:
        return;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
