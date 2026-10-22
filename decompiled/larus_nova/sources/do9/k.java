package do9;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f469526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, b> f469527b = null;

    static {
        f469526a = PThreadExecutorsUtils.newSingleThreadExecutor(new c());
        f469527b = new LinkedHashMap();
    }

    public static void b(final Function0 r100) {
        f469526a.execute(new h(r100));
    }

    public static void a(final String r100, final String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L19;
        if (r101 != null) goto L12;
    L15:
        if (r102 == true) goto L19;
        b(new e(r100, r101));
        return;
    L12:
        if (StringsKt.isBlank(r101) == true) goto L15;
        r102 = false;
    L19:
        FLogger.f375446a.i("RecordingTrace", "markSdkStartSuccess ignored invalid params conversationId=" + r100 + ", recordingId=" + r101);
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r103 = false;
        goto L9
    }
}
