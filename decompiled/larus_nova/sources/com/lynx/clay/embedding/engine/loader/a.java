package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f380742a = null;

    static {
        f380742a = FlutterLoader.class.getName().concat(".flutter-assets-dir");
    }

    public static b a(Context r100) {
        ApplicationInfo r101 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L34
        if (Build.VERSION.SDK_INT < 23) goto L6;
        NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    L6:
        Bundle r102 = r101.metaData;
        String r103 = f380742a;
        String r104 = null;
        if (r102 != null) goto L9;
        String r105 = null;
    L10:
        Bundle r106 = r101.metaData;
        if (r106 == null) goto L28;
        int r107 = r106.getInt("com.lynx.clay.network-policy", 0);
        if (r107 <= 0) goto L28;
        JSONArray r108 = new JSONArray();
        XmlResourceParser r109 = r100.getResources().getXml(r107);     // Catch: Throwable -> L27
        r109.next();     // Catch: Throwable -> L27
        int r110 = r109.getEventType();     // Catch: Throwable -> L27
    L18:
        if (r110 == 1) goto L26;
        if (r110 != 2) goto L24;
        if (r109.getName().equals("domain-config") == false) goto L24;
        b(r109, r108, false);     // Catch: Throwable -> L27
    L24:
        r110 = r109.next();     // Catch: Throwable -> L27
        goto L18
    L26:
        r104 = r108.toString();
    L28:
        String r111 = r101.nativeLibraryDir;
        Bundle r112 = r101.metaData;
        if (r112 == null) goto L33;
        r112.getBoolean("com.lynx.clay.automatically-register-plugins", true);
    L33:
        return new b(r105, r104, r111);
    L9:
        r105 = r102.getString(r103, null);
    L34:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void b(XmlResourceParser r100, JSONArray r101, boolean r102) throws IOException, XmlPullParserException {
        boolean r103 = r100.getAttributeBooleanValue(null, "cleartextTrafficPermitted", r102);
    L3:
        int r104 = r100.next();
        if (r104 == 2) goto L6;
        if (r104 != 3) goto L3;
        return;
    L6:
        if (r100.getName().equals("domain") == true) goto L7;
        if (r100.getName().equals("domain-config") == true) goto L18;
        String r105 = r100.getName();
        int r106 = r100.getEventType();
    L20:
        if (r106 != 3) goto L23;
        if (r100.getName() == r105) goto L3;
    L23:
        r106 = r100.next();
        goto L20
    L18:
        b(r100, r101, r103);
        goto L3
    L7:
        boolean r107 = r100.getAttributeBooleanValue(null, "includeSubdomains", false);
        r100.next();
        if (r100.getEventType() != 4) goto L15;
        String r108 = r100.getText().trim();
        JSONArray r109 = new JSONArray();
        r109.put(r108);
        r109.put(r107);
        r109.put(r103);
        r101.put(r109);
        r100.next();
        if (r100.getEventType() == 3) goto L3;
        throw new IllegalStateException("Expected end of domain tag");
    L15:
        throw new IllegalStateException("Expected text");
    }
}
