package com.bytedance.ee.bear.lynx.impl;

import android.app.Application;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.doc.resupdate.h;
import com.bytedance.ee.bear.lynx.api.f;
import com.bytedance.ee.bear.lynx.impl.globalbridge.DateTimeFormatModule;
import com.bytedance.ee.bear.lynx.impl.lynxview.CCMLynxAnimationUI;
import com.bytedance.ee.bear.lynx.impl.lynxview.CCMLynxEmptyStateView;
import com.bytedance.ee.bear.lynx.impl.lynxview.CCMLynxIconView;
import com.bytedance.ee.bear.lynx.impl.lynxview.CCMLynxRadioBox;
import com.bytedance.ee.bear.lynx.impl.lynxview.CCMLynxSwitch;
import com.bytedance.ee.bear.lynx.impl.lynxview.CCMLynxTabbarView;
import com.bytedance.ee.bear.lynx.impl.lynxview.refresh.CCMLynxPullRefreshView;
import com.bytedance.ee.bear.lynx.impl.lynxview.refresh.CCMLynxRefreshFooter;
import com.bytedance.ee.bear.lynx.impl.lynxview.refresh.CCMLynxRefreshHeader;
import com.bytedance.ee.bear.lynx.impl.xelement.CCMXELottieView;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.lark.lynxlib.widget.udtabs.LynxViewPager;
import com.bytedance.lark.lynxlib.widget.udtabs.childitem.LynxViewpagerItem;
import com.larksuite.framework.utils.ApkUtil;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import com.ss.android.lark.lynxkit.templateloader.loaderimpl.GeckoStrategy;
import com.ss.android.lark.lynxkit.templateloader.loaderimpl.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.lynx.api.b {
    public static final /* synthetic */ int c = 0;
    public f a;
    public final AtomicBoolean b;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.c$a$a, reason: collision with other inner class name */
        public static final class C0039a extends com.lynx.tasm.behavior.a {
            public C0039a() {
                super("ud-radio-box");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxRadioBox(r2);
            }
        }

        public static final class b extends com.lynx.tasm.behavior.a {
            public b() {
                super("ccm-icon-view");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxIconView(r2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.c$a$c, reason: collision with other inner class name */
        public static final class C0040c extends com.lynx.tasm.behavior.a {
            public C0040c() {
                super("ccm-animation-view");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxAnimationUI(r2);
            }
        }

        public static final class d extends com.lynx.tasm.behavior.a {
            public d() {
                super("ccm-lottie-view");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMXELottieView(r2);
            }
        }

        public static final class e extends com.lynx.tasm.behavior.a {
            public e() {
                super("ccm-refresh-view");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxPullRefreshView(r2);
            }
        }

        public static final class f extends com.lynx.tasm.behavior.a {
            public f() {
                super("ccm-refresh-header");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxRefreshHeader(r2);
            }
        }

        public static final class g extends com.lynx.tasm.behavior.a {
            public g() {
                super("ccm-refresh-footer");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxRefreshFooter(r2);
            }
        }

        public static final class h extends com.lynx.tasm.behavior.a {
            public h() {
                super("ud-empty");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxEmptyStateView(r2);
            }
        }

        public static final class i extends com.lynx.tasm.behavior.a {
            public i() {
                super("ud-viewpager-item");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new LynxViewpagerItem(r2);
            }
        }

        public static final class j extends com.lynx.tasm.behavior.a {
            public j() {
                super("ud-viewpager");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new LynxViewPager(r2);
            }
        }

        public static final class k extends com.lynx.tasm.behavior.a {
            public k() {
                super("ud-tabbar");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxTabbarView(r2);
            }
        }

        public static final class l extends com.lynx.tasm.behavior.a {
            public l() {
                super("ud-switch");
            }

            public final LynxUI<?> createUI(LynxContext r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return new CCMLynxSwitch(r2);
            }
        }

        @JvmStatic
        public static List a() {
            ArrayList r0 = new ArrayList();
            r0.addAll(new XElementBehavior().create());
            r0.add(new d());
            r0.add(new e());
            r0.add(new f());
            r0.add(new g());
            r0.add(new h());
            r0.add(new i());
            r0.add(new j());
            r0.add(new k());
            r0.add(new l());
            r0.add(new C0039a());
            r0.add(new b());
            r0.add(new C0040c());
            return r0;
        }
    }

    static {
    }

    public c() {
        this.b = new AtomicBoolean(false);
    }

    @Override // com.bytedance.ee.bear.lynx.api.b
    public final void init(Application r14) {
        Intrinsics.checkNotNullParameter(r14, "app");
        if (this.b.compareAndSet(false, true) == false) goto L40;
        tt5.a.h("ccm-lynx: CCMLynxEnvImpl", "init begin");
        g r4 = null;
        if (this.a != null) goto L7;
        this.a = (f) org.koin.java.a.c(f.class, null, null, 6);
    L7:
        f r3 = this.a;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.lynx.api.LynxHostService");
        r3.b();
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer r5 = LarkLynxKitInitializer.b.a();
        r5.registerCustomComponents("ccm-lynx-bid", a.a());
        String r6 = he5.a.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        ArrayList r7 = new ArrayList();
        if (((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(r14) == false) goto L10;
        r7.add(new he5.b());
    L10:
        h r8 = (h) org.koin.java.a.c(h.class, null, null, 6);
        String r9 = r8.getDeviceId();
        String r10 = r8.d();
        if (r9 != null) goto L13;
    L16:
        boolean r11 = true;
    L17:
        if (r11 == true) goto L27;
        if (r10 != null) goto L20;
    L23:
        boolean r12 = true;
    L24:
        if (r12 == true) goto L27;
        String r13 = com.bytedance.ee.bear.doc.resupdate.c.a(r14, false);
        GeckoConfig r15 = new GeckoConfig.Builder(r14).accessKey(new String[]{r13}).allLocalAccessKeys(new String[]{r13}).appId(r8.getAppId()).host(r10).appVersion(ApkUtil.getAppVersionName(r14)).deviceId(r9).resRootDir(com.bytedance.ee.bear.doc.resupdate.c.b(r14)).build();
    L28:
        if (r15 == null) goto L31;
        r4 = new g("docs_lynx_channel", r15, GeckoStrategy.NO_WAIT_FOR_REMOTE);
    L31:
        if (r4 == null) goto L33;
        r7.add(r4);
    L33:
        r7.add(new he5.c());
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r1 = r7.iterator();
    L35:
        if (r1.hasNext() == false) goto L37;
        r16.add(new he5.a.C0240a((uqb.b) r1.next()));
        goto L35
    L37:
        r5.registerTemplateLoaders("ccm-lynx-bid", r16);
        int r17 = ee5.a.a;
        LynxEnv.inst().registerModule(DateTimeFormatModule.NAME, DateTimeFormatModule.class);
        tt5.a.h("ccm-lynx: CCMLynxEnvImpl", "init end lynx version: " + LynxEnv.inst().getLynxVersion() + ", app is debug: " + eu5.c.a());
        return;
    L20:
        if (r10.length() == 0) goto L23;
        r12 = false;
    L27:
        tt5.a.d("CCMLynxTemplateLoaderProvider", "can not create gecko config, deviceId or host invalid");
        r15 = null;
        goto L28
    L13:
        if (r9.length() == 0) goto L16;
        r11 = false;
        goto L17
    }
}
