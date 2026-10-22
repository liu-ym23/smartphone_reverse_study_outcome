package w29;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f558053a = null;

    static {
        f558053a = new g();
    }

    public g() {
    }

    public static Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r101 = AppCompatResources.getDrawable(r100, R.drawable.larus_dbx_ic_usage);
        if (r101 == null) goto L7;
        Drawable r102 = r101.mutate();
        if (r102 == null) goto L7;
        DrawableCompat.setTint(r102, com.larus.common_ui.dbx.theme.a.b(r100, R.attr.larus_dbx_text_100));
        return r102;
    L7:
        return null;
    }
}
