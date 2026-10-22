package tb2;

import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<c> f545242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public yb2.a f545243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b5 f545244c;

    public d() {
        this.f545242a = new ArrayList();
    }

    public final d a(Function1<? super d, d> r100) {
        Intrinsics.checkNotNullParameter(r100, "f");
        return r100.invoke(this);
    }

    public final void b(List r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f545242a.addAll(r100);
    }

    public final void c(c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f545242a.add(r100);
    }

    public final void d(List r100) {
        this.f545242a.addAll(0, r100);
    }

    public final void e(c r100) {
        ListProtector.add(this.f545242a, 0, r100);
    }
}
