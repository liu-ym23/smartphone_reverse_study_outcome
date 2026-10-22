package t6b;

import com.ss.android.lark.biz.im.api.m1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m1 f544789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<e.b<?>> f544790d;

    @Override // t6b.e
    public final jya.b d() {
        return null;
    }

    @Override // t6b.e
    public final List<e.b<?>> c() {
        return this.f544790d;
    }

    @Override // t6b.e
    public final m1 e() {
        return this.f544789c;
    }

    public f(e r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        List<e.b<?>> r101 = null;
        super(null, null, null);
        this.f544789c = r100.e();
        r100.d();
        List<e.b<?>> r102 = r100.c();
        if (r102 == null) goto L5;
        r101 = CollectionsKt.toMutableList(r102);
    L5:
        this.f544790d = r101;
    }
}
