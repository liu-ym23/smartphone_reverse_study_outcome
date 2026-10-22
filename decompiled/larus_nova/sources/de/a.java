package de;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public class a {

    @SerializedName("animated_common_icon_url")
    public String animatedCommonIconUrl;

    @SerializedName("animated_icon_url")
    public String animatedIconUrl;

    @SerializedName("static_icon_url")
    public String staticIconUrl;

    public a() {
    }

    public static a parseFromMap(Map<String, Serializable> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        a r101 = new a();
        Serializable r102 = r100.get("static_icon_url");
        if ((r102 instanceof String) == false) goto L8;
        r101.staticIconUrl = (String) r102;
    L8:
        Serializable r103 = r100.get("animated_icon_url");
        if ((r103 instanceof String) == false) goto L11;
        r101.animatedIconUrl = (String) r103;
    L11:
        Serializable r104 = r100.get("animated_common_icon_url");
        if ((r104 instanceof String) == false) goto L14;
        r101.animatedCommonIconUrl = (String) r104;
    L14:
        return r101;
    }
}
