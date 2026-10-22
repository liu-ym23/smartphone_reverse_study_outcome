package com.bytedance.android.window.shop.product.presenter.others;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yo.i;
import zq3.g;
import zq3.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends i<WindowV2ProductItemVO> {
    public s1 l;
    public final WindowLayoutType m;
    public final int n;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.product.presenter.others.b$b, reason: collision with other inner class name */
    public static final class RunnableC0039b implements Runnable {
        public final /* synthetic */ s1 a;

        public RunnableC0039b(s1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void c0() {
        s1 r0 = this.l;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.l = null;
    }

    public final void d0(WindowV2ProductItemVO r6) {
        s1 r0 = this.l;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        Integer r1 = null;
        this.l = null;
        if (r6 == null) goto L8;
        String r2 = r6.N;
    L10:
        if (k.c(r2) == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r2, "red_border") == false) goto L36;
        if (r6 == null) goto L15;
        r6.N = null;
    L15:
        View r3 = a0().findViewById(2131387381);
        if (r3 != null) goto L18;
        r3 = a0();
    L18:
        WindowLayoutType r4 = this.m;
        if (r4 == null) goto L23;
        boolean r5 = true;
        if (r4.isSingleColumn() != true) goto L23;
    L24:
        List<Float> r7 = g.a;
        int r8 = this.n;
        if (r6 == null) goto L27;
        r1 = r6.b();
    L27:
        Float r9 = CollectionsKt.minOrNull(g.a(r8, r5, r1));
        if (r9 == null) goto L30;
        float r10 = r9.floatValue();
    L33:
        s1 r11 = new s1(r3, r10);
        r3.post(new RunnableC0039b(r11));
        Unit r12 = Unit.INSTANCE;
        this.l = r11;
        return;
    L30:
        if (r5 == false) goto L32;
        r10 = 6.0f;
        goto L33
    L32:
        r10 = 8.0f;
    L23:
        r5 = false;
        goto L24
    L36:
        return;
    L8:
        r2 = null;
        goto L10
    }

    public b(Fragment r2, WindowLayoutType r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.m = r3;
        this.n = r4;
    }
}
