package com.bytedance.ee.bear.tts.service;

import android.app.Application;
import com.bytedance.ee.bear.tts.TtsConfig;
import com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel;
import com.bytedance.ee.bear.tts.impl.TtsViewModel;
import com.bytedance.ee.bear.tts.impl.d;
import com.bytedance.ee.bear.tts.meta.TtsMetaBean;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@UserScope
public final class TtsService implements e {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final TtsConfig e;
    public final Lazy f;
    public d g;
    public volatile boolean h;

    public static final class a {
    }

    public final class b implements d.e {
        public final /* synthetic */ TtsService a;

        public b(TtsService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.tts.impl.d.e
        public final void a(d r4) {
            Intrinsics.checkNotNullParameter(r4, "session");
            r4.v(this);
            TtsService r5 = this.a;
            d r0 = r5.g;
            if (r0 == null) goto L6;
            tt5.a.h("TtsService", "SessionLifecycleObserver-onChanged, session: " + r0);
            r0.v(this);
            r5.g = null;
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TtsService a;

        public c(TtsService r1) {
            this.a = r1;
        }

        public final void a() {
            TtsService r0 = this.a;
            d r1 = r0.g;
            if (r1 == null) goto L5;
            tt5.a.h("TtsService", "destroySession, found activeSession: " + r1);
            r1.v((d.e) r0.f.getValue());
            r1.j();
            r0.g = null;
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
        return !this.b;
    }

    @Override // mo5.e
    public final void onDestroy() {
        tt5.a.h("TtsService", "onDestroy");
        j.f(new c(this));
    }

    @Override // mo5.e
    public final boolean Zb() {
        return this.d;
    }

    @Override // mo5.e
    public final boolean isEnable() {
        return this.a;
    }

    @Override // mo5.e
    public final boolean z5() {
        return this.c;
    }

    @Inject
    public TtsService(by4.b r6) {
        Intrinsics.checkNotNullParameter(r6, "kvStorage");
        com.bytedance.ee.bear.appsetting.c r7 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r0 = LarkContext.getApplication();
        r7.getClass();
        boolean r1 = ((dn4.a) k.b(((v) k.a(r0, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r0, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.docx.listen_to_doc_android");
        tt5.a.h("TtsService", "fgEnabled: " + r1);
        this.a = r1;
        Application r2 = LarkContext.getApplication();
        r7.getClass();
        boolean r3 = ((dn4.a) k.b(((v) k.a(r2, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r2, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.mobile.tts.disable_auto_play");
        tt5.a.h("TtsService", "isAutoPlayFGDisabled: " + r3);
        this.b = r3;
        Application r4 = LarkContext.getApplication();
        r7.getClass();
        tt5.a.h("TtsService", "ttVideoLogEnabled: " + ((dn4.a) k.b(((v) k.a(r4, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r4, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.mobile.docx.enable_ttvideo_log_when_listen_to_doc"));
        Application r5 = LarkContext.getApplication();
        r7.getClass();
        boolean r8 = ((dn4.a) k.b(((v) k.a(r5, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r5, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.docx.listen_to_doc_support_jump");
        tt5.a.h("TtsService", "isBlockRouterFGEnabled: " + r8);
        this.c = r8;
        Application r9 = LarkContext.getApplication();
        r7.getClass();
        boolean r10 = ((dn4.a) k.b(((v) k.a(r9, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r9, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.docx.listen_to_doc_free_trial");
        tt5.a.h("TtsService", "isFreeTrial: " + r10);
        this.d = r10;
        TtsConfig r11 = (TtsConfig) r7.c(TtsConfig.CONFIG_NAME, TtsConfig.class, null);
        tt5.a.h("TtsService", "settingsConfig: " + r11);
        this.e = r11;
        this.f = LazyKt.lazy(new TtsService$sessionStateCallback$2(this));
    }

    @Override // mo5.e
    public final boolean N3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "languageCode");
        TtsConfig r0 = this.e;
        if (r0 == null) goto L7;
        List<String> r1 = r0.getSupportedLanguages();
        if (r1 == null) goto L7;
        return r1.contains(r2);
    L7:
        return false;
    }

    @Override // mo5.e
    public final f V6(boolean r6) {
        if (this.a == true) goto L6;
        tt5.a.d("TtsService", "getSession, FG not enabled.");
        return null;
    L6:
        d r0 = this.g;
        if (r0 == null) goto L9;
        tt5.a.h("TtsService", "getSession, activeSession: " + r0);
        return r0;
    L9:
        if (r6 == false) goto L17;
        d r1 = new d(new TtsAlbumViewModel());
        d.e r7 = (d.e) this.f.getValue();
        Intrinsics.checkNotNullParameter(r7, "callback");
        tt5.a.h("TtsSession", "addStateCallback, callback: " + r7 + ", result: " + ((Set) r1.h.getValue()).add(r7));
        if (this.h == true) goto L14;
        this.h = true;
        r1.p = true;
    L14:
        this.g = r1;
        tt5.a.h("TtsService", "getSession, create an activeSession: " + r1);
        return r1;
    L17:
        return null;
    }

    @Override // mo5.e
    public final g b2(String r5, int r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "objToken");
        if (this.a == true) goto L6;
        tt5.a.d("TtsService", "createTtsVM, FG not enabled. token: " + du5.b.i(r5) + ", type: " + r6);
        return null;
    L6:
        TtsMetaBean r0 = new TtsMetaBean();
        r0.setObjToken(r5);
        r0.setObjType(r6);
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        r0.setTitle(r7);
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        r0.setOwnerName(r8);
        r0.setIconInfo(r9);
        TtsViewModel r10 = new TtsViewModel(r5, r6, r0, null);
        tt5.a.h("TtsService", "createTtsVM, by token and type, viewModel: " + r10);
        return r10;
    }
}
