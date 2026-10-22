package doc;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Singleton
public final class a implements c, com.ss.android.lark.passportc.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f469531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jdb.e f469532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f469533c;

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // doc.c
    public final boolean a() {
        Intrinsics.checkNotNullParameter("lark.scs.service_hook_npe_fix", "name");
        return this.f469532b.B0(this.f469533c, "lark.scs.service_hook_npe_fix");
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final com.ss.android.lark.passportc.api.j getPassport() {
        return this.f469531a;
    }

    @Inject
    public a(com.ss.android.lark.passportc.api.j r100, jdb.e r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "fgService");
        this.f469531a = r100;
        this.f469532b = r101;
        this.f469533c = r100.g();
        r100.e(this);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
        Intrinsics.checkNotNullParameter(r101, "currentState");
        f0c.g r102 = r101.a();
        if (r102 == null) goto L7;
        User r103 = r102.f475033a;
        if (r103 == null) goto L7;
        String r104 = r103.userId;
    L8:
        this.f469533c = r104;
        return;
    L7:
        r104 = null;
        goto L8
    }
}
