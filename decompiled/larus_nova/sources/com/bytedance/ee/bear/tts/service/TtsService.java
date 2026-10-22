package com.bytedance.ee.bear.tts.service;

import android.app.Application;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.tts.TtsConfig;
import com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel;
import com.bytedance.ee.bear.tts.impl.TtsViewModel;
import com.bytedance.ee.bear.tts.impl.d;
import com.bytedance.ee.bear.tts.meta.TtsMetaBean;
import com.bytedance.ee.util.ui.j;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mo5.e;
import mo5.f;
import mo5.g;

/* JADX INFO: loaded from: classes18.dex */
@UserScope
public final class TtsService implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f239773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f239774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f239775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f239776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TtsConfig f239777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f239778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f239779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f239780h;

    public static final class a {
    }

    public final class b implements d.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TtsService f239781a;

        public b(TtsService r100) {
            this.f239781a = r100;
        }

        @Override // com.bytedance.ee.bear.tts.impl.d.e
        public final void a(d r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            r100.v(this);
            TtsService r101 = this.f239781a;
            d r102 = r101.f239779g;
            if (r102 == null) goto L6;
            tt5.a.h("TtsService", "SessionLifecycleObserver-onChanged, session: " + r102);
            r102.v(this);
            r101.f239779g = null;
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TtsService f239782a;

        public c(TtsService r100) {
            this.f239782a = r100;
        }

        public final void a() {
            TtsService r100 = this.f239782a;
            d r101 = r100.f239779g;
            if (r101 == null) goto L5;
            tt5.a.h("TtsService", "destroySession, found activeSession: " + r101);
            r101.v((d.e) r100.f239778f.getValue());
            r101.j();
            r100.f239779g = null;
            return;
        L5:
            tt5.a.h("TtsService", "destroySession, activeSession not found.");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // mo5.e
    public final boolean canAutoPlay() {
        return !this.f239774b;
    }

    @Override // mo5.e
    public final void onDestroy() {
        tt5.a.h("TtsService", LiveCommonConstants.REASON_ON_DEDTROY);
        j.f(new c(this));
    }

    @Override // mo5.e
    public final boolean Zb() {
        return this.f239776d;
    }

    @Override // mo5.e
    public final boolean isEnable() {
        return this.f239773a;
    }

    @Override // mo5.e
    public final boolean z5() {
        return this.f239775c;
    }

    @Inject
    public TtsService(by4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        Application r102 = LarkContext.getApplication();
        r101.getClass();
        boolean r103 = ((dn4.a) k.b(((v) k.a(r102, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r102, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.docx.listen_to_doc_android");
        tt5.a.h("TtsService", "fgEnabled: " + r103);
        this.f239773a = r103;
        Application r104 = LarkContext.getApplication();
        r101.getClass();
        boolean r105 = ((dn4.a) k.b(((v) k.a(r104, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r104, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.mobile.tts.disable_auto_play");
        tt5.a.h("TtsService", "isAutoPlayFGDisabled: " + r105);
        this.f239774b = r105;
        Application r106 = LarkContext.getApplication();
        r101.getClass();
        tt5.a.h("TtsService", "ttVideoLogEnabled: " + ((dn4.a) k.b(((v) k.a(r106, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r106, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.mobile.docx.enable_ttvideo_log_when_listen_to_doc"));
        Application r107 = LarkContext.getApplication();
        r101.getClass();
        boolean r108 = ((dn4.a) k.b(((v) k.a(r107, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r107, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.docx.listen_to_doc_support_jump");
        tt5.a.h("TtsService", "isBlockRouterFGEnabled: " + r108);
        this.f239775c = r108;
        Application r109 = LarkContext.getApplication();
        r101.getClass();
        boolean r110 = ((dn4.a) k.b(((v) k.a(r109, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r109, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.docx.listen_to_doc_free_trial");
        tt5.a.h("TtsService", "isFreeTrial: " + r110);
        this.f239776d = r110;
        TtsConfig r111 = (TtsConfig) r101.c(TtsConfig.CONFIG_NAME, TtsConfig.class, null);
        tt5.a.h("TtsService", "settingsConfig: " + r111);
        this.f239777e = r111;
        this.f239778f = LazyKt.lazy(new TtsService$sessionStateCallback$2(this));
    }

    @Override // mo5.e
    public final boolean N3(String r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        TtsConfig r101 = this.f239777e;
        if (r101 == null) goto L7;
        List<String> r102 = r101.getSupportedLanguages();
        if (r102 == null) goto L7;
        return r102.contains(r100);
    L7:
        return false;
    }

    @Override // mo5.e
    public final f V6(boolean r100) {
        if (this.f239773a == true) goto L6;
        tt5.a.d("TtsService", "getSession, FG not enabled.");
        return null;
    L6:
        d r101 = this.f239779g;
        if (r101 == null) goto L9;
        tt5.a.h("TtsService", "getSession, activeSession: " + r101);
        return r101;
    L9:
        if (r100 == false) goto L17;
        d r102 = new d(new TtsAlbumViewModel());
        d.e r103 = (d.e) this.f239778f.getValue();
        Intrinsics.checkNotNullParameter(r103, "callback");
        tt5.a.h("TtsSession", "addStateCallback, callback: " + r103 + ", result: " + ((Set) r102.f239545h.getValue()).add(r103));
        if (this.f239780h == true) goto L14;
        this.f239780h = true;
        r102.f239553p = true;
    L14:
        this.f239779g = r102;
        tt5.a.h("TtsService", "getSession, create an activeSession: " + r102);
        return r102;
    L17:
        return null;
    }

    @Override // mo5.e
    public final g b2(String r100, int r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        if (this.f239773a == true) goto L6;
        tt5.a.d("TtsService", "createTtsVM, FG not enabled. token: " + du5.b.i(r100) + ", type: " + r101);
        return null;
    L6:
        TtsMetaBean r105 = new TtsMetaBean();
        r105.setObjToken(r100);
        r105.setObjType(r101);
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r105.setTitle(r102);
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        r105.setOwnerName(r103);
        r105.setIconInfo(r104);
        TtsViewModel r106 = new TtsViewModel(r100, r101, r105, null);
        tt5.a.h("TtsService", "createTtsVM, by token and type, viewModel: " + r106);
        return r106;
    }
}
