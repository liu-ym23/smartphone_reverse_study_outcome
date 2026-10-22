package com.bytedance.ee.bear.wikiv2;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements bn4.a.a {
    public final /* synthetic */ WikiFragment a;
    public final /* synthetic */ WikiInfo b;
    public final /* synthetic */ Function1<BearUrl, Unit> c;
    public final /* synthetic */ BearUrl d;

    public static final class a implements Runnable {
        public final /* synthetic */ WikiFragment a;
        public final /* synthetic */ WikiInfo b;
        public final /* synthetic */ Function1<BearUrl, Unit> c;
        public final /* synthetic */ BearUrl d;

        public a(WikiFragment r1, WikiInfo r2, Function1<? super BearUrl, Unit> r3, BearUrl r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        L23:
            return;
        L3:
            if (this.a.isAdded() == false) goto L18;
            WikiFragment r0 = this.a;     // Catch: Throwable -> L15
            WikiInfo r1 = this.b;     // Catch: Throwable -> L15
            WikiInfo r2 = r0.k.get();     // Catch: Throwable -> L15
            if (r2 != null) goto L8;
        L10:
            boolean r3 = false;
        L11:
            if (r3 == true) goto L22;
            Function1<BearUrl, Unit> r4 = this.c;     // Catch: Throwable -> L15
            WikiFragment r5 = this.a;     // Catch: Throwable -> L15
            BearUrl r6 = this.d;     // Catch: Throwable -> L15
            WikiInfo r7 = this.b;     // Catch: Throwable -> L15
            r5.getClass();     // Catch: Throwable -> L15
            r4.invoke(WikiFragment.X90(r6, r7));     // Catch: Throwable -> L15
            return;
        L22:
            return;
        L8:
            if (r2.getInSpace() != r1.getInSpace()) goto L10;
            r3 = true;
            goto L11
        }
    }

    public final void onResult(boolean r6) {
        tt5.a.h("WikiFragment", "resolveLoadUrl: bitable async result isApp=" + r6);
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        FragmentActivity r7 = this.a.getActivity();
        if (r7 == null) goto L9;
        r7.runOnUiThread(new a(this.a, this.b, this.c, this.d));
        return;
    }

    public g(WikiFragment r1, WikiInfo r2, Function1<? super BearUrl, Unit> r3, BearUrl r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
