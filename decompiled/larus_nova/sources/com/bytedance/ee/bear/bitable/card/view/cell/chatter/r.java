package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class r implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAnalytic f207618a;

    public r(BitableAnalytic r100) {
        this.f207618a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.f.a
    public final void b(boolean r100) {
        BitableAnalytic r101 = this.f207618a;
        if (r101 == null) goto L6;
        HashMap r102 = new HashMap();
        r102.put("is_multi_group", String.valueOf(r100));
        r101.t("ccm_bitable_group_field_select_view", r102);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.f.a
    public final void a(String r100, Boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "click");
        BitableAnalytic r103 = this.f207618a;
        if (r103 == null) goto L13;
        HashMap r104 = new HashMap();
        r104.put("click", r100);
        if (TextUtils.equals(r100, "add_group") == false) goto L7;
        r104.put(PickerReporterConstants.KEY.TARGET, "ccm_bitable_group_field_add_view");
    L7:
        if (r101 == null) goto L9;
        r104.put("is_multi_group", String.valueOf(r101));
    L9:
        if (r102 == null) goto L11;
        r104.put("group_num", r102);
    L11:
        r103.t("ccm_bitable_group_field_select_click", r104);
        return;
    }
}
