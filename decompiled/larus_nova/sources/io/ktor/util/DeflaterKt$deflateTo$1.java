package io.ktor.util;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {72, 77, 82, 88, 91}, m = "deflateTo", n = {"$this$deflateTo", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "pool", "crc", "deflater", "input", "compressed", DownloadHelper.GZIP, "$this$deflateTo", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "pool", "crc", "deflater", "input", "compressed", DownloadHelper.GZIP, "$this$deflateTo", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "pool", "crc", "deflater", "input", "compressed", DownloadHelper.GZIP, com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "pool", "crc", "deflater", "input", "compressed", DownloadHelper.GZIP, "pool", "deflater", "input", "compressed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3"})
final class DeflaterKt$deflateTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public DeflaterKt$deflateTo$1(Continuation<? super DeflaterKt$deflateTo$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DeflaterKt.a(null, null, false, null, this);
    }
}
