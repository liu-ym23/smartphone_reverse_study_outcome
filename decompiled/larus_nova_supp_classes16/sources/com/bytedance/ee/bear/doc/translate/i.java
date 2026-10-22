package com.bytedance.ee.bear.doc.translate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.TranslateTargetData;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.view3.MoreFragmentV3;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends com.bytedance.ee.bear.more.protocol3.g {
    public final DocumentPluginHost c;

    public static final class a {
    }

    public static final class b extends vj5.a {
        public final /* synthetic */ TranslatePlugin a;
        public final /* synthetic */ Ref.ObjectRef<String> b;
        public final /* synthetic */ i c;

        public b(TranslatePlugin r1, Ref.ObjectRef<String> r2, i r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements com.bytedance.ee.bear.more.protocol3.a {
        public final /* synthetic */ i a;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ i a;

            public a(i r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L6;
                Toast.showFailureText(this.a.c.getContext(), 2131887951);
                return;
            L6:
                UDToast.show(this.a.c.getContext(), 2131889114);
            }
        }

        public final String b() {
            return "current state is presenter in vc";
        }

        public final View.OnClickListener a() {
            return new a(this.a);
        }

        public final boolean isEnable() {
            if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L7;
            return false;
        L7:
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("mobile.ccm.doc.translate_ms_p_allow") == true) goto L12;
            FollowPlugin r0 = (FollowPlugin) this.a.c.findPlugin(FollowPlugin.class);
            if (r0 != null) goto L11;
            return true;
        L11:
            return true ^ r0.getDocumentFollow().isPresenter();
        L12:
            return true;
        }

        public c(i r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.bytedance.ee.bear.more.protocol3.m {
        public final /* synthetic */ i a;
        public final /* synthetic */ TranslatePlugin b;

        public final boolean isVisible() {
            if (this.a.c() != null) goto L7;
            tt5.a.k("DocImpl", "moreInfo == null");
            return false;
        L7:
            return this.b.isEnableTranslate();
        }

        public d(i r1, TranslatePlugin r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.k a() {
        TranslatePlugin r0 = (TranslatePlugin) this.c.findPlugin(TranslatePlugin.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        TranslateLanguageSetting r2 = r0.getTranslateLanguageSetting();
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        TranslateTargetData r4 = this.c.a().getTranslateTargetData();
        if (r4 == null) goto L8;
        String r5 = r4.getLanguage();
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L22;
        if (r4 == null) goto L13;
        String r6 = r4.getLanguageText();
    L15:
        if (TextUtils.isEmpty(r6) == true) goto L22;
        if (r4 == null) goto L18;
        String r7 = r4.getLanguage();
    L19:
        r3.element = r7;
        if (r4 == null) goto L24;
        String r8 = r4.getLanguageText();
    L25:
        if (r8 != null) goto L27;
        com.bytedance.ee.bear.more.protocol3.f.m r9 = new com.bytedance.ee.bear.more.protocol3.f.m(null);
    L28:
        com.bytedance.ee.bear.more.protocol3.f.m r10 = r9;
        d r1 = new d(this, r0);
        c r11 = new c(this);
        if (r8 != null) goto L31;
        boolean r12 = true;
    L33:
        return h(r10, new com.bytedance.ee.bear.more.protocol3.e.g(r12, this.c.getContext().getResources().getString(2131889112)), CollectionsKt.listOf(r1), CollectionsKt.listOf(r11), new b(r0, r3, this));
    L31:
        r12 = false;
        goto L33
    L27:
        r9 = new com.bytedance.ee.bear.more.protocol3.f.m(xo5.a.c(this.c.getContext(), 2131889331, "lang", r8));
    L24:
        r8 = null;
        goto L25
    L18:
        r7 = null;
        goto L19
    L13:
        r6 = null;
    L22:
        if (r2 == null) goto L24;
        r3.element = r2.getTargetLanguageKey();
        r8 = r2.getTargetLanguageDisplayName();
        goto L25
    L8:
        r5 = null;
        goto L10
    }

    public i(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
    }

    public final void k(String r26) {
        oj5.a r0 = c();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r1 = r0;
        int r2 = n.a;
        n.a.a(r1);
        if ((c() instanceof oj5.a) == false) goto L30;
        if (org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6) == null) goto L30;
        TranslateTargetData r4 = this.c.a().getTranslateTargetData();
        com.bytedance.ee.bear.more.b r5 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        sj5.b r6 = getHost();
        if (r6 == null) goto L11;
        MoreFragmentV3 r7 = r6.getHostFragment();
        if (r7 == null) goto L11;
        Bundle r8 = r7.getArguments();
    L12:
        String r9 = r1.c;
        int r10 = r1.getType();
        String r11 = r1.b();
        if (r26 != null) goto L15;
        String r23 = "";
    L16:
        com.bytedance.ee.bear.more.i r16 = new com.bytedance.ee.bear.more.i(r8, r9, r10, false, r11, "translate", "ccm_space_translate_view", "", "", r23, r1 instanceof oj5.f, r1.k, r1.r, r1.isOwner(), r1.L(), "first");
        if (r4 == null) goto L19;
        String r12 = r4.getUserMainLang();
    L20:
        r16.q = r12;
        if (r4 == null) goto L23;
        String r13 = r4.getSrcLang();
    L24:
        r16.r = r13;
        if (r4 == null) goto L27;
        String r14 = r4.getUserDefaultTargetLang();
    L28:
        r16.s = r14;
        r5.c(r16);
        ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).q(r1.getType(), "translate", "ccm_space_translate_view", null, null, null);
        return;
    L27:
        r14 = null;
        goto L28
    L23:
        r13 = null;
        goto L24
    L19:
        r12 = null;
        goto L20
    L15:
        r23 = r26;
    L11:
        r8 = null;
    }
}
