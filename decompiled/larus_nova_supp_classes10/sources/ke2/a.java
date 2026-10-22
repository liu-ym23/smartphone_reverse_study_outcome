package ke2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final ArrayList<Integer> a = null;

    static {
        a = CollectionsKt.arrayListOf(new Integer[]{12, 8, 16, 5, 4});
    }

    public static String b() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L11;
        n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L11;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L11;
        MutableLiveData<Boolean> r3 = r2.getScoreOpen();
        if (r3 == null) goto L11;
        Boolean r4 = (Boolean) r3.getValue();
    L13:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L15;
        return "score";
    L15:
        return "order_song";
    L11:
        r4 = null;
        goto L13
    }

    public static boolean e() {
        o r0 = m.i();
        if (r0 == null) goto L7;
        i r1 = r0.getLiveMode();
        if (r1 == null) goto L7;
        LiveMode r2 = (LiveMode) r1.getValue();
    L9:
        if (r2 != LiveMode.SCREEN_RECORD) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public static void f() {
        String r0 = b();
        KtvComponentContext r1 = KtvComponentContext.Companion.getContext();
        boolean r2 = false;
        if (r1 == null) goto L12;
        n<KtvComponentUIContext> r3 = r1.getKtvComponentUIContext();
        if (r3 == null) goto L12;
        KtvComponentUIContext r4 = (KtvComponentUIContext) r3.getValue();
        if (r4 == null) goto L12;
        NextLiveData<Integer> r5 = r4.getOrderSongUnReadNum();
        if (r5 == null) goto L12;
        Integer r6 = (Integer) r5.getValue();
        if (r6 == null) goto L12;
    L14:
        if (Intrinsics.compare(r6.intValue(), 0) <= 0) goto L16;
        r2 = true;
    L16:
        int r7 = b.a;
        b.e(r0, r2);
        return;
    L12:
        r6 = 0;
        goto L14
    }

    public static void a(boolean r6) {
        ArrayList r0 = new ArrayList();
        KtvComponentOrderedSongDataContext r1 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r1 == null) goto L10;
        List<SongUniqueInfo> r2 = r1.m201getKtvSongUniqueInfoList();
        if (r2 == null) goto L10;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        SongUniqueInfo r4 = (SongUniqueInfo) r3.next();
        r0.add(new Pair(Long.valueOf(r4.getSongId()), r4.getUserId()));
    L10:
        KtvComponentContext.a r5 = KtvComponentContext.Companion;
        KtvComponentContext r7 = r5.getContext();
        if (r7 == null) goto L19;
        n<KtvComponentUIContext> r8 = r7.getKtvComponentUIContext();
        if (r8 == null) goto L19;
        KtvComponentUIContext r9 = (KtvComponentUIContext) r8.getValue();
        if (r9 == null) goto L19;
        List<Pair<Long, String>> r10 = r9.getOrderSongReadList();
        if (r10 == null) goto L19;
        r10.clear();
        r10.addAll(r0);
    L19:
        KtvComponentContext r11 = r5.getContext();
        if (r11 == null) goto L28;
        n<KtvComponentUIContext> r12 = r11.getKtvComponentUIContext();
        if (r12 == null) goto L28;
        KtvComponentUIContext r13 = (KtvComponentUIContext) r12.getValue();
        if (r13 == null) goto L28;
        NextLiveData<Integer> r14 = r13.getOrderSongUnReadNum();
        if (r14 == null) goto L28;
        r14.setValue(0);
    L28:
        if (r6 == false) goto L46;
        KtvComponentContext r15 = r5.getContext();
        if (r15 == null) goto L38;
        n<KtvComponentUIContext> r16 = r15.getKtvComponentUIContext();
        if (r16 == null) goto L38;
        KtvComponentUIContext r17 = (KtvComponentUIContext) r16.getValue();
        if (r17 == null) goto L38;
        NextLiveData<Integer> r18 = r17.getOrderSongUnReadNum();
        if (r18 == null) goto L38;
        Integer r19 = (Integer) r18.getValue();
    L39:
        if (r19 != null) goto L42;
        return;
    L42:
        if (r19.intValue() != 0) goto L47;
        f();
        return;
    L47:
        return;
    L38:
        r19 = null;
        goto L39
    }

    public static String c(Throwable r1) {
        if ((r1 instanceof CustomApiServerException) == false) goto L6;
        return ((CustomApiServerException) r1).getXTtLogId();
    L6:
        if ((r1 instanceof ResponseNoDataException) == false) goto L11;
        BaseResponse r2 = ((ResponseNoDataException) r1).getResponse();
        if (r2 == null) goto L11;
        String r3 = r2.logId;
        if (r3 == null) goto L11;
        return r3;
    L11:
        return "";
    }

    public static boolean d(DataCenter r3) {
        if (r3 == null) goto L7;
        Integer r4 = (Integer) r3.get("data_link_state", 0);
        if (r4 == null) goto L7;
        int r5 = r4.intValue();
    L9:
        if (v.a(r5, 32) == false) goto L11;
        return true;
    L11:
        if (v.a(r5, 2) == false) goto L13;
        return true;
    L13:
        if (v.a(r5, 8) == true) goto L19;
        return false;
    L19:
        return true;
    L7:
        r5 = 0;
        goto L9
    }

    @JvmStatic
    public static final String g(String r1) {
        if (r1 != null) goto L5;
    L34:
        return "";
    L5:
        switch(r1.hashCode()) {
            case -1722036118: goto L31;
            case -1384010634: goto L28;
            case -1006593783: goto L25;
            case -971457025: goto L23;
            case -388452221: goto L19;
            case 3005871: goto L16;
            case 156415682: goto L14;
            case 179012560: goto L10;
            case 377558170: goto L8;
            default: goto L34;
        };
    L10:
        String r0 = "link_setting_panel";
        if (r1.equals("link_setting_panel") == false) goto L34;
    L39:
        return r0;
    L16:
        r0 = "auto";
        if (r1.equals("auto") == false) goto L34;
    L19:
        r0 = "ktv_tab";
        if (r1.equals("ktv_tab") == false) goto L34;
    L25:
        r0 = "ktv_big_event";
        if (r1.equals("ktv_big_event") == false) goto L34;
    L28:
        r0 = "link_interact_panel_tab";
        if (r1.equals("link_interact_panel_tab") == false) goto L34;
    L31:
        r0 = "pk_chorus";
        if (r1.equals("pk_chorus") == false) goto L34;
    L8:
        if (r1.equals("more_panel") == false) goto L34;
        return "more";
    L14:
        if (r1.equals("order_by_user") == false) goto L34;
        return "audience_empty";
    L23:
        if (r1.equals("interaction_button") == false) goto L34;
        return "interact";
    }
}
