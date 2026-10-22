package com.ss.android.ugc.aweme.search.common.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes40.dex */
public class SharedPreferencesWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f452181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f452182b;

    public SharedPreferencesWrapper(Context r100) {
        this.f452181a = null;
        this.f452182b = null;
        this.f452181a = r100.getApplicationContext().getSharedPreferences("search", 0);
    }
}
