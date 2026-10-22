package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.view.SuggestedActionBar;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LarusWidgetInputSuggestedActionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f324088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f324089b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324088a;
    }

    public static LarusWidgetInputSuggestedActionBinding a(View r100) {
        int r101 = R.id.input_suggest_action_bar;
        if (((SuggestedActionBar) ViewBindings.findChildViewById(r100, R.id.input_suggest_action_bar)) == null) goto L9;
        r101 = R.id.input_suggested_action_divider;
        View r102 = ViewBindings.findChildViewById(r100, R.id.input_suggested_action_divider);
        if (r102 == null) goto L9;
        return new LarusWidgetInputSuggestedActionBinding((LinearLayout) r100, r102);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusWidgetInputSuggestedActionBinding(LinearLayout r100, View r101) {
        this.f324088a = r100;
        this.f324089b = r101;
    }
}
