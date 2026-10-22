package com.larus.drive.sdk.impl.utils;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewResType;
import com.obric.sva.sdk.data.ISmModel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l {
    public static final DrivePreviewOpenItem a(OfficeSpaceItem r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return new DrivePreviewOpenItem("2", DrivePreviewResType.SPACE_FILE, r110.getToken(), r110.getObjType(), r110.getTitle(), r110.getUrl(), r110.getExtra().get(DrivePreviewOpenItem.EXTRA_FILE_EXT), r110.getExtra().get(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN), r110.getExtra().get(DrivePreviewOpenItem.EXTRA_MOUNT_POINT), null, null, new HashMap(r110.getExtra()), ISmModel.VERSION_0600, null);
    }
}
