package gu1;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.dslservice.slice.view.container.ConstraintContainerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends yt1.a<ConstraintLayout> {

    /* JADX INFO: renamed from: gu1.a$a, reason: collision with other inner class name */
    public static final class C6067a {
    }

    static {
    }

    public a() {
    }

    @Override // yt1.f
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ConstraintContainerView(r100);
    }
}
