package fu4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements du4.d {
    public b() {
    }

    @Override // du4.d
    public final View b(Context r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // du4.d
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return LayoutInflater.from(r100).inflate(R.layout.bitable_header_container_loading_sketelon, null);
    }
}
