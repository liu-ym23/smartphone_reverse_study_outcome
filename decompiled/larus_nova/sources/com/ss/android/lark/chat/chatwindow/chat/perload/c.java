package com.ss.android.lark.chat.chatwindow.chat.perload;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.extension.ChatCoreRuntimeProvider;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import t3b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f413465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<? extends u3b.a>, com.ss.android.lark.chat.chatwindow.chat.perload.loader.c> f413466b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f413467a = null;

        static {
            f413467a = new c(ImSdkService.b(), ImSdkService.f());
        }
    }

    public final void b(u3b.a r100) {
        Map<Class<? extends u3b.a>, com.ss.android.lark.chat.chatwindow.chat.perload.loader.c> r101 = this.f413466b;
        HashMap r102 = (HashMap) r101;
        com.ss.android.lark.chat.chatwindow.chat.perload.loader.c r103 = (com.ss.android.lark.chat.chatwindow.chat.perload.loader.c) r102.get(r100.getClass());
        if (r103 != null) goto L6;
        Log.e("DataPreLoadManager", "Could not find a loader for target task");
        return;
    L6:
        t3b.c r104 = t3b.c.a.f544544a;
        Map<Class, e> r105 = r104.f544542a;
        HashMap r106 = (HashMap) r105;
        e r107 = (e) r106.get(r100.getClass());
        if (r107 != null) goto L9;
        r107 = r104.f544543b;
    L9:
        u3b.d r108 = new u3b.d(r107.b(r100), r100);
        this.f413465a.a(r108, r103);
    }

    public c(ImSdkChatService r100, p r101) {
        this.f413465a = new b();
        this.f413466b = new HashMap(5);
        c(u3b.c.class, new com.ss.android.lark.chat.chatwindow.chat.perload.loader.b(r101), new t3b.b());
        c(u3b.b.class, new com.ss.android.lark.chat.chatwindow.chat.perload.loader.a(r100, r101), new t3b.a());
        Collection<d<? extends u3b.a, ?>> r102 = ChatCoreRuntimeProvider.f414745a.h();
        Log.i("DataPreLoadManager", "holder count:" + r102.size());
        Iterator<d<? extends u3b.a, ?>> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        d<? extends u3b.a, ?> r104 = r103.next();
        Log.i("DataPreLoadManager", "holder task class:".concat(r104.f413468a.getName()));
        c(r104.f413468a, r104.f413469b, r104.f413470c);
        goto L4
    }

    public final void a(u3b.a r100, IGetDataCallback<u3b.e> r101) {
        t3b.c r102 = t3b.c.a.f544544a;
        e r103 = (e) ((HashMap) r102.f544542a).get(r100.getClass());
        if (r103 != null) goto L5;
        r103 = r102.f544543b;
    L5:
        String r104 = r103.a(r100);
        b r105 = this.f413465a;
        ((ReentrantLock) r105.f413464d).lock();
        u3b.e r106 = (u3b.e) ((ConcurrentHashMap) r105.f413462b).remove(r104);     // Catch: Throwable -> L25
        if (r106 != null) goto L10;
        u3b.d r107 = r105.f413463c.get(r104);     // Catch: Throwable -> L25
        if (r107 == null) goto L20;
        r107.f548630c = r101;     // Catch: Throwable -> L25
    L23:
        ((ReentrantLock) r105.f413464d).unlock();
        return;
    L20:
        Log.e("DataPreLoadEngine", "Failed to find task when fetch data：" + r104 + "");     // Catch: Throwable -> L25
        u3b.d r108 = new u3b.d(r104, r100);     // Catch: Throwable -> L25
        r108.f548630c = r101;     // Catch: Throwable -> L25
        com.ss.android.lark.chat.chatwindow.chat.perload.loader.c r109 = (com.ss.android.lark.chat.chatwindow.chat.perload.loader.c) ((HashMap) a.f413467a.f413466b).get(r100.getClass());     // Catch: Throwable -> L25
        if (r109 == null) goto L23;
        r105.a(r108, r109);     // Catch: Throwable -> L25
        goto L23
    L10:
        if (r106.f548632b != null) goto L12;
        boolean r110 = true;
    L14:
        if (r110 == false) goto L16;
        Log.i("DataPreLoadEngine", "Task:" + r104 + " Fetch data after task finish, return result");     // Catch: Throwable -> L25
        r101.onSuccess(r106);     // Catch: Throwable -> L25
        goto L23
    L16:
        Log.e("DataPreLoadEngine", "Task:" + r104 + " Fetch data after task finish, return error:" + r106.f548632b);     // Catch: Throwable -> L25
        r101.onError(r106.f548632b);     // Catch: Throwable -> L25
        goto L23
    L12:
        r110 = false;
    L25:
        th = move-exception;
        ((ReentrantLock) r105.f413464d).unlock();
        throw th;
    }

    public final <Task extends u3b.a, DATA> void c(Class<Task> r100, com.ss.android.lark.chat.chatwindow.chat.perload.loader.c<Task, u3b.e<DATA>> r101, e<Task> r102) {
        this.f413466b.put(r100, r101);
        if (r102 == null) goto L6;
        ((HashMap) t3b.c.a.f544544a.f544542a).put(r100, r102);
        return;
    }
}
