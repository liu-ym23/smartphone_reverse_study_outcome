package com.ss.android.lark.im.sdk.usercontainer;

import com.ss.android.lark.biz.im.api.h0;
import com.ss.android.lark.biz.im.api.i0;
import com.ss.android.lark.biz.im.api.l0;
import com.ss.android.lark.chat.service.impl.ImSdkChatterPushImplV2;
import com.ss.android.lark.chat.service.impl.w;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import m6b.t;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkChatterPushProxy extends c0c.b implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f426190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f426191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<t> f426192d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.t
    public final void A5(l0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426192d.d(new com.ss.android.lark.passportc.convention.b.C5239b(l0.class, r100));
    }

    @Override // m6b.t
    public final void J1(final h0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426192d.a(new com.ss.android.lark.passportc.convention.b.C5239b(h0.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatterPushProxy$addPushChatterListener$1(r100), new ImSdkChatterPushProxy$addPushChatterListener$2(r100)));
    }

    @Override // m6b.t
    public final void h5(w r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426192d.d(new com.ss.android.lark.passportc.convention.b.C5239b(w.class, r100));
    }

    @Override // m6b.t
    public final void la(final i0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426192d.a(new com.ss.android.lark.passportc.convention.b.C5239b(i0.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatterPushProxy$addPushChattersListener$1(r100), new ImSdkChatterPushProxy$addPushChattersListener$2(r100)));
    }

    @Override // c0c.b
    public final void mf(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ImSdkChatterPushProxy", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        t r101 = this.f426192d.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ImSdkChatterPushImplV2");
        ImSdkChatterPushImplV2 r102 = (ImSdkChatterPushImplV2) r101;
        r102.getClass();
        Log.i("ImSdkChatterPushImplV2", "release for user " + r102.f416360a);
        r102.f416362c.dispose();
    }

    @Override // c0c.b
    public final void of(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ImSdkChatterPushProxy", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // m6b.t
    public final void r8(final l0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426192d.a(new com.ss.android.lark.passportc.convention.b.C5239b(l0.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatterPushProxy$addPushMineChatterChangedListener$1(r100), new ImSdkChatterPushProxy$addPushMineChatterChangedListener$2(r100)));
    }

    @Override // m6b.t
    public final void te(h0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426192d.d(new com.ss.android.lark.passportc.convention.b.C5239b(h0.class, r100));
    }

    @Override // m6b.t
    public final void w8(i0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426192d.d(new com.ss.android.lark.passportc.convention.b.C5239b(i0.class, r100));
    }

    @Override // m6b.t
    public final void x5(final w r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426192d.a(new com.ss.android.lark.passportc.convention.b.C5239b(w.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ImSdkChatterPushProxy$addPushChannelNicknameListener$1(r100), new ImSdkChatterPushProxy$addPushChannelNicknameListener$2(r100)));
    }

    public ImSdkChatterPushProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<t> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), t.class), t.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f426190b = r103.b();
        this.f426191c = r101;
        this.f426192d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        StringBuilder r102 = new StringBuilder("preparing, fromUser: ");
        String r103 = "";
        if (r100 == null) goto L8;
        UserSession r104 = r100.f475034b;
        if (r104 == null) goto L8;
        String r105 = r104.f438138b;
        if (r105 == null) goto L8;
    L9:
        r102.append(r105);
        r102.append(", toUser: ");
        if (r101 == null) goto L17;
        UserSession r106 = r101.f475034b;
        if (r106 == null) goto L17;
        String r107 = r106.f438138b;
        if (r107 == null) goto L17;
        r103 = r107;
    L17:
        r102.append(r103);
        Log.i("ImSdkChatterPushProxy", r102.toString());
        t r108 = this.f426192d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ImSdkChatterPushImplV2");
        ImSdkChatterPushImplV2 r109 = (ImSdkChatterPushImplV2) r108;
        if (Intrinsics.areEqual(r109.f416360a, "absent_user") == false) goto L20;
        Log.w("ImSdkChatterPushProxy", "from user is ABSENT_USER, call release manually");
        Log.i("ImSdkChatterPushImplV2", "release for user " + r109.f416360a);
        r109.f416362c.dispose();
    L20:
        v r110 = this.f426191c;
        if (r101 == null) goto L24;
        UserSession r111 = r101.f475034b;
        if (r111 == null) goto L24;
    L25:
        this.f426192d.e((t) k.b(r110.c(r111), t.class));
        return;
    L24:
        r111 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }
}
