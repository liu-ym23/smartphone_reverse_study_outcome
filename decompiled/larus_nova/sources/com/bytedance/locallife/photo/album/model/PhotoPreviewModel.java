package com.bytedance.locallife.photo.album.model;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001aJ`\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/PhotoPreviewModel;", "", "traceSessionId", "", "logParams", "Lcom/google/gson/JsonObject;", "defaultIndex", "", "scene", "data", "Lcom/bytedance/locallife/photo/album/model/PhotoPreviewData;", "uniqueId", "useDefaultBounce", "", "(Ljava/lang/String;Lcom/google/gson/JsonObject;ILjava/lang/String;Lcom/bytedance/locallife/photo/album/model/PhotoPreviewData;Ljava/lang/String;Ljava/lang/Boolean;)V", "getData", "()Lcom/bytedance/locallife/photo/album/model/PhotoPreviewData;", "getDefaultIndex", "()I", "getLogParams", "()Lcom/google/gson/JsonObject;", "getScene", "()Ljava/lang/String;", "getTraceSessionId", "getUniqueId", "getUseDefaultBounce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/google/gson/JsonObject;ILjava/lang/String;Lcom/bytedance/locallife/photo/album/model/PhotoPreviewData;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/locallife/photo/album/model/PhotoPreviewModel;", "equals", "other", "hashCode", "toString", "locallife-photo-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PhotoPreviewModel {
    private final PhotoPreviewData data;
    private final int defaultIndex;
    private final JsonObject logParams;
    private final String scene;
    private final String traceSessionId;
    private final String uniqueId;
    private final Boolean useDefaultBounce;

    public PhotoPreviewModel() {
        this(null, null, 0, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PhotoPreviewModel copy$default(PhotoPreviewModel r100, String r101, JsonObject r102, int r103, String r104, PhotoPreviewData r110, String r111, Boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.traceSessionId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.logParams;
    L8:
        JsonObject r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.defaultIndex;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.scene;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.data;
    L17:
        PhotoPreviewData r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.uniqueId;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.useDefaultBounce;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.traceSessionId;
    }

    public final JsonObject component2() {
        return this.logParams;
    }

    public final int component3() {
        return this.defaultIndex;
    }

    public final String component4() {
        return this.scene;
    }

    public final PhotoPreviewData component5() {
        return this.data;
    }

    public final String component6() {
        return this.uniqueId;
    }

    public final Boolean component7() {
        return this.useDefaultBounce;
    }

    public final PhotoPreviewModel copy(String r110, JsonObject r111, int r112, String r113, PhotoPreviewData r114, String r115, Boolean r116) {
        return new PhotoPreviewModel(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoPreviewModel) == true) goto L8;
        return false;
    L8:
        PhotoPreviewModel r101 = (PhotoPreviewModel) r100;
        if (Intrinsics.areEqual(this.traceSessionId, r101.traceSessionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logParams, r101.logParams) == true) goto L15;
        return false;
    L15:
        if (this.defaultIndex == r101.defaultIndex) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.uniqueId, r101.uniqueId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.useDefaultBounce, r101.useDefaultBounce) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.traceSessionId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.logParams;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.defaultIndex) * 31;
        String r107 = this.scene;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        PhotoPreviewData r110 = this.data;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.uniqueId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.useDefaultBounce;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "PhotoPreviewModel(traceSessionId=" + this.traceSessionId + ", logParams=" + this.logParams + ", defaultIndex=" + this.defaultIndex + ", scene=" + this.scene + ", data=" + this.data + ", uniqueId=" + this.uniqueId + ", useDefaultBounce=" + this.useDefaultBounce + ')';
    }

    public final PhotoPreviewData getData() {
        return this.data;
    }

    public final int getDefaultIndex() {
        return this.defaultIndex;
    }

    public final JsonObject getLogParams() {
        return this.logParams;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTraceSessionId() {
        return this.traceSessionId;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final Boolean getUseDefaultBounce() {
        return this.useDefaultBounce;
    }

    public PhotoPreviewModel(String r100, JsonObject r101, int r102, String r103, PhotoPreviewData r104, String r105, Boolean r106) {
        this.traceSessionId = r100;
        this.logParams = r101;
        this.defaultIndex = r102;
        this.scene = r103;
        this.data = r104;
        this.uniqueId = r105;
        this.useDefaultBounce = r106;
    }

    public /* synthetic */ PhotoPreviewModel(String r100, JsonObject r101, int r102, String r110, PhotoPreviewData r111, String r112, Boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        JsonObject r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        PhotoPreviewData r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Boolean r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
