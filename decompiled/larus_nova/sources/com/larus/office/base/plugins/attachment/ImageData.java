package com.larus.office.base.plugins.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXMode;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0005\u0013\u0014\u0015\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/office/base/plugins/attachment/ImageData;", "", "<init>", "()V", "toolStatus", "Lcom/larus/office/base/plugins/attachment/ImageData$ToolStatus;", "image", "Lcom/larus/office/base/plugins/attachment/ImageData$Image;", "imageList", "", "toString", "", "clone", "", "equals", "", "o", "hashCode", "", "Image", "SourceInfo", "Position", "ToolStatus", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ImageData implements Cloneable {
    public static final a Companion = null;
    private static final String TAG = "ImageData";

    @SerializedName("image")
    public Image image;

    @SerializedName("image_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<Image> imageList;

    @SerializedName("tool_status")
    public ToolStatus toolStatus;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010=\u001a\u00020/H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00104\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0013\u0010>\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b?\u0010\u0007¨\u0006A"}, d2 = {"Lcom/larus/office/base/plugins/attachment/ImageData$Image;", "", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "src", "getSrc", "setSrc", "originalSrc", "getOriginalSrc", "setOriginalSrc", ST.UUID_DEVICE, "getUuid", "setUuid", GXMode.MODE_TYPE_CROP, "", "getCrop", "()[F", "setCrop", "([F)V", "rotation", "Lcom/larus/office/base/plugins/attachment/ImageData$Image$Rotation;", "getRotation", "()Lcom/larus/office/base/plugins/attachment/ImageData$Image$Rotation;", "setRotation", "(Lcom/larus/office/base/plugins/attachment/ImageData$Image$Rotation;)V", "singleToolStatus", "Lcom/larus/office/base/plugins/attachment/ImageData$ToolStatus;", "getSingleToolStatus", "()Lcom/larus/office/base/plugins/attachment/ImageData$ToolStatus;", "setSingleToolStatus", "(Lcom/larus/office/base/plugins/attachment/ImageData$ToolStatus;)V", "position", "Lcom/larus/office/base/plugins/attachment/ImageData$Position;", "getPosition", "()Lcom/larus/office/base/plugins/attachment/ImageData$Position;", "setPosition", "(Lcom/larus/office/base/plugins/attachment/ImageData$Position;)V", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "", "getSrcObjType", "()I", "setSrcObjType", "(I)V", "sourceInfo", "Lcom/larus/office/base/plugins/attachment/ImageData$SourceInfo;", "getSourceInfo", "()Lcom/larus/office/base/plugins/attachment/ImageData$SourceInfo;", "setSourceInfo", "(Lcom/larus/office/base/plugins/attachment/ImageData$SourceInfo;)V", "equals", "", "o", "hashCode", "realSrc", "getRealSrc", "Rotation", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Image {

        @SerializedName(GXMode.MODE_TYPE_CROP)
        private float[] crop;

        @SerializedName("originalSrc")
        private String originalSrc;

        @SerializedName("position")
        private Position position;

        @SerializedName("rotation")
        private Rotation rotation;

        @SerializedName("singleToolStatus")
        private ToolStatus singleToolStatus;

        @SerializedName("sourceInfo")
        private SourceInfo sourceInfo;

        /* JADX INFO: renamed from: src, reason: collision with root package name */
        @SerializedName("src")
        private String f360693src;

        @SerializedName("srcObjToken")
        private String srcObjToken;

        @SerializedName("srcObjType")
        private int srcObjType;

        @SerializedName("title")
        private String title;

        @SerializedName(ST.UUID_DEVICE)
        private String uuid;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/office/base/plugins/attachment/ImageData$Image$Rotation;", "", "rotation", "", "<init>", "(Ljava/lang/String;II)V", "getRotation", "()I", "setRotation", "(I)V", "ROTATE_0", "ROTATE_90", "ROTATE_180", "ROTATE_270", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Rotation extends Enum<Rotation> {
            public static final Rotation ROTATE_0 = null;
            public static final Rotation ROTATE_180 = null;
            public static final Rotation ROTATE_270 = null;
            public static final Rotation ROTATE_90 = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Rotation[] f360694a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f360695b = null;
            private int rotation;

            public static EnumEntries<Rotation> getEntries() {
                return f360695b;
            }

            static {
                Rotation r100 = new Rotation("ROTATE_0", 0, 0);
                ROTATE_0 = r100;
                Rotation r101 = new Rotation("ROTATE_90", 1, 90);
                ROTATE_90 = r101;
                Rotation r102 = new Rotation("ROTATE_180", 2, 180);
                ROTATE_180 = r102;
                Rotation r103 = new Rotation("ROTATE_270", 3, 270);
                ROTATE_270 = r103;
                Rotation[] r104 = {r100, r101, r102, r103};
                f360694a = r104;
                f360695b = EnumEntriesKt.enumEntries(r104);
            }

            public static Rotation[] values() {
                return (Rotation[]) f360694a.clone();
            }

            public final int getRotation() {
                return this.rotation;
            }

            public static Rotation valueOf(String r100) {
                return (Rotation) r27.a.a(Rotation.class, r100);
            }

            public final void setRotation(int r100) {
                this.rotation = r100;
            }

            public Rotation(String r100, int r101, int r102) {
                super(r100, r101);
                this.rotation = r102;
            }
        }

        public int hashCode() {
            return (Objects.hash(new Object[]{this.title, this.f360693src, this.originalSrc, this.uuid, this.rotation, this.singleToolStatus}) * 31) + Arrays.hashCode(this.crop);
        }

        public final String getRealSrc() {
            if (TextUtils.isEmpty(this.originalSrc) == false) goto L6;
            return this.f360693src;
        L6:
            return this.originalSrc;
        }

        public Image() {
            this.crop = new float[0];
            this.rotation = Rotation.ROTATE_0;
        }

        public final float[] getCrop() {
            return this.crop;
        }

        public final String getOriginalSrc() {
            return this.originalSrc;
        }

        public final Position getPosition() {
            return this.position;
        }

        public final Rotation getRotation() {
            return this.rotation;
        }

        public final ToolStatus getSingleToolStatus() {
            return this.singleToolStatus;
        }

        public final SourceInfo getSourceInfo() {
            return this.sourceInfo;
        }

        public final String getSrc() {
            return this.f360693src;
        }

        public final String getSrcObjToken() {
            return this.srcObjToken;
        }

        public final int getSrcObjType() {
            return this.srcObjType;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L27:
            return false;
        L8:
            if (Intrinsics.areEqual(Image.class, r100.getClass()) == false) goto L27;
            Image r101 = (Image) r100;
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L13;
        L25:
            return false;
        L13:
            if (Intrinsics.areEqual(this.f360693src, r101.f360693src) == false) goto L25;
            if (Intrinsics.areEqual(this.originalSrc, r101.originalSrc) == false) goto L25;
            if (Intrinsics.areEqual(this.uuid, r101.uuid) == false) goto L25;
            if (this.rotation != r101.rotation) goto L25;
            if (Arrays.equals(this.crop, r101.crop) == false) goto L25;
            if (Intrinsics.areEqual(this.singleToolStatus, r101.singleToolStatus) == false) goto L25;
            return true;
        }

        public final void setCrop(float[] r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.crop = r100;
        }

        public final void setOriginalSrc(String r100) {
            this.originalSrc = r100;
        }

        public final void setPosition(Position r100) {
            this.position = r100;
        }

        public final void setRotation(Rotation r100) {
            this.rotation = r100;
        }

        public final void setSingleToolStatus(ToolStatus r100) {
            this.singleToolStatus = r100;
        }

        public final void setSourceInfo(SourceInfo r100) {
            this.sourceInfo = r100;
        }

        public final void setSrc(String r100) {
            this.f360693src = r100;
        }

        public final void setSrcObjToken(String r100) {
            this.srcObjToken = r100;
        }

        public final void setSrcObjType(int r100) {
            this.srcObjType = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }

        public final void setUuid(String r100) {
            this.uuid = r100;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/office/base/plugins/attachment/ImageData$Position;", "Landroid/os/Parcelable;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "writeToParcel", "", "dest", "flags", "", "describeContents", "CREATOR", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Position implements Parcelable {
        public static final a CREATOR = null;

        @SerializedName("height")
        private float height;

        @SerializedName("width")
        private float width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private float f360696x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private float f360697y;

        public static final class a implements Parcelable.Creator<Position> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Position createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new Position(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final Position[] newArray(int r100) {
                return new Position[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public Position() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float getX() {
            return this.f360696x;
        }

        public final float getY() {
            return this.f360697y;
        }

        public Position(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            this.f360696x = r100.readFloat();
            this.f360697y = r100.readFloat();
            this.width = r100.readFloat();
            this.height = r100.readFloat();
        }

        public final void setHeight(float r100) {
            this.height = r100;
        }

        public final void setWidth(float r100) {
            this.width = r100;
        }

        public final void setX(float r100) {
            this.f360696x = r100;
        }

        public final void setY(float r100) {
            this.f360697y = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeFloat(this.f360696x);
            r100.writeFloat(this.f360697y);
            r100.writeFloat(this.width);
            r100.writeFloat(this.height);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/office/base/plugins/attachment/ImageData$SourceInfo;", "", "<init>", "()V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SourceInfo {

        @SerializedName("token")
        private String token;

        @SerializedName("type")
        private int type;

        public SourceInfo() {
        }

        public final String getToken() {
            return this.token;
        }

        public final int getType() {
            return this.type;
        }

        public final void setToken(String r100) {
            this.token = r100;
        }

        public final void setType(int r100) {
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/larus/office/base/plugins/attachment/ImageData$ToolStatus;", "", "<init>", "()V", "isComment", "", "()Z", "setComment", "(Z)V", "isCommentable", "setCommentable", "isDelete", "setDelete", "isCopy", "setCopy", "isExport", "setExport", "isEdit", "setEdit", "isFollowMark", "setFollowMark", "toString", "", "equals", "o", "hashCode", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ToolStatus {

        @SerializedName("comment")
        private boolean isComment;

        @SerializedName("commentable")
        private boolean isCommentable;

        @SerializedName("copy")
        private boolean isCopy;

        @SerializedName("delete")
        private boolean isDelete;

        @SerializedName("edit")
        private boolean isEdit;

        @SerializedName("export")
        private boolean isExport;

        @SerializedName("openVcWb")
        private boolean isFollowMark;

        public ToolStatus() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.isComment), Boolean.valueOf(this.isDelete), Boolean.valueOf(this.isCopy), Boolean.valueOf(this.isEdit), Boolean.valueOf(this.isFollowMark)});
        }

        public String toString() {
            return "ToolStatus{comment=" + this.isComment + ", commentable=" + this.isCommentable + ", delete=" + this.isDelete + ", copy=" + this.isCopy + ", export=" + this.isExport + ", edit=" + this.isEdit + ", followMark=" + this.isFollowMark + '}';
        }

        public final boolean isComment() {
            return this.isComment;
        }

        public final boolean isCommentable() {
            return this.isCommentable;
        }

        public final boolean isCopy() {
            return this.isCopy;
        }

        public final boolean isDelete() {
            return this.isDelete;
        }

        public final boolean isEdit() {
            return this.isEdit;
        }

        public final boolean isExport() {
            return this.isExport;
        }

        public final boolean isFollowMark() {
            return this.isFollowMark;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L23:
            return false;
        L8:
            if (Intrinsics.areEqual(ToolStatus.class, r100.getClass()) == false) goto L23;
            ToolStatus r101 = (ToolStatus) r100;
            if (this.isComment == r101.isComment) goto L13;
        L21:
            return false;
        L13:
            if (this.isDelete != r101.isDelete) goto L21;
            if (this.isCopy != r101.isCopy) goto L21;
            if (this.isEdit != r101.isEdit) goto L21;
            if (this.isFollowMark != r101.isFollowMark) goto L21;
            return true;
        }

        public final void setComment(boolean r100) {
            this.isComment = r100;
        }

        public final void setCommentable(boolean r100) {
            this.isCommentable = r100;
        }

        public final void setCopy(boolean r100) {
            this.isCopy = r100;
        }

        public final void setDelete(boolean r100) {
            this.isDelete = r100;
        }

        public final void setEdit(boolean r100) {
            this.isEdit = r100;
        }

        public final void setExport(boolean r100) {
            this.isExport = r100;
        }

        public final void setFollowMark(boolean r100) {
            this.isFollowMark = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageData() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.toolStatus, this.image, this.imageList});
    }

    public String toString() {
        return "ImageData{toolStatus=" + this.toolStatus + ", image=" + this.image + ", imageList=" + this.imageList + '}';
    }

    public Object clone() {
        Object r100 = super.clone();     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.office.base.plugins.attachment.ImageData");     // Catch: Exception -> L4
        return (ImageData) r100;
    L4:
        e = move-exception;
        FLogger.f375446a.e(TAG, "clone error", e);
        return new ImageData();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (Intrinsics.areEqual(getClass(), r100.getClass()) == false) goto L19;
        ImageData r101 = (ImageData) r100;
        if (Intrinsics.areEqual(this.toolStatus, r101.toolStatus) == true) goto L13;
    L17:
        return false;
    L13:
        if (Intrinsics.areEqual(this.image, r101.image) == false) goto L17;
        if (Intrinsics.areEqual(this.imageList, r101.imageList) == false) goto L17;
        return true;
    }
}
