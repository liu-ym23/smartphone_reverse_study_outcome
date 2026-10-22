package hp5;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UDCheckBox f486437c;

    public c(UDCheckBox r100) {
        this.f486437c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        UDCheckBox r101 = this.f486437c;
        if (r101 == null) goto L9;
        if (r101 == null) goto L6;
        boolean r102 = r101.isChecked();
    L7:
        r101.setChecked(!r102);
        return;
    L6:
        r102 = false;
        goto L7
    }
}
