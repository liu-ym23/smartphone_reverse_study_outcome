package com.ss.android.lark.im.sdk.usercontainer;

import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.im.sdk.service.x;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends c0c.b implements x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f426205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f426206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<x> f426207d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.x
    public final TopicGroup fc(String r100) {
        return this.f426205b.fc(r100);
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<x> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), x.class), x.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f426205b = r103.b();
        this.f426206c = r101;
        this.f426207d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("ImSdkChatServiceProxy", "preparing ImSdkChatService");
        v r102 = this.f426206c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        x r104 = (x) k.b(r102.c(r103), x.class);
        this.f426207d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
