package ne2;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting.KtvChallengeSettingDialog;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final boolean a() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = KtvChallengeDataContext.Companion.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isKtvChallengeOpen() != true) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean b() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = KtvChallengeDataContext.Companion.a();
        if (r0 == null) goto L9;
        me2.a r1 = r0.getChallengeConfig();
        if (r1 == null) goto L9;
        if (r1.f != KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue()) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean c() {
        return k.n(IInteractService.class).isMultiLinkScene();
    }

    @JvmStatic
    public static final boolean d() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = KtvChallengeDataContext.Companion.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.needHideMidi() != true) goto L7;
        return true;
    }

    static {
    }

    @JvmStatic
    public static final boolean f(KtvMusic r2) {
        if (b() == false) goto L9;
        if (r2 == null) goto L6;
        String r3 = r2.getMidiUrl();
    L8:
        return !TextUtils.isEmpty(r3);
    L6:
        r3 = null;
        goto L8
    L9:
        return true;
    }

    public static void e(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "source");
        KtvChallengeSettingDialog r2 = new KtvChallengeSettingDialog();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "source");
        r2.U90(r6);
        r2.n = r7;
        e r8 = c.x;
        Boolean r0 = Boolean.FALSE;
        r8.getClass();
        f.d(r8, r0);
        o r9 = m.i();
        if (r9 == null) goto L13;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L14;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L15;
        Long r1 = KtvLoggerHelper.a;
        String r3 = j.d();
        String r4 = r11.getOwnerUserIdString();
        long r5 = r11.getRoomId();
        String r12 = j.c();
        Intrinsics.checkNotNullParameter(r3, "liveType");
        Intrinsics.checkNotNullParameter(r4, "anchorId");
        Intrinsics.checkNotNullParameter(r12, "functionType");
        HashMap r13 = new HashMap();
        r13.put("anchor_id", r4);
        r13.put("room_id", String.valueOf(r5));
        r13.put("function_type", KtvLoggerHelper.H(r12));
        r13.put("live_type", KtvLoggerHelper.F());
        if (r7 == null) goto L11;
        r13.put("source", r7);
    L11:
        j0.l().sendLog("livesdk_ktv_sing_challenge_open_settings_page_show", r13, new Object[0]);
        return;
    L15:
        return;
    L14:
        return;
    }
}
