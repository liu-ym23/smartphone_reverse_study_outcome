package i0c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c<S, E, C, R> extends a<S, E, C, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public S f487919c;

    public c(h0c.e<S, E, C, R> r100) {
        Intrinsics.checkNotNullParameter(r100, "stateMap");
        super(r100);
    }

    public final void a(com.ss.android.lark.passportc.impl.v2.action.d r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        S r101 = this.f487919c;
        if (r101 == null) goto L14;
        S r102 = this.f487918b;
        if (r102 == null) goto L12;
        e r103 = new e(r101, r102, r100);
        h0c.e<S, E, C, R> r104 = this.f487917a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "transition");
        HashMap<S, List<d<S, C, R>>> r105 = r104.f483509a;
        S r106 = r103.f487920a;
        List<d<S, C, R>> r107 = r105.get(r106);
        if (r107 != null) goto L9;
        r107 = new ArrayList();
        r105.put(r106, r107);
    L9:
        TypeIntrinsics.asMutableList(r107).add(r103);
        return;
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L14:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
