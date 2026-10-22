package qe5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends XCoreBridgeMethod implements hj5.b {
    public XBridgeMethod.Callback a;
    public final String b;
    public final XBridgeMethod.Access c;

    public static final class a {
    }

    static {
    }

    public f() {
        this.b = "ccm.permission.showWikiScopePicker";
        this.c = XBridgeMethod.Access.PROTECT;
    }

    public final void release() {
        super.release();
        tt5.a.h("ccm-lynx: CCMSelectPermTypeMethod", "release()...");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ArrayList<hj5.b> r0 = jg5.j.i;
        if (hu5.a.f(r0) == false) goto L6;
        r0.remove(this);
        return;
    }

    public final XBridgeMethod.Access getAccess() {
        return this.c;
    }

    public final String getName() {
        return this.b;
    }

    @Override // hj5.b
    public final void a(int r9) {
        tt5.a.h("ccm-lynx: CCMSelectPermTypeMethod", "onPermTypeChanged()...permType = " + r9);
        XBridgeMethod.Callback r3 = this.a;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r9 != (-1)) goto L7;
        XCoreBridgeMethod.onSuccess$default(this, r3, new LinkedHashMap(), null, 4, null);
        return;
    L7:
        XCoreBridgeMethod.onSuccess$default(this, r3, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scopeType", Integer.valueOf(r9))}), null, 4, null);
    }

    public final void handle(XReadableMap r4, XBridgeMethod.Callback r5, XBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TYPE);
        boolean r7 = r4.getBoolean("shouldShowLockTips");
        int r8 = r4.getInt("defaultScopeType");
        tt5.a.h("ccm-lynx: CCMSelectPermTypeMethod", "handle()...willLock = " + r7 + ", permType = " + r8 + ", callback = " + r5);
        this.a = r5;
        FragmentActivity r9 = (Context) provideContext(Context.class);
        if ((r9 instanceof FragmentActivity) == false) goto L7;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).Xe(r9, r7, r8);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ArrayList<hj5.b> r10 = jg5.j.i;
        if (r10.contains(this) == true) goto L9;
        r10.add(this);
        return;
    L9:
        return;
    L7:
        tt5.a.d("ccm-lynx: CCMSelectPermTypeMethod", "context is not FragmentActivity, return");
    }
}
