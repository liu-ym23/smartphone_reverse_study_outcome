package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.larksuite.component.ui.button.LKUICheckBox;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public class ThrottleCheckBox extends LKUICheckBox {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f461113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f461114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f461115e;

    public ThrottleCheckBox(Context r100) {
        super(r100);
        this.f461113c = 200;
        this.f461114d = 0;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        long r101 = SystemClock.uptimeMillis();
        if ((r101 - this.f461114d) >= this.f461113c) goto L6;
        Log.i("OnLimitingListener", "elapsedTime is short than LENGTH_SHORT");
        return;
    L6:
        this.f461114d = r101;
        super.setChecked(r100);
    }

    public void setCheckedImmediatelyNoEvent(boolean r100) {
        CompoundButton.OnCheckedChangeListener r101 = this.f461115e;
        setOnCheckedChangeListener(null);
        super.setChecked(r100);
        setOnCheckedChangeListener(r101);
    }

    public void setMinClickInterval(long r100) {
        this.f461113c = r100;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r100) {
        super.setOnCheckedChangeListener(r100);
        this.f461115e = r100;
    }

    public ThrottleCheckBox(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f461113c = 200;
        this.f461114d = 0;
    }

    public ThrottleCheckBox(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f461113c = 200;
        this.f461114d = 0;
    }
}
