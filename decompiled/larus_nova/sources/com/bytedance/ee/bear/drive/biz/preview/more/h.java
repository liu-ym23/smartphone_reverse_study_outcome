package com.bytedance.ee.bear.drive.biz.preview.more;

import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements com.bytedance.ee.bear.drive.biz.preview.more.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f223529a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f223530a;

        /* JADX INFO: Incorrect field signature: TT; */
        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseMoreMenuAction f223531b;

        /* JADX WARN: Incorrect types in method signature: (Lcom/bytedance/ee/bear/drive/biz/preview/more/b;TT;)V */
        public a(b r100, BaseMoreMenuAction r101) {
            this.f223530a = r100;
            this.f223531b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.b(this.f223530a, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(this.f223531b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h(b r100) {
        this.f223529a = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.a
    public final <T extends BaseMoreMenuAction> void a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        com.bytedance.ee.util.ui.m.a(new a(this.f223529a, r100));
    }
}
