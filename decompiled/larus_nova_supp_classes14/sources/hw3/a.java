package hw3;

import android.view.View;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.security.AppletJSBBridgeChannel;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.d0;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.contianer.h;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.platform.web.c;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.i;
import k2.j;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me7.d;
import org.json.JSONObject;
import q4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final AtomicBoolean a = null;

    /* JADX INFO: renamed from: hw3.a$a, reason: collision with other inner class name */
    public static final class C0134a extends id7.a {
        public final id7.a a;

        /* JADX INFO: renamed from: hw3.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0135a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PlatformType.values().length];
                r0[PlatformType.WEB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[PlatformType.LYNX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[PlatformType.WORKER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public C0134a(id7.a r1) {
            this.a = r1;
        }

        public final void a(le7.a<?> r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "call");
            id7.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            return;
        }

        public final boolean b(le7.a r13, d r14, com.bytedance.sdk.xbridge.cn.protocol.d r15) {
            Intrinsics.checkNotNullParameter(r13, "call");
            Intrinsics.checkNotNullParameter(r14, "context");
            Intrinsics.checkNotNullParameter(r15, "callback");
            AppletRuntimeManager r0 = AppletRuntimeManager.INSTANCE;
            View r1 = r14.a.b;
            r0.getClass();
            i r2 = AppletRuntimeManager.d(r1);
            if (r2 == null) goto L12;
            String r4 = r2.getAppletId();
            if (r4 == null) goto L12;
            if (r4.length() <= 0) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == false) goto L12;
        L13:
            if (r2 == null) goto L71;
            if (r4 == null) goto L71;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L31
            AppletAppManagerService.INSTANCE.getClass();     // Catch: Throwable -> L31
            AppletApplication r7 = AppletAppManagerService.a(r4);     // Catch: Throwable -> L31
            if (r7 == null) goto L20;
            Applet r8 = r7.j();     // Catch: Throwable -> L31
            if (r8 == null) goto L20;
            Integer r9 = Integer.valueOf(((AIPackage) r8).G);     // Catch: Throwable -> L31
        L29:
            Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L31
        L33:
            Throwable r11 = Result.exceptionOrNull-impl(r10);
            if (r11 == null) goto L37;
            g.a.e("AppletJSBAccessControl", "resolveSourceType failed: appletId=".concat(r4), r11);
        L37:
            if (Result.isFailure-impl(r10) == false) goto L39;
            r10 = null;
        L39:
            Integer r12 = (Integer) r10;
            if (r12 != null) goto L43;
            g.a.e("AppletJSBAccessControl", "resolveSourceType failed: manifest not found, appletId=".concat(r4));
        L43:
            if ((r2 instanceof h) == false) goto L46;
            String r3 = "widget";
        L50:
            if (StringsKt.contains$default(r13.a, '.', false, 2, null) == false) goto L52;
        L58:
            String r16 = r13.a;
        L59:
            g r17 = g.a;
            StringBuilder r18 = new StringBuilder("evaluate: appletId=");
            r18.append(r4);
            r18.append(", containerType=");
            r18.append(r3);
            r18.append(", channel=");
            AppletJSBBridgeChannel r19 = AppletJSBBridgeChannel.XBRIDGE;
            r18.append(r19.getValue());
            r18.append(", methodName=");
            r18.append(r16);
            r17.i("AppletJSBAccessControl", r18.toString());
            if (b.a(r16, r12, r4) == true) goto L71;
            b.b(r16, r4, r12, r3, r19);
            String r110 = "method " + r16 + " is not allowed for third-party applets";
            r13.k = -6;
            Intrinsics.checkNotNullParameter(r110, "<set-?>");
            r13.l = r110;
            r13.m = false;
            PlatformType r111 = r13.c();
            f3.a r112 = f3.a.l;
            JavaOnlyMap r113 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("code", -6), TuplesKt.to("msg", r110), TuplesKt.to("errNo", Integer.valueOf(r112.a)), TuplesKt.to("errMsg", r112.b)});
            int r114 = C0135a.a[r111.ordinal()];
            if (r114 == 1) goto L68;
            if (r114 == 2) goto L69;
            if (r114 != 3) goto L67;
            r113 = JavaOnlyMap.from(r113);
            goto L69
        L67:
            throw new NoWhenBranchMatchedException();
        L69:
            Intrinsics.checkNotNull(r113);
            r15.c(r113);
            return true;
        L68:
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            r113 = new JSONObject(r113);
            goto L69
        L52:
            if (r13.d.length() != 0) goto L54;
            boolean r20 = true;
        L55:
            if (r20 == true) goto L58;
            r16 = r13.d + '.' + r13.a;
            goto L59
        L54:
            r20 = false;
            goto L55
        L46:
            if ((r2 instanceof j) == false) goto L48;
            r3 = "page";
            goto L50
        L48:
            r3 = CommentPublishScene.UNKNOWN;
        L20:
            AIManager r21 = AIManager.a;     // Catch: Throwable -> L31
            d0 r22 = AIManager.m(r4);     // Catch: Throwable -> L31
            if (r22 == null) goto L28;
            Applet r23 = r22.g(r4);     // Catch: Throwable -> L31
            if (r23 == null) goto L25;
            r9 = Integer.valueOf(((AIPackage) r23).G);     // Catch: Throwable -> L31
            goto L29
        L25:
            Widget r24 = (Widget) CollectionsKt.firstOrNull(r22.f());     // Catch: Throwable -> L31
            if (r24 == null) goto L28;
            r9 = Integer.valueOf(((AIPackage) r24).G);     // Catch: Throwable -> L31
        L28:
            r9 = null;
        L31:
            th = move-exception;
            Result.Companion r25 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
        L71:
            id7.a r26 = this.a;
            if (r26 != null) goto L74;
        L76:
            return false;
        L74:
            if (r26.b(r13, r14, r15) != true) goto L76;
            return true;
        L9:
            r5 = false;
        L12:
            r4 = null;
            goto L13
        }

        public final void c(String r2, Object r3, c r4) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r4, "context");
            id7.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.c(r2, r3, r4);
            return;
        }
    }

    static {
        a = new AtomicBoolean(false);
    }
}
