package r08;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends UDBaseListDialogBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f535504a;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setMController$universe_ui_dialog_release(new b(r100));
        setMWidth$universe_ui_dialog_release(1.0f);
        setMGravity$universe_ui_dialog_release(80);
        setMMarginInDp$universe_ui_dialog_release(0);
    }
}
