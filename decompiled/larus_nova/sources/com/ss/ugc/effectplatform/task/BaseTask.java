package com.ss.ugc.effectplatform.task;

import bytekn.foundation.utils.Transmitter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseTask implements e0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f457531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f457532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f457533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f457534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f457535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hlc.a f457536f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f457537a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f457537a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Function0 r100) {
            this.f457537a = r100;
        }
    }

    public abstract void a();

    public abstract void b();

    public void c() {
    }

    @Override // e0.c
    public void cancel() {
        this.f457532b = true;
        e(new AnonymousClass1(this));
    }

    public void d() {
    }

    @Override // e0.c
    public int getLevel() {
        return 0;
    }

    @Override // e0.c
    public void pause() {
        this.f457532b = true;
        e(new C123171(this));
    }

    @Override // e0.c
    public final void run() {
        this.f457534d = true;
        String r100 = this.f457535e;
        IEffectPlatformBaseListener r101 = null;
        if (r100 == null) goto L12;
        hlc.a r102 = this.f457536f;
        if (r102 == null) goto L7;
        IEffectPlatformBaseListener r103 = r102.a(r100);
    L9:
        if ((r103 instanceof hlc.c) == false) goto L12;
        ((hlc.c) r103).onStart();
        goto L12
    L7:
        r103 = null;
    L12:
        if (this.f457532b == false) goto L14;
        return;
    L14:
        a();
        String r104 = this.f457535e;
        if (r104 == null) goto L22;
        hlc.a r105 = this.f457536f;
        if (r105 == null) goto L20;
        r101 = r105.a(r104);
    L20:
        if ((r101 instanceof hlc.c) == false) goto L22;
        ((hlc.c) r101).onFinally();
    L22:
        this.f457534d = false;
    }

    @Override // e0.c
    public final String getId() {
        String r100 = this.f457535e;
        if (r100 != null) goto L7;
        return "0";
    L7:
        return r100;
    }

    @Override // e0.c
    public final String getTag() {
        int r100 = com.ss.ugc.effectplatform.util.r.f458047a;
        if (com.ss.ugc.effectplatform.util.r.b(this.f457531a) == false) goto L6;
        return String.valueOf(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName());
    L6:
        return this.f457531a;
    }

    @Override // e0.c
    public long getModifyTime() {
        return this.f457533c;
    }

    public final void e(Function0<Unit> r100) {
        Transmitter.a(new a(r100));
    }

    @Override // e0.c
    public void setModifyTime(long r100) {
        this.f457533c = r100;
    }

    public BaseTask(String r100, hlc.a r101) {
        this.f457535e = r100;
        this.f457536f = r101;
        this.f457531a = "";
    }
}
