package hi5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.PolicyConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements c.b {
    public final /* synthetic */ PolicyConfig a;

    @Override // hi5.c.b
    public final void a() {
        com.bytedance.ee.bear.route.h r0 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        PolicyConfig r1 = this.a;
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(r1, "policyConfig");
        String r5 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        String r3 = r1.getPrivacy_url();
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        tt5.a.h("ChoosePolicyUtil", "getPrivacyUrl use default");
        String r4 = "https://feishu.cn/{lan}/privacy";
    L9:
        r0.u5(StringsKt.replace$default(r4, "{lan}", r5, false, 4, null));
        return;
    L8:
        r4 = "https://".concat(r3);
        goto L9
    }

    @Override // hi5.c.b
    public final void b() {
        com.bytedance.ee.bear.route.h r0 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        PolicyConfig r1 = this.a;
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(r1, "policyConfig");
        String r5 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        String r3 = r1.getService_term_url();
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        tt5.a.h("ChoosePolicyUtil", "getServiceTermUrl use default");
        String r4 = "https://feishu.cn/{lan}/terms";
    L9:
        r0.u5(StringsKt.replace$default(r4, "{lan}", r5, false, 4, null));
        return;
    L8:
        r4 = "https://".concat(r3);
        goto L9
    }

    public v(PolicyConfig r1) {
        this.a = r1;
    }
}
