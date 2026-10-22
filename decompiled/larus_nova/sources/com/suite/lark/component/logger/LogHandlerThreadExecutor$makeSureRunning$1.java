package com.suite.lark.component.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.suite.component.logger.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "looper", "Landroid/os/Looper;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class LogHandlerThreadExecutor$makeSureRunning$1 extends Lambda implements Function1<Looper, Unit> {
    public static final LogHandlerThreadExecutor$makeSureRunning$1 INSTANCE = null;

    public static final class a extends Handler {
        public a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 1) goto L14;
            Object r101 = r100.obj;
            if (r101 != null) goto L7;
            return;
        L7:
            if ((r101 instanceof com.suite.component.logger.c) == false) goto L16;
            com.suite.component.logger.c r102 = (com.suite.component.logger.c) r101;
            d.f460152a.getClass();
            long r103 = d.f460156e.decrementAndGet();
            if (r103 <= 2000) goto L17;
            com.suite.lark.component.logger.dynamic.a r104 = Log.f460091e;
            if (r104 == null) goto L18;
            r104.e(r102, r103);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    static {
        INSTANCE = new LogHandlerThreadExecutor$makeSureRunning$1();
    }

    public LogHandlerThreadExecutor$makeSureRunning$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Looper r100) {
        Intrinsics.checkNotNullParameter(r100, "looper");
        d r101 = d.f460152a;
        a r102 = new a(r100);
        d.f460152a.getClass();
        LinkedList<com.suite.component.logger.c> r103 = d.f460155d;
        monitor-enter(r103);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r103.isEmpty() == true) goto L11;
        Iterator<T> r104 = r103.iterator();     // Catch: Throwable -> L15
    L8:
        if (r104.hasNext() == false) goto L10;
        com.suite.component.logger.c r105 = (com.suite.component.logger.c) r104.next();     // Catch: Throwable -> L15
        d.f460152a.getClass();     // Catch: Throwable -> L15
        Message r106 = Message.obtain();     // Catch: Throwable -> L15
        r106.what = 1;     // Catch: Throwable -> L15
        r106.obj = r105;     // Catch: Throwable -> L15
        r102.sendMessage(r106);     // Catch: Throwable -> L15
        goto L8
    L10:
        d.f460155d.clear();     // Catch: Throwable -> L15
    L11:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r103);
        d.f460154c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Looper r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
