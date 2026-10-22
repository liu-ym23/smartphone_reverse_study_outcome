package com.bytedance.lego.init;

import com.bytedance.lego.init.model.ExecutionPeriod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<ExecutionPeriod, List<bf6.g>> f254532a = null;

    static {
        f254532a = new LinkedHashMap();
    }

    public static void a(ExecutionPeriod r100) {
        List r101 = (List) ((LinkedHashMap) f254532a).get(r100);
        if (r101 == null) goto L9;
        Iterator r102 = r101.iterator();
        if (r102.hasNext() == false) goto L10;
        ((bf6.g) r102.next()).getClass();
        throw null;
    L10:
        return;
    }
}
