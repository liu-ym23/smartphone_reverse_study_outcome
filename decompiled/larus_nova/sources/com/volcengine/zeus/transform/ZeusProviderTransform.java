package com.volcengine.zeus.transform;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.core.app.NotificationCompat;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.provider.ContentProviderManager;
import com.volcengine.zeus.provider.a;
import com.volcengine.zeus.util.MethodUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class ZeusProviderTransform {
    public ZeusProviderTransform() {
    }

    public static String getType(Object r100, Uri r101, String r102) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return (String) MethodUtils.invokeMethod(r100, "getType", new Object[]{r101}, new Class[]{Uri.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().getType((ContentResolver) r100, r101, r102);
    }

    public static void unregisterContentObserver(Object r100, ContentObserver r101, String r102) {
        if ((r100 instanceof ContentResolver) == false) goto L10;
        ((ContentResolver) r100).unregisterContentObserver(r101);
        return;
    L10:
        MethodUtils.invokeMethod(r100, "unregisterContentObserver", new Object[]{r101}, new Class[]{ContentObserver.class});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static int delete(Object r100, Uri r101, Bundle r102, String r103) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return ((Integer) MethodUtils.invokeMethod(r100, "delete", new Object[]{r101, r102}, new Class[]{Uri.class, Bundle.class})).intValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().delete((ContentResolver) r100, r101, r102, r103);
    }

    public static Uri insert(Object r100, Uri r101, ContentValues r102, String r103) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return (Uri) MethodUtils.invokeMethod(r100, "insert", new Object[]{r101, r102}, new Class[]{Uri.class, ContentValues.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().insert((ContentResolver) r100, r101, r102, r103);
    }

    public static void notifyChange(Object r100, Uri r101, ContentObserver r102, String r103) {
        if ((r100 instanceof ContentResolver) == false) goto L5;
        Uri r104 = a.a(r101, r103);
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange] notify plugin proxyUri=" + r104 + ", original uri=" + r101 + ", pluginPkg=" + r103);
        ContentResolver r105 = (ContentResolver) r100;
        r105.notifyChange(r104, r102);
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange] notify host original uri=" + r101 + ", pluginPkg=" + r103);
        r105.notifyChange(r101, r102);
        return;
    L5:
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange(2 params)] invoke via reflection");
        MethodUtils.invokeMethod(r100, "notifyChange", new Object[]{r101, r102}, new Class[]{Uri.class, ContentObserver.class});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static int delete(Object r100, Uri r101, String r102, String[] r110, String r111) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return ((Integer) MethodUtils.invokeMethod(r100, "delete", new Object[]{r101, r102, r110}, new Class[]{Uri.class, String.class, String[].class})).intValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().delete((ContentResolver) r100, r101, r102, r110, r111);
    }

    public static Uri insert(Object r100, Uri r101, ContentValues r102, Bundle r110, String r111) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return (Uri) MethodUtils.invokeMethod(r100, "insert", new Object[]{r101, r102, r110}, new Class[]{Uri.class, ContentValues.class, Bundle.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().insert((ContentResolver) r100, r101, r102, r110, r111);
    }

    public static void notifyChange(Object r100, Collection<Uri> r101, ContentObserver r102, int r103, String r104) {
        if ((r100 instanceof ContentResolver) == false) goto L9;
        ArrayList r105 = new ArrayList();
        Iterator<Uri> r106 = r101.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r105.add(a.a(r106.next(), r104));
        goto L6
    L8:
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange] notify plugin proxyUris=" + r105 + ", original uris=" + r101 + ", pluginPkg=" + r104);
        ContentResolver r107 = (ContentResolver) r100;
        r107.notifyChange(r105, r102, r103);
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange] notify host original uris=" + r101 + ", pluginPkg=" + r104);
        r107.notifyChange(r101, r102, r103);
        return;
    L9:
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange(Collection)] invoke via reflection");
        MethodUtils.invokeMethod(r100, "notifyChange", new Object[]{r101, r102, Integer.valueOf(r103)}, new Class[]{Collection.class, ContentObserver.class, Integer.TYPE});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void registerContentObserver(Object r100, Uri r101, boolean r102, ContentObserver r103, String r104) {
        if ((r100 instanceof ContentResolver) == false) goto L10;
        ((ContentResolver) r100).registerContentObserver(a.a(r101, r104), r102, r103);
        return;
    L10:
        MethodUtils.invokeMethod(r100, "registerContentObserver", new Object[]{r101, Boolean.valueOf(r102), r103}, new Class[]{Uri.class, Boolean.TYPE, ContentObserver.class});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static int update(Object r100, Uri r101, ContentValues r102, Bundle r110, String r111) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return ((Integer) MethodUtils.invokeMethod(r100, "update", new Object[]{r101, r102, r110}, new Class[]{Uri.class, ContentValues.class, Bundle.class})).intValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().update((ContentResolver) r100, r101, r102, r110, r111);
    }

    public static void notifyChange(Object r100, Uri r101, ContentObserver r102, int r103, String r104) {
        if ((r100 instanceof ContentResolver) == false) goto L5;
        Uri r105 = a.a(r101, r104);
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange] notify plugin proxyUri=" + r105 + ", original uri=" + r101 + ", pluginPkg=" + r104);
        ContentResolver r106 = (ContentResolver) r100;
        r106.notifyChange(r105, r102, r103);
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange] notify host original uri=" + r101 + ", pluginPkg=" + r104);
        r106.notifyChange(r101, r102, r103);
        return;
    L5:
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange(3 params, flags)] invoke via reflection");
        MethodUtils.invokeMethod(r100, "notifyChange", new Object[]{r101, r102, Integer.valueOf(r103)}, new Class[]{Uri.class, ContentObserver.class, Integer.TYPE});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void notifyChange(Object r100, Uri r101, ContentObserver r102, boolean r103, String r104) {
        if ((r100 instanceof ContentResolver) == false) goto L5;
        Uri r105 = a.a(r101, r104);
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange] notify plugin proxyUri=" + r105 + ", original uri=" + r101 + ", pluginPkg=" + r104);
        ContentResolver r106 = (ContentResolver) r100;
        r106.notifyChange(r105, r102, r103);
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange] notify host original uri=" + r101 + ", pluginPkg=" + r104);
        r106.notifyChange(r101, r102, r103);
        return;
    L5:
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "[ZeusProviderTransform#notifyChange(3 params, sync)] invoke via reflection");
        MethodUtils.invokeMethod(r100, "notifyChange", new Object[]{r101, r102, Boolean.valueOf(r103)}, new Class[]{Uri.class, ContentObserver.class, Boolean.TYPE});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Bundle call(Object r100, Uri r101, String r110, String r111, Bundle r112, String r113) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return (Bundle) MethodUtils.invokeMethod(r100, NotificationCompat.CATEGORY_CALL, new Object[]{r101, r110, r111, r112}, new Class[]{Uri.class, String.class, String.class, Bundle.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().call((ContentResolver) r100, r101, r110, r111, r112, r113);
    }

    public static Cursor query(Object r100, Uri r101, String[] r110, Bundle r111, CancellationSignal r112, String r113) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return (Cursor) MethodUtils.invokeMethod(r100, "query", new Object[]{r101, r110, r111, r112}, new Class[]{Uri.class, String[].class, Bundle.class, CancellationSignal.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().query((ContentResolver) r100, r101, r110, r111, r112, r113);
    }

    public static int update(Object r100, Uri r101, ContentValues r110, String r111, String[] r112, String r113) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return ((Integer) MethodUtils.invokeMethod(r100, "update", new Object[]{r101, r110, r111, r112}, new Class[]{Uri.class, ContentValues.class, String.class, String[].class})).intValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().update((ContentResolver) r100, r101, r110, r111, r112, r113);
    }

    public static Bundle call(Object r100, String r101, String r110, String r111, Bundle r112, String r113) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return (Bundle) MethodUtils.invokeMethod(r100, NotificationCompat.CATEGORY_CALL, new Object[]{r101, r110, r111, r112}, new Class[]{String.class, String.class, String.class, Bundle.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().call((ContentResolver) r100, r101, r110, r111, r112, r113);
    }

    public static Cursor query(Object r100, Uri r110, String[] r111, String r112, String[] r113, String r114, String r115) {
        if ((r100 instanceof ContentResolver) == true) goto L5;
        return (Cursor) MethodUtils.invokeMethod(r100, "query", new Object[]{r110, r111, r112, r113, r114}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().query((ContentResolver) r100, r110, r111, r112, r113, r114, r115);
    }

    public static Cursor query(Object r110, Uri r111, String[] r112, String r113, String[] r114, String r115, CancellationSignal r116, String r117) {
        if ((r110 instanceof ContentResolver) == true) goto L5;
        return (Cursor) MethodUtils.invokeMethod(r110, "query", new Object[]{r111, r112, r113, r114, r115, r116}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class, CancellationSignal.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().query((ContentResolver) r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
