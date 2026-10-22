package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006*"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;", "", "inputBoxTitle", "", "inputPlaceholder", "inputPlaceholderPrompt", "mustPhotos", "", "selectedPhotosCount", "", "preSetPhotoUrl", "preSetPhotoUri", "selectedModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInputBoxTitle", "()Ljava/lang/String;", "getInputPlaceholder", "getInputPlaceholderPrompt", "getMustPhotos", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelectedPhotosCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreSetPhotoUrl", "getPreSetPhotoUri", "getSelectedModel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadInputPocket {

    @SerializedName("input_box_title")
    private final String inputBoxTitle;

    @SerializedName("input_placeholder")
    private final String inputPlaceholder;

    @SerializedName("input_placeholder_prompt")
    private final String inputPlaceholderPrompt;

    @SerializedName("must_photos")
    private final Boolean mustPhotos;

    @SerializedName("pre_set_photo_uri")
    private final String preSetPhotoUri;

    @SerializedName("pre_set_photo_url")
    private final String preSetPhotoUrl;

    @SerializedName("selected_model")
    private final String selectedModel;

    @SerializedName("selected_photos_count")
    private final Integer selectedPhotosCount;

    public UploadInputPocket() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ UploadInputPocket copy$default(UploadInputPocket r100, String r110, String r111, String r112, Boolean r113, Integer r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.inputBoxTitle;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.inputPlaceholder;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.inputPlaceholderPrompt;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = r100.mustPhotos;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = r100.selectedPhotosCount;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.preSetPhotoUrl;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.preSetPhotoUri;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.selectedModel;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.inputBoxTitle;
    }

    public final String component2() {
        return this.inputPlaceholder;
    }

    public final String component3() {
        return this.inputPlaceholderPrompt;
    }

    public final Boolean component4() {
        return this.mustPhotos;
    }

    public final Integer component5() {
        return this.selectedPhotosCount;
    }

    public final String component6() {
        return this.preSetPhotoUrl;
    }

    public final String component7() {
        return this.preSetPhotoUri;
    }

    public final String component8() {
        return this.selectedModel;
    }

    public final UploadInputPocket copy(String r110, String r111, String r112, Boolean r113, Integer r114, String r115, String r116, String r117) {
        return new UploadInputPocket(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UploadInputPocket) == true) goto L8;
        return false;
    L8:
        UploadInputPocket r101 = (UploadInputPocket) r100;
        if (Intrinsics.areEqual(this.inputBoxTitle, r101.inputBoxTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inputPlaceholder, r101.inputPlaceholder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputPlaceholderPrompt, r101.inputPlaceholderPrompt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mustPhotos, r101.mustPhotos) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectedPhotosCount, r101.selectedPhotosCount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.preSetPhotoUrl, r101.preSetPhotoUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.preSetPhotoUri, r101.preSetPhotoUri) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.selectedModel, r101.selectedModel) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.inputBoxTitle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.inputPlaceholder;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.inputPlaceholderPrompt;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.mustPhotos;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.selectedPhotosCount;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.preSetPhotoUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.preSetPhotoUri;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.selectedModel;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "UploadInputPocket(inputBoxTitle=" + this.inputBoxTitle + ", inputPlaceholder=" + this.inputPlaceholder + ", inputPlaceholderPrompt=" + this.inputPlaceholderPrompt + ", mustPhotos=" + this.mustPhotos + ", selectedPhotosCount=" + this.selectedPhotosCount + ", preSetPhotoUrl=" + this.preSetPhotoUrl + ", preSetPhotoUri=" + this.preSetPhotoUri + ", selectedModel=" + this.selectedModel + ')';
    }

    public final String getInputBoxTitle() {
        return this.inputBoxTitle;
    }

    public final String getInputPlaceholder() {
        return this.inputPlaceholder;
    }

    public final String getInputPlaceholderPrompt() {
        return this.inputPlaceholderPrompt;
    }

    public final Boolean getMustPhotos() {
        return this.mustPhotos;
    }

    public final String getPreSetPhotoUri() {
        return this.preSetPhotoUri;
    }

    public final String getPreSetPhotoUrl() {
        return this.preSetPhotoUrl;
    }

    public final String getSelectedModel() {
        return this.selectedModel;
    }

    public final Integer getSelectedPhotosCount() {
        return this.selectedPhotosCount;
    }

    public UploadInputPocket(String r100, String r101, String r102, Boolean r103, Integer r104, String r105, String r106, String r107) {
        this.inputBoxTitle = r100;
        this.inputPlaceholder = r101;
        this.inputPlaceholderPrompt = r102;
        this.mustPhotos = r103;
        this.selectedPhotosCount = r104;
        this.preSetPhotoUrl = r105;
        this.preSetPhotoUri = r106;
        this.selectedModel = r107;
    }

    public /* synthetic */ UploadInputPocket(String r110, String r111, String r112, Boolean r113, Integer r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = Boolean.FALSE;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
