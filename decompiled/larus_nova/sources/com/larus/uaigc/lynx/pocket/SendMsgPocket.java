package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;", "", "allowPhotos", "", "selectedPhotosCount", "", "selectedModel", "", "presetImageUrl", "presetImageUri", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllowPhotos", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelectedPhotosCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSelectedModel", "()Ljava/lang/String;", "getPresetImageUrl", "getPresetImageUri", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMsgPocket {

    @SerializedName("allow_photos")
    private final Boolean allowPhotos;

    @SerializedName("preset_image_uri")
    private final String presetImageUri;

    @SerializedName("preset_image_url")
    private final String presetImageUrl;

    @SerializedName("selected_model")
    private final String selectedModel;

    @SerializedName("selected_photos_count")
    private final Integer selectedPhotosCount;

    public SendMsgPocket() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SendMsgPocket copy$default(SendMsgPocket r100, Boolean r101, Integer r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.allowPhotos;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.selectedPhotosCount;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.selectedModel;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.presetImageUrl;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.presetImageUri;
    L17:
        Boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final String component4() {
        return this.presetImageUrl;
    }

    public final String component5() {
        return this.presetImageUri;
    }

    public final SendMsgPocket copy(Boolean r100, Integer r101, String r110, String r111, String r112) {
        return new SendMsgPocket(r100, r101, r110, r111, r112);
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
        if (Intrinsics.areEqual(this.selectedModel, r101.selectedModel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.presetImageUrl, r101.presetImageUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.presetImageUri, r101.presetImageUri) == true) goto L23;
        return false;
    L23:
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
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.presetImageUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.presetImageUri;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SendMsgPocket(allowPhotos=" + this.allowPhotos + ", selectedPhotosCount=" + this.selectedPhotosCount + ", selectedModel=" + this.selectedModel + ", presetImageUrl=" + this.presetImageUrl + ", presetImageUri=" + this.presetImageUri + ')';
    }

    public final Boolean getAllowPhotos() {
        return this.allowPhotos;
    }

    public final String getPresetImageUri() {
        return this.presetImageUri;
    }

    public final String getPresetImageUrl() {
        return this.presetImageUrl;
    }

    public final String getSelectedModel() {
        return this.selectedModel;
    }

    public final Integer getSelectedPhotosCount() {
        return this.selectedPhotosCount;
    }

    public SendMsgPocket(Boolean r100, Integer r101, String r102, String r103, String r104) {
        this.allowPhotos = r100;
        this.selectedPhotosCount = r101;
        this.selectedModel = r102;
        this.presetImageUrl = r103;
        this.presetImageUri = r104;
    }

    public /* synthetic */ SendMsgPocket(Boolean r100, Integer r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        Integer r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = "";
    L11:
        String r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        String r107 = null;
    L16:
        if ((r105 & 16) == 0) goto L18;
        String r108 = null;
    L19:
        this(r100, r111, r106, r107, r108);
        return;
    L18:
        r108 = r104;
        goto L19
    L14:
        r107 = r103;
        goto L16
    }
}
