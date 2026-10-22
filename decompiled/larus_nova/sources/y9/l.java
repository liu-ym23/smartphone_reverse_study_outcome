package y9;

import android.content.Context;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l implements o {
    public l() {
    }

    @Override // y9.o
    public final void D0(Context r100, String r101, String r102, Type r103) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r103, "type");
    }

    @Override // y9.o
    public final void G(Context r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
    }

    @Override // y9.o
    public final void x1(Context r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
    }
}
