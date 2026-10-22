package com.bytedance.awemeopen.apps.framework.profile.works;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements RecentlySeeHelper.a {
    public final /* synthetic */ RecentlySeeHelper a;
    public final /* synthetic */ View b;

    @Override // com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper.a
    public final void a() {
        ToastUtils.b(this.b.getContext(), 2131894141);
        RecentlySeeHelper r0 = this.a;
        r0.o = false;
        r0.f();
        RecentlySeeHelper r1 = this.a;
        r1.k = false;
        ViewGroup r2 = r1.c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        r2 = null;
    L5:
        x54.b.b(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper.a
    public final void onFail() {
        RecentlySeeHelper r0 = this.a;
        r0.o = false;
        r0.f();
    }

    public e(RecentlySeeHelper r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper.a
    public final void onSuccess(List<jz3.a> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "data");
        RecentlySeeHelper r0 = this.a;
        r0.j = RecentlySeeHelper.b(r5, r0.i);
        RecentlySeeHelper r7 = this.a;
        ViewGroup r3 = null;
        ViewGroup r4 = null;
        TextView r8 = null;
        if (r7.j < 0) goto L14;
        TextView r9 = r7.d;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r9 = null;
    L7:
        r9.setText(2131894269);
        ViewGroup r10 = this.a.c;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
    L12:
        if (x54.b.c(r4) == false) goto L26;
        RecentlySeeHelper r11 = this.a;
        r11.o = true;
        r11.c(r11.j);
    L26:
        this.a.f();
        return;
    L10:
        r4 = r10;
        goto L12
    L14:
        r7.o = false;
        if (r6 == false) goto L21;
        TextView r12 = r7.d;
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L20:
        r8.setText(2131894270);
        ToastUtils.b(this.b.getContext(), 2131894142);
        goto L26
    L19:
        r8 = r12;
        goto L20
    L21:
        ToastUtils.b(this.b.getContext(), 2131894141);
        RecentlySeeHelper r13 = this.a;
        r13.k = false;
        ViewGroup r14 = r13.c;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
    L25:
        x54.b.b(r3);
        goto L26
    L24:
        r3 = r14;
        goto L25
    }
}
