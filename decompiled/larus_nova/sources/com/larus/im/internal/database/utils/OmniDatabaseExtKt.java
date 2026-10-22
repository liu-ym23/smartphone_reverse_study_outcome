package com.larus.im.internal.database.utils;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.flow.kmp.common.util.ReentrantMutex;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.slowtask.DBSlowTaskManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OmniDatabaseExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<f> f348152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static transient int f348153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantMutex f348154c = null;

    static {
        f348152a = new CopyOnWriteArrayList();
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L5;
        Function1 r100 = new m();
    L6:
        f348154c = new ReentrantMutex(r100);
        return;
    L5:
        r100 = null;
        goto L6
    }

    public static final void b(DBSlowTaskManager r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<f> r101 = f348152a;
        r101.remove(r100);
        r101.add(r100);
        if (f348153b != 0) goto L6;
        CoroutineExtKt.a(new OmniDatabaseExtKt$registerDBIdleListener$1(null));
        return;
    }

    public static final void c(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        CopyOnWriteArrayList<f> r101 = f348152a;
        if ((!r101.isEmpty()) == true) goto L7;
    L20:
        f348153b = r100;
        return;
    L7:
        if (f348153b != 0) goto L14;
        if (r100 == 0) goto L14;
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L14;
        ((f) r102.next()).a(false);
    L14:
        if (f348153b == 0) goto L20;
        if (r100 != 0) goto L20;
        Iterator<T> r103 = f348152a.iterator();
    L18:
        if (r103.hasNext() == false) goto L20;
        ((f) r103.next()).a(true);
        goto L18
    }

    public static final void a(String r100, MessageEntity r101) {
        Intrinsics.checkNotNullParameter("MessageDaoSource", "tag");
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "message");
        com.larus.im.internal.delegate.a r102 = com.larus.im.internal.delegate.a.f348188b;
        String r103 = "FtsLog(" + r101.getMessageId() + ')';
        StringBuilder r104 = new StringBuilder("(MessageDaoSource#");
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

    public static final <T> T d(String r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "block");
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L6;
        return r101.invoke();
    L6:
        return (T) n.a(r100, null, r101);
    }

    public static final <R> Object e(Function1<? super Continuation<? super R>, ? extends Object> r100, Continuation<? super R> r101) {
        c(f348153b + 1);
        OmniDatabaseExtKt$withLock$2$monitorBlock$1 r102 = new OmniDatabaseExtKt$withLock$2$monitorBlock$1(r100, null);
        if (((hd9.k) ae9.d.f3121a.getValue()) != null) goto L7;
        com.larus.im.internal.database.b.f347916a.getClass();
        com.larus.im.internal.database.b.a.b();
        return com.larus.im.internal.database.d.a(r102, r101);
    L7:
        return f348154c.a(r102, r101);
    }
}
