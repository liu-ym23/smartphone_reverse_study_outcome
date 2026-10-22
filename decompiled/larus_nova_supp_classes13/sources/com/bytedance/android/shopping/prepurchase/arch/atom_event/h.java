package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/atom_event/h;", "", "", "mediaType", "Ljava/lang/String;", "getMediaType", "()Ljava/lang/String;", "", "Lfj/d;", "videos", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "imageUrlArray", "b", "", "imageIndex", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "enterFrom", "getEnterFrom", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {
    public static final /* synthetic */ int a = 0;

    @SerializedName(SimilarProductParam.ENTER_FROM)
    private final Integer enterFrom;

    @SerializedName("image_index")
    private final Integer imageIndex;

    @SerializedName("image_url_array")
    private final List<String> imageUrlArray;

    @SerializedName("media_type")
    private final String mediaType;

    @SerializedName("video")
    private final List<fj.d> videos;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L16;
        h r4 = (h) r3;
        if (Intrinsics.areEqual(this.mediaType, r4.mediaType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.videos, r4.videos) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imageUrlArray, r4.imageUrlArray) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageIndex, r4.imageIndex) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.enterFrom, r4.enterFrom) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.mediaType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<fj.d> r4 = this.videos;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.imageUrlArray;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.imageIndex;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.enterFrom;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPMediaPreviewActionAtomEventParam(mediaType=" + this.mediaType + ", videos=" + this.videos + ", imageUrlArray=" + this.imageUrlArray + ", imageIndex=" + this.imageIndex + ", enterFrom=" + this.enterFrom + ")";
    }

    public h() {
        this("", new ArrayList(), CollectionsKt.emptyList(), 0, 0);
    }

    public final Integer a() {
        return this.imageIndex;
    }

    public final List<String> b() {
        return this.imageUrlArray;
    }

    public final List<fj.d> c() {
        return this.videos;
    }

    public h(String r1, List<fj.d> r2, List<String> r3, Integer r4, Integer r5) {
        this.mediaType = r1;
        this.videos = r2;
        this.imageUrlArray = r3;
        this.imageIndex = r4;
        this.enterFrom = r5;
    }
}
