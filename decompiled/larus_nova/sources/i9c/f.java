package i9c;

import android.content.Context;
import android.view.LayoutInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends c {
    @Override // i9c.c
    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ug_banner_template_item_2, this, true);
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
