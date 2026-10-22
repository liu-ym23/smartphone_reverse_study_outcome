package pe9;

import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.z0;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pf9.n;
import pf9.o;
import pf9.r;

/* JADX INFO: loaded from: classes30.dex */
public final class f extends d {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f528731a = null;

        static {
            int[] r100 = new int[SAMICoreCallBackEventType.values().length];
            r100[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SAMICoreCallBackEventType.BotTriggered.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f528731a = r100;
        }
    }

    public f() {
    }

    @Override // pe9.d
    public final List<z0.a> c(SAMICoreCallBackEventType r110, SAMICoreBlock r111, SAMICoreServerEvent r112, e r113) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r114 = new ArrayList();
        int r115 = a.f528731a[r110.ordinal()];
        if (r115 != 1) goto L5;
        int r116 = o.f528951k;
        r114.add(o.a.a(false, false, false, false, "", "", "", "", "", ""));
    L21:
        return r114;
    L5:
        if (r115 != 2) goto L7;
        r114.add(new n(0));
        goto L21
    L7:
        if (r115 != 3) goto L21;
        Intrinsics.checkNotNullParameter(r111, "data");
        Map r117 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, TriggerMode.HELLO), TuplesKt.to(2, TriggerMode.WAIT), TuplesKt.to(4, TriggerMode.HANGUP), TuplesKt.to(5, TriggerMode.AUTH_DENY), TuplesKt.to(6, TriggerMode.AUTH_SUCCESS), TuplesKt.to(8, TriggerMode.ONBOARDING_START), TuplesKt.to(12, TriggerMode.CONTINUE_TYPE), TuplesKt.to(13, TriggerMode.ANCS_SUMMARY)});
        JSONObject r118 = d.e(r111);
        r r119 = null;
        if (r118 == null) goto L12;
        Integer r120 = Integer.valueOf(r118.optInt("trigger_type"));
    L13:
        fe9.a.f476620a.e("SamiDownLinkMapper", "receive triggerType:" + r120);
        TriggerMode r121 = (TriggerMode) r117.get(r120);
        if (r121 == null) goto L17;
        r119 = new r(r121, null);
    L17:
        if (r119 == null) goto L21;
        r114.add(r119);
        goto L21
    L12:
        r120 = null;
        goto L13
    }
}
