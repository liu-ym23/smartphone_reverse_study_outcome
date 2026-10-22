package com.ss.android.ugc.aweme.shortvideo.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.creative.CreativeSuppressCheck;
import com.ss.android.ugc.aweme.creative.PersistentPath;
import com.ss.texturerender.VideoSurfaceTexture;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010BE\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJN\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00061"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/model/FrameItem;", "Ljava/io/Serializable;", "path", "", "type", "", "index", "isCropped", "", "cropInfo", "Lcom/ss/android/ugc/aweme/shortvideo/model/FrameItemCropInfo;", "rotate", "", "(Ljava/lang/String;IIZLcom/ss/android/ugc/aweme/shortvideo/model/FrameItemCropInfo;Ljava/lang/Float;)V", "getCropInfo", "()Lcom/ss/android/ugc/aweme/shortvideo/model/FrameItemCropInfo;", "setCropInfo", "(Lcom/ss/android/ugc/aweme/shortvideo/model/FrameItemCropInfo;)V", "getIndex", "()I", "()Z", "setCropped", "(Z)V", "getPath", "()Ljava/lang/String;", "getRotate", "()Ljava/lang/Float;", "Ljava/lang/Float;", VideoSurfaceTexture.KEY_TIME, "", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;IIZLcom/ss/android/ugc/aweme/shortvideo/model/FrameItemCropInfo;Ljava/lang/Float;)Lcom/ss/android/ugc/aweme/shortvideo/model/FrameItem;", "equals", "other", "", "hashCode", "toString", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class FrameItem implements Serializable {
    public static final Companion Companion = null;
    public static final int FRAME_INDEX_DEFAULT = -1;
    public static final int FRAME_TYPE_CUSTOM_STICKER = 2;
    public static final int FRAME_TYPE_DEFAULT = 1;

    @CreativeSuppressCheck
    private FrameItemCropInfo cropInfo;

    @CreativeSuppressCheck
    private final int index;

    @CreativeSuppressCheck
    private boolean isCropped;

    @SerializedName("path")
    @PersistentPath
    private final String path;

    @CreativeSuppressCheck
    private final Float rotate;

    @SerializedName(VideoSurfaceTexture.KEY_TIME)
    private long timeStamp;

    @CreativeSuppressCheck
    private final int type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/model/FrameItem$Companion;", "", "()V", "FRAME_INDEX_DEFAULT", "", "FRAME_TYPE_CUSTOM_STICKER", "FRAME_TYPE_DEFAULT", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public FrameItem(String r110) {
        this(r110, 0, 0, false, null, null, 62, null);
    }

    public FrameItem(String r110, int r111) {
        this(r110, r111, 0, false, null, null, 60, null);
    }

    public FrameItem(String r110, int r111, int r112) {
        this(r110, r111, r112, false, null, null, 56, null);
    }

    public FrameItem(String r110, int r111, int r112, boolean r113) {
        this(r110, r111, r112, r113, null, null, 48, null);
    }

    public FrameItem(String r110, int r111, int r112, boolean r113, FrameItemCropInfo r114) {
        this(r110, r111, r112, r113, r114, null, 32, null);
    }

    public static /* synthetic */ FrameItem copy$default(FrameItem r100, String r101, int r102, int r103, boolean r104, FrameItemCropInfo r105, Float r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.path;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.index;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isCropped;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.cropInfo;
    L17:
        FrameItemCropInfo r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.rotate;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.path;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.index;
    }

    public final boolean component4() {
        return this.isCropped;
    }

    public final FrameItemCropInfo component5() {
        return this.cropInfo;
    }

    public final Float component6() {
        return this.rotate;
    }

    public final FrameItem copy(String r100, int r110, int r111, boolean r112, FrameItemCropInfo r113, Float r114) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return new FrameItem(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FrameItem) == false) goto L18;
        FrameItem r101 = (FrameItem) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L10;
        return false;
    L10:
        if (this.index == r101.index) goto L12;
        return false;
    L12:
        if (this.isCropped == r101.isCropped) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cropInfo, r101.cropInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.rotate, r101.rotate) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        String r100 = this.path;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.type) * 31) + this.index) * 31;
        boolean r104 = this.isCropped;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        FrameItemCropInfo r107 = this.cropInfo;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.rotate;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FrameItem(path=" + this.path + ", type=" + this.type + ", index=" + this.index + ", isCropped=" + this.isCropped + ", cropInfo=" + this.cropInfo + ", rotate=" + this.rotate + ")";
    }

    public final FrameItemCropInfo getCropInfo() {
        return this.cropInfo;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getPath() {
        return this.path;
    }

    public final Float getRotate() {
        return this.rotate;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    public final void setCropInfo(FrameItemCropInfo r100) {
        this.cropInfo = r100;
    }

    public final void setCropped(boolean r100) {
        this.isCropped = r100;
    }

    public final void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }

    public FrameItem(String r100, int r101, int r102, boolean r103, FrameItemCropInfo r104, Float r105) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.path = r100;
        this.type = r101;
        this.index = r102;
        this.isCropped = r103;
        this.cropInfo = r104;
        this.rotate = r105;
        this.timeStamp = -1;
    }

    public /* synthetic */ FrameItem(String r100, int r101, int r110, boolean r111, FrameItemCropInfo r112, Float r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        int r102 = 1;
    L7:
        if ((r114 & 4) == 0) goto L9;
        int r103 = -1;
    L11:
        if ((r114 & 8) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r114 & 16) == 0) goto L17;
        FrameItemCropInfo r105 = null;
    L19:
        if ((r114 & 32) == 0) goto L21;
        Float r106 = null;
    L22:
        this(r100, r102, r103, r104, r105, r106);
        return;
    L21:
        r106 = r113;
        goto L22
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
