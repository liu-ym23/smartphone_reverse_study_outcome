package ws2;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerFunctionHandler;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ILivePlayerFunctionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f560945a = null;

    public a() {
    }

    static {
        f560945a = new a();
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerFunctionHandler
    public final AbsLivePlayerView createLivePlayerView(Context r110, boolean r111, AttributeSet r112, int r113, long r114, String r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "userId");
        Long r100 = StringsKt.toLongOrNull(r210);
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L7:
        return new LivePlayerView(r110, r112, r113, r114, r101, r211, r212, r213, r214, r215);
    L5:
        r101 = 0;
        goto L7
    }
}
