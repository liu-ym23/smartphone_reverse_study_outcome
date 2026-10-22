package com.ivy.ivykit.plugin.impl.applet;

import com.bytedance.ies.bullet.base.settings.l;
import com.bytedance.ies.bullet.settings.BulletSettingsService;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w26.g;
import w26.k;

/* JADX INFO: loaded from: classes23.dex */
public final class f extends s26.a implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BulletSettingsService f278374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f278375c;

    public static final class a implements w26.f {
        public a() {
        }

        @Override // w26.f
        public final k post(String r100, Map<String, String> r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "headers");
            Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
            return new k();
        }
    }

    @Override // w26.g
    public final void a() {
    }

    @Override // w26.g
    public final <T> T n0(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(this.f278375c.c(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L15;
        BulletSettingsService r103 = this.f278374b;
        if (r103 != null) goto L19;
        return null;
    L19:
        return (T) r103.n0(r100);
    L15:
        return (T) r102;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public f(w26.a r100, BulletSettingsService r101) {
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        this.f278374b = r101;
        m16.b r102 = new m16.b();
        this.f278375c = r102;
        a r103 = new a();
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r103, "network");
        l r104 = new l();
        Boolean r105 = Boolean.TRUE;
        r104.l(r105);
        Unit r106 = Unit.INSTANCE;
        r102.d(l.class, r104);
        w26.e r107 = new w26.e();
        r107.z2(Boolean.FALSE);
        r107.A2(r105);
        r102.d(w26.e.class, r107);
    }
}
