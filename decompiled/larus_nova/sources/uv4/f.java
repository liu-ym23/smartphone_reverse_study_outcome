package uv4;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f551858a;

    public f(c r100) {
        this.f551858a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f551858a.f551848e;
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
