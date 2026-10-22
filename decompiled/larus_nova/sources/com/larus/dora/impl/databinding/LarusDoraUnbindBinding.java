package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraUnbindBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f333304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraTextView f333305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f333306d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333303a;
    }

    public LarusDoraUnbindBinding(ConstraintLayout r100, View r101, DoraTextView r102, NovaTitleBarEx r103) {
        this.f333303a = r100;
        this.f333304b = r101;
        this.f333305c = r102;
        this.f333306d = r103;
    }
}
