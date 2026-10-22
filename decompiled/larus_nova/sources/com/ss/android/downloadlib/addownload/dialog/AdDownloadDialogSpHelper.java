package com.ss.android.downloadlib.addownload.dialog;

import android.text.TextUtils;
import com.ss.android.download.api.model.DelayInstallModel;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
class AdDownloadDialogSpHelper {
    static final String KEY_INSTALLED_LIST = "key_installed_list";
    static final String KEY_UNINSTALLED_LIST = "key_uninstalled_list";

    public AdDownloadDialogSpHelper() {
    }

    public void cleanSpKey(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        GlobalInfo.getContext().getSharedPreferences(r100, 0).edit().putString(r101, "").apply();
        return;
    }

    public CopyOnWriteArrayList<DelayInstallModel> loadInfoFromSp(String r100, String r101) {
        CopyOnWriteArrayList<DelayInstallModel> r102 = new CopyOnWriteArrayList();
        String r103 = GlobalInfo.getContext().getSharedPreferences(r100, 0).getString(r101, "");     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r103) == true) goto L14;
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L12
        Iterator<String> r105 = r104.keys();     // Catch: Exception -> L12
    L7:
        if (r105.hasNext() == false) goto L14;
        JSONObject r106 = r104.optJSONObject(r105.next());     // Catch: Exception -> L12
        DelayInstallModel r107 = DelayInstallModel.Companion.fromJson(r106);     // Catch: Exception -> L12
        if (r107 == null) goto L7;
        r102.add(r107);     // Catch: Exception -> L12
    L14:
        return r102;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public void updateInfoToSp(String r100, String r101, CopyOnWriteArrayList<DelayInstallModel> r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        JSONObject r103 = new JSONObject();
        Iterator<DelayInstallModel> r104 = r102.iterator();     // Catch: Exception -> L12
    L7:
        if (r104.hasNext() == false) goto L14;
        DelayInstallModel r105 = r104.next();     // Catch: Exception -> L12
        if (r105 == null) goto L7;
        r103.put(String.valueOf(r105.getAdId()), r105.toJson());     // Catch: Exception -> L12
    L14:
        GlobalInfo.getContext().getSharedPreferences(r100, 0).edit().putString(r101, r103.toString()).apply();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
