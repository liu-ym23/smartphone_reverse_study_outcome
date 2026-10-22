package com.obric.assistant.session.singleton;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class SessionEndpointMgr implements bga.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SessionEndpointMgr f391648a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f391649b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f391650c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f391651d = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ISessionEndPoint) r101).f()), Integer.valueOf(((ISessionEndPoint) r100).f()));
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ISessionEndPoint) r101).h()), Integer.valueOf(((ISessionEndPoint) r100).h()));
        }
    }

    public SessionEndpointMgr() {
    }

    @Override // bga.i
    public final void onDestroy() {
    }

    static {
        f391648a = new SessionEndpointMgr();
        f391649b = LazyKt.lazy(new f());
        f391650c = LazyKt.lazy(new g());
        f391651d = LazyKt.lazy(new h());
    }

    @Override // bga.i
    public final void onInit() {
        Intrinsics.checkNotNullParameter("AiIslandVoiceInteractionSession", "tag");
        Intrinsics.checkNotNullParameter("AiIslandVoiceInteractionSession", "tag");
        Iterator r100 = ((List) f391650c.getValue()).iterator();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        Object r103 = r100.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ISessionEndPoint r105 = (ISessionEndPoint) r103;
        FLogger.f375446a.i("AiIsland->SessionEndpointMgr", "prepare item[" + r102 + "] is " + r105 + " -> " + r105.f());
        r102 = r104;
        goto L4
    L9:
        FLogger.f375446a.i("AiIsland->SessionEndpointMgr", "prepare size is " + ((List) f391650c.getValue()).size());
        Iterator r106 = ((List) f391651d.getValue()).iterator();
    L11:
        if (r106.hasNext() == false) goto L16;
        Object r107 = r106.next();
        int r108 = r101 + 1;
        if (r101 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        ISessionEndPoint r109 = (ISessionEndPoint) r107;
        FLogger.f375446a.i("AiIsland->SessionEndpointMgr", "process item[" + r101 + "] is " + r109 + " -> " + r109.h());
        r101 = r108;
        goto L11
    L16:
        FLogger.f375446a.i("AiIsland->SessionEndpointMgr", "process size is " + ((List) f391651d.getValue()).size());
    }

    @Override // bga.i
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ad -> B:24:0x00b1). Please report as a decompilation issue!!! */
    public final Object b(Bundle r110, Continuation<? super Pair<? extends ErrorCode, String>> r111) {
        if ((r111 instanceof SessionEndpointMgr$onSessionProcess$1) == false) goto L7;
        SessionEndpointMgr$onSessionProcess$1 r100 = (SessionEndpointMgr$onSessionProcess$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r113 = r100.I$1;
        int r104 = r100.I$0;
        Bundle r105 = (Bundle) r100.L$0;
        ResultKt.throwOnFailure(r112);
        SessionEndpointMgr$onSessionProcess$1 r106 = r100;
        String r107 = "AiIsland->SessionEndpointMgr";
        int r108 = r104;
        Object r109 = r102;
    L24:
        Pair r114 = (Pair) r112;
        FLogger.f375446a.i(r107, "onSessionProcess chain point result " + r114);
        ErrorCode r115 = (ErrorCode) r114.getFirst();
        String r116 = (String) r114.getSecond();
        if (ArraysKt.contains(new ErrorCode[]{ErrorCode.QUIT_SESSION, ErrorCode.LAUNCH_ASSISTANT_DIRECTLY, ErrorCode.ONLY_END}, r115) == false) goto L27;
        ErrorCode r117 = r115;
        String r118 = r116;
    L29:
        return TuplesKt.to(r117, r118);
    L27:
        r113 = r113 + 1;
        r118 = r116;
        Bundle r119 = r105;
        String r120 = r107;
        r117 = r115;
    L19:
        if (r113 >= r108) goto L29;
        ISessionEndPoint r121 = (ISessionEndPoint) ListProtector.get((List) f391651d.getValue(), r113);
        FLogger.f375446a.i(r120, "onSessionProcess chain point start " + r121);
        r106.L$0 = r119;
        r106.I$0 = r108;
        r106.I$1 = r113;
        r106.label = 1;
        Object r122 = r121.d(r119, r106);
        if (r122 != r109) goto L23;
        return r109;
    L23:
        String r123 = r120;
        r105 = r119;
        r112 = r122;
        r107 = r123;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        FLogger.f375446a.i("AiIsland->SessionEndpointMgr", "onSessionProcess " + r110);
        if (r110 == null) goto L17;
        ErrorCode r124 = ErrorCode.NA;
        r118 = "";
        r120 = "AiIsland->SessionEndpointMgr";
        r108 = ((List) f391651d.getValue()).size();
        r109 = r102;
        r106 = r100;
        r117 = r124;
        r119 = r110;
        r113 = 0;
        goto L19
    L17:
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "invalid args");
    L7:
        r100 = new SessionEndpointMgr$onSessionProcess$1(this, r111);
        goto L8
    }
}
