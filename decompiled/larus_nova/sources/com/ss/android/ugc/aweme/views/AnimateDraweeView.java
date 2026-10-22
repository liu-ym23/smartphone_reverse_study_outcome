package com.ss.android.ugc.aweme.views;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes40.dex */
public class AnimateDraweeView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f454353a;

    public AnimateDraweeView(Context r100) {
        super(r100);
        this.f454353a = true;
    }

    public final void f(boolean r100) {
        DraweeController r101 = getController();     // Catch: NullPointerException -> L4
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        Animatable r102 = r101.getAnimatable();
        if (r102 != null) goto L11;
        return;
    L11:
        if (r100 == true) goto L13;
    L15:
        r102.stop();
        return;
    L13:
        if (this.f454353a == false) goto L15;
        r102.start();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        boolean r101 = false;
        if (r100 == 0) goto L5;
    L8:
        if (r100 != 0) goto L10;
        r101 = true;
    L10:
        f(r101);
        return;
    L5:
        if (getVisibility() != 0) goto L7;
        r100 = 0;
        goto L8
    L7:
        r100 = 8;
        goto L8
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(@Nullable DraweeController r100) {
        super.setController(r100);
    }

    public void setEnableAnimation(boolean r100) {
        this.f454353a = r100;
    }

    public AnimateDraweeView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f454353a = true;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L5;
        boolean r102 = true;
    L6:
        f(r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public AnimateDraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f454353a = true;
    }
}
