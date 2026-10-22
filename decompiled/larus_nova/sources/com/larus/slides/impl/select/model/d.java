package com.larus.slides.impl.select.model;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/slides/impl/select/model/AIPPTSlidesImageInfo;", "", PlayerResolution.SDKKEY.ORIGIN, "Lcom/larus/slides/impl/actionbar/model/ImageInfo;", DocCallbackImpl.KEY_THUMBNAIL, "<init>", "(Lcom/larus/slides/impl/actionbar/model/ImageInfo;Lcom/larus/slides/impl/actionbar/model/ImageInfo;)V", "getOrigin", "()Lcom/larus/slides/impl/actionbar/model/ImageInfo;", "getThumbnail", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("ori")
    private final com.larus.slides.impl.actionbar.model.a origin;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    private final com.larus.slides.impl.actionbar.model.a thumbnail;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.origin, r101.origin) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.thumbnail, r101.thumbnail) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        com.larus.slides.impl.actionbar.model.a r100 = this.origin;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        com.larus.slides.impl.actionbar.model.a r104 = this.thumbnail;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIPPTSlidesImageInfo(origin=" + this.origin + ", thumbnail=" + this.thumbnail + ')';
    }

    public d() {
        this.origin = null;
        this.thumbnail = null;
    }

    public final com.larus.slides.impl.actionbar.model.a a() {
        return this.origin;
    }

    public final com.larus.slides.impl.actionbar.model.a b() {
        return this.thumbnail;
    }
}
