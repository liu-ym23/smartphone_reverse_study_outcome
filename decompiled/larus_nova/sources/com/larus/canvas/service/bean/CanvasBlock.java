package com.larus.canvas.service.bean;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003JH\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasBlock;", "Ljava/io/Serializable;", "blockType", "", WikiFolderPushPlugin.BLOCK_ID, "", "content", "Lcom/larus/canvas/service/bean/CanvasImageBlock;", "isFinish", "", "logId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/canvas/service/bean/CanvasImageBlock;ZLjava/lang/String;)V", "Ljava/lang/Integer;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/canvas/service/bean/CanvasImageBlock;ZLjava/lang/String;)Lcom/larus/canvas/service/bean/CanvasBlock;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasBlock implements Serializable {

    @SerializedName(BitableResourceData.KEY_BLOCK_ID)
    public final String blockId;

    @SerializedName("block_type")
    public final Integer blockType;

    @SerializedName("content")
    public final CanvasImageBlock content;

    @SerializedName(EventConstant.Key.IS_FINISH)
    public final boolean isFinish;
    public final transient String logId;

    public CanvasBlock() {
        this(null, null, null, false, null, 31, null);
    }

    public static /* synthetic */ CanvasBlock copy$default(CanvasBlock r100, Integer r101, String r102, CanvasImageBlock r103, boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.blockType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.blockId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        CanvasImageBlock r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isFinish;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.logId;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.blockType;
    }

    public final String component2() {
        return this.blockId;
    }

    public final CanvasImageBlock component3() {
        return this.content;
    }

    public final boolean component4() {
        return this.isFinish;
    }

    public final String component5() {
        return this.logId;
    }

    public final CanvasBlock copy(Integer r100, String r101, CanvasImageBlock r110, boolean r111, String r112) {
        return new CanvasBlock(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CanvasBlock) == true) goto L8;
        return false;
    L8:
        CanvasBlock r101 = (CanvasBlock) r100;
        if (Intrinsics.areEqual(this.blockType, r101.blockType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockId, r101.blockId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (this.isFinish == r101.isFinish) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.blockType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.blockId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CanvasImageBlock r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.isFinish == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        String r112 = this.logId;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = 1237;
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
        return "CanvasBlock(blockType=" + this.blockType + ", blockId=" + this.blockId + ", content=" + this.content + ", isFinish=" + this.isFinish + ", logId=" + this.logId + ')';
    }

    public CanvasBlock(Integer r100, String r101, CanvasImageBlock r102, boolean r103, String r104) {
        this.blockType = r100;
        this.blockId = r101;
        this.content = r102;
        this.isFinish = r103;
        this.logId = r104;
    }

    public /* synthetic */ CanvasBlock(Integer r100, String r101, CanvasImageBlock r102, boolean r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Integer r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        CanvasImageBlock r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
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
