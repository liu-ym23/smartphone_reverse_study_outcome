package web;

import com.ss.android.lark.feed.shared.page.experiment.FeedPreloadConfig;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends iua.a<FeedPreloadConfig> {

    public static final class a {
    }

    static {
    }

    @Override // iua.a
    public final FeedPreloadConfig getDefault() {
        return new FeedPreloadConfig(false, false, false, false, false, false, false, false, 255, null);
    }

    @Override // iua.a
    public final iua.b getLarkExperimentInfo() {
        return new iua.b("feed_preload_chat_config", "Feed Preload Chat Experiment");
    }

    public e() {
    }
}
