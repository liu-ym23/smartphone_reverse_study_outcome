package com.ss.android.ugc.aweme.tools;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class ToolsUrlModel implements Parcelable {
    public static final Parcelable.Creator<ToolsUrlModel> CREATOR = null;

    @SerializedName("uri")
    protected String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected List<String> urlList;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public final int hashCode() {
        return (this.uri.hashCode() * 31) + this.urlList.hashCode();
    }

    public final String toString() {
        return "ToolsUrlModel{uri='" + this.uri + "', urlList=" + this.urlList + '}';
    }

    public ToolsUrlModel() {
    }

    public ToolsUrlModel(Parcel r100) {
        this.uri = r100.readString();
        this.urlList = r100.createStringArrayList();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L15;
        ToolsUrlModel r101 = (ToolsUrlModel) r100;
        if (this.uri.equals(r101.uri) == true) goto L14;
        return false;
    L14:
        return this.urlList.equals(r101.urlList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.uri);
        r100.writeStringList(this.urlList);
    }
}
