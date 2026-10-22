package com.bytedance.ee.bear.lynx.impl.xbridge.method.view;

import android.text.TextUtils;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.v;
import eu5.c;
import fe5.h;
import i66.b;
import ie5.j;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a extends XCoreBridgeMethod {
    public final String a;
    public final XBridgeMethod.Access b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.xbridge.method.view.a$a, reason: collision with other inner class name */
    public static final class C0045a {
        public final /* synthetic */ XBridgeMethod.Callback a;

        public C0045a(XBridgeMethod.Callback r1) {
            this.a = r1;
        }
    }

    public a() {
        this.a = "ccm.sendContainerEvent";
        this.b = XBridgeMethod.Access.PROTECT;
    }

    public final XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final Class<SendEventContainerMethodParamModel> provideParamModel() {
        return SendEventContainerMethodParamModel.class;
    }

    public final Class<b> provideResultModel() {
        return b.class;
    }

    public final void handle(XReadableMap r10, XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TYPE);
        int r3 = SendEventContainerMethodParamModel.d;
        Intrinsics.checkNotNullParameter(r10, "params");
        String r4 = s.f(r10, "containerID", "");
        String r5 = s.f(r10, "eventName", "");
        XReadableMap r13 = s.e(r10, "params");
        SendEventContainerMethodParamModel r6 = new SendEventContainerMethodParamModel();
        if (TextUtils.isEmpty(r4) == true) goto L6;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r6.a = r4;
    L6:
        if (TextUtils.isEmpty(r5) == true) goto L8;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r6.b = r5;
    L8:
        r6.c = r13;
        C0045a r14 = new C0045a(r11);
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TYPE);
        String r15 = r6.a;
        String r16 = r6.b;
        XReadableMap r17 = r6.c;
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        CCMLynxCardView.b r1 = null;
        if (r17 == null) goto L11;
        u r2 = r17.keyIterator();
    L12:
        LinkedHashMap r7 = new LinkedHashMap();
        if (r2 != null) goto L15;
    L37:
        r0.element = r7;
        Map<String, WeakReference<CCMLynxCardView>> r18 = h.a;
        Intrinsics.checkNotNullParameter(r15, "containerId");
        WeakReference r19 = (WeakReference) ((LinkedHashMap) h.a).get(r15);
        if (r19 == null) goto L40;
        CCMLynxCardView r110 = (CCMLynxCardView) r19.get();
    L41:
        if (r110 == null) goto L44;
        r1 = r110.e();
    L44:
        switch(r16.hashCode()) {
            case -1351902487: goto L65;
            case -1012968068: goto L60;
            case -504772615: goto L52;
            case -256129687: goto L47;
            default: goto L69;
        };
    L69:
        tt5.a.k("ccm-lynx: SendContainerEventMethod", "unknown event");
        return;
    L47:
        if (r16.equals(SendEventContainerMethodParamModel.EventKinds.closeContainer) == false) goto L69;
        if (r1 == null) goto L96;
        r1.H();
        return;
    L96:
        return;
    L52:
        if (r16.equals(SendEventContainerMethodParamModel.EventKinds.openPage) == false) goto L69;
        Map r111 = (Map) r0.element;
        if (r111 == null) goto L98;
        String r112 = (String) r111.get("location");
        if (r112 == null) goto L99;
        int r113 = j.a;
        Map r114 = (Map) r0.element;
        Intrinsics.checkNotNullParameter(r112, "path");
        return;
    L99:
        return;
    L98:
        return;
    L60:
        if (r16.equals(SendEventContainerMethodParamModel.EventKinds.onShow) == false) goto L69;
        if (r1 == null) goto L101;
        r1.onShow();
        return;
    L101:
        return;
    L65:
        if (r16.equals(SendEventContainerMethodParamModel.EventKinds.onClick) == false) goto L69;
        if (r1 == null) goto L103;
        r1.a((Map) r0.element);
        return;
    L103:
        return;
    L40:
        r110 = null;
    L15:
        if (r2.hasNextKey() == false) goto L37;
        String r8 = r2.nextKey();
        if (r17 == null) goto L15;
        t r9 = r17.get(r8);
        if (r9 == null) goto L15;
        switch(se5.a.b.a[r9.getType().ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L28;
            case 6: goto L25;
            default: goto L23;
        };
    L25:
        v r20 = r9.asArray();
        if (r20 == null) goto L15;
        String r21 = (String) r7.put(r8, com.bytedance.ies.xbridge.utils.j.c(r20).toString());
        goto L15
    L28:
        XReadableMap r22 = r9.asMap();
        if (r22 == null) goto L15;
        String r23 = (String) r7.put(r8, com.bytedance.ies.xbridge.utils.j.d(r22).toString());
        goto L15
    L31:
        r7.put(r8, r9.asString());
        goto L15
    L32:
        r7.put(r8, com.bytedance.ee.bear.lynx.impl.xbridge.a.a(r17, r8).toString());
        goto L15
    L33:
        r7.put(r8, String.valueOf(r9.asInt()));
        goto L15
    L34:
        r7.put(r8, String.valueOf(r9.asBoolean()));
        goto L15
    L23:
        if (c.a() == true) goto L36;
        tt5.a.k("ccm-lynx: SendContainerEventMethod", "event param type unknown");
        Unit r24 = Unit.INSTANCE;
        goto L15
    L36:
        throw new IllegalArgumentException("Illegal level!");
    L11:
        r2 = null;
        goto L12
    }
}
