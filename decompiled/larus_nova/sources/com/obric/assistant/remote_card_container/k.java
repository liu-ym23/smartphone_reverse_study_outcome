package com.obric.assistant.remote_card_container;

import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
public final class k implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBinder f391267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<yca.d.a> f391268b;

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IBinder r100 = this.f391267a;
        Ref.ObjectRef<yca.d.a> r101 = this.f391268b;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
        FLogger.f375446a.i("RemoteCardImpl", "binderDied, will dismiss menu");     // Catch: Throwable -> L19
        if (r100 == null) goto L25;
        r100.unlinkToDeath(this, 0);     // Catch: Throwable -> L19
    L25:
        yca.d.a r103 = r101.element;     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        r103.dismiss();     // Catch: Throwable -> L12
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L19
        if (r106 == null) goto L17;
        FLogger.f375446a.w("RemoteCardImpl", "dismiss menu failed", r106);     // Catch: Throwable -> L19
    L17:
        Object r107 = Result.m9449constructorimpl(Result.m9448boximpl(r105));     // Catch: Throwable -> L19
    L21:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L29;
        FLogger.f375446a.w("RemoteCardImpl", "linkToDeath failed", r108);
        return;
    L29:
        return;
    L9:
        r104 = null;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L19
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public k(IBinder r100, Ref.ObjectRef<yca.d.a> r101) {
        this.f391267a = r100;
        this.f391268b = r101;
    }
}
