package vf3;

import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v96.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.shopping.new_cart.components.a implements com.bytedance.kmp.ec.yata.event.ability.uplink.c {
    public final boolean b;
    public final com.bytedance.android.shopping.new_cart.yata.interceptor.a c;
    public final AtomicLong d;
    public final CartObjectContainer e;

    /* JADX INFO: renamed from: vf3.a$a, reason: collision with other inner class name */
    public static final class C0235a {
    }

    static {
    }

    public final boolean n() {
        AndroidYaTaInstance r0 = (AndroidYaTaInstance) this.e.e.d.invoke();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.i("hit_client_selected");
    L7:
        if ((r2 instanceof Boolean) == false) goto L10;
        r1 = r2;
    L10:
        Boolean r3 = (Boolean) r1;
        if (r3 == null) goto L13;
        boolean r4 = r3.booleanValue();
    L14:
        dm.a.a("cart MultiUpdateImpl").i("checkHitClientSelected: res: " + r4 + ", enable: " + this.b);
        return r4;
    L13:
        r4 = false;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    public final long o() {
        long r0 = this.d.addAndGet(1);
        dm.a.a("cart MultiUpdateImpl").i("getNextVersion res: " + r0);
        return r0;
    }

    public final void q() {
        dm.a.a("cart MultiUpdateImpl").i("do rollBack");
        com.bytedance.android.shopping.new_cart.yata.interceptor.a r0 = this.c;
        r0.getClass();
        dm.a.a("RollBackImpl").i("rollBack: " + ((Number) r0.a.get().getFirst()).longValue());
        aa6.b r1 = r0.b.get();
        if (r1 == null) goto L5;
        ((AndroidYaTaInstance) r0.c.e.d.invoke()).x(r1, aa6.a.a.b, null, null);
    L5:
        Pair<Long, e> r2 = r0.a.get();
        if (r2 == null) goto L11;
        e r3 = (e) r2.getSecond();
        if (r3 == null) goto L12;
        ((AndroidYaTaInstance) r0.c.e.d.invoke()).x(r3.g(), aa6.a.b.b.b, null, f.b(r3));
        return;
    L12:
        return;
    }

    public a(CartObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        super(r3);
        this.e = r3;
        this.b = true;
        this.c = new com.bytedance.android.shopping.new_cart.yata.interceptor.a(r3);
        this.d = new AtomicLong(0);
    }

    public final com.bytedance.kmp.ec.yata.event.ability.uplink.b d(com.bytedance.kmp.ec.yata.event.ability.uplink.a r14) {
        Intrinsics.checkNotNullParameter(r14, "info");
        j r1 = r14.b;
        e r2 = r14.c;
        dm.a.b r4 = dm.a.a("cart MultiUpdateImpl");
        StringBuilder r5 = new StringBuilder("handleResponse: nowVersion:  ");
        Map r6 = r1.b;
        if (r6 == null) goto L5;
        Object r7 = r6.get("uplink_version");
    L6:
        r5.append(com.bytedance.android.ecom.arch.slice.render.util.b.l(r7, Long.MIN_VALUE));
        r5.append(", trigger: ");
        r5.append(r14.a.i());
        r5.append("，enable: ");
        r5.append(this.b);
        r5.append(", hitClick: ");
        r5.append(n());
        r4.i(r5.toString());
        boolean r8 = true;
        if (this.b == true) goto L11;
        Intrinsics.checkNotNullParameter(r14, "info");
        return new com.bytedance.kmp.ec.yata.event.ability.uplink.b(true);
    L11:
        if (n() == true) goto L14;
        Intrinsics.checkNotNullParameter(r14, "info");
        return new com.bytedance.kmp.ec.yata.event.ability.uplink.b(true);
    L14:
        Map r15 = r1.b;
        if (r15 == null) goto L17;
        Object r16 = r15.get("uplink_version");
    L18:
        long r0 = com.bytedance.android.ecom.arch.slice.render.util.b.l(r16, Long.MIN_VALUE);
        if (r0 == this.d.get()) goto L23;
        r8 = false;
    L23:
        if ((r2 instanceof e) == true) goto L25;
        r2 = null;
    L25:
        r(r0, r2);
        dm.a.a("cart MultiUpdateImpl").i("handleResponse res: isValid: " + r8);
        return new com.bytedance.kmp.ec.yata.event.ability.uplink.b(r8);
    L17:
        r16 = null;
        goto L18
    L5:
        r7 = null;
        goto L6
    }

    public final boolean p(long r8, e r10) {
        dm.a.a("cart MultiUpdateImpl").i("handleQueryResponse version: " + r8 + "，enable: " + this.b + ", hitClick: " + n());
        boolean r2 = true;
        if (this.b == true) goto L6;
        return true;
    L6:
        if (n() == true) goto L9;
        return true;
    L9:
        if (r8 == this.d.get()) goto L12;
        r2 = false;
    L12:
        r(r8, r10);
        dm.a.a("cart MultiUpdateImpl").i("handleQueryResponse res: valid: " + r2 + ", version: " + r8 + "，enable: " + this.b + ", hitClick: " + n());
        return r2;
    }

    public final void r(long r7, e r9) {
        dm.a.b r0 = dm.a.a("cart MultiUpdateImpl");
        StringBuilder r1 = new StringBuilder("storeResponseIfVersionNewer: version: ");
        r1.append(r7);
        r1.append("，enable: ");
        r1.append(this.b);
        r1.append(", success: ");
        if (r9 == null) goto L5;
        Boolean r2 = Boolean.valueOf(f.d(r9));
    L6:
        r1.append(r2);
        r0.i(r1.toString());
        if (r9 != null) goto L9;
        return;
    L9:
        if (f.d(r9) != true) goto L19;
        com.bytedance.android.shopping.new_cart.yata.interceptor.a r3 = this.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "resp");
        dm.a.a("RollBackImpl").i("onReceiveResponse: " + r7 + ", " + r3.a() + ", " + f.d(r9));
        if (r7 > r3.a()) goto L14;
        return;
    L14:
        if (f.d(r9) == false) goto L21;
        r3.a.getAndSet(new Pair(Long.valueOf(r7), r9));
        return;
    L21:
        return;
    L19:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
