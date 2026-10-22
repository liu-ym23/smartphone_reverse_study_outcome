package com.ss.android.lark.im.sdk.usercontainer;

import com.ss.android.lark.biz.im.api.f1;
import com.ss.android.lark.biz.im.api.k0;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.service.impl.MessagePushV2;
import com.ss.android.lark.chat.service.impl.g0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import m6b.u;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkMessagePushProxy extends c0c.b implements u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f426193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f426194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<u> f426195d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.u
    public final void I(MessageInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "preMessageInfo");
        this.f426193b.I(r100);
    }

    @Override // m6b.u
    public final void dispose() {
        this.f426193b.dispose();
    }

    @Override // m6b.u
    public final void K3(final g0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426195d.a(new com.ss.android.lark.passportc.convention.b.C5239b(g0.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ImSdkMessagePushProxy$addPushPreMessageListener$1(r100), new ImSdkMessagePushProxy$addPushPreMessageListener$2(r100)));
    }

    @Override // m6b.u
    public final void O3(k0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426195d.d(new com.ss.android.lark.passportc.convention.b.C5239b(k0.class, r100));
    }

    @Override // m6b.u
    public final void gc(final k0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426195d.a(new com.ss.android.lark.passportc.convention.b.C5239b(k0.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ImSdkMessagePushProxy$addPushMessageListener$1(r100), new ImSdkMessagePushProxy$addPushMessageListener$2(r100)));
    }

    @Override // m6b.u
    public final void kd(g0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f426195d.d(new com.ss.android.lark.passportc.convention.b.C5239b(g0.class, r100));
    }

    @Override // c0c.b
    public final void mf(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ImSdkMessagePushProxy", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        this.f426195d.c().dispose();
    }

    @Override // c0c.b
    public final void of(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ImSdkMessagePushProxy", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    public ImSdkMessagePushProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<u> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), u.class), u.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f426193b = r103.b();
        this.f426194c = r101;
        this.f426195d = r103;
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
        Log.i("ImSdkMessagePushProxy", r102.toString());
        u r108 = this.f426195d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.MessagePushV2");
        MessagePushV2 r109 = (MessagePushV2) r108;
        if (Intrinsics.areEqual(r109.f416376a, "absent_user") == false) goto L20;
        Log.w("ImSdkMessagePushProxy", "from user is ABSENT_USER, call release manually");
        r109.dispose();
    L20:
        v r110 = this.f426194c;
        if (r101 == null) goto L24;
        UserSession r111 = r101.f475034b;
        if (r111 == null) goto L24;
    L25:
        u r112 = (u) k.b(r110.c(r111), u.class);
        this.f426195d.e(r112);
        return;
    L24:
        r111 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }

    @Override // m6b.u
    public final void Hd(String r100, Long r101, f1 r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        if (r102 != null) goto L5;
        return;
    L5:
        this.f426195d.d(new com.ss.android.lark.passportc.convention.b.C5239b(f1.class, r102));
    }

    @Override // m6b.u
    public final void pb(final String r100, final Long r101, final f1 r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        if (r102 != null) goto L5;
        return;
    L5:
        this.f426195d.a(new com.ss.android.lark.passportc.convention.b.C5239b(f1.class, r102), new com.ss.android.lark.passportc.convention.b.c(new ImSdkMessagePushProxy$addPushAIRoundInfoListener$1(r100, r101, r102), new ImSdkMessagePushProxy$addPushAIRoundInfoListener$2(r100, r101, r102)));
    }
}
