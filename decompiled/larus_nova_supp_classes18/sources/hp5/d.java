package hp5;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends t {
    public final /* synthetic */ UDCheckBox c;

    public d(UDCheckBox r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        UDCheckBox r3 = this.c;
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
