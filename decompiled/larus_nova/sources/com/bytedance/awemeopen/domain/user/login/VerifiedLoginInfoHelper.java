package com.bytedance.awemeopen.domain.user.login;

import android.app.Activity;
import com.bytedance.awemeopen.bizmodels.user.LoginMethod;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class VerifiedLoginInfoHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f198504d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoginHelper f198505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f198506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<Function1<com.bytedance.awemeopen.bizmodels.user.c, Unit>> f198507c;

    public static final class a {
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.awemeopen.bizmodels.user.f f198508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<com.bytedance.awemeopen.bizmodels.user.c, Unit> f198509b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(com.bytedance.awemeopen.bizmodels.user.f r100, Function1<? super com.bytedance.awemeopen.bizmodels.user.c, Unit> r101) {
            this.f198508a = r100;
            this.f198509b = r101;
        }

        @Override // com.bytedance.awemeopen.domain.user.login.e
        public final void a(LoginMethod r100, u64.b r101) {
            Intrinsics.checkNotNullParameter(r100, "loginMethod");
            Intrinsics.checkNotNullParameter(r101, "result");
            com.bytedance.awemeopen.bizmodels.user.f r102 = this.f198508a;
            Function4<Activity, LoginMethod, String, Map<String, String>, Unit> r103 = r102.f198228g;
            if (r103 == null) goto L5;
            Activity r104 = r102.getActivity();
            Intrinsics.checkNotNull(r104);
            com.bytedance.awemeopen.bizmodels.user.f r105 = this.f198508a;
            r103.invoke(r104, r100, r105.f198223b, r105.f198224c);
        L5:
            this.f198509b.invoke(com.bytedance.awemeopen.domain.user.b.a(r101));
        }

        @Override // com.bytedance.awemeopen.domain.user.login.e
        public final void b(LoginMethod r100, int r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "loginMethod");
            com.bytedance.awemeopen.bizmodels.user.f r101 = this.f198508a;
            Function6<Activity, LoginMethod, String, Map<String, String>, Integer, String, Unit> r102 = r101.f198229h;
            if (r102 == null) goto L5;
            Activity r103 = r101.getActivity();
            Intrinsics.checkNotNull(r103);
            com.bytedance.awemeopen.bizmodels.user.f r104 = this.f198508a;
            r102.invoke(r103, r100, r104.f198223b, r104.f198224c, Integer.valueOf(r110), r111);
        L5:
            this.f198509b.invoke(null);
        }
    }

    static {
    }

    public VerifiedLoginInfoHelper() {
        LoginHelper r100 = LoginHelper.f198497a;
        Intrinsics.checkNotNullParameter(r100, "loginHelper");
        this.f198505a = r100;
        this.f198507c = new HashSet();
    }

    public final void a(com.bytedance.awemeopen.bizmodels.user.c r100) {
        monitor-enter(this);
        Iterator<T> r101 = this.f198507c.iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L7;
        ((Function1) r101.next()).invoke(r100);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f198507c.clear();     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void b(com.bytedance.awemeopen.bizmodels.user.f r100, Function1<? super com.bytedance.awemeopen.bizmodels.user.c, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "loginConfig");
        Intrinsics.checkNotNullParameter(r110, "callback");
        boolean r101 = false;
        AoLogger.g("AosLogin", new Object[]{"--------------invoke getVerifiedLoginInfo()--------------"});
        AoLogger.g("AosLogin", new Object[]{"getVerifiedLoginInfo(),addVerifyCallbacks()"});
        if (r100.getActivity() != null) goto L6;
        a(null);
        return;
    L6:
        monitor-enter(this);
        this.f198507c.add(r110);     // Catch: Throwable -> L43
        monitor-exit(this);
        if (this.f198506b == false) goto L13;
        AoLogger.g("AosLogin", new Object[]{"getVerifiedLoginInfo(),isVerifying=true,return,but callback will been invoked after last getVerifiedLoginInfo finished!"});
        return;
    L13:
        this.f198506b = true;
        AoLogger.g("AosLogin", new Object[]{"getVerifiedLoginInfo(),isVerifying=true"});
        Function1<com.bytedance.awemeopen.bizmodels.user.c, Unit> r111 = new VerifiedLoginInfoHelper$getVerifiedToken$wrapCallback$1(this);
        this.f198505a.getClass();
        u64.b r102 = LoginHelper.b();
        if (r102 == null) goto L33;
        String r103 = r102.f548920a;
        if (r103 != null) goto L18;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == true) goto L33;
        String r105 = r102.f548921b;
        if (r105 != null) goto L26;
    L29:
        boolean r106 = true;
    L30:
        if (r106 == true) goto L33;
        r111.invoke(com.bytedance.awemeopen.domain.user.b.a(r102));
        return;
    L26:
        if (r105.length() == 0) goto L29;
        r106 = false;
        goto L30
    L18:
        if (r103.length() == 0) goto L21;
        r104 = false;
    L33:
        if (r102 == null) goto L41;
        String r107 = r102.f548920a;
        if (r107 != null) goto L37;
    L38:
        r101 = true;
    L39:
        if (r101 == false) goto L41;
        r100.f198225d = true;
        LoginHelper r108 = this.f198505a;
        c24.b r109 = r100.f198226e;
        r100.getClass();
        b24.a r112 = r100.f198227f;
        r108.getClass();
        LoginHelper.a(r109, null, r112);
        goto L41
    L37:
        if (r107.length() != 0) goto L39;
    L41:
        LoginHelper r113 = this.f198505a;
        Activity r114 = r100.getActivity();
        Intrinsics.checkNotNull(r114);
        String r115 = r100.f198223b;
        c24.b r116 = r100.f198226e;
        r100.getClass();
        b24.a r117 = r100.f198227f;
        b r118 = new b(r100, r111);
        Map<String, String> r119 = r100.f198224c;
        r113.getClass();
        LoginHelper.c(r114, r115, r116, null, r117, r118, r119);
        return;
    L43:
        th = move-exception;
        throw th;
    }
}
