package com.bytedance.ee.bear.document.loading;

import com.bytedance.ee.bear.document.editionmanager.data.TokenResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ DocLoadingPlugin a;
    public final /* synthetic */ int b;
    public final /* synthetic */ DocLoadingPlugin.c c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.loading.a$a, reason: collision with other inner class name */
    public static final class C0082a implements c15.a {
        public final /* synthetic */ DocLoadingPlugin.c a;
        public final /* synthetic */ DocLoadingPlugin b;

        @Override // c15.a
        public final void a(TokenResult r4) {
            DocLoadingPlugin.c r0 = this.a;
            DocLoadingPlugin r1 = r0.a;
            if (r4 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            DocLoadingPlugin.access$setEditionTokenInPath$p(r1, r5);
            j.c(new b(r0.a, r0));
            return;
        L5:
            if (r4.getReal_sub_type() != 4) goto L7;
            r5 = true;
            goto L8
        }

        @Override // c15.a
        public final void onFail(int r2) {
            DocLoadingPlugin.access$setEditionTokenInPath$p(this.b, false);
        }

        public C0082a(DocLoadingPlugin.c r1, DocLoadingPlugin r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a(DocLoadingPlugin r1, int r2, DocLoadingPlugin.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DocLoadingPlugin.c r1 = this.c;     // Catch: Throwable -> L6
        DocLoadingPlugin r2 = this.a;     // Catch: Throwable -> L6
        C0082a r0 = new C0082a(r1, r2);     // Catch: Throwable -> L6
        z05.d r3 = DocLoadingPlugin.access$getMEditionManager$p(r2);     // Catch: Throwable -> L6
        if (r3 == null) goto L9;
        iu5.f.a(new z05.c(r3, this.a.getDocumentMetadata().getToken(), this.b, r0));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
