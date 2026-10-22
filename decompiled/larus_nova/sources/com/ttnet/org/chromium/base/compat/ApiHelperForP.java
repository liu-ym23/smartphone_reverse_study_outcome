package com.ttnet.org.chromium.base.compat;

import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.LinkProperties;
import android.os.LocaleList;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;

/* JADX INFO: loaded from: classes5.dex */
public final class ApiHelperForP {
    private ApiHelperForP() {
    }

    public static void clearPrimaryClip(ClipboardManager r100) {
    }

    public static TextSelection.Request build(TextSelection.Request.Builder r100) {
        return r100.build();
    }

    public static long getLongVersionCode(PackageInfo r100) {
        return r100.getLongVersionCode();
    }

    public static String getPrivateDnsServerName(LinkProperties r100) {
        return r100.getPrivateDnsServerName();
    }

    public static SignalStrength getSignalStrength(TelephonyManager r100) {
        return r100.getSignalStrength();
    }

    public static boolean isLocationEnabled(LocationManager r100) {
        return r100.isLocationEnabled();
    }

    public static boolean isPrivateDnsActive(LinkProperties r100) {
        return r100.isPrivateDnsActive();
    }

    public static TextSelection.Request.Builder setDefaultLocales(TextSelection.Request.Builder r100, LocaleList r101) {
        return r100.setDefaultLocales(r101);
    }

    public static TextSelection suggestSelection(TextClassifier r100, TextSelection.Request r101) {
        return r100.suggestSelection(r101);
    }

    public static TextSelection.Request.Builder newTextSelectionRequestBuilder(CharSequence r100, int r101, int r102) {
        return new TextSelection.Request.Builder(r100, r101, r102);
    }

    public static boolean hasSigningCertificate(PackageManager r100, String r101, byte[] r102, int r103) {
        return r100.hasSigningCertificate(r101, r102, r103);
    }
}
