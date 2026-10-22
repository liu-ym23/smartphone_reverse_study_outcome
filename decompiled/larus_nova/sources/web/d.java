package web;

import com.ss.android.lark.feed.shared.page.experiment.FeedGCFragmentConfigValue;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends iua.a<FeedGCFragmentConfigValue> {

    public static final class a {
    }

    static {
    }

    @Override // iua.a
    public final FeedGCFragmentConfigValue getDefault() {
        return new FeedGCFragmentConfigValue(false, 0, false, 7, null);
    }

    @Override // iua.a
    public final iua.b getLarkExperimentInfo() {
        return new iua.b("feed_gc_fragment_config", "Feed GC fragment ab experiment");
    }

    public d() {
    }
}
