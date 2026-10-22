package i9c;

import android.content.Context;
import android.view.LayoutInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g extends c {
    @Override // i9c.c
    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ug_banner_template_item_3, this, true);
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
