package wza;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a<Data, BlockData> implements b<Data, BlockData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f561976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i<Data, BlockData> f561977b;

    public abstract i<Data, BlockData> b(g r100);

    @Override // wza.b
    public final j getKey() {
        return this.f561976a;
    }

    public a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f561976a = r100;
    }

    @Override // wza.b
    public final i<Data, BlockData> a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        i<Data, BlockData> r101 = this.f561977b;
        if (r101 == null) goto L6;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("block");
        return null;
    L8:
        return r101;
    L6:
        i<Data, BlockData> r102 = b(r100);
        this.f561977b = r102;
        return r102;
    }
}
