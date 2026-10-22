package com.bytedance.ee.drive.preview;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.drive.core.fragment.j;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DrivePreviewService$prepareOpenRequest$result$2 extends FunctionReferenceImpl implements Function1<DrivePreviewOpenItem, MimeTypeCategory> {
    public DrivePreviewService$prepareOpenRequest$result$2(Object r100) {
        super(1, r100, j.class, "resolveFromOpenItem", "resolveFromOpenItem(Lcom/bytedance/ee/drive/preview/DrivePreviewOpenItem;)Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeCategory;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MimeTypeCategory invoke2(DrivePreviewOpenItem r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((j) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        String r101 = r100.getFileExt();
        String r102 = null;
        if (r101 != null) goto L5;
    L9:
        String r103 = r100.getTitle();
        if (r103 == null) goto L12;
        r102 = StringsKt.substringAfterLast(r103, '.', "");
    L12:
        if (r102 != null) goto L14;
        r101 = "";
    L16:
        return j.e(j.c(r101), "");
    L14:
        r101 = r102;
        goto L16
    L5:
        if (StringsKt.isBlank(r101) == false) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L16;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MimeTypeCategory invoke(DrivePreviewOpenItem r100) {
        return invoke2(r100);
    }
}
