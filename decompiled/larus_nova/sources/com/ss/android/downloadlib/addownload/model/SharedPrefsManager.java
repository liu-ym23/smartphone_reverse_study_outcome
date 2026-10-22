package com.ss.android.downloadlib.addownload.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class SharedPrefsManager {
    private static String TAG = "SharedPrefsManager";

    public static class SingleTonHolder {
        private static SharedPrefsManager INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new SharedPrefsManager(null);
        }

        public static /* synthetic */ SharedPrefsManager access$100() {
            return INSTANCE;
        }
    }

    private SharedPrefsManager() {
    }

    public ConcurrentHashMap<Long, NativeDownloadModel> getAllNativeDownloadModels() {
        ConcurrentHashMap<Long, NativeDownloadModel> r100 = new ConcurrentHashMap();
        Map<String, ?> r101 = getDownloadModelSp().getAll();
        if (r101 != null) goto L5;
        return r100;
    L5:
        Iterator<Map.Entry<String, ?>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, ?> r103 = r102.next();
        if (r103.getValue() == null) goto L7;
        long r104 = CastLongProtector.valueOf(r103.getKey()).longValue();     // Catch: Exception -> L16
        NativeDownloadModel r105 = NativeDownloadModel.fromJson(new JSONObject(String.valueOf(r103.getValue())));     // Catch: Exception -> L16
        if (r104 <= 0) goto L7;
        if (r105 == null) goto L7;
        r100.put(Long.valueOf(r104), r105);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L7
    L18:
        return r100;
    }

    private SharedPreferences getDownloadModelSp() {
        return GlobalInfo.getContext().getSharedPreferences(DownloadConstants.SP_AD_DOWNLOAD_EVENT, 0);
    }

    public static SharedPrefsManager getInstance() {
        return SingleTonHolder.access$100();
    }

    public /* synthetic */ SharedPrefsManager(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ SharedPreferences access$200(SharedPrefsManager r100) {
        return r100.getDownloadModelSp();
    }

    public static List<String> getNativeModelIds(List<NativeDownloadModel> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L20;
        ArrayList r101 = new ArrayList();
        Iterator<NativeDownloadModel> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        NativeDownloadModel r103 = r102.next();
        if (r103 == null) goto L8;
        r101.add(String.valueOf(r103.getId()));
        goto L8
    L12:
        return r101;
    L20:
        return null;
    }

    public void removeNativeDownloadModels(final List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        DownloadComponentManager.getInstance().submitCPUTask(new AnonymousClass2(this, r100), true);
        return;
    }

    public void saveNativeDownloadModel(NativeDownloadModel r100) {
        ArrayList r101 = new ArrayList();
        r101.add(r100);
        saveNativeDownloadModels(r101);
    }

    public synchronized void saveNativeDownloadModels(final Collection<NativeDownloadModel> r100) {
        monitor-enter(this);
        if (r100 != null) goto L15;
    L13:
        monitor-exit(this);
        return;
    L15:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.isEmpty() == true) goto L13;
        DownloadComponentManager.getInstance().submitCPUTask(new AnonymousClass1(this, r100), true);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public static SharedPreferences getSpByName(String r100, int r101) {
        Context r102 = GlobalInfo.getContext();
        if (Build.VERSION.SDK_INT <= 24) goto L11;
        if (r102.isDeviceProtectedStorage() == false) goto L11;
        Context r103 = r102.createDeviceProtectedStorageContext();
        if (r103.moveSharedPreferencesFrom(r102, r100) == true) goto L9;
        Logger.w(TAG, "Failed to migrate shared preferences.");
    L9:
        r102 = r103;
    L11:
        return r102.getSharedPreferences(r100, r101);
    }
}
