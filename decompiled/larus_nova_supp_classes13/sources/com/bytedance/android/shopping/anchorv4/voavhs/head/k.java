package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class k implements d83.c {
    public final d83.b a;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Function1 b;

        public a(View r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            int[] r10 = new int[2];
            this.a.getLocationOnScreen(r10);
            int r11 = r10[0];
            Rect r12 = new Rect(r11, r10[1], this.a.getWidth() + r11, r10[1] + this.a.getHeight());
            this.b.invoke(Result.box-impl(Result.constructor-impl(r12)));
        }
    }

    @Override // d83.c
    public final boolean J() {
        return ViewCompat.isAttachedToWindow(this.a.e());
    }

    @Override // d83.c
    public final boolean a() {
        return this.a.a();
    }

    @Override // d83.c
    public final List<ECUrlModel> c() {
        return this.a.c();
    }

    @Override // d83.c
    public final void d() {
        this.a.d();
    }

    @Override // d83.c
    public View e() {
        return this.a.e();
    }

    @Override // d83.c
    public final String f() {
        return this.a.f();
    }

    @Override // d83.c
    public final void onResume() {
        this.a.onResume();
    }

    public k(d83.b r2) {
        Intrinsics.checkNotNullParameter(r2, "headerAbility");
        this.a = r2;
    }

    @Override // d83.c
    public final void D(Function1<? super Result<Rect>, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        View r0 = this.a.h();
        if (r0 != null) goto L7;
        Result.Companion r1 = Result.Companion;
        r8.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception()))));
        return;
    L7:
        if (ViewCompat.isLaidOut(r0) == true) goto L9;
    L11:
        r0.addOnLayoutChangeListener(new a(r0, r8));
        return;
    L9:
        if (r0.isLayoutRequested() == true) goto L11;
        int[] r2 = new int[2];
        r0.getLocationOnScreen(r2);
        int r3 = r2[0];
        r8.invoke(Result.box-impl(Result.constructor-impl(new Rect(r3, r2[1], r0.getWidth() + r3, r2[1] + r0.getHeight()))));
    }

    @Override // d83.c
    public final void b(boolean r2) {
        this.a.b(r2);
    }
}
