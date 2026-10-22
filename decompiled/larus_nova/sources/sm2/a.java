package sm2;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.rg;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542568a = 0;

    static {
    }

    public static Map a(rg r100) {
        User r101 = r100.E();
        if (r101 == null) goto L5;
        String r102 = r101.getIdStr();
    L6:
        String r103 = String.valueOf(r102);
        User r104 = r100.E();
        String r105 = "";
        if (r104 == null) goto L10;
        String r106 = r104.getNickName();
        if (r106 == null) goto L10;
    L11:
        String r107 = String.valueOf(r100.G());
        String r108 = r100.H();
        if (r108 == null) goto L16;
        r105 = r108;
    L16:
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("channel_uid", r103), TuplesKt.to(OpenFeedConstantKt.KEY_CHANNEL_NAME, r106), TuplesKt.to(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r107), TuplesKt.to("program_name", r105)});
    L10:
        r106 = "";
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void b(rg r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "selectType");
        if (r100 == null) goto L6;
        Map<String, String> r102 = a(r100);
        if (r102 == null) goto L6;
    L7:
        r102.put(PickerReporterConstants.KEY.TYPE, r101);
        u.l().sendLog("carousel_grasp_microphone_click", r102, new Object[]{Room.class});
        return;
    L6:
        r102 = new LinkedHashMap();
        goto L7
    }
}
