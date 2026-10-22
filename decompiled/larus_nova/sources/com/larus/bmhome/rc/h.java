package com.larus.bmhome.rc;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f313564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResourceAttachmentExtra f313565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UplinkFileEntity f313566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f313567d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f313564a, r101.f313564a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313565b, r101.f313565b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313566c, r101.f313566c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313567d, r101.f313567d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f313564a.hashCode() * 31) + this.f313565b.hashCode()) * 31;
        UplinkFileEntity r101 = this.f313566c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f313567d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResourceUploadContext(originParam=" + this.f313564a + ", preHandleExtraParam=" + this.f313565b + ", uplinkEntityContent=" + this.f313566c + ", sceneId=" + this.f313567d + ')';
    }

    public h(j r100, ResourceAttachmentExtra r101, UplinkFileEntity r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "originParam");
        Intrinsics.checkNotNullParameter(r101, "preHandleExtraParam");
        Intrinsics.checkNotNullParameter(r103, "sceneId");
        this.f313564a = r100;
        this.f313565b = r101;
        this.f313566c = r102;
        this.f313567d = r103;
    }
}
