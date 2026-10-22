package pz7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final Drawable a(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r103 = AppCompatResources.getDrawable(r100, r101);
        if (r103 == null) goto L7;
        r103.mutate();
        r103.setTint(r102);
        return r103;
    L7:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r101));
    }
}
