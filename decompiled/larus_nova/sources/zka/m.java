package zka;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f572726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<Messenger> f572727b;

    public m() {
        this.f572726a = new AtomicBoolean(false);
        this.f572727b = new CopyOnWriteArraySet();
    }

    public final boolean a(Context r100, Messenger r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "messenger");
        this.f572727b.add(r101);
        Context r102 = r100.getApplicationContext();
        if (this.f572726a.compareAndSet(false, true) == false) goto L18;
        l r103 = new l(this, r102, new Handler(Looper.getMainLooper()));
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        r102.getContentResolver().registerContentObserver(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider/server_alive"), false, r103);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L18:
        Bundle r106 = new Bundle();     // Catch: Exception -> L15
        r106.putParcelable("alarmTtsMessenger", r101);     // Catch: Exception -> L15
        Bundle r107 = r100.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_REGISTER_ALARM_TTS_MESSENGER, null, r106);     // Catch: Exception -> L15
        if (r107 == null) goto L20;
        return r107.getBoolean("accepted", false);
    L20:
        return false;
    L21:
        return false;
    }
}
