package com.bytedance.bmmt;

import android.content.Context;
import android.content.SharedPreferences;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bmmt.base.ContextUtils;
import com.bytedance.bmmt.base.Logging;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes46.dex */
public class PreferencesHelper {
    private static final String BMMT_PREFERENCE = "bmmt_preference";
    public static final String ONER_RTC_PREFERENCE = "oner_rtc_preference";
    public static final String PREF_CONFIGURE = "pref_configure";
    public static final String PREF_FEEDBACK = "pref_rtc_feedback_data";
    public static final String PREF_HOST_RTT_HISTORY = "pref_host_rtt_history";
    private static final String TAG = "PreferencesHelper";
    private static volatile PreferencesHelper sInstance;
    private final SharedPreferences mSharedPreferences;

    private void clearCache() {
        this.mSharedPreferences.edit().clear().commit();
    }

    private static PreferencesHelper getInstance() {
        return instance(ContextUtils.getApplicationContext());
    }

    private PreferencesHelper(Context r100) {
        this.mSharedPreferences = r100.getSharedPreferences(BMMT_PREFERENCE, 0);
    }

    public static PreferencesHelper instance(Context r100) {
    L20:
        return null;
    L3:
        if (sInstance != null) goto L19;
        monitor-enter(PreferencesHelper.class);     // Catch: OutOfMemoryError -> L20
        if (r100 == null) goto L15;
        if (sInstance != null) goto L10;
        sInstance = new PreferencesHelper(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(PreferencesHelper.class);     // Catch: Throwable -> L12
        goto L19
    L15:
        throw new RuntimeException("unable to init RtcPreferences without context");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: OutOfMemoryError -> L20
    L19:
        return sInstance;
    }

    public void remove(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SharedPreferences.Editor r101 = this.mSharedPreferences.edit();
        r101.remove(r100);
        r101.apply();
    }

    public int getInt(String r100, int r101) {
        return this.mSharedPreferences.getInt(r100, r101);
    }

    public String getString(String r100, String r101) {
        String r102 = this.mSharedPreferences.getString(r100, r101);
        r102.getBytes(XML.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L5
        return r102;
    L5:
        e = move-exception;
        Logging.e(TAG, "Unable to get bytes use utf-8", e);
        return "";
    }

    public void putInt(String r100, int r101) {
        SharedPreferences.Editor r102 = this.mSharedPreferences.edit();
        r102.putInt(r100, r101);
        r102.apply();
    }

    public void putString(String r100, String r101) {
        SharedPreferences.Editor r102 = this.mSharedPreferences.edit();
        r102.putString(r100, r101);
        r102.apply();
    }
}
