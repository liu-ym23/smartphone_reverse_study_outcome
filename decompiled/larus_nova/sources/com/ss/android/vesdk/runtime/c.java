package com.ss.android.vesdk.runtime;

import android.text.TextUtils;
import com.ss.android.vesdk.runtime.persistence.VESP;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f455896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f455897b;

    public final String a() {
        if (TextUtils.isEmpty(this.f455897b) == false) goto L6;
        this.f455897b = (String) VESP.b().a("vesdk_models_dir_sp_key", "");
    L6:
        return this.f455897b;
    }

    public c() {
    }
}
