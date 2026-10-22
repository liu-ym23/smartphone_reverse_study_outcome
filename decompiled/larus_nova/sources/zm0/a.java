package zm0;

import com.bytedance.android.live.multilink.MultiLinkInitializer;
import com.bytedance.android.live.multilink.external.api.IMultiLinkService;

/* JADX INFO: loaded from: classes46.dex */
public class a implements IMultiLinkService {
    public a() {
        MultiLinkInitializer.INSTANCE.ensureInitialized();
    }
}
