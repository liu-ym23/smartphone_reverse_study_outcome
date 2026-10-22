package fh7;

import com.bytedance.ruler.utils.f;
import com.bytedance.timonbase.report.TMDataCollector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements f {
    public b() {
    }

    @Override // com.bytedance.ruler.utils.f
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        TMDataCollector.h(r100, r101, r103, r102, 16);
    }
}
