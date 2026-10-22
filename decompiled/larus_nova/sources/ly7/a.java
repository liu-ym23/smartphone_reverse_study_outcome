package ly7;

import android.content.Context;
import com.larksuite.common_selection.g;
import com.larksuite.common_selection.selectionhandle.CursorHandle;
import com.larksuite.common_selection.selectionhandle.SelectionHandleType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements g {
    public a() {
    }

    @Override // com.larksuite.common_selection.g
    public final CursorHandle a(Context r100, SelectionHandleType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "handleType");
        return new CursorHandle(r100, r101);
    }
}
