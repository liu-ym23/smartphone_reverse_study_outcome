package hp4;

import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window f486429a;

    public static final class a {
    }

    static {
    }

    public t(Window r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null);
        this.f486429a = r100;
        ViewCompat.setOnApplyWindowInsetsListener(this, new s(this, r101));
    }
}
