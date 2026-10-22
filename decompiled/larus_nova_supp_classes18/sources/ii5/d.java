package ii5;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.OfficeRequestPasswordView;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@UserScope
public final class d implements b {
    public final a a;

    @Inject
    public d() {
        this.a = a.a;
    }

    @Override // ii5.b
    public final int a() {
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        return 2131564060;
    L10:
        this.a.getClass();
        return 2131561079;
    L5:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // ii5.b
    public final RequestPasswordView b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L12;
        this.a.getClass();
        RequestPasswordView r1 = new RequestPasswordView(r3);
        Intrinsics.checkNotNull(r1);
        return r1;
    L12:
        return new OfficeRequestPasswordView(r3, null);
    L5:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // ii5.b
    public final com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.h c(FragmentActivity r2, View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        this.a.getClass();
        return new com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.h(r2, r3, r4);
    }
}
