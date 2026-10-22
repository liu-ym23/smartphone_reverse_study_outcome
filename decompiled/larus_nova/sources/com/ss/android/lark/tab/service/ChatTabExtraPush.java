package com.ss.android.lark.tab.service;

import com.ss.android.lark.chat.entity.chat.ChatTabExtra;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class ChatTabExtraPush implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f441112e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f441113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f441114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<b, c> f441115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Throwable, Unit> f441116d;

    public static final class a {
    }

    public static abstract class b {
        public b() {
            throw null;
        }

        public abstract void a(ChatTabExtra r100);
    }

    public static final class c implements aqb.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f441117a;

        public c(b r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f441117a = r100;
        }

        @Override // aqb.f
        public final void a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            this.f441117a.getClass();
            if (Intrinsics.areEqual(null, r100) == false) goto L10;
            int r102 = 1;
            boolean r103 = !r101;
            b r104 = this.f441117a;
            if (r103 == true) goto L8;
            r102 = 2;
        L8:
            r104.a(new ChatTabExtra(r102, -1));
            return;
        }
    }

    static {
    }

    @Inject
    public ChatTabExtraPush(j r100) {
        Intrinsics.checkNotNullParameter(r100, "pushRepo");
        this.f441113a = r100;
        this.f441114b = new CopyOnWriteArrayList();
        this.f441115c = new ConcurrentHashMap();
        this.f441116d = ChatTabExtraPush$onError$1.INSTANCE;
    }

    @Override // com.ss.android.lark.tab.service.i
    public final void a1(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList<b> r101 = this.f441114b;
        if (r101.isEmpty() == false) goto L15;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r101.isEmpty() == false) goto L10;
        this.f441113a.a(new ChatTabExtraPush$startPush$1$1(this), this.f441116d);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
    L15:
        r101.add(r100);
        c r102 = new c(r100);
        this.f441115c.put(r100, r102);
        ImSdkService.a().gd(r102);
    }

    @Override // com.ss.android.lark.tab.service.i
    public final void vb(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList<b> r101 = this.f441114b;
        monitor-enter(r101);
        r101.remove(r100);     // Catch: Throwable -> L23
        monitor-exit(r101);     // Catch: Throwable -> L23
        if (r101.isEmpty() == false) goto L19;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r101.isEmpty() == false) goto L14;
        this.f441113a.b();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
    L19:
        c r102 = this.f441115c.get(r100);
        if (r102 == null) goto L30;
        ImSdkService.a().Se(r102);
        c r103 = this.f441115c.remove(r100);
        return;
    L30:
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
