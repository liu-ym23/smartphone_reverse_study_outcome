package com.ss.android.lark.integrator.todo.dependency;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class TodoTimeFormatDependency implements g7c.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f428136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f428137b;

    public static final class a implements com.ss.android.lark.usersetting.service.timeformat.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoTimeFormatDependency f428138a;

        /* JADX INFO: renamed from: com.ss.android.lark.integrator.todo.dependency.TodoTimeFormatDependency$a$a, reason: collision with other inner class name */
        public static final class RunnableC5075a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TodoTimeFormatDependency f428139a;

            public RunnableC5075a(TodoTimeFormatDependency r100) {
                this.f428139a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r100 = ((CopyOnWriteArrayList) this.f428139a.f428137b.getValue()).iterator();     // Catch: Throwable -> L7
            L4:
                if (r100.hasNext() == false) goto L16;
                ((g7c.t.a) r100.next()).a();     // Catch: Throwable -> L7
                goto L4
            L16:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public a(TodoTimeFormatDependency r100) {
            this.f428138a = r100;
        }

        @Override // com.ss.android.lark.usersetting.service.timeformat.a
        public final void a(TimeFormatSetting r100) {
            UICallbackExecutor.post(new RunnableC5075a(this.f428138a));
        }
    }

    @Override // g7c.t
    public final boolean c() {
        TimeFormatSetting r100 = com.ss.android.lark.usersetting.service.e.a.f444639a.f();
        if (r100 != null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 != true) goto L8;
    L7:
        return true;
    L8:
        if (r101 == true) goto L14;
        if (r100.getTimeFormat() == TimeFormatSetting.TimeFormat.TWENTY_FOUR_HOUR) goto L7;
        return false;
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        r101 = false;
        goto L6
    }

    public TodoTimeFormatDependency() {
        this.f428137b = LazyKt.lazy(TodoTimeFormatDependency$mChangeListeners$2.INSTANCE);
    }

    @Override // g7c.t
    public final void a(g7c.t.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) this.f428137b.getValue()).remove(r100);
        if (this.f428136a != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.f428137b.getValue()).size() == 0) goto L7;
        return;
    L7:
        if (com.ss.android.lark.usersetting.service.e.a.f444639a == null) goto L12;
        a r101 = this.f428136a;
        Object r102 = com.ss.android.lark.usersetting.service.timeformat.b.f444648b;
        com.ss.android.lark.usersetting.service.timeformat.b r103 = com.ss.android.lark.usersetting.service.timeformat.b.C5374b.f444651a;
        if (r101 != null) goto L11;
        r103.getClass();
        goto L12
    L11:
        ((ConcurrentHashMap) r103.f444649a).remove(r101);
    L12:
        this.f428136a = null;
    }

    @Override // g7c.t
    public final void b(g7c.t.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newListener");
        ((CopyOnWriteArrayList) this.f428137b.getValue()).add(r100);
        if (this.f428136a != null) goto L8;
        a r101 = new a(this);
        this.f428136a = r101;
        if (com.ss.android.lark.usersetting.service.e.a.f444639a == null) goto L9;
        Object r102 = com.ss.android.lark.usersetting.service.timeformat.b.f444648b;
        Map<com.ss.android.lark.usersetting.service.timeformat.a, Object> r103 = com.ss.android.lark.usersetting.service.timeformat.b.C5374b.f444651a.f444649a;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(r101, com.ss.android.lark.usersetting.service.timeformat.b.f444648b);
        return;
    L9:
        return;
    }
}
