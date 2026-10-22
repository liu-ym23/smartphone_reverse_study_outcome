package com.larus.kmp.voice_setting.voice.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f355114b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f355115c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355116a;

    public static final class a {
    }

    static {
        f355114b = new n("bot_id");
        f355115c = new n("enter_method");
    }

    public final int hashCode() {
        return this.f355116a.hashCode();
    }

    public n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rawValue");
        this.f355116a = r100;
    }

    public final boolean equals(Object r100) {
        String r101 = null;
        if ((r100 instanceof n) == false) goto L5;
        n r102 = (n) r100;
    L6:
        if (r102 == null) goto L9;
        r101 = r102.f355116a;
    L9:
        return Intrinsics.areEqual(r101, this.f355116a);
    L5:
        r102 = null;
        goto L6
    }
}
