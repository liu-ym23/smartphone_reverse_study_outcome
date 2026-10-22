package com.bytedance.ee.bear.drive.biz.preview.more;

import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements com.bytedance.ee.bear.drive.biz.preview.more.a {
    public final /* synthetic */ b a;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        /* JADX INFO: Incorrect field signature: TT; */
        public final /* synthetic */ BaseMoreMenuAction b;

        /* JADX WARN: Incorrect types in method signature: (Lcom/bytedance/ee/bear/drive/biz/preview/more/b;TT;)V */
        public a(b r1, BaseMoreMenuAction r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.b(this.a, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(this.b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
    public final <T extends BaseMoreMenuAction> void a(T r3) {
        Intrinsics.checkNotNullParameter(r3, "t");
        com.bytedance.ee.util.ui.m.a(new a(this.a, r3));
    }
}
