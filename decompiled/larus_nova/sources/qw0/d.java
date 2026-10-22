package qw0;

import com.bytedance.android.scope.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements o, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Object, rw0.a> f534956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f534957b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // qw0.a
    public final Map<Object, rw0.a> S0() {
        return this.f534956a;
    }

    public d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "roomService");
        this.f534957b = r100;
        this.f534956a = new HashMap();
    }

    @Override // qw0.a
    public final rw0.a Kc(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f534956a.get(r100);
    }

    @Override // qw0.a
    public final void Ue(Object r100, rw0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "filter");
        this.f534956a.put(r100, r101);
    }
}
