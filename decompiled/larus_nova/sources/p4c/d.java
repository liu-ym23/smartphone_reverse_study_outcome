package p4c;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface d {
    boolean enableDoubaoDialogWatermarkGlobalOnly();

    boolean enableDoubaoWatermark();

    boolean fragmentBinderOpt();

    String getFileWatermarkPointKey();

    String getFileWatermarkSceneType();

    List<Integer> getLscSettingAuditValue();

    KVRepo getScsUserKVRepo(boolean r100);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void monitorEventV2(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103, int r104);
}
