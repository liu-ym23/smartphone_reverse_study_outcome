package ip5;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends UDBaseDialogBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f495305a;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        controller(new b(r100));
        marginInDp(36);
        autoDismiss(true);
        cancelOnTouchOutside(false);
    }
}
