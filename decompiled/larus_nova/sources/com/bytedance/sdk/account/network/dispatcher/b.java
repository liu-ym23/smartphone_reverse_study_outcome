package com.bytedance.sdk.account.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements IRequest, Runnable, Comparable<IRequest>, WeakHandler.IHandler {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f269212g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f269213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f269214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHandler f269215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f269216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f269217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IRequest.Priority f269218f;

    public void run() {
    }

    static {
        f269212g = c.a();
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.IRequest
    public final int a() {
        return this.f269216d;
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.IRequest
    public final IRequest.Priority getPriority() {
        return this.f269218f;
    }

    public b(IRequest.Priority r100) {
        this.f269213a = new AtomicBoolean(false);
        this.f269214b = new AtomicBoolean(false);
        this.f269215c = new WeakHandler(Looper.getMainLooper(), this);
        this.f269218f = r100;
        String r101 = null;
        if (StringUtils.isEmpty(null) == false) goto L5;
        r101 = getClass().getSimpleName();
    L5:
        this.f269217e = r101;
    }

    @Override // java.lang.Comparable
    public final int compareTo(IRequest r100) {
        IRequest r101 = r100;
        IRequest.Priority r102 = this.f269218f;
        IRequest.Priority r103 = r101.getPriority();
        if (r102 != null) goto L5;
        r102 = IRequest.Priority.NORMAL;
    L5:
        if (r103 != null) goto L7;
        r103 = IRequest.Priority.NORMAL;
    L7:
        if (r102 != r103) goto L10;
        return this.f269216d - r101.a();
    L10:
        return r103.ordinal() - r102.ordinal();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L16;
        return;
    L16:
        int r101 = r100.what;     // Catch: Throwable -> L12
        if (r101 != 0) goto L7;
        f269212g.c();     // Catch: Throwable -> L12
    L15:
        return;
    L7:
        if (r101 != 1) goto L15;
        f269212g.b();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
    }
}
