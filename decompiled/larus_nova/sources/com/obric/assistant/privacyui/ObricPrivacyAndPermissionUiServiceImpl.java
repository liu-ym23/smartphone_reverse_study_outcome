package com.obric.assistant.privacyui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import ofa.a;
import ofa.c;
import t9a.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u008f\u0001\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132u\u0010\u0014\u001aq\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\f0\u0015H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/assistant/privacyui/ObricPrivacyAndPermissionUiServiceImpl;", "Lcom/obric/assistant/spi/security/privacypermission/IObricPrivacyAndPermissionUiService;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "systemPermissionItemsController", "Lcom/obric/assistant/privacyui/ObricSystemPermissionItemsController;", "interceptGoToSettingsDialog", "", "setInterceptGoToSettingsDialog", "", "intercept", "shouldInterceptGoToSettingsDialog", "setupObricSystemPermissionItems", "host", "Landroidx/fragment/app/Fragment;", "itemsStub", "Landroid/view/ViewStub;", "onRequestGoSettings", "Lkotlin/Function5;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "permissionType", "title", "message", "confirmText", "releaseObricSystemPermissionItems", "isPermissionRequestUiCustomizeEnabled", "getPermissionRequestUiDialogTitle", "type", "getPermissionRequestUiDialogSubtitle", "getNotesDisplayName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyAndPermissionUiServiceImpl implements IObricPrivacyAndPermissionUiService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f391158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f391159c;

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void c() {
        this.f391159c = true;
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final boolean d() {
        FLogger.f375446a.i(this.f391157a, "shouldInterceptGoToSettingsDialog: " + this.f391159c);
        boolean r100 = this.f391159c;
        if (r100 == false) goto L5;
        this.f391159c = false;
    L5:
        return r100;
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void e() {
        this.f391158b.b();
    }

    public ObricPrivacyAndPermissionUiServiceImpl() {
        this.f391157a = "ObricPrivacyAndPermissionUiServiceImpl";
        this.f391158b = new c();
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String a() {
        if (b.a().b() == false) goto L5;
        String r100 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_notes);
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        String r101 = AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_setting_data_source_notes_gr);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        switch(r100.hashCode()) {
            case -2062386608: goto L56;
            case -1928411001: goto L52;
            case -1921431796: goto L48;
            case -1888586689: goto L44;
            case -1446288141: goto L40;
            case -798669607: goto L37;
            case -63024214: goto L34;
            case 175802396: goto L30;
            case 603653886: goto L26;
            case 710297143: goto L23;
            case 1166454870: goto L20;
            case 1831139720: goto L16;
            case 1977429404: goto L12;
            case 2024715147: goto L9;
            case 2062356686: goto L6;
            default: goto L59;
        };
    L59:
        return null;
    L6:
        if (r100.equals("android.permission.BLUETOOTH_SCAN") == false) goto L59;
    L65:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_bluetooth_connect_permission);
    L9:
        if (r100.equals("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L59;
    L67:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_get_location_permission);
    L12:
        if (r100.equals("android.permission.READ_CONTACTS") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_contact_permission);
    L16:
        if (r100.equals("android.permission.RECORD_AUDIO") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_read_audio_permission);
    L20:
        if (r100.equals("android.permission.BLUETOOTH_ADVERTISE") == true) goto L65;
    L23:
        if (r100.equals(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L59;
    L64:
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_album_permission);
    L26:
        if (r100.equals("android.permission.WRITE_CALENDAR") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_write_calendar_permission);
    L30:
        if (r100.equals(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == true) goto L64;
    L34:
        if (r100.equals("android.permission.ACCESS_COARSE_LOCATION") == true) goto L67;
    L37:
        if (r100.equals("android.permission.BLUETOOTH_CONNECT") == false) goto L59;
    L40:
        if (r100.equals("com.android.permission.GET_INSTALLED_APPS") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_read_app_list_permission);
    L44:
        if (r100.equals("android.permission.ACCESS_FINE_LOCATION") == true) goto L67;
    L48:
        if (r100.equals("android.permission.READ_CALL_LOG") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_call_log_permission);
    L52:
        if (r100.equals("android.permission.READ_CALENDAR") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_read_calendar_permission);
    L56:
        if (r100.equals("android.permission.READ_SMS") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_fragment_personal_context_open_message_permission);
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        switch(r100.hashCode()) {
            case -2062386608: goto L56;
            case -1928411001: goto L52;
            case -1921431796: goto L48;
            case -1888586689: goto L44;
            case -1446288141: goto L40;
            case -798669607: goto L37;
            case -63024214: goto L34;
            case 175802396: goto L30;
            case 603653886: goto L26;
            case 710297143: goto L23;
            case 1166454870: goto L20;
            case 1831139720: goto L16;
            case 1977429404: goto L12;
            case 2024715147: goto L9;
            case 2062356686: goto L6;
            default: goto L59;
        };
    L59:
        return null;
    L6:
        if (r100.equals("android.permission.BLUETOOTH_SCAN") == false) goto L59;
    L65:
        return AppHost.f326268a.getApplication().getString(R.string.obric_bluetooth_authorization_topbar_title);
    L9:
        if (r100.equals("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L59;
    L67:
        return AppHost.f326268a.getApplication().getString(R.string.obric_location_authorization_topbar_title);
    L12:
        if (r100.equals("android.permission.READ_CONTACTS") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_contact_authorization_topbar_title);
    L16:
        if (r100.equals("android.permission.RECORD_AUDIO") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_microphone_authorization_topbar_title);
    L20:
        if (r100.equals("android.permission.BLUETOOTH_ADVERTISE") == true) goto L65;
    L23:
        if (r100.equals(BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L59;
    L64:
        return AppHost.f326268a.getApplication().getString(R.string.obric_album_authorization_topbar_title);
    L26:
        if (r100.equals("android.permission.WRITE_CALENDAR") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_calendar_authorization_topbar_title);
    L30:
        if (r100.equals(BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == true) goto L64;
    L34:
        if (r100.equals("android.permission.ACCESS_COARSE_LOCATION") == true) goto L67;
    L37:
        if (r100.equals("android.permission.BLUETOOTH_CONNECT") == false) goto L59;
    L40:
        if (r100.equals("com.android.permission.GET_INSTALLED_APPS") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_app_list_authorization_topbar_title);
    L44:
        if (r100.equals("android.permission.ACCESS_FINE_LOCATION") == true) goto L67;
    L48:
        if (r100.equals("android.permission.READ_CALL_LOG") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_call_log_authorization_topbar_title);
    L52:
        if (r100.equals("android.permission.READ_CALENDAR") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_calendar_authorization_topbar_title);
    L56:
        if (r100.equals("android.permission.READ_SMS") == false) goto L59;
        return AppHost.f326268a.getApplication().getString(R.string.obric_sms_authorization_topbar_title);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v20, types: [androidx.lifecycle.LifecycleObserver, ofa.a] */
    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void b(Fragment r100, ViewStub r110, Function5<? super View, ? super String, ? super String, ? super String, ? super String, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r110, "itemsStub");
        Intrinsics.checkNotNullParameter(r111, "onRequestGoSettings");
        final c r101 = this.f391158b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r110, "itemsStub");
        Intrinsics.checkNotNullParameter(r111, "onRequestGoSettings");
        r101.b();
        r110.setLayoutResource(R.layout.obric_privacy_system_permission_items);
        ViewParent r102 = r110.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r102;
    L6:
        if (r103 == null) goto L33;
        int r104 = r103.indexOfChild(r110);
        if (r104 < 0) goto L34;
        r103.removeViewAt(r104);
        int r112 = r110.getLayoutResource();
        if (r112 == 0) goto L35;
        int r105 = r103.getChildCount();
        LayoutInflater.from(r103.getContext()).inflate(r112, r103, true);
        int r113 = r103.getChildCount() - r105;
        if (r113 <= 0) goto L28;
        if (r104 >= r105) goto L28;
        ArrayList r106 = new ArrayList(r113);
        int r107 = 0;
        int r108 = 0;
    L18:
        if (r108 >= r113) goto L20;
        r106.add(r103.getChildAt(r105 + r108));
        r108 = r108 + 1;
        goto L18
    L20:
        Iterator r114 = r106.iterator();
    L22:
        if (r114.hasNext() == false) goto L24;
        r103.removeView((View) r114.next());
        goto L22
    L24:
        Iterator r115 = r106.iterator();
    L26:
        if (r115.hasNext() == false) goto L28;
        int r109 = r107 + 1;
        r103.addView((View) r115.next(), r107 + r104);
        r107 = r109;
    L28:
        r101.f523128a = (ItemTextArrow) r103.findViewById(R.id.obric_contact_permission_item);
        r101.f523129b = (ItemTextArrow) r103.findViewById(R.id.obric_call_log_permission_item);
        r101.f523130c = (ItemTextArrow) r103.findViewById(R.id.obric_sms_permission_item);
        r101.f523131d = (ItemTextArrow) r103.findViewById(R.id.obric_calendar_permission_item);
        r101.f523132e = r111;
        r101.a(r101.f523128a, "contact");
        r101.a(r101.f523129b, "call_log");
        r101.a(r101.f523130c, "sms");
        r101.a(r101.f523131d, "calendar");
        Lifecycle r116 = r100.getViewLifecycleOwner().getLifecycle();
        ?? r117 = new a(r101);
        r116.addObserver(r117);
        r101.f523133f = r116;
        r101.f523134g = r117;
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
