package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.bt;
import com.larus.settings.value.e10;
import com.larus.settings.value.vu;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitDecorViewDebugTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "scene", "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitDecorViewDebugTask extends d implements bg9.i {
    public final String a;
    public final String b;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        AppHost.Companion r0 = AppHost.a;
        boolean r1 = r0.isDebug();
        boolean r2 = r0.isTestChannel();
        e10 r3 = e10.a;
        int r4 = l0.a;
        Boolean r5 = Boolean.FALSE;
        boolean r6 = ((Boolean) l0.a(r5, new vu())).booleanValue();
        boolean r7 = ((Boolean) l0.a(r5, new bt())).booleanValue();
        if (r1 == true) goto L7;
        if (r2 == true) goto L7;
        if (r6 == true) goto L7;
        if (r7 == true) goto L7;
        return;
    L7:
        FLogger r8 = FLogger.a;
        r8.i(this.a, "runInternal, isDebug: " + r1 + ", isTestChannel: " + r2 + ", canDebug: " + r6 + ", canProtect: " + r7);
        r8.i(this.a, "registerActivityLifecycleCallbacks");
        r0.getApplication().registerActivityLifecycleCallbacks(new a(this, r7));
    }

    public InitDecorViewDebugTask() {
        this.a = "InitDecorViewDebugTask";
        this.b = "Basic";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.b;
    }
}
