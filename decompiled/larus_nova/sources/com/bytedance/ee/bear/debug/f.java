package com.bytedance.ee.bear.debug;

import android.content.SharedPreferences;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppendParamsActivity f217375a;

    public f(AppendParamsActivity r100) {
        this.f217375a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f217375a.f217348j.clear();
        this.f217375a.f217349k.notifyDataSetChanged();
        SharedPreferences r101 = this.f217375a.f217345g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appendParamsSP");
        r101 = null;
    L5:
        r101.edit().clear().apply();
    }
}
