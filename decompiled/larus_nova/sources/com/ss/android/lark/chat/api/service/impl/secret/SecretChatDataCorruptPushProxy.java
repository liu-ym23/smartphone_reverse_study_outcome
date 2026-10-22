package com.ss.android.lark.chat.api.service.impl.secret;

import a2b.i;
import c0c.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class SecretChatDataCorruptPushProxy extends b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f411649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f411650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<i> f411651d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.i
    public final void dispose() {
        this.f411649b.dispose();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f411651d.c().dispose();
    }

    @Override // a2b.i
    public final void u1(i.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f411651d.d(new com.ss.android.lark.passportc.convention.b.C5239b(i.a.class, r100));
    }

    @Override // a2b.i
    public final void yc(final i.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f411651d.a(new com.ss.android.lark.passportc.convention.b.C5239b(i.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new SecretChatDataCorruptPushProxy$addListener$1(r100), new SecretChatDataCorruptPushProxy$addListener$2(r100)));
    }

    public SecretChatDataCorruptPushProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<i> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), i.class), i.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411649b = r103.b();
        this.f411650c = r101;
        this.f411651d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        Intrinsics.checkNotNullParameter(r101, "toState");
        i r102 = this.f411651d.c();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.secret.SecretChatDataCorruptPush");
        SecretChatDataCorruptPush r103 = (SecretChatDataCorruptPush) r102;
        if (Intrinsics.areEqual(r103.f411642a, "absent_user") == false) goto L5;
        Log.w("SChatDataCorruptPush", "from user is ABSENT_USER, call release manually");
        r103.dispose();
    L5:
        v r104 = this.f411650c;
        g r105 = r101.a();
        if (r105 == null) goto L9;
        UserSession r106 = r105.f475034b;
        if (r106 == null) goto L9;
    L10:
        SecretChatDataCorruptPush r107 = (SecretChatDataCorruptPush) k.b(r104.c(r106), SecretChatDataCorruptPush.class);
        this.f411651d.e(r107);
        return;
    L9:
        r106 = ContainerConstsKt.a();
        goto L10
    }
}
