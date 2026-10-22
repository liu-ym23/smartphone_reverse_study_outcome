package com.larus.flowskill.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusFragmentFolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f343520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusLayoutBottomSheetHeaderBinding f343521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusLayoutTaskSkillStateBinding f343522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f343523d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343520a;
    }

    public LarusFragmentFolderBinding(ConstraintLayout r100, LarusLayoutBottomSheetHeaderBinding r101, LarusLayoutTaskSkillStateBinding r102, RecyclerView r103) {
        this.f343520a = r100;
        this.f343521b = r101;
        this.f343522c = r102;
        this.f343523d = r103;
    }
}
