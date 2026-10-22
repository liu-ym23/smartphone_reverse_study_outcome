package de;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public class b {

    @SerializedName("allow_show_cart")
    public boolean allowShowCart;

    public b() {
    }

    public static b parseFromMap(Map<String, Serializable> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        b r101 = new b();
        Serializable r102 = r100.get("allow_show_cart");
        if ((r102 instanceof Boolean) == false) goto L8;
        r101.allowShowCart = ((Boolean) r102).booleanValue();
    L8:
        return r101;
    }
}
