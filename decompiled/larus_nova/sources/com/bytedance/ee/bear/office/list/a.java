package com.bytedance.ee.bear.office.list;

import android.os.Bundle;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235562a = 0;

    static {
    }

    public static Bundle a(OfficeFolderPageRequest r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Bundle r103 = new Bundle();
        r103.putSerializable("office_folder_page_request", r100);
        r103.putString("token", r100.getFolderToken());
        r103.putString("title", r100.getFolderTitle());
        r103.putInt(ToygerFaceAlgorithmConfig.DEPTH, r100.getDepth());
        Integer r104 = r100.getPayload().getOwnerType();
        if (r104 == null) goto L5;
        r103.putInt("owner_type", r104.intValue());
    L5:
        r103.putInt("permission", r100.getPayload().getPermission());
        r103.putString(DocViewModel.EXTRA_PARENT_TOKEN, r100.getPayload().getParentToken());
        r103.putString("parent_space_id", r100.getPayload().getParentSpaceId());
        r103.putString("current_module", r100.getPayload().getCurrentModule());
        r103.putString("type", r100.getPayload().getFolderType());
        r103.putBoolean("is_external", r100.getPayload().isExternal());
        r103.putBoolean("is_personal_folder", r100.getPayload().isPersonalFolder());
        OfficeSpaceTab r105 = r100.getPayload().getSourceTab();
        if (r105 != null) goto L8;
        r105 = OfficeSpaceTab.MINE;
    L8:
        r103.putSerializable("office_list_tab", r105);
        r103.putSerializable("office_list_config", r100.getPayload().getListConfig().toOfficeListConfig());
        if (r101 != null) goto L11;
    L16:
        return r103;
    L11:
        if ((!StringsKt.isBlank(r101)) == true) goto L14;
        r101 = null;
    L14:
        if (r101 == null) goto L16;
        r103.putString("office_list_runtime_id", r101);
        r103.putBoolean("office_folder_runtime_owned_by_fragment", r102);
        goto L16
    }
}
