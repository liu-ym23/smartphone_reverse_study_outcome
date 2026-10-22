package com.larus.home.impl.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.util.ILivePreInflateService;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.applog.api.IApplog;
import com.larus.network.quota.AppStartState;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class OpenGraceReportHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OpenGraceReportHelper f346337a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f346338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f346339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f346340d;

    public OpenGraceReportHelper() {
    }

    static {
        f346337a = new OpenGraceReportHelper();
        f346340d = "uninitialized";
        IApplog.Companion r100 = IApplog.f287053a;
        r100.c("open_method", new g());
        r100.c("tenant_id", new h());
        r100.c("enterprise_mode", new i());
        ThreadPlus.submitRunnable(new j());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsJSONObject");
        if (f346338b == false) goto L5;
        return;
    L5:
        r100.put("login_status", AccountService.f365697a.isLogin().booleanValue() ? 1 : 0);
        jm9.d r101 = jm9.d.f499704a;
        boolean r102 = false;
        if (jm9.d.f499710g != AppStartState.ColdStart) goto L8;
        int r103 = 1;
    L9:
        r100.put("is_cold_launch", r103);
        IApplog.f287053a.reportEvent("open_grace", r100);
        String r104 = r100.optString("enter_url");
        String r105 = "unknown";
        if (o0.d(r104) == true) goto L12;
    L56:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L46
        IApplog.Companion r107 = IApplog.f287053a;     // Catch: Throwable -> L46
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L46
        String r109 = r100.optString("enter_url");     // Catch: Throwable -> L46
        String r110 = UriProtector.getQueryParameter(UriProtector.parse(r109), AppConstants.BUNDLE_GD_LABEL);     // Catch: Throwable -> L46
        if (r110 != null) goto L26;
    L29:
        boolean r111 = true;
    L30:
        if (r111 == true) goto L32;
        r108.put(AppConstants.BUNDLE_GD_LABEL, r110);     // Catch: Throwable -> L46
    L34:
        if (r109 != null) goto L36;
    L37:
        r102 = true;
    L38:
        if (r102 == false) goto L40;
        r109 = "";
    L40:
        r108.put("scheme", r109);     // Catch: Throwable -> L46
        if (TextUtils.isEmpty(r110) == true) goto L44;
        r105 = r110;
    L44:
        r108.put("code_launch_mode", r105);     // Catch: Throwable -> L46
        r108.put(SoloKtvContext.SOLO_PAGE_ENTRANCE, ILivePreInflateService.MAIN_ACTIVITY);     // Catch: Throwable -> L46
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L46
        r107.reportEvent("launch_log", r108);     // Catch: Throwable -> L46
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L48:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L52;
        FLogger.f375446a.e("OpenGraceReportHelper", "report launch_log error", r114);
    L52:
        f346338b = true;
        return;
    L36:
        if (r109.length() != 0) goto L38;
    L32:
        r108.put(AppConstants.BUNDLE_GD_LABEL, "unknown");     // Catch: Throwable -> L46
        goto L34
    L26:
        if (r110.length() == 0) goto L29;
        r111 = false;
    L46:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L48
    L12:
        if (Intrinsics.areEqual(r104, "null") == true) goto L56;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L20
        Uri r117 = y0.j(r104);     // Catch: Throwable -> L20
        if (r117 == null) goto L17;
        String r118 = UriProtector.getQueryParameter(r117, AppConstants.BUNDLE_GD_LABEL);     // Catch: Throwable -> L20
        if (r118 == null) goto L17;
    L18:
        Result.m9449constructorimpl(r100.put(AppConstants.BUNDLE_GD_LABEL, r118));     // Catch: Throwable -> L20
    L22:
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("open_grace", r100, null, null);
    L17:
        r118 = "unknown";
    L20:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L8:
        r103 = 0;
        goto L9
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        if (f346339c == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("OpenGraceReportHelper", "[setOpenMethodCommonParams] method:".concat(r100));
        if (Intrinsics.areEqual(r100, "outer_push") == false) goto L8;
        r100 = "push";
    L8:
        f346340d = r100;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), null, new OpenGraceReportHelper$setOpenMethodCommonParams$1(null), 2, null);
        f346339c = true;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        FLogger.f375446a.i("OpenGraceReportHelper", "[setOpenMethodCommonParamsFromSNSSDK] openMethod:" + r100);
        f346340d = r100;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new OpenGraceReportHelper$setOpenMethodCommonParamsFromSNSSDK$1(null), 3, null);
        f346339c = true;
    }
}
