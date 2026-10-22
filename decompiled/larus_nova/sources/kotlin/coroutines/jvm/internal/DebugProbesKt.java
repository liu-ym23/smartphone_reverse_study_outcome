package kotlin.coroutines.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Classes with same name are omitted, all sources:
  classes.dex
  larus_nova_base.apk:DebugProbesKt.bin
  larus_nova_base.apk:assets/zeus_p/com.obric.aiagent.plugin_150200100:DebugProbesKt.bin
  larus_nova_base.apk:assets/zeus_p/com.obric.memorydata.plugin_150200101:DebugProbesKt.bin
 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001¨\u0006\b"}, d2 = {"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "completion", "probeCoroutineResumed", "", "frame", "probeCoroutineSuspended", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DebugProbesKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "completion");
        return r100;
    }

    public static final void probeCoroutineResumed(Continuation<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
    }

    public static final void probeCoroutineSuspended(Continuation<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
    }
}
