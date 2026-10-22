package w21;

import android.content.Context;
import android.widget.FrameLayout;
import b31.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f557983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IMProgressBarLayout f557984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f557985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f557986d;

    public a(Context r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f557985c = r100;
        this.f557986d = r101;
        this.f557983a = new d();
    }
}
