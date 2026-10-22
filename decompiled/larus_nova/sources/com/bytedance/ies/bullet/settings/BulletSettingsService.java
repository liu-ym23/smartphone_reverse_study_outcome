package com.bytedance.ies.bullet.settings;

import com.bytedance.ies.bullet.base.settings.AnnieXRedirectRules;
import com.bytedance.ies.bullet.base.settings.f;
import com.bytedance.ies.bullet.base.settings.l;
import com.bytedance.ies.bullet.base.settings.r;
import com.bytedance.ies.bullet.base.settings.u;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.secure.HybridSecureManager;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.settings.data.IBulletSettings;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import w26.d;
import w26.e;
import w26.g;
import w26.i;
import w26.j;

/* JADX INFO: loaded from: classes19.dex */
public final class BulletSettingsService extends s26.a implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f248162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f248163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f248164d;

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.settings.BulletSettingsService$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            g37.a.c("Bullet").e(true);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public static final class a implements g37.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BulletSettingsService f248165a;

        public a(BulletSettingsService r100) {
            this.f248165a = r100;
        }

        @Override // g37.c
        public final g37.d create() {
            g37.d.a r100 = new g37.d.a();
            h r101 = h.f246501h;
            r100.f479841a = h.f246501h.f246503b;
            r100.f479845e = BaseConstants.Time.HOUR;
            r100.f479843c = new com.bytedance.ies.bullet.settings.a(this.f248165a.f248162b);
            return r100.a();
        }
    }

    public static final class b implements SettingsUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BulletSettingsService f248166a;

        public b(BulletSettingsService r100) {
            this.f248166a = r100;
        }

        @Override // com.bytedance.news.common.settings.SettingsUpdateListener
        public final void onSettingsUpdate(SettingsData r100) {
            ExecutorService r101 = BulletLogger.f247763a;     // Catch: Throwable -> L5
            BulletLogger.d("bullet onUpdate,appSettings = " + r100.getAppSettings() + ",userSettings = " + r100.getUserSettings());     // Catch: Throwable -> L5
        L6:
            IBulletSettings r102 = (IBulletSettings) g37.a.c("Bullet").b(IBulletSettings.class);
            this.f248166a.f248163c.d(j.class, r102.getResourceLoaderConfig());
            this.f248166a.f248163c.d(e.class, r102.getCommonConfig());
            this.f248166a.f248163c.d(w26.h.class, r102.getMonitorConfig());
            this.f248166a.f248163c.d(i.class, r102.getPineappleConfig());
            this.f248166a.f248163c.d(r.class, r102.getMixConfig());
            this.f248166a.f248163c.d(u.class, r102.getSecuritySettingConfig());
            this.f248166a.f248163c.d(l.class, r102.getForestSettingConfig());
            this.f248166a.f248163c.d(t16.d.class, r102.getAnnieXPredefineConfig());
            this.f248166a.f248163c.d(com.bytedance.ies.bullet.base.settings.h.class, r102.getArgusSecuritySettingConfig());
            this.f248166a.f248163c.d(f.class, r102.getArgusRecoveryConfig());
            this.f248166a.f248163c.d(t16.f.class, r102.getAnnieXPredefineWasmConfig());
            this.f248166a.f248163c.d(com.bytedance.pia.core.setting.b.class, r102.getPIAConfig());
            this.f248166a.f248163c.d(com.bytedance.ies.bullet.base.settings.j.class, r102.getClientAiConfig());
            this.f248166a.f248163c.d(com.bytedance.ies.bullet.base.settings.e.class, r102.getAnnieXSLConfig());
            this.f248166a.f248163c.d(com.bytedance.ies.bullet.base.settings.a.class, r102.getAnnieXBatchFlowConfig());
            this.f248166a.f248163c.d(AnnieXRedirectRules.class, r102.getAnnieXRedirectRules());
            this.f248166a.f248163c.d(com.bytedance.ies.bullet.base.settings.g.class, r102.getArgusSecurityDebugConfig());
            SccConfig r103 = r102.getSccSettingsConfig();
            if (r103 == null) goto L9;
            Lazy<HybridSecureManager> r104 = HybridSecureManager.f247741c;
            HybridSecureManager.a.a().getClass();
            Intrinsics.checkNotNullParameter(r103, "sccConfig");
            n07.e.a(r103.e(), n07.b.f516587d);
        L9:
            c r105 = this.f248166a.f248164d;
            if (r105 == null) goto L15;
            r105.onUpdate();
            return;
        }
    }

    public interface c {
        void onUpdate();
    }

    @Override // w26.g
    public final void a() {
        g37.a.c("Bullet").e(true);
    }

    public BulletSettingsService(d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f248162b = r100;
        this.f248163c = new m16.b();
        g37.a.c("Bullet").f479824a = new a(this);
        BulletLogger.d("bullet init: ");
        g37.a.c("Bullet").d(new b(this), !r100.f558032c);
        s26.d r101 = s26.d.f540305c;
        m0 r102 = (m0) s26.d.f540305c.c(m0.class);
        if (r102 == null) goto L5;
        r102.a0();
    L5:
        g37.a.c("Bullet").e(true);
    }

    @Override // w26.g
    public final <T> T n0(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        T r102 = (T) Result.m9449constructorimpl(this.f248163c.c(r100));
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        return null;
    L13:
        return r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = (T) Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
