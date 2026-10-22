package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.ImageData;
import com.larus.platform.api.creation.UserCreationFromIM;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasImageBlock;", "Ljava/io/Serializable;", "canvasInfo", "Lcom/larus/canvas/service/bean/CanvasInfo;", "image", "Lcom/larus/im/bean/message/ImageData;", "creation", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "generateData", "Lcom/larus/canvas/service/bean/CanvasGenerateData;", "msgInfo", "Lcom/larus/canvas/service/bean/CanvasMsgInfo;", "<init>", "(Lcom/larus/canvas/service/bean/CanvasInfo;Lcom/larus/im/bean/message/ImageData;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/canvas/service/bean/CanvasGenerateData;Lcom/larus/canvas/service/bean/CanvasMsgInfo;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasImageBlock implements Serializable {

    @SerializedName("canvas")
    public final CanvasInfo canvasInfo;

    @SerializedName("creation")
    public final UserCreationFromIM creation;

    @SerializedName("generate_data")
    public final CanvasGenerateData generateData;

    @SerializedName("image")
    public final ImageData image;

    @SerializedName("msg_info")
    public final CanvasMsgInfo msgInfo;

    public CanvasImageBlock() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CanvasImageBlock copy$default(CanvasImageBlock r100, CanvasInfo r101, ImageData r102, UserCreationFromIM r103, CanvasGenerateData r104, CanvasMsgInfo r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.canvasInfo;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.image;
    L8:
        ImageData r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.creation;
    L11:
        UserCreationFromIM r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.generateData;
    L14:
        CanvasGenerateData r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.msgInfo;
    L17:
        CanvasInfo r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final CanvasInfo component1() {
        return this.canvasInfo;
    }

    public final ImageData component2() {
        return this.image;
    }

    public final UserCreationFromIM component3() {
        return this.creation;
    }

    public final CanvasGenerateData component4() {
        return this.generateData;
    }

    public final CanvasMsgInfo component5() {
        return this.msgInfo;
    }

    public final CanvasImageBlock copy(CanvasInfo r100, ImageData r101, UserCreationFromIM r110, CanvasGenerateData r111, CanvasMsgInfo r112) {
        return new CanvasImageBlock(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CanvasImageBlock) == true) goto L8;
        return false;
    L8:
        CanvasImageBlock r101 = (CanvasImageBlock) r100;
        if (Intrinsics.areEqual(this.canvasInfo, r101.canvasInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creation, r101.creation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.generateData, r101.generateData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.msgInfo, r101.msgInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        CanvasInfo r100 = this.canvasInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ImageData r104 = this.image;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        UserCreationFromIM r107 = this.creation;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        CanvasGenerateData r110 = this.generateData;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        CanvasMsgInfo r113 = this.msgInfo;
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
        return "CanvasImageBlock(canvasInfo=" + this.canvasInfo + ", image=" + this.image + ", creation=" + this.creation + ", generateData=" + this.generateData + ", msgInfo=" + this.msgInfo + ')';
    }

    public CanvasImageBlock(CanvasInfo r100, ImageData r101, UserCreationFromIM r102, CanvasGenerateData r103, CanvasMsgInfo r104) {
        this.canvasInfo = r100;
        this.image = r101;
        this.creation = r102;
        this.generateData = r103;
        this.msgInfo = r104;
    }

    public /* synthetic */ CanvasImageBlock(CanvasInfo r100, ImageData r101, UserCreationFromIM r102, CanvasGenerateData r103, CanvasMsgInfo r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        CanvasInfo r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        ImageData r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        UserCreationFromIM r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        CanvasGenerateData r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        CanvasMsgInfo r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
