package com.volcengine.zeus.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mt.protector.impl.UriProtector;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.g;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ContentProviderProxy extends ContentProvider {
    private static volatile Field sAttributionSourceField;
    private static volatile Field sCallingPackageField;
    private static volatile boolean sFieldInitialized;
    public ContentProviderManager mPluginProviderManager;

    public void waitInit() {
        Zeus.waitInit(-1);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mPluginProviderManager = ContentProviderManager.getInstance();
        return true;
    }

    public ContentProviderProxy() {
    }

    private void hookCallingPackage(ContentProvider r7) {
        if (sFieldInitialized == true) goto L27;
        monitor-enter(ContentProviderProxy.class);
    L23:
        th = move-exception;
        throw th;
    L7:
        if (sFieldInitialized == false) goto L10;
    L21:
        monitor-exit(ContentProviderProxy.class);     // Catch: Throwable -> L23
        goto L27
    L10:
        if (Build.VERSION.SDK_INT < 31) goto L59;
        sAttributionSourceField = FieldUtils.getField(ContentProvider.class, "mCallingAttributionSource");     // Catch: Throwable -> L13
    L20:
        sFieldInitialized = true;     // Catch: Throwable -> L23
        goto L21
    L13:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "hookCallingPackage init mCallingAttributionSource failed", th);     // Catch: Throwable -> L23
        goto L20
    L59:
        sCallingPackageField = FieldUtils.getField(ContentProvider.class, "mCallingPackage");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "hookCallingPackage init mCallingPackage failed", th);     // Catch: Throwable -> L23
    L27:
        if (sAttributionSourceField == null) goto L41;
        Object r2 = FieldUtils.readField(sAttributionSourceField, this);     // Catch: Throwable -> L38
        if ((r2 instanceof ThreadLocal) == false) goto L33;
        FieldUtils.writeField(sAttributionSourceField, r7, r2);     // Catch: Throwable -> L38
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "hookCallingPackage success using mCallingAttributionSource");     // Catch: Throwable -> L38
        return;
    L33:
        if (r2 != null) goto L35;
        String r3 = "null";
    L36:
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "hookCallingPackage failed: mCallingAttributionSource is not ThreadLocal! It is ".concat(r3));     // Catch: Throwable -> L38
        goto L41
    L35:
        r3 = r2.getClass().getName();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "hookCallingPackage mCallingAttributionSource failed", th);
    L41:
        if (sCallingPackageField == null) goto L62;
        Object r1 = FieldUtils.readField(sCallingPackageField, this);     // Catch: Throwable -> L51
        if ((r1 instanceof ThreadLocal) == false) goto L46;
        FieldUtils.writeField(sCallingPackageField, r7, r1);     // Catch: Throwable -> L51
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "hookCallingPackage success using mCallingPackage");     // Catch: Throwable -> L51
        return;
    L46:
        if (r1 != null) goto L48;
        String r4 = "null";
    L49:
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "hookCallingPackage failed: mCallingPackage is not ThreadLocal! It is ".concat(r4));     // Catch: Throwable -> L51
        return;
    L48:
        r4 = r1.getClass().getName();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "hookCallingPackage mCallingPackage failed", th);
        return;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r4) {
        waitInit();
        if (r4 != null) goto L14;
        return null;
    L14:
        a r5 = obtainPluginProvider(r4, r4.getAuthority());     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        PluginContentProvider r1 = r5.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.getType(r5.b);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#getType className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    private a obtainPluginProvider(Uri r2, String r3) throws JSONException {
        return obtainPluginProvider(r2, r3, null);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r3, Bundle r4) {
        waitInit();
        if (r3 != null) goto L14;
        return -1;
    L14:
        a r5 = obtainPluginProvider(r3, r3.getAuthority());     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        PluginContentProvider r1 = r5.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.delete(r5.b, r4);
    L13:
        return -1;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#delete(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r3, ContentValues r4) {
        waitInit();
        if (r3 != null) goto L14;
        return null;
    L14:
        a r5 = obtainPluginProvider(r3, r3.getAuthority());     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        PluginContentProvider r1 = r5.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.insert(r5.b, r4);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#insert(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    private a obtainPluginProvider(Uri r7, String r8, String r9) throws JSONException {
        String r10 = UriProtector.getQueryParameter(r7, "provider_params");
        Uri r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
    L11:
        JSONObject r0 = new JSONObject(r10);
        String r12 = r0.optString(ContentProviderManager.PLUGIN_PROCESS_NAME);
        String r1 = r0.optString(ContentProviderManager.PLUGIN_PKG_NAME);
        String r2 = r0.optString(ContentProviderManager.PROVIDER_URI);
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()]解析插件参数: Plugin provider [pluginProcessName:" + r12 + "] [pluginPkgName:" + r1 + "]  [pluginUrl : " + r2 + "]");
        Zeus.loadOrAwaitLoad(r1, g.c);
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r11 = UriProtector.parse(r2);
        r9 = r11.getAuthority();
    L14:
        if (r9 != null) goto L16;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()] plugin Authority is null !!! plugin provider can not find !!");
    L16:
        PluginContentProvider r13 = this.mPluginProviderManager.getPluginProvider(new ContentProviderManager.b(r1, r12, r9));
        if (r13 != null) goto L19;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()] pluginProvider is null");
    L21:
        return new a(r13, r11);
    L19:
        hookCallingPackage(r13);
        goto L21
    L8:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        r10 = XmlPullParser.NO_NAMESPACE;
        goto L11
    L10:
        r10 = new String(Base64.decode(r10, 10));
        goto L11
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r5, String r6, Bundle r7) {
        waitInit();
        if (r7 == null) goto L16;
        String r3 = r7.getString("provider_params", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L10
        String r1 = r7.getString(ContentProviderManager.PROVIDER_PROXY_URI, XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L10
        r7.remove("provider_params");     // Catch: Throwable -> L10
        r7.remove(ContentProviderManager.PROVIDER_PROXY_URI);     // Catch: Throwable -> L10
        Uri r0 = UriProtector.parse(r1);     // Catch: Throwable -> L10
        a r2 = obtainPluginProvider(r0, r0.getAuthority(), r3);     // Catch: Throwable -> L10
        if (r2 == null) goto L17;
        PluginContentProvider r4 = r2.a;     // Catch: Throwable -> L10
        if (r4 == null) goto L18;
        return r4.call(r5, r6, r7);
    L18:
        return null;
    L17:
        return null;
    L10:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#call(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        return null;
    L16:
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r3, String r4, String[] r5) {
        waitInit();
        if (r3 != null) goto L14;
        return -1;
    L14:
        a r6 = obtainPluginProvider(r3, r3.getAuthority());     // Catch: Throwable -> L11
        if (r6 == null) goto L13;
        PluginContentProvider r1 = r6.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.delete(r6.b, r4, r5);
    L13:
        return -1;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#delete(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r3, ContentValues r4, Bundle r5) {
        waitInit();
        if (r3 != null) goto L14;
        return null;
    L14:
        a r6 = obtainPluginProvider(r3, r3.getAuthority());     // Catch: Throwable -> L11
        if (r6 == null) goto L13;
        PluginContentProvider r1 = r6.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.insert(r6.b, r4, r5);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#insert(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public int update(Uri r3, ContentValues r4, Bundle r5) {
        waitInit();
        if (r3 != null) goto L14;
        return 0;
    L14:
        a r6 = obtainPluginProvider(r3, r3.getAuthority());     // Catch: Throwable -> L11
        if (r6 == null) goto L13;
        PluginContentProvider r1 = r6.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.update(r6.b, r4, r5);
    L13:
        return 0;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#update(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r4, String r5, String r6, Bundle r7) {
        waitInit();
        if (r7 == null) goto L16;
        String r2 = r7.getString("provider_params", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L10
        String r0 = r7.getString(ContentProviderManager.PROVIDER_PROXY_URI, XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L10
        r7.remove("provider_params");     // Catch: Throwable -> L10
        r7.remove(ContentProviderManager.PROVIDER_PROXY_URI);     // Catch: Throwable -> L10
        Uri r8 = UriProtector.parse(r0);     // Catch: Throwable -> L10
        a r9 = obtainPluginProvider(r8, r8.getAuthority(), r2);     // Catch: Throwable -> L10
        if (r9 == null) goto L17;
        PluginContentProvider r10 = r9.a;     // Catch: Throwable -> L10
        if (r10 == null) goto L18;
        return r10.call(r2, r5, r6, r7);
    L18:
        return null;
    L17:
        return null;
    L10:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#call(4 params-Added in API level 29) className=" + getClass().getSimpleName() + ",exception:", th);
        return null;
    L16:
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r3, String[] r4, Bundle r5, CancellationSignal r6) {
        waitInit();
        if (r3 != null) goto L14;
        return null;
    L14:
        a r7 = obtainPluginProvider(r3, r3.getAuthority());     // Catch: Throwable -> L11
        if (r7 == null) goto L13;
        PluginContentProvider r1 = r7.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.query(r7.b, r4, r5, r6);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public int update(Uri r3, ContentValues r4, String r5, String[] r6) {
        waitInit();
        if (r3 != null) goto L14;
        return 0;
    L14:
        a r7 = obtainPluginProvider(r3, r3.getAuthority());     // Catch: Throwable -> L11
        if (r7 == null) goto L13;
        PluginContentProvider r1 = r7.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.update(r7.b, r4, r5, r6);
    L13:
        return 0;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#update(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r8, String[] r9, String r10, String[] r11, String r12) {
        waitInit();
        if (r8 != null) goto L14;
        return null;
    L14:
        a r13 = obtainPluginProvider(r8, r8.getAuthority());     // Catch: Throwable -> L11
        if (r13 == null) goto L13;
        PluginContentProvider r1 = r13.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.query(r13.b, r9, r10, r11, r12);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(5 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13, CancellationSignal r14) {
        waitInit();
        if (r9 != null) goto L14;
        return null;
    L14:
        a r15 = obtainPluginProvider(r9, r9.getAuthority());     // Catch: Throwable -> L11
        if (r15 == null) goto L13;
        PluginContentProvider r1 = r15.a;     // Catch: Throwable -> L11
        if (r1 == null) goto L13;
        return r1.query(r15.b, r10, r11, r12, r13, r14);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(6 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }
}
