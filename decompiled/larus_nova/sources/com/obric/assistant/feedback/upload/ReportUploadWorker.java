package com.obric.assistant.feedback.upload;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.JsonObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.feedback.upload.bean.ReportUploadTask;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bytertc.engine.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.k;

/* JADX INFO: loaded from: classes33.dex */
public final class ReportUploadWorker {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f389276c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f389277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f389278b;

    public static final class a {
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String c() {
        Method r100 = a().getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Exception -> L5
        r100.setAccessible(true);     // Catch: Exception -> L5
        Object r101 = r100.invoke(null, new Object[]{"ro.os.ota.version"});     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L5
        return (String) r101;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ReportUploadWorker", "getProperty failed!", e);
        return null;
    }

    public ReportUploadWorker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f389277a = r100;
        this.f389278b = LazyKt.lazy(new e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.utils.logger.FLogger] */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.obric.assistant.feedback.upload.ReportUploadWorker] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v61 */
    /* JADX WARN: Type inference failed for: r8v63, types: [com.obric.assistant.feedback.upload.IReportUploadNetworkService] */
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
    public final Object d(ReportUploadTask r310, Continuation<? super Boolean> r311) {
        ReportUploadTask r100 = r310;
        if ((r311 instanceof ReportUploadWorker$upload$1) == false) goto L7;
        ReportUploadWorker$upload$1 r101 = (ReportUploadWorker$upload$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ReportUploadWorker$upload$1 r103 = r101;
        Object r104 = r103.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        int r111 = 0;
        String r112 = "";
        if (r105 != 0) goto L173;
        ResultKt.throwOnFailure(r104);
        FLogger r106 = FLogger.f375446a;
        r106.i("ReportUploadWorker", "upload start");
        r106.i("ReportUploadWorker", "upload main report start");
        JsonObject r107 = new JsonObject();
        r107.addProperty("report_tag", "功能异常");
        r107.addProperty("report_from", "用户反馈");
        r107.addProperty("createtime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r100.f389288g));
        String r108 = "豆包手机助手";
        r107.addProperty("label_lv1", "豆包手机助手");
        ReportUploadTask.Status r109 = r100.f389284c;
        if (r109 == null) goto L30;
        String r113 = r109.getDescription();
        if (r113 == null) goto L30;
        r108 = r113;
    L30:
        r107.addProperty("label_lv2", r108);
        String r114 = r100.f389282a;
        if (r114 != null) goto L33;
    L36:
        boolean r115 = true;
    L37:
        if (r115 == false) goto L41;
        String r116 = r100.f389285d;
        if (r116 != null) goto L46;
        r116 = "";
    L46:
        r107.addProperty("description", r116);
        JsonObject r117 = new JsonObject();
        r117.addProperty("softwareVersion", c());
        r117.addProperty("type", Build.TYPE);
        r117.addProperty(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, Build.FINGERPRINT);
        r117.addProperty("cpuAbi", Build.CPU_ABI);
        r117.addProperty("cpuAbi2", Build.CPU_ABI2);
        r117.addProperty("version_sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        JsonObject r118 = new JsonObject();
        r118.addProperty("product", "obric");
        r118.addProperty(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, t9a.b.b().b().getDeviceModel());
        r118.addProperty("board", Build.BOARD);
        r118.addProperty("brand", t9a.b.b().b().getDeviceBrand());
        r118.addProperty("telephony_device_id", "");
        IApplog.Companion r119 = IApplog.f287053a;
        r118.addProperty("local_device_id", r119.getDeviceId());
        r118.addProperty("serial", "");
        r118.addProperty("udid", r119.e());
        r118.addProperty("uid", r119.getUserID());
        Object r120 = this.f389277a.getSystemService("wifi");
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager r121 = (WifiManager) r120;
        ArrayList r122 = new ArrayList();
        Object[] r123 = new Object[0];
        f06.b r210 = new f06.b();
        g06.a r124 = ApiHookConfig.f245611b.get(102301);
        if (r124 == null) goto L49;
        f06.a[] r125 = r124.f479473i;
    L50:
        int r126 = r125.length;
        String r127 = "ReportUploadWorker";
    L52:
        if (r111 >= r126) goto L63;
        String r211 = r127;
        f06.a r128 = r125[r111];
        f06.a[] r212 = r125;
        f06.d r129 = r128.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r121, r123, "android.net.wifi.WifiInfo", r210);     // Catch: Exception -> L61
        Object[] r130 = r123;
        if (r129.f474982a == true) goto L58;
        r122.add(r128);     // Catch: Exception -> L161
        goto L62
    L58:
        String r213 = r211;
    L65:
        if (r129.f474982a == false) goto L67;
        WifiInfo r131 = (WifiInfo) r129.f474983b;
    L68:
        if (r131 == null) goto L73;
        f06.c r132 = new f06.c();
        Object[] r133 = new Object[0];
        f06.b r134 = new f06.b();
        f06.d r135 = r132.b(101700, "android/net/wifi/WifiInfo", "getMacAddress", r131, r133, "java.lang.String", r134);
        if (r135.f474982a == false) goto L72;
        r132.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r131, r133, null, r134, false);
        String r136 = (String) r135.f474983b;
    L74:
        r118.addProperty("wifi_mac", r136);
        JsonObject r137 = new JsonObject();
        AppHost.Companion r138 = AppHost.f326268a;
        String r139 = r138.getApplication().getPackageName();
        r137.addProperty("package_name", r139);
        if (TextUtils.isEmpty(r139) == false) goto L77;
    L79:
        JsonObject r140 = new JsonObject();
        r140.addProperty("app_name", r138.getApplication().getPackageName());
        r140.addProperty("app_version", r138.getVersionName());
        r107.add("systeminfo", r117);
        r107.add("deviceinfo", r118);
        r107.add("processinfo", r137);
        r107.add("appinfo", r140);
        LinkedHashMap r141 = new LinkedHashMap();
        r141.put("aid", Integer.valueOf(r138.getAppId()));
        r141.put("ctw", 86400);
        AccountService r142 = AccountService.f365697a;
        r141.put("autuid", r142.getUserId());
        com.privacy.azerothprivacy.userAuthToken.c.c().getClass();
        String r143 = com.privacy.azerothprivacy.userAuthToken.c.b(1801, r141);
        if (r143 != null) goto L82;
        r143 = "";
    L82:
        r107.addProperty("trace_token", r143);
        JsonObject r144 = new JsonObject();
        r144.add("data", r107);
        ?? r145 = (IReportUploadNetworkService) this.f389278b.getValue();     // Catch: Exception -> L157
        String r146 = r142.getXTTToken();     // Catch: Exception -> L157
        r103.L$0 = r100;     // Catch: Exception -> L157
        r103.label = 1;     // Catch: Exception -> L157
        String r147 = r213;
        boolean r148 = false;
        boolean r149 = true;
        Object r150 = r145.uploadReport("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTIwOTkxMzEsIm5iZiI6MTU5MjA5OTEzMSwianRpIjoiODI0MGM1ZTktMDJjNS00NWU0LTk2YTUtYjc2YmZmZTcxYjljIiwiZXhwIjo0NzQ1Njk5MTMxLCJpZGVudGl0eSI6InN0b25lX2ZlZWRiYWNrX2FwcCIsImZyZXNoIjpmYWxzZSwidHlwZSI6ImFjY2VzcyJ9.E0y5gIm89ykDX0CLMI2SMvb1o-veARcLG4i8DX2qlUw", "application/json", r146, 1, r144, r103);     // Catch: Exception -> L154
        String r151 = r147;
        ?? r152 = "application/json";
        if (r150 != r110) goto L88;
        return r110;
    L88:
        JsonObject r153 = (JsonObject) r150;     // Catch: Exception -> L154
        if (r153 == null) goto L151;
        if (r153.toString().length() != 0) goto L93;
        boolean r154 = true;
    L94:
        if (r154 == true) goto L151;
        if (r153.size() == 0) goto L151;
        FLogger r155 = FLogger.f375446a;     // Catch: Exception -> L154
        r155.d(r151, "upload report, response = " + r153);     // Catch: Exception -> L154
        if (r153.get("code").getAsInt() != 0) goto L149;
        String r156 = r153.get("data").getAsJsonObject().get("report_id").getAsString();     // Catch: Exception -> L154
        r155.i(r151, "upload report success, reportId = " + r156);     // Catch: Exception -> L154
        r103.L$0 = r100;     // Catch: Exception -> L154
        r103.L$1 = r156;     // Catch: Exception -> L154
        r103.label = 2;     // Catch: Exception -> L154
        if (e(r156, r103) != r110) goto L103;
        return r110;
    L103:
        String r157 = r156;
        int r158 = r148;
        r147 = r151;
    L104:
        FLogger r159 = FLogger.f375446a;     // Catch: Exception -> L154
        r159.i(r147, "upload report ext, reportId = " + r157);     // Catch: Exception -> L154
        if (r100.f389286e == false) goto L144;
        r159.i(r147, "task.haveExtraData is true");
        Result.Companion r160 = Result.Companion;     // Catch: Throwable -> L119
        r159.i(r147, "createZipFile start");     // Catch: Throwable -> L119
        List<String> r161 = r100.f389287f;     // Catch: Throwable -> L119
        if (r161 == null) goto L112;
        Collection r162 = CollectionsKt.toMutableList(r161);     // Catch: Throwable -> L119
        if (r162 == null) goto L112;
    L113:
        String r163 = bea.a.e(this.f389277a, (String[]) r162.toArray(new String[r158]));     // Catch: Throwable -> L119
        if (new PolarisFileWrapper(r163).exists() == true) goto L117;
        r163 = r112;
    L117:
        Object r164 = Result.m9449constructorimpl(r163);     // Catch: Throwable -> L119
    L121:
        Object r165 = r164;
        Throwable r166 = Result.m9452exceptionOrNullimpl(r165);
        if (r166 == null) goto L125;
        FLogger.f375446a.e(r147, "compressLogFiles failed: " + r166);
        r165 = r112;
    L125:
        String r167 = (String) r165;
        if (r167.length() != 0) goto L128;
        boolean r168 = true;
    L129:
        if (r168 == false) goto L132;
        FLogger.f375446a.e(r147, "createZipFile error!");
        return Boxing.boxBoolean(r158);
    L132:
        File r169 = new PolarisFileWrapper(r167);
        if (r169.exists() == true) goto L136;
        FLogger.f375446a.e(r147, "createZipFile error! zipFile is not exist!");
        return Boxing.boxBoolean(r158);
    L136:
        FLogger.f375446a.i(r147, "upload file start");
        List r170 = CollectionsKt.listOf(r167);
        r103.L$0 = r169;
        r103.L$1 = null;
        r103.label = 3;
        boolean r171 = false;
        String r172 = r147;
        r104 = f(r157, "0", LogUtil.DIR_TAIL, r170, r103);
        if (r104 != r110) goto L140;
        return r110;
    L140:
        if (((Boolean) r104).booleanValue() == true) goto L143;
        FLogger.f375446a.e(r172, "upload file error");
        r169.delete();
        return Boxing.boxBoolean(r171);
    L143:
        Boxing.boxBoolean(r169.delete());
    L146:
        return Boxing.boxBoolean(r149);
    L128:
        r168 = false;
    L112:
        r162 = new ArrayList();     // Catch: Throwable -> L119
    L119:
        th = move-exception;
        Result.Companion r173 = Result.Companion;
        r164 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L121
    L144:
        r159.i(r147, "task.haveExtraData is false");
        goto L146
    L149:
        return Boxing.boxBoolean(false);
    L93:
        r154 = false;
    L151:
        return Boxing.boxBoolean(false);
    L152:
        e = e;
    L159:
        FLogger.f375446a.e(r145, "upload report failed", e);
        return Boxing.boxBoolean(r152);
    L154:
        e = e;
        r145 = r147;
    L156:
        r152 = 0;
    L157:
        e = e;
        r145 = r213;
        goto L156
    L77:
        if (Intrinsics.areEqual("UNKNOWN", r139) == true) goto L79;
        r137.addProperty("package_version", r138.getVersionName());
        goto L79
    L72:
        String r174 = r131.getMacAddress();
        r132.a(101700, "android/net/wifi/WifiInfo", "getMacAddress", r131, r133, r174, r134, true);
        r136 = r174;
        goto L74
    L73:
        r136 = "wifiMacAddress";
        goto L74
    L67:
        r131 = r121.getConnectionInfo();
    L62:
        r111 = r111 + 1;
        r123 = r130;
        r127 = r211;
        r125 = r212;
    L61:
        r130 = r123;
        goto L62
    L63:
        r213 = r127;
        r129 = new f06.d(false, null);
        goto L65
    L49:
        r125 = ApiHookConfig.f245613d;
        goto L50
    L41:
        StringBuilder r175 = new StringBuilder("【sId】\n");
        r175.append(r100.f389282a + '\n');
        r175.append("【任务名】\n");
        r175.append(r100.f389283b + '\n');
        r175.append("【任务状态】\n");
        StringBuilder r176 = new StringBuilder();
        ReportUploadTask.Status r177 = r100.f389284c;
        if (r177 == null) goto L44;
        String r178 = r177.getDescription();
    L45:
        r176.append(r178);
        r176.append('\n');
        r175.append(r176.toString());
        r175.append("【反馈信息】\n");
        r175.append(r100.f389285d);
        r116 = r175.toString();
        goto L46
    L44:
        r178 = null;
        goto L45
    L33:
        if (r114.length() == 0) goto L36;
        r115 = false;
        goto L37
    L173:
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        r169 = (File) r103.L$0;
        ResultKt.throwOnFailure(r104);
        r172 = "ReportUploadWorker";
        r171 = false;
        r149 = true;
        goto L140
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r179 = (String) r103.L$1;
        ReportUploadTask r180 = (ReportUploadTask) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L22
        r147 = "ReportUploadWorker";
        r112 = "";
        r158 = 0;
        r149 = true;
        r157 = r179;
        r100 = r180;
        goto L104
    L19:
        r100 = (ReportUploadTask) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L22
        r150 = r104;
        r151 = "ReportUploadWorker";
        r148 = false;
        r149 = true;
        r152 = "ReportUploadWorker";
    L22:
        e = e;
        r145 = "ReportUploadWorker";
    L7:
        r101 = new ReportUploadWorker$upload$1(this, r311);
        goto L8
    }

    public final Object e(String r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof ReportUploadWorker$uploadExt$1) == false) goto L7;
        ReportUploadWorker$uploadExt$1 r100 = (ReportUploadWorker$uploadExt$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        boolean r105 = true;
    L18:
        return Boxing.boxBoolean(TextUtils.isEmpty((String) r102) ^ r105);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        StringBuilder r106 = new StringBuilder();
        r106.append("【softwareVersion】:" + c() + '\n');
        r106.append("【type】:" + Build.TYPE + '\n');
        r106.append("【fingerprint】:" + Build.FINGERPRINT + '\n');
        r106.append("【cpuAbi】:" + Build.CPU_ABI + '\n');
        r106.append("【cpuAbi2】:" + Build.CPU_ABI2 + '\n');
        r106.append("【version_sdk_int】:" + Build.VERSION.SDK_INT + '\n');
        r106.append("【product】:obric\n");
        r106.append("【model】:" + Build.MODEL + '\n');
        r106.append("【board】:" + Build.BOARD + '\n');
        StringBuilder r107 = new StringBuilder("【brand】:");
        String r108 = Build.BRAND;
        r107.append(r108);
        r107.append('\n');
        r106.append(r107.toString());
        r106.append("【imei】:\n");
        StringBuilder r109 = new StringBuilder("【did】:");
        IApplog.Companion r112 = IApplog.f287053a;
        r109.append(r112.getDeviceId());
        r109.append('\n');
        r106.append(r109.toString());
        r106.append("【serial】:\n");
        r106.append("【udid】:" + r112.e() + '\n');
        r106.append("【uid】:" + r112.getUserID() + '\n');
        AppHost.Companion r113 = AppHost.f326268a;
        Object r114 = r113.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo r115 = new ActivityManager.MemoryInfo();
        ((ActivityManager) r114).getMemoryInfo(r115);
        r106.append("【avail_mem】:" + (r115.availMem / ((long) 1048576)) + '\n');
        r106.append("【wifi_mac】:\n");
        r106.append("【brand】:" + r108 + '\n');
        r106.append("【imei】:\n");
        r106.append("【did】:" + r112.getDeviceId() + '\n');
        r106.append("【app_name】:" + r113.getApplication().getPackageName() + '\n');
        r106.append("【app_version】:" + r113.getVersionName() + '\n');
        String r116 = r106.toString();
        r105 = true;
        r100.label = 1;
        r102 = g(r110, r116, r100);
        if (r102 != r103) goto L18;
        return r103;
    L7:
        r100 = new ReportUploadWorker$uploadExt$1(this, r111);
        goto L8
    }

    public final Object g(String r100, String r101, Continuation<? super String> r102) {
        if ((r102 instanceof ReportUploadWorker$uploadText$1) == false) goto L7;
        ReportUploadWorker$uploadText$1 r103 = (ReportUploadWorker$uploadText$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: IOException -> L32
    L19:
        JsonObject r109 = (JsonObject) r105;     // Catch: IOException -> L32
        if (r109 != null) goto L22;
        return null;
    L22:
        if (r109.toString().length() > 0) goto L25;
        r108 = false;
    L25:
        if (r108 == true) goto L27;
        return null;
    L27:
        if (r109.size() <= 0) goto L40;
        FLogger.f375446a.d("ReportUploadWorker", "uploadText, response = " + r109);     // Catch: IOException -> L32
        if (r109.get("code").getAsInt() != 0) goto L41;
        return r109.get("data").getAsJsonObject().get("chat_id").getAsString();
    L41:
        return null;
    L40:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        JsonObject r110 = new JsonObject();
        r110.addProperty("report_id", r100);
        r110.addProperty("description", r101);
        IReportUploadNetworkService r111 = (IReportUploadNetworkService) this.f389278b.getValue();     // Catch: IOException -> L32
        r103.label = 1;     // Catch: IOException -> L32
        r105 = r111.appendText("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTIwOTkxMzEsIm5iZiI6MTU5MjA5OTEzMSwianRpIjoiODI0MGM1ZTktMDJjNS00NWU0LTk2YTUtYjc2YmZmZTcxYjljIiwiZXhwIjo0NzQ1Njk5MTMxLCJpZGVudGl0eSI6InN0b25lX2ZlZWRiYWNrX2FwcCIsImZyZXNoIjpmYWxzZSwidHlwZSI6ImFjY2VzcyJ9.E0y5gIm89ykDX0CLMI2SMvb1o-veARcLG4i8DX2qlUw", "application/json", r110, r103);     // Catch: IOException -> L32
        if (r105 != r106) goto L19;
        return r106;
    L32:
        e = move-exception;
        FLogger.f375446a.e("ReportUploadWorker", ExceptionsKt.stackTraceToString(e));
        return null;
    L7:
        r103 = new ReportUploadWorker$uploadText$1(this, r102);
        goto L8
    }

    public static k b(String r100, String r101, String r102, List r110) {
        k.a r103 = new k.a();
        Iterator r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L24;
        String r104 = (String) r111.next();
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104);
        if (r105.exists() == true) goto L22;
        r105.createNewFile();     // Catch: IOException -> L9
    L9:
        FLogger.f375446a.e("ReportUploadWorker", "File don't exist. file = " + r104);
    L22:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        r103.b(SpeechEngineDefines.RECORDER_TYPE_FILE, r105.getName(), RequestBody.create(MediaType.get("application/otcet-stream"), r105));     // Catch: Throwable -> L12
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L4
    L24:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L16
        r103.b("report_id", null, RequestBody.create(MediaType.get("text/plain"), r100));     // Catch: Throwable -> L16
        r103.b("chat_id", null, RequestBody.create(MediaType.get("text/plain"), r101));     // Catch: Throwable -> L16
        r103.b("file_type", null, RequestBody.create(MediaType.get("text/plain"), r102));     // Catch: Throwable -> L16
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L16
    L18:
        r103.e(k.f523924f);
        return r103.d();
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final Object f(String r100, String r101, String r110, List<String> r111, Continuation<? super Boolean> r112) {
        if ((r112 instanceof ReportUploadWorker$uploadFiles$1) == false) goto L7;
        ReportUploadWorker$uploadFiles$1 r102 = (ReportUploadWorker$uploadFiles$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r113 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = true;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L32
    L22:
        JsonObject r114 = (JsonObject) r113;     // Catch: Exception -> L32
        FLogger.f375446a.d("ReportUploadWorker", "uploadFile result = " + r114);     // Catch: Exception -> L32
        if (r114 != null) goto L25;
    L29:
        r106 = false;
    L30:
        return Boxing.boxBoolean(r106);
    L25:
        if (r114.isJsonObject() == false) goto L29;
        if (r114.get("code").getAsInt() != 0) goto L29;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
        if (r111.isEmpty() == true) goto L18;
        k r107 = b(r100, r101, r110, r111);     // Catch: Exception -> L32
        IReportUploadNetworkService r108 = (IReportUploadNetworkService) this.f389278b.getValue();     // Catch: Exception -> L32
        r102.label = 1;     // Catch: Exception -> L32
        r113 = r108.uploadFile("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTIwOTkxMzEsIm5iZiI6MTU5MjA5OTEzMSwianRpIjoiODI0MGM1ZTktMDJjNS00NWU0LTk2YTUtYjc2YmZmZTcxYjljIiwiZXhwIjo0NzQ1Njk5MTMxLCJpZGVudGl0eSI6InN0b25lX2ZlZWRiYWNrX2FwcCIsImZyZXNoIjpmYWxzZSwidHlwZSI6ImFjY2VzcyJ9.E0y5gIm89ykDX0CLMI2SMvb1o-veARcLG4i8DX2qlUw", r107, r102);     // Catch: Exception -> L32
        if (r113 != r104) goto L22;
        return r104;
    L18:
        return Boxing.boxBoolean(true);
    L32:
        e = move-exception;
        FLogger.f375446a.e("ReportUploadWorker", "uploadFile exception = " + ExceptionsKt.stackTraceToString(e));
        return Boxing.boxBoolean(false);
    L7:
        r102 = new ReportUploadWorker$uploadFiles$1(this, r112);
        goto L8
    }
}
