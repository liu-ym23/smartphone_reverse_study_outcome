package gu1;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.dslservice.slice.view.container.NormalContainerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends yt1.a<NormalContainerView> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // yt1.f
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new NormalContainerView(r100);
    }
}
