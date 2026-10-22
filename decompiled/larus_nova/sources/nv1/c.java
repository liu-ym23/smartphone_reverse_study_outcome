package nv1;

import android.content.Context;
import com.bytedance.android.live.core.IInnerSDKCore;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements IInnerSDKCore {
    public c() {
    }

    @Override // com.bytedance.android.live.core.IInnerSDKCore
    public final String getChannel() {
        return LiveFeedContext.hostService().appContext().getChannel();
    }

    @Override // com.bytedance.android.live.core.IInnerSDKCore
    public Context getContext() {
        return LiveFeedContext.hostService().appContext().context();
    }
}
