package com.larus.init.task.anr;

import com.larus.apm.api.IApmTrace;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.settings.value.gf;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/init/task/anr/InitAnrTrackTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "<init>", "()V", "TAG", "", "run", "", "trackAnr", "timeFormatter", "Ljava/text/SimpleDateFormat;", "getCurTime", "timeMillis", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitAnrTrackTask extends bf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDateFormat f351165b;

    public final void a() {
        AppHost.Companion r100 = AppHost.f326268a;
        boolean r101 = r100.isDebug();
        boolean r102 = r100.isTestChannel();
        e10 r103 = e10.f368561a;
        int r104 = l0.f375430a;
        boolean r105 = ((Boolean) l0.a(Boolean.FALSE, new gf())).booleanValue();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
        if (r105 == true) goto L8;
        IApmTrace.f286937a.a("flow_anr_track", "false");
        FLogger.f375446a.i(this.f351164a, "trackAnr, disable");
        return;
    L8:
        FLogger.f375446a.i(this.f351164a, "anrTrack, isDebug: " + r101 + ", isTestChannel: " + r102 + ", anrTrackEnable: " + r105);
        IApmTrace.f286937a.a("flow_anr_track", "true");
        c r106 = new c(this);
        IBootProtectorLauncher.f317602a.getClass();
        Intrinsics.checkNotNullParameter(r106, "listener");
        IBootProtectorLauncher r107 = IBootProtectorLauncher.a.c();
        if (r107 == null) goto L13;
        r107.a(r106);
        return;
    }

    public InitAnrTrackTask() {
        this.f351164a = "AnrTrack";
        this.f351165b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
