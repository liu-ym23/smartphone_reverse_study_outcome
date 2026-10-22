package com.lynx.devtool.recorder;

import android.net.Uri;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class QueryMapUtils {
    private final String TAG;
    private HashMap<String, String> mQuery;

    public HashMap<String, String> toMap() {
        HashMap<String, String> r100 = new HashMap();
        r100.putAll(this.mQuery);
        return r100;
    }

    public QueryMapUtils() {
        this.TAG = getClass().toString();
        this.mQuery = new HashMap();
    }

    private String getQueryStringFromUrl(String r100) {
        if (r100.contains("?") == true) goto L5;
        return null;
    L5:
        return r100.split("\\?")[1];
    }

    private void saveQueryToMap(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L19;
        String[] r101 = r100.split("&");
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L20;
        String[] r104 = r101[r103].split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r104.length < 2) goto L14;
        String r105 = r104[0];
        String r106 = r104[1];
        if (r106.startsWith("http") == false) goto L13;
        r106 = Uri.decode(r106);
    L13:
        this.mQuery.put(r105, r106);
    L14:
        r103 = r103 + 1;
        goto L7
    L20:
        return;
    }

    public boolean contains(String r100) {
        return this.mQuery.containsKey(r100);
    }

    public String getString(String r100) {
        return this.mQuery.get(r100);
    }

    public void parse(String r100) {
        saveQueryToMap(getQueryStringFromUrl(r100));
    }

    public boolean getBoolean(String r100, boolean r101) {
        String r102 = this.mQuery.get(r100);
        if (r102 != null) goto L8;
        return r101;
    L8:
        return Boolean.parseBoolean(r102);
    L7:
        return r101;
    }

    public float getFloat(String r100, float r101) {
        if (this.mQuery.containsKey(r100) == false) goto L9;
        String r102 = this.mQuery.get(r100);
        if (r102 != null) goto L11;
        return r101;
    L11:
        return CastFloatProtector.parseFloat(r102);
    L9:
        return r101;
    }

    public int getInt(String r100, int r101) {
        String r102 = this.mQuery.get(r100);
        if (r102 != null) goto L8;
        return r101;
    L8:
        return CastIntegerProtector.parseInt(r102);
    L7:
        return r101;
    }
}
