package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.gallery.api.GalleryType;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class PublishAction implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f324696a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324697a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f324698b = null;

        static {
            int[] r100 = new int[SourceType.values().length];
            r100[SourceType.CREATION_RECORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r100[SourceType.CREATION_CARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            f324697a = r100;
            int[] r101 = new int[GalleryType.values().length];
            r101[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            f324698b = r101;
        }
    }

    static {
    }

    public PublishAction() {
    }

    public static PublisherCreation d(xy8.d r210, xy8.e r211) {
        String r100 = r211.f565443a;
        Integer r101 = r211.f565444b;
        Integer r102 = r211.f565450h;
        String r103 = r211.f565445c;
        if (r103 != null) goto L5;
    L10:
        r103 = null;
    L11:
        String r104 = r211.f565451i;
        if (r104 != null) goto L20;
        r104 = r210.f565432g;
        if (r104.length() <= 0) goto L16;
        boolean r110 = true;
    L17:
        if (r110 == true) goto L20;
        r104 = null;
        goto L20
    L16:
        r110 = false;
    L20:
        xy8.b r111 = r210.f565428c;
        if (r111 == null) goto L24;
        String r112 = r111.f565413a;
        if (r112 == null) goto L24;
    L28:
        String r113 = r211.f565446d;
        String r105 = r211.f565448f;
        if (r105 == null) goto L31;
        Integer r114 = StringsKt.toIntOrNull(r105);
    L32:
        String r106 = r211.f565447e;
        if (r106 != null) goto L35;
    L40:
        String r115 = null;
    L41:
        String r107 = r211.f565449g;
        if (r211.f565443a == null) goto L44;
        boolean r116 = true;
    L46:
        return new PublisherCreation(r100, r101, r102, r103, r104, r112, r113, r114, r115, r116, r107, null, null, null, 14336, null);
    L44:
        r116 = false;
        goto L46
    L35:
        if (r106.length() <= 0) goto L37;
        boolean r117 = true;
    L38:
        if (r117 == false) goto L40;
        r115 = r106;
        goto L41
    L37:
        r117 = false;
        goto L38
    L31:
        r114 = null;
    L24:
        xy8.g r108 = r210.f565429d;
        if (r108 == null) goto L27;
        r112 = r108.f565463d;
        goto L28
    L27:
        r112 = null;
        goto L28
    L5:
        if (r103.length() <= 0) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == false) goto L10;
    L7:
        r109 = false;
        goto L8
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r110, Continuation<? super Unit> r210) {
        FLogger.f375446a.i("PublishAction", "execute: sourceType=" + r110.f324766a.f565426a);
        xy8.d r100 = r110.f324766a;
        xy8.e r101 = r100.f565438m;
        if (r101 == null) goto L5;
        Integer r102 = r101.f565444b;
    L7:
        if (b.f324698b[r100.f565430e.ordinal()] != 1) goto L9;
        String r103 = "video_detail";
    L10:
        String r104 = "";
        if (r102 == null) goto L13;
        String r111 = zp9.y.b(r102.intValue());
    L14:
        if (r102 == null) goto L16;
        r104 = zp9.y.a(r102.intValue());
    L16:
        String r105 = r104;
        if (r110.f324775j == false) goto L19;
        String r106 = "share_panel";
    L20:
        JSONObject r112 = new JSONObject();
        r112.put("click_from", r106);
        Iterator<Map.Entry<String, Object>> r107 = r100.f565431f.entrySet().iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        Map.Entry<String, Object> r108 = r107.next();
        String r113 = r108.getKey();
        Object r109 = r108.getValue();
        if (r112.has(r113) == true) goto L22;
        r112.put(r113, r109);
        goto L22
    L26:
        if (r101 == null) goto L29;
        String r114 = r101.f565445c;
        if (r114 == null) goto L29;
    L33:
        if (r101 == null) goto L35;
        String r115 = r101.f565443a;
    L36:
        String r116 = r111;
        tx9.m0.b(r114, null, null, "chat", r103, r111, r105, r115, r112, 518);
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("reportClickPublish: click_add_creation, creationId=");
        if (r101 == null) goto L39;
        String r119 = r101.f565443a;
    L40:
        r118.append(r119);
        r118.append(", type=");
        r118.append(r116);
        r118.append(", subType=");
        r118.append(r105);
        r118.append(", currentPage=");
        r118.append(r103);
        r117.i("PublishAction", r118.toString());
        int r120 = b.f324697a[r110.f324766a.f565426a.ordinal()];
        if (r120 != 1) goto L43;
        xy8.d r121 = r110.f324766a;
        xy8.e r122 = r121.f565438m;
        if (r122 != null) goto L56;
        r117.w("PublishAction", "handleCreationRecord: publishMetadata is null");
        Object r123 = Unit.INSTANCE;
    L67:
        if (r123 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L70;
        return r123;
    L70:
        return Unit.INSTANCE;
    L56:
        if (z2.f365865a.getCreationPublishConfig().b() == false) goto L62;
        UserCreation r124 = r121.f565439n;
        if (r124 == null) goto L60;
        PublisherCreation r125 = zp9.d.g(r124, null);
    L61:
        r117.i("PublishAction", "handleCreationRecord: gotoPublisher, creationId=" + r122.f565443a);
        com.larus.platform.service.e0.f365731a.a1(r125, new PublisherTrackParams("creation_detail", 6));
        r123 = Unit.INSTANCE;
        goto L67
    L60:
        r125 = d(r121, r122);
        goto L61
    L62:
        r123 = g(r110, r122, r210);
        if (r123 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L67;
        r123 = Unit.INSTANCE;
        goto L67
    L43:
        if (r120 == 2) goto L46;
        r117.w("PublishAction", "不支持的 sourceType: " + r110.f324766a.f565426a);
        return Unit.INSTANCE;
    L46:
        Object r126 = e(r110, r210);
        if (r126 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        return r126;
    L50:
        return Unit.INSTANCE;
    L39:
        r119 = null;
        goto L40
    L35:
        r115 = null;
    L29:
        xy8.f r127 = r100.f565437l;
        if (r127 == null) goto L32;
        r114 = r127.f565454a;
        goto L33
    L32:
        r114 = null;
        goto L33
    L19:
        r106 = "detail_page";
        goto L20
    L13:
        r111 = "";
        goto L14
    L9:
        r103 = "picture_detail";
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public final Object e(l0 r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof PublishAction$handleCreationCard$1) == false) goto L7;
        PublishAction$handleCreationCard$1 r101 = (PublishAction$handleCreationCard$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        ResultKt.throwOnFailure(r111);
    L45:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r111);
    L40:
        return Unit.INSTANCE;
    L18:
        r100 = (l0) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L34:
        xy8.e r112 = (xy8.e) r111;
        if (r112.f565443a == null) goto L41;
        FLogger.f375446a.i("PublishAction", "handleCreationCard: 从消息 ext 补全 creationId=" + r112.f565443a);
        r101.L$0 = null;
        r101.label = 3;
        if (g(r100, r112, r101) != r103) goto L40;
        return r103;
    L41:
        FLogger.f375446a.i("PublishAction", "handleCreationCard: 无 creationId，走 addCreation");
        r101.L$0 = null;
        r101.label = 4;
        if (c(r100, r112, r101) != r103) goto L45;
        return r103;
    L19:
        ResultKt.throwOnFailure(r111);
    L30:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r111);
        xy8.e r113 = r100.f324766a.f565438m;
        if (r113 != null) goto L25;
        FLogger.f375446a.w("PublishAction", "handleCreationCard: publishMetadata is null");
        return Unit.INSTANCE;
    L25:
        if (r113.f565443a == null) goto L31;
        FLogger.f375446a.i("PublishAction", "handleCreationCard: 已有 creationId=" + r113.f565443a);
        r101.label = 1;
        if (g(r100, r113, r101) != r103) goto L30;
        return r103;
    L31:
        r101.L$0 = r100;
        r101.label = 2;
        r111 = f(r113, r101);
        if (r111 != r103) goto L34;
        return r103;
    L7:
        r101 = new PublishAction$handleCreationCard$1(this, r110);
        goto L8
    }

    public final Object f(xy8.e r110, Continuation<? super xy8.e> r210) {
        xy8.e r100 = r110;
        if ((r210 instanceof PublishAction$resolvePublishMetadataFromMessage$1) == false) goto L7;
        PublishAction$resolvePublishMetadataFromMessage$1 r101 = (PublishAction$resolvePublishMetadataFromMessage$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        String r107 = (String) r101.L$2;
        String r108 = (String) r101.L$1;
        xy8.e r109 = (xy8.e) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
        String r111 = r107;
        r100 = r109;
    L28:
        String r112 = (String) r103;     // Catch: Throwable -> L54
        if (r112 != null) goto L31;
    L34:
        if (r106 == false) goto L36;
        return r100;
    L36:
        String r113 = r108 + '_' + r111;     // Catch: Throwable -> L54
        UserCreationFromIM r114 = (UserCreationFromIM) ((LinkedHashMap) DataConverterKt.c(r112, r108)).get(r113);     // Catch: Throwable -> L54
        if (r114 == null) goto L51;
        FLogger.f375446a.i("PublishAction", "resolvePublishMetadataFromMessage: 找到 creationId=" + r114.getCreationId());     // Catch: Throwable -> L54
        String r115 = r114.getCreationId();     // Catch: Throwable -> L54
        Integer r116 = r114.getCreationType();     // Catch: Throwable -> L54
        if (r116 != null) goto L41;
        r116 = r100.f565444b;     // Catch: Throwable -> L54
    L41:
        Integer r117 = r116;
        String r118 = r114.getRefContent();     // Catch: Throwable -> L54
        if (r118 != null) goto L44;
        r118 = r100.f565446d;     // Catch: Throwable -> L54
    L44:
        String r119 = r118;
        String r120 = r114.getMaterialId();     // Catch: Throwable -> L54
        if (r120 != null) goto L47;
        r120 = r100.f565449g;     // Catch: Throwable -> L54
    L47:
        String r121 = r120;
        String r122 = r114.getPrompt();     // Catch: Throwable -> L54
        if (r122 != null) goto L50;
        r122 = r100.f565451i;     // Catch: Throwable -> L54
    L50:
        xy8.e r123 = xy8.e.a(r100, r115, r117, r119, r121, r122, false, 1716);     // Catch: Throwable -> L54
    L52:
        Object r124 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L54
    L57:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L61;
        FLogger.f375446a.e("PublishAction", "resolvePublishMetadataFromMessage error", r125);
    L61:
        if (Result.m9455isFailureimpl(r124) == true) goto L63;
        return r124;
    L63:
        return r100;
    L54:
        Throwable th10 = th;
        r109 = r100;
    L56:
        Result.Companion r126 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r100 = r109;
        goto L57
    L51:
        FLogger.f375446a.w("PublishAction", "resolvePublishMetadataFromMessage: 未找到匹配项, key=" + r113);     // Catch: Throwable -> L54
        r123 = r100;
        goto L52
    L31:
        if (r112.length() == 0) goto L34;
        r106 = false;
    L14:
        th10 = th;
        goto L56
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        String r127 = r100.f565445c;
        if (r127 != null) goto L21;
        return r100;
    L21:
        r111 = r100.f565447e;
        if (r111 != null) goto L64;
        return r100;
    L64:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L54
        IChatRepoService r129 = RepoDispatcherDelegate.f307737b.e();     // Catch: Throwable -> L54
        r101.L$0 = r100;     // Catch: Throwable -> L54
        r101.L$1 = r127;     // Catch: Throwable -> L54
        r101.L$2 = r111;     // Catch: Throwable -> L54
        r101.label = 1;     // Catch: Throwable -> L54
        Object r130 = r129.w1(r127, r101);     // Catch: Throwable -> L54
        if (r130 != r104) goto L27;
        return r104;
    L27:
        r108 = r127;
        r103 = r130;
    L7:
        r101 = new PublishAction$resolvePublishMetadataFromMessage$1(this, r210);
        goto L8
    }

    public static final void b(PublishAction r210, l0 r211, String r212) {
        r210.getClass();
        PreviewToolbarView r100 = r211.f324771f;
        if (r100 == null) goto L5;
        r100.b(ToolbarButtonType.PUBLISH, new s());
    L5:
        PreviewToolbarView r101 = r211.f324771f;
        if (r101 == null) goto L8;
        r101.b(ToolbarButtonType.SET_PRIVATE, new t());
    L8:
        xy8.d r102 = r211.f324766a;
        xy8.e r103 = r102.f565438m;
        UserCreation r110 = null;
        if (r103 == null) goto L14;
        if (r212 != null) goto L12;
        String r104 = r103.f565443a;
    L13:
        xy8.e r105 = xy8.e.a(r103, r104, null, null, null, null, true, 1022);
    L15:
        UserCreation r106 = r102.f565439n;
        if (r106 == null) goto L18;
        r110 = UserCreation.c(r106, 1, null, null, null, null, null, 131063);
    L18:
        r211.f324770e.Rf(new com.larus.gallery.api.p.j(xy8.d.a(r102, null, null, null, null, null, null, r105, r110, null, 0, 118783), false));
        FLogger.f375446a.i("PublishAction", "swapToSetPrivateButton: 更新发布状态, itemKey=" + r102.f565427b + ", creationId=" + r212);
        return;
    L12:
        r104 = r212;
        goto L13
    L14:
        r105 = null;
        goto L15
    }

    public final Object c(l0 r110, xy8.e r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof PublishAction$addCreation$1) == false) goto L7;
        PublishAction$addCreation$1 r100 = (PublishAction$addCreation$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L16;
        if (r102 == 1) goto L15;
        if (r102 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
    L46:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (l0) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L42:
        MainCoroutineDispatcher r115 = Dispatchers.getMain();
        PublishAction$addCreation$2 r103 = new PublishAction$addCreation$2((zp9.a) r113, r110, this, null);
        r100.L$0 = null;
        r100.label = 2;
        if (BuildersKt.withContext(r115, r103, r100) != r114) goto L46;
        return r114;
    L16:
        ResultKt.throwOnFailure(r113);
        PublisherCreation r116 = d(r110.f324766a, r111);
        if (z2.f365865a.getCreationPublishConfig().b() == false) goto L20;
        FLogger.f375446a.i("PublishAction", "addCreation: isByPublisher=true, gotoPublisher");
        com.larus.platform.service.e0.f365731a.a1(r116, new PublisherTrackParams("picture_detail", 6));
        return Unit.INSTANCE;
    L20:
        FLogger.f375446a.i("PublishAction", "addCreation: isByPublisher=false, 直接调 API");
        Integer r117 = r111.f565444b;
        if (r117 != null) goto L24;
    L26:
        if (r117 != null) goto L29;
    L31:
        int r104 = 2;
    L33:
        if (r111.f565452j == false) goto L35;
        int r105 = 4;
    L36:
        com.larus.platform.service.e0 r106 = com.larus.platform.service.e0.f365731a;
        String r118 = r111.f565445c;
        if (r118 != null) goto L39;
        r118 = "";
    L39:
        String r107 = r111.f565448f;
        String r108 = r111.f565447e;
        String r109 = r111.f565449g;
        r100.L$0 = r110;
        r100.label = 1;
        r113 = r106.l(r118, r104, r107, 1, r108, r105, r109, r100);
        if (r113 != r114) goto L42;
        return r114;
    L35:
        r105 = 1;
        goto L36
    L29:
        if (r117.intValue() != 4) goto L31;
        r104 = 4;
        goto L33
    L24:
        if (r117.intValue() != 3) goto L26;
        r104 = 3;
    L7:
        r100 = new PublishAction$addCreation$1(this, r112);
        goto L8
    }

    public final Object g(l0 r110, xy8.e r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof PublishAction$setCreationPublic$1) == false) goto L7;
        PublishAction$setCreationPublic$1 r100 = (PublishAction$setCreationPublic$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r114 = (String) r100.L$1;
        l0 r115 = (l0) r100.L$0;
        ResultKt.throwOnFailure(r113);
        String r104 = r114;
        l0 r105 = r115;
    L39:
        MainCoroutineDispatcher r116 = Dispatchers.getMain();
        PublishAction$setCreationPublic$2 r117 = new PublishAction$setCreationPublic$2((Pair) r113, r105, this, r104, null);
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 2;
        if (BuildersKt.withContext(r116, r117, r100) != r102) goto L43;
        return r102;
    L16:
        ResultKt.throwOnFailure(r113);
        xy8.d r118 = r110.f324766a;
        if (z2.f365865a.getCreationPublishConfig().b() == false) goto L31;
        SourceType r119 = r118.f565426a;
        SourceType r106 = SourceType.CREATION_RECORD;
        if (r119 != r106) goto L24;
        UserCreation r120 = r118.f565439n;
        if (r120 == null) goto L23;
        PublisherCreation r121 = zp9.d.g(r120, null);
    L26:
        if (r118.f565426a != r106) goto L28;
        String r122 = "creation_detail";
    L29:
        FLogger.f375446a.i("PublishAction", "setCreationPublic: isByPublisher=true, gotoPublisher");
        com.larus.platform.service.e0.f365731a.a1(r121, new PublisherTrackParams(r122, 6));
        return Unit.INSTANCE;
    L28:
        r122 = "picture_detail";
        goto L29
    L23:
        r121 = d(r118, r111);
        goto L26
    L24:
        r121 = d(r118, r111);
        goto L26
    L31:
        String r123 = r111.f565443a;
        if (r123 != null) goto L35;
        FLogger.f375446a.w("PublishAction", "setCreationPublic: creationId is null");
        return Unit.INSTANCE;
    L35:
        FLogger.f375446a.i("PublishAction", "setCreationPublic: 调 updateCreationPrivateStatus, creationId=".concat(r123));
        com.larus.platform.service.e0 r124 = com.larus.platform.service.e0.f365731a;
        r100.L$0 = r110;
        r100.L$1 = r123;
        r100.label = 1;
        r113 = r124.h(r123, 1, r100);
        if (r113 != r102) goto L38;
        return r102;
    L38:
        r105 = r110;
        r104 = r123;
    L7:
        r100 = new PublishAction$setCreationPublic$1(this, r112);
        goto L8
    }
}
