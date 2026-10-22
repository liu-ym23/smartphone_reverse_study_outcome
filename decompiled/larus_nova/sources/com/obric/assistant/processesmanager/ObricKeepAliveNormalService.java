package com.obric.assistant.processesmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.IObricReporter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import pfa.o;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/processesmanager/ObricKeepAliveNormalService;", "Landroid/app/Service;", "<init>", "()V", "keepAliveMidiLevel", "", "getKeepAliveMidiLevel", "()Z", "keepAliveMidiLevel$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", LiveCommonConstants.REASON_ON_DEDTROY, "onBind", "Landroid/os/IBinder;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricKeepAliveNormalService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f391163b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f391164a;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        FLogger.f375446a.i("ObricKeepAliveNormalService", WidgetCostModule.TYPE_ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        FLogger.f375446a.i("ObricKeepAliveNormalService", "onDestroy: ");
        super.onDestroy();
    }

    public ObricKeepAliveNormalService() {
        this.f391164a = LazyKt.lazy(new o());
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L13;
        IObricReporter.f391335a.getClass();
        IObricReporter r104 = IObricReporter.a.a();
        if (r104 == null) goto L13;
        r104.c();
    L13:
        if (((Boolean) this.f391164a.getValue()).booleanValue() == false) goto L15;
        return 1;
    L15:
        return 2;
    L5:
        if (r100.hasExtra("caller") != true) goto L7;
        r103 = true;
        goto L8
    }
}
