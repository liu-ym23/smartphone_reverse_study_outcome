package com.larus.bmhome.rc;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import hq9.b4;
import hq9.c4;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mr9.m;

/* JADX INFO: loaded from: classes26.dex */
public final class ResourceCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceCenter f313541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f313542b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f313543c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f313544d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f313545e = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f313546a = null;

        static {
            int[] r100 = new int[FlowResourceScene.values().length];
            r100[FlowResourceScene.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[FlowResourceScene.FileUpload.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[FlowResourceScene.ImageVLM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[FlowResourceScene.ImageOCR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[FlowResourceScene.ImageEDU.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[FlowResourceScene.VideoUpload.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[FlowResourceScene.O_Server.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[FlowResourceScene.O_Mobile_Tmp.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[FlowResourceScene.O_ASSISTANT_FEEDBACK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[FlowResourceScene.CreationUserVideo.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[FlowResourceScene.CreationUserVideoV2.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[FlowResourceScene.SpringMainVenue.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f313546a = r100;
        }
    }

    public ResourceCenter() {
    }

    static {
        f313541a = new ResourceCenter();
        if (AppHost.f326268a.isOversea() == false) goto L5;
        String r100 = "3";
    L6:
        f313542b = r100;
        f313543c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f313544d = new ConcurrentHashMap();
        f313545e = new ConcurrentHashMap();
        FLogger.f375446a.i("ResourceCenter", "[init] config:" + f());
        return;
    L5:
        r100 = "4";
        goto L6
    }

    public static b4 f() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isTestChannel() == true) goto L9;
        if (r100.isDebugChannel() == true) goto L9;
        return z2.f365865a.getResourceCenterConfig();
    L9:
        return e.f313559a;
    }

    public static boolean c() {
        if (f().a() == false) goto L13;
        c4 r100 = f().b();
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.d() != true) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        FLogger.f375446a.i("ResourceCenter", "[clearRecordedData] identifier:" + r100);
        f313544d.remove(r100);
        f313545e.remove(r100);
    }

    public static boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        String r101 = f313544d.get(r100);
        boolean r102 = false;
        if (r101 != null) goto L5;
        return false;
    L5:
        FlowResourceScene.Companion.getClass();
        switch(a.f313546a[FlowResourceScene.a.a(r101).ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L30;
            case 4: goto L20;
            case 5: goto L10;
            case 6: goto L38;
            case 7: goto L38;
            case 8: goto L38;
            case 9: goto L38;
            case 10: goto L38;
            case 11: goto L38;
            case 12: goto L38;
            default: goto L8;
        };
    L38:
        r102 = true;
        goto L40
    L39:
        r102 = c();
    L40:
        FLogger.f375446a.i("ResourceCenter", "[enabledForRecordedScene] sceneId:" + r101 + ", enabled:" + r102);
        return r102;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        if (f().a() == false) goto L40;
        c4 r103 = f().b();
        if (r103 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L40;
    L14:
        if (r103.a() != true) goto L16;
        r104 = true;
        goto L17
    L20:
        if (f().a() == false) goto L40;
        c4 r105 = f().b();
        if (r105 != null) goto L24;
    L26:
        boolean r106 = false;
    L27:
        if (r106 == false) goto L40;
    L24:
        if (r105.b() != true) goto L26;
        r106 = true;
        goto L27
    L30:
        if (f().a() == false) goto L40;
        c4 r107 = f().b();
        if (r107 != null) goto L34;
    L36:
        boolean r108 = false;
    L37:
        if (r108 == false) goto L40;
    L34:
        if (r107.c() != true) goto L36;
        r108 = true;
        goto L37
    }

    public static FlowResourceScene g(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        String r101 = f313544d.get(r100);
        if (r101 == null) goto L7;
        FlowResourceScene.Companion.getClass();
        FlowResourceScene r102 = FlowResourceScene.a.a(r101);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return FlowResourceScene.Unknown;
    }

    public static void k(String r100, FlowResourceScene r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, String> r103 = f313544d;
        FlowResourceScene.Companion.getClass();
        r103.put(r100, FlowResourceScene.a.b(r101));
        FLogger.f375446a.i("ResourceCenter", "[recordScene] identifier:" + r100 + ", scene:" + r103.get(r100));
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final Object b(List<String> r100, Continuation<? super String> r101) {
        if ((r101 instanceof ResourceCenter$deleteResource$1) == false) goto L7;
        ResourceCenter$deleteResource$1 r102 = (ResourceCenter$deleteResource$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        dm9.a r107 = (dm9.a) r104;
        if ((r107 instanceof dm9.a.C5690a) == false) goto L21;
        FLogger.f375446a.e("ResourceCenter", "[deleteResource] failed, " + r107);
    L21:
        return r107.toString();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ResourceApi.a r108 = ResourceApi.f313539a;
        ResourceCenter$deleteResource$2 r109 = new ResourceCenter$deleteResource$2(r100, null);
        r102.label = 1;
        r108.getClass();
        r104 = ResourceApi.a.a("/alice/resource/delete", r109, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new ResourceCenter$deleteResource$1(this, r101);
        goto L8
    }

    public final Object e(String r100, String r101, Continuation<? super String> r102) {
        if ((r102 instanceof ResourceCenter$getAudioFileDetailUrl$1) == false) goto L7;
        ResourceCenter$getAudioFileDetailUrl$1 r103 = (ResourceCenter$getAudioFileDetailUrl$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        dm9.a r108 = (dm9.a) r105;
        if ((r108 instanceof dm9.a.C5690a) == false) goto L21;
        FLogger.f375446a.e("ResourceCenter", "[getAudioFileDetailUrl] failed, " + r108);
        return null;
    L21:
        if ((r108 instanceof dm9.a.b) == false) goto L27;
        Map r109 = (Map) ((dm9.a.b) r108).f469231a.getData();
        FLogger.f375446a.i("ResourceCenter", "[getAudioFileDetailUrl] success, urlMap=" + r109);
        if (r109 != null) goto L25;
        return null;
    L25:
        return (String) r109.get(r100);
    L27:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        ResourceApi.a r110 = ResourceApi.f313539a;
        ResourceCenter$getAudioFileDetailUrl$2 r111 = new ResourceCenter$getAudioFileDetailUrl$2(r100, r101, null);
        r103.L$0 = r100;
        r103.label = 1;
        r110.getClass();
        r105 = ResourceApi.a.a("/alice/resource/get_audio_file_h5", r111, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new ResourceCenter$getAudioFileDetailUrl$1(this, r102);
        goto L8
    }

    public final Object j(FlowResourceType r210, String r211, Continuation<? super PrepareUploadResult> r212) {
        if ((r212 instanceof ResourceCenter$prepareUpload$1) == false) goto L7;
        ResourceCenter$prepareUpload$1 r100 = (ResourceCenter$prepareUpload$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        g.a r105 = (g.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L59:
        dm9.a r106 = (dm9.a) r102;
        if ((r106 instanceof dm9.a.C5690a) == false) goto L63;
        FLogger.f375446a.e("ResourceCenter", "[prepareUpload] failed, " + r106);
        return new PrepareUploadResult(null, "HttpError(" + ((dm9.a.C5690a) r106).f469228a + ')', 1, null);
    L63:
        if ((r106 instanceof dm9.a.b) == false) goto L166;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("[prepareUpload] prepareUploadResp=");
        dm9.a.b r109 = (dm9.a.b) r106;
        r108.append(r109.f469231a.getData());
        r107.i("ResourceCenter", r108.toString());
        ResourceCenter r110 = f313541a;
        ResourcePrepareUploadData r111 = (ResourcePrepareUploadData) r109.f469231a.getData();
        r110.getClass();
        if (r111 != null) goto L68;
    L129:
        m r112 = null;
    L151:
        if (r112 != null) goto L153;
        r107.e("ResourceCenter", "[prepareUpload] failed, prepareUploadResp is null");
        return new PrepareUploadResult(null, "RespError(null data)", 1, null);
    L153:
        g.f313560a.getClass();
        Intrinsics.checkNotNullParameter(r112, "tokenData");
        Intrinsics.checkNotNullParameter(r105, "cacheKey");
        if (g.d(r105) == false) goto L164;
        r107.i("ResourceCenterUploadTokenCache", "save cache token: " + r112 + ", currentTime: " + AppHost.f326268a.getAppClock().currentTimeMillis());
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L158
        g.f313561b.storeString(g.a(r105), new Gson().toJson(r112));     // Catch: Throwable -> L158
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L158
    L160:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L164;
        FLogger.f375446a.e("ResourceCenterUploadTokenCache", "failed to save cache token, " + r115);
        g.f313560a.getClass();
        g.b(r105);
    L158:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L164:
        return new PrepareUploadResult(r112, null, 2, null);
    L68:
        if (r111.getUploadAuthToken() == null) goto L129;
        ResourceUploadAuthToken r117 = r111.getUploadAuthToken();
        if (r117 == null) goto L73;
        String r118 = r117.getAccessKey();
    L74:
        if (r118 != null) goto L76;
    L79:
        boolean r119 = true;
    L80:
        if (r119 == true) goto L129;
        ResourceUploadAuthToken r120 = r111.getUploadAuthToken();
        if (r120 == null) goto L85;
        String r121 = r120.getSecretKey();
    L86:
        if (r121 != null) goto L88;
    L91:
        boolean r122 = true;
    L92:
        if (r122 == true) goto L129;
        ResourceUploadAuthToken r123 = r111.getUploadAuthToken();
        if (r123 == null) goto L97;
        String r124 = r123.getSessionToken();
    L98:
        if (r124 != null) goto L100;
    L103:
        boolean r125 = true;
    L104:
        if (r125 == true) goto L129;
        ResourceUploadAuthToken r126 = r111.getUploadAuthToken();
        if (r126 == null) goto L109;
        String r127 = r126.getExpiredTime();
    L110:
        if (r127 != null) goto L112;
    L115:
        boolean r128 = true;
    L116:
        if (r128 == true) goto L129;
        ResourceUploadAuthToken r129 = r111.getUploadAuthToken();
        if (r129 == null) goto L121;
        String r130 = r129.getCurrentTime();
    L122:
        if (r130 != null) goto L124;
    L127:
        boolean r131 = true;
    L128:
        if (r131 == true) goto L129;
        String r132 = r111.getServiceId();
        String r133 = r111.getUploadHost();
        String r134 = r111.getUploadPathPrefix();
        ResourceUploadAuthToken r135 = r111.getUploadAuthToken();
        if (r135 == null) goto L133;
        String r136 = r135.getAccessKey();
    L134:
        ResourceUploadAuthToken r137 = r111.getUploadAuthToken();
        if (r137 == null) goto L137;
        String r138 = r137.getSecretKey();
    L138:
        ResourceUploadAuthToken r139 = r111.getUploadAuthToken();
        if (r139 == null) goto L141;
        String r140 = r139.getSessionToken();
    L142:
        ResourceUploadAuthToken r141 = r111.getUploadAuthToken();
        if (r141 == null) goto L145;
        String r213 = r141.getExpiredTime();
    L146:
        ResourceUploadAuthToken r142 = r111.getUploadAuthToken();
        if (r142 == null) goto L149;
        String r214 = r142.getCurrentTime();
    L150:
        r112 = new m(r132, r134, r133, new mr9.b(r136, r138, r140, r213, r214));
        goto L151
    L149:
        r214 = null;
        goto L150
    L145:
        r213 = null;
        goto L146
    L141:
        r140 = null;
        goto L142
    L137:
        r138 = null;
        goto L138
    L133:
        r136 = null;
        goto L134
    L124:
        if (StringsKt.isBlank(r130) == true) goto L127;
        r131 = false;
        goto L128
    L121:
        r130 = null;
        goto L122
    L112:
        if (StringsKt.isBlank(r127) == true) goto L115;
        r128 = false;
        goto L116
    L109:
        r127 = null;
        goto L110
    L100:
        if (StringsKt.isBlank(r124) == true) goto L103;
        r125 = false;
        goto L104
    L97:
        r124 = null;
        goto L98
    L88:
        if (StringsKt.isBlank(r121) == true) goto L91;
        r122 = false;
        goto L92
    L85:
        r121 = null;
        goto L86
    L76:
        if (StringsKt.isBlank(r118) == true) goto L79;
        r119 = false;
        goto L80
    L73:
        r118 = null;
        goto L74
    L166:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FlowResourceScene.Companion.getClass();
        g.a r143 = new g.a(FlowResourceScene.a.a(r211), r210);
        String r144 = f().c();
        if (r144 != null) goto L17;
        String r145 = r211;
    L18:
        g.f313560a.getClass();
        Intrinsics.checkNotNullParameter(r143, "cacheKey");
        if (g.d(r143) == true) goto L21;
    L47:
        g.c(false);
    L48:
        m r146 = null;
    L49:
        if (r146 == null) goto L51;
        FLogger.f375446a.i("ResourceCenter", "[acquireUploadTokenFromCache] success " + r143 + ':' + r146);
    L52:
        if (r146 != null) goto L54;
        ResourceApi.a r147 = ResourceApi.f313539a;
        ResourceCenter$prepareUpload$2 r148 = new ResourceCenter$prepareUpload$2(r145, r210, null);
        r100.L$0 = r143;
        r100.label = 1;
        r147.getClass();
        r102 = ResourceApi.a.a("/alice/resource/prepare_upload", r148, r100);
        if (r102 != r103) goto L58;
        return r103;
    L58:
        r105 = r143;
        goto L59
    L54:
        return new PrepareUploadResult(r146, null, 2, null);
    L51:
        FLogger.f375446a.i("ResourceCenter", "[acquireUploadTokenFromCache] failed, key=" + r143);
        g.f313560a.getClass();
        g.b(r143);
        r146 = null;
        goto L52
    L21:
        if (z2.f365865a.uploaderUseCachedTokenEnable() == false) goto L47;
        String r149 = g.f313561b.getString(g.a(r143), "");
        if (r149 != null) goto L25;
    L46:
        FLogger.f375446a.i("ResourceCenterUploadTokenCache", "accessAuthToken failed, missed");
        goto L47
    L25:
        if (o0.d(r149) == false) goto L46;
        Result.Companion r150 = Result.Companion;     // Catch: Throwable -> L28
        Object r151 = Result.m9449constructorimpl((m) new Gson().fromJson(r149, m.class));     // Catch: Throwable -> L28
    L30:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r151);
        if (r152 == null) goto L34;
        FLogger.f375446a.e("ResourceCenterUploadTokenCache", "accessAuthToken failed, " + r152);
        g.f313560a.getClass();
        g.b(r143);
    L34:
        if (Result.m9455isFailureimpl(r151) == false) goto L36;
        r151 = null;
    L36:
        r146 = (m) r151;
        if (r146 == null) goto L48;
        long r153 = AppHost.f326268a.getAppClock().currentTimeMillis() + 300000;
        FLogger.f375446a.i("ResourceCenterUploadTokenCache", "accessAuthToken success, tokenData: " + r146 + ", deviceTime: " + r153);
        mr9.b r154 = r146.a();
        if (r154 == null) goto L42;
        long r155 = r154.b();
    L44:
        if (r155 <= r153) goto L46;
        g.f313560a.getClass();
        g.c(true);
        goto L49
    L42:
        r155 = -1;
    L28:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L17:
        r145 = r144;
    L7:
        r100 = new ResourceCenter$prepareUpload$1(this, r212);
        goto L8
    }

    public final Object m(List<String> r100, SignUrlMode r101, Continuation<? super Map<String, ResourceSignUrlData>> r102) {
        if ((r102 instanceof ResourceCenter$signUrl$1) == false) goto L7;
        ResourceCenter$signUrl$1 r103 = (ResourceCenter$signUrl$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        dm9.a r109 = (dm9.a) r105;
        if ((r109 instanceof dm9.a.C5690a) == false) goto L21;
        FLogger.f375446a.e("ResourceCenter", "[signUrl] failed, " + r109);
        return MapsKt.emptyMap();
    L21:
        if ((r109 instanceof dm9.a.b) == false) goto L35;
        Map r110 = (Map) ((dm9.a.b) r109).f469231a.getData();
        if (r110 != null) goto L25;
    L28:
        if (r108 == false) goto L30;
        FLogger.f375446a.e("ResourceCenter", "[signUrl] failed, registerResp is null");
    L31:
        if (r110 == null) goto L33;
        return r110;
    L33:
        return MapsKt.emptyMap();
    L30:
        FLogger.f375446a.i("ResourceCenter", "[signUrl] success, registerResp=" + r110);
        goto L31
    L25:
        if (r110.isEmpty() == true) goto L28;
        r108 = false;
        goto L28
    L35:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        ResourceApi.a r111 = ResourceApi.f313539a;
        ResourceCenter$signUrl$2 r112 = new ResourceCenter$signUrl$2(r100, r101, null);
        r103.label = 1;
        r111.getClass();
        r105 = ResourceApi.a.a("/alice/resource/sign_url", r112, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new ResourceCenter$signUrl$1(this, r102);
        goto L8
    }

    public final Object n(List<ResourceSignUrlParamV2> r100, boolean r101, Continuation<? super List<ResourceSignUrlDataV2>> r102) {
        if ((r102 instanceof ResourceCenter$signUrlV2$1) == false) goto L7;
        ResourceCenter$signUrlV2$1 r103 = (ResourceCenter$signUrlV2$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        dm9.a r109 = (dm9.a) r105;
        if ((r109 instanceof dm9.a.C5690a) == false) goto L21;
        FLogger.f375446a.e("ResourceCenter", "[signUrlV2] failed, " + r109);
        return CollectionsKt.emptyList();
    L21:
        if ((r109 instanceof dm9.a.b) == false) goto L35;
        List r110 = (List) ((dm9.a.b) r109).f469231a.getData();
        List r111 = r110;
        if (r111 != null) goto L25;
    L28:
        if (r108 == false) goto L30;
        FLogger.f375446a.e("ResourceCenter", "[signUrlV2] failed, registerResp is null");
    L31:
        if (r110 == null) goto L33;
        return r110;
    L33:
        return CollectionsKt.emptyList();
    L30:
        FLogger.f375446a.i("ResourceCenter", "[signUrlV2] success, registerResp=" + r110);
        goto L31
    L25:
        if (r111.isEmpty() == true) goto L28;
        r108 = false;
        goto L28
    L35:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        ResourceApi.a r112 = ResourceApi.f313539a;
        ResourceCenter$signUrlV2$2 r113 = new ResourceCenter$signUrlV2$2(r100, r101, null);
        r103.label = 1;
        r112.getClass();
        r105 = ResourceApi.a.a("/alice/resource/v2/sign_url", r113, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new ResourceCenter$signUrlV2$1(this, r102);
        goto L8
    }

    public final Object h(String r100, String r101, boolean r102, Continuation<? super GetVideoModelResultItem> r103) {
        if ((r103 instanceof ResourceCenter$getVideoModelResult$1) == false) goto L7;
        ResourceCenter$getVideoModelResult$1 r104 = (ResourceCenter$getVideoModelResult$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = r104.Z$0;
        r100 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L17:
        dm9.a r109 = (dm9.a) r106;
        if ((r109 instanceof dm9.a.C5690a) == false) goto L21;
        FLogger.f375446a.e("ResourceCenter", "[getVideoModel] failed, " + r109);
        return null;
    L21:
        if ((r109 instanceof dm9.a.b) == false) goto L54;
        GetVideoModelResults r110 = (GetVideoModelResults) ((dm9.a.b) r109).f469231a.getData();
        if (r110 == null) goto L51;
        FLogger.f375446a.i("ResourceCenter", "[getVideoModel] success, " + r110);
        if (r102 == false) goto L31;
        List<GetVideoModelResultItem> r111 = r110.getResults();
        if (r111 == null) goto L47;
        List r112 = CollectionsKt.filterNotNull(r111);
        if (r112 == null) goto L47;
        GetVideoModelResultItem r113 = (GetVideoModelResultItem) CollectionsKt.firstOrNull(r112);
    L48:
        if (r113 == null) goto L51;
        return r113;
    L47:
        r113 = null;
        goto L48
    L31:
        List<GetVideoModelResultItem> r114 = r110.getResults();
        if (r114 == null) goto L47;
        List r115 = CollectionsKt.filterNotNull(r114);
        if (r115 == null) goto L47;
        Iterator r116 = r115.iterator();
    L37:
        if (r116.hasNext() == false) goto L45;
        Object r117 = r116.next();
        GetVideoModelParam r118 = ((GetVideoModelResultItem) r117).getParams();
        if (r118 == null) goto L41;
        String r119 = r118.getResourceId();
    L43:
        if (Intrinsics.areEqual(r119, r100) == false) goto L37;
    L46:
        r113 = (GetVideoModelResultItem) r117;
        goto L48
    L41:
        r119 = null;
        goto L43
    L45:
        r117 = null;
    L51:
        FLogger.f375446a.e("ResourceCenter", "[getVideoModel] failed, data is null");
        return null;
    L54:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        ResourceApi.a r120 = ResourceApi.f313539a;
        ResourceCenter$getVideoModelResult$2 r121 = new ResourceCenter$getVideoModelResult$2(r101, r100, null);
        r104.L$0 = r100;
        r104.Z$0 = r102;
        r104.label = 1;
        r120.getClass();
        r106 = ResourceApi.a.a("/alice/resource/get_video_model", r121, r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new ResourceCenter$getVideoModelResult$1(this, r103);
        goto L8
    }

    public final Object l(List<FlowResource> r100, ResourceAttachmentExtra r101, String r102, Continuation<? super dm9.a<? extends Map<String, ResourceRegisterData>>> r103) {
        if ((r103 instanceof ResourceCenter$register$1) == false) goto L7;
        ResourceCenter$register$1 r104 = (ResourceCenter$register$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r100 = (List) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L21:
        dm9.a r109 = (dm9.a) r106;
        if ((r109 instanceof dm9.a.C5690a) == false) goto L25;
        FLogger.f375446a.e("ResourceCenter", "[register] failed, " + r109);
    L46:
        return r109;
    L25:
        if ((r109 instanceof dm9.a.b) == false) goto L48;
        Map r110 = (Map) ((dm9.a.b) r109).f469231a.getData();
        if (r110 != null) goto L29;
        FLogger.f375446a.e("ResourceCenter", "[register] failed, registerResp is null");
        goto L46
    L29:
        FLogger.f375446a.i("ResourceCenter", "[register] registerResp=" + r110);
        f313541a.getClass();
        Iterator<FlowResource> r111 = r100.iterator();
    L31:
        if (r111.hasNext() == false) goto L46;
        FlowResource r112 = r111.next();
        ConcurrentHashMap<String, String> r113 = f313545e;
        String r114 = r112.getIdentifier();
        String r115 = "";
        if (r114 != null) goto L35;
        r114 = "";
    L35:
        String r116 = r112.getUri();
        if (r116 != null) goto L38;
        r116 = "";
    L38:
        ResourceRegisterData r117 = (ResourceRegisterData) r110.get(r116);
        if (r117 == null) goto L41;
        String r118 = r117.getResourceId();
    L42:
        if (r118 == null) goto L45;
        r115 = r118;
    L45:
        r113.put(r114, r115);
        goto L31
    L41:
        r118 = null;
        goto L42
    L48:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        String r119 = f().c();
        if (r119 == null) goto L18;
        r102 = r119;
    L18:
        ResourceApi.a r120 = ResourceApi.f313539a;
        ResourceCenter$register$2 r121 = new ResourceCenter$register$2(r102, r100, r101, null);
        r104.L$0 = r100;
        r104.label = 1;
        r120.getClass();
        r106 = ResourceApi.a.a("/alice/resource/register", r121, r104);
        if (r106 != r107) goto L21;
        return r107;
    L7:
        r104 = new ResourceCenter$register$1(this, r103);
        goto L8
    }

    public static /* synthetic */ Object i(ResourceCenter r100, String r101, String r102, boolean r103, Continuation r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = false;
    L12:
        return r100.h(r101, r102, r103, r104);
    }
}
