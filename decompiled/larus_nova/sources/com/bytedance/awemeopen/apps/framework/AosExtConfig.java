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
import com.ss.android.lark.utils.statistics.PerfLog;
import e54.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/AosExtConfig;", "Lcom/bytedance/awemeopen/export/api/AosConfigService;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosExtConfig implements AosConfigService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AosExtConfig f193138b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AosConfigService f193139a;

    static {
        f193138b = new AosExtConfig();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final a A() {
        return this.f193139a.A();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final void D0() {
        this.f193139a.D0();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final void E0(int r100, AosRecomendFeedViewModel.f r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f193139a.E0(r100, r101);
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final boolean H(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("com.ss.android.ugc.aweme", "packageName");
        return this.f193139a.H(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final void H1() {
        this.f193139a.H1();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final m54.a J() {
        return this.f193139a.J();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final f54.a J0() {
        return this.f193139a.J0();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final boolean K0() {
        return this.f193139a.K0();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final View L1(Context r100, String r101, String r110, c r111, AosConfigService.b r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "handleBySdkCallback");
        return this.f193139a.L1(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final void P0(LaunchConfigManager$checkLaunchConfig$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f193139a.P0(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final boolean P1(Context r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scheme");
        return this.f193139a.P1(r100, r101, r102);
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final boolean Q1(Context r100, String r101, boolean r102, Function2<? super Float, ? super Float, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f193139a.Q1(r100, r101, r102, r103);
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final AosPageTransition U0() {
        return this.f193139a.U0();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final c54.a W1() {
        return this.f193139a.W1();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final e Y() {
        return this.f193139a.Y();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final boolean Y0() {
        return this.f193139a.Y0();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final z44.a b0() {
        return this.f193139a.b0();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final a54.a getCommentConfig() {
        return this.f193139a.getCommentConfig();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final b l1() {
        return this.f193139a.l1();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final boolean m0() {
        return this.f193139a.m0();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final c54.c n1() {
        return this.f193139a.n1();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final g54.b p2() {
        return this.f193139a.p2();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final long v(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        return this.f193139a.v(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final void v2() {
        this.f193139a.v2();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final void x() {
        this.f193139a.x();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final void z() {
        this.f193139a.z();
    }

    @Override // com.bytedance.awemeopen.export.api.AosConfigService
    public final r54.a z0() {
        return this.f193139a.z0();
    }

    private AosExtConfig() {
        AosConfigService r100 = (AosConfigService) j64.a.a(AosConfigService.class);
        if (r100 != null) goto L5;
        r100 = new AosConfigServiceDefaultImpl();
    L5:
        this.f193139a = r100;
    }
}
