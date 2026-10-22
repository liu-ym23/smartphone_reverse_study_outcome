package com.larus.push.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusOpenPushReminderDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f367090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f367091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f367092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f367093d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f367090a;
    }

    public LarusOpenPushReminderDialogBinding(ConstraintLayout r100, AppCompatImageView r101, FrameLayout r102, View r103, View r104, TextView r105, TextView r106, TextView r107) {
        this.f367090a = r100;
        this.f367091b = r102;
        this.f367092c = r103;
        this.f367093d = r104;
    }
}
