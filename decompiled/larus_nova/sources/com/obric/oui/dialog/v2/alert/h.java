package com.obric.oui.dialog.v2.alert;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.oui.dialog.base.AbstractDialogModal;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends AbstractDialogModal implements zla.f {
    public ButtonStyleController A;

    @Override // zla.f
    public FrameLayout getBannerSlot() {
        return null;
    }

    @Override // zla.f
    public FrameLayout getBodySlot() {
        return null;
    }

    @Override // zla.f
    public FrameLayout getButtonSlot() {
        return null;
    }

    @Override // zla.f
    public FrameLayout getIconSlot() {
        return null;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R.layout.o_alert_dialog_v2;
    }

    public final CharSequence getMessageStr() {
        return null;
    }

    public final TextView getMessageView() {
        return null;
    }

    public final CharSequence getTitleStr() {
        return null;
    }

    public final TextView getTitleView() {
        return null;
    }

    public final void setMessage(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    public final void setOnlyTitleText(CharSequence r100) {
    }

    public final View getNegativeButton() {
        int r100 = vma.c.f556351a;
        ButtonStyleController r101 = this.A;
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.d();
    }

    public final View getNeutralButton() {
        int r100 = vma.c.f556351a;
        ButtonStyleController r101 = this.A;
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.e();
    }

    public final View getPositiveButton() {
        int r100 = vma.c.f556351a;
        ButtonStyleController r101 = this.A;
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f();
    }

    public final void setBodyStyleController(zla.h r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        if (getMatchParentHeight() == false) goto L5;
        throw null;
    L5:
        throw null;
    }

    public final void setButtonStyleController(ButtonStyleController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.A = r100;
        zla.e r101 = (zla.e) r100;
        r101.a(getContext(), this);
        r101.c(this);
    }

    public final void setTitleText(CharSequence r100) {
        TextUtils.isEmpty(r100);
    }

    public final void setTopImageStyleController(zla.h r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        r100.a(getContext(), this);
    }
}
