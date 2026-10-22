package com.larus.home.impl.sdk;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.pia.core.metrics.ErrorType;
import com.ixigua.lib.track.TrackParams;
import com.larus.permission.api.IPermissionX;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class w0 implements com.larus.platform.api.g1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w0 f346256b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f346257c = null;

    public static final class a implements IPermissionX.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.platform.api.g1.c f346258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f346259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f346260c;

        @Override // com.larus.permission.api.IPermissionX.a
        public final void onSettingPageReturn() {
            this.f346258a.onSettingPageReturn();
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void b(String r100) {
            this.f346258a.onGoSettingsDialogShow();
            JSONObject r101 = this.f346260c;
            if (r101 == null) goto L17;
            int r102 = com.larus.utils.p0.f375454a;
            String r103 = com.larus.utils.p0.a(r101.optString("enter_method"));
            if (r103 == null) goto L18;
            jc9.a r104 = jc9.a.f498169a;
            JSONObject r105 = c(r100);
            Intrinsics.checkNotNullParameter(r103, "enterMethod");
            Intrinsics.checkNotNullParameter(r105, "params");
            String r106 = jc9.a.a(r100);
            if (r106 == null) goto L19;
            r105.put("permission_type", r106);     // Catch: JSONException -> L11
            r105.put("enter_method", r103);     // Catch: JSONException -> L11
        L13:
            FLogger.f375446a.i("PermissionEventHelper", "reportSystemPermissionPopupShow(type=" + r106 + ", enter=" + r103 + ')');
            TrackParams r107 = new TrackParams().merge(r105);
            by7.a r108 = new by7.a("system_permission_popup_show");
            r108.f21463a.merge(r107);
            r108.b();
            return;
        L11:
            e = move-exception;
            FLogger.f375446a.e("PermissionEventHelper", "reportSystemPermissionPopupShow error", e);
            goto L13
        L19:
            return;
        L18:
            return;
        }

        public final JSONObject c(String r100) {
            JSONObject r101 = new JSONObject();
            if (Intrinsics.areEqual(r100, "android.permission.RECORD_AUDIO") == false) goto L9;
            JSONObject r102 = this.f346260c;
            if (r102 == null) goto L7;
            Object r103 = r102.opt("record_scene");
        L8:
            r101.put("record_scene", r103);
            goto L9
        L7:
            r103 = null;
        L9:
            return r101;
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void a(boolean r100, String r101) {
            this.f346258a.onGoSettingsDialogDismiss(r100);
            JSONObject r102 = this.f346260c;
            if (r102 == null) goto L21;
            int r103 = com.larus.utils.p0.f375454a;
            String r104 = com.larus.utils.p0.a(r102.optString("enter_method"));
            if (r104 == null) goto L22;
            jc9.a r105 = jc9.a.f498169a;
            if (r100 == false) goto L9;
            String r106 = "setting";
        L10:
            JSONObject r107 = c(r101);
            Intrinsics.checkNotNullParameter(r104, "enterMethod");
            Intrinsics.checkNotNullParameter(r106, "clickFrom");
            Intrinsics.checkNotNullParameter(r107, "params");
            String r108 = jc9.a.a(r101);
            if (r108 == null) goto L23;
            r107.put("permission_type", r108);     // Catch: JSONException -> L15
            r107.put("enter_method", r104);     // Catch: JSONException -> L15
            r107.put("click_from", r106);     // Catch: JSONException -> L15
        L17:
            FLogger.f375446a.i("PermissionEventHelper", "reportSystemPermissionPopupClick(type=" + r108 + ", enter=" + r104 + ", clickFrom=" + r106 + ')');
            TrackParams r109 = new TrackParams().merge(r107);
            by7.a r110 = new by7.a("system_permission_popup_click");
            r110.f21463a.merge(r109);
            r110.b();
            return;
        L15:
            e = move-exception;
            FLogger.f375446a.e("PermissionEventHelper", "reportSystemPermissionPopupClick error", e);
            goto L17
        L23:
            return;
        L9:
            r106 = "cancel";
            goto L10
        L22:
            return;
        }

        public a(com.larus.platform.api.g1.c r100, boolean r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.f346258a = r100;
            this.f346259b = r101;
            this.f346260c = r102;
        }

        @Override // com.larus.permission.api.IPermissionX.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            if (this.f346259b == false) goto L16;
            JSONObject r104 = this.f346260c;
            if (r104 == null) goto L9;
            boolean r105 = true;
            if (r104.has(BdpAppEventConstant.PARAMS_AUTH_TYPE) != true) goto L9;
        L10:
            if (r105 == false) goto L15;
            if (r100 == false) goto L13;
            Object r106 = this.f346260c.opt(BdpAppEventConstant.PARAMS_AUTH_TYPE);
        L14:
            this.f346260c.put(LocationMonitorConst.AUTH_STATUS, r106);
            goto L15
        L13:
            r106 = "refuse";
        L15:
            jc9.a r107 = jc9.a.f498169a;
            jc9.a.c(r100, this.f346260c);
        L9:
            r105 = false;
        L16:
            this.f346258a.onResult(r100, r101, r102, r103);
        }
    }

    public static final class b implements IPermissionX.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.larus.platform.api.g1.c f346261a;

        @Override // com.larus.permission.api.IPermissionX.a
        public final void a(boolean r100, String r101) {
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void b(String r100) {
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void onSettingPageReturn() {
        }

        public b(com.larus.platform.api.g1.c r100) {
            this.f346261a = r100;
        }

        @Override // com.larus.permission.api.IPermissionX.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            com.larus.platform.api.g1.c r104 = this.f346261a;
            if (r104 == null) goto L6;
            r104.onResult(r100, r101, r102, r103);
            return;
        }
    }

    public static final class c implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f346262a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Boolean, Unit> r100) {
            this.f346262a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean r100) {
            boolean r101 = r100.booleanValue();
            this.f346262a.invoke(Boolean.valueOf(r101));
            jc9.a r102 = jc9.a.f498169a;
            jc9.a.c(r101, null);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Function3<Boolean, List<? extends String>, List<? extends String>, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function3<Boolean, List<String>, List<String>, Unit> f346263a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r100) {
            this.f346263a = r100;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(Boolean r100, List<? extends String> r101, List<? extends String> r102) {
            boolean r103 = r100.booleanValue();
            List<? extends String> r104 = r101;
            List<? extends String> r105 = r102;
            Intrinsics.checkNotNullParameter(r104, "grantedList");
            Intrinsics.checkNotNullParameter(r105, "deniedList");
            jc9.a r106 = jc9.a.f498169a;
            jc9.a.c(r103, null);
            this.f346263a.invoke(Boolean.valueOf(r103), (List<String>) r104, (List<String>) r105);
            return Unit.INSTANCE;
        }
    }

    public static final class e implements IPermissionX.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.larus.platform.api.g1.b f346264a;

        @Override // com.larus.permission.api.IPermissionX.a
        public final void onSettingPageReturn() {
            com.larus.platform.api.g1.b r100 = this.f346264a;
            if (r100 == null) goto L6;
            r100.onSettingPageReturn();
            return;
        }

        public e(com.larus.platform.api.g1.b r100) {
            this.f346264a = r100;
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void b(String r100) {
            com.larus.platform.api.g1.b r101 = this.f346264a;
            if (r101 == null) goto L6;
            r101.onGoSettingsDialogShow();
            return;
        }

        @Override // com.larus.permission.api.IPermissionX.a
        public final void a(boolean r100, String r101) {
            com.larus.platform.api.g1.b r102 = this.f346264a;
            if (r102 == null) goto L6;
            r102.onGoSettingsDialogDismiss(r100);
            return;
        }
    }

    public w0() {
    }

    static {
        f346256b = new w0();
        f346257c = w0.class.getSimpleName();
    }

    public static boolean p(List r100) {
        if (Build.VERSION.SDK_INT < 29) goto L12;
        if (r100.contains("android.permission.ACCESS_COARSE_LOCATION") == false) goto L7;
    L17:
        return true;
    L7:
        if (r100.contains("android.permission.ACCESS_FINE_LOCATION") == true) goto L17;
        if (r100.contains("android.permission.ACCESS_BACKGROUND_LOCATION") == true) goto L17;
    L16:
        return false;
    L12:
        if (r100.contains("android.permission.ACCESS_COARSE_LOCATION") == true) goto L17;
        if (r100.contains("android.permission.ACCESS_FINE_LOCATION") == false) goto L16;
        goto L16
    }

    @Override // com.larus.platform.api.g1
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        return IPermissionX.f363962a.d(r100);
    }

    @Override // com.larus.platform.api.g1
    public final void f(boolean r100) {
        if (r100 == false) goto L10;
        FLogger.f375446a.i(f346257c, "requestNotificationPermission forbit cause launching");
        return;
    L10:
        ThreadPlus.submitRunnable(new v0());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e(f346257c, "tryRequestNotificationPermission error", e);
    }

    @Override // com.larus.platform.api.g1
    public final void i(FragmentActivity r100, com.larus.platform.api.g1.c r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        IPermissionX.f363962a.j(r100, new b(r101));
    }

    @Override // com.larus.platform.api.g1
    public final void a(FragmentActivity r100, List<String> r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        IPermissionX.f363962a.a(r100, r101, r102);
    }

    @Override // com.larus.platform.api.g1
    public final void m(FragmentActivity r100, List<String> r101, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        if (p(r101) == false) goto L5;
        jc9.a r103 = jc9.a.f498169a;
        jc9.a.d(null);
        IPermissionX.f363962a.e(r100, r101, new d(r102));
        return;
    L5:
        IPermissionX.f363962a.e(r100, r101, r102);
    }

    @Override // com.larus.platform.api.g1
    public final void b(Fragment r100, List<String> r101, Function1<? super Boolean, Unit> r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        if (p(r101) == false) goto L5;
        jc9.a r104 = jc9.a.f498169a;
        jc9.a.d(null);
        IPermissionX.f363962a.b(r100, r101, new c(r102), r103);
        return;
    L5:
        IPermissionX.f363962a.b(r100, r101, r102, r103);
    }

    @Override // com.larus.platform.api.g1
    public final void l(FragmentActivity r100, String r101, String r102, com.larus.platform.api.g1.b r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "permission");
        IPermissionX.f363962a.f(r100, r101, r102, new e(r103));
    }

    @Override // com.larus.platform.api.g1
    public final void j(Fragment r100, FragmentActivity r101, List<String> r102, JSONObject r103, com.larus.platform.api.g1.c r104) {
        Intrinsics.checkNotNullParameter(r102, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r104, "requestCallBack");
        a r105 = new a(r104, false, r103);
        IPermissionX.f363962a.h(r100, r101, r102, r105);
    }

    @Override // com.larus.platform.api.g1
    public final void k(Fragment r100, List<String> r101, com.larus.platform.api.g1.c r102, Map<String, String> r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r101, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r102, "requestCallBack");
        boolean r105 = p(r101);
        if (r105 == false) goto L5;
        jc9.a r106 = jc9.a.f498169a;
        jc9.a.d(r104);
    L5:
        a r107 = new a(r102, r105, r104);
        IPermissionX.f363962a.l(r100, r101, r107, r103);
    }

    @Override // com.larus.platform.api.g1
    public final void g(FragmentActivity r100, List<String> r110, com.larus.platform.api.g1.c r111, Map<String, String> r112, JSONObject r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(r111, "requestCallBack");
        boolean r101 = p(r110);
        if (r101 == false) goto L5;
        jc9.a r102 = jc9.a.f498169a;
        jc9.a.d(r113);
    L5:
        a r103 = new a(r111, r101, r113);
        IPermissionX.f363962a.i(r100, r110, r103, r112, r114);
    }
}
