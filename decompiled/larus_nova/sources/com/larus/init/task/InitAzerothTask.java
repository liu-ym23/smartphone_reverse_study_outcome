package com.larus.init.task;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.FirstInitStyle;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/init/task/InitAzerothTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitAzerothTask extends bf6.d implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351025b;

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a implements com.larus.platform.api.y {
        public a() {
        }

        @Override // com.larus.platform.api.y
        public final boolean a() {
            return true;
        }

        @Override // com.larus.platform.api.y
        public final void onGetId(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
            Intrinsics.checkNotNullParameter(r102, "ssid");
            com.larus.security.api.d.a();
        }
    }

    @Override // bg9.i
    public final void runInternal() {
        com.larus.platform.service.o r100 = com.larus.platform.service.o.f365780a;
        if (r100.getDeviceId().length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        com.larus.security.api.d.a();
        return;
    L8:
        r100.e(new a());
        return;
    L5:
        r101 = false;
        goto L6
    }

    public InitAzerothTask() {
        this.f351024a = ServiceType.BASIC_SERVICE;
        this.f351025b = FirstInitStyle.AsyncThreadWhenFirst;
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
        return this.f351024a;
    }

    @Override // bg9.i
    public final String v() {
        return this.f351025b;
    }
}
