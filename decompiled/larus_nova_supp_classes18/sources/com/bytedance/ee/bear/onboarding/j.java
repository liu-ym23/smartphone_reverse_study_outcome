package com.bytedance.ee.bear.onboarding;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import vk5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<UI extends vk5.c> extends k {
    public final tk5.d<UI> b;
    public final WeakReference<UI> c;

    public j(tk5.d<UI> r2, WeakReference<UI> r3) {
        Intrinsics.checkNotNullParameter(r2, "mission");
        Intrinsics.checkNotNullParameter(r3, "reference");
        this.b = r2;
        this.c = r3;
    }
}
