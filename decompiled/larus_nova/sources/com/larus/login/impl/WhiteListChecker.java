package com.larus.login.impl;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
public final class WhiteListChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f357247a = 0;

    public WhiteListChecker() {
    }

    static {
        String r100 = com.larus.network.http.d.f360140a;
    }

    public static void a() {
        c(new WhiteListChecker$goLarkSsoIfNeed$1(null));
    }

    public static void b() {
        c(new WhiteListChecker$onLoginSuccess$1(null));
    }

    public static FragmentActivity c(Function2 r100) {
        Object r101 = null;
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) null;
    L5:
        return null;
    }
}
