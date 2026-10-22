package com.ss.android.lark.passport_user.container;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.k;
import com.ss.android.lark.passportc.api.l;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.internal.r;
import com.ss.android.lark.utils.statistics.PerfLog;
import f0c.g;
import f0c.h;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0018BO\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/passport_user/container/CreateUserComponentTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "multiOnlineFG", "Ljavax/inject/Provider;", "Lcom/ss/android/lark/passportc/api/IMultiOnlineFG;", "passportStateManager", "Lcom/ss/android/lark/passportc/api/IPassportStateManager;", "passportStateManager2", "Lcom/ss/android/lark/passportc/api/IPassportStateManager2;", "passportGlobalService", "Lcom/ss/android/lark/passportc/api/IPassportGlobalService;", "larkUserListApi", "Lcom/ss/android/lark/passport_user/api/container/ILarkUserListApi;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isUserComponentCreated", "", "userId", "", "Companion", "lark-user_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateUserComponentTask extends AbstractLaunchTask<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider<i> f438089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Provider<l> f438090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Provider<k> f438091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Provider<j> f438092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Provider<yzb.b> f438093g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f438094a = null;

        static {
            f438094a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Log.e("CreateUserComponentTask", "create user component v2 doOnError: " + ((Throwable) r100).getCause() + ' ');
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f438095a = null;

        static {
            f438095a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            j0c.d r101 = (j0c.d) r100;
            Log.i("CreateUserComponentTask", "create user component v2 doOnNext");
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f438096a = null;

        static {
            f438096a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Log.i("CreateUserComponentTask", "create user component v2 doOnComplete");
        }
    }

    static {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r101 = System.currentTimeMillis();
        if (this.f438093g.get().isLogin() == false) goto L52;
        Log.i("CreateUserComponentTask", "isLogin cost = " + (System.currentTimeMillis() - r101) + " ms ");
        User r102 = this.f438093g.get().getForegroundUser();
        boolean r103 = true;
        if (r102 == null) goto L41;
        String r104 = r102.userId;
        Iterator<T> r105 = this.f438092f.get().a().iterator();
    L7:
        Object r106 = null;
        if (r105.hasNext() == false) goto L17;
        Object r107 = r105.next();
        g r108 = ((f0c.b) r107).a();
        if (r108 == null) goto L15;
        User r109 = r108.f475033a;
        if (r109 == null) goto L15;
        r106 = r109.userId;
    L15:
        if (Intrinsics.areEqual(r106, r104) == false) goto L7;
        r106 = r107;
    L17:
        f0c.b r110 = (f0c.b) r106;
        if (r110 == null) goto L23;
        h r111 = r110.f475024b;
        if (r111 == null) goto L23;
        UserState r112 = r111.f475035a;
        if (r112 == null) goto L23;
    L25:
        if (r112 != UserState.ONLINE) goto L27;
        boolean r113 = true;
    L28:
        if (r113 == true) goto L41;
    L36:
        th = move-exception;
        Log.e("CreateUserComponentTask", new Throwable("create user component error", th), true);
        if (DevEnvUtil.isDevelopPackage(com.larksuite.framework.utils.b.f285948a) == false) goto L54;
        throw th;
    L54:
        return;
    L31:
        if (this.f438089c.get().c() == false) goto L33;
        k r114 = this.f438091e.get();     // Catch: Throwable -> L36
        UpdateUserRequest.a r115 = new UpdateUserRequest.a();     // Catch: Throwable -> L36
        UserState r116 = UserState.OFFLINE;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r102, "targetUser");     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r116, "targetState");     // Catch: Throwable -> L36
        r115.f438266a = new com.ss.android.lark.passportc.impl.v2.entity.d(r102, r116, false);     // Catch: Throwable -> L36
        Observable<j0c.d> r117 = r114.c(r115.a(), com.ss.android.lark.passportc.api.d.a(com.ss.android.lark.passportc.api.d.f438111g, Scene.CREATE_USER_COMPONENT), r.f438480a);     // Catch: Throwable -> L36
    L34:
        j0c.d r118 = r117.doOnError(b.f438094a).doOnNext(c.f438095a).doOnComplete(d.f438096a).blockingFirst();     // Catch: Throwable -> L36
        return;
    L33:
        r117 = this.f438090d.get().b(new com.ss.android.lark.passportc.api.a(r102), com.ss.android.lark.passportc.api.d.f438111g, r.f438480a);     // Catch: Throwable -> L36
        goto L34
    L27:
        r113 = false;
    L23:
        r112 = UserState.ABSENT;
    L41:
        StringBuilder r119 = new StringBuilder("create user component v2 skipped, user is null = ");
        if (r102 == null) goto L45;
        r103 = false;
    L45:
        r119.append(r103);
        Log.e("CreateUserComponentTask", r119.toString());
        return;
    }

    @Inject
    public CreateUserComponentTask(Provider<i> r100, Provider<l> r101, Provider<k> r102, Provider<j> r103, Provider<yzb.b> r104) {
        Intrinsics.checkNotNullParameter(r100, "multiOnlineFG");
        Intrinsics.checkNotNullParameter(r101, "passportStateManager");
        Intrinsics.checkNotNullParameter(r102, "passportStateManager2");
        Intrinsics.checkNotNullParameter(r103, "passportGlobalService");
        Intrinsics.checkNotNullParameter(r104, "larkUserListApi");
        this.f438089c = r100;
        this.f438090d = r101;
        this.f438091e = r102;
        this.f438092f = r103;
        this.f438093g = r104;
    }
}
