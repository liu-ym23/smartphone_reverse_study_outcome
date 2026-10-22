package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\"B5\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u0010\u001a\u00020\bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R\u001a\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001e\u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/ContentTag;", "Ljava/io/Serializable;", "", "hasConsumed", "", "component1", "Lcom/bytedance/locallife/model/poi/resp/AttitudeTag;", "component2", "", "component3", "component4", "tagType", "attitudeTag", "consumerExperienceTag", "consumerExperienceTagType", "copy", "toString", "hashCode", "", "other", "equals", "I", "getTagType", "()I", "Lcom/bytedance/locallife/model/poi/resp/AttitudeTag;", "getAttitudeTag", "()Lcom/bytedance/locallife/model/poi/resp/AttitudeTag;", "Ljava/lang/String;", "getConsumerExperienceTag", "()Ljava/lang/String;", "getConsumerExperienceTagType", "<init>", "(ILcom/bytedance/locallife/model/poi/resp/AttitudeTag;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class ContentTag implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("attitude_tag")
    private final AttitudeTag attitudeTag;

    @SerializedName("consumer_experience_tag")
    private final String consumerExperienceTag;

    @SerializedName("consumer_experience_tag_type")
    private final String consumerExperienceTagType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    private final int tagType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ContentTag() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ ContentTag copy$default(ContentTag r100, int r101, AttitudeTag r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.tagType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.attitudeTag;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.consumerExperienceTag;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.consumerExperienceTagType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.tagType;
    }

    public final AttitudeTag component2() {
        return this.attitudeTag;
    }

    public final String component3() {
        return this.consumerExperienceTag;
    }

    public final String component4() {
        return this.consumerExperienceTagType;
    }

    public final ContentTag copy(int r100, AttitudeTag r101, String r102, String r103) {
        return new ContentTag(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContentTag) == true) goto L8;
        return false;
    L8:
        ContentTag r101 = (ContentTag) r100;
        if (this.tagType == r101.tagType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attitudeTag, r101.attitudeTag) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.consumerExperienceTag, r101.consumerExperienceTag) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.consumerExperienceTagType, r101.consumerExperienceTagType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.tagType * 31;
        AttitudeTag r101 = this.attitudeTag;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.consumerExperienceTag;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.consumerExperienceTagType;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ContentTag(tagType=" + this.tagType + ", attitudeTag=" + this.attitudeTag + ", consumerExperienceTag=" + this.consumerExperienceTag + ", consumerExperienceTagType=" + this.consumerExperienceTagType + ')';
    }

    public final boolean hasConsumed() {
        if (this.tagType != ContentTagType.CONSUMER_EXPERIENCE.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final AttitudeTag getAttitudeTag() {
        return this.attitudeTag;
    }

    public final String getConsumerExperienceTag() {
        return this.consumerExperienceTag;
    }

    public final String getConsumerExperienceTagType() {
        return this.consumerExperienceTagType;
    }

    public final int getTagType() {
        return this.tagType;
    }

    public ContentTag(int r100, AttitudeTag r101, String r102, String r103) {
        this.tagType = r100;
        this.attitudeTag = r101;
        this.consumerExperienceTag = r102;
        this.consumerExperienceTagType = r103;
    }

    public /* synthetic */ ContentTag(int r100, AttitudeTag r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
