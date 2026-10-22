package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public String a;
    public int b;
    public boolean c;

    public b() {
        this(0);
    }

    public b(int r2) {
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_TIMEOUT, "chorusId");
        this.a = BDLocationException.ERROR_TIMEOUT;
        this.b = 0;
        this.c = false;
    }
}
