package com.larus.home.impl.route;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.api.AppletService;
import com.bytedance.ai.api.navi.IAppletNaviService;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.business.debug.api.IDebugService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlertDialog f346065a;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/home/impl/route/ThirdAppInterceptor$LocationDialogAppInfo;", "", "appName", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("appName")
        private final String appName;

        @SerializedName("text")
        private final String text;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.appName;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.text;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "LocationDialogAppInfo(appName=" + this.appName + ", text=" + this.text + ')';
        }

        public b() {
            this.appName = null;
            this.text = null;
        }

        public final String a() {
            return this.appName;
        }

        public final String b() {
            return this.text;
        }
    }

    static {
    }

    public c1() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (r100 == null) goto L10;
        String r101 = r100.f267533g;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (StringsKt.startsWith$default(r101, "/third_app", false, 2, null) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static boolean d(Context r100, com.bytedance.router.c r101) {
        if (r101 == null) goto L6;
        Uri r102 = r101.f267530d;
        if (r102 == null) goto L6;
        String r103 = UriProtector.getQueryParameter(r102, "backup_h5_url");
    L8:
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        return false;
    L16:
        com.bytedance.router.i r105 = SmartRouter.buildRoute(r100, "//flow/webview");
        r105.f267554c.putExtra("link_url", r103);
        r105.f267555d = R.anim.larus_router_slide_in_right;
        r105.f267556e = R.anim.larus_router_no_anim;
        r105.d();
        return true;
    L10:
        if (StringsKt.isBlank(r103) == true) goto L13;
        r104 = false;
    L6:
        r103 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r210, final com.bytedance.router.c r211) {
        if (ServiceManager.get().getService(IDebugService.class) == null) goto L9;
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("only debug mode log. handle: ");
        if (r211 == null) goto L7;
        String r102 = r211.f267529c;
    L8:
        r101.append(r102);
        r100.i("ThirdAppInterceptor", r101.toString());
        goto L9
    L7:
        r102 = null;
    L9:
        FLogger r103 = FLogger.f375446a;
        r103.i("ThirdAppInterceptor", "start to handle url");
        boolean r110 = true;
        if (r211 == null) goto L16;
        String r104 = r211.f267533g;
        if (r104 == null) goto L16;
        if (StringsKt.endsWith$default(r104, "navi", false, 2, null) != true) goto L16;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L57;
        if (r211 == null) goto L193;
        Uri r106 = r211.f267530d;
        if (r106 == null) goto L193;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r106, "handle_by_server"), "1") == false) goto L30;
        r103.i("ThirdAppInterceptor", "handle_by_server == 1");
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r106, "app_name"), "doubao") == false) goto L220;
        AppletService r107 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r107 == null) goto L220;
        JsonObject r108 = new JsonObject();
        r108.addProperty("pageId", "ll_nav_detail");
        JsonObject r109 = new JsonObject();
        r109.addProperty("from", "realtime_active");
        Unit r111 = Unit.INSTANCE;
        r108.add("pageData", r109);
        r107.a("flow.onOpenPageDemand", r108);
    L220:
        return r110;
    L30:
        IAppletNaviService r112 = (IAppletNaviService) ServiceManager.get().getService(IAppletNaviService.class);
        if (r112 == null) goto L193;
        String r113 = UriProtector.getQueryParameter(r106, PlayerResolution.SDKKEY.ORIGIN);
        if (r113 == null) goto L193;
        String r212 = UriProtector.getQueryParameter(r106, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r212 == null) goto L193;
        String r114 = UriProtector.getQueryParameter(r106, "olat");
        if (r114 == null) goto L193;
        Float r115 = StringsKt.toFloatOrNull(r114);
        if (r115 == null) goto L193;
        float r116 = r115.floatValue();
        String r117 = UriProtector.getQueryParameter(r106, "olon");
        if (r117 == null) goto L193;
        Float r118 = StringsKt.toFloatOrNull(r117);
        if (r118 == null) goto L193;
        float r119 = r118.floatValue();
        String r120 = UriProtector.getQueryParameter(r106, "dlat");
        if (r120 == null) goto L193;
        Float r121 = StringsKt.toFloatOrNull(r120);
        if (r121 == null) goto L193;
        float r213 = r121.floatValue();
        String r122 = UriProtector.getQueryParameter(r106, "dlon");
        if (r122 == null) goto L193;
        Float r123 = StringsKt.toFloatOrNull(r122);
        if (r123 == null) goto L193;
        r112.a(UriProtector.getQueryParameter(r106, "app_name"), UriProtector.getQueryParameter(r106, "type"), r116, r119, r113, r213, r123.floatValue(), r212, UriProtector.getQueryParameter(r106, "ride_type"), false, new e1(this, r106));
        r103.i("ThirdAppInterceptor", "handleNaviApp ends, return true");
    L193:
        r110 = false;
        goto L220
    L57:
        if (r211 == null) goto L63;
        String r124 = r211.f267533g;
        if (r124 == null) goto L63;
        if (StringsKt.endsWith$default(r124, "location", false, 2, null) != true) goto L63;
        boolean r125 = true;
    L64:
        if (r125 == false) goto L196;
        if (r211 == null) goto L193;
        Uri r126 = r211.f267530d;
        if (r126 == null) goto L193;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r126, "is_oversea"), "1") == false) goto L221;
        final String r127 = UriProtector.getQueryParameter(r126, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r127 == null) goto L222;
        String r128 = UriProtector.getQueryParameter(r126, "dlat");
        if (r128 == null) goto L193;
        Float r129 = StringsKt.toFloatOrNull(r128);
        if (r129 == null) goto L193;
        final float r130 = r129.floatValue();
        String r131 = UriProtector.getQueryParameter(r126, "dlon");
        if (r131 == null) goto L193;
        Float r132 = StringsKt.toFloatOrNull(r131);
        if (r132 == null) goto L193;
        final float r133 = r132.floatValue();
        String r134 = UriProtector.getQueryParameter(r126, "dialog_title");
        String r135 = UriProtector.getQueryParameter(r126, "dialog_list");     // Catch: JSONException -> L89
        if (r135 != null) goto L87;
        r135 = "[]";
    L87:
        JSONArray r136 = new JSONArray(r135);     // Catch: JSONException -> L89
    L90:
        if (r134 != null) goto L92;
    L95:
        boolean r137 = true;
    L96:
        if (r137 == false) goto L98;
    L192:
        r110 = c(r210, r211, r130, r133, r127);
        goto L220
    L98:
        if (r136.length() == 0) goto L192;
        Gson r138 = new Gson();
        final LinkedHashMap r139 = new LinkedHashMap();
        int r140 = r136.length();
        int r141 = 0;
    L101:
        if (r141 >= r140) goto L133;
        Object r142 = r136.opt(r141);
        b r143 = (b) GsonProtectorUtils.fromJson(r138, r142.toString(), b.class);     // Catch: JsonSyntaxException -> L130
        if (r143.a() == null) goto L126;
        if (r143.b() == null) goto L126;
        Gson r144 = r138;
        if (Intrinsics.areEqual(r143.a(), "google") == false) goto L121;
        Application r145 = AppHost.f326268a.getApplication();     // Catch: JsonSyntaxException -> L130
        if (r145 == null) goto L121;
        JSONArray r214 = r136;
        if (r145.getPackageManager().getPackageInfo(MapRouteService.MapPackageName.PACKAGE_NAME_GOOGLEMAP, 0) == null) goto L122;
        boolean r146 = true;
    L123:
        if (r146 == false) goto L125;
        r139.put(r143.b(), r143.a());     // Catch: JsonSyntaxException -> L128
    L125:
        r141 = r141 + 1;     // Catch: JsonSyntaxException -> L128
        r138 = r144;
        r136 = r214;
    L128:
        e = e;
    L132:
        FLogger.f375446a.e("ThirdAppInterceptor", "wrong dialogList item: " + r142, e);
    L122:
        r146 = false;
        goto L123
    L119:
        r214 = r136;
    L121:
        r214 = r136;
    L126:
        FLogger.f375446a.i("ThirdAppInterceptor", "dialogAppList cannot contain any null");     // Catch: JsonSyntaxException -> L128
    L130:
        e = e;
        goto L132
    L133:
        AlertDialog r147 = this.f346065a;
        if (r147 == null) goto L154;
        Handler r148 = DialogLancet.resolveDialogHandler(r147);
        if (r148 != null) goto L138;
    L140:
        DialogLancet.beforeDialogDismiss(r147);
        r147.dismiss();     // Catch: Throwable -> L143 Exception -> L145
    L150:
        DialogLancet.afterDialogDismiss(r147);
        goto L154
    L145:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L143
        Throwable r149 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L143
        if (r149 == null) goto L150;
        com.bytedance.crash.d.d(r149, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L143
    L143:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r147);
        throw th;
    L138:
        if (Looper.myLooper() == r148.getLooper()) goto L140;
        r148.post(DialogLancet.createDismissRunnable(r147));
    L154:
        if ((r210 instanceof Activity) == false) goto L156;
        Activity r150 = (Activity) r210;
    L157:
        if (r150 != null) goto L159;
        r150 = AppHost.f326268a.a().getCurrentActivity();
    L159:
        final Activity r151 = r150;
        if (r151 != null) goto L163;
        FLogger.f375446a.i("ThirdAppInterceptor", "cannot get activity");
        goto L193
    L163:
        if (r139.size() != 0) goto L165;
        FLogger.f375446a.i("ThirdAppInterceptor", "no app installed for dialog");
        r110 = d(r151, r211);
        goto L220
    L165:
        final String[] r152 = new String[r139.size()];
        Iterator r153 = r139.keySet().iterator();
        int r154 = 0;
    L167:
        if (r153.hasNext() == false) goto L169;
        r152[r154] = (String) r153.next();
        r154 = r154 + 1;
        goto L167
    L169:
        Uri r155 = r211.f267530d;
        if (r155 == null) goto L176;
        String r156 = UriProtector.getQueryParameter(r155, "trace_info");
        if (r156 == null) goto L176;
        JSONObject r157 = new JSONObject(r156);     // Catch: JSONException -> L175
    L177:
        d1 r158 = new d1(r151, r152, this);
        ChatControlTrace r159 = ChatControlTrace.f309996b;
        Uri r160 = r211.f267530d;
        if (r160 == null) goto L180;
        String r161 = r160.toString();
    L181:
        JSONObject r162 = r159.Gb(r161, r157);
        if (r162 != null) goto L184;
        r162 = new JSONObject();
    L184:
        final JSONObject r163 = r162;
        AlertDialog r164 = new AlertDialog.Builder(r151).setTitle(r134).setAdapter(r158, new z0(this, r139, r152, r163, r151, r211, r130, r133, r127)).setOnCancelListener(new a1(r163, this)).create();
        r164.setOnShowListener(new b1(r163));
        this.f346065a = r164;
        FLogger.f375446a.i("ThirdAppInterceptor", "dialog show with: " + r139);
        AlertDialog r165 = this.f346065a;
        if (r165 != null) goto L187;
    L191:
        r110 = true;
        goto L220
    L187:
        if (DialogLancet.shouldBlockDialogShow(r165) == false) goto L199;
        DialogLancet.handleBlockedDialogShow(r165);
        goto L191
    L199:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L198
    L190:
        DialogLancet.beforeDialogShow(r165);
        r165.show();
        DialogLancet.afterDialogShow(r165);
        goto L191
    L180:
        r161 = null;
    L176:
        r157 = null;
        goto L177
    L156:
        r150 = null;
        goto L157
    L92:
        if (StringsKt.isBlank(r134) == true) goto L95;
        r137 = false;
    L89:
        r136 = new JSONArray();
        goto L90
    L222:
        return false;
    L221:
        return false;
    L196:
        return false;
    L63:
        r125 = false;
    L16:
        r105 = false;
        goto L18
    }

    public static boolean c(Context r100, com.bytedance.router.c r101, float r102, float r103, String r104) {
        Intent r105 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("geo:" + r102 + ',' + r103 + "?q=" + Uri.encode(r104)));
        r105.setPackage(MapRouteService.MapPackageName.PACKAGE_NAME_GOOGLEMAP);
        if (r105.resolveActivity(AppHost.f326268a.getApplication().getPackageManager()) == null) goto L9;
        if (r100 == null) goto L10;
        r100.startActivity(r105);
        return true;
    L10:
        return true;
    L9:
        return d(r100, r101);
    }
}
