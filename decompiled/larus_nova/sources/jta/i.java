package jta;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f500380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f500381b;

    public i(Context r100) {
        new Handler(Looper.getMainLooper());
        this.f500380a = "";
        this.f500381b = r100.getSharedPreferences(kta.b.f506097a, 0);
    }
}
