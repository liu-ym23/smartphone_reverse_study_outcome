package hm0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import h71.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class a<Session> implements f.a<Session> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Session f485711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f<Session>> f485712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f485713c;

    @Override // h71.f.a
    public final Session d() {
        return this.f485711a;
    }

    @Override // h71.f.a
    public final void a(Session r100) {
        if (this.f485713c >= this.f485712b.size()) goto L7;
        ((f) ListProtector.get(this.f485712b, this.f485713c)).a(new a(r100, this.f485712b, this.f485713c + 1));
        return;
    L7:
        throw new AssertionError("index out of size, AbsProcessChain is " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Session r100, List<? extends f<Session>> r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "processors");
        this.f485711a = r100;
        this.f485712b = r101;
        this.f485713c = r102;
    }
}
