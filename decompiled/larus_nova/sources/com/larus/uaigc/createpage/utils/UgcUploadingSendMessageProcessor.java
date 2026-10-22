package com.larus.uaigc.createpage.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import yc9.n1;

/* JADX INFO: loaded from: classes31.dex */
public final class UgcUploadingSendMessageProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f372624a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f372625b = null;

    public static final class a {
    }

    public UgcUploadingSendMessageProcessor() {
    }

    static {
        f372624a = Collections.synchronizedSet(new LinkedHashSet());
        f372625b = new ConcurrentHashMap();
    }

    public final Object f(String r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof UgcUploadingSendMessageProcessor$ugcReviewImage$1) == false) goto L7;
        UgcUploadingSendMessageProcessor$ugcReviewImage$1 r102 = (UgcUploadingSendMessageProcessor$ugcReviewImage$1) r101;
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
        boolean r108 = r107 instanceof dm9.a.b;
        if (r108 == false) goto L32;
        dm9.a.b r109 = (dm9.a.b) r107;
        if (r109.f469231a.isSuccess() == false) goto L32;
        ReviewUgcImageApi.c r110 = (ReviewUgcImageApi.c) r109.f469231a.getData();
        if (r110 == null) goto L29;
        Integer r111 = r110.a();
        if (r111 == null) goto L29;
        if (r111.intValue() != 3) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L32;
        return Boxing.boxBoolean(false);
    L29:
        r112 = false;
    L32:
        if (r108 == true) goto L37;
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L37;
        return null;
    L37:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ReviewUgcImageApi.Companion r113 = ReviewUgcImageApi.f370263a;
        UgcUploadingSendMessageProcessor$ugcReviewImage$checkResult$1 r114 = new UgcUploadingSendMessageProcessor$ugcReviewImage$checkResult$1(r100, null);
        r102.label = 1;
        r113.getClass();
        r104 = ReviewUgcImageApi.Companion.a(r114, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new UgcUploadingSendMessageProcessor$ugcReviewImage$1(this, r101);
        goto L8
    }

    public static void e(String r210, NestedFileContent r211, Long r212, String r310) {
        if (r212 == null) goto L82;
        long r100 = r212.longValue();
        if (r211 == null) goto L6;
        List<UplinkFileEntity> r101 = r211.getEntities();
    L7:
        if (r101 != null) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        Iterator<T> r102 = r101.iterator();
        long r103 = 0;
        long r110 = 0;
        int r104 = 0;
    L11:
        if (r102.hasNext() == false) goto L61;
        UplinkFileEntity r111 = (UplinkFileEntity) r102.next();
        String r112 = r111.getFileIdentifier();
        if (r112 == null) goto L11;
        if (r112.length() <= 0) goto L17;
        boolean r113 = true;
    L18:
        if (r113 == true) goto L21;
        r112 = null;
    L21:
        if (r112 == null) goto L11;
        UplinkEntityContent r114 = r111.getUplinkEntityContent();
        if (r114 == null) goto L33;
        UplinkFileInfo r115 = r114.getUplinkFileInfo();
        if (r115 == null) goto L33;
        Integer r116 = r115.getFileType();
        int r105 = FileType.FileTypeVideo.getValue();
        if (r116 == null) goto L33;
        if (r116.intValue() != r105) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
        ResourceMediaType r117 = ResourceMediaType.VIDEO;
    L37:
        if (r106 == false) goto L39;
        com.larus.bmhome.resource.access.x r118 = com.larus.uaigc.service.f.f373959c;
    L40:
        com.larus.bmhome.resource.access.x r119 = r118;
        ICreationResourceAccessService.Companion r107 = ICreationResourceAccessService.f373925a;
        if (r106 == false) goto L43;
        String r108 = "creation_video";
    L44:
        com.larus.bmhome.resource.access.z r109 = r107.d(r112, r119, r117, r108);
        if (r109 == null) goto L57;
        Long r120 = Long.valueOf(r109.f313786e);
        long r121 = r120.longValue();
        if (r121 > 0) goto L49;
    L51:
        boolean r122 = false;
    L52:
        if (r122 == true) goto L55;
        r120 = null;
    L55:
        if (r120 == null) goto L57;
        long r123 = r100 - r120.longValue();
    L59:
        if (r123 <= 0) goto L11;
        r104 = r104 + 1;
        r103 = r103 + r123;
        r110 = Math.max(r110, r123);
        goto L11
    L49:
        if (r121 >= r100) goto L51;
        r122 = true;
    L57:
        r123 = 0;
        goto L59
    L43:
        r108 = null;
        goto L44
    L39:
        r118 = com.larus.uaigc.service.f.f373957a;
        goto L40
    L36:
        r117 = ResourceMediaType.IMAGE;
    L33:
        r106 = false;
        goto L34
    L17:
        r113 = false;
        goto L18
    L61:
        int r124 = r101.size();
        if (r104 <= 0) goto L64;
        boolean r213 = true;
    L65:
        CreationResourceAccessUploader r125 = CreationResourceAccessUploader.f372969a;
        ResourceMediaType r126 = ResourceMediaType.FILE;
        long r214 = System.currentTimeMillis() - r100;
        Pair[] r127 = new Pair[2];
        com.larus.uaigc.helper.f.f373014a.getClass();
        r127[0] = TuplesKt.to("pipeline_enabled", String.valueOf(com.larus.uaigc.helper.f.a()));
        if (r211 == null) goto L70;
        List<UplinkFileEntity> r128 = r211.getEntities();
        if (r128 == null) goto L70;
        int r129 = r128.size();
    L71:
        r127[1] = TuplesKt.to("entity_count", String.valueOf(r129));
        CreationResourceAccessUploader.j(r210, null, r126, r310, r214, r213, "ugc_uploading_send", MapsKt.plus(MapsKt.mapOf(r127), MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_entity_count", String.valueOf(r124)), TuplesKt.to("reuse_entity_count", String.valueOf(r104)), TuplesKt.to("has_reused_task", String.valueOf(r213)), TuplesKt.to("send_wait_estimated_saved_ms", String.valueOf(r103)), TuplesKt.to("send_wait_max_saved_ms", String.valueOf(r110))})), Long.valueOf(r103));
        return;
    L70:
        r129 = 0;
        goto L71
    L64:
        r213 = false;
        goto L65
    L6:
        r101 = null;
        goto L7
    }

    public final Object d(UplinkFileEntity r110, String r111, String r112, String r113, Continuation<? super Boolean> r114) {
        if ((r114 instanceof UgcUploadingSendMessageProcessor$preHandleV2Review$1) == false) goto L7;
        UgcUploadingSendMessageProcessor$preHandleV2Review$1 r100 = (UgcUploadingSendMessageProcessor$preHandleV2Review$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r115 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r115);
    L17:
        dm9.a r116 = (dm9.a) r115;
        if ((r116 instanceof dm9.a.b) == true) goto L20;
    L22:
        r104 = false;
    L24:
        return Boxing.boxBoolean(r104);
    L20:
        if (((dm9.a.b) r116).f469231a.isSuccess() == false) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        ReviewUgcImageApi.Companion r117 = ReviewUgcImageApi.f370263a;
        UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1 r105 = new UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1(r110, r112, r113, r111, null);
        r100.label = 1;
        r117.getClass();
        r115 = ReviewUgcImageApi.Companion.a(r105, r100);
        if (r115 != r102) goto L17;
        return r102;
    L7:
        r100 = new UgcUploadingSendMessageProcessor$preHandleV2Review$1(this, r114);
        goto L8
    }

    public static final Object b(UgcUploadingSendMessageProcessor r100, String r110, UplinkFileEntity r111, String r112, String r113, String r114, boolean r115, Continuation r116) {
        r100.getClass();
        if (r115 == false) goto L50;
        String r101 = null;
        if (r111 == null) goto L7;
        String r102 = r111.getInstantUploadInfoJson();
    L8:
        boolean r103 = false;
        if (r102 != null) goto L11;
    L40:
        ResourceUploadInstantInfo r104 = null;
    L41:
        if (r104 == null) goto L43;
        r103 = Intrinsics.areEqual(r104.getPreQueryHit(), Boxing.boxBoolean(true));
    L43:
        if (r103 == false) goto L50;
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.b().b(), Boxing.boxBoolean(true)) == false) goto L50;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("[reviewAttachment] skip pre_handle on instant hit, identifier=");
        if (r111 == null) goto L49;
        r101 = r111.getFileIdentifier();
    L49:
        r106.append(r101);
        r105.i("NestedFileSendMessageProcessor", r106.toString());
        return Boxing.boxBoolean(true);
    L11:
        if (r102.length() <= 0) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L17;
        r102 = null;
    L17:
        if (r102 == null) goto L40;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L34
        zd9.h r109 = zd9.h.f571481a;     // Catch: Throwable -> L34
        if (StringsKt.isBlank(r102) == false) goto L56;
    L31:
        Object r117 = null;
    L32:
        Object r118 = Result.m9449constructorimpl((ResourceUploadInstantInfo) r117);     // Catch: Throwable -> L34
    L37:
        if (Result.m9455isFailureimpl(r118) == false) goto L39;
        r118 = null;
    L39:
        r104 = (ResourceUploadInstantInfo) r118;
        goto L41
    L56:
        r109.getClass();     // Catch: Throwable -> L24
        r117 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r102, new s().getType()));     // Catch: Throwable -> L24
    L26:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L34
        if (r119 == null) goto L30;
        com.larus.im.internal.delegate.c0 r120 = com.larus.im.internal.delegate.c0.f348199b;     // Catch: Throwable -> L34
        StringBuilder r121 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r119, "<this>");     // Catch: Throwable -> L34
        r121.append(ExceptionsKt.stackTraceToString(r119));     // Catch: Throwable -> L34
        r120.e("GsonHolder", r121.toString());     // Catch: Throwable -> L34
    L30:
        if (Result.m9455isFailureimpl(r117) == false) goto L32;
    L24:
        th = move-exception;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L34
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    L13:
        r107 = false;
        goto L14
    L7:
        r102 = null;
    L50:
        if (r115 == false) goto L53;
        return r100.d(r111, r112, r113, r114, r116);
    L53:
        return r100.f(r110, r116);
    }

    public static final Object a(UgcUploadingSendMessageProcessor r510, AtomicInteger r511, AtomicBoolean r512, ICoreInputAbility.OnSendParams r513, Map r514, String r610, String r611, Function3 r612, Continuation r613) {
        String r100 = r610;
        r510.getClass();
        if ((r613 instanceof UgcUploadingSendMessageProcessor$checkSendMessage$1) == false) goto L7;
        UgcUploadingSendMessageProcessor$checkSendMessage$1 r101 = (UgcUploadingSendMessageProcessor$checkSendMessage$1) r613;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        CustomMultiAttachmentInfo r106 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        Function3 r107 = (Function3) r101.L$4;
        String r108 = (String) r101.L$3;
        String r109 = (String) r101.L$2;
        Map r110 = (Map) r101.L$1;
        ICoreInputAbility.OnSendParams r111 = (ICoreInputAbility.OnSendParams) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Map r112 = r110;
        ICoreInputAbility.OnSendParams r113 = r111;
        Object r114 = r103;
        Function3 r115 = r107;
        r100 = r109;
    L24:
        NestedFileContent r116 = (NestedFileContent) r114;
        if (r116 != null) goto L31;
        CustomMultiAttachmentInfo r117 = r113.getCustomMultiAttachment();
        if (r117 == null) goto L29;
        r116 = r117.getNestedFileContent();
    L30:
        FLogger.f375446a.w("NestedFileSendMessageProcessor", "[checkSendMessage] cache snapshot missing, fallback to send snapshot, localMessageId=" + r100);
        goto L31
    L29:
        r116 = null;
    L31:
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("[checkSendMessage] finalNestedFileContent entities count: ");
        if (r116 == null) goto L36;
        List<UplinkFileEntity> r120 = r116.getEntities();
        if (r120 == null) goto L36;
        Integer r121 = Boxing.boxInt(r120.size());
    L37:
        r119.append(r121);
        r118.i("NestedFileSendMessageProcessor", r119.toString());
        Long r122 = f372625b.remove(r100);
        if (r116 == null) goto L40;
        List<UplinkFileEntity> r123 = r116.getEntities();
    L41:
        if (r123 != null) goto L43;
        r123 = CollectionsKt.emptyList();
    L43:
        List<UplinkFileEntity> r124 = r123;
        if ((r124 instanceof Collection) == true) goto L46;
    L48:
        Iterator<T> r125 = r124.iterator();
    L50:
        if (r125.hasNext() == false) goto L62;
        UplinkFileEntity r126 = (UplinkFileEntity) r125.next();
        if (n1.d(r126) == false) goto L59;
        Integer r127 = r126.getFileReviewStatus();
        int r128 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r127 == null) goto L59;
        if (r127.intValue() != r128) goto L59;
        boolean r129 = true;
    L60:
        if (r129 == false) goto L50;
        boolean r130 = true;
    L63:
        if (r130 == false) goto L78;
        FLogger.f375446a.i("NestedFileSendMessageProcessor", "[checkSendMessage] image review rejected, mark SEND_COMPLIANT");
        String[] r131 = {r100, r108};
        ArrayList r132 = new ArrayList();
        int r133 = 0;
    L65:
        if (r133 >= 2) goto L73;
        String r134 = r131[r133];
        if (r134.length() <= 0) goto L69;
        boolean r135 = true;
    L70:
        if (r135 == false) goto L72;
        r132.add(r134);
    L72:
        r133 = r133 + 1;
        goto L65
    L69:
        r135 = false;
        goto L70
    L73:
        Iterator r136 = r132.iterator();
    L75:
        if (r136.hasNext() == false) goto L77;
        String r137 = (String) r136.next();
        RepoDispatcherDelegate r138 = RepoDispatcherDelegate.f307737b;
        r138.e().r1(r137, new q());
        r138.e().t1(r137, 14);
        goto L75
    L77:
        e(r100, r116, r122, "review_un_pass");
        return Unit.INSTANCE;
    L78:
        NestedFileContent r139 = CreationNoWatermarkManager.f373832a.b0(r116);
        if (r139 != null) goto L81;
        NestedFileContent r140 = r116;
    L82:
        CreationMediaAttachmentExtUpdater.f372612a.getClass();
        CreationMediaAttachmentExtUpdater.c(r112, r140);
        Map r210 = MapsKt.toMap(r112);
        CustomMultiAttachmentInfo r141 = r113.getCustomMultiAttachment();
        if (r141 == null) goto L85;
        r106 = CustomMultiAttachmentInfo.copy$default(r141, null, null, r140, false, false, false, false, null, 251, null);
    L85:
        ICoreInputAbility.OnSendParams r142 = ICoreInputAbility.OnSendParams.copy$default(r113, null, null, null, null, null, r210, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, r106, null, null, null, null, null, null, -67108897, 1, null);
        FLogger r143 = FLogger.f375446a;
        r143.i("NestedFileSendMessageProcessor", "[checkSendMessage] Calling originalLogic to send message");
        r115.invoke(r142, r100, r108);
        e(r100, r116, r122, "actual_send");
        r143.i("NestedFileSendMessageProcessor", "[checkSendMessage] Message sent");
        return Unit.INSTANCE;
    L81:
        r140 = r139;
    L59:
        r129 = false;
    L62:
        r130 = false;
        goto L63
    L46:
        if (r124.isEmpty() == false) goto L48;
    L40:
        r123 = null;
    L36:
        r121 = null;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        int r144 = r511.get();
        FLogger r145 = FLogger.f375446a;
        r145.i("NestedFileSendMessageProcessor", "[checkSendMessage] handlingFileCount: " + r144);
        if (r144 <= 0) goto L18;
        r145.i("NestedFileSendMessageProcessor", "[checkSendMessage] Still have " + r144 + " files processing, waiting...");
        return Unit.INSTANCE;
    L18:
        if (r512.compareAndSet(false, true) == true) goto L20;
        r145.i("NestedFileSendMessageProcessor", "[checkSendMessage] Message already sent, skip duplicate call");
        return Unit.INSTANCE;
    L20:
        r145.i("NestedFileSendMessageProcessor", "[checkSendMessage] All files processed, preparing to send message");
        MainCoroutineDispatcher r146 = Dispatchers.getMain();
        UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1 r147 = new UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1(r100, null);
        r113 = r513;
        r101.L$0 = r113;
        r112 = r514;
        r101.L$1 = r112;
        r101.L$2 = r100;
        r101.L$3 = r611;
        r101.L$4 = r612;
        r101.label = 1;
        Object r148 = BuildersKt.withContext(r146, r147, r101);
        if (r148 == r104) goto L99;
        r114 = r148;
        r108 = r611;
        r115 = r612;
        goto L24
    L99:
        return r104;
    L7:
        r101 = new UgcUploadingSendMessageProcessor$checkSendMessage$1(r510, r613);
        goto L8
    }

    public static final void c(AtomicBoolean r110, String r111, AtomicInteger r112, UgcUploadingSendMessageProcessor r113, y8 r114, AtomicBoolean r115, ICoreInputAbility.OnSendParams r116, Map r210, Ref.ObjectRef r211, Ref.ObjectRef r212, Function3 r213, String r214) {
        if (r110.compareAndSet(false, true) == true) goto L5;
        FLogger.f375446a.i("NestedFileSendMessageProcessor", "[" + r214 + "] skip duplicate finish, identifier: " + r111);
        return;
    L5:
        f372624a.remove(r111);
        int r100 = r112.decrementAndGet();
        FLogger.f375446a.i("NestedFileSendMessageProcessor", "[" + r214 + "] handlingFileCount decremented, remaining: " + r100 + ", identifier: " + r111);
        AlbumHelperKt.g(GlobalScope.INSTANCE, null, new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$finishImageProcessing$1(r113, r114, r112, r115, r116, r210, r211, r212, r213, null), 3);
    }
}
