package com.larus.im.internal.network.link.impl.sami;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Function0<Boolean>> f349501a;

    public final boolean a() {
        Iterator r100 = ((ArrayList) this.f349501a).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((Boolean) ((Function0) r100.next()).invoke()).booleanValue() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public x() {
        this.f349501a = new ArrayList();
    }

    public final void b(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        ((ArrayList) this.f349501a).add(r100);
    }
}
