package com.larus.im.internal.network.chunk.handler;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.larksuite.component.card.plugin.FetchCardPlugin;
import com.larus.im.internal.database.utils.e;
import com.larus.im.internal.network.chunk.ChunkOperator;
import com.larus.im.internal.network.chunk.data.ChunkParser;
import com.larus.im.internal.protocol.bean.FetchChunkMessageUplinkBody;
import com.larus.im.internal.protocol.bean.UplinkBody;
import com.larus.im.internal.protocol.bean.UplinkMessage;
import com.larus.im.internal.utils.j0;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
public final class ChunkHandler extends com.larus.im.internal.network.chunk.handler.a<UplinkMessage> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f349119e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vt7.a<String, Job> f349120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vt7.a<String, Job> f349121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vt7.a<String, Job> f349122d;

    public static final class a {
    }

    static {
    }

    public ChunkHandler(ChunkOperator.a.C4362a r100) {
        Intrinsics.checkNotNullParameter(r100, "dispatcher");
        super(r100);
        this.f349120b = new vt7.a();
        this.f349121c = new vt7.a();
        this.f349122d = new vt7.a();
    }

    public final void c(String r100) {
        Job r101 = this.f349122d.get(r100);
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        this.f349122d.remove(r100);
    }

    public final void d(String r100) {
        Job r101 = this.f349121c.get(r100);
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        this.f349121c.remove(r100);
    }

    public final void b(UplinkMessage r100, b r101) {
        String r102 = j0.b(r100);
        if (this.f349120b.containsKey(r102) == false) goto L5;
    L12:
        int r103 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("ChunkHandler", "intercept, token(" + r102 + ')');
        return;
    L5:
        if (r102.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L12;
        e.c(new ChunkHandler$fetchChunkInternal$1(r102, this, r100, r101, null));
        return;
    L7:
        r104 = false;
        goto L8
    }

    public final void f(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        int r102 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("ChunkHandler", "cancel " + r100);
        Job r103 = this.f349120b.get(r100);
        if (r103 == null) goto L5;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L5:
        this.f349120b.remove(r100);
    }

    public static final Object a(ChunkHandler r310, String r311, UplinkMessage r410, b r411, Continuation r412) {
        r310.getClass();
        if ((r412 instanceof ChunkHandler$request$1) == false) goto L7;
        ChunkHandler$request$1 r100 = (ChunkHandler$request$1) r412;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ChunkHandler$request$1 r102 = r100;
        Object r103 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L22;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        ResultKt.throwOnFailure(r103);
    L156:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        BufferedSource r105 = (BufferedSource) r102.L$4;
        String r111 = (String) r102.L$3;
        b r112 = (b) r102.L$2;
        UplinkMessage r113 = (UplinkMessage) r102.L$1;
        String r210 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
        String r106 = "ChunkHandler";
        String r114 = r111;
        b r107 = r112;
        UplinkMessage r115 = r113;
        String r116 = r210;
        int r117 = 1;
    L147:
    L81:
        th = th;
        r112 = r107;
    L90:
        Result.Companion r108 = Result.Companion;
        Object r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r107 = r112;
    L91:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r109);
        if (r118 == null) goto L156;
        String r119 = r118.getMessage();
        if (r119 != null) goto L97;
        r119 = "";
    L97:
        r105.close();
        int r120 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c(r106, "line end = ".concat(r119));
        r310.c(r116);
        com.larus.im.internal.network.chunk.data.a r121 = new com.larus.im.internal.network.chunk.data.a(2, r114, 2, r119);
        Intrinsics.checkNotNullParameter(r115, "info");
        UplinkBody r122 = r115.uplinkBody;
        if (r122 == null) goto L100;
        FetchChunkMessageUplinkBody r123 = r122.fetchChunkMessageUplinkBody;
    L101:
        if (r123 == null) goto L103;
        String r124 = r123.token;
    L104:
        if (r124 != null) goto L107;
        r124 = "";
    L107:
        if (r124.length() != 0) goto L109;
        boolean r125 = true;
    L110:
        if (r125 == false) goto L112;
        UplinkMessage r126 = r115;
    L125:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.L$4 = null;
        r102.label = 4;
        if (r310.e(r116, r126, r107, r121, r102) != r110) goto L156;
        return r110;
    L112:
        int r127 = com.larus.im.internal.network.chunk.cache.a.b(r124);
        if (r127 > Integer.MIN_VALUE) goto L115;
        int r128 = 0;
    L116:
        int r129 = r117 + r128;
        com.larus.im.internal.utils.b.c(r106, "retry nextUplinkBody: token = " + r124 + ", seq = " + r129);
        if (r122 != null) goto L119;
        UplinkBody r211 = null;
    L124:
        r126 = UplinkMessage.copy$default(r115, 0, null, r211, null, null, 27, null);
        goto L125
    L119:
        if (r123 == null) goto L121;
        FetchChunkMessageUplinkBody r212 = FetchChunkMessageUplinkBody.copy$default(r123, null, r129, null, 5, null);
    L122:
        r211 = UplinkBody.copy$default(r122, null, null, r212, null, null, null, null, null, null, null, null, null, null, 8187, null);
        goto L124
    L121:
        r212 = null;
        goto L122
    L115:
        r128 = r127;
        goto L116
    L109:
        r125 = false;
        goto L110
    L103:
        r124 = null;
        goto L104
    L100:
        r123 = null;
        goto L101
    L77:
        if (JobKt.isActive(r102.getContext()) == true) goto L79;
        int r130 = com.larus.im.internal.network.chunk.a.f349081a;     // Catch: Throwable -> L81
        com.larus.im.internal.utils.b.c("interrupt_test", "!coroutineContext.isActive");     // Catch: Throwable -> L81
        r310.c(r116);     // Catch: Throwable -> L81
        r310.f349133a.b(r116, Integer.MAX_VALUE, new com.larus.im.internal.network.chunk.data.a(3, r114, 12));     // Catch: Throwable -> L81
    L79:
        r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L81
    L20:
        th = th;
        r106 = "ChunkHandler";
        r114 = r111;
        r115 = r113;
        r116 = r210;
        r117 = 1;
        goto L90
    L22:
        ResultKt.throwOnFailure(r103);
    L142:
        return Unit.INSTANCE;
    L23:
        b r131 = (b) r102.L$2;
        UplinkMessage r132 = (UplinkMessage) r102.L$1;
        String r133 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);
        String r134 = r133;
        UplinkMessage r135 = r132;
        b r136 = r131;
    L28:
        Intrinsics.checkNotNullParameter(r135, "uplink");
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L31
        ze9.a.f571571a.getClass();     // Catch: Throwable -> L31
        Object r138 = Result.m9449constructorimpl(ze9.a.e(r135));     // Catch: Throwable -> L31
    L34:
        if (Result.m9452exceptionOrNullimpl(r138) == null) goto L37;
        r138 = null;
    L37:
        gd9.e r139 = (gd9.e) r138;
        if (r139 == null) goto L45;
        Map<String, String> r140 = r139.f480967c;
        if (r140 == null) goto L45;
        Intrinsics.checkNotNullParameter(Constants.Keys.KEY_X_TT_LOGID, "<this>");
        String r141 = r140.get(Constants.Keys.KEY_X_TT_LOGID.toLowerCase(Locale.getDefault()));
        if (r141 == null) goto L45;
        r114 = r141;
    L46:
        int r142 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("ChunkHandler", "request chunk logid = ".concat(r114));
        IntRange r143 = new IntRange(400, FetchCardPlugin.SERVER_ERROR);
        if (r139 == null) goto L49;
        Integer r144 = Boxing.boxInt(r139.f480966b);
    L50:
        if (r144 != null) goto L52;
    L54:
        boolean r145 = false;
    L55:
        if (r145 == false) goto L61;
        com.larus.im.internal.network.chunk.handler.a.InterfaceC4365a r146 = r310.f349133a;
        if (r139 == null) goto L59;
        int r147 = r139.f480966b;
    L60:
        r146.b(r134, Integer.MAX_VALUE, new com.larus.im.internal.network.chunk.data.a(r147, r114, 12));
        return Unit.INSTANCE;
    L59:
        r147 = -1;
        goto L60
    L61:
        if (r139 != null) goto L63;
    L129:
        b r148 = r136;
        UplinkMessage r149 = r135;
        String r150 = r134;
        if (r139 == null) goto L132;
        int r151 = r139.f480966b;
    L133:
        if (r139 == null) goto L135;
        String r152 = r139.f480969e;
    L136:
        if (r152 != null) goto L138;
        r152 = "";
    L138:
        com.larus.im.internal.network.chunk.data.a r153 = new com.larus.im.internal.network.chunk.data.a(2, r114, r151, r152);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.label = 2;
        if (r310.e(r150, r149, r148, r153, r102) != r110) goto L142;
        return r110;
    L135:
        r152 = null;
        goto L136
    L132:
        r151 = 2;
        goto L133
    L63:
        if (r139.c() == false) goto L129;
        BufferedSource r154 = r139.f480970f;
        if (r154 == null) goto L129;
        Intrinsics.checkNotNull(r154);
        ChunkParser r155 = ChunkParser.f349096a;     // Catch: Throwable -> L87
        b r312 = r136;
        r106 = "ChunkHandler";
        r115 = r135;
        r116 = r134;
        r117 = 1;
        ChunkHandler$request$2$1 r156 = new ChunkHandler$request$2$1(r310, r134, r114, r312, null);     // Catch: Throwable -> L85
        r102.L$0 = r116;     // Catch: Throwable -> L85
        r102.L$1 = r115;     // Catch: Throwable -> L85
        r107 = r312;
        r102.L$2 = r107;     // Catch: Throwable -> L83
        r102.L$3 = r114;     // Catch: Throwable -> L83
        r102.L$4 = r154;     // Catch: Throwable -> L83
        r102.label = 3;     // Catch: Throwable -> L83
        if (r155.b(r154, r156, r102) == r110) goto L158;
        r105 = r154;
        goto L147
    L158:
        return r110;
    L83:
        th = th;
    L89:
        r112 = r107;
        r105 = r154;
    L85:
        th = th;
        r107 = r312;
    L87:
        th = th;
        r107 = r136;
        r106 = "ChunkHandler";
        r115 = r135;
        r116 = r134;
        r117 = 1;
        goto L89
    L52:
        if (r143.contains(r144.intValue()) == false) goto L54;
        r145 = true;
        goto L55
    L49:
        r144 = null;
    L45:
        r114 = "";
    L31:
        th = move-exception;
        Result.Companion r157 = Result.Companion;
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L24:
        ResultKt.throwOnFailure(r103);
        r102.L$0 = r311;
        r102.L$1 = r410;
        r136 = r411;
        r102.L$2 = r136;
        r102.label = 1;
        r310.d(r311);
        r310.f349121c.put(r311, e.c(new ChunkHandler$setReqTimeoutTask$2(r310, r311, null)));
        if (Unit.INSTANCE == r110) goto L157;
        r134 = r311;
        r135 = r410;
        goto L28
    L157:
        return r110;
    L7:
        r100 = new ChunkHandler$request$1(r310, r412);
        goto L8
    }

    public final Object e(String r100, UplinkMessage r110, b r111, com.larus.im.internal.network.chunk.data.a r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof ChunkHandler$retry$1) == false) goto L7;
        ChunkHandler$retry$1 r101 = (ChunkHandler$retry$1) r113;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r114 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r101.L$3;
        r111 = (b) r101.L$2;
        r110 = (UplinkMessage) r101.L$1;
        String r115 = (String) r101.L$0;
        ResultKt.throwOnFailure(r114);
        String r106 = r105;
        r100 = r115;
    L22:
        this.f349120b.remove(r100);
        b(r110, r111);
        int r116 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("ChunkHandler", "retry startTask " + r100 + ", " + r106);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        r111.f349137d++;
        r111.f349136c++;
        int r117 = r111.f349134a;
        int r107 = r117 * 3;
        r106 = "chunkRetryTime(" + r111.f349137d + ")-limit(" + r117 + "), taskRetryTime(" + r111.f349136c + ")-limit(" + r107 + ')';
        if (r111.f349137d <= r117) goto L17;
    L24:
        int r118 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("ChunkHandler", "stop retry " + r106 + " token=" + r100);
        d(r100);
        c(r100);
        this.f349133a.b(r100, Integer.MAX_VALUE, r112);
        return Unit.INSTANCE;
    L17:
        if (r111.f349136c > r107) goto L24;
        long r119 = r111.f349135b;
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.L$2 = r111;
        r101.L$3 = r106;
        r101.label = 1;
        if (DelayKt.delay(r119, r101) != r103) goto L22;
        return r103;
    L7:
        r101 = new ChunkHandler$retry$1(this, r113);
        goto L8
    }
}
