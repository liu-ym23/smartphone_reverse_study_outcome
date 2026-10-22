package com.larus.flowskill.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusFragmentPcDevicePanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f343532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusLayoutBottomSheetHeaderBinding f343533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f343534c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343532a;
    }

    public LarusFragmentPcDevicePanelBinding(LinearLayout r100, LarusLayoutBottomSheetHeaderBinding r101, RecyclerView r102) {
        this.f343532a = r100;
        this.f343533b = r101;
        this.f343534c = r102;
    }
}
