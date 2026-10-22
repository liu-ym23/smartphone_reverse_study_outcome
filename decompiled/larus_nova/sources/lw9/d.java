package lw9;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements jn7.d {
    public d() {
    }

    @Override // jn7.d
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i(r100, r101);
    }

    @Override // jn7.d
    public final void onAppLogEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "param");
        o.f365780a.reportEvent(r100, r101);
    }
}
