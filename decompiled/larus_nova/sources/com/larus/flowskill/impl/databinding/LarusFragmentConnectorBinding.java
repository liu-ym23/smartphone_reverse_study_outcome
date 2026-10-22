package com.larus.flowskill.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusFragmentConnectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f343512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusItemConnectorBinding f343513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f343514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusLayoutBottomSheetHeaderBinding f343515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f343516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f343517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LarusLayoutTaskSkillStateBinding f343518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RecyclerView f343519h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343512a;
    }

    public LarusFragmentConnectorBinding(ConstraintLayout r100, LarusItemConnectorBinding r101, LinearLayout r102, LarusLayoutBottomSheetHeaderBinding r103, FrameLayout r104, ConstraintLayout r105, LarusLayoutTaskSkillStateBinding r106, RecyclerView r107) {
        this.f343512a = r100;
        this.f343513b = r101;
        this.f343514c = r102;
        this.f343515d = r103;
        this.f343516e = r104;
        this.f343517f = r105;
        this.f343518g = r106;
        this.f343519h = r107;
    }
}
