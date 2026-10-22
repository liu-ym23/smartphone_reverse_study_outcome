package com.larus.flowskill.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusFragmentTaskSkillPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f343544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusLayoutBottomSheetHeaderBinding f343545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f343546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f343547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LarusLayoutTaskSkillStateBinding f343548e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343544a;
    }

    public LarusFragmentTaskSkillPanelBinding(LinearLayout r100, LarusLayoutBottomSheetHeaderBinding r101, ProgressBar r102, RecyclerView r103, LarusLayoutTaskSkillStateBinding r104) {
        this.f343544a = r100;
        this.f343545b = r101;
        this.f343546c = r102;
        this.f343547d = r103;
        this.f343548e = r104;
    }
}
