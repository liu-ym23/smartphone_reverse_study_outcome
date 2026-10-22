package com.bytedance.ee.bear.office.list;

import android.os.Bundle;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Bundle a(OfficeFolderPageRequest r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Bundle r0 = new Bundle();
        r0.putSerializable("office_folder_page_request", r3);
        r0.putString(ResourceData.KEY_TOKEN, r3.getFolderToken());
        r0.putString("title", r3.getFolderTitle());
        r0.putInt("depth", r3.getDepth());
        Integer r1 = r3.getPayload().getOwnerType();
        if (r1 == null) goto L5;
        r0.putInt("owner_type", r1.intValue());
    L5:
        r0.putInt("permission", r3.getPayload().getPermission());
        r0.putString("parent_token", r3.getPayload().getParentToken());
        r0.putString("parent_space_id", r3.getPayload().getParentSpaceId());
        r0.putString("current_module", r3.getPayload().getCurrentModule());
        r0.putString(ResourceData.KEY_TYPE, r3.getPayload().getFolderType());
        r0.putBoolean("is_external", r3.getPayload().isExternal());
        r0.putBoolean("is_personal_folder", r3.getPayload().isPersonalFolder());
        OfficeSpaceTab r2 = r3.getPayload().getSourceTab();
        if (r2 != null) goto L8;
        r2 = OfficeSpaceTab.MINE;
    L8:
        r0.putSerializable("office_list_tab", r2);
        r0.putSerializable("office_list_config", r3.getPayload().getListConfig().toOfficeListConfig());
        if (r4 != null) goto L11;
    L16:
        return r0;
    L11:
        if ((!StringsKt.isBlank(r4)) == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L16;
        r0.putString("office_list_runtime_id", r4);
        r0.putBoolean("office_folder_runtime_owned_by_fragment", r5);
        goto L16
    }
}
