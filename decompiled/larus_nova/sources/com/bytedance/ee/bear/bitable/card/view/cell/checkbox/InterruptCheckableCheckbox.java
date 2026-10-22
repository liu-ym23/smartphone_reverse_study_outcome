package com.bytedance.ee.bear.bitable.card.view.cell.checkbox;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;

/* JADX INFO: loaded from: classes15.dex */
public class InterruptCheckableCheckbox extends AppCompatCheckBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f207629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f207630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f207631c;

    public interface a {
        void a(boolean r100);
    }

    public InterruptCheckableCheckbox(Context r100) {
        super(r100);
        this.f207630b = false;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f207630b == false) goto L6;
        super.setChecked(r100);
        return;
    L6:
        if (this.f207629a == false) goto L12;
        a r101 = this.f207631c;
        if (r101 == null) goto L13;
        r101.a(r100);
        return;
    L13:
        return;
    }

    public void setEnableUserSetChecked(boolean r100) {
        this.f207629a = r100;
    }

    public void setSetCheckedInterceptor(a r100) {
        this.f207631c = r100;
    }

    public InterruptCheckableCheckbox(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f207630b = false;
    }

    public InterruptCheckableCheckbox(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f207630b = false;
    }
}
