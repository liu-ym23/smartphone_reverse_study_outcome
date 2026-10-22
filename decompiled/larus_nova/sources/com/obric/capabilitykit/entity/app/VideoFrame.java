package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BY\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jc\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\b\u0010-\u001a\u00020.H\u0016J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020.HÖ\u0001J\u0018\u00104\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00106\u001a\u00020.H\u0002J\t\u00107\u001a\u00020\u000bHÖ\u0001J\u0018\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020.H\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001c¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/entity/app/VideoFrame;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", DyPayConstant.KEY_START_TIME, "", "endTime", "frameTime", PromotionProductPrivilegesStruct.TAGS, "", "", "faces", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "caption", "ocr", "(JJJLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "getEndTime", "()J", "setEndTime", "(J)V", "getFaces", "()Ljava/util/List;", "setFaces", "(Ljava/util/List;)V", "getFrameTime", "setFrameTime", "getOcr", "setOcr", "getStartTime", "setStartTime", "getTags", "setTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "readExtensionField", "", "theirVersion", "toString", "writeToParcel", "dest", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VideoFrame implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String caption;
    private long endTime;
    private List<PhotoFaceEntity> faces;
    private long frameTime;
    private String ocr;
    private long startTime;
    private List<String> tags;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/app/VideoFrame$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/VideoFrame;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<VideoFrame> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoFrame createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new VideoFrame(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VideoFrame createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoFrame[] newArray(int r100) {
            return new VideoFrame[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VideoFrame[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public VideoFrame(long r100, long r101, long r102, List<String> r103, List<PhotoFaceEntity> r104, String r105, String r110) {
        this.startTime = r100;
        this.endTime = r101;
        this.frameTime = r102;
        this.tags = r103;
        this.faces = r104;
        this.caption = r105;
        this.ocr = r110;
    }

    public /* synthetic */ VideoFrame(long r110, long r111, long r112, List r210, List r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 8) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r214 & 16) == 0) goto L9;
        List r113 = null;
    L11:
        if ((r214 & 32) == 0) goto L13;
        String r114 = null;
    L15:
        if ((r214 & 64) == 0) goto L17;
        String r115 = null;
    L18:
        this(r110, r111, r112, r100, r113, r114, r115);
        return;
    L17:
        r115 = r213;
        goto L18
    L13:
        r114 = r212;
        goto L15
    L9:
        r113 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public VideoFrame(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(r110.readLong(), r110.readLong(), r110.readLong(), r110.createStringArrayList(), r110.createTypedArrayList(PhotoFaceEntity.CREATOR), r110.readString(), r110.readString());
        readExtensionField(r110, r110.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoFrame copy$default(VideoFrame r110, long r111, long r112, long r113, List r114, List r115, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        long r100 = r110.startTime;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r101 = r110.endTime;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.frameTime;
    L15:
        if ((r212 & 8) == 0) goto L17;
        List r103 = r110.tags;
    L19:
        if ((r212 & 16) == 0) goto L21;
        List r104 = r110.faces;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.caption;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r116 = r110.ocr;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116);
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    private final void readExtensionField(Parcel r100, int r101) {
        if (r101 <= 0) goto L4;
        int r102 = 0;
    L5:
        ClassLoader r103 = AppEntity.class.getClassLoader();
        int r104 = 1;
    L6:
        if (r104 > r102) goto L8;
        r104 = r104 + 1;
    L8:
        if (r104 > r101) goto L10;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r103);
        r104 = r104 + 1;
        goto L8
    L10:
        return;
    L4:
        r102 = r101;
        goto L5
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTime;
    }

    public final long component3() {
        return this.frameTime;
    }

    public final List<String> component4() {
        return this.tags;
    }

    public final List<PhotoFaceEntity> component5() {
        return this.faces;
    }

    public final String component6() {
        return this.caption;
    }

    public final String component7() {
        return this.ocr;
    }

    public final VideoFrame copy(long r110, long r111, long r112, List<String> r113, List<PhotoFaceEntity> r210, String r211, String r212) {
        return new VideoFrame(r110, r111, r112, r113, r210, r211, r212);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoFrame) == true) goto L8;
        return false;
    L8:
        VideoFrame r101 = (VideoFrame) r100;
        if (this.startTime == r101.startTime) goto L12;
        return false;
    L12:
        if (this.endTime == r101.endTime) goto L15;
        return false;
    L15:
        if (this.frameTime == r101.frameTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.faces, r101.faces) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.caption, r101.caption) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ocr, r101.ocr) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final List<PhotoFaceEntity> getFaces() {
        return this.faces;
    }

    public final long getFrameTime() {
        return this.frameTime;
    }

    public final String getOcr() {
        return this.ocr;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        long r100 = this.startTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.endTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.frameTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        List<String> r106 = this.tags;
        int r107 = 0;
        if (r106 != null) goto L5;
        int r108 = 0;
    L6:
        int r109 = (r105 + r108) * 31;
        List<PhotoFaceEntity> r110 = this.faces;
        if (r110 != null) goto L9;
        int r111 = 0;
    L10:
        int r112 = (r109 + r111) * 31;
        String r113 = this.caption;
        if (r113 != null) goto L13;
        int r114 = 0;
    L14:
        int r115 = (r112 + r114) * 31;
        String r116 = this.ocr;
        if (r116 == null) goto L19;
        r107 = r116.hashCode();
    L19:
        return r115 + r107;
    L13:
        r114 = r113.hashCode();
        goto L14
    L9:
        r111 = r110.hashCode();
        goto L10
    L5:
        r108 = r106.hashCode();
        goto L6
    }

    public final void setCaption(String r100) {
        this.caption = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setFaces(List<PhotoFaceEntity> r100) {
        this.faces = r100;
    }

    public final void setFrameTime(long r100) {
        this.frameTime = r100;
    }

    public final void setOcr(String r100) {
        this.ocr = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setTags(List<String> r100) {
        this.tags = r100;
    }

    public String toString() {
        return "VideoFrame(startTime=" + this.startTime + ", endTime=" + this.endTime + ", frameTime=" + this.frameTime + ", tags=" + this.tags + ", faces=" + this.faces + ", caption=" + this.caption + ", ocr=" + this.ocr + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.startTime);
        r100.writeLong(this.endTime);
        r100.writeLong(this.frameTime);
        r100.writeStringList(this.tags);
        r100.writeTypedList(this.faces);
        r100.writeString(this.caption);
        r100.writeString(this.ocr);
        r100.writeInt(0);
    }
}
