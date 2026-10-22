package od8;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.canvas.service.bean.AlbumImage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.action.SuggestedExt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.utils.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.t3;

/* JADX INFO: loaded from: classes25.dex */
public final class m0 implements com.larus.bmhome.chat.camera.command.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.chat.camera.command.e f522886b;

    public final String a() {
        BotModel r100 = this.f522886b.a();
        if (r100 == null) goto L6;
        String r101 = r100.getBotId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        com.larus.bmhome.chat.api.e0 r102 = AuthModelDelegate.f297134b.e().getValue();
        if (r102 == null) goto L11;
        LaunchInfo r103 = r102.f297186a;
        if (r103 == null) goto L11;
        return r103.W();
    L11:
        return null;
    }

    public m0(com.larus.bmhome.chat.camera.command.e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f522886b = r100;
    }

    public static String f(Uri r100) {
        if (Intrinsics.areEqual(r100.getScheme(), "file") == false) goto L5;
        return "shoot";
    L5:
        return "album";
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final void b(SuggestedAction r100) {
        this.f522886b.b(r100);
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final Intent e(Uri r510) {
        Intrinsics.checkNotNullParameter(r510, "uri");
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r101 = (FragmentActivity) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        Pair<z0, Boolean> r102 = this.f522886b.A7();
        if (r102 == null) goto L11;
        z0 r103 = r102.getFirst();
    L12:
        String r104 = f(r510);
        this.f522886b.P8();
        if (r103 != null) goto L15;
        return null;
    L15:
        wc9.e r105 = this.f522886b.O8();
        if (r105 == null) goto L18;
        String r210 = r105.f559198a;
    L19:
        final ny9.b r106 = new ny9.b(false, r101, r103, new ChatParam(r210, a(), null, null, null, 252), false, false, null, null, null, null, null, null, null, null, null, null, null, r510.toString(), null, false, false, new l0("photo_preview_sug", r104), null, null, true, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -19005455, 262143);
        t0.e(new i0(r106));
        return null;
    L18:
        r210 = null;
        goto L19
    L11:
        r103 = null;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final Intent c(String r610, Uri r611) {
        Intrinsics.checkNotNullParameter(r610, "scene");
        Intrinsics.checkNotNullParameter(r611, "uri");
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r101 = (FragmentActivity) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        String r102 = "click_camera_confirm_image_edit_button";
        if (z2.f365865a.getCreationCanvasConfig().a() == false) goto L53;
        boolean r110 = false;
        AlbumImage r111 = new AlbumImage(r611, false, 6);
        Pair[] r112 = new Pair[5];
        r112[0] = TuplesKt.to("bot_id", a());
        BotModel r113 = this.f522886b.a();
        if (r113 == null) goto L13;
        String r114 = r113.getChatType(AccountService.f365697a.getUserId());
    L14:
        r112[1] = TuplesKt.to("chat_type", r114);
        r112[2] = TuplesKt.to("previous_page", "camera_confirm");
        if (Intrinsics.areEqual(r610, "from_icon") == true) goto L18;
        r102 = "photo_preview_sug";
    L18:
        r112[3] = TuplesKt.to("enter_method", r102);
        r112[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, f(r611));
        Bundle r103 = com.larus.utils.f.c(r112);
        wc9.e r104 = this.f522886b.O8();
        if (r104 == null) goto L26;
        Integer r105 = r104.f559203f;
        if (r105 == null) goto L26;
        if (r105.intValue() != 1) goto L26;
        boolean r106 = true;
    L28:
        if (r106 == false) goto L35;
        wc9.e r107 = AuthModelDelegate.f297134b.y().getValue();
        if (r107 == null) goto L32;
        String r108 = r107.f559198a;
    L33:
        if (r108 == null) goto L49;
    L50:
        String r115 = r108;
    L51:
        final ny8.e r109 = new ny8.e(r101, null, r111, r103, r115, 54);
        t0.e(new j0(r109));
        return null;
    L49:
        r115 = "";
        goto L51
    L32:
        r108 = null;
        goto L33
    L35:
        if (r104 == null) goto L37;
        r108 = r104.f559198a;
    L38:
        if (r108 != null) goto L41;
        r108 = "";
    L41:
        if (r108.length() != 0) goto L43;
        r110 = true;
    L43:
        if (r110 == false) goto L50;
        wc9.e r116 = AuthModelDelegate.f297134b.y().getValue();
        if (r116 == null) goto L47;
        r108 = r116.f559198a;
    L48:
        if (r108 != null) goto L50;
    L47:
        r108 = null;
        goto L48
    L37:
        r108 = null;
    L26:
        r106 = false;
        goto L28
    L13:
        r114 = null;
        goto L14
    L53:
        Pair<z0, Boolean> r117 = this.f522886b.N8();
        this.f522886b.P8();
        if (r117 == null) goto L67;
        z0 r118 = r117.getFirst();
        if (r118 == null) goto L67;
        wc9.e r119 = this.f522886b.O8();
        if (r119 == null) goto L61;
        String r120 = r119.f559198a;
    L62:
        ChatParam r121 = new ChatParam(r120, a(), null, null, null, 252);
        String r510 = r611.toString();
        if (Intrinsics.areEqual(r610, "from_icon") == true) goto L66;
        r102 = "photo_preview_sug";
    L66:
        final ny9.b r122 = new ny9.b(false, r101, r118, r121, false, false, null, null, null, null, null, null, null, null, null, null, null, r510, null, false, false, new l0(r102, f(r611)), null, null, true, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -19005455, 262143);
        t0.e(new k0(r122));
        goto L67
    L61:
        r120 = null;
    L67:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final void d(boolean r310, List<?> r311) {
        Intrinsics.checkNotNullParameter(r311, "data");
        Object r100 = CollectionsKt.getOrNull(r311, 0);
        String r101 = null;
        if ((r100 instanceof SuggestedAction) == false) goto L5;
        SuggestedAction r102 = (SuggestedAction) r100;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        Object r103 = CollectionsKt.getOrNull(r311, 1);
        if ((r103 instanceof Integer) == false) goto L11;
        Integer r104 = (Integer) r103;
    L12:
        if (r104 == null) goto L14;
        int r110 = r104.intValue();
    L15:
        Object r105 = CollectionsKt.getOrNull(r311, 2);
        if ((r105 instanceof Boolean) == false) goto L18;
        Boolean r106 = (Boolean) r105;
    L19:
        if (r106 == null) goto L21;
        boolean r107 = r106.booleanValue();
    L22:
        Object r108 = CollectionsKt.getOrNull(r311, 3);
        if ((r108 instanceof String) == false) goto L25;
        String r210 = (String) r108;
    L26:
        Object r109 = CollectionsKt.getOrNull(r311, 4);
        if ((r109 instanceof String) == false) goto L29;
        String r111 = (String) r109;
    L30:
        if (r111 != null) goto L32;
        r111 = "shoot_photo";
    L32:
        String r112 = r111;
        Pair<z0, Boolean> r113 = this.f522886b.N8();
        ChatControlTrace r114 = ChatControlTrace.f309996b;
        if (r114.gc(this.f522886b.chatKey()) == null) goto L52;
        long r115 = this.f522886b.chatKey();
        if (r113 == null) goto L43;
        z0 r116 = r113.getFirst();
        if (r116 == null) goto L43;
        com.larus.bmhome.actionbar.model.r r117 = r116.f295621q;
        if (r117 == null) goto L43;
        Integer r118 = r117.f295408a;
        if (r118 == null) goto L43;
        String r119 = r118.toString();
    L44:
        if (r113 == null) goto L50;
        z0 r120 = r113.getFirst();
        if (r120 == null) goto L50;
        com.larus.bmhome.actionbar.model.r r121 = r120.f295621q;
        if (r121 == null) goto L50;
        String r211 = r121.f295414g;
    L51:
        r114.b0(r310, r102, r115, "camera_confirm", r107, r112, 1, r110, 0, "shoot", "photo_preview_sug", 1, r119, r211, r210, null, null, new JSONObject());
        return;
    L50:
        r211 = null;
    L43:
        r119 = null;
        goto L44
    L52:
        if (r107 == false) goto L54;
        String r122 = "direct";
    L55:
        String r123 = r122;
        String r124 = String.valueOf(r110 + 1);
        BotModel r125 = this.f522886b.a();
        if (r125 == null) goto L58;
        String r126 = r125.getChatType(AccountService.f365697a.getUserId());
    L59:
        if (r310 == false) goto L65;
        SuggestedExt r127 = r102.getExt();
        if (r127 == null) goto L63;
        String r128 = r127.getDisplayNameStartlingKey();
    L64:
        t3.b("camera_confirm", r123, r112, r126, r128, "single_line", r124, "1", "shoot", 1, a(), r210, null, 12288);
    L71:
        if (Intrinsics.areEqual(r102.getSuggestedActionKey(), SuggestedActionKey.AIBeautify.getValue()) == false) goto L101;
        if (r113 == null) goto L81;
        z0 r129 = r113.getFirst();
        if (r129 == null) goto L81;
        com.larus.bmhome.actionbar.model.r r130 = r129.f295621q;
        if (r130 == null) goto L81;
        Integer r131 = r130.f295408a;
        if (r131 == null) goto L81;
        String r132 = r131.toString();
    L82:
        if (r113 == null) goto L88;
        z0 r133 = r113.getFirst();
        if (r133 == null) goto L88;
        com.larus.bmhome.actionbar.model.r r134 = r133.f295621q;
        if (r134 == null) goto L88;
        String r135 = r134.f295414g;
    L89:
        if (r310 == false) goto L94;
        hy9.d r136 = ICreationReportService.f373922a.j();
        SuggestedExt r137 = r102.getExt();
        if (r137 == null) goto L93;
        r101 = r137.getDisplayNameStartlingKey();
    L93:
        hy9.d.a.b(r136, r101, null, null, "photo_preview_sug", "edit_entrance", null, "photo_preview_sug", r132, r135, "camera_confirm", null, null, null, null, null, null, null, null, 1047590);
        return;
    L94:
        hy9.d r138 = ICreationReportService.f373922a.j();
        SuggestedExt r139 = r102.getExt();
        if (r139 == null) goto L97;
        r101 = r139.getDisplayNameStartlingKey();
    L97:
        hy9.d.a.a(r138, r101, null, null, "photo_preview_sug", "edit_entrance", null, "photo_preview_sug", r132, r135, "camera_confirm", null, null, null, null, null, null, null, null, null, null, null, 4193318);
        return;
    L88:
        r135 = null;
    L81:
        r132 = null;
        goto L82
    L101:
        return;
    L63:
        r128 = null;
        goto L64
    L65:
        SuggestedExt r140 = r102.getExt();
        if (r140 == null) goto L68;
        String r141 = r140.getDisplayNameStartlingKey();
    L69:
        t3.a("chat", r123, r112, r126, r141, "single_line", r124, "1", "shoot", 1, a(), r210, null, 12288);
        goto L71
    L68:
        r141 = null;
        goto L69
    L58:
        r126 = null;
        goto L59
    L54:
        r122 = "slide";
        goto L55
    L29:
        r111 = null;
        goto L30
    L25:
        r210 = null;
        goto L26
    L21:
        r107 = false;
        goto L22
    L18:
        r106 = null;
        goto L19
    L14:
        r110 = -1;
        goto L15
    L11:
        r104 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
