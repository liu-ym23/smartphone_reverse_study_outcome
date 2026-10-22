package com.ss.android.lark.search.doubao.env;

import b4c.d;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.pb.improto.Command;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends c0c.b implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f440106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f440107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<d> f440108d;

    @Override // b4c.d
    public final void j2(Command r100, Message.Builder r101, UIGetDataCallback r102, ProtoAdapter r103) {
        Intrinsics.checkNotNullParameter(r100, "serverCommand");
        Intrinsics.checkNotNullParameter(r101, "builder");
        Intrinsics.checkNotNullParameter(r103, "adapter");
        this.f440106b.j2(r100, r101, r102, r103);
    }

    public a(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<d> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), d.class), d.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f440106b = r103.b();
        this.f440107c = r101;
        this.f440108d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f440107c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        d r104 = (d) k.b(r102.c(r103), d.class);
        this.f440108d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
