package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/linkshare/linkpassword/OfficeRequestPasswordView;", "Lcom/bytedance/ee/bear/middleground/permission/setting/linkshare/linkpassword/RequestPasswordView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getContentLayoutRes", "", "getConfirmEnabledBgRes", "getConfirmDisabledBgRes", "showEditTextErrorBg", "", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeRequestPasswordView extends RequestPasswordView {
    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView
    public int getConfirmDisabledBgRes() {
        return R.drawable.office_permission_primary_button_disabled;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView
    public int getConfirmEnabledBgRes() {
        return R.drawable.office_permission_primary_button;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView
    public int getContentLayoutRes() {
        return R.layout.office_request_password_layout;
    }

    public OfficeRequestPasswordView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public OfficeRequestPasswordView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
