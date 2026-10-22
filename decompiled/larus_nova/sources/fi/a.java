package fi;

import android.content.Context;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.c0;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.common.lib.MobClickCombiner;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f477218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f477219b = null;

    public a() {
    }

    static {
        f477219b = new a();
        f477218a = CollectionsKt.listOf(new String[]{"slice_create_view", "slice_bind_data", "slice_layout", "slice_hit_click_debounce", "slice_normal_error", "slice_render_error", "slice_sdk_error", "slice_sdk_init_error", "slice_sdk_exception_monitor", "slice_load_template", "slice_load_template_error"});
    }

    @Override // fi.b
    public final String getSessionKey() {
        return AppLog.f408004g0.getSessionKey();
    }

    @Override // fi.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "abSDKVersion");
        AppLog.N = r100;
        AppLog.f408004g0.a(r100);
    }

    @Override // fi.b
    public final String addCommonParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        boolean r101 = AppLog.L;
        return c0.b(r100, true);
    }

    @Override // fi.b
    public final void onEventV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        if ((!f477218a.contains(r100)) == true) goto L5;
    L10:
        AppLogNewUtils.onEventV3(r100, r101);
        return;
    L5:
        if (StringsKt.startsWith$default(r100, "tobsdk_", false, 2, null) == true) goto L10;
        if (StringsKt.startsWith$default(r100, "livesdk", false, 2, null) == false) goto L9;
        r100 = "tobsdk_" + r100;
        goto L10
    L9:
        r100 = "tobsdk_livesdk_" + r100;
        goto L10
    }

    @Override // fi.b
    public final void b(Context r110, String r111, String r112, String r113, long r114, JSONObject r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "eventName");
        Intrinsics.checkNotNullParameter(r112, "labelName");
        Intrinsics.checkNotNullParameter(r113, "value");
        Intrinsics.checkNotNullParameter(r115, "ext_json");
        Long r100 = StringsKt.toLongOrNull(r113);
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        MobClickCombiner.onEvent(r110, "", r111, r112, r101, r114, r115);
        return;
    L5:
        r101 = 0;
        goto L6
    }
}
