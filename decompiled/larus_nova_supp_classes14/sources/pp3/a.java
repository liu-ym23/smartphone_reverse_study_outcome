package pp3;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import uq3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ p b;

    public a(Function1 r1, p r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1 r3 = this.a;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke(this.b.a);
        return;
    }
}
