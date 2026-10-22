package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.k {
    public final /* synthetic */ p a;
    public final /* synthetic */ h83.f b;

    public static final class a implements Runnable {
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.base.d a;
        public final /* synthetic */ int b;
        public final /* synthetic */ o c;

        public a(com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r1, int r2, o r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewPager r0 = this.c.a.i;     // Catch: Throwable -> L10
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getCurrentItem() != this.b) goto L17;
            g83.a r1 = this.a.q();     // Catch: Throwable -> L10
            if (r1 == null) goto L18;
            r1.c(this.b);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void b(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void d() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onResume() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.k
    public final void c() {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r0 = this.a.g;
        if (r0 == null) goto L8;
        r0.k(false, null, null);
        r0.h(true);
        r0.p(true);
        g83.a r1 = r0.q();
        if (r1 == null) goto L9;
        r1.c(-1);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.k
    public final void e(boolean r6) {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r7 = this.a.g;
        if (r7 == null) goto L22;
        int r0 = 0;
        r7.h(false);
        r7.p(false);
        ViewPager r1 = this.a.i;
        if (r1 == null) goto L7;
        r0 = r1.getCurrentItem();
    L7:
        h83.f r2 = this.b;
        Integer r3 = null;
        if (r2 == null) goto L12;
        List<String> r4 = r2.b;
        if (r4 == null) goto L12;
        String r5 = (String) CollectionsKt.getOrNull(r4, r0);
    L13:
        StringBuilder r8 = new StringBuilder();
        r8.append(r0 + 1);
        r8.append('/');
        h83.f r9 = this.b;
        if (r9 == null) goto L18;
        List<String> r10 = r9.b;
        if (r10 == null) goto L18;
        r3 = Integer.valueOf(r10.size());
    L18:
        r8.append(r3);
        r7.k(true, r5, r8.toString());
        ViewPager r11 = this.a.i;
        if (r11 == null) goto L23;
        r11.post(new a(r7, r0, this));
        return;
    L23:
        return;
    L12:
        r5 = null;
        goto L13
    }

    public o(p r1, h83.f r2) {
        this.a = r1;
        this.b = r2;
    }
}
