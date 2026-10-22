package com.bytedance.ee.bear.debug;

import android.content.SharedPreferences;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ AppendParamsActivity a;

    public f(AppendParamsActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.j.clear();
        this.a.k.notifyDataSetChanged();
        SharedPreferences r2 = this.a.g;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appendParamsSP");
        r2 = null;
    L5:
        r2.edit().clear().apply();
    }
}
