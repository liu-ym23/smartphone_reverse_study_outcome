package tg5;

import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements UDCheckBox.c {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    public final void a(UDCheckBox r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        this.a.D0(r3);
        p.a r4 = this.a.d;
        if (r4 == null) goto L6;
        r4.N(r3);
        return;
    }
}
