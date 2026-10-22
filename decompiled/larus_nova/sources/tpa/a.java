package tpa;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f547074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547075b;

    public a(SharedPreferences r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f547074a = r100;
        this.f547075b = false;
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f547074a.contains(r100) == true) goto L7;
        return null;
    L7:
        return this.f547074a.getString(r100, "");
    }
}
