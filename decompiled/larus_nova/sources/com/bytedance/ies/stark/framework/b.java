package com.bytedance.ies.stark.framework;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f248627a = null;

    public interface a {
        void a();
    }

    static {
        f248627a = new CopyOnWriteArrayList();
    }

    public static void a(Object r100) {
        Intrinsics.checkNotNullParameter("service", "tag");
        Intrinsics.checkNotNullParameter("service", "tag");
        Intrinsics.checkNotNullParameter("devtool", "type");
        Intrinsics.checkNotNullParameter("service", "tag");
        if (((s46.a) HybridDevTool.f248625a.getValue()) == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L11;
        Iterator<a> r102 = f248627a.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().a();
    L11:
        String.valueOf(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
