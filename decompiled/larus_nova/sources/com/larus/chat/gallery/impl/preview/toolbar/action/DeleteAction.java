package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.nova.R;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class DeleteAction implements o {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324681a = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f324681a = r100;
        }
    }

    static {
    }

    public DeleteAction() {
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r110, Continuation<? super Unit> r210) {
        l0 r100 = r110;
        if ((r210 instanceof DeleteAction$execute$1) == false) goto L7;
        DeleteAction$execute$1 r101 = (DeleteAction$execute$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        String r107 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r108 = (String) r101.L$4;
        String r109 = (String) r101.L$3;
        String r111 = (String) r101.L$2;
        xy8.d r112 = (xy8.d) r101.L$1;
        l0 r113 = (l0) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r114 = r108;
        r100 = r113;
        String r115 = r109;
        xy8.d r116 = r112;
    L44:
        Pair r117 = (Pair) r103;
        if (r117 != null) goto L47;
    L49:
        r106 = false;
    L50:
        if (r106 == false) goto L52;
        FLogger.f375446a.i("DeleteAction", "deleteCreation success: " + r111);
        t19.s r118 = t19.s.f544207a;
        Context r119 = r100.getContext();
        r118.getClass();
        t19.s.o(r119, R.string.larus_ccMob_profilePage_privateTab_toast_deleted, false);
        b(r100, r116, r111, r114, r115, "1");
        com.larus.platform.service.e0.f365731a.X0(r111);
        r100.f324770e.Rf(com.larus.gallery.api.p.g.f343882a);
    L57:
        return Unit.INSTANCE;
    L52:
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder("deleteCreation failed: ");
        r121.append(r111);
        r121.append(", ");
        if (r117 == null) goto L55;
        r107 = (String) r117.getSecond();
    L55:
        r121.append(r107);
        r120.w("DeleteAction", r121.toString());
        b(r100, r116, r111, r114, r115, "0");
        goto L57
    L47:
        if (((Boolean) r117.getFirst()).booleanValue() != true) goto L49;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        xy8.d r122 = r100.f324766a;
        xy8.e r123 = r122.f565438m;
        if (r123 == null) goto L17;
        r111 = r123.f565443a;
    L18:
        if (r111 != null) goto L20;
    L23:
        boolean r124 = true;
    L24:
        if (r124 == false) goto L27;
        FLogger.f375446a.w("DeleteAction", "publishMetadata.creationId is null, itemKey=" + r122.f565427b);
        return Unit.INSTANCE;
    L27:
        FLogger.f375446a.i("DeleteAction", "execute: creationId=" + r111);
        UserCreation r125 = r122.f565439n;
        if (r125 == null) goto L32;
        Integer r126 = r125.f364990d;
        if (r126 == null) goto L32;
        int r127 = r126.intValue();
    L34:
        if (r127 != 2) goto L36;
        String r128 = "0";
    L37:
        if (r125 == null) goto L39;
        String r129 = zp9.d.d(r125);
    L40:
        com.larus.platform.service.e0 r130 = com.larus.platform.service.e0.f365731a;
        r101.L$0 = r100;
        r101.L$1 = r122;
        r101.L$2 = r111;
        r101.L$3 = r128;
        r101.L$4 = r129;
        r101.label = 1;
        Object r131 = r130.g(r111, r101);
        if (r131 != r104) goto L43;
        return r104;
    L43:
        r114 = r129;
        r103 = r131;
        r116 = r122;
        r115 = r128;
        goto L44
    L39:
        r129 = "";
        goto L40
    L36:
        r128 = "1";
    L32:
        r127 = 0;
        goto L34
    L20:
        if (r111.length() == 0) goto L23;
        r124 = false;
        goto L24
    L17:
        r111 = null;
    L7:
        r101 = new DeleteAction$execute$1(this, r210);
        goto L8
    }

    public static void b(l0 r100, xy8.d r101, String r102, String r110, String r111, String r112) {
        if (r100.f324774i == false) goto L5;
        String r103 = "more_panel_click";
    L6:
        xy8.e r104 = r101.f565438m;
        String r105 = null;
        if (r104 == null) goto L10;
        String r106 = r104.f565447e;
        if (r106 == null) goto L10;
    L13:
        String r107 = "";
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        if (r104 == null) goto L21;
        String r108 = r104.f565445c;
        if (r108 == null) goto L21;
        r105 = r108;
    L24:
        if (r105 == null) goto L27;
        r107 = r105;
    L27:
        int r109 = r101.f565442q;
        if (r101.f565426a != SourceType.USER_SEND) goto L30;
        String r113 = "user";
    L32:
        if (b.f324681a[r101.f565430e.ordinal()] != 1) goto L34;
        String r114 = "video_detail";
    L35:
        JSONObject r115 = new JSONObject();
        r115.put("previous_page", r114);
        r115.put("current_page", r114);
        r115.put("success", r112);
        r115.put("creation_id", r102);
        r115.put("type", r110);
        r115.put("public_status", r111);
        r115.put("creation_task_id", r106);
        r115.put(MusicAppletPage.KEY_MESSAGE_ID, r107);
        r115.put("position", r109);
        r115.put("user_type", r113);
        r115.put("click_method", r103);
        Iterator<Map.Entry<String, Object>> r116 = r101.f565431f.entrySet().iterator();
    L37:
        if (r116.hasNext() == false) goto L41;
        Map.Entry<String, Object> r117 = r116.next();
        String r118 = r117.getKey();
        Object r119 = r117.getValue();
        if (r115.has(r118) == true) goto L37;
        r115.put(r118, r119);
        goto L37
    L41:
        FLogger.f375446a.i("DeleteAction", "reportCancelCreation: cancel_creation, success=" + r112 + ", params=" + r115);
        com.larus.platform.service.o.f365780a.reportEvent("cancel_creation", r115);
        return;
    L34:
        r114 = "picture_detail";
        goto L35
    L30:
        r113 = "bot";
    L21:
        xy8.f r120 = r101.f565437l;
        if (r120 == null) goto L24;
        r105 = r120.f565454a;
    L10:
        if (r104 == null) goto L12;
        r106 = r104.f565443a;
        goto L13
    L12:
        r106 = null;
        goto L13
    L5:
        r103 = "detail_click";
        goto L6
    }
}
