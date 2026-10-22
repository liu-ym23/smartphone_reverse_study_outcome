package com.ss.android.lark.screenprotect;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
@Deprecated(message = "no need for user scope")
public final class ScreenshotProtectionModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.screenprotect.a f439775a;

    public static final class a {
    }

    static {
    }

    @Inject
    public ScreenshotProtectionModule() {
        int r100 = ScreenshotProtectionModule$onLoginListener$1.f439776a;
        int r101 = ScreenshotProtectionModule$onLogoutListener$1.f439777a;
    }
}
