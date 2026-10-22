package qd2;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.AddSongResultModel;
import com.bytedance.android.live.ktv.common.karaokestation.model.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.AddMusicControlNode;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.n;
import fd2.x;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import w20.e;
import w20.j7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends e<j7, AddSongResultModel> {
    public a() {
    }

    public final void invoke(Object r55, CallContext r56) {
        j7 r0 = (j7) r55;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r56, "context");
        KtvMusic r1 = (KtvMusic) GsonHelper.get().fromJson(r0.f(), KtvMusic.class);     // Catch: Exception -> L5
    L6:
        KtvMusic r46 = r1;
        String r2 = r0.b();
        if (r2 != null) goto L9;
        r2 = "mark";
    L9:
        String r5 = r2;
        String r3 = r0.e();
        if (r3 != null) goto L12;
        r3 = "request";
    L12:
        Object r4 = r0.c();
        if (r4 != null) goto L15;
        r4 = 0L;
    L15:
        String r6 = r0.a();
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("request_type", r3);
        r7.put("to_user_id", r4);
        r7.put("enter_from", r6);
        MusicPanel r8 = new MusicPanel(r46, 0, r5, false, null, null, r7, 1073741302);
        AddMusicControlNode r9 = new AddMusicControlNode(r8, null, 6);
        com.bytedance.android.live.ktv.common.music.control.b.e(r9, r56.getContext(), "ksong_mark_panel", null, true, 12);
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(8) == false) goto L21;
    L48:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r10 = KtvRoomContext.a.a();
        if (r10 == null) goto L57;
        k<v> r11 = r10.getRequestDownloadMusic();
        if (r11 == null) goto L58;
        r11.post(new v(r56.getContext(), r9));
        return;
    L58:
        return;
    L57:
        return;
    L21:
        if (KtvContext.a.c(32) == true) goto L48;
        KtvComponentContext r12 = KtvComponentContext.Companion.getContext();
        if (r12 == null) goto L27;
        n<Integer> r13 = r12.getKtvComponentStatus();
        if (r13 == null) goto L27;
        Integer r14 = (Integer) r13.getValue();
    L29:
        if (r14 == null) goto L35;
        if (r14.intValue() == 1) goto L48;
    L35:
        if (((Boolean) vm2.d.s4.getValue(null, vm2.d.a[276(0x114, float:3.87E-43)])).booleanValue() == false) goto L43;
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 == null) goto L43;
        com.bytedance.android.live.liveinteract.revenue.fight.b r16 = r15.teamFightService();
        if (r16 == null) goto L43;
        if (r16.isTeamFightShowing() != true) goto L43;
        boolean r17 = true;
    L44:
        if (r17 == false) goto L46;
        x r18 = new x(1, Boolean.FALSE, r5, r8, null, null, null, null, 240);
    L47:
        jc1.k.n(IKtvService.class).sendKtvComponentV2Command(r18);
        return;
    L46:
        r18 = new x(1, null, r5, r8, null, null, null, null, 242);
    L43:
        r17 = false;
    L27:
        r14 = null;
    L5:
        r1 = new KtvMusic(0, null, null, null, 0, null, null, 0, 0.0f, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 0, null, 0, null, null, 0, null, null, null, null, null, null, -1, 7, null);
        goto L6
    }
}
