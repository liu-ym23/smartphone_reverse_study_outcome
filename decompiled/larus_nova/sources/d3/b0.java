package d3;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes43.dex */
public interface b0 {
    void a(String r100, JsonObject r101);

    com.bytedance.ai.bridge.core.a<JsonObject> b(JsonObject r100);

    void c(ProtocolMessage r100, Consumer<JsonObject> r101, Consumer<AIBridgeMethod.Error> r102, String r103);
}
