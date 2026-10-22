package com.larus.bmhome.view.actionbar.custom.router;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements b {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaUrl");
        return StringsKt.contains$default(r100, "sslocal://flow/realtime_chat", false, 2, null);
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean a(BaseContentWidget r210, String r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r211, "schemaUrl");
        Intrinsics.checkNotNullParameter(r212, "commonArgs");
        Uri r100 = UriProtector.parse(r211);
        String r101 = y0.f(r100, "target_scene");
        if (r101 == null) goto L5;
        int r110 = CastIntegerProtector.parseInt(r101);
    L7:
        if (r210 == null) goto L9;
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Fragment r102 = com.larus.ui.arch.component.internal.attach.a.b(r210, r210);
    L11:
        if ((r102 instanceof ChatFragment) == false) goto L13;
        ChatFragment r103 = (ChatFragment) r102;
    L14:
        if (r103 != null) goto L17;
        return false;
    L17:
        ChatParam r104 = r103.f296872m;
        y r105 = (y) s1a.d.a(r210).getAbility(y.class);
        if (r105 == null) goto L20;
        wc9.e r106 = r105.h();
    L21:
        String r107 = y0.f(r100, "conversation_id");
        if (r107 != null) goto L26;
        if (r106 == null) goto L25;
        r107 = r106.f559198a;
        goto L26
    L25:
        String r108 = null;
    L27:
        String r109 = y0.f(r100, "last_section_id");
        if (r109 != null) goto L32;
        if (r106 == null) goto L31;
        r109 = r106.B;
        goto L32
    L31:
        String r111 = null;
    L33:
        String r112 = y0.f(r100, "last_message_id");
        if (r112 == null) goto L37;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L37;
    L39:
        Long r114 = r113;
    L41:
        String r115 = y0.f(r100, "bot_say_hello_text_key");
        String r116 = y0.f(r100, "trigger_hello");
        String r117 = y0.f(r100, "open_vlm");
        String r118 = y0.f(r100, "track_params");
        String r119 = y0.f(r100, "session_extra");
        LocalSubConvHelper r120 = LocalSubConvHelper.f314106a;
        Map r121 = LocalSubConvHelper.d(r108);
        FLogger r122 = FLogger.f375446a;
        StringBuilder r123 = new StringBuilder("yyytrack scheme start ");
        r123.append(r100);
        r123.append(" , enter_method ");
        r123.append(y0.f(r100, "enter_method"));
        r123.append(", botId ");
        r123.append(r104.f296890b);
        r123.append(" , valid_track_params ");
        r123.append(!TextUtils.isEmpty(r118));
        r122.i("RealtimeCallRouterProcessor", r123.toString());
        LifecycleOwnerKt.getLifecycleScope(r103).launchWhenResumed(new RealtimeCallRouterProcessor$handleRoute$1(r104, r103, r106, r212, r121, r108, r111, r114, r110, r115, r116, r117, r118, r119, null));
        return true;
    L37:
        if (r106 == null) goto L40;
        r113 = r106.f559214q;
        goto L39
    L40:
        r114 = null;
    L32:
        r111 = r109;
    L26:
        r108 = r107;
        goto L27
    L20:
        r106 = null;
        goto L21
    L13:
        r103 = null;
        goto L14
    L9:
        r102 = null;
        goto L11
    L5:
        r110 = -1;
        goto L7
    }
}
