package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class CleanFolder extends CleanFile {
    public static final String CLEAN_FOLDER = "clean_folder";
    public static final Parcelable.Creator<CleanFolder> CREATOR = null;
    private List<CleanFile> cleanFiles;
    private Map<String, CleanFile> cleanFilesMap;
    private String folderName;
    private boolean isExpand;
    private BaseCleanGroup parent;

    @Override // com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.download.api.clean.CleanFile
    public String getClassifyType() {
        return CLEAN_FOLDER;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.ss.android.download.api.clean.CleanFile
    public String getFolderName() {
        if (TextUtils.isEmpty(this.folderName) == false) goto L6;
        return "其他文件";
    L6:
        return this.folderName;
    }

    public CleanFolder() {
        this.cleanFiles = new ArrayList();
        this.cleanFilesMap = new HashMap();
    }

    @Override // com.ss.android.download.api.clean.BaseCleanItem
    public String getName() {
        String r100 = super.getName();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "其他文件";
    L6:
        return r100;
    }

    @Override // com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public JSONObject toJson() {
        JSONObject r100 = super.toJson();
        r100.put("folder_name", this.folderName);     // Catch: JSONException -> L9
        r100.put("is_expand", this.isExpand);     // Catch: JSONException -> L9
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L9
        Iterator<Map.Entry<String, CleanFile>> r102 = this.cleanFilesMap.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        Map.Entry<String, CleanFile> r103 = r102.next();     // Catch: JSONException -> L9
        r101.put(r103.getKey(), r103.getValue().toJson());     // Catch: JSONException -> L9
        goto L5
    L7:
        r100.put("clean_file_list", r101);     // Catch: JSONException -> L9
    L11:
        return r100;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public List<CleanFile> getCleanFiles() {
        return this.cleanFiles;
    }

    public BaseCleanGroup getParent() {
        return this.parent;
    }

    public boolean isExpand() {
        return this.isExpand;
    }

    public CleanFolder(Parcel r100) {
        super(r100);
        this.cleanFiles = new ArrayList();
        this.cleanFilesMap = new HashMap();
        this.folderName = r100.readString();
        int r101 = 0;
        boolean r102 = true;
        if (r100.readInt() == 1) goto L6;
        r102 = false;
    L6:
        this.isExpand = r102;
        int r103 = r100.readInt();
    L7:
        if (r101 >= r103) goto L19;
        String r104 = r100.readString();
        String r105 = r100.readString();
        if (ApkCleanFile.APK_CLEAN_FILE.equals(r105) == false) goto L12;
        Parcelable r106 = r100.readParcelable(ApkCleanFile.class.getClassLoader());
    L18:
        Map<String, CleanFile> r107 = this.cleanFilesMap;
        r107.put(r104, (CleanFile) r106);
        r101 = r101 + 1;
        goto L7
    L12:
        if (CleanAppCache.CLEAN_APP_CACHE.equals(r105) == false) goto L15;
        r106 = r100.readParcelable(CleanAppCache.class.getClassLoader());
        goto L18
    L15:
        if (CLEAN_FOLDER.equals(r105) == false) goto L17;
        r106 = r100.readParcelable(CleanFolder.class.getClassLoader());
        goto L18
    L17:
        r106 = r100.readParcelable(CleanFile.class.getClassLoader());
        goto L18
    }

    public boolean addCleanFile(CleanFile r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (this.cleanFilesMap.containsKey(r100.absolutePath.toLowerCase()) == true) goto L10;
        this.cleanFilesMap.put(r100.absolutePath.toLowerCase(), r100);
        this.cleanFiles.add(r100);
        this.size += r100.size;
        return true;
    L10:
        return false;
    }

    @Override // com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public void parse(JSONObject r100) {
        if (r100 == null) goto L26;
        super.parse(r100);
        this.folderName = r100.optString("folder_name");
        this.isExpand = r100.optBoolean("is_expand");
        JSONObject r101 = r100.optJSONObject("clean_file_list");
        Iterator<String> r102 = r101.keys();
    L5:
        if (r102.hasNext() == false) goto L34;
        String r103 = r102.next();
        JSONObject r104 = r101.optJSONObject(r103);
        String r105 = r104.optString("classify_type");     // Catch: Exception -> L24
        if (ApkCleanFile.APK_CLEAN_FILE.equals(r105) == false) goto L11;
        CleanFile r106 = new ApkCleanFile();     // Catch: Exception -> L24
    L17:
        r106.parse(r104);     // Catch: Exception -> L24
        if ((r106 instanceof CleanFolder) == true) goto L20;
    L22:
        this.cleanFiles.add(r106);     // Catch: Exception -> L24
        this.cleanFilesMap.put(r103, r106);     // Catch: Exception -> L24
        goto L5
    L20:
        if ((this instanceof BaseCleanGroup) == false) goto L22;
        ((CleanFolder) r106).setParent((BaseCleanGroup) this);     // Catch: Exception -> L24
        goto L22
    L11:
        if (CleanAppCache.CLEAN_APP_CACHE.equals(r105) == false) goto L14;
        r106 = new CleanAppCache();     // Catch: Exception -> L24
        goto L17
    L14:
        if (CLEAN_FOLDER.equals(r105) == false) goto L16;
        r106 = new CleanFolder();     // Catch: Exception -> L24
        goto L17
    L16:
        r106 = new CleanFile();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L5
    L34:
        return;
    }

    @Override // com.ss.android.download.api.clean.BaseCleanItem
    public void setCheck(boolean r100) {
        setCheck(r100, true);
    }

    public void setExpand(boolean r100) {
        this.isExpand = r100;
    }

    @Override // com.ss.android.download.api.clean.CleanFile
    public void setFolderName(String r100) {
        this.folderName = r100;
    }

    public void setParent(BaseCleanGroup r100) {
        this.parent = r100;
    }

    public void removeCleanFile(CleanFile r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == false) goto L6;
        this.cleanFiles.remove(r100);
    L6:
        this.cleanFilesMap.remove(r100.absolutePath.toLowerCase());
        this.size -= r100.size;
    }

    public void setCheck(boolean r100, boolean r101) {
        this.isCheck = r100;
        if (getParent() == null) goto L7;
        if (r101 == false) goto L8;
        getParent().checkSelectedStatus(r100);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.folderName);
        r100.writeInt(this.isExpand ? 1 : 0);
        r100.writeInt(this.cleanFilesMap.size());
        Iterator<Map.Entry<String, CleanFile>> r102 = this.cleanFilesMap.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, CleanFile> r103 = r102.next();
        String r104 = r103.getKey();
        CleanFile r105 = r103.getValue();
        r100.writeString(r104);
        r100.writeString(r105.getClassifyType());
        r100.writeParcelable(r105, 0);
        goto L4
    }
}
