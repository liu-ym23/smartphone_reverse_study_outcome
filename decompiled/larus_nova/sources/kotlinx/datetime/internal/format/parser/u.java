package kotlinx.datetime.internal.format.parser;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class u<Output> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<r<Output>> f505342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<u<Output>> f505343b;

    public final String toString() {
        return CollectionsKt.joinToString$default(this.f505342a, ", ", null, null, 0, null, null, 62, null) + '(' + CollectionsKt.joinToString$default(this.f505343b, com.alipay.sdk.m.u.i.f25853b, null, null, 0, null, null, 62, null) + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(List<? extends r<? super Output>> r100, List<? extends u<? super Output>> r101) {
        Intrinsics.checkNotNullParameter(r100, "operations");
        Intrinsics.checkNotNullParameter(r101, "followedBy");
        this.f505342a = r100;
        this.f505343b = r101;
    }
}
