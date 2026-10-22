package oe5;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.lynx.impl.route.c;
import com.bytedance.ee.bear.lynx.impl.route.d;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.mt.protector.impl.UriProtector;
import ie5.f;
import ie5.g;
import ie5.h;
import ie5.i;
import ie5.j;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends XCoreBridgeMethod {
    public final String a;
    public final String b;

    public static final class a {
        public final /* synthetic */ b a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public a(b r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(i66.b r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "result");
            Intrinsics.checkNotNullParameter(r4, "msg");
            int r0 = i66.b.a;
            Map r5 = i66.b.a.a(r3);
            this.a.onSuccess(this.b, r5, r4);
        }
    }

    public b() {
        this.a = "ccm.openPage";
        this.b = "ccm-lynx: XOpenPageMethod";
    }

    public final String getName() {
        return this.a;
    }

    public final Class<oe5.a> provideParamModel() {
        return oe5.a.class;
    }

    public final Class<i66.b> provideResultModel() {
        return i66.b.class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handle(XReadableMap r23, XBridgeMethod.Callback r24, XBridgePlatformType r25) {
        Intrinsics.checkNotNullParameter(r23, "params");
        Intrinsics.checkNotNullParameter(r24, "callback");
        Intrinsics.checkNotNullParameter(r25, ResourceData.KEY_TYPE);
        int r6 = oe5.a.g;
        Intrinsics.checkNotNullParameter(r23, "params");
        String r9 = s.f(r23, "schema", "");
        if (r9.length() != 0) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L9;
        oe5.a r11 = null;
    L18:
        if (r11 != null) goto L21;
        XCoreBridgeMethod.onFailure$default(this, r24, -3, null, null, 12, null);
        return;
    L21:
        a r0 = new a(this, r24);
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r0, "callback");
        Intrinsics.checkNotNullParameter(r25, ResourceData.KEY_TYPE);
        String r2 = r11.a;
        if (r2 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("schema");
        r2 = null;
    L25:
        boolean r3 = r11.b;
        boolean r4 = r11.c;
        tt5.a.h(this.b, "replace: " + r3 + ",  useSysBrowser: " + r4 + ",  panelParam: " + r11.f);
        Context r5 = (Context) provideContext(Context.class);
        Fragment r19 = (Fragment) provideContext(Fragment.class);
        if (r5 != 0) goto L29;
        Intrinsics.checkNotNullParameter("Context not provided in host", "msg");
        XCoreBridgeMethod.onFailure$default(this, r24, 0, "Context not provided in host", null, 8, null);
        return;
    L29:
        if (TextUtils.isEmpty(r2) == false) goto L31;
        Intrinsics.checkNotNullParameter("schema url is empty", "msg");
        XCoreBridgeMethod.onFailure$default(this, r24, 0, "schema url is empty", null, 8, null);
        return;
    L31:
        de5.a r1 = new de5.a(r11.d, r11.e, r11.f, null, null, r19, false, 88);
        int r7 = j.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r1, "openParams");
        Map<Integer, String> r12 = d.a;
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
        if (d.b(UriProtector.parse(r2)) == false) goto L34;
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).b(r5, r2, r1);
    L37:
        if (r3 == true) goto L39;
    L41:
        r0.a(new i66.b(), "");
        return;
    L39:
        if ((r5 instanceof c) == false) goto L41;
        ((c) r5).close();
        goto L41
    L34:
        if (r4 == false) goto L36;
        Flowable.just("").subscribeOn(fo5.d.b()).map(f.a).map(new g(r2)).observeOn(fo5.d.d()).subscribe(h.a, i.a);
        goto L37
    L36:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r2);
        goto L37
    L9:
        r11 = new oe5.a();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r11.a = r9;
        r11.b = s.b(r23, "replace", false);
        r11.c = s.b(r23, "useSysBrowser", false);
        r11.d = s.f(r23, "shareContextID", "");
        XReadableMap r13 = s.e(r23, "initialProperties");
        if (r13 == null) goto L12;
        HashMap<String, Serializable> r14 = ie5.a.b(r13);
    L13:
        r11.e = r14;
        XReadableMap r8 = s.e(r23, "panelParam");
        if (r8 == null) goto L16;
        HashMap<String, Serializable> r15 = ie5.a.b(r8);
    L17:
        r11.f = r15;
        goto L18
    L16:
        r15 = null;
        goto L17
    L12:
        r14 = null;
        goto L13
    L5:
        r10 = false;
        goto L7
    }
}
