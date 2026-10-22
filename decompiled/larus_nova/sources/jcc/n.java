package jcc;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkPhotoPickerView f498189a;

    public n(LarkPhotoPickerView r100) {
        this.f498189a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f498189a.f445896l.isEnabled() == false) goto L6;
        UDCheckBox r101 = this.f498189a.f445896l;
        r101.setChecked(!r101.isChecked());
        return;
    }
}
