package com.ss.android.lark.framework.assembly.rust;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import com.ss.android.lark.framework.assembly.sp.InitUniStoreTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public class InitRustSdkTask extends AbstractLaunchTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider<com.bytedance.lark.sdk.refactor.n> f425679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Provider<IAppStateSyncService> f425680d;

    public class a implements com.ss.android.lark.sdk.e {
        public a() {
        }

        @Override // com.ss.android.lark.sdk.e
        public final String a(String r100) {
            return f0.a(r100);
        }

        @Override // com.ss.android.lark.sdk.e
        public final void b(JSONObject r100) {
            Statistics.sendEvent("lark_rust_ffi_userid_check_dev", r100);
        }

        @Override // com.ss.android.lark.sdk.e
        public final void w(String r100) {
            Log.w("sdk", r100);
        }
    }

    public class b implements com.ss.android.lark.sdk.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f425681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InitRustSdkTask f425682b;

        @Override // com.ss.android.lark.sdk.d
        public final void b() {
        }

        @Override // com.ss.android.lark.sdk.d
        public final boolean d() {
            if (com.larksuite.framework.utils.z.e(this.f425681a) == true) goto L6;
            return false;
        L6:
            return true;
        }

        @Override // com.ss.android.lark.sdk.d
        public final boolean e() {
            if (com.larksuite.framework.utils.z.e(this.f425681a) == false) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // com.ss.android.lark.sdk.d
        public final String getUserId() {
            return ((yzb.b) e0c.k.a(LarkContext.getApplication(), yzb.b.class)).d();
        }

        @Override // com.ss.android.lark.sdk.d
        public final Long a(String r100) {
            return this.f425682b.f425679c.get().a(r100);
        }

        @Override // com.ss.android.lark.sdk.d
        public final boolean c(Command r100) {
            if (r100 != Command.SET_DEVICE) goto L5;
        L10:
            return true;
        L5:
            if (r100 == Command.MAKE_USER_ONLINE) goto L10;
            if (r100 == Command.GET_INIT_SETTINGS) goto L10;
            return false;
        }

        public b(InitRustSdkTask r100, Context r101) {
            this.f425682b = r100;
            this.f425681a = r101;
        }
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask
    public final List<Class<? extends ILaunchTask>> i() {
        ArrayList r100 = new ArrayList();
        r100.add(InitLogTask.class);
        r100.add(InitUniStoreTask.class);
        return r100;
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        int r101 = c0.f425692a;
        com.ss.android.lark.sdk.i.f439881a = new a();
        com.ss.android.lark.sdk.i.f439882b = new b(this, r100);
        com.ss.android.lark.sdk.i.f439883c = new j();
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new i(this));
    }

    @Inject
    public InitRustSdkTask(Provider<com.bytedance.lark.sdk.refactor.n> r100, Provider<IAppStateSyncService> r101) {
        this.f425679c = r100;
        this.f425680d = r101;
    }
}
