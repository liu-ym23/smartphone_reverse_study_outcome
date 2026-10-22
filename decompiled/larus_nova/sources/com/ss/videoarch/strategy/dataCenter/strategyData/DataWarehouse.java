package com.ss.videoarch.strategy.dataCenter.strategyData;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.videoarch.strategy.utils.JNINamespace;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class DataWarehouse {
    private static final String FeatureTableKey = "CategoriesTable";
    private static final String SettingsTableKey = "SettingsTable";
    private static final String TAG = "DataWarehouse";
    private static SharedPreferences sharedPreferences;
    private Context mContext;

    public static class DataWarehouseInstance {
        private static final DataWarehouse mInstance = null;

        private DataWarehouseInstance() {
        }

        static {
            mInstance = new DataWarehouse();
        }

        public static /* synthetic */ DataWarehouse access$000() {
            return mInstance;
        }
    }

    public native String nativeGetDataFromeDisk(String r100);

    public DataWarehouse() {
        this.mContext = null;
    }

    public static DataWarehouse getInstance() {
        return DataWarehouseInstance.access$000();
    }

    public static String getOfflineFeatures() {
        return DataWarehouseInstance.access$000().nativeGetDataFromeDisk(FeatureTableKey);
    }

    public static void init(Context r100) {
        getInstance().mContext = r100;
    }

    public String ReadFromDB(String r100, String r101) {
        Context r102 = this.mContext;
        if (r102 != null) goto L6;
        return "";
    L6:
        if (sharedPreferences != null) goto L8;
        sharedPreferences = r102.getSharedPreferences(r100, 0);
    L8:
        String r103 = sharedPreferences.getString(r101, "");
        r103.length();
        return r103;
    }

    public void WriteToDB(String r100, String r101, String r102) {
        Context r103 = this.mContext;
        if (r103 != null) goto L6;
        return;
    L6:
        if (sharedPreferences != null) goto L8;
        sharedPreferences = r103.getSharedPreferences(r100, 0);
    L8:
        SharedPreferences.Editor r104 = sharedPreferences.edit();
        r104.putString(r101, r102);
        r104.apply();
        r102.length();
    }
}
