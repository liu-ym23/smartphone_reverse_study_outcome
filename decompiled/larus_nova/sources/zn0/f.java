package zn0;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedInput;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f<R> extends com.bytedance.frameworks.baselib.netx.chunk.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TypedInput f572904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Converter<TypedInput, R> f572905e;

    public f(TypedInput r100, Converter<TypedInput, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "originalConverter");
        super(r100);
        this.f572904d = r100;
        this.f572905e = r101;
    }
}
