package x08;

import android.content.Context;
import androidx.collection.SieveCacheKt;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.compose.foundation.toast.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final g a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDToast.a r102 = UDToast.build(r100);
        r102.f285429b.e(r101);
        r102.e(new UDLoadingDrawable(r100));
        r102.f285429b.f417630d = SieveCacheKt.NodeLinkMask;
        return r102.a();
    }

    @JvmStatic
    public static final g b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        UDToast.a r102 = UDToast.build(r100);
        r102.g(r101);
        r102.e(new UDLoadingDrawable(r100));
        r102.f285429b.f417630d = SieveCacheKt.NodeLinkMask;
        return r102.a();
    }
}
