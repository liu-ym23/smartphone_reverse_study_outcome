package com.larus.bmhome.upload;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceCenterPostUploadSupport;
import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import com.larus.bmhome.rc.ResourceRegisterData;
import com.larus.bmhome.rc.ResourceRegisterTraceError;
import com.larus.bmhome.upload.instant.ImageInstantUploadStrategy;
import com.larus.bmhome.upload.sdk.api.model.CancelReason;
import com.larus.bmhome.upload.sdk.api.model.RegisterPolicy;
import com.larus.bmhome.upload.sdk.api.model.RoutePolicy;
import com.larus.bmhome.upload.sdk.api.model.UploadMediaType;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import hq9.u1;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes26.dex */
public final class ResourceUploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceUploader f314736a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f314737b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/bmhome/upload/ResourceUploader$StopObserveSdkTaskException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StopObserveSdkTaskException extends RuntimeException {
        public StopObserveSdkTaskException() {
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.bmhome.upload.ResourceUploader$a$a, reason: collision with other inner class name */
        public static final class C4107a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4107a f314738a = null;

            static {
                f314738a = new C4107a();
            }

            public C4107a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f314739a = null;

            static {
                f314739a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314740a = null;

        static {
            int[] r100 = new int[UploadScene.values().length];
            r100[UploadScene.CHAT_FILE_UPLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r100[UploadScene.CHAT_IMAGE_VLM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r100[UploadScene.CHAT_DIRECT_IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r100[UploadScene.CHAT_ATTACHMENT_IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r100[UploadScene.CHAT_IMAGE_OCR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r100[UploadScene.CHAT_IMAGE_EDU.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[UploadScene.CHAT_ATTACHMENT_VIDEO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[UploadScene.CREATION_USER_VIDEO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r100[UploadScene.SPRING_MAIN_VENUE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r100[UploadScene.O_SERVER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[UploadScene.O_MOBILE_TMP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r100[UploadScene.O_ASSISTANT_FEEDBACK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r100[UploadScene.UNKNOWN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            f314740a = r100;
        }
    }

    public ResourceUploader() {
    }

    static {
        f314736a = new ResourceUploader();
        f314737b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void a(a.C4107a r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i("ResourceUploader", "[cancelAllIdentifierUploadTask]");
        Iterator r101 = Collections.list(com.larus.bmhome.upload.sdk.g.f314835b.keys()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) r101.next();
        BuildersKt.launch$default(f314737b, null, null, new ResourceUploader$cancelAllIdentifierUploadTask$1$1(r102, r100, null), 3, null);
        goto L4
    }

    public static /* synthetic */ void c(String r100) {
        b(r100, a.b.f314739a);
    }

    public static void f(mr9.j r100) {
        ms8.b r101 = ms8.b.f515490a;
        ms8.b.g(r101, r100, "callback_success", "success", null, null, 56);
        ms8.b.d(r101, r100, "success", null, 12);
    }

    public static FlowResourceScene h(UploadScene r100) {
        switch(b.f314740a[r100.ordinal()]) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L25;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            default: goto L15;
        };
    L15:
        return null;
    L17:
        return FlowResourceScene.O_ASSISTANT_FEEDBACK;
    L18:
        return FlowResourceScene.O_Mobile_Tmp;
    L19:
        return FlowResourceScene.O_Server;
    L20:
        return FlowResourceScene.SpringMainVenue;
    L21:
        return FlowResourceScene.CreationUserVideo;
    L22:
        return FlowResourceScene.VideoUpload;
    L23:
        return FlowResourceScene.ImageEDU;
    L24:
        return FlowResourceScene.ImageOCR;
    L25:
        return FlowResourceScene.ImageVLM;
    L26:
        return FlowResourceScene.FileUpload;
    }

    public static void b(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        FLogger.f375446a.i("ResourceUploader", "[cancelUploadTask] uploaderIdentifier:" + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, mr9.j> r103 = com.larus.bmhome.upload.sdk.g.f314834a;
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        gs8.b r104 = com.larus.bmhome.upload.sdk.g.f314835b.get(r100);
        if (r104 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r101, a.b.f314739a) == false) goto L17;
        CancelReason r105 = CancelReason.User;
    L19:
        r104.b(r105);
        return;
    L17:
        if (Intrinsics.areEqual(r101, a.C4107a.f314738a) == false) goto L22;
        r105 = CancelReason.LeaveChat;
        goto L19
    L22:
        throw new NoWhenBranchMatchedException();
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static void d(mr9.j r100, String r101) {
        if (r100.f515011m == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ResourceUploader", "[upload_" + r100.f515010l + "] " + r101 + " counting down latch.");
        CountDownLatch r102 = r100.f515012n;
        if (r102 == null) goto L9;
        r102.countDown();
        return;
    }

    public static FlowResourceScene g(mr9.j r100, UploadScene r101) {
        String r102 = r100.f515010l;
        if (r102 == null) goto L22;
        boolean r103 = false;
        if (r102.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        FlowResourceScene r105 = null;
        if (r104 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L22;
        ResourceCenter.f313541a.getClass();
        FlowResourceScene r106 = ResourceCenter.g(r102);
        if (r106 == null) goto L22;
        if (r106 == FlowResourceScene.Unknown) goto L18;
        r103 = true;
    L18:
        if (r103 == false) goto L20;
        r105 = r106;
    L20:
        if (r105 == null) goto L22;
        return r105;
    L7:
        r104 = false;
    L22:
        FlowResourceScene r107 = h(r101);
        if (r107 == null) goto L25;
        return r107;
    L25:
        return FlowResourceScene.Unknown;
    }

    public final Object j(mr9.j r310, Continuation<? super Unit> r311) {
        mr9.j r100 = r310;
        if ((r311 instanceof ResourceUploader$upload$1) == false) goto L7;
        ResourceUploader$upload$1 r101 = (ResourceUploader$upload$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ResourceUploader$upload$1 r110 = r101;
        Object r103 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        boolean r112 = false;
        String r105 = "param";
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        u1 r106 = (u1) r110.L$2;
        UploadScene r107 = (UploadScene) r110.L$1;
        mr9.j r108 = (mr9.j) r110.L$0;
        ResultKt.throwOnFailure(r103);
        mr9.j r109 = r108;
        r105 = "param";
        int r113 = 2;
    L109:
        if (((Boolean) r103).booleanValue() == true) goto L111;
    L112:
        boolean r114 = Intrinsics.areEqual(r106.e(), Boxing.boxBoolean(true));
        if (r109.f515013o.f514994a == false) goto L131;
        String r115 = r109.f515010l;
        if (r115 == null) goto L131;
        if (r115.length() <= 0) goto L119;
        boolean r116 = true;
    L120:
        if (r116 == true) goto L123;
        r115 = null;
    L123:
        if (r115 == null) goto L131;
        ResourceCenter.f313541a.getClass();
        if (ResourceCenter.g(r115) != FlowResourceScene.Unknown) goto L131;
        FlowResourceScene r117 = h(r107);
        if (r117 == null) goto L131;
        ResourceCenter.k(r115, r117);
        goto L131
    L119:
        r116 = false;
    L131:
        int r118 = com.larus.bmhome.upload.sdk.d.f314831a;
        Intrinsics.checkNotNullParameter(r109, r105);
        int r119 = com.larus.bmhome.upload.sdk.d.a.f314832a[r109.f515001c.ordinal()];
        if (r119 == 1) goto L143;
        if (r119 != r113) goto L135;
        UploadMediaType r120 = UploadMediaType.VIDEO;
    L144:
        UploadMediaType r121 = r120;
        boolean r122 = r109.f515013o.f514994a;
        String r123 = r109.f515010l;
        if (r123 != null) goto L148;
        r123 = UUID.randomUUID().toString();
    L148:
        if (r109.f515005g == false) goto L150;
        is8.i r124 = new is8.i.a(r109.f514999a);
    L151:
        is8.i r125 = r124;
        String r126 = r109.f515000b;
        if (r107 == null) goto L154;
        UploadScene r127 = r107;
    L167:
        is8.c r128 = new is8.c(r126, r127, r123);
        if (r122 == false) goto L170;
        RoutePolicy r129 = RoutePolicy.ForceResourceCenter;
    L171:
        if (r122 == false) goto L173;
        RegisterPolicy r130 = RegisterPolicy.ForceEnable;
    L174:
        is8.f r131 = new is8.f(r129, r130, 57);
        String r132 = r109.f515009k;
        Pair[] r133 = new Pair[r113];
        r133[0] = TuplesKt.to("source_scene", r109.f515000b);
        r133[1] = TuplesKt.to("source_identifier", r123);
        is8.g r134 = new is8.g(r125, r121, r128, r131, new is8.e(r132, MapsKt.mapOf(r133), 14));
        String r135 = r134.f495672c.f495650f;
        String r136 = r109.f515010l;
        if (r136 != null) goto L177;
        String r137 = r135;
    L178:
        mr9.j r138 = mr9.j.a(r109, null, null, null, null, r137, 2095103);
        if (r138.f515013o.f514994a == true) goto L184;
        ResourceCenter r139 = ResourceCenter.f313541a;
        String r140 = r138.f515010l;
        if (r140 != null) goto L183;
        r140 = "";
    L183:
        r139.getClass();
        ResourceCenter.a(r140);
    L184:
        ConcurrentHashMap<String, mr9.j> r141 = com.larus.bmhome.upload.sdk.g.f314834a;
        Intrinsics.checkNotNullParameter(r135, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r138, r105);
        Intrinsics.checkNotNullParameter(r107, "uploadScene");
        com.larus.bmhome.upload.sdk.g.f314834a.put(r135, r138);
        ConcurrentHashMap<String, Boolean> r142 = com.larus.bmhome.upload.sdk.g.f314837d;
        int r143 = com.larus.bmhome.upload.sdk.g.a.f314838a[r107.ordinal()];
        if (r143 != 1) goto L187;
    L189:
        r142.put(r135, Boolean.valueOf(r112));
        com.larus.bmhome.upload.sdk.impl.core.a r144 = ((gs8.a) com.larus.bmhome.upload.sdk.c.f314830a.getValue()).a(r134);
        Intrinsics.checkNotNullParameter(r135, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r144, "handle");
        com.larus.bmhome.upload.sdk.g.f314835b.put(r135, r144);
        BuildersKt.launch$default(f314737b, null, null, new ResourceUploader$submitSdkUpload$1(r144, r135, r138, r114, null), 3, null);
        return Unit.INSTANCE;
    L187:
        if (r143 == 2) goto L189;
        r112 = true;
        goto L189
    L177:
        r137 = r136;
        goto L178
    L173:
        r130 = RegisterPolicy.Disabled;
        goto L174
    L170:
        r129 = RoutePolicy.ForceUploadAuthToken;
        goto L171
    L154:
        if (r121 != UploadMediaType.VIDEO) goto L157;
        r127 = UploadScene.CHAT_ATTACHMENT_VIDEO;
        goto L167
    L157:
        if (r121 != UploadMediaType.FILE) goto L160;
        r127 = UploadScene.CHAT_FILE_UPLOAD;
        goto L167
    L160:
        if (r109.f515013o.f514994a == false) goto L163;
        r127 = UploadScene.CHAT_ATTACHMENT_IMAGE;
        goto L167
    L163:
        if (r121 != UploadMediaType.IMAGE) goto L165;
        r127 = UploadScene.CHAT_DIRECT_IMAGE;
        goto L167
    L165:
        r127 = UploadScene.CHAT_FILE_UPLOAD;
        goto L167
    L150:
        r124 = new is8.i.b(r109.f514999a);
        goto L151
    L135:
        if (r119 != 3) goto L137;
    L141:
        r120 = UploadMediaType.FILE;
        goto L144
    L137:
        if (r119 == 4) goto L141;
        throw new NoWhenBranchMatchedException();
    L143:
        r120 = UploadMediaType.IMAGE;
        goto L144
    L111:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r106 = (u1) r110.L$2;
        r107 = (UploadScene) r110.L$1;
        mr9.j r145 = (mr9.j) r110.L$0;
        ResultKt.throwOnFailure(r103);
        r109 = r145;
        r113 = 2;
    L103:
        com.larus.bmhome.upload.instant.b r146 = (com.larus.bmhome.upload.instant.b) r103;
        if (r146 == null) goto L112;
        FLogger.f375446a.i("ResourceUploader", "[upload_" + r109.f515010l + "] instant hit before sdk, result=" + r146.f314770a);
        ResourceUploader r147 = f314736a;
        r110.L$0 = r109;
        r110.L$1 = r107;
        r110.L$2 = r106;
        r110.label = r113;
        r103 = r147.i(r109, r146, r107, r110);
        if (r103 != r111) goto L109;
        return r111;
    L16:
        ResultKt.throwOnFailure(r103);
        String r148 = r100.f515010l;
        if (r148 != null) goto L19;
    L26:
        UplinkFileEntity r149 = r100.f515013o.f514996c;
        if (r149 == null) goto L36;
        r148 = r149.getFileIdentifier();
        if (r148 == null) goto L36;
        if (r148.length() <= 0) goto L33;
        boolean r150 = true;
    L34:
        if (r150 == false) goto L36;
    L37:
        if (r148 != null) goto L39;
        r148 = UUID.randomUUID().toString();
    L39:
        String r151 = r148;
        if (Intrinsics.areEqual(r151, r100.f515010l) == true) goto L43;
        r100 = mr9.j.a(r310, null, null, null, null, r151, 2095103);
    L43:
        Function1<String, Unit> r152 = r100.f515019u;
        if (r152 == null) goto L46;
        r152.invoke("upload_dispatched");
    L46:
        int r153 = com.larus.bmhome.upload.sdk.a.f314805a;
        Intrinsics.checkNotNullParameter(r100, "param");
        String r154 = r100.f515010l;
        if (r154 != null) goto L49;
    L59:
        FlowResourceScene r155 = FlowResourceScene.Unknown;
    L61:
        switch(com.larus.bmhome.upload.sdk.a.C4109a.f314806a[r155.ordinal()]) {
            case 1: goto L74;
            case 2: goto L73;
            case 3: goto L72;
            case 4: goto L71;
            case 5: goto L70;
            case 6: goto L69;
            case 7: goto L69;
            case 8: goto L68;
            case 9: goto L67;
            case 10: goto L66;
            case 11: goto L65;
            case 12: goto L64;
            default: goto L63;
        };
    L64:
        UploadScene r156 = null;
    L75:
        if (r156 != null) goto L93;
        UploadDataType r157 = r100.f515001c;
        if (r157 != UploadDataType.VIDEO) goto L80;
        r156 = UploadScene.CHAT_ATTACHMENT_VIDEO;
        goto L93
    L80:
        if (r157 != UploadDataType.FILE) goto L82;
    L92:
        r156 = UploadScene.CHAT_FILE_UPLOAD;
        goto L93
    L82:
        if (r157 == UploadDataType.UNCLEAR) goto L92;
        UploadDataType r158 = UploadDataType.IMAGE;
        if (r157 == r158) goto L87;
    L89:
        if (r157 != r158) goto L91;
        r156 = UploadScene.CHAT_DIRECT_IMAGE;
        goto L93
    L91:
        r156 = UploadScene.CHAT_FILE_UPLOAD;
        goto L93
    L87:
        if (r100.f515013o.f514994a == false) goto L89;
        r156 = UploadScene.CHAT_ATTACHMENT_IMAGE;
    L93:
        u1 r159 = z2.f365865a.getImageInstantUploadConfig();
        ms8.b r160 = ms8.b.f515490a;
        String r210 = r156.name();
        Boolean r161 = Boxing.boxBoolean(Intrinsics.areEqual(r159.e(), Boxing.boxBoolean(true)));
        if (Intrinsics.areEqual(r159.e(), Boxing.boxBoolean(true)) == true) goto L96;
    L98:
        boolean r162 = false;
    L99:
        Boolean r163 = Boxing.boxBoolean(r162);
        r160.getClass();
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter("sdk", "chain");
        String r164 = ms8.b.l(r100);
        long r211 = SystemClock.elapsedRealtime();
        Boolean r165 = Boolean.TRUE;
        ms8.b.f515491b.put(r164, new ms8.b.a(r164, r211, "sdk", r210, Intrinsics.areEqual(r161, r165), Intrinsics.areEqual(r163, r165), null, null, null));
        ms8.b.g(r160, r100, "upload_start", "success", 0L, null, 48);
        FLogger.f375446a.i("ResourceUploader", "[upload_" + r100.f515010l + "] route to sdk, uploadScene=" + r156 + "  [instantUploadPolicy_" + r100.f515016r + "], resourceCenterEnabled=" + r100.f515013o.f514994a);
        ImageInstantUploadStrategy r166 = ImageInstantUploadStrategy.f314769a;
        FlowResourceScene.a r167 = FlowResourceScene.Companion;
        FlowResourceScene r168 = g(r100, r156);
        r167.getClass();
        String r169 = FlowResourceScene.a.b(r168);
        r110.L$0 = r100;
        r110.L$1 = r156;
        r110.L$2 = r159;
        r110.label = 1;
        r113 = 2;
        Object r170 = r166.o(r100, r156, r169, r159, r110);
        if (r170 != r111) goto L102;
        return r111;
    L102:
        r109 = r100;
        r106 = r159;
        r107 = r156;
        r103 = r170;
        goto L103
    L96:
        if (Intrinsics.areEqual(r159.d(), Boxing.boxBoolean(true)) == false) goto L98;
        r162 = true;
        goto L99
    L65:
        r156 = UploadScene.O_ASSISTANT_FEEDBACK;
        goto L75
    L66:
        r156 = UploadScene.O_MOBILE_TMP;
        goto L75
    L67:
        r156 = UploadScene.O_SERVER;
        goto L75
    L68:
        r156 = UploadScene.SPRING_MAIN_VENUE;
        goto L75
    L69:
        r156 = UploadScene.CREATION_USER_VIDEO;
        goto L75
    L70:
        r156 = UploadScene.CHAT_ATTACHMENT_VIDEO;
        goto L75
    L71:
        r156 = UploadScene.CHAT_IMAGE_EDU;
        goto L75
    L72:
        r156 = UploadScene.CHAT_IMAGE_OCR;
        goto L75
    L73:
        r156 = UploadScene.CHAT_IMAGE_VLM;
        goto L75
    L74:
        r156 = UploadScene.CHAT_FILE_UPLOAD;
        goto L75
    L63:
        throw new NoWhenBranchMatchedException();
    L49:
        if (r154.length() <= 0) goto L51;
        boolean r171 = true;
    L52:
        if (r171 == true) goto L55;
        r154 = null;
    L55:
        if (r154 == null) goto L59;
        ResourceCenter.f313541a.getClass();
        r155 = ResourceCenter.g(r154);
        if (r155 == null) goto L59;
    L51:
        r171 = false;
        goto L52
    L33:
        r150 = false;
    L36:
        r148 = null;
        goto L37
    L19:
        if (r148.length() <= 0) goto L21;
        boolean r172 = true;
    L22:
        if (r172 == true) goto L25;
        r148 = null;
    L25:
        if (r148 != null) goto L39;
    L21:
        r172 = false;
    L7:
        r101 = new ResourceUploader$upload$1(this, r311);
        goto L8
    }

    public static void e(mr9.j r100, ResourceUploadError r101, String r110) {
        ms8.b r102 = ms8.b.f515490a;
        ms8.b.g(r102, r100, "callback_fail", r110, null, r101, 40);
        ms8.b.d(r102, r100, r110, r101, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v6 */
    public final Object i(mr9.j r310, com.larus.bmhome.upload.instant.b r311, UploadScene r312, Continuation<? super Boolean> r313) {
        com.larus.bmhome.upload.instant.b r100 = r311;
        if ((r313 instanceof ResourceUploader$tryNotifyInstantUploadSuccess$1) == false) goto L7;
        ResourceUploader$tryNotifyInstantUploadSuccess$1 r101 = (ResourceUploader$tryNotifyInstantUploadSuccess$1) r313;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ResourceUploader$tryNotifyInstantUploadSuccess$1 r110 = r101;
        Object r103 = r110.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r110.label;
        String r111 = "api_path";
        String r106 = "api_name";
        String r112 = "resource_scene";
        String r107 = "register_finished";
        if (r105 != 0) goto L11;
        ResultKt.throwOnFailure(r103);
        com.larus.bmhome.upload.instant.f.a(r310);
        FlowResourceScene r108 = g(r310, r312);
        ms8.b.f515490a.getClass();
        ms8.b.i(r310, "resource_register");
        Function1<String, Unit> r109 = r310.f515019u;
        if (r109 == null) goto L124;
        r109.invoke("register_started");
    L124:
        ResourceCenterPostUploadSupport r113 = ResourceCenterPostUploadSupport.f313547a;     // Catch: Throwable -> L83
        mr9.l r114 = r100.f314770a;     // Catch: Throwable -> L83
        mr9.h r115 = r310.f515013o;     // Catch: Throwable -> L81
        UplinkFileEntity r116 = r115.f514996c;     // Catch: Throwable -> L79
        ResourceAttachmentExtra r117 = r115.f514995b;     // Catch: Throwable -> L79
        FlowResourceScene.Companion.getClass();     // Catch: Throwable -> L79
        String r210 = FlowResourceScene.a.b(r108);     // Catch: Throwable -> L79
        String r118 = r310.f515010l;     // Catch: Throwable -> L77
        FlowResourceType r211 = com.larus.bmhome.upload.a.a(r310);     // Catch: Throwable -> L77
        ResourceInstantUploadInfo r119 = r100.f314771b;     // Catch: Throwable -> L74
        Long r120 = r310.f515018t;     // Catch: Throwable -> L74
        r110.L$0 = r310;     // Catch: Throwable -> L74
        r110.L$1 = r100;     // Catch: Throwable -> L74
        r110.L$2 = r108;     // Catch: Throwable -> L74
        r110.label = 1;     // Catch: Throwable -> L74
        Object r121 = "register_type";
        r108 = r108;
        r107 = "register_finished";
        Object r212 = "/alice/resource/register";
        String r213 = "api_path";
        r112 = "resource_scene";
        boolean r214 = true;
        boolean r215 = true;
        String r216 = "resource_register";
        String r217 = "api_name";
        Object r218 = "instant_hit";
        int r122 = 4;
        Object r123 = r113.a(r114, r116, r117, r210, r118, r211, r119, r120, r110);     // Catch: Throwable -> L72
        if (r123 != r104) goto L35;
        return r104;
    L35:
        mr9.j r124 = r310;
        Object r125 = r123;
        FlowResourceScene r126 = r108;
    L128:
        ResourceRegisterData r127 = (ResourceRegisterData) r125;     // Catch: Throwable -> L69
        ms8.b r128 = ms8.b.f515490a;     // Catch: Throwable -> L69
        Pair[] r129 = new Pair[r122];     // Catch: Throwable -> L69
        r129[0] = TuplesKt.to(r112, r126.name());     // Catch: Throwable -> L69
        Object r130 = r218;
        r129[r215 ? 1 : 0] = TuplesKt.to(r121, r130);     // Catch: Throwable -> L67
        r106 = r217;
        String r131 = r216;
        r129[2] = TuplesKt.to(r106, r131);     // Catch: Throwable -> L65
        r111 = r213;
        Object r219 = r212;
        r129[3] = TuplesKt.to(r111, r219);     // Catch: Throwable -> L63
        ms8.b.c(r128, r124, "resource_register", "success", null, MapsKt.mapOf(r129), 8);     // Catch: Throwable -> L61
        mr9.l r132 = r100.f314770a;     // Catch: Throwable -> L61
        String r133 = r100.f314771b.getRegisterUri();     // Catch: Throwable -> L61
        String r134 = r127.getResourceId();     // Catch: Throwable -> L61
        String r135 = r127.getAliasName();     // Catch: Throwable -> L61
        if (r135 != null) goto L48;
        r135 = r100.f314770a.f515023b;     // Catch: Throwable -> L61
    L48:
        mr9.l r136 = mr9.l.a(r132, r133, r135, r134, 120);     // Catch: Throwable -> L61
        Function1<String, Unit> r137 = r124.f515019u;
        if (r137 == null) goto L52;
        r137.invoke(r107);
    L52:
        Function1<String, Unit> r138 = r124.f515019u;
        if (r138 == null) goto L142;
        r138.invoke("fast_upload");
    L142:
        r124.f515002d.invoke(r136);     // Catch: Throwable -> L58
        f(r124);
        d(r124, "instant hit");
        return Boxing.boxBoolean(r215);
    L58:
        th = move-exception;
        f(r124);
        d(r124, "instant hit");
        throw th;
    L61:
        th = th;
    L71:
        FlowResourceScene r139 = r126;
        ?? r220 = r215;
    L86:
        Function1<String, Unit> r140 = r124.f515019u;
        if (r140 == null) goto L89;
        r140.invoke(r107);
    L89:
        Map<String, Object> r141 = null;
        if ((th instanceof ResourceRegisterTraceError) == false) goto L92;
        ResourceRegisterTraceError r142 = th;
    L93:
        if (r142 == null) goto L97;
        ResourceUploadError r143 = r142.getUploadError();
        if (r143 == null) goto L97;
    L105:
        ms8.b r144 = ms8.b.f515490a;
        Pair[] r145 = new Pair[6];
        r145[0] = TuplesKt.to(r112, r139.name());
        r145[r220] = TuplesKt.to(r121, r130);
        r145[2] = TuplesKt.to(r106, r131);
        r145[3] = TuplesKt.to(r111, r219);
        String r146 = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
        if (r142 != null) goto L108;
        Object r147 = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
    L109:
        r145[4] = TuplesKt.to("error_type", r147);
        if (r142 == null) goto L113;
        r146 = null;
    L113:
        r145[5] = TuplesKt.to("fail_reason", r146);
        Map r148 = MapsKt.mapOf(r145);
        if (r142 == null) goto L116;
        r141 = r142.getTraceExtra();
    L116:
        if (r141 != null) goto L118;
        r141 = MapsKt.emptyMap();
    L118:
        Map r149 = MapsKt.plus(r148, r141);
        r144.getClass();
        ms8.b.b(r124, r131, "fail", r143, r149);
        FLogger.f375446a.e("ResourceUploader", "[upload_" + r124.f515010l + "] instant hit register failed, fallback to normal upload", th);
        return Boxing.boxBoolean(false);
    L108:
        r147 = null;
    L97:
        if ((th instanceof ResourceUploadError) == false) goto L99;
        r143 = th;
    L100:
        if (r143 != null) goto L105;
        String r150 = th.getMessage();
        if (r150 != null) goto L104;
        r150 = "";
    L104:
        r143 = new ResourceUploadError(ResourceUploadError.REGISTER_ERROR, r150);
        goto L105
    L99:
        r143 = null;
        goto L100
    L92:
        r142 = null;
    L63:
        th = th;
    L65:
        th = th;
        r126 = r126;
        r106 = r106;
        r111 = r213;
        r219 = r212;
    L67:
        th = th;
        r126 = r126;
        r111 = r213;
        r106 = r217;
        r219 = r212;
        r131 = r216;
    L69:
        th = th;
        r126 = r126;
        r111 = r213;
        r106 = r217;
        r219 = r212;
        r131 = r216;
        r130 = r218;
    L72:
        th = th;
        r107 = r107;
        r111 = r213;
        r106 = r217;
        r219 = r212;
        r131 = r216;
        r130 = r218;
    L85:
        r124 = r310;
        r139 = r108;
        r220 = r214;
    L74:
        th = th;
        r121 = "register_type";
        r130 = "instant_hit";
        r219 = "/alice/resource/register";
        r131 = "resource_register";
    L76:
        r214 = true;
    L77:
        th = th;
        r131 = "resource_register";
        r121 = "register_type";
        r130 = "instant_hit";
        r219 = "/alice/resource/register";
    L79:
        th = th;
        r219 = "/alice/resource/register";
        r131 = "resource_register";
        r121 = "register_type";
        r130 = "instant_hit";
    L81:
        th = th;
        r130 = "instant_hit";
        r219 = "/alice/resource/register";
        r131 = "resource_register";
        r121 = "register_type";
    L83:
        th = th;
        r121 = "register_type";
        r130 = "instant_hit";
        r219 = "/alice/resource/register";
        r131 = "resource_register";
        goto L76
    L11:
        if (r105 != 1) goto L18;
        FlowResourceScene r151 = (FlowResourceScene) r110.L$2;
        r100 = (com.larus.bmhome.upload.instant.b) r110.L$1;
        r124 = (mr9.j) r110.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
        r125 = r103;
        r107 = "register_finished";
        r218 = "instant_hit";
        r217 = "api_name";
        r213 = "api_path";
        r212 = "/alice/resource/register";
        r112 = "resource_scene";
        r216 = "resource_register";
        r122 = 4;
        r215 = true;
        r126 = r151;
        r121 = "register_type";
    L15:
        th = th;
        r107 = "register_finished";
        r130 = "instant_hit";
        r106 = "api_name";
        r111 = "api_path";
        r219 = "/alice/resource/register";
        r112 = "resource_scene";
        r131 = "resource_register";
        r220 = 1;
        r139 = r151;
        r121 = "register_type";
        goto L86
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new ResourceUploader$tryNotifyInstantUploadSuccess$1(this, r313);
        goto L8
    }
}
