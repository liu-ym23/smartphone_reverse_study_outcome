package we2;

import am2.x;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.c;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import jd2.e;
import ke2.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final void a(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        MutableLiveData<d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L9;
        d r1 = (d) r0.getValue();
        if (r1 == null) goto L9;
        if (r1.b != true) goto L9;
        String r3 = "on";
    L10:
        r2.put("chorus_status", r3);
        return;
    L9:
        r3 = "off";
        goto L10
    }

    public static final void b(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        MultiChorusContext r0 = MultiChorusContext.Companion.getContext();
        if (r0 == null) goto L6;
        String r1 = String.valueOf(r0.getOneSongAccumulatorMultiChorusUserCount());
        if (r1 == null) goto L6;
    L7:
        r2.put("chorus_user", r1);
        return;
    L6:
        r1 = BDLocationException.ERROR_TIMEOUT;
        goto L7
    }

    public static final void c(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        MutableLiveData<d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L9;
        d r1 = (d) r0.getValue();
        if (r1 == null) goto L9;
        if (r1.a != true) goto L9;
        String r3 = "on";
    L10:
        r2.put("order_status", r3);
        return;
    L9:
        r3 = "off";
        goto L10
    }

    public static final void d(Map<String, String> r9, MusicPanel r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "logMap");
        Intrinsics.checkNotNullParameter(r11, "subTab");
        Long r0 = null;
        if (r10 == null) goto L7;
        KtvMusic r1 = r10.a;
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.getMId());
    L9:
        if (r2 != null) goto L11;
    L46:
        r9.put("song_status", "order");
        return;
    L11:
        if (r10.a.getMId() == 0) goto L46;
        MultiChorusContext.a r3 = MultiChorusContext.Companion;
        List<e> r4 = r3.k();
        if (r4 == null) goto L15;
        int r5 = r4.size();
    L17:
        if (r5 <= 1) goto L46;
        jd2.d r6 = r3.j();
        if (r6 == null) goto L21;
        Long r7 = r6.c;
    L22:
        if (r7 == null) goto L46;
        jd2.d r8 = r3.j();
        if (r8 == null) goto L26;
        Long r12 = r8.c;
    L27:
        if (r12 != null) goto L30;
    L31:
        jd2.d r13 = r3.j();
        if (r13 == null) goto L34;
        r0 = r13.c;
    L34:
        long r14 = r10.a.getMId();
        if (r0 == null) goto L46;
        if (r0.longValue() != r14) goto L46;
        if (Intrinsics.areEqual(r11, s1.B(2131918327)) == false) goto L42;
    L45:
        r9.put("song_status", "chorus");
        return;
    L42:
        if (Intrinsics.areEqual(r11, s1.B(2131918328)) == true) goto L45;
        if ((!Intrinsics.areEqual(r9.get("button_type"), "")) == false) goto L46;
    L30:
        if (r12.longValue() == 0) goto L46;
    L26:
        r12 = null;
        goto L27
    L21:
        r7 = null;
        goto L22
    L15:
        r5 = 0;
    L7:
        r2 = null;
        goto L9
    }

    public static final void e(MusicPanel r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "clickPosition");
        Intrinsics.checkNotNullParameter(r6, "clickButton");
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = b.a;
        b.n(r0);
        Long r2 = KtvLoggerHelper.a;
        r0.put("play_mode", KtvLoggerHelper.E());
        r0.put("function_type2", k.n(IInteractService.class).getFunctionTypeForLog());
        b.p(r0);
        String r3 = "";
        if (r4 == null) goto L8;
        KtvMusic r7 = r4.a;
        if (r7 == null) goto L8;
        String r8 = String.valueOf(r7.getMId());
        if (r8 == null) goto L8;
    L9:
        r0.put("song_id", r8);
        if (r4 == null) goto L17;
        KtvMusic r9 = r4.a;
        if (r9 == null) goto L17;
        String r10 = r9.getMTitle();
        if (r10 == null) goto L17;
        r3 = r10;
    L17:
        r0.put("song_name", r3);
        r0.put("click_position", r5);
        r0.put("click_button", r6);
        if (c.a(r4) == false) goto L20;
        String r11 = "1";
    L21:
        r0.put("is_in_play", r11);
        j0.l().sendLog("livesdk_anchor_ksong_chorus_button_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L20:
        r11 = BDLocationException.ERROR_TIMEOUT;
    L8:
        r8 = "";
        goto L9
    }

    public static final void f(MusicPanel r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "clickPosition");
        Intrinsics.checkNotNullParameter(r5, "clickButton");
        if (r3 != null) goto L5;
        return;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = b.a;
        b.n(r0);
        Long r2 = KtvLoggerHelper.a;
        r0.put("play_mode", KtvLoggerHelper.E());
        r0.put("function_type2", k.n(IInteractService.class).getFunctionTypeForLog());
        b.p(r0);
        r0.put("song_id", String.valueOf(r3.a.getMId()));
        String r6 = r3.a.getMTitle();
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r0.put("song_name", r6);
        r0.put("click_position", r4);
        r0.put("click_button", r5);
        if (c.a(r3) == false) goto L11;
        String r7 = "1";
    L12:
        r0.put("is_in_play", r7);
        j0.l().sendLog("livesdk_anchor_ksong_chorus_join", r0, new Object[]{IRoom.class, x.class});
        return;
    L11:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L12
    }
}
