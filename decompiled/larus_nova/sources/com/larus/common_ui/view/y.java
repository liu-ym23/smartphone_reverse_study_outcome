package com.larus.common_ui.view;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import com.larus.common_res.common_ui.databinding.LarusItemSuggestedActionBinding;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class y implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusItemSuggestedActionBinding f328374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SuggestedActionBar f328375b;

    public y(LarusItemSuggestedActionBinding r100, SuggestedActionBar r101) {
        this.f328374a = r100;
        this.f328375b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        float r109 = this.f328374a.f326735c.getMeasuredWidth();
        SuggestedActionBar r110 = this.f328375b;
        this.f328374a.f326735c.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r109, 0.0f, r110.f328261a, r110.f328262b, Shader.TileMode.CLAMP));
        this.f328374a.f326734b.setImageResource(R.drawable.larus_ic_suggested_action_arrow_highlight);
    }
}
