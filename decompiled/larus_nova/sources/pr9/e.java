package pr9;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public class e implements b {
    public e() {
    }

    @Override // pr9.b
    public d a() {
        return null;
    }

    @Override // pr9.b
    public final void b(CustomFeedPlayerEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // pr9.b
    public final void c(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "aid");
    }

    @Override // pr9.b
    public final void onLoadError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // pr9.b
    public final void onLoadSuccess() {
    }
}
