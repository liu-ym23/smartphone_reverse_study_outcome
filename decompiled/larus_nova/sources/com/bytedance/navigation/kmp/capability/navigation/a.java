package com.bytedance.navigation.kmp.capability.navigation;

import com.bytedance.bdnavigationsdk.navigation.w;
import com.bytedance.bdnavigationsdk.network.route.v;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f265746a = null;

    static {
        f265746a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.navigation.kmp.capability.navigation.n
    public final b37.b a(com.bytedance.bdnavigationsdk.f r100, List<v> r101) {
        Intrinsics.checkNotNullParameter(r101, "wayPoints");
        int r102 = 2;
        if (r100 == null) goto L5;
        w r103 = r100.k(r101);
        int r104 = r103.f200110b;
        if (r104 != 0) goto L9;
        r102 = 0;
    L14:
        return new b37.b(r103.f200109a, r102, r103.f200111c);
    L9:
        if (r104 == 1) goto L11;
        if (r104 == 2) goto L14;
    L11:
        r102 = 1;
        goto L14
    L5:
        return new b37.b(null, 2, "navigation engine is not running");
    }
}
