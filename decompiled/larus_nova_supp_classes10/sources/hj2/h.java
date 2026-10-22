package hj2;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends ij2.d {
    public final e d;
    public final c e;
    public final b f;
    public final g g;
    public final f h;
    public final a i;
    public final d j;

    public h(Context r2, LivePromotionCardArgs r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "argument");
        super(r2);
        this.d = new e(r3);
        this.e = new c(r3);
        this.f = new b(r3);
        this.g = new g();
        this.h = new f(r3);
        this.i = new a();
        this.j = new d(r3);
    }

    public static ij2.c a(com.bytedance.android.ec.common.api.jump.model.e r2, List r3) {
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (((ij2.c) r0).b(r2) == false) goto L4;
    L10:
        return (ij2.c) r0;
    L8:
        r0 = null;
        goto L10
    }
}
