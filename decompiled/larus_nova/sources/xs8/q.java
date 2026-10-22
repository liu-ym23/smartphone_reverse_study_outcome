package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.TextListSelectorWidget;
import com.larus.bmhome.view.actionbar.edit.component.UserMessageSenderWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q extends o {
    @Override // xs8.o, up8.b
    public int getType() {
        return 13;
    }

    public q() {
    }

    @Override // xs8.o, up8.b
    public final /* bridge */ /* synthetic */ AbsInstructionWidget e(Context r100) {
        return s(r100);
    }

    @Override // xs8.o
    public final TextListSelectorWidget s(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new UserMessageSenderWidget(r100);
    }
}
