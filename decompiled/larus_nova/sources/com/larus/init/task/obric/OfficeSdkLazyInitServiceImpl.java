package com.larus.init.task.obric;

import android.os.Process;
import com.larus.common.apphost.AppHost;
import com.larus.init.task.InitOfficeSdkOnFeedTask;
import com.larus.init.task.InitOfficeSdkTask;
import com.larus.init.task.x0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.office.IOfficeSdkLazyInitService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\t"}, d2 = {"Lcom/larus/init/task/obric/OfficeSdkLazyInitServiceImpl;", "Lcom/obric/assistant/spi/office/IOfficeSdkLazyInitService;", "<init>", "()V", "tryInitOnUiEntry", "", "tryInitOnFirstFeedShown", "", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSdkLazyInitServiceImpl implements IOfficeSdkLazyInitService {

    public static final class a {
    }

    static {
    }

    public OfficeSdkLazyInitServiceImpl() {
    }

    @Override // com.obric.assistant.spi.office.IOfficeSdkLazyInitService
    public final void a() {
        FLogger r100 = FLogger.f375446a;
        r100.d("OfficeSdkLazyInitServiceImpl", "tryInitOnFirstFeedShown: received");
        if (x0.a() == true) goto L6;
        r100.i("OfficeSdkLazyInitController", "onRealFirstFeedShown skipped: lazy path not enabled");
        return;
    L6:
        if (x0.f351466b.compareAndSet(false, true) == true) goto L8;
        r100.i("OfficeSdkLazyInitController", "first feed init already dispatched, skip");
        return;
    L8:
        r100.i("OfficeSdkLazyInitController", "onRealFirstFeedShown: start (first UI shown), replay Feed + OnFeed, process=" + Process.myPid());
        x0.b();
        InitOfficeSdkTask r101 = new InitOfficeSdkTask();     // Catch: Exception -> L11
        r101.f351076a = true;     // Catch: Exception -> L11
        r101.run();     // Catch: Exception -> L11
    L24:
        InitOfficeSdkOnFeedTask r102 = new InitOfficeSdkOnFeedTask();     // Catch: Exception -> L16
        r102.f351074b = true;     // Catch: Exception -> L16
        r102.run();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        FLogger.f375446a.e("OfficeSdkLazyInitController", "InitOfficeSdkOnFeedTask failed", e);
        if (AppHost.f326268a.isTestChannel() == false) goto L27;
        throw e;
    L27:
        return;
    L11:
        e = move-exception;
        FLogger.f375446a.e("OfficeSdkLazyInitController", "InitOfficeSdkTask failed", e);
        if (AppHost.f326268a.isTestChannel() == false) goto L24;
        throw e;
    }

    @Override // com.obric.assistant.spi.office.IOfficeSdkLazyInitService
    public final boolean b() {
        boolean r100 = x0.a();
        FLogger.f375446a.i("OfficeSdkLazyInitServiceImpl", "tryInitOnUiEntry, handleLazy=" + r100);
        if (r100 == true) goto L6;
        return false;
    L6:
        x0.b();
        return true;
    }
}
