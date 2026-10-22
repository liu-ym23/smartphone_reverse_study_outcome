package com.ss.android.lark.active.user.impl;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.g;
import com.ss.android.lark.passportc.api.j;
import f0c.f;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;
import jdb.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class c implements nua.c.a, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f408625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f408626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MultiUserOnlineFgRepository f408627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Inject
    public yzb.b f408628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f408629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C4742c f408630f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f408631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f408632b;

        public b(f r100, c r101) {
            this.f408631a = r100;
            this.f408632b = r101;
        }

        public final void a() {
            String r100 = this.f408631a.f475032c.f475033a.userId;
            Log.i("MultiUserOnlineFGController", "afterUserOnline, newUserId=" + r100);
            boolean r101 = this.f408632b.f408626b.B0(r100, "messenger.multiuser.allow_multiuser");
            User r102 = this.f408631a.f475032c.f475033a;
            Intrinsics.checkNotNullParameter(r102, "<this>");
            boolean r103 = false;
            if (Intrinsics.areEqual(r102.userUnit, "useast15a") == false) goto L7;
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage() == false) goto L7;
            boolean r104 = true;
        L8:
            MultiUserOnlineFgRepository r105 = this.f408632b.f408627c;
            if (r101 == false) goto L12;
            if (r104 == true) goto L12;
            boolean r106 = true;
        L13:
            r105.g(r106, !r104);
            Log.i("MultiUserOnlineFGController", "updateFeatureAllowed, allow_multiuser=" + r101 + ", uid=" + r100 + ", isTTP=" + r104);
            c r107 = this.f408632b;
            String r108 = r107.f408629e;
            if (r108 == null) goto L16;
            r107.f408626b.Kb(r108, r107.f408630f, "_normal_fg");
        L16:
            c r109 = this.f408632b;
            r109.f408626b.T(r100, "messenger.multiuser.allow_multiuser", r109.f408630f, "_normal_fg");
            c r110 = this.f408632b;
            r110.f408629e = r100;
            yzb.b r111 = r110.f408628d;
            if (r111 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("larkUserService");
            r111 = null;
        L20:
            Iterator<User> r112 = r111.getAllValidUserList().iterator();
        L22:
            if (r112.hasNext() == false) goto L28;
            String r113 = r112.next().userId;
            if (r113 == null) goto L22;
            boolean r114 = this.f408632b.f408626b.B0(r113, "messenger.multiuser.enable_multiuser");
            Log.i("MultiUserOnlineFGController", "updateFeatureAllowed, enable_multiuser=" + r114 + ", uid=" + r113);
            if (r114 == false) goto L22;
            Log.i("MultiUserOnlineFGController", "enable_multiuser = true, uid=".concat(r113));
            r103 = true;
        L28:
            com.ss.android.lark.featuregating.b r115 = this.f408632b.f408627c.e();
            r115.getClass();
            Intrinsics.checkNotNullParameter("messenger.multiuser.enable_multiuser", "fgKey");
            com.ss.android.lark.storage.kv.flash.c r116 = r115.f420728a;
            r116.getClass();
            Intrinsics.checkNotNullParameter("messenger.multiuser.enable_multiuser", "key");
            r116.f441038a.putBoolean("messenger.multiuser.enable_multiuser", r103);
            Log.i("MultiUserOnlineFGController", "updateFeatureEnable, enable_multiuser=" + r103);
            return;
        L12:
            r106 = false;
        L7:
            r104 = false;
            goto L8
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

    /* JADX INFO: renamed from: com.ss.android.lark.active.user.impl.c$c, reason: collision with other inner class name */
    public static final class C4742c implements jdb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f408633a;

        public C4742c(c r100) {
            this.f408633a = r100;
        }

        @Override // jdb.c
        public final void a(boolean r100) {
            this.f408633a.f408627c.g(r100, true);
            Log.i("MultiUserOnlineFGController", "onFeatureAllowedUpdate, updateFeatureAllowed=" + r100);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // nua.c.a
    public final void init() {
        this.f408625a.e(this);
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final j getPassport() {
        return this.f408625a;
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new b(r100, this));
    }

    @Inject
    public c(j r100, e r101, MultiUserOnlineFgRepository r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "globalFgService");
        Intrinsics.checkNotNullParameter(r102, "multiOnlineFgRepo");
        this.f408625a = r100;
        this.f408626b = r101;
        this.f408627c = r102;
        this.f408630f = new C4742c(this);
    }
}
