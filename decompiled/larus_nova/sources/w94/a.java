package w94;

import com.bytedance.bdp.appbase.settings.ipc.MainSettingsProviderImpl;
import com.bytedance.bdp.bdpbase.ipc.annotation.RemoteInterface;
import com.bytedance.bdp.bdpbase.ipc.r;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@RemoteInterface(implementClass = MainSettingsProviderImpl.class)
public interface a extends r {
    void clearMockSettings(String r100);

    void markExpose(String r100, String r101);

    void setMockSettings(String r100, String r101, JSONObject r102);

    void updateSettings(String r100, Map<String, String> r101, boolean r102, String r103, boolean r104);
}
