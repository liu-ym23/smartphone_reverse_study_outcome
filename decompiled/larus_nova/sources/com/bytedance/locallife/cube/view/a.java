package com.bytedance.locallife.cube.view;

import com.bytedance.locallife.cube.model.CubeEvent;
import java.util.Comparator;

/* JADX INFO: loaded from: classes21.dex */
public final class a<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f257275a = null;

    static {
        f257275a = new a();
    }

    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        CubeEvent r102 = (CubeEvent) r100;
        CubeEvent r103 = (CubeEvent) r101;
        int r104 = -1;
        if (r102 == null) goto L5;
        int r105 = r102.getPriority();
    L6:
        if (r103 == null) goto L9;
        r104 = r103.getPriority();
    L9:
        return r105 - r104;
    L5:
        r105 = -1;
        goto L6
    }
}
