package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.gallery.api.GalleryType;
import com.larus.nova.R;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class SetPrivateAction implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f324699a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324700a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f324701b = null;

        static {
            int[] r100 = new int[SourceType.values().length];
            r100[SourceType.CREATION_RECORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r100[SourceType.CREATION_CARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            f324700a = r100;
            int[] r101 = new int[GalleryType.values().length];
            r101[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            f324701b = r101;
        }
    }

    static {
    }

    public SetPrivateAction() {
    }

    public static void g(l0 r210) {
        xy8.d r110 = r210.f324766a;
        xy8.e r111 = r110.f565438m;
        UserCreation r100 = null;
        if (r111 == null) goto L5;
        xy8.e r101 = xy8.e.a(r111, null, null, null, null, null, false, 1023);
    L6:
        UserCreation r112 = r110.f565439n;
        if (r112 == null) goto L9;
        r100 = UserCreation.c(r112, 2, null, null, null, null, null, 131063);
    L9:
        r210.f324770e.Rf(new com.larus.gallery.api.p.j(xy8.d.a(r110, null, null, null, null, null, null, r101, r100, null, 0, 118783), false));
        FLogger.f375446a.i("SetPrivateAction", "updatePreviewData: isPublished=false, itemKey=" + r110.f565427b);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static final void b(SetPrivateAction r100, l0 r101) {
        r100.getClass();
        PreviewToolbarView r102 = r101.f324771f;
        if (r102 == null) goto L5;
        r102.b(ToolbarButtonType.SET_PRIVATE, new w());
    L5:
        PreviewToolbarView r103 = r101.f324771f;
        if (r103 == null) goto L9;
        r103.b(ToolbarButtonType.PUBLISH, new x());
        return;
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof SetPrivateAction$execute$1) == false) goto L7;
        SetPrivateAction$execute$1 r100 = (SetPrivateAction$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r112);
    L53:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
    L58:
        return Unit.INSTANCE;
    L17:
        xy8.d r113 = (xy8.d) r100.L$1;
        l0 r105 = (l0) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L35:
        String r114 = (String) r112;
        xy8.d r115 = r113;
        r110 = r105;
        String r106 = r114;
    L36:
        if (r106 != null) goto L38;
    L39:
        r104 = true;
    L41:
        if (r104 == false) goto L44;
        FLogger.f375446a.w("SetPrivateAction", "creationId is null, itemKey=" + r115.f565427b);
        return Unit.INSTANCE;
    L44:
        FLogger r107 = FLogger.f375446a;
        r107.i("SetPrivateAction", "execute: sourceType=" + r115.f565426a + ", creationId=" + r106);
        int r108 = b.f324700a[r115.f565426a.ordinal()];
        if (r108 == 1) goto L54;
        if (r108 == 2) goto L49;
        r107.w("SetPrivateAction", "设为私密不支持 sourceType=" + r115.f565426a);
        return Unit.INSTANCE;
    L49:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        if (e(r110, r106, r100) != r102) goto L53;
        return r102;
    L54:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 2;
        if (f(r110, r106, r100) != r102) goto L58;
        return r102;
    L38:
        if (r106.length() != 0) goto L41;
    L18:
        ResultKt.throwOnFailure(r112);
        r115 = r110.f324766a;
        xy8.e r109 = r115.f565438m;
        if (r109 == null) goto L21;
        r106 = r109.f565443a;
    L22:
        if (r106 != null) goto L24;
    L27:
        boolean r116 = true;
    L28:
        if (r116 == false) goto L36;
        xy8.e r117 = r115.f565438m;
        if (r117 == null) goto L36;
        r100.L$0 = r110;
        r100.L$1 = r115;
        r100.label = 1;
        Object r118 = d(r117, r100);
        if (r118 != r102) goto L34;
        return r102;
    L34:
        r105 = r110;
        r113 = r115;
        r112 = r118;
        goto L35
    L24:
        if (r106.length() == 0) goto L27;
        r116 = false;
        goto L28
    L21:
        r106 = null;
    L7:
        r100 = new SetPrivateAction$execute$1(this, r111);
        goto L8
    }

    public final Object d(xy8.e r110, Continuation<? super String> r111) {
        if ((r111 instanceof SetPrivateAction$resolveCreationIdFromMessage$1) == false) goto L7;
        SetPrivateAction$resolveCreationIdFromMessage$1 r100 = (SetPrivateAction$resolveCreationIdFromMessage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        String r113 = (String) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L14
    L28:
        String r114 = (String) r112;     // Catch: Throwable -> L14
        if (r114 != null) goto L31;
    L34:
        if (r104 == false) goto L36;
        return null;
    L36:
        String r115 = r105 + '_' + r113;     // Catch: Throwable -> L14
        UserCreationFromIM r116 = (UserCreationFromIM) ((LinkedHashMap) DataConverterKt.c(r114, r105)).get(r115);     // Catch: Throwable -> L14
        if (r116 == null) goto L39;
        FLogger.f375446a.i("SetPrivateAction", "resolveCreationIdFromMessage: 找到 creationId=" + r116.getCreationId());     // Catch: Throwable -> L14
        String r117 = r116.getCreationId();     // Catch: Throwable -> L14
    L40:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L14
    L43:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L47;
        FLogger.f375446a.e("SetPrivateAction", "resolveCreationIdFromMessage error", r119);
    L47:
        if (Result.m9455isFailureimpl(r118) == false) goto L50;
        return null;
    L50:
        return r118;
    L39:
        FLogger.f375446a.w("SetPrivateAction", "resolveCreationIdFromMessage: 未找到匹配项, key=" + r115);     // Catch: Throwable -> L14
        r117 = null;
        goto L40
    L31:
        if (r114.length() == 0) goto L34;
        r104 = false;
        goto L34
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        String r120 = r110.f565445c;
        if (r120 != null) goto L21;
        return null;
    L21:
        r113 = r110.f565447e;
        if (r113 != null) goto L24;
        return null;
    L24:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L14
        IChatRepoService r107 = RepoDispatcherDelegate.f307737b.e();     // Catch: Throwable -> L14
        r100.L$0 = r120;     // Catch: Throwable -> L14
        r100.L$1 = r113;     // Catch: Throwable -> L14
        r100.label = 1;     // Catch: Throwable -> L14
        Object r108 = r107.w1(r120, r100);     // Catch: Throwable -> L14
        if (r108 != r102) goto L27;
        return r102;
    L27:
        r105 = r120;
        r112 = r108;
    L14:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new SetPrivateAction$resolveCreationIdFromMessage$1(this, r111);
        goto L8
    }

    public static void c(l0 r100, xy8.d r110, String r111) {
        if (r100.f324774i == false) goto L5;
        String r101 = "more_panel_click";
    L6:
        xy8.e r102 = r110.f565438m;
        Integer r103 = null;
        if (r102 == null) goto L10;
        String r104 = r102.f565447e;
        if (r104 == null) goto L10;
    L13:
        String r105 = "";
        if (r104 != null) goto L16;
        r104 = "";
    L16:
        if (r102 == null) goto L19;
        String r106 = r102.f565445c;
        if (r106 == null) goto L19;
    L23:
        if (r106 != null) goto L25;
        r106 = "";
    L25:
        int r107 = r110.f565442q;
        if (r110.f565426a != SourceType.USER_SEND) goto L28;
        String r108 = "user";
    L30:
        if (b.f324701b[r110.f565430e.ordinal()] != 1) goto L32;
        String r109 = "video_detail";
    L33:
        xy8.e r112 = r110.f565438m;
        if (r112 == null) goto L36;
        r103 = r112.f565444b;
    L36:
        if (r103 == null) goto L38;
        String r113 = zp9.y.b(r103.intValue());
    L39:
        if (r103 == null) goto L41;
        r105 = zp9.y.a(r103.intValue());
    L41:
        JSONObject r114 = new JSONObject();
        r114.put("creation_id", r111);
        r114.put("creation_task_id", r104);
        r114.put(MusicAppletPage.KEY_MESSAGE_ID, r106);
        r114.put("position", r107);
        r114.put("user_type", r108);
        r114.put("click_method", r101);
        r114.put("current_page", r109);
        r114.put("sub_type", r105);
        r114.put("type", r113);
        r114.put("from_status", "1");
        r114.put("to_status", "0");
        Iterator<Map.Entry<String, Object>> r115 = r110.f565431f.entrySet().iterator();
    L43:
        if (r115.hasNext() == false) goto L47;
        Map.Entry<String, Object> r116 = r115.next();
        String r117 = r116.getKey();
        Object r118 = r116.getValue();
        if (r114.has(r117) == true) goto L43;
        r114.put(r117, r118);
        goto L43
    L47:
        FLogger.f375446a.i("SetPrivateAction", "reportCreationPublicStatus: params=" + r114);
        com.larus.platform.service.o.f365780a.reportEvent("creation_public_status", r114);
        return;
    L38:
        r113 = "";
        goto L39
    L32:
        r109 = "picture_detail";
        goto L33
    L28:
        r108 = "bot";
    L19:
        xy8.f r119 = r110.f565437l;
        if (r119 == null) goto L22;
        r106 = r119.f565454a;
        goto L23
    L22:
        r106 = null;
    L10:
        if (r102 == null) goto L12;
        r104 = r102.f565443a;
        goto L13
    L12:
        r104 = null;
        goto L13
    L5:
        r101 = "detail_click";
        goto L6
    }

    public final Object e(l0 r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof SetPrivateAction$setPrivateViaCreationCard$1) == false) goto L7;
        SetPrivateAction$setPrivateViaCreationCard$1 r100 = (SetPrivateAction$setPrivateViaCreationCard$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        String r114 = (String) r100.L$1;
        l0 r115 = (l0) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L31:
        t19.s r116 = t19.s.f544207a;
        Context r117 = r115.getContext();
        r116.getClass();
        t19.s.o(r117, R.string.larus_ccMob_PreviewPage_toast_madePrivate, false);
        com.larus.platform.service.e0.f365731a.X0(r114);
    L37:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r111 = (String) r100.L$1;
        r110 = (l0) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L19:
        Pair r118 = (Pair) r113;
        if (r118 != null) goto L22;
    L24:
        r104 = false;
    L25:
        String r105 = null;
        if (r104 == false) goto L32;
        FLogger.f375446a.i("SetPrivateAction", "setPrivateViaCreationCard success: " + r111);
        MutableSharedFlow<com.larus.bmhome.share.panel.k> r119 = com.larus.bmhome.share.panel.l.f313967a;
        com.larus.bmhome.share.panel.l.a(com.larus.bmhome.share.panel.k.b.f313965a);
        g(r110);
        MainCoroutineDispatcher r120 = Dispatchers.getMain();
        SetPrivateAction$setPrivateViaCreationCard$2 r106 = new SetPrivateAction$setPrivateViaCreationCard$2(this, r110, null);
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 2;
        if (BuildersKt.withContext(r120, r106, r100) != r102) goto L30;
        return r102;
    L30:
        String r107 = r111;
        r115 = r110;
        r114 = r107;
        goto L31
    L32:
        FLogger r121 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("setPrivateViaCreationCard failed: ");
        r108.append(r111);
        r108.append(", ");
        if (r118 == null) goto L35;
        r105 = (String) r118.getSecond();
    L35:
        r108.append(r105);
        r121.w("SetPrivateAction", r108.toString());
        goto L37
    L22:
        if (((Boolean) r118.getFirst()).booleanValue() != true) goto L24;
    L16:
        ResultKt.throwOnFailure(r113);
        c(r110, r110.f324766a, r111);
        com.larus.platform.service.e0 r122 = com.larus.platform.service.e0.f365731a;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 1;
        r113 = r122.h(r111, 2, r100);
        if (r113 != r102) goto L19;
        return r102;
    L7:
        r100 = new SetPrivateAction$setPrivateViaCreationCard$1(this, r112);
        goto L8
    }

    public final Object f(l0 r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof SetPrivateAction$setPrivateViaCreationRecord$1) == false) goto L7;
        SetPrivateAction$setPrivateViaCreationRecord$1 r100 = (SetPrivateAction$setPrivateViaCreationRecord$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        String r114 = (String) r100.L$1;
        l0 r115 = (l0) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L44:
        t19.s r116 = t19.s.f544207a;
        Context r117 = r115.getContext();
        r116.getClass();
        t19.s.o(r117, R.string.larus_ccMob_PreviewPage_toast_madePrivate, false);
        com.larus.platform.service.e0.f365731a.X0(r114);
    L50:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r114 = (String) r100.L$1;
        r115 = (l0) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L32:
        Pair r118 = (Pair) r113;
    L34:
        if (r118 != null) goto L36;
    L38:
        r104 = false;
    L39:
        String r105 = null;
        if (r104 == false) goto L45;
        FLogger.f375446a.i("SetPrivateAction", "setPrivateViaCreationRecord success: " + r114);
        MutableSharedFlow<com.larus.bmhome.share.panel.k> r119 = com.larus.bmhome.share.panel.l.f313967a;
        com.larus.bmhome.share.panel.l.a(com.larus.bmhome.share.panel.k.b.f313965a);
        g(r115);
        MainCoroutineDispatcher r120 = Dispatchers.getMain();
        SetPrivateAction$setPrivateViaCreationRecord$2 r106 = new SetPrivateAction$setPrivateViaCreationRecord$2(this, r115, null);
        r100.L$0 = r115;
        r100.L$1 = r114;
        r100.label = 3;
        if (BuildersKt.withContext(r120, r106, r100) != r102) goto L44;
        return r102;
    L45:
        FLogger r121 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("setPrivateViaCreationRecord failed: ");
        r107.append(r114);
        r107.append(", ");
        if (r118 == null) goto L48;
        r105 = (String) r118.getSecond();
    L48:
        r107.append(r105);
        r121.w("SetPrivateAction", r107.toString());
        goto L50
    L36:
        if (((Boolean) r118.getFirst()).booleanValue() != true) goto L38;
    L17:
        r111 = (String) r100.L$1;
        r110 = (l0) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L21:
        r118 = (Pair) r113;
        if (r118 != null) goto L24;
    L26:
        boolean r108 = false;
    L27:
        if (r108 == true) goto L33;
        FLogger.f375446a.w("SetPrivateAction", "setPrivateViaCreationRecord: 首次失败，重试: " + r111);
        com.larus.platform.service.e0 r122 = com.larus.platform.service.e0.f365731a;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 2;
        r113 = r122.h(r111, 2, r100);
        if (r113 != r102) goto L31;
        return r102;
    L31:
        String r109 = r111;
        r115 = r110;
        r114 = r109;
        goto L32
    L33:
        String r123 = r111;
        r115 = r110;
        r114 = r123;
        goto L34
    L24:
        if (((Boolean) r118.getFirst()).booleanValue() != true) goto L26;
        r108 = true;
        goto L27
    L18:
        ResultKt.throwOnFailure(r113);
        c(r110, r110.f324766a, r111);
        com.larus.platform.service.e0 r124 = com.larus.platform.service.e0.f365731a;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 1;
        r113 = r124.h(r111, 2, r100);
        if (r113 != r102) goto L21;
        return r102;
    L7:
        r100 = new SetPrivateAction$setPrivateViaCreationRecord$1(this, r112);
        goto L8
    }
}
