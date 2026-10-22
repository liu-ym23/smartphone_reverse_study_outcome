package io.ktor.client.plugins.cache;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.ktor.http.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class HttpCache$findResponse$requestHeaders$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public HttpCache$findResponse$requestHeaders$1(Object r100) {
        super(1, r100, n.class, MonitorConstants.CONNECT_TYPE_GET, "get(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return ((n) this.receiver).get(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }
}
