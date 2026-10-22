package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class CustomJumpDevicePlan extends AbsDevicePlan {
    private final JSONObject mAntiConfig;

    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String r100 = this.mAntiConfig.optString("action");
        String r101 = this.mAntiConfig.optString("category");
        int r102 = this.mAntiConfig.optInt("flags", 1342210048);
        String r103 = this.mAntiConfig.optString("path_extra_key");
        String r104 = this.mAntiConfig.optString("path_data_key");
        JSONObject r105 = this.mAntiConfig.optJSONObject("extra");
        JSONObject r106 = this.mAntiConfig.optJSONObject("extra_type");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        Intent r107 = new Intent(r100);
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r107.addCategory(r101);
    L10:
        if (TextUtils.isEmpty(r104) == false) goto L20;
    L15:
        r107.setFlags(r102);
        if (TextUtils.isEmpty(r103) == true) goto L18;
        r107.putExtra(r103, this.mJumpPath);
    L18:
        putExtra(r107, r105, r106);
        return r107;
    L20:
        r107.setData(UriProtector.parse(String.format(r104, new Object[]{this.mJumpPath})));     // Catch: Throwable -> L14
        goto L15
    }

    private static void putExtra(Intent r100, JSONObject r101, JSONObject r102) {
        if (r101 == null) goto L15;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101.length() != r102.length()) goto L22;
        if (r100 == null) goto L24;
        Iterator<String> r103 = r101.keys();
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.hasNext() == false) goto L25;
        String r104 = r103.next();
        String r105 = r102.optString(r104);
        if (r105 == null) goto L11;
        parseValueAndPut(r101, r104, r105, r100);
        goto L11
    L25:
        return;
    L24:
        return;
    L22:
        return;
    }

    public CustomJumpDevicePlan(Context r100, DownloadSetting r101, String r102, JSONObject r103) {
        super(r100, r101, r102);
        this.mAntiConfig = r103;
    }

    private static void parseValueAndPut(JSONObject r100, String r101, String r102, Intent r103) {
        r102.getClass();
        byte r104 = -1;
        switch(r102.hashCode()) {
            case -1325958191: goto L22;
            case -891985903: goto L18;
            case 104431: goto L14;
            case 3327612: goto L10;
            case 64711720: goto L6;
            default: goto L25;
        };
    L25:
        switch(r104) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L37;
        };
    L27:
        r103.putExtra(r101, r100.optBoolean(r101));
        return;
    L28:
        r103.putExtra(r101, r100.optLong(r101));
        return;
    L29:
        r103.putExtra(r101, r100.optInt(r101));
        return;
    L30:
        r103.putExtra(r101, r100.optString(r101));
        return;
    L31:
        r103.putExtra(r101, r100.optDouble(r101));
        return;
    L37:
        return;
    L6:
        if (r102.equals("boolean") == false) goto L25;
        r104 = 4;
        goto L25
    L10:
        if (r102.equals("long") == false) goto L25;
        r104 = 3;
        goto L25
    L14:
        if (r102.equals("int") == false) goto L25;
        r104 = 2;
        goto L25
    L18:
        if (r102.equals("string") == false) goto L25;
        r104 = 1;
        goto L25
    L22:
        if (r102.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L25;
        r104 = 0;
        goto L25
    }
}
