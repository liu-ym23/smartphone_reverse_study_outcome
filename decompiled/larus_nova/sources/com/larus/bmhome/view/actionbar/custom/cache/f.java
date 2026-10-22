package com.larus.bmhome.view.actionbar.custom.cache;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.z1;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {
    public static final boolean b(b2 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        z1 r101 = r100.f295007n;
        if (r101 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r101.f295635b, Boolean.TRUE);
    }

    public static final boolean a(ArrayList<b2> r100, ModelItemIdentity r101, boolean r102) {
        b2 r103 = null;
        Object r104 = null;
        if (r100 == null) goto L11;
        Iterator<T> r105 = r100.iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((b2) r106).b(), r101) == false) goto L6;
        r104 = r106;
    L10:
        r103 = (b2) r104;
    L11:
        if (r103 != null) goto L13;
    L21:
        return false;
    L13:
        if (b(r103) == true) goto L21;
        if (r102 == false) goto L20;
        Integer r107 = r103.f295005l;
        int r108 = AgentMode.MOA.getValue();
        if (r107 == null) goto L21;
        if (r107.intValue() != r108) goto L21;
    L20:
        return true;
    }
}
