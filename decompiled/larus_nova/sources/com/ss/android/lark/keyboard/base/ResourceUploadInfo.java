package com.ss.android.lark.keyboard.base;

import com.bytedance.lark.pb.basic.v1.ResourceFile;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/keyboard/base/ResourceUploadInfo;", "Ljava/io/Serializable;", "sendFileType", "Lcom/bytedance/lark/pb/basic/v1/ResourceFile$FileType;", "imageCompressInfo", "Lcom/ss/android/lark/keyboard/base/ImageCompressInfo;", "<init>", "(Lcom/bytedance/lark/pb/basic/v1/ResourceFile$FileType;Lcom/ss/android/lark/keyboard/base/ImageCompressInfo;)V", "getSendFileType", "()Lcom/bytedance/lark/pb/basic/v1/ResourceFile$FileType;", "getImageCompressInfo", "()Lcom/ss/android/lark/keyboard/base/ImageCompressInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceUploadInfo implements Serializable {
    private final ImageCompressInfo imageCompressInfo;
    private final ResourceFile.FileType sendFileType;

    public static /* synthetic */ ResourceUploadInfo copy$default(ResourceUploadInfo r100, ResourceFile.FileType r101, ImageCompressInfo r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.sendFileType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.imageCompressInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final ResourceFile.FileType component1() {
        return this.sendFileType;
    }

    public final ImageCompressInfo component2() {
        return this.imageCompressInfo;
    }

    public final ResourceUploadInfo copy(ResourceFile.FileType r100, ImageCompressInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "sendFileType");
        return new ResourceUploadInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceUploadInfo) == true) goto L8;
        return false;
    L8:
        ResourceUploadInfo r101 = (ResourceUploadInfo) r100;
        if (this.sendFileType == r101.sendFileType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageCompressInfo, r101.imageCompressInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.sendFileType.hashCode() * 31;
        ImageCompressInfo r101 = this.imageCompressInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ResourceUploadInfo(sendFileType=" + this.sendFileType + ", imageCompressInfo=" + this.imageCompressInfo + ')';
    }

    public final ImageCompressInfo getImageCompressInfo() {
        return this.imageCompressInfo;
    }

    public final ResourceFile.FileType getSendFileType() {
        return this.sendFileType;
    }

    public ResourceUploadInfo(ResourceFile.FileType r100, ImageCompressInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "sendFileType");
        this.sendFileType = r100;
        this.imageCompressInfo = r101;
    }

    public /* synthetic */ ResourceUploadInfo(ResourceFile.FileType r100, ImageCompressInfo r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
