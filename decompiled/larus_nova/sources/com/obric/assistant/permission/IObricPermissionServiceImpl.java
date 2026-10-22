package com.obric.assistant.permission;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.nova.R;
import com.larus.permission.api.IPermissionX;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.security.privacypermission.ObricPrivacyAndPermissionUiDelegate;
import com.obric.assistant.utils.IObricAssistantUtilHelperService;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import mfa.e;
import mfa.f;
import mfa.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J&\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016JG\u0010\u0019\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2%\u0010\u0017\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001dj\u0002`!H\u0016JH\u0010\u0019\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016JP\u0010\u0019\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\fH\u0016J}\u0010*\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2[\u0010\u0017\u001aW\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00050+j\u0002`.H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\fH\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J,\u00102\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\n2\b\u00104\u001a\u0004\u0018\u000105H\u0016J<\u00106\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0017\u001a\u00020$H\u0016J\u001a\u00107\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010$H\u0016J(\u00107\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u00104\u001a\u0004\u0018\u00010$H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\fH\u0016J\u001e\u0010;\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010=\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020\fH\u0002J\u0010\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\f2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010C\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\u0002J\u001a\u0010D\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010$H\u0002J\u001a\u0010E\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010$H\u0002J0\u0010F\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\t2\b\u00104\u001a\u0004\u0018\u00010$2\u0006\u0010I\u001a\u00020\nH\u0002J<\u0010)\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\n2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010&2\n\b\u0002\u00104\u001a\u0004\u0018\u00010KH\u0002¨\u0006M"}, d2 = {"Lcom/obric/assistant/permission/IObricPermissionServiceImpl;", "Lcom/obric/assistant/permission/IObricPermissionService;", "<init>", "()V", "batchPermissionRequest", "", "activity", "Landroidx/fragment/app/FragmentActivity;", ErrorType.MANIFEST, "", "", "needShowGrantedPermission", "", "showIcon", "fallbackToSingleRequestWhenNoResolveInfo", "forceRuntimeRequestOnFallback", "requestDataCallBack", "Lcom/obric/assistant/permission/IObricPermissionService$IObricRequestPermissionCallback;", "isSystemResolveInfo", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "isGenesisRProduct", "tryRequestCombinePermissionByMiui", "requestCallBack", "checkPermission", "permission", "checkAlbumPermission", "Lcom/obric/assistant/permission/IObricPermissionService$Companion$ObricPermissionStatus;", "isOEMSupportAppListPermission", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "allGranted", "Lcom/larus/platform/api/RequestPermissionCallback;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "subTitleMap", "", "trackInfo", "Lorg/json/JSONObject;", "showGoSettingsDialog", "permissionForDetail", "Lkotlin/Function3;", "grantedList", "deniedList", "Lcom/larus/platform/api/RequestPermissionDataCallback;", "requestNotificationPermission", "isLaunching", "hasPermissionRequest", "showGoSettingPageDialog", "subTitle", "callback", "Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;", "permissionAny", "goPermissionSettings", ComplianceResult.JsonKey.PERMISSIONS, "setInterceptGoToSettingsDialog", "intercept", "shouldShowRequestPermissionListRationale", "manifests", "getDescriptionByPermission", "hasAllFilesAccessPermission", "isPartAlbumAccess", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isFullAlbumAccess", "getPermissionName", "openCommonAppPermissionPage", "openFileAccessPermissionPage", "openPermissionSettingsByCandidates", "intentCandidates", "Landroid/content/Intent;", "scene", "fragmentActivity", "Lcom/larus/permission/api/IPermissionX$IRequestPermissionCallback;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IObricPermissionServiceImpl implements IObricPermissionService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f391054b = 0;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IObricPermissionService.a f391055a;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
        }

        public b(IObricPermissionService.a r100) {
            this.f391055a = r100;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            this.f391055a.a(false, r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class c implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<String> f391056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IObricPermissionService.a f391057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IObricPermissionServiceImpl f391058c;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
            List<String> r100 = this.f391056a;
            IObricPermissionServiceImpl r101 = this.f391058c;
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r100.iterator();
        L4:
            if (r103.hasNext() == false) goto L8;
            Object r104 = r103.next();
            if (r101.checkPermission((String) r104) == false) goto L4;
            r102.add(r104);
            goto L4
        L8:
            List<String> r105 = this.f391056a;
            IObricPermissionServiceImpl r106 = this.f391058c;
            ArrayList r107 = new ArrayList();
            Iterator<T> r108 = r105.iterator();
        L10:
            if (r108.hasNext() == false) goto L14;
            Object r109 = r108.next();
            if (r106.checkPermission((String) r109) == true) goto L10;
            r107.add(r109);
            goto L10
        L14:
            boolean r110 = true;
            if ((!r102.isEmpty()) == true) goto L17;
        L19:
            r110 = false;
        L20:
            this.f391057b.a(false, r110, r102, r107);
            return;
        L17:
            if (r107.isEmpty() == false) goto L19;
            goto L19
        }

        public c(List<String> r100, IObricPermissionService.a r101, IObricPermissionServiceImpl r102) {
            this.f391056a = r100;
            this.f391057b = r101;
            this.f391058c = r102;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class d implements IPermissionX.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g1.b f391059a;

        @Override // com.larus.permission.api.IPermissionX.a
        public final void a(boolean r100, String r101) {
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void b(String r100) {
        }

        @Override // com.larus.permission.api.IPermissionX.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void onSettingPageReturn() {
            g1.b r100 = this.f391059a;
            if (r100 == null) goto L6;
            r100.onSettingPageReturn();
            return;
        }

        public d(g1.b r100) {
            this.f391059a = r100;
        }
    }

    static {
    }

    public IObricPermissionServiceImpl() {
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final void c() {
        ObricPrivacyAndPermissionUiDelegate.f392909b.c();
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final IObricPermissionService.Companion.ObricPermissionStatus h() {
        AppHost.Companion r100 = AppHost.f326268a;
        r100.getApplication();
        int r101 = Build.VERSION.SDK_INT;
        boolean r102 = true;
        if (r101 >= 33) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L27;
        r100.getApplication();
        if (r101 < 34) goto L22;
        boolean r104 = checkPermission("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
        boolean r105 = checkPermission(BaseConstants.PERMISSION_READ_MEDIA_IMAGES);
        if (checkPermission(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L18;
        if (r105 == false) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L22;
        if (r104 == false) goto L22;
    L23:
        if (r102 == false) goto L26;
        return IObricPermissionService.Companion.ObricPermissionStatus.LIMITED_GRANTED;
    L26:
        return IObricPermissionService.Companion.ObricPermissionStatus.DENIED;
    L18:
        r106 = false;
    L22:
        r102 = false;
        goto L23
    L27:
        return IObricPermissionService.Companion.ObricPermissionStatus.GRANTED;
    L5:
        if (checkPermission(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == false) goto L9;
        if (checkPermission(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L9;
        r103 = true;
        goto L10
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final boolean o() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        boolean r101 = false;
        if (Settings.Secure.getInt(AppHost.f326268a.getApplication().getContentResolver(), "oem_installed_apps_runtime_permission_enable", 0) != 1) goto L6;
        r101 = true;
    L6:
        FLogger.f375446a.w("IObricPermissionServiceImpl", "isOEMSupportAppListPermission ret: " + r101);     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        FLogger.f375446a.w("IObricPermissionServiceImpl", "isOEMSupportAppListPermission failed: " + r103.getMessage(), r103);
    L13:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L17;
        r102 = r104;
    L17:
        return ((Boolean) r102).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static String p(String r100) {
        switch(r100.hashCode()) {
            case -2062386608: goto L78;
            case -1928411001: goto L74;
            case -1925850455: goto L70;
            case -1921431796: goto L66;
            case -1888586689: goto L62;
            case -1813079487: goto L58;
            case -1446288141: goto L54;
            case -1142799244: goto L50;
            case -909527021: goto L46;
            case -798669607: goto L43;
            case -63024214: goto L39;
            case 175802396: goto L36;
            case 603653886: goto L32;
            case 710297143: goto L28;
            case 1166454870: goto L25;
            case 1780337063: goto L21;
            case 1831139720: goto L17;
            case 1977429404: goto L13;
            case 2024715147: goto L9;
            case 2062356686: goto L6;
            default: goto L81;
        };
    L81:
        return "";
    L6:
        if (r100.equals("android.permission.BLUETOOTH_SCAN") == false) goto L81;
    L48:
        String r101 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_bluetooth_connect_permission);
        Intrinsics.checkNotNull(r101);
        return r101;
    L9:
        if (r100.equals("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L81;
        String r102 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_get_location_permission);
        Intrinsics.checkNotNull(r102);
        return r102;
    L13:
        if (r100.equals("android.permission.READ_CONTACTS") == false) goto L81;
        String r103 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_contact_permission);
        Intrinsics.checkNotNull(r103);
        return r103;
    L17:
        if (r100.equals("android.permission.RECORD_AUDIO") == false) goto L81;
        String r104 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_read_audio_permission);
        Intrinsics.checkNotNull(r104);
        return r104;
    L21:
        if (r100.equals("android.permission.ACTIVITY_RECOGNITION") == false) goto L81;
        String r105 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_body_sensor_permission);
        Intrinsics.checkNotNull(r105);
        return r105;
    L25:
        if (r100.equals("android.permission.BLUETOOTH_ADVERTISE") == true) goto L48;
    L28:
        if (r100.equals(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L81;
        String r106 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_album_video_permission);
        Intrinsics.checkNotNull(r106);
        return r106;
    L32:
        if (r100.equals("android.permission.WRITE_CALENDAR") == false) goto L81;
        String r107 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_write_calendar_permission);
        Intrinsics.checkNotNull(r107);
        return r107;
    L36:
        if (r100.equals(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == false) goto L81;
    L52:
        String r108 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_album_permission);
        Intrinsics.checkNotNull(r108);
        return r108;
    L39:
        if (r100.equals("android.permission.ACCESS_COARSE_LOCATION") == false) goto L81;
        String r109 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_get_location_permission);
        Intrinsics.checkNotNull(r109);
        return r109;
    L43:
        if (r100.equals("android.permission.BLUETOOTH_CONNECT") == true) goto L48;
    L46:
        if (r100.equals("android.permission.NEARBY_WIFI_DEVICES") == true) goto L48;
    L50:
        if (r100.equals("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == true) goto L52;
    L54:
        if (r100.equals("com.android.permission.GET_INSTALLED_APPS") == false) goto L81;
        String r110 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_read_app_list_permission);
        Intrinsics.checkNotNull(r110);
        return r110;
    L58:
        if (r100.equals("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L81;
        String r111 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_file_manage_permission);
        Intrinsics.checkNotNull(r111);
        return r111;
    L62:
        if (r100.equals("android.permission.ACCESS_FINE_LOCATION") == false) goto L81;
        String r112 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_get_location_permission);
        Intrinsics.checkNotNull(r112);
        return r112;
    L66:
        if (r100.equals("android.permission.READ_CALL_LOG") == false) goto L81;
        String r113 = AppHost.f326268a.getApplication().getString(R.string.obric_init_batch_request_open_call_log_permission);
        Intrinsics.checkNotNull(r113);
        return r113;
    L70:
        if (r100.equals("android.permission.POST_NOTIFICATIONS") == false) goto L81;
        String r114 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_post_notification_permission);
        Intrinsics.checkNotNull(r114);
        return r114;
    L74:
        if (r100.equals("android.permission.READ_CALENDAR") == false) goto L81;
        String r115 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_read_calendar_permission);
        Intrinsics.checkNotNull(r115);
        return r115;
    L78:
        if (r100.equals("android.permission.READ_SMS") == false) goto L81;
        String r116 = AppHost.f326268a.getApplication().getString(R.string.obric_init_batch_request_open_message_permission);
        Intrinsics.checkNotNull(r116);
        return r116;
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final boolean checkPermission(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        if (Intrinsics.areEqual(r100, "android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L19;
        if (Build.VERSION.SDK_INT >= 30) goto L23;
        AppHost.Companion r101 = AppHost.f326268a;
        if (ContextCompat.checkSelfPermission(r101.getApplication(), "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L10;
        boolean r102 = true;
    L12:
        if (ContextCompat.checkSelfPermission(r101.getApplication(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L14;
        boolean r103 = true;
    L15:
        if (r102 == false) goto L21;
        if (r103 == false) goto L21;
        return true;
    L21:
        return false;
    L14:
        r103 = false;
        goto L15
    L10:
        r102 = false;
        goto L12
    L23:
        return Environment.isExternalStorageManager();
    L19:
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), r100) != 0) goto L21;
        return true;
    }

    @Override // com.larus.platform.api.g1
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        return i2.f365748b.d(r100);
    }

    @Override // com.larus.platform.api.g1
    public final void f(boolean r100) {
        i2.f365748b.f(r100);
    }

    public static void q(FragmentActivity r100, g1.c r101) {
        String r102 = AppHost.f326268a.getApplication().getPackageName();
        ArrayList r103 = new ArrayList();
        if (t9a.b.a().b() == false) goto L5;
    L7:
        Intent r104 = new Intent("android.intent.action.MANAGE_APP_PERMISSIONS");
        r104.putExtra("android.intent.extra.PACKAGE_NAME", r102);
        r103.add(r104);
        r(r100, r103, r101, "openCommonAppPermissionPage");
        return;
    L5:
        if (StringsKt.equals(Build.MANUFACTURER, "Xiaomi", true) == false) goto L7;
        Intent r105 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        r105.putExtra("extra_pkgname", r102);
        r105.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
        r103.add(r105);
        goto L7
    }

    @Override // com.larus.platform.api.g1
    public final void i(FragmentActivity r100, g1.c r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        i2.f365748b.i(r100, r101);
    }

    @Override // com.larus.platform.api.g1
    public final void a(FragmentActivity r100, List<String> r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        i2.f365748b.a(r100, r101, r102);
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final void e(FragmentActivity r100, List<String> r101, g1.c r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        FLogger.f375446a.i("IObricPermissionServiceImpl", "goPermissionSettings with custom landing, permissions: " + r101);
        if (r101.contains("android.permission.MANAGE_EXTERNAL_STORAGE") == true) goto L5;
        q(r100, r102);
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 30) goto L7;
        q(r100, r102);
        return;
    L7:
        String r103 = AppHost.f326268a.getApplication().getPackageName();
        ArrayList r104 = new ArrayList();
        Intent r105 = new Intent();
        r105.setComponent(new ComponentName("com.android.permissioncontroller", "com.android.permissioncontroller.permissionplus.ui.AppAllPermissionsActivity"));
        r105.putExtra("PACKAGE_NAME", r103);
        r104.add(r105);
        Intent r106 = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        r106.setData(UriProtector.parse("package:" + r103));
        r104.add(r106);
        r104.add(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
        if (r(r100, r104, r102, "openFileAccessPermissionPage") == true) goto L13;
        q(r100, r102);
        return;
    }

    @Override // com.larus.platform.api.g1
    public final void m(FragmentActivity r100, List<String> r101, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        i2.f365748b.m(r100, r101, r102);
    }

    public static boolean r(FragmentActivity r100, List r101, final g1.c r110, String r111) {
        IObricAssistantUtilHelperService r102 = (IObricAssistantUtilHelperService) ServiceManager.get().getService(IObricAssistantUtilHelperService.class);
        if (r102 != null) goto L8;
        FLogger.f375446a.w("IObricPermissionServiceImpl", r111.concat(" helper service is null"));
        if (r110 == null) goto L7;
        r110.onSettingPageReturn();
    L7:
        return false;
    L8:
        PackageManager r103 = r100.getPackageManager();
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        Intent r105 = (Intent) r104.next();
        List<ResolveInfo> r106 = r103.queryIntentActivities(r105, 65536);
        FLogger.f375446a.i("IObricPermissionServiceImpl", r111 + " intent: " + r105 + ", resolveListEmpty: " + r106.isEmpty());
        if ((!r106.isEmpty()) == false) goto L10;
        r102.startActivityForResult(r105, new mfa.c(r110), new mfa.d(r110));
        return true;
    L15:
        if (r110 == null) goto L17;
        r110.onSettingPageReturn();
    L17:
        return false;
    }

    @Override // com.larus.platform.api.g1
    public final void b(Fragment r100, List<String> r101, Function1<? super Boolean, Unit> r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
    }

    @Override // com.larus.platform.api.g1
    public final void l(FragmentActivity r100, String r101, String r102, g1.b r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "permission");
        boolean r103 = false;
        if (r102 == null) goto L5;
        MapsKt.mutableMapOf(new Pair[]{new Pair(r101, r102)});
    L5:
        d r104 = new d(r110);
        switch(r101.hashCode()) {
            case -2062386608: goto L35;
            case -1928411001: goto L31;
            case -1921431796: goto L27;
            case -1813079487: goto L23;
            case -1142799244: goto L19;
            case 175802396: goto L16;
            case 710297143: goto L13;
            case 1977429404: goto L9;
            default: goto L38;
        };
    L38:
        String r111 = "";
    L39:
        String r105 = p(r101);
        String r106 = r100.getString(R.string.larus_microphone_authorization_settings_noninitial);
        String r107 = r100.getString(R.string.larus_microphone_authorization_cancel_noninitial);
        if (r111.length() != 0) goto L42;
        boolean r108 = true;
    L43:
        if (r108 == true) goto L45;
    L49:
        Ref.BooleanRef r109 = new Ref.BooleanRef();
        CommonDialog.a r112 = new CommonDialog.a();
        Intrinsics.checkNotNullParameter(r111, "title");
        r112.f327172a = r111;
        r112.g(r105);
        CommonDialog.a.e(r112, new e(), r107, 4);
        CommonDialog.a.f(r112, new f(r109, r100, r104), r106, true, 8);
        g r113 = new g(r104, r109);
        Intrinsics.checkNotNullParameter(r113, "listener");
        r112.f327195x = r113;
        CommonDialog r114 = r112.b(ContextCompat.getColor(r100, R.color.larus_primary_50));
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L60;
        FragmentManager r115 = r100.getSupportFragmentManager();
        LandscapeRestrictionOperation r116 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r114, "PermissionXGoSettingDialog", r116);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r115, r114, r116) == true) goto L62;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L57
    L55:
        r114.show(r115, "PermissionXGoSettingDialog");
        return;
    L62:
        return;
    L60:
        return;
    L45:
        if (r105.length() != 0) goto L47;
        r103 = true;
    L47:
        if (r103 == false) goto L49;
        return;
    L42:
        r108 = false;
        goto L43
    L9:
        if (r101.equals("android.permission.READ_CONTACTS") == false) goto L38;
        r111 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_need_contact_permission);
        Intrinsics.checkNotNull(r111);
        goto L39
    L13:
        if (r101.equals(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L38;
    L21:
        r111 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_need_album_permission);
        Intrinsics.checkNotNull(r111);
        goto L39
    L16:
        if (r101.equals(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == true) goto L21;
    L19:
        if (r101.equals("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == true) goto L21;
    L23:
        if (r101.equals("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L38;
        r111 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_need_file_manage_permission);
        Intrinsics.checkNotNull(r111);
        goto L39
    L27:
        if (r101.equals("android.permission.READ_CALL_LOG") == false) goto L38;
        r111 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_need_call_log_permission);
        Intrinsics.checkNotNull(r111);
        goto L39
    L31:
        if (r101.equals("android.permission.READ_CALENDAR") == false) goto L38;
        r111 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_need_calendar_permission);
        Intrinsics.checkNotNull(r111);
        goto L39
    L35:
        if (r101.equals("android.permission.READ_SMS") == false) goto L38;
        r111 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_need_message_permission);
        Intrinsics.checkNotNull(r111);
        goto L39
    }

    @Override // com.larus.platform.api.g1
    public final void j(Fragment r100, FragmentActivity r101, List<String> r110, JSONObject r111, g1.c r112) {
        Intrinsics.checkNotNullParameter(r110, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r112, "requestCallBack");
        i2.f365748b.j(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.platform.api.g1
    public final void k(Fragment r100, List<String> r101, g1.c r110, Map<String, String> r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r110, "requestCallBack");
        i2.f365748b.k(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.platform.api.g1
    public final void g(FragmentActivity r100, List<String> r110, g1.c r111, Map<String, String> r112, JSONObject r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r111, "requestCallBack");
        i2.f365748b.g(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final void n(FragmentActivity r110, List<String> r111, boolean r112, boolean r210, boolean r211, boolean r212, final IObricPermissionService.a r213) {
        Intrinsics.checkNotNullParameter(r111, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r213, "requestDataCallBack");
        if (r110 != null) goto L103;
        return;
    L103:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        String r101 = t9a.b.a().d();     // Catch: Throwable -> L8
        FLogger.f375446a.i("IObricPermissionServiceImpl", "isGenesisRProduct " + r101);     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(r101, "Genesis-R")));     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        FLogger.f375446a.w("IObricPermissionServiceImpl", "isGenesisRProduct failed: " + r103.getMessage(), r103);
    L13:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L16;
        r102 = r104;
    L16:
        boolean r105 = true;
        if (((Boolean) r102).booleanValue() == true) goto L105;
        ResolveInfo r106 = r110.getPackageManager().resolveActivity(new Intent("com.android.permissioncontroller.action.BATCH_PERMISSION_GRANT"), 65536);
        FLogger r107 = FLogger.f375446a;
        r107.i("IObricPermissionServiceImpl", "checkResolveInfo, " + r106);
        if (r106 == null) goto L82;
        ActivityInfo r113 = r106.activityInfo;
        if (r113 == null) goto L74;
        ApplicationInfo r114 = r113.applicationInfo;
        if (r114 == null) goto L74;
        if ((r114.flags & 129) == 0) goto L72;
        boolean r115 = true;
    L73:
        r107.i("IObricPermissionServiceImpl", "isSystemResolveInfo pkg=" + r114.packageName + ", isSystem=" + r115);
    L75:
        if (r115 == false) goto L82;
        ActivityInfo r108 = r106.activityInfo;
        String[] r109 = (String[]) CollectionsKt.distinct(r111).toArray(new String[0]);
        ArrayList r116 = new ArrayList(r109.length);
        int r117 = r109.length;
        int r118 = 0;
    L77:
        if (r118 >= r117) goto L79;
        r116.add(p(r109[r118]));
        r118 = r118 + 1;
        goto L77
    L79:
        String[] r119 = (String[]) r116.toArray(new String[0]);
        final Intent r120 = new Intent("com.android.permissioncontroller.action.BATCH_PERMISSION_GRANT");
        r120.setComponent(new ComponentName(r108.packageName, r108.name));
        r120.putExtra("com.android.permissioncontroller.extra.PERMISSION_LIST", r109);
        r120.putExtra("com.android.permissioncontroller.extra.PERMISSION_DESCRIPTIONS", r119);
        r120.putExtra("com.android.permissioncontroller.extra.SHOW_GRANTED_PERMISSIONS", r112);
        r120.putExtra("com.android.permissioncontroller.extra.SHOW_ICON", r210);
        IObricAssistantUtilHelperService r121 = (IObricAssistantUtilHelperService) ServiceManager.get().getService(IObricAssistantUtilHelperService.class);
        if (r121 == null) goto L116;
        r121.startActivityForResult(r120, new mfa.a(r120, r213), null);
        return;
    L116:
        return;
    L72:
        r115 = false;
    L74:
        r115 = false;
    L82:
        if (r211 == true) goto L85;
        r107.w("IObricPermissionServiceImpl", "not support batch request permission, skip");
        r213.a(true, false, new ArrayList(), new ArrayList());
        return;
    L85:
        List<String> r122 = CollectionsKt.distinct(r111);
        List<String> r123 = r122;
        if ((r123 instanceof Collection) == true) goto L88;
    L90:
        Iterator<T> r124 = r123.iterator();
    L92:
        if (r124.hasNext() == false) goto L96;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r110, (String) r124.next()) == true) goto L92;
        r105 = false;
    L96:
        FLogger.f375446a.w("IObricPermissionServiceImpl", "not support batch request permission, fallback to single request, shouldShowRequest: " + r105 + ", forceRuntimeRequestOnFallback: " + r212);
        if (r105 == true) goto L101;
        if (r212 == true) goto L101;
        e(r110, r122, new c(r122, r213, this));
        return;
    L101:
        i2 r125 = i2.f365748b;
        g1.a.b(r110, r122, new b(r213), null, null, 24);
        return;
    L88:
        if (r123.isEmpty() == false) goto L90;
    L105:
        ApplicationInfo r126 = r110.getPackageManager().getApplicationInfo("com.miui.securitycenter", 128);     // Catch: Throwable -> L29
        Bundle r127 = r126.metaData;     // Catch: Throwable -> L29
        if (r127 == null) goto L22;
        int r128 = r127.getInt("combine_permission_version");     // Catch: Throwable -> L29
    L23:
        FLogger r129 = FLogger.f375446a;     // Catch: Throwable -> L29
        r129.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui appInfo: " + r126);     // Catch: Throwable -> L29
        r129.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui appInfo.metadata: " + r126.metaData);     // Catch: Throwable -> L29
        r129.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui combinePermissionVersion: " + r128);     // Catch: Throwable -> L29
        Bundle r130 = r126.metaData;     // Catch: Throwable -> L29
        if (r130 == null) goto L26;
        boolean r131 = r130.getBoolean("supportCombinePermission", false);     // Catch: Throwable -> L29
    L27:
        Object r132 = Result.m9449constructorimpl(Boolean.valueOf(r131));     // Catch: Throwable -> L29
    L31:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);
        if (r133 == null) goto L34;
        FLogger.f375446a.w("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui get meta failed: " + r133.getMessage(), r133);
    L34:
        Boolean r134 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r132) == false) goto L38;
        r132 = r134;
    L38:
        if (((Boolean) r132).booleanValue() == true) goto L40;
        FLogger.f375446a.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui not supported");
        r213.a(true, false, new ArrayList(), new ArrayList());
        return;
    L40:
        String[] r135 = (String[]) CollectionsKt.distinct(r111).toArray(new String[0]);
        ArrayList r136 = new ArrayList(r135.length);
        int r137 = r135.length;
        int r138 = 0;
    L41:
        if (r138 >= r137) goto L43;
        r136.add(p(r135[r138]));
        r138 = r138 + 1;
        goto L41
    L43:
        String[] r139 = (String[]) r136.toArray(new String[0]);
        Intent r140 = new Intent("miui.intent.action.REQUEST_PERMISSIONS_COMBINE");
        r140.setPackage("com.miui.securitycenter");
        r140.putExtra("miui.intent.extra.PERMISSIONS_DIALOG_DESC", "");
        r140.putExtra("miui.intent.extra.REQUEST_PERMISSIONS_NAMES", r135);
        r140.putExtra("miui.intent.extra.REQUEST_PERMISSIONS_NAMES_DESC", r139);
        r140.putExtra("miui.intent.extra.PERMISSION_FORCE_SHOW", true);
        ResolveInfo r141 = r110.getPackageManager().resolveActivity(r140, 65536);
        if (r141 != null) goto L46;
        FLogger.f375446a.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui resolveActivity null");
        r213.a(true, false, new ArrayList(), new ArrayList());
        return;
    L46:
        ActivityInfo r142 = r141.activityInfo;
        if (r142 == null) goto L49;
        String r143 = r142.packageName;
    L51:
        if (Intrinsics.areEqual(r143, "com.miui.securitycenter") == true) goto L57;
        FLogger r144 = FLogger.f375446a;
        StringBuilder r145 = new StringBuilder("tryRequestCombinePermissionByMiui resolveActivity not security center: ");
        ActivityInfo r146 = r141.activityInfo;
        if (r146 == null) goto L55;
        String r147 = r146.packageName;
    L56:
        r145.append(r147);
        r144.w("IObricPermissionServiceImpl", r145.toString());
        r213.a(true, false, new ArrayList(), new ArrayList());
        return;
    L55:
        r147 = null;
        goto L56
    L57:
        IObricAssistantUtilHelperService r148 = (IObricAssistantUtilHelperService) ServiceManager.get().getService(IObricAssistantUtilHelperService.class);
        if (r148 != null) goto L60;
        FLogger.f375446a.w("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui helper service null");
        r213.a(true, false, new ArrayList(), new ArrayList());
        return;
    L60:
        FLogger.f375446a.i("IObricPermissionServiceImpl", "miui combine permission, intent: " + r140.getExtras());
        r148.startActivityForResult(r140, new mfa.b(r213), null);
        return;
    L49:
        r143 = null;
        goto L51
    L26:
        r131 = false;
        goto L27
    L22:
        r128 = 0;
    L29:
        th = move-exception;
        Result.Companion r149 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
