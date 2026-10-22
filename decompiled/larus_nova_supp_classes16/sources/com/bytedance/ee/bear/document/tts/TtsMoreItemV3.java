package com.bytedance.ee.bear.document.tts;

import android.view.View;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.documentinfo.TranslateTargetData;
import com.bytedance.ee.bear.lark.dependency.l0;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.m;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.ss.android.lark.utils.LarkContext;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mo5.e;
import mo5.f;
import mo5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class TtsMoreItemV3 extends g {
    public final DocumentPluginHost c;
    public Function0<Unit> d;

    public final class TtsEnableChecker implements com.bytedance.ee.bear.more.protocol3.a {
        public final /* synthetic */ TtsMoreItemV3 a;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ Function0<Unit> a;

            public a(Function0<Unit> r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                this.a.invoke();
            }
        }

        public final String b() {
            return "";
        }

        public final View.OnClickListener a() {
            Function0<Unit> r0 = this.a.d;
            if (r0 != null) goto L7;
            return null;
        L7:
            return new a(r0);
        }

        public final boolean isEnable() {
            if (j.a.a.getNetworkState().a() == true) goto L6;
            tt5.a.k("TtsMoreItemV3", "TtsEnableChecker-isEnable, network not connected.");
            return false;
        L6:
            DocViewModel r0 = this.a.c.a();
            if (r0 != null) goto L10;
            tt5.a.d("TtsMoreItemV3", "isVCFollowing, docViewModel is null.");
            boolean r1 = false;
        L14:
            if (r1 == false) goto L17;
            tt5.a.k("TtsMoreItemV3", "TtsEnableChecker-isEnable, VC following, disabled.");
            return false;
        L17:
            DocViewModel r2 = this.a.c.a();
            if (r2 != null) goto L21;
            tt5.a.d("TtsMoreItemV3", "TtsEnableChecker-isEnable, docViewModel is null.");
            return false;
        L21:
            TranslateTargetData r3 = r2.getTranslateTargetData();
            if (r3 == null) goto L24;
            String r4 = r3.getSrcLang();
        L25:
            e r5 = (e) org.koin.java.a.c(e.class, null, null, 6);
            if (r4 != null) goto L28;
            String r6 = "";
        L29:
            boolean r7 = r5.N3(r6);
            tt5.a.h("TtsMoreItemV3", "TtsEnableChecker-isEnable, srcLang: " + r4 + ", isEnabled: " + r7);
            if (r7 == true) goto L32;
            this.a.d = TtsMoreItemV3$TtsEnableChecker$isEnable$1.INSTANCE;
        L32:
            return r7;
        L28:
            r6 = r4;
            goto L29
        L24:
            r4 = null;
            goto L25
        L10:
            if (r0.getOpenSource() != DocsOpenSource.vc) goto L12;
            r1 = true;
        L13:
            tt5.a.d("TtsMoreItemV3", "isVCFollowing: " + r1);
            goto L14
        L12:
            r1 = false;
            goto L13
        }

        public TtsEnableChecker(TtsMoreItemV3 r1) {
            this.a = r1;
        }
    }

    public static final class a {
    }

    public final class b implements View.OnClickListener {
        public final /* synthetic */ TtsMoreItemV3 a;

        public static final class a implements mo5.b {
            public final /* synthetic */ mo5.a a;

            public a(mo5.a r1) {
                this.a = r1;
            }

            public final void a(TtsResult r4) {
                Intrinsics.checkNotNullParameter(r4, "it");
                i r5 = (i) this.a.e().getValue();
                if (r5 == null) goto L11;
                mo5.g r6 = (mo5.g) r5.b;
                if (r6 != null) goto L7;
                return;
            L7:
                if (((e) org.koin.java.a.c(e.class, null, null, 6)).canAutoPlay() == false) goto L9;
                r6.p(TtsLoadScene.DEFAULT, null);
                return;
            L9:
                r6.h(TtsLoadScene.DEFAULT, null);
                return;
            }
        }

        public b(TtsMoreItemV3 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            ((d) org.koin.java.a.c(d.class, null, null, 6)).n("ccm_space_docs_more_menu_click", MapsKt.mapOf(TuplesKt.to("click", "speak_docs")));
            DocumentPluginHost r12 = this.a.c;
            if ((r12 instanceof DocumentPluginHost) == true) goto L7;
            r12 = null;
        L7:
            if (r12 == null) goto L35;
            DocViewModel r13 = r12.a();
            if (r13 == null) goto L35;
            e r4 = (e) org.koin.java.a.c(e.class, null, null, 6);
            String r5 = r13.getToken();
            int r6 = r13.getDocumentTypeValue();
            String r7 = r13.getDocTitle();
            DocumentInfo r3 = r13.getDocumentInfoData();
            if (r3 == null) goto L16;
            DocMetaInfo r8 = r3.getDocMetaInfo();
            if (r8 == null) goto L16;
            String r9 = r8.getOwnerName();
        L17:
            DocumentInfo r10 = r13.getDocumentInfoData();
            if (r10 == null) goto L22;
            DocMetaInfo r14 = r10.getDocMetaInfo();
            if (r14 == null) goto L22;
            String r16 = r14.getIcon_info();
        L23:
            mo5.g r17 = r4.b2(r5, r6, r7, r9, r16);
            if (r17 != null) goto L27;
            tt5.a.d("TtsMoreItemV3", "TtsClickListener-onClick, ttsViewModel is null.");
            return;
        L27:
            tt5.a.h("TtsMoreItemV3", "TtsClickListener-onClick, token: " + du5.b.i(r13.getToken()) + ", type: " + r13.getDocumentTypeValue() + ", viewModel: " + r17);
            r17.h(TtsLoadScene.DEFAULT, null);
            f r18 = ((e) org.koin.java.a.c(e.class, null, null, 6)).V6(true);
            if (r18 != null) goto L31;
            tt5.a.d("TtsMoreItemV3", "TtsClickListener-onClick, ttsSession is null.");
            return;
        L31:
            this.a.getHost().a();
            mo5.a r0 = r18.k();
            r0.o(r17);
            r0.h(r17);
            r0.n(new a(r0));
            ((l0) LarkContext.spiByDwarf(l0.class)).a();
            tt5.a.h("TtsMoreItemV3", "TtsClickListener-onClick, VC is not active, show ModalController.");
            r18.c();
            r18.f();
            r18.b();
            r18.i();
            TtsPlugin r19 = (TtsPlugin) this.a.c.findPlugin(TtsPlugin.class);
            if (r19 == null) goto L37;
            r19.onTtsSessionActive();
            return;
        L37:
            return;
        L22:
            r16 = null;
        L16:
            r9 = null;
        L35:
            tt5.a.d("TtsMoreItemV3", "TtsClickListener-onClick, docViewModel is null.");
        }
    }

    public final class c implements m {
        public final /* synthetic */ TtsMoreItemV3 a;

        public final boolean isVisible() {
            if (((e) org.koin.java.a.c(e.class, null, null, 6)).isEnable() == true) goto L6;
            tt5.a.h("TtsMoreItemV3", "TtsVisibleChecker-isVisible, fg disabled.");
            return false;
        L6:
            DocViewModel r0 = this.a.c.a();
            if (r0 != null) goto L11;
            tt5.a.h("TtsMoreItemV3", "TtsVisibleChecker-isVisible, docViewModel is null.");
            return false;
        L11:
            if (bx4.b.b(r0.getToken()) == false) goto L14;
            tt5.a.h("TtsMoreItemV3", "TtsVisibleChecker-isVisible, token is fake.");
            return false;
        L14:
            boolean r1 = r0.isDocumentType(sbb.e.o);
            tt5.a.h("TtsMoreItemV3", "TtsVisibleChecker-isVisible, type: " + r0.getDocumentTypeValue() + ", supported: " + r1);
            return r1;
        }

        public c(TtsMoreItemV3 r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final k a() {
        boolean r0 = ((e) org.koin.java.a.c(e.class, null, null, 6)).Zb();
        tt5.a.h("TtsMoreItemV3", "buildUIItem, isFreeTrial: " + r0);
        com.bytedance.ee.bear.more.protocol3.e.f r5 = new com.bytedance.ee.bear.more.protocol3.e.f(false, false, r0);
        com.bytedance.ee.bear.more.protocol3.f.j0 r4 = com.bytedance.ee.bear.more.protocol3.f.j0.c;
        return h(r4, r5, CollectionsKt.listOf(new m[]{new c(this), new com.bytedance.ee.bear.more.protocol3.checker.c(((com.bytedance.ee.bear.more.protocol3.f) r4).a)}), CollectionsKt.listOf(new TtsEnableChecker(this)), new b(this));
    }

    public TtsMoreItemV3(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
    }
}
