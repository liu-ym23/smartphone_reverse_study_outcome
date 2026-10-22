package e43;

import android.view.View;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.kmp.ec.yata.common.platform.o;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m33.b;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f470978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<com.bytedance.kmp.ec.yata.chain.event.b, Unit> f470979b;

    @Override // m33.b
    public final Map<String, Object> a() {
        Map<String, Object> r100 = this.f470978a.q();
        if (r100 != null) goto L7;
        return null;
    L7:
        return k.b(r100);
    }

    @Override // m33.b
    public final Map<String, Object> c() {
        return k.b(this.f470978a.d());
    }

    public final Map<String, Object> e() {
        c r100 = this.f470978a.j();
        if (r100 == null) goto L7;
        Map<String, Object> r101 = r100.e();
        if (r101 == null) goto L7;
        return k.b(r101);
    L7:
        return null;
    }

    public final String f() {
        c r100 = this.f470978a.j();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getKey();
    }

    public final View g() {
        o r100 = this.f470978a.m();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f251548a;
    }

    @Override // m33.b
    public final e b() {
        return this.f470978a;
    }

    @Override // m33.b
    public final void d(m33.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventResponse");
        if (r100.f511709a == false) goto L5;
        Function1<com.bytedance.kmp.ec.yata.chain.event.b, Unit> r101 = this.f470979b;
        int r102 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(r100.f511711c, r100.f511713e, null, 4));
        return;
    L5:
        Function1<com.bytedance.kmp.ec.yata.chain.event.b, Unit> r103 = this.f470979b;
        int r104 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r103.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(r100.f511711c, r100.f511712d, r100.f511710b, null, r100.f511713e, 40));
    }

    public a(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        this.f470978a = r100;
        this.f470979b = r101;
    }
}
