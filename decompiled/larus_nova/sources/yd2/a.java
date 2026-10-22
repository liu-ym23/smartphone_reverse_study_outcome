package yd2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, List<String>> f567302a;

    public a() {
        this.f567302a = new HashMap();
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "dressId");
        List<String> r102 = this.f567302a.get(r100);
        if (r102 != null) goto L5;
        r102 = new ArrayList();
        this.f567302a.put(r100, r102);
    L5:
        r102.add(r101);
    }
}
