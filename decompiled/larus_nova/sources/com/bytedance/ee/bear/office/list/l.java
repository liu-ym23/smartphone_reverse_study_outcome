package com.bytedance.ee.bear.office.list;

import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235917a = 0;

    static {
    }

    public static void a(SmartRefreshLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        r100.setTag(R.id.list_office_load_state_style_config, new com.bytedance.ee.bear.list.loadstateview.i(new com.bytedance.ee.bear.list.loadstateview.i.a(R.drawable.dbx_empty_folder, R.dimen.office_load_state_empty_icon_size, R.string.LarkCCM_Doubao_Drive_NoContent_EmptyState, -1), new com.bytedance.ee.bear.list.loadstateview.i.a(R.drawable.dbx_loading_fail, R.dimen.office_load_state_fail_icon_size, R.string.LarkCCM_Doubao_Drive_LoadFailed_EmptyState, R.string.LarkCCM_Doubao_Drive_Retry_Button)));
    }
}
