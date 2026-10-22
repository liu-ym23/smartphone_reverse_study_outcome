package com.larus.chat.gallery.api;

import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSendableState;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.AttachmentUploadState;
import com.larus.platform.model.preview.ResourceRef;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p {
    public static final AttachmentSnapshot a(o r210, AttachmentSource r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, "source");
        ResourceRef r100 = dr9.a.c(r210.f324171b, r210.f324174e, r210.f324175f, 2);
        String r101 = r210.f324173d;
        if (r101 == null) goto L5;
        ResourceRef r102 = dr9.a.c(r101, 0, 0, 14);
    L6:
        ResourceRef r103 = r102;
        String r104 = r210.f324170a;
        if (r210.getType() != PreviewMediaType.VIDEO) goto L9;
        AttachmentMediaType r105 = AttachmentMediaType.VIDEO;
    L10:
        AttachmentMediaType r106 = r105;
        long r110 = r210.f324176g;
        AttachmentUploadState r111 = AttachmentUploadState.NOT_UPLOADED;
        if (r100 == null) goto L13;
        AttachmentSendableState r107 = AttachmentSendableState.NEEDS_MATERIALIZE;
    L15:
        return new AttachmentSnapshot(r104, r211, r106, r100, r103, r100, null, null, null, null, null, r110, r111, null, r212, r107, null, 75712, null);
    L13:
        r107 = AttachmentSendableState.NOT_SENDABLE;
        goto L15
    L9:
        r105 = AttachmentMediaType.IMAGE;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
