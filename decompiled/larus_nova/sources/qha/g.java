package qha;

import android.content.Context;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t1a.b f533027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f533028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f533029f;

    @Override // qha.e
    public final String k() {
        return "obric_omni";
    }

    @Override // qha.e
    public final long p() {
        return 1360883263;
    }

    @Override // qha.e
    public final int q() {
        return R.string.obric_action_bar_complex_task;
    }

    @Override // qha.e
    public final int r() {
        return R.drawable.obric_custom_action_bar_complex_task_main_icon;
    }

    @Override // qha.e
    public final int m() {
        return ActionBarExecutionType.OBRIC_ACTION.getValue();
    }

    @Override // qha.e
    public Context getContext() {
        return this.f533028e;
    }

    @Override // qha.e
    public final String l() {
        return this.f533029f;
    }

    public g(t1a.b r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("", "address");
        super(r100, r101, "");
        this.f533027d = r100;
        this.f533028e = r101;
        this.f533029f = "";
    }
}
