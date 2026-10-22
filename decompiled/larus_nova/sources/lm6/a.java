package lm6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements xt6.a {
    public a() {
    }

    @Override // xt6.a
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ContextCompat.getDrawable(r100, R.drawable.img_s_s_network_error);
    }

    @Override // xt6.a
    public final Drawable b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ContextCompat.getDrawable(r100, R.drawable.img_s_s_network_error);
    }
}
