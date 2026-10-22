package com.ss.android.lark.integrator.security.compliance;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.ActionMode;
import android.view.Menu;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.api.creation.TplType;
import com.ss.android.lark.log.Log;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import com.suite.lark.emm.impl.clipboard.utils.ServiceHookNPEFixHelper;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class SCClipboardProviderGlobalOfficeSDK implements com.suite.lark.emm.impl.clipboard.userscope.export.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final doc.d f428049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f428050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f428051c;

    public static final class a implements boc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SCClipboardScene f428052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SCClipboardProviderGlobalOfficeSDK f428053b;

        /* JADX INFO: renamed from: com.ss.android.lark.integrator.security.compliance.SCClipboardProviderGlobalOfficeSDK$a$a, reason: collision with other inner class name */
        public static final class RunnableC5072a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final RunnableC5072a f428054a = null;

            static {
                f428054a = new RunnableC5072a();
            }

            public RunnableC5072a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.suite.lark.emm.impl.clipboard.adpater.a.f460440b.wa();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f428055a = null;

            static {
                f428055a = new b();
            }

            public b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.suite.lark.emm.impl.clipboard.adpater.a.f460440b.wa();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // boc.b
        public final boolean L0() {
            return this.f428053b.f428049a.L0();
        }

        @Override // boc.b
        public final boolean f() {
            if (SCClipboardProvider.b() == true) goto L33;
        L8:
            ClipboardManager r100 = (ClipboardManager) this.f428053b.f428050b.getValue();
            ArrayList r110 = new ArrayList();
            Object[] r111 = new Object[0];
            f06.b r112 = new f06.b();
            g06.a r101 = ApiHookConfig.f245611b.get(101805);
            if (r101 == null) goto L11;
            f06.a[] r102 = r101.f479473i;
        L12:
            f06.a[] r113 = r102;
            int r103 = r113.length;
            int r104 = 0;
        L14:
            if (r104 >= r103) goto L21;
            f06.a r105 = r113[r104];
            int r114 = r104;
            int r115 = r103;
            f06.a[] r210 = r113;
            f06.d r106 = r105.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r100, r111, "boolean", r112);     // Catch: Exception -> L32
            if (r106.f474982a == true) goto L23;
            r110.add(r105);     // Catch: Exception -> L32
        L23:
            if (r106.f474982a == false) goto L25;
            boolean r107 = ((Boolean) r106.f474983b).booleanValue();
        L26:
            Log.i("SCClipboardManager", "handleHasPrimaryClip system:" + r107);
            if (r107 == false) goto L30;
            return true;
        L30:
            boolean r108 = com.suite.lark.emm.impl.clipboard.adpater.a.f460440b.E6();
            Log.i("SCClipboardManager", "handleHasPrimaryClip inner:" + r108);
            return r108;
        L25:
            r107 = r100.hasPrimaryClip();
        L20:
            r104 = r114 + 1;
            r103 = r115;
            r113 = r210;
            goto L14
        L21:
            r106 = new f06.d(false, null);
            goto L23
        L11:
            r102 = ApiHookConfig.f245613d;
            goto L12
        L33:
            com.suite.lark.emm.impl.clipboard.utils.d.a((ClipboardManager) this.f428053b.f428050b.getValue());     // Catch: Exception -> L6
        L6:
            e = move-exception;
            Log.e("SCClipboardManager", "handleHasPrimaryClip forceReportWebviewClipChanged failed: " + e);
            goto L8
        }

        public a(SCClipboardProviderGlobalOfficeSDK r100) {
            this.f428053b = r100;
        }

        @Override // boc.b
        public final void N0(Menu r100) {
            Intrinsics.checkNotNullParameter(r100, TplType.MENU);
            if (r100 != null) goto L5;
            Lazy r101 = TextViewMenuUtilsKt.f460460a;
            return;
        L5:
            TextViewMenuUtilsKt.c(r100, 4);
        }

        @Override // boc.b
        public final void O0(SCClipboardScene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f428053b.f428049a.Ob(r100);
        }

        @Override // boc.b
        public final void Q0(SCClipboardScene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Log.i("SCClipboardManager", "setScene: " + r100);
            if (r100 == SCClipboardScene.SCENE_ENCRYPT) goto L5;
        L7:
            this.f428052a = r100;
            return;
        L5:
            if ((r100.getParam() instanceof String) == true) goto L7;
            Log.e("SCClipboardManager", "encrypt scene but wrong param: " + r100.getParam() + ", ignore scene");
            r100 = null;
            goto L7
        }

        @Override // boc.b
        public final ActionMode.Callback R0(ActionMode.Callback r100) {
            if (r100 != null) goto L4;
            return r100;
        L4:
            Lazy r101 = TextViewMenuUtilsKt.f460460a;
            Intrinsics.checkNotNullParameter(r100, "original");
            if (com.suite.lark.emm.impl.clipboard.utils.a.a() == true) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == false) goto L11;
            return r100;
        L11:
            return TextViewMenuUtilsKt.d(r100, true);
        L7:
            coc.f.f24672a.f24669b.b();
            r102 = false;
            goto L8
        }

        @Override // boc.b
        public final void S0(Menu r100) {
            Intrinsics.checkNotNullParameter(r100, TplType.MENU);
            TextViewMenuUtilsKt.b(r100, 3);
        }

        @Override // boc.b
        public final ClipData T0(Token r100) {
            Intrinsics.checkNotNullParameter(r100, "token");
            this.f428053b.f428049a.Ob(this.f428052a);
            return a(r100);
        L5:
            e = move-exception;
            this.f428053b.f428049a.wa();
            throw e;
        }

        public final ClipData a(Token r100) {
            ClipData r101 = qf7.a.f532746a.d((ClipboardManager) this.f428053b.f428050b.getValue(), r100);
            if (r101 != null) goto L5;
            boolean r102 = true;
        L6:
            com.suite.lark.emm.impl.clipboard.adpater.a r103 = com.suite.lark.emm.impl.clipboard.adpater.a.f460440b;
            if (r103.b(r101) == false) goto L13;
            if (r103.a(r101) == true) goto L13;
            Log.i("SCClipboardManager", "handlePrimaryClipGet: system1, null?" + r102);
            return r101;
        L13:
            if (r103.xb(r101) == 0) goto L15;
            ClipData r104 = r103.Ma();
            if (SCClipboardProvider.b() == false) goto L28;
            ThreadUtils.runOnUIThread(b.f428055a, 50);
        L29:
            if (r104 == null) goto L32;
            Log.i("SCClipboardManager", "handlePrimaryClipGet: inner");
            return r104;
        L32:
            Log.i("SCClipboardManager", "handlePrimaryClipGet: system3, null?" + r102);
            return r101;
        L28:
            r103.wa();
            goto L29
        L15:
            if (SCClipboardProvider.b() == false) goto L17;
            ThreadUtils.runOnUIThread(RunnableC5072a.f428054a, 50);
        L18:
            if (r101 == null) goto L20;
        L23:
            Log.i("SCClipboardManager", "handlePrimaryClipGet: system2, null?" + r102);
            return r101;
        L20:
            if (r103.E6() == false) goto L23;
            Log.i("SCClipboardManager", "handlePrimaryClipGet: blank");
            return ClipData.newPlainText("", " ");
        L17:
            r103.wa();
            goto L18
        L5:
            r102 = false;
            goto L6
        }

        @Override // boc.b
        public final void d(ClipboardManager.OnPrimaryClipChangedListener r100) {
            this.f428053b.f428049a.d(r100);
        }

        @Override // boc.b
        public final void e(ClipboardManager.OnPrimaryClipChangedListener r100) {
            this.f428053b.f428049a.e(r100);
        }

        @Override // boc.b
        public final void M0(ClipData r100, Token r101) {
            Intrinsics.checkNotNullParameter(r100, "clip");
            Intrinsics.checkNotNullParameter(r101, "token");
            this.f428053b.f428049a.Ob(this.f428052a);
            if (this.f428052a != SCClipboardScene.SCENE_SYSTEM_ONCE) goto L10;
            this.f428052a = null;
        L10:
            b(r100, r101);     // Catch: SensitiveAPIException -> L7
            return;
        L7:
            e = move-exception;
            this.f428053b.f428049a.wa();
            throw e;
        }

        @Override // boc.b
        public final ActionMode.Callback P0(ActionMode.Callback r100, Boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "original");
            if (r101 == null) goto L5;
            boolean r102 = r101.booleanValue();
        L7:
            return TextViewMenuUtilsKt.d(r100, r102);
        L5:
            r102 = true;
            goto L7
        }

        public final void b(ClipData r100, Token r101) {
            com.suite.lark.emm.impl.clipboard.adpater.a r102 = com.suite.lark.emm.impl.clipboard.adpater.a.f460440b;
            if (r102.b(r100) == true) goto L5;
        L15:
            Log.i("SCClipboardManager", "handlePrimaryClipSet: system");
            qf7.a.f532746a.a((ClipboardManager) this.f428053b.f428050b.getValue(), r100, r101);
            return;
        L5:
            if (r102.a(r100) == false) goto L15;
            int r103 = r102.Ua();
            if (r103 != 0) goto L10;
            r102.L3();
            r102.wa();
            Log.i("SCClipboardManager", "handlePrimaryClipSet: system");
            qf7.a.f532746a.a((ClipboardManager) this.f428053b.f428050b.getValue(), r100, r101);
            return;
        L10:
            if (r103 == 2) goto L12;
            Log.i("SCClipboardManager", "handlePrimaryClipSet: inner");
            r102.Ze(r100);
            r102.Sd();
            r102.wa();
            return;
        L12:
            Log.i("SCClipboardManager", "handlePrimaryClipSet: disable set");
        }
    }

    @Override // com.suite.lark.emm.impl.clipboard.userscope.export.a
    public final boc.b getClipboardManager() {
        return this.f428051c;
    }

    @Inject
    public SCClipboardProviderGlobalOfficeSDK(doc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "clipboardService");
        this.f428049a = r100;
        this.f428050b = LazyKt.lazy(SCClipboardProviderGlobalOfficeSDK$clipboardManager$2.INSTANCE);
        new ServiceHookNPEFixHelper();
        this.f428051c = new a(this);
    }
}
