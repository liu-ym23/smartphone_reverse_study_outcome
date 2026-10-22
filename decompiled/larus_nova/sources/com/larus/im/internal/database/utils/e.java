package com.larus.im.internal.database.utils;

import com.larus.im.internal.database.entity.MessageEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f348155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f348156b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f348157c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f348158d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f348159e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f348160f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f348161g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f348162h = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            com.larus.im.internal.delegate.a.f348188b.e("FlowImTracingProxy", r101.getMessage());
        }
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            com.larus.im.internal.delegate.a.f348188b.e("FlowImTracingProxy#notifyType", r101.getMessage());
        }
    }

    static {
        f348155a = LazyKt.lazy(new com.larus.im.internal.database.utils.a());
        f348156b = LazyKt.lazy(new com.larus.im.internal.database.utils.b());
        f348157c = com.flow.kmp.common.thread.c.a("flow-im#tracking");
        CoroutineExceptionHandler.Key r100 = CoroutineExceptionHandler.Key;
        f348158d = new a(r100);
        f348159e = LazyKt.lazy(new c());
        f348160f = com.flow.kmp.common.thread.c.a("flow-im#notifyType");
        f348161g = new b(r100);
        f348162h = LazyKt.lazy(new d());
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "replyFor");
        return r100 + "-loading";
    }

    public static final Job c(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return BuildersKt.launch$default((CoroutineScope) f348155a.getValue(), null, null, r100, 3, null);
    }

    public static final void d(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        BuildersKt.launch$default((CoroutineScope) f348156b.getValue(), null, null, r100, 3, null);
    }

    public static final void e(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        BuildersKt.launch$default((CoroutineScope) f348159e.getValue(), null, null, r100, 3, null);
    }

    public static final void a(String r100, MessageEntity r101) {
        Intrinsics.checkNotNullParameter("MessageHandler", "tag");
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "message");
        com.larus.im.internal.delegate.a r102 = com.larus.im.internal.delegate.a.f348188b;
        String r103 = "FtsLog(" + r101.getMessageId() + ')';
        StringBuilder r104 = new StringBuilder("(MessageHandler#");
        r104.append(r100);
        r104.append("), fts_empty: ");
        String r105 = r101.getFtsContent();
        if (r105 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        r104.append(r106);
        r104.append(", content_type: ");
        r104.append(r101.getContentType());
        r104.append(", before_content_type: ");
        r104.append(r101.getBeforeContentType());
        r104.append(", local_id: ");
        r104.append(r101.getLocalMessageId());
        r102.i(r103, r104.toString());
        return;
    L5:
        if (r105.length() == 0) goto L8;
        r106 = false;
        goto L9
    }
}
