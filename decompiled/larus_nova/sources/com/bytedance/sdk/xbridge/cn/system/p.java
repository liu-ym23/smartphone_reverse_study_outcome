package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.addShortcut")
public final class p extends com.bytedance.sdk.xbridge.cn.system.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f270220j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f270221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f270222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f270223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f270224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f270225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f270226i;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f270227a = null;

        static {
            f270227a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f270228a;

        public b(Activity r100) {
            this.f270228a = r100;
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            String r102 = ze7.c.f571557a;
            Activity r103 = this.f270228a;
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            String r104 = ze7.c.f571557a;
            boolean r105 = false;
            if (StringsKt.contains$default(r104, RomUtils.BRAND_HUAWEI, false, 2, null) == false) goto L6;
            Intent r106 = new Intent();
            r106.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        L78:
            r106.putExtra("start_only_for_android", true);     // Catch: Exception -> L70
            r103.startActivity(r106);     // Catch: Exception -> L70
            return;
        L70:
            r103.startActivity(ze7.c.c(r103));
            return;
        L6:
            if (StringsKt.contains$default(r104, DimLocationCheckUtil.XIAOMI, false, 2, null) == false) goto L46;
            BufferedReader r107 = new BufferedReader(new InputStreamReader(ze7.c.b(Runtime.getRuntime(), "getprop ro.miui.ui.version.name").getInputStream()), 1024);     // Catch: Throwable -> L12 IOException -> L14
        L82:
            String r108 = r107.readLine();     // Catch: Throwable -> L10 IOException -> L73
        L74:
            r107.close();     // Catch: IOException -> L19
        L21:
            if (TextUtils.isEmpty(r108) == false) goto L23;
        L38:
            r106 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            r106.putExtra("extra_pkgname", r103.getPackageName());
            goto L78
        L23:
            if (StringsKt.contains$default(r108, "V7", false, 2, null) == true) goto L38;
            if (StringsKt.contains$default(r108, "V8", false, 2, null) == true) goto L38;
            if (TextUtils.isEmpty(r108) == false) goto L30;
        L37:
            r106 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            r106.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
            r106.putExtra("extra_pkgname", r103.getPackageName());
            goto L78
        L30:
            if (StringsKt.contains$default(r108, "V9", false, 2, null) == true) goto L37;
            if (StringsKt.contains$default(r108, "V10", false, 2, null) == true) goto L37;
            if (StringsKt.contains$default(r108, "V11", false, 2, null) == true) goto L37;
            r106 = ze7.c.c(r103);
            goto L78
        L10:
            th = th;
        L42:
            if (r107 != null) goto L76;
        L44:
            throw th;
        L76:
            r107.close();     // Catch: IOException -> L72
        L15:
            r108 = "";
            if (r107 == null) goto L21;
        L14:
            r107 = null;
        L12:
            th = th;
            r107 = null;
            goto L42
        L46:
            if (StringsKt.contains$default(r104, AppConstants.CHANNEL_OPPO, false, 2, null) == false) goto L54;
            r106 = new Intent();
            r106.putExtra("packageName", r103.getPackageName());
            r106.setClassName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity");
            if (r103.getPackageManager().queryIntentActivities(r106, 65536).size() <= 0) goto L50;
            r105 = true;
        L50:
            if (r105 == true) goto L78;
            r106.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
            goto L78
        L54:
            if (StringsKt.contains$default(r104, DimLocationCheckUtil.VIVO, false, 2, null) == false) goto L62;
            r106 = new Intent();
            r106.putExtra("packagename", r103.getPackageName());
            r106.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
            if (r103.getPackageManager().queryIntentActivities(r106, 65536).size() <= 0) goto L58;
            r105 = true;
        L58:
            if (r105 == true) goto L78;
            r106.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
            goto L78
        L62:
            if (StringsKt.contains$default(r104, "meizu", false, 2, null) == true) goto L64;
            r106 = ze7.c.c(r103);
            goto L78
        L64:
            if (Build.VERSION.SDK_INT < 24) goto L66;
            r106 = ze7.c.c(r103);
            goto L78
        L66:
            r106 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            r106.putExtra("packageName", r103.getPackageName());
            r106.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
            goto L78
        }
    }

    public p() {
        this.f270221d = "add shortcut failed";
        this.f270222e = "load icon failed";
        this.f270223f = "前往设置";
        this.f270224g = "若添加失败，请前往系统设置，为本应用打开\"创建桌面快捷方式\"的权限";
        this.f270225h = "已尝试添加到桌面";
        this.f270226i = "取消";
    }

    public final void a(Activity r110, IBDXBridgeContext r111) {
        b r100 = new b(r110);
        a r101 = a.f270227a;
        String r102 = this.f270223f;
        String r103 = this.f270224g;
        DialogBuilder r112 = new DialogBuilder(r110, this.f270225h, r103, r102, r100, this.f270226i, r101, null, true);
        IHostStyleUIDepend r113 = com.bytedance.sdk.xbridge.cn.utils.g.h(r111);
        if (r113 == null) goto L5;
        Boolean r114 = r113.showDialog(r112);
    L7:
        if (Intrinsics.areEqual(r114, Boolean.TRUE) == true) goto L10;
        Intrinsics.checkNotNullParameter(r112, "dialogBuilder");
        Intrinsics.checkNotNullParameter(r112, "dialogBuilder");
        return;
    L10:
        return;
    L5:
        r114 = null;
        goto L7
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        com.bytedance.sdk.xbridge.cn.system.a.b r113 = (com.bytedance.sdk.xbridge.cn.system.a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        IAnnieXCustomActivityService r101 = (IAnnieXCustomActivityService) r110.getService(IAnnieXCustomActivityService.class);
        if (r101 == null) goto L10;
        r113.getSchema();
        Class<?> r102 = r101.D0();
        if (r102 == null) goto L10;
    L14:
        if (r102 != null) goto L16;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context can not convert to activity", null, 4, null);
        return;
    L16:
        boolean r103 = false;
        if (r113.getName().length() != 0) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L23;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "The name key is required.", null, 4, null);
        return;
    L23:
        if (r113.getId().length() != 0) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == false) goto L29;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "The id key is required.", null, 4, null);
        return;
    L29:
        if (r113.getSchema().length() != 0) goto L31;
        boolean r106 = true;
    L32:
        if (r106 == false) goto L34;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "The schema key is required.", null, 4, null);
        return;
    L34:
        String r107 = ze7.c.f571557a;
        String r108 = r113.getId();
        String r109 = r113.getName();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r108, "id");
        Intrinsics.checkNotNullParameter(r109, "name");
        if (Build.VERSION.SDK_INT < 25) goto L42;
        Iterator<T> r114 = ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).getPinnedShortcuts().iterator();
    L38:
        if (r114.hasNext() == false) goto L42;
        if (TextUtils.equals(((ShortcutInfo) r114.next()).getId(), r108) == false) goto L38;
    L87:
        boolean r115 = true;
    L89:
        if (r115 == false) goto L91;
        XBaseModel r116 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.system.a.c.class));
        ((com.bytedance.sdk.xbridge.cn.system.a.c) r116).setCode(1);
        r112.onSuccess((XBaseResultModel) r116, "shortcut already exists");
        return;
    L91:
        ShortcutInfoCompat.Builder r117 = new ShortcutInfoCompat.Builder(r100, r113.getId()).setShortLabel(r113.getName()).setIntent(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r113.getSchema()), r100, r102));
        String r118 = r113.getIcon();
        if (r118 != null) goto L94;
    L95:
        r103 = true;
    L96:
        if (r103 == true) goto L98;
        String r119 = r113.getIcon();
        Intrinsics.checkNotNull(r119);
        com.bytedance.sdk.xbridge.cn.utils.g.a().execute(new o(r119, r110, r117, r100, r112, this));
        return;
    L98:
        if (ShortcutManagerCompat.requestPinShortcut(r100, r117.build(), null) == false) goto L100;
        XBaseModel r120 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.system.a.c.class));
        ((com.bytedance.sdk.xbridge.cn.system.a.c) r120).setCode(1);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r120, null, 2, null);
        a(r100, r110);
        return;
    L100:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, this.f270221d, null, 4, null);
        a(r100, r110);
        return;
    L94:
        if (r118.length() != 0) goto L96;
    L42:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r109, "title");
        Intent r121 = new Intent("android.intent.action.MAIN");
        r121.addCategory("android.intent.category.HOME");
        PackageManager r122 = r100.getPackageManager();
        ResolveInfo r123 = r122.resolveActivity(r121, 0);
        if (r123 == null) goto L57;
        ActivityInfo r124 = r123.activityInfo;
        List<ProviderInfo> r125 = r122.queryContentProviders(r124.packageName, r124.applicationInfo.uid, 8);
        if (r125 == null) goto L57;
        Iterator<ProviderInfo> r126 = r125.iterator();
    L50:
        if (r126.hasNext() == false) goto L57;
        ProviderInfo r127 = r126.next();
        if (TextUtils.isEmpty(r127.readPermission) == true) goto L50;
        if (Pattern.matches(".*launcher.*READ_SETTINGS", r127.readPermission) == false) goto L50;
        String r128 = r127.authority;
    L58:
        if (r128 != null) goto L60;
    L67:
        r128 = "com.android.launcher3.settings";
    L68:
        StringBuffer r129 = new StringBuffer("content://");
        r129.append(r128);
        r129.append("/favorites?notify=true");
        Cursor r130 = ze7.c.a(r100.getContentResolver(), UriProtector.parse(r129.toString()), new String[]{r109});     // Catch: Exception -> L84
        if (r130 == null) goto L85;
        Cursor r131 = r130;     // Catch: Exception -> L84
    L79:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        CloseableKt.closeFinally(r131, th);     // Catch: Exception -> L84
        throw th;     // Catch: Exception -> L84
    L73:
        if (r131.moveToNext() == false) goto L76;
        CloseableKt.closeFinally(r131, null);     // Catch: Exception -> L84
        boolean r132 = true;
    L86:
        if (r132 == true) goto L87;
        r115 = false;
        goto L89
    L76:
        Unit r133 = Unit.INSTANCE;     // Catch: Throwable -> L79
        CloseableKt.closeFinally(r131, null);     // Catch: Exception -> L84
        goto L85
    L85:
        r132 = false;
        goto L86
    L60:
        if (r128.length() <= 0) goto L62;
        boolean r134 = true;
    L63:
        if (r134 == true) goto L66;
        r128 = null;
    L66:
        if (r128 != null) goto L68;
    L62:
        r134 = false;
    L57:
        r128 = "";
        goto L58
    L31:
        r106 = false;
        goto L32
    L25:
        r105 = false;
        goto L26
    L19:
        r104 = false;
    L10:
        Activity r135 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r100);
        if (r135 == null) goto L13;
        r102 = r135.getClass();
        goto L14
    L13:
        r102 = null;
        goto L14
    }
}
