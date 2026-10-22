package kz8;

import android.os.SystemClock;
import com.larus.im.d;
import com.larus.im.internal.core.conversation.FtsSearchParam;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f506763a = 0;

    static {
    }

    public static Object a(String r110, long r210, String r211, List r212, String r213, Continuation r214) {
        SafeContinuation r100 = new SafeContinuation(IntrinsicsKt.intercepted(r214));
        FLogger.f375446a.i("MessageSearch", "searchMessage start");
        long r101 = SystemClock.elapsedRealtime();
        NativeMessageServiceImpl r102 = d.e();
        z2 r103 = z2.f365865a;
        if (r103.getChatListSearchConfig().f482396c == true) goto L5;
    L7:
        boolean r111 = false;
    L8:
        r102.searchMessageByFts(new FtsSearchParam(r110, true, r210, 20, r111, r211, r212, null, null, 384, null), new a(r101, r213, r100));
        Object r104 = r100.getOrThrow();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r214);
    L11:
        return r104;
    L5:
        if (r103.searchForceByLike() == true) goto L7;
        r111 = true;
        goto L8
    }
}
