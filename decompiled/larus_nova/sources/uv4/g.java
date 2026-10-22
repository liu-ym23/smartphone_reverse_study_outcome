package uv4;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f551859a;

    public g(c r100) {
        this.f551859a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f551859a.f551848e;
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.isChecked());
    L6:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r103 = r102.booleanValue();
        c r104 = this.f551859a;
        c.a r105 = r104.f551854k;
        if (r105 == null) goto L9;
        r105.a(r104.f551853j, r103);
    L9:
        this.f551859a.a();
        return;
    L5:
        r102 = null;
        goto L6
    }
}
