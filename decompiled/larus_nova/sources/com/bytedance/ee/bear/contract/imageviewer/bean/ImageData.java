package com.bytedance.ee.bear.contract.imageviewer.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import du5.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class ImageData implements NonProguard, Cloneable {
    private static final String TAG = "ImageData";
    protected Image image;
    protected List<Image> imageList;
    protected ToolStatus toolStatus;

    public static class Image implements NonProguard {
        private LinkedHashMap<String, Float[]> areaComments;

        @SerializedName("commentableArea")
        @JSONField(name = "commentableArea")
        private float[] commentableArea;
        private float[] crop;
        private com.bytedance.ee.bear.contract.imageviewer.bean.a localTransformerInfo;
        private String originalSrc;
        private Position position;
        private Rotation rotation;
        private ToolStatus singleToolStatus;
        private SourceInfo sourceInfo;

        /* JADX INFO: renamed from: src, reason: collision with root package name */
        private String f217068src;
        private String srcObjToken;
        private int srcObjType;
        private String thumbnailSrc;
        private String title;
        private Map<String, a> transformAreaComments;
        private Boolean transformAreaCommentsIsSSIV;

        @SerializedName("transformerInfo")
        @JSONField(name = "transformerInfo")
        private TransformerInfo transformerInfo;
        private String uuid;

        public static final enum Rotation extends Enum<Rotation> {
            public static final Rotation ROTATE_0 = null;
            public static final Rotation ROTATE_180 = null;
            public static final Rotation ROTATE_270 = null;
            public static final Rotation ROTATE_90 = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Rotation[] f217069a = null;
            public int rotation;

            static {
                Rotation r100 = new Rotation("ROTATE_0", 0, 0);
                ROTATE_0 = r100;
                Rotation r101 = new Rotation("ROTATE_90", 1, 90);
                ROTATE_90 = r101;
                Rotation r102 = new Rotation("ROTATE_180", 2, 180);
                ROTATE_180 = r102;
                Rotation r103 = new Rotation("ROTATE_270", 3, 270);
                ROTATE_270 = r103;
                f217069a = new Rotation[]{r100, r101, r102, r103};
            }

            public static Rotation[] values() {
                return (Rotation[]) f217069a.clone();
            }

            public int getRotation() {
                return this.rotation;
            }

            public static Rotation valueOf(String r100) {
                return (Rotation) r27.a.a(Rotation.class, r100);
            }

            public Rotation(String r100, int r101, int r102) {
                super(r100, r101);
                this.rotation = r102;
            }
        }

        public static class TransformerInfo implements NonProguard {
            public String clipPath;
            public float scaleX;
            public float scaleY;

            public int hashCode() {
                return Objects.hash(new Object[]{Float.valueOf(this.scaleX), Float.valueOf(this.scaleY), this.clipPath});
            }

            public String toString() {
                return "TransformerInfo{scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", clipPath='" + this.clipPath + "'}";
            }

            public TransformerInfo() {
                this.scaleX = 1.0f;
                this.scaleY = 1.0f;
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 != null) goto L8;
            L19:
                return false;
            L8:
                if (getClass() != r100.getClass()) goto L19;
                TransformerInfo r101 = (TransformerInfo) r100;
                if (Float.compare(r101.scaleX, this.scaleX) == 0) goto L13;
            L17:
                return false;
            L13:
                if (Float.compare(r101.scaleY, this.scaleY) != 0) goto L17;
                if (Objects.equals(this.clipPath, r101.clipPath) == false) goto L17;
                return true;
            }
        }

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public float f217070a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public float f217071b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public float f217072c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public float f217073d;

            public a() {
            }

            public final String toString() {
                return "Area{[" + this.f217070a + ", " + this.f217071b + ", " + this.f217072c + ", " + this.f217073d + "]}";
            }
        }

        public int hashCode() {
            return (((Objects.hash(new Object[]{this.title, this.f217068src, this.originalSrc, this.uuid, this.transformerInfo, this.rotation, this.singleToolStatus}) * 31) + Arrays.hashCode(this.commentableArea)) * 31) + Arrays.hashCode(this.crop);
        }

        public Image copy() {
            Image r100 = new Image();
            r100.title = this.title;
            r100.f217068src = this.f217068src;
            r100.originalSrc = this.originalSrc;
            r100.thumbnailSrc = this.thumbnailSrc;
            r100.uuid = this.uuid;
            r100.transformerInfo = this.transformerInfo;
            float[] r101 = this.commentableArea;
            if (r101 == null) goto L5;
            float[] r102 = Arrays.copyOf(r101, r101.length);
        L6:
            r100.commentableArea = r102;
            float[] r103 = this.crop;
            if (r103 == null) goto L9;
            float[] r104 = Arrays.copyOf(r103, r103.length);
        L10:
            r100.crop = r104;
            if (this.areaComments == null) goto L13;
            LinkedHashMap<String, Float[]> r105 = new LinkedHashMap(this.areaComments);
        L14:
            r100.areaComments = r105;
            r100.transformAreaComments = null;
            r100.transformAreaCommentsIsSSIV = null;
            r100.rotation = this.rotation;
            r100.singleToolStatus = this.singleToolStatus;
            r100.position = this.position;
            r100.srcObjToken = this.srcObjToken;
            r100.srcObjType = this.srcObjType;
            r100.sourceInfo = this.sourceInfo;
            return r100;
        L13:
            r105 = null;
            goto L14
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        public String getRealSrc() {
            if (TextUtils.isEmpty(this.originalSrc) == false) goto L6;
            return this.f217068src;
        L6:
            return this.originalSrc;
        }

        public Map<String, a> getTransformAreaComments() {
            return getTransformAreaComments(this.transformAreaCommentsIsSSIV);
        }

        public a getTransfromedCommentableArea() {
            com.bytedance.ee.bear.contract.imageviewer.bean.a r100 = this.localTransformerInfo;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.c(this.commentableArea, false);
        }

        public String toString() {
            return "Image{uuid='" + b.g(this.uuid) + "', singleToolStatus=" + this.singleToolStatus + ", transformerInfo=" + this.transformerInfo + ", commentableArea=" + Arrays.toString(this.commentableArea) + ", crop=" + Arrays.toString(this.crop) + ", rotation=" + this.rotation + '}';
        }

        public Image() {
            this.commentableArea = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
            this.crop = new float[0];
            this.areaComments = new LinkedHashMap();
            this.transformAreaComments = null;
            this.transformAreaCommentsIsSSIV = null;
            this.rotation = Rotation.ROTATE_0;
        }

        public float[] getCommentableArea() {
            return this.commentableArea;
        }

        public float[] getCrop() {
            return this.crop;
        }

        public com.bytedance.ee.bear.contract.imageviewer.bean.a getLocalTransformerInfo() {
            return this.localTransformerInfo;
        }

        public String getOriginalSrc() {
            return this.originalSrc;
        }

        public Position getPosition() {
            return this.position;
        }

        public Rotation getRotation() {
            return this.rotation;
        }

        public ToolStatus getSingleToolStatus() {
            return this.singleToolStatus;
        }

        public SourceInfo getSourceInfo() {
            return this.sourceInfo;
        }

        public String getSrc() {
            return this.f217068src;
        }

        public String getSrcObjToken() {
            return this.srcObjToken;
        }

        public int getSrcObjType() {
            return this.srcObjType;
        }

        public String getThumbnailSrc() {
            return this.thumbnailSrc;
        }

        public String getTitle() {
            return this.title;
        }

        public TransformerInfo getTransformerInfo() {
            return this.transformerInfo;
        }

        public String getUuid() {
            return this.uuid;
        }

        public static /* synthetic */ Position access$000(Image r100) {
            return r100.position;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L31:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L31;
            Image r101 = (Image) r100;
            if (Objects.equals(this.title, r101.title) == true) goto L13;
        L29:
            return false;
        L13:
            if (Objects.equals(this.f217068src, r101.f217068src) == false) goto L29;
            if (Objects.equals(this.originalSrc, r101.originalSrc) == false) goto L29;
            if (Objects.equals(this.uuid, r101.uuid) == false) goto L29;
            if (Objects.equals(this.transformerInfo, r101.transformerInfo) == false) goto L29;
            if (Arrays.equals(this.commentableArea, r101.commentableArea) == false) goto L29;
            if (Objects.equals(this.rotation, r101.rotation) == false) goto L29;
            if (Arrays.equals(this.crop, r101.crop) == false) goto L29;
            if (Objects.equals(this.singleToolStatus, r101.singleToolStatus) == false) goto L29;
            return true;
        }

        public Map<String, a> getTransformAreaComments(Boolean r110) {
            if (this.transformAreaComments == null) goto L10;
            Boolean r100 = this.transformAreaCommentsIsSSIV;
            if (r100 == null) goto L10;
            if (r100.booleanValue() != r110.booleanValue()) goto L10;
            return this.transformAreaComments;
        L10:
            this.transformAreaComments = new LinkedHashMap();
            this.transformAreaCommentsIsSSIV = r110;
            com.bytedance.ee.bear.contract.imageviewer.bean.a r101 = this.localTransformerInfo;
            if (r101 != null) goto L43;
            Iterator<Map.Entry<String, Float[]>> r102 = this.areaComments.entrySet().iterator();
        L14:
            if (r102.hasNext() == false) goto L42;
            Map.Entry<String, Float[]> r103 = r102.next();
            Float[] r104 = r103.getValue();
            float[] r105 = this.crop;
            a r111 = new a();
            if (r104 == null) goto L40;
            if (r104.length < 4) goto L40;
            Float r112 = r104[0];
            if (r112 == null) goto L40;
            if (r104[1] == null) goto L40;
            if (r104[2] == null) goto L40;
            if (r104[3] == null) goto L40;
            if (r105 != null) goto L30;
        L39:
            r111.f217070a = r112.floatValue();
            r111.f217071b = r104[1].floatValue();
            r111.f217072c = r104[2].floatValue();
            r111.f217073d = r104[3].floatValue();
            goto L40
        L30:
            if (r105.length < 4) goto L39;
            float r113 = r105[0];
            float r114 = r105[1];
            float r115 = r105[2] - r113;
            float r106 = r105[3] - r114;
            if (r115 != 0.0f) goto L35;
        L38:
            r111.f217070a = r112.floatValue();
            r111.f217071b = r104[1].floatValue();
            r111.f217072c = r104[2].floatValue();
            r111.f217073d = r104[3].floatValue();
            goto L40
        L35:
            if (r106 == 0.0f) goto L38;
            float r116 = (r112.floatValue() - r113) / r115;
            float r117 = (r104[1].floatValue() - r114) / r106;
            float r118 = (r104[2].floatValue() - r113) / r115;
            float r107 = (r104[3].floatValue() - r114) / r106;
            r111.f217070a = r116;
            r111.f217071b = r117;
            r111.f217072c = r118;
            r111.f217073d = r107;
        L40:
            this.transformAreaComments.put(r103.getKey(), r111);
            goto L14
        L42:
            return this.transformAreaComments;
        L43:
            LinkedHashMap<String, Float[]> r108 = this.areaComments;
            if (r108 == null) goto L57;
            if (hu5.a.e(r108) == true) goto L57;
            Iterator<Map.Entry<String, Float[]>> r109 = this.areaComments.entrySet().iterator();
        L49:
            if (r109.hasNext() == false) goto L57;
            Map.Entry<String, Float[]> r119 = r109.next();
            Float[] r120 = r119.getValue();
            if (r120 == null) goto L49;
            if (r120.length < 4) goto L49;
            a r121 = r101.c(new float[]{r120[0].floatValue(), r120[1].floatValue(), r120[2].floatValue(), r120[3].floatValue()}, r110.booleanValue());
            this.transformAreaComments.put(r119.getKey(), r121);
            tt5.a.h(ImageData.TAG, "transformAreaComment: " + r121 + ", commentId: " + r119.getKey() + ", areaArray: " + Arrays.toString(r120));
        L57:
            return this.transformAreaComments;
        }

        public void setAreaComments(LinkedHashMap<String, Float[]> r100) {
            this.areaComments = r100;
            this.transformAreaComments = null;
            this.transformAreaCommentsIsSSIV = null;
        }

        public void setCommentableArea(float[] r100) {
            this.commentableArea = r100;
        }

        public void setCrop(float[] r100) {
            this.crop = r100;
            this.transformAreaComments = null;
            this.transformAreaCommentsIsSSIV = null;
        }

        public void setLocalTransformerInfo(com.bytedance.ee.bear.contract.imageviewer.bean.a r100) {
            this.localTransformerInfo = r100;
        }

        public void setOriginalSrc(String r100) {
            this.originalSrc = r100;
        }

        public void setPosition(Position r100) {
            this.position = r100;
        }

        public void setRotation(Rotation r100) {
            this.rotation = r100;
        }

        public void setSingleToolStatus(ToolStatus r100) {
            this.singleToolStatus = r100;
        }

        public void setSourceInfo(SourceInfo r100) {
            this.sourceInfo = r100;
        }

        public void setSrc(String r100) {
            this.f217068src = r100;
        }

        public void setSrcObjToken(String r100) {
            this.srcObjToken = r100;
        }

        public void setSrcObjType(int r100) {
            this.srcObjType = r100;
        }

        public void setThumbnailSrc(String r100) {
            this.thumbnailSrc = r100;
        }

        public void setTitle(String r100) {
            this.title = r100;
        }

        public void setTransformerInfo(TransformerInfo r100) {
            this.transformerInfo = r100;
            this.transformAreaComments = null;
            this.transformAreaCommentsIsSSIV = null;
        }

        public void setUuid(String r100) {
            this.uuid = r100;
        }
    }

    public static class Position implements Parcelable, NonProguard {
        public static final Parcelable.Creator<Position> CREATOR = null;
        public float height;
        public float width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public float f217074x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f217075y;

        public class a implements Parcelable.Creator<Position> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Position createFromParcel(Parcel r100) {
                return new Position(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final Position[] newArray(int r100) {
                return new Position[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public Position() {
        }

        public Position(Parcel r100) {
            this.f217074x = r100.readFloat();
            this.f217075y = r100.readFloat();
            this.width = r100.readFloat();
            this.height = r100.readFloat();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeFloat(this.f217074x);
            r100.writeFloat(this.f217075y);
            r100.writeFloat(this.width);
            r100.writeFloat(this.height);
        }
    }

    public static class SourceInfo implements NonProguard {
        private String token;
        private int type;

        public SourceInfo() {
        }

        public String getToken() {
            return this.token;
        }

        public int getType() {
            return this.type;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setType(int r100) {
            this.type = r100;
        }
    }

    public static class ToolStatus implements NonProguard {
        private boolean areaComment;
        private boolean comment;
        private boolean commentable;
        private boolean copy;
        private boolean delete;
        private boolean edit;
        private boolean export;

        @SerializedName("openVcWb")
        @JSONField(name = "openVcWb")
        private boolean followMark;

        public ToolStatus() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.comment), Boolean.valueOf(this.delete), Boolean.valueOf(this.copy), Boolean.valueOf(this.edit), Boolean.valueOf(this.followMark), Boolean.valueOf(this.areaComment)});
        }

        public String toString() {
            return "ToolStatus{comment=" + this.comment + ", commentable=" + this.commentable + ", delete=" + this.delete + ", copy=" + this.copy + ", export=" + this.export + ", edit=" + this.edit + ", followMark=" + this.followMark + ", areaComment=" + this.areaComment + '}';
        }

        public boolean isAreaComment() {
            return this.areaComment;
        }

        public boolean isComment() {
            return this.comment;
        }

        public boolean isCommentable() {
            return this.commentable;
        }

        public boolean isCopy() {
            return this.copy;
        }

        public boolean isDelete() {
            return this.delete;
        }

        public boolean isEdit() {
            return this.edit;
        }

        public boolean isExport() {
            return this.export;
        }

        public boolean isFollowMark() {
            return this.followMark;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L25:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L25;
            ToolStatus r101 = (ToolStatus) r100;
            if (this.comment == r101.comment) goto L13;
        L23:
            return false;
        L13:
            if (this.delete != r101.delete) goto L23;
            if (this.copy != r101.copy) goto L23;
            if (this.edit != r101.edit) goto L23;
            if (this.followMark != r101.followMark) goto L23;
            if (this.areaComment != r101.areaComment) goto L23;
            return true;
        }

        public void setAreaComment(boolean r100) {
            this.areaComment = r100;
        }

        public void setComment(boolean r100) {
            this.comment = r100;
        }

        public void setCommentable(boolean r100) {
            this.commentable = r100;
        }

        public void setCopy(boolean r100) {
            this.copy = r100;
        }

        public void setDelete(boolean r100) {
            this.delete = r100;
        }

        public void setEdit(boolean r100) {
            this.edit = r100;
        }

        public void setExport(boolean r100) {
            this.export = r100;
        }

        public void setFollowMark(boolean r100) {
            this.followMark = r100;
        }
    }

    public ImageData() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.toolStatus, this.image, this.imageList});
    }

    public String getToolbarStatusLog() {
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L8
        r100.append("toolStatus = ");     // Catch: Exception -> L8
        r100.append(this.toolStatus);     // Catch: Exception -> L8
        r100.append(", [");     // Catch: Exception -> L8
        Iterator<Image> r101 = this.imageList.iterator();     // Catch: Exception -> L8
    L4:
        if (r101.hasNext() == false) goto L6;
        Image r102 = r101.next();     // Catch: Exception -> L8
        r100.append("singleToolStatus = ");     // Catch: Exception -> L8
        r100.append(r102.getSingleToolStatus());     // Catch: Exception -> L8
        r100.append(", ");     // Catch: Exception -> L8
        goto L4
    L6:
        r100.append("]");     // Catch: Exception -> L8
        return r100.toString();
    L8:
        e = move-exception;
        tt5.a.e(TAG, "getToolbarStatusLog error", e, false);
        return "toolStatus = null";
    }

    public boolean hasValidEnterAnimator() {
        Image r100 = this.image;
        if (r100 != null) goto L5;
        return false;
    L5:
        Position r101 = Image.access$000(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.width > 0.0f) goto L10;
        return false;
    L10:
        if (r101.height <= 0.0f) goto L15;
        return true;
    L15:
        return false;
    }

    public String toString() {
        return "ImageData{toolStatus=" + this.toolStatus + ", image=" + this.image + ", imageList=" + this.imageList + '}';
    }

    public ImageData clone() {
        return (ImageData) super.clone();
    L4:
        e = move-exception;
        tt5.a.e(TAG, "clone error", e, false);
        return null;
    }

    public Image getImage() {
        return this.image;
    }

    public List<Image> getImageList() {
        return this.imageList;
    }

    public ToolStatus getToolStatus() {
        return this.toolStatus;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8322clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        ImageData r101 = (ImageData) r100;
        if (Objects.equals(this.toolStatus, r101.toolStatus) == true) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.image, r101.image) == false) goto L17;
        if (Objects.equals(this.imageList, r101.imageList) == false) goto L17;
        return true;
    }

    public Image findImageByPosition(int r100) {
        List<Image> r101 = this.imageList;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.size() > 0) goto L7;
        return null;
    L7:
        return (Image) ListProtector.get(this.imageList, r100);
    }

    public void setImage(Image r100) {
        this.image = r100;
    }

    public void setImageList(List<Image> r100) {
        this.imageList = r100;
    }

    public void setToolStatus(ToolStatus r100) {
        this.toolStatus = r100;
    }
}
