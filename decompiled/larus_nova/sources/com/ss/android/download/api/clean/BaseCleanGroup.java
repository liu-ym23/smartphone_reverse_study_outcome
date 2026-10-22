package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class BaseCleanGroup extends CleanFolder {
    public static final Parcelable.Creator<BaseCleanGroup> CREATOR = null;
    List<CleanFolder> cleanFolders;

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public BaseCleanGroup() {
        this.cleanFolders = new ArrayList();
    }

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public JSONObject toJson() {
        JSONObject r100 = super.toJson();
        JSONArray r101 = new JSONArray();
        Iterator<CleanFolder> r102 = this.cleanFolders.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        r101.put(r102.next().toJson());
        goto L4
    L11:
        r100.putOpt("clean_folders", r101);     // Catch: JSONException -> L8
    L10:
        return r100;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public List<CleanFolder> getCleanFolders() {
        return this.cleanFolders;
    }

    public BaseCleanGroup(Parcel r100) {
        super(r100);
        this.cleanFolders = new ArrayList();
        int r101 = r100.readInt();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        CleanFolder r103 = (CleanFolder) r100.readParcelable(CleanFolder.class.getClassLoader());
        this.cleanFolders.add(r103);
        r102 = r102 + 1;
        goto L3
    }

    public void checkSelectedStatus(boolean r100) {
        if (r100 == this.isCheck) goto L5;
        boolean r101 = true;
    L6:
        if (r100 == true) goto L8;
        this.isCheck = false;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (getParent() == null) goto L23;
        getParent().checkSelectedStatus(this.isCheck);
        return;
    L23:
        return;
    L8:
        this.isCheck = true;
        Iterator<CleanFolder> r102 = this.cleanFolders.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        if (r102.next().isCheck() == true) goto L10;
        this.isCheck = false;
        goto L14
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public void parse(JSONObject r100) {
        if (r100 == null) goto L22;
        super.parse(r100);
        JSONArray r101 = r100.optJSONArray("clean_folders");
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.length() <= 0) goto L29;
        int r102 = 0;
    L9:
        if (r102 >= r101.length()) goto L30;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r101, r102);     // Catch: JSONException -> L19
        String r104 = r103.optString("classify_type");     // Catch: JSONException -> L19
        if (ApkCleanFile.APK_CLEAN_FILE.equals(r104) == false) goto L14;
        CleanFolder r105 = new ApkCleanFile();     // Catch: JSONException -> L19
    L17:
        r105.parse(r103);     // Catch: JSONException -> L19
        r105.setParent(this);     // Catch: JSONException -> L19
        this.cleanFolders.add(r105);     // Catch: JSONException -> L19
    L21:
        r102 = r102 + 1;
        goto L9
    L14:
        if (CleanAppCache.CLEAN_APP_CACHE.equals(r104) == false) goto L16;
        r105 = new CleanAppCache();     // Catch: JSONException -> L19
        goto L17
    L16:
        r105 = new CleanFolder();     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L30:
        return;
    L29:
        return;
    }

    @Override // com.ss.android.download.api.clean.CleanFolder
    public void setCheck(boolean r100, boolean r101) {
        Iterator<CleanFolder> r102 = this.cleanFolders.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        CleanFolder r103 = r102.next();
        if (r103 == null) goto L9;
        r103.setCheck(r100, false);
    L9:
        super.setCheck(r100, r101);
    }

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        if (this.cleanFolders != null) goto L5;
        this.cleanFolders = new ArrayList();
    L5:
        r100.writeInt(this.cleanFolders.size());
        Iterator<CleanFolder> r102 = this.cleanFolders.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r100.writeParcelable(r102.next(), 0);
        goto L7
    }
}
