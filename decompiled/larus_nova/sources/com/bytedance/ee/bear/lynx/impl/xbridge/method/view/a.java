package com.bytedance.ee.bear.lynx.impl.xbridge.method.view;

import android.text.TextUtils;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
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

/* JADX INFO: loaded from: classes18.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f229971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f229972b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.xbridge.method.view.a$a, reason: collision with other inner class name */
    public static final class C3292a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f229973a;

        public C3292a(XBridgeMethod.Callback r100) {
            this.f229973a = r100;
        }
    }

    public a() {
        this.f229971a = "ccm.sendContainerEvent";
        this.f229972b = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f229972b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f229971a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<SendEventContainerMethodParamModel> provideParamModel() {
        return SendEventContainerMethodParamModel.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<b> provideResultModel() {
        return b.class;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.util.LinkedHashMap, java.util.Map] */
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = SendEventContainerMethodParamModel.f229966d;
        Intrinsics.checkNotNullParameter(r110, "params");
        String r101 = s.f(r110, "containerID", "");
        String r102 = s.f(r110, "eventName", "");
        XReadableMap r113 = s.e(r110, "params");
        SendEventContainerMethodParamModel r103 = new SendEventContainerMethodParamModel();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r103.f229967a = r101;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r103.f229968b = r102;
    L8:
        r103.f229969c = r113;
        C3292a r114 = new C3292a(r111);
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r114, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r115 = r103.f229967a;
        String r116 = r103.f229968b;
        XReadableMap r117 = r103.f229969c;
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        CCMLynxCardView.b r105 = null;
        if (r117 == null) goto L11;
        u r106 = r117.keyIterator();
    L12:
        ?? r107 = new LinkedHashMap();
        if (r106 != null) goto L15;
    L37:
        r104.element = r107;
        Map<String, WeakReference<CCMLynxCardView>> r118 = h.f476596a;
        Intrinsics.checkNotNullParameter(r115, "containerId");
        WeakReference r119 = (WeakReference) ((LinkedHashMap) h.f476596a).get(r115);
        if (r119 == null) goto L40;
        CCMLynxCardView r120 = (CCMLynxCardView) r119.get();
    L41:
        if (r120 == null) goto L44;
        r105 = r120.e();
    L44:
        switch(r116.hashCode()) {
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
        if (r116.equals(SendEventContainerMethodParamModel.EventKinds.closeContainer) == false) goto L69;
        if (r105 == null) goto L96;
        r105.H();
        return;
    L96:
        return;
    L52:
        if (r116.equals(SendEventContainerMethodParamModel.EventKinds.openPage) == false) goto L69;
        Map r121 = (Map) r104.element;
        if (r121 == null) goto L98;
        String r122 = (String) r121.get("location");
        if (r122 == null) goto L99;
        int r123 = j.f489486a;
        Map r124 = (Map) r104.element;
        Intrinsics.checkNotNullParameter(r122, "path");
        return;
    L99:
        return;
    L98:
        return;
    L60:
        if (r116.equals(SendEventContainerMethodParamModel.EventKinds.onShow) == false) goto L69;
        if (r105 == null) goto L101;
        r105.onShow();
        return;
    L101:
        return;
    L65:
        if (r116.equals(SendEventContainerMethodParamModel.EventKinds.onClick) == false) goto L69;
        if (r105 == null) goto L103;
        r105.a((Map) r104.element);
        return;
    L103:
        return;
    L40:
        r120 = null;
    L15:
        if (r106.hasNextKey() == false) goto L37;
        String r108 = r106.nextKey();
        if (r117 == null) goto L15;
        t r109 = r117.get(r108);
        if (r109 == null) goto L15;
        switch(se5.a.b.f541560a[r109.getType().ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L28;
            case 6: goto L25;
            default: goto L23;
        };
    L25:
        v r125 = r109.asArray();
        if (r125 == null) goto L15;
        String r126 = (String) r107.put(r108, com.bytedance.ies.xbridge.utils.j.c(r125).toString());
        goto L15
    L28:
        XReadableMap r127 = r109.asMap();
        if (r127 == null) goto L15;
        String r128 = (String) r107.put(r108, com.bytedance.ies.xbridge.utils.j.d(r127).toString());
        goto L15
    L31:
        r107.put(r108, r109.asString());
        goto L15
    L32:
        r107.put(r108, com.bytedance.ee.bear.lynx.impl.xbridge.a.a(r117, r108).toString());
        goto L15
    L33:
        r107.put(r108, String.valueOf(r109.asInt()));
        goto L15
    L34:
        r107.put(r108, String.valueOf(r109.asBoolean()));
        goto L15
    L23:
        if (c.a() == true) goto L36;
        tt5.a.k("ccm-lynx: SendContainerEventMethod", "event param type unknown");
        Unit r129 = Unit.INSTANCE;
        goto L15
    L36:
        throw new IllegalArgumentException("Illegal level!");
    L11:
        r106 = null;
        goto L12
    }
}
