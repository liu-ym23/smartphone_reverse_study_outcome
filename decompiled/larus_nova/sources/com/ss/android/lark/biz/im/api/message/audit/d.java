package com.ss.android.lark.biz.im.api.message.audit;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends c0c.b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f410328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f410329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<f> f410330d;

    @Override // com.ss.android.lark.biz.im.api.message.audit.f
    public final void Cb(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f410328b.Cb(r100);
    }

    @Override // com.ss.android.lark.biz.im.api.message.audit.f
    public final List<IMFileEntity> I8() {
        return this.f410328b.I8();
    }

    @Override // com.ss.android.lark.biz.im.api.message.audit.f
    public final void Z9(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f410328b.Z9(r100);
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<f> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), f.class), f.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f410328b = r103.b();
        this.f410329c = r101;
        this.f410330d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        Log.i("AuthResourceUserScopeManagerProxy", "preparing AuthResourceUserScopeManagerProxy");
        v r102 = this.f410329c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        f r105 = (f) k.b(r102.c(r104), f.class);
        this.f410330d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
