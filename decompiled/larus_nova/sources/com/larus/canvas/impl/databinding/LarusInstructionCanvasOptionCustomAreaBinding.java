package com.larus.canvas.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusInstructionCanvasOptionCustomAreaBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f323774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f323775b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323774a;
    }

    public static LarusInstructionCanvasOptionCustomAreaBinding a(LayoutInflater r100) {
        View r101 = r100.inflate(R.layout.larus_instruction_canvas_option_custom_area, null, false);
        RecyclerView r102 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.rv_option_list);
        if (r102 == null) goto L7;
        return new LarusInstructionCanvasOptionCustomAreaBinding((ConstraintLayout) r101, r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(R.id.rv_option_list)));
    }

    public LarusInstructionCanvasOptionCustomAreaBinding(ConstraintLayout r100, RecyclerView r101) {
        this.f323774a = r100;
        this.f323775b = r101;
    }
}
