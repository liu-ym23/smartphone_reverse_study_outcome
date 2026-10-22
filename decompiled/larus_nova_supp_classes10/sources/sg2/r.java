package sg2;

import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements Function1<Fragment, Unit> {
    public final /* synthetic */ Fragment[] a;

    public r(Fragment[] r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Fragment[] r0 = this.a;
        r0[0] = (Fragment) r3;
        return null;
    }
}
