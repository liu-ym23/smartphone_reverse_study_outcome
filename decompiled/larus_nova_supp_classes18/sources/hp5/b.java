package hp5;

import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements UDCheckBox.c {
    public final /* synthetic */ e a;

    public b(e r1) {
        this.a = r1;
    }

    public final void a(UDCheckBox r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "buttonView");
        e r0 = this.a;
        if (r0.d == false) goto L11;
        UDButton r1 = r0.f;
        if (r1 == null) goto L8;
        r1.setClickable(r4);
    L8:
        UDButton r2 = r0.f;
        if (r2 == null) goto L11;
        r2.setEnabled(r4);
    L11:
        UDCheckBox.c r5 = this.a.g;
        if (r5 == null) goto L15;
        r5.a(r3, r4);
        return;
    }
}
