package le8;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import ie8.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a<STATE extends ie8.a> extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f508969a;

    public void b() {
        this.f508969a = null;
    }

    public RecyclerView getAttachedRecyclerView() {
        return this.f508969a;
    }

    public final RecyclerView getRecyclerView() {
        return this.f508969a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public final void setRecyclerView(RecyclerView r100) {
        this.f508969a = r100;
    }
}
