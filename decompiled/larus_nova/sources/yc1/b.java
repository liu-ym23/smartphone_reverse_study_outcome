package yc1;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.debug.tag.global.solid.ALogSwitchLogTag;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567129a = 0;

    static {
        LocalTestManager.a(new Class[]{ALogSwitchLogTag.class});
    }

    public static void b(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        r100.put("is_streaming", "1");
        r100.put("is_external_panel", "1");
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogger.i(r100, r101);
    }
}
