package com.larus.init.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import com.larus.office.base.OfficeSdkInitor;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.OfficeSDK;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.LaunchTaskFlag;
import com.ss.android.lark.officesdk.executor.OfficeSDKRuntime;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/init/task/InitOfficeSdkOnFeedTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "bypassObricSkip", "", "runLazyInit", "", "runInternal", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitOfficeSdkOnFeedTask extends bf6.a implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f351074b;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r100 = FLogger.f375446a;
        r100.d("InitOfficeSdkOnFeedTask", "runInternal: bypass=" + this.f351074b);
        AtomicBoolean r101 = x0.f351465a;
        if (this.f351074b == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        r100.i("InitOfficeSdkOnFeedTask", "skip: lazy=true, deferred to first UI shown");
        return;
    L12:
        if (com.larus.platform.exp.q.f365393a.b() == true) goto L14;
        return;
    L14:
        AtomicBoolean r103 = OfficeSDK.f433090a;
        LaunchExperiment r104 = OfficeSDK.f433091b.f530687a;
        r100.i("InitOfficeSdkOnFeedTask", "run: " + r104);
        if (r104.isBeforeFirstFeed() == true) goto L17;
        return;
    L17:
        OfficeSDKRuntime r105 = OfficeSDK.f433092c;
        if (r105 == null) goto L33;
        LaunchTaskFlag r106 = r105.getRuntimeFlag();
        if (r106 != null) goto L23;
        return;
    L23:
        if (r106.getSdkInitReadyFlag().get() == true) goto L26;
        r106.getFirstFeedShowFlag().compareAndSet(false, true);
        r100.i("InitOfficeSdkOnFeedTask", "im sdk not init ready!");
        return;
    L26:
        r100.i("InitOfficeSdkOnFeedTask", "do initImSDKFeed");
        OfficeSdkInitor.f360451a.getClass();
        IOfficeSDKLifeCycle r107 = OfficeSdkInitor.f360456f;
        if ((r107 instanceof tm9.a) == false) goto L29;
        tm9.a r108 = (tm9.a) r107;
    L30:
        if (r108 == null) goto L34;
        r108.X0(!r106.getRustLoginFlag().get());
        return;
    L34:
        return;
    L29:
        r108 = null;
        goto L30
    L33:
        return;
    L5:
        if (x0.a() == false) goto L7;
        r102 = true;
        goto L8
    }

    public InitOfficeSdkOnFeedTask() {
        this.f351073a = ServiceType.OFFICE;
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
        return this.f351073a;
    }
}
