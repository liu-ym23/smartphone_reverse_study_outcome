package uv4;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ c a;

    public f(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        UDCheckBox r3 = this.a.e;
        if (r3 == null) goto L9;
        if (r3 == null) goto L6;
        boolean r0 = r3.isChecked();
    L7:
        r3.setChecked(!r0);
        return;
    L6:
        r0 = false;
        goto L7
    }
}
