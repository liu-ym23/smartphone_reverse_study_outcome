package com.ss.android.lark.tab.service;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatTabExtraPushProxy extends c0c.b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f441118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f441119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<i> f441120d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.tab.service.i
    public final void a1(final ChatTabExtraPush.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f441120d.a(new com.ss.android.lark.passportc.convention.b.C5239b(ChatTabExtraPush.b.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ChatTabExtraPushProxy$startPush$1(r100), new ChatTabExtraPushProxy$startPush$2(r100)));
    }

    @Override // c0c.b
    public final void mf(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ChatTabExtraPush", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        i r101 = this.f441120d.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.tab.service.ChatTabExtraPush");
        ((ChatTabExtraPush) r101).f441113a.b();
    }

    @Override // c0c.b
    public final void of(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ChatTabExtraPush", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // com.ss.android.lark.tab.service.i
    public final void vb(ChatTabExtraPush.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f441120d.d(new com.ss.android.lark.passportc.convention.b.C5239b(ChatTabExtraPush.b.class, r100));
    }

    public ChatTabExtraPushProxy(com.ss.android.lark.passportc.api.j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<i> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), i.class), i.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f441118b = r103.b();
        this.f441119c = r101;
        this.f441120d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
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
        Log.i("ChatTabExtraPush", r102.toString());
        i r108 = this.f441120d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.tab.service.ChatTabExtraPush");
        ChatTabExtraPush r109 = (ChatTabExtraPush) r108;
        j r110 = r109.f441113a;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.tab.service.ChatTabExtraPushRepositoryV2");
        if (Intrinsics.areEqual(((ChatTabExtraPushRepositoryV2) r110).f441121a, "absent_user") == false) goto L20;
        Log.w("ChatTabExtraPush", "from user is ABSENT_USER, call release manually");
        r109.f441113a.b();
    L20:
        v r111 = this.f441119c;
        if (r101 == null) goto L24;
        UserSession r112 = r101.f475034b;
        if (r112 == null) goto L24;
    L25:
        i r113 = (i) e0c.k.b(r111.c(r112), i.class);
        this.f441120d.e(r113);
        return;
    L24:
        r112 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }
}
