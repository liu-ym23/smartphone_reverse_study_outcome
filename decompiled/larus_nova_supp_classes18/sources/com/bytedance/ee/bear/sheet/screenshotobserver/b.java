package com.bytedance.ee.bear.sheet.screenshotobserver;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.permission.StoragePermissionUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ ScreenshotObserver b;
    public final /* synthetic */ Uri c;

    public static final class a implements StoragePermissionUtils.a {
        public final /* synthetic */ ScreenshotObserver a;
        public final /* synthetic */ Uri b;

        public a(ScreenshotObserver r1, Uri r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b(StoragePermissionUtils.c r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            if (r4.a != 0) goto L5;
            boolean r5 = true;
        L6:
            int r1 = ScreenshotObserver.o;
            tt5.a.h("ScreenshotObserver", "Request read permission result. isGranted: " + r5);
            if (r5 == false) goto L10;
            ScreenshotObserver r6 = this.a;
            r6.g = true;
            ScreenshotObserver.a(r6, this.b);
            return;
        L10:
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    public b(Activity r1, ScreenshotObserver r2, Uri r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
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
        if (com.bytedance.ee.util.ui.b.a(this.a) == false) goto L9;
        Activity r0 = this.a;     // Catch: Throwable -> L6
        Token r1 = new Token("LARK-PSDA-sheet_screenshot_request_read_image_permission");     // Catch: Throwable -> L6
        StoragePermissionUtils.f(r0, new a(this.b, this.c), 2, r1, new String[0]);     // Catch: Throwable -> L6
        return;
    }
}
