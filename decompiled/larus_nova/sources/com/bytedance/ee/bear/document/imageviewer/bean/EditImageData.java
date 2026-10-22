package com.bytedance.ee.bear.document.imageviewer.bean;

import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/imageviewer/bean/EditImageData;", "Lcom/bytedance/ee/util/io/NonProguard;", "src", "", "image", "Lcom/bytedance/ee/bear/contract/imageviewer/bean/ImageData$Image;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/contract/imageviewer/bean/ImageData$Image;)V", "getSrc", "()Ljava/lang/String;", "getImage", "()Lcom/bytedance/ee/bear/contract/imageviewer/bean/ImageData$Image;", "equals", "", "other", "", "hashCode", "", "toString", "component1", "component2", "copy", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditImageData implements NonProguard {
    private final ImageData.Image image;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    private final String f220098src;

    public static /* synthetic */ EditImageData copy$default(EditImageData r100, String r101, ImageData.Image r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f220098src;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.image;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.f220098src;
    }

    public final ImageData.Image component2() {
        return this.image;
    }

    public final EditImageData copy(String r100, ImageData.Image r101) {
        return new EditImageData(r100, r101);
    }

    public int hashCode() {
        String r100 = this.f220098src;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "EditImageData{src=" + this.f220098src + ", image=" + this.image + '}';
    }

    public final ImageData.Image getImage() {
        return this.image;
    }

    public final String getSrc() {
        return this.f220098src;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof EditImageData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(((EditImageData) r100).f220098src, this.f220098src) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public EditImageData(String r100, ImageData.Image r101) {
        this.f220098src = r100;
        this.image = r101;
    }
}
