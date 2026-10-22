package rk2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.a0;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIAction;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends e {
    public ViewGroup n;
    public ViewGroup o;

    public final String b() {
        return "EXPLAIN_CARD";
    }

    public final int j(QModel r1) {
        return 4;
    }

    public final QIPresenter h() {
        return new a0();
    }

    public final List<QUIModule> i() {
        View r1 = null;
        if (getContext() == null) goto L25;
        e[] r0 = new e[6];
        a r2 = new a();
        r2.l = k(2131560684, this.n);
        Unit r3 = Unit.INSTANCE;
        r0[0] = r2;
        d r4 = new d();
        ViewGroup r5 = this.o;
        if (r5 == null) goto L7;
        View r6 = r5.findViewById(2131370727);
    L8:
        r4.l = r6;
        r0[1] = r4;
        m r7 = new m();
        ViewGroup r8 = this.o;
        if (r8 == null) goto L11;
        View r9 = r8.findViewById(2131370729);
    L12:
        r7.l = r9;
        r0[2] = r7;
        k r10 = new k(false);
        ViewGroup r11 = this.o;
        if (r11 == null) goto L15;
        View r12 = r11.findViewById(2131377583);
    L16:
        r10.l = r12;
        r0[3] = r10;
        f r13 = new f();
        ViewGroup r14 = this.o;
        if (r14 == null) goto L19;
        View r15 = r14.findViewById(2131370506);
    L20:
        r13.l = r15;
        r0[4] = r13;
        i r16 = new i();
        ViewGroup r17 = this.o;
        if (r17 == null) goto L23;
        r1 = r17.findViewById(2131372727);
    L23:
        r16.l = r1;
        r0[5] = r16;
        return CollectionsKt.listOf(r0);
    L19:
        r15 = null;
        goto L20
    L15:
        r12 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    L25:
        return null;
    }

    public l() {
    }

    public final QUIAction c(ArrayList r2) {
        Intrinsics.checkNotNullParameter(r2, "conflictModule");
        return QUIAction.REPLACE;
    }

    @Override // rk2.e
    public final void e(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.m = r5;
        LinearLayout r0 = new LinearLayout(r5);
        r0.setOrientation(1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        FrameLayout r1 = new FrameLayout(r5);
        this.n = r1;
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Unit r6 = Unit.INSTANCE;
        r0.addView(r1);
        View r7 = k(2131560682, r0);
        if ((r7 instanceof ViewGroup) == true) goto L5;
        r7 = null;
    L5:
        this.o = (ViewGroup) r7;
        this.l = r0;
    }

    public final View k(int r7, View r8) {
        boolean r0 = r8 instanceof ViewGroup;
        if (r0 == true) goto L5;
        View r2 = null;
    L6:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L16;
        ShoppingAsyncInflater.a r4 = ShoppingAsyncInflater.e;
        Context r5 = a().b;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L11:
        Context r6 = th.a.e(r5, true);
        r4.getClass();
        ShoppingAsyncInflater r9 = ShoppingAsyncInflater.a.a(r6);
        if (r0 == true) goto L14;
        r8 = null;
    L14:
        View r1 = com.bytedance.android.ec.opt.asyncInflate.c.a(r9, r7, (ViewGroup) r8, 4);
        r3.addView(r1);
        return r1;
    L16:
        return null;
    L5:
        r2 = r8;
        goto L6
    }
}
