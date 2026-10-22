package com.larus.bmhome.chat.component.bottom.voice;

import android.net.Uri;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yc9.v0;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f300410d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1a.b f300411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f300412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f300413c;

    public static final class a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            FLogger.f375446a.i("VoiceMixInput", r100);
        }
    }

    static {
    }

    public d0(t1a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        this.f300411a = r100;
    }

    public static String b(t1a.b r100) {
        g1 r101 = (g1) r100.getAbility(g1.class);
        String r102 = null;
        if (r101 == null) goto L25;
        String r103 = r101.uM();
        if (r103 == null) goto L25;
        NestedFileContent r104 = r101.b6(r103);
        if (r104 == null) goto L20;
        v0.g(r104);
        List<UplinkFileEntity> r105 = r104.getEntities();
        if (r105 == null) goto L18;
        UplinkFileEntity r106 = (UplinkFileEntity) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L18;
        Uri r107 = r106.getUri();
        if (r107 == null) goto L18;
        String r108 = r107.toString();
        if (r108 == null) goto L18;
        String r109 = (String) com.larus.utils.l.b(r108, "image_from_scene");
    L19:
        boolean r110 = CollectionsKt.contains(CollectionsKt.listOf(new String[]{"shoot", "shoot_ocr"}), r109);
        boolean r111 = CollectionsKt.contains(CollectionsKt.listOf(new String[]{"album", "album_ocr"}), r109);
    L21:
        if (r111 == false) goto L23;
        r102 = "album";
        goto L25
    L23:
        if (r110 == false) goto L25;
        r102 = "shoot";
    L18:
        r109 = null;
        goto L19
    L20:
        r110 = false;
        r111 = false;
    L25:
        if (r102 != null) goto L28;
        return ObricActionBarTrackType.KEY_BOARD;
    L28:
        return r102;
    }

    public static String a(wc9.e r100, BotModel r101) {
        LruCache<String, wc9.e> r102 = ko8.a.f504531a;
        String r103 = null;
        if (r100 == null) goto L5;
        Integer r104 = r100.f559219v;
    L6:
        if (r101 == null) goto L8;
        Integer r105 = r101.getBotType();
    L9:
        if (r101 == null) goto L14;
        BotCreatorInfo r106 = r101.getBotCreatorInfo();
        if (r106 == null) goto L14;
        r103 = r106.getId();
    L14:
        return ko8.a.f(r104, r105, Intrinsics.areEqual(r103, AccountService.f365697a.getUserId()));
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    public final void c(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r110, "inputPosition");
        if (this.f300413c == false) goto L5;
        return;
    L5:
        this.f300413c = true;
        this.f300412b = System.currentTimeMillis();
        com.larus.bmhome.chat.component.cvs.y r101 = (com.larus.bmhome.chat.component.cvs.y) this.f300411a.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        String r102 = null;
        if (r101 == null) goto L8;
        BotModel r103 = r101.j0();
    L9:
        if (r101 == null) goto L11;
        wc9.e r104 = r101.h();
    L12:
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        JSONObject r106 = new JSONObject();
        if (r103 == null) goto L15;
        String r107 = r103.getBotId();
    L16:
        String r108 = "";
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r106.put("bot_id", r107);
        r106.put("chat_type", a(r104, r103));
        r106.put("current_page", "chat");
        if (r104 == null) goto L22;
        r102 = r104.f559198a;
    L22:
        if (r102 == null) goto L25;
        r108 = r102;
    L25:
        r106.put("conversation_id", r108);
        if (r104 == null) goto L32;
        String r109 = r104.B;
        if (r109 == null) goto L32;
        Long r111 = StringsKt.toLongOrNull(r109);
        if (r111 == null) goto L32;
        long r112 = r111.longValue();
    L33:
        r106.put("section_id", r112);
        r106.put("enter_method", r100);
        r106.put("scene", b(this.f300411a));
        r106.put("input_position", r110);
        Unit r113 = Unit.INSTANCE;
        r105.reportEvent("audio_complement_click", r106);
        return;
    L32:
        r112 = 0;
        goto L33
    L15:
        r107 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    }

    public static /* synthetic */ void e(d0 r100, int r101, int r102, String r103, String r110) {
        r100.d(r101, r102, r103, r110, "end");
    }

    public final void d(int r100, int r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "enterMethod");
        Intrinsics.checkNotNullParameter(r112, "endMethod");
        Intrinsics.checkNotNullParameter(r113, "inputPosition");
        if (this.f300413c == true) goto L5;
        return;
    L5:
        this.f300413c = false;
        com.larus.bmhome.chat.component.cvs.y r101 = (com.larus.bmhome.chat.component.cvs.y) this.f300411a.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        String r102 = null;
        if (r101 == null) goto L8;
        BotModel r103 = r101.j0();
    L9:
        if (r101 == null) goto L11;
        wc9.e r104 = r101.h();
    L12:
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        JSONObject r106 = new JSONObject();
        if (r103 == null) goto L15;
        String r107 = r103.getBotId();
    L16:
        String r108 = "";
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r106.put("bot_id", r107);
        r106.put("chat_type", a(r104, r103));
        r106.put("current_page", "chat");
        if (r104 == null) goto L22;
        r102 = r104.f559198a;
    L22:
        if (r102 == null) goto L25;
        r108 = r102;
    L25:
        r106.put("conversation_id", r108);
        if (r104 == null) goto L32;
        String r109 = r104.B;
        if (r109 == null) goto L32;
        Long r114 = StringsKt.toLongOrNull(r109);
        if (r114 == null) goto L32;
        long r115 = r114.longValue();
    L33:
        r106.put("section_id", r115);
        r106.put("is_cover_keyboard", "1");
        r106.put("scene", b(this.f300411a));
        r106.put("enter_method", r111);
        r106.put("end_method", r112);
        r106.put("user_content_length", r100);
        r106.put("user_speaking_content_length", r110);
        r106.put("user_speaking_duration", System.currentTimeMillis() - this.f300412b);
        r106.put("input_position", r113);
        Unit r116 = Unit.INSTANCE;
        r105.reportEvent("audio_complement_end", r106);
        return;
    L32:
        r115 = 0;
        goto L33
    L15:
        r107 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    }
}
