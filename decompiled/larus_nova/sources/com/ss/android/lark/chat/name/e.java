package com.ss.android.lark.chat.name;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends c0c.b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f415959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f415960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<f> f415961d;

    public static final class a {
    }

    static {
    }

    public e(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<f> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), f.class), f.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f415959b = r103.b();
        this.f415960c = r101;
        this.f415961d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("ChatNameRendererProxy", "preparing IChatNameRenderer");
        v r102 = this.f415960c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        f r104 = (f) k.b(r102.c(r103), f.class);
        this.f415961d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
