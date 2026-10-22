package com.ss.android.ugc.aweme.filter;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.tools.ToolsUrlModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class FilterBean implements Parcelable, Serializable {
    public static final Parcelable.Creator<FilterBean> CREATOR = null;
    public static final float NONE_INTENSITY = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Uri f450837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f450838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient List<String> f450839c;

    @SerializedName("category_extra")
    private FilterCategoryExtra categoryExtra;

    @SerializedName("filter_category")
    private String categoryKey;
    private String compareKey;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient String f450840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient float f450841e;

    @SerializedName("enter_method")
    private transient String enterMethod;

    @SerializedName("extra")
    private String extra;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient boolean f450842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient boolean f450843g;

    @SerializedName("en_name")
    private String mEnName;

    @SerializedName("filter_file_path")
    private String mFilterFilePath;

    @SerializedName("filter_folder")
    private String mFilterFolder;

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("resource")
    private transient ToolsUrlModel mResource;

    @SerializedName("resource_id")
    private String resId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mId), getCompareKey()});
    }

    public void resetCompareKey() {
        this.compareKey = null;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public List<String> getTags() {
        List<String> r100 = this.f450839c;
        if (r100 == null) goto L9;
        if (r100.isEmpty() == true) goto L9;
        return this.f450839c;
    L9:
        return new ArrayList();
    }

    public String toString() {
        ToolsUrlModel r100 = this.mResource;
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L7:
        return "FilterBean{mId=" + this.mId + ", resId:" + this.resId + ", mName='" + this.mName + "', mEnName='" + this.mEnName + "', mCategory" + this.categoryKey + "', mResource=" + r101 + ", mIndex=0, mThumbnailFileUri=" + this.f450837a + ", mThumbnailFilePath='" + this.f450838b + "', mFilterFilePath='" + this.mFilterFilePath + "', mFilterFolder='" + this.mFilterFolder + "', tags=" + this.f450839c + ", mTagUpdateAt=" + this.f450840d + ", internalDefaultIntensity=" + this.f450841e + ", executeSetFilterFolder=" + this.f450842f + ", isSaveFilter2BeautySequence=" + this.f450843g + ", extra=" + this.extra + ", categoryExtra" + this.categoryExtra + '}';
    L5:
        r101 = "";
        goto L7
    }

    public FilterBean() {
        this.mId = 0;
        this.f450840d = "";
        this.categoryKey = "";
        this.enterMethod = "";
        this.f450841e = -1.0f;
        this.f450842f = false;
        this.f450843g = true;
        this.resId = "";
        this.extra = "";
        this.categoryExtra = new FilterCategoryExtra();
    }

    public FilterCategoryExtra getCategoryExtra() {
        return this.categoryExtra;
    }

    public String getCategoryKey() {
        return this.categoryKey;
    }

    public String getCompareKey() {
        return this.compareKey;
    }

    public String getEnName() {
        return this.mEnName;
    }

    public String getEnterMethod() {
        return this.enterMethod;
    }

    public boolean getExecuteSetFilterFolder() {
        return this.f450842f;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFilterFilePath() {
        return this.mFilterFilePath;
    }

    public String getFilterFolder() {
        return this.mFilterFolder;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getResId() {
        return this.resId;
    }

    public ToolsUrlModel getResource() {
        return this.mResource;
    }

    public String getTagUpdateAt() {
        return this.f450840d;
    }

    public String getThumbnailFilePath() {
        return this.f450838b;
    }

    public Uri getThumbnailFileUri() {
        return this.f450837a;
    }

    public boolean isSaveFilter2BeautySequence() {
        return this.f450843g;
    }

    public FilterBean(Parcel r100) {
        this.mId = 0;
        this.f450840d = "";
        this.categoryKey = "";
        this.enterMethod = "";
        this.f450841e = -1.0f;
        this.f450842f = false;
        this.f450843g = true;
        this.resId = "";
        this.extra = "";
        this.categoryExtra = new FilterCategoryExtra();
        this.mId = r100.readInt();
        this.mName = r100.readString();
        this.mEnName = r100.readString();
        this.mFilterFilePath = r100.readString();
        this.mFilterFolder = r100.readString();
        this.resId = r100.readString();
        this.extra = r100.readString();
        this.f450839c = r100.createStringArrayList();
        this.categoryKey = r100.readString();
        this.mResource = (ToolsUrlModel) r100.readParcelable(ToolsUrlModel.class.getClassLoader());
        this.f450837a = (Uri) r100.readParcelable(Uri.class.getClassLoader());
        this.categoryExtra = (FilterCategoryExtra) r100.readSerializable();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FilterBean) == true) goto L8;
        return false;
    L8:
        FilterBean r101 = (FilterBean) r100;
        if (this.mId == r101.mId) goto L11;
    L15:
        return false;
    L11:
        if (TextUtils.equals(this.categoryKey, r101.categoryKey) == false) goto L15;
        if (TextUtils.equals(getCompareKey(), r101.getCompareKey()) == false) goto L15;
        return true;
    }

    public void setCategoryExtra(FilterCategoryExtra r100) {
        this.categoryExtra = r100;
    }

    public void setCategoryKey(String r100) {
        this.categoryKey = r100;
    }

    public void setCompareKey(String r100) {
        this.compareKey = r100;
    }

    public void setEnName(String r100) {
        this.mEnName = r100;
    }

    public void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public void setExecuteSetFilterFolder(boolean r100) {
        this.f450842f = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setFilterFilePath(String r100) {
        this.mFilterFilePath = r100;
    }

    public void setFilterFolder(String r100) {
        this.mFilterFolder = r100;
    }

    public void setId(int r100) {
        this.mId = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setResId(String r100) {
        this.resId = r100;
    }

    public void setResource(ToolsUrlModel r100) {
        this.mResource = r100;
    }

    public void setSaveFilter2BeautySequence(boolean r100) {
        this.f450843g = r100;
    }

    public void setTagUpdateAt(String r100) {
        this.f450840d = r100;
    }

    public void setTags(List<String> r100) {
        this.f450839c = r100;
    }

    public void setThumbnailFilePath(String r100) {
        this.f450838b = r100;
    }

    public void setThumbnailFileUri(Uri r100) {
        this.f450837a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mId);
        r100.writeString(this.mName);
        r100.writeString(this.mEnName);
        r100.writeString(this.mFilterFilePath);
        r100.writeString(this.mFilterFolder);
        r100.writeString(this.resId);
        r100.writeString(this.extra);
        r100.writeStringList(this.f450839c);
        r100.writeString(this.categoryKey);
        r100.writeParcelable(this.mResource, r101);
        r100.writeParcelable(this.f450837a, r101);
        r100.writeSerializable(this.categoryExtra);
    }
}
