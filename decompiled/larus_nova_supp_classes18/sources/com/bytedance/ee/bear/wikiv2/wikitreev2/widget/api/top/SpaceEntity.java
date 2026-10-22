package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004XYZ[B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010O\u001a\u00020\u0007H\u0016J\u0018\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0007H\u0016J\u0010\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020SH\u0002J\b\u0010W\u001a\u00020\u0000H\u0014R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R \u0010+\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR \u0010.\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR \u00101\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001e\u00104\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\t\"\u0004\b6\u0010\u000bR\u001e\u00107\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011R\u001e\u0010:\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R \u0010=\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010\u001dR \u0010@\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\t\"\u0004\bH\u0010\u000bR \u0010I\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001b\"\u0004\bK\u0010\u001dR \u0010L\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001b\"\u0004\bN\u0010\u001d¨\u0006\\"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "<init>", "()V", "canSetSecLabel", "", "getCanSetSecLabel", "()I", "setCanSetSecLabel", "(I)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "editTime", "getEditTime", "setEditTime", "editUid", "", "getEditUid", "()Ljava/lang/String;", "setEditUid", "(Ljava/lang/String;)V", "extra", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityExtra;", "getExtra", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityExtra;", "setExtra", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityExtra;)V", "isPined", "", "()Z", "setPined", "(Z)V", "isStared", "setStared", "name", "getName", "setName", "objToken", "getObjToken", "setObjToken", "ownerId", "getOwnerId", "setOwnerId", "ownerType", "getOwnerType", "setOwnerType", "pinTime", "getPinTime", "setPinTime", "secretKeyDelete", "getSecretKeyDelete", "setSecretKeyDelete", "thumbnail", "getThumbnail", "setThumbnail", "thumbnailExtra", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityThumbnailExtra;", "getThumbnailExtra", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityThumbnailExtra;", "setThumbnailExtra", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityThumbnailExtra;)V", ResourceData.KEY_TYPE, "getType", "setType", ResourceData.KEY_URL, "getUrl", "setUrl", "icon", "getIcon", "setIcon", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "readFromParcel", "parcel", "clone", "CREATOR", "SpaceEntityExtra", "SpaceEntityDisplayTag", "SpaceEntityThumbnailExtra", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceEntity implements NonProguard, Parcelable, Cloneable {
    public static final a CREATOR = null;
    private static final String TAG = "SpaceEntity";

    @SerializedName("can_set_sec_label")
    private int canSetSecLabel;

    @SerializedName("create_time")
    private long createTime;

    @SerializedName("delete_flag")
    private int deleteFlag;

    @SerializedName("edit_time")
    private long editTime;

    @SerializedName("edit_uid")
    private String editUid;

    @SerializedName("extra")
    private SpaceEntityExtra extra;

    @SerializedName("icon_info")
    private String icon;

    @SerializedName("is_pined")
    private boolean isPined;

    @SerializedName("is_stared")
    private boolean isStared;

    @SerializedName("name")
    private String name;

    @SerializedName(ResourceData.KEY_OBJ_TOKEN)
    private String objToken;

    @SerializedName("owner_id")
    private String ownerId;

    @SerializedName("owner_type")
    private int ownerType;

    @SerializedName("pin_time")
    private long pinTime;

    @SerializedName("secret_key_delete")
    private boolean secretKeyDelete;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("thumbnail_extra")
    private SpaceEntityThumbnailExtra thumbnailExtra;

    @SerializedName(ResourceData.KEY_TYPE)
    private int type;

    @SerializedName(ResourceData.KEY_URL)
    private String url;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0000H\u0014R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityDisplayTag;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "<init>", "()V", "objectTagType", "", "getObjectTagType", "()I", "setObjectTagType", "(I)V", "tagValue", "", "getTagValue", "()Ljava/lang/String;", "setTagValue", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "readFromParcel", "parcel", "clone", "CREATOR", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SpaceEntityDisplayTag implements NonProguard, Parcelable, Cloneable {
        public static final a CREATOR = null;

        @SerializedName("ObjectTagType")
        private int objectTagType;

        @SerializedName("tag_value")
        private String tagValue;

        public static final class a implements Parcelable.Creator<SpaceEntityDisplayTag> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceEntityDisplayTag createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "source");
                SpaceEntityDisplayTag r0 = new SpaceEntityDisplayTag();
                SpaceEntityDisplayTag.access$readFromParcel(r0, r2);
                return r0;
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceEntityDisplayTag[] newArray(int r1) {
                return new SpaceEntityDisplayTag[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public SpaceEntityDisplayTag() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SpaceEntityDisplayTag clone() {
            SpaceEntityDisplayTag r0 = new SpaceEntityDisplayTag();
            Object r1 = super.clone();     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SpaceEntity.SpaceEntityDisplayTag");     // Catch: Exception -> L5
            return (SpaceEntityDisplayTag) r1;
        L5:
            e = move-exception;
            tt5.a.d(SpaceEntity.TAG, "clone SpaceEntityDisplayTag fail. " + e);
            return r0;
        }

        public final int getObjectTagType() {
            return this.objectTagType;
        }

        public final String getTagValue() {
            return this.tagValue;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m705clone() {
            return clone();
        }

        private final void readFromParcel(Parcel r2) {
            this.objectTagType = r2.readInt();
            this.tagValue = r2.readString();
        }

        public final void setObjectTagType(int r1) {
            this.objectTagType = r1;
        }

        public final void setTagValue(String r1) {
            this.tagValue = r1;
        }

        public static final /* synthetic */ void access$readFromParcel(SpaceEntityDisplayTag r0, Parcel r1) {
            r0.readFromParcel(r1);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeInt(this.objectTagType);
            r1.writeString(this.tagValue);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u0000H\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityExtra;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "<init>", "()V", "displayTag", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityDisplayTag;", "getDisplayTag", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityDisplayTag;", "setDisplayTag", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityDisplayTag;)V", "isExternal", "", "()Z", "setExternal", "(Z)V", "templateType", "", "getTemplateType", "()I", "setTemplateType", "(I)V", "bizType", "getBizType", "setBizType", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "readFromParcel", "parcel", "clone", "CREATOR", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SpaceEntityExtra implements NonProguard, Parcelable, Cloneable {
        public static final a CREATOR = null;

        @SerializedName("biz_type")
        private int bizType;

        @SerializedName("display_tag")
        private SpaceEntityDisplayTag displayTag;

        @SerializedName("is_external")
        private boolean isExternal;

        @SerializedName("template_type")
        private int templateType;

        public static final class a implements Parcelable.Creator<SpaceEntityExtra> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceEntityExtra createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "source");
                SpaceEntityExtra r0 = new SpaceEntityExtra();
                SpaceEntityExtra.access$readFromParcel(r0, r2);
                return r0;
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceEntityExtra[] newArray(int r1) {
                return new SpaceEntityExtra[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SpaceEntityExtra clone() {
            SpaceEntityExtra r0 = new SpaceEntityExtra();
            Object r1 = super.clone();     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SpaceEntity.SpaceEntityExtra");     // Catch: Exception -> L5
            return (SpaceEntityExtra) r1;
        L5:
            e = move-exception;
            tt5.a.d(SpaceEntity.TAG, "clone SpaceEntityExtra fail. " + e);
            return r0;
        }

        public SpaceEntityExtra() {
            this.bizType = -1;
        }

        public final int getBizType() {
            return this.bizType;
        }

        public final SpaceEntityDisplayTag getDisplayTag() {
            return this.displayTag;
        }

        public final int getTemplateType() {
            return this.templateType;
        }

        public final boolean isExternal() {
            return this.isExternal;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m706clone() {
            return clone();
        }

        private final void readFromParcel(Parcel r2) {
            this.displayTag = (SpaceEntityDisplayTag) r2.readParcelable(SpaceEntityDisplayTag.class.getClassLoader());
            if (r2.readByte() == 0) goto L5;
            boolean r0 = true;
        L6:
            this.isExternal = r0;
            this.templateType = r2.readInt();
            this.bizType = r2.readInt();
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final void setBizType(int r1) {
            this.bizType = r1;
        }

        public final void setDisplayTag(SpaceEntityDisplayTag r1) {
            this.displayTag = r1;
        }

        public final void setExternal(boolean r1) {
            this.isExternal = r1;
        }

        public final void setTemplateType(int r1) {
            this.templateType = r1;
        }

        public static final /* synthetic */ void access$readFromParcel(SpaceEntityExtra r0, Parcel r1) {
            r0.readFromParcel(r1);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "dest");
            r2.writeParcelable(this.displayTag, r3);
            r2.writeByte(this.isExternal ? 1 : 0);
            r2.writeInt(this.templateType);
            r2.writeInt(this.bizType);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u0000H\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/top/SpaceEntity$SpaceEntityThumbnailExtra;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "<init>", "()V", "nonce", "", "getNonce", "()Ljava/lang/String;", "setNonce", "(Ljava/lang/String;)V", "secret", "getSecret", "setSecret", ResourceData.KEY_TYPE, "", "getType", "()I", "setType", "(I)V", ResourceData.KEY_URL, "getUrl", "setUrl", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "readFromParcel", "parcel", "clone", "CREATOR", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SpaceEntityThumbnailExtra implements NonProguard, Parcelable, Cloneable {
        public static final a CREATOR = null;

        @SerializedName("nonce")
        private String nonce;

        @SerializedName("secret")
        private String secret;

        @SerializedName(ResourceData.KEY_TYPE)
        private int type;

        @SerializedName(ResourceData.KEY_URL)
        private String url;

        public static final class a implements Parcelable.Creator<SpaceEntityThumbnailExtra> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceEntityThumbnailExtra createFromParcel(Parcel r2) {
                Intrinsics.checkNotNullParameter(r2, "source");
                SpaceEntityThumbnailExtra r0 = new SpaceEntityThumbnailExtra();
                SpaceEntityThumbnailExtra.access$readFromParcel(r0, r2);
                return r0;
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceEntityThumbnailExtra[] newArray(int r1) {
                return new SpaceEntityThumbnailExtra[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public SpaceEntityThumbnailExtra() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SpaceEntityThumbnailExtra clone() {
            SpaceEntityThumbnailExtra r0 = new SpaceEntityThumbnailExtra();
            Object r1 = super.clone();     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SpaceEntity.SpaceEntityThumbnailExtra");     // Catch: Exception -> L5
            return (SpaceEntityThumbnailExtra) r1;
        L5:
            e = move-exception;
            tt5.a.d(SpaceEntity.TAG, "clone SpaceEntityThumbnailExtra fail. " + e);
            return r0;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getSecret() {
            return this.secret;
        }

        public final int getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m707clone() {
            return clone();
        }

        private final void readFromParcel(Parcel r2) {
            this.nonce = r2.readString();
            this.secret = r2.readString();
            this.type = r2.readInt();
            this.url = r2.readString();
        }

        public final void setNonce(String r1) {
            this.nonce = r1;
        }

        public final void setSecret(String r1) {
            this.secret = r1;
        }

        public final void setType(int r1) {
            this.type = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }

        public static final /* synthetic */ void access$readFromParcel(SpaceEntityThumbnailExtra r0, Parcel r1) {
            r0.readFromParcel(r1);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeString(this.nonce);
            r1.writeString(this.secret);
            r1.writeInt(this.type);
            r1.writeString(this.url);
        }
    }

    public static final class a implements Parcelable.Creator<SpaceEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            SpaceEntity r0 = new SpaceEntity();
            SpaceEntity.access$readFromParcel(r0, r2);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceEntity[] newArray(int r1) {
            return new SpaceEntity[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SpaceEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SpaceEntity clone() {
        SpaceEntity r0 = new SpaceEntity();
        Object r1 = super.clone();     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SpaceEntity");     // Catch: Exception -> L5
        return (SpaceEntity) r1;
    L5:
        e = move-exception;
        tt5.a.d(TAG, "clone SpaceEntity fail. " + e);
        return r0;
    }

    public final int getCanSetSecLabel() {
        return this.canSetSecLabel;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final int getDeleteFlag() {
        return this.deleteFlag;
    }

    public final long getEditTime() {
        return this.editTime;
    }

    public final String getEditUid() {
        return this.editUid;
    }

    public final SpaceEntityExtra getExtra() {
        return this.extra;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final int getOwnerType() {
        return this.ownerType;
    }

    public final long getPinTime() {
        return this.pinTime;
    }

    public final boolean getSecretKeyDelete() {
        return this.secretKeyDelete;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final SpaceEntityThumbnailExtra getThumbnailExtra() {
        return this.thumbnailExtra;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isPined() {
        return this.isPined;
    }

    public final boolean isStared() {
        return this.isStared;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m704clone() {
        return clone();
    }

    private final void readFromParcel(Parcel r6) {
        this.canSetSecLabel = r6.readInt();
        this.createTime = r6.readLong();
        this.deleteFlag = r6.readInt();
        this.editTime = r6.readLong();
        this.editUid = r6.readString();
        this.extra = (SpaceEntityExtra) r6.readParcelable(SpaceEntityExtra.class.getClassLoader());
        boolean r1 = true;
        if (r6.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.isPined = r0;
        if (r6.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.isStared = r2;
        this.name = r6.readString();
        this.objToken = r6.readString();
        this.ownerId = r6.readString();
        this.ownerType = r6.readInt();
        this.pinTime = r6.readLong();
        if (r6.readByte() != 0) goto L14;
        r1 = false;
    L14:
        this.secretKeyDelete = r1;
        this.thumbnail = r6.readString();
        this.thumbnailExtra = (SpaceEntityThumbnailExtra) r6.readParcelable(SpaceEntityThumbnailExtra.class.getClassLoader());
        this.type = r6.readInt();
        this.url = r6.readString();
        this.icon = r6.readString();
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final void setCanSetSecLabel(int r1) {
        this.canSetSecLabel = r1;
    }

    public final void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public final void setDeleteFlag(int r1) {
        this.deleteFlag = r1;
    }

    public final void setEditTime(long r1) {
        this.editTime = r1;
    }

    public final void setEditUid(String r1) {
        this.editUid = r1;
    }

    public final void setExtra(SpaceEntityExtra r1) {
        this.extra = r1;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setObjToken(String r1) {
        this.objToken = r1;
    }

    public final void setOwnerId(String r1) {
        this.ownerId = r1;
    }

    public final void setOwnerType(int r1) {
        this.ownerType = r1;
    }

    public final void setPinTime(long r1) {
        this.pinTime = r1;
    }

    public final void setPined(boolean r1) {
        this.isPined = r1;
    }

    public final void setSecretKeyDelete(boolean r1) {
        this.secretKeyDelete = r1;
    }

    public final void setStared(boolean r1) {
        this.isStared = r1;
    }

    public final void setThumbnail(String r1) {
        this.thumbnail = r1;
    }

    public final void setThumbnailExtra(SpaceEntityThumbnailExtra r1) {
        this.thumbnailExtra = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public static final /* synthetic */ void access$readFromParcel(SpaceEntity r0, Parcel r1) {
        r0.readFromParcel(r1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.canSetSecLabel);
        r3.writeLong(this.createTime);
        r3.writeInt(this.deleteFlag);
        r3.writeLong(this.editTime);
        r3.writeString(this.editUid);
        r3.writeParcelable(this.extra, r4);
        r3.writeByte(this.isPined ? 1 : 0);
        r3.writeByte(this.isStared ? 1 : 0);
        r3.writeString(this.name);
        r3.writeString(this.objToken);
        r3.writeString(this.ownerId);
        r3.writeInt(this.ownerType);
        r3.writeLong(this.pinTime);
        r3.writeByte(this.secretKeyDelete ? 1 : 0);
        r3.writeString(this.thumbnail);
        r3.writeParcelable(this.thumbnailExtra, r4);
        r3.writeInt(this.type);
        r3.writeString(this.url);
        r3.writeString(this.icon);
    }
}
