package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageRecordMinutesBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f333234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemTextToggle f333235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f333236d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333233a;
    }

    public LarusDoraPageRecordMinutesBinding(ConstraintLayout r100, View r101, ItemTextToggle r102, NovaTitleBarEx r103) {
        this.f333233a = r100;
        this.f333234b = r101;
        this.f333235c = r102;
        this.f333236d = r103;
    }
}
