package com.bytedance.android.livesdk.livecommerce.oldflash;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends c {
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public final String g;
    public final String h;

    public g(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "label");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "code");
        super(r2);
        this.g = r3;
        this.h = r4;
        this.c = true;
    }
}
