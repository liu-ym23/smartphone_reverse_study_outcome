package ke2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
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

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Integer> f503018a = null;

    static {
        f503018a = CollectionsKt.arrayListOf(new Integer[]{12, 8, 16, 5, 4});
    }

    public static String b() {
        KtvComponentContext r100 = KtvComponentContext.Companion.getContext();
        if (r100 == null) goto L11;
        n<KtvComponentUIContext> r101 = r100.getKtvComponentUIContext();
        if (r101 == null) goto L11;
        KtvComponentUIContext r102 = r101.getValue();
        if (r102 == null) goto L11;
        MutableLiveData<Boolean> r103 = r102.getScoreOpen();
        if (r103 == null) goto L11;
        Boolean r104 = r103.getValue();
    L13:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L15;
        return com.bytedance.android.ec.core.event.a.KEY_SCORE;
    L15:
        return "order_song";
    L11:
        r104 = null;
        goto L13
    }

    public static boolean e() {
        o r100 = m.i();
        if (r100 == null) goto L7;
        i<LiveMode> r101 = r100.getLiveMode();
        if (r101 == null) goto L7;
        LiveMode r102 = r101.getValue();
    L9:
        if (r102 != LiveMode.SCREEN_RECORD) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public static void f() {
        String r100 = b();
        KtvComponentContext r101 = KtvComponentContext.Companion.getContext();
        boolean r102 = false;
        if (r101 == null) goto L12;
        n<KtvComponentUIContext> r103 = r101.getKtvComponentUIContext();
        if (r103 == null) goto L12;
        KtvComponentUIContext r104 = r103.getValue();
        if (r104 == null) goto L12;
        NextLiveData<Integer> r105 = r104.getOrderSongUnReadNum();
        if (r105 == null) goto L12;
        Integer r106 = r105.getValue();
        if (r106 == null) goto L12;
    L14:
        if (Intrinsics.compare(r106.intValue(), 0) <= 0) goto L16;
        r102 = true;
    L16:
        int r107 = b.f503019a;
        b.e(r100, r102);
        return;
    L12:
        r106 = 0;
        goto L14
    }

    public static void a(boolean r100) {
        ArrayList r101 = new ArrayList();
        KtvComponentOrderedSongDataContext r102 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r102 == null) goto L10;
        List<SongUniqueInfo> r103 = r102.m8258getKtvSongUniqueInfoList();
        if (r103 == null) goto L10;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        SongUniqueInfo r105 = (SongUniqueInfo) r104.next();
        r101.add(new Pair(Long.valueOf(r105.getSongId()), r105.getUserId()));
    L10:
        KtvComponentContext.a r106 = KtvComponentContext.Companion;
        KtvComponentContext r107 = r106.getContext();
        if (r107 == null) goto L19;
        n<KtvComponentUIContext> r108 = r107.getKtvComponentUIContext();
        if (r108 == null) goto L19;
        KtvComponentUIContext r109 = r108.getValue();
        if (r109 == null) goto L19;
        List<Pair<Long, String>> r110 = r109.getOrderSongReadList();
        if (r110 == null) goto L19;
        r110.clear();
        r110.addAll(r101);
    L19:
        KtvComponentContext r111 = r106.getContext();
        if (r111 == null) goto L28;
        n<KtvComponentUIContext> r112 = r111.getKtvComponentUIContext();
        if (r112 == null) goto L28;
        KtvComponentUIContext r113 = r112.getValue();
        if (r113 == null) goto L28;
        NextLiveData<Integer> r114 = r113.getOrderSongUnReadNum();
        if (r114 == null) goto L28;
        r114.setValue(0);
    L28:
        if (r100 == false) goto L46;
        KtvComponentContext r115 = r106.getContext();
        if (r115 == null) goto L38;
        n<KtvComponentUIContext> r116 = r115.getKtvComponentUIContext();
        if (r116 == null) goto L38;
        KtvComponentUIContext r117 = r116.getValue();
        if (r117 == null) goto L38;
        NextLiveData<Integer> r118 = r117.getOrderSongUnReadNum();
        if (r118 == null) goto L38;
        Integer r119 = r118.getValue();
    L39:
        if (r119 != null) goto L42;
        return;
    L42:
        if (r119.intValue() != 0) goto L47;
        f();
        return;
    L47:
        return;
    L38:
        r119 = null;
        goto L39
    }

    public static String c(Throwable r100) {
        if ((r100 instanceof CustomApiServerException) == false) goto L6;
        return ((CustomApiServerException) r100).getXTtLogId();
    L6:
        if ((r100 instanceof ResponseNoDataException) == false) goto L11;
        BaseResponse r101 = ((ResponseNoDataException) r100).getResponse();
        if (r101 == null) goto L11;
        String r102 = r101.logId;
        if (r102 == null) goto L11;
        return r102;
    L11:
        return "";
    }

    public static boolean d(DataCenter r100) {
        if (r100 == null) goto L7;
        Integer r101 = (Integer) r100.get("data_link_state", 0);
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L9:
        if (v.a(r102, 32) == false) goto L11;
        return true;
    L11:
        if (v.a(r102, 2) == false) goto L13;
        return true;
    L13:
        if (v.a(r102, 8) == true) goto L19;
        return false;
    L19:
        return true;
    L7:
        r102 = 0;
        goto L9
    }

    @JvmStatic
    public static final String g(String r100) {
        if (r100 != null) goto L5;
    L34:
        return "";
    L5:
        switch(r100.hashCode()) {
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
        String r101 = "link_setting_panel";
        if (r100.equals("link_setting_panel") == false) goto L34;
    L39:
        return r101;
    L16:
        r101 = "auto";
        if (r100.equals("auto") == false) goto L34;
    L19:
        r101 = "ktv_tab";
        if (r100.equals("ktv_tab") == false) goto L34;
    L25:
        r101 = "ktv_big_event";
        if (r100.equals("ktv_big_event") == false) goto L34;
    L28:
        r101 = "link_interact_panel_tab";
        if (r100.equals("link_interact_panel_tab") == false) goto L34;
    L31:
        r101 = "pk_chorus";
        if (r100.equals("pk_chorus") == false) goto L34;
    L8:
        if (r100.equals("more_panel") == false) goto L34;
        return "more";
    L14:
        if (r100.equals("order_by_user") == false) goto L34;
        return "audience_empty";
    L23:
        if (r100.equals("interaction_button") == false) goto L34;
        return IHostPlugin.ENTER_FROM_LINKMIC_TYPE;
    }
}
