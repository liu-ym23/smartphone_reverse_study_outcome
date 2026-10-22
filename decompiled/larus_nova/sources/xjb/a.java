package xjb;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes36.dex */
public class a {

    @SerializedName("areaKey")
    private String areaKey;

    @SerializedName("priority")
    private long priority;

    public a() {
        this("", 0);
    }

    public final String toString() {
        return "AreaInfo{areaKey='" + this.areaKey + "', priority=" + this.priority + '}';
    }

    public final String a() {
        return this.areaKey;
    }

    public a(String r100, long r101) {
        this.areaKey = r100;
        this.priority = r101;
    }
}
