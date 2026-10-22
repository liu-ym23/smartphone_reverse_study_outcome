package io.ktor.client.plugins.cache;

import io.ktor.http.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class HttpCache$findResponse$requestHeaders$2 extends FunctionReferenceImpl implements Function1<String, List<? extends String>> {
    public HttpCache$findResponse$requestHeaders$2(Object r100) {
        super(1, r100, n.class, "getAll", "getAll(Ljava/lang/String;)Ljava/util/List;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<String> invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return ((n) this.receiver).a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends String> invoke(String r100) {
        return invoke2(r100);
    }
}
