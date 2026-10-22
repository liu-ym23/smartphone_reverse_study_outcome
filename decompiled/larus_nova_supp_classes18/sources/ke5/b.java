package ke5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.escape.g;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends XCoreBridgeMethod {
    public final String a;

    public static final class a {
    }

    /* JADX INFO: renamed from: ke5.b$b, reason: collision with other inner class name */
    public static final class C0254b implements g.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.b
        public final void onCancel() {
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", DocFeed$Value$Result.CANCEL)}), null, 4, null);
        }

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.b
        public final void onConfirm() {
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", "confirm")}), null, 4, null);
        }

        public C0254b(b r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public b() {
        this.a = "ccm.permission.escape_rule.repeatedApprovalDialog";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r4, XBridgeMethod.Callback r5, XBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TYPE);
        FragmentActivity r7 = (Context) provideContext(Context.class);
        if ((r7 instanceof FragmentActivity) == true) goto L6;
        tt5.a.d("CCMEscapeRepeatedApprovalDialogMethod", "context is not FragmentActivity!");
        return;
    L6:
        ((g) org.koin.java.a.c(g.class, null, null, 6)).c(r7, d.a(r4), new C0254b(this, r5));
    }
}
