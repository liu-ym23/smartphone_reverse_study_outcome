package com.larus.common.venue.impl.venue.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;", "", "allowPhotos", "", "selectedPhotosCount", "", "selectedModel", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getAllowPhotos", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelectedPhotosCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSelectedModel", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/common/venue/impl/venue/api/SendMsgPocket;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMsgPocket {

    @SerializedName("allow_photos")
    private final Boolean allowPhotos;

    @SerializedName("selected_model")
    private final String selectedModel;

    @SerializedName("selected_photos_count")
    private final Integer selectedPhotosCount;

    public SendMsgPocket() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SendMsgPocket copy$default(SendMsgPocket r100, Boolean r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.allowPhotos;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.selectedPhotosCount;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.selectedModel;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Boolean component1() {
        return this.allowPhotos;
    }

    public final Integer component2() {
        return this.selectedPhotosCount;
    }

    public final String component3() {
        return this.selectedModel;
    }

    public final SendMsgPocket copy(Boolean r100, Integer r101, String r102) {
        return new SendMsgPocket(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendMsgPocket) == true) goto L8;
        return false;
    L8:
        SendMsgPocket r101 = (SendMsgPocket) r100;
        if (Intrinsics.areEqual(this.allowPhotos, r101.allowPhotos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedPhotosCount, r101.selectedPhotosCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectedModel, r101.selectedModel) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.allowPhotos;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.selectedPhotosCount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.selectedModel;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SendMsgPocket(allowPhotos=" + this.allowPhotos + ", selectedPhotosCount=" + this.selectedPhotosCount + ", selectedModel=" + this.selectedModel + ')';
    }

    public final Boolean getAllowPhotos() {
        return this.allowPhotos;
    }

    public final String getSelectedModel() {
        return this.selectedModel;
    }

    public final Integer getSelectedPhotosCount() {
        return this.selectedPhotosCount;
    }

    public SendMsgPocket(Boolean r100, Integer r101, String r102) {
        this.allowPhotos = r100;
        this.selectedPhotosCount = r101;
        this.selectedModel = r102;
    }

    public /* synthetic */ SendMsgPocket(Boolean r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
