package gwa;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements g.b {
    @Override // gwa.g.b
    public final void c(Map r100, Map r101, Map r102, int r103) {
    }

    @Override // gwa.g.b
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
    }

    @Override // gwa.g.b
    public final KVRepo b() {
        return LarkKVStorage.p(g.b.f483079a, "common", false);
    }

    @Override // gwa.g.b
    public final List<Integer> getLscSettingAuditValue() {
        ArrayList r100 = new ArrayList();
        r100.add(16);
        return r100;
    }

    public f() {
    }
}
