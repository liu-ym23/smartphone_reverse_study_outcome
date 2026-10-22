package com.bytedance.android.shopping.deepfeed.ui.ability;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.deepfeed.viewmodel.c;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tc3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public ConstraintLayout a;
    public View b;
    public View c;
    public View d;
    public View e;
    public TextView f;
    public TextView g;
    public boolean h;
    public final View i;
    public final c j;
    public final Context k;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.ui.ability.a$a, reason: collision with other inner class name */
    public static final class C0060a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            TextView r4 = this.a.g;
            if (r4 == null) goto L5;
            r4.setText("刷新中、请耐心等待");
        L5:
            TextView r5 = this.a.f;
            if (r5 == null) goto L8;
            r5.setText("刷新");
        L8:
            a r6 = this.a;
            r6.j.loadProductPack(DeepFeedNetErrorAbility$reloadProduct$1.INSTANCE);
            r6.j.loadProductFeed(null);
        }
    }

    static {
    }

    public final void a() {
        Lazy r0 = DeepFeedFoldHelper.a;
        Context r1 = this.k;
        if (r1 == null) goto L5;
        Activity r2 = ECHybridExtensionsKt.a(r1);
    L6:
        DeepFeedFoldHelper.b(r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void b() {
        if (this.h == true) goto L57;
        this.h = true;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L47
        View r2 = this.i;     // Catch: Throwable -> L47
        View r3 = null;
        if (r2 == null) goto L8;
        ViewStub r4 = (ViewStub) r2.findViewById(2131368684);     // Catch: Throwable -> L47
    L9:
        View r5 = this.i;     // Catch: Throwable -> L47
        if (r5 == null) goto L12;
        View r6 = r5.findViewById(2131376076);     // Catch: Throwable -> L47
    L13:
        this.c = r6;     // Catch: Throwable -> L47
        View r7 = this.i;     // Catch: Throwable -> L47
        if (r7 == null) goto L16;
        View r8 = r7.findViewById(2131365241);     // Catch: Throwable -> L47
    L17:
        this.d = r8;     // Catch: Throwable -> L47
        View r9 = this.i;     // Catch: Throwable -> L47
        if (r9 == null) goto L20;
        View r10 = r9.findViewById(2131376252);     // Catch: Throwable -> L47
    L21:
        this.e = r10;     // Catch: Throwable -> L47
        if (r4 == null) goto L24;
        View r11 = r4.inflate();     // Catch: Throwable -> L47
    L26:
        if ((r11 instanceof ConstraintLayout) == true) goto L28;
        r11 = null;
    L28:
        ConstraintLayout r12 = (ConstraintLayout) r11;     // Catch: Throwable -> L47
        this.a = r12;     // Catch: Throwable -> L47
        if (r12 == null) goto L31;
        TextView r13 = (TextView) r12.findViewById(2131368686);     // Catch: Throwable -> L47
    L32:
        this.f = r13;     // Catch: Throwable -> L47
        ConstraintLayout r14 = this.a;     // Catch: Throwable -> L47
        if (r14 == null) goto L35;
        TextView r15 = (TextView) r14.findViewById(2131368687);     // Catch: Throwable -> L47
    L36:
        this.g = r15;     // Catch: Throwable -> L47
        ConstraintLayout r16 = this.a;     // Catch: Throwable -> L47
        if (r16 == null) goto L39;
        r3 = r16.findViewById(2131368685);     // Catch: Throwable -> L47
    L39:
        this.b = r3;     // Catch: Throwable -> L47
        ConstraintLayout r17 = this.a;     // Catch: Throwable -> L47
        if (r17 == null) goto L42;
        r17.setClickable(true);     // Catch: Throwable -> L47
    L42:
        View r0 = this.b;     // Catch: Throwable -> L47
        if (r0 == null) goto L45;
        r0.setOnClickListener(new b(this));     // Catch: Throwable -> L47
    L45:
        a();     // Catch: Throwable -> L47
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L50:
        if (Result.exceptionOrNull-impl(r18) == null) goto L58;
        ConstraintLayout r19 = this.a;
        if (r19 == null) goto L59;
        ExtensionsKt.gone(r19);
        return;
    L59:
        return;
    L58:
        return;
    L35:
        r15 = null;
        goto L36
    L31:
        r13 = null;
        goto L32
    L24:
        r11 = null;
        goto L26
    L20:
        r10 = null;
        goto L21
    L16:
        r8 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    L8:
        r4 = null;
    L47:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    }

    public final void c() {
        b();
        ConstraintLayout r0 = this.a;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        if (f.b() == false) goto L13;
        View r1 = this.d;
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        View r2 = this.c;
        if (r2 == null) goto L17;
        r2.setVisibility(8);
        return;
    L17:
        return;
    L13:
        View r3 = this.c;
        if (r3 == null) goto L19;
        r3.setVisibility(8);
        return;
    }

    public a(View r2, DeepFeedProductViewModel r3, FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        this.i = r2;
        this.j = r3;
        this.k = r4;
    }
}
