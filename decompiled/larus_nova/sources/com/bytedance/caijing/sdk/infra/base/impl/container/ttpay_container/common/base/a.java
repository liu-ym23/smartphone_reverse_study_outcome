package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.IKmpBizExtensions;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.popup.TTPayAbsPopupFragment;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import h16.d;
import h16.e;
import ia.c;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m16.b;

/* JADX INFO: loaded from: classes15.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a$a, reason: collision with other inner class name */
    public static final class C2930a {

        /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a$a$a, reason: collision with other inner class name */
        public static final class C2931a implements com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f202525a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f202526b;

            @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.a
            public final void close() {
                b r100 = this.f202525a;
                if (r100 == null) goto L5;
                TTPayAbsPopupFragment r101 = (TTPayAbsPopupFragment) r100.c(TTPayAbsPopupFragment.class);
            L6:
                if (r101 != null) goto L23;
                b r102 = this.f202525a;
                if (r102 == null) goto L27;
                e r103 = (e) r102.c(e.class);
                if (r103 == null) goto L28;
                d r104 = r103.getActivityWrapper();
                if (r104 == null) goto L29;
                Activity r105 = r104.getActivity();
                if (r105 == null) goto L30;
                CJPayKotlinExtensionsKt.safeFinish(r105);
                return;
            L30:
                return;
            L29:
                return;
            L28:
                return;
            L27:
                return;
            L23:
                r101.dismiss();     // Catch: Exception -> L9
                return;
            L9:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
                Throwable r106 = DialogFragmentLancet.sLastShowStack;
                if (r106 == null) goto L25;
                com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            L25:
                return;
            L5:
                r101 = null;
                goto L6
            }

            @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.a
            public final View getRootView() {
                b r100 = this.f202525a;
                if (r100 == null) goto L10;
                e r101 = (e) r100.c(e.class);
                if (r101 == null) goto L10;
                o r102 = r101.getKitView();
                if (r102 == null) goto L10;
                View r103 = r102.realView();
                if (r103 == null) goto L10;
            L18:
                if (r103 != null) goto L23;
                c r104 = this.f202526b;
                if (r104 == null) goto L22;
                r103 = r104.getKitView();
                goto L23
            L22:
                r103 = null;
            L23:
                if (r103 != null) goto L25;
                return null;
            L25:
                return r103.getRootView();
            L10:
                if (r100 == null) goto L12;
                r103 = (WebView) r100.c(WebView.class);
            L13:
                if (r103 != null) goto L18;
                if (r100 == null) goto L17;
                r103 = (LynxView) r100.c(LynxView.class);
                goto L18
            L17:
                r103 = null;
                goto L18
            L12:
                r103 = null;
                goto L13
            }

            @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.a
            public final WebView getWebview() {
                b r100 = this.f202525a;
                if (r100 != null) goto L8;
                c r101 = this.f202526b;
                if (r101 == null) goto L7;
                r100 = r101.getContextProviderFactory();
                goto L8
            L7:
                r100 = null;
            L8:
                if (r100 == null) goto L14;
                BulletContext r102 = (BulletContext) r100.c(BulletContext.class);
                if (r102 == null) goto L14;
                o r103 = r102.f246444l;
                if (r103 == null) goto L14;
                View r104 = r103.realView();
            L16:
                if ((r104 instanceof WebView) == true) goto L18;
                return null;
            L18:
                return (WebView) r104;
            L14:
                r104 = null;
                goto L16
            }

            public C2931a(b r100, c r101) {
                this.f202525a = r100;
                this.f202526b = r101;
            }
        }

        public static String c(t36.d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "$receiver");
            Intrinsics.checkNotNullParameter(r101, "key");
            String r102 = r100.c().get("ttpay_annie_query");
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            Uri r103 = new Uri.Builder().encodedQuery(r102).build();
            if (r103 != null) goto L10;
            return null;
        L10:
            return UriProtector.getQueryParameter(r103, r101);
        }

        public static String d(t36.d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "$receiver");
            Intrinsics.checkNotNullParameter(r101, "key");
            return UriProtector.getQueryParameter(r100.getOriginUrl(), r101);
        }

        public static t36.d e(b r100, c r101) {
            if (r100 == null) goto L8;
            BulletContext r102 = (BulletContext) r100.c(BulletContext.class);
            if (r102 == null) goto L8;
            t36.d r103 = r102.f246437e;
            if (r103 == null) goto L8;
            return r103;
        L8:
            if (r101 == null) goto L10;
            t36.d r104 = r101.getSchemaData();
        L11:
            if (r104 != null) goto L15;
            if (r101 != null) goto L18;
            return null;
        L18:
            return r101.getCurrentSchema();
        L15:
            return r104;
        L10:
            r104 = null;
            goto L11
        }

        public static gf4.a f(b r100, c r101) {
            String r102 = null;
            if (r100 == null) goto L6;
            final gf4.a r103 = (gf4.a) r100.c(gf4.a.class);
            if (r103 == null) goto L6;
        L17:
            if (r103 != null) goto L31;
            r103 = new gf4.a();
            if (r100 == null) goto L21;
            r100.e(gf4.a.class, new ITTPayAnnieService$setState$1(r103));
            Unit r104 = Unit.INSTANCE;
        L26:
            if (r104 != null) goto L31;
            Map<String, b> r105 = c36.a.f22277a;
            if (r101 == null) goto L30;
            r102 = r101.getContainerId();
        L30:
            c36.a.a(r102).e(gf4.a.class, new ITTPayAnnieService$setState$3(r103));
            goto L31
        L21:
            if (r101 == null) goto L25;
            b r106 = r101.getContextProviderFactory();
            if (r106 == null) goto L25;
            r106.e(gf4.a.class, new ITTPayAnnieService$setState$2(r103));
            r104 = Unit.INSTANCE;
        L25:
            r104 = null;
        L31:
            return r103;
        L6:
            if (r101 == null) goto L10;
            b r107 = r101.getContextProviderFactory();
            if (r107 == null) goto L10;
            r103 = (gf4.a) r107.c(gf4.a.class);
        L11:
            if (r103 != null) goto L17;
            Map<String, b> r108 = c36.a.f22277a;
            if (r101 == null) goto L15;
            String r109 = r101.getContainerId();
        L16:
            r103 = (gf4.a) c36.a.a(r109).c(gf4.a.class);
            goto L17
        L15:
            r109 = null;
        L10:
            r103 = null;
            goto L11
        }

        public static ContainerContext a(a r100, b r101, c r102) {
            t36.d r103 = r100.U6(r101, r102);
            Context r104 = null;
            if (r103 == null) goto L5;
            Uri r105 = r103.getOriginUrl();
        L6:
            String r106 = String.valueOf(r105);
            if (r101 == null) goto L12;
            e r107 = (e) r101.c(e.class);
            if (r107 == null) goto L12;
            String r108 = r107.getSessionId();
            if (r108 == null) goto L12;
        L15:
            if (r101 == null) goto L21;
            e r109 = (e) r101.c(e.class);
            if (r109 == null) goto L21;
            d r110 = r109.getActivityWrapper();
            if (r110 == null) goto L21;
            Activity r111 = r110.getActivity();
        L22:
            if (r101 == null) goto L24;
            r104 = (Context) r101.c(Context.class);
        L24:
            ContainerContext r112 = new ContainerContext(r106, r108, r111, r104);
            r112.f202238g = new C2931a(r101, r102);
            return r112;
        L21:
            r111 = null;
        L12:
            if (r102 == null) goto L14;
            r108 = r102.getContainerId();
            goto L15
        L14:
            r108 = "";
            goto L15
        L5:
            r105 = null;
            goto L6
        }

        public static df4.a b(a r100, b r101, c r102) {
            if (r101 != null) goto L7;
            if (r102 == null) goto L6;
            b r103 = r102.getContextProviderFactory();
        L8:
            if (r103 == null) goto L10;
            df4.a r104 = (df4.a) r103.c(df4.a.class);
        L11:
            if (r104 == null) goto L13;
            return r104;
        L13:
            t36.d r105 = r100.U6(r101, r102);
            if (r105 == null) goto L16;
            String r106 = r100.Sn(r105);
        L17:
            if (r106 == null) goto L38;
            Map<String, Class<? extends IBizExtension>> r107 = df4.b.f468210a;
            Intrinsics.checkNotNullParameter(r106, "biz");
            Class<? extends IBizExtension> r108 = df4.b.f468210a.get(r106);
            if (r108 == null) goto L22;
            IBizExtension r109 = (IBizExtension) ve4.b.b(r108);
            if (r109 == null) goto L22;
        L26:
            if (r109 == null) goto L28;
            df4.a r110 = new df4.a(r109);
        L29:
            if (r110 == null) goto L39;
            if (r101 != null) goto L34;
            if (r102 == null) goto L33;
            r101 = r102.getContextProviderFactory();
            goto L34
        L33:
            r101 = null;
        L34:
            if (r101 == null) goto L37;
            r101.d(df4.a.class, r110);
        L37:
            return r110;
        L39:
            return null;
        L28:
            r110 = null;
        L22:
            IKmpBizExtensions r111 = (IKmpBizExtensions) ve4.b.b(IKmpBizExtensions.class);
            if (r111 == null) goto L25;
            r109 = r111.getExtension(r106);
            goto L26
        L25:
            r109 = null;
            goto L26
        L38:
            return null;
        L16:
            r106 = null;
            goto L17
        L10:
            r104 = null;
            goto L11
        L6:
            r103 = null;
            goto L8
        L7:
            r103 = r101;
            goto L8
        }
    }

    String Sn(t36.d r100);

    t36.d U6(b r100, c r101);
}
