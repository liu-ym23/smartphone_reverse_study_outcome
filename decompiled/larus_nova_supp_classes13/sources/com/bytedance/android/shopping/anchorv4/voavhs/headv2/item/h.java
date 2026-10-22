package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.d {
    public final /* synthetic */ j a;

    public h(j r1) {
        this.a = r1;
    }

    public final void a(PlayerBlock r4) {
        Intrinsics.checkNotNullParameter(r4, "player");
        j r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "reporter");
        r4.p.remove(r0);
        Function1<Boolean, Unit> r1 = this.a.h;
        Intrinsics.checkNotNullParameter(r1, "listener");
        ((ArrayList) r4.x).remove(r1);
        j r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) r4.y).remove(r2);
        r4.i = null;
        if (r4.getExpandMode() == true) goto L11;
        ViewParent r3 = r4.getParent();
        if ((r3 instanceof ViewGroup) == true) goto L7;
        r3 = null;
    L7:
        ViewGroup r5 = (ViewGroup) r3;
        if (r5 == null) goto L11;
        r5.removeView(r4);
    L11:
        if (Intrinsics.areEqual(r4, this.a.e) == false) goto L14;
        this.a.e = null;
        return;
    }
}
