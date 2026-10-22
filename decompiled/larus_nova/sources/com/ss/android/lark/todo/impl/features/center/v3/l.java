package com.ss.android.lark.todo.impl.features.center.v3;

import com.ss.android.lark.todo.impl.features.center.v3.data.TaskSectionData;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<TaskSectionData> f441627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f441628b;

    public l(List<TaskSectionData> r100, boolean r101) {
        this.f441627a = r100;
        this.f441628b = r101;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        com.ss.android.lark.todo.impl.features.center.v3.data.f r102 = (com.ss.android.lark.todo.impl.features.center.v3.data.f) r100;
        com.ss.android.lark.todo.impl.features.center.v3.data.f r103 = (com.ss.android.lark.todo.impl.features.center.v3.data.f) r101;
        Iterator<TaskSectionData> r104 = this.f441627a.iterator();
        int r105 = 0;
        int r106 = 0;
    L3:
        int r107 = -1;
        if (r104.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r104.next().f441515c, r102.f441562b) == true) goto L10;
        r106 = r106 + 1;
    L10:
        Iterator<TaskSectionData> r108 = this.f441627a.iterator();
    L12:
        if (r108.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(r108.next().f441515c, r103.f441562b) == true) goto L18;
        r105 = r105 + 1;
    L18:
        int r109 = r106 - r105;
        if (r109 != 0) goto L34;
        int r110 = Intrinsics.compare(r102.f441564d, r103.f441564d);
        if (r110 == 0) goto L28;
        if (this.f441628b == false) goto L33;
        r107 = 1;
    L33:
        return r110 * r107;
    L28:
        return r102.f441561a.compareTo(r103.f441561a);
    L34:
        return r109;
    L17:
        r105 = -1;
        goto L18
    L9:
        r106 = -1;
        goto L10
    }
}
