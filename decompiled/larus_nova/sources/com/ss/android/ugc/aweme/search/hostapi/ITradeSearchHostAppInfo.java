package com.ss.android.ugc.aweme.search.hostapi;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H&J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\u0016H&J\b\u0010\u001b\u001a\u00020\u0016H&J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H&J\b\u0010\u001e\u001a\u00020\u0016H&J\b\u0010\u001f\u001a\u00020\u0016H\u0016¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostAppInfo;", "", "getAppId", "", "getAppLaunchTime", "", "getAppVersionName", "getApplicationContext", "Landroid/content/Context;", "getBussinessVersionName", "getCurrentActivity", "Landroid/app/Activity;", "getCurrentFontScale", "", "()Ljava/lang/Float;", "getGeckoOnlineKey", "getGeckoTestKey", "getServerDeviceId", "getServerTime", "()Ljava/lang/Long;", "getUpdateVersionCode", "isAppInBackground", "", "isAweme", "isDebug", "isGuestMode", "isInHouse", "isLargeFontMode", "isLegou", "isLocalTest", "isNightMode", "isSaas", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ITradeSearchHostAppInfo {
    String getAppId();

    long getAppLaunchTime();

    String getAppVersionName();

    Context getApplicationContext();

    String getBussinessVersionName();

    Activity getCurrentActivity();

    Float getCurrentFontScale();

    String getGeckoOnlineKey();

    String getGeckoTestKey();

    String getServerDeviceId();

    Long getServerTime();

    String getUpdateVersionCode();

    boolean isAppInBackground();

    boolean isAweme();

    boolean isDebug();

    boolean isGuestMode();

    boolean isInHouse();

    boolean isLargeFontMode();

    boolean isLegou();

    boolean isLocalTest();

    boolean isNightMode();

    boolean isSaas();
}
