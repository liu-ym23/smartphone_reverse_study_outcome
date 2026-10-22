package com.larus.dora.impl.file;

import android.os.SystemClock;
import androidx.collection.SieveCacheKt;
import com.bytedance.dora.file.DoraInterruptLogFileReason;
import com.google.gson.reflect.TypeToken;
import com.larus.dora.impl.core.request.v2.DoraRequestXV2;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraFileRemoteStreamer implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f335701a = 0;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<m> {
        public b() {
        }
    }

    static {
    }

    public DoraFileRemoteStreamer() {
    }

    @Override // com.larus.dora.impl.file.v
    public final Object a(String r100, DoraInterruptLogFileReason r101, Continuation<? super Unit> r102) {
        Object r103 = e(new xj4.e(r100, r101), 3000, r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00cf -> B:49:0x0122). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0115 -> B:48:0x0118). Please report as a decompilation issue!!! */
    @Override // com.larus.dora.impl.file.v
    public final Object b(String r110, int r111, Continuation<? super Boolean> r210) {
        if ((r210 instanceof DoraFileRemoteStreamer$fileReceivedAckWithRetry$1) == false) goto L7;
        DoraFileRemoteStreamer$fileReceivedAckWithRetry$1 r100 = (DoraFileRemoteStreamer$fileReceivedAckWithRetry$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        DoraFileRemoteStreamer r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        int r106 = 1;
        String r107 = " for fileName=";
        String r108 = "DoraFileRemoteStreamer";
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        int r109 = r100.I$2;
        int r112 = r100.I$1;
        int r113 = r100.I$0;
        xj4.b r114 = (xj4.b) r100.L$1;
        String r115 = (String) r100.L$0;
        ResultKt.throwOnFailure(r103);
        DoraFileRemoteStreamer r116 = r102;
    L48:
        String r117 = r107;
        DoraFileRemoteStreamer$fileReceivedAckWithRetry$1 r118 = r100;
        int r119 = r113;
        String r120 = r108;
        Object r121 = r104;
        xj4.b r122 = r114;
        String r123 = r115;
        int r124 = r109;
        String r125 = r123;
    L49:
        int r126 = r112 + 1;
        String r127 = r117;
        r106 = 1;
    L21:
        if (r126 > r119) goto L50;
        if (r124 != 0) goto L50;
        r118.L$0 = r125;     // Catch: Throwable -> L43
        r118.L$1 = r122;     // Catch: Throwable -> L43
        r118.I$0 = r119;     // Catch: Throwable -> L43
        r118.I$1 = r126;     // Catch: Throwable -> L43
        r118.I$2 = r124;     // Catch: Throwable -> L43
        r118.label = r106;     // Catch: Throwable -> L43
        r103 = r116.e(r122, 3000, r118);     // Catch: Throwable -> L43
        if (r103 != r121) goto L26;
        return r121;
    L26:
        String r128 = r120;
        r113 = r119;
        r100 = r118;
        r107 = r127;
        r112 = r126;
        r114 = r122;
        r104 = r121;
        r108 = r128;
        int r129 = r124;
        r115 = r125;
        r109 = r129;
    L62:
        m r130 = (m) r103;     // Catch: Throwable -> L41
        if (r130 == null) goto L36;
        Integer r131 = r130.b();     // Catch: Throwable -> L41
        if (r131 == null) goto L36;
        if (r131.intValue() != 0) goto L36;
        if (1 == 0) goto L48;
    L36:
        if (0 == 0) goto L48;
        g49.d.d(r108, "fileReceivedAckWithRetry: success on attempt=" + r112 + r107 + r115);     // Catch: Throwable -> L39
        r117 = r107;
        r125 = r115;
        r124 = 1;
        r118 = r100;
        r119 = r113;
        r120 = r108;
        r121 = r104;
        r122 = r114;
    L39:
        Throwable th10 = th;
        r109 = 1;
    L45:
        g49.d.c(r108, "fileReceivedAckWithRetry: failed on attempt=" + r112 + r107 + r115, th10);
        r100.L$0 = r115;
        r100.L$1 = r114;
        r100.I$0 = r113;
        r100.I$1 = r112;
        r100.I$2 = r109;
        r100.label = 2;
        if (DelayKt.delay(100, r100) != r104) goto L48;
        return r104;
    L41:
        th10 = th;
    L43:
        th10 = th;
        String r132 = r120;
        r113 = r119;
        r100 = r118;
        r107 = r127;
        r112 = r126;
        r114 = r122;
        r104 = r121;
        r108 = r132;
        int r133 = r124;
        r115 = r125;
        r109 = r133;
    L50:
        boolean r134 = true;
        if (r124 != 0) goto L53;
        g49.d.b(r120, "fileReceivedAckWithRetry: failed after " + r119 + " retries for fileName=" + r125);
    L53:
        if (r124 != 0) goto L57;
        r134 = false;
    L57:
        return Boxing.boxBoolean(r134);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r109 = r100.I$2;
        r112 = r100.I$1;
        r113 = r100.I$0;
        r114 = (xj4.b) r100.L$1;
        r115 = (String) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L18
        r116 = r102;
    L18:
        th10 = th;
        r116 = r102;
        goto L45
    L20:
        ResultKt.throwOnFailure(r103);
        r125 = r110;
        r116 = r102;
        r127 = " for fileName=";
        r120 = "DoraFileRemoteStreamer";
        r126 = 0;
        r124 = 0;
        r118 = r100;
        r121 = r104;
        r119 = r111;
        r122 = new xj4.b(r125);
    L7:
        r102 = this;
        r100 = new DoraFileRemoteStreamer$fileReceivedAckWithRetry$1(r102, r210);
        goto L8
    }

    @Override // com.larus.dora.impl.file.v
    public final Object c(long r100, String r101, long r102) {
        g49.d.d("DoraFileRemoteStreamer", "start: dataId=" + r100 + ", fileName=" + r101 + ", offset=" + r102);
        return Boxing.boxInt(vj4.b.a.f555417a.b((int) r100, new xj4.c(r101, r102)));
    }

    public final Object e(xj4.a r100, long r101, Continuation<? super m> r110) {
        if ((r110 instanceof DoraFileRemoteStreamer$sendEvent$1) == false) goto L7;
        DoraFileRemoteStreamer$sendEvent$1 r102 = (DoraFileRemoteStreamer$sendEvent$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        w39.a r106 = (w39.a) r102.L$1;
        xj4.a r107 = (xj4.a) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L18:
        com.larus.dora.impl.core.request.v2.a r112 = (com.larus.dora.impl.core.request.v2.a) r111;
        if ((r112 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L39;
        g49.d.b("DoraRequestXV2", "request<T>: failed, " + r112);
        Result.Companion r108 = Result.Companion;
        Object r109 = Result.m9449constructorimpl(ResultKt.createFailure(new Exception("Request failed: " + r112)));
    L29:
        if (Result.m9456isSuccessimpl(r109) == false) goto L31;
        g49.d.d("DoraFileRemoteStreamer", "sendEvent: " + r107 + " success, response=" + ((m) r109));
    L31:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r109);
        if (r113 == null) goto L35;
        g49.d.c("DoraFileRemoteStreamer", "sendEvent: " + r107 + " failed", r113);
    L35:
        if (Result.m9455isFailureimpl(r109) == false) goto L41;
        return null;
    L41:
        return r109;
    L39:
        Type r114 = new b().getType();     // Catch: Throwable -> L25
        byte[] r115 = ((com.larus.dora.impl.core.request.v2.a.b) r112).f332256a;     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L25
        Object r116 = r106.a(r115, r114);     // Catch: Throwable -> L25
        if (r116 != null) goto L23;
        g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L25
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L25
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L25
    L38:
        goto L29
    L23:
        r109 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        g49.d.c("DoraRequestXV2", "request<T>: parse error", th);
        Result.Companion r118 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        g49.d.d("DoraFileRemoteStreamer", "sendEvent: " + r100);
        DoraRequestXV2 r119 = DoraRequestXV2.f332240a;
        Lazy<w39.d> r120 = w39.d.f558188b;
        w39.d r121 = w39.d.a.a();
        r102.L$0 = r100;
        r102.L$1 = r121;
        r102.label = 1;
        r111 = r119.a(r100, r101, r102);
        if (r111 != r104) goto L17;
        return r104;
    L17:
        r107 = r100;
        r106 = r121;
    L7:
        r102 = new DoraFileRemoteStreamer$sendEvent$1(this, r110);
        goto L8
    }

    public final Object d(int r110, String r111, String r112, Continuation<? super List<l>> r113) {
        if ((r113 instanceof DoraFileRemoteStreamer$getFileInfoList$1) == false) goto L7;
        DoraFileRemoteStreamer$getFileInfoList$1 r100 = (DoraFileRemoteStreamer$getFileInfoList$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        int r104 = 0;
        boolean r105 = true;
        int r106 = 2;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r115 = r100.J$0;
        int r116 = r100.I$0;
        String r107 = (String) r100.L$1;
        String r108 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L23:
        m r117 = (m) r114;
        com.larus.dora.impl.file.a r109 = f.f335741a;
        long r118 = SystemClock.elapsedRealtime() - r115;
        if (r117 == null) goto L26;
        r106 = 1;
    L26:
        Intrinsics.checkNotNullParameter(r108, "transportType");
        Intrinsics.checkNotNullParameter(r107, "fetchFrom");
        LinkedHashMap r119 = new LinkedHashMap();
        if (r108 != null) goto L29;
    L32:
        boolean r120 = true;
    L34:
        if (r120 == false) goto L36;
        r108 = "unknown";
    L36:
        r119.put("transport_type", r108);
        if (r107 != null) goto L39;
    L42:
        if (r105 == false) goto L44;
        r107 = "unknown";
    L44:
        r119.put("fetch_from", r107);
        r119.put("file_type", Integer.valueOf(r116));
        Long r121 = Long.valueOf(r118);
        if (r121 != null) goto L47;
    L50:
        r119.put("duration", Integer.valueOf(r104));
        r119.put("result", Integer.valueOf(r106));
        f.b("d_file_fetch_list", r119);
        List<l> r122 = null;
        if (r117 == null) goto L55;
        k r123 = r117.a();
        if (r123 == null) goto L55;
        List<l> r124 = r123.b();
    L56:
        if (r124 != null) goto L58;
        r124 = CollectionsKt.emptyList();
    L58:
        List<l> r125 = r124;
        if (r117 == null) goto L63;
        k r126 = r117.a();
        if (r126 == null) goto L63;
        List<l> r127 = r126.a();
    L64:
        if (r127 != null) goto L66;
        r127 = CollectionsKt.emptyList();
    L66:
        List r128 = CollectionsKt.plus(r125, r127);
        if (r117 == null) goto L71;
        k r129 = r117.a();
        if (r129 == null) goto L71;
        r122 = r129.c();
    L71:
        if (r122 != null) goto L74;
        r122 = CollectionsKt.emptyList();
    L74:
        return CollectionsKt.filterNotNull(CollectionsKt.plus(r128, r122));
    L63:
        r127 = null;
    L55:
        r124 = null;
        goto L56
    L47:
        if (r121.longValue() < 0) goto L50;
        r104 = (int) RangesKt.coerceAtMost(r121.longValue(), SieveCacheKt.NodeLinkMask);
        goto L50
    L39:
        if (StringsKt.isBlank(r107) == true) goto L42;
        r105 = false;
        goto L42
    L29:
        if (StringsKt.isBlank(r108) == true) goto L32;
        r120 = false;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        long r130 = SystemClock.elapsedRealtime();
        xj4.a r131 = new xj4.d(new int[]{r110});
        if (r110 == 1) goto L18;
        if (r110 == 2) goto L18;
        long r132 = 60000;
    L19:
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.I$0 = r110;
        r100.J$0 = r130;
        r100.label = 1;
        r114 = e(r131, r132, r100);
        if (r114 != r102) goto L22;
        return r102;
    L22:
        r108 = r111;
        r107 = r112;
        r116 = r110;
        r115 = r130;
    L18:
        r132 = 10000;
    L7:
        r100 = new DoraFileRemoteStreamer$getFileInfoList$1(this, r113);
        goto L8
    }
}
