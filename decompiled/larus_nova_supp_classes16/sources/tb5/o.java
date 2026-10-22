package tb5;

import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface o<T> {
    @Nullable
    BridgeAuthType authType();

    void handle(T r1, m r2);
}
