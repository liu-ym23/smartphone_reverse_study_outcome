package i8a;

import com.lynx.tasm.service.IServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public interface d extends IServiceProvider {
    void reportCrashGlobalContextTag(String r100, String r101);

    void reportImageInfo(j r100);

    void reportImageStatus(String r100, JSONObject r101);
}
