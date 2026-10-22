package com.ss.android.download.api.clean;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ss.android.download.api.utils.ToolUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class CleanAppCache extends BaseCleanGroup {
    public static final String CLEAN_APP_CACHE = "clean_app_cache";
    public static final Parcelable.Creator<CleanAppCache> CREATOR = null;
    private String packageName;

    @Override // com.ss.android.download.api.clean.BaseCleanGroup, com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile
    public String getClassifyType() {
        return CLEAN_APP_CACHE;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.ss.android.download.api.clean.BaseCleanGroup, com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public JSONObject toJson() {
        JSONObject r100 = super.toJson();
        r100.putOpt("package_name", this.packageName);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public CleanAppCache() {
    }

    public String getPackageName() {
        return this.packageName;
    }

    public CleanAppCache(Parcel r100) {
        this.packageName = r100.readString();
    }

    public Drawable getIcon(Context r100) {
        return ToolUtils.getIconByPackageName(r100, this.packageName);
    }

    public String getName(Context r100) {
        String r101 = ToolUtils.getNameByPackageName(r100, this.packageName);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        return r101;
    L6:
        return super.getName();
    }

    @Override // com.ss.android.download.api.clean.BaseCleanGroup, com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public void parse(JSONObject r100) {
        super.parse(r100);
        this.packageName = r100.optString("package_name");
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    @Override // com.ss.android.download.api.clean.BaseCleanGroup, com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.packageName);
    }
}
