package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class CleanType extends BaseCleanGroup {
    public static final Parcelable.Creator<CleanType> CREATOR = null;
    private Map<String, CleanAppCache> appCacheItems;
    private int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int APK = -1;
        public static final int CACHE = -3;
        public static final int LOG = -2;
        public static final int OTHERS = -5;
        public static final int REMAIN = -4;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.BaseCleanItem
    public String getName() {
        int r100 = this.type;
        if (r100 != (-5)) goto L5;
        return "系统盘垃圾";
    L5:
        if (r100 != (-4)) goto L7;
        return "卸载残留垃圾";
    L7:
        if (r100 != (-3)) goto L9;
        return "应用缓存垃圾";
    L9:
        if (r100 != (-2)) goto L11;
        return "广告垃圾";
    L11:
        if (r100 == (-1)) goto L14;
        return "";
    L14:
        return "无用的安装包";
    }

    public CleanType() {
        this.appCacheItems = new HashMap();
    }

    @Override // com.ss.android.download.api.clean.BaseCleanGroup, com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public JSONObject toJson() {
        JSONObject r100 = super.toJson();
        r100.putOpt("type", Integer.valueOf(this.type));     // Catch: JSONException -> L13
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L13
        Iterator<Map.Entry<String, CleanAppCache>> r102 = this.appCacheItems.entrySet().iterator();     // Catch: JSONException -> L13
    L5:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, CleanAppCache> r103 = r102.next();     // Catch: JSONException -> L13
        r101.putOpt(r103.getKey(), r103.getValue().toJson());     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L13
        goto L5
    L11:
        r100.putOpt("app_cache_list", r101);     // Catch: JSONException -> L13
    L15:
        return r100;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public Map<String, CleanAppCache> getAppCacheItems() {
        return this.appCacheItems;
    }

    public int getType() {
        return this.type;
    }

    public CleanType(Parcel r100) {
        super(r100);
        this.appCacheItems = new HashMap();
        this.type = r100.readInt();
        int r101 = r100.readInt();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        String r103 = r100.readString();
        CleanAppCache r104 = (CleanAppCache) r100.readParcelable(CleanAppCache.class.getClassLoader());
        this.appCacheItems.put(r103, r104);
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.ss.android.download.api.clean.BaseCleanGroup, com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public void parse(JSONObject r100) {
        super.parse(r100);
        this.type = r100.optInt("type");
        JSONObject r101 = r100.optJSONObject("app_cache_list");
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L12;
        Iterator<String> r102 = r101.keys();
    L8:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        JSONObject r104 = r101.optJSONObject(r103);
        CleanAppCache r105 = new CleanAppCache();
        r105.parse(r104);
        this.appCacheItems.put(r103, r105);
        goto L8
    L13:
        return;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    @Override // com.ss.android.download.api.clean.BaseCleanGroup, com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.type);
        r100.writeInt(this.appCacheItems.size());
        Iterator<Map.Entry<String, CleanAppCache>> r102 = this.appCacheItems.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, CleanAppCache> r103 = r102.next();
        String r104 = r103.getKey();     // Catch: Exception -> L8
        CleanAppCache r105 = r103.getValue();     // Catch: Exception -> L8
        r100.writeString(r104);     // Catch: Exception -> L8
        r100.writeParcelable(r105, 0);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }
}
