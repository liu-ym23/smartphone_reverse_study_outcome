package com.bytedance.mira.stub;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.mira.Mira;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import f06.b;
import f06.c;
import f06.d;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class BaseStubContentProvider extends ContentProvider {
    private static final String TAG = "BaseStubContentProvider";

    /* JADX INFO: loaded from: classes21.dex */
    public static final class CodeConst {
        public static final String EXTRA_STUB_AUTHORITY = "stub_authority";
        public static final String EXTRA_TARGET_AUTHORITY = "target_authority";

        public CodeConst() {
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        MiraLogger.d(MiraLogger.TAG_INIT, "BaseStubContentProvider onCreate");
        if (Mira.getAppContext() != null) goto L7;
        Mira.setAppContext(getContext());
        return true;
    L7:
        return true;
    }

    public BaseStubContentProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider getType, uri = " + r100);
        String r101 = UriProtector.getQueryParameter(r100, CodeConst.EXTRA_TARGET_AUTHORITY);
        if (TextUtils.equals(r100.getAuthority(), r101) == true) goto L14;
        ContentProviderClient r102 = acquireContentProviderClient(r100.getAuthority(), r101);     // Catch: RemoteException -> L8
        if (r102 == null) goto L15;
        Uri r103 = buildForwardUri(r100, r101);     // Catch: RemoteException -> L8
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider client.getType(targetUri), " + r103);     // Catch: RemoteException -> L8
        return r102.getType(r103);
    L15:
        return null;
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient.getType() failed.", e);
        return null;
    L14:
        return null;
    }

    private synchronized ContentProviderClient acquireContentProviderClient(String r100, String r101) {
        monitor-enter(this);
        ProviderInfo r102 = getContext().getPackageManager().resolveContentProvider(r100, 0);     // Catch: Throwable -> L12
        ProviderInfo r103 = PluginPackageManager.resolveContentProvider(r101, 0);     // Catch: Throwable -> L12
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient, " + r103 + " <<>> " + r102);     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        PluginManager.getInstance().loadPlugin(r103.applicationInfo.packageName, r103);     // Catch: Throwable -> L12
        ContentProviderClient r104 = com_bytedance_mira_stub_BaseStubContentProvider_android_content_ContentResolver_acquireContentProviderClient(getContext().getContentResolver(), r101);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r104;
    L9:
        monitor-exit(this);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    private Uri buildForwardUri(Uri r100, String r101) {
        Uri.Builder r102 = new Uri.Builder();
        r102.scheme(r100.getScheme());
        r102.authority(r101);
        r102.path(r100.getPath());
        if (OSUtil.isAndroidHHigher() == false) goto L14;
        Set<String> r103 = UriProtector.getQueryParameterNames(r100);
        if (r103 != null) goto L7;
    L15:
        r102.fragment(r100.getFragment());
        return r102.build();
    L7:
        if (r103.size() <= 0) goto L15;
        Iterator<String> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();
        if (TextUtils.equals(r105, CodeConst.EXTRA_TARGET_AUTHORITY) == true) goto L10;
        r102.appendQueryParameter(r105, UriProtector.getQueryParameter(r100, r105));
        goto L10
    L14:
        r102.query(r100.getQuery());
        goto L15
    }

    private static ContentProviderClient com_bytedance_mira_stub_BaseStubContentProvider_android_content_ContentResolver_acquireContentProviderClient(ContentResolver r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, null, r112, false);
        return (ContentProviderClient) r113.f474983b;
    L6:
        ContentProviderClient r114 = r110.acquireContentProviderClient(r111);
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, r114, r112, true);
        return r114;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri r100, ContentValues[] r101) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider bulkInsert, uri = " + r100);
        String r102 = UriProtector.getQueryParameter(r100, CodeConst.EXTRA_TARGET_AUTHORITY);
        if (TextUtils.equals(r100.getAuthority(), r102) == true) goto L11;
        ContentProviderClient r103 = acquireContentProviderClient(r100.getAuthority(), r102);     // Catch: RemoteException -> L8
        if (r103 == null) goto L11;
        Uri r104 = buildForwardUri(r100, r102);     // Catch: RemoteException -> L8
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider client.bulkInsert(targetUri), " + r104);     // Catch: RemoteException -> L8
        return r103.bulkInsert(r104, r101);
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient.bulkInsert() failed.", e);
    L11:
        return super.bulkInsert(r100, r101);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider insert, uri = " + r100);
        String r102 = UriProtector.getQueryParameter(r100, CodeConst.EXTRA_TARGET_AUTHORITY);
        if (TextUtils.equals(r100.getAuthority(), r102) == true) goto L14;
        ContentProviderClient r103 = acquireContentProviderClient(r100.getAuthority(), r102);     // Catch: RemoteException -> L8
        if (r103 == null) goto L15;
        Uri r104 = buildForwardUri(r100, r102);     // Catch: RemoteException -> L8
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider client.insert(targetUri), " + r104);     // Catch: RemoteException -> L8
        return r103.insert(r104, r101);
    L15:
        return null;
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient.insert() failed.", e);
        return null;
    L14:
        return null;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r100, String r101) throws FileNotFoundException {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider openFile, uri = " + r100);
        String r102 = UriProtector.getQueryParameter(r100, CodeConst.EXTRA_TARGET_AUTHORITY);
        if (TextUtils.equals(r100.getAuthority(), r102) == true) goto L11;
        ContentProviderClient r103 = acquireContentProviderClient(r100.getAuthority(), r102);     // Catch: RemoteException -> L8
        if (r103 == null) goto L11;
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider client.openFile(uri), " + r100);     // Catch: RemoteException -> L8
        return r103.openFile(r100, r101);
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient.openFile() failed.", e);
    L11:
        return super.openFile(r100, r101);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getString(CodeConst.EXTRA_STUB_AUTHORITY);
    L6:
        if (r102 == null) goto L8;
        r103 = r102.getString(CodeConst.EXTRA_TARGET_AUTHORITY);
    L8:
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider call, target = " + r103 + ", stub = " + r104);
        if (TextUtils.equals(r104, r103) == true) goto L21;
        ContentProviderClient r105 = acquireContentProviderClient(r104, r103);     // Catch: RemoteException -> L18
        if (r105 == null) goto L21;
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider client.call(method, arg, extras), " + r103);     // Catch: RemoteException -> L18
        if (OSUtil.isAndroidJ_MR1Higher() == false) goto L17;
        return r105.call(r100, r101, r102);
    L17:
        return call(r105, r100, r101, r102);
    L18:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient.call() failed.", e);
    L21:
        return super.call(r100, r101, r102);
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider delete, uri = " + r100);
        String r103 = UriProtector.getQueryParameter(r100, CodeConst.EXTRA_TARGET_AUTHORITY);
        if (TextUtils.equals(r100.getAuthority(), r103) == true) goto L14;
        ContentProviderClient r104 = acquireContentProviderClient(r100.getAuthority(), r103);     // Catch: RemoteException -> L8
        if (r104 == null) goto L15;
        Uri r105 = buildForwardUri(r100, r103);     // Catch: RemoteException -> L8
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider client.delete(targetUri), " + r105);     // Catch: RemoteException -> L8
        return r104.delete(r105, r101, r102);
    L15:
        return 0;
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient.delete() failed.", e);
        return 0;
    L14:
        return 0;
    }

    private Bundle call(ContentProviderClient r110, String r111, String r112, Bundle r113) throws RemoteException {
        Boolean r100 = Boolean.FALSE;
        Object r101 = FieldUtils.readField(r110, "mContentProvider");     // Catch: IllegalAccessException -> L5
    L37:
        ContentResolver r102 = (ContentResolver) FieldUtils.readField(r110, "mContentResolver");     // Catch: IllegalAccessException -> L9
    L39:
        r100 = (Boolean) FieldUtils.readField(r110, "mStable");     // Catch: IllegalAccessException -> L13
    L45:
        MethodUtils.invokeMethod(r101, NotificationCompat.CATEGORY_CALL, new Object[]{r111, r112, r113}, new Class[]{String.class, String.class, Bundle.class});     // Catch: Throwable -> L18 InvocationTargetException -> L30 IllegalAccessException -> L32 NoSuchMethodException -> L34
    L36:
        return null;
    L32:
        e = move-exception;
        e.printStackTrace();
    L34:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e.printStackTrace();
    L18:
        th = move-exception;
        if (r100.booleanValue() == false) goto L43;
    L29:
        throw th;
    L43:
        MethodUtils.invokeMethod(r102, "unstableProviderDied", new Object[]{r101});     // Catch: InvocationTargetException -> L23 IllegalAccessException -> L25 NoSuchMethodException -> L27
    L25:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        r102 = null;
    L5:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L37
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider update, uri = " + r100);
        String r104 = UriProtector.getQueryParameter(r100, CodeConst.EXTRA_TARGET_AUTHORITY);
        if (TextUtils.equals(r100.getAuthority(), r104) == true) goto L14;
        ContentProviderClient r105 = acquireContentProviderClient(r100.getAuthority(), r104);     // Catch: RemoteException -> L8
        if (r105 == null) goto L15;
        Uri r106 = buildForwardUri(r100, r104);     // Catch: RemoteException -> L8
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider client.update(targetUri), " + r106);     // Catch: RemoteException -> L8
        return r105.update(r106, r101, r102, r103);
    L15:
        return 0;
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient.update() failed.", e);
        return 0;
    L14:
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r110, String[] r111, String r112, String[] r113, String r114) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider query, uri = " + r110);
        String r100 = UriProtector.getQueryParameter(r110, CodeConst.EXTRA_TARGET_AUTHORITY);
        if (TextUtils.equals(r110.getAuthority(), r100) == true) goto L14;
        ContentProviderClient r101 = acquireContentProviderClient(r110.getAuthority(), r100);     // Catch: RemoteException -> L8
        if (r101 == null) goto L15;
        Uri r102 = buildForwardUri(r110, r100);     // Catch: RemoteException -> L8
        MiraLogger.d(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider client.query(targetUri), " + r102);     // Catch: RemoteException -> L8
        return r101.query(r102, r111, r112, r113, r114);
    L15:
        return null;
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PROVIDER, "BaseStubContentProvider acquireContentProviderClient.query() failed.", e);
        return null;
    L14:
        return null;
    }
}
