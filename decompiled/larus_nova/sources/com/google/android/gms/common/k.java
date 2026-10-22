package com.google.android.gms.common;

import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
@CheckReturnValue
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f274581c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f274582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Throwable f274583b;

    static {
        f274581c = new k(true, null, null);
    }

    public k(boolean r100, @Nullable String r101, @Nullable Throwable r102) {
        this.f274582a = r100;
        this.f274583b = r102;
    }

    public static k b(String r100) {
        return new k(false, r100, null);
    }

    public static k c(String r100, Throwable r101) {
        return new k(false, r100, r101);
    }

    @Nullable
    public void a() {
    }
}
