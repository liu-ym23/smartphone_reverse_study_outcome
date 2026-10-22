package ke5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.escape.g;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends XCoreBridgeMethod {
    public final String a;

    /* JADX INFO: renamed from: ke5.a$a, reason: collision with other inner class name */
    public static final class C0253a {
    }

    static {
    }

    public a() {
        this.a = "ccm.permission.escape_rule.approvalList";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r3, XBridgeMethod.Callback r4, XBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TYPE);
        FragmentActivity r6 = (Context) provideContext(Context.class);
        if ((r6 instanceof FragmentActivity) == true) goto L6;
        tt5.a.d("CCMEscapeApprovalListMethod", "context is not FragmentActivity!");
        return;
    L6:
        ((g) org.koin.java.a.c(g.class, null, null, 6)).d(r6, d.a(r3));
    }
}
