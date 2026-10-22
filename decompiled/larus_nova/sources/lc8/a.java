package lc8;

import android.content.Context;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface a {

    /* JADX INFO: renamed from: lc8.a$a, reason: collision with other inner class name */
    public static final class C6675a {
        public static void a(Context r100, FileCardVMData r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "data");
        }
    }

    void a(Context r100, FileCardVMData r101);

    void b(Context r100, FileCardVMData r101);
}
