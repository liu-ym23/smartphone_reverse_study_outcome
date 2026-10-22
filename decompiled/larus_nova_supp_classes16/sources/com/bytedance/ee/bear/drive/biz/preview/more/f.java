package com.bytedance.ee.bear.drive.biz.preview.more;

import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements com.bytedance.ee.bear.drive.biz.preview.more.a {
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
            b.a(this.a, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(this.b), this.c);     // Catch: Throwable -> L4
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

    public f(b r1, a95.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
