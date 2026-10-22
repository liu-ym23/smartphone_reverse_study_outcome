package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u001d\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0096\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\n\u0010\u0018R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$MediaPickerShowOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "maxSelectedCount", "", "sourceType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mediaType", "maxDuration", "isSaveToAlbum", "", "sizeType", "cameraDeviceX", "<init>", "(ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/String;)V", "getMaxSelectedCount", "()I", "getSourceType", "()Ljava/util/ArrayList;", "getMediaType", "getMaxDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSizeType", "getCameraDeviceX", "()Ljava/lang/String;", "cameraDevice", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$CameraDevice;", "getCameraDevice", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$CameraDevice;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$MediaPickerShowOptions;", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$MediaPickerShowOptions implements NonProguard {
    private final String cameraDeviceX;
    private final Boolean isSaveToAlbum;
    private final Integer maxDuration;
    private final int maxSelectedCount;
    private final ArrayList<String> mediaType;
    private final ArrayList<String> sizeType;
    private final ArrayList<String> sourceType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IWidget$MediaPickerShowOptions copy$default(IWidget$MediaPickerShowOptions r100, int r101, ArrayList r102, ArrayList r103, Integer r104, Boolean r110, ArrayList r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.maxSelectedCount;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.sourceType;
    L8:
        ArrayList r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.mediaType;
    L11:
        ArrayList r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.maxDuration;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.isSaveToAlbum;
    L17:
        Boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.sizeType;
    L20:
        ArrayList r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.cameraDeviceX;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.maxSelectedCount;
    }

    public final ArrayList<String> component2() {
        return this.sourceType;
    }

    public final ArrayList<String> component3() {
        return this.mediaType;
    }

    public final Integer component4() {
        return this.maxDuration;
    }

    public final Boolean component5() {
        return this.isSaveToAlbum;
    }

    public final ArrayList<String> component6() {
        return this.sizeType;
    }

    public final String component7() {
        return this.cameraDeviceX;
    }

    public final IWidget$MediaPickerShowOptions copy(int r110, ArrayList<String> r111, ArrayList<String> r112, Integer r113, Boolean r114, ArrayList<String> r115, @JSONField(name = "cameraDevice") String r116) {
        return new IWidget$MediaPickerShowOptions(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWidget$MediaPickerShowOptions) == true) goto L8;
        return false;
    L8:
        IWidget$MediaPickerShowOptions r101 = (IWidget$MediaPickerShowOptions) r100;
        if (this.maxSelectedCount == r101.maxSelectedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceType, r101.sourceType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mediaType, r101.mediaType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxDuration, r101.maxDuration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isSaveToAlbum, r101.isSaveToAlbum) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sizeType, r101.sizeType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cameraDeviceX, r101.cameraDeviceX) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.maxSelectedCount * 31;
        ArrayList<String> r101 = this.sourceType;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ArrayList<String> r105 = this.mediaType;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.maxDuration;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.isSaveToAlbum;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        ArrayList<String> r114 = this.sizeType;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.cameraDeviceX;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MediaPickerShowOptions(maxSelectedCount=" + this.maxSelectedCount + ", sourceType=" + this.sourceType + ", mediaType=" + this.mediaType + ", maxDuration=" + this.maxDuration + ", isSaveToAlbum=" + this.isSaveToAlbum + ", sizeType=" + this.sizeType + ", cameraDeviceX=" + this.cameraDeviceX + ')';
    }

    public final IWidget$CameraDevice getCameraDevice() {
        String r100 = this.cameraDeviceX;
        if (r100 == null) goto L16;
        IWidget$CameraDevice.Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        IWidget$CameraDevice[] r101 = IWidget$CameraDevice.values();
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        IWidget$CameraDevice r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L11;
        r103 = r103 + 1;
    L11:
        if (r104 != null) goto L14;
        r104 = IWidget$CameraDevice.Back;
    L14:
        if (r104 == null) goto L16;
        return r104;
    L10:
        r104 = null;
    L16:
        return IWidget$CameraDevice.Back;
    }

    public final String getCameraDeviceX() {
        return this.cameraDeviceX;
    }

    public final Integer getMaxDuration() {
        return this.maxDuration;
    }

    public final int getMaxSelectedCount() {
        return this.maxSelectedCount;
    }

    public final ArrayList<String> getMediaType() {
        return this.mediaType;
    }

    public final ArrayList<String> getSizeType() {
        return this.sizeType;
    }

    public final ArrayList<String> getSourceType() {
        return this.sourceType;
    }

    public final Boolean isSaveToAlbum() {
        return this.isSaveToAlbum;
    }

    public IWidget$MediaPickerShowOptions(int r100, ArrayList<String> r101, ArrayList<String> r102, Integer r103, Boolean r104, ArrayList<String> r105, @JSONField(name = "cameraDevice") String r106) {
        this.maxSelectedCount = r100;
        this.sourceType = r101;
        this.mediaType = r102;
        this.maxDuration = r103;
        this.isSaveToAlbum = r104;
        this.sizeType = r105;
        this.cameraDeviceX = r106;
    }

    public /* synthetic */ IWidget$MediaPickerShowOptions(int r110, ArrayList r111, ArrayList r112, Integer r113, Boolean r114, ArrayList r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        int r100 = 9;
    L7:
        if ((r117 & 8) == 0) goto L9;
        Integer r101 = 60000;
    L11:
        if ((r117 & 16) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L15:
        if ((r117 & 64) == 0) goto L17;
        String r103 = null;
    L18:
        this(r100, r111, r112, r101, r102, r115, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
