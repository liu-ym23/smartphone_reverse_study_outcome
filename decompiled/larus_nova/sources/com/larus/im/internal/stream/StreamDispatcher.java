package com.larus.im.internal.stream;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.database.utils.e;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.tracking.m;
import com.larus.im.internal.tracking.w;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import ouc.e0;
import ouc.j;
import vd9.r;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamDispatcher implements nf9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StreamDispatcher f350097a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vt7.a<String, vt7.b<nf9.c>> f350098b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vt7.b<nf9.c> f350099c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vt7.b<nf9.c> f350100d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vt7.a<String, vt7.b<nf9.c>> f350101e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final vt7.b<nf9.c> f350102f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final vt7.b<nf9.c> f350103g = null;

    public StreamDispatcher() {
    }

    static {
        f350097a = new StreamDispatcher();
        f350098b = new vt7.a();
        f350099c = new vt7.b();
        f350100d = new vt7.b();
        f350101e = new vt7.a();
        f350102f = new vt7.b();
        f350103g = new vt7.b();
    }

    public static final String a(Message r100) {
        Map<String, String> r101 = r100.getBusinessExt();
        if (com.larus.im.bean.message.a.D0(r100) == false) goto L7;
        String r102 = r100.getThreadId();
        if (r102 != null) goto L22;
    L20:
        return "";
    L22:
        return r102;
    L7:
        if (r101 == null) goto L9;
        String r103 = r101.get("message_case_mode");
    L11:
        if (Intrinsics.areEqual(r103, "1") == false) goto L18;
        String r104 = r101.get("case_conversation_id");
        if (r104 != null) goto L24;
        String r105 = r100.getConversationId();
        if (r105 == null) goto L20;
        return r105;
    L24:
        return r104;
    L18:
        String r106 = r100.getConversationId();
        if (r106 == null) goto L20;
        return r106;
    L9:
        r103 = null;
        goto L11
    }

    @Override // nf9.c
    public final void A(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if (com.larus.im.bean.message.a.D0(r110) == false) goto L5;
        vt7.b<nf9.c> r100 = f350103g;
    L6:
        Iterator<nf9.c> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().A(r110);
        goto L8
    L10:
        w r102 = w.f350508a;
        String r103 = r110.getMessageId();
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r102.getClass();
        String r104 = "0";
        Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.MSGID);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L33
        w.a r106 = w.f350510c.remove(r103);     // Catch: Throwable -> L33
        if (r106 == null) goto L30;
        long r107 = Duration.m10811getInWholeMillisecondsimpl(TimeSource.Monotonic.ValueTimeMark.m10943minus6eNON_k(TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto(), r106.f350512b));     // Catch: Throwable -> L33
        int r108 = com.larus.im.internal.tracking.d.f350316a;     // Catch: Throwable -> L33
        float r109 = ((int) ((r106.f350514d / 1000000.0f) * 100)) / 100.0f;     // Catch: Throwable -> L33
        float r111 = r106.f350513c;     // Catch: Throwable -> L33
        float r112 = 0.0f;
        if (r111 != 0.0f) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == true) goto L23;
        r112 = ((int) ((r109 / r111) * 100)) / 100.0f;     // Catch: Throwable -> L33
    L23:
        d1 r114 = d1.f348206b;     // Catch: Throwable -> L33
        e0 r115 = new e0();     // Catch: Throwable -> L33
        m.b(r115, ce9.a.a());     // Catch: Throwable -> L33
        j.c(r115, "is_chunk_improve", "0");     // Catch: Throwable -> L33
        j.c(r115, "scene", r106.f350511a);     // Catch: Throwable -> L33
        j.c(r115, "msg_id", r103);     // Catch: Throwable -> L33
        j.b(r115, "count", Integer.valueOf(r106.f350513c));     // Catch: Throwable -> L33
        j.b(r115, "duration", Long.valueOf(r107));     // Catch: Throwable -> L33
        j.b(r115, "total_time", Float.valueOf(r109));     // Catch: Throwable -> L33
        j.b(r115, "once_time", Float.valueOf(r112));     // Catch: Throwable -> L33
        if (r106.f350515e == false) goto L26;
        r104 = "1";
    L26:
        j.c(r115, "is_thinking_message", r104);     // Catch: Throwable -> L33
        j.b(r115, "content_type", Integer.valueOf(r106.f350516f));     // Catch: Throwable -> L33
        j.b(r115, "content_hit_cache_ratio", Float.valueOf(r.d().a()));     // Catch: Throwable -> L33
        if (r106.f350515e == false) goto L29;
        j.b(r115, "thinking_content_hit_cache_ratio", Float.valueOf(((vd9.c) r.f554250b.getValue()).a()));     // Catch: Throwable -> L33
    L29:
        j.b(r115, "ext_hit_cache_ratio", Float.valueOf(((vd9.c) r.f554251c.getValue()).a()));     // Catch: Throwable -> L33
        j.b(r115, "suggest1_hit_cache_ratio", Float.valueOf(((vd9.c) r.f554252d.getValue()).a()));     // Catch: Throwable -> L33
        j.b(r115, "suggest2_hit_cache_ratio", Float.valueOf(((vd9.c) r.f554253e.getValue()).a()));     // Catch: Throwable -> L33
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r114.a("flow_im_concat_chunk_cost", r115.a());     // Catch: Throwable -> L33
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L33
    L31:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L33
    L35:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L39;
        com.larus.im.internal.delegate.a.f348188b.e("MessageConcatReporter", "reportEvent, failed:" + r119);
        r118 = Unit.INSTANCE;
    L39:
        Unit r120 = (Unit) r118;
        e.d(new StreamDispatcher$onStreamEnd$2(r110, null));
        return;
    L19:
        r113 = false;
        goto L20
    L30:
        r117 = null;
    L33:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L5:
        r100 = f350100d;
        goto L6
    }

    @Override // nf9.c
    public final void B(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (com.larus.im.bean.message.a.D0(r100) == false) goto L5;
        vt7.b<nf9.c> r101 = f350103g;
    L6:
        Iterator<nf9.c> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().B(r100);
        goto L8
    L10:
        e.d(new StreamDispatcher$onStreamUpdate$2(r100, null));
        return;
    L5:
        r101 = f350100d;
        goto L6
    }

    @Override // nf9.c
    public final void C(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (com.larus.im.bean.message.a.D0(r100) == false) goto L5;
        vt7.b<nf9.c> r101 = f350103g;
    L6:
        Iterator<nf9.c> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().C(r100);
        goto L8
    L10:
        e.d(new StreamDispatcher$onStreamBegin$2(r100, null));
        return;
    L5:
        r101 = f350100d;
        goto L6
    }
}
