package com.ss.android.lark.rustinfrabridge.appstatesync.service.impl;

import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.NoticeClientEventRequest;
import com.bytedance.lark.pb.basic.v1.NoticeClientEventResponse;
import com.bytedance.lark.pb.basic.v1.SetInOfflineModeRequest;
import com.bytedance.lark.pb.basic.v1.SetInofflineModeResponse;
import com.bytedance.lark.rustclient.api.h;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
public final class d implements IAppStateSyncService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f439684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f439685b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f439686a = null;

        static {
            f439686a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            x r101 = (x) r100;
            Log.i("GlobalAppStateService", "noticeSdkDozeMode success");
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f439687a = null;

        static {
            f439687a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Log.e("GlobalAppStateService", "noticeSdkDozeMode failed");
        }
    }

    static {
    }

    @Override // com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService
    public final void b() {
        d(IAppStateSyncService.ClientEvent.MEMORY_WARNING);
    }

    @Inject
    public d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f439684a = r100;
        this.f439685b = true;
    }

    @Override // com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService
    public final void a(boolean r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f439685b != r100) goto L9;
        Log.i("GlobalAppStateService", "notice client event: isAppFont equal last, isAppFont: " + r100);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        this.f439685b = r100;     // Catch: Throwable -> L12
        e(r100);     // Catch: Throwable -> L12
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    @Override // com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService
    public final void c(boolean r100) {
        SetInOfflineModeRequest.Builder r101 = new SetInOfflineModeRequest.Builder().is_offline(Boolean.valueOf(r100));
        Log.i("GlobalAppStateService", "send in offline mode isOffline = " + r100);
        h r102 = this.f439684a;
        Intrinsics.checkNotNull(r101);
        t.b(r102.d(new com.bytedance.lark.rustclient.api.f(r101, SetInofflineModeResponse.RAW_TYPE_ADAPTER, Command.SET_IN_OFFLINE_MODE, null, 248)).a()).subscribe(b.f439686a, c.f439687a);
    }

    public final void d(IAppStateSyncService.ClientEvent r100) {
        Log.i("GlobalAppStateService", "send notice client request event: " + r100.name());
        NoticeClientEventRequest.Builder r101 = new NoticeClientEventRequest.Builder().event(NoticeClientEventRequest.Event.fromValue(r100.getNumber()));
        if (r100.updateTime() == 0) goto L5;
        r101.update_time(Long.valueOf(r100.updateTime()));
    L5:
        h r102 = this.f439684a;
        Intrinsics.checkNotNull(r101);
        t.b(r102.d(new com.bytedance.lark.rustclient.api.f(r101, NoticeClientEventResponse.RAW_TYPE_ADAPTER, Command.NOTICE_CLIENT_EVENT, null, 248)).a()).subscribe(new e(r100), new f(r100));
    }

    public final void e(boolean r100) {
        monitor-enter(this);
        long r101 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r100 == false) goto L7;
        IAppStateSyncService.ClientEvent r103 = IAppStateSyncService.ClientEvent.ENTER_FOREGROUND;
    L8:
        d(r103.updateTime(r101));
        return;
    L7:
        r103 = IAppStateSyncService.ClientEvent.ENTER_BACKGROUND;
    L10:
        th = move-exception;
        throw th;
    }
}
