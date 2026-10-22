package com.bytedance.awemeopen.apps.framework;

import android.content.Context;
import android.view.View;
import b54.b;
import c54.e;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.c;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosRecomendFeedViewModel;
import com.bytedance.awemeopen.apps.framework.launchconfig.LaunchConfigManager$checkLaunchConfig$1;
import com.bytedance.awemeopen.export.api.AosConfigService;
import com.bytedance.awemeopen.export.api.pagetransition.AosPageTransition;
import e54.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/AosExtConfig;", "Lcom/bytedance/awemeopen/export/api/AosConfigService;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosExtConfig implements AosConfigService {
    public static final AosExtConfig b = null;
    public final /* synthetic */ AosConfigService a;

    static {
        b = new AosExtConfig();
    }

    public final a A() {
        return this.a.A();
    }

    public final void D0() {
        this.a.D0();
    }

    public final void E0(int r2, AosRecomendFeedViewModel.f r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a.E0(r2, r3);
    }

    public final boolean H(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("com.ss.android.ugc.aweme", "packageName");
        return this.a.H(r3);
    }

    public final void H1() {
        this.a.H1();
    }

    public final m54.a J() {
        return this.a.J();
    }

    public final f54.a J0() {
        return this.a.J0();
    }

    public final boolean K0() {
        return this.a.K0();
    }

    public final View L1(Context r8, String r9, String r10, c r11, AosConfigService.b r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "handleBySdkCallback");
        return this.a.L1(r8, r9, r10, r11, r12);
    }

    public final void P0(LaunchConfigManager$checkLaunchConfig$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.P0(r2);
    }

    public final boolean P1(Context r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scheme");
        return this.a.P1(r2, r3, r4);
    }

    public final boolean Q1(Context r2, String r3, boolean r4, Function2<? super Float, ? super Float, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.Q1(r2, r3, r4, r5);
    }

    public final AosPageTransition U0() {
        return this.a.U0();
    }

    public final c54.a W1() {
        return this.a.W1();
    }

    public final e Y() {
        return this.a.Y();
    }

    public final boolean Y0() {
        return this.a.Y0();
    }

    public final z44.a b0() {
        return this.a.b0();
    }

    public final a54.a getCommentConfig() {
        return this.a.getCommentConfig();
    }

    public final b l1() {
        return this.a.l1();
    }

    public final boolean m0() {
        return this.a.m0();
    }

    public final c54.c n1() {
        return this.a.n1();
    }

    public final g54.b p2() {
        return this.a.p2();
    }

    public final long v(String r3) {
        Intrinsics.checkNotNullParameter(r3, "openId");
        return this.a.v(r3);
    }

    public final void v2() {
        this.a.v2();
    }

    public final void x() {
        this.a.x();
    }

    public final void z() {
        this.a.z();
    }

    public final r54.a z0() {
        return this.a.z0();
    }

    private AosExtConfig() {
        AosConfigService r0 = j64.a.a(AosConfigService.class);
        if (r0 != null) goto L5;
        r0 = new AosConfigServiceDefaultImpl();
    L5:
        this.a = r0;
    }
}
