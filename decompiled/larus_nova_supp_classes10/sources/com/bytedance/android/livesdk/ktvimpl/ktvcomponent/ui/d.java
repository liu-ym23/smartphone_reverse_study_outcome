package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements fd0.b {
    public final /* synthetic */ Function0 a;

    public d(Function0 r1) {
        this.a = r1;
    }

    public final void onStop() {
        Function0 r0 = this.a;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }
}
