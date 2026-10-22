package com.bytedance.ee.bear.sheet.screenshotobserver;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.permission.StoragePermissionUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f238331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenshotObserver f238332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f238333c;

    public static final class a implements StoragePermissionUtils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenshotObserver f238334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f238335b;

        public a(ScreenshotObserver r100, Uri r101) {
            this.f238334a = r100;
            this.f238335b = r101;
        }

        @Override // com.ss.android.lark.permission.StoragePermissionUtils.a
        public final void b(StoragePermissionUtils.c r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            if (r100.f438544a != 0) goto L5;
            boolean r101 = true;
        L6:
            int r102 = ScreenshotObserver.f238306o;
            tt5.a.h("ScreenshotObserver", "Request read permission result. isGranted: " + r101);
            if (r101 == false) goto L10;
            ScreenshotObserver r103 = this.f238334a;
            r103.f238313g = true;
            ScreenshotObserver.a(r103, this.f238335b);
            return;
        L10:
            return;
        L5:
            r101 = false;
            goto L6
        }
    }

    public b(Activity r100, ScreenshotObserver r101, Uri r102) {
        this.f238331a = r100;
        this.f238332b = r101;
        this.f238333c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (com.bytedance.ee.util.ui.b.a(this.f238331a) == false) goto L9;
        Activity r100 = this.f238331a;     // Catch: Throwable -> L6
        Token r101 = new Token("LARK-PSDA-sheet_screenshot_request_read_image_permission");     // Catch: Throwable -> L6
        StoragePermissionUtils.f(r100, new a(this.f238332b, this.f238333c), 2, r101, new String[0]);     // Catch: Throwable -> L6
        return;
    }
}
