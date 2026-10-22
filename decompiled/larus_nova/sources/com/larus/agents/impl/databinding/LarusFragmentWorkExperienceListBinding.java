package com.larus.agents.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusFragmentWorkExperienceListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f286646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f286647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemTextToggle f286648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f286649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f286650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NovaTitleBarEx f286651f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f286646a;
    }

    public LarusFragmentWorkExperienceListBinding(LinearLayout r100, TextView r101, ItemTextToggle r102, RecyclerView r103, ProgressBar r104, NovaTitleBarEx r105) {
        this.f286646a = r100;
        this.f286647b = r101;
        this.f286648c = r102;
        this.f286649d = r103;
        this.f286650e = r104;
        this.f286651f = r105;
    }
}
