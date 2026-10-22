package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import cq8.z0;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wa8.b0;
import wa8.c0;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Context> f316561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f316562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AttachReceiver f316563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wp8.c f316564d;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.kmp.a$a, reason: collision with other inner class name */
    public static final class C4116a {
    }

    static {
    }

    public final JSONObject a() {
        if (p.a(s1a.d.a(this.f316563c)) == false) goto L5;
        Fragment r100 = this.f316562b;
        String r101 = null;
        if (r100 == null) goto L9;
        Bundle r102 = r100.getArguments();
    L10:
        JSONObject r103 = new JSONObject();
        r103.put("app_enter_method", VoiceInputFrom.ACTION_BAR);
        if (r102 == null) goto L14;
        String r104 = r102.getString(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE);
        if (r104 == null) goto L14;
    L15:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, r104);
        if (r102 == null) goto L19;
        String r105 = r102.getString("app_key");
        if (r105 == null) goto L19;
    L20:
        r103.put("app_key", r105);
        if (r102 == null) goto L24;
        String r106 = r102.getString("app_name");
        if (r106 == null) goto L24;
    L25:
        r103.put("app_name", r106);
        if (r102 == null) goto L34;
        String r107 = r102.getString(MusicAppletPage.KEY_MESSAGE_ID);
        if (r107 == null) goto L34;
        if ((!StringsKt.isBlank(r107)) == false) goto L32;
        r101 = r107;
    L32:
        if (r101 == null) goto L34;
        r103.put("doubao_apps_message_id", r101);
    L34:
        return r103;
    L24:
        r106 = "AI 写歌";
    L19:
        r105 = MusicAppletPage.APP_ID;
    L14:
        r104 = "self";
        goto L15
    L9:
        r102 = null;
        goto L10
    L5:
        return new JSONObject();
    }

    public final String b() {
        if (p.a(s1a.d.a(this.f316563c)) == false) goto L5;
        return "template_page";
    L5:
        return "chat";
    }

    public final void c(dq8.a r410) {
        z0 r100 = r410.f469688d;
        com.larus.bmhome.actionbar.model.a r101 = r410.f469686b;
        Map<String, b0> r102 = c0.f558840a;
        c0.a(r101.f294949d, ActionBarItemLocation.DETAIL_PANEL, null);
        String r103 = r100.f465007a;
        String r104 = r100.f465009c;
        String r105 = r100.f465010d;
        String r106 = r100.f465012f;
        String r107 = r100.f465013g;
        String r110 = r101.f294947b;
        String r111 = String.valueOf(r101.f294946a);
        Boolean r108 = r100.f465015i;
        String r109 = r100.f465014h;
        String r210 = b();
        tx9.b.e(r103, r104, r105, r106, r107, null, null, r110, r111, 0, 0, null, "select", null, null, null, a(), null, "chat", null, null, null, r210, r109, r108, null, null, null, null, null, null, null, null, null, null, null, null, -59316128, 127);
    }

    public a(j r100, Fragment r101, AttachReceiver r102, wp8.c r103) {
        Intrinsics.checkNotNullParameter(r100, "uiContext");
        Intrinsics.checkNotNullParameter(r102, "attachReceiver");
        Intrinsics.checkNotNullParameter(r103, "instructionCoreAbility");
        this.f316561a = r100;
        this.f316562b = r101;
        this.f316563c = r102;
        this.f316564d = r103;
    }
}
