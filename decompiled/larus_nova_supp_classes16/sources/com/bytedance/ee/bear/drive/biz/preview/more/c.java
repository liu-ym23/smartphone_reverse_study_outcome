package com.bytedance.ee.bear.drive.biz.preview.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.SpaceFileDownloadManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.drive.biz.preview.more.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ a95.a b;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        /* JADX INFO: Incorrect field signature: TT; */
        public final /* synthetic */ BaseMoreMenuAction b;
        public final /* synthetic */ a95.a c;

        /* JADX WARN: Incorrect types in method signature: (Lcom/bytedance/ee/bear/drive/biz/preview/more/b;TT;La95/a;)V */
        public a(b r1, BaseMoreMenuAction r2, a95.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a;     // Catch: Throwable -> L4
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r5 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(this.b);     // Catch: Throwable -> L4
            a95.a r6 = this.c;     // Catch: Throwable -> L4
            int r1 = b.f;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            FragmentActivity r2 = r0.a;     // Catch: Throwable -> L4
            e65.a r3 = r0.b;     // Catch: Throwable -> L4
            new SpaceFileDownloadManager(r2, r3.a, r3.b.getFileModel(), r5, r6).c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
    public final <T extends BaseMoreMenuAction> void a(T r4) {
        Intrinsics.checkNotNullParameter(r4, "t");
        com.bytedance.ee.util.ui.m.a(new a(this.a, r4, this.b));
    }

    public c(b r1, a95.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
