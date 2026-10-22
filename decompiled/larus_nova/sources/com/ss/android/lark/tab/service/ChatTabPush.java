package com.ss.android.lark.tab.service;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class ChatTabPush implements m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f441127d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f441128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f441129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Throwable, Unit> f441130c;

    public static final class a {
    }

    public static abstract class b {
        public b() {
            throw null;
        }

        public abstract void a(p6c.c r100);
    }

    public static final class c implements com.ss.android.lark.sdk.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatTabPush f441131a;

        public c(ChatTabPush r100) {
            this.f441131a = r100;
        }

        @Override // com.ss.android.lark.sdk.f.a
        public final void a() {
            this.f441131a.f441128a.a();
        }
    }

    static {
    }

    @Inject
    public ChatTabPush(n r100) {
        Intrinsics.checkNotNullParameter(r100, "pushRepo");
        this.f441128a = r100;
        this.f441129b = new CopyOnWriteArrayList();
        this.f441130c = ChatTabPush$onError$1.INSTANCE;
    }

    @Override // com.ss.android.lark.tab.service.m
    public final void M1(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.b(this.f441129b, r100, new c(this));
    }

    @Override // com.ss.android.lark.tab.service.m
    public final void he(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList<b> r101 = this.f441129b;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator<b> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        r102.next().getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L11;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        return;
    L18:
        CopyOnWriteArrayList<b> r104 = this.f441129b;
        if (r104.isEmpty() == false) goto L29;
        monitor-enter(r104);
    L26:
        th = move-exception;
        throw th;
    L22:
        if (r104.isEmpty() == false) goto L24;
        this.f441128a.b(new ChatTabPush$startPush$2$1(this), this.f441130c);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r104);     // Catch: Throwable -> L26
    L29:
        r104.add(r100);
        return;
    L15:
        r103 = false;
        goto L16
    L7:
        if (r101.isEmpty() == false) goto L9;
        goto L9
    }
}
