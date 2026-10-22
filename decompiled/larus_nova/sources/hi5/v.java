package hi5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.PolicyConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class v implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PolicyConfig f485337a;

    @Override // hi5.c.b
    public final void a() {
        com.bytedance.ee.bear.route.h r100 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        PolicyConfig r101 = this.f485337a;
        int r102 = c.f485276a;
        Intrinsics.checkNotNullParameter(r101, "policyConfig");
        String r103 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        String r104 = r101.getPrivacy_url();
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        if (TextUtils.isEmpty(r104) == false) goto L8;
        tt5.a.h("ChoosePolicyUtil", "getPrivacyUrl use default");
        String r105 = "https://feishu.cn/{lan}/privacy";
    L9:
        r100.u5(StringsKt.replace$default(r105, "{lan}", r103, false, 4, null));
        return;
    L8:
        r105 = "https://".concat(r104);
        goto L9
    }

    @Override // hi5.c.b
    public final void b() {
        com.bytedance.ee.bear.route.h r100 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        PolicyConfig r101 = this.f485337a;
        int r102 = c.f485276a;
        Intrinsics.checkNotNullParameter(r101, "policyConfig");
        String r103 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        String r104 = r101.getService_term_url();
        if (r104 != null) goto L6;
        r104 = "";
    L6:
        if (TextUtils.isEmpty(r104) == false) goto L8;
        tt5.a.h("ChoosePolicyUtil", "getServiceTermUrl use default");
        String r105 = "https://feishu.cn/{lan}/terms";
    L9:
        r100.u5(StringsKt.replace$default(r105, "{lan}", r103, false, 4, null));
        return;
    L8:
        r105 = "https://".concat(r104);
        goto L9
    }

    public v(PolicyConfig r100) {
        this.f485337a = r100;
    }
}
