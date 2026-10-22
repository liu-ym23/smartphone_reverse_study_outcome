package po8;

import android.content.Context;
import android.widget.LinearLayout;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusBlockCreateDocButtonBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f530104a;

    private final LarusBlockCreateDocButtonBinding getBinding() {
        return (LarusBlockCreateDocButtonBinding) this.f530104a.getValue();
    }

    public c(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f530104a = LazyKt.lazy(new a(r100, this));
    }

    public final void a(final Message r100, final boolean r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        getBinding().f358427b.setText(getContext().getString(R.string.larus_aiDoc_msgLongPressMenu_createDoc));
        e1.d(getBinding().f358427b, new b(r100, r101, r102, this));
    }
}
