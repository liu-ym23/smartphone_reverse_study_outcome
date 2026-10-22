package com.ss.android.lark.todo.impl.features.center.v3;

import com.bytedance.lark.pb.todo.v1.Todo;
import java.util.Comparator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f441619a;

    public g(Map<String, String> r100) {
        this.f441619a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        Todo r102 = (Todo) r100;
        Todo r103 = (Todo) r101;
        Map<String, String> r104 = this.f441619a;
        String r105 = null;
        if (r102 == null) goto L5;
        String r106 = r102.guid;
    L6:
        String r107 = r104.get(r106);
        Map<String, String> r108 = this.f441619a;
        if (r103 == null) goto L9;
        r105 = r103.guid;
    L9:
        String r109 = r108.get(r105);
        if (r107 != null) goto L12;
        r107 = "";
    L12:
        if (r109 != null) goto L14;
        r109 = "";
    L14:
        int r110 = r107.compareTo(r109);
        if (r110 == 0) goto L17;
        return r110;
    L17:
        return Intrinsics.compare(r102.create_milli_time.longValue(), r103.create_milli_time.longValue());
    L5:
        r106 = null;
        goto L6
    }
}
