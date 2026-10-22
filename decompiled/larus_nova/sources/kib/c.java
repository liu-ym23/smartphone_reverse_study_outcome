package kib;

import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s5c.d;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f503668a = 0;

    public static final class a {
        public static void a() {
            Intrinsics.checkNotNullParameter("confirm", "click");
            Intrinsics.checkNotNullParameter("none", PickerReporterConstants.KEY.TARGET);
            Statistics.sendEvent("public_multi_select_share_click", new JSONObject().put("click", "confirm").put(PickerReporterConstants.KEY.TARGET, "none"));
        }
    }

    static {
    }

    @JvmStatic
    public static final d a(ForwardTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, "forwradTemplate");
        List<String> r101 = r100.f424790f.f424844f;
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        d.a r102 = d.f540773o2;
        String r103 = r101.toString();
        r102.getClass();
        s5c.a r104 = new s5c.a("msg_id", r103);
        return d.b.b(new s5c.a(WsConstants.MSG_COUNT, String.valueOf(r101.size())), r104);
    }
}
