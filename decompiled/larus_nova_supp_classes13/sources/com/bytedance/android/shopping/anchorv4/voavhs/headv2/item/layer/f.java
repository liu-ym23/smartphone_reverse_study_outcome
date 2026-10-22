package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements x {
    public final /* synthetic */ ItemMediaLayer a;
    public final /* synthetic */ int b;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.C(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x
    public final void onStartPlay() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.x
    public final void a() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d == false) goto L14;
        ItemMediaLayer r0 = this.a;
        int r1 = this.b;
        Integer r2 = r0.a;
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L15;
        Lazy r4 = UIUtils.a;
        UIUtils.c().postDelayed(new a(this), 100);
        return;
    L15:
        return;
    L8:
        if (r1 != r2.intValue()) goto L10;
        r3 = true;
        goto L11
    }

    public f(ItemMediaLayer r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
