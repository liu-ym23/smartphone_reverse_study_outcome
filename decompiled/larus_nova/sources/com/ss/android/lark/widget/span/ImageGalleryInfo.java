package com.ss.android.lark.widget.span;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/widget/span/ImageGalleryInfo;", "Lcom/ss/android/lark/widget/span/SpanInfo;", "imageInfo", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/widget/span/ImageInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getImageInfo", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageGalleryInfo extends SpanInfo {
    private final ArrayList<ImageInfo> imageInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageGalleryInfo copy$default(ImageGalleryInfo r100, ArrayList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.imageInfo;
    L6:
        return r100.copy(r101);
    }

    public final ArrayList<ImageInfo> component1() {
        return this.imageInfo;
    }

    public final ImageGalleryInfo copy(ArrayList<ImageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "imageInfo");
        return new ImageGalleryInfo(r100);
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageGalleryInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.imageInfo, ((ImageGalleryInfo) r100).imageInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        return this.imageInfo.hashCode();
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public String toString() {
        return "ImageGalleryInfo(imageInfo=" + this.imageInfo + ')';
    }

    public final ArrayList<ImageInfo> getImageInfo() {
        return this.imageInfo;
    }

    public ImageGalleryInfo(ArrayList<ImageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "imageInfo");
        this.imageInfo = r100;
    }
}
