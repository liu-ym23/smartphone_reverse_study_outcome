package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.ktvapi.model.mv.h;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvPlayer;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import fd2.f0;
import fd2.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements r {
    public View a;
    public h<?> b;
    public f0 c;
    public Function1<? super TextView, Unit> d;
    public Function1<? super Boolean, Unit> e;

    public c() {
    }

    public final c a(h r2) {
        Intrinsics.checkNotNullParameter(r2, "playerClient");
        this.b = r2;
        return this;
    }

    public final c b(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        this.d = r2;
        return this;
    }

    public final c c(f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "i");
        this.c = r2;
        return this;
    }

    public final void d(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.e = r2;
    }

    public final c f(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a = r2;
        return this;
    }

    public final MVPreViewDialog e(Context r9, Function0 r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "selectedListener");
        f0 r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(LocationMonitorConst.INFO);
    L5:
        String r3 = r0.a;
        f0 r1 = this.c;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(LocationMonitorConst.INFO);
    L8:
        String r4 = r1.b;
        View r5 = this.a;
        h<?> r2 = this.b;
        h r6 = r2;
        if (r2 != null) goto L11;
        KtvMvPlayer r7 = new KtvMvPlayer(r9, null);
        r7.o().setIsMute(true);
        Unit r11 = Unit.INSTANCE;
        r6 = r7;
    L11:
        MVPreViewDialog r12 = new MVPreViewDialog(r3, r4, r5, r6, r10);
        r12.h = this.e;
        r12.f = this.d;
        return r12;
    }
}
