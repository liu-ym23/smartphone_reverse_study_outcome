package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import fd2.n;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements n {
    public int a;
    public final HashMap<String, Integer> b;

    public static final class a {
    }

    static {
    }

    public e() {
        this.a = 100;
        this.b = new HashMap(15);
    }

    public final int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        if (this.b.containsKey(r2) == false) goto L9;
        Integer r3 = this.b.get(r2);
        if (r3 != null) goto L10;
        r3 = Integer.valueOf(this.a);
    L10:
        return r3.intValue();
    L9:
        return this.a;
    }
}
