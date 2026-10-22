package com.bytedance.applet.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LarusAppletDebugActivityBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final Button b;
    public final ScrollView c;
    public final RecyclerView d;
    public final SwitchCompat e;
    public final FrameLayout f;
    public final Button g;
    public final Button h;

    public final View getRoot() {
        return this.a;
    }

    public LarusAppletDebugActivityBinding(ConstraintLayout r1, Button r2, ScrollView r3, RecyclerView r4, SwitchCompat r5, FrameLayout r6, Button r7, Button r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
