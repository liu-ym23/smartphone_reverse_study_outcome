package ii5;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.OfficeRequestPasswordView;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.nova.R;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@UserScope
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f489993a;

    @Inject
    public d() {
        this.f489993a = a.f489991a;
    }

    @Override // ii5.b
    public final int a() {
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L10;
        return R.layout.office_enter_link_password;
    L10:
        this.f489993a.getClass();
        return R.layout.enter_link_password;
    L5:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // ii5.b
    public final RequestPasswordView b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L12;
        this.f489993a.getClass();
        RequestPasswordView r102 = new RequestPasswordView(r100);
        Intrinsics.checkNotNull(r102);
        return r102;
    L12:
        return new OfficeRequestPasswordView(r100, null);
    L5:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // ii5.b
    public final com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.h c(FragmentActivity r100, View r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        this.f489993a.getClass();
        return new com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.h(r100, r101, r102);
    }
}
