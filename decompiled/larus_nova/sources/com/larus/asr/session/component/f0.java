package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f287699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f287700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f287701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Message f287702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f287703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f287704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f287705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f287706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f287707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> f287708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> f287709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> f287710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile String f287711m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile long f287712n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile AsrEngineRoute f287713o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f287714p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f287715q;

    public final boolean a() {
        if (this.f287700b.invoke().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f287706h.get() == true) goto L7;
        return true;
    }

    public final k0 b() {
        k0 r100 = this.f287701c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("request");
        return null;
    }

    public final boolean c() {
        return this.f287703e.get();
    }

    public final void d() {
        this.f287704f.set(false);
    }

    public final void e(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f287710l.set(r100);
        Iterator<T> r101 = this.f287708j.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        com.larus.bmhome.chat.component.bottom.core.speaker.h r102 = (com.larus.bmhome.chat.component.bottom.core.speaker.h) r101.next();
        if (this.f287700b.invoke().booleanValue() == false) goto L7;
        r102.a(r100);
        goto L4
    L7:
        return;
    }

    public final boolean f(boolean r100) {
        if (this.f287705g.compareAndSet(false, true) == true) goto L5;
        return false;
    L5:
        if (r100 == false) goto L7;
        this.f287704f.set(false);
    L7:
        return true;
    }

    public f0(String r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "isCurrentSession");
        this.f287699a = r100;
        this.f287700b = r101;
        this.f287703e = new AtomicBoolean(false);
        this.f287704f = new AtomicBoolean(false);
        this.f287705g = new AtomicBoolean(false);
        this.f287706h = new AtomicBoolean(false);
        this.f287708j = new CopyOnWriteArraySet();
        this.f287709k = new CopyOnWriteArraySet();
        this.f287710l = new AtomicReference();
        this.f287713o = AsrEngineRoute.NONE;
        this.f287714p = LazyKt.lazy(new e0());
    }
}
