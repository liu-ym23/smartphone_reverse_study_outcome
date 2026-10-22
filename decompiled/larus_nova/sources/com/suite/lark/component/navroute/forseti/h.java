package com.suite.lark.component.navroute.forseti;

import androidx.fragment.app.Fragment;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, i> f460345a;

    public h() {
        this.f460345a = new ConcurrentHashMap();
    }

    public final Fragment a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        i r101 = b(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f460346a.get();
    }

    public final i b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        i r101 = this.f460345a.get(r100);
        if (r101 == null) goto L5;
        Fragment r102 = r101.f460346a.get();
    L6:
        if (r102 != null) goto L8;
        this.f460345a.remove(r100);
    L8:
        return r101;
    L5:
        r102 = null;
        goto L6
    }
}
