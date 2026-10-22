package io.ktor.client;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/client/engine/e;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/HttpClientConfig;", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/HttpClientConfig;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpClientKt$HttpClient$1 extends Lambda implements Function1 {
    public static final HttpClientKt$HttpClient$1 INSTANCE = null;

    static {
        INSTANCE = new HttpClientKt$HttpClient$1();
    }

    public HttpClientKt$HttpClient$1() {
        super(1);
    }

    public final void invoke(HttpClientConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        invoke((HttpClientConfig) r100);
        return Unit.INSTANCE;
    }
}
