package ke5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.escape.g;
import com.bytedance.ee.bear.middleground.permission.escape.model.ApprovalDef;
import com.bytedance.ee.bear.middleground.permission.escape.model.ApprovalDetail;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
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
public final class c extends XCoreBridgeMethod {
    public final String a;

    public static final class a {
    }

    public static final class b implements g.a {
        public final /* synthetic */ c a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
        }

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
        public final void onCancel() {
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", DocFeed$Value$Result.CANCEL)}), null, 4, null);
        }

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
        public final void onSuccess() {
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", "success")}), null, 4, null);
        }

        public b(c r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public c() {
        this.a = "ccm.permission.escape_rule.approval";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r20, XBridgeMethod.Callback r21, XBridgePlatformType r22) {
        Intrinsics.checkNotNullParameter(r20, "params");
        Intrinsics.checkNotNullParameter(r21, "callback");
        Intrinsics.checkNotNullParameter(r22, ResourceData.KEY_TYPE);
        FragmentActivity r5 = (Context) provideContext(Context.class);
        if ((r5 instanceof FragmentActivity) == true) goto L6;
        tt5.a.d("CCMSecretLevelEscapeApprovalMethod", "context is not FragmentActivity!");
        return;
    L6:
        g r6 = (g) org.koin.java.a.c(g.class, null, null, 6);
        FragmentActivity r7 = r5;
        int r8 = d.a;
        Intrinsics.checkNotNullParameter(r20, "params");
        String r9 = r20.getString(ResourceData.KEY_TOKEN);
        int r10 = r20.getInt(ResourceData.KEY_TYPE);
        String r11 = r20.getString("escape_setting");
        XReadableMap r3 = r20.getMap("approval_def");
        if (r3 != null) goto L9;
        ApprovalDef r12 = new ApprovalDef(null, null, null, null, 15, null);
    L14:
        r6.b(r7, new EscapeRuleBean(r9, r10, r11, r12, r20.getInt("perm_req_type"), r20.getString("perm_req_param"), false, 0, 192, null), d.a(r20), new b(this, r21));
        return;
    L9:
        String r4 = r3.getString("approval_code");
        XReadableMap r13 = r3.getMap("approval_detail");
        if (r13 != null) goto L12;
        ApprovalDetail r14 = new ApprovalDetail(false, false, 3, null);
    L13:
        r12 = new ApprovalDef(r4, r14, d.c(r3.getArray("reviewers")), d.c(r3.getArray("cc_users")));
        goto L14
    L12:
        r14 = new ApprovalDetail(r13.getBoolean("is_need_approve"), r13.getBoolean("only_carbon_copy"));
        goto L13
    }
}
