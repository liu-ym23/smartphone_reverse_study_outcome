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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        private String src;
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
            public static final /* synthetic */ Rotation[] a = null;
            public int rotation;

            static {
                Rotation r0 = new Rotation("ROTATE_0", 0, 0);
                ROTATE_0 = r0;
                Rotation r1 = new Rotation("ROTATE_90", 1, 90);
                ROTATE_90 = r1;
                Rotation r3 = new Rotation("ROTATE_180", 2, 180);
                ROTATE_180 = r3;
                Rotation r4 = new Rotation("ROTATE_270", 3, 270);
                ROTATE_270 = r4;
                a = new Rotation[]{r0, r1, r3, r4};
            }

            public static Rotation[] values() {
                return (Rotation[]) a.clone();
            }

            public int getRotation() {
                return this.rotation;
            }

            public static Rotation valueOf(String r1) {
                return (Rotation) r27.a.a(Rotation.class, r1);
            }

            public Rotation(String r1, int r2, int r3) {
                super(r1, r2);
                this.rotation = r3;
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

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (r5 != null) goto L8;
            L19:
                return false;
            L8:
                if (getClass() != r5.getClass()) goto L19;
                TransformerInfo r6 = (TransformerInfo) r5;
                if (Float.compare(r6.scaleX, this.scaleX) == 0) goto L13;
            L17:
                return false;
            L13:
                if (Float.compare(r6.scaleY, this.scaleY) != 0) goto L17;
                if (Objects.equals(this.clipPath, r6.clipPath) == false) goto L17;
                return true;
            }
        }

        public static class a {
            public float a;
            public float b;
            public float c;
            public float d;

            public a() {
            }

            public final String toString() {
                return "Area{[" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + "]}";
            }
        }

        public int hashCode() {
            return (((Objects.hash(new Object[]{this.title, this.src, this.originalSrc, this.uuid, this.transformerInfo, this.rotation, this.singleToolStatus}) * 31) + Arrays.hashCode(this.commentableArea)) * 31) + Arrays.hashCode(this.crop);
        }

        public Image copy() {
            Image r0 = new Image();
            r0.title = this.title;
            r0.src = this.src;
            r0.originalSrc = this.originalSrc;
            r0.thumbnailSrc = this.thumbnailSrc;
            r0.uuid = this.uuid;
            r0.transformerInfo = this.transformerInfo;
            float[] r1 = this.commentableArea;
            if (r1 == null) goto L5;
            float[] r2 = Arrays.copyOf(r1, r1.length);
        L6:
            r0.commentableArea = r2;
            float[] r3 = this.crop;
            if (r3 == null) goto L9;
            float[] r4 = Arrays.copyOf(r3, r3.length);
        L10:
            r0.crop = r4;
            if (this.areaComments == null) goto L13;
            LinkedHashMap<String, Float[]> r5 = new LinkedHashMap(this.areaComments);
        L14:
            r0.areaComments = r5;
            r0.transformAreaComments = null;
            r0.transformAreaCommentsIsSSIV = null;
            r0.rotation = this.rotation;
            r0.singleToolStatus = this.singleToolStatus;
            r0.position = this.position;
            r0.srcObjToken = this.srcObjToken;
            r0.srcObjType = this.srcObjType;
            r0.sourceInfo = this.sourceInfo;
            return r0;
        L13:
            r5 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public String getRealSrc() {
            if (TextUtils.isEmpty(this.originalSrc) == false) goto L6;
            return this.src;
        L6:
            return this.originalSrc;
        }

        public Map<String, a> getTransformAreaComments() {
            return getTransformAreaComments(this.transformAreaCommentsIsSSIV);
        }

        public a getTransfromedCommentableArea() {
            com.bytedance.ee.bear.contract.imageviewer.bean.a r0 = this.localTransformerInfo;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.c(this.commentableArea, false);
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
            return this.src;
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

        public static /* synthetic */ Position access$000(Image r0) {
            return r0.position;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L31:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L31;
            Image r6 = (Image) r5;
            if (Objects.equals(this.title, r6.title) == true) goto L13;
        L29:
            return false;
        L13:
            if (Objects.equals(this.src, r6.src) == false) goto L29;
            if (Objects.equals(this.originalSrc, r6.originalSrc) == false) goto L29;
            if (Objects.equals(this.uuid, r6.uuid) == false) goto L29;
            if (Objects.equals(this.transformerInfo, r6.transformerInfo) == false) goto L29;
            if (Arrays.equals(this.commentableArea, r6.commentableArea) == false) goto L29;
            if (Objects.equals(this.rotation, r6.rotation) == false) goto L29;
            if (Arrays.equals(this.crop, r6.crop) == false) goto L29;
            if (Objects.equals(this.singleToolStatus, r6.singleToolStatus) == false) goto L29;
            return true;
        }

        public Map<String, a> getTransformAreaComments(Boolean r18) {
            if (this.transformAreaComments == null) goto L10;
            Boolean r1 = this.transformAreaCommentsIsSSIV;
            if (r1 == null) goto L10;
            if (r1.booleanValue() != r18.booleanValue()) goto L10;
            return this.transformAreaComments;
        L10:
            this.transformAreaComments = new LinkedHashMap();
            this.transformAreaCommentsIsSSIV = r18;
            com.bytedance.ee.bear.contract.imageviewer.bean.a r2 = this.localTransformerInfo;
            if (r2 != null) goto L43;
            Iterator<Map.Entry<String, Float[]>> r3 = this.areaComments.entrySet().iterator();
        L14:
            if (r3.hasNext() == false) goto L42;
            Map.Entry<String, Float[]> r4 = r3.next();
            Float[] r8 = r4.getValue();
            float[] r9 = this.crop;
            a r10 = new a();
            if (r8 == null) goto L40;
            if (r8.length < 4) goto L40;
            Float r11 = r8[0];
            if (r11 == null) goto L40;
            if (r8[1] == null) goto L40;
            if (r8[2] == null) goto L40;
            if (r8[3] == null) goto L40;
            if (r9 != null) goto L30;
        L39:
            r10.a = r11.floatValue();
            r10.b = r8[1].floatValue();
            r10.c = r8[2].floatValue();
            r10.d = r8[3].floatValue();
            goto L40
        L30:
            if (r9.length < 4) goto L39;
            float r12 = r9[0];
            float r13 = r9[1];
            float r14 = r9[2] - r12;
            float r16 = r9[3] - r13;
            if (r14 != 0.0f) goto L35;
        L38:
            r10.a = r11.floatValue();
            r10.b = r8[1].floatValue();
            r10.c = r8[2].floatValue();
            r10.d = r8[3].floatValue();
            goto L40
        L35:
            if (r16 == 0.0f) goto L38;
            float r17 = (r11.floatValue() - r12) / r14;
            float r19 = (r8[1].floatValue() - r13) / r16;
            float r110 = (r8[2].floatValue() - r12) / r14;
            float r20 = (r8[3].floatValue() - r13) / r16;
            r10.a = r17;
            r10.b = r19;
            r10.c = r110;
            r10.d = r20;
        L40:
            this.transformAreaComments.put(r4.getKey(), r10);
            goto L14
        L42:
            return this.transformAreaComments;
        L43:
            LinkedHashMap<String, Float[]> r21 = this.areaComments;
            if (r21 == null) goto L57;
            if (hu5.a.e(r21) == true) goto L57;
            Iterator<Map.Entry<String, Float[]>> r22 = this.areaComments.entrySet().iterator();
        L49:
            if (r22.hasNext() == false) goto L57;
            Map.Entry<String, Float[]> r23 = r22.next();
            Float[] r111 = r23.getValue();
            if (r111 == null) goto L49;
            if (r111.length < 4) goto L49;
            a r112 = r2.c(new float[]{r111[0].floatValue(), r111[1].floatValue(), r111[2].floatValue(), r111[3].floatValue()}, r18.booleanValue());
            this.transformAreaComments.put(r23.getKey(), r112);
            tt5.a.h(ImageData.TAG, "transformAreaComment: " + r112 + ", commentId: " + r23.getKey() + ", areaArray: " + Arrays.toString(r111));
        L57:
            return this.transformAreaComments;
        }

        public void setAreaComments(LinkedHashMap<String, Float[]> r1) {
            this.areaComments = r1;
            this.transformAreaComments = null;
            this.transformAreaCommentsIsSSIV = null;
        }

        public void setCommentableArea(float[] r1) {
            this.commentableArea = r1;
        }

        public void setCrop(float[] r1) {
            this.crop = r1;
            this.transformAreaComments = null;
            this.transformAreaCommentsIsSSIV = null;
        }

        public void setLocalTransformerInfo(com.bytedance.ee.bear.contract.imageviewer.bean.a r1) {
            this.localTransformerInfo = r1;
        }

        public void setOriginalSrc(String r1) {
            this.originalSrc = r1;
        }

        public void setPosition(Position r1) {
            this.position = r1;
        }

        public void setRotation(Rotation r1) {
            this.rotation = r1;
        }

        public void setSingleToolStatus(ToolStatus r1) {
            this.singleToolStatus = r1;
        }

        public void setSourceInfo(SourceInfo r1) {
            this.sourceInfo = r1;
        }

        public void setSrc(String r1) {
            this.src = r1;
        }

        public void setSrcObjToken(String r1) {
            this.srcObjToken = r1;
        }

        public void setSrcObjType(int r1) {
            this.srcObjType = r1;
        }

        public void setThumbnailSrc(String r1) {
            this.thumbnailSrc = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }

        public void setTransformerInfo(TransformerInfo r1) {
            this.transformerInfo = r1;
            this.transformAreaComments = null;
            this.transformAreaCommentsIsSSIV = null;
        }

        public void setUuid(String r1) {
            this.uuid = r1;
        }
    }

    public static class Position implements Parcelable, NonProguard {
        public static final Parcelable.Creator<Position> CREATOR = null;
        public float height;
        public float width;
        public float x;
        public float y;

        public class a implements Parcelable.Creator<Position> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Position createFromParcel(Parcel r2) {
                return new Position(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final Position[] newArray(int r1) {
                return new Position[r1];
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

        public Position(Parcel r2) {
            this.x = r2.readFloat();
            this.y = r2.readFloat();
            this.width = r2.readFloat();
            this.height = r2.readFloat();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeFloat(this.x);
            r1.writeFloat(this.y);
            r1.writeFloat(this.width);
            r1.writeFloat(this.height);
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

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setType(int r1) {
            this.type = r1;
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L25:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L25;
            ToolStatus r6 = (ToolStatus) r5;
            if (this.comment == r6.comment) goto L13;
        L23:
            return false;
        L13:
            if (this.delete != r6.delete) goto L23;
            if (this.copy != r6.copy) goto L23;
            if (this.edit != r6.edit) goto L23;
            if (this.followMark != r6.followMark) goto L23;
            if (this.areaComment != r6.areaComment) goto L23;
            return true;
        }

        public void setAreaComment(boolean r1) {
            this.areaComment = r1;
        }

        public void setComment(boolean r1) {
            this.comment = r1;
        }

        public void setCommentable(boolean r1) {
            this.commentable = r1;
        }

        public void setCopy(boolean r1) {
            this.copy = r1;
        }

        public void setDelete(boolean r1) {
            this.delete = r1;
        }

        public void setEdit(boolean r1) {
            this.edit = r1;
        }

        public void setExport(boolean r1) {
            this.export = r1;
        }

        public void setFollowMark(boolean r1) {
            this.followMark = r1;
        }
    }

    public ImageData() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.toolStatus, this.image, this.imageList});
    }

    public String getToolbarStatusLog() {
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L8
        r0.append("toolStatus = ");     // Catch: Exception -> L8
        r0.append(this.toolStatus);     // Catch: Exception -> L8
        r0.append(", [");     // Catch: Exception -> L8
        Iterator<Image> r1 = this.imageList.iterator();     // Catch: Exception -> L8
    L4:
        if (r1.hasNext() == false) goto L6;
        Image r2 = r1.next();     // Catch: Exception -> L8
        r0.append("singleToolStatus = ");     // Catch: Exception -> L8
        r0.append(r2.getSingleToolStatus());     // Catch: Exception -> L8
        r0.append(", ");     // Catch: Exception -> L8
        goto L4
    L6:
        r0.append("]");     // Catch: Exception -> L8
        return r0.toString();
    L8:
        e = move-exception;
        tt5.a.e(TAG, "getToolbarStatusLog error", e, false);
        return "toolStatus = null";
    }

    public boolean hasValidEnterAnimator() {
        Image r0 = this.image;
        if (r0 != null) goto L5;
        return false;
    L5:
        Position r1 = Image.access$000(r0);
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.width > 0.0f) goto L10;
        return false;
    L10:
        if (r1.height <= 0.0f) goto L15;
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
    public /* bridge */ /* synthetic */ Object m115clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        ImageData r6 = (ImageData) r5;
        if (Objects.equals(this.toolStatus, r6.toolStatus) == true) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.image, r6.image) == false) goto L17;
        if (Objects.equals(this.imageList, r6.imageList) == false) goto L17;
        return true;
    }

    public Image findImageByPosition(int r2) {
        List<Image> r0 = this.imageList;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() > 0) goto L7;
        return null;
    L7:
        return (Image) ListProtector.get(this.imageList, r2);
    }

    public void setImage(Image r1) {
        this.image = r1;
    }

    public void setImageList(List<Image> r1) {
        this.imageList = r1;
    }

    public void setToolStatus(ToolStatus r1) {
        this.toolStatus = r1;
    }
}
