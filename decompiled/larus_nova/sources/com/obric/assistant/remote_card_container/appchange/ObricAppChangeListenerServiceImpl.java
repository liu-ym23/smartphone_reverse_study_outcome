package com.obric.assistant.remote_card_container.appchange;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.appchange.IObricAppChangeListenerService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/remote_card_container/appchange/ObricAppChangeListenerServiceImpl;", "Lcom/obric/assistant/appchange/IObricAppChangeListenerService;", "<init>", "()V", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppChangeListenerServiceImpl implements IObricAppChangeListenerService {
    public ObricAppChangeListenerServiceImpl() {
    }

    @Override // com.obric.assistant.appchange.IObricAppChangeListenerService
    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppChangeListener.a r101 = AppChangeListener.f391229a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (AppChangeListener.f391230b != null) goto L27;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (AppChangeListener.f391230b == null) goto L10;
        monitor-exit(r101);
        return;
    L10:
        AppChangeListener r102 = new AppChangeListener();     // Catch: Throwable -> L20
        Context r103 = r100.getApplicationContext();     // Catch: Throwable -> L20
        if (r103 != null) goto L23;
        r103 = r100;
    L23:
        ContextCompat.registerReceiver(r103, r102, AppChangeListener.a.a(), null, null, 4);     // Catch: Exception -> L15 Throwable -> L20
        AppChangeListener.f391230b = r102;     // Catch: Exception -> L15 Throwable -> L20
        FLogger.f375446a.i("AppChangeListener", "register AppChangeListener success");     // Catch: Exception -> L15 Throwable -> L20
    L17:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("AppChangeListener", "register AppChangeListener failed", e);     // Catch: Throwable -> L20
        goto L17
    }
}
