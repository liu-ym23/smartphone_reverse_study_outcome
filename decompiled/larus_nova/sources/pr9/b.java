package pr9;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;

/* JADX INFO: loaded from: classes31.dex */
public interface b {
    d a();

    void b(CustomFeedPlayerEvent r100);

    void c(boolean r100, String r101);

    void onLoadError(String r100);

    void onLoadSuccess();
}
