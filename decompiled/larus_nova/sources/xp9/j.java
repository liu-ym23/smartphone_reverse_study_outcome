package xp9;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements by7.b {
    public j() {
    }

    @Override // by7.b
    public final void onEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        com.larus.platform.service.o.f365780a.reportEvent(r100, r101);
    }
}
