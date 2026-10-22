package com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile;

import android.net.Uri;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.m;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.c1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.drive.biz.external.c.a {
    public final /* synthetic */ SpaceFileDownloadManager a;
    public final /* synthetic */ boolean b;

    public static final class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SpaceFileDownloadManager b;
        public final /* synthetic */ Uri c;

        public a(boolean r1, SpaceFileDownloadManager r2, Uri r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (this.a == false) goto L5;
            String r0 = this.b.a.getString(2131887289);
        L6:
            Intrinsics.checkNotNull(r0);
            Toast.showSuccessText(this.b.a, r0, 1);
            return;
        L5:
            r0 = this.b.a.getString(2131887288) + c1.c(this.b.a, this.c);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(SpaceFileDownloadManager r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.c.a
    public final void a(boolean r3, Uri r4) {
        c r0 = this.a.f;
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        SpaceFileDownloadManager.EResult r1 = SpaceFileDownloadManager.EResult.SUCCESS;
    L7:
        r0.a(r1);
        goto L8
    L6:
        r1 = SpaceFileDownloadManager.EResult.SAVE_FAILED;
    L8:
        if (r3 == false) goto L17;
        SpaceFileDownloadManager r5 = this.a;
        if (r5.a == null) goto L18;
        if (r4 == null) goto L19;
        m.a(new a(this.b, r5, r4));
        if (this.b == false) goto L15;
        i.i(this.a.a, r4, new Token("LARK-PSDA-ccm_android_drive_save_media_notify_system_in_space"));
        return;
    L15:
        i.h(this.a.a, r4, new Token("LARK-PSDA-ccm_android_drive_save_file_notify_system_in_space"));
        return;
    L19:
        return;
    L18:
        return;
    }
}
