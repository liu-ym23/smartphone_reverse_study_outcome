package com.bytedance.ee.android.file.picker.lib.v2.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes15.dex */
public abstract class Hilt_FileInfoView extends ConstraintLayout implements GeneratedComponentManagerHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewComponentManager f206146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f206147b;

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final GeneratedComponentManager componentManager() {
        if (this.f206146a != null) goto L6;
        this.f206146a = new ViewComponentManager(this, false);
    L6:
        return this.f206146a;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.f206146a != null) goto L6;
        this.f206146a = new ViewComponentManager(this, false);
    L6:
        return this.f206146a.generatedComponent();
    }

    public Hilt_FileInfoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        if (this.f206147b == true) goto L6;
        this.f206147b = true;
        ((a) generatedComponent()).a((FileInfoView) UnsafeCasts.unsafeCast(this));
        return;
    }
}
