package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import java.util.Comparator;

/* JADX INFO: loaded from: classes38.dex */
public final class v0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0<T> f442130a = null;

    static {
        f442130a = new v0();
    }

    public v0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return ((SectionHeaderItem) r100).f441437c.compareTo(((SectionHeaderItem) r101).f441437c);
    }
}
