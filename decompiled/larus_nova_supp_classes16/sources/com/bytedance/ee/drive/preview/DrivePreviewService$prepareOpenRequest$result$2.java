package com.bytedance.ee.drive.preview;

import com.bytedance.ee.bear.drive.core.fragment.j;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DrivePreviewService$prepareOpenRequest$result$2 extends FunctionReferenceImpl implements Function1<DrivePreviewOpenItem, MimeTypeCategory> {
    public DrivePreviewService$prepareOpenRequest$result$2(Object r8) {
        super(1, r8, j.class, "resolveFromOpenItem", "resolveFromOpenItem(Lcom/bytedance/ee/drive/preview/DrivePreviewOpenItem;)Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeCategory;", 0);
    }

    public final MimeTypeCategory invoke(DrivePreviewOpenItem r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        ((j) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        String r0 = r5.getFileExt();
        String r1 = null;
        if (r0 != null) goto L5;
    L9:
        String r6 = r5.getTitle();
        if (r6 == null) goto L12;
        r1 = StringsKt.substringAfterLast(r6, '.', "");
    L12:
        if (r1 != null) goto L14;
        r0 = "";
    L16:
        return j.e(j.c(r0), "");
    L14:
        r0 = r1;
        goto L16
    L5:
        if (StringsKt.isBlank(r0) == false) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L16;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((DrivePreviewOpenItem) r1);
    }
}
