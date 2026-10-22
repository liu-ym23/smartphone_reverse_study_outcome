package com.larus.community.impl.publish.viewmodel;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/community/impl/publish/viewmodel/CreationPublishShowImageState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "imageUrl", "", "refImageUrls", "", "Lcom/larus/ugc/community/adapter/RefData;", "showVideoIcon", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "getImageUrl", "()Ljava/lang/String;", "getRefImageUrls", "()Ljava/util/List;", "getShowVideoIcon", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishShowImageState implements w1a.b {
    private final String imageUrl;
    private final List<f0a.a> refImageUrls;
    private final boolean showVideoIcon;

    public CreationPublishShowImageState() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationPublishShowImageState copy$default(CreationPublishShowImageState r100, String r101, List r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.imageUrl;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.refImageUrls;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.showVideoIcon;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final List<f0a.a> component2() {
        return this.refImageUrls;
    }

    public final boolean component3() {
        return this.showVideoIcon;
    }

    public final CreationPublishShowImageState copy(String r100, List<f0a.a> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "refImageUrls");
        return new CreationPublishShowImageState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationPublishShowImageState) == true) goto L8;
        return false;
    L8:
        CreationPublishShowImageState r101 = (CreationPublishShowImageState) r100;
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.refImageUrls, r101.refImageUrls) == true) goto L15;
        return false;
    L15:
        if (this.showVideoIcon == r101.showVideoIcon) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.imageUrl;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.refImageUrls.hashCode()) * 31;
        if (this.showVideoIcon == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationPublishShowImageState(imageUrl=" + this.imageUrl + ", refImageUrls=" + this.refImageUrls + ", showVideoIcon=" + this.showVideoIcon + ')';
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<f0a.a> getRefImageUrls() {
        return this.refImageUrls;
    }

    public final boolean getShowVideoIcon() {
        return this.showVideoIcon;
    }

    public CreationPublishShowImageState(String r100, List<f0a.a> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "refImageUrls");
        this.imageUrl = r100;
        this.refImageUrls = r101;
        this.showVideoIcon = r102;
    }

    public /* synthetic */ CreationPublishShowImageState(String r100, List r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
