package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class CleanFile extends BaseCleanItem {
    public static final String CLEAN_FILE = "clean_file";
    public static final Parcelable.Creator<CleanFile> CREATOR = null;
    private String classifyType;
    private String folderName;
    private boolean isEmptyFolder;
    private String parentFolderPath;

    @Override // com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public CleanFile() {
        this.classifyType = CLEAN_FILE;
    }

    @Override // com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public JSONObject toJson() {
        JSONObject r100 = super.toJson();
        r100.putOpt("parent_folder_path", this.parentFolderPath);     // Catch: JSONException -> L5
        r100.putOpt("folder_name", this.folderName);     // Catch: JSONException -> L5
        r100.putOpt("is_empty_folder", Boolean.valueOf(this.isEmptyFolder));     // Catch: JSONException -> L5
        r100.putOpt("classify_type", getClassifyType());     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String getClassifyType() {
        return this.classifyType;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public String getParentFolderPath() {
        return this.parentFolderPath;
    }

    public boolean isEmptyFolder() {
        return this.isEmptyFolder;
    }

    public CleanFile(Parcel r100) {
        this.classifyType = CLEAN_FILE;
        this.parentFolderPath = r100.readString();
        this.folderName = r100.readString();
        boolean r101 = true;
        if (r100.readInt() == 1) goto L6;
        r101 = false;
    L6:
        this.isEmptyFolder = r101;
        this.classifyType = r100.readString();
    }

    @Override // com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public void parse(JSONObject r100) {
        super.parse(r100);
        this.parentFolderPath = r100.optString("parent_folder_path");
        this.folderName = r100.optString("folder_name");
        this.isEmptyFolder = r100.optBoolean("is_empty_folder");
        this.classifyType = r100.optString("classify_type");
    }

    public void setEmptyFolder(boolean r100) {
        this.isEmptyFolder = r100;
    }

    public void setFolderName(String r100) {
        this.folderName = r100;
    }

    public void setParentFolderPath(String r100) {
        this.parentFolderPath = r100;
    }

    @Override // com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.parentFolderPath);
        r100.writeString(this.folderName);
        r100.writeInt(this.isEmptyFolder ? 1 : 0);
        r100.writeString(this.classifyType);
    }
}
