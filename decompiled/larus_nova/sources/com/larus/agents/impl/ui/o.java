package com.larus.agents.impl.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceEditorBinding;

/* JADX INFO: loaded from: classes24.dex */
public final class o implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusFragmentWorkExperienceEditorBinding f286788a;

    public o(LarusFragmentWorkExperienceEditorBinding r100) {
        this.f286788a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        AppCompatEditText r109 = this.f286788a.f286638e;
        ViewParent r110 = r109.getParent();
        if ((r110 instanceof ViewGroup) == false) goto L5;
        ViewGroup r111 = (ViewGroup) r110;
    L6:
        if (r111 == null) goto L13;
        int r112 = (r100.getHeight() - r109.getTop()) - r111.getPaddingBottom();
        if (r112 <= r109.getMinimumHeight()) goto L12;
        r109.setMinimumHeight(r112);
        return;
    L12:
        return;
    L13:
        return;
    L5:
        r111 = null;
        goto L6
    }
}
