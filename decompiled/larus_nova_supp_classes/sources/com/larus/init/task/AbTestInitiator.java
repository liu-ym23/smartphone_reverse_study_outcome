package com.larus.init.task;

import android.util.EventsUtils;
import com.bytedance.dataplatform.o;
import com.bytedance.dataplatform.u;
import com.bytedance.dataplatform.v;
import com.google.gson.Gson;
import com.larus.abtest.api.IAbTest;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.init.IAbTestInitiator;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0003\b\u000b\u0014\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/init/task/AbTestInitiator;", "Lcom/larus/init/IAbTestInitiator;", "<init>", "()V", "initAbTest", XmlPullParser.NO_NAMESPACE, "waitWhenNotInit", "settings", "com/larus/init/task/AbTestInitiator$settings$1", "Lcom/larus/init/task/AbTestInitiator$settings$1;", "serializationService", "com/larus/init/task/AbTestInitiator$serializationService$1", "Lcom/larus/init/task/AbTestInitiator$serializationService$1;", "exposureService", "Lcom/bytedance/dataplatform/IExposureService;", "netService", "Lcom/bytedance/dataplatform/INetService;", "experimentListener", "Lcom/bytedance/dataplatform/IExperimentListener;", "accountStatusCallback", "com/larus/init/task/AbTestInitiator$accountStatusCallback$1", "Lcom/larus/init/task/AbTestInitiator$accountStatusCallback$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class AbTestInitiator implements IAbTestInitiator {
    public static final /* synthetic */ int g = 0;
    public final e a;
    public final d b;
    public final com.larus.init.task.a c;
    public final com.larus.init.task.b d;
    public final c e;
    public final b f;

    public static final class a {
    }

    public static final class b implements n38.j {
        public b() {
        }

        @Override // n38.j
        public final void a(n38.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            FLogger.a.i("InitAbTest", "onUserDidOffline businessScene = " + r4.d);
            o.g(XmlPullParser.NO_NAMESPACE);
            IAbTest r5 = (IAbTest) ServiceManager.get().getService(IAbTest.class);
            if (r5 == null) goto L6;
            r5.refresh();
            return;
        }

        @Override // n38.j
        public final void b(n38.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            FLogger.a.i("InitAbTest", "onUserDidOnline businessScene = " + r4.d);
            o.g(r4.b.a);
            IAbTest r5 = (IAbTest) ServiceManager.get().getService(IAbTest.class);
            if (r5 == null) goto L6;
            r5.refresh();
            return;
        }
    }

    public static final class d implements u {
        public final Gson a;

        public d() {
            this.a = new Gson();
        }

        @Override // com.bytedance.dataplatform.u
        public final <T> T a(String r8, Type r9) {
            if (r8 != null) goto L25;
        L10:
            boolean r4 = true;
        L12:
            if (r4 == true) goto L21;
            if (r9 == null) goto L21;
            T r5 = (T) this.a.fromJson(r8, r9);
            if (r5 != null) goto L19;
            FLogger.a.w("InitAbTest", "parseObject: input is " + r8 + ",clazz is " + r9 + ", result is null");     // Catch: Throwable -> L8
            return null;
        L19:
            FLogger.a.i("InitAbTest", "parseObject success, result: " + r5);     // Catch: Throwable -> L8
            return r5;
        L21:
            FLogger.a.w("InitAbTest", "parseObject: input is " + r8 + ",clazz is " + r9);     // Catch: Throwable -> L8
            return null;
        L25:
        L8:
            th = move-exception;
            FLogger.a.e("InitAbTest", "parseObject:Failed to parse JSON to OBJECT, input is " + r8 + ",clazz is " + r9 + ", " + th.getMessage(), th);
            return null;
        L5:
            if (r8.length() == 0) goto L10;
            r4 = false;
            goto L12
        }
    }

    public static final class e implements v {
        public e() {
        }

        @Override // com.bytedance.dataplatform.v
        public final Object G0(String r1, Type r2) {
            Intrinsics.checkNotNullParameter(r2, "tClass");
            return null;
        }
    }

    static {
    }

    @Override // com.larus.init.IAbTestInitiator
    public final void b() {
        o.m = true;
    }

    @Override // com.larus.init.IAbTestInitiator
    public final void a() {
        FLogger r0 = FLogger.a;
        r0.i("InitAbTest", "ABTestSDK init start");
        o.m = true;
        hj4.d.a = new com.larus.init.task.d();
        hj4.d.d = true;
        hj4.d.c = true;
        o.j = this.e;
        o.e(AppHost.a.getApplication(), "https://abtest-ch.snssdk.com/common", this.a, this.b, this.c, this.d);
        String r2 = AccountService.a.getUserId();
        if (o0.d(r2) == false) goto L7;
        IAbTest r3 = (IAbTest) ServiceManager.get().getService(IAbTest.class);
        if (r3 == null) goto L7;
        r3.t(r2);
    L7:
        IApplog.a.f(new com.larus.init.task.e());
        ILoginService r4 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r4 == null) goto L10;
        r4.f(this.f, Boolean.FALSE);
    L10:
        r0.i("InitAbTest", "ABTestSDK init finished");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.init.task.a] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.init.task.b] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.init.task.c] */
    public AbTestInitiator() {
        this.a = new e();
        this.b = new d();
        this.c = new com.larus.init.task.a();
        this.d = new com.larus.init.task.b();
        this.e = new c();
        this.f = new b();
    }
}
