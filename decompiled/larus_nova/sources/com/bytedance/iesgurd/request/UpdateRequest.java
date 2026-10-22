package com.bytedance.iesgurd.request;

import android.os.Handler;
import android.util.Pair;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.net.RequestExecutor;
import com.bytedance.iesgurd.core.BlockType;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.ReportNode;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.exception.ExceptionWithCode;
import com.bytedance.iesgurd.j;
import com.bytedance.iesgurd.l;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.model.CleanTask;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.model.ResponseBodyUpdate;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class UpdateRequest {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f250792n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f250793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f250795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f250796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f250797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z86.c f250798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GeckoUpdateListener f250799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ReqType f250800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<PrepareMeta> f250801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<PrepareMeta> f250802j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ResponseBodyUpdate f250803k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RequestBodyUpdate f250804l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j f250805m;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateRequest f250806a;

        public b(UpdateRequest r100) {
            this.f250806a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UpdateRequest.a(this.f250806a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void c() {
        z86.c r100 = this.f250798f;
        r100.f570936g = "update_v7_custom";
        ReqType r101 = this.f250800h;
        if (r101 != ReqType.POLLING) goto L6;
        r100.f570936g = "update_v7_polling";
        String r102 = "/gkx/api/resource/v7/polling";
    L12:
        StringBuilder r103 = new StringBuilder("https://");
        com.bytedance.geckox.b r104 = com.bytedance.geckox.b.a.f245076a;
        r103.append(com.bytedance.geckox.b.a().getHost());
        r103.append(r102);
        final String r105 = r103.toString();
        GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.CHECK_UPDATE_REQUEST, "check update start, tag: " + this.f250805m.f250715h + ", retry: " + this.f250794b + ", reqType: " + this.f250800h + ", " + r105);
        new RequestExecutor(this.f250804l, r105, this.f250796d ^ true, this.f250793a, new UpdateRequest$doRequest$1(this, r105)).b();
        return;
    L6:
        if (r101 != ReqType.QUEUE) goto L8;
    L11:
        r100.f570936g = "update_v7_coldstart";
        r102 = "/gkx/api/resource/v7/coldstart";
        goto L12
    L8:
        if (r101 == ReqType.REGISTER_LATE) goto L11;
        r102 = "/gkx/api/resource/v7/custom";
        goto L12
    }

    public final void d() {
        Iterator<PrepareMeta> r100 = this.f250801i.iterator();
    L4:
        if (r100.hasNext() == false) goto L26;
        PrepareMeta r101 = r100.next();
        String r102 = r101.getAccessKey();
        String r103 = r101.getChannel();
        if (r101.getFullPackage() == null) goto L4;
        r101.setLogId(this.f250798f.f570935f);
        r101.setApiVersion(this.f250798f.f570936g);
        r101.setRetry(this.f250798f.f570942m);
        Long r104 = this.f250804l.getLocalVersion(r102, r103);
        if (r104 == null) goto L10;
        r101.setLocalVersion(r104.longValue());
    L10:
        r101.initByRequest(this.f250800h);
        Map<String, ConcurrentHashMap<String, PrepareMeta>> r105 = PrepareMetaManager.f250761a;
        Map<String, ConcurrentHashMap<String, PrepareMeta>> r106 = PrepareMetaManager.f250761a;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        if (r107.get(r102) != null) goto L22;
        monitor-enter(r106);
        if (((ConcurrentHashMap) r106).get(r102) != null) goto L16;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r106;     // Catch: Throwable -> L19
        r108.put(r102, new ConcurrentHashMap());     // Catch: Throwable -> L19
    L16:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r106);
    L19:
        th = move-exception;
        throw th;
    L22:
        Object r110 = r107.get(r102);
        if (r110 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        ((Map) r110).put(r103, r101);
        goto L4
    }

    public final void f() {
        ((ThreadPoolExecutor) GeckoExecutors.f250868a.getValue()).execute(new b(this));
    }

    public UpdateRequest(RequestBodyUpdate r110) {
        this(r110, new j("gecko_backup", null, null, null, null, false, 254));
    }

    public static final void a(final UpdateRequest r210) {
        r210.f250799g = r210.f250805m.f250710c;
        ReqType r100 = r210.f250804l.getReqType();
        r210.f250800h = r100;
        if (r100 != ReqType.NEW_REQUEST_CUSTOM) goto L5;
    L10:
        boolean r101 = true;
    L11:
        r210.f250796d = r101;
        GeckoLogger.d("start check update request " + r210.f250800h);
        r210.f250804l.getReqInfo().setTag(r210.f250805m.f250715h);
        String r102 = r210.f250804l.getSortedDeployments();
        r210.f250797e.f250819b = new com.bytedance.iesgurd.request.a(r210.f250796d);
        r210.f250797e.f250820c = new e(r210.f250794b, r210.f250805m.f250709b, r102, r210);
        if (r210.f250796d == false) goto L14;
        r210.f250797e.f250818a = new g(r210.f250805m.f250708a, r102);
    L14:
        z86.c r103 = r210.f250798f;
        r103.f570942m = r210.f250794b;
        r103.f570930a = r210.f250800h;
        r103.f570940k = r210.f250805m;
        String r104 = r210.f250793a;
        if (r104 == null) goto L18;
        r103.f570941l = r104;
    L18:
        if (r210.f250796d == false) goto L363;
        Iterator<String> r105 = r210.f250804l.getDeployments().keySet().iterator();
        if (r105.hasNext() == false) goto L363;
        String r106 = r105.next();
        r210.f250798f.f570937h = r106;
        DeploymentsData r107 = r210.f250804l.getDeployments().get(r106);
        if (r107 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        DeploymentsData r108 = r107;
        List<String> r109 = r108.getChannels();
        if (r109 != null) goto L28;
    L31:
        boolean r110 = true;
    L32:
        if (r110 == true) goto L34;
        r210.f250798f.f570938i = String.valueOf(r108.getChannels());
    L34:
        List<String> r111 = r108.getGroups();
        if (r111 != null) goto L37;
    L40:
        boolean r112 = true;
    L41:
        if (r112 == true) goto L43;
        r210.f250798f.f570939j = String.valueOf(r108.getGroups());
    L43:
        Map<String, String> r113 = r210.f250804l.getCustom().get(r106);
        if (r113 != null) goto L46;
        Intrinsics.throwNpe();
    L46:
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        z86.c r115 = r210.f250798f;
        GeckoLogger.d(String.format("check update, ak: %s, channels:%s, groupName:%s, business_version:%s", Arrays.copyOf(new Object[]{r106, r115.f570938i, r115.f570939j, r113.get("business_version")}, 4)));
        goto L363
    L37:
        if (r111.isEmpty() == true) goto L40;
        r112 = false;
        goto L41
    L28:
        if (r109.isEmpty() == true) goto L31;
        r110 = false;
    L363:
        r210.f250797e.a();     // Catch: ExceptionWithCode -> L356
        r210.c();     // Catch: Throwable -> L335
        ResponseBodyUpdate r116 = r210.f250803k;
        if (r116 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("responseBody");
    L52:
        int r117 = r116.getStatus();
        if (r117 == 0) goto L55;
        r210.f250798f.f570933d = r117;
        String r118 = "check update failed, status error: " + r117;
    L70:
        Long r119 = null;
    L224:
        if (r118 == null) goto L226;
        r210.e(new Exception(r118));
        return;
    L226:
        r210.d();
        int r120 = h.f250831a[r210.f250800h.ordinal()];
        if (r120 != 1) goto L229;
    L291:
        HashMap r121 = new HashMap();
        Iterator<T> r122 = r210.f250801i.iterator();
    L293:
        if (r122.hasNext() == false) goto L301;
        PrepareMeta r123 = (PrepareMeta) r122.next();
        long r124 = r123.getDownloadDelay();
        if (r124 > 0) goto L297;
        r124 = 3;
    L297:
        List r125 = (List) r121.get(Long.valueOf(r124));
        if (r125 != null) goto L300;
        r125 = new ArrayList();
        r121.put(Long.valueOf(r124), r125);
    L300:
        r125.add(r123);
        goto L293
    L301:
        Iterator r126 = r121.entrySet().iterator();
    L303:
        if (r126.hasNext() == false) goto L306;
        final Map.Entry r127 = (Map.Entry) r126.next();
        final long r128 = ((Number) r127.getKey()).longValue();
        ((Handler) GeckoExecutors.f250869b.getValue()).postDelayed(new UpdateRequest$initColdStartOperations$$inlined$forEach$lambda$1(r128, r127, r210), r128 * 1000);
    L306:
        if (r210.f250796d == false) goto L321;
        if (r210.f250799g == null) goto L321;
        Map<String, List<Pair<String, Long>>> r129 = r210.f250804l.getRequestMap();
        HashMap r130 = new HashMap();
        Iterator r131 = ((ArrayList) r210.f250802j).iterator();
    L311:
        if (r131.hasNext() == false) goto L316;
        PrepareMeta r132 = (PrepareMeta) r131.next();
        String r133 = r132.getAccessKey();
        List r134 = (List) r130.get(r133);
        if (r134 != null) goto L315;
        r134 = new ArrayList();
    L315:
        r134.add(r132.getPack());
        r130.put(r133, r134);
        goto L311
    L316:
        GeckoUpdateListener r135 = r210.f250799g;
        if (r135 != null) goto L319;
        Intrinsics.throwNpe();
    L319:
        r135.onCheckServerVersionSuccess(r129, r130);
    L321:
        if ((!((ArrayList) r210.f250802j).isEmpty()) == true) goto L323;
        return;
    L323:
        if (r210.f250805m.f250719l == null) goto L334;
        Iterator r136 = ((ArrayList) r210.f250802j).iterator();
    L326:
        if (r136.hasNext() == false) goto L334;
        PrepareMeta r137 = (PrepareMeta) r136.next();
        j r138 = r210.f250805m;
        String r139 = r137.getChannel();
        if (r138.f250719l == null) goto L326;
        Map<String, Boolean> r140 = r138.f250714g;
        if (r140 != null) goto L333;
        Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
    L333:
        r140.put(r139, Boolean.FALSE);
    L334:
        AtomicInteger r141 = b96.i.f18315a;
        b96.i.a(r210.f250802j, r210.f250805m);
        return;
    L229:
        if (r120 == 2) goto L291;
        if (r120 != 3) goto L233;
        Iterator<T> r142 = r210.f250801i.iterator();
    L289:
        if (r142.hasNext() == false) goto L306;
        r210.b((PrepareMeta) r142.next());
        goto L289
    L233:
        if (r120 == 4) goto L278;
        Iterator<Map.Entry<String, DeploymentsData>> r143 = r210.f250804l.getDeployments().entrySet().iterator();
    L236:
        if (r143.hasNext() == false) goto L306;
        Map.Entry<String, DeploymentsData> r144 = r143.next();
        DeploymentsData r145 = r144.getValue();
        List<String> r146 = r145.getChannels();
        if (r146 == null) goto L263;
        Iterator<T> r147 = r146.iterator();
    L241:
        if (r147.hasNext() == false) goto L263;
        String r148 = (String) r147.next();
        String r149 = r144.getKey();
        PrepareMeta r150 = PrepareMetaManager.b(r149, r148);
        if (r150 == null) goto L246;
        r210.b(r150);
    L246:
        if (r210.f250796d == false) goto L241;
        Function1<l, Unit> r151 = r210.f250805m.f250719l;
        if (r210.f250799g != null) goto L252;
        if (r151 == null) goto L241;
    L252:
        if (r150 == null) goto L253;
        BlockType r152 = r150.getBlockType();
        if (r152 == null) goto L241;
        Set<GeckoUpdateListener> r153 = ty5.a.f547967a;
        ty5.a.a(r210.f250799g, r150.getPack(), new Exception("update blocked: " + r152));
        r210.f250805m.b(r148, "update blocked: " + r152);
        goto L241
    L253:
        ChannelMeta r154 = com.bytedance.iesgurd.meta.a.c(r149, r148);
        if (r154 == null) goto L256;
        Long r155 = r154.getId();
    L257:
        if (r155 == null) goto L258;
        Set<GeckoUpdateListener> r156 = ty5.a.f547967a;
        ty5.a.b(r210.f250799g, r149, r148, r155.longValue());
        r210.f250805m.d(r148, r155.longValue());
        goto L241
    L258:
        r210.f250805m.b(r148, "no local version and no remote version");
        goto L241
    L256:
        r155 = r119;
    L263:
        List<String> r157 = r145.getGroups();
        if (r157 == null) goto L236;
        Iterator<T> r158 = r157.iterator();
    L267:
        if (r158.hasNext() == false) goto L236;
        String r159 = (String) r158.next();
        Map<String, ConcurrentHashMap<String, PrepareMeta>> r160 = PrepareMetaManager.f250761a;
        Map r161 = PrepareMetaManager.a(r144.getKey());
        if (r161 == null) goto L267;
        Iterator r162 = r161.entrySet().iterator();
    L272:
        if (r162.hasNext() == false) goto L267;
        PrepareMeta r163 = (PrepareMeta) ((Map.Entry) r162.next()).getValue();
        List<String> r164 = r163.getGroups();
        if (r164 == null) goto L272;
        if (r164.contains(r159) != true) goto L272;
        r210.b(r163);
        goto L272
    L278:
        Iterator<T> r165 = r210.f250804l.getCustom().keySet().iterator();
    L280:
        if (r165.hasNext() == false) goto L306;
        Map r166 = PrepareMetaManager.a((String) r165.next());
        if (r166 == null) goto L280;
        Iterator r167 = r166.entrySet().iterator();
    L285:
        if (r167.hasNext() == false) goto L280;
        r210.b((PrepareMeta) ((Map.Entry) r167.next()).getValue());
        goto L285
    L55:
        ResponseBodyUpdate r168 = r210.f250803k;
        if (r168 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("responseBody");
    L59:
        if (r168.getData() != null) goto L61;
        r118 = "check update failed, data is null";
        goto L70
    L61:
        ResponseBodyUpdate r169 = r210.f250803k;
        if (r169 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("responseBody");
    L64:
        ResponseBodyUpdate.ResponseBodyData r170 = r169.getData();
        if (r170 != null) goto L68;
        Intrinsics.throwNpe();
    L68:
        if (r170.getResources() != null) goto L71;
        r118 = "check update failed, resources is null";
        goto L70
    L71:
        r210.f250798f.a();
        if (r210.f250798f.f570941l == null) goto L77;
        String r171 = "http_status: " + r210.f250798f.f570931b + ", err_code:" + r210.f250798f.f570933d + ", err_msg:" + r210.f250798f.f570934e;
        String r172 = com.bytedance.iesgurd.strategy.e.f250861a;
        String r173 = r210.f250798f.f570941l;
        if (r173 != null) goto L76;
        Intrinsics.throwNpe();
    L76:
        com.bytedance.iesgurd.strategy.e.b("request_finish", r173, r171);
    L77:
        int r174 = x86.a.f562912a;
        Map<String, Map<String, CleanTask>> r175 = r170.getCleanTasks();
        if (r175 != null) goto L80;
    L83:
        boolean r176 = true;
    L84:
        if (r176 == true) goto L157;
        Iterator<Map.Entry<String, Map<String, CleanTask>>> r177 = r175.entrySet().iterator();
    L88:
        if (r177.hasNext() == false) goto L156;
        Map.Entry<String, Map<String, CleanTask>> r178 = r177.next();
        String r179 = r178.getKey();
        Iterator<Map.Entry<String, CleanTask>> r180 = r178.getValue().entrySet().iterator();
    L91:
        if (r180.hasNext() == false) goto L88;
        Map.Entry<String, CleanTask> r181 = r180.next();
        String r182 = r181.getKey();
        CleanTask r183 = r181.getValue();
        List<Long> r184 = r183.getCleanPackages();
        int r185 = x86.a.f562912a;
        if (r184 == null) goto L98;
        Iterator<T> r186 = r184.iterator();
    L96:
        if (r186.hasNext() == false) goto L98;
        x86.a.d(r179, r182, ((Number) r186.next()).longValue(), CleanStrategy.CHECK_UPDATE, 0);
        r182 = r182;
    L98:
        String r187 = r182;
        List<Long> r188 = r183.getClosePackages();
        if (r188 == null) goto L104;
        Iterator<T> r189 = r188.iterator();
    L102:
        if (r189.hasNext() == false) goto L104;
        long r190 = ((Number) r189.next()).longValue();
        Map<String, ConcurrentHashMap<String, PrepareMeta>> r191 = PrepareMetaManager.f250761a;
        PrepareMetaManager.c(r179, r187, Long.valueOf(r190));
    L104:
        x86.a.b(r179, r187);
        ChannelMeta r192 = com.bytedance.iesgurd.meta.a.c(r179, r187);
        if (r192 == null) goto L154;
        List<Long> r193 = r183.getForbiddenPackages();
        String r194 = "access_key";
        if (r193 == null) goto L130;
        Iterator<T> r195 = r193.iterator();
    L110:
        if (r195.hasNext() == false) goto L130;
        String r211 = r194;
        long r196 = ((Number) r195.next()).longValue();
        Long r212 = r192.getId();
        if (r212 != null) goto L115;
    L119:
        boolean r197 = false;
    L120:
        EventSubType r198 = EventSubType.FORBIDDEN;
        String r199 = String.valueOf(r197);
        String r200 = String.valueOf(r196);
        JSONObject r201 = new JSONObject();
        r201.put("sub_type", r198.getType());
        if (r179 == null) goto L123;
        r201.put(r211, r179);
    L123:
        if (r187 == null) goto L125;
        r201.put("channels", r187);
    L125:
        if (r199 == null) goto L127;
        r201.put(LocationMonitorConst.ERR_MSG, r199);
    L127:
        if (r200 == null) goto L129;
        r201.put("extra", r200);
    L129:
        y86.a.c("geckosdk_event_message", r201);
        r194 = r211;
        r177 = r177;
        goto L110
    L115:
        if (r212.longValue() != r196) goto L119;
        if (r192.getForbidden() == true) goto L119;
        GeckoLogger.d("forbidden channel: " + r179 + '-' + r187 + '-' + r196);
        r192.setForbidden(true);
        com.bytedance.iesgurd.meta.a.f(r179, r187, r192);
        x86.a.a(r179, r187);
        r197 = true;
    L130:
        Iterator<Map.Entry<String, Map<String, CleanTask>>> r213 = r177;
        String r202 = r194;
        List<Long> r203 = r183.getUnforbiddenPackages();
        if (r203 == null) goto L155;
        Iterator r204 = r203.iterator();
    L134:
        if (r204.hasNext() == false) goto L155;
        long r205 = ((Number) r204.next()).longValue();
        Long r1100 = r192.getId();
        if (r1100 != null) goto L139;
    L143:
        boolean r214 = false;
    L144:
        EventSubType r215 = EventSubType.UNFORBIDDEN;
        String r206 = String.valueOf(r214);
        String r207 = String.valueOf(r205);
        JSONObject r208 = new JSONObject();
        r208.put("sub_type", r215.getType());
        if (r179 == null) goto L147;
        r208.put(r202, r179);
    L147:
        if (r187 == null) goto L149;
        r208.put("channels", r187);
    L149:
        if (r206 == null) goto L151;
        r208.put(LocationMonitorConst.ERR_MSG, r206);
    L151:
        if (r207 == null) goto L153;
        r208.put("extra", r207);
    L153:
        y86.a.c("geckosdk_event_message", r208);
        r204 = r204;
        goto L134
    L139:
        if (r1100.longValue() != r205) goto L143;
        if (r192.getForbidden() == false) goto L143;
        GeckoLogger.d("unforbidden channel: " + r179 + '-' + r187 + '-' + r205);
        r192.setForbidden(false);
        com.bytedance.iesgurd.meta.a.f(r179, r187, r192);
        r214 = true;
    L155:
        r177 = r213;
        goto L91
    L154:
        r213 = r177;
        goto L155
    L156:
        com.bytedance.iesgurd.core.a.b();
    L157:
        List r209 = CollectionsKt.toMutableList(r170.getResources());
        int r216 = r209.size() - 1;
    L158:
        if (r216 < 0) goto L163;
        PrepareMeta r217 = (PrepareMeta) ListProtector.get(r209, r216);
        String r218 = r217.checkValid();
        if (r218 == null) goto L162;
        String r219 = "server data error: ".concat(r218);
        GeckoLogger.w(r219);
        UpdatePackage r1101 = new UpdatePackage(r217.getAccessKey(), r217.getChannel(), 0, 4, null);
        Set<GeckoUpdateListener> r220 = ty5.a.f547967a;
        ty5.a.a(r210.f250799g, r1101, new Exception(r219));
        r210.f250805m.b(r217.getChannel(), r219);
        ListProtector.remove(r209, r216);
    L162:
        r216 = r216 - 1;
        goto L158
    L163:
        r210.f250801i = CollectionsKt.toList(r209);
        if (r210.f250795c != null) goto L166;
    L223:
        r119 = null;
        r118 = null;
        goto L224
    L166:
        if (AppSettingsManager.b.f245071a.a() == false) goto L223;
        String r221 = r210.f250795c;
        if (r221 != null) goto L170;
        Intrinsics.throwNpe();
    L170:
        Map r1102 = (Map) ((ConcurrentHashMap) com.bytedance.iesgurd.meta.a.f250766c).get(r221);
        if (r1102 != null) goto L173;
    L176:
        boolean r222 = true;
    L178:
        if (r222 == true) goto L198;
        Iterator r1103 = CollectionsKt.toList(r1102.keySet()).iterator();
    L181:
        if (r1103.hasNext() == false) goto L198;
        String r223 = (String) r1103.next();
        ChannelMeta r224 = (ChannelMeta) r1102.get(r223);
        if (r224 == null) goto L181;
        Long r225 = r224.getId();
        if (r225 == null) goto L181;
        long r226 = r225.longValue();
        Iterator<T> r227 = r210.f250801i.iterator();
    L188:
        if (r227.hasNext() == false) goto L192;
        Object r228 = r227.next();
        if (Intrinsics.areEqual(((PrepareMeta) r228).getChannel(), r223) == false) goto L188;
    L193:
        PrepareMeta r229 = (PrepareMeta) r228;
        if (r229 == null) goto L197;
        if (r229.getVersion() == r226) goto L181;
    L197:
        GeckoLogger.d("clean wrong channel version, " + r221 + ", " + r223 + ", " + r226);
        x86.a.c(r221, r223);
        new z86.a(CleanStrategy.LATE_REGISTER, 1, r221, r223, r226, 0, 224).a();
        goto L181
    L192:
        r228 = null;
    L198:
        Map r1104 = PrepareMetaManager.a(r221);
        if (r1104 != null) goto L201;
    L204:
        boolean r230 = true;
    L205:
        if (r230 == true) goto L223;
        Iterator r1105 = CollectionsKt.toList(r1104.keySet()).iterator();
    L208:
        if (r1105.hasNext() == false) goto L223;
        String r231 = (String) r1105.next();
        PrepareMeta r232 = (PrepareMeta) r1104.get(r231);
        if (r232 == null) goto L208;
        long r233 = r232.getVersion();
        Iterator<T> r234 = r210.f250801i.iterator();
    L213:
        if (r234.hasNext() == false) goto L217;
        Object r235 = r234.next();
        if (Intrinsics.areEqual(((PrepareMeta) r235).getChannel(), r231) == false) goto L213;
    L218:
        PrepareMeta r236 = (PrepareMeta) r235;
        if (r236 == null) goto L222;
        if (r236.getVersion() == r233) goto L208;
    L222:
        GeckoLogger.d("clean wrong prepare version, " + r221 + ", " + r231 + ", " + r233);
        PrepareMetaManager.c(r221, r231, null);
        new z86.a(CleanStrategy.LATE_REGISTER, 2, r221, r231, r233, 0, 224).a();
        goto L208
    L217:
        r235 = null;
        goto L218
    L201:
        if (r1104.isEmpty() == true) goto L204;
        r230 = false;
        goto L205
    L173:
        if (r1102.isEmpty() == true) goto L176;
        r222 = false;
        goto L178
    L80:
        if (r175.isEmpty() == true) goto L83;
        r176 = false;
    L335:
        th = move-exception;
        d r237 = r210.f250797e;
        g r238 = r237.f250818a;
        if (r238 == null) goto L339;
        g.f250828c.remove(r238.f250830b);
    L339:
        com.bytedance.iesgurd.request.a r239 = r237.f250819b;
        if (r239 == null) goto L348;
        monitor-enter(r239);
        com.bytedance.iesgurd.request.a.f250810c++;     // Catch: Throwable -> L345
        com.bytedance.iesgurd.request.a.f250811d = System.currentTimeMillis();     // Catch: Throwable -> L345
    L345:
        th = move-exception;
        throw th;
    L348:
        e r240 = r237.f250820c;
        if (r240 != null) goto L351;
    L355:
        r210.e(th);
        return;
    L351:
        if (r240.f250822a == true) goto L355;
        if (r240.f250823b == false) goto L355;
        long r241 = System.currentTimeMillis();
        e.f250821e.put(r240.f250824c, Long.valueOf(r241));
        GeckoLogger.d(r240.f250824c + "gecko update request retry hit");
        ((Handler) GeckoExecutors.f250869b.getValue()).postDelayed(new f(r240, r241), 60000);
    L356:
        e = move-exception;
        r210.f250798f.f570933d = e.getCode();
        r210.f250798f.f570932c = 1;
        r210.e(e);
        return;
    L5:
        if (r100 == ReqType.NEW_REQUEST_CONFIG) goto L10;
        if (r100 == ReqType.NORMAL) goto L10;
        r101 = false;
        goto L11
    }

    public final void b(PrepareMeta r100) {
        r100.setReqType(this.f250800h);
        r100.updateBlockType();
        if (r100.getBlockType() != null) goto L6;
        ((ArrayList) this.f250802j).add(r100);
        return;
    }

    public final void e(Throwable r100) {
        String r101 = r100.getMessage();
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        GeckoLogger.w(r101);
        z86.c r103 = this.f250798f;
        r103.f570934e = r100.getMessage();
        this.f250798f.a();
        if (this.f250796d == false) goto L16;
        GeckoUpdateListener r104 = this.f250799g;
        if (r104 == null) goto L11;
        r104.onCheckServerVersionFail(null, r100);
    L11:
        j r105 = this.f250805m;
        String r106 = r100.getMessage();
        if (r106 == null) goto L14;
        r102 = r106;
    L14:
        r105.a(r102);
        return;
    }

    public UpdateRequest(RequestBodyUpdate r100, j r101) {
        this.f250804l = r100;
        this.f250805m = r101;
        this.f250797e = new d();
        this.f250798f = new z86.c();
        this.f250800h = ReqType.NORMAL;
        this.f250801i = new ArrayList();
        this.f250802j = new ArrayList();
    }
}
