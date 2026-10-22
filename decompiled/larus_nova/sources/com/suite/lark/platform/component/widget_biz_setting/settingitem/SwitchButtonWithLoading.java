package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.button.LKUISwitchButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class SwitchButtonWithLoading extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LKUISwitchButton f461100a;

    public interface a {
    }

    public void setOnSwitchListener(a r100) {
    }

    public final void R5() {
        LKUISwitchButton r100 = (LKUISwitchButton) LayoutInflater.from(getContext()).inflate(R.layout.view_switch_button_with_loading_notification, this).findViewById(R.id.switcher_button);
        this.f461100a = r100;
        r100.setCheckedNoEvent(true);
        SwitcherLoadingView r101 = (SwitcherLoadingView) findViewById(R.id.switcher_loading);
        this.f461100a.setOnCheckedChangeListener(new com.suite.lark.platform.component.widget_biz_setting.settingitem.a(this));
    }

    public SwitchButtonWithLoading(Context r100) {
        super(r100);
        R5();
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f461100a.setEnabled(r100);
    }

    public void update(boolean r100) {
        this.f461100a.setCheckedImmediately(r100);
    }

    public SwitchButtonWithLoading(Context r100, AttributeSet r101) {
        super(r100, r101);
        R5();
    }

    public SwitchButtonWithLoading(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        R5();
    }
}
