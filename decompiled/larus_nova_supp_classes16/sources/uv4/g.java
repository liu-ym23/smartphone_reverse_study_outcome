package uv4;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ c a;

    public g(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        UDCheckBox r4 = this.a.e;
        if (r4 == null) goto L5;
        Boolean r5 = Boolean.valueOf(r4.isChecked());
    L6:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r6 = r5.booleanValue();
        c r0 = this.a;
        c.a r1 = r0.k;
        if (r1 == null) goto L9;
        r1.a(r0.j, r6);
    L9:
        this.a.a();
        return;
    L5:
        r5 = null;
        goto L6
    }
}
