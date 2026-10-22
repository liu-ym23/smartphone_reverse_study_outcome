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

/* JADX INFO: loaded from: classes.dex */
public class ContentProviderProxy extends ContentProvider {
    private static volatile Field sAttributionSourceField;
    private static volatile Field sCallingPackageField;
    private static volatile boolean sFieldInitialized;
    public ContentProviderManager mPluginProviderManager;

    /* JADX INFO: loaded from: classes6.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PluginContentProvider f462828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f462829b;

        public a(PluginContentProvider r100, Uri r101) {
            this.f462828a = r100;
            this.f462829b = r101;
        }
    }

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

    private void hookCallingPackage(ContentProvider r100) {
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
        Object r101 = FieldUtils.readField(sAttributionSourceField, this);     // Catch: Throwable -> L38
        if ((r101 instanceof ThreadLocal) == false) goto L33;
        FieldUtils.writeField(sAttributionSourceField, r100, r101);     // Catch: Throwable -> L38
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "hookCallingPackage success using mCallingAttributionSource");     // Catch: Throwable -> L38
        return;
    L33:
        if (r101 != null) goto L35;
        String r102 = "null";
    L36:
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "hookCallingPackage failed: mCallingAttributionSource is not ThreadLocal! It is ".concat(r102));     // Catch: Throwable -> L38
        goto L41
    L35:
        r102 = r101.getClass().getName();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "hookCallingPackage mCallingAttributionSource failed", th);
    L41:
        if (sCallingPackageField == null) goto L62;
        Object r103 = FieldUtils.readField(sCallingPackageField, this);     // Catch: Throwable -> L51
        if ((r103 instanceof ThreadLocal) == false) goto L46;
        FieldUtils.writeField(sCallingPackageField, r100, r103);     // Catch: Throwable -> L51
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "hookCallingPackage success using mCallingPackage");     // Catch: Throwable -> L51
        return;
    L46:
        if (r103 != null) goto L48;
        String r104 = "null";
    L49:
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "hookCallingPackage failed: mCallingPackage is not ThreadLocal! It is ".concat(r104));     // Catch: Throwable -> L51
        return;
    L48:
        r104 = r103.getClass().getName();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "hookCallingPackage mCallingPackage failed", th);
        return;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        waitInit();
        if (r100 != null) goto L14;
        return null;
    L14:
        a r101 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r101 == null) goto L13;
        PluginContentProvider r102 = r101.f462828a;     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return r102.getType(r101.f462829b);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#getType className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    private a obtainPluginProvider(Uri r100, String r101) throws JSONException {
        return obtainPluginProvider(r100, r101, null);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, Bundle r101) {
        waitInit();
        if (r100 != null) goto L14;
        return -1;
    L14:
        a r102 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        PluginContentProvider r103 = r102.f462828a;     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        return r103.delete(r102.f462829b, r101);
    L13:
        return -1;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#delete(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        waitInit();
        if (r100 != null) goto L14;
        return null;
    L14:
        a r102 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        PluginContentProvider r103 = r102.f462828a;     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        return r103.insert(r102.f462829b, r101);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#insert(2 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    private a obtainPluginProvider(Uri r100, String r101, String r102) throws JSONException {
        String r103 = UriProtector.getQueryParameter(r100, "provider_params");
        Uri r104 = null;
        if (r103 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L8;
    L11:
        JSONObject r105 = new JSONObject(r103);
        String r106 = r105.optString("process_name");
        String r107 = r105.optString(ContentProviderManager.PLUGIN_PKG_NAME);
        String r108 = r105.optString("uri");
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()]解析插件参数: Plugin provider [pluginProcessName:" + r106 + "] [pluginPkgName:" + r107 + "]  [pluginUrl : " + r108 + "]");
        Zeus.loadOrAwaitLoad(r107, g.f462706c);
        if (TextUtils.isEmpty(r108) == true) goto L14;
        r104 = UriProtector.parse(r108);
        r102 = r104.getAuthority();
    L14:
        if (r102 != null) goto L16;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()] plugin Authority is null !!! plugin provider can not find !!");
    L16:
        PluginContentProvider r109 = this.mPluginProviderManager.getPluginProvider(new ContentProviderManager.b(r107, r106, r102));
        if (r109 != null) goto L19;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "[Method:obtainPluginProvider()] pluginProvider is null");
    L21:
        return new a(r109, r104);
    L19:
        hookCallingPackage(r109);
        goto L21
    L8:
        if (TextUtils.isEmpty(r103) == false) goto L10;
        r103 = "";
        goto L11
    L10:
        r103 = new String(Base64.decode(r103, 10));
        goto L11
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        waitInit();
        if (r102 == null) goto L16;
        String r103 = r102.getString("provider_params", "");     // Catch: Throwable -> L10
        String r104 = r102.getString(ContentProviderManager.PROVIDER_PROXY_URI, "");     // Catch: Throwable -> L10
        r102.remove("provider_params");     // Catch: Throwable -> L10
        r102.remove(ContentProviderManager.PROVIDER_PROXY_URI);     // Catch: Throwable -> L10
        Uri r105 = UriProtector.parse(r104);     // Catch: Throwable -> L10
        a r106 = obtainPluginProvider(r105, r105.getAuthority(), r103);     // Catch: Throwable -> L10
        if (r106 == null) goto L17;
        PluginContentProvider r107 = r106.f462828a;     // Catch: Throwable -> L10
        if (r107 == null) goto L18;
        return r107.call(r100, r101, r102);
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
    public int delete(Uri r100, String r101, String[] r102) {
        waitInit();
        if (r100 != null) goto L14;
        return -1;
    L14:
        a r103 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        PluginContentProvider r104 = r103.f462828a;     // Catch: Throwable -> L11
        if (r104 == null) goto L13;
        return r104.delete(r103.f462829b, r101, r102);
    L13:
        return -1;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#delete(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101, Bundle r102) {
        waitInit();
        if (r100 != null) goto L14;
        return null;
    L14:
        a r103 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        PluginContentProvider r104 = r103.f462828a;     // Catch: Throwable -> L11
        if (r104 == null) goto L13;
        return r104.insert(r103.f462829b, r101, r102);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#insert(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, Bundle r102) {
        waitInit();
        if (r100 != null) goto L14;
        return 0;
    L14:
        a r103 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        PluginContentProvider r104 = r103.f462828a;     // Catch: Throwable -> L11
        if (r104 == null) goto L13;
        return r104.update(r103.f462829b, r101, r102);
    L13:
        return 0;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#update(3 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, String r102, Bundle r103) {
        waitInit();
        if (r103 == null) goto L16;
        String r104 = r103.getString("provider_params", "");     // Catch: Throwable -> L10
        String r105 = r103.getString(ContentProviderManager.PROVIDER_PROXY_URI, "");     // Catch: Throwable -> L10
        r103.remove("provider_params");     // Catch: Throwable -> L10
        r103.remove(ContentProviderManager.PROVIDER_PROXY_URI);     // Catch: Throwable -> L10
        Uri r106 = UriProtector.parse(r105);     // Catch: Throwable -> L10
        a r107 = obtainPluginProvider(r106, r106.getAuthority(), r104);     // Catch: Throwable -> L10
        if (r107 == null) goto L17;
        PluginContentProvider r108 = r107.f462828a;     // Catch: Throwable -> L10
        if (r108 == null) goto L18;
        return r108.call(r104, r101, r102, r103);
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
    public Cursor query(Uri r100, String[] r101, Bundle r102, CancellationSignal r103) {
        waitInit();
        if (r100 != null) goto L14;
        return null;
    L14:
        a r104 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r104 == null) goto L13;
        PluginContentProvider r105 = r104.f462828a;     // Catch: Throwable -> L11
        if (r105 == null) goto L13;
        return r105.query(r104.f462829b, r101, r102, r103);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        waitInit();
        if (r100 != null) goto L14;
        return 0;
    L14:
        a r104 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r104 == null) goto L13;
        PluginContentProvider r105 = r104.f462828a;     // Catch: Throwable -> L11
        if (r105 == null) goto L13;
        return r105.update(r104.f462829b, r101, r102, r103);
    L13:
        return 0;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#update(4 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r110, String[] r111, String r112) {
        waitInit();
        if (r100 != null) goto L14;
        return null;
    L14:
        a r102 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        PluginContentProvider r103 = r102.f462828a;     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        return r103.query(r102.f462829b, r101, r110, r111, r112);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(5 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r110, String r111, String[] r112, String r113, CancellationSignal r114) {
        waitInit();
        if (r100 != null) goto L14;
        return null;
    L14:
        a r101 = obtainPluginProvider(r100, r100.getAuthority());     // Catch: Throwable -> L11
        if (r101 == null) goto L13;
        PluginContentProvider r102 = r101.f462828a;     // Catch: Throwable -> L11
        if (r102 == null) goto L13;
        return r102.query(r101.f462829b, r110, r111, r112, r113, r114);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "proxy provider#query(6 params) className=" + getClass().getSimpleName() + ",exception:", th);
        goto L13
    }
}
