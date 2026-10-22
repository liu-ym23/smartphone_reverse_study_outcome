package ew4;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class t implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f474598a = null;

    static {
        f474598a = new t();
    }

    public t() {
    }

    @Override // ew4.z
    public final boolean f() {
        return false;
    }

    @Override // ew4.z
    public final boolean H0() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // ew4.z
    public final boolean f1() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // ew4.z
    public final boolean o1() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // ew4.z
    public final g l() {
        return z.a.a();
    }

    @Override // ew4.z
    public final boolean c(DialogFragment r100, CommentImageSelectorDismissReason r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "reason");
        return false;
    }

    @Override // ew4.z
    public final DialogFragment e(c r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        return null;
    }
}
