package i2;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ai.api.model.floating.FloatingView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends FloatingView {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FrameLayout f488020q;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, R.layout.layout_floating_view);
    }

    public a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 4, 0);
        View.inflate(r100, r101, this);
        this.f488020q = (FrameLayout) findViewById(R.id.floating_layout);
    }
}
