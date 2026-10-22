package rw0;

import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.u;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f539562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f539563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f539564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f539565e;

    public f(i r110) {
        Intrinsics.checkNotNullParameter(r110, "dealSet");
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.c().iterator();
        char r102 = 0;
        long r103 = 0;
        int r104 = 0;
        boolean r111 = false;
    L3:
        boolean r112 = true;
        if (r101.hasNext() == false) goto L19;
        u r113 = (u) r101.next();
        Pair[] r114 = new Pair[3];
        r114[r102] = TuplesKt.to("money", String.valueOf(r113.f89766d));
        r114[1] = TuplesKt.to("given_scores", String.valueOf(r113.f89767e));
        r114[2] = TuplesKt.to("money_paid", String.valueOf(r113.f89765c));
        r100.add(MapsKt.mapOf(r114));
        Long r105 = Long.valueOf(r110.l());
        long r115 = r103;
        if (r105.longValue() == r113.f89764b) goto L9;
        r112 = false;
    L9:
        if (r112 == false) goto L11;
        Long r116 = r105;
    L12:
        if (r116 == null) goto L14;
        r116.longValue();
        this.f539565e = r113;
        r103 = r113.f89765c;
        r111 = r113.f89770h;
    L15:
        int r106 = r113.f89767e;
        if (r106 <= 0) goto L18;
        r104 = r106;
    L18:
        r102 = 0;
        goto L3
    L14:
        r103 = r115;
        goto L15
    L11:
        r116 = null;
        goto L12
    L19:
        long r117 = r103;
        if (r117 != 0) goto L36;
        Iterator<T> r107 = r110.c().iterator();
    L23:
        if (r107.hasNext() == false) goto L30;
        Object r108 = r107.next();
        if (((u) r108).f89764b != r110.d()) goto L27;
        boolean r109 = true;
    L28:
        if (r109 == false) goto L23;
        Object r118 = r108;
    L31:
        u r119 = (u) r118;
        this.f539565e = r119;
        if (r119 == null) goto L34;
        long r120 = r119.f89765c;
    L35:
        long r121 = r120;
    L37:
        this.f539563c = r111;
        this.f539561a = r100.toString();
        this.f539562b = r121;
        this.f539564d = r104;
        return;
    L34:
        r120 = 0;
        goto L35
    L27:
        r109 = false;
        goto L28
    L30:
        r118 = null;
        goto L31
    L36:
        r121 = r117;
        goto L37
    }
}
